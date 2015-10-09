package com.github.rithms.dto.Summoner;

import java.io.Serializable;

/** DEPRECATED **/

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


public class Rune implements Serializable {
	
	private static final long serialVersionUID = -7246944638208327134L;
	private int id, tier;
	private String description, name;
	
	public int getId() {
		return id;
	}
	
	public int getTier() {
		return tier;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getName() {
		return name;
	}
	
}
