package constant;
	
public enum PlayerStatSummaryType {
	    
		Unranked("Summoner's Rift Unranked"),
		Unranked3x3("Twisted Treeline Unranked"),
		OdinUnranked("Dominion/Crystal Scar"),
		AramUnranked5x5("ARAM / Howling Abyss"),
		CoopVsAI("Summoner's Rift/Crystal Scar Bots"),
		CoopVsAI3x3("Twisted Treeline Bots"),
		RankedSolo5x5("Summoner's Rift Ranked Solo"),
		RankedTeam3x3("Twisted Treeline Ranked Team"),
		RankedTeam5x5("Summoner's Rift Ranked Team"),
		OneForAll5x5("One for All"),
		FirstBlood1x1("Snowdown Showdown 1x1"),
		FirstBlood2x2("Snowdown Showdown 2x2"),
		SummonersRift6x6("Hexakill"),
		CAP5x5("Team Builder"),
		URF("Ultra Rapid Fire"),
		URFBots("Ultra Rapid Fire Bots");
		
	    private String name;
	    
	    PlayerStatSummaryType(String name) {
	        this.name = name;
	    }

	    public String getName() {
	        return name;
	    }	    
}
