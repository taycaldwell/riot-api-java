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

package net.rithms.riot.api.endpoints.league.methods;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.UrlParameter;
import net.rithms.riot.api.endpoints.league.LeagueApiMethod;
import net.rithms.riot.api.endpoints.league.dto.League;
import net.rithms.riot.constant.QueueType;
import net.rithms.riot.constant.Region;

public class GetChallengerLeague extends LeagueApiMethod {

	public GetChallengerLeague(ApiConfig config, Region region, QueueType queueType) {
		super(config);
		setRegion(region);
		setReturnType(League.class);
		setUrlBase(region.getEndpoint() + "/v2.5/league/challenger");
		add(new UrlParameter("type", queueType.name()));
		addApiKeyParameter();
	}
}