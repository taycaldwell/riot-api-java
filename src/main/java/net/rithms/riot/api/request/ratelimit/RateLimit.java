/*
 * Copyright 2016 Taylor Caldwell
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */

package net.rithms.riot.api.request.ratelimit;

/**
 * This class represents a single rate limit, including retry time.
 * 
 * @author Daniel 'Linnun' Figge
 */
public class RateLimit {

	private final String type;
	private final int retryAfter;
	private final long retryTime;

	public RateLimit(String type, int retryAfter) {
		this.type = type;
		this.retryAfter = retryAfter;
		this.retryTime = System.currentTimeMillis() + (retryAfter * 1000);
	}

	public int getRetryAfter() {
		return retryAfter;
	}

	public long getRetryTime() {
		return retryTime;
	}

	public String getType() {
		return type;
	}

	public boolean isLimitExceeded() {
		return (retryTime > System.currentTimeMillis());
	}
}