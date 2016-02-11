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

import java.util.List;
import java.util.Map;

/**
 * Represents the raw response of the RiotApi
 * 
 * @author Daniel 'Linnun' Figge
 */
public class RequestResponse {

	private final int code;
	private final String body;
	private final Map<String, List<String>> headerFields;

	/**
	 * Constructs a RequestResponse
	 * 
	 * @param code
	 *            HTTP response code
	 * @param body
	 *            Raw body of the HTTP response
	 * @param headerFields
	 *            HTTP header fields
	 */
	RequestResponse(int code, String body, Map<String, List<String>> headerFields) {
		this.code = code;
		this.body = body;
		this.headerFields = headerFields;
	}

	/**
	 * Returns the HTTP response code from the Riot Api.
	 * 
	 * @return HTTP response code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * Returns the raw HTTP body from the Riot Api.
	 *
	 * @return HTTP body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * Returns the HTTP header fields from the Riot Api.
	 * 
	 * @return HTTP header fields
	 */
	public Map<String, List<String>> getHeaderFields() {
		return headerFields;
	}
}