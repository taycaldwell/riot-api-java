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

package net.rithms.riot.api.endpoints.match.dto;

import java.io.Serializable;

import lombok.Data;
import net.rithms.riot.api.Dto;

public @Data class MatchPosition extends Dto implements Serializable {

	private static final long serialVersionUID = -6998248732159256525L;

	private int x;
	private int y;

	@Override
	public String toString() {
		return "[" + getX() + "," + getY() + "]";
	}
}