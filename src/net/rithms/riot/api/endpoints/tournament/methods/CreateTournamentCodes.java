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

package net.rithms.riot.api.endpoints.tournament.methods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.UrlParameter;
import net.rithms.riot.api.endpoints.tournament.TournamentApiMethod;
import net.rithms.riot.api.request.RequestMethod;
import net.rithms.riot.constant.PickType;
import net.rithms.riot.constant.SpectatorType;
import net.rithms.riot.constant.TournamentMap;

public class CreateTournamentCodes extends TournamentApiMethod {

	public CreateTournamentCodes(ApiConfig config, int tournamentId, int count, int teamSize, TournamentMap mapType, PickType pickType,
			SpectatorType spectatorType, String metaData, long... allowedSummonerIds) {
		super(config);
		setMethod(RequestMethod.POST);
		setReturnType(new TypeToken<List<String>>() {
		}.getType());
		setUrlBase("https://global.api.pvp.net/tournament/public/v1/code");
		add(new UrlParameter("tournamentId", tournamentId));
		add(new UrlParameter("count", count));
		addTournamentApiKeyParameter();
		Map<String, Object> body = new HashMap<String, Object>();
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
		buildJsonBody(body);
	}
}