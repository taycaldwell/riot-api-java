/*
 * Copyright 2015 Taylor Caldwell
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

package net.rithms.riot.api.endpoints.tournament.dto;

import java.io.Serializable;

import net.rithms.riot.api.Dto;

public class LobbyEvent extends Dto implements Serializable {

	private static final long serialVersionUID = 2914669820313091597L;

	private String eventType;
	private String summonerId;
	private String timestamp;

	public String getEventType() {
		return eventType;
	}

	public String getSummonerId() {
		return summonerId;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public void setSummonerId(String summonerId) {
		this.summonerId = summonerId;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return getEventType();
	}
}