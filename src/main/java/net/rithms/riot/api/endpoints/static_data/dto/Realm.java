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

package net.rithms.riot.api.endpoints.static_data.dto;

import java.io.Serializable;
import java.util.Map;

import net.rithms.riot.api.Dto;

public class Realm extends Dto implements Serializable {

	private static final long serialVersionUID = -3494066446872616575L;

	private String cdn;
	private String css;
	private String dd;
	private String l;
	private String lg;
	private Map<String, String> n;
	private int profileiconmax;
	private String store;
	private String v;

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

	public Map<String, String> getN() {
		return n;
	}

	public int getProfileiconmax() {
		return profileiconmax;
	}

	public String getStore() {
		return store;
	}

	public String getV() {
		return v;
	}
	
	public void setCdn(String cdn) {
		this.cdn = cdn;
	}

	public void setCss(String css) {
		this.css = css;
	}

	public void setDd(String dd) {
		this.dd = dd;
	}

	public void setL(String l) {
		this.l = l;
	}

	public void setLg(String lg) {
		this.lg = lg;
	}

	public void setN(Map<String, String> n) {
		this.n = n;
	}

	public void setProfileiconmax(int profileiconmax) {
		this.profileiconmax = profileiconmax;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public void setV(String v) {
		this.v = v;
	}

	@Override
	public String toString() {
		return getL();
	}
}