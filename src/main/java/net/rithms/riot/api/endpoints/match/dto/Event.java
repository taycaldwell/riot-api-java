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

import net.rithms.riot.api.Dto;

public class Event extends Dto implements Serializable {

	private static final long serialVersionUID = -2911353385877952457L;

	private String ascendedType;
	private List<Integer> assistingParticipantIds;
	private String buildingType;
	private int creatorId;
	private String eventType;
	private int itemAfter;
	private int itemBefore;
	private int itemId;
	private int killerId;
	private String laneType;
	private String levelUpType;
	private String monsterType;
	private int participantId;
	private String pointCaptured;
	private Position position;
	private int skillSlot;
	private int teamId;
	private long timestamp;
	private String towerType;
	private int victimId;
	private String wardType;

	public String getAscendedType() {
		return ascendedType;
	}

	public List<Integer> getAssistingParticipantIds() {
		return assistingParticipantIds;
	}

	public String getBuildingType() {
		return buildingType;
	}

	public int getCreatorId() {
		return creatorId;
	}

	public String getEventType() {
		return eventType;
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

	public String getLaneType() {
		return laneType;
	}

	public String getLevelUpType() {
		return levelUpType;
	}

	public String getMonsterType() {
		return monsterType;
	}

	public int getParticipantId() {
		return participantId;
	}

	public String getPointCaptured() {
		return pointCaptured;
	}

	public Position getPosition() {
		return position;
	}

	public int getSkillSlot() {
		return skillSlot;
	}

	public int getTeamId() {
		return teamId;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public String getTowerType() {
		return towerType;
	}

	public int getVictimId() {
		return victimId;
	}

	public String getWardType() {
		return wardType;
	}
	
	public void setAscendedType(String ascendedType) {
		this.ascendedType = ascendedType;
	}

	public void setAssistingParticipantIds(List<Integer> assistingParticipantIds) {
		this.assistingParticipantIds = assistingParticipantIds;
	}

	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}

	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public void setItemAfter(int itemAfter) {
		this.itemAfter = itemAfter;
	}

	public void setItemBefore(int itemBefore) {
		this.itemBefore = itemBefore;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public void setKillerId(int killerId) {
		this.killerId = killerId;
	}

	public void setLaneType(String laneType) {
		this.laneType = laneType;
	}

	public void setLevelUpType(String levelUpType) {
		this.levelUpType = levelUpType;
	}

	public void setMonsterType(String monsterType) {
		this.monsterType = monsterType;
	}

	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}

	public void setPointCaptured(String pointCaptured) {
		this.pointCaptured = pointCaptured;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public void setSkillSlot(int skillSlot) {
		this.skillSlot = skillSlot;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public void setTowerType(String towerType) {
		this.towerType = towerType;
	}

	public void setVictimId(int victimId) {
		this.victimId = victimId;
	}

	public void setWardType(String wardType) {
		this.wardType = wardType;
	}

	@Override
	public String toString() {
		return getEventType();
	}
}