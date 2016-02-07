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

package net.rithms.riot.api;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import net.rithms.riot.api.request.RequestMethod;
import net.rithms.riot.api.request.RequestObject;

public class ApiMethod implements RequestObject {

	protected final ApiConfig config;
	private String urlBase;
	private final List<UrlParameter> urlParameters = new LinkedList<UrlParameter>();
	private final List<HttpHeadParameter> httpHeadParameters = new LinkedList<HttpHeadParameter>();
	private RequestMethod method = RequestMethod.GET;
	private String body = null;
	private Type returnType = null;
	private long l; // DEBUG

	protected ApiMethod(ApiConfig config) {
		this.config = config;
		l = System.currentTimeMillis(); // DEBUG
	}

	protected void add(HttpHeadParameter p) {
		httpHeadParameters.add(p);
	}

	protected void add(UrlParameter p) {
		urlParameters.add(p);
	}

	protected void addApiKeyParameter() {
		add(new UrlParameter("api_key", config.getKey()));
	}

	protected void addTournamentApiKeyHttpHeadParameter() {
		add(new HttpHeadParameter("X-Riot-Token", config.getTournamentKey()));
	}

	protected void addTournamentApiKeyParameter() {
		add(new UrlParameter("api_key", config.getTournamentKey()));
	}

	public void buildJsonBody(Map<String, Object> map) {
		body = new Gson().toJson(map);
	}

	@Override
	public String getBody() {
		return body;
	}

	@Override
	public Type getReturnType() {
		return returnType;
	}

	@Override
	public List<HttpHeadParameter> getHttpHeadParameters() {
		return httpHeadParameters;
	}

	@Override
	public RequestMethod getMethod() {
		return method;
	}

	@Override
	public String getUrl() {
		StringBuilder url = new StringBuilder(urlBase);
		char connector = '?';
		for (UrlParameter p : urlParameters) {
			url.append(connector).append(p.toString());
			connector = '&';
		}
		return url.toString();
	}

	// public void setDtoType(Class<?> dtoClass) {
	// this.dtoClass = dtoClass;
	// }

	public void setReturnType(Type returnType) {
		this.returnType = returnType;
	}

	protected void setMethod(RequestMethod method) {
		this.method = method;
	}

	protected void setUrlBase(String urlBase) {
		this.urlBase = urlBase;
	}

	@Override
	public String toString() {
		// return getClass().getSimpleName();
		long running = System.currentTimeMillis() - l; // DEBUG
		return getClass().getSimpleName() + " (running since " + running + " ms)"; // DEBUG
	}
}