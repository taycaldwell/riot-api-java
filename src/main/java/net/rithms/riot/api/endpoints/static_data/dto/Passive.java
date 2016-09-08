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

import net.rithms.riot.api.Dto;

public class Passive extends Dto implements Serializable {

	private static final long serialVersionUID = 3894157958044991050L;

	private String description;
	private Image image;
	private String name;
	private String sanitizedDescription;

	public String getDescription() {
		return description;
	}

	public Image getImage() {
		return image;
	}

	public String getName() {
		return name;
	}

	public String getSanitizedDescription() {
		return sanitizedDescription;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSanitizedDescription(String sanitizedDescription) {
		this.sanitizedDescription = sanitizedDescription;
	}

	@Override
	public String toString() {
		return getName();
	}
}