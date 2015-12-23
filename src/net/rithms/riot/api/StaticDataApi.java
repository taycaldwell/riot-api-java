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
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

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

final class StaticDataApi {

	private static final String VERSION = "/v1.2/";
	private static final String STATIC_DATA_ENDPOINT = "https://global.api.pvp.net/api/lol/static-data/";

	public static ChampionList getDataChampionList(Region region, String key, String locale, String version, boolean dataById, ChampData... champData)
			throws RiotApiException {
		String url = STATIC_DATA_ENDPOINT + region + VERSION + "champion?api_key=" + key;
		if (locale != null) {
			url += "&locale=" + locale;
		}
		if (version != null) {
			url += "&version=" + version;
		}
		url += "&dataById=" + dataById;
		if (champData[0] != null) {
			url += "&champData=";
			for (ChampData data : champData) {
				url += data.getName() + ",";
			}
		}

		ChampionList championList = null;
		try {
			championList = new Gson().fromJson(Request.sendGet(url), ChampionList.class);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (championList == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return championList;
	}

	public static Champion getDataChampion(Region region, String key, int id, String locale, String version, ChampData... champData) throws RiotApiException {
		String url = STATIC_DATA_ENDPOINT + region + VERSION + "champion/" + id + "?api_key=" + key;
		if (locale != null) {
			url += "&locale=" + locale;
		}
		if (version != null) {
			url += "&version=" + version;
		}
		if (champData[0] != null) {
			url += "&champData=";
			for (ChampData data : champData) {
				url += data.getName() + ",";
			}
		}

		Champion champion = null;
		try {
			champion = new Gson().fromJson(Request.sendGet(url), Champion.class);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (champion == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return champion;
	}

	public static ItemList getDataItemList(Region region, String key, String locale, String version, ItemListData... itemListData) throws RiotApiException {
		String url = STATIC_DATA_ENDPOINT + region + VERSION + "item?api_key=" + key;
		if (locale != null) {
			url += "&locale=" + locale;
		}
		if (version != null) {
			url += "&version=" + version;
		}
		if (itemListData[0] != null) {
			url += "&itemListData=";
			for (ItemListData data : itemListData) {
				url += data.getName() + ",";
			}
		}

		ItemList itemList = null;
		try {
			itemList = new Gson().fromJson(Request.sendGet(url), ItemList.class);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (itemList == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return itemList;
	}

	public static Item getDataItem(Region region, String key, int id, String locale, String version, ItemData... itemData) throws RiotApiException {
		String url = STATIC_DATA_ENDPOINT + region + VERSION + "item/" + id + "?api_key=" + key;
		if (locale != null) {
			url += "&locale=" + locale;
		}
		if (version != null) {
			url += "&version=" + version;
		}
		if (itemData[0] != null) {
			url += "&itemData=";
			for (ItemData data : itemData) {
				url += data.getName() + ",";
			}
		}

		Item item = null;
		try {
			item = new Gson().fromJson(Request.sendGet(url), Item.class);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (item == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return item;
	}

	public static Realm getDataRealm(Region region, String key) throws RiotApiException {
		String url = STATIC_DATA_ENDPOINT + region + VERSION + "realm?api_key=" + key;

		Realm realm = null;
		try {
			realm = new Gson().fromJson(Request.sendGet(url), Realm.class);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (realm == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return realm;
	}

	public static RuneList getDataRuneList(Region region, String key, String locale, String version, RuneListData... runeListData) throws RiotApiException {
		String url = STATIC_DATA_ENDPOINT + region + VERSION + "rune?api_key=" + key;
		if (locale != null) {
			url += "&locale=" + locale;
		}
		if (version != null) {
			url += "&version=" + version;
		}
		if (runeListData[0] != null) {
			url += "&runeListData=";
			for (RuneListData data : runeListData) {
				url += data.getName() + ",";
			}
		}

		RuneList runeList = null;
		try {
			runeList = new Gson().fromJson(Request.sendGet(url), RuneList.class);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (runeList == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return runeList;
	}

	public static Rune getDataRune(Region region, String key, int id, String locale, String version, RuneData... runeData) throws RiotApiException {
		String url = STATIC_DATA_ENDPOINT + region + VERSION + "rune/" + id + "?api_key=" + key;
		if (locale != null) {
			url += "&locale=" + locale;
		}
		if (version != null) {
			url += "&version=" + version;
		}
		if (runeData[0] != null) {
			url += "&runeData=";
			for (RuneData data : runeData) {
				url += data.getName() + ",";
			}
		}

		Rune rune = null;
		try {
			rune = new Gson().fromJson(Request.sendGet(url), Rune.class);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (rune == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return rune;
	}

	public static MasteryList getDataMasteryList(Region region, String key, String locale, String version, MasteryListData... masteryListData)
			throws RiotApiException {
		String url = STATIC_DATA_ENDPOINT + region + VERSION + "mastery?api_key=" + key;
		if (locale != null) {
			url += "&locale=" + locale;
		}
		if (version != null) {
			url += "&version=" + version;
		}
		if (masteryListData[0] != null) {
			url += "&masteryListData=";
			for (MasteryListData data : masteryListData) {
				url += data.getName() + ",";
			}
		}

		MasteryList masteryList = null;
		try {
			masteryList = new Gson().fromJson(Request.sendGet(url), MasteryList.class);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (masteryList == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return masteryList;
	}

	public static Mastery getDataMastery(Region region, String key, int id, String locale, String version, MasteryData... masteryData) throws RiotApiException {
		String url = STATIC_DATA_ENDPOINT + region + VERSION + "mastery/" + id + "?api_key=" + key;
		if (locale != null) {
			url += "&locale=" + locale;
		}
		if (version != null) {
			url += "&version=" + version;
		}
		if (masteryData[0] != null) {
			url += "&masteryData=";
			for (MasteryData data : masteryData) {
				url += data.getName() + ",";
			}
		}

		Mastery mastery = null;
		try {
			mastery = new Gson().fromJson(Request.sendGet(url), Mastery.class);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (mastery == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return mastery;
	}

	public static SummonerSpellList getDataSummonerSpellList(Region region, String key, String locale, String version, boolean dataById, SpellData... spellData)
			throws RiotApiException {
		String url = STATIC_DATA_ENDPOINT + region + VERSION + "summoner-spell?api_key=" + key;
		if (locale != null) {
			url += "&locale=" + locale;
		}
		if (version != null) {
			url += "&version=" + version;
		}
		url += "&dataById=" + dataById;
		if (spellData[0] != null) {
			url += "&spellData=";
			for (SpellData data : spellData) {
				url += data.getName() + ",";
			}
		}

		SummonerSpellList spellList = null;
		try {
			spellList = new Gson().fromJson(Request.sendGet(url), SummonerSpellList.class);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (spellList == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return spellList;
	}

	public static SummonerSpell getDataSummonerSpell(Region region, String key, int id, String locale, String version, SpellData... spellData)
			throws RiotApiException {
		String url = STATIC_DATA_ENDPOINT + region + VERSION + "summoner-spell/" + id + "?api_key=" + key;
		if (locale != null) {
			url += "&locale=" + locale;
		}
		if (version != null) {
			url += "&version=" + version;
		}
		if (spellData[0] != null) {
			url += "&spellData=";
			for (SpellData data : spellData) {
				url += data.getName() + ",";
			}
		}

		SummonerSpell spell = null;
		try {
			spell = new Gson().fromJson(Request.sendGet(url), SummonerSpell.class);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (spell == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return spell;
	}

	public static List<String> getDataVersions(Region region, String key) throws RiotApiException {
		String url = STATIC_DATA_ENDPOINT + region + VERSION + "versions?api_key=" + key;

		List<String> versions = null;
		try {
			versions = new Gson().fromJson(Request.sendGet(url), new TypeToken<List<String>>() {
			}.getType());
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (versions == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return versions;
	}

	public static List<String> getDataLanguages(Region region, String key) throws RiotApiException {
		String url = STATIC_DATA_ENDPOINT + region + VERSION + "languages?api_key=" + key;

		List<String> languages = null;
		try {
			languages = new Gson().fromJson(Request.sendGet(url), new TypeToken<List<String>>() {
			}.getType());
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (languages == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return languages;
	}

	public static GameMapList getDataGameMapList(Region region, String key, String locale, String version) throws RiotApiException {
		String url = STATIC_DATA_ENDPOINT + region + VERSION + "map?api_key=" + key;
		if (locale != null) {
			url += "&locale=" + locale;
		}
		if (version != null) {
			url += "&version=" + version;
		}

		GameMapList gameMapList = null;
		try {
			gameMapList = new Gson().fromJson(Request.sendGet(url), GameMapList.class);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (gameMapList == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return gameMapList;
	}

	public static LanguageStrings getDataLanguageStrings(Region region, String key, String locale, String version) throws RiotApiException {
		String url = STATIC_DATA_ENDPOINT + region + VERSION + "language-strings?api_key=" + key;
		if (locale != null) {
			url += "&locale=" + locale;
		}
		if (version != null) {
			url += "&version=" + version;
		}

		LanguageStrings languageStrings = null;
		try {
			languageStrings = new Gson().fromJson(Request.sendGet(url), LanguageStrings.class);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (languageStrings == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return languageStrings;
	}
}