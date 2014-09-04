package dto.Game;

import java.util.Set;

public class RecentGames {
	
	private Set<Game> games;
	private long summonerId;
	
	public Set<Game> getGames() {
		return games;
	}
	
	public long getSummonerId() {
		return summonerId;
	}
	
}
