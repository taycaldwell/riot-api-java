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

package net.rithms.riot.api.endpoints.team.methods;

import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.team.TeamApiMethod;
import net.rithms.riot.api.endpoints.team.dto.Team;
import net.rithms.riot.constant.Region;

public class GetTeamsBySummonerIds extends TeamApiMethod {

	public GetTeamsBySummonerIds(ApiConfig config, Region region, String summonerIds) {
		super(config);
		setRegion(region);
		setReturnType(new TypeToken<Map<String, List<Team>>>() {
		}.getType());
		setUrlBase(region.getEndpoint() + "/v2.4/team/by-summoner/" + summonerIds);
		addApiKeyParameter();
	}
}