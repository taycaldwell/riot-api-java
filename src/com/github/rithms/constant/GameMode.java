package com.github.rithms.constant;

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

public enum GameMode {
	    
		CLASSIC("Classic"),
		ODIN("Dominion/Crystal Scar"),
		ARAM("ARAM"),
		TUTORIAL("Tutorial"),
		ONEFORALL("One for All"),
		ASCENSION("Ascension"),
		FIRSTBLOOD("Snowdown Showdown"),
		KINGPORO("King Poro");

	    private String name;
	    
	    GameMode(String name) {
	        this.name = name;
	    }

	    public String getName() {
	        return name;
	    }	    
}
