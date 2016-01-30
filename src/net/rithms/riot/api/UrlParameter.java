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

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;

public class UrlParameter {

	private final String key;
	private final String value;

	public UrlParameter(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public UrlParameter(String key, int value) {
		this(key, String.valueOf(value));
	}

	public UrlParameter(String key, long value) {
		this(key, String.valueOf(value));
	}

	public UrlParameter(String key, boolean value) {
		this(key, value ? "1" : "0");
	}

	public UrlParameter(String key, Object value) {
		this(key, value.toString());
	}

	protected String getKey() {
		return key;
	}

	protected String getValue() {
		return value;
	}

	@Override
	public String toString() {
		String parameter = null;
		try {
			parameter = URLEncoder.encode(getKey(), "UTF-8") + "=" + URLEncoder.encode(getValue(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// This should never happen
			RiotApi.log.log(Level.SEVERE, "URL Encoding Failed", e);
		}
		return parameter;
	}
}