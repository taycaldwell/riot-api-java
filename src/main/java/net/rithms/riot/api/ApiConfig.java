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
import java.util.logging.Level;

/**
 * Configuration class to use with the {@link RiotApi}.
 */
public class ApiConfig implements Cloneable {

	public final int DEFAULT_ASYNC_REQUEST_TIMEOUT = 10000;
	public final Level DEFAULT_DEBUG_LEVEL = Level.WARNING;
	public final boolean DEFAULT_DEBUG_TO_FILE = false;
	public final int DEFAULT_MAX_ASYNC_THREADS = 0;
	public final int DEFAULT_REQUEST_TIMEOUT = 0;
	public final boolean DEFAULT_RESPECT_RATE_LIMIT = true;
	public final boolean DEFAULT_TOURNAMENT_MOCK_MODE = false;

	private int asyncRequestTimeout = DEFAULT_ASYNC_REQUEST_TIMEOUT;
	private Level debugLevel = DEFAULT_DEBUG_LEVEL;
	private boolean debugToFile = DEFAULT_DEBUG_TO_FILE;
	private String key = null;
	private int maxAsyncThreads = DEFAULT_MAX_ASYNC_THREADS;
	private int requestTimeout = DEFAULT_REQUEST_TIMEOUT;
	private boolean respectRateLimit = DEFAULT_RESPECT_RATE_LIMIT;
	private String tournamentKey = null;
	private boolean tournamentMockMode = DEFAULT_TOURNAMENT_MOCK_MODE;

	@Override
	public ApiConfig clone() {
		return new ApiConfig().setAsyncRequestTimeout(getAsyncRequestTimeout()).setDebugLevel(getDebugLevel()).setDebugToFile(getDebugToFile()).setKey(getKey())
				.setMaxAsyncThreads(getMaxAsyncThreads()).setRequestTimeout(getRequestTimeout()).setRespectRateLimit(getRespectRateLimit())
				.setTournamentKey(getTournamentKey()).setTournamentMockMode(getTournamentMockMode());
	}

	public int getAsyncRequestTimeout() {
		return asyncRequestTimeout;
	}

	public Level getDebugLevel() {
		return debugLevel;
	}

	public boolean getDebugToFile() {
		return debugToFile;
	}

	public String getKey() {
		return key;
	}

	public int getMaxAsyncThreads() {
		return maxAsyncThreads;
	}

	public int getRequestTimeout() {
		return requestTimeout;
	}

	public boolean getRespectRateLimit() {
		return respectRateLimit;
	}

	public String getTournamentKey() {
		return tournamentKey;
	}

	public boolean getTournamentMockMode() {
		return tournamentMockMode;
	}

	/**
	 * Sets a specified timeout value, in milliseconds, for calls in {@link RiotApiAsync} to wait at most for a response. If set to zero,
	 * asynchronous requests won't time out.
	 * 
	 * <p>
	 * To set the timeout for synchronous requests use {@link #setRequestTimeout(int)} instead.
	 * </p>
	 *
	 * @param timeout
	 *            The maximum time for an asynchronous call to wait for a response until it times out
	 * @return This ApiConfig object for chaining
	 * @throws IllegalArgumentException
	 *             If the timeout value is smaller than {@code 0}
	 */
	public ApiConfig setAsyncRequestTimeout(int asyncRequestTimeout) {
		if (asyncRequestTimeout < 0) {
			throw new IllegalArgumentException("The timeout value must be greater than or equal to 0");
		}
		this.asyncRequestTimeout = asyncRequestTimeout;
		return this;
	}

	/**
	 * Sets the debug level.
	 * 
	 * @param debugLevel
	 *            Debug level
	 * @return This ApiConfig object for chaining
	 */
	public ApiConfig setDebugLevel(Level debugLevel) {
		Objects.requireNonNull(debugLevel, "debug level must not be null");
		this.debugLevel = debugLevel;
		return this;
	}

	/**
	 * Sets whether the debug log should be saved in a file.
	 * <p>
	 * If debug logging to file is activated, a file named {@code riot-api.log} will be created and contain all logging messages for the
	 * level set via {@link #setDebugLevel(Level)}.
	 * </p>
	 * 
	 * @param debugToFile
	 *            {@code true} if the debug log should be saved in a file, {@code false} otherwise
	 * @return This ApiConfig object for chaining
	 */
	public ApiConfig setDebugToFile(boolean debugToFile) {
		this.debugToFile = debugToFile;
		return this;
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
	 * Sets the maximum amount of threads for asynchronous api calls running at once. If set to zero, there is no limit.
	 * 
	 * <p>
	 * If you make asynchronous calls, and the current thread limit is reached, the api call will be queued and executed when resources
	 * become available.
	 * </p>
	 * 
	 * @param maxAsyncThreads
	 *            Max amount of threads to run at the same time
	 * @return This ApiConfig object for chaining
	 * @throws IllegalArgumentException
	 *             If the limit is smaller than {@code 0}
	 */
	public ApiConfig setMaxAsyncThreads(int maxAsyncThreads) {
		if (maxAsyncThreads < 0) {
			throw new IllegalArgumentException("The max amount of threads to run must be greater than or equal to 0");
		}
		this.maxAsyncThreads = maxAsyncThreads;
		return this;
	}

	/**
	 * Sets a specified timeout value, in milliseconds, for calls in {@link RiotApi} to wait at most for a response. If set to zero,
	 * requests won't time out.
	 * 
	 * <p>
	 * To set the timeout for asynchronous requests use {@link #setAsyncRequestTimeout(int)} instead.
	 * </p>
	 *
	 * @param timeout
	 *            The maximum time to wait for a response until a synchronous call fails
	 * @return This ApiConfig object for chaining
	 * @throws IllegalArgumentException
	 *             If the timeout value is smaller than {@code 0}
	 */
	public ApiConfig setRequestTimeout(int requestTimeout) {
		if (requestTimeout < 0) {
			throw new IllegalArgumentException("The timeout value must be greater than or equal to 0");
		}
		this.requestTimeout = requestTimeout;
		return this;
	}

	/**
	 * Sets whether the api should attempt to automatically respect rate limits. If set to {@code true}, the api will listen to
	 * rate-limit-specific headers from the Riot Api and try to respect them.
	 *
	 * @param respectRateLimit
	 *            {@code true} if the api should attempt to automatically respect rate limits
	 * @return This ApiConfig object for chaining
	 */
	public ApiConfig setRespectRateLimit(boolean respectRateLimit) {
		this.respectRateLimit = respectRateLimit;
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

	/**
	 * Sets whether the api should redirect tournament method calls should be redirected to the {@code TOURNAMENT-STUB} endpoint.
	 * <p>
	 * The {@code TOURNAMENT-STUB} endpoint provides dummy data meant for testing your app before going into production. Note that not all
	 * tournament methods are available in mock mode.
	 * </p>
	 * 
	 * @param tournamentMockMode
	 *            {@code true} if tournament methods should be called in mock mode
	 * @return This ApiConfig object for chaining
	 */
	public ApiConfig setTournamentMockMode(boolean tournamentMockMode) {
		this.tournamentMockMode = tournamentMockMode;
		return this;
	}
}