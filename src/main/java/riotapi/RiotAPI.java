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
	
	/**The base URL for all API requests*/
	private String baseURL = "https://prod.api.pvp.net/api/lol/";
	
	/**Your personal API key*/
	private String key = "YOUR API KEY";
	
	/**The desired region*/
	private String region = ""; 
	
	/**The desired season*/
	private String season = "";
	
	/**Constructor*/
	public RiotAPI() {
		
	}
	
	/**Constructor*/
	public RiotAPI(String key) {
		
		this.setKey(key);
	}
	
	/**Constructor*/
	public RiotAPI(String key, String region) {
		
		this.setKey(key);
		this.setRegion(region);
	}
	
	/**
	 * Get all the champions for a set region
	 * @return A list of all the champions for the set region
	 * @see ChampionList
	 */
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
	
	/**
	 * Get all the champions for a given region
	 * @param region The desired region
	 * @return A list of all the champions for the set region
	 * @see ChampionList
	 */
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
    
	/**
	 * Get all the champions for a set region
	 * @param freeToPlay Only free to play
	 * @return 
	 * A list of all the free to play champions for the set region when freeToPlay is true
	 * A list of all the champions for the set region when freeToPlay is false
	 * @see ChampionList
	 * 
	 */
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
	
	/**
	 * Get all champions for a given region
	 * @param region The desired region
	 * @param freeToPlay Only free to play
	 * @return
	 * A list of all the free to play champions for the given region when freeToPlay is true
	 * A list of all the champions for the given region when freeToPlay is false
	 * @see ChampionList
	 */
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
	
	/**
	 * Get all free to play champions for a given region
	 * @param region The desired region
	 * @return A list of all the free to play champions for the given region
	 * @see ChampionList
	 */
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
	
	/**
	 * Get all free to play champions for a set region
	 * @return A list of all the free to play champions for the set region
	 * @see ChampionList
	 */
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
	
	/**
	 * Get recent games for a given summoner
	 * @param region The desired region
	 * @param summonerId The ID of the desired summoner
	 * @return Recent games of the given summoner
	 * @see RecentGames
	 */
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
	
	/**
	 * Get recent games for a given summoner
	 * @param summonerId The ID of the desired summoner
	 * @return Recent games of the given summoner
	 * @see RecentGames
	 */
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
	
	/**
	 * Get leagues of a given summoner
	 * @param region The desired region
	 * @param summonerId The ID of the desired summoner
	 * @return A map of leagues the given summoner belongs to
	 * @see League
	 */
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
	
	/**
	 * Get leagues of a given summoner
	 * @param summonerId The ID of the desired summoner
	 * @return A map of leagues the given summoner belongs to
	 * @see League
	 */
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
	
	/**
	 * Get a summary of player statistics for a given summoner
	 * @param region The desired region
	 * @param summonerId The ID of the desired summoner
	 * @param season The desired season
	 * @return A summary of player statistics for the given summoner
	 * @see PlayerStatsSummaryList
	 */
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
	
	/**
	 * Get a summary of player statistics for a given summoner
	 * @param summonerId The ID of the desired summoner
	 * @param season The desired season
	 * @return A summary of player statistics for the given summoner
	 * @see PlayerStatsSummaryList
	 */
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
	
	/**
	 * Get a summary of player statistics for a given summoner
	 * @param region The desired region
	 * @param summonerId The ID of the desired summoner
	 * @return A summary of player statistics for the given summoner
	 * @see PlayerStatsSummaryList
	 */
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
	
	/**
	 * Get a summary of player statistics for a given summoner
	 * @param summonerId The ID of the desired summoner
	 * @return A summary of player statistics for the given summoner
	 * @see PlayerStatsSummaryList
	 */
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
	
	/**
	 * Get the ranked statistics of a given summoner
	 * @param region The desired region
	 * @param summonerId The ID of the desired summoner
	 * @param season The desired season
	 * @return Ranked statistics of the given summoner
	 * @see RankedStats
	 */
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
	
	/**
	 * Get the ranked statistics of a given summoner
	 * @param summonerId The ID of the desired summoner
	 * @param season The desired season
	 * @return Ranked statistics of the given summoner
	 * @see RankedStats
	 */
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
	
	/**
	 * Get the ranked statistics of a given summoner
	 * @param region The desired region
	 * @param summonerId The ID of the desired summoner
	 * @return Ranked statistics of the given summoner
	 * @see RankedStats
	 */
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
	
	/**
	 * Get the ranked statistics of a given summoner
	 * @param summonerId The ID of the desired summoner
	 * @return Ranked statistics of the given summoner
	 * @see RankedStats
	 */
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
	
	/**
	 * Get the mastery pages of a given summoner
	 * @param region The desired region
	 * @param summonerId The ID of the desired summoner
	 * @return Mastery pages of the given summoner
	 * @see MasteryPages
	 */
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
	
	/**
	 * Get the mastery pages of a given summoner
	 * @param summonerId The ID of the desired summoner
	 * @return Mastery pages of the given summoner
	 * @see MasteryPages
	 */
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
	
	/**
	 * Get the rune pages of a given summoner
	 * @param region The desired region
	 * @param summonerId The ID of the desired summoner
	 * @return Rune pages of the given summoner
	 * @see RunePages
	 */
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
	
	/**
	 * Get the rune pages of a given summoner
	 * @param summonerId The ID of the desired summoner
	 * @return Rune pages of the given summoner
	 * @see RunePages
	 */
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
	
	/**
	 * Get a summoner by name
	 * @param region The desired region
	 * @param name The name of the desired summoner
	 * @return The desired summoner
	 * @see Summoner
	 */
	public Summoner getSummoner(String region, String name) {
		
		name = name.replaceAll("\\s+", "");
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
	
	/**
	 * Get a summoner by name
	 * @param name The name of the desired summoner
	 * @return The desired summoner
	 * @see Summoner
	 */
	public Summoner getSummoner(String name) {
		
		name = name.replaceAll("\\s+", "");
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
	
	/**
	 * Get a summoner by ID
	 * @param region The desired region
	 * @param summonerId The ID of the desired summoner
	 * @return The desired summoner
	 * @see Summoner
	 */
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
	
	/**
	 * Get a summoner by ID
	 * @param summonerId The ID of the desired summoner
	 * @return The desired summoner
	 * @see Summoner
	 */
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
	
	/**
	 * Get summoner names by IDs
	 * @param region The desired region
	 * @param summonerIds The IDs of the desired summoners
	 * @return A list of desired summoner names
	 * @see SummonerNameList
	 */
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
	
	/**
	 * Get summoner names by IDs
	 * @param summonerIds The IDs of the desired summoners
	 * @return A list of desired summoner names
	 * @see SummonerNameList
	 */
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
	
	/**
	 * Get teams of a given summoner
	 * @param region The desired region
	 * @param summonerId The ID of the desired summoner
	 * @return The teams the given summoner is a member of
	 * @see Team
	 */
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
	
	/**
	 * Get teams of a given summoner
	 * @param summonerId The desired summoner
	 * @return The teams the given summoner is a member of
	 * @see Team
	 */
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
	
	/**
	 * Get the currently set season
	 * @return The currently set season
	 */
	public String getSeason() {
		if(season.equals("")) {
			try {
				throw new Exception("No season was set.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return season;
	}
	
	/**
	 * Get the currently set API key
	 * @return The currently set API key
	 */
	public String getKey() {
		if(key.equals("YOUR API KEY")) {
			try {
				throw new Exception("No key was set.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return key;
	}
	
	/**
	 * Get the currently set region
	 * @return The currently set region
	 */
	public String getRegion() {
		if(region.equals("")) {
			try {
				throw new Exception("No region was set.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return region;
	}
	
	/**
	 * Set the season
	 * @param season The season to set
	 */
	public void setSeason(String season) {
		this.season = season;
	}
	
	/**
	 * Set the API key
	 * @param key The API key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
	
	/**
	 * Set the region
	 * @param region The region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	
	/**
	 * Get the base URL for all API requests
	 * @return The base URL for all API requests
	 */
	public String getBaseURL() {
		return baseURL;
	}

}
