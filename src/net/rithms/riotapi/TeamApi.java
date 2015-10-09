package net.rithms.riotapi;

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
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import net.rithms.dto.Team.Team;
import net.rithms.util.Convert;

final class TeamApi {

	private static final String VERSION = "/v2.4/";

	public static Map<String, List<Team>> getTeamsBySummonerIds(String endpoint, String region, String key, long... summonerIds) throws RiotApiException {
		String url = endpoint + region + VERSION + "team/by-summoner/" + Convert.longToString(summonerIds) + "?api_key=" + key;

		Map<String, List<Team>> teams = null;
		try {
			teams = new Gson().fromJson(Request.execute(url), new TypeToken<Map<String, List<Team>>>() {
			}.getType());
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (teams == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return teams;
	}

	public static Map<String, List<Team>> getTeamsBySummonerIds(String endpoint, String region, String key, String summonerIds) throws RiotApiException {
		String url = endpoint + region + VERSION + "team/by-summoner/" + summonerIds + "?api_key=" + key;

		Map<String, List<Team>> teams = null;
		try {
			teams = new Gson().fromJson(Request.execute(url), new TypeToken<Map<String, List<Team>>>() {
			}.getType());
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (teams == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return teams;
	}

	public static Map<String, List<Team>> getTeamsByTeamIds(String endpoint, String region, String key, long... teamIds) throws RiotApiException {
		String url = endpoint + region + VERSION + "team/" + Convert.longToString(teamIds) + "?api_key=" + key;

		Map<String, List<Team>> teams = null;
		try {
			teams = new Gson().fromJson(Request.execute(url), new TypeToken<Map<String, List<Team>>>() {
			}.getType());
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (teams == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return teams;
	}

	public static Map<String, List<Team>> getTeamsByTeamIds(String endpoint, String region, String key, String teamIds) throws RiotApiException {
		String url = endpoint + region + VERSION + "team/" + teamIds + "?api_key=" + key;

		Map<String, List<Team>> teams = null;
		try {
			teams = new Gson().fromJson(Request.execute(url), new TypeToken<Map<String, List<Team>>>() {
			}.getType());
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (teams == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return teams;
	}
}