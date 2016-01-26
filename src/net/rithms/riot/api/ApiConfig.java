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
package net.rithms.riot.api;

public class ApiConfig {

	private String key = null;
	private String tournamentKey = null;
	private int timeout = 0;

	@Override
	public ApiConfig clone() {
		return new ApiConfig().setKey(getKey()).setTournamentKey(getTournamentKey()).setTimeout(getTimeout());
	}

	public String getKey() {
		return key;
	}

	public int getTimeout() {
		return timeout;
	}

	public String getTournamentKey() {
		return tournamentKey;
	}

	public ApiConfig setKey(String key) {
		this.key = key;
		return this;
	}

	public ApiConfig setTimeout(int timeout) {
		this.timeout = timeout;
		return this;
	}

	public ApiConfig setTournamentKey(String tournamentKey) {
		this.tournamentKey = tournamentKey;
		return this;
	}
}