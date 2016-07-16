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

public class RawStats implements Serializable {

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
}
