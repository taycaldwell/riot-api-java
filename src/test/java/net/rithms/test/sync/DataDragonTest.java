package net.rithms.test.sync;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.data_dragon.constant.Locale;
import net.rithms.riot.api.endpoints.data_dragon.dto.Champion;
import net.rithms.riot.api.endpoints.data_dragon.dto.ChampionList;
import net.rithms.riot.api.endpoints.data_dragon.dto.ItemList;
import net.rithms.riot.api.endpoints.data_dragon.dto.LanguageStrings;
import net.rithms.riot.api.endpoints.data_dragon.dto.MapData;
import net.rithms.riot.api.endpoints.data_dragon.dto.MapDetails;
import net.rithms.riot.api.endpoints.data_dragon.dto.MasteryList;
import net.rithms.riot.api.endpoints.data_dragon.dto.ProfileIconData;
import net.rithms.riot.api.endpoints.data_dragon.dto.ProfileIconDetails;
import net.rithms.riot.api.endpoints.data_dragon.dto.Realm;
import net.rithms.riot.api.endpoints.data_dragon.dto.Rune;
import net.rithms.riot.api.endpoints.data_dragon.dto.RuneList;
import net.rithms.riot.api.endpoints.data_dragon.dto.SummonerSpell;
import net.rithms.riot.api.endpoints.data_dragon.dto.SummonerSpellList;
import net.rithms.riot.constant.Platform;
import net.rithms.test.RiotApiTest;

/**
 * 
 * @author Guillaume 'KabaL' ETTORI
 * Test cases of data dragon endpoint
 *
 */
public class DataDragonTest {
    private static RiotApi api = null;

    @BeforeClass
    public static void prepareApi() {
        api = RiotApiTest.getRiotApi();
    }
    
    @Test
    public void testDDataRuneList() throws RiotApiException {
    	Realm realm = api.getDDataRealm(Platform.EUW);
    	assertNotNull(realm);
    	
    	String runeVersion = realm.getN().get("rune");
    	Locale locale = Locale.valueOf(realm.getL().toUpperCase());
    	String cdn = realm.getCdn();
    	
    	RuneList runeList = api.getDDataRuneList(cdn, Platform.EUW, locale, runeVersion);
    	assertNotNull(runeList);
    	assertEquals(runeList.getVersion(), runeVersion);
    	assertTrue(!runeList.getData().isEmpty());
    	
    	Rune rune = runeList.getData().get("10001");
    	assertNotNull(rune);
    }
    
    @Test
    public void testDDataMasteryList() throws RiotApiException {
    	Realm realm = api.getDDataRealm(Platform.EUW);
    	assertNotNull(realm);
    	
    	String masteryVersion = realm.getN().get("mastery");
    	Locale locale = Locale.valueOf(realm.getL().toUpperCase());
    	String cdn = realm.getCdn();
    	
    	MasteryList masteryList = api.getDDataMasteryList(cdn, Platform.EUW, locale, masteryVersion);
    	assertNotNull(masteryList);
    	assertEquals(masteryList.getVersion(), masteryVersion);
    	assertTrue(!masteryList.getData().isEmpty());
    	
    	assertNotNull(masteryList.getTree().getFerocity());
    	assertTrue(!masteryList.getTree().getFerocity().isEmpty());
    }
    
    @Test
    public void testDDataLanguageStrings() throws RiotApiException {
    	Realm realm = api.getDDataRealm(Platform.EUW);
    	assertNotNull(realm);
    	
    	String languageVersion = realm.getN().get("language");
    	Locale locale = Locale.valueOf(realm.getL().toUpperCase());
    	String cdn = realm.getCdn();
    	
    	LanguageStrings languageStrings = api.getDataLanguageStrings(cdn, Platform.EUW, locale, languageVersion);
    	assertNotNull(languageStrings);
    	assertEquals(languageStrings.getVersion(), languageVersion);
    	assertTrue(!languageStrings.getData().isEmpty());
    	
    }
    
