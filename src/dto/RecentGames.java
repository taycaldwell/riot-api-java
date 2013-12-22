package dto;

import java.util.List;

public class RecentGames {
	
	private List<Game> games;
	private long summonerId;
	
	public List<Game> getGames() {
		return games;
	}
	
	public long getSummonerId() {
		return summonerId;
	}
	
}
