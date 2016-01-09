package net.rithms.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import net.rithms.riot.api.RiotApiException;
import net.rithms.util.Convert;

public class UtilTest {

	@Test
	public void testLongToString() throws RiotApiException {
		assertEquals("1", Convert.longToString(1));
		assertEquals("1,2,3", Convert.longToString(1, 2, 3));
	}

	@Test
	public void testNormalizeSummonerName() throws RiotApiException {
		assertEquals("abc", Convert.normalizeSummonerName("A b     C"));
	}

	@Test
	public void testNormalizeSummonerNames() throws RiotApiException {
		String[] s = Convert.normalizeSummonerNames("ab c", "D E F");
		assertEquals("abc", s[0]);
		assertEquals("def", s[1]);
	}

	@Test
	public void testJoinString() throws RiotApiException {
		assertEquals("abc", Convert.joinString(",", "abc"));
		assertEquals("abc,def,ghi", Convert.joinString(",", "abc", "def", "ghi"));
	}
}