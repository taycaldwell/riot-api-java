package dto.Summoner;

import java.util.Set;

public class RunePage {
	
	private boolean current;
	private long id;
	private String name;
	private Set<RuneSlot> slots;
	
	public boolean isCurrent() {
		return current;
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Set<RuneSlot> getSlots() {
		return slots;
	}

}
