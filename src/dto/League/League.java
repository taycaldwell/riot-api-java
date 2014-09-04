package dto.League;

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

import java.util.List;

public class League {

	private List<LeagueEntry> entries;
	private String name, queue, tier, participantId;
	
	public List<LeagueEntry> getEntries() {
		return entries;
	}

	public String getName() {
		return name;
	}
	
	public String getQueue() {
		return queue;
	}

	public String getTier() {
		return tier;
	}

	public String getParticipantId() {
		return participantId;
	}
	
}
