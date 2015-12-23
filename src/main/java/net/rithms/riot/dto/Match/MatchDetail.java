package net.rithms.riot.dto.Match;

import java.io.Serializable;
import java.util.List;

public class MatchDetail implements Serializable {

	private static final long serialVersionUID = 2606895296338330266L;
	private int mapId;
	private long matchCreation, matchDuration, matchId;
	private String matchVersion, queueType, region, season;
	private List<ParticipantIdentity> participantIdentities;
	private List<Participant> participants;
	private List<Team> teams;
	private Timeline timeline;
	private String matchMode, matchType, platformId;

	public String getMatchMode() {
		return matchMode;
	}

	public String getMatchType() {
		return matchType;
	}

	public String getPlatformId() {
		return platformId;
	}

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

	public List<ParticipantIdentity> getParticipantIdentities() {
		return participantIdentities;
	}

	public List<Participant> getParticipants() {
		return participants;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public Timeline getTimeline() {
		return timeline;
	}
}