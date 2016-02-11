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

package net.rithms.riot.api.endpoints.featured_game.dto;

import java.io.Serializable;
import java.util.List;

public class CurrentGameInfo implements Serializable {

	private static final long serialVersionUID = -3351906462835367100L;
	private List<BannedChampion> bannedChampions;
	private List<Participant> participants;
	private String gameMode, gameType, platformId;
	private Observer observers;
	private long gameId, gameLength, gameQueueConfigId, gameStartTime, gameTypeConfigId, mapId;

	public List<BannedChampion> getBannedChampions() {
		return bannedChampions;
	}

	public List<Participant> getParticipants() {
		return participants;
	}

	public String getGameMode() {
		return gameMode;
	}

	public String getGameType() {
		return gameType;
	}

	public String getPlatformId() {
		return platformId;
	}

	public Observer getObservers() {
		return observers;
	}

	public long getGameId() {
		return gameId;
	}

	public long getGameLength() {
		return gameLength;
	}

	public long getGameQueueConfigId() {
		return gameQueueConfigId;
	}

	public long getGameStartTime() {
		return gameStartTime;
	}

	public long getGameTypeConfigId() {
		return gameTypeConfigId;
	}

	public long getMapId() {
		return mapId;
	}
}