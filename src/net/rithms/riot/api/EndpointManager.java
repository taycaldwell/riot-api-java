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

import net.rithms.riot.api.endpoints.ApiMethod;
import net.rithms.riot.api.request.Request;

public class EndpointManager {

	private final ApiConfig config;

	public EndpointManager(ApiConfig config) {
		this.config = config;
	}

	// INTERNAL

	void callMethod(ApiMethod method) throws RateLimitException, RiotApiException {
		new Request(config, method);
	}

	public <T> T callMethodAndReturnDto(ApiMethod method) throws RateLimitException, RiotApiException {
		Request request = new Request(config, method);
		return request.getDto();
	}
}