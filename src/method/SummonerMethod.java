package method;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import util.Convert;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import dto.Summoner.MasteryPages;
import dto.Summoner.RunePages;
import dto.Summoner.Summoner;

public final class SummonerMethod {

	public static Map<String, MasteryPages> getMasteryPages(String endpoint, String region, String key, String summonerIds) {
		
		String url = endpoint + "/api/lol/" + region + "/v1.4/summoner/" + summonerIds + "/masteries?api_key=" + key;
	    Map<String, MasteryPages> masteryPages = null;

			try {
				masteryPages = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, MasteryPages>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}

	    return masteryPages;
	}
	
	public static Map<String, MasteryPages> getMasteryPages(String endpoint, String region, String key, long... summonerIds) {
		
		String url = endpoint + "/api/lol/" + region + "/v1.4/summoner/" + Convert.longToString(summonerIds) + "/masteries?api_key=" + key;
	    Map<String, MasteryPages> masteryPages = null;

			try {
				masteryPages = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, MasteryPages>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}

	    return masteryPages;
	}
	
	public static Map<String, RunePages> getRunePages(String endpoint, String region, String key, String summonerIds) {
		
		String url = endpoint + "/api/lol/" + region + "/v1.4/summoner/" + summonerIds + "/runes?api_key=" + key;
	    Map<String, RunePages> runePages = null;

			try {
				runePages = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, RunePages>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
		
	    return runePages;
	}
	
	public static Map<String, RunePages> getRunePages(String endpoint, String region, String key, long... summonerIds) {
		
		String url = endpoint + "/api/lol/" + region + "/v1.3/summoner/" + Convert.longToString(summonerIds) + "/runes?api_key=" + key;
	    Map<String, RunePages> runePages = null;

			try {
				runePages = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, RunePages>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
		
	    return runePages;
	}

	public static Map<String, Summoner> getSummonerByName(String endpoint, String region, String key, String summonerName) {
		
		summonerName = summonerName.replaceAll("\\s+", "");
		String url = endpoint + "/api/lol/" + region + "/v1.4/summoner/by-name/" + summonerName + "?api_key=" + key;
		Map<String, Summoner> summoner = null;

			try {
				summoner = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, Summoner>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
    
	    return summoner;
	}
	
	public static Map<String, Summoner> getSummonersById(String endpoint, String region, String key, long... summonerIds) {
			
		String url = endpoint + "/api/lol/" + region + "/v1.4/summoner/" + Convert.longToString(summonerIds) + "?api_key=" + key;
		Map<String, Summoner> summoner = null;

			try {
				summoner = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, Summoner>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
    
	    return summoner;
	}
	
	public static Map<String, Summoner> getSummonerById(String endpoint, String region, String key, long summonerId) {
			
		String url = endpoint + "/api/lol/" + region + "/v1.4/summoner/" + Convert.longToString(summonerId) + "?api_key=" + key;
		Map<String, Summoner> summoner = null;

			try {
				summoner = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, Summoner>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
    
	    return summoner;
	}
	
	public static Map<String, Summoner> getSummonerById(String endpoint, String region, String key, String summonerId) {
		
		String url = endpoint + "/api/lol/" + region + "/v1.4/summoner/" + summonerId + "?api_key=" + key;
		Map<String, Summoner> summoner = null;

			try {
				summoner = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, Summoner>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
    
	    return summoner;
	}
	
	public static Map<String, String> getSummonerNames(String endpoint, String region, String key, long... summonerIds){
	
		String url = endpoint + "/api/lol/" + region + "/v1.4/summoner/" + Convert.longToString(summonerIds) + "/name?api_key=" + key;
		Map<String, String> summonerNameList = null;

			try {
				summonerNameList = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, String>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
    
	    return summonerNameList;
	}

	public static Map<String, String> getSummonerName(String endpoint, String region, String key, long summonerId){
	
		String url = endpoint + "/api/lol/" + region + "/v1.4/summoner/" + Convert.longToString(summonerId) + "/name?api_key=" + key;
		Map<String, String> summonerNameList = null;

			try {
				summonerNameList = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, String>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
    
	    return summonerNameList;
	}

	public static Map<String, String> getSummonerName(String endpoint, String region, String key, String summonerId){
		
		String url = endpoint + "/api/lol/" + region + "/v1.4/summoner/" + summonerId + "/name?api_key=" + key;
		Map<String, String> summonerNameList = null;

			try {
				summonerNameList = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, String>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
    
	    return summonerNameList;
	}
	
}
