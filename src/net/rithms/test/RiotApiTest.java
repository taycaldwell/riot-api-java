package net.rithms.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import net.rithms.riot.api.RiotApi;

@RunWith(Suite.class)
@SuiteClasses({ UtilTest.class, SummonerTest.class })
public class RiotApiTest {

	private static final String apiKey = "YOUR-API-KEY-HERE";

	static RiotApi getRiotApi() {
		return new RiotApi(apiKey);
	}
}