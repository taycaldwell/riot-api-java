package com.github.rithms.dto.Static;

import java.io.Serializable;
import java.util.Map;

/*
 * Copyright 2014 Taylor Caldwell
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

public class Realm implements Serializable {

	private static final long serialVersionUID = -3494066446872616575L;
	private Map<String, String> n;
	private String cdn, css, dd, l, lg, store, v;
	private int profileiconmax;
	
	public Map<String, String> getN() {
		return n;
	}
	public String getCdn() {
		return cdn;
	}
	public String getCss() {
		return css;
	}
	public String getDd() {
		return dd;
	}
	public String getL() {
		return l;
	}
	public String getLg() {
		return lg;
	}
	public String getStore() {
		return store;
	}
	public String getV() {
		return v;
	}
	public int getProfileiconmax() {
		return profileiconmax;
	}
	
}
