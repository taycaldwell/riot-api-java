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
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Summoner.MasteryPages;
import net.rithms.riot.dto.Summoner.RunePages;
import net.rithms.riot.dto.Summoner.Summoner;
import net.rithms.util.Convert;

final class SummonerApi {

	private static final String VERSION = "/v1.4/";

	public static Map<String, MasteryPages> getMasteryPages(Region region, String key, String summonerIds) throws RiotApiException {
		String url = region.getEndpoint() + VERSION + "summoner/" + summonerIds + "/masteries?api_key=" + key;

		Map<String, MasteryPages> masteryPages = null;
		try {
			masteryPages = new Gson().fromJson(Request.sendGet(url), new TypeToken<Map<String, MasteryPages>>() {
			}.getType());
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (masteryPages == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return masteryPages;
	}

	public static Map<String, RunePages> getRunePages(Region region, String key, String summonerIds) throws RiotApiException {
		String url = region.getEndpoint() + VERSION + "summoner/" + summonerIds + "/runes?api_key=" + key;

		Map<String, RunePages> runePages = null;
		try {
			runePages = new Gson().fromJson(Request.sendGet(url), new TypeToken<Map<String, RunePages>>() {
			}.getType());
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (runePages == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return runePages;
	}

	public static Map<String, Summoner> getSummonersByName(Region region, String key, String summonerNames) throws RiotApiException {
		summonerNames = Convert.normalizeSummonerName(summonerNames);

		String url = null;
		try {
			url = region.getEndpoint() + VERSION + "summoner/by-name/" + URLEncoder.encode(summonerNames, "UTF-8") + "?api_key=" + key;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		Map<String, Summoner> summoners = null;
		try {
			summoners = new Gson().fromJson(Request.sendGet(url), new TypeToken<Map<String, Summoner>>() {
			}.getType());
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (summoners == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return summoners;
	}

	public static Map<String, Summoner> getSummonersById(Region region, String key, String summonerIds) throws RiotApiException {
		String url = region.getEndpoint() + VERSION + "summoner/" + summonerIds + "?api_key=" + key;

		Map<String, Summoner> summoners = null;
		try {
			summoners = new Gson().fromJson(Request.sendGet(url), new TypeToken<Map<String, Summoner>>() {
			}.getType());
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (summoners == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return summoners;
	}

	public static Map<String, String> getSummonerNames(Region region, String key, String summonerIds) throws RiotApiException {
		String url = region.getEndpoint() + VERSION + "summoner/" + summonerIds + "/name?api_key=" + key;

		Map<String, String> summonerNames = null;
		try {
			summonerNames = new Gson().fromJson(Request.sendGet(url), new TypeToken<Map<String, String>>() {
			}.getType());
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (summonerNames == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return summonerNames;
	}
}