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

package net.rithms.riot.api.endpoints.tournament.methods;

import java.util.HashMap;
import java.util.Map;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.tournament.TournamentApiMethod;
import net.rithms.riot.api.request.RequestMethod;

public class CreateTournamentProvider extends TournamentApiMethod {

	public CreateTournamentProvider(ApiConfig config, String region, String callbackUrl) {
		super(config);
		setHttpMethod(RequestMethod.POST);
		setReturnType(Integer.class);
		if (config.getTournamentMockMode()) {
			setUrlBase(HOST + "/lol/tournament-stub/v4/providers");
		} else {
			setUrlBase(HOST + "/lol/tournament/v3/providers");
		}
		addTournamentApiKeyParameter();
		allowMockMode();

		Map<String, Object> body = new HashMap<String, Object>();
		body.put("region", region);
		body.put("url", callbackUrl);
		buildJsonBody(body);
	}
}