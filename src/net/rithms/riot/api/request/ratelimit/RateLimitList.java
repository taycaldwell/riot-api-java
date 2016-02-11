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

import net.rithms.riot.constant.Region;

/**
 * This class provides a list of rate limits and retry times.
 * 
 * @author Daniel 'Linnun' Figge
 */
public class RateLimitList {

	private final Map<Region, RateLimit> userLimits = new ConcurrentHashMap<Region, RateLimit>();
	private final Map<Region, Map<String, RateLimit>> serviceLimits = new ConcurrentHashMap<Region, Map<String, RateLimit>>();

	public RateLimit getRateLimit(String service, Region region) {
		if (userLimits.containsKey(region)) {
			if (userLimits.get(region).isLimitExceeded()) {
				return userLimits.get(region);
			}
		}

		if (serviceLimits.containsKey(region)) {
			if (serviceLimits.get(region).containsKey(service)) {
				if (serviceLimits.get(region).get(service).isLimitExceeded()) {
					return serviceLimits.get(region).get(service);
				}
			}
		}
		return null;
	}

	public boolean isLimitExceeded(String service, Region region) {
		if (userLimits.containsKey(region)) {
			if (userLimits.get(region).isLimitExceeded()) {
				return true;
			}
		}

		if (serviceLimits.containsKey(region)) {
			if (serviceLimits.get(region).containsKey(service)) {
				if (serviceLimits.get(region).get(service).isLimitExceeded()) {
					return true;
				}
			}
		}
		return false;
	}

	public void setRateLimit(String service, Region region, String type, int retryAfter) {
		if (type.equals("user")) {
			userLimits.put(region, new RateLimit(type, retryAfter));
		} else if (type.equals("service")) {
			if (!serviceLimits.containsKey(region)) {
				serviceLimits.put(region, new ConcurrentHashMap<String, RateLimit>());
			}
			serviceLimits.get(region).put(service, new RateLimit(type, retryAfter));
		}
	}
}