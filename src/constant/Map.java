package constant;
	
public enum Map {
	    
		SUMMONERS_RIFT_SUMMER(1),
		SUMMONERS_RIFT_AUTUMN(2),
		PROVING_GROUNDS(3),
		TUTORIAL(3),
		TWISTED_TREELINE_ORIGINAL(4),
		CRYSTAL_SCAR(8),
		DOMINION(8),
		TWISTED_TREELINE_CURRENT(10),
		HOWLING_ABYSS(12),
		ARAM(12);
		

	    private int id;
	    
	    Map(int id) {
	        this.id = id;
	    }

	    public int getId() {
	        return id;
	    }	    
}
