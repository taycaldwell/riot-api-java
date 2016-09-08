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

public class Mastery extends Dto implements Serializable {

	private static final long serialVersionUID = 8480226179945327205L;

	private List<String> description;
	private int id;
	private Image image;
	private String masteryTree;
	private String name;
	private String prereq;
	private int ranks;
	private List<String> sanitizedDescription;

	public List<String> getDescription() {
		return description;
	}

	public int getId() {
		return id;
	}

	public Image getImage() {
		return image;
	}

	// Legal values: Defense, Offense, Utility
	public String getMasteryTree() {
		return masteryTree;
	}

	public String getName() {
		return name;
	}

	public String getPrereq() {
		return prereq;
	}

	public int getRanks() {
		return ranks;
	}

	public List<String> getSanitizedDescription() {
		return sanitizedDescription;
	}

	public void setDescription(List<String> description) {
		this.description = description;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public void setMasteryTree(String masteryTree) {
		this.masteryTree = masteryTree;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrereq(String prereq) {
		this.prereq = prereq;
	}

	public void setRanks(int ranks) {
		this.ranks = ranks;
	}

	public void setSanitizedDescription(List<String> sanitizedDescription) {
		this.sanitizedDescription = sanitizedDescription;
	}

	@Override
	public String toString() {
		return getId() + ": " + getName();
	}
}