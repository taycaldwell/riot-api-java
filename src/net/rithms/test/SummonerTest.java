package net.rithms.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Summoner.Summoner;

public class SummonerTest {

	private static RiotApi api = null;

	@BeforeClass
	public static void prepareApi() {
		api = RiotApiTest.getRiotApi();
	}

	@Test
	public void testGetSummonersByName() throws RiotApiException {
		api.setRegion(Region.NA);
		Map<String, Summoner> summoners = api.getSummonersByName("ryze", "tryndamere");
		assertNotNull(summoners);
		assertEquals(329, summoners.get("ryze").getId());
		assertEquals(133, summoners.get("tryndamere").getId());
	}
}