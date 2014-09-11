package constant;

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
		NIGHTMARE_BOT("Summoner's Rift Doom Bots"),
		ASCENSION("Ascension");
		
		
	    private String name;
	    
	    SubType(String name) {
	        this.name = name;
	    }

	    public String getName() {
	        return name;
	    }	    
}
