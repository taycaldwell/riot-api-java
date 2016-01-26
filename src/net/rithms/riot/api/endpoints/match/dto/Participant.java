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

package net.rithms.riot.api.endpoints.match.dto;

import java.io.Serializable;
import java.util.List;

public class Participant implements Serializable {

	private static final long serialVersionUID = -507075680096851928L;
	private int championId, participantId, spell1Id, spell2Id, teamId;
	private ParticipantStats stats;
	private ParticipantTimeline timeline;
	private List<Rune> runes;
	private List<Mastery> masteries;
	private String highestAchievedSeasonTier;

	public String getHighestAchievedSeasonTier() {
		return highestAchievedSeasonTier;
	}

	public int getChampionId() {
		return championId;
	}

	public int getParticipantId() {
		return participantId;
	}

	public List<Rune> getRunes() {
		return runes;
	}

	public List<Mastery> getMasteries() {
		return masteries;
	}

	public int getSpell1Id() {
		return spell1Id;
	}

	public int getSpell2Id() {
		return spell2Id;
	}

	public int getTeamId() {
		return teamId;
	}

	public ParticipantStats getStats() {
		return stats;
	}

	public ParticipantTimeline getTimeline() {
		return timeline;
	}
}