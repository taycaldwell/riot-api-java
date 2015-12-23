package net.rithms.riot.dto.FeaturedGames;

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

import java.io.Serializable;

public class BannedChampion implements Serializable {

	private static final long serialVersionUID = -1094265845803914995L;
	private long championId, teamId;
	private int pickTurn;

	public long getChampionId() {
		return championId;
	}

	public long getTeamId() {
		return teamId;
	}

	public int getPickTurn() {
		return pickTurn;
	}
}