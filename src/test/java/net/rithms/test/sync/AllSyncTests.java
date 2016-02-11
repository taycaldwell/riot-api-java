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

package net.rithms.test.sync;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import net.rithms.riot.api.RiotApi;
import net.rithms.test.RiotApiTest;

/**
 * Runs all synchronous tests. You might need an api key with extended limits to run all the tests at once.
 * 
 * <p>
 * For these tests to work, you need to insert your api key in {@link RiotApiTest}.
 * </p>
 * 
 * @see RiotApi
 */
@RunWith(Suite.class)
@SuiteClasses({ SummonerTest.class })
public class AllSyncTests {
}