/*********************************
riot-api-java
----------------------------------
Riot Games API Java Library
by Taylor Caldwell - @taycaldwell
********************************/

package main.java.riotapi;

import java.io.IOException;
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
	private final String baseURL = "https://prod.api.pvp.net/api/lol/";
	
	/**Your personal API key*/
	private String key;
	
	/**The desired region*/
	private String region; 
	
	/**The desired season*/
	private String season;
	
	/**Constructor*/
	public RiotAPI() {}
	
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
			} catch (JsonSyntaxException | IOException e) {
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
			} catch (JsonSyntaxException | IOException e) {
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
			} catch (JsonSyntaxException | IOException e) {
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
			} catch (JsonSyntaxException | IOException e) {
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
			} catch (JsonSyntaxException | IOException e) {
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
			} catch (JsonSyntaxException | IOException e) {
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
		
		String url = getBaseURL() + region + "/v1.3/game/by-summoner/" + summonerId + "/recent?api_key=" + getKey();
	    RecentGames recentGames = null;

			try {
				recentGames = new Gson().fromJson(IOUtils.toString(new URL(url)), RecentGames.class);
			} catch (JsonSyntaxException | IOException e) {
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
		
		String url = getBaseURL() + getRegion() + "/v1.3/game/by-summoner/" + summonerId + "/recent?api_key=" + getKey();
	    RecentGames recentGames = null;

			try {
				recentGames = new Gson().fromJson(IOUtils.toString(new URL(url)), RecentGames.class);
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
    
	    return recentGames;
	}
	
	/**
	 * Get leagues of a given summoner
	 * @param region The desired region
	 * @param summonerId The ID of the desired summoner
	 * @return A list of leagues the given summoner belongs to
	 * @see League
	 */
	public List<League> getLeagues(String region, long summonerId) {
		
		String url = getBaseURL() + region + "/v2.2/league/by-summoner/" + summonerId + "?api_key=" + getKey();
	    List<League> leagues = null;

			try {
				leagues = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<List<League>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}

	    return leagues;
	}
	
	/**
	 * Get leagues of a given summoner
	 * @param summonerId The ID of the desired summoner
	 * @return A list of leagues the given summoner belongs to
	 * @see League
	 */
	public List<League> getLeagues(long summonerId) {
		
		String url = getBaseURL() + getRegion() + "/v2.2/league/by-summoner/" + summonerId + "?api_key=" + getKey();
	    List<League> leagues = null;

			try {
				leagues = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<List<League>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
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
			} catch (JsonSyntaxException | IOException e) {
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
			} catch (JsonSyntaxException | IOException e) {
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
			} catch (JsonSyntaxException | IOException e) {
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
			} catch (JsonSyntaxException | IOException e) {
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
			} catch (JsonSyntaxException | IOException e) {
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
			} catch (JsonSyntaxException | IOException e) {
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
			} catch (JsonSyntaxException | IOException e) {
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
			} catch (JsonSyntaxException | IOException e) {	
				e.printStackTrace();
			}

	    return rankedStats;
	}
	
	/**
	 * Get the mastery pages of a given summoner
	 * @param region The desired region
	 * @param summonerIds The IDs of the desired summoners
	 * @return A map of mastery pages of the given summoners
	 * @see MasteryPages
	 */
	public Map<String, MasteryPages> getMasteryPages(String region, String summonerIds) {
		
		String url = getBaseURL() + region + "/v1.3/summoner/" + summonerIds + "/masteries?api_key=" + getKey();
	    Map<String, MasteryPages> masteryPages = null;

			try {
				masteryPages = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, MasteryPages>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}

	    return masteryPages;
	}
	
	
	/**
	 * Get the mastery pages of a given summoner
	 * @param summonerIds The IDs of the desired summoners
	 * @return A map of mastery pages of the given summoners
	 * @see MasteryPages
	 */
	public Map<String, MasteryPages> getMasteryPages(String summonerIds) {
		
		String url = getBaseURL() + getRegion() + "/v1.3/summoner/" + summonerIds + "/masteries?api_key=" + getKey();
	    Map<String, MasteryPages> masteryPages = null;

			try {
				masteryPages = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, MasteryPages>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}

	    return masteryPages;
	}
	
	/**
	 * Get the mastery pages of a given summoner
	 * @param region The desired region
	 * @param summonerIds The IDs of the desired summoners
	 * @return A map of mastery pages of the given summoners
	 * @see MasteryPages
	 */
	public Map<String, MasteryPages> getMasteryPages(String region, long... summonerIds) {
		
		String url = getBaseURL() + region + "/v1.3/summoner/" + longToString(summonerIds) + "/masteries?api_key=" + getKey();
	    Map<String, MasteryPages> masteryPages = null;

			try {
				masteryPages = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, MasteryPages>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}

	    return masteryPages;
	}
	
	/**
	 * Get the mastery pages of a given summoner
	 * @param summonerIds The IDs of the desired summoners
	 * @return A map of mastery pages of the given summoners
	 * @see MasteryPages
	 */
	public Map<String, MasteryPages> getMasteryPages(long... summonerIds) {
		
		String url = getBaseURL() + getRegion() + "/v1.3/summoner/" + longToString(summonerIds) + "/masteries?api_key=" + getKey();
	    Map<String, MasteryPages> masteryPages = null;

			try {
				masteryPages = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, MasteryPages>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}

	    return masteryPages;
	}
	
	
	/**
	 * Get the rune pages of a given summoner
	 * @param region The desired region
	 * @param summonerIds The IDs of the desired summoners
	 * @return A map of rune pages of the given summoners
	 * @see RunePages
	 */
	public Map<String, RunePages> getRunePages(String region, String summonerIds) {
		
		String url = getBaseURL() + region + "/v1.3/summoner/" + summonerIds + "/runes?api_key=" + getKey();
	    Map<String, RunePages> runePages = null;

			try {
				runePages = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, RunePages>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
		
	    return runePages;
	}
	
	/**
	 * Get the rune pages of a given summoner
	 * @param summonerIds The IDs of the desired summoners
	 * @return A map of rune pages of the given summoners
	 * @see RunePages
	 */
	public Map<String, RunePages> getRunePages(String summonerIds) {
		
		String url = getBaseURL() + getRegion() + "/v1.3/summoner/" + summonerIds + "/runes?api_key=" + getKey();
	    Map<String, RunePages> runePages = null;

			try {
				runePages = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, RunePages>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
		
	    return runePages;
	}
	
	/**
	 * Get the rune pages of a given summoner
	 * @param region The desired region
	 * @param summonerIds The IDs of the desired summoners
	 * @return A map of rune pages of the given summoners
	 * @see RunePages
	 */
	public Map<String, RunePages> getRunePages(String region, long... summonerIds) {
		
		String url = getBaseURL() + region + "/v1.3/summoner/" + longToString(summonerIds) + "/runes?api_key=" + getKey();
	    Map<String, RunePages> runePages = null;

			try {
				runePages = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, RunePages>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
		
	    return runePages;
	}
	
	/**
	 * Get the rune pages of a given summoner
	 * @param summonerIds The IDs of the desired summoners
	 * @return A map of rune pages of the given summoners
	 * @see RunePages
	 */
	public Map<String, RunePages> getRunePages(long... summonerIds) {
		
		String url = getBaseURL() + getRegion() + "/v1.3/summoner/" + longToString(summonerIds) + "/runes?api_key=" + getKey();
	    Map<String, RunePages> runePages = null;

			try {
				runePages = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, RunePages>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
		
	    return runePages;
	}
	
	/**
	 * Get summoners by names
	 * @param region The desired region
	 * @param summonerNames The names of the desired summoners
	 * @return A map of desired summoners
	 * @see Summoner
	 */
	public Map<String, Summoner> getSummonersByName(String region, String summonerNames) {
		
		summonerNames = summonerNames.replaceAll("\\s+", "");
		String url = getBaseURL() + region + "/v1.3/summoner/by-name/" + summonerNames + "?api_key=" + getKey();
		Map<String, Summoner> summoner = null;

			try {
				summoner = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, Summoner>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
    
	    return summoner;
	}
	
	/**
	 * Get summoners by names
	 * @param summonerNames The names of the desired summoners
	 * @return A map of desired summoners
	 * @see Summoner
	 */
	public Map<String, Summoner> getSummonersByName(String summonerNames) {
		
		summonerNames = summonerNames.replaceAll("\\s+", "");
		String url = getBaseURL() + getRegion() + "/v1.3/summoner/by-name/" + summonerNames + "?api_key=" + getKey();
		Map<String, Summoner> summoner = null;

			try {
				summoner = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, Summoner>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
    
	    return summoner;
	}
	
	/**
	 * Get summoner by name
	 * @param region The desired region
	 * @param summonerName The name of the desired summoner
	 * @return A map of desired summoners
	 * @see Summoner
	 */
	public Map<String, Summoner> getSummonerByName(String region, String summonerName) {
		
		summonerName = summonerName.replaceAll("\\s+", "");
		String url = getBaseURL() + region + "/v1.3/summoner/by-name/" + summonerName + "?api_key=" + getKey();
		Map<String, Summoner> summoner = null;

			try {
				summoner = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, Summoner>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
    
	    return summoner;
	}
	
	/**
	 * Get summoner by name
	 * @param summonerName The name of the desired summoner
	 * @return A map of desired summoners
	 * @see Summoner
	 */
	public Map<String, Summoner> getSummonerByName(String summonerName) {
		
		summonerName = summonerName.replaceAll("\\s+", "");
		String url = getBaseURL() + getRegion() + "/v1.3/summoner/by-name/" + summonerName + "?api_key=" + getKey();
		Map<String, Summoner> summoner = null;

			try {
				summoner = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, Summoner>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
    
	    return summoner;
	}
	
	/**
	 * Get summoners by names
	 * @param region The desired region
	 * @param summonerIds The IDs of the desired summoners
	 * @return A map of desired summoners
	 * @see Summoner
	 */
	public Map<String, Summoner> getSummonersById(String region, long... summonerIds) {
			
		String url = getBaseURL() + region + "/v1.3/summoner/" + longToString(summonerIds) + "?api_key=" + getKey();
		Map<String, Summoner> summoner = null;

			try {
				summoner = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, Summoner>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
    
	    return summoner;
	}
	
	/**
	 * Get summoners by names
	 * @param summonerIds The IDs of the desired summoners
	 * @return A map of desired summoners
	 * @see Summoner
	 */
	public Map<String, Summoner> getSummonersById(long... summonerIds) {
		
		String url = getBaseURL() + getRegion() + "/v1.3/summoner/" + longToString(summonerIds) + "?api_key=" + getKey();
		Map<String, Summoner> summoner = null;

			try {
				summoner = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, Summoner>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
    
	    return summoner;
	}
	
	/**
	 * Get summoners by names
	 * @param region The desired region
	 * @param summonerIds The IDs of the desired summoners
	 * @return A map of desired summoners
	 * @see Summoner
	 */
	public Map<String, Summoner> getSummonersById(String region, String summonerIds) {
		
		String url = getBaseURL() + region + "/v1.3/summoner/" + summonerIds + "?api_key=" + getKey();
		Map<String, Summoner> summoner = null;

			try {
				summoner = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, Summoner>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
    
	    return summoner;
	}
	
	/**
	 * Get summoners by names
	 * @param summonerIds The IDs of the desired summoners
	 * @return A map of desired summoners
	 * @see Summoner
	 */
	public Map<String, Summoner> getSummonersById(String summonerIds) {
		
		String url = getBaseURL() + getRegion() + "/v1.3/summoner/" + summonerIds + "?api_key=" + getKey();
		Map<String, Summoner> summoner = null;

			try {
				summoner = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, Summoner>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
    
	    return summoner;
	}
	
	/**
	 * Get summoners by names
	 * @param region The desired region
	 * @param summonerId The ID of the desired summoner
	 * @return A map of desired summoners
	 * @see Summoner
	 */
	public Map<String, Summoner> getSummonerById(String region, long summonerId) {
			
		String url = getBaseURL() + region + "/v1.3/summoner/" + longToString(summonerId) + "?api_key=" + getKey();
		Map<String, Summoner> summoner = null;

			try {
				summoner = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, Summoner>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
    
	    return summoner;
	}
	
	/**
	 * Get summoners by names
	 * @param summonerId The IDs of the desired summoners
	 * @return A map of desired summoners
	 * @see Summoner
	 */
	public Map<String, Summoner> getSummonerById(long summonerId) {
		
		String url = getBaseURL() + getRegion() + "/v1.3/summoner/" + longToString(summonerId) + "?api_key=" + getKey();
		Map<String, Summoner> summoner = null;

			try {
				summoner = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, Summoner>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
    
	    return summoner;
	}
	
	/**
	 * Get summoners by names
	 * @param region The desired region
	 * @param summonerIds The IDs of the desired summoners
	 * @return A map of desired summoners
	 * @see Summoner
	 */
	public Map<String, Summoner> getSummonerById(String region, String summonerId) {
		
		String url = getBaseURL() + region + "/v1.3/summoner/" + summonerId + "?api_key=" + getKey();
		Map<String, Summoner> summoner = null;

			try {
				summoner = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, Summoner>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
    
	    return summoner;
	}
	
	/**
	 * Get summoners by names
	 * @param summonerId The IDs of the desired summoners
	 * @return A map of desired summoners
	 * @see Summoner
	 */
	public Map<String, Summoner> getSummonerById(String summonerId) {
		
		String url = getBaseURL() + getRegion() + "/v1.3/summoner/" + summonerId + "?api_key=" + getKey();
		Map<String, Summoner> summoner = null;

			try {
				summoner = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, Summoner>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
    
	    return summoner;
	}
	
	/**
	 * Get summoner names by IDs
	 * @param region The desired region
	 * @param summonerIds The IDs of the desired summoners
	 * @return A map of desired summoner names
	 */
	public Map<String, String> getSummonerNames(String region, long... summonerIds){
	
		String url = getBaseURL() + region + "/v1.3/summoner/" + longToString(summonerIds) + "/name?api_key=" + getKey();
		Map<String, String> summonerNameList = null;

			try {
				summonerNameList = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, String>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
    
	    return summonerNameList;
	}
	
	/**
	 * Get summoner names by IDs
	 * @param summonerIds The IDs of the desired summoners
	 * @return A map of desired summoner names
	 */
	public Map<String, String> getSummonerNames(long... summonerIds){
	
		String url = getBaseURL() + getRegion() + "/v1.3/summoner/" + longToString(summonerIds) + "/name?api_key=" + getKey();
		Map<String, String> summonerNameList = null;

			try {
				summonerNameList = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, String>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
    
	    return summonerNameList;
	}
	
	/**
	 * Get summoner names by IDs
	 * @param region The desired region
	 * @param summonerIds A comma separated list of IDs of the desired summoners
	 * @return A map of desired summoner names
	 */
	public Map<String, String> getSummonerNames(String region, String summonerIds){
		
		String url = getBaseURL() + region + "/v1.3/summoner/" + summonerIds + "/name?api_key=" + getKey();
		Map<String, String> summonerNameList = null;

			try {
				summonerNameList = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, String>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
    
	    return summonerNameList;
	}
	
	/**
	 * Get summoner names by IDs
	 * @param summonerIds A comma separated list of IDs of the desired summoners
	 * @return A map of desired summoner names
	 */
	public Map<String, String> getSummonerNames(String summonerIds){
		
		String url = getBaseURL() + getRegion() + "/v1.3/summoner/" + summonerIds + "/name?api_key=" + getKey();
		Map<String, String> summonerNameList = null;

			try {
				summonerNameList = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, String>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
    
	    return summonerNameList;
	}
	
	/**
	 * Get summoner names by IDs
	 * @param region The desired region
	 * @param summonerId The IDs of the desired summoner
	 * @return A map of desired summoner names
	 */
	public Map<String, String> getSummonerName(String region, long summonerId){
	
		String url = getBaseURL() + region + "/v1.3/summoner/" + longToString(summonerId) + "/name?api_key=" + getKey();
		Map<String, String> summonerNameList = null;

			try {
				summonerNameList = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, String>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
    
	    return summonerNameList;
	}
	
	/**
	 * Get summoner names by IDs
	 * @param summonerId The IDs of the desired summoner
	 * @return A map of desired summoner names
	 */
	public Map<String, String> getSummonerName(long summonerId){
	
		String url = getBaseURL() + getRegion() + "/v1.3/summoner/" + longToString(summonerId) + "/name?api_key=" + getKey();
		Map<String, String> summonerNameList = null;

			try {
				summonerNameList = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, String>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
    
	    return summonerNameList;
	}
	
	/**
	 * Get summoner names by IDs
	 * @param region The desired region
	 * @param summonerId The ID of the desired summoner
	 * @return A map of desired summoner names
	 */
	public Map<String, String> getSummonerName(String region, String summonerId){
		
		String url = getBaseURL() + region + "/v1.3/summoner/" + summonerId + "/name?api_key=" + getKey();
		Map<String, String> summonerNameList = null;

			try {
				summonerNameList = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, String>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
    
	    return summonerNameList;
	}
	
	/**
	 * Get summoner names by IDs
	 * @param summonerIds The ID of the desired summoner
	 * @return A map of desired summoner names
	 */
	public Map<String, String> getSummonerName(String summonerId){
		
		String url = getBaseURL() + getRegion() + "/v1.3/summoner/" + summonerId + "/name?api_key=" + getKey();
		Map<String, String> summonerNameList = null;

			try {
				summonerNameList = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<Map<String, String>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
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
			} catch (JsonSyntaxException | IOException e) {
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
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
	
	    return teamList;
	}
	
	private String longToString(long... summonerIds){
		String ids = "";
		for(int i = 0; i < summonerIds.length; i++){
			if(i != (summonerIds.length - 1)){ ids = ids + summonerIds[i] + ", "; }
			else { ids = ids + summonerIds[i]; }
		}
		return ids;
	}
	
	/**
	 * Get the currently set season
	 * @return The currently set season
	 * @throws Exception 
	 */
	public String getSeason() {
		return season;
	}
	
	/**
	 * Get the currently set API key
	 * @return The currently set API key
	 * @throws Exception 
	 */
	public String getKey() {
		return key;
	}
	
	/**
	 * Get the currently set region
	 * @return The currently set region
	 * @throws Exception 
	 */
	public String getRegion() {
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
