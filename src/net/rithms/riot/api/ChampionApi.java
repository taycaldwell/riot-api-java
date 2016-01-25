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

package net.rithms.riot.api;

import net.rithms.riot.api.request.Request;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Champion.Champion;
import net.rithms.riot.dto.Champion.ChampionList;

/**
 * @version 1.2
 */
final class ChampionApi {

	private static final String VERSION = "/v1.2/";

	public static Champion getChampionById(ApiConfig config, Region region, int id) throws RiotApiException {
		Request request = new Request(config);
		request.addApiKeyToUrl();
		request.setUrlBase(region.getEndpoint(), VERSION, "champion/", id);
		request.execute();
		Champion dto = request.getDto(Champion.class);
		return dto;
	}

	public static ChampionList getChampions(ApiConfig config, Region region, boolean freeToPlay) throws RiotApiException {
		Request request = new Request(config);
		request.addApiKeyToUrl();
		request.setUrlBase(region.getEndpoint(), VERSION, "champion");
		if (freeToPlay) {
			request.addUrlParameter("freeToPlay", freeToPlay);
		}
		request.execute();
		ChampionList dto = request.getDto(ChampionList.class);
		return dto;
	}
}