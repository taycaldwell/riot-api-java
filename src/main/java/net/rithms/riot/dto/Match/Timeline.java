package net.rithms.riot.dto.Match;

import java.io.Serializable;
import java.util.List;

public class Timeline implements Serializable {

	private static final long serialVersionUID = 3888184958883394435L;
	private List<Frame> frames;
	private long frameInterval;

	public List<Frame> getFrames() {
		return frames;
	}

	public long getFrameInterval() {
		return frameInterval;
	}
}