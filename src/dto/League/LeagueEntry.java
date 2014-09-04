package dto.League;


public class LeagueEntry {
	
	private String division, playerOrTeamId, playerOrTeamName;
	private boolean isFreshBlood, isHotStreak, isInactive, isVeteran;
	private int leaguePoints, wins;
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

	public MiniSeries getMiniSeries() {
		return miniSeries;
	}

	public boolean isFreshBlood() {
		return isFreshBlood;
	}

	public String getPlayerOrTeamName() {
		return playerOrTeamName;
	}

	public boolean isVeteran() {
		return isVeteran;
	}

	public String getDivision() {
		return division;
	}
	
}
