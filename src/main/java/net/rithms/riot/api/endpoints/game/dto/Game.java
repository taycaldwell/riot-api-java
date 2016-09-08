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

package net.rithms.riot.api.endpoints.game.dto;

import java.io.Serializable;
import java.util.List;

import net.rithms.riot.api.Dto;

public class Game extends Dto implements Serializable {

	private static final long serialVersionUID = 1228681223919935293L;

	private int championId;
	private long createDate;
	private List<Player> fellowPlayers;
	private long gameId;
	private String gameMode;
	private String gameType;
	private boolean invalid;
	private int ipEarned;
	private int level;
	private int mapId;
	private int spell1;
	private int spell2;
	private RawStats stats;
	private String subType;
	private int teamId;

	public int getChampionId() {
		return championId;
	}

	public long getCreateDate() {
		return createDate;
	}

	public List<Player> getFellowPlayers() {
		return fellowPlayers;
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

	public int getIpEarned() {
		return ipEarned;
	}

	public int getLevel() {
		return level;
	}

	public int getMapId() {
		return mapId;
	}

	public int getSpell1() {
		return spell1;
	}

	public int getSpell2() {
		return spell2;
	}

	public RawStats getStats() {
		return stats;
	}

	public String getSubType() {
		return subType;
	}

	public int getTeamId() {
		return teamId;
	}

	public boolean isInvalid() {
		return invalid;
	}
	
	public void setChampionId(int championId) {
		this.championId = championId;
	}

	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}

	public void setFellowPlayers(List<Player> fellowPlayers) {
		this.fellowPlayers = fellowPlayers;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public void setInvalid(boolean invalid) {
		this.invalid = invalid;
	}

	public void setIpEarned(int ipEarned) {
		this.ipEarned = ipEarned;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
	}

	public void setSpell1(int spell1) {
		this.spell1 = spell1;
	}

	public void setSpell2(int spell2) {
		this.spell2 = spell2;
	}

	public void setStats(RawStats stats) {
		this.stats = stats;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	@Override
	public String toString() {
		return getGameId() + " (" + getGameMode() + ")";
	}
}