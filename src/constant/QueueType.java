package constant;

import java.util.HashMap;

/*
 * Copyright 2014 Taylor Caldwell
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
	
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
        ONEFORALL_MIRRORMODE_5x5("One for All: Mirror Mode"),
		FIRSTBLOOD_1x1("Snowdown Showdown 1v1"),
		FIRSTBLOOD_2x2("Snowdown Showdown 2v2"),
		SR_6x6("Hexakill"),
		URF_5x5("Ultra Rapid Fire"),
		BOT_URF_5x5("Ultra Rapid Fire games played against AI"),
		NIGHTMARE_BOT_5x5_RANK1("Doom Bots Rank 1"),
		NIGHTMARE_BOT_5x5_RANK2("Doom Bots Rank 2"),
		NIGHTMARE_BOT_5x5_RANK5("Doom Bots Rank 5"),
		ASCENSION_5x5("Ascension"),
		HEXAKILL("Twisted Treeline 6x6 Hexakill"),
		KING_PORO_5x5("King Poro");

		private static final HashMap<Integer, String> queueTypes;
	    private String name;
	    
	    static {
	    	HashMap<Integer, String> hm = new HashMap<Integer, String>();
			hm.put(0, "Custom");
			hm.put(2, "Normal 5v5 Blind Pick");
			hm.put(7, "Historical Summoner's Rift Coop vs AI");
			hm.put(31, "Summoner's Rift Coop vs AI Intro Bot");
			hm.put(32, "Summoner's Rift Coop vs AI Beginner Bot");
			hm.put(33, "Historical Summoner's Rift Coop vs AI Intermediate Bot");
			hm.put(8, "Normal 3v3");
			hm.put(14, "Normal 5v5 Draft Pick");
			hm.put(16, "Dominion 5v5 Blind Pick");
			hm.put(17, "Dominion 5v5 Draft Pick");
			hm.put(25, "Dominion Coop vs AI");
			hm.put(4, "Ranked Solo 5v5");
			hm.put(9, "Ranked Premade 3v3");
			hm.put(6, "Ranked Premade 5v5");
			hm.put(41, "Ranked Team 3v3");
			hm.put(42, "Ranked Team 5v5");
			hm.put(52, "Twisted Treeline Coop vs AI");
			hm.put(61, "Team Builder");
			hm.put(65, "ARAM");
			hm.put(70, "One for All");
			hm.put(72, "Snowdown Showdown 1v1");
			hm.put(73, "Snowdown Showdown 2v2");
			hm.put(75, "Hexakill");
			hm.put(76, "Ultra Rapid Fire");
			hm.put(83, "Ultra Rapid Fire games played against AI");
			hm.put(91, "Doom Bots Rank 1");
			hm.put(92, "Doom Bots Rank 2");
			hm.put(93, "Doom Bots Rank 5");
			hm.put(96, "Ascension");
			hm.put(98, "Twisted Treeline 6x6 Hexakill");
			hm.put(300, "King Poro");
	    	queueTypes = hm;
	    }
	    
	    public static String getQueueNameByConfigId(int gameQueueConfigId) {
	    	return queueTypes.get(gameQueueConfigId);
	    }
	    
	    QueueType(String name) {
	        this.name = name;
	    }

	    public String getName() {
	        return name;
	    }	    
}
