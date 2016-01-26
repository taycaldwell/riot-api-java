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

public class RuneStat implements Serializable {

	private static final long serialVersionUID = -5413858974003841974L;
	private String type;
	private double value;

	public String getType() {
		return type;
	}

	public double getValue() {
		return value;
	}

	protected void setType(String type) {
		this.type = type;
	}

	protected void setValue(double value) {
		this.value = value;
	}
}