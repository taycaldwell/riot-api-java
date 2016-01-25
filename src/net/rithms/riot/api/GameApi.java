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

package net.rithms.riot.api;

import net.rithms.riot.api.request.Request;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Game.RecentGames;

/**
 * @version 1.3
 */
final class GameApi {

	private static final String VERSION = "/v1.3/";

	public static RecentGames getRecentGames(ApiConfig config, Region region, String summonerId) throws RiotApiException {
		Request request = new Request(config);
		request.addApiKeyToUrl();
		request.setUrlBase(region.getEndpoint(), VERSION, "game/by-summoner/", summonerId, "/recent");
		request.execute();
		RecentGames dto = request.getDto(RecentGames.class);
		return dto;
	}
}