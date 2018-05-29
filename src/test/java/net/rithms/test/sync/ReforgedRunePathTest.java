package net.rithms.test.sync;

import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.static_data.dto.ReforgedRune;
import net.rithms.riot.api.endpoints.static_data.dto.ReforgedRunePath;
import net.rithms.riot.constant.Platform;
import net.rithms.test.RiotApiTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ReforgedRunePathTest {
    private static RiotApi api = null;

    @BeforeClass
    public static void prepareApi() {
        api = RiotApiTest.getRiotApi();
    }

    @Test
    public void testgetReforgedRunePath() throws RiotApiException {
        ReforgedRunePath reforgedRunePath = api.getDataReforgedRunePath(Platform.EUW, 8200);
        assertNotNull(reforgedRunePath);
        assertEquals("Sorcery", reforgedRunePath.getName());
    }

    @Test
    public void testgetReforgedRunePaths() throws RiotApiException {
        ReforgedRunePath[] reforgedRunePaths = api.getDataReforgedRunePathList(Platform.EUW);
        assertNotNull(reforgedRunePaths);
        assertEquals("Precision", reforgedRunePaths[2].getName());

    }
}

