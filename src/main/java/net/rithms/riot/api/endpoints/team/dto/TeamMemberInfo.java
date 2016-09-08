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

package net.rithms.riot.api.endpoints.team.dto;

import java.io.Serializable;

import net.rithms.riot.api.Dto;

public class TeamMemberInfo extends Dto implements Serializable {

	private static final long serialVersionUID = 7987276053364898769L;

	private long inviteDate;
	private long joinDate;
	private long playerId;
	private String status;

	public long getInviteDate() {
		return inviteDate;
	}

	public long getJoinDate() {
		return joinDate;
	}

	public long getPlayerId() {
		return playerId;
	}

	public String getStatus() {
		return status;
	}

	public void setInviteDate(long inviteDate) {
		this.inviteDate = inviteDate;
	}

	public void setJoinDate(long joinDate) {
		this.joinDate = joinDate;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return String.valueOf(getPlayerId());
	}
}