package net.rithms.dto.Status;

import java.io.Serializable;
import java.util.List;

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

public class ShardStatus implements Serializable {

	private static final long serialVersionUID = -530404100006610537L;
	private List<String> locales;
	private List<Service> services;
	private String hostname, name, region_tag, slug;
	
	public List<String> getLocales() {
		return locales;
	}
	public List<Service> getServices() {
		return services;
	}
	public String getHostname() {
		return hostname;
	}
	public String getName() {
		return name;
	}
	public String getRegion_tag() {
		return region_tag;
	}
	public String getSlug() {
		return slug;
	}

}
