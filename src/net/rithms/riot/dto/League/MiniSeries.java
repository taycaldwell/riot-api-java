package net.rithms.riot.dto.League;

import java.io.Serializable;

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

public class MiniSeries implements Serializable {

	private static final long serialVersionUID = -1698803031525933530L;
	private int losses, target, wins;
	private String progress;

	public String getProgress() {
		return progress;
	}

	public int getLosses() {
		return losses;
	}

	public int getWins() {
		return wins;
	}

	public int getTarget() {
		return target;
	}
}