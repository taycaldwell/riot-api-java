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

package net.rithms.riot.api.endpoints.lol_status.dto;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import net.rithms.riot.api.Dto;

public class Message extends Dto implements Serializable {

	private static final long serialVersionUID = 9036838901306467780L;

	private String author;
	private String content;
	@SerializedName(value = "created_at")
	private String createdAt;
	private String id;
	private String severity;
	private List<Translation> translations;
	@SerializedName(value = "updated_at")
	private String updatedAt;

	public String getAuthor() {
		return author;
	}

	public String getContent() {
		return content;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public String getId() {
		return id;
	}

	public String getSeverity() {
		return severity;
	}

	public List<Translation> getTranslations() {
		return translations;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	@Override
	public String toString() {
		return getContent();
	}
}