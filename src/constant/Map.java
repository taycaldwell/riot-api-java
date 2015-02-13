package constant;

/*
 * Copyright 2015 Taylor Caldwell
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

import java.util.HashMap;

public class Map {

	private static final HashMap<Integer, String> maps;
	
	static {
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "Summoner's Rift"); //Original Summer Variant
		hm.put(2, "Summoner's Rift"); //Original Autumn Variant
		hm.put(3, "The Proving Grounds"); //Tutorial Map
		hm.put(4, "Twisted Treeline"); //Original Version
		hm.put(8, "The Crystal Scar"); //Dominion Map
		hm.put(10, "Twisted Treeline"); //Current Version
		hm.put(11, "Summoner's Rift"); //Current Version
		hm.put(12, "Howling Abyss"); //ARAM Map
		
		maps = hm;
	}
	
	public static String getMapNameById(int id) {
		return maps.get(id);
	}
	
}
