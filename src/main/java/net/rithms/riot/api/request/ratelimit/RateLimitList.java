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

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import net.rithms.riot.constant.Platform;

/**
 * This class provides a list of rate limits and retry times.
 * 
 * @author Daniel 'Linnun' Figge
 */
public class RateLimitList {

	private final Map<Platform, RateLimit> applicationLimits = new ConcurrentHashMap<Platform, RateLimit>();
	private final Map<Platform, Map<String, RateLimit>> serviceLimits = new ConcurrentHashMap<Platform, Map<String, RateLimit>>();
	private final Map<Platform, Map<String, RateLimit>> methodLimits = new ConcurrentHashMap<Platform, Map<String, RateLimit>>();

	public RateLimit getRateLimit(Platform platform, String service, String method) {
		if (applicationLimits.containsKey(platform)) {
			if (applicationLimits.get(platform).isLimitExceeded()) {
				return applicationLimits.get(platform);
			}
		}

		if (serviceLimits.containsKey(platform)) {
			if (serviceLimits.get(platform).containsKey(service)) {
				if (serviceLimits.get(platform).get(service).isLimitExceeded()) {
					return serviceLimits.get(platform).get(service);
				}
			}
		}

		if (methodLimits.containsKey(platform)) {
			if (methodLimits.get(platform).containsKey(method)) {
				if (methodLimits.get(platform).get(method).isLimitExceeded()) {
					return methodLimits.get(platform).get(method);
				}
			}
		}
		return null;
	}

	public boolean isLimitExceeded(Platform platform, String service, String method) {
		if (applicationLimits.containsKey(platform)) {
			if (applicationLimits.get(platform).isLimitExceeded()) {
				return true;
			}
		}

		if (serviceLimits.containsKey(platform)) {
			if (serviceLimits.get(platform).containsKey(service)) {
				if (serviceLimits.get(platform).get(service).isLimitExceeded()) {
					return true;
				}
			}
		}

		if (methodLimits.containsKey(platform)) {
			if (methodLimits.get(platform).containsKey(method)) {
				if (methodLimits.get(platform).get(method).isLimitExceeded()) {
					return true;
				}
			}
		}
		return false;
	}

	public void setRateLimit(Platform platform, String service, String method, String type, int retryAfter) {
		if (type.equals("application")) {
			applicationLimits.put(platform, new RateLimit(type, retryAfter));
		} else if (type.equals("service")) {
			if (!serviceLimits.containsKey(platform)) {
				serviceLimits.put(platform, new ConcurrentHashMap<String, RateLimit>());
			}
			serviceLimits.get(platform).put(service, new RateLimit(type, retryAfter));
		} else if (type.equals("method")) {
			if (!methodLimits.containsKey(platform)) {
				methodLimits.put(platform, new ConcurrentHashMap<String, RateLimit>());
			}
			methodLimits.get(platform).put(method, new RateLimit(type, retryAfter));
		}
	}
}