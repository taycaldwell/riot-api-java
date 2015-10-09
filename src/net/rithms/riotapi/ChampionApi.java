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

import net.rithms.dto.Champion.Champion;
import net.rithms.dto.Champion.ChampionList;

final class ChampionApi {

	private static final String VERSION = "/v1.2/";

	public static ChampionList getChampions(String endpoint, String region, String key) throws RiotApiException {
		String url = endpoint + region + VERSION + "champion?api_key=" + key;

		ChampionList championList = null;
		try {
			championList = new Gson().fromJson(Request.execute(url), ChampionList.class);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (championList == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return championList;
	}

	public static ChampionList getChampions(String endpoint, String region, String key, boolean freeToPlay) throws RiotApiException {
		String url = endpoint + region + VERSION + "champion?freeToPlay=" + freeToPlay + "&api_key=" + key;

		ChampionList championList = null;
		try {
			championList = new Gson().fromJson(Request.execute(url), ChampionList.class);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (championList == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return championList;
	}

	public static Champion getChampionById(String endpoint, String region, String key, int champId) throws RiotApiException {
		String url = endpoint + region + VERSION + "champion/" + champId + "?api_key=" + key;

		Champion champion = null;
		try {
			champion = new Gson().fromJson(Request.execute(url), Champion.class);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (champion == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return champion;
	}
}