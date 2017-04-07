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

package net.rithms.riot.api.endpoints.lol_status.dto;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import net.rithms.riot.api.Dto;

public class ShardStatus extends Dto implements Serializable {

	private static final long serialVersionUID = -530404100006610537L;

	private String hostname;
	private List<String> locales;
	private String name;
	@SerializedName(value = "region_tag")
	private String regionTag;
	private List<Service> services;
	private String slug;

	public String getHostname() {
		return hostname;
	}

	public List<String> getLocales() {
		return locales;
	}

	public String getName() {
		return name;
	}

	public String getRegionTag() {
		return regionTag;
	}

	public List<Service> getServices() {
		return services;
	}

	public String getSlug() {
		return slug;
	}

	@Override
	public String toString() {
		return getName();
	}
}