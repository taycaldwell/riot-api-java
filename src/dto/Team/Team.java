package dto.Team;

import java.util.List;

public class Team {
	
	private String fullId, name, status, tag;
	private List<MatchHistorySummary> matchHistory;
	private List<TeamStatDetail> teamStatDetails;
	private Roster roster;
	private long createDate, lastGameDate, lastJoinDate, 
				 lastJoinedRankedTeamQueueDate, modifyDate, 
				 secondLastJoinDate, thirdLastJoinDate;
	
	public String getFullId() {
		return fullId;
	}
	
	public String getName() {
		return name;
	}
	
	public String getStatus() {
		return status;
	}
	
	public String getTag() {
		return tag;
	}
	
	public List<MatchHistorySummary> getMatchHistory() {
		return matchHistory;
	}
	
	public Roster getRoster() {
		return roster;
	}
	
	public long getCreateDate() {
		return createDate;
	}
	
	public long getLastGameDate() {
		return lastGameDate;
	}
	
	public long getLastJoinDate() {
		return lastJoinDate;
	}
	
	public long getLastJoinedRankedTeamQueueDate() {
		return lastJoinedRankedTeamQueueDate;
	}
	
	public long getModifyDate() {
		return modifyDate;
	}
	
	public long getSecondLastJoinDate() {
		return secondLastJoinDate;
	}
	
	public long getThirdLastJoinDate() {
		return thirdLastJoinDate;
	}

	public List<TeamStatDetail> getTeamStatDetails() {
		return teamStatDetails;
	}

}
