package dto;

public class MiniSeries {
	
	private int losses, target, wins;
	private char[] progress;
	private long timeLeftToPlayMillis;
	
	public char[] getProgress() {
		return progress;
	}

	public int getLosses() {
		return losses;
	}

	public int getWins() {
		return wins;
	}

	public long getTimeLeftToPlayMillis() {
		return timeLeftToPlayMillis;
	}

	public int getTarget() {
		return target;
	}

}
