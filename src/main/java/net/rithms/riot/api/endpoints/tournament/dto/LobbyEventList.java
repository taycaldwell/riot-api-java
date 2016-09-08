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
import java.util.List;

import net.rithms.riot.api.Dto;

public class LobbyEventList extends Dto implements Serializable {

	private static final long serialVersionUID = -7830193432118565589L;

	private List<LobbyEvent> eventList;

	public List<LobbyEvent> getEventList() {
		return eventList;
	}
	
	public void setEventList(List<LobbyEvent> eventList) {
		this.eventList = eventList;
	}

	@Override
	public String toString() {
		return getEventList().toString();
	}
}