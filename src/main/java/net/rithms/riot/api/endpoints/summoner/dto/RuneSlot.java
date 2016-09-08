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

import net.rithms.riot.api.Dto;

public class RuneSlot extends Dto implements Serializable {

	private static final long serialVersionUID = -8204125507572318573L;

	private int runeId;
	private int runeSlotId;

	public int getRuneId() {
		return runeId;
	}

	public int getRuneSlotId() {
		return runeSlotId;
	}
	
	public void setRuneId(int runeId) {
		this.runeId = runeId;
	}

	public void setRuneSlotId(int runeSlotId) {
		this.runeSlotId = runeSlotId;
	}

	@Override
	public String toString() {
		return getRuneSlotId() + ": " + getRuneId();
	}
}