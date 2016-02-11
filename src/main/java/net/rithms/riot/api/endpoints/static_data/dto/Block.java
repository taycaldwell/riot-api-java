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

public class Block implements Serializable {

	private static final long serialVersionUID = -4041031408263653499L;
	private List<BlockItem> items;
	private boolean recMath;
	private String type;

	public List<BlockItem> getItems() {
		return items;
	}

	public boolean isRecMath() {
		return recMath;
	}

	public String getType() {
		return type;
	}
}