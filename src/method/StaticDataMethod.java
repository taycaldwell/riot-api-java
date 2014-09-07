package method;

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

import java.io.IOException;
import java.net.URL;
import java.util.List;
import org.apache.commons.io.IOUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import constant.staticdata.ChampData;
import constant.staticdata.ItemData;
import constant.staticdata.ItemListData;
import constant.staticdata.RuneData;
import constant.staticdata.MasteryData;
import constant.staticdata.RuneListData;
import constant.staticdata.MasteryListData;
import constant.staticdata.SpellData;
import dto.Static.Champion;
import dto.Static.ChampionList;
import dto.Static.Item;
import dto.Static.ItemList;
import dto.Static.Mastery;
import dto.Static.MasteryList;
import dto.Static.Realm;
import dto.Static.Rune;
import dto.Static.RuneList;
import dto.Static.SummonerSpell;
import dto.Static.SummonerSpellList;

public final class StaticDataMethod {
	
	public static ChampionList getDataChampionList(String region, String key, String locale, String version, boolean dataById, ChampData champData) {
		
		String url = "https://global.api.pvp.net/api/lol/static-data/" + region + "/v1.2/champion?";
		
		if(locale != null)
			url += "locale=" + locale + "&";
		if(version != null)
			url += "version=" + version + "&";
		url += "dataById=" + dataById + "&";
		if(champData != null)
			url += "champData=" + champData.getName() + "&";
		url += "api_key=" + key;
		
		ChampionList championList = null;

			try {
				championList = new Gson().fromJson(IOUtils.toString(new URL(url)), ChampionList.class);
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
	
	    return championList;
	}
	
	public static Champion getDataChampion(String region, String key, int id, String locale, String version, boolean dataById, ChampData champData) {
		
		String url = "https://global.api.pvp.net/api/lol/static-data/" + region + "/v1.2/champion/" + id + "?";
		
		if(locale != null)
			url += "locale=" + locale + "&";
		if(version != null)
			url += "version=" + version + "&";
		url += "dataById=" + dataById + "&";
		if(champData != null)
			url += "champData=" + champData.getName() + "&";
		url += "api_key=" + key;
		
		Champion champion = null;

			try {
				champion = new Gson().fromJson(IOUtils.toString(new URL(url)), Champion.class);
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
	
	    return champion;
	}
	
	public static ItemList getDataItemList(String region, String key, String locale, String version, ItemListData itemListData) {
			
			String url = "https://global.api.pvp.net/api/lol/static-data/" + region + "/v1.2/item?";
			
			if(locale != null)
				url += "locale=" + locale + "&";
			if(version != null)
				url += "version=" + version + "&";
			if(itemListData != null)
				url += "itemListData=" + itemListData.getName() + "&";
			url += "api_key=" + key;
			
			ItemList itemList = null;
	
				try {
					itemList = new Gson().fromJson(IOUtils.toString(new URL(url)), ItemList.class);
				} catch (JsonSyntaxException | IOException e) {
					e.printStackTrace();
				}
		
		    return itemList;
		}
	
	public static Item getDataItem(String region, String key, int id, String locale, String version, ItemData itemData) {
		
		String url = "https://global.api.pvp.net/api/lol/static-data/" + region + "/v1.2/item/" + id + "?";
		
		if(locale != null)
			url += "locale=" + locale + "&";
		if(version != null)
			url += "version=" + version + "&";
		if(itemData != null)
			url += "itemData=" + itemData.getName() + "&";
		url += "api_key=" + key;
		
		Item item = null;
	
			try {
				item = new Gson().fromJson(IOUtils.toString(new URL(url)), Item.class);
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
	
	    return item;
	}
	
	public static Realm getDataRealm(String region, String key) {
		
		String url = "https://global.api.pvp.net/api/lol/static-data/" + region + "/v1.2/realm?api_key=" + key;
		
		Realm realm = null;
	
			try {
				realm = new Gson().fromJson(IOUtils.toString(new URL(url)), Realm.class);
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
	
	    return realm;
	}
	
	public static RuneList getDataRuneList(String region, String key, String locale, String version, RuneListData runeListData) {
		
		String url = "https://global.api.pvp.net/api/lol/static-data/" + region + "/v1.2/rune/?";
		
		if(locale != null)
			url += "locale=" + locale + "&";
		if(version != null)
			url += "version=" + version + "&";
		if(runeListData != null)
			url += "runeListData=" + runeListData.getName() + "&";
		url += "api_key=" + key;
		
		RuneList runeList = null;
	
			try {
				runeList = new Gson().fromJson(IOUtils.toString(new URL(url)), RuneList.class);
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
	
	    return runeList;
	}
	
	public static Rune getDataRune(String region, String key, int id, String locale, String version, RuneData runeData) {
		
		String url = "https://global.api.pvp.net/api/lol/static-data/" + region + "/v1.2/rune/" + id + "?";
		
		if(locale != null)
			url += "locale=" + locale + "&";
		if(version != null)
			url += "version=" + version + "&";
		if(runeData != null)
			url += "runeData=" + runeData.getName() + "&";
		url += "api_key=" + key;
		
		Rune rune = null;
	
			try {
				rune = new Gson().fromJson(IOUtils.toString(new URL(url)), Rune.class);
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
	
	    return rune;
	}
	
	public static MasteryList getDataMasteryList(String region, String key, String locale, String version, MasteryListData masteryListData) {
		
		String url = "https://global.api.pvp.net/api/lol/static-data/" + region + "/v1.2/mastery?";
		
		if(locale != null)
			url += "locale=" + locale + "&";
		if(version != null)
			url += "version=" + version + "&";
		if(masteryListData != null)
			url += "masteryListData=" + masteryListData.getName() + "&";
		url += "api_key=" + key;
		
		MasteryList masteryList = null;
	
			try {
				masteryList = new Gson().fromJson(IOUtils.toString(new URL(url)), MasteryList.class);
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
	
	    return masteryList;
	}
	
	public static Mastery getDataMastery(String region, String key, int id, String locale, String version, MasteryData masteryData) {
		
		String url = "https://global.api.pvp.net/api/lol/static-data/" + region + "/v1.2/mastery/" + id + "?";
		
		if(locale != null)
			url += "locale=" + locale + "&";
		if(version != null)
			url += "version=" + version + "&";
		if(masteryData != null)
			url += "masteryData=" + masteryData.getName() + "&";
		url += "api_key=" + key;
		
		Mastery mastery = null;
	
			try {
				mastery = new Gson().fromJson(IOUtils.toString(new URL(url)), Mastery.class);
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
	
	    return mastery;
	}
	
	public static SummonerSpellList getDataSummonerSpellList(String region, String key, String locale, String version, boolean dataById, SpellData spellData) {
		
		String url = "https://global.api.pvp.net/api/lol/static-data/" + region + "/v1.2/summoner-spell?";
		
		if(locale != null)
			url += "locale=" + locale + "&";
		if(version != null)
			url += "version=" + version + "&";
		url += "dataById=" + dataById + "&";
		if(spellData != null)
			url += "spellData=" + spellData.getName() + "&";
		url += "api_key=" + key;
		
		SummonerSpellList spellList = null;
	
			try {
				spellList = new Gson().fromJson(IOUtils.toString(new URL(url)), SummonerSpellList.class);
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
	
	    return spellList;
	}

	public static SummonerSpell getDataSummonerSpellList(String region, String key, int id, String locale, String version, SpellData spellData) {
		
		String url = "https://global.api.pvp.net/api/lol/static-data/" + region + "/v1.2/summoner-spell/" + id + "?";
		
		if(locale != null)
			url += "locale=" + locale + "&";
		if(version != null)
			url += "version=" + version + "&";
		if(spellData != null)
			url += "spellData=" + spellData.getName() + "&";
		url += "api_key=" + key;
		
		SummonerSpell spell = null;
	
			try {
				spell = new Gson().fromJson(IOUtils.toString(new URL(url)), SummonerSpell.class);
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
	
	    return spell;
	}
	
	public static List<String> getDataVersion(String region, String key) {
		
		String url = "https://global.api.pvp.net/api/lol/static-data/" + region + "/v1.2/versions?api_key=" + key;
		
		List<String> version = null;
	
			try {
				version = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<List<String>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
	
	    return version;
	}

}
