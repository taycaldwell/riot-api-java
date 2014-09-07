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

public enum SpellData {
	    
		ALL("all"),
		COOLDOWN("cooldown"),
		COOLDOWN_BURN("cooldownBurn"),
		COST("cost"),
		COST_BURN("costBurn"),
		COST_TYPE("costType"),
		EFFECT("effect"),
		EFFECT_BURN("effectBurn"),
		IMAGE("image"),
		KEY("key"),
		LEVELTIP("leveltip"),
		MAXRANK("maxrank"),
		MODES("modes"),
		RANGE("range"),
		RANGE_BURN("rangeBurn"),
		RESOURCE("resource"),
		SANITIZED_DESCRIPTION("sanitizedDescription"),
		SANITIZED_TOOLTIP("sanitizedTooltip"),
		TOOLTIP("tooltip"),
		VARS("vars");
		
	    private String name;
	    
	    SpellData(String name) {
	        this.name = name;
	    }

	    public String getName() {
	        return name;
	    }	    
}
