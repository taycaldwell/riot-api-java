package com.github.rithms.dto.Match;

import java.io.Serializable;
import java.util.List;

public class Team implements Serializable {

	private static final long serialVersionUID = -3414402914522684688L;
	private List<BannedChampion> bans;
	private int baronKills, dragonKills, inhibitorKills, teamId, towerKills,
				vilemawKills;
	private boolean firstBaron, firstBlood, firstDragon, firstInhibitor, firstTower,
				winner;
	private long dominionVictoryScore;
	
	public long getDominionVictoryScore() {
		return dominionVictoryScore;
	}

	public List<BannedChampion> getBans() {
		return bans;
	}
	
	public int getBaronKills() {
		return baronKills;
	}
	
	public int getDragonKills() {
		return dragonKills;
	}
	
	public int getInhibitorKills() {
		return inhibitorKills;
	}
	
	public int getTeamId() {
		return teamId;
	}
	
	public int getTowerKills() {
		return towerKills;
	}
	
	public int getVilemawKills() {
		return vilemawKills;
	}
	
	public boolean isFirstBaron() {
		return firstBaron;
	}
	
	public boolean isFirstBlood() {
		return firstBlood;
	}
	
	public boolean isFirstDragon() {
		return firstDragon;
	}
	
	public boolean isFirstInhibitor() {
		return firstInhibitor;
	}
	
	public boolean isFirstTower() {
		return firstTower;
	}
	
	public boolean isWinner() {
		return winner;
	}

}
