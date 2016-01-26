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

import java.util.Objects;

/**
 * Configuration class to use with the {@link RiotApi}.
 */
public class ApiConfig {

	private String key = null;
	private String tournamentKey = null;
	private int timeout = 0;

	@Override
	public ApiConfig clone() {
		return new ApiConfig().setKey(getKey()).setTimeout(getTimeout()).setTournamentKey(getTournamentKey());
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

	/**
	 * Sets the api key for the Riot Api. Most endpoints require this key to be set.
	 *
	 * @param key
	 *            Your api key
	 * @return This ApiConfig object for chaining
	 * @throws NullPointerException
	 *             If the {@code key} is null
	 */
	public ApiConfig setKey(String key) {
		Objects.requireNonNull(key, "key must not be null");
		this.key = key;
		return this;
	}

	/**
	 * Sets how many milliseconds a call in {@link RiotApi} should block at most until a command without response fails. This value can be
	 * set to zero to disable the timeout. By default, there is no timeout.
	 *
	 * @param timeout
	 *            The maximum time to wait for a response until a synchronous call fails
	 * @return This ApiConfig object for chaining
	 * @throws IllegalArgumentException
	 *             If the timeout value is smaller than {@code 0}
	 */
	public ApiConfig setTimeout(int timeout) {
		if (timeout < 0) {
			throw new IllegalArgumentException("The timeout value must be greater than or equal to 0");
		}
		this.timeout = timeout;
		return this;
	}

	/**
	 * Sets the tournament api key for the Riot Api. Tournament-related endpoints require this key to be set.
	 *
	 * @param key
	 *            Your tournament api key
	 * @return This ApiConfig object for chaining
	 * @throws NullPointerException
	 *             If the {@code tournamentKey} is null
	 */
	public ApiConfig setTournamentKey(String tournamentKey) {
		Objects.requireNonNull(tournamentKey, "tournamentKey must not be null");
		this.tournamentKey = tournamentKey;
		return this;
	}
}