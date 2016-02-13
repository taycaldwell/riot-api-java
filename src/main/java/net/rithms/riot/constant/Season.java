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

package net.rithms.riot.constant;

public enum Season {
	// Seasons with Number
	SEASON3("SEASON3"),
	SEASON4("SEASON2014"),
	SEASON5("SEASON2015"),
	SEASON6("SEASON2016"),

	// Seasons with Year
	SEASON2013("SEASON3"),
	SEASON2014("SEASON2014"),
	SEASON2015("SEASON2015"),
	SEASON2016("SEASON2016"),

	// Preseasons
	PRESEASON3("PRESEASON3"),
	PRESEASON2014("PRESEASON2014"),
	PRESEASON2015("PRESEASON2015"),
	PRESEASON2016("PRESEASON2016"),

	// Number
	THREE("SEASON3"),
	FOUR("SEASON2014"),
	FIVE("SEASON2015"),
	SIX("SEASON2016"),

	// Current Season
	CURRENT("SEASON2016");

	private String season;

	Season(String season) {
		this.season = season;
	}

	public String getName() {
		return season;
	}

	@Override
	public String toString() {
		return getName();
	}
}