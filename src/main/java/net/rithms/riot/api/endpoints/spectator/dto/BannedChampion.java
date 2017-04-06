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

package net.rithms.riot.api.endpoints.spectator.dto;

import java.io.Serializable;

import net.rithms.riot.api.Dto;

public class BannedChampion extends Dto implements Serializable {

	private static final long serialVersionUID = -2518840271357794856L;

	private int championId;
	private int pickTurn;
	private int teamId;

	public int getChampionId() {
		return championId;
	}

	public int getPickTurn() {
		return pickTurn;
	}

	public int getTeamId() {
		return teamId;
	}

	@Override
	public String toString() {
		return String.valueOf(getChampionId());
	}
}