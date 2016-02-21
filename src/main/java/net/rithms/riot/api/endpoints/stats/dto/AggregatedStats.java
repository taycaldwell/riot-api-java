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

package net.rithms.riot.api.endpoints.stats.dto;

import java.io.Serializable;

public class AggregatedStats implements Serializable {

	private static final long serialVersionUID = 5450927796643171275L;

	private int averageAssists;
	private int averageChampionsKilled;
	private int averageCombatPlayerScore;
	private int averageNodeCapture;
	private int averageNodeCaptureAssist;
	private int averageNodeNeutralize;
	private int averageNodeNeutralizeAssist;
	private int averageNumDeaths;
	private int averageObjectivePlayerScore;
	private int averageTeamObjective;
	private int averageTotalPlayerScore;
	private int botGamesPlayed;
	private int killingSpree;
	private int maxAssists;
	private int maxChampionsKilled;
	private int maxCombatPlayerScore;
	private int maxLargestCriticalStrike;
	private int maxLargestKillingSpree;
	private int maxNodeCapture;
	private int maxNodeCaptureAssist;
	private int maxNodeNeutralize;
	private int maxNodeNeutralizeAssist;
	private int maxNumDeaths;
	private int maxObjectivePlayerScore;
	private int maxTeamObjective;
	private int maxTimePlayed;
	private int maxTimeSpentLiving;
	private int maxTotalPlayerScore;
	private int mostChampionKillsPerSession;
	private int mostSpellsCast;
	private int normalGamesPlayed;
	private int rankedPremadeGamesPlayed;
	private int rankedSoloGamesPlayed;
	private int totalAssists;
	private int totalChampionKills;
	private int totalDamageDealt;
	private int totalDamageTaken;
	private int totalDeathsPerSession;
	private int totalDoubleKills;
	private int totalFirstBlood;
	private int totalGoldEarned;
	private int totalHeal;
	private int totalMagicDamageDealt;
	private int totalMinionKills;
	private int totalNeutralMinionsKilled;
	private int totalNodeCapture;
	private int totalNodeNeutralize;
	private int totalPentaKills;
	private int totalPhysicalDamageDealt;
	private int totalQuadraKills;
	private int totalSessionsLost;
	private int totalSessionsPlayed;
	private int totalSessionsWon;
	private int totalTripleKills;
	private int totalTurretsKilled;
	private int totalUnrealKills;

	public int getAverageAssists() {
		return averageAssists;
	}

	public int getAverageChampionsKilled() {
		return averageChampionsKilled;
	}

	public int getAverageCombatPlayerScore() {
		return averageCombatPlayerScore;
	}

	public int getAverageNodeCapture() {
		return averageNodeCapture;
	}

	public int getAverageNodeCaptureAssist() {
		return averageNodeCaptureAssist;
	}

	public int getAverageNodeNeutralize() {
		return averageNodeNeutralize;
	}

	public int getAverageNodeNeutralizeAssist() {
		return averageNodeNeutralizeAssist;
	}

	public int getAverageNumDeaths() {
		return averageNumDeaths;
	}

	public int getAverageObjectivePlayerScore() {
		return averageObjectivePlayerScore;
	}

	public int getAverageTeamObjective() {
		return averageTeamObjective;
	}

	public int getAverageTotalPlayerScore() {
		return averageTotalPlayerScore;
	}

	public int getBotGamesPlayed() {
		return botGamesPlayed;
	}

	public int getKillingSpree() {
		return killingSpree;
	}

	public int getMaxAssists() {
		return maxAssists;
	}

	public int getMaxChampionsKilled() {
		return maxChampionsKilled;
	}

	public int getMaxCombatPlayerScore() {
		return maxCombatPlayerScore;
	}

	public int getMaxLargestCriticalStrike() {
		return maxLargestCriticalStrike;
	}

	public int getMaxLargestKillingSpree() {
		return maxLargestKillingSpree;
	}

	public int getMaxNodeCapture() {
		return maxNodeCapture;
	}

	public int getMaxNodeCaptureAssist() {
		return maxNodeCaptureAssist;
	}

	public int getMaxNodeNeutralize() {
		return maxNodeNeutralize;
	}

	public int getMaxNodeNeutralizeAssist() {
		return maxNodeNeutralizeAssist;
	}

	public int getMaxNumDeaths() {
		return maxNumDeaths;
	}

	public int getMaxObjectivePlayerScore() {
		return maxObjectivePlayerScore;
	}

	public int getMaxTeamObjective() {
		return maxTeamObjective;
	}

	public int getMaxTimePlayed() {
		return maxTimePlayed;
	}

	public int getMaxTimeSpentLiving() {
		return maxTimeSpentLiving;
	}

	public int getMaxTotalPlayerScore() {
		return maxTotalPlayerScore;
	}

	public int getMostChampionKillsPerSession() {
		return mostChampionKillsPerSession;
	}

	public int getMostSpellsCast() {
		return mostSpellsCast;
	}

	public int getNormalGamesPlayed() {
		return normalGamesPlayed;
	}

	public int getRankedPremadeGamesPlayed() {
		return rankedPremadeGamesPlayed;
	}

	public int getRankedSoloGamesPlayed() {
		return rankedSoloGamesPlayed;
	}

	public int getTotalAssists() {
		return totalAssists;
	}

	public int getTotalChampionKills() {
		return totalChampionKills;
	}

	public int getTotalDamageDealt() {
		return totalDamageDealt;
	}

	public int getTotalDamageTaken() {
		return totalDamageTaken;
	}

	public int getTotalDeathsPerSession() {
		return totalDeathsPerSession;
	}

	public int getTotalDoubleKills() {
		return totalDoubleKills;
	}

	public int getTotalFirstBlood() {
		return totalFirstBlood;
	}

	public int getTotalGoldEarned() {
		return totalGoldEarned;
	}

	public int getTotalHeal() {
		return totalHeal;
	}

	public int getTotalMagicDamageDealt() {
		return totalMagicDamageDealt;
	}

	public int getTotalMinionKills() {
		return totalMinionKills;
	}

	public int getTotalNeutralMinionsKilled() {
		return totalNeutralMinionsKilled;
	}

	public int getTotalNodeCapture() {
		return totalNodeCapture;
	}

	public int getTotalNodeNeutralize() {
		return totalNodeNeutralize;
	}

	public int getTotalPentaKills() {
		return totalPentaKills;
	}

	public int getTotalPhysicalDamageDealt() {
		return totalPhysicalDamageDealt;
	}

	public int getTotalQuadraKills() {
		return totalQuadraKills;
	}

	public int getTotalSessionsLost() {
		return totalSessionsLost;
	}

	public int getTotalSessionsPlayed() {
		return totalSessionsPlayed;
	}

	public int getTotalSessionsWon() {
		return totalSessionsWon;
	}

	public int getTotalTripleKills() {
		return totalTripleKills;
	}

	public int getTotalTurretsKilled() {
		return totalTurretsKilled;
	}

	public int getTotalUnrealKills() {
		return totalUnrealKills;
	}
}