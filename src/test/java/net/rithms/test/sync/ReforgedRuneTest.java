package net.rithms.test.sync;

import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.static_data.dto.ReforgedRune;
import net.rithms.riot.constant.Platform;
import net.rithms.test.RiotApiTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ReforgedRuneTest {

    private static RiotApi api = null;

    @BeforeClass
    public static void prepareApi() {
        api = RiotApiTest.getRiotApi();
    }

    @Test
    public void testgetReforgedRune() throws RiotApiException {
        ReforgedRune reforgedRune = api.getDataReforgedRune(Platform.EUW, 8014);
        assertNotNull(reforgedRune);
        assertEquals("Coup de Grace", reforgedRune.getName());
    }
}
