package net.rithms.riot.dto.Match;

import java.io.Serializable;

public class Player implements Serializable {

	private static final long serialVersionUID = -4459702825178547603L;
	private String matchHistoryUri, summonerName;
	private int profileIcon;
	private long summonerId;

	public String getMatchHistoryUri() {
		return matchHistoryUri;
	}

	public long getSummonerId() {
		return summonerId;
	}

	public String getSummonerName() {
		return summonerName;
	}

	public int getProfileIcon() {
		return profileIcon;
	}
}