package net.rithms.riot.api;

/*
 * Copyright 2015 Taylor Caldwell
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
import net.rithms.riot.dto.FeaturedGames.FeaturedGames;

final class FeaturedGamesApi {

	private static final String VERSION = "/v1.0/";

	private static final String endpoint = ".api.pvp.net/observer-mode/rest/featured";

	public static FeaturedGames getFeaturedGames(Region region, String key) throws RiotApiException {
		String url = "https://" + region + endpoint + "?api_key=" + key;

		FeaturedGames featuredGames = null;
		try {
			featuredGames = new Gson().fromJson(Request.sendGet(url), FeaturedGames.class);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (featuredGames == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return featuredGames;
	}
}