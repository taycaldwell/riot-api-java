package dto.Team;

public class MatchHistorySummary {

	private int assists, deaths, kills, mapId, opposingTeamKills;
	private String gameMode, opposingTeamName;
	private boolean invalid, win;
	private long gameId, date;
	
	public int getAssists() {
		return assists;
	}
	
	public int getDeaths() {
		return deaths;
	}
	
	public int getKills() {
		return kills;
	}
	
	public int getMapId() {
		return mapId;
	}
	
	public int getOpposingTeamKills() {
		return opposingTeamKills;
	}
	
	public String getGameMode() {
		return gameMode;
	}
	
	public String getOpposingTeamName() {
		return opposingTeamName;
	}
	
	public boolean isInvalid() {
		return invalid;
	}
	
	public boolean isWin() {
		return win;
	}
	
	public long getGameId() {
		return gameId;
	}

	public long getDate() {
		return date;
	}
	
}
