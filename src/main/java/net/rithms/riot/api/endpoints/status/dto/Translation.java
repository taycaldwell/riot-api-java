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

package net.rithms.riot.api.endpoints.status.dto;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import net.rithms.riot.api.Dto;

public class Translation extends Dto implements Serializable {

	private static final long serialVersionUID = -8923544184113630844L;

	private String content;
	private String locale;
	@SerializedName(value = "updated_at")
	private String updatedAt;

	public String getContent() {
		return content;
	}

	public String getLocale() {
		return locale;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return getContent();
	}
}