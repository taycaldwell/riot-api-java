package net.rithms.test;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiAsync;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.champion.dto.Champion;
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
		ApiConfig config = new ApiConfig().setKey("API-KEY-HERE");
		RiotApi api = new RiotApi(config);
		try {
			long l1 = System.currentTimeMillis();
			Champion x = api.getChampionById(Region.NA, 117);
			Champion y = api.getChampionById(Region.NA, 222);
			Champion z = api.getChampionById(Region.NA, 412);
			System.out.println(x.getId() + " - " + y.getId() + " - " + z.getId());
			long l2 = System.currentTimeMillis();
			System.out.println("sync time to get 3 champs: " + (l2 - l1) + "ms");

			RiotApiAsync apiAsync = api.getAsyncApi();
			long l3 = System.currentTimeMillis();
			AsyncRequest r1 = apiAsync.getChampionById(Region.NA, 117);
			AsyncRequest r2 = apiAsync.getChampionById(Region.NA, 222);
			AsyncRequest r3 = apiAsync.getChampionById(Region.NA, 412);
			r1.await();
			r2.await();
			r3.await();
			Champion c1 = r1.getDto();
			Champion c2 = r2.getDto();
			Champion c3 = r3.getDto();
			System.out.println(c1.getId() + " - " + c2.getId() + " - " + c3.getId());
			long l4 = System.currentTimeMillis();
			System.out.println("async time to get 3 champs: " + (l4 - l3) + "ms");
		} catch (RiotApiException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}