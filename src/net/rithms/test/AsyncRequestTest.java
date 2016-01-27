package net.rithms.test;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiAsync;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.match.dto.MatchDetail;
import net.rithms.riot.api.request.AsyncRequest;
import net.rithms.riot.constant.Region;

/**
 * this is not a junit test, only WIP code to test WIP features
 */
class AsyncRequestTest {

	public static void main(String[] args) {
		new AsyncRequestTest();
	}

	AsyncRequestTest() {
		ApiConfig config = new ApiConfig().setKey("API-KEY-HERE").setMaxAsyncThreads(3);
		RiotApi api = new RiotApi(config);
		try {
			long l1 = System.currentTimeMillis();
			MatchDetail m1 = api.getMatch(Region.EUW, 2000000000);
			MatchDetail m2 = api.getMatch(Region.EUW, 2000000000);
			MatchDetail m3 = api.getMatch(Region.EUW, 2000000000);
			System.out.println(m1.getMatchId() + " - " + m2.getMatchId() + " - " + m3.getMatchId());
			long l2 = System.currentTimeMillis();
			System.out.println("sync time to get 3 matches: " + (l2 - l1) + "ms");

			RiotApiAsync apiAsync = api.getAsyncApi();
			long l3 = System.currentTimeMillis();
			AsyncRequest r1 = apiAsync.getMatch(Region.EUW, 2000000000);
			AsyncRequest r2 = apiAsync.getMatch(Region.EUW, 2000000000);
			AsyncRequest r3 = apiAsync.getMatch(Region.EUW, 2000000000);
			r1.await();
			r2.await();
			r3.await();
			MatchDetail m4 = r1.getDto();
			MatchDetail m5 = r2.getDto();
			MatchDetail m6 = r3.getDto();
			System.out.println(m4.getMatchId() + " - " + m5.getMatchId() + " - " + m6.getMatchId());
			long l4 = System.currentTimeMillis();
			System.out.println("async time to get 3 matches: " + (l4 - l3) + "ms");
		} catch (RiotApiException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}