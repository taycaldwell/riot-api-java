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

public class LevelTip extends Dto implements Serializable {

	private static final long serialVersionUID = -3061786573868823081L;

	private List<String> effect;
	private List<String> label;

	public List<String> getEffect() {
		return effect;
	}

	public List<String> getLabel() {
		return label;
	}
	
	public void setEffect(List<String> effect) {
		this.effect = effect;
	}

	public void setLabel(List<String> label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return getLabel().toString();
	}
}