package dto.Stats;

/** DEPRECATED **/

public class PlayerStatsSummary {
	
	private AggregatedStats aggregatedStats;
	private int losses, wins;
	private long modifyDate;
	private String playerStatSummaryType;
	
	public AggregatedStats getAggregatedStats() {
		return aggregatedStats;
	}
	public int getLosses() {
		return losses;
	}
	public int getWins() {
		return wins;
	}
	public long getModifyDate() {
		return modifyDate;
	}
	public String getPlayerStatSummaryType() {
		return playerStatSummaryType;
	}
}
