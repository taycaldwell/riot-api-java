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
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Game.RecentGames;

final class GameApi {

	private static final String VERSION = "/v1.3/";

	public static RecentGames getRecentGames(Region region, String key, String summonerId) throws RiotApiException {
		String url = region.getEndpoint() + VERSION + "game/by-summoner/" + summonerId + "/recent?api_key=" + key;

		RecentGames recentGames = null;
		try {
			recentGames = new Gson().fromJson(Request.sendGet(url), RecentGames.class);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (recentGames == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return recentGames;
	}
}