package constant;
	
public enum SubType {
	    
		NONE("Custom"),
		NORMAL("Summoner's Rift Unranked"),
		NORMAL_3x3("Twisted Treeline Unranked"),
		ODIN_UNRANKED("Dominion/Crystal Scar"),
		ARAM_UNRANKED_5x5("ARAM / Howling Abyss"),
		BOT("Summoner's Rift/Crystal Scar Bots"),
		BOT_3x3("Twisted Treeline Bots"),
		RANKED_SOLO_5x5("Summoner's Rift Ranked Solo"),
		RANKED_TEAM_3x3("Twisted Treeline Ranked Team"),
		RANKED_TEAM_5x5("Summoner's Rift Ranked Team"),
		ONEFORALL_5x5("One for All"),
		FIRSTBLOOD_1x1("Snowdown Showdown 1x1"),
		FIRSTBLOOD_2x2("Snowdown Showdown 2x2"),
		SR_6x6("Hexakill"),
		CAP_5x5("Team Builder"),
		URF("Ultra Rapid Fire"),
		URF_BOT("Ultra Rapid Fire Bots"),
		NIGHTMARE_BOT("Summoner's Rift Doom Bots");
		
		
	    private String name;
	    
	    SubType(String name) {
	        this.name = name;
	    }

	    public String getName() {
	        return name;
	    }	    
}
