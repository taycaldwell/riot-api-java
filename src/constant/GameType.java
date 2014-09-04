package constant;
	
public enum GameType {
	    
		CUSTOM_GAME("Custom"),
		TUTORIAL_GAME("Tutorial"),
		MATCHED_GAME("All");
		
	    private String name;
	    
	    GameType(String name) {
	        this.name = name;
	    }

	    public String getName() {
	        return name;
	    }	    
}
