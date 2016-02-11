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

package net.rithms.riot.api.endpoints.tournament.dto;

import java.io.Serializable;
import java.util.Set;

public class TournamentCode implements Serializable {

	private static final long serialVersionUID = -1525318794336918321L;
	private String code, lobbyName, map, metaData, password, pickType, region, spectators;
	private int id, providerId, teamSize, tournamentId;
	private Set<Long> participants;

	public String getCode() {
		return code;
	}

	public String getLobbyName() {
		return lobbyName;
	}

	public String getMap() {
		return map;
	}

	public String getMetaData() {
		return metaData;
	}

	public String getPassword() {
		return password;
	}

	public String getPickType() {
		return pickType;
	}

	public String getRegion() {
		return region;
	}

	public String getSpectators() {
		return spectators;
	}

	public int getId() {
		return id;
	}

	public int getProviderId() {
		return providerId;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public int getTournamentId() {
		return tournamentId;
	}

	public Set<Long> getParticipants() {
		return participants;
	}

	@Override
	public String toString() {
		return getCode();
	}
}