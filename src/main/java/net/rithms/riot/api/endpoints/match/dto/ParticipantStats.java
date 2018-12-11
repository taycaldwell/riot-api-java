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

public class ParticipantStats extends Dto implements Serializable {

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
	private int statPerk0;
	private int statPerk1;
	private int statPerk2;

	public int getAltarsCaptured() {
		return altarsCaptured;
	}

	public int getAltarsNeutralized() {
		return altarsNeutralized;
	}

	public int getAssists() {
		return assists;
	}

	public int getChampLevel() {
		return champLevel;
	}

	public int getCombatPlayerScore() {
		return combatPlayerScore;
	}

	public long getDamageDealtToObjectives() {
		return damageDealtToObjectives;
	}

	public long getDamageDealtToTurrets() {
		return damageDealtToTurrets;
	}

	public long getDamageSelfMitigated() {
		return damageSelfMitigated;
	}

	public int getDeaths() {
		return deaths;
	}

	public int getDoubleKills() {
		return doubleKills;
	}

	public int getGoldEarned() {
		return goldEarned;
	}

	public int getGoldSpent() {
		return goldSpent;
	}

	public int getInhibitorKills() {
		return inhibitorKills;
	}

	public int getItem0() {
		return item0;
	}

	public int getItem1() {
		return item1;
	}

	public int getItem2() {
		return item2;
	}

	public int getItem3() {
		return item3;
	}

	public int getItem4() {
		return item4;
	}

	public int getItem5() {
		return item5;
	}

	public int getItem6() {
		return item6;
	}

	public int getKillingSprees() {
		return killingSprees;
	}

	public int getKills() {
		return kills;
	}

	public int getLargestCriticalStrike() {
		return largestCriticalStrike;
	}

	public int getLargestKillingSpree() {
		return largestKillingSpree;
	}

	public int getLargestMultiKill() {
		return largestMultiKill;
	}

	public int getLongestTimeSpentLiving() {
		return longestTimeSpentLiving;
	}

	public long getMagicDamageDealt() {
		return magicDamageDealt;
	}

	public long getMagicDamageDealtToChampions() {
		return magicDamageDealtToChampions;
	}

	public long getMagicalDamageTaken() {
		return magicalDamageTaken;
	}

	public int getNeutralMinionsKilled() {
		return neutralMinionsKilled;
	}

	public int getNeutralMinionsKilledEnemyJungle() {
		return neutralMinionsKilledEnemyJungle;
	}

	public int getNeutralMinionsKilledTeamJungle() {
		return neutralMinionsKilledTeamJungle;
	}

	public int getNodeCapture() {
		return nodeCapture;
	}

	public int getNodeCaptureAssist() {
		return nodeCaptureAssist;
	}

	public int getNodeNeutralize() {
		return nodeNeutralize;
	}

	public int getNodeNeutralizeAssist() {
		return nodeNeutralizeAssist;
	}

	public int getObjectivePlayerScore() {
		return objectivePlayerScore;
	}

	public int getParticipantId() {
		return participantId;
	}

	public int getPentaKills() {
		return pentaKills;
	}

	public long getPhysicalDamageDealt() {
		return physicalDamageDealt;
	}

	public long getPhysicalDamageDealtToChampions() {
		return physicalDamageDealtToChampions;
	}

	public long getPhysicalDamageTaken() {
		return physicalDamageTaken;
	}

	public int getQuadraKills() {
		return quadraKills;
	}

	public int getSightWardsBoughtInGame() {
		return sightWardsBoughtInGame;
	}

	public int getTeamObjective() {
		return teamObjective;
	}

	public int getTimeCCingOthers() {
		return timeCCingOthers;
	}

	public long getTotalDamageDealt() {
		return totalDamageDealt;
	}

	public long getTotalDamageDealtToChampions() {
		return totalDamageDealtToChampions;
	}

	public long getTotalDamageTaken() {
		return totalDamageTaken;
	}

	public long getTotalHeal() {
		return totalHeal;
	}

	public int getTotalMinionsKilled() {
		return totalMinionsKilled;
	}

	public int getTotalPlayerScore() {
		return totalPlayerScore;
	}

