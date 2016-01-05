package net.rithms.riot.api;

/*
 * Copyright 2014 Taylor Caldwell
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

public class RateLimitException extends RiotApiException {

	private static final long serialVersionUID = 8523329282717166886L;

	protected final int retryAfter;
	protected final String rateLimitType;

	public RateLimitException(final int retryAfter, final String rateLimitType) {
		super(RATE_LIMITED);
		this.retryAfter = retryAfter;
		this.rateLimitType = rateLimitType;
	}

	public RateLimitException() {
		this(0, null);
	}

	public int getRetryAfter() {
		return retryAfter;
	}

	public String getRateLimitType() {
		return rateLimitType;
	}
}