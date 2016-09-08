/*
 * Copyright 2015 Taylor Caldwell
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

package net.rithms.riot.api.endpoints.current_game.dto;

import java.io.Serializable;
import java.util.List;

import net.rithms.riot.api.Dto;

public class CurrentGameInfo extends Dto implements Serializable {

	private static final long serialVersionUID = -6094147804616587912L;

	private List<BannedChampion> bannedChampions;
	private long gameId;
	private long gameLength;
	private String gameMode;
	private int gameQueueConfigId;
	private long gameStartTime;
	private String gameType;
	private int mapId;
	private Observer observers;
	private List<CurrentGameParticipant> participants;
	private String platformId;
	private TeamInfo teamInfoOne;
	private TeamInfo teamInfoTwo;

	public List<BannedChampion> getBannedChampions() {
		return bannedChampions;
	}

	public long getGameId() {
		return gameId;
	}

	public long getGameLength() {
		return gameLength;
	}

	public String getGameMode() {
		return gameMode;
	}

	public int getGameQueueConfigId() {
		return gameQueueConfigId;
	}

	public long getGameStartTime() {
		return gameStartTime;
	}

	public String getGameType() {
		return gameType;
	}

	public int getMapId() {
		return mapId;
	}

	public Observer getObservers() {
		return observers;
	}

	public List<CurrentGameParticipant> getParticipants() {
		return participants;
	}

	public String getPlatformId() {
		return platformId;
	}

	public TeamInfo getTeamInfoOne() {
		return teamInfoOne;
	}

	public TeamInfo getTeamInfoTwo() {
		return teamInfoTwo;
	}

	public void setBannedChampions(List<BannedChampion> bannedChampions) {
		this.bannedChampions = bannedChampions;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

	public void setGameLength(long gameLength) {
		this.gameLength = gameLength;
	}

	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}

	public void setGameQueueConfigId(int gameQueueConfigId) {
		this.gameQueueConfigId = gameQueueConfigId;
	}

	public void setGameStartTime(long gameStartTime) {
		this.gameStartTime = gameStartTime;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
	}

	public void setObservers(Observer observers) {
		this.observers = observers;
	}

	public void setParticipants(List<CurrentGameParticipant> participants) {
		this.participants = participants;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public void setTeamInfoOne(TeamInfo teamInfoOne) {
		this.teamInfoOne = teamInfoOne;
	}

	public void setTeamInfoTwo(TeamInfo teamInfoTwo) {
		this.teamInfoTwo = teamInfoTwo;
	}
}