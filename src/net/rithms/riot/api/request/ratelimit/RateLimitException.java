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

package net.rithms.riot.api.request.ratelimit;

import net.rithms.riot.api.RiotApiException;

/**
 * Thrown when the Riot Api returns error code 429 (rate limit exceeded). This can either mean, that the limits of your api key have been
 * exceeded, or that Riot has reached some internal limits for the api you are trying to use. You can find out whose rate limit was exceeded
 * by calling {@link #getRateLimitType()}.
 */
public class RateLimitException extends RiotApiException {

	private static final long serialVersionUID = 8523329282717166886L;

	private final int retryAfter;
	private final String rateLimitType;

	/**
	 * Constructs a {@code RateLimitException} with the specified attributes.
	 * 
	 * @param retryAfter
	 *            The time in seconds to wait before the api key limits get refreshed
	 * @param rateLimitType
	 *            The type of rate limit that has been exceeded
	 */
	public RateLimitException(final int retryAfter, final String rateLimitType) {
		super(RATE_LIMITED, getMessage(RATE_LIMITED) + " (Retry After: " + retryAfter + ")");
		this.retryAfter = retryAfter;
		this.rateLimitType = rateLimitType;
	}

	/**
	 * Constructs a {@code RateLimitException} with the specified attributes.
	 * 
	 * @param message
	 *            Error message
	 * @param retryAfter
	 *            The time in seconds to wait before the api key limits get refreshed
	 * @param rateLimitType
	 *            The type of rate limit that has been exceeded
	 */
	protected RateLimitException(final String message, final int retryAfter, final String rateLimitType) {
		super(RATE_LIMITED, message);
		this.retryAfter = retryAfter;
		this.rateLimitType = rateLimitType;
	}

	/**
	 * Returns the type of rate limit that has been exceeded. This value can either be {@code user}, if the user's api key has reached its
	 * limits, or {@code service}, if Riot has reached some internal limits for that api.
	 * 
	 * @return The type of rate limit that has been exceeded
	 */
	public String getRateLimitType() {
		return rateLimitType;
	}

	/**
	 * Returns the time in seconds to wait before the api key limits get refreshed.
	 * 
	 * @return The time in seconds to wait before the api key limits get refreshed
	 */
	public int getRetryAfter() {
		return retryAfter;
	}
}