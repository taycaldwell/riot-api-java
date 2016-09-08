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

package net.rithms.riot.api.endpoints.static_data.dto;

import java.io.Serializable;
import java.util.List;

import net.rithms.riot.api.Dto;

public class MasteryTree extends Dto implements Serializable {

	private static final long serialVersionUID = 5475789665588541152L;

	private List<MasteryTreeList> Cunning;
	private List<MasteryTreeList> Ferocity;
	private List<MasteryTreeList> Resolve;

	public List<MasteryTreeList> getCunning() {
		return Cunning;
	}

	public List<MasteryTreeList> getFerocity() {
		return Ferocity;
	}

	public List<MasteryTreeList> getResolve() {
		return Resolve;
	}

	public void setCunning(List<MasteryTreeList> cunning) {
		Cunning = cunning;
	}

	public void setFerocity(List<MasteryTreeList> ferocity) {
		Ferocity = ferocity;
	}

	public void setResolve(List<MasteryTreeList> resolve) {
		Resolve = resolve;
	}
}