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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.rithms.riot.api.ApiMethod;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.request.Request;
import net.rithms.riot.api.request.RequestResponse;

/**
 * The {@code BufferedRateLimitHandler} extends the {@link DefaultRateLimitHandler}. It checks the rate limit headers after each request,
 * and if a certain threshold is exceeded, it will soft rate limit the application for a certain time.
 * 
 * <p>
 * If you have a use case where you fire a lot of simultaneous requests (like asynchronously requesting many matches from a match list)
 * using multiple threads or even multiple dedicated servers, if you were to use the {@link DefaultRateLimitHandler}, you would already have
 * fired many more requests before you get the first 429 response, resulting in all already fired requests to also result in 429 responses
 * before the {@link DefaultRateLimitHandler} can actually prevent further requests from being fired before the rate limit resets. In such a
 * scenario you may want to stop firing new requests for {@code X} seconds when you reach {@code X}% of your rate limits, so that you have a
 * buffer for already fired requests to end gracefully.
 * </p>
 * 
 * @author Daniel 'Linnun' Figge
 */
public class BufferedRateLimitHandler extends DefaultRateLimitHandler {

	protected final double threshold;
	protected final int cooldown;

	/**
	 * Creates a new {@code BufferedRateLimitHandler}.
	 * 
	 * @param threshold
	 *            Rate limit threshold to trigger a soft rate limit (e.g. 0.9 for 90%)
	 * @param cooldown
	 *            Time interval in seconds for an app or method to go on cooldown once the threshold has been exceeded
	 */
	public BufferedRateLimitHandler(double threshold, int cooldown) {
		this.threshold = threshold;
		this.cooldown = cooldown;
	}

	/**
	 * Parses a given header field of rate limits or rate limit counts.
	 * 
	 * @param headerField
	 *            header field to parse
	 * @return A map, mapping interval to rate limit / rate limit count
	 */
	protected Map<Integer, Integer> getIntervalCountMapFromHeaderField(List<String> headerField) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		if (headerField != null) {
			for (String rateLimitField : headerField) {
				String[] split = rateLimitField.split(":");
				if (split.length == 2) {
					map.put(Integer.valueOf(split[1]), Integer.valueOf(split[0]));
				}
			}
		}
		return map;
	}

	@Override
	public void onRequestDone(Request request) {
		super.onRequestDone(request);
		RequestResponse response = request.getResponse();
		ApiMethod object = request.getObject();

		// interval -> count
		Map<Integer, Integer> appCounts = getIntervalCountMapFromHeaderField(response.getHeaderFields().get("X-App-Rate-Limit-Count"));
		Map<Integer, Integer> appLimits = getIntervalCountMapFromHeaderField(response.getHeaderFields().get("X-App-Rate-Limit"));
		Map<Integer, Integer> methodCounts = getIntervalCountMapFromHeaderField(response.getHeaderFields().get("X-Method-Rate-Limit-Count"));
		Map<Integer, Integer> methodLimits = getIntervalCountMapFromHeaderField(response.getHeaderFields().get("X-Method-Rate-Limit"));

		// Check app limits
		for (Map.Entry<Integer, Integer> entry : appCounts.entrySet()) {
			int interval = entry.getKey();
			int count = entry.getValue();
			if (appLimits.containsKey(interval)) {
				int limit = appLimits.get(interval);
				if ((double) count / (double) limit > threshold) {
					rateLimitList.setRateLimit(object.getPlatform(), object.getService(), object.getClass().getName(), "app", cooldown);
					RiotApi.log.fine("[BufferedRateLimitHandler] App limit threshhold " + threshold + " exceeded (" + count + "/" + limit
							+ "). Soft rate limiting for " + cooldown + "s");
				}
			}
		}

		// Check method limits
		for (Map.Entry<Integer, Integer> entry : methodCounts.entrySet()) {
			int interval = entry.getKey();
			int count = entry.getValue();
			if (methodLimits.containsKey(interval)) {
				int limit = methodLimits.get(interval);
				if ((double) count / (double) limit > threshold) {
					rateLimitList.setRateLimit(object.getPlatform(), object.getService(), object.getClass().getName(), "app", cooldown);
					RiotApi.log.fine("[BufferedRateLimitHandler] Method limit threshhold " + threshold + " exceeded (" + count + "/" + limit + ") for "
							+ object.getClass().getName() + ". Soft rate limiting for " + cooldown + "s");
				}
			}
		}
	}
}