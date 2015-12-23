package net.rithms.riot.api;

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

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Match.MatchDetail;

final class MatchApi {

	private static final String VERSION = "/v2.2/";

	public static MatchDetail getMatch(Region region, String key, long matchId, boolean includeTimeline) throws RiotApiException {
		String url = region.getEndpoint() + VERSION + "match/" + matchId + "?api_key=" + key;
		if (includeTimeline) {
			url += "&includeTimeline=" + includeTimeline;
		}

		MatchDetail matchDetail = null;
		try {
			matchDetail = new Gson().fromJson(Request.sendGet(url), MatchDetail.class);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (matchDetail == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return matchDetail;
	}

	public static MatchDetail getMatchForTournament(Region region, String key, long matchId, String tournamentCode, boolean includeTimeline)
			throws RiotApiException {
		String url = region.getEndpoint() + VERSION + "match/for-tournament/" + matchId + "?tournamentCode=" + tournamentCode + "&api_key=" + key;
		if (includeTimeline) {
			url += "&includeTimeline=" + includeTimeline;
		}

		MatchDetail matchDetail = null;
		try {
			matchDetail = new Gson().fromJson(Request.sendGet(url), MatchDetail.class);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (matchDetail == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return matchDetail;
	}

	public static List<Long> getMatchesByTournament(Region region, String key, String tournamentCode) throws RiotApiException {
		String url = region.getEndpoint() + VERSION + "match/by-tournament/" + tournamentCode + "/ids?api_key=" + key;

		List<Long> matchIds = null;
		try {
			matchIds = new Gson().fromJson(Request.sendGet(url), new TypeToken<List<Long>>() {
			}.getType());
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (matchIds == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return matchIds;
	}
}