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

import net.rithms.riot.constant.PlatformId;
import net.rithms.riot.dto.CurrentGame.CurrentGameInfo;

final class CurrentGameApi {

	private static final String VERSION = "/v1.0/";

	private static final String endpoint = ".api.pvp.net/observer-mode/rest/consumer/getSpectatorGameInfo/";

	public static CurrentGameInfo getCurrentGameInfo(PlatformId platformId, String key, String summonerId) throws RiotApiException {
		String url = "https://" + platformId.getName() + endpoint + platformId.getId() + "/" + summonerId + "?api_key=" + key;

		CurrentGameInfo currentGameInfo = null;
		try {
			currentGameInfo = new Gson().fromJson(Request.sendGet(url), CurrentGameInfo.class);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (currentGameInfo == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return currentGameInfo;
	}
}