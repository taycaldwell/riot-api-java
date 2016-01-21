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

class RequestResponse {
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

	private int code = -1;
	private String body = null;

	void setCode(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	boolean isSuccessful() {
		return (code != -1 && code >= 200 && code < 300);
	}

	void setBody(String body) {
		this.body = body;
	}

	public String getBody() {
		return body;
	}

	@Override
	public String toString() {
		return getBody();
	}
}