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

package net.rithms.riot.api.endpoints.match.methods;

import java.util.Set;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.UrlParameter;
import net.rithms.riot.api.endpoints.match.MatchApiMethod;
import net.rithms.riot.api.endpoints.match.dto.MatchList;
import net.rithms.riot.constant.Platform;

public class GetMatchListByAccountId extends MatchApiMethod {

	public GetMatchListByAccountId(ApiConfig config, Platform platform, String accountId, Set<Integer> champion, Set<Integer> queue, Set<Integer> season,
			long beginTime, long endTime, int beginIndex, int endIndex) {
		super(config);
		setPlatform(platform);
		setReturnType(MatchList.class);
		setUrlBase(platform.getHost() + "/lol/match/v4/matchlists/by-account/" + accountId);
		if (champion != null) {
			for (int param : champion) {
				add(new UrlParameter("champion", param));
			}
		}
		if (queue != null) {
			for (int param : queue) {
				add(new UrlParameter("queue", param));
			}
		}
		if (season != null) {
			for (int param : season) {
				add(new UrlParameter("season", param));
			}
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