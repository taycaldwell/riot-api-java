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

package net.rithms.riot.api.endpoints.data_dragon.dto;

import java.io.Serializable;
import java.util.List;

import net.rithms.riot.api.Dto;

/**
 * This object contains rune data.
 */
public class Rune extends Dto implements Serializable {

	private static final long serialVersionUID = -4823668922402235509L;

	private String description;
	private int id;
	private Image image;
	private String name;
	private MetaData rune;
	private String sanitizedDescription;
	private RuneStats stats;
	private List<String> tags;

	public String getDescription() {
		return description;
	}

	public int getId() {
		return id;
	}

	public Image getImage() {
		return image;
	}

	public String getName() {
		return name;
	}

	public MetaData getRune() {
		return rune;
	}

	public String getSanitizedDescription() {
		return sanitizedDescription;
	}

	public RuneStats getStats() {
		return stats;
	}

	public List<String> getTags() {
		return tags;
	}

	@Override
	public String toString() {
		return getId() + ": " + getName();
	}
}