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

	public static ChampionList getDataChampionList(Region region, String key, String locale, String version, boolean dataById, ChampData... champData)
			throws RiotApiException {
		Request request = new Request();
		request.addToUrl(ENDPOINT, region, VERSION, "champion?api_key=", key);
		if (locale != null) {
			request.addToUrl("&locale=", locale);
		}
		if (version != null) {
			request.addToUrl("&version=", version);
		}
		request.addToUrl("&dataById=", dataById);
		if (champData[0] != null) {
			request.addToUrl("&champData=");
			for (ChampData data : champData) {
				request.addToUrl(data.getName(), ",");
			}
		}
		request.execute();
		ChampionList dto = request.getDto(ChampionList.class);
		return dto;
	}

	public static Champion getDataChampion(Region region, String key, int id, String locale, String version, ChampData... champData) throws RiotApiException {
		Request request = new Request();
		request.addToUrl(ENDPOINT, region, VERSION, "champion/", id, "?api_key=", key);
		if (locale != null) {
			request.addToUrl("&locale=", locale);
		}
		if (version != null) {
			request.addToUrl("&version=", version);
		}
		if (champData[0] != null) {
			request.addToUrl("&champData=");
			for (ChampData data : champData) {
				request.addToUrl(data.getName(), ",");
			}
		}
		request.execute();
		Champion dto = request.getDto(Champion.class);
		return dto;
	}

	public static ItemList getDataItemList(Region region, String key, String locale, String version, ItemListData... itemListData) throws RiotApiException {
		Request request = new Request();
		request.addToUrl(ENDPOINT, region, VERSION, "item?api_key=", key);
		if (locale != null) {
			request.addToUrl("&locale=", locale);
		}
		if (version != null) {
			request.addToUrl("&version=", version);
		}
		if (itemListData[0] != null) {
			request.addToUrl("&itemListData=");
			for (ItemListData data : itemListData) {
				request.addToUrl(data.getName(), ",");
			}
		}
		request.execute();
		ItemList dto = request.getDto(ItemList.class);
		return dto;
	}

	public static Item getDataItem(Region region, String key, int id, String locale, String version, ItemData... itemData) throws RiotApiException {
		Request request = new Request();
		request.addToUrl(ENDPOINT, region, VERSION, "item/", id, "?api_key=", key);
		if (locale != null) {
			request.addToUrl("&locale=", locale);
		}
		if (version != null) {
			request.addToUrl("&version=", version);
		}
		if (itemData[0] != null) {
			request.addToUrl("&itemData=");
			for (ItemData data : itemData) {
				request.addToUrl(data.getName(), ",");
			}
		}
		request.execute();
		Item dto = request.getDto(Item.class);
		return dto;
	}

	public static Realm getDataRealm(Region region, String key) throws RiotApiException {
		Request request = new Request();
		request.addToUrl(ENDPOINT, region, VERSION, "realm?api_key=", key);
		request.execute();
		Realm dto = request.getDto(Realm.class);
		return dto;
	}

	public static RuneList getDataRuneList(Region region, String key, String locale, String version, RuneListData... runeListData) throws RiotApiException {
		Request request = new Request();
		request.addToUrl(ENDPOINT, region, VERSION, "rune?api_key=", key);
		if (locale != null) {
			request.addToUrl("&locale=", locale);
		}
		if (version != null) {
			request.addToUrl("&version=", version);
		}
		if (runeListData[0] != null) {
			request.addToUrl("&runeListData=");
			for (RuneListData data : runeListData) {
				request.addToUrl(data.getName(), ",");
			}
		}
		request.execute();
		RuneList dto = request.getDto(RuneList.class);
		return dto;
	}

	public static Rune getDataRune(Region region, String key, int id, String locale, String version, RuneData... runeData) throws RiotApiException {
		Request request = new Request();
		request.addToUrl(ENDPOINT, region, VERSION, "rune/", id, "?api_key=", key);
		if (locale != null) {
			request.addToUrl("&locale=", locale);
		}
		if (version != null) {
			request.addToUrl("&version=", version);
		}
		if (runeData[0] != null) {
			request.addToUrl("&runeData=");
			for (RuneData data : runeData) {
				request.addToUrl(data.getName(), ",");
			}
		}
		request.execute();
		Rune dto = request.getDto(Rune.class);
		return dto;
	}

	public static MasteryList getDataMasteryList(Region region, String key, String locale, String version, MasteryListData... masteryListData)
			throws RiotApiException {
		Request request = new Request();
		request.addToUrl(ENDPOINT, region, VERSION, "mastery?api_key=", key);
		if (locale != null) {
			request.addToUrl("&locale=", locale);
		}
		if (version != null) {
			request.addToUrl("&version=", version);
		}
		if (masteryListData[0] != null) {
			request.addToUrl("&masteryListData=");
			for (MasteryListData data : masteryListData) {
				request.addToUrl(data.getName(), ",");
			}
		}
		request.execute();
		MasteryList dto = request.getDto(MasteryList.class);
		return dto;
	}

	public static Mastery getDataMastery(Region region, String key, int id, String locale, String version, MasteryData... masteryData) throws RiotApiException {
		Request request = new Request();
		request.addToUrl(ENDPOINT, region, VERSION, "mastery/", id, "?api_key=", key);
		if (locale != null) {
			request.addToUrl("&locale=", locale);
		}
		if (version != null) {
			request.addToUrl("&version=", version);
		}
		if (masteryData[0] != null) {
			request.addToUrl("&masteryData=");
			for (MasteryData data : masteryData) {
				request.addToUrl(data.getName(), ",");
			}
		}
		request.execute();
		Mastery dto = request.getDto(Mastery.class);
		return dto;
	}

	public static SummonerSpellList getDataSummonerSpellList(Region region, String key, String locale, String version, boolean dataById, SpellData... spellData)
			throws RiotApiException {
		Request request = new Request();
		request.addToUrl(ENDPOINT, region, VERSION, "summoner-spell?api_key=", key);
		if (locale != null) {
			request.addToUrl("&locale=", locale);
		}
		if (version != null) {
			request.addToUrl("&version=", version);
		}
		request.addToUrl("&dataById=", dataById);
		if (spellData[0] != null) {
			request.addToUrl("&spellData=");
			for (SpellData data : spellData) {
				request.addToUrl(data.getName(), ",");
			}
		}
		request.execute();
		SummonerSpellList dto = request.getDto(SummonerSpellList.class);
		return dto;
	}

	public static SummonerSpell getDataSummonerSpell(Region region, String key, int id, String locale, String version, SpellData... spellData)
			throws RiotApiException {
		Request request = new Request();
		request.addToUrl(ENDPOINT, region, VERSION, "summoner-spell/", id, "?api_key=", key);
		if (locale != null) {
			request.addToUrl("&locale=", locale);
		}
		if (version != null) {
			request.addToUrl("&version=", version);
		}
		if (spellData[0] != null) {
			request.addToUrl("&spellData=");
			for (SpellData data : spellData) {
				request.addToUrl(data.getName(), ",");
			}
		}
		request.execute();
		SummonerSpell dto = request.getDto(SummonerSpell.class);
		return dto;
	}

	public static List<String> getDataVersions(Region region, String key) throws RiotApiException {
		Request request = new Request();
		request.addToUrl(ENDPOINT, region, VERSION, "versions?api_key=", key);
		request.execute();
		List<String> dto = request.getDto(new TypeToken<List<String>>() {
		}.getType());
		return dto;
	}

	public static List<String> getDataLanguages(Region region, String key) throws RiotApiException {
		Request request = new Request();
		request.addToUrl(ENDPOINT, region, VERSION, "languages?api_key=", key);
		request.execute();
		List<String> dto = request.getDto(new TypeToken<List<String>>() {
		}.getType());
		return dto;
	}

	public static GameMapList getDataGameMapList(Region region, String key, String locale, String version) throws RiotApiException {
		Request request = new Request();
		request.addToUrl(ENDPOINT, region, VERSION, "map?api_key=", key);
		if (locale != null) {
			request.addToUrl("&locale=", locale);
		}
		if (version != null) {
			request.addToUrl("&version=", version);
		}
		request.execute();
		GameMapList dto = request.getDto(GameMapList.class);
		return dto;
	}

	public static LanguageStrings getDataLanguageStrings(Region region, String key, String locale, String version) throws RiotApiException {
		Request request = new Request();
		request.addToUrl(ENDPOINT, region, VERSION, "language-strings?api_key=", key);
		if (locale != null) {
			request.addToUrl("&locale=", locale);
		}
		if (version != null) {
			request.addToUrl("&version=", version);
		}
		request.execute();
		LanguageStrings dto = request.getDto(LanguageStrings.class);
		return dto;
	}
}