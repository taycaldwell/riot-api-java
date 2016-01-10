package net.rithms.test;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import net.rithms.riot.api.RiotApiException;
import net.rithms.util.Convert;

public class UtilTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testLongToString() throws RiotApiException {
		// Valid Usage
		assertEquals("1", Convert.longToString(1));
		assertEquals("1,2,3", Convert.longToString(1, 2, 3));
		// NullPointerException
		thrown.expect(NullPointerException.class);
		Convert.longToString(null);
	}

	@Test
	public void testNormalizeSummonerName() throws RiotApiException {
		// Valid Usage
		assertEquals("abc", Convert.normalizeSummonerName("A b     C"));
		// NullPointerException
		thrown.expect(NullPointerException.class);
		Convert.normalizeSummonerName(null);
	}

	@Test
	public void testNormalizeSummonerNames() throws RiotApiException {
		// Valid Usage
		String[] s = Convert.normalizeSummonerNames("ab c", "D E F");
		assertEquals("abc", s[0]);
		assertEquals("def", s[1]);
		// NullPointerException
		thrown.expect(NullPointerException.class);
		Convert.normalizeSummonerNames((String[]) null);
	}

	@Test
	public void testJoinString() throws RiotApiException {
		// Valid Usage
		assertEquals("abc", Convert.joinString(",", "abc"));
		assertEquals("abc,def,ghi", Convert.joinString(",", "abc", "def", "ghi"));
		// NullPointerException
		thrown.expect(NullPointerException.class);
		Convert.joinString(null, (CharSequence[]) null);
	}
}