    @Test
    public void testDDataProfilIcons() throws RiotApiException {
    	Realm realm = api.getDDataRealm(Platform.EUW);
    	assertNotNull(realm);
    	
    	String profilIconsVersion = realm.getN().get("profileicon");
    	Locale locale = Locale.valueOf(realm.getL().toUpperCase());
    	String cdn = realm.getCdn();
    	
    	ProfileIconData profilIconData = api.getDDataProfileIcons(cdn, Platform.EUW, locale, profilIconsVersion);
    	assertNotNull(profilIconData);
    	assertEquals(profilIconData.getVersion(), profilIconsVersion);
    	assertTrue(!profilIconData.getData().isEmpty());
    	
    	ProfileIconDetails profilIconDetail = profilIconData.getData().get("0");
    	assertNotNull(profilIconDetail);
    	assertEquals(profilIconDetail.getImage().getSprite(), "profileicon0.png");
    	
    }
    
    @Test
    public void testDDataSummonerSpellList() throws RiotApiException {
    	Realm realm = api.getDDataRealm(Platform.EUW);
    	assertNotNull(realm);
    	
    	String summonerVersion = realm.getN().get("summoner");
    	Locale locale = Locale.valueOf(realm.getL().toUpperCase());
    	String cdn = realm.getCdn();
    	
    	
    	SummonerSpellList summonerSpellList = api.getDDataSummonerSpellList(cdn, Platform.EUW, locale, summonerVersion);
    	assertNotNull(summonerSpellList);
    	assertEquals(summonerSpellList.getVersion(), summonerVersion);
    	assertTrue(!summonerSpellList.getData().isEmpty());
    	
    	SummonerSpell summonerSpell = summonerSpellList.getData().get("SummonerBarrier");
    	assertNotNull(summonerSpell);
    }
    
    @Test
    public void testDDataItemList() throws RiotApiException {
    	Realm realm = api.getDDataRealm(Platform.EUW);
    	assertNotNull(realm);
    	
    	String itemVersion = realm.getN().get("item");
    	Locale locale = Locale.valueOf(realm.getL().toUpperCase());
    	String cdn = realm.getCdn();
    	
    	ItemList itemList = api.getDDataItemList(cdn, Platform.EUW, locale, itemVersion);
    	assertNotNull(itemList);
    	assertEquals(itemList.getVersion(), itemVersion);
    	assertTrue(!itemList.getData().isEmpty());
    }

    @Test
    public void testDDataMaps() throws RiotApiException {
    	Realm realm = api.getDDataRealm(Platform.EUW);
    	assertNotNull(realm);
    	
    	String mapVersion = realm.getN().get("map");
    	Locale locale = Locale.valueOf(realm.getL().toUpperCase());
    	String cdn = realm.getCdn();
    	
    	MapData mapData = api.getDDataMaps(cdn, Platform.EUW, locale, mapVersion);
    	assertNotNull(mapData);
    	assertEquals(mapData.getVersion(), mapVersion);
    	assertTrue(!mapData.getData().isEmpty());
    	
    	MapDetails mapDetails = mapData.getData().get("11");
    	assertNotNull(mapDetails);
    }
    
    @Test
    public void testDDataChampionList() throws RiotApiException {
    	Realm realm = api.getDDataRealm(Platform.EUW);
    	assertNotNull(realm);
    	
    	String championVersion = realm.getN().get("champion");
    	Locale locale = Locale.valueOf(realm.getL().toUpperCase());
    	String cdn = realm.getCdn();
    	
    	ChampionList champList = api.getDDataChampionList(cdn, Platform.EUW, locale, championVersion);
    	assertNotNull(champList);
    	assertEquals(champList.getVersion(), championVersion);
    	assertTrue(!champList.getData().isEmpty());
    }
    
    @Test
    public void testDDataChampion() throws RiotApiException {
    	Realm realm = api.getDDataRealm(Platform.EUW);
    	assertNotNull(realm);
    	
    	String championVersion = realm.getN().get("champion");
    	Locale locale = Locale.valueOf(realm.getL().toUpperCase());
    	String cdn = realm.getCdn();
    	
    	String champName = "Aatrox";
    	
    	ChampionList champList = api.getDDataChampion(cdn, Platform.EUW, champName, locale, championVersion);
    	assertNotNull(champList);
    	assertEquals(champList.getVersion(), championVersion);
    	assertTrue(!champList.getData().isEmpty());
    	
    	Champion champion = champList.getData().get(champName);
    	
    	assertNotNull(champion);
    	assertEquals(champion.getName(), champName);
    }
    
    @Test
    public void testDDataVersion() throws RiotApiException {
    	List<String> listVersions = api.getDDataVersions(Platform.EUW);
    	assertNotNull(listVersions);
    	assertTrue(!listVersions.isEmpty());
    }
}
