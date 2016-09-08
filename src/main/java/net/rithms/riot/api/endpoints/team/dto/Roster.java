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
import java.util.List;

import net.rithms.riot.api.Dto;

public class Roster extends Dto implements Serializable {

	private static final long serialVersionUID = 1860524282741648264L;

	private List<TeamMemberInfo> memberList;
	private long ownerId;

	public List<TeamMemberInfo> getMemberList() {
		return memberList;
	}

	public long getOwnerId() {
		return ownerId;
	}

	public void setMemberList(List<TeamMemberInfo> memberList) {
		this.memberList = memberList;
	}

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}

	@Override
	public String toString() {
		return getMemberList().toString();
	}
}