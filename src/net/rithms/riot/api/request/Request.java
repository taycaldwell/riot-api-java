/*
 * Copyright 2014 Taylor Caldwell
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
import java.net.URL;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import net.rithms.riot.api.RateLimitException;
import net.rithms.riot.api.RiotApiException;

public class Request {
	public static final int CODE_SUCCESS_OK = 200;
	public static final int CODE_SUCCESS_NOCONTENT = 204;
	public static final int CODE_ERROR_BAD_REQUEST = 400;
	public static final int CODE_ERROR_UNAUTHORIZED = 401;
	public static final int CODE_ERROR_FORBIDDEN = 403;
	public static final int CODE_ERROR_NOT_FOUND = 404;
	public static final int CODE_ERROR_UNPROCESSABLE_ENTITY = 422;
	public static final int CODE_ERROR_RATE_LIMITED = 429;
	public static final int CODE_ERROR_SERVER_ERROR = 500;
	public static final int CODE_ERROR_SERVICE_UNAVAILABLE = 503;

	private RequestState state = RequestState.NotSent;
	private RequestMethod method = RequestMethod.GET;
	private StringBuilder urlBuilder = new StringBuilder();
	private String riotToken = null;
	private String body = null;

	private int responseCode = -1;
	private String responseBody = null;

	public Request() {
	}

	public Request(RequestMethod method) {
		setMethod(method);
	}

	public void setMethod(RequestMethod method) {
		this.method = method;
	}

	public void setRiotToken(String riotToken) {
		this.riotToken = riotToken;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void buildJsonBody(Map<String, Object> map) {
		body = new Gson().toJson(map);
	}

	public void addToUrl(Object... pieces) {
		for (Object piece : pieces) {
			urlBuilder.append(piece);
		}
	}

	public int getResponseCode() {
		requireSucceededRequestState();
		return responseCode;
	}

	public String getResponseBody() {
		requireSucceededRequestState();
		return responseBody;
	}

	public synchronized void execute() throws RiotApiException, RateLimitException {
		if (state != RequestState.NotSent) {
			throw new IllegalStateException("The request has already been sent");
		}
		state = RequestState.Waiting;
		HttpURLConnection connection = null;
		try {
			URL url = new URL(urlBuilder.toString());
			connection = (HttpURLConnection) url.openConnection();
			connection.setDoInput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod(method.name());

			if (riotToken != null) {
				connection.setRequestProperty("X-Riot-Token", riotToken);
			}

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
			if (responseCode != CODE_SUCCESS_NOCONTENT) {
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
				String line;
				while ((line = br.readLine()) != null) {
					responseBodyBuilder.append(line).append(System.lineSeparator());
				}
				br.close();
			}
			responseBody = responseBodyBuilder.toString();
			state = RequestState.Succeeded;
		} catch (IOException e) {
			state = RequestState.Failed;
			Logger.getLogger(Request.class.getName()).log(Level.SEVERE, null, e);
			throw new RiotApiException(RiotApiException.IOEXCEPTION);
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	public <T> T getDto(Class<T> desiredDto) throws RiotApiException, RateLimitException {
		requireSucceededRequestState();
		if (responseCode == CODE_SUCCESS_NOCONTENT) {
			// The Riot Api is fine with the request, and explicitly sends no content
			return null;
		}
		T dto = null;
		try {
			dto = new Gson().fromJson(responseBody, desiredDto);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (dto == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		return dto;
	}

	public <T> T getDto(Type desiredDto) throws RiotApiException, RateLimitException {
		requireSucceededRequestState();
		if (responseCode == CODE_SUCCESS_NOCONTENT) {
			// The Riot Api is fine with the request, and explicitly sends no content
			return null;
		}
		T dto = null;
		try {
			dto = new Gson().fromJson(responseBody, desiredDto);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (dto == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		return dto;
	}

	private void requireSucceededRequestState() {
		if (state == RequestState.NotSent) {
			throw new IllegalStateException("The request has not yet been sent");
		} else if (state == RequestState.Waiting) {
			throw new IllegalStateException("The request has not received a response yet");
		} else if (state == RequestState.Failed) {
			throw new IllegalStateException("The request has failed");
		}
	}
}