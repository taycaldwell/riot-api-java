package dto.Match;

import java.util.List;
import java.util.Map;

public class Frame {
	
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
