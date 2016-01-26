/*
 * Copyright 2016 Taylor Caldwell
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

package net.rithms.riot.api.endpoints.championmastery.dto;

import java.io.Serializable;

public class ChampionMastery implements Serializable {

	private static final long serialVersionUID = 1980259216579071478L;
	private long championId, championPointsSinceLastLevel, championPointsUntilNextLevel, lastPlayTime, playerId;
	private int championLevel, championPoints;
	private boolean chestGranted;
	private String highestGrade;

	public int getChampionLevel() {
		return championLevel;
	}

	public int getChampionPoints() {
		return championPoints;
	}

	public long getChampionId() {
		return championId;
	}

	public long getChampionPointsSinceLastLevel() {
		return championPointsSinceLastLevel;
	}

	public long getChampionPointsUntilNextLevel() {
		return championPointsUntilNextLevel;
	}

	public long getLastPlayTime() {
		return lastPlayTime;
	}

	public long getPlayerId() {
		return playerId;
	}

	public boolean isChestGranted() {
		return chestGranted;
	}

	public String getHighestGrade() {
		return highestGrade;
	}
}