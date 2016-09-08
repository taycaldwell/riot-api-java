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

package net.rithms.riot.api.endpoints.league.dto;

import java.io.Serializable;
import java.util.List;

import net.rithms.riot.api.Dto;

public class League extends Dto implements Serializable {

	private static final long serialVersionUID = 1878237445691308532L;

	private List<LeagueEntry> entries;
	private String name;
	private String participantId;
	private String queue;
	private String tier;

	public List<LeagueEntry> getEntries() {
		return entries;
	}

	public String getName() {
		return name;
	}

	public String getParticipantId() {
		return participantId;
	}

	public String getQueue() {
		return queue;
	}

	public String getTier() {
		return tier;
	}

	public void setEntries(List<LeagueEntry> entries) {
		this.entries = entries;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setParticipantId(String participantId) {
		this.participantId = participantId;
	}

	public void setQueue(String queue) {
		this.queue = queue;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}

	@Override
	public String toString() {
		return getName();
	}
}