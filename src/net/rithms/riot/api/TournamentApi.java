package net.rithms.riot.api;

/*
 * Copyright 2015 Taylor Caldwell
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
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import net.rithms.riot.constant.PickType;
import net.rithms.riot.constant.Region;
import net.rithms.riot.constant.SpectatorType;
import net.rithms.riot.constant.TournamentMap;
import net.rithms.riot.dto.Tournament.LobbyEventList;
import net.rithms.riot.dto.Tournament.TournamentCode;

final class TournamentApi {

	private static final String VERSION = "/v1/";
	private static final String TOURNAMENT_ENDPOINT = "https://global.api.pvp.net/tournament/public" + VERSION;

	public static TournamentCode getTournamentCode(String key, String tournamentCode) throws RiotApiException {
		String url = TOURNAMENT_ENDPOINT + "code/" + tournamentCode;

		TournamentCode tournamentCodeData = null;
		try {
			tournamentCodeData = new Gson().fromJson(Request.sendGet(url, key), TournamentCode.class);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (tournamentCodeData == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return tournamentCodeData;
	}

	public static LobbyEventList getLobbyEventsByTournament(String key, String tournamentCode) throws RiotApiException {
		String url = TOURNAMENT_ENDPOINT + "lobby/events/by-code/" + tournamentCode;

		LobbyEventList lobbyEvents = null;
		try {
			lobbyEvents = new Gson().fromJson(Request.sendGet(url, key), LobbyEventList.class);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (lobbyEvents == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return lobbyEvents;
	}

	public static int createProvider(String key, Region region, String callbackUrl) throws RiotApiException {
		String url = TOURNAMENT_ENDPOINT + "provider";
		HashMap<String, Object> bodyMap = new HashMap<String, Object>();
		bodyMap.put("region", region.getName().toUpperCase());
		bodyMap.put("url", callbackUrl);

		Integer providerId = null;
		try {
			providerId = new Gson().fromJson(Request.sendPost(url, key, new Gson().toJson(bodyMap)), Integer.class);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (providerId == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return providerId.intValue();
	}

	public static int createTournament(String key, String tournamentName, int providerId) throws RiotApiException {
		String url = TOURNAMENT_ENDPOINT + "tournament";
		HashMap<String, Object> bodyMap = new HashMap<String, Object>();
		bodyMap.put("name", (tournamentName == null) ? "" : tournamentName);
		bodyMap.put("providerId", providerId);

		Integer tournamentId = null;
		try {
			tournamentId = new Gson().fromJson(Request.sendPost(url, key, new Gson().toJson(bodyMap)), Integer.class);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (tournamentId == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return tournamentId.intValue();
	}

	public static List<String> createTournamentCodes(String key, int tournamentId, int count, int teamSize, TournamentMap mapType, PickType pickType,
			SpectatorType spectatorType, String metaData, long... allowedSummonerIds) throws RiotApiException {
		String url = TOURNAMENT_ENDPOINT + "code?tournamentId=" + tournamentId + "&count=" + count;
		HashMap<String, Object> bodyMap = new HashMap<String, Object>();
		bodyMap.put("teamSize", teamSize);
		bodyMap.put("spectatorType", spectatorType);
		bodyMap.put("pickType", pickType);
		bodyMap.put("mapType", mapType);
		if (metaData != null) {
			bodyMap.put("metaData", metaData);
		}
		if (allowedSummonerIds.length > 0) {
			HashMap<String, Object> allowedSummonerIdsMap = new HashMap<String, Object>();
			allowedSummonerIdsMap.put("participants", allowedSummonerIds);
			bodyMap.put("allowedSummonerIds", allowedSummonerIdsMap);
		}

		List<String> tournamentCodes = null;
		try {
			tournamentCodes = new Gson().fromJson(Request.sendPost(url, key, new Gson().toJson(bodyMap)), new TypeToken<List<String>>() {
			}.getType());
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (tournamentCodes == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return tournamentCodes;
	}

	public static void updateTournamentCode(String key, String tournamentCode, TournamentMap mapType, PickType pickType, SpectatorType spectatorType,
			long... allowedSummonerIds) throws RiotApiException {
		String url = TOURNAMENT_ENDPOINT + "code/" + tournamentCode;
		HashMap<String, Object> bodyMap = new HashMap<String, Object>();
		bodyMap.put("allowedParticipants", allowedSummonerIds);
		if (spectatorType != null) {
			bodyMap.put("spectatorType", spectatorType);
		}
		if (pickType != null) {
			bodyMap.put("pickType", pickType);
		}
		if (mapType != null) {
			bodyMap.put("mapType", mapType);
		}

		Request.sendPut(url, key, new Gson().toJson(bodyMap));
	}
}