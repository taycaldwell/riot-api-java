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

public class Champion extends Dto implements Serializable {

	private static final long serialVersionUID = 8120597968700936522L;

	private List<String> allytips;
	private String blurb;
	private List<String> enemytips;
	private int id;
	private Image image;
	private Info info;
	private String key;
	private String lore;
	private String name;
	private String partype;
	private Passive passive;
	private List<Recommended> recommended;
	private List<Skin> skins;
	private List<ChampionSpell> spells;
	private Stats stats;
	private List<String> tags;
	private String title;

	public List<String> getAllytips() {
		return allytips;
	}

	public String getBlurb() {
		return blurb;
	}

	public List<String> getEnemytips() {
		return enemytips;
	}

	public int getId() {
		return id;
	}

	public Image getImage() {
		return image;
	}

	public Info getInfo() {
		return info;
	}

	public String getKey() {
		return key;
	}

	public String getLore() {
		return lore;
	}

	public String getName() {
		return name;
	}

	public String getPartype() {
		return partype;
	}

	public Passive getPassive() {
		return passive;
	}

	public List<Recommended> getRecommended() {
		return recommended;
	}

	public List<Skin> getSkins() {
		return skins;
	}

	public List<ChampionSpell> getSpells() {
		return spells;
	}

	public Stats getStats() {
		return stats;
	}

	public List<String> getTags() {
		return tags;
	}

	public String getTitle() {
		return title;
	}
	
	public void setAllytips(List<String> allytips) {
		this.allytips = allytips;
	}

	public void setBlurb(String blurb) {
		this.blurb = blurb;
	}

	public void setEnemytips(List<String> enemytips) {
		this.enemytips = enemytips;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setLore(String lore) {
		this.lore = lore;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPartype(String partype) {
		this.partype = partype;
	}

	public void setPassive(Passive passive) {
		this.passive = passive;
	}

	public void setRecommended(List<Recommended> recommended) {
		this.recommended = recommended;
	}

	public void setSkins(List<Skin> skins) {
		this.skins = skins;
	}

	public void setSpells(List<ChampionSpell> spells) {
		this.spells = spells;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return getId() + ": " + getName();
	}
}