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

import net.rithms.riot.api.Dto;

/**
 * This object contains image data.
 */
public class Image extends Dto implements Serializable {

	private static final long serialVersionUID = 5802273643884377746L;

	private String full;
	private String group;
	private int h;
	private String sprite;
	private int w;
	private int x;
	private int y;

	public String getFull() {
		return full;
	}

	public String getGroup() {
		return group;
	}

	public int getH() {
		return h;
	}

	public String getSprite() {
		return sprite;
	}

	public int getW() {
		return w;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return getSprite();
	}
}