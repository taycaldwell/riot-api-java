package net.rithms.riot.dto.Match;

import java.io.Serializable;

public class ParticipantTimelineData implements Serializable {

	private static final long serialVersionUID = 3515118575430099707L;
	private double tenToTwenty, thirtyToEnd, twentyToThirty, zeroToTen;

	public double getTenToTwenty() {
		return tenToTwenty;
	}

	public double getThirtyToEnd() {
		return thirtyToEnd;
	}

	public double getTwentyToThirty() {
		return twentyToThirty;
	}

	public double getZeroToTen() {
		return zeroToTen;
	}
}