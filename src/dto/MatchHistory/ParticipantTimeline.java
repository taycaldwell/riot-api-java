package dto.MatchHistory;

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

public class ParticipantTimeline {

	private String lane, role;
	private ParticipantTimelineData ancientGolemAssistsPerMinCounts, ancientGolemKillsPerMinCounts,
				assistedLaneDeathsPerMinDeltas, assistedLaneKillsPerMinDeltas, baronAssistsPerMinCounts,
				baronKillsPerMinCounts, creepsPerMinDeltas, csDiffPerMinDeltas, damageTakenDiffPerMinDeltas,
				damageTakenPerMinDeltas, dragonAssistsPerMinCounts, dragonKillsPerMinCounts, elderLizardAssistsPerMinCounts,
				elderLizardKillsPerMinCounts, goldPerMinDeltas, inhibitorAssistsPerMinCounts, inhibitorKillsPerMinCounts,
				towerAssistsPerMinCounts, towerKillsPerMinCounts, towerKillsPerMinDeltas, vilemawAssistsPerMinCounts,
				vilemawKillsPerMinCounts, wardsPerMinDeltas, xpDiffPerMinDeltas, xpPerMinDeltas;
	
	public String getLane() {
		return lane;
	}
	
	public String getRole() {
		return role;
	}
	
	public ParticipantTimelineData getAncientGolemAssistsPerMinCounts() {
		return ancientGolemAssistsPerMinCounts;
	}
	
	public ParticipantTimelineData getAncientGolemKillsPerMinCounts() {
		return ancientGolemKillsPerMinCounts;
	}
	
	public ParticipantTimelineData getAssistedLaneDeathsPerMinDeltas() {
		return assistedLaneDeathsPerMinDeltas;
	}
	
	public ParticipantTimelineData getAssistedLaneKillsPerMinDeltas() {
		return assistedLaneKillsPerMinDeltas;
	}
	
	public ParticipantTimelineData getBaronAssistsPerMinCounts() {
		return baronAssistsPerMinCounts;
	}
	
	public ParticipantTimelineData getBaronKillsPerMinCounts() {
		return baronKillsPerMinCounts;
	}
	
	public ParticipantTimelineData getCreepsPerMinDeltas() {
		return creepsPerMinDeltas;
	}
	
	public ParticipantTimelineData getCsDiffPerMinDeltas() {
		return csDiffPerMinDeltas;
	}
	public ParticipantTimelineData getDamageTakenDiffPerMinDeltas() {
		return damageTakenDiffPerMinDeltas;
	}
	
	public ParticipantTimelineData getDamageTakenPerMinDeltas() {
		return damageTakenPerMinDeltas;
	}
	
	public ParticipantTimelineData getDragonAssistsPerMinCounts() {
		return dragonAssistsPerMinCounts;
	}
	
	public ParticipantTimelineData getDragonKillsPerMinCounts() {
		return dragonKillsPerMinCounts;
	}
	
	public ParticipantTimelineData getElderLizardAssistsPerMinCounts() {
		return elderLizardAssistsPerMinCounts;
	}
	
	public ParticipantTimelineData getElderLizardKillsPerMinCounts() {
		return elderLizardKillsPerMinCounts;
	}
	
	public ParticipantTimelineData getGoldPerMinDeltas() {
		return goldPerMinDeltas;
	}
	
	public ParticipantTimelineData getInhibitorAssistsPerMinCounts() {
		return inhibitorAssistsPerMinCounts;
	}
	
	public ParticipantTimelineData getInhibitorKillsPerMinCounts() {
		return inhibitorKillsPerMinCounts;
	}
	
	public ParticipantTimelineData getTowerAssistsPerMinCounts() {
		return towerAssistsPerMinCounts;
	}
	public ParticipantTimelineData getTowerKillsPerMinCounts() {
		return towerKillsPerMinCounts;
	}
	
	public ParticipantTimelineData getTowerKillsPerMinDeltas() {
		return towerKillsPerMinDeltas;
	}
	
	public ParticipantTimelineData getVilemawAssistsPerMinCounts() {
		return vilemawAssistsPerMinCounts;
	}
	
	public ParticipantTimelineData getVilemawKillsPerMinCounts() {
		return vilemawKillsPerMinCounts;
	}
	
	public ParticipantTimelineData getWardsPerMinDeltas() {
		return wardsPerMinDeltas;
	}
	
	public ParticipantTimelineData getXpDiffPerMinDeltas() {
		return xpDiffPerMinDeltas;
	}
	
	public ParticipantTimelineData getXpPerMinDeltas() {
		return xpPerMinDeltas;
	}
	
}
