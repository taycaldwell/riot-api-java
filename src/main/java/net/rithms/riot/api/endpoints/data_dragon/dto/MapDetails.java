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
import java.util.List;

import net.rithms.riot.api.Dto;

/**
 * This object contains map details data.
 */
public class MapDetails extends Dto implements Serializable {

	private static final long serialVersionUID = -8161048291003061062L;

	private Image image;
	private int mapId;
	private String mapName;
	private List<Long> unpurchasableItemList;

	public Image getImage() {
		return image;
	}

	public int getMapId() {
		return mapId;
	}

	public String getMapName() {
		return mapName;
	}

	public List<Long> getUnpurchasableItemList() {
		return unpurchasableItemList;
	}

	@Override
	public String toString() {
		return getMapName();
	}
}