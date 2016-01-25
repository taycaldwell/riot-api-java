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

import java.util.List;

import com.google.gson.reflect.TypeToken;

import net.rithms.riot.api.request.Request;
import net.rithms.riot.constant.PlatformId;
import net.rithms.riot.dto.ChampionMastery.ChampionMastery;

/**
 * @version 1.0
 */
final class ChampionMasteryApi {

	private static final String endpoint = ".api.pvp.net/championmastery/location/";

	public static List<ChampionMastery> getChampionMasteries(ApiConfig config, PlatformId platformId, String summonerId) throws RiotApiException {
		Request request = new Request(config);
		request.addApiKeyToUrl();
		request.setUrlBase("https://", platformId.getName(), endpoint, platformId.getId(), "/player/", summonerId, "/champions");
		request.execute();
		List<ChampionMastery> dto = request.getDto(new TypeToken<List<ChampionMastery>>() {
		}.getType());
		return dto;
	}

	public static ChampionMastery getChampionMastery(ApiConfig config, PlatformId platformId, String summonerId, long championId) throws RiotApiException {
		Request request = new Request(config);
		request.addApiKeyToUrl();
		request.setUrlBase("https://", platformId.getName(), endpoint, platformId.getId(), "/player/", summonerId, "/champion/", championId);
		request.execute();
		ChampionMastery dto = request.getDto(ChampionMastery.class);
		return dto;
	}

	public static int getChampionMasteryScore(ApiConfig config, PlatformId platformId, String summonerId) throws RiotApiException {
		Request request = new Request(config);
		request.addApiKeyToUrl();
		request.setUrlBase("https://", platformId.getName(), endpoint, platformId.getId(), "/player/", summonerId, "/score");
		request.execute();
		Integer dto = request.getDto(Integer.class);
		return dto.intValue();
	}

	public static List<ChampionMastery> getTopChampionMasteries(ApiConfig config, PlatformId platformId, String summonerId, int count) throws RiotApiException {
		Request request = new Request(config);
		request.addApiKeyToUrl();
		request.setUrlBase("https://", platformId.getName(), endpoint, platformId.getId(), "/player/", summonerId, "/topchampions");
		if (count != -1) {
			request.addUrlParameter("count", count);
		}
		request.execute();
		List<ChampionMastery> dto = request.getDto(new TypeToken<List<ChampionMastery>>() {
		}.getType());
		return dto;
	}
}