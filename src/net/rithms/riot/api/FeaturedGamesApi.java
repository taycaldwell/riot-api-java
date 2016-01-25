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
import net.rithms.riot.dto.FeaturedGames.FeaturedGames;

/**
 * @version 1.0
 */
final class FeaturedGamesApi {

	private static final String endpoint = ".api.pvp.net/observer-mode/rest/featured";

	public static FeaturedGames getFeaturedGames(ApiConfig config, Region region) throws RiotApiException {
		Request request = new Request(config);
		request.addApiKeyToUrl();
		request.setUrlBase("https://", region, endpoint);
		request.execute();
		FeaturedGames dto = request.getDto(FeaturedGames.class);
		return dto;
	}
}