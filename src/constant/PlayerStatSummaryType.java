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
		URFBots("Ultra Rapid Fire Bots"),
		NightmareBot("Summoner's Rift Nightmare Bots"),
		Ascension("Ascension");
		
	    private String name;
	    
	    PlayerStatSummaryType(String name) {
	        this.name = name;
	    }

	    public String getName() {
	        return name;
	    }	    
}
