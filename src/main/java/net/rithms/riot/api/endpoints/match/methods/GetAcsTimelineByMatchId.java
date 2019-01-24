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
import net.rithms.riot.api.endpoints.match.MatchApiMethod;
import net.rithms.riot.api.endpoints.match.dto.Match;
import net.rithms.riot.api.endpoints.match.dto.MatchTimeline;
import net.rithms.riot.constant.Platform;

public class GetAcsTimelineByMatchId extends MatchApiMethod {

	public GetAcsTimelineByMatchId(ApiConfig config, Platform platform, String platformTourney, long matchId, String gameHash) {
		super(config);
		setPlatform(platform);
		setReturnType(MatchTimeline.class);
		String url = "https://acs.leagueoflegends.com/v1/stats/game/" + platformTourney + "/" + matchId + "/timeline?gameHash=" + gameHash;
		setUrlBase(url);
	}
}