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
import java.util.List;
import java.util.Map;

import net.rithms.riot.api.Dto;

public class ItemList extends Dto implements Serializable {

	private static final long serialVersionUID = -1708490617004185357L;

	private BasicData basic;
	private Map<String, Item> data;
	private List<Group> groups;
	private List<ItemTree> tree;
	private String type;
	private String version;

	public BasicData getBasic() {
		return basic;
	}

	public Map<String, Item> getData() {
		return data;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public List<ItemTree> getTree() {
		return tree;
	}

	public String getType() {
		return type;
	}

	public String getVersion() {
		return version;
	}

	public void setBasic(BasicData basic) {
		this.basic = basic;
	}

	public void setData(Map<String, Item> data) {
		this.data = data;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public void setTree(List<ItemTree> tree) {
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