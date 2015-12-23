package net.rithms.riot.dto.Match;

import java.io.Serializable;

public class BannedChampion implements Serializable {

	private static final long serialVersionUID = 2323180505557888125L;
	private int championId, pickTurn;

	public int getChampionId() {
		return championId;
	}

	public int getPickTurn() {
		return pickTurn;
	}
}