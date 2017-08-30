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

/**
 * This object contains summoner spell data.
 */
public class SummonerSpell extends Dto implements Serializable {

	private static final long serialVersionUID = -8682930729114683183L;

	private List<Double> cooldown;
	private String cooldownBurn;
	private List<Integer> cost;
	private String costBurn;
	private String costType;
	private String description;
	private List<Object> effect;
	private List<String> effectBurn;
	private int id;
	private Image image;
	private String key;
	private LevelTip leveltip;
	private int maxrank;
	private List<String> modes;
	private String name;
	private Object range;
	private String rangeBurn;
	private String resource;
	private String sanitizedDescription;
	private String sanitizedTooltip;
	private int summonerLevel;
	private String tooltip;
	private List<SpellVars> vars;

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

	public int getId() {
		return id;
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

	public List<String> getModes() {
		return modes;
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

	public int getSummonerLevel() {
		return summonerLevel;
	}

	public String getTooltip() {
		return tooltip;
	}

	public List<SpellVars> getVars() {
		return vars;
	}

	@Override
	public String toString() {
		return getId() + ": " + getName();
	}
}