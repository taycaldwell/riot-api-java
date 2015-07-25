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

import java.io.Serializable;
import java.util.List;

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

/**
 * @deprecated  As of release 3.6.0
 */
public class MatchSummary implements Serializable {

	private static final long serialVersionUID = -6127065346549837016L;
	private int mapId;
	private long matchCreation, matchDuration, matchId;
	private String matchVersion, queueType, region, season;
	private List<Participant> participants;
	private List<ParticipantIdentity> participantIdentities;
	private String matchType, matchMode, platformId;
	
	public String getPlatformId() {
		return platformId;
	}

	public String getMatchType() {
		return matchType;
	}

	public String getMatchMode() {
		return matchMode;
	}

	public int getMapId() {
		return mapId;
	}
	
	public long getMatchCreation() {
		return matchCreation;
	}
	
	public long getMatchDuration() {
		return matchDuration;
	}
	
	public long getMatchId() {
		return matchId;
	}
	
	public String getMatchVersion() {
		return matchVersion;
	}
	
	public String getQueueType() {
		return queueType;
	}
	
	public String getRegion() {
		return region;
	}
	
	public String getSeason() {
		return season;
	}
	
	public List<Participant> getParticipants() {
		return participants;
	}
	
	public List<ParticipantIdentity> getParticipantIdentities() {
		return participantIdentities;
	}
	
}
