package dto.Static;

import java.util.List;
import java.util.Map;

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

public class BasicData {
	
	private List<String> from;
	private List<String> into;
	private Map<String, Boolean> maps;
	private List<String> tags;
	private Gold gold;
	private Image image;
	private MetaData rune;
	private BasicDataStats stats;
	private String colloq, decription, group, ame, plaintext, requiredChampion,
					sanitizedDescription;
	private boolean consumeOnFull, consumed, hideFromAll, inStore;
	private int depth, id, specialRecipe, stacks;
	
	public List<String> getFrom() {
		return from;
	}
	public List<String> getInto() {
		return into;
	}
	public Map<String, Boolean> getMaps() {
		return maps;
	}
	public List<String> getTags() {
		return tags;
	}
	public Gold getGold() {
		return gold;
	}
	public Image getImage() {
		return image;
	}
	public MetaData getRune() {
		return rune;
	}
	public BasicDataStats getStats() {
		return stats;
	}
	public String getColloq() {
		return colloq;
	}
	public String getDecription() {
		return decription;
	}
	public String getGroup() {
		return group;
	}
	public String getAme() {
		return ame;
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
	public int getDepth() {
		return depth;
	}
	public int getId() {
		return id;
	}
	public int getSpecialRecipe() {
		return specialRecipe;
	}
	public int getStacks() {
		return stacks;
	}

}
