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

import com.google.gson.reflect.TypeToken;

import net.rithms.riot.api.request.Request;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Match.MatchDetail;

/**
 * @version 2.2
 */
final class MatchApi {

	private static final String VERSION = "/v2.2/";

	public static MatchDetail getMatch(ApiConfig config, Region region, long matchId, boolean includeTimeline) throws RiotApiException {
		Request request = new Request(config);
		request.addApiKeyToUrl();
		request.setUrlBase(region.getEndpoint(), VERSION, "match/", matchId);
		if (includeTimeline) {
			request.addUrlParameter("includeTimeline", includeTimeline);
		}
		request.execute();
		MatchDetail dto = request.getDto(MatchDetail.class);
		return dto;
	}

	public static MatchDetail getMatchForTournament(ApiConfig config, Region region, long matchId, String tournamentCode, boolean includeTimeline)
			throws RiotApiException {
		Request request = new Request(config);
		request.addApiKeyToUrl();
		request.setUrlBase(region.getEndpoint(), VERSION, "match/for-tournament/", matchId);
		request.addUrlParameter("tournamentCode", tournamentCode);
		if (includeTimeline) {
			request.addUrlParameter("includeTimeline", includeTimeline);
		}
		request.execute();
		MatchDetail dto = request.getDto(MatchDetail.class);
		return dto;
	}

	public static List<Long> getMatchesByTournament(ApiConfig config, Region region, String tournamentCode) throws RiotApiException {
		Request request = new Request(config);
		request.addApiKeyToUrl();
		request.setUrlBase(region.getEndpoint(), VERSION, "match/by-tournament/", tournamentCode, "/ids");
		request.execute();
		List<Long> dto = request.getDto(new TypeToken<List<Long>>() {
		}.getType());
		return dto;
	}
}