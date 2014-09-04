package dto.Team;

import java.util.List;

public class Roster {
	
	private long ownerId;
	private List<TeamMemberInfo> memberList;
	
	public long getOwnerId() {
		return ownerId;
	}
	
	public List<TeamMemberInfo> getMemberList() {
		return memberList;
	}
	
}
