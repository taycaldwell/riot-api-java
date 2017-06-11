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
import java.util.List;
import java.util.Map;

import net.rithms.riot.api.Dto;

public class Item extends Dto implements Serializable {

	private static final long serialVersionUID = -2356960824032495693L;

	private String colloq;
	private boolean consumeOnFull;
	private boolean consumed;
	private int depth;
	private String description;
	private Map<String, String> effect;
	private List<String> from;
	private Gold gold;
	private String group;
	private boolean hideFromAll;
	private int id;
	private Image image;
	private boolean inStore;
	private List<String> into;
	private Map<String, Boolean> maps;
	private String name;
	private String plaintext;
	private String requiredChampion;
	private String sanitizedDescription;
	private int specialRecipe;
	private int stacks;
	private InventoryDataStats stats;
	private List<String> tags;

	public String getColloq() {
		return colloq;
	}

	public String getDescription() {
		return description;
	}

	public int getDepth() {
		return depth;
	}

	public Map<String, String> getEffect() {
		return effect;
	}

	public List<String> getFrom() {
		return from;
	}

	public Gold getGold() {
		return gold;
	}

	public String getGroup() {
		return group;
	}

	public int getId() {
		return id;
	}

	public Image getImage() {
		return image;
	}

	public List<String> getInto() {
		return into;
	}

	public Map<String, Boolean> getMaps() {
		return maps;
	}

	public String getName() {
		return name;
	}

	public String getPlaintext() {
		return plaintext;
	}

	public String getRequiredChampion() {
		return requiredChampion;
	}

	public String getSanitizedDescription() {
		return sanitizedDescription;
	}

	public int getSpecialRecipe() {
		return specialRecipe;
	}

	public int getStacks() {
		return stacks;
	}

	public InventoryDataStats getStats() {
		return stats;
	}

	public List<String> getTags() {
		return tags;
	}

	public boolean isConsumeOnFull() {
		return consumeOnFull;
	}

	public boolean isConsumed() {
		return consumed;
	}

	public boolean isHideFromAll() {
		return hideFromAll;
	}

	public boolean isInStore() {
		return inStore;
	}

	@Override
	public String toString() {
		return getId() + ": " + getName();
	}
}