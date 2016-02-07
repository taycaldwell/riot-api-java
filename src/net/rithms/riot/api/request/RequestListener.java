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

package net.rithms.riot.api.request;

import net.rithms.riot.api.RiotApiException;

/**
 * The listener interface for receiving events from asynchronous requests.
 * 
 * @author Daniel 'Linnun' Figge
 * @see AsyncRequest
 */
public interface RequestListener {

	/**
	 * Invoked when a request fails.
	 * 
	 * @param e
	 *            Exception thrown
	 */
	public void onRequestFailed(RiotApiException e);

	/**
	 * Invoked when a request succeeds.
	 * 
	 * @param request
	 *            AsyncRequest object
	 * @see AsyncRequest
	 */
	public void onRequestSucceeded(AsyncRequest request);

	/**
	 * Invoked when a request times out.
	 * 
	 * @param request
	 *            AsyncRequest object
	 * @see AsyncRequest
	 */
	public void onRequestTimeout(AsyncRequest request);
}