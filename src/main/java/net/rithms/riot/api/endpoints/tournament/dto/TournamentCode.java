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

import net.rithms.riot.api.Dto;

public class TournamentCode extends Dto implements Serializable {

	private static final long serialVersionUID = -1525318794336918321L;

	private String code;
	private int id;
	private String lobbyName;
	private String map;
	private String metaData;
	private Set<Long> participants;
	private String password;
	private String pickType;
	private int providerId;
	private String region;
	private String spectators;
	private int teamSize;
	private int tournamentId;

	public String getCode() {
		return code;
	}

	public int getId() {
		return id;
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

	public Set<Long> getParticipants() {
		return participants;
	}

	public String getPassword() {
		return password;
	}

	public String getPickType() {
		return pickType;
	}

	public int getProviderId() {
		return providerId;
	}

	public String getRegion() {
		return region;
	}

	public String getSpectators() {
		return spectators;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public int getTournamentId() {
		return tournamentId;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLobbyName(String lobbyName) {
		this.lobbyName = lobbyName;
	}

	public void setMap(String map) {
		this.map = map;
	}

	public void setMetaData(String metaData) {
		this.metaData = metaData;
	}

	public void setParticipants(Set<Long> participants) {
		this.participants = participants;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPickType(String pickType) {
		this.pickType = pickType;
	}

	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setSpectators(String spectators) {
		this.spectators = spectators;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	public void setTournamentId(int tournamentId) {
		this.tournamentId = tournamentId;
	}

	@Override
	public String toString() {
		return getCode();
	}
}