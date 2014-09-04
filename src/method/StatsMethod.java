package method;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import dto.Stats.PlayerStatsSummaryList;
import dto.Stats.RankedStats;

public final class StatsMethod {

	/**
	 * Get a summary of player statistics for a given summoner
	 * @param region The desired region
	 * @param summonerId The ID of the desired summoner
	 * @param season The desired season
	 * @return A summary of player statistics for the given summoner
	 * @see PlayerStatsSummaryList
	 */
	public static PlayerStatsSummaryList getPlayerStatsSummary(String endpoint, String region, String season, String key, long summonerId) {
		
		String url = endpoint + "/api/lol/" + region + "/v1.3/stats/by-summoner/" + summonerId + "/summary?season=" + season + "&api_key=" + key;
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
	public static RankedStats getRankedStats(String endpoint, String region, String season, String key, long summonerId) {
		
		String url = endpoint + "/api/lol/" + region + "/v1.3/stats/by-summoner/" + summonerId + "/ranked?season=" + season + "&api_key=" + key;
	    RankedStats rankedStats = null;

			try {
				rankedStats = new Gson().fromJson(IOUtils.toString(new URL(url)), RankedStats.class);
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
	    
	    return rankedStats;
	}
	
}
