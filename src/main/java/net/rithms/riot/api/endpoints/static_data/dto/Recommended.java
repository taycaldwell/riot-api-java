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

public class Recommended extends Dto implements Serializable {

	private static final long serialVersionUID = 8722523053273835114L;

	private List<Block> blocks;
	private String champion;
	private String map;
	private String mode;
	private boolean priority;
	private String title;
	private String type;

	public List<Block> getBlocks() {
		return blocks;
	}

	public String getChampion() {
		return champion;
	}

	public String getMap() {
		return map;
	}

	public String getMode() {
		return mode;
	}

	public String getTitle() {
		return title;
	}

	public String getType() {
		return type;
	}

	public boolean isPriority() {
		return priority;
	}

	public void setBlocks(List<Block> blocks) {
		this.blocks = blocks;
	}

	public void setChampion(String champion) {
		this.champion = champion;
	}

	public void setMap(String map) {
		this.map = map;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public void setPriority(boolean priority) {
		this.priority = priority;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return getTitle();
	}
}