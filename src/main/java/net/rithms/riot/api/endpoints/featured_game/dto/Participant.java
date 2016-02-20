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

package net.rithms.riot.api.endpoints.featured_game.dto;

import java.io.Serializable;
import java.util.List;

public class Participant implements Serializable {

	private static final long serialVersionUID = 7105307616042600638L;

	private boolean bot;
	private int championId;
	private int profileIconId;
	private int spell1Id;
	private int spell2Id;
	private String summonerName;
	private int teamId;

	@Deprecated
	private long summonerId;
	@Deprecated
	private long teamParticipantId;
	@Deprecated
	private List<Mastery> masteries;
	@Deprecated
	private List<Rune> runes;

	public int getChampionId() {
		return championId;
	}

	@Deprecated
	public List<Mastery> getMasteries() {
		return masteries;
	}

	public int getProfileIconId() {
		return profileIconId;
	}

	@Deprecated
	public List<Rune> getRunes() {
		return runes;
	}

	public int getSpell1Id() {
		return spell1Id;
	}

	public int getSpell2Id() {
		return spell2Id;
	}

	@Deprecated
	public long getSummonerId() {
		return summonerId;
	}

	public String getSummonerName() {
		return summonerName;
	}

	public int getTeamId() {
		return teamId;
	}

	@Deprecated
	public long getTeamParticipantId() {
		return teamParticipantId;
	}

	public boolean isBot() {
		return bot;
	}
}