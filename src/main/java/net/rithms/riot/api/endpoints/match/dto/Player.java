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

import net.rithms.riot.api.Dto;

public class Player extends Dto implements Serializable {

	private static final long serialVersionUID = -4459702825178547603L;

	private String accountId;
	private String currentAccountId;
	private String currentPlatformId;
	private String matchHistoryUri;
	private String platformId;
	private int profileIcon;
	private String summonerId;
	private String summonerName;

	public String getAccountId() {
		return accountId;
	}

	public String getCurrentAccountId() {
		return currentAccountId;
	}

	public String getCurrentPlatformId() {
		return currentPlatformId;
	}

	public String getMatchHistoryUri() {
		return matchHistoryUri;
	}

	public String getPlatformId() {
		return platformId;
	}

	public int getProfileIcon() {
		return profileIcon;
	}

	public String getSummonerId() {
		return summonerId;
	}

	public String getSummonerName() {
		return summonerName;
	}

	@Override
	public String toString() {
		return getSummonerName();
	}
}