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

package net.rithms.riot.api.endpoints.summoner.dto;

import java.io.Serializable;

import net.rithms.riot.api.Dto;

public class Mastery extends Dto implements Serializable {

	private static final long serialVersionUID = -1053051501742552701L;

	private int id;
	private int rank;

	public int getId() {
		return id;
	}

	public int getRank() {
		return rank;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return getId() + ": " + getRank();
	}
}