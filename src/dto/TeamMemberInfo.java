package dto;

import java.util.Date;

public class TeamMemberInfo {
	
	private Date inviteDate, joinDate;
	private long playerId;
	private String status;
	
	public Date getInviteDate() {
		return inviteDate;
	}
	
	public Date getJoinDate() {
		return joinDate;
	}
	
	public long getPlayerId() {
		return playerId;
	}
	
	public String getStatus() {
		return status;
	}
	
	
	
}
