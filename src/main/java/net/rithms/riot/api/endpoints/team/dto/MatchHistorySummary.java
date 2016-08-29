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

package net.rithms.riot.api.endpoints.team.dto;

import java.io.Serializable;

import net.rithms.riot.api.Dto;

public class MatchHistorySummary extends Dto implements Serializable {

	private static final long serialVersionUID = 3300531318253810880L;

	private int assists;
	private long date;
	private int deaths;
	private long gameId;
	private String gameMode;
	private boolean invalid;
	private int kills;
	private int mapId;
	private int opposingTeamKills;
	private String opposingTeamName;
	private boolean win;

	public int getAssists() {
		return assists;
	}

	public long getDate() {
		return date;
	}

	public int getDeaths() {
		return deaths;
	}

	public long getGameId() {
		return gameId;
	}

	public String getGameMode() {
		return gameMode;
	}

	public int getKills() {
		return kills;
	}

	public int getMapId() {
		return mapId;
	}

	public int getOpposingTeamKills() {
		return opposingTeamKills;
	}

	public String getOpposingTeamName() {
		return opposingTeamName;
	}

	public boolean isInvalid() {
		return invalid;
	}

	public boolean isWin() {
		return win;
	}

	@Override
	public String toString() {
		return getGameId() + " (" + getGameMode() + ")";
	}
}