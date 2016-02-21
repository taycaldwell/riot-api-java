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

package net.rithms.riot.api.endpoints.team.dto;

import java.io.Serializable;
import java.util.List;

public class Team implements Serializable {

	private static final long serialVersionUID = -3318215531984856913L;

	private long createDate;
	private String fullId;
	private long lastGameDate;
	private long lastJoinDate;
	private long lastJoinedRankedTeamQueueDate;
	private List<MatchHistorySummary> matchHistory;
	private long modifyDate;
	private String name;
	private Roster roster;
	private long secondLastJoinDate;
	private String status;
	private String tag;
	private List<TeamStatDetail> teamStatDetails;
	private long thirdLastJoinDate;

	public long getCreateDate() {
		return createDate;
	}

	public String getFullId() {
		return fullId;
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

	public List<MatchHistorySummary> getMatchHistory() {
		return matchHistory;
	}

	public long getModifyDate() {
		return modifyDate;
	}

	public String getName() {
		return name;
	}

	public Roster getRoster() {
		return roster;
	}

	public long getSecondLastJoinDate() {
		return secondLastJoinDate;
	}

	public String getStatus() {
		return status;
	}

	public String getTag() {
		return tag;
	}

	public List<TeamStatDetail> getTeamStatDetails() {
		return teamStatDetails;
	}

	public long getThirdLastJoinDate() {
		return thirdLastJoinDate;
	}
}