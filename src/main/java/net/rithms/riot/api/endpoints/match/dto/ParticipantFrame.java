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

public class ParticipantFrame implements Serializable {

	private static final long serialVersionUID = -7134736662198942818L;
	private int currentGold, jungleMinionsKilled, level, minionsKilled, participantId, totalGold, xp;
	private Position position;

	public int getCurrentGold() {
		return currentGold;
	}

	public int getJungleMinionsKilled() {
		return jungleMinionsKilled;
	}

	public int getLevel() {
		return level;
	}

	public int getMinionsKilled() {
		return minionsKilled;
	}

	public int getParticipantId() {
		return participantId;
	}

	public int getTotalGold() {
		return totalGold;
	}

	public int getXp() {
		return xp;
	}

	public Position getPosition() {
		return position;
	}
}