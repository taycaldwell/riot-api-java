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

package net.rithms.riot.api.endpoints.summoner.dto;

import java.io.Serializable;
import java.util.Set;

import net.rithms.riot.api.Dto;

public class RunePage extends Dto implements Serializable {

	private static final long serialVersionUID = 97699628656087959L;

	private boolean current;
	private long id;
	private String name;
	private Set<RuneSlot> slots;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<RuneSlot> getSlots() {
		return slots;
	}

	public boolean isCurrent() {
		return current;
	}

	public void setCurrent(boolean current) {
		this.current = current;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSlots(Set<RuneSlot> slots) {
		this.slots = slots;
	}

	@Override
	public String toString() {
		return getId() + ": " + getName();
	}
}