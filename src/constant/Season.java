package constant;
	
public enum Season {
	     
		FOUR("SEASON4"),
		THREE("SEASON3");

	    private String season;
	    
	    Season(String season) {
	        this.season = season;
	    }

	    public String getName() {
	        return season;
	    }	    
}
