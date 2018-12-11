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
import java.util.List;

import net.rithms.riot.api.Dto;

public class CurrentGameParticipant extends Dto implements Serializable {

	private static final long serialVersionUID = -2549733502630146814L;

	private boolean bot;
	private int championId;
	private List<GameCustomizationObject> gameCustomizationObjects;
	private Perks perks;
	private int profileIconId;
	private int spell1Id;
	private int spell2Id;
	private String summonerId;
	private String summonerName;
	private int teamId;

	public int getChampionId() {
		return championId;
	}

	public List<GameCustomizationObject> getGameCustomizationObjects() {
		return gameCustomizationObjects;
	}

	public Perks getPerks() {
		return perks;
	}

	public int getProfileIconId() {
		return profileIconId;
	}

	public int getSpell1Id() {
		return spell1Id;
	}

	public int getSpell2Id() {
		return spell2Id;
	}

	public String getSummonerId() {
		return summonerId;
	}

	public String getSummonerName() {
		return summonerName;
	}

	public int getTeamId() {
		return teamId;
	}

	public boolean isBot() {
		return bot;
	}

	@Override
	public String toString() {
		return getSummonerName();
	}
}