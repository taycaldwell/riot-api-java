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

package net.rithms.riot.api.endpoints.match.dto;

import java.io.Serializable;
import java.util.List;

import net.rithms.riot.api.Dto;

public class Match extends Dto implements Serializable {

	private static final long serialVersionUID = 2606895296338330266L;

	private long gameCreation;
	private long gameDuration;
	private long gameId;
	private String gameMode;
	private String gameType;
	private String gameVersion;
	private int mapId;
	private List<ParticipantIdentity> participantIdentities;
	private List<Participant> participants;
	private String platformId;
	private int queueId;
	private int seasonId;
	private List<TeamStats> teams;

	public long getGameCreation() {
		return gameCreation;
	}

	public long getGameDuration() {
		return gameDuration;
	}

	public long getGameId() {
		return gameId;
	}

	public String getGameMode() {
		return gameMode;
	}

	public String getGameType() {
		return gameType;
	}

	public String getGameVersion() {
		return gameVersion;
	}

	public int getMapId() {
		return mapId;
	}

	public List<ParticipantIdentity> getParticipantIdentities() {
		return participantIdentities;
	}

	public List<Participant> getParticipants() {
		return participants;
	}

	public String getPlatformId() {
		return platformId;
	}

	public int getQueueId() {
		return queueId;
	}

	public int getSeasonId() {
		return seasonId;
	}

	public List<TeamStats> getTeams() {
		return teams;
	}

	@Override
	public String toString() {
		return String.valueOf(getGameId());
	}
}