	public int getTotalScoreRank() {
		return totalScoreRank;
	}

	public int getTotalTimeCrowdControlDealt() {
		return totalTimeCrowdControlDealt;
	}

	public int getTotalUnitsHealed() {
		return totalUnitsHealed;
	}

	public int getTripleKills() {
		return tripleKills;
	}

	public long getTrueDamageDealt() {
		return trueDamageDealt;
	}

	public long getTrueDamageDealtToChampions() {
		return trueDamageDealtToChampions;
	}

	public long getTrueDamageTaken() {
		return trueDamageTaken;
	}

	public int getTurretKills() {
		return turretKills;
	}

	public int getUnrealKills() {
		return unrealKills;
	}

	public long getVisionScore() {
		return visionScore;
	}

	public int getVisionWardsBoughtInGame() {
		return visionWardsBoughtInGame;
	}

	public int getWardsKilled() {
		return wardsKilled;
	}

	public int getWardsPlaced() {
		return wardsPlaced;
	}

	public boolean isFirstBloodAssist() {
		return firstBloodAssist;
	}

	public boolean isFirstBloodKill() {
		return firstBloodKill;
	}

	public boolean isFirstInhibitorAssist() {
		return firstInhibitorAssist;
	}

	public boolean isFirstInhibitorKill() {
		return firstInhibitorKill;
	}

	public boolean isFirstTowerAssist() {
		return firstTowerAssist;
	}

	public boolean isFirstTowerKill() {
		return firstTowerKill;
	}

	public boolean isWin() {
		return win;
	}

	public int getPerk0() {
		return perk0;
	}

	public int getPerk1() {
		return perk1;
	}

	public int getPerk2() {
		return perk2;
	}

	public int getPerk3() {
		return perk3;
	}

	public int getPerk4() {
		return perk4;
	}

	public int getPerk5() {
		return perk5;
	}

	public long getPerk0Var1() {
		return perk0Var1;
	}

	public long getPerk0Var2() {
		return perk0Var2;
	}

	public long getPerk0Var3() {
		return perk0Var3;
	}

	public long getPerk1Var1() {
		return perk1Var1;
	}

	public long getPerk1Var2() {
		return perk1Var2;
	}

	public long getPerk1Var3() {
		return perk1Var3;
	}

	public long getPerk2Var1() {
		return perk2Var1;
	}

	public long getPerk2Var2() {
		return perk2Var2;
	}

	public long getPerk2Var3() {
		return perk2Var3;
	}

	public long getPerk3Var1() {
		return perk3Var1;
	}

	public long getPerk3Var2() {
		return perk3Var2;
	}

	public long getPerk3Var3() {
		return perk3Var3;
	}

	public long getPerk4Var1() {
		return perk4Var1;
	}

	public long getPerk4Var2() {
		return perk4Var2;
	}

	public long getPerk4Var3() {
		return perk4Var3;
	}

	public long getPerk5Var1() {
		return perk5Var1;
	}

	public long getPerk5Var2() {
		return perk5Var2;
	}

	public long getPerk5Var3() {
		return perk5Var3;
	}

	public long getPlayerScore0() {
		return playerScore0;
	}

	public long getPlayerScore1() {
		return playerScore1;
	}

	public long getPlayerScore2() {
		return playerScore2;
	}

	public long getPlayerScore3() {
		return playerScore3;
	}

	public long getPlayerScore4() {
		return playerScore4;
	}

	public long getPlayerScore5() {
		return playerScore5;
	}

	public long getPlayerScore6() {
		return playerScore6;
	}

	public long getPlayerScore7() {
		return playerScore7;
	}

	public long getPlayerScore8() {
		return playerScore8;
	}

	public long getPlayerScore9() {
		return playerScore9;
	}

	public int getPerkPrimaryStyle() {
		return perkPrimaryStyle;
	}

	public int getPerkSubStyle() {
		return perkSubStyle;
	}

	public int getStatPerk0() {
		return statPerk0;
	}

	public int getStatPerk1() {
		return statPerk1;
	}

	public int getStatPerk2() {
		return statPerk2;
	}
}