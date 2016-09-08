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

package net.rithms.riot.api.endpoints.stats.dto;

import java.io.Serializable;
import java.util.List;

import net.rithms.riot.api.Dto;

public class RankedStats extends Dto implements Serializable {

	private static final long serialVersionUID = 6544447595249079077L;

	private List<ChampionStats> champions;
	private long modifyDate;
	private long summonerId;

	public List<ChampionStats> getChampions() {
		return champions;
	}

	public long getModifyDate() {
		return modifyDate;
	}

	public long getSummonerId() {
		return summonerId;
	}

	public void setChampions(List<ChampionStats> champions) {
		this.champions = champions;
	}

	public void setModifyDate(long modifyDate) {
		this.modifyDate = modifyDate;
	}

	public void setSummonerId(long summonerId) {
		this.summonerId = summonerId;
	}
}