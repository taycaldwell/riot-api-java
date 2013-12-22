package main.java.riotapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dto.*;

/**
The MIT License (MIT)

Copyright (c) 2013 Taylor Caldwell

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

public class RiotAPI {

	private String key = "YOUR API KEY";
	private String baseURL = "https://prod.api.pvp.net/api/lol/";
	private String region = ""; 
	private String season = "";
	
	public RiotAPI() {
		
	}
	
	public RiotAPI(String key) {
		
		this.setKey(key);
	}
	
	public RiotAPI(String key, String region) {
		
		this.setKey(key);
		this.setRegion(region);
	}
	
	public ChampionList getChampions() {
		
		String url = getBaseURL() + getRegion() + "/v1.1/champion?api_key=" + getKey();
		ChampionList championList = new Gson().fromJson(RiotAPI.request(url), ChampionList.class);
	    
		return championList;
	}
	
	public ChampionList getChampions(String region) {
	
		String url = getBaseURL() + region + "/v1.1/champion?api_key=" + getKey();
		ChampionList championList = new Gson().fromJson(RiotAPI.request(url), ChampionList.class);
	    
		return championList;
	}
    
	public ChampionList getChampions(boolean freeToPlay) {

		String url = getBaseURL() + getRegion() + "/v1.1/champion?freeToPlay=" + freeToPlay + "&api_key=" + getKey();
		ChampionList championList = new Gson().fromJson(RiotAPI.request(url), ChampionList.class);
	    
		return championList;
	}
	
	public ChampionList getChampions(String region, boolean freeToPlay) {
		
		String url = getBaseURL() + region + "/v1.1/champion?freeToPlay=" + freeToPlay + "&api_key=" + getKey();
		ChampionList championList = new Gson().fromJson(RiotAPI.request(url), ChampionList.class);
	    	
		return championList;
	}
	
	public ChampionList getFreeToPlayChampions(String region) {

		String url = getBaseURL() + region + "/v1.1/champion?freeToPlay=true" + "&api_key=" + getKey();
		ChampionList championList = new Gson().fromJson(RiotAPI.request(url), ChampionList.class);
	    
		return championList;
	}
	
	public ChampionList getFreeToPlayChampions() {

		String url = getBaseURL() + getRegion() + "/v1.1/champion?freeToPlay=true" + "&api_key=" + getKey();
		ChampionList championList = new Gson().fromJson(RiotAPI.request(url), ChampionList.class);
	    
		return championList;
	}
	
	public RecentGames getRecentGames(String region, long summonerId) {
		
		String url = getBaseURL() + region + "/v1.2/game/by-summoner/" + summonerId + "/recent?api_key=" + getKey();
		RecentGames recentGames = new Gson().fromJson(RiotAPI.request(url), RecentGames.class);
	    
		return recentGames;
	}
	
	public RecentGames getRecentGames(long summonerId) {
		
		String url = getBaseURL() + getRegion() + "/v1.2/game/by-summoner/" + summonerId + "/recent?api_key=" + getKey();
		RecentGames recentGames = new Gson().fromJson(RiotAPI.request(url), RecentGames.class);
	    
		return recentGames;
	}

	public Map<String, League> getLeagues(String region, long summonerId) {
		
		String url = getBaseURL() + region + "/v2.2/league/by-summoner/" + summonerId + "?api_key=" + getKey();
		Map<String, League> leagues = new Gson().fromJson(RiotAPI.request(url), new TypeToken<Map<String, League>>(){}.getType());
	    
		return leagues;
	}
	
	public Map<String, League> getLeagues(long summonerId) {
		
		String url = getBaseURL() + getRegion() + "/v2.2/league/by-summoner/" + summonerId + "?api_key=" + getKey();
		Map<String, League> leagues = new Gson().fromJson(RiotAPI.request(url), new TypeToken<Map<String, League>>(){}.getType());
	    
		return leagues;
	}
	
	public PlayerStatsSummaryList getPlayerStatsSummary(String region, long summonerId, String season) {
		
		String url = getBaseURL() + region + "/v1.2/stats/by-summoner/" + summonerId + "/summary?season=" + season + "&api_key=" + getKey();
		PlayerStatsSummaryList summaryList = new Gson().fromJson(RiotAPI.request(url), PlayerStatsSummaryList.class);
	    
		return summaryList;
	}
	
	public PlayerStatsSummaryList getPlayerStatsSummary(long summonerId, String season) {
		
		String url = getBaseURL() + getRegion() + "/v1.2/stats/by-summoner/" + summonerId + "/summary?season=" + season + "&api_key=" + getKey();
		PlayerStatsSummaryList summaryList = new Gson().fromJson(RiotAPI.request(url), PlayerStatsSummaryList.class);
	    
		return summaryList;
	}
	
	public PlayerStatsSummaryList getPlayerStatsSummary(String region, long summonerId) {
		
		String url = getBaseURL() + region + "/v1.2/stats/by-summoner/" + summonerId + "/summary?season=" + getSeason() + "&api_key=" + getKey();
		PlayerStatsSummaryList summaryList = new Gson().fromJson(RiotAPI.request(url), PlayerStatsSummaryList.class);
	    
		return summaryList;
	}
	
	public PlayerStatsSummaryList getPlayerStatsSummary(long summonerId) {
		
		String url = getBaseURL() + getRegion() + "/v1.2/stats/by-summoner/" + summonerId + "/summary?season=" + getSeason() + "&api_key=" + getKey();
		PlayerStatsSummaryList summaryList = new Gson().fromJson(RiotAPI.request(url), PlayerStatsSummaryList.class);
	    
		return summaryList;
	}
	
	public RankedStats getRankedStats(String region, long summonerId, String season) {
		
		String url = getBaseURL() + region + "/v1.2/stats/by-summoner/" + summonerId + "/ranked?season=" + season + "&api_key=" + getKey();
		RankedStats rankedStats = new Gson().fromJson(RiotAPI.request(url), RankedStats.class);
	    
		return rankedStats;
	}
	
	
	public RankedStats getRankedStats(long summonerId, String season) {
		
		String url = getBaseURL() + getRegion() + "/v1.2/stats/by-summoner/" + summonerId + "/ranked?season=" + season + "&api_key=" + getKey();
		RankedStats rankedStats = new Gson().fromJson(RiotAPI.request(url), RankedStats.class);
	    
		return rankedStats;
	}
	
	
	public RankedStats getRankedStats(String region, long summonerId) {
		
		String url = getBaseURL() + region + "/v1.2/stats/by-summoner/" + summonerId + "/ranked?season=" + getSeason() + "&api_key=" + getKey();
		RankedStats rankedStats = new Gson().fromJson(RiotAPI.request(url), RankedStats.class);
	    
		return rankedStats;
	}
	
	public RankedStats getRankedStats(long summonerId) {
		
		String url = getBaseURL() + getRegion() + "/v1.2/stats/by-summoner/" + summonerId + "/ranked?season=" + getSeason() + "&api_key=" + getKey();
		RankedStats rankedStats = new Gson().fromJson(RiotAPI.request(url), RankedStats.class);
	    
		return rankedStats;
	}
	
	public MasteryPages getMasteryPages(String region, long summonerId) {
		
		String url = getBaseURL() + region + "/v1.2/summoner/" + summonerId + "/masteries?api_key=" + getKey();
		MasteryPages masteryPages = new Gson().fromJson(RiotAPI.request(url), MasteryPages.class);
	    
		return masteryPages;
	}
	
	public MasteryPages getMasteryPages(long summonerId) {
		
		String url = getBaseURL() + getRegion() + "/v1.2/summoner/" + summonerId + "/masteries?api_key=" + getKey();
		MasteryPages masteryPages = new Gson().fromJson(RiotAPI.request(url), MasteryPages.class);
	    
		return masteryPages;
	}
	
	public RunePages getRunePages(String region, long summonerId) {
		
		String url = getBaseURL() + region + "/v1.2/summoner/" + summonerId + "/runes?api_key=" + getKey();
		RunePages runePages = new Gson().fromJson(RiotAPI.request(url), RunePages.class);
	    
		return runePages;
	}
	
	public RunePages getRunePages(long summonerId) {
		
		String url = getBaseURL() + getRegion() + "/v1.2/summoner/" + summonerId + "/runes?api_key=" + getKey();
		RunePages runePages = new Gson().fromJson(RiotAPI.request(url), RunePages.class);
	    
		return runePages;
	}
	
	public Summoner getSummoner(String region, String name) {
		
		String url = getBaseURL() + region + "/v1.2/summoner/by-name/" + name + "?api_key=" + getKey();
		Summoner summoner = new Gson().fromJson(RiotAPI.request(url), Summoner.class);
	    
		return summoner;
	}
	
	public Summoner getSummoner(String name) {
		
		String url = getBaseURL() + getRegion() + "/v1.2/summoner/by-name/" + name + "?api_key=" + getKey();
		Summoner summoner = new Gson().fromJson(RiotAPI.request(url), Summoner.class);
	    
		return summoner;
	}
	
	public Summoner getSummoner(String region, long summonerId) {
		
		String url = getBaseURL() + region + "/v1.2/summoner/" + summonerId + "?api_key=" + getKey();
		Summoner summoner = new Gson().fromJson(RiotAPI.request(url), Summoner.class);
	    
		return summoner;
	}
	
	public Summoner getSummoner(long summonerId) {
		
		String url = getBaseURL() + getRegion() + "/v1.2/summoner/" + summonerId + "?api_key=" + getKey();
		Summoner summoner = new Gson().fromJson(RiotAPI.request(url), Summoner.class);
	    
		return summoner;
	}
	
	public SummonerNameList getSummonerNameList(String region, long... summonerIds){
	
		String ids = "";
		for(int i = 0; i < summonerIds.length; i++){
			if(i != (summonerIds.length - 1)){ ids = ids + summonerIds[i] + ", "; }
			else { ids = ids + summonerIds[i]; }
		}
		
		String url = getBaseURL() + region + "/v1.2/summoner/" + ids + "/name?api_key=" + getKey();
		SummonerNameList summonerNameList = new Gson().fromJson(RiotAPI.request(url), SummonerNameList.class);
	    
		return summonerNameList;
	}
	
	public SummonerNameList getSummonerNameList(long... summonerIds){
		
		String ids = "";
		for(int i = 0; i < summonerIds.length; i++){
			if(i != (summonerIds.length - 1)){ ids = ids + summonerIds[i] + ", "; }
			else { ids = ids + summonerIds[i]; }
		}
		
		String url = getBaseURL() + getRegion() + "/v1.2/summoner/" + ids + "/name?api_key=" + getKey();
		SummonerNameList summonerNameList = new Gson().fromJson(RiotAPI.request(url), SummonerNameList.class);
	    
		return summonerNameList;
	}
	
	public List<Team> getTeams(String region, long summonerId){
		
		String url = getBaseURL() + region + "/v2.2/team/by-summoner/" + summonerId + "?api_key=" + getKey();
		List<Team> teamList = new Gson().fromJson(RiotAPI.request(url), new TypeToken<List<Team>>(){}.getType());
		
		return teamList;
	}
	
	public List<Team> getTeams(long summonerId){
		
		String url = getBaseURL() + getRegion() + "/v2.2/team/by-summoner/" + summonerId + "?api_key=" + getKey();
		List<Team> teamList = new Gson().fromJson(RiotAPI.request(url), new TypeToken<List<Team>>(){}.getType());
		
		return teamList;
	}
	
	public static String request(String url) {
		
		StringBuilder sb = null;
		URL requestURL = null;
		
		try {
			requestURL = new URL(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
        	try {
			HttpURLConnection connection = (HttpURLConnection) requestURL.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			sb = new StringBuilder();
			String inputLine;
			while ((inputLine = in.readLine()) != null) 
			    sb.append(inputLine);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
		return sb.toString();
	 }

	public String getSeason() {
		if(season.equals("")){
			try {
				throw new Exception("No season was set.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return season;
	}
	
	public void setSeason(String season) {
		this.season = season;
	}
	
	public String getKey() {
		if(key.equals("YOUR API KEY")){
			try {
				throw new Exception("No key was set.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getBaseURL() {
		return baseURL;
	}

	public String getRegion() {
		if(region.equals("")){
			try {
				throw new Exception("No region was set.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

}
