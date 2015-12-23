package net.rithms.riot.dto.Match;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Frame implements Serializable {

	private static final long serialVersionUID = 4359409042534560829L;
	private List<Event> events;
	private Map<String, ParticipantFrame> participantFrames;
	private long timestamp;

	public List<Event> getEvents() {
		return events;
	}

	public Map<String, ParticipantFrame> getParticipantFrames() {
		return participantFrames;
	}

	public long getTimestamp() {
		return timestamp;
	}
}