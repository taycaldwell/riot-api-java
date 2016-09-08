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

package net.rithms.riot.api.endpoints.game.dto;

import java.io.Serializable;

import net.rithms.riot.api.Dto;

public class RawStats extends Dto implements Serializable {

	private static final long serialVersionUID = -5596702203314851885L;

	private int assists;
	private int barracksKilled;
	private int bountyLevel;
	private int championsKilled;
	private int combatPlayerScore;
	private int consumablesPurchased;
	private int damageDealtPlayer;
	private int doubleKills;
	private int firstBlood;
	private int gold;
	private int goldEarned;
	private int goldSpent;
	private int item0;
	private int item1;
	private int item2;
	private int item3;
	private int item4;
	private int item5;
	private int item6;
	private int itemsPurchased;
	private int killingSprees;
	private int largestCriticalStrike;
	private int largestKillingSpree;
	private int largestMultiKill;
	private int legendaryItemsCreated;
	private int level;
	private int magicDamageDealtPlayer;
	private int magicDamageDealtToChampions;
	private int magicDamageTaken;
	private int minionsDenied;
	private int minionsKilled;
	private int neutralMinionsKilled;
	private int neutralMinionsKilledEnemyJungle;
	private int neutralMinionsKilledYourJungle;
	private boolean nexusKilled;
	private int nodeCapture;
	private int nodeCaptureAssist;
	private int nodeNeutralize;
	private int nodeNeutralizeAssist;
	private int numDeaths;
	private int numItemsBought;
	private int objectivePlayerScore;
	private int pentaKills;
	private int physicalDamageDealtPlayer;
	private int physicalDamageDealtToChampions;
	private int physicalDamageTaken;
	private int playerPosition;
	private int playerRole;
	private int quadraKills;
	private int sightWardsBought;
	private int spell1Cast;
	private int spell2Cast;
	private int spell3Cast;
	private int spell4Cast;
	private int summonSpell1Cast;
	private int summonSpell2Cast;
	private int superMonsterKilled;
	private int team;
	private int teamObjective;
	private int timePlayed;
	private int totalDamageDealt;
	private int totalDamageDealtToBuildings;
	private int totalDamageDealtToChampions;
	private int totalDamageTaken;
	private int totalHeal;
	private int totalPlayerScore;
	private int totalScoreRank;
	private int totalTimeCrowdControlDealt;
	private int totalUnitsHealed;
	private int tripleKills;
	private int trueDamageDealtPlayer;
	private int trueDamageDealtToChampions;
	private int trueDamageTaken;
	private int turretsKilled;
	private int unrealKills;
	private int victoryPointTotal;
	private int visionWardsBought;
	private int wardKilled;
	private int wardPlaced;
	private boolean win;

	public int getAssists() {
		return assists;
	}

	public int getBarracksKilled() {
		return barracksKilled;
	}

	public int getBountyLevel() {
		return bountyLevel;
	}

	public int getChampionsKilled() {
		return championsKilled;
	}

	public int getCombatPlayerScore() {
		return combatPlayerScore;
	}

	public int getConsumablesPurchased() {
		return consumablesPurchased;
	}

	public int getDamageDealtPlayer() {
		return damageDealtPlayer;
	}

	public int getDoubleKills() {
		return doubleKills;
	}

	public int getFirstBlood() {
		return firstBlood;
	}

	public int getGold() {
		return gold;
	}

	public int getGoldEarned() {
		return goldEarned;
	}

