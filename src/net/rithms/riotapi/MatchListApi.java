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
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import net.rithms.dto.MatchList.MatchList;

final class MatchListApi {

	private static final String VERSION = "/v2.2/";

	public static MatchList getMatchList(String endpoint, String region, String key, long summonerId, String championIds, String rankedQueues, String seasons,
			long beginTime, long endTime, int beginIndex, int endIndex) throws RiotApiException {
		String url = endpoint + region + VERSION + "matchlist/by-summoner/" + summonerId + "?";
		if (championIds != null) {
			url += "championIds=" + championIds + "&";
		}
		if (rankedQueues != null) {
			url += "rankedQueues=" + rankedQueues + "&";
		}
		if (seasons != null) {
			url += "seasons=" + seasons + "&";
		}
		if (beginTime != -1) {
			url += "beginTime=" + beginTime + "&";
		}
		if (endTime != -1) {
			url += "endTime=" + endTime + "&";
		}
		if (beginIndex != -1) {
			url += "beginIndex=" + beginIndex + "&";
		}
		if (endIndex != -1) {
			url += "endIndex=" + endIndex + "&";
		}
		url += "api_key=" + key;

		MatchList matchList = null;
		try {
			matchList = new Gson().fromJson(Request.execute(url), MatchList.class);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (matchList == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return matchList;
	}
}