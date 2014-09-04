package dto.Game;

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

import java.util.List;

public class Game {

	private int championId, ipEarned, level, mapId, spell1, spell2, teamId;
	private long createDate, gameId;
	private List<Player> fellowPlayers;
	private String gameMode, gameType, subType;
	private boolean invalid;
	private RawStats stats;
	
	
	public long getCreateDate() {
		return createDate;
	}

	public long getGameId() {
		return gameId;
	}

	public int getTeamId() {
		return teamId;
	}

	public int getLevel() {
		return level;
	}

	public int getSpell2() {
		return spell2;
	}

	public int getChampionId() {
		return championId;
	}

	public List<Player> getFellowPlayers() {
		return fellowPlayers;
	}

	public int getSpell1() {
		return spell1;
	}

	public int getMapId() {
		return mapId;
	}

	public boolean isInvalid() {
		return invalid;
	}

	public String getSubType() {
		return subType;
	}

	public String getGameType() {
		return gameType;
	}

	public String getGameMode() {
		return gameMode;
	}

	public int getIpEarned() {
		return ipEarned;
	}

	public RawStats getStats() {
		return stats;
	}

}
