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

package net.rithms.riot.api.endpoints.matchlist.methods;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.UrlParameter;
import net.rithms.riot.api.endpoints.matchlist.MatchListApiMethod;
import net.rithms.riot.api.endpoints.matchlist.dto.MatchList;
import net.rithms.riot.constant.Region;

public class GetMatchList extends MatchListApiMethod {

	public GetMatchList(ApiConfig config, Region region, long summonerId, String championIds, String rankedQueues, String seasons, long beginTime, long endTime,
			int beginIndex, int endIndex) {
		super(config);
		setRegion(region);
		setReturnType(MatchList.class);
		setUrlBase(region.getEndpoint() + "/v2.2/matchlist/by-summoner/" + summonerId);
		if (championIds != null) {
			add(new UrlParameter("championIds", championIds));
		}
		if (rankedQueues != null) {
			add(new UrlParameter("rankedQueues", rankedQueues));
		}
		if (seasons != null) {
			add(new UrlParameter("seasons", seasons));
		}
		if (beginTime != -1) {
			add(new UrlParameter("beginTime", beginTime));
		}
		if (endTime != -1) {
			add(new UrlParameter("endTime", endTime));
		}
		if (beginIndex != -1) {
			add(new UrlParameter("beginIndex", beginIndex));
		}
		if (endIndex != -1) {
			add(new UrlParameter("endIndex", endIndex));
		}
		addApiKeyParameter();
	}
}