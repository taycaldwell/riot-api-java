import java.util.Set;
import java.util.logging.Level;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiAsync;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.league.constant.LeagueQueue;
import net.rithms.riot.api.endpoints.league.dto.LeaguePosition;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;
import net.rithms.riot.api.request.AsyncRequest;
import net.rithms.riot.api.request.RequestAdapter;
import net.rithms.riot.constant.Platform;

/**
 * This example demonstrates how to use asynchronous requests. In this example we get a summoner's base information, as well as league
 * information asynchronously. Requesting these information asynchronously can save a lot of time, since the requests do not block each
 * other.
 */
public class AsyncExample {

	public static void main(String[] args) throws RiotApiException {
		new AsyncExample();
	}

	// Inner class to store information in
	private class ExtendedSummoner {
		public Summoner summoner;
		public LeaguePosition leagueSolo;
		public LeaguePosition leagueFlexSR;
		public LeaguePosition leagueFlexTT;
	}

	public AsyncExample() throws RiotApiException {
		ApiConfig config = new ApiConfig().setKey("YOUR-API-KEY-HERE");
		RiotApi api = new RiotApi(config);
		RiotApiAsync apiAsync = api.getAsyncApi();

		// TODO need to rewrite this example to properly work with v4 endpoints
		String summonerId = "20987694"; // Encrypted summonerId to request
		Platform platform = Platform.EUW; // platform to request
		final ExtendedSummoner eSummoner = new ExtendedSummoner(); // Object where we want to store the data

		// Asynchronously get summoner information
		AsyncRequest requestSummoner = apiAsync.getSummoner(platform, summonerId);
		requestSummoner.addListeners(new RequestAdapter() {
			@Override
			public void onRequestSucceeded(AsyncRequest request) {
				eSummoner.summoner = request.getDto();
			}
		});

		// Asynchronously get league information
		AsyncRequest requestLeague = apiAsync.getLeaguePositionsBySummonerId(platform, summonerId);
		requestLeague.addListeners(new RequestAdapter() {
			@Override
			public void onRequestSucceeded(AsyncRequest request) {
				Set<LeaguePosition> leaguePositions = request.getDto();
				if (leaguePositions == null || leaguePositions.isEmpty()) {
					return;
				}
				for (LeaguePosition leaguePosition : leaguePositions) {
					if (leaguePosition.getQueueType().equals(LeagueQueue.RANKED_SOLO_5x5.name())) {
						eSummoner.leagueSolo = leaguePosition;
					} else if (leaguePosition.getQueueType().equals(LeagueQueue.RANKED_FLEX_SR.name())) {
						eSummoner.leagueFlexSR = leaguePosition;
					} else if (leaguePosition.getQueueType().equals(LeagueQueue.RANKED_FLEX_TT.name())) {
						eSummoner.leagueFlexTT = leaguePosition;
					}
				}
			}
		});

		try {
			// Wait for all asynchronous requests to finish
			apiAsync.awaitAll();
		} catch (InterruptedException e) {
			// We can use the Api's logger
			RiotApi.log.log(Level.SEVERE, "Waiting Interrupted", e);
		}

		// Print information stored in eSummoner
		System.out.println("Summoner name: " + eSummoner.summoner.getName());

		System.out.print("Solo Rank: ");
		if (eSummoner.leagueSolo == null) {
			System.out.println("unranked");
		} else {
			System.out.println(eSummoner.leagueSolo.getTier() + " " + eSummoner.leagueSolo.getRank());
		}

		System.out.print("Flex SR Rank: ");
		if (eSummoner.leagueFlexSR == null) {
			System.out.println("unranked");
		} else {
			System.out.println(eSummoner.leagueFlexSR.getTier() + " " + eSummoner.leagueFlexSR.getRank());
		}

		System.out.print("Flex TT Rank: ");
		if (eSummoner.leagueFlexTT == null) {
			System.out.println("unranked");
		} else {
			System.out.println(eSummoner.leagueFlexTT.getTier() + " " + eSummoner.leagueFlexTT.getRank());
		}
	}
}