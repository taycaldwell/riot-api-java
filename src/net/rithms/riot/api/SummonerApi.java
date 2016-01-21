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

package net.rithms.riot.api;

import java.util.Map;

import com.google.gson.reflect.TypeToken;

import net.rithms.riot.api.request.Request;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Summoner.MasteryPages;
import net.rithms.riot.dto.Summoner.RunePages;
import net.rithms.riot.dto.Summoner.Summoner;
import net.rithms.util.Convert;

/**
 * @version 1.4
 */
final class SummonerApi {

	private static final String VERSION = "/v1.4/";

	public static Map<String, MasteryPages> getMasteryPages(Region region, String key, String summonerIds) throws RiotApiException {
		Request request = new Request();
		request.addToUrl(region.getEndpoint(), VERSION, "summoner/", summonerIds, "/masteries?api_key=", key);
		request.execute();
		Map<String, MasteryPages> dto = request.getDto(new TypeToken<Map<String, MasteryPages>>() {
		}.getType());
		return dto;
	}

	public static Map<String, RunePages> getRunePages(Region region, String key, String summonerIds) throws RiotApiException {
		Request request = new Request();
		request.addToUrl(region.getEndpoint(), VERSION, "summoner/", summonerIds, "/runes?api_key=", key);
		request.execute();
		Map<String, RunePages> dto = request.getDto(new TypeToken<Map<String, RunePages>>() {
		}.getType());
		return dto;
	}

	public static Map<String, Summoner> getSummonersByName(Region region, String key, String summonerNames) throws RiotApiException {
		summonerNames = Convert.normalizeSummonerName(summonerNames);
		Request request = new Request();
		request.addToUrl(region.getEndpoint(), VERSION, "summoner/by-name/", summonerNames, "?api_key=", key);
		request.execute();
		Map<String, Summoner> dto = request.getDto(new TypeToken<Map<String, Summoner>>() {
		}.getType());
		return dto;
	}

	public static Map<String, Summoner> getSummonersById(Region region, String key, String summonerIds) throws RiotApiException {
		Request request = new Request();
		request.addToUrl(region.getEndpoint(), VERSION, "summoner/", summonerIds, "?api_key=", key);
		request.execute();
		Map<String, Summoner> dto = request.getDto(new TypeToken<Map<String, Summoner>>() {
		}.getType());
		return dto;
	}

	public static Map<String, String> getSummonerNames(Region region, String key, String summonerIds) throws RiotApiException {
		Request request = new Request();
		request.addToUrl(region.getEndpoint(), VERSION, "summoner/", summonerIds, "/name?api_key=", key);
		request.execute();
		Map<String, String> dto = request.getDto(new TypeToken<Map<String, String>>() {
		}.getType());
		return dto;
	}
}