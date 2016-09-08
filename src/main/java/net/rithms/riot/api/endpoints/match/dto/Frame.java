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
import java.util.Map;

import net.rithms.riot.api.Dto;

public class Frame extends Dto implements Serializable {

	private static final long serialVersionUID = 4359409042534560829L;

	private List<Event> events;
	private Map<String, ParticipantFrame> participantFrames;
	private long timestamp;

	public List<Event> getEvents() {
		return events;
	}

	public Map<String, ParticipantFrame> getParticipantFrames() {
		return participantFrames;
	}

	public long getTimestamp() {
		return timestamp;
	}
	
	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public void setParticipantFrames(Map<String, ParticipantFrame> participantFrames) {
		this.participantFrames = participantFrames;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return String.valueOf(getTimestamp());
	}
}