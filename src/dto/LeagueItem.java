package dto;

public class LeagueItem {
	
	private String leagueName, playerOrTeamId, playerOrTeamName, queueType, rank, tier;
	private boolean isFreshBlood, isHotStreak, isInactive, isVeteran;
	private int leaguePoints, wins;
	private long lastPlayed;
	private MiniSeries miniSeries;
	
	public String getPlayerOrTeamId() {
		return playerOrTeamId;
	}

	public boolean isHotStreak() {
		return isHotStreak;
	}

	public boolean isInactive() {
		return isInactive;
	}

	public int getLeaguePoints() {
		return leaguePoints;
	}

	public int getWins() {
		return wins;
	}

	public long getLastPlayed() {
		return lastPlayed;
	}

	public MiniSeries getMiniSeries() {
		return miniSeries;
	}

	public String getRank() {
		return rank;
	}

	public boolean isFreshBlood() {
		return isFreshBlood;
	}


	public String getLeagueName() {
		return leagueName;
	}

	public String getPlayerOrTeamName() {
		return playerOrTeamName;
	}


	public String getQueueType() {
		return queueType;
	}


	public boolean isVeteran() {
		return isVeteran;
	}


	public String getTier() {
		return tier;
	}


	
}
