package dto;

import java.util.List;

public class MasteryPage {
	
	private boolean current;
	private long id;
	private String name;
	private List<Talent> talents;
	
	public boolean isCurrent() {
		return current;
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public List<Talent> getTalents() {
		return talents;
	}
	
}
