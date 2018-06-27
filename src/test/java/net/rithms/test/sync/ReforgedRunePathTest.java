/*
 * Copyright 2018 Taylor Caldwell
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

import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
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
    public void testGetReforgedRunePath() throws RiotApiException {
        ReforgedRunePath reforgedRunePath = api.getDataReforgedRunePath(Platform.EUW, 8200);
        assertNotNull(reforgedRunePath);
        assertEquals("Sorcery", reforgedRunePath.getName());
    }

    @Test
    public void testGetReforgedRunePaths() throws RiotApiException {
        ReforgedRunePath[] reforgedRunePaths = api.getDataReforgedRunePathList(Platform.EUW);
        assertNotNull(reforgedRunePaths);
        assertEquals("Precision", reforgedRunePaths[2].getName());

    }
}

