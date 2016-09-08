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

	public void setAltimages(List<Image> altimages) {
		this.altimages = altimages;
	}

	public void setCooldown(List<Double> cooldown) {
		this.cooldown = cooldown;
	}

	public void setCooldownBurn(String cooldownBurn) {
		this.cooldownBurn = cooldownBurn;
	}

	public void setCost(List<Integer> cost) {
		this.cost = cost;
	}

	public void setCostBurn(String costBurn) {
		this.costBurn = costBurn;
	}

	public void setCostType(String costType) {
		this.costType = costType;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setEffect(List<Object> effect) {
		this.effect = effect;
	}

	public void setEffectBurn(List<String> effectBurn) {
		this.effectBurn = effectBurn;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setLeveltip(LevelTip leveltip) {
		this.leveltip = leveltip;
	}

	public void setMaxrank(int maxrank) {
		this.maxrank = maxrank;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRange(Object range) {
		this.range = range;
	}

	public void setRangeBurn(String rangeBurn) {
		this.rangeBurn = rangeBurn;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public void setSanitizedDescription(String sanitizedDescription) {
		this.sanitizedDescription = sanitizedDescription;
	}

	public void setSanitizedTooltip(String sanitizedTooltip) {
		this.sanitizedTooltip = sanitizedTooltip;
	}

	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}

	public void setVars(List<SpellVars> vars) {
		this.vars = vars;
	}

	@Override
	public String toString() {
		return getName();
	}
}
