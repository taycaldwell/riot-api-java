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

package net.rithms.riot.api;

import java.util.HashMap;
import java.util.List;

import com.google.gson.reflect.TypeToken;

import net.rithms.riot.api.request.Request;
import net.rithms.riot.api.request.RequestMethod;
import net.rithms.riot.constant.PickType;
import net.rithms.riot.constant.Region;
import net.rithms.riot.constant.SpectatorType;
import net.rithms.riot.constant.TournamentMap;
import net.rithms.riot.dto.Tournament.LobbyEventList;
import net.rithms.riot.dto.Tournament.TournamentCode;

/**
 * @version 1
 */
final class TournamentApi {

	private static final String VERSION = "/v1/";
	private static final String ENDPOINT = "https://global.api.pvp.net/tournament/public" + VERSION;

	public static int createProvider(ApiConfig config, Region region, String callbackUrl) throws RiotApiException {
		Request request = new Request(config);
		request.setMethod(RequestMethod.POST);
		request.addTournamentKeyToRiotToken();
		request.setUrlBase(ENDPOINT, "provider");
		HashMap<String, Object> body = new HashMap<String, Object>();
		body.put("region", region.getName().toUpperCase());
		body.put("url", callbackUrl);
		request.buildJsonBody(body);
		request.execute();
		Integer dto = request.getDto(Integer.class);
		return dto.intValue();
	}

	public static int createTournament(ApiConfig config, String tournamentName, int providerId) throws RiotApiException {
		Request request = new Request(config);
		request.setMethod(RequestMethod.POST);
		request.addTournamentKeyToRiotToken();
		request.setUrlBase(ENDPOINT, "tournament");
		HashMap<String, Object> body = new HashMap<String, Object>();
		body.put("name", (tournamentName == null) ? "" : tournamentName);
		body.put("providerId", providerId);
		request.buildJsonBody(body);
		request.execute();
		Integer dto = request.getDto(Integer.class);
		return dto.intValue();
	}

	public static List<String> createTournamentCodes(ApiConfig config, int tournamentId, int count, int teamSize, TournamentMap mapType, PickType pickType,
			SpectatorType spectatorType, String metaData, long... allowedSummonerIds) throws RiotApiException {
		Request request = new Request(config);
		request.setMethod(RequestMethod.POST);
		request.addTournamentKeyToRiotToken();
		request.setUrlBase(ENDPOINT, "code?tournamentId=", tournamentId);
		request.addUrlParameter("count", count);
		HashMap<String, Object> body = new HashMap<String, Object>();
		body.put("teamSize", teamSize);
		body.put("mapType", mapType);
		body.put("pickType", pickType);
		body.put("spectatorType", spectatorType);
		if (metaData != null) {
			body.put("metaData", metaData);
		}
		if (allowedSummonerIds != null && allowedSummonerIds.length > 0) {
			HashMap<String, Object> allowedSummonerIdsMap = new HashMap<String, Object>();
			allowedSummonerIdsMap.put("participants", allowedSummonerIds);
			body.put("allowedSummonerIds", allowedSummonerIdsMap);
		}
		request.buildJsonBody(body);
		request.execute();
		List<String> dto = request.getDto(new TypeToken<List<String>>() {
		}.getType());
		return dto;
	}

	public static LobbyEventList getLobbyEventsByTournament(ApiConfig config, String tournamentCode) throws RiotApiException {
		Request request = new Request(config);
		request.addTournamentKeyToRiotToken();
		request.setUrlBase(ENDPOINT, "lobby/events/by-code/", tournamentCode);
		request.execute();
		LobbyEventList dto = request.getDto(LobbyEventList.class);
		return dto;
	}

	public static TournamentCode getTournamentCode(ApiConfig config, String tournamentCode) throws RiotApiException {
		Request request = new Request(config);
		request.addTournamentKeyToRiotToken();
		request.setUrlBase(ENDPOINT, "code/", tournamentCode);
		request.execute();
		TournamentCode dto = request.getDto(TournamentCode.class);
		return dto;
	}

	public static void updateTournamentCode(ApiConfig config, String tournamentCode, TournamentMap mapType, PickType pickType, SpectatorType spectatorType,
			long... allowedSummonerIds) throws RiotApiException {
		Request request = new Request(config);
		request.setMethod(RequestMethod.PUT);
		request.addTournamentKeyToRiotToken();
		request.setUrlBase(ENDPOINT, "code/", tournamentCode);
		HashMap<String, Object> body = new HashMap<String, Object>();
		if (mapType != null) {
			body.put("mapType", mapType);
		}
		if (pickType != null) {
			body.put("pickType", pickType);
		}
		if (spectatorType != null) {
			body.put("spectatorType", spectatorType);
		}
		if (allowedSummonerIds != null && allowedSummonerIds.length > 0) {
			body.put("allowedParticipants", allowedSummonerIds);
		}
		request.buildJsonBody(body);
		request.execute();
	}
}