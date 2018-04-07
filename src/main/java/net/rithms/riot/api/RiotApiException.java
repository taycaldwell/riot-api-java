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

package net.rithms.riot.api;

import net.rithms.riot.api.request.RiotApiError;

/**
 * Thrown when the Riot Api returns an error code, or if the Riot Api's response can not be parsed successfully.
 */
public class RiotApiException extends Exception {

	private static final long serialVersionUID = 2658256159686373725L;

	// Official client error codes 4xx
	public static final int BAD_REQUEST = 400;
	public static final int UNAUTHORIZED = 401;
	public static final int FORBIDDEN = 403;
	public static final int DATA_NOT_FOUND = 404;
	public static final int METHOD_NOT_ALLOWED = 405;
	public static final int UNSUPPORTED_MEDIA_TYPE = 415;
	public static final int UNPROCESSABLE_ENTITY = 422;
	public static final int RATE_LIMITED = 429;

	// Official server error codes 5xx
	public static final int SERVER_ERROR = 500;
	public static final int NOT_IMPLEMENTED = 501;
	public static final int BAD_GATEWAY = 502;
	public static final int UNAVAILABLE = 503;
	public static final int GATEWAY_TIMEOUT = 504;

	// Custom error codes 6xx
	public static final int PARSE_FAILURE = 600;
	public static final int IOEXCEPTION = 601;
	public static final int NULLPOINTEREXCEPTION = 602;
	public static final int TIMEOUT_EXCEPTION = 603;
	public static final int MISSING_API_KEY = 611;
	public static final int MISSING_TOURNAMENT_API_KEY = 612;

	private final int errorCode;
	private final RiotApiError errorDto;

	/**
	 * Constructs a {@code RiotApiException} with the specified error code and error dto, as sent by the Riot Api.
	 *
	 * @param errorCode
	 *            Error code
	 * @param message
	 *            Error message
	 */
	public RiotApiException(int errorCode, RiotApiError errorDto) {
		this.errorCode = errorCode;
		this.errorDto = errorDto;
	}

	/**
	 * Constructs a {@code RiotApiException} with the specified error code and error message.
	 *
	 * @param errorCode
	 *            Error code
	 * @param message
	 *            Error message
	 */
	public RiotApiException(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
		errorDto = null;
	}

	/**
	 * Constructs a {@code RiotApiException} with the specified error code.
	 *
	 * @param errorCode
	 *            Error code
	 */
	public RiotApiException(int errorCode) {
		this(errorCode, getMessage(errorCode));
	}

	/**
	 * Gets the error code of this {@code RiotApiException}
	 * 
	 * @return Error code
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * Gets the error DTO as sent by the Riot Api
	 * <p>
	 * Be aware that the errorDto can be {@code null}, if no valid error response was received
	 * </p>
	 * 
	 * @return Error DTO
	 * @see RiotApiError
	 */
	public RiotApiError getErrorDto() {
		return errorDto;
	}

	@Override
	public String getMessage() {
		if (errorDto != null) {
			return errorDto.toString();
		}
		return super.getMessage();
	}

	/**
	 * Returns a short description for the specified error code.
	 * 
	 * @param errorCode
	 *            Error code
	 * @return Short description for the specified error code
	 */
	public static String getMessage(int errorCode) {
		switch (errorCode) {
		case BAD_GATEWAY:
			return "Bad gateway";
		case BAD_REQUEST:
			return "Bad request";
		case FORBIDDEN:
			return "Forbidden";
		case DATA_NOT_FOUND:
			return "Requested data not found";
		case GATEWAY_TIMEOUT:
			return "Gateway timeout";
		case IOEXCEPTION:
			return "I/O Exception thrown";
		case METHOD_NOT_ALLOWED:
			return "Method not allowed";
		case MISSING_API_KEY:
			return "Api Key is required but missing";
		case MISSING_TOURNAMENT_API_KEY:
			return "Tournament Api Key is required but missing";
		case NULLPOINTEREXCEPTION:
			return "NullPointerException thrown";
		case PARSE_FAILURE:
			return "Failed to parse the JSON response";
		case RATE_LIMITED:
			return "Rate limit exceeded";
		case SERVER_ERROR:
			return "Internal server error";
		case TIMEOUT_EXCEPTION:
			return "Request timed out";
		case UNAUTHORIZED:
			return "Unauthorized";
		case UNAVAILABLE:
			return "Service unavailable";
		case UNPROCESSABLE_ENTITY:
			return "Summoner has an entry, but hasn't played since the start of 2013";
		case UNSUPPORTED_MEDIA_TYPE:
			return "Unsupported media type";
		default:
			return "Unknown API error (Code " + errorCode + ")";
		}
	}
}