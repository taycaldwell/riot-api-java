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

import net.rithms.riot.api.Dto;

public class AggregatedStats extends Dto implements Serializable {

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

	public void setAverageAssists(int averageAssists) {
		this.averageAssists = averageAssists;
	}

	public void setAverageChampionsKilled(int averageChampionsKilled) {
		this.averageChampionsKilled = averageChampionsKilled;
	}

	public void setAverageCombatPlayerScore(int averageCombatPlayerScore) {
		this.averageCombatPlayerScore = averageCombatPlayerScore;
	}

	public void setAverageNodeCapture(int averageNodeCapture) {
		this.averageNodeCapture = averageNodeCapture;
	}

	public void setAverageNodeCaptureAssist(int averageNodeCaptureAssist) {
		this.averageNodeCaptureAssist = averageNodeCaptureAssist;
	}

	public void setAverageNodeNeutralize(int averageNodeNeutralize) {
		this.averageNodeNeutralize = averageNodeNeutralize;
	}

	public void setAverageNodeNeutralizeAssist(int averageNodeNeutralizeAssist) {
		this.averageNodeNeutralizeAssist = averageNodeNeutralizeAssist;
	}

	public void setAverageNumDeaths(int averageNumDeaths) {
		this.averageNumDeaths = averageNumDeaths;
	}

	public void setAverageObjectivePlayerScore(int averageObjectivePlayerScore) {
		this.averageObjectivePlayerScore = averageObjectivePlayerScore;
	}

	public void setAverageTeamObjective(int averageTeamObjective) {
		this.averageTeamObjective = averageTeamObjective;
	}

	public void setAverageTotalPlayerScore(int averageTotalPlayerScore) {
		this.averageTotalPlayerScore = averageTotalPlayerScore;
	}

	public void setBotGamesPlayed(int botGamesPlayed) {
		this.botGamesPlayed = botGamesPlayed;
	}

	public void setKillingSpree(int killingSpree) {
		this.killingSpree = killingSpree;
	}

	public void setMaxAssists(int maxAssists) {
		this.maxAssists = maxAssists;
	}

	public void setMaxChampionsKilled(int maxChampionsKilled) {
		this.maxChampionsKilled = maxChampionsKilled;
	}

	public void setMaxCombatPlayerScore(int maxCombatPlayerScore) {
		this.maxCombatPlayerScore = maxCombatPlayerScore;
	}

	public void setMaxLargestCriticalStrike(int maxLargestCriticalStrike) {
		this.maxLargestCriticalStrike = maxLargestCriticalStrike;
	}

	public void setMaxLargestKillingSpree(int maxLargestKillingSpree) {
		this.maxLargestKillingSpree = maxLargestKillingSpree;
	}

	public void setMaxNodeCapture(int maxNodeCapture) {
		this.maxNodeCapture = maxNodeCapture;
	}

	public void setMaxNodeCaptureAssist(int maxNodeCaptureAssist) {
		this.maxNodeCaptureAssist = maxNodeCaptureAssist;
	}

	public void setMaxNodeNeutralize(int maxNodeNeutralize) {
		this.maxNodeNeutralize = maxNodeNeutralize;
	}

	public void setMaxNodeNeutralizeAssist(int maxNodeNeutralizeAssist) {
		this.maxNodeNeutralizeAssist = maxNodeNeutralizeAssist;
	}

	public void setMaxNumDeaths(int maxNumDeaths) {
		this.maxNumDeaths = maxNumDeaths;
	}

	public void setMaxObjectivePlayerScore(int maxObjectivePlayerScore) {
		this.maxObjectivePlayerScore = maxObjectivePlayerScore;
	}

	public void setMaxTeamObjective(int maxTeamObjective) {
		this.maxTeamObjective = maxTeamObjective;
	}

	public void setMaxTimePlayed(int maxTimePlayed) {
		this.maxTimePlayed = maxTimePlayed;
	}

	public void setMaxTimeSpentLiving(int maxTimeSpentLiving) {
		this.maxTimeSpentLiving = maxTimeSpentLiving;
	}

