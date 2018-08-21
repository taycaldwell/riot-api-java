/*
 * Copyright 2018 Taylor Caldwell
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

package net.rithms.riot.api.endpoints.champion.dto;

import java.io.Serializable;
import java.util.List;

import net.rithms.riot.api.Dto;

/**
 * This object contains champion rotation information.
 */
public class ChampionInfo extends Dto implements Serializable {

	private static final long serialVersionUID = 485607278126377515L;

	private List<Integer> freeChampionIds;
	private List<Integer> freeChampionIdsForNewPlayers;
	private int maxNewPlayerLevel;

	public List<Integer> getFreeChampionIds() {
		return freeChampionIds;
	}

	public List<Integer> getFreeChampionIdsForNewPlayers() {
		return freeChampionIdsForNewPlayers;
	}

	public int getMaxNewPlayerLevel() {
		return maxNewPlayerLevel;
	}
}