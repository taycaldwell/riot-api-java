package net.rithms.riot.constant;

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

import net.rithms.riot.api.RiotStringNotFound;

public enum Map {
	ARAM(12, "Howling Abyss"),
	BUTCHERS_BRIDGE(14,"Butcher's Bridge"),
	CRYSTAL_SCAR(8, "The Crystal Scar"),
	DOMINION(8, "The Crystal Scar"),
	HOWLING_ABYSS(12, "Howling Abyss"),
	PROVING_GROUNDS(3, "Proving Grounds"),
    SUMMONERS_RIFT_2014(11, "Summoner's Rift"),
	SUMMONERS_RIFT_AUTUMN(2, "Summoner's Rift"),
	SUMMONERS_RIFT_SUMMER(1, "Summoner's Rift"),
	TUTORIAL(3, "Proving Grounds"),
	TWISTED_TREELINE_CURRENT(10, "Twisted Treeline"),
	TWISTED_TREELINE_ORIGINAL(4, "Twisted Treeline");

	private int id;
	private String name;

	public static String getNameById(int mapId) throws RiotStringNotFound {
		Map[] maps = Map.values();
		for (Map map : maps) {
			if (mapId == map.getId()) {
				return map.getName();
			}
		}
		throw new RiotStringNotFound("Could not find map " + mapId);
	}

	Map(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return getName();
	}
}