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
import java.util.List;

import net.rithms.riot.api.Dto;

public class Timeline extends Dto implements Serializable {

	private static final long serialVersionUID = 3888184958883394435L;

	private long frameInterval;
	private List<Frame> frames;

	public long getFrameInterval() {
		return frameInterval;
	}

	public List<Frame> getFrames() {
		return frames;
	}

	public void setFrameInterval(long frameInterval) {
		this.frameInterval = frameInterval;
	}

	public void setFrames(List<Frame> frames) {
		this.frames = frames;
	}

	@Override
	public String toString() {
		return String.valueOf(getFrameInterval());
	}
}