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
import net.rithms.riot.constant.QueueType;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.League.League;

/**
 * @version 2.5
 */
final class LeagueApi {

	private static final String VERSION = "/v2.5/";

	public static Map<String, List<League>> getLeagueBySummoners(Region region, String key, String summonerIds) throws RiotApiException {
		Request request = new Request();
		request.addToUrl(region.getEndpoint(), VERSION, "league/by-summoner/", summonerIds, "?api_key=", key);
		request.execute();
		Map<String, List<League>> dto = request.getDto(new TypeToken<Map<String, List<League>>>() {
		}.getType());
		return dto;
	}

	public static Map<String, List<League>> getLeagueEntryBySummoners(Region region, String key, String summonerIds) throws RiotApiException {
		Request request = new Request();
		request.addToUrl(region.getEndpoint(), VERSION, "league/by-summoner/", summonerIds, "/entry?api_key=", key);
		request.execute();
		Map<String, List<League>> dto = request.getDto(new TypeToken<Map<String, List<League>>>() {
		}.getType());
		return dto;
	}

	public static Map<String, List<League>> getLeagueByTeams(Region region, String key, String teamIds) throws RiotApiException {
		Request request = new Request();
		request.addToUrl(region.getEndpoint(), VERSION, "league/by-team/", teamIds, "?api_key=", key);
		request.execute();
		Map<String, List<League>> dto = request.getDto(new TypeToken<Map<String, List<League>>>() {
		}.getType());
		return dto;
	}

	public static Map<String, List<League>> getLeagueEntryByTeams(Region region, String key, String teamIds) throws RiotApiException {
		Request request = new Request();
		request.addToUrl(region.getEndpoint(), VERSION, "league/by-team/", teamIds, "/entry?api_key=", key);
		request.execute();
		Map<String, List<League>> dto = request.getDto(new TypeToken<Map<String, List<League>>>() {
		}.getType());
		return dto;
	}

	public static League getChallengerLeague(Region region, String key, QueueType queueType) throws RiotApiException {
		Request request = new Request();
		request.addToUrl(region.getEndpoint(), VERSION, "league/challenger/?api_key=", key, "&type=", queueType.name());
		request.execute();
		League dto = request.getDto(League.class);
		return dto;
	}

	public static League getMasterLeague(Region region, String key, QueueType queueType) throws RiotApiException {
		Request request = new Request();
		request.addToUrl(region.getEndpoint(), VERSION, "league/master/?api_key=", key, "&type=", queueType.name());
		request.execute();
		League dto = request.getDto(League.class);
		return dto;
	}
}