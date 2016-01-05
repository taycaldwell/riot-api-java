package net.rithms.riot.api;

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

public class RiotApiException extends Exception {

	private static final long serialVersionUID = 2658256159686373725L;
	public static final int BAD_REQUEST = 400;
	public static final int UNAUTHORIZED = 401;
	public static final int FORBIDDEN = 403;
	public static final int DATA_NOT_FOUND = 404;
	public static final int UNPROCESSABLE_ENTITY = 422;
	public static final int RATE_LIMITED = 429;
	public static final int SERVER_ERROR = 500;
	public static final int UNAVAILABLE = 503;
	public static final int PARSE_FAILURE = 600;
	public static final int IOEXCEPTION = 601;

	protected final int errorCode;

	public RiotApiException(final int errorCode) {
		super(getMessage(errorCode));
		this.errorCode = errorCode;
	}

	public static String getMessage(final int errorCode) {
		switch (errorCode) {
		case BAD_REQUEST:
			return "Bad request";
		case FORBIDDEN:
			return "Forbidden";
		case DATA_NOT_FOUND:
			return "Requested data not found";
		case IOEXCEPTION:
			return "I/O Exception thrown";
		case PARSE_FAILURE:
			return "Failed to parse Riot's JSON response";
		case UNPROCESSABLE_ENTITY:
			return "Summoner has an entry, but hasn't played since the start of 2013";
		case RATE_LIMITED:
			return "Rate limit exceeded";
		case SERVER_ERROR:
			return "Internal server error";
		case UNAUTHORIZED:
			return "Unauthorized";
		case UNAVAILABLE:
			return "Service unavailable";
		default:
			return "An unknown API error occured: " + errorCode;
		}
	}

	public int getErrorCode() {
		return errorCode;
	}

	@Override
	public String toString() {
		return getClass().getName() + ": " + getMessage(errorCode);
	}
}