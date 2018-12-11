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

import lombok.Data;
import net.rithms.riot.api.Dto;

public @Data class ParticipantStats extends Dto implements Serializable {

	private static final long serialVersionUID = 7907342025148370788L;

	private int altarsCaptured;
	private int altarsNeutralized;
	private int assists;
	private int champLevel;
	private int combatPlayerScore;
	private long damageDealtToObjectives;
	private long damageDealtToTurrets;
	private long damageSelfMitigated;
	private int deaths;
	private int doubleKills;
	private boolean firstBloodAssist;
	private boolean firstBloodKill;
	private boolean firstInhibitorAssist;
	private boolean firstInhibitorKill;
	private boolean firstTowerAssist;
	private boolean firstTowerKill;
	private int goldEarned;
	private int goldSpent;
	private int inhibitorKills;
	private int item0;
	private int item1;
	private int item2;
	private int item3;
	private int item4;
	private int item5;
	private int item6;
	private int killingSprees;
	private int kills;
	private int largestCriticalStrike;
	private int largestKillingSpree;
	private int largestMultiKill;
	private int longestTimeSpentLiving;
	private long magicDamageDealt;
	private long magicDamageDealtToChampions;
	private long magicalDamageTaken;
	private int neutralMinionsKilled;
	private int neutralMinionsKilledEnemyJungle;
	private int neutralMinionsKilledTeamJungle;
	private int nodeCapture;
	private int nodeCaptureAssist;
	private int nodeNeutralize;
	private int nodeNeutralizeAssist;
	private int objectivePlayerScore;
	private int participantId;
	private int pentaKills;
	private long physicalDamageDealt;
	private long physicalDamageDealtToChampions;
	private long physicalDamageTaken;
	private int quadraKills;
	private int sightWardsBoughtInGame;
	private int teamObjective;
	private int timeCCingOthers;
	private long totalDamageDealt;
	private long totalDamageDealtToChampions;
	private long totalDamageTaken;
	private long totalHeal;
	private int totalMinionsKilled;
	private int totalPlayerScore;
	private int totalScoreRank;
	private int totalTimeCrowdControlDealt;
	private int totalUnitsHealed;
	private int tripleKills;
	private long trueDamageDealt;
	private long trueDamageDealtToChampions;
	private long trueDamageTaken;
	private int turretKills;
	private int unrealKills;
	private long visionScore;
	private int visionWardsBoughtInGame;
	private int wardsKilled;
	private int wardsPlaced;
	private boolean win;
	private int perk0;
	private int perk1;
	private int perk2;
	private int perk3;
	private int perk4;
	private int perk5;
	private long perk0Var1;
	private long perk0Var2;
	private long perk0Var3;
	private long perk1Var1;
	private long perk1Var2;
	private long perk1Var3;
	private long perk2Var1;
	private long perk2Var2;
	private long perk2Var3;
	private long perk3Var1;
	private long perk3Var2;
	private long perk3Var3;
	private long perk4Var1;
	private long perk4Var2;
	private long perk4Var3;
	private long perk5Var1;
	private long perk5Var2;
	private long perk5Var3;
	private long playerScore0;
	private long playerScore1;
	private long playerScore2;
	private long playerScore3;
	private long playerScore4;
	private long playerScore5;
	private long playerScore6;
	private long playerScore7;
	private long playerScore8;
	private long playerScore9;
	private int perkPrimaryStyle;
	private int perkSubStyle;

}