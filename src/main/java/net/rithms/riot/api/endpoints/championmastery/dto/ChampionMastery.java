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

import net.rithms.riot.api.Dto;

public class ChampionMastery extends Dto implements Serializable {

	private static final long serialVersionUID = 1980259216579071478L;

	private int championId;
	private int championLevel;
	private int championPoints;
	private long championPointsSinceLastLevel;
	private long championPointsUntilNextLevel;
	private boolean chestGranted;
	private long lastPlayTime;
	private long playerId;
	private int tokensEarned;

	public int getChampionId() {
		return championId;
	}

	public int getChampionLevel() {
		return championLevel;
	}

	public int getChampionPoints() {
		return championPoints;
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

	public int getTokensEarned() {
		return tokensEarned;
	}

	public boolean isChestGranted() {
		return chestGranted;
	}

	public void setChampionId(int championId) {
		this.championId = championId;
	}

	public void setChampionLevel(int championLevel) {
		this.championLevel = championLevel;
	}

	public void setChampionPoints(int championPoints) {
		this.championPoints = championPoints;
	}

	public void setChampionPointsSinceLastLevel(long championPointsSinceLastLevel) {
		this.championPointsSinceLastLevel = championPointsSinceLastLevel;
	}

	public void setChampionPointsUntilNextLevel(long championPointsUntilNextLevel) {
		this.championPointsUntilNextLevel = championPointsUntilNextLevel;
	}

	public void setChestGranted(boolean chestGranted) {
		this.chestGranted = chestGranted;
	}

	public void setLastPlayTime(long lastPlayTime) {
		this.lastPlayTime = lastPlayTime;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public void setTokensEarned(int tokensEarned) {
		this.tokensEarned = tokensEarned;
	}

	@Override
	public String toString() {
		return getChampionId() + ": " + getChampionPoints() + " (Level " + getChampionLevel() + ")";
	}
}