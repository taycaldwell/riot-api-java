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
