package dto.MatchHistory;

import java.util.List;

import dto.Match.Participant;
import dto.Match.ParticipantIdentity;

public class MatchSummary {

	private int mapId;
	private long matchCreation, matchDuration, matchId;
	private String matchVersion, queueType, region, season;
	private List<Participant> participants;
	private List<ParticipantIdentity> participantIdentities;
	
	public int getMapId() {
		return mapId;
	}
	
	public long getMatchCreation() {
		return matchCreation;
	}
	
	public long getMatchDuration() {
		return matchDuration;
	}
	
	public long getMatchId() {
		return matchId;
	}
	
	public String getMatchVersion() {
		return matchVersion;
	}
	
	public String getQueueType() {
		return queueType;
	}
	
	public String getRegion() {
		return region;
	}
	
	public String getSeason() {
		return season;
	}
	
	public List<Participant> getParticipants() {
		return participants;
	}
	
	public List<ParticipantIdentity> getParticipantIdentities() {
		return participantIdentities;
	}
	
}
