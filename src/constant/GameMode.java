package constant;
	
public enum GameMode {
	    
		CLASSIC("Classic Summoner's Rift and Twisted Treeline"),
		ODIN("Dominion/Crystal Scar"),
		ARAM("ARAM"),
		TUTORIAL("Tutorial"),
		ONEFORALL("One for All"),
		FIRSTBLOOD("Snowdown Showdown");

	    private String name;
	    
	    GameMode(String name) {
	        this.name = name;
	    }

	    public String getName() {
	        return name;
	    }	    
}
