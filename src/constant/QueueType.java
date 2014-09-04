package constant;
	
public enum QueueType {
	    
		CUSTOM("Custom"),
		NORMAL_5x5_BLIND("Normal 5v5 Blind Pick"),
		BOT_5x5("Historical Summoner's Rift Coop vs AI"),
		BOT_5x5_INTRO("Summoner's Rift Coop vs AI Intro Bot"),
		BOT_5x5_BEGINNER("Summoner's Rift Coop vs AI Beginner Bot"),
		BOT_5x5_INTERMEDIATE("Historical Summoner's Rift Coop vs AI Intermediate Bot"),
		NORMAL_3x3("Normal 3v3"),
		NORMAL_5x5_DRAFT("Normal 5v5 Draft Pick"),
		ODIN_5x5_BLIND("Dominion 5v5 Blind Pick"),
		ODIN_5x5_DRAFT("Dominion 5v5 Draft Pick"),
		BOT_ODIN_5x5("Dominion Coop vs AI"),
		RANKED_SOLO_5x5("Ranked Solo 5v5"),
		RANKED_PREMADE_3x3("Ranked Premade 3v3"),
		RANKED_PREMADE_5x5("Ranked Premade 5v5"),
		RANKED_TEAM_3x3("Ranked Team 3v3"),
		RANKED_TEAM_5x5("Ranked Team 5v5"),
		BOT_TT_3x3("Twisted Treeline Coop vs AI"),
		GROUP_FINDER_5x5("Team Builder"),
		ARAM_5x5("ARAM"),
		ONEFORALL_5x5("One for All"),
		FIRSTBLOOD_1x1("Snowdown Showdown 1v1"),
		FIRSTBLOOD_2x2("Snowdown Showdown 2v2"),
		SR_6x6("Hexakill"),
		URF_5x5("Ultra Rapid Fire"),
		BOT_URF_5x5("Ultra Rapid Fire games played against AI"),
		NIGHTMARE_BOT_5x5_RANK1("Doom Bots Rank 1"),
		NIGHTMARE_BOT_5x5_RANK2("Doom Bots Rank 2"),
		NIGHTMARE_BOT_5x5_RANK5("Doom Bots Rank 5");

	    private String name;
	    
	    QueueType(String name) {
	        this.name = name;
	    }

	    public String getName() {
	        return name;
	    }	    
}