	public void setMaxTotalPlayerScore(int maxTotalPlayerScore) {
		this.maxTotalPlayerScore = maxTotalPlayerScore;
	}

	public void setMostChampionKillsPerSession(int mostChampionKillsPerSession) {
		this.mostChampionKillsPerSession = mostChampionKillsPerSession;
	}

	public void setMostSpellsCast(int mostSpellsCast) {
		this.mostSpellsCast = mostSpellsCast;
	}

	public void setNormalGamesPlayed(int normalGamesPlayed) {
		this.normalGamesPlayed = normalGamesPlayed;
	}

	public void setRankedPremadeGamesPlayed(int rankedPremadeGamesPlayed) {
		this.rankedPremadeGamesPlayed = rankedPremadeGamesPlayed;
	}

	public void setRankedSoloGamesPlayed(int rankedSoloGamesPlayed) {
		this.rankedSoloGamesPlayed = rankedSoloGamesPlayed;
	}

	public void setTotalAssists(int totalAssists) {
		this.totalAssists = totalAssists;
	}

	public void setTotalChampionKills(int totalChampionKills) {
		this.totalChampionKills = totalChampionKills;
	}

	public void setTotalDamageDealt(int totalDamageDealt) {
		this.totalDamageDealt = totalDamageDealt;
	}

	public void setTotalDamageTaken(int totalDamageTaken) {
		this.totalDamageTaken = totalDamageTaken;
	}

	public void setTotalDeathsPerSession(int totalDeathsPerSession) {
		this.totalDeathsPerSession = totalDeathsPerSession;
	}

	public void setTotalDoubleKills(int totalDoubleKills) {
		this.totalDoubleKills = totalDoubleKills;
	}

	public void setTotalFirstBlood(int totalFirstBlood) {
		this.totalFirstBlood = totalFirstBlood;
	}

	public void setTotalGoldEarned(int totalGoldEarned) {
		this.totalGoldEarned = totalGoldEarned;
	}

	public void setTotalHeal(int totalHeal) {
		this.totalHeal = totalHeal;
	}

	public void setTotalMagicDamageDealt(int totalMagicDamageDealt) {
		this.totalMagicDamageDealt = totalMagicDamageDealt;
	}

	public void setTotalMinionKills(int totalMinionKills) {
		this.totalMinionKills = totalMinionKills;
	}

	public void setTotalNeutralMinionsKilled(int totalNeutralMinionsKilled) {
		this.totalNeutralMinionsKilled = totalNeutralMinionsKilled;
	}

	public void setTotalNodeCapture(int totalNodeCapture) {
		this.totalNodeCapture = totalNodeCapture;
	}

	public void setTotalNodeNeutralize(int totalNodeNeutralize) {
		this.totalNodeNeutralize = totalNodeNeutralize;
	}

	public void setTotalPentaKills(int totalPentaKills) {
		this.totalPentaKills = totalPentaKills;
	}

	public void setTotalPhysicalDamageDealt(int totalPhysicalDamageDealt) {
		this.totalPhysicalDamageDealt = totalPhysicalDamageDealt;
	}

	public void setTotalQuadraKills(int totalQuadraKills) {
		this.totalQuadraKills = totalQuadraKills;
	}

	public void setTotalSessionsLost(int totalSessionsLost) {
		this.totalSessionsLost = totalSessionsLost;
	}

	public void setTotalSessionsPlayed(int totalSessionsPlayed) {
		this.totalSessionsPlayed = totalSessionsPlayed;
	}

	public void setTotalSessionsWon(int totalSessionsWon) {
		this.totalSessionsWon = totalSessionsWon;
	}

	public void setTotalTripleKills(int totalTripleKills) {
		this.totalTripleKills = totalTripleKills;
	}

	public void setTotalTurretsKilled(int totalTurretsKilled) {
		this.totalTurretsKilled = totalTurretsKilled;
	}

	public void setTotalUnrealKills(int totalUnrealKills) {
		this.totalUnrealKills = totalUnrealKills;
	}
}