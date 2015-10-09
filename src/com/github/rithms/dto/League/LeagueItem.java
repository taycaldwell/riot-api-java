package com.github.rithms.dto.League;

import java.io.Serializable;

/** DEPRECATED **/

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

public class LeagueItem implements Serializable {

	private static final long serialVersionUID = 1806506962119201213L;
	private String leagueName, playerOrTeamId, playerOrTeamName, queueType, rank, tier;
	private boolean isFreshBlood, isHotStreak, isInactive, isVeteran;
	private int leaguePoints, wins, losses;
	private long lastPlayed;
	private MiniSeries miniSeries;
	
	public String getPlayerOrTeamId() {
		return playerOrTeamId;
	}

	public boolean isHotStreak() {
		return isHotStreak;
	}

	public boolean isInactive() {
		return isInactive;
	}

	public int getLeaguePoints() {
		return leaguePoints;
	}

	public int getWins() {
		return wins;
	}
	
	public int getLosses(){
		return losses;
	}

	public long getLastPlayed() {
		return lastPlayed;
	}

	public MiniSeries getMiniSeries() {
		return miniSeries;
	}

	public String getRank() {
		return rank;
	}

	public boolean isFreshBlood() {
		return isFreshBlood;
	}


	public String getLeagueName() {
		return leagueName;
	}

	public String getPlayerOrTeamName() {
		return playerOrTeamName;
	}


	public String getQueueType() {
		return queueType;
	}


	public boolean isVeteran() {
		return isVeteran;
	}


	public String getTier() {
		return tier;
	}


	
}
