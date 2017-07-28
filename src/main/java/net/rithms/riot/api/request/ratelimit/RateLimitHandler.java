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

import net.rithms.riot.api.request.Request;

/**
 * The interface for handling rate limits
 * 
 * @author Daniel 'Linnun' Figge
 */
public interface RateLimitHandler {

	/**
	 * This method is called for every request before it is fired to the Riot API. Here you get the chance to respect rate limits and decide
	 * to not fire the request by throwing a {@code RespectedRateLimitException} instead.
	 * 
	 * @throws RespectedRateLimitException
	 *             If the RateLimitHandler decides that a request should not be fired
	 */
	public void onRequestAboutToFire(Request request) throws RespectedRateLimitException;

	/**
	 * This method is called for every request after it has finished. Here you get the chance to check the request's response and use its
	 * header fields to handle your rate limiting logic.
	 */
	public void onRequestDone(Request request);
}