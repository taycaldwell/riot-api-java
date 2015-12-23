package net.rithms.riot.dto.Static;

import java.io.Serializable;
import java.util.List;

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

public class Mastery implements Serializable {

	private static final long serialVersionUID = 8480226179945327205L;
	private List<String> description;
	private List<String> sanitizedDescription;
	private Image image;
	private int id, ranks;
	private String name, prereq, masteryTree;

	public List<String> getDescription() {
		return description;
	}

	public List<String> getSanitizedDescription() {
		return sanitizedDescription;
	}

	public Image getImage() {
		return image;
	}

	public int getId() {
		return id;
	}

	public int getRanks() {
		return ranks;
	}

	public String getName() {
		return name;
	}

	public String getPrereq() {
		return prereq;
	}

	/**
	 * Legal values: Defense, Offense, Utility
	 */
	public String getMasteryTree() {
		return masteryTree;
	}
}