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

package net.rithms.riot.api.endpoints.match.methods;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.UrlParameter;
import net.rithms.riot.api.endpoints.match.dto.Match;
import net.rithms.riot.api.endpoints.tournament.TournamentApiMethod;
import net.rithms.riot.constant.Platform;

public class GetMatchByMatchIdAndTournamentCode extends TournamentApiMethod {

	public GetMatchByMatchIdAndTournamentCode(ApiConfig config, Platform platform, long matchId, String tournamentCode) {
		super(config);
		setPlatform(platform);
		setReturnType(Match.class);
		setUrlBase(platform.getHost() + "/lol/match/v4/matches/" + matchId + "/by-tournament-code/" + tournamentCode);
		add(new UrlParameter("tournamentCode", tournamentCode));
		addTournamentApiKeyParameter();
		allowMockMode();
	}
}