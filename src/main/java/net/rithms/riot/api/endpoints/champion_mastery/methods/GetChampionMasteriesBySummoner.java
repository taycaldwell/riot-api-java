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

package net.rithms.riot.api.endpoints.champion_mastery.methods;

import java.util.List;

import com.google.gson.reflect.TypeToken;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.champion_mastery.ChampionMasteryApiMethod;
import net.rithms.riot.api.endpoints.champion_mastery.dto.ChampionMastery;
import net.rithms.riot.constant.Platform;

public class GetChampionMasteriesBySummoner extends ChampionMasteryApiMethod {

	public GetChampionMasteriesBySummoner(ApiConfig config, Platform platform, String summonerId) {
		super(config);
		setPlatform(platform);
		setReturnType(new TypeToken<List<ChampionMastery>>() {
		}.getType());
		setUrlBase(platform.getHost() + "/lol/champion-mastery/v4/champion-masteries/by-summoner/" + summonerId);
		addApiKeyParameter();
	}
}