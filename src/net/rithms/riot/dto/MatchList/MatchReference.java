package net.rithms.riot.dto.MatchList;

import java.io.Serializable;

public class MatchReference implements Serializable {

	private static final long serialVersionUID = 3975874858170021162L;
	private long champion, matchId, timestamp;
	private String lane, platformId, queue, role, season;

	public long getChampion() {
		return champion;
	}

	public long getMatchId() {
		return matchId;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public String getLane() {
		return lane;
	}

	public String getPlatformId() {
		return platformId;
	}

	public String getQueue() {
		return queue;
	}

	public String getRole() {
		return role;
	}

	public String getSeason() {
		return season;
	}
}