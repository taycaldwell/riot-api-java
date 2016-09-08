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

public class Rune extends Dto implements Serializable {

	private static final long serialVersionUID = -4823668922402235509L;

	private String colloq;
	private boolean consumeOnFull;
	private boolean consumed;
	private int depth;
	private String description;
	private List<String> from;
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
	private MetaData rune;
	private String sanitizedDescription;
	private int specialRecipe;
	private BasicDataStats stats;
	private int stacks;
	private List<String> tags;

	public String getColloq() {
		return colloq;
	}

	public int getDepth() {
		return depth;
	}

	public String getDescription() {
		return description;
	}

	public List<String> getFrom() {
		return from;
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

	public MetaData getRune() {
		return rune;
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

	public BasicDataStats getStats() {
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
	
	public void setColloq(String colloq) {
		this.colloq = colloq;
	}

	public void setConsumeOnFull(boolean consumeOnFull) {
		this.consumeOnFull = consumeOnFull;
	}

	public void setConsumed(boolean consumed) {
		this.consumed = consumed;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setFrom(List<String> from) {
		this.from = from;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public void setHideFromAll(boolean hideFromAll) {
		this.hideFromAll = hideFromAll;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public void setInStore(boolean inStore) {
		this.inStore = inStore;
	}

	public void setInto(List<String> into) {
		this.into = into;
	}

	public void setMaps(Map<String, Boolean> maps) {
		this.maps = maps;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPlaintext(String plaintext) {
		this.plaintext = plaintext;
	}

	public void setRequiredChampion(String requiredChampion) {
		this.requiredChampion = requiredChampion;
	}

	public void setRune(MetaData rune) {
		this.rune = rune;
	}

	public void setSanitizedDescription(String sanitizedDescription) {
		this.sanitizedDescription = sanitizedDescription;
	}

	public void setSpecialRecipe(int specialRecipe) {
		this.specialRecipe = specialRecipe;
	}

	public void setStats(BasicDataStats stats) {
		this.stats = stats;
	}

	public void setStacks(int stacks) {
		this.stacks = stacks;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return getId() + ": " + getName();
	}
}