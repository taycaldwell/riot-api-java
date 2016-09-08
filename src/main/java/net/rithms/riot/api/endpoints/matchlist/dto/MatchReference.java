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

package net.rithms.riot.api.endpoints.matchlist.dto;

import java.io.Serializable;

import net.rithms.riot.api.Dto;

public class MatchReference extends Dto implements Serializable {

	private static final long serialVersionUID = 3975874858170021162L;

	private int champion;
	private String lane;
	private long matchId;
	private String platformId;
	private String queue;
	private String region;
	private String role;
	private String season;
	private long timestamp;

	public int getChampion() {
		return champion;
	}

	public String getLane() {
		return lane;
	}

	public long getMatchId() {
		return matchId;
	}

	public String getPlatformId() {
		return platformId;
	}

	public String getQueue() {
		return queue;
	}

	public String getRegion() {
		return region;
	}

	public String getRole() {
		return role;
	}

	public String getSeason() {
		return season;
	}

	public long getTimestamp() {
		return timestamp;
	}
	
	public void setChampion(int champion) {
		this.champion = champion;
	}

	public void setLane(String lane) {
		this.lane = lane;
	}

	public void setMatchId(long matchId) {
		this.matchId = matchId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public void setQueue(String queue) {
		this.queue = queue;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return String.valueOf(getMatchId());
	}
}