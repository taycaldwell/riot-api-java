package net.rithms.riot.dto.Match;

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