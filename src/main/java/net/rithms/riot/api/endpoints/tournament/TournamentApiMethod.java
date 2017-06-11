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

package net.rithms.riot.api.endpoints.tournament;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.ApiMethod;
import net.rithms.riot.api.HttpHeadParameter;
import net.rithms.riot.api.RiotApiException;

abstract public class TournamentApiMethod extends ApiMethod {

	protected final String HOST = "https://americas.api.riotgames.com";

	private boolean allowMockMode = false;
	private boolean requireTournamentApiKey = false;

	protected TournamentApiMethod(ApiConfig config) {
		super(config, "tournament");
		requireTournamentApiKey();
	}

	protected void addTournamentApiKeyParameter() {
		add(new HttpHeadParameter("X-Riot-Token", getConfig().getTournamentKey()));
	}

	protected void allowMockMode() {
		allowMockMode = true;
	}

	@Override
	public void checkRequirements() throws RiotApiException {
		if (!allowMockMode && getConfig().getTournamentMockMode()) {
			throw new RiotApiException(RiotApiException.FORBIDDEN, "This method isn't available in tournament mock mode");
		}
		if (requireTournamentApiKey && getConfig().getTournamentKey() == null) {
			throw new RiotApiException(RiotApiException.MISSING_TOURNAMENT_API_KEY);
		}
	}

	protected void requireTournamentApiKey() {
		requireTournamentApiKey = true;
	}
}