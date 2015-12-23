package net.rithms.riot.dto.Match;

import java.io.Serializable;

public class ParticipantIdentity implements Serializable {

	private static final long serialVersionUID = 7750317217073991764L;
	private int participantId;
	private Player player;

	public int getParticipantId() {
		return participantId;
	}

	public Player getPlayer() {
		return player;
	}
}