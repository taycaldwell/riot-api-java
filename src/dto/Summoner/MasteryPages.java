package dto.Summoner;

import java.util.Set;

public class MasteryPages {
	
	private long summonerId;
	private Set<MasteryPage> pages;
	
	public long getSummonerId() {
		return summonerId;
	}
	
	public Set<MasteryPage> getPages() {
		return pages;
	}
	
}
