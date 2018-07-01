/*
 * Copyright 2016 Taylor Caldwell
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.rithms.riot.api.request;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.logging.Level;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.ApiMethod;
import net.rithms.riot.api.HttpHeadParameter;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.request.ratelimit.RateLimitException;
import net.rithms.riot.api.request.ratelimit.RespectedRateLimitException;

/**
 * This class is used to fire synchronous call at the Riot Api. You should not construct these requests manually. To fire synchronous
 * requests, use a {@link RiotApi} object.
 * 
 * @author Daniel 'Linnun' Figge
 * @see RiotApi
 */
public class Request {
	public static final int CODE_SUCCESS_OK = 200;
	public static final int CODE_SUCCESS_NO_CONTENT = 204;
	public static final int CODE_ERROR_BAD_REQUEST = 400;
	public static final int CODE_ERROR_UNAUTHORIZED = 401;
	public static final int CODE_ERROR_FORBIDDEN = 403;
	public static final int CODE_ERROR_NOT_FOUND = 404;
	public static final int CODE_ERROR_METHOD_NOT_ALLOWED = 405;
	public static final int CODE_ERROR_UNSUPPORTED_MEDIA_TYPE = 415;
	public static final int CODE_ERROR_UNPROCESSABLE_ENTITY = 422;
	public static final int CODE_ERROR_RATE_LIMITED = 429;
	public static final int CODE_ERROR_SERVER_ERROR = 500;
	public static final int CODE_ERROR_BAD_GATEWAY = 502;
	public static final int CODE_ERROR_SERVICE_UNAVAILABLE = 503;
	public static final int CODE_ERROR_GATEWAY_TIMEOUT = 504;

	protected enum RequestState {
		Waiting,
		Cancelled,
		Succeeded,
		Failed,
		Timeout
	}

	private volatile RequestState state = RequestState.Waiting;
	private RequestResponse response = null;

	protected ApiConfig config;
	protected ApiMethod object;
	protected HttpURLConnection connection = null;
	private volatile RiotApiException exception = null;

	/**
	 * Constructs a synchronous request
	 * 
	 * @param config
	 *            Configuration to use
	 * @param method
	 *            Api method to call
	 * @see ApiConfig
	 * @see ApiMethod
	 */
	public Request(ApiConfig config, ApiMethod object) throws RateLimitException, RiotApiException {
		init(config, object);
		execute();
	}

	/**
	 * Constructs a synchronous request. This allows child classes to create their own constructor.
	 */
	protected Request() {
	}

	/**
	 * Attempts to cancel the request. This attempt will fail if the request has already been completed, or could not be cancelled for some
	 * other reason. If successful, and this request has not started when {@code cancel} is called, this request should never run.
	 * 
	 * @return {@code false} if the request could not be cancelled, typically because it has already completed normally; {@code true}
	 *         otherwise
	 */
	public boolean cancel() {
		if (isDone()) {
			return false;
		}
		state = RequestState.Cancelled;
		return true;
	}

