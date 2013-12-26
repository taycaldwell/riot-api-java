package main.java.riotapi;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.IOUtils;
import dto.*;


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
	    ChampionList championList = null;
		try {
			championList = new Gson().fromJson(IOUtils.toString(new URL(url)), ChampionList.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return championList;
	}
	
	public ChampionList getChampions(String region) {
	
		String url = getBaseURL() + region + "/v1.1/champion?api_key=" + getKey();
	    ChampionList championList = null;
		try {
			championList = new Gson().fromJson(IOUtils.toString(new URL(url)), ChampionList.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return championList;
	}
    
	public ChampionList getChampions(boolean freeToPlay) {

		String url = getBaseURL() + getRegion() + "/v1.1/champion?freeToPlay=" + freeToPlay + "&api_key=" + getKey();
	    ChampionList championList = null;
		try {
			championList = new Gson().fromJson(IOUtils.toString(new URL(url)), ChampionList.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return championList;
	}
	
	public ChampionList getChampions(String region, boolean freeToPlay) {
		
		String url = getBaseURL() + region + "/v1.1/champion?freeToPlay=" + freeToPlay + "&api_key=" + getKey();
	    ChampionList championList = null;
		try {
			championList = new Gson().fromJson(IOUtils.toString(new URL(url)), ChampionList.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return championList;
	}
	
	public ChampionList getFreeToPlayChampions(String region) {

		String url = getBaseURL() + region + "/v1.1/champion?freeToPlay=true" + "&api_key=" + getKey();
	    ChampionList championList = null;
		try {
			championList = new Gson().fromJson(IOUtils.toString(new URL(url)), ChampionList.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return championList;
	}
	
	public ChampionList getFreeToPlayChampions() {

		String url = getBaseURL() + getRegion() + "/v1.1/champion?freeToPlay=true" + "&api_key=" + getKey();
	    ChampionList championList = null;
		try {
			championList = new Gson().fromJson(IOUtils.toString(new URL(url)), ChampionList.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return championList;
	}
	
	public RecentGames getRecentGames(String region, long summonerId) {
		
		String url = getBaseURL() + region + "/v1.2/game/by-summoner/" + summonerId + "/recent?api_key=" + getKey();
	    RecentGames recentGames = null;
		try {
			recentGames = new Gson().fromJson(IOUtils.toString(new URL(url)), RecentGames.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return recentGames;
	}
	
	public RecentGames getRecentGames(long summonerId) {
		
		String url = getBaseURL() + getRegion() + "/v1.2/game/by-summoner/" + summonerId + "/recent?api_key=" + getKey();
	    RecentGames recentGames = null;
		try {
			recentGames = new Gson().fromJson(IOUtils.toString(new URL(url)), RecentGames.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return recentGames;
	}

	public Map<String, League> getLeagues(String region, long summonerId) {
		
		String url = getBaseURL() + region + "/v2.2/league/by-summoner/" + summonerId + "?api_key=" + getKey();
	    Map<String, League> leagues = null;
		try {
			leagues = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, League>>(){}.getType());
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return leagues;
	}
	
	public Map<String, League> getLeagues(long summonerId) {
		
		String url = getBaseURL() + getRegion() + "/v2.2/league/by-summoner/" + summonerId + "?api_key=" + getKey();
	    Map<String, League> leagues = null;
		try {
			leagues = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, League>>(){}.getType());
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return leagues;
	}
	
	public PlayerStatsSummaryList getPlayerStatsSummary(String region, long summonerId, String season) {
		
		String url = getBaseURL() + region + "/v1.2/stats/by-summoner/" + summonerId + "/summary?season=" + season + "&api_key=" + getKey();
	    PlayerStatsSummaryList summaryList = null;
		try {
			summaryList = new Gson().fromJson(IOUtils.toString(new URL(url)), PlayerStatsSummaryList.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return summaryList;
	}
	
	public PlayerStatsSummaryList getPlayerStatsSummary(long summonerId, String season) {
		
		String url = getBaseURL() + getRegion() + "/v1.2/stats/by-summoner/" + summonerId + "/summary?season=" + season + "&api_key=" + getKey();
	    PlayerStatsSummaryList summaryList = null;
		try {
			summaryList = new Gson().fromJson(IOUtils.toString(new URL(url)), PlayerStatsSummaryList.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return summaryList;
	}
	
	public PlayerStatsSummaryList getPlayerStatsSummary(String region, long summonerId) {
		
		String url = getBaseURL() + region + "/v1.2/stats/by-summoner/" + summonerId + "/summary?season=" + getSeason() + "&api_key=" + getKey();
	    PlayerStatsSummaryList summaryList = null;
		try {
			summaryList = new Gson().fromJson(IOUtils.toString(new URL(url)), PlayerStatsSummaryList.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return summaryList;
	}
	
	public PlayerStatsSummaryList getPlayerStatsSummary(long summonerId) {
		
		String url = getBaseURL() + getRegion() + "/v1.2/stats/by-summoner/" + summonerId + "/summary?season=" + getSeason() + "&api_key=" + getKey();
	    PlayerStatsSummaryList summaryList = null;
		try {
			summaryList = new Gson().fromJson(IOUtils.toString(new URL(url)), PlayerStatsSummaryList.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return summaryList;
	}
	
	public RankedStats getRankedStats(String region, long summonerId, String season) {
		
		String url = getBaseURL() + region + "/v1.2/stats/by-summoner/" + summonerId + "/ranked?season=" + season + "&api_key=" + getKey();
	    RankedStats rankedStats = null;
		try {
			rankedStats = new Gson().fromJson(IOUtils.toString(new URL(url)), RankedStats.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return rankedStats;
	}
	
	
	public RankedStats getRankedStats(long summonerId, String season) {
		
		String url = getBaseURL() + getRegion() + "/v1.2/stats/by-summoner/" + summonerId + "/ranked?season=" + season + "&api_key=" + getKey();
	    RankedStats rankedStats = null;
		try {
			rankedStats = new Gson().fromJson(IOUtils.toString(new URL(url)), RankedStats.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return rankedStats;
	}
	
	
	public RankedStats getRankedStats(String region, long summonerId) {
		
		String url = getBaseURL() + region + "/v1.2/stats/by-summoner/" + summonerId + "/ranked?season=" + getSeason() + "&api_key=" + getKey();
	    RankedStats rankedStats = null;
		try {
			rankedStats = new Gson().fromJson(IOUtils.toString(new URL(url)), RankedStats.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return rankedStats;
	}
	
	public RankedStats getRankedStats(long summonerId) {
		
		String url = getBaseURL() + getRegion() + "/v1.2/stats/by-summoner/" + summonerId + "/ranked?season=" + getSeason() + "&api_key=" + getKey();
	    RankedStats rankedStats = null;
		try {
			rankedStats = new Gson().fromJson(IOUtils.toString(new URL(url)), RankedStats.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return rankedStats;
	}
	
	public MasteryPages getMasteryPages(String region, long summonerId) {
		
		String url = getBaseURL() + region + "/v1.2/summoner/" + summonerId + "/masteries?api_key=" + getKey();
	    MasteryPages masteryPages = null;
		try {
			masteryPages = new Gson().fromJson(IOUtils.toString(new URL(url)), MasteryPages.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return masteryPages;
	}
	
	public MasteryPages getMasteryPages(long summonerId) {
		
		String url = getBaseURL() + getRegion() + "/v1.2/summoner/" + summonerId + "/masteries?api_key=" + getKey();
	    MasteryPages masteryPages = null;
		try {
			masteryPages = new Gson().fromJson(IOUtils.toString(new URL(url)), MasteryPages.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return masteryPages;
	}
	
	public RunePages getRunePages(String region, long summonerId) {
		
		String url = getBaseURL() + region + "/v1.2/summoner/" + summonerId + "/runes?api_key=" + getKey();
	    RunePages runePages = null;
			try {
				runePages = new Gson().fromJson(IOUtils.toString(new URL(url)), RunePages.class);
			} catch (JsonSyntaxException e) {
				e.printStackTrace();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	    return runePages;
	}
	
	public RunePages getRunePages(long summonerId) {
		
		String url = getBaseURL() + getRegion() + "/v1.2/summoner/" + summonerId + "/runes?api_key=" + getKey();
	    RunePages runePages = null;
		try {
			runePages = new Gson().fromJson(IOUtils.toString(new URL(url)), RunePages.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return runePages;
	}
	
	public Summoner getSummoner(String region, String name) {
		String url = getBaseURL() + region + "/v1.2/summoner/by-name/" + name + "?api_key=" + getKey();
		Summoner summoner = null;
		try {
			summoner = new Gson().fromJson(IOUtils.toString(new URL(url)), Summoner.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return summoner;
	}
	
	public Summoner getSummoner(String name) {
		
		String url = getBaseURL() + getRegion() + "/v1.2/summoner/by-name/" + name + "?api_key=" + getKey();
		Summoner summoner = null;
		try {
			summoner = new Gson().fromJson(IOUtils.toString(new URL(url)), Summoner.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return summoner;
	}
	
	public Summoner getSummoner(String region, long summonerId) {
		
		String url = getBaseURL() + region + "/v1.2/summoner/" + summonerId + "?api_key=" + getKey();
		Summoner summoner = null;
		try {
			summoner = new Gson().fromJson(IOUtils.toString(new URL(url)), Summoner.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return summoner;
	}
	
	public Summoner getSummoner(long summonerId) {
		
		String url = getBaseURL() + getRegion() + "/v1.2/summoner/" + summonerId + "?api_key=" + getKey();
		Summoner summoner = null;
		try {
			summoner = new Gson().fromJson(IOUtils.toString(new URL(url)), Summoner.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return summoner;
	}
	
	public SummonerNameList getSummonerNames(String region, long... summonerIds){
	
		String ids = "";
		for(int i = 0; i < summonerIds.length; i++){
			if(i != (summonerIds.length - 1)){ ids = ids + summonerIds[i] + ", "; }
			else { ids = ids + summonerIds[i]; }
		}
		
		String url = getBaseURL() + region + "/v1.2/summoner/" + ids + "/name?api_key=" + getKey();
		SummonerNameList summonerNameList = null;
		try {
			summonerNameList = new Gson().fromJson(IOUtils.toString(new URL(url)), SummonerNameList.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return summonerNameList;
	}
	
	public SummonerNameList getSummonerNames(long... summonerIds){
		
		String ids = "";
		for(int i = 0; i < summonerIds.length; i++){
			if(i != (summonerIds.length - 1)){ ids = ids + summonerIds[i] + ", "; }
			else { ids = ids + summonerIds[i]; }
		}
		
		String url = getBaseURL() + getRegion() + "/v1.2/summoner/" + ids + "/name?api_key=" + getKey();
		SummonerNameList summonerNameList = null;
		try {
			summonerNameList = new Gson().fromJson(IOUtils.toString(new URL(url)), SummonerNameList.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return summonerNameList;
	}
	
	public List<Team> getTeams(String region, long summonerId){
		
		String url = getBaseURL() + region + "/v2.2/team/by-summoner/" + summonerId + "?api_key=" + getKey();
		List<Team> teamList = null;
		try {
			teamList = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<List<Team>>(){}.getType());
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	    return teamList;
	}
	
	public List<Team> getTeams(long summonerId){
		
		String url = getBaseURL() + getRegion() + "/v2.2/team/by-summoner/" + summonerId + "?api_key=" + getKey();
		List<Team> teamList = null;
		try {
			teamList = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<List<Team>>(){}.getType());
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	    return teamList;
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
				// TODO Auto-generated catch block
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
