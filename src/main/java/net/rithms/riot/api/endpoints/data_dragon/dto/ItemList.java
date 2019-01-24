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

package net.rithms.riot.api.endpoints.data_dragon.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import net.rithms.riot.api.Dto;

/**
 * This object contains item list data.
 */
public class ItemList extends Dto implements Serializable {

	private static final long serialVersionUID = -1708490617004185357L;

	private Map<String, Item> data;
	private List<Group> groups;
	private List<ItemTree> tree;
	private String type;
	private String version;

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

	@Override
	public String toString() {
		return getType();
	}
}