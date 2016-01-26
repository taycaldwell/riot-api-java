/*
 * Copyright 2014 Taylor Caldwell
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.rithms.riot.api.endpoints.match.dto;

import java.io.Serializable;
import java.util.List;

public class Event implements Serializable {

	private static final long serialVersionUID = -2911353385877952457L;
	private int creatorId, itemAfter, itemBefore, itemId, killerId, participantId, skillSlot, teamId, victimId;
	private String buildingType, eventType, laneType, levelUpType, monsterType, towerType, wardType;
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