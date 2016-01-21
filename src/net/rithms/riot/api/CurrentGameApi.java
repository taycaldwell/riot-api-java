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
import net.rithms.riot.constant.PlatformId;
import net.rithms.riot.dto.CurrentGame.CurrentGameInfo;

/**
 * @version 1.0
 */
final class CurrentGameApi {

	private static final String endpoint = ".api.pvp.net/observer-mode/rest/consumer/getSpectatorGameInfo/";

	public static CurrentGameInfo getCurrentGameInfo(PlatformId platformId, String key, String summonerId) throws RiotApiException {
		Request request = new Request();
		request.addToUrl("https://", platformId.getName(), endpoint, platformId.getId(), "/", summonerId, "?api_key=", key);
		request.execute();
		CurrentGameInfo dto = request.getDto(CurrentGameInfo.class);
		return dto;
	}
}