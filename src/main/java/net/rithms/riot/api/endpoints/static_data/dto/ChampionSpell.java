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

import net.rithms.riot.api.Dto;

public class ChampionSpell extends Dto implements Serializable {

	private static final long serialVersionUID = 5070619841076416615L;

	private List<Image> altimages;
	private List<Double> cooldown;
	private String cooldownBurn;
	private List<Integer> cost;
	private String costBurn;
	private String costType;
	private String description;
	private List<Object> effect;
	private List<String> effectBurn;
	private Image image;
	private String key;
	private LevelTip leveltip;
	private int maxrank;
	private String name;
	private Object range;
	private String rangeBurn;
	private String resource;
	private String sanitizedDescription;
	private String sanitizedTooltip;
	private String tooltip;
	private List<SpellVars> vars;

	public List<Image> getAltimages() {
		return altimages;
	}

	public List<Double> getCooldown() {
		return cooldown;
	}

	public String getCooldownBurn() {
		return cooldownBurn;
	}

	public List<Integer> getCost() {
		return cost;
	}

	public String getCostBurn() {
		return costBurn;
	}

	public String getCostType() {
		return costType;
	}

	public String getDescription() {
		return description;
	}

	public List<Object> getEffect() {
		return effect;
	}

	public List<String> getEffectBurn() {
		return effectBurn;
	}

	public Image getImage() {
		return image;
	}

	public String getKey() {
		return key;
	}

	public LevelTip getLeveltip() {
		return leveltip;
	}

	public int getMaxrank() {
		return maxrank;
	}

	public String getName() {
		return name;
	}

	public Object getRange() {
		return range;
	}

	public String getRangeBurn() {
		return rangeBurn;
	}

	public String getResource() {
		return resource;
	}

	public String getSanitizedDescription() {
		return sanitizedDescription;
	}

	public String getSanitizedTooltip() {
		return sanitizedTooltip;
	}

	public String getTooltip() {
		return tooltip;
	}

	public List<SpellVars> getVars() {
		return vars;
	}

	@Override
	public String toString() {
		return getName();
	}
}
