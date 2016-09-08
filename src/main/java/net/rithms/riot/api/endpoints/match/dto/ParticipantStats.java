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

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public void setChampLevel(int champLevel) {
		this.champLevel = champLevel;
	}

	public void setCombatPlayerScore(int combatPlayerScore) {
		this.combatPlayerScore = combatPlayerScore;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	public void setDoubleKills(int doubleKills) {
		this.doubleKills = doubleKills;
	}

	public void setFirstBloodAssist(boolean firstBloodAssist) {
		this.firstBloodAssist = firstBloodAssist;
	}

	public void setFirstBloodKill(boolean firstBloodKill) {
		this.firstBloodKill = firstBloodKill;
	}

	public void setFirstInhibitorAssist(boolean firstInhibitorAssist) {
		this.firstInhibitorAssist = firstInhibitorAssist;
	}

	public void setFirstInhibitorKill(boolean firstInhibitorKill) {
		this.firstInhibitorKill = firstInhibitorKill;
	}

	public void setFirstTowerAssist(boolean firstTowerAssist) {
		this.firstTowerAssist = firstTowerAssist;
	}

	public void setFirstTowerKill(boolean firstTowerKill) {
		this.firstTowerKill = firstTowerKill;
	}

	public void setGoldEarned(int goldEarned) {
		this.goldEarned = goldEarned;
	}

	public void setGoldSpent(int goldSpent) {
		this.goldSpent = goldSpent;
	}

	public void setInhibitorKills(int inhibitorKills) {
		this.inhibitorKills = inhibitorKills;
	}

	public void setItem0(int item0) {
		this.item0 = item0;
	}

	public void setItem1(int item1) {
		this.item1 = item1;
	}

	public void setItem2(int item2) {
		this.item2 = item2;
	}

	public void setItem3(int item3) {
		this.item3 = item3;
	}

	public void setItem4(int item4) {
		this.item4 = item4;
	}

	public void setItem5(int item5) {
		this.item5 = item5;
	}

	public void setItem6(int item6) {
		this.item6 = item6;
	}

	public void setKillingSprees(int killingSprees) {
		this.killingSprees = killingSprees;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}

	public void setLargestCriticalStrike(int largestCriticalStrike) {
		this.largestCriticalStrike = largestCriticalStrike;
	}

	public void setLargestKillingSpree(int largestKillingSpree) {
		this.largestKillingSpree = largestKillingSpree;
	}

	public void setLargestMultiKill(int largestMultiKill) {
		this.largestMultiKill = largestMultiKill;
	}

	public void setMagicDamageDealt(int magicDamageDealt) {
		this.magicDamageDealt = magicDamageDealt;
	}

	public void setMagicDamageDealtToChampions(int magicDamageDealtToChampions) {
		this.magicDamageDealtToChampions = magicDamageDealtToChampions;
	}

	public void setMagicDamageTaken(int magicDamageTaken) {
		this.magicDamageTaken = magicDamageTaken;
	}

	public void setMinionsKilled(int minionsKilled) {
		this.minionsKilled = minionsKilled;
	}

	public void setNeutralMinionsKilled(int neutralMinionsKilled) {
		this.neutralMinionsKilled = neutralMinionsKilled;
	}

	public void setNeutralMinionsKilledEnemyJungle(int neutralMinionsKilledEnemyJungle) {
		this.neutralMinionsKilledEnemyJungle = neutralMinionsKilledEnemyJungle;
	}

	public void setNeutralMinionsKilledTeamJungle(int neutralMinionsKilledTeamJungle) {
		this.neutralMinionsKilledTeamJungle = neutralMinionsKilledTeamJungle;
	}

	public void setNodeCapture(int nodeCapture) {
		this.nodeCapture = nodeCapture;
	}

	public void setNodeCaptureAssist(int nodeCaptureAssist) {
		this.nodeCaptureAssist = nodeCaptureAssist;
	}

	public void setNodeNeutralize(int nodeNeutralize) {
		this.nodeNeutralize = nodeNeutralize;
	}

	public void setNodeNeutralizeAssist(int nodeNeutralizeAssist) {
		this.nodeNeutralizeAssist = nodeNeutralizeAssist;
	}

	public void setObjectivePlayerScore(int objectivePlayerScore) {
		this.objectivePlayerScore = objectivePlayerScore;
	}

	public void setPentaKills(int pentaKills) {
		this.pentaKills = pentaKills;
	}

	public void setPhysicalDamageDealt(int physicalDamageDealt) {
		this.physicalDamageDealt = physicalDamageDealt;
	}

	public void setPhysicalDamageDealtToChampions(int physicalDamageDealtToChampions) {
		this.physicalDamageDealtToChampions = physicalDamageDealtToChampions;
	}

	public void setPhysicalDamageTaken(int physicalDamageTaken) {
		this.physicalDamageTaken = physicalDamageTaken;
	}

	public void setQuadraKills(int quadraKills) {
		this.quadraKills = quadraKills;
	}

	public void setSightWardsBoughtInGame(int sightWardsBoughtInGame) {
		this.sightWardsBoughtInGame = sightWardsBoughtInGame;
	}

	public void setTeamObjective(int teamObjective) {
		this.teamObjective = teamObjective;
	}

	public void setTotalDamageDealt(int totalDamageDealt) {
		this.totalDamageDealt = totalDamageDealt;
	}

	public void setTotalDamageDealtToChampions(int totalDamageDealtToChampions) {
		this.totalDamageDealtToChampions = totalDamageDealtToChampions;
	}

	public void setTotalDamageTaken(int totalDamageTaken) {
		this.totalDamageTaken = totalDamageTaken;
	}

	public void setTotalHeal(int totalHeal) {
		this.totalHeal = totalHeal;
	}

	public void setTotalPlayerScore(int totalPlayerScore) {
		this.totalPlayerScore = totalPlayerScore;
	}

	public void setTotalScoreRank(int totalScoreRank) {
		this.totalScoreRank = totalScoreRank;
	}

	public void setTotalTimeCrowdControlDealt(int totalTimeCrowdControlDealt) {
		this.totalTimeCrowdControlDealt = totalTimeCrowdControlDealt;
	}

	public void setTotalUnitsHealed(int totalUnitsHealed) {
		this.totalUnitsHealed = totalUnitsHealed;
	}

	public void setTowerKills(int towerKills) {
		this.towerKills = towerKills;
	}

	public void setTripleKills(int tripleKills) {
		this.tripleKills = tripleKills;
	}

	public void setTrueDamageDealt(int trueDamageDealt) {
		this.trueDamageDealt = trueDamageDealt;
	}

	public void setTrueDamageDealtToChampions(int trueDamageDealtToChampions) {
		this.trueDamageDealtToChampions = trueDamageDealtToChampions;
	}

	public void setTrueDamageTaken(int trueDamageTaken) {
		this.trueDamageTaken = trueDamageTaken;
	}

	public void setUnrealKills(int unrealKills) {
		this.unrealKills = unrealKills;
	}

	public void setVisionWardsBoughtInGame(int visionWardsBoughtInGame) {
		this.visionWardsBoughtInGame = visionWardsBoughtInGame;
	}

	public void setWardsKilled(int wardsKilled) {
		this.wardsKilled = wardsKilled;
	}

	public void setWardsPlaced(int wardsPlaced) {
		this.wardsPlaced = wardsPlaced;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}
}