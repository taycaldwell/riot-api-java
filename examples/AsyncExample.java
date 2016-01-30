import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiAsync;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.league.dto.League;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;
import net.rithms.riot.api.request.AsyncRequest;
import net.rithms.riot.api.request.SimpleRequestListener;
import net.rithms.riot.constant.Region;

/**
 * This is an example for how to use asynchronous requests. In this example we get a summoner's base information, as well as league
 * information asynchronously. Requesting these information asynchronously saves a lot of time, since the requests do not block each other.
 */
public class AsyncExample {

	public static void main(String[] args) throws RiotApiException {
		new AsyncExample();
	}

	private class ExtendedSummoner {
		public Summoner summoner;
		public League league;
	}

	public AsyncExample() throws RiotApiException {
		long summonerId = 20987694; // summonerId to lookup
		Region region = Region.EUW; // region to lookup
		ExtendedSummoner eSummoner = new ExtendedSummoner(); // Object where we want to store the data

		ApiConfig config = new ApiConfig().setKey("YOUR-API-KEY-HERE");
		RiotApi api = new RiotApi(config);
		RiotApiAsync apiAsync = api.getAsyncApi();

		// Asynchronously get summoner information
		AsyncRequest requestSummoner = apiAsync.getSummonersById(region, summonerId);
		requestSummoner.addListener(new SimpleRequestListener() {
			@Override
			public void onRequestSucceeded(AsyncRequest request) {
				Map<String, Summoner> summoners = request.getDto();
				eSummoner.summoner = summoners.get(String.valueOf(summonerId));
			}
		});
		// Asynchronously get league information
		AsyncRequest requestLeague = apiAsync.getLeagueEntryBySummoners(region, summonerId);
		requestLeague.addListener(new SimpleRequestListener() {
			@Override
			public void onRequestSucceeded(AsyncRequest request) {
				Map<String, List<League>> league = request.getDto();
				eSummoner.league = league.get(String.valueOf(summonerId)).get(0);
			}
		});

		try {
			// Wait for all asynchronous requests to finish
			apiAsync.awaitAll();
		} catch (InterruptedException e) {
			// We can use the Api's logger
			RiotApi.log.log(Level.SEVERE, "Waiting Interrupted", e);
		}

		System.out.println("Summoner name: " + eSummoner.summoner.getName());
		if (eSummoner.league == null) {
			System.out.println("Rank: unranked");
		} else {
			System.out.println("Rank: " + eSummoner.league.getTier());
		}
	}
}