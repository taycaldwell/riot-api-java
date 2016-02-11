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
import java.util.Map;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.tournament.TournamentApiMethod;
import net.rithms.riot.api.request.RequestMethod;
import net.rithms.riot.constant.PickType;
import net.rithms.riot.constant.SpectatorType;
import net.rithms.riot.constant.TournamentMap;

public class UpdateTournamentCode extends TournamentApiMethod {

	public UpdateTournamentCode(ApiConfig config, String tournamentCode, TournamentMap mapType, PickType pickType, SpectatorType spectatorType,
			long... allowedSummonerIds) {
		super(config);
		setMethod(RequestMethod.PUT);
		setUrlBase("https://global.api.pvp.net/tournament/public/v1/code/" + tournamentCode);
		addTournamentApiKeyParameter();
		Map<String, Object> body = new HashMap<String, Object>();
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
		buildJsonBody(body);
	}
}