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

package net.rithms.riot.constant;

import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotStringNotFoundException;

public enum Region {
	BR("br.api.pvp.net", "br"),
	EUNE("eune.api.pvp.net", "eune"),
	EUW("euw.api.pvp.net", "euw"),
	KR("kr.api.pvp.net", "kr"),
	LAS("las.api.pvp.net", "las"),
	LAN("lan.api.pvp.net", "lan"),
	NA("na.api.pvp.net", "na"),
	OCE("oce.api.pvp.net", "oce"),
	PBE("pbe.api.pvp.net", "pbe"),
	RU("ru.api.pvp.net", "ru"),
	TR("tr.api.pvp.net", "tr"),
	GLOBAL("global.api.pvp.net", "global");

	private String endpoint;
	private String region;

	public static Region getRegionByName(String name) throws RiotStringNotFoundException {
		for (Region region : Region.values()) {
			if (region.getName().equals(name.toLowerCase())) {
				return region;
			}
		}
		RiotApi.log.warning("Unknown region: " + name);
		throw new RiotStringNotFoundException("Could not find region " + name);
	}

	public static Region getRegionByPlatformId(PlatformId platformId) {
		try {
			return getRegionByName(platformId.getName());
		} catch (RiotStringNotFoundException e) {
			return null;
		}
	}

	Region(String endpoint, String region) {
		this.endpoint = endpoint;
		this.region = region;
	}

	public String getEndpoint(boolean withRegion) {
		String url = "https://" + endpoint + "/api/lol/";
		if (withRegion) {
			url += getName();
		}
		return url;
	}

	public String getEndpoint() {
		return getEndpoint(true);
	}

	public String getName() {
		return region;
	}

	@Override
	public String toString() {
		return getName();
	}
}