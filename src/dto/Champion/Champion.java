package dto.Champion;

public class Champion {
	
	private boolean active, botEnabled, botMmEnabled, freeToPlay, rankedPlayEnabled;
	private long id;
	
	public boolean isBotEnabled() {
		return botEnabled;
	}
	public void setBotEnabled(boolean botEnabled) {
		this.botEnabled = botEnabled;
	}
	public boolean isActive() {
		return active;
	}
	
	public boolean isFreeToPlay() {
		return freeToPlay;
	}
	
	public boolean isRankedPlayEnabled() {
		return rankedPlayEnabled;
	}

	public boolean isBotMmEnabled() {
		return botMmEnabled;
	}
	
	public long getId() {
		return id;
	}


}
