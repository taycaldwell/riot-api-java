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

package net.rithms.riot.api.endpoints.champion.methods;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.UrlParameter;
import net.rithms.riot.api.endpoints.champion.ChampionApiMethod;
import net.rithms.riot.api.endpoints.champion.dto.ChampionList;
import net.rithms.riot.constant.Region;

public class GetChampions extends ChampionApiMethod {

	public GetChampions(ApiConfig config, Region region, boolean freeToPlay) {
		super(config);
		setRegion(region);
		setReturnType(ChampionList.class);
		setUrlBase(region.getEndpoint() + "/v1.2/champion");
		if (freeToPlay) {
			add(new UrlParameter("freeToPlay", freeToPlay));
		}
		addApiKeyParameter();
	}
}