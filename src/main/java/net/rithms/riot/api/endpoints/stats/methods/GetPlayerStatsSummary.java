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

package net.rithms.riot.api.endpoints.stats.methods;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.UrlParameter;
import net.rithms.riot.api.endpoints.stats.StatsApiMethod;
import net.rithms.riot.api.endpoints.stats.dto.PlayerStatsSummaryList;
import net.rithms.riot.constant.Region;
import net.rithms.riot.constant.Season;

public class GetPlayerStatsSummary extends StatsApiMethod {

	public GetPlayerStatsSummary(ApiConfig config, Region region, Season season, long summonerId) {
		super(config);
		setRegion(region);
		setReturnType(PlayerStatsSummaryList.class);
		setUrlBase(region.getEndpoint() + "/v1.3/stats/by-summoner/" + summonerId + "/summary");
		if (season != null) {
			add(new UrlParameter("season", season));
		}
		addApiKeyParameter();
	}
}