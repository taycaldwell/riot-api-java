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

/**
 * Thrown when the Riot Api previously returned error code 429 (rate limit exceeded), combined with HTTP headers, asking to not retry again
 * for a certain time.
 */
public class RespectedRateLimitException extends RateLimitException {

	private static final long serialVersionUID = 8877368984231613516L;

	/**
	 * Constructs a {@code RespectedRateLimitException} with the specified attributes.
	 * 
	 * @param retryAfter
	 *            The time in seconds to wait before the api key limits get refreshed
	 * @param rateLimitType
	 *            The type of rate limit that has been exceeded
	 */
	public RespectedRateLimitException(final int retryAfter, final String rateLimitType) {
		super(getMessage(RATE_LIMITED) + " (Respected; Retry After: " + retryAfter + ")", retryAfter, rateLimitType);
	}
}
