package net.rithms.riot.constant;

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
	AramUnranked5x5("ARAM / Howling Abyss"),
	Ascension("Ascension"),
	Bilgewater("Black Market Brawlers"),
	CAP5x5("Team Builder"),
	CoopVsAI("Summoner's Rift/Crystal Scar Bots"),
	CoopVsAI3x3("Twisted Treeline Bots"),
	CounterPick("Nemesis"),
	FirstBlood1x1("Snowdown Showdown 1x1"),
	FirstBlood2x2("Snowdown Showdown 2x2"),
	Hexakill("Twisted Treeline 6x6 Hexakill"),
	KingPoro("King Poro"),
	NightmareBot("Summoner's Rift Nightmare Bots"),
	OdinUnranked("Dominion/Crystal Scar"),
	OneForAll5x5("One for All"),
	RankedSolo5x5("Summoner's Rift Ranked Solo"),
	RankedTeam3x3("Twisted Treeline Ranked Team"),
	RankedTeam5x5("Summoner's Rift Ranked Team"),
	SummonersRift6x6("Hexakill"),
	Unranked("Summoner's Rift Unranked"),
	Unranked3x3("Twisted Treeline Unranked"),
	URF("Ultra Rapid Fire"),
	URFBots("Ultra Rapid Fire Bots");

	private String name;

	PlayerStatSummaryType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return getName();
	}
}