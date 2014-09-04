package dto.Team;

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

public class MatchHistorySummary {

	private int assists, deaths, kills, mapId, opposingTeamKills;
	private String gameMode, opposingTeamName;
	private boolean invalid, win;
	private long gameId, date;
	
	public int getAssists() {
		return assists;
	}
	
	public int getDeaths() {
		return deaths;
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
	
	public String getGameMode() {
		return gameMode;
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
	
	public long getGameId() {
		return gameId;
	}

	public long getDate() {
		return date;
	}
	
}
