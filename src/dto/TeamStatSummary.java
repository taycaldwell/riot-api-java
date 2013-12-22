package dto;

import java.util.Set;

public class TeamStatSummary {
			
	private String fullId;
	private Set<TeamStatDetail> teamStatDetails;
	
	public String getFullId() {
		return fullId;
	}
	
	public Set<TeamStatDetail> getTeamStatDetails() {
		return teamStatDetails;
	}
	
	
}
