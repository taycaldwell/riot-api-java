package dto.Match;

public class Player {
	
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
