package dto;

public class Champion {
	
	private boolean active, botEnabled, botMmEnabled, freeToPlay, rankedPlayEnabled;
	private int attackRank, defenseRank, difficultyRank, magicRank;
	private long id;
	private String name;
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
	
	public int getAttackRank() {
		return attackRank;
	}
	
	public long getId() {
		return id;
	}
	
	public int getMagicRank() {
		return magicRank;
	}
	
	public int getDifficultyRank() {
		return difficultyRank;
	}
	
	public int getDefenseRank() {
		return defenseRank;
	}

	public String getName() {
		return name;
	}
	
}
