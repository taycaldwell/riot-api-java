package com.github.rithms.constant;

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

public enum PlatformId {
	    
		NA("NA1", "na"),
		BR("BR1", "br"),
		LAN("LA1", "lan"),
		LAS("LA2", "las"),
		OCE("OC1", "oce"),
		EUNE("EUN1", "eune"),
		EUW("EUW1", "euw"),
		KR("KR", "kr"),
		RU("RU", "ru"),
		TR("TR1", "tr"),
		PBE("PBE1", "pbe");
		
	    private String id;
	    private String name;
	    
	    PlatformId(String id, String name) {
	        this.id = id;
	        this.name = name;
	    }

	    public String getId() {
	        return id;
	    }	    
	    
	    public String getName() {
	    	return name;
	    }
}
