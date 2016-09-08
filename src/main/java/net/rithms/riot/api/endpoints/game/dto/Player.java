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

package net.rithms.riot.api.endpoints.game.dto;

import java.io.Serializable;

import net.rithms.riot.api.Dto;

public class Player extends Dto implements Serializable {

	private static final long serialVersionUID = -2222223068241891011L;

	private int championId;
	private long summonerId;
	private int teamId;

	public int getChampionId() {
		return championId;
	}

	public long getSummonerId() {
		return summonerId;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setChampionId(int championId) {
		this.championId = championId;
	}

	public void setSummonerId(long summonerId) {
		this.summonerId = summonerId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	@Override
	public String toString() {
		return String.valueOf(getSummonerId());
	}
}