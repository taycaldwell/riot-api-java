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

public class Summoner extends Dto implements Serializable {

	private static final long serialVersionUID = -8213488199644701555L;

	private long id;
	private String name;
	private int profileIconId;
	private long revisionDate;
	private int summonerLevel;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getProfileIconId() {
		return profileIconId;
	}

	public long getRevisionDate() {
		return revisionDate;
	}

	public int getSummonerLevel() {
		return summonerLevel;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProfileIconId(int profileIconId) {
		this.profileIconId = profileIconId;
	}

	public void setRevisionDate(long revisionDate) {
		this.revisionDate = revisionDate;
	}

	public void setSummonerLevel(int summonerLevel) {
		this.summonerLevel = summonerLevel;
	}

	@Override
	public String toString() {
		return getId() + ": " + getName();
	}
}