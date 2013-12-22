package dto;

import java.util.Date;
import java.util.List;

public class Team {
	
	private String fullId, name, status, tag;
	private List<MatchHistorySummary> matchHistory;
	private MessageOfDay messageOfDay;
	private Roster roster;
	private TeamStatSummary teamStatSummary;
	private Date createDate, lastGameDate, lastJoinDate, 
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
	
	public MessageOfDay getMessageOfDay() {
		return messageOfDay;
	}
	
	public Roster getRoster() {
		return roster;
	}
	
	public TeamStatSummary getTeamStatSummary() {
		return teamStatSummary;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public Date getLastGameDate() {
		return lastGameDate;
	}
	
	public Date getLastJoinDate() {
		return lastJoinDate;
	}
	
	public Date getLastJoinedRankedTeamQueueDate() {
		return lastJoinedRankedTeamQueueDate;
	}
	
	public Date getModifyDate() {
		return modifyDate;
	}
	
	public Date getSecondLastJoinDate() {
		return secondLastJoinDate;
	}
	
	public Date getThirdLastJoinDate() {
		return thirdLastJoinDate;
	}
	
}
