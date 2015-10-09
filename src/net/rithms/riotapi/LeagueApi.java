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

import net.rithms.constant.QueueType;
import net.rithms.dto.League.League;
import net.rithms.util.Convert;

final class LeagueApi {

	private static final String VERSION = "/v2.5/";

	public static Map<String, List<League>> getLeagueBySummoners(String endpoint, String region, String key, long... summonerIds) throws RiotApiException {
		return getLeagueBySummoners(endpoint, region, key, Convert.longToString(summonerIds));
	}

	public static Map<String, List<League>> getLeagueEntryBySummoners(String endpoint, String region, String key, long... summonerIds) throws RiotApiException {
		return getLeagueEntryBySummoners(endpoint, region, key, Convert.longToString(summonerIds));
	}

	public static Map<String, List<League>> getLeagueBySummoners(String endpoint, String region, String key, String summonerIds) throws RiotApiException {
		String url = endpoint + region + VERSION + "league/by-summoner/" + summonerIds + "?api_key=" + key;

		Map<String, List<League>> leagues = null;
		try {
			leagues = new Gson().fromJson(Request.execute(url), new TypeToken<Map<String, List<League>>>() {
			}.getType());
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (leagues == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return leagues;
	}

	public static Map<String, List<League>> getLeagueEntryBySummoners(String endpoint, String region, String key, String summonerIds) throws RiotApiException {
		String url = endpoint + region + VERSION + "league/by-summoner/" + summonerIds + "/entry?api_key=" + key;

		Map<String, List<League>> leagues = null;
		try {
			leagues = new Gson().fromJson(Request.execute(url), new TypeToken<Map<String, List<League>>>() {
			}.getType());
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (leagues == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return leagues;
	}

	public static Map<String, List<League>> getLeagueByTeams(String endpoint, String region, String key, long... teamIds) throws RiotApiException {
		return getLeagueByTeams(endpoint, region, key, Convert.longToString(teamIds));
	}

	public static Map<String, List<League>> getLeagueEntryByTeams(String endpoint, String region, String key, long... teamIds) throws RiotApiException {
		return getLeagueEntryByTeams(endpoint, region, key, Convert.longToString(teamIds));
	}

	public static Map<String, List<League>> getLeagueByTeams(String endpoint, String region, String key, String teamIds) throws RiotApiException {
		String url = endpoint + region + VERSION + "league/by-team/" + teamIds + "?api_key=" + key;

		Map<String, List<League>> leagues = null;
		try {
			leagues = new Gson().fromJson(Request.execute(url), new TypeToken<Map<String, List<League>>>() {
			}.getType());
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (leagues == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return leagues;
	}

	public static Map<String, List<League>> getLeagueEntryByTeams(String endpoint, String region, String key, String teamIds) throws RiotApiException {
		String url = endpoint + region + VERSION + "league/by-team/" + teamIds + "/entry?api_key=" + key;

		Map<String, List<League>> leagues = null;
		try {
			leagues = new Gson().fromJson(Request.execute(url), new TypeToken<Map<String, List<League>>>() {
			}.getType());
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (leagues == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return leagues;
	}

	public static League getChallengerLeague(String endpoint, String region, String key) throws RiotApiException {
		String url = endpoint + region + VERSION + "league/challenger/?type=RANKED_SOLO_5x5&api_key=" + key;

		League leagues = null;
		try {
			leagues = new Gson().fromJson(Request.execute(url), League.class);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (leagues == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return leagues;
	}

	public static League getChallengerLeague(String endpoint, String region, String key, QueueType queueType) throws RiotApiException {
		String url = endpoint + region + VERSION + "league/challenger/?type=" + queueType.name() + "&api_key=" + key;

		League leagues = null;
		try {
			leagues = new Gson().fromJson(Request.execute(url), League.class);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (leagues == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return leagues;
	}

	public static League getMasterLeague(String endpoint, String region, String key) throws RiotApiException {
		String url = endpoint + region + VERSION + "league/master/?type=RANKED_SOLO_5x5&api_key=" + key;

		League leagues = null;
		try {
			leagues = new Gson().fromJson(Request.execute(url), League.class);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (leagues == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return leagues;
	}

	public static League getMasterLeague(String endpoint, String region, String key, QueueType queueType) throws RiotApiException {
		String url = endpoint + region + VERSION + "league/master/?type=" + queueType.name() + "&api_key=" + key;

		League leagues = null;
		try {
			leagues = new Gson().fromJson(Request.execute(url), League.class);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (leagues == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return leagues;
	}
}