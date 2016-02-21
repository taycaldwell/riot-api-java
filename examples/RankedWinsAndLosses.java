import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.stats.dto.AggregatedStats;
import net.rithms.riot.api.endpoints.stats.dto.RankedStats;
import net.rithms.riot.constant.Region;

/**
 * This is a simple example using the RiotApi to request summoner information for a few given summoner names
 */
public class RankedWinsAndLosses {

	public static void main(String[] args) throws RiotApiException {
		ApiConfig config = new ApiConfig().setKey("YOUR-API-KEY-HERE");
		RiotApi api = new RiotApi(config);

		RankedStats rankedStats = api.getRankedStats(Region.EUW, 33481164);
		// We can either get stats for a certain champion (by ID), or use 0 to get combined stats for all champions
		AggregatedStats allChampionsStats = rankedStats.getChampions().get(0).getStats();
		int wins = allChampionsStats.getTotalSessionsWon();
		int losses = allChampionsStats.getTotalSessionsLost();
		System.out.println("Wins: " + wins);
		System.out.println("Losses: " + losses);
	}
}