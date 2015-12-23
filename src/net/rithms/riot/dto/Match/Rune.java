package net.rithms.riot.dto.Match;

import java.io.Serializable;

public class Rune implements Serializable {

	private static final long serialVersionUID = -6196166736612993781L;
	private long rank, runeId;

	public long getRank() {
		return rank;
	}

	public long getRuneId() {
		return runeId;
	}
}