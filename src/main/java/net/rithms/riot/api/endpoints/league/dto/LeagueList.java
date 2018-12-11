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

public class LeagueList extends Dto implements Serializable {

	private static final long serialVersionUID = 1878237445691308532L;

	private List<LeagueItem> entries;
	private String leagueId;
	private String name;
	private String queue;
	private String tier;

	public List<LeagueItem> getEntries() {
		return entries;
	}

	/**
	 * Utility method to get the entry by {@code summonerId}.
	 * 
	 * @param summonerId
	 *            Summoner ID
	 * @return Entry from {@link #getEntries()} matching {@code summonerId}, or {@code null} if there is no such entry.
	 */
	public LeagueItem getEntryBySummonerId(String summonerId) {
		List<LeagueItem> entries = getEntries();
		if (entries != null) {
			for (LeagueItem entry : entries) {
				if (entry.getSummonerId().equals(summonerId)) {
					return entry;
				}
			}
		}
		return null;
	}

	/**
	 * Utility method to get the entry by {@code summonerName}.
	 * 
	 * @param summonerName
	 *            Summoner name
	 * @return Entry from {@link #getEntries()} matching {@code summonerName}, or {@code null} if there is no such entry.
	 */
	public LeagueItem getEntryBySummonerName(String summonerName) {
		List<LeagueItem> entries = getEntries();
		if (entries != null) {
			for (LeagueItem entry : entries) {
				if (entry.getSummonerName().equalsIgnoreCase(summonerName)) {
					return entry;
				}
			}
		}
		return null;
	}

	public String getLeagueId() {
		return leagueId;
	}

	public String getName() {
		return name;
	}

	public String getQueue() {
		return queue;
	}

	public String getTier() {
		return tier;
	}

	@Override
	public String toString() {
		return getName();
	}
}