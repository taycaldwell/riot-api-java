package net.rithms.test.async;

import net.rithms.riot.api.RiotApiAsync;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.static_data.dto.ReforgedRune;
import net.rithms.riot.api.request.AsyncRequest;
import net.rithms.riot.api.request.RequestListener;
import net.rithms.riot.constant.Platform;
import net.rithms.test.RiotApiTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class AsyncReforgedRuneTest {

    private static RiotApiAsync api = null;

    @BeforeClass
    public static void prepareApi() {
        api = RiotApiTest.getRiotApiAsync();
    }

    @Test
    public void testGetReforgedRune() throws RiotApiException, InterruptedException {
        AsyncRequest reqSummonerMap = api.getDataReforgedRune(Platform.EUW, 8014);
        reqSummonerMap.addListeners(new RequestListener() {
            @Override
            public void onRequestFailed(RiotApiException e) {
                fail();
            }

            @Override
            public void onRequestSucceeded(AsyncRequest request) {
                ReforgedRune reforgedRune = request.getDto();
                assertNotNull(reforgedRune);
                assertEquals("Coup de Grace", reforgedRune.getName());
            }

            @Override
            public void onRequestTimeout(AsyncRequest request) {
                fail();
            }
        });
        api.awaitAll();
    }

    @Test
    public void testGetReforgedRunes() throws RiotApiException, InterruptedException {
        AsyncRequest reqSummonerMap = api.getDataReforgedRuneList(Platform.EUW);
        reqSummonerMap.addListeners(new RequestListener() {
            @Override
            public void onRequestFailed(RiotApiException e) {
                fail();
            }

            @Override
            public void onRequestSucceeded(AsyncRequest request) {
                ReforgedRune[] reforgedRunes = request.getDto();
                assertNotNull(reforgedRunes);
                assertEquals("Coup de Grace", reforgedRunes[6].getName());
            }

            @Override
            public void onRequestTimeout(AsyncRequest request) {
                fail();
            }
        });
        api.awaitAll();
    }
}
