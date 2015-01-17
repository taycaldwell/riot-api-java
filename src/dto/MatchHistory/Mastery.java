package dto.MatchHistory;

import java.io.Serializable;

public class Mastery implements Serializable {
	
	private static final long serialVersionUID = 4262895569684383732L;
	private long rank, masteryId;

	public long getRank() {
		return rank;
	}

	public long getMasteryId() {
		return masteryId;
	}
}
