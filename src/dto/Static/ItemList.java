package dto.Static;

import java.util.List;
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

public class ItemList {
	
	private List<Group> groups;
	private List<ItemTree> tree;
	private Map<String, Item> data;
	private BasicData basic;
	private String type, version;
	
	public List<Group> getGroups() {
		return groups;
	}
	public List<ItemTree> getTree() {
		return tree;
	}
	public Map<String, Item> getData() {
		return data;
	}
	public BasicData getBasic() {
		return basic;
	}
	public String getType() {
		return type;
	}
	public String getVersion() {
		return version;
	}

}
