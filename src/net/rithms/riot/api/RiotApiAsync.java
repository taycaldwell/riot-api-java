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

import java.util.Objects;

import net.rithms.riot.api.endpoints.champion.dto.Champion;
import net.rithms.riot.api.endpoints.champion.methods.GetChampionById;
import net.rithms.riot.api.request.AsyncRequest;
import net.rithms.riot.constant.Region;

public class RiotApiAsync {

	private final ApiConfig config;
	private final EndpointManager endpointManager;

	RiotApiAsync(ApiConfig config, EndpointManager endpointManager) {
		this.config = config;
		this.endpointManager = endpointManager;
	}

	/**
	 * Retrieve champion by {@code id}.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param id
	 *            The ID of the desired champion
	 * @return The champion of the given ID
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Champion
	 */
	public AsyncRequest getChampionById(Region region, int id) throws RiotApiException {
		Objects.requireNonNull(region);
		ApiMethod method = new GetChampionById(getConfig(), region, id);
		return endpointManager.callMethodAsynchronously(method);
	}

	protected ApiConfig getConfig() {
		return config;
	}
}