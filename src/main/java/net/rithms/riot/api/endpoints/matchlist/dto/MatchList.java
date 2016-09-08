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

package net.rithms.riot.api.endpoints.matchlist.dto;

import java.io.Serializable;
import java.util.List;

import net.rithms.riot.api.Dto;

public class MatchList extends Dto implements Serializable {

	private static final long serialVersionUID = 939383850419752274L;

	private int endIndex;
	private List<MatchReference> matches;
	private int startIndex;
	private int totalGames;

	public int getEndIndex() {
		return endIndex;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public int getTotalGames() {
		return totalGames;
	}

	public List<MatchReference> getMatches() {
		return matches;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public void setMatches(List<MatchReference> matches) {
		this.matches = matches;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public void setTotalGames(int totalGames) {
		this.totalGames = totalGames;
	}

	@Override
	public String toString() {
		return "[" + getStartIndex() + "," + getEndIndex() + "]";
	}
}