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
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.ApiMethod;
import net.rithms.riot.api.HttpHeadParameter;
import net.rithms.riot.api.RateLimitException;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;

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
	public static final int CODE_ERROR_UNPROCESSABLE_ENTITY = 422;
	public static final int CODE_ERROR_RATE_LIMITED = 429;
	public static final int CODE_ERROR_SERVER_ERROR = 500;
	public static final int CODE_ERROR_SERVICE_UNAVAILABLE = 503;

	private RequestState state = RequestState.Waiting;

	private int responseCode = -1;
	private String responseBody = null;

	protected ApiConfig config;
	protected ApiMethod method;
	protected HttpURLConnection connection = null;
	private RiotApiException exception = null;

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
	public Request(ApiConfig config, ApiMethod method) throws RateLimitException, RiotApiException {
		init(config, method);
		setTimeout();
		execute();
	}

	protected Request() { // Allow child classes to make their own constructor
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

	protected synchronized void execute() throws RiotApiException, RateLimitException {
		setState(RequestState.Waiting);
		try {
			URL url = new URL(method.getUrl());
			connection = (HttpURLConnection) url.openConnection();
			setTimeout();
			connection.setDoInput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod(method.getMethod().name());
			for (HttpHeadParameter p : method.getHttpHeadParameters()) {
				connection.setRequestProperty(p.getKey(), p.getValue());
			}
			String body = method.getBody();
			if (body != null) {
				connection.setRequestProperty("Content-Type", "application/json");
				connection.setDoOutput(true);
				DataOutputStream dos = new DataOutputStream(connection.getOutputStream());
				dos.writeBytes(body);
				dos.flush();
				dos.close();
			}

			responseCode = connection.getResponseCode();
			if (responseCode == CODE_ERROR_RATE_LIMITED) {
				String retryAfterString = connection.getHeaderField("Retry-After");
				String rateLimitType = connection.getHeaderField("X-Rate-Limit-Type");
				if (retryAfterString != null) {
					int retryAfter = Integer.parseInt(retryAfterString);
					throw new RateLimitException(retryAfter, rateLimitType);
				} else {
					throw new RateLimitException(0, rateLimitType);
				}
			} else if (responseCode < 200 || responseCode >= 300) {
				throw new RiotApiException(responseCode);
			}

			StringBuilder responseBodyBuilder = new StringBuilder();
			if (responseCode != CODE_SUCCESS_NO_CONTENT) {
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
				String line;
				while ((line = br.readLine()) != null) {
					responseBodyBuilder.append(line).append(System.lineSeparator());
				}
				br.close();
			}
			responseBody = responseBodyBuilder.toString();
			setState(RequestState.Succeeded);
		} catch (RiotApiException e) {
			setException(e);
			setState(RequestState.Failed);
			throw e;
		} catch (SocketTimeoutException e) {
			RiotApiException exception = new RiotApiException(RiotApiException.TIMEOUT_EXCEPTION);
			setException(exception);
			setState(RequestState.TimeOut);
			Logger.getLogger(Request.class.getName()).log(Level.FINE, null, e);
			throw exception;
		} catch (IOException e) {
			RiotApiException exception = new RiotApiException(RiotApiException.IOEXCEPTION);
			setException(exception);
			setState(RequestState.Failed);
			Logger.getLogger(Request.class.getName()).log(Level.SEVERE, null, e);
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
	 * @throws RiotApiException
	 *             If parsing the Riot Api's response fails
	 */
	@SuppressWarnings("unchecked")
	public <T> T getDto() throws RiotApiException, RateLimitException {
		Class<?> clazz = method.getDtoClass();
		if (clazz != null) {
			return (T) getDto((Class<T>) clazz);
		}
		Type type = method.getDtoType();
		if (type != null) {
			return getDto(type);
		}
		throw new NullPointerException("That ApiMethod has not set a dtoType. If you encounter this issue, please file a bug.");
	}

	private <T> T getDto(Class<T> desiredDto) throws RiotApiException {
		requireSucceededRequestState();
		if (responseCode == CODE_SUCCESS_NO_CONTENT) {
			// The Riot Api is fine with the request, and explicitly sends no content
			return null;
		}
		T dto = null;
		try {
			dto = new Gson().fromJson(responseBody, desiredDto);
		} catch (JsonSyntaxException e) {
			RiotApiException exception = new RiotApiException(RiotApiException.PARSE_FAILURE);
			setException(exception);
			throw exception;
		}
		if (dto == null) {
			RiotApiException exception = new RiotApiException(RiotApiException.PARSE_FAILURE);
			setException(exception);
			throw exception;
		}
		return dto;
	}

	private <T> T getDto(Type desiredDto) throws RiotApiException {
		requireSucceededRequestState();
		if (responseCode == CODE_SUCCESS_NO_CONTENT) {
			// The Riot Api is fine with the request, and explicitly sends no content
			return null;
		}
		T dto = null;
		try {
			dto = new Gson().fromJson(responseBody, desiredDto);
		} catch (JsonSyntaxException e) {
			RiotApiException exception = new RiotApiException(RiotApiException.PARSE_FAILURE);
			setException(exception);
			throw exception;
		}
		if (dto == null) {
			RiotApiException exception = new RiotApiException(RiotApiException.PARSE_FAILURE);
			setException(exception);
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
		if (!isFailed()) {
			return null;
		}
		return exception;
	}

	protected void init(ApiConfig config, ApiMethod method) {
		this.config = config;
		this.method = method;
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
		return state == RequestState.TimeOut;
	}

	protected void requireSucceededRequestState() {
		if (state == RequestState.Waiting) {
			throw new IllegalStateException("The request has not received a response yet");
		} else if (state == RequestState.Cancelled) {
			throw new IllegalStateException("The request has been cancelled");
		} else if (state == RequestState.Failed) {
			throw new IllegalStateException("The request has failed");
		}
	}

	protected void setException(RiotApiException exception) {
		this.exception = exception;
	}

	protected boolean setState(RequestState state) {
		if (!isDone()) {
			this.state = state;
			return true;
		}
		return false;
	}

	protected void setTimeout() {
		setTimeout(config.getRequestTimeout());
	}

	protected void setTimeout(int timeout) {
		if (connection != null && timeout > 0) {
			connection.setConnectTimeout(timeout);
			connection.setReadTimeout(timeout);
		}
	}
}