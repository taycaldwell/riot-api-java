package constant.staticdata;

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

public enum ChampData {
	    
		ALL("all"),
		ALLYTIPS("allytips"),
		ALTIMAGES("altimages"),
		BLURB("blurb"),
		ENEMYTIPS("enemytips"),
		IMAGE("image"),
		INFO("info"),
		LORE("lore"),
		PARTYPE("partype"),
		PASSIVE("passive"),
		RECOMMENDED("recommended"),
		SKINS("skins"),
		SPELLS("spells"),
		STATS("stats"),
		TAGS("tags");
		
	    private String name;
	    
	    ChampData(String name) {
	        this.name = name;
	    }

	    public String getName() {
	        return name;
	    }	    
}
