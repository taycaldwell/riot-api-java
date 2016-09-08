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

public class MasteryList extends Dto implements Serializable {

	private static final long serialVersionUID = -2255568964283725298L;

	private Map<String, Mastery> data;
	private MasteryTree tree;
	private String type;
	private String version;

	public Map<String, Mastery> getData() {
		return data;
	}

	public MasteryTree getTree() {
		return tree;
	}

	public String getType() {
		return type;
	}

	public String getVersion() {
		return version;
	}

	public void setData(Map<String, Mastery> data) {
		this.data = data;
	}

	public void setTree(MasteryTree tree) {
		this.tree = tree;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return getType();
	}
}