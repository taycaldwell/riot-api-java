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

package net.rithms.test;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.static_data.constant.ChampionTags;
import net.rithms.util.RiotApiUtil;

/**
 * Tests all the utility features provided by the classes in the package {@code net.rithms.util}.
 */
public class UtilTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testNormalizeSummonerName() throws RiotApiException {
		// Valid Usage
		assertEquals("abc", RiotApiUtil.normalizeSummonerName("A b     C"));
		// Test fix for special case characters
		assertEquals("i", RiotApiUtil.normalizeSummonerName("İ"));
		// NullPointerException
		thrown.expect(NullPointerException.class);
		RiotApiUtil.normalizeSummonerName(null);
	}

	@Test
	public void testNormalizeSummonerNames() throws RiotApiException {
		// Valid Usage
		String[] s = RiotApiUtil.normalizeSummonerNames("ab c", "D E F");
		assertEquals("abc", s[0]);
		assertEquals("def", s[1]);
		// NullPointerException
		thrown.expect(NullPointerException.class);
		RiotApiUtil.normalizeSummonerNames((String[]) null);
	}

	@Test
	public void testJoinString() throws RiotApiException {
		// Valid Usage for Strings
		assertEquals("abc", RiotApiUtil.joinString(",", "abc"));
		assertEquals("abc,def,ghi", RiotApiUtil.joinString(",", "abc", "def", "ghi"));
		// Valid Usage for other objects
		assertEquals("RANKED_SOLO_5x5,TEAM_BUILDER_DRAFT_RANKED_5x5", RiotApiUtil.joinString(",", "RANKED_SOLO_5x5", "TEAM_BUILDER_DRAFT_RANKED_5x5"));
		assertEquals("info,lore", RiotApiUtil.joinString(",", ChampionTags.INFO, ChampionTags.LORE));
		// NullPointerException
		thrown.expect(NullPointerException.class);
		RiotApiUtil.joinString(null, (CharSequence[]) null);
	}
	
	@Test
	public void testRequireValidSummonerName() {
		// Latin
		assertEquals("_Fiddlesticks.123", RiotApiUtil.requireValidSummonerName("_Fiddlesticks.123"));
		// Japanese
		assertEquals("日本語を話しますか", RiotApiUtil.requireValidSummonerName("日本語を話しますか"));
		// Korean
		assertEquals("볼리베어브랜드말자하", RiotApiUtil.requireValidSummonerName("볼리베어브랜드말자하"));
		// Russian
		assertEquals("можете ознакомиться", RiotApiUtil.requireValidSummonerName("можете ознакомиться"));
		// Chinese
		assertEquals("综合资讯", RiotApiUtil.requireValidSummonerName("综合资讯"));
		// Arabic
		assertEquals("أنا لا أتكلم العربية", RiotApiUtil.requireValidSummonerName("أنا لا أتكلم العربية"));
		
		thrown.expect(IllegalArgumentException.class);
		RiotApiUtil.requireValidSummonerName("   ");
		RiotApiUtil.requireValidSummonerName("Fiddlesticks,123");
		RiotApiUtil.requireValidSummonerName("Fiddlesticks\f123");
		RiotApiUtil.requireValidSummonerName("Cho'Gath");
	}
	
}