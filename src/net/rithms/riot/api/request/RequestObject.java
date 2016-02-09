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

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;

import net.rithms.riot.api.HttpHeadParameter;

/**
 * The interface for objects that can be handled by requests. These objects provide information about the request to be made, such as the
 * URL and a few HTTP parameters.
 * 
 * @author Daniel 'Linnun' Figge
 * @see AsyncRequest
 */
public interface RequestObject {

	/**
	 * Returns the HTTP body that should be sent with the request. Returns {@code null} if no body should be used.
	 * 
	 * @return HTTP body
	 */
	public String getBody();

	/**
	 * Returns a list of parameters for the HTTP head to be sent with the request.
	 * 
	 * @return List of paramters for the HTTP head
	 */
	public List<HttpHeadParameter> getHttpHeadParameters();

	/**
	 * Returns the HTTP method that should be used for the request.
	 * 
	 * @return HTTP method
	 */
	public RequestMethod getMethod();

	/**
	 * Returns the return type that the request's response should be parsed to using {@link Gson}.
	 * 
	 * @return Return type
	 */
	public Type getReturnType();

	/**
	 * Returns the URL for the request.
	 * 
	 * @return URL
	 */
	public String getUrl();
}