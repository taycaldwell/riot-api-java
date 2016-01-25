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

import java.util.List;

import com.google.gson.reflect.TypeToken;

import net.rithms.riot.api.request.Request;
import net.rithms.riot.constant.Region;
import net.rithms.riot.constant.staticdata.ChampData;
import net.rithms.riot.constant.staticdata.ItemData;
import net.rithms.riot.constant.staticdata.ItemListData;
import net.rithms.riot.constant.staticdata.MasteryData;
import net.rithms.riot.constant.staticdata.MasteryListData;
import net.rithms.riot.constant.staticdata.RuneData;
import net.rithms.riot.constant.staticdata.RuneListData;
import net.rithms.riot.constant.staticdata.SpellData;
import net.rithms.riot.dto.Static.Champion;
import net.rithms.riot.dto.Static.ChampionList;
import net.rithms.riot.dto.Static.GameMapList;
import net.rithms.riot.dto.Static.Item;
import net.rithms.riot.dto.Static.ItemList;
import net.rithms.riot.dto.Static.LanguageStrings;
import net.rithms.riot.dto.Static.Mastery;
import net.rithms.riot.dto.Static.MasteryList;
import net.rithms.riot.dto.Static.Realm;
import net.rithms.riot.dto.Static.Rune;
import net.rithms.riot.dto.Static.RuneList;
import net.rithms.riot.dto.Static.SummonerSpell;
import net.rithms.riot.dto.Static.SummonerSpellList;

/**
 * @version 1.2
 */
final class StaticDataApi {

	private static final String VERSION = "/v1.2/";
	private static final String ENDPOINT = "https://global.api.pvp.net/api/lol/static-data/";

	public static Champion getDataChampion(ApiConfig config, Region region, int id, String locale, String version, ChampData... champData)
			throws RiotApiException {
		Request request = new Request(config);
		request.addApiKeyToUrl();
		request.setUrlBase(ENDPOINT, region, VERSION, "champion/", id);
		if (locale != null) {
			request.addUrlParameter("locale", locale);
		}
		if (version != null) {
			request.addUrlParameter("version", version);
		}
		if (champData[0] != null) {
			StringBuilder dataBuilder = new StringBuilder();
			for (ChampData data : champData) {
				dataBuilder.append(',').append(data.getName());
			}
			request.addUrlParameter("champData", dataBuilder.substring(1));
		}
		request.execute();
		Champion dto = request.getDto(Champion.class);
		return dto;
	}

	public static ChampionList getDataChampionList(ApiConfig config, Region region, String locale, String version, boolean dataById, ChampData... champData)
			throws RiotApiException {
		Request request = new Request(config);
		request.addApiKeyToUrl();
		request.setUrlBase(ENDPOINT, region, VERSION, "champion");
		if (locale != null) {
			request.addUrlParameter("locale", locale);
		}
		if (version != null) {
			request.addUrlParameter("version", version);
		}
		request.addUrlParameter("dataById", dataById);
		if (champData[0] != null) {
			StringBuilder dataBuilder = new StringBuilder();
			for (ChampData data : champData) {
				dataBuilder.append(',').append(data.getName());
			}
			request.addUrlParameter("champData", dataBuilder.substring(1));
		}
		request.execute();
		ChampionList dto = request.getDto(ChampionList.class);
		return dto;
	}

	public static GameMapList getDataGameMapList(ApiConfig config, Region region, String locale, String version) throws RiotApiException {
		Request request = new Request(config);
		request.addApiKeyToUrl();
		request.setUrlBase(ENDPOINT, region, VERSION, "map");
		if (locale != null) {
			request.addUrlParameter("locale", locale);
		}
		if (version != null) {
			request.addUrlParameter("version", version);
		}
		request.execute();
		GameMapList dto = request.getDto(GameMapList.class);
		return dto;
	}

