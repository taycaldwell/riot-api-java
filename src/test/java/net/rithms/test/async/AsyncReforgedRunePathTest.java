package net.rithms.test.async;

import net.rithms.riot.api.RiotApiAsync;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.static_data.dto.ReforgedRunePath;
import net.rithms.riot.api.request.AsyncRequest;
import net.rithms.riot.api.request.RequestListener;
import net.rithms.riot.constant.Platform;
import net.rithms.test.RiotApiTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class AsyncReforgedRunePathTest {

    private static RiotApiAsync api = null;

    @BeforeClass
    public static void prepareApi() {
        api = RiotApiTest.getRiotApiAsync();
    }

    @Test
    public void testGetReforgedRunePath() throws RiotApiException, InterruptedException {
        AsyncRequest reqSummonerMap = api.getDataReforgedRunePath(Platform.EUW, 8200);
        reqSummonerMap.addListeners(new RequestListener() {
            @Override
            public void onRequestFailed(RiotApiException e) {
                fail();
            }

            @Override
            public void onRequestSucceeded(AsyncRequest request) {
                ReforgedRunePath reforgedRunePath = request.getDto();
                assertNotNull(reforgedRunePath);
                assertEquals("Sorcery", reforgedRunePath.getName());
            }

            @Override
            public void onRequestTimeout(AsyncRequest request) {
                fail();
            }
        });
        api.awaitAll();
    }

    @Test
    public void testGetReforgedRunePaths() throws RiotApiException, InterruptedException {
        AsyncRequest reqSummonerMap = api.getDataReforgedRunePathList(Platform.EUW);
        reqSummonerMap.addListeners(new RequestListener() {
            @Override
            public void onRequestFailed(RiotApiException e) {
                fail();
            }

            @Override
            public void onRequestSucceeded(AsyncRequest request) {
                ReforgedRunePath[] reforgedRunePaths = request.getDto();
                assertNotNull(reforgedRunePaths);
                assertEquals("Precision", reforgedRunePaths[2].getName());
            }

            @Override
            public void onRequestTimeout(AsyncRequest request) {
                fail();
            }
        });
        api.awaitAll();
    }
}
