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

package net.rithms.riot.api.endpoints.league.dto;

import java.io.Serializable;

import net.rithms.riot.api.Dto;

public class LeagueEntry extends Dto implements Serializable {

	private static final long serialVersionUID = 3987113536371700279L;

	private String division;
	private boolean isFreshBlood;
	private boolean isHotStreak;
	private boolean isInactive;
	private boolean isVeteran;
	private int leaguePoints;
	private int losses;
	private MiniSeries miniSeries;
	private String playerOrTeamId;
	private String playerOrTeamName;
	private int wins;

	public String getDivision() {
		return division;
	}

	public int getLeaguePoints() {
		return leaguePoints;
	}

	public int getLosses() {
		return losses;
	}

	public MiniSeries getMiniSeries() {
		return miniSeries;
	}

	public String getPlayerOrTeamId() {
		return playerOrTeamId;
	}

	public String getPlayerOrTeamName() {
		return playerOrTeamName;
	}

	public int getWins() {
		return wins;
	}

	public boolean isFreshBlood() {
		return isFreshBlood;
	}

	public boolean isHotStreak() {
		return isHotStreak;
	}

	public boolean isInactive() {
		return isInactive;
	}

	public boolean isVeteran() {
		return isVeteran;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public void setFreshBlood(boolean isFreshBlood) {
		this.isFreshBlood = isFreshBlood;
	}

	public void setHotStreak(boolean isHotStreak) {
		this.isHotStreak = isHotStreak;
	}

	public void setInactive(boolean isInactive) {
		this.isInactive = isInactive;
	}

	public void setVeteran(boolean isVeteran) {
		this.isVeteran = isVeteran;
	}

	public void setLeaguePoints(int leaguePoints) {
		this.leaguePoints = leaguePoints;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public void setMiniSeries(MiniSeries miniSeries) {
		this.miniSeries = miniSeries;
	}

	public void setPlayerOrTeamId(String playerOrTeamId) {
		this.playerOrTeamId = playerOrTeamId;
	}

	public void setPlayerOrTeamName(String playerOrTeamName) {
		this.playerOrTeamName = playerOrTeamName;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	@Override
	public String toString() {
		return getPlayerOrTeamName();
	}
}