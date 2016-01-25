package net.rithms.test;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RateLimitException;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.request.AsyncRequest;
import net.rithms.riot.api.request.Request;
import net.rithms.riot.api.request.RequestListener;
import net.rithms.riot.dto.Match.MatchDetail;

/**
 * this is not a junit test, only WIP code to test WIP features
 */
class AsyncRequestTest implements RequestListener {

	public static void main(String[] args) {
		new AsyncRequestTest();
	}

	AsyncRequestTest() {
		ApiConfig config = new ApiConfig().setKey("API-KEY-HERE");
		// Test Timeout
//		config.setTimeout(50);
		AsyncRequest request = new AsyncRequest(config);
		request.addApiKeyToUrl();
		// Test Success
		request.setUrlBase("https://euw.api.pvp.net/api/lol/euw/v2.2/match/2000000000");
		// Test Error
//		request.setUrlBase("https://euw.api.pvp.net/api/lol/euw/v2.2/match/5000000000");
		request.setListener(this);
		request.execute();
		try {
			// Test Cancel
//			Thread.sleep(20);
//			request.cancel();
			System.out.println("waiting now");
			request.await();
			for (int i = 0; i < 10; i++) {
				System.out.println(i);
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onRequestSucceeded(Request request) {
		System.out.println("success");
		try {
			MatchDetail dto = request.getDto(MatchDetail.class);
			System.out.println("matchid: " + dto.getMatchId());
		} catch (RateLimitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RiotApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
	}

	@Override
	public void onRequestFailed(Exception e) {
		System.out.println("fail");
		e.printStackTrace();
		// TODO Auto-generated method stub
	}

	@Override
	public void onRequestTimeout(Request request) {
		System.out.println("timeout");
		// TODO Auto-generated method stub
	}
}