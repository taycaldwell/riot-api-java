package com.github.rithms.dto.Summoner;

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

import java.io.Serializable;
import java.util.Set;

public class MasteryPages implements Serializable {
	
	private static final long serialVersionUID = 2574314573359467443L;
	private long summonerId;
	private Set<MasteryPage> pages;
	
	public long getSummonerId() {
		return summonerId;
	}
	
	public Set<MasteryPage> getPages() {
		return pages;
	}
	
}