/*
 * Copyright 2017 Taylor Caldwell
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

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import net.rithms.riot.api.ApiMethod;
import net.rithms.riot.api.request.Request;
import net.rithms.riot.api.request.RequestResponse;
import net.rithms.riot.constant.Platform;

/**
 * This is the default {@link RateLimitHandler}. It keeps track of rate limits when they happen and prevents further requests from being
 * fired if they would violate a known rate limit.
 * <p>
 * If you want to keep the functionality of this {@code DefaultRateLimitHandler} but want to extend it, you can simply inherit this class
 * and call the super methods like this:
 * </p>
 * 
 * <pre>
 * public class CustomRateLimitHandler extends DefaultRateLimitHandler {
 * 	&#64;Override
 * 	public void onRequestAboutToFire(Request request) throws RespectedRateLimitException {
 * 		super.onRequestAboutToFire(request);
 * 		// Your code here
 * 	}
 *
 * 	&#64;Override
 * 	public void onRequestDone(Request request) {
 * 		super.onRequestDone(request);
 * 		// Your code here
 * 	}
 * }
 * </pre>
 * 
 * @author Daniel 'Linnun' Figge
 */
public class DefaultRateLimitHandler implements RateLimitHandler {

	public class RateLimit {

		private final String rateLimitType;
		private final int retryAfter;
		private final long retryTime;

		public RateLimit(String rateLimitType, int retryAfter) {
			this.rateLimitType = rateLimitType;
			this.retryAfter = retryAfter;
			this.retryTime = System.currentTimeMillis() + (retryAfter * 1000);
		}

		public int getRetryAfter() {
			return retryAfter;
		}

		public long getRetryTime() {
			return retryTime;
		}

		public String getRateLimitType() {
			return rateLimitType;
		}

		public boolean isLimitExceeded() {
			return (retryTime > System.currentTimeMillis());
		}
	}

	public class RateLimitList {

		private final Map<Platform, RateLimit> applicationLimits = new ConcurrentHashMap<Platform, RateLimit>();
		private final Map<Platform, Map<String, RateLimit>> serviceLimits = new ConcurrentHashMap<Platform, Map<String, RateLimit>>();
		private final Map<Platform, Map<String, RateLimit>> methodLimits = new ConcurrentHashMap<Platform, Map<String, RateLimit>>();

		public RateLimit getRateLimit(Platform platform, String service, String method) {
			// Check application limits
			if (applicationLimits.containsKey(platform)) {
				if (applicationLimits.get(platform).isLimitExceeded()) {
					return applicationLimits.get(platform);
				}
			}

			// Check service limits
			if (serviceLimits.containsKey(platform)) {
				if (serviceLimits.get(platform).containsKey(service)) {
					if (serviceLimits.get(platform).get(service).isLimitExceeded()) {
						return serviceLimits.get(platform).get(service);
					}
				}
			}

			// Check method limits
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
			return (getRateLimit(platform, service, method) != null);
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

	protected final RateLimitList rateLimitList = new RateLimitList();

	protected boolean isRateLimitExceeded(Request request) {
		ApiMethod object = request.getObject();
		return rateLimitList.isLimitExceeded(object.getPlatform(), object.getService(), object.getClass().getName());
	}

	@Override
	public void onRequestAboutToFire(Request request) throws RespectedRateLimitException {
		if (isRateLimitExceeded(request)) {
			ApiMethod object = request.getObject();
			RateLimit rateLimit = rateLimitList.getRateLimit(object.getPlatform(), object.getService(), object.getClass().getName());
			if (rateLimit == null) {
				return;
			}
			throw new RespectedRateLimitException(rateLimit.getRetryAfter(), rateLimit.getRateLimitType());
		}
	}

	@Override
	public void onRequestDone(Request request) {
		RequestResponse response = request.getResponse();
		if (response.getCode() == Request.CODE_ERROR_RATE_LIMITED) {
			String retryAfterString = response.getHeaderField("Retry-After");
			String rateLimitType = response.getHeaderField("X-Rate-Limit-Type");
			if (retryAfterString != null) {
				int retryAfter = Integer.parseInt(retryAfterString);
				ApiMethod object = request.getObject();
				rateLimitList.setRateLimit(object.getPlatform(), object.getService(), object.getClass().getName(), rateLimitType, retryAfter);
			}
		}
	}
}