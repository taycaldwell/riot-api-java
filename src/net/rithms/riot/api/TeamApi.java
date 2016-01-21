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

package net.rithms.riot.api;

import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import net.rithms.riot.api.request.Request;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Team.Team;

/**
 * @version 2.4
 */
final class TeamApi {

	private static final String VERSION = "/v2.4/";

	public static Map<String, List<Team>> getTeamsBySummonerIds(Region region, String key, String summonerIds) throws RiotApiException {
		Request request = new Request();
		request.addToUrl(region.getEndpoint(), VERSION, "team/by-summoner/", summonerIds, "?api_key=", key);
		request.execute();
		Map<String, List<Team>> dto = request.getDto(new TypeToken<Map<String, List<Team>>>() {
		}.getType());
		return dto;
	}

	public static Map<String, Team> getTeamsByTeamIds(Region region, String key, String teamIds) throws RiotApiException {
		Request request = new Request();
		request.addToUrl(region.getEndpoint(), VERSION, "team/", teamIds, "?api_key=", key);
		request.execute();
		Map<String, Team> dto = request.getDto(new TypeToken<Map<String, Team>>() {
		}.getType());
		return dto;
	}
}