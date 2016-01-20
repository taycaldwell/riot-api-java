package net.rithms.riot.api;

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
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import net.rithms.riot.constant.PlatformId;
import net.rithms.riot.dto.ChampionMastery.ChampionMastery;

/**
 * @version 1.0
 */
final class ChampionMasteryApi {

	private static final String endpoint = ".api.pvp.net/championmastery/location/";

	public static ChampionMastery getChampionMastery(PlatformId platformId, String key, String summonerId, long championId) throws RiotApiException {
		String url = "https://" + platformId.getName() + endpoint + platformId.getId() + "/player/" + summonerId + "/champion/" + championId + "?api_key=" + key;

		ChampionMastery championMastery = null;
		try {
			championMastery = new Gson().fromJson(Request.sendGet(url), ChampionMastery.class);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (championMastery == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		return championMastery;
	}
	
	public static List<ChampionMastery> getChampionMasteries(PlatformId platformId, String key, String summonerId) throws RiotApiException {
		String url = "https://" + platformId.getName() + endpoint + platformId.getId() + "/player/" + summonerId + "/champions?api_key=" + key;

		List<ChampionMastery> championMasteryList = null;
		try {
			championMasteryList = new Gson().fromJson(Request.sendGet(url), new TypeToken<List<ChampionMastery>>() {
			}.getType());
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (championMasteryList == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		return championMasteryList;
	}
	
	public static int getChampionMasteryScore(PlatformId platformId, String key, String summonerId) throws RiotApiException {
		String url = "https://" + platformId.getName() + endpoint + platformId.getId() + "/player/" + summonerId + "/score?api_key=" + key;

		Integer score = null;
		try {
			score = new Gson().fromJson(Request.sendGet(url), Integer.class);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (score == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		return score.intValue();
	}
	
	public static List<ChampionMastery> getTopChampionMasteries(PlatformId platformId, String key, String summonerId, int count) throws RiotApiException {
		String url = "https://" + platformId.getName() + endpoint + platformId.getId() + "/player/" + summonerId + "/topchampions?api_key=" + key;
		if (count != -1) {
			url += "&count=" + count;
		}

		List<ChampionMastery> championMasteryList = null;
		try {
			championMasteryList = new Gson().fromJson(Request.sendGet(url), new TypeToken<List<ChampionMastery>>() {
			}.getType());
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (championMasteryList == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		return championMasteryList;
	}
}