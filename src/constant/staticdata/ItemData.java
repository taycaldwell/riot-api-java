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

public enum ItemData {
	    
		ALL("all"),
		COLLOQ("colloq"),
		CONSUME_ON_FULL("consumeOnFull"),
		CONSUMED("consumed"),
		DEPTH("depth"),
		FROM("from"),
		GOLD("gold"),
		HIDE_FROM_ALL("hideFromAll"),
		IMAGE("image"),
		IN_STORE("inStore"),
		INTO("into"),
		MAPS("maps"),
		REQUIRED_CHAMPION("requiredChampion"),
		SANITIZED_DESCRIPTION("sanitizedDescription"),
		SPECIAL_RECIPE("specialRecipe"),
		STACKS("stacks"),
		STATS("stats"),
		TAGS("tags"),
		TREE("tree");
		
	    private String name;
	    
	    ItemData(String name) {
	        this.name = name;
	    }

	    public String getName() {
	        return name;
	    }	    
}
