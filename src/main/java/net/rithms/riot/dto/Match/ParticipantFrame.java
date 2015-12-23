package net.rithms.riot.dto.Match;

import java.io.Serializable;

public class ParticipantFrame implements Serializable {

	private static final long serialVersionUID = -7134736662198942818L;
	private int currentGold, jungleMinionsKilled, level, minionsKilled, participantId, totalGold, xp;
	private Position position;

	public int getCurrentGold() {
		return currentGold;
	}

	public int getJungleMinionsKilled() {
		return jungleMinionsKilled;
	}

	public int getLevel() {
		return level;
	}

	public int getMinionsKilled() {
		return minionsKilled;
	}

	public int getParticipantId() {
		return participantId;
	}

	public int getTotalGold() {
		return totalGold;
	}

	public int getXp() {
		return xp;
	}

	public Position getPosition() {
		return position;
	}
}