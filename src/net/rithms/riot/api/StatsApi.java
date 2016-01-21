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
import net.rithms.riot.constant.Season;
import net.rithms.riot.dto.Stats.PlayerStatsSummaryList;
import net.rithms.riot.dto.Stats.RankedStats;

/**
 * @version 1.3
 */
final class StatsApi {

	private static final String VERSION = "/v1.3/";

	public static PlayerStatsSummaryList getPlayerStatsSummary(Region region, Season season, String key, long summonerId) throws RiotApiException {
		Request request = new Request();
		request.addToUrl(region.getEndpoint(), VERSION, "stats/by-summoner/", summonerId, "/summary?api_key=", key);
		if (season != null) {
			request.addToUrl("&season=", season);
		}
		request.execute();
		PlayerStatsSummaryList dto = request.getDto(PlayerStatsSummaryList.class);
		return dto;
	}

	public static RankedStats getRankedStats(Region region, Season season, String key, long summonerId) throws RiotApiException {
		Request request = new Request();
		request.addToUrl(region.getEndpoint(), VERSION, "stats/by-summoner/", summonerId, "/ranked?api_key=", key);
		if (season != null) {
			request.addToUrl("&season=", season);
		}
		request.execute();
		RankedStats dto = request.getDto(RankedStats.class);
		return dto;
	}
}