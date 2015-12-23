package net.rithms.riot.dto.Match;

import java.io.Serializable;

public class Mastery implements Serializable {

	private static final long serialVersionUID = 1049623074386811783L;
	private long rank, masteryId;

	public long getRank() {
		return rank;
	}

	public long getMasteryId() {
		return masteryId;
	}
}