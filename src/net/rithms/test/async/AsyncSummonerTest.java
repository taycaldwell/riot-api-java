/*
 * Copyright 2016 Taylor Caldwell
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

package net.rithms.test.async;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import net.rithms.riot.api.RiotApiAsync;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.summoner.dto.MasteryPages;
import net.rithms.riot.api.endpoints.summoner.dto.RunePages;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;
import net.rithms.riot.api.request.AsyncRequest;
import net.rithms.riot.api.request.RequestListener;
import net.rithms.riot.constant.Region;
import net.rithms.test.RiotApiTest;

/**
 * Tests asynchronous calls to the summoner endpoint
 */
public class AsyncSummonerTest {

	private static RiotApiAsync api = null;

	@BeforeClass
	public static void prepareApi() {
		api = RiotApiTest.getRiotApiAsync();
	}

	@Test
	public void testGetMasteryPages() throws RiotApiException, InterruptedException {
		AsyncRequest reqMasteryPages = api.getMasteryPages(Region.NA, 133);
		reqMasteryPages.addListener(new RequestListener() {
			@Override
			public void onRequestFailed(RiotApiException e) {
				fail();
			}

			@Override
			public void onRequestSucceeded(AsyncRequest request) {
				Map<String, MasteryPages> masteryPages = request.getDto();
				assertNotNull(masteryPages);
				assertEquals(133, masteryPages.get("133").getSummonerId());
			}

			@Override
			public void onRequestTimeout(AsyncRequest request) {
				fail();
			}
		});
		api.awaitAll();
	}

	@Test
	public void testGetRunePages() throws RiotApiException, InterruptedException {
		AsyncRequest reqRunePages = api.getRunePages(Region.NA, 133);
		reqRunePages.addListener(new RequestListener() {
			@Override
			public void onRequestFailed(RiotApiException e) {
				fail();
			}

			@Override
			public void onRequestSucceeded(AsyncRequest request) {
				Map<String, RunePages> runePages = request.getDto();
				assertNotNull(runePages);
				assertEquals(133, runePages.get("133").getSummonerId());
			}

			@Override
			public void onRequestTimeout(AsyncRequest request) {
				fail();
			}
		});
		api.awaitAll();
	}

	@Test
	public void testGetSummonersById() throws RiotApiException, InterruptedException {
		AsyncRequest reqSummonerMap = api.getSummonersById(Region.NA, 133, 329);
		reqSummonerMap.addListener(new RequestListener() {
			@Override
			public void onRequestFailed(RiotApiException e) {
				fail();
			}

			@Override
			public void onRequestSucceeded(AsyncRequest request) {
				Map<String, Summoner> summoners = request.getDto();
				assertNotNull(summoners);
				assertEquals("Tryndamere", summoners.get("133").getName());
				assertEquals("Ryze", summoners.get("329").getName());
			}

			@Override
			public void onRequestTimeout(AsyncRequest request) {
				fail();
			}
		});
		api.awaitAll();
	}

	@Test
	public void testGetSummonersByName() throws RiotApiException, InterruptedException {
		AsyncRequest reqSummonerMap = api.getSummonersByName(Region.NA, "ryze", "tryndamere");
		reqSummonerMap.addListener(new RequestListener() {
			@Override
			public void onRequestFailed(RiotApiException e) {
				fail();
			}

			@Override
			public void onRequestSucceeded(AsyncRequest request) {
				Map<String, Summoner> summoners = request.getDto();
				assertNotNull(summoners);
				assertEquals(329, summoners.get("ryze").getId());
				assertEquals(133, summoners.get("tryndamere").getId());
			}

			@Override
			public void onRequestTimeout(AsyncRequest request) {
				fail();
			}
		});
		api.awaitAll();
	}

	@Test
	public void testGetSummonerNames() throws RiotApiException, InterruptedException {
		AsyncRequest reqSummonerNameMap = api.getSummonerNames(Region.NA, 133, 329);
		reqSummonerNameMap.addListener(new RequestListener() {
			@Override
			public void onRequestFailed(RiotApiException e) {
				fail();
			}

			@Override
			public void onRequestSucceeded(AsyncRequest request) {
				Map<String, String> summoners = request.getDto();
				assertNotNull(summoners);
				assertEquals("Tryndamere", summoners.get("133"));
				assertEquals("Ryze", summoners.get("329"));
			}

			@Override
			public void onRequestTimeout(AsyncRequest request) {
				fail();
			}
		});
		api.awaitAll();
	}
}