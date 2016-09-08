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

package net.rithms.riot.api.endpoints.featured_game.dto;

import java.io.Serializable;

import net.rithms.riot.api.Dto;

public class Participant extends Dto implements Serializable {

	private static final long serialVersionUID = 7105307616042600638L;

	private boolean bot;
	private int championId;
	private int profileIconId;
	private int spell1Id;
	private int spell2Id;
	private String summonerName;
	private int teamId;

	public int getChampionId() {
		return championId;
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

	public String getSummonerName() {
		return summonerName;
	}

	public int getTeamId() {
		return teamId;
	}

	public boolean isBot() {
		return bot;
	}

	public void setBot(boolean bot) {
		this.bot = bot;
	}

	public void setChampionId(int championId) {
		this.championId = championId;
	}

	public void setProfileIconId(int profileIconId) {
		this.profileIconId = profileIconId;
	}

	public void setSpell1Id(int spell1Id) {
		this.spell1Id = spell1Id;
	}

	public void setSpell2Id(int spell2Id) {
		this.spell2Id = spell2Id;
	}

	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	@Override
	public String toString() {
		return getSummonerName();
	}
}