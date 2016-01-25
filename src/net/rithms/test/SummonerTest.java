/*
 * Copyright 2014 Taylor Caldwell
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.rithms.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Summoner.MasteryPages;
import net.rithms.riot.dto.Summoner.RunePages;
import net.rithms.riot.dto.Summoner.Summoner;

public class SummonerTest {

	private static RiotApi api = null;

	@BeforeClass
	public static void prepareApi() {
		api = RiotApiTest.getRiotApi();
	}

	@Test
	public void testGetMasteryPages() throws RiotApiException {
		MasteryPages masteryPages = api.getMasteryPages(Region.NA, 133);
		assertNotNull(masteryPages);
		assertEquals(133, masteryPages.getSummonerId());
	}

	@Test
	public void testGetRunePages() throws RiotApiException {
		RunePages runePages = api.getRunePages(Region.NA, 133);
		assertNotNull(runePages);
		assertEquals(133, runePages.getSummonerId());
	}

	@Test
	public void testGetSummonerById() throws RiotApiException {
		Summoner summoner = api.getSummonerById(Region.NA, 133);
		assertNotNull(summoner);
		assertEquals("Tryndamere", summoner.getName());
	}

	@Test
	public void testGetSummonerByName() throws RiotApiException {
		Summoner summoner = api.getSummonerByName(Region.NA, "tryndamere");
		assertNotNull(summoner);
		assertEquals(133, summoner.getId());
	}

	@Test
	public void testGetSummonersById() throws RiotApiException {
		Map<String, Summoner> summoners = api.getSummonersById(Region.NA, 133, 329);
		assertNotNull(summoners);
		assertEquals("Tryndamere", summoners.get("133").getName());
		assertEquals("Ryze", summoners.get("329").getName());
	}

	@Test
	public void testGetSummonersByName() throws RiotApiException {
		Map<String, Summoner> summoners = api.getSummonersByName(Region.NA, "ryze", "tryndamere");
		assertNotNull(summoners);
		assertEquals(329, summoners.get("ryze").getId());
		assertEquals(133, summoners.get("tryndamere").getId());
	}

	@Test
	public void testGetSummonerName() throws RiotApiException {
		String summonerName = api.getSummonerName(Region.NA, 133);
		assertNotNull(summonerName);
		assertEquals("Tryndamere", summonerName);
	}

	@Test
	public void testGetSummonerNames() throws RiotApiException {
		Map<String, String> summoners = api.getSummonerNames(Region.NA, 133, 329);
		assertNotNull(summoners);
		assertEquals("Tryndamere", summoners.get("133"));
		assertEquals("Ryze", summoners.get("329"));
	}
}