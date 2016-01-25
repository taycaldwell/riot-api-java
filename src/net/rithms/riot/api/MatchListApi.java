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

import net.rithms.riot.api.request.Request;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.MatchList.MatchList;

/**
 * @version 2.2
 */
final class MatchListApi {

	private static final String VERSION = "/v2.2/";

	public static MatchList getMatchList(ApiConfig config, Region region, long summonerId, String championIds, String rankedQueues, String seasons,
			long beginTime, long endTime, int beginIndex, int endIndex) throws RiotApiException {
		Request request = new Request(config);
		request.addApiKeyToUrl();
		request.setUrlBase(region.getEndpoint(), VERSION, "matchlist/by-summoner/", summonerId);
		if (championIds != null) {
			request.addUrlParameter("championIds", championIds);
		}
		if (rankedQueues != null) {
			request.addUrlParameter("rankedQueues", rankedQueues);
		}
		if (seasons != null) {
			request.addUrlParameter("seasons", seasons);
		}
		if (beginTime != -1) {
			request.addUrlParameter("beginTime", beginTime);
		}
		if (endTime != -1) {
			request.addUrlParameter("endTime", endTime);
		}
		if (beginIndex != -1) {
			request.addUrlParameter("beginIndex", beginIndex);
		}
		if (endIndex != -1) {
			request.addUrlParameter("endIndex", endIndex);
		}
		request.execute();
		MatchList dto = request.getDto(MatchList.class);
		return dto;
	}
}