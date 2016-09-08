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

import com.google.gson.annotations.SerializedName;

import net.rithms.riot.api.Dto;

public class Group extends Dto implements Serializable {

	private static final long serialVersionUID = -4691215871693156751L;

	@SerializedName(value = "MaxGroupOwnable")
	private String maxGroupOwnable;
	private String key;

	public String getMaxGroupOwnable() {
		return maxGroupOwnable;
	}

	public String getKey() {
		return key;
	}
	
	public void setMaxGroupOwnable(String maxGroupOwnable) {
		this.maxGroupOwnable = maxGroupOwnable;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return getKey();
	}
}