package dto;

import java.util.List;

public class RankedStats {
	
	private List<ChampionStats> champions;
	private long modifyDate, summonerId;
	
	public List<ChampionStats> getChampions() {
		return champions;
	}
	public long getModifyDate() {
		return modifyDate;
	}
	public long getSummonerId() {
		return summonerId;
	}
	
	
}
