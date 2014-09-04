package dto.Summoner;

import java.util.List;

public class MasteryPage {
	
	private boolean current;
	private long id;
	private String name;
	private List<Mastery> masteries;
	
	public boolean isCurrent() {
		return current;
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public List<Mastery> getMasteries() {
		return masteries;
	}
	
}
