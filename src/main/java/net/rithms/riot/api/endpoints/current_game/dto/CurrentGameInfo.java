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

public class CurrentGameInfo implements Serializable {

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

	@Deprecated
	private int gameTypeConfigId;
	@Deprecated
	private TeamInfo teamInfoOne;
	@Deprecated
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

	@Deprecated
	public int getGameTypeConfigId() {
		return gameTypeConfigId;
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

	@Deprecated
	public TeamInfo getTeamInfoOne() {
		return teamInfoOne;
	}

	@Deprecated
	public TeamInfo getTeamInfoTwo() {
		return teamInfoTwo;
	}
}