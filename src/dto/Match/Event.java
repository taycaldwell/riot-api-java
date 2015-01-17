package dto.Match;

import java.util.List;

public class Event {
	
	private int creatorId, itemAfter, itemBefore, itemId, killerId,
				participantId, skillSlot, teamId, victimId;
	private String buildingType, eventType, laneType, levelUpType,
					monsterType, towerType, wardType;
	private List<Integer> assistingParticipantIds;
	private Position position;
	private long timestamp;
	
	public int getCreatorId() {
		return creatorId;
	}
	
	public int getItemAfter() {
		return itemAfter;
	}
	
	public int getItemBefore() {
		return itemBefore;
	}
	
	public int getItemId() {
		return itemId;
	}
	
	public int getKillerId() {
		return killerId;
	}
	
	public int getParticipantId() {
		return participantId;
	}
	
	public int getSkillSlot() {
		return skillSlot;
	}
	
	public int getTeamId() {
		return teamId;
	}
	
	public int getVictimId() {
		return victimId;
	}
	
	public String getBuildingType() {
		return buildingType;
	}
	
	public String getEventType() {
		return eventType;
	}
	
	public String getLaneType() {
		return laneType;
	}
	
	public String getLevelUpType() {
		return levelUpType;
	}
	
	public String getMonsterType() {
		return monsterType;
	}
	
	public String getTowerType() {
		return towerType;
	}
	
	public String getWardType() {
		return wardType;
	}
	
	public List<Integer> getAssistingParticipantIds() {
		return assistingParticipantIds;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public long getTimestamp() {
		return timestamp;
	}
	
}
