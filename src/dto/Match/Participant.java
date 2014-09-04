package dto.Match;

public class Participant {
	
	private int championId, participantId, spell1Id, spell2Id, teamId;
	private ParticipantStats stats;
	private ParticipantTimeline timeline;
	
	public int getChampionId() {
		return championId;
	}
	
	public int getParticipantId() {
		return participantId;
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
