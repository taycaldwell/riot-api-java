package net.rithms.riot.dto.Match;

import java.io.Serializable;

public class Position implements Serializable {

	private static final long serialVersionUID = -6998248732159256525L;
	private int x, y;

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}
}