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

import net.rithms.riot.api.Dto;

public class Participant extends Dto implements Serializable {

	private static final long serialVersionUID = -507075680096851928L;

	private int championId;
	private String highestAchievedSeasonTier;
	private List<Mastery> masteries;
	private int participantId;
	private List<Rune> runes;
	private int spell1Id;
	private int spell2Id;
	private ParticipantStats stats;
	private int teamId;
	private ParticipantTimeline timeline;

	public int getChampionId() {
		return championId;
	}

	public String getHighestAchievedSeasonTier() {
		return highestAchievedSeasonTier;
	}

	public List<Mastery> getMasteries() {
		return masteries;
	}

	public int getParticipantId() {
		return participantId;
	}

	public List<Rune> getRunes() {
		return runes;
	}

	public int getSpell1Id() {
		return spell1Id;
	}

	public int getSpell2Id() {
		return spell2Id;
	}

	public ParticipantStats getStats() {
		return stats;
	}

	public int getTeamId() {
		return teamId;
	}

	public ParticipantTimeline getTimeline() {
		return timeline;
	}

	public void setChampionId(int championId) {
		this.championId = championId;
	}

	public void setHighestAchievedSeasonTier(String highestAchievedSeasonTier) {
		this.highestAchievedSeasonTier = highestAchievedSeasonTier;
	}

	public void setMasteries(List<Mastery> masteries) {
		this.masteries = masteries;
	}

	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}

	public void setRunes(List<Rune> runes) {
		this.runes = runes;
	}

	public void setSpell1Id(int spell1Id) {
		this.spell1Id = spell1Id;
	}

	public void setSpell2Id(int spell2Id) {
		this.spell2Id = spell2Id;
	}

	public void setStats(ParticipantStats stats) {
		this.stats = stats;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public void setTimeline(ParticipantTimeline timeline) {
		this.timeline = timeline;
	}

	@Override
	public String toString() {
		return String.valueOf(getParticipantId());
	}
}