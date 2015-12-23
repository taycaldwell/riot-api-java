package net.rithms.riot.constant;

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

import net.rithms.riot.api.RiotStringNotFound;

public enum QueueType {
	ARAM_5x5("ARAM", 65),
	ASCENSION_5x5("Ascension", 96),
	BILGEWATER_5x5("Black Market Brawlers", 313),
	BILGEWATER_ARAM_5x5("Butcher's Bridge", 100),
	BOT_5x5("Historical Summoner's Rift Coop vs AI", 7),
	BOT_5x5_BEGINNER("Summoner's Rift Coop vs AI Beginner Bot", 32),
	BOT_5x5_INTERMEDIATE("Historical Summoner's Rift Coop vs AI Intermediate Bot", 33),
	BOT_5x5_INTRO("Summoner's Rift Coop vs AI Intro Bot", 31),
	BOT_ODIN_5x5("Dominion Coop vs AI", 25),
	BOT_URF_5x5("Ultra Rapid Fire games played against AI", 83),
	BOT_TT_3x3("Twisted Treeline Coop vs AI", 52),
	COUNTER_PICK("Nemesis Draft", 310),
	CUSTOM("Custom", 0),
	FIRSTBLOOD_1x1("Snowdown Showdown 1v1", 72),
	FIRSTBLOOD_2x2("Snowdown Showdown 2v2", 73),
	GROUP_FINDER_5x5("Team Builder", 61),
	HEXAKILL("Twisted Treeline 6x6 Hexakill", 98),
	KING_PORO_5x5("King Poro", 300),
	NIGHTMARE_BOT_5x5_RANK1("Doom Bots Rank 1", 91),
	NIGHTMARE_BOT_5x5_RANK2("Doom Bots Rank 2", 92),
	NIGHTMARE_BOT_5x5_RANK5("Doom Bots Rank 5", 93),
	NORMAL_5x5_BLIND("Normal 5v5 Blind Pick", 2),
	NORMAL_3x3("Normal 3v3", 8),
	NORMAL_5x5_DRAFT("Normal 5v5 Draft Pick", 14),
	ODIN_5x5_BLIND("Dominion 5v5 Blind Pick", 16),
	ODIN_5x5_DRAFT("Dominion 5v5 Draft Pick", 17),
	ONEFORALL_5x5("One for All", 70),
    ONEFORALL_MIRRORMODE_5x5("One for All: Mirror Mode", 70),
	RANKED_PREMADE_3x3("Ranked Premade 3v3", 9),
	RANKED_PREMADE_5x5("Ranked Premade 5v5", 6),
	RANKED_SOLO_5x5("Ranked Solo 5v5", 4),
	RANKED_TEAM_3x3("Ranked Team 3v3", 41),
	RANKED_TEAM_5x5("Ranked Team 5v5", 42),
	SR_6x6("Hexakill", 75),
	URF_5x5("Ultra Rapid Fire", 76);

	private String name;
	private int gameQueueConfigId;

	public static String getQueueNameByConfigId(int gameQueueConfigId) throws RiotStringNotFound {
		QueueType[] queueTypes = QueueType.values();
		for (QueueType queueType : queueTypes) {
			if (queueType.getGameQueueConfigId() == gameQueueConfigId) {
				return queueType.getName();
			}
		}
		throw new RiotStringNotFound("Could not find queue " + gameQueueConfigId);
	}

	QueueType(String name, int gameQueueConfigId) {
		this.name = name;
		this.gameQueueConfigId = gameQueueConfigId;
	}

	public String getName() {
		return name;
	}

	public int getGameQueueConfigId() {
		return gameQueueConfigId;
	}

	@Override
	public String toString() {
		return getName();
	}
}