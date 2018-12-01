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

package net.rithms.test.async;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;

import net.rithms.riot.api.RiotApiAsync;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;
import net.rithms.riot.api.request.AsyncRequest;
import net.rithms.riot.api.request.RequestListener;
import net.rithms.riot.constant.Platform;
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
	public void testGetSummoners() throws RiotApiException, InterruptedException {
		// TODO This test is currently expected to fail, due to summonerIds being encrypted differently for each app.
		AsyncRequest reqSummonerMap = api.getSummoner(Platform.NA, "81439110");
		reqSummonerMap.addListeners(new RequestListener() {
			@Override
			public void onRequestFailed(RiotApiException e) {
				fail();
			}

			@Override
			public void onRequestSucceeded(AsyncRequest request) {
				Summoner summoner = request.getDto();
				assertNotNull(summoner);
				assertEquals("Tryndamere", summoner.getName());
			}

			@Override
			public void onRequestTimeout(AsyncRequest request) {
				fail();
			}
		});
		api.awaitAll();
	}

	@Test
	public void testGetSummonersByAccount() throws RiotApiException, InterruptedException {
		// TODO This test is currently expected to fail, due to summonerIds being encrypted differently for each app.
		AsyncRequest reqSummonerMap = api.getSummonerByAccount(Platform.NA, "235464896");
		reqSummonerMap.addListeners(new RequestListener() {
			@Override
			public void onRequestFailed(RiotApiException e) {
				fail();
			}

			@Override
			public void onRequestSucceeded(AsyncRequest request) {
				Summoner summoner = request.getDto();
				assertNotNull(summoner);
				assertEquals("Tryndamere", summoner.getName());
			}

			@Override
			public void onRequestTimeout(AsyncRequest request) {
				fail();
			}
		});
		api.awaitAll();
	}

	@Test
	public void testGetSummonerByName() throws RiotApiException, InterruptedException {
		// TODO This test is currently expected to fail, due to summonerIds being encrypted differently for each app.
		AsyncRequest reqSummonerMap = api.getSummonerByName(Platform.NA, "tryndamere");
		reqSummonerMap.addListeners(new RequestListener() {
			@Override
			public void onRequestFailed(RiotApiException e) {
				fail();
			}

			@Override
			public void onRequestSucceeded(AsyncRequest request) {
				Summoner summoner = request.getDto();
				assertNotNull(summoner);
				assertEquals("81439110", summoner.getId());
			}

			@Override
			public void onRequestTimeout(AsyncRequest request) {
				fail();
			}
		});
		api.awaitAll();
	}
}
