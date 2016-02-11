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

package net.rithms.riot.api.endpoints.current_game.dto;

import java.io.Serializable;
import java.util.List;

public class Participant implements Serializable {

	private static final long serialVersionUID = -2549733502630146814L;
	private boolean bot;
	private long championId, profileIconId, spell1Id, spell2Id, summonerId, teamId;
	private List<Mastery> masteries;
	private List<Rune> runes;
	private String summonerName;

	public boolean isBot() {
		return bot;
	}

	public long getChampionId() {
		return championId;
	}

	public long getProfileIconId() {
		return profileIconId;
	}

	public long getSpell1Id() {
		return spell1Id;
	}

	public long getSpell2Id() {
		return spell2Id;
	}

	public long getSummonerId() {
		return summonerId;
	}

	public long getTeamId() {
		return teamId;
	}

	public List<Mastery> getMasteries() {
		return masteries;
	}

	public List<Rune> getRunes() {
		return runes;
	}

	public String getSummonerName() {
		return summonerName;
	}
}