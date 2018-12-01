/*
 * Copyright 2016-2017 Taylor Caldwell
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

package net.rithms.test.sync;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;
import net.rithms.riot.constant.Platform;
import net.rithms.test.RiotApiTest;

/**
 * Tests synchronous calls to the summoner endpoint
 */
public class SummonerTest {

	private static RiotApi api = null;

	@BeforeClass
	public static void prepareApi() {
		api = RiotApiTest.getRiotApi();
	}

	@Test
	public void testGetSummoner() throws RiotApiException {
		// TODO This test is currently expected to fail, due to summonerIds being encrypted differently for each app.
		Summoner summoner = api.getSummoner(Platform.NA, "81439110");
		assertNotNull(summoner);
		assertEquals("Tryndamere", summoner.getName());
	}

	@Test
	public void testGetSummonerByAccount() throws RiotApiException {
		// TODO This test is currently expected to fail, due to summonerIds being encrypted differently for each app.
		Summoner summoner = api.getSummonerByAccount(Platform.NA, "235464896");
		assertNotNull(summoner);
		assertEquals("Tryndamere", summoner.getName());
	}

	@Test
	public void testGetSummonerByName() throws RiotApiException {
		// TODO This test is currently expected to fail, due to summonerIds being encrypted differently for each app.
		Summoner summoner = api.getSummonerByName(Platform.NA, "tryndamere");
		assertNotNull(summoner);
		assertEquals("81439110", summoner.getId());
	}
}
