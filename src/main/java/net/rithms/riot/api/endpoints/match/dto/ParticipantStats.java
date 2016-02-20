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

public class ParticipantStats implements Serializable {

	private static final long serialVersionUID = 7907342025148370788L;

	private int assists;
	private int champLevel;
	private int combatPlayerScore;
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
	private int magicDamageDealt;
	private int magicDamageDealtToChampions;
	private int magicDamageTaken;
	private int minionsKilled;
	private int neutralMinionsKilled;
	private int neutralMinionsKilledEnemyJungle;
	private int neutralMinionsKilledTeamJungle;
	private int nodeCapture;
	private int nodeCaptureAssist;
	private int nodeNeutralize;
	private int nodeNeutralizeAssist;
	private int objectivePlayerScore;
	private int pentaKills;
	private int physicalDamageDealt;
	private int physicalDamageDealtToChampions;
	private int physicalDamageTaken;
	private int quadraKills;
	private int sightWardsBoughtInGame;
	private int teamObjective;
	private int totalDamageDealt;
	private int totalDamageDealtToChampions;
	private int totalDamageTaken;
	private int totalHeal;
	private int totalPlayerScore;
	private int totalScoreRank;
	private int totalTimeCrowdControlDealt;
	private int totalUnitsHealed;
	private int towerKills;
	private int tripleKills;
	private int trueDamageDealt;
	private int trueDamageDealtToChampions;
	private int trueDamageTaken;
	private int unrealKills;
	private int visionWardsBoughtInGame;
	private int wardsKilled;
	private int wardsPlaced;
	private boolean winner;

	public int getAssists() {
		return assists;
	}

	public int getChampLevel() {
		return champLevel;
	}

	public int getCombatPlayerScore() {
		return combatPlayerScore;
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

	public int getMagicDamageDealt() {
		return magicDamageDealt;
	}

	public int getMagicDamageDealtToChampions() {
		return magicDamageDealtToChampions;
	}

	public int getMagicDamageTaken() {
		return magicDamageTaken;
	}

	public int getMinionsKilled() {
		return minionsKilled;
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

	public int getPentaKills() {
		return pentaKills;
	}

	public int getPhysicalDamageDealt() {
		return physicalDamageDealt;
	}

	public int getPhysicalDamageDealtToChampions() {
		return physicalDamageDealtToChampions;
	}

	public int getPhysicalDamageTaken() {
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

	public int getTotalDamageDealt() {
		return totalDamageDealt;
	}

	public int getTotalDamageDealtToChampions() {
		return totalDamageDealtToChampions;
	}

	public int getTotalDamageTaken() {
		return totalDamageTaken;
	}

	public int getTotalHeal() {
		return totalHeal;
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

	public int getTowerKills() {
		return towerKills;
	}

	public int getTripleKills() {
		return tripleKills;
	}

	public int getTrueDamageDealt() {
		return trueDamageDealt;
	}

	public int getTrueDamageDealtToChampions() {
		return trueDamageDealtToChampions;
	}

	public int getTrueDamageTaken() {
		return trueDamageTaken;
	}

	public int getUnrealKills() {
		return unrealKills;
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

	public boolean isWinner() {
		return winner;
	}
}