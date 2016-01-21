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

	public static ChampionMastery getChampionMastery(PlatformId platformId, String key, String summonerId, long championId) throws RiotApiException {
		Request request = new Request();
		request.addToUrl("https://", platformId.getName(), endpoint, platformId.getId(), "/player/", summonerId, "/champion/", championId, "?api_key=", key);
		request.execute();
		ChampionMastery dto = request.getDto(ChampionMastery.class);
		return dto;
	}

	public static List<ChampionMastery> getChampionMasteries(PlatformId platformId, String key, String summonerId) throws RiotApiException {
		Request request = new Request();
		request.addToUrl("https://", platformId.getName(), endpoint, platformId.getId(), "/player/", summonerId, "/champions?api_key=", key);
		request.execute();
		List<ChampionMastery> dto = request.getDto(new TypeToken<List<ChampionMastery>>() {
		}.getType());
		return dto;
	}

	public static int getChampionMasteryScore(PlatformId platformId, String key, String summonerId) throws RiotApiException {
		Request request = new Request();
		request.addToUrl("https://", platformId.getName(), endpoint, platformId.getId(), "/player/", summonerId, "/score?api_key=", key);
		request.execute();
		Integer dto = request.getDto(Integer.class);
		return dto.intValue();
	}

	public static List<ChampionMastery> getTopChampionMasteries(PlatformId platformId, String key, String summonerId, int count) throws RiotApiException {
		Request request = new Request();
		request.addToUrl("https://", platformId.getName(), endpoint, platformId.getId(), "/player/", summonerId, "/topchampions?api_key=", key);
		if (count != -1) {
			request.addToUrl("&count=", count);
		}
		request.execute();
		List<ChampionMastery> dto = request.getDto(new TypeToken<List<ChampionMastery>>() {
		}.getType());
		return dto;
	}
}