	public int getGoldSpent() {
		return goldSpent;
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

	public int getItemsPurchased() {
		return itemsPurchased;
	}

	public int getKillingSprees() {
		return killingSprees;
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

	public int getLegendaryItemsCreated() {
		return legendaryItemsCreated;
	}

	public int getLevel() {
		return level;
	}

	public int getMagicDamageDealtPlayer() {
		return magicDamageDealtPlayer;
	}

	public int getMagicDamageDealtToChampions() {
		return magicDamageDealtToChampions;
	}

	public int getMagicDamageTaken() {
		return magicDamageTaken;
	}

	public int getMinionsDenied() {
		return minionsDenied;
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

	public int getNeutralMinionsKilledYourJungle() {
		return neutralMinionsKilledYourJungle;
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

	public int getNumDeaths() {
		return numDeaths;
	}

	public int getNumItemsBought() {
		return numItemsBought;
	}

	public int getObjectivePlayerScore() {
		return objectivePlayerScore;
	}

	public int getPentaKills() {
		return pentaKills;
	}

	public int getPhysicalDamageDealtPlayer() {
		return physicalDamageDealtPlayer;
	}

	public int getPhysicalDamageDealtToChampions() {
		return physicalDamageDealtToChampions;
	}

	public int getPhysicalDamageTaken() {
		return physicalDamageTaken;
	}

	public int getPlayerPosition() {
		return playerPosition;
	}

	public int getPlayerRole() {
		return playerRole;
	}

	public int getQuadraKills() {
		return quadraKills;
	}

	public int getSightWardsBought() {
		return sightWardsBought;
	}

	public int getSpell1Cast() {
		return spell1Cast;
	}

	public int getSpell2Cast() {
		return spell2Cast;
	}

	public int getSpell3Cast() {
		return spell3Cast;
	}

	public int getSpell4Cast() {
		return spell4Cast;
	}

	public int getSummonSpell1Cast() {
		return summonSpell1Cast;
	}

	public int getSummonSpell2Cast() {
		return summonSpell2Cast;
	}

	public int getSuperMonsterKilled() {
		return superMonsterKilled;
	}

	public int getTeam() {
		return team;
	}

	public int getTeamObjective() {
		return teamObjective;
	}

	public int getTimePlayed() {
		return timePlayed;
	}

	public int getTotalDamageDealt() {
		return totalDamageDealt;
	}
	
	public int getTotalDamageDealtToBuildings() {
		return totalDamageDealtToBuildings;
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

	public int getTripleKills() {
		return tripleKills;
	}

	public int getTrueDamageDealtPlayer() {
		return trueDamageDealtPlayer;
	}

	public int getTrueDamageDealtToChampions() {
		return trueDamageDealtToChampions;
	}

	public int getTrueDamageTaken() {
		return trueDamageTaken;
	}

	public int getTurretsKilled() {
		return turretsKilled;
	}

	public int getUnrealKills() {
		return unrealKills;
	}

	public int getVictoryPointTotal() {
		return victoryPointTotal;
	}

	public int getVisionWardsBought() {
		return visionWardsBought;
	}

	public int getWardKilled() {
		return wardKilled;
	}

	public int getWardPlaced() {
		return wardPlaced;
	}

	public boolean isNexusKilled() {
		return nexusKilled;
	}

	public boolean isWin() {
		return win;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public void setBarracksKilled(int barracksKilled) {
		this.barracksKilled = barracksKilled;
	}

	public void setBountyLevel(int bountyLevel) {
		this.bountyLevel = bountyLevel;
	}

	public void setChampionsKilled(int championsKilled) {
		this.championsKilled = championsKilled;
	}

	public void setCombatPlayerScore(int combatPlayerScore) {
		this.combatPlayerScore = combatPlayerScore;
	}

	public void setConsumablesPurchased(int consumablesPurchased) {
		this.consumablesPurchased = consumablesPurchased;
	}

	public void setDamageDealtPlayer(int damageDealtPlayer) {
		this.damageDealtPlayer = damageDealtPlayer;
	}

	public void setDoubleKills(int doubleKills) {
		this.doubleKills = doubleKills;
	}

	public void setFirstBlood(int firstBlood) {
		this.firstBlood = firstBlood;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public void setGoldEarned(int goldEarned) {
		this.goldEarned = goldEarned;
	}

	public void setGoldSpent(int goldSpent) {
		this.goldSpent = goldSpent;
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

	public void setItemsPurchased(int itemsPurchased) {
		this.itemsPurchased = itemsPurchased;
	}

	public void setKillingSprees(int killingSprees) {
		this.killingSprees = killingSprees;
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

	public void setLegendaryItemsCreated(int legendaryItemsCreated) {
		this.legendaryItemsCreated = legendaryItemsCreated;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setMagicDamageDealtPlayer(int magicDamageDealtPlayer) {
		this.magicDamageDealtPlayer = magicDamageDealtPlayer;
	}

	public void setMagicDamageDealtToChampions(int magicDamageDealtToChampions) {
		this.magicDamageDealtToChampions = magicDamageDealtToChampions;
	}

	public void setMagicDamageTaken(int magicDamageTaken) {
		this.magicDamageTaken = magicDamageTaken;
	}

	public void setMinionsDenied(int minionsDenied) {
		this.minionsDenied = minionsDenied;
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

	public void setNeutralMinionsKilledYourJungle(int neutralMinionsKilledYourJungle) {
		this.neutralMinionsKilledYourJungle = neutralMinionsKilledYourJungle;
	}

	public void setNexusKilled(boolean nexusKilled) {
		this.nexusKilled = nexusKilled;
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

	public void setNumDeaths(int numDeaths) {
		this.numDeaths = numDeaths;
	}

	public void setNumItemsBought(int numItemsBought) {
		this.numItemsBought = numItemsBought;
	}

	public void setObjectivePlayerScore(int objectivePlayerScore) {
		this.objectivePlayerScore = objectivePlayerScore;
	}

	public void setPentaKills(int pentaKills) {
		this.pentaKills = pentaKills;
	}

	public void setPhysicalDamageDealtPlayer(int physicalDamageDealtPlayer) {
		this.physicalDamageDealtPlayer = physicalDamageDealtPlayer;
	}

	public void setPhysicalDamageDealtToChampions(int physicalDamageDealtToChampions) {
		this.physicalDamageDealtToChampions = physicalDamageDealtToChampions;
	}

	public void setPhysicalDamageTaken(int physicalDamageTaken) {
		this.physicalDamageTaken = physicalDamageTaken;
	}

	public void setPlayerPosition(int playerPosition) {
		this.playerPosition = playerPosition;
	}

	public void setPlayerRole(int playerRole) {
		this.playerRole = playerRole;
	}

	public void setQuadraKills(int quadraKills) {
		this.quadraKills = quadraKills;
	}

	public void setSightWardsBought(int sightWardsBought) {
		this.sightWardsBought = sightWardsBought;
	}

	public void setSpell1Cast(int spell1Cast) {
		this.spell1Cast = spell1Cast;
	}

	public void setSpell2Cast(int spell2Cast) {
		this.spell2Cast = spell2Cast;
	}

	public void setSpell3Cast(int spell3Cast) {
		this.spell3Cast = spell3Cast;
	}

	public void setSpell4Cast(int spell4Cast) {
		this.spell4Cast = spell4Cast;
	}

	public void setSummonSpell1Cast(int summonSpell1Cast) {
		this.summonSpell1Cast = summonSpell1Cast;
	}

	public void setSummonSpell2Cast(int summonSpell2Cast) {
		this.summonSpell2Cast = summonSpell2Cast;
	}

	public void setSuperMonsterKilled(int superMonsterKilled) {
		this.superMonsterKilled = superMonsterKilled;
	}

	public void setTeam(int team) {
		this.team = team;
	}

	public void setTeamObjective(int teamObjective) {
		this.teamObjective = teamObjective;
	}

	public void setTimePlayed(int timePlayed) {
		this.timePlayed = timePlayed;
	}

	public void setTotalDamageDealt(int totalDamageDealt) {
		this.totalDamageDealt = totalDamageDealt;
	}

	public void setTotalDamageDealtToBuildings(int totalDamageDealtToBuildings) {
		this.totalDamageDealtToBuildings = totalDamageDealtToBuildings;
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

	public void setTripleKills(int tripleKills) {
		this.tripleKills = tripleKills;
	}

	public void setTrueDamageDealtPlayer(int trueDamageDealtPlayer) {
		this.trueDamageDealtPlayer = trueDamageDealtPlayer;
	}

	public void setTrueDamageDealtToChampions(int trueDamageDealtToChampions) {
		this.trueDamageDealtToChampions = trueDamageDealtToChampions;
	}

	public void setTrueDamageTaken(int trueDamageTaken) {
		this.trueDamageTaken = trueDamageTaken;
	}

	public void setTurretsKilled(int turretsKilled) {
		this.turretsKilled = turretsKilled;
	}

	public void setUnrealKills(int unrealKills) {
		this.unrealKills = unrealKills;
	}

	public void setVictoryPointTotal(int victoryPointTotal) {
		this.victoryPointTotal = victoryPointTotal;
	}

	public void setVisionWardsBought(int visionWardsBought) {
		this.visionWardsBought = visionWardsBought;
	}

	public void setWardKilled(int wardKilled) {
		this.wardKilled = wardKilled;
	}

	public void setWardPlaced(int wardPlaced) {
		this.wardPlaced = wardPlaced;
	}

	public void setWin(boolean win) {
		this.win = win;
	}
}
