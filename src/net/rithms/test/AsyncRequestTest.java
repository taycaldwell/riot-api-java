package net.rithms.test;

import java.util.Map;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RateLimitException;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;
import net.rithms.riot.api.endpoints.summoner.methods.GetSummonersByName;
import net.rithms.riot.api.request.AsyncRequest;
import net.rithms.riot.api.request.Request;
import net.rithms.riot.api.request.RequestListener;
import net.rithms.riot.constant.Region;

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
		new AsyncRequest(config, new GetSummonersByName(config, Region.EUW, "linnun,jszeus")).setListener(this);
		try {
			// Test Cancel
//			Thread.sleep(20);
//			request.cancel();
			System.out.println("waiting now");
//			request.await();
			for (int i = 0; i < 10; i++) {
				System.out.println(i);
				Thread.sleep(100);
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
			Map<String, Summoner> dto = request.getDto();
			for(String s : dto.keySet()){
				System.out.println(s + " - " + dto.get(s).getId());
			}
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