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
import java.util.Set;

import net.rithms.riot.api.Dto;

public class MasteryPages extends Dto implements Serializable {

	private static final long serialVersionUID = 2574314573359467443L;

	private Set<MasteryPage> pages;
	private long summonerId;

	public Set<MasteryPage> getPages() {
		return pages;
	}

	public long getSummonerId() {
		return summonerId;
	}
	
	public void setPages(Set<MasteryPage> pages) {
		this.pages = pages;
	}

	public void setSummonerId(long summonerId) {
		this.summonerId = summonerId;
	}

	@Override
	public String toString() {
		return getPages().toString();
	}
}