	/**
	 * Executes the request
	 * 
	 * @throws RiotApiException
	 *             If the Riot Api responds with an error code or parsing the response fails
	 * @throws RateLimitException
	 *             If a rate limit is exceeded
	 */
	protected synchronized void execute() throws RiotApiException, RateLimitException {
		setState(RequestState.Waiting);
		try {
			object.checkRequirements();

			// Notify RateLimitHandler
			if (config.getRateLimitHandler() != null) {
				config.getRateLimitHandler().onRequestAboutToFire(this);
			}

			URL url = new URL(object.getUrl());
			connection = (HttpURLConnection) url.openConnection();
			setTimeout();
			connection.setDoInput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod(getHttpMethod().name());
			for (HttpHeadParameter p : object.getHttpHeadParameters()) {
				connection.setRequestProperty(p.getKey(), p.getValue());
			}
			String body = object.getBody();
			if (body != null) {
				connection.setRequestProperty("Content-Type", "application/json");
				connection.setDoOutput(true);
				DataOutputStream dos = new DataOutputStream(connection.getOutputStream());
				dos.writeBytes(body);
				dos.flush();
				dos.close();
			}
			int responseCode = connection.getResponseCode();

			// Get body
			InputStream is = null;
			if (responseCode < 400) {
				is = connection.getInputStream();
			} else {
				is = connection.getErrorStream();
			}
			StringBuilder responseBodyBuilder = new StringBuilder();
			if (responseCode != CODE_SUCCESS_NO_CONTENT && is != null) {
				BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
				String line;
				while ((line = br.readLine()) != null) {
					responseBodyBuilder.append(line).append(System.lineSeparator());
				}
				br.close();
			}

			// Handle error (except rate limit)
			if (responseCode >= 300 && responseCode != CODE_ERROR_RATE_LIMITED) {
				RiotApiError errorDto = null;
				try {
					errorDto = new Gson().fromJson(responseBodyBuilder.toString(), RiotApiError.class);
				} catch (JsonSyntaxException e) {
					RiotApi.log.warning("[" + object + "] Request > JsonSyntaxException: " + e.getMessage());
				}
				throw new RiotApiException(responseCode, errorDto);
			}
			setResponse(new RequestResponse(connection.getResponseCode(), responseBodyBuilder.toString(), connection.getHeaderFields()));

			// Notify RateLimitHandler
			if (config.getRateLimitHandler() != null) {
				config.getRateLimitHandler().onRequestDone(this);
			}

			// Handle rate limit error
			if (responseCode == CODE_ERROR_RATE_LIMITED) {
				String retryAfterString = connection.getHeaderField("Retry-After");
				String rateLimitType = connection.getHeaderField("X-Rate-Limit-Type");
				if (retryAfterString != null) {
					int retryAfter = Integer.parseInt(retryAfterString);
					throw new RateLimitException(retryAfter, rateLimitType);
				} else {
					throw new RateLimitException(0, rateLimitType);
				}
			}

			setState(RequestState.Succeeded);
		} catch (RespectedRateLimitException e) {
			setException(e);
			setState(RequestState.Failed);
			RiotApi.log.fine("[" + object + "] Request > RespectedRateLimitException: " + e.getMessage());
			throw e;
		} catch (RateLimitException e) {
			setException(e);
			setState(RequestState.Failed);
			RiotApi.log.fine("[" + object + "] Request > RateLimitException: " + e.getMessage());
			throw e;
		} catch (RiotApiException e) {
			setException(e);
			setState(RequestState.Failed);
			RiotApi.log.fine("[" + object + "] Request > RiotApiException: " + e.getMessage());
			throw e;
		} catch (SocketTimeoutException e) {
			RiotApiException exception = new RiotApiException(RiotApiException.TIMEOUT_EXCEPTION);
			setException(exception);
			setState(RequestState.Timeout);
			RiotApi.log.fine("[" + object + "] Request > Timeout");
			throw exception;
		} catch (IOException e) {
			RiotApiException exception = new RiotApiException(RiotApiException.IOEXCEPTION);
			setException(exception);
			setState(RequestState.Failed);
			RiotApi.log.log(Level.SEVERE, "[" + object + "] Request > IOException", e);
			throw exception;
		} catch (NullPointerException e) {
			RiotApiException exception = new RiotApiException(RiotApiException.NULLPOINTEREXCEPTION);
			setException(exception);
			setState(RequestState.Failed);
			RiotApi.log.log(Level.SEVERE, "[" + object + "] Request > NullPointerException", e);
			throw exception;
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	/**
	 * Retrieves the result of the request.
	 * 
	 * @return The object returned by the api call
	 * @throws IllegalStateException
	 *             If this request did not complete yet or did not succeed
	 * @throws RiotApiException
	 *             If parsing the Riot Api's response fails
	 */
	public <T> T getDto() throws RiotApiException, RateLimitException {
		return getDto(false);
	}

	/**
	 * Retrieves the result of the request.
	 * 
	 * @param overrideStateRequirement
	 *            If set to {@code true}, this method will not check the status of the request, and thus not throw an
	 *            {@code IllegalStateException}
	 * @return The object returned by the api call
	 * @throws IllegalStateException
	 *             If this request did not complete yet or did not succeed
	 * @throws NullPointerException
	 *             If this request is not properly implemented to have a dto to return
	 * @throws RiotApiException
	 *             If parsing the Riot Api's response fails
	 */
	protected <T> T getDto(boolean overrideStateRequirement) throws RiotApiException {
		if (!overrideStateRequirement) {
			requireSucceededRequestState();
		}
		if (response.getCode() == CODE_SUCCESS_NO_CONTENT) {
			// The Riot Api is fine with the request, and explicitly sends no content
			return null;
		}
		Type type = object.getReturnType();
		if (type == Void.class) {
			// The method explicitly does not want to return a result
			return null;
		}
		if (type == null) {
			NullPointerException exception = new NullPointerException("The ApiMethod '" + object
					+ "' has not set a dtoType. If you think this method is supposed to return something and you encounter this issue, please file a bug.");
			RiotApi.log.log(Level.INFO, "[" + object + "] Request > NullPointerException", exception);
			throw exception;
		}
		T dto = null;
		try {
			dto = new Gson().fromJson(response.getBody(), type);
		} catch (JsonSyntaxException e) {
			RiotApiException exception = new RiotApiException(RiotApiException.PARSE_FAILURE);
			setException(exception);
			RiotApi.log.log(Level.WARNING, "[" + object + "] Request > Parse Failure", exception);
			throw exception;
		}
		if (dto == null) {
			RiotApiException exception = new RiotApiException(RiotApiException.PARSE_FAILURE);
			setException(exception);
			RiotApi.log.log(Level.WARNING, "[" + object + "] Request > Parse Failure", exception);
			throw exception;
		}
		return dto;
	}

	/**
	 * Returns the exception that was thrown when calling {@link #execute()}.
	 * 
	 * @return The exception that was thrown when executing this request
	 */
	public RiotApiException getException() {
		return exception;
	}

	private RequestMethod getHttpMethod() {
		RequestMethod method = object.getHttpMethod();
		Objects.requireNonNull(method);
		return method;
	}

	/**
	 * Returns the object defining the request
	 * 
	 * @return An {@link ApiMethod} object
	 * @see ApiMethod
	 */
	public ApiMethod getObject() {
		return object;
	}

	/**
	 * Returns the raw response from the Riot Api
	 * 
	 * @return A {@link RequestResponse} object, providing raw data of the Riot Api's response
	 * @see RequestResponse
	 */
	public RequestResponse getResponse() {
		return response;
	}

	/**
	 * Initializes the request object. Child classes should call this method instead of the super constructor, if they don't want the
	 * request to execute automatically.
	 * 
	 * @param config
	 *            ApiConfig object
	 * @param method
	 *            ApiMethod object
	 * @see ApiConfig
	 * @see ApiMethod
	 */
	protected void init(ApiConfig config, ApiMethod object) {
		this.config = config;
		this.object = object;
	}

	/**
	 * Returns {@code true} if this request was cancelled before it completed normally.
	 * 
	 * @return {@code true} if this request was cancelled before it completed
	 */
	public boolean isCancelled() {
		return state == RequestState.Cancelled;
	}

	/**
	 * Returns {@code true} if this request completed. Completion may be due to normal termination, an exception, cancellation or timing out
	 * -- in all of these cases, this method will return {@code true}.
	 * 
	 * @return {@code true} if this request completed
	 */
	public boolean isDone() {
		return state != RequestState.Waiting;
	}

	/**
	 * Returns {@code true} if this request failed.
	 * 
	 * @return {@code true} if this request failed
	 */
	public boolean isFailed() {
		return state == RequestState.Failed;
	}

	/**
	 * Returns {@code true} if this request is still waiting for a response from the Riot Api.
	 * 
	 * @return {@code true} if this request is still waiting for a response
	 */
	public boolean isPending() {
		return state == RequestState.Waiting;
	}

	/**
	 * Returns {@code true} if this request completed successfully.
	 * 
	 * @return {@code true} if this request completed successfully
	 */
	public boolean isSuccessful() {
		return state == RequestState.Succeeded;
	}

	/**
	 * Returns {@code true} if this request timed out before it completed normally.
	 * 
	 * @return {@code true} if this request timed out before it completed
	 */
	public boolean isTimeOut() {
		return state == RequestState.Timeout;
	}

	/**
	 * Checks that the current state of this request is succeeded.
	 * 
	 * @throws IllegalStateException
	 *             If the state of this request is anything other than {@code RequestState.Succeeded}.
	 */
	protected void requireSucceededRequestState() {
		if (state == RequestState.Waiting) {
			throw new IllegalStateException("The request has not received a response yet");
		} else if (state == RequestState.Cancelled) {
			throw new IllegalStateException("The request has been cancelled");
		} else if (state == RequestState.Failed) {
			throw new IllegalStateException("The request has failed");
		}
	}

	/**
	 * Sets the Exception that was thrown when executing this request
	 * 
	 * @param exception
	 *            Exception
	 * @see RiotApiException
	 */
	protected void setException(RiotApiException exception) {
		this.exception = exception;
	}

	private void setResponse(RequestResponse response) {
		this.response = response;
	}

	/**
	 * Sets the state of this request, if the request is not already done.
	 * 
	 * @param state
	 *            State
	 * @return {@code true} if the state has been changed
	 * @see RequestState
	 */
	protected boolean setState(RequestState state) {
		if (isDone()) {
			return false;
		}
		this.state = state;
		return true;
	}

	/**
	 * Sets the timeout according to the {@link ApiConfig} object, associated with this request.
	 */
	protected void setTimeout() {
		setTimeout(config.getRequestTimeout());
	}

	/**
	 * Sets a specified timeout value, in milliseconds, until connecting to or reading from the Riot Api times out.
	 * 
	 * @param timeout
	 *            Timeout value in milliseconds
	 */
	protected void setTimeout(int timeout) {
		if (connection != null && timeout > 0) {
			connection.setConnectTimeout(timeout);
			connection.setReadTimeout(timeout);
		}
	}
}