	public static Item getDataItem(ApiConfig config, Region region, int id, String locale, String version, ItemData... itemData) throws RiotApiException {
		Request request = new Request(config);
		request.addApiKeyToUrl();
		request.setUrlBase(ENDPOINT, region, VERSION, "item/", id);
		if (locale != null) {
			request.addUrlParameter("locale", locale);
		}
		if (version != null) {
			request.addUrlParameter("version", version);
		}
		if (itemData[0] != null) {
			StringBuilder dataBuilder = new StringBuilder();
			for (ItemData data : itemData) {
				dataBuilder.append(',').append(data.getName());
			}
			request.addUrlParameter("itemData", dataBuilder.substring(1));
		}
		request.execute();
		Item dto = request.getDto(Item.class);
		return dto;
	}

	public static ItemList getDataItemList(ApiConfig config, Region region, String locale, String version, ItemListData... itemListData)
			throws RiotApiException {
		Request request = new Request(config);
		request.addApiKeyToUrl();
		request.setUrlBase(ENDPOINT, region, VERSION, "item");
		if (locale != null) {
			request.addUrlParameter("locale", locale);
		}
		if (version != null) {
			request.addUrlParameter("version", version);
		}
		if (itemListData[0] != null) {
			StringBuilder dataBuilder = new StringBuilder();
			for (ItemListData data : itemListData) {
				dataBuilder.append(',').append(data.getName());
			}
			request.addUrlParameter("itemListData", dataBuilder.substring(1));
		}
		request.execute();
		ItemList dto = request.getDto(ItemList.class);
		return dto;
	}

	public static List<String> getDataLanguages(ApiConfig config, Region region) throws RiotApiException {
		Request request = new Request(config);
		request.addApiKeyToUrl();
		request.setUrlBase(ENDPOINT, region, VERSION, "languages");
		request.execute();
		List<String> dto = request.getDto(new TypeToken<List<String>>() {
		}.getType());
		return dto;
	}

	public static LanguageStrings getDataLanguageStrings(ApiConfig config, Region region, String locale, String version) throws RiotApiException {
		Request request = new Request(config);
		request.addApiKeyToUrl();
		request.setUrlBase(ENDPOINT, region, VERSION, "language-strings");
		if (locale != null) {
			request.addUrlParameter("locale", locale);
		}
		if (version != null) {
			request.addUrlParameter("version", version);
		}
		request.execute();
		LanguageStrings dto = request.getDto(LanguageStrings.class);
		return dto;
	}

	public static Mastery getDataMastery(ApiConfig config, Region region, int id, String locale, String version, MasteryData... masteryData)
			throws RiotApiException {
		Request request = new Request(config);
		request.addApiKeyToUrl();
		request.setUrlBase(ENDPOINT, region, VERSION, "mastery/", id);
		if (locale != null) {
			request.addUrlParameter("locale", locale);
		}
		if (version != null) {
			request.addUrlParameter("version", version);
		}
		if (masteryData[0] != null) {
			StringBuilder dataBuilder = new StringBuilder();
			for (MasteryData data : masteryData) {
				dataBuilder.append(',').append(data.getName());
			}
			request.addUrlParameter("masteryListData", dataBuilder.substring(1));
		}
		request.execute();
		Mastery dto = request.getDto(Mastery.class);
		return dto;
	}

	public static MasteryList getDataMasteryList(ApiConfig config, Region region, String locale, String version, MasteryListData... masteryListData)
			throws RiotApiException {
		Request request = new Request(config);
		request.addApiKeyToUrl();
		request.setUrlBase(ENDPOINT, region, VERSION, "mastery");
		if (locale != null) {
			request.addUrlParameter("locale", locale);
		}
		if (version != null) {
			request.addUrlParameter("version", version);
		}
		if (masteryListData[0] != null) {
			StringBuilder dataBuilder = new StringBuilder();
			for (MasteryListData data : masteryListData) {
				dataBuilder.append(',').append(data.getName());
			}
			request.addUrlParameter("masteryListData", dataBuilder.substring(1));
		}
		request.execute();
		MasteryList dto = request.getDto(MasteryList.class);
		return dto;
	}

	public static Realm getDataRealm(ApiConfig config, Region region) throws RiotApiException {
		Request request = new Request(config);
		request.addApiKeyToUrl();
		request.setUrlBase(ENDPOINT, region, VERSION, "realm");
		request.execute();
		Realm dto = request.getDto(Realm.class);
		return dto;
	}

	public static Rune getDataRune(ApiConfig config, Region region, int id, String locale, String version, RuneData... runeData) throws RiotApiException {
		Request request = new Request(config);
		request.addApiKeyToUrl();
		request.setUrlBase(ENDPOINT, region, VERSION, "rune/", id);
		if (locale != null) {
			request.addUrlParameter("locale", locale);
		}
		if (version != null) {
			request.addUrlParameter("version", version);
		}
		if (runeData[0] != null) {
			StringBuilder dataBuilder = new StringBuilder();
			for (RuneData data : runeData) {
				dataBuilder.append(',').append(data.getName());
			}
			request.addUrlParameter("runeData", dataBuilder.substring(1));
		}
		request.execute();
		Rune dto = request.getDto(Rune.class);
		return dto;
	}

	public static RuneList getDataRuneList(ApiConfig config, Region region, String locale, String version, RuneListData... runeListData)
			throws RiotApiException {
		Request request = new Request(config);
		request.addApiKeyToUrl();
		request.setUrlBase(ENDPOINT, region, VERSION, "rune");
		if (locale != null) {
			request.addUrlParameter("locale", locale);
		}
		if (version != null) {
			request.addUrlParameter("version", version);
		}
		if (runeListData[0] != null) {
			StringBuilder dataBuilder = new StringBuilder();
			for (RuneListData data : runeListData) {
				dataBuilder.append(',').append(data.getName());
			}
			request.addUrlParameter("runeListData", dataBuilder.substring(1));
		}
		request.execute();
		RuneList dto = request.getDto(RuneList.class);
		return dto;
	}

	public static SummonerSpell getDataSummonerSpell(ApiConfig config, Region region, int id, String locale, String version, SpellData... spellData)
			throws RiotApiException {
		Request request = new Request(config);
		request.addApiKeyToUrl();
		request.setUrlBase(ENDPOINT, region, VERSION, "summoner-spell/", id);
		if (locale != null) {
			request.addUrlParameter("locale", locale);
		}
		if (version != null) {
			request.addUrlParameter("version", version);
		}
		if (spellData[0] != null) {
			StringBuilder dataBuilder = new StringBuilder();
			for (SpellData data : spellData) {
				dataBuilder.append(',').append(data.getName());
			}
			request.addUrlParameter("spellData", dataBuilder.substring(1));
		}
		request.execute();
		SummonerSpell dto = request.getDto(SummonerSpell.class);
		return dto;
	}

	public static SummonerSpellList getDataSummonerSpellList(ApiConfig config, Region region, String locale, String version, boolean dataById,
			SpellData... spellData) throws RiotApiException {
		Request request = new Request(config);
		request.addApiKeyToUrl();
		request.setUrlBase(ENDPOINT, region, VERSION, "summoner-spell");
		if (locale != null) {
			request.addUrlParameter("locale", locale);
		}
		if (version != null) {
			request.addUrlParameter("version", version);
		}
		request.addUrlParameter("dataById", dataById);
		if (spellData[0] != null) {
			StringBuilder dataBuilder = new StringBuilder();
			for (SpellData data : spellData) {
				dataBuilder.append(',').append(data.getName());
			}
			request.addUrlParameter("spellData", dataBuilder.substring(1));
		}
		request.execute();
		SummonerSpellList dto = request.getDto(SummonerSpellList.class);
		return dto;
	}

	public static List<String> getDataVersions(ApiConfig config, Region region) throws RiotApiException {
		Request request = new Request(config);
		request.addApiKeyToUrl();
		request.setUrlBase(ENDPOINT, region, VERSION, "versions");
		request.execute();
		List<String> dto = request.getDto(new TypeToken<List<String>>() {
		}.getType());
		return dto;
	}
}