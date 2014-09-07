package dto.Static;

import java.util.List;

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

public class Champion {
	
	private List<String> allytips;
	private List<String> enemytips;
	private List<Recommended> recommended;
	private List<Skin> skins;
	private List<ChampionSpell> spells;
	private List<String> tags;
	private Image image;
	private Info info;
	private Passive passive;
	private Stats stats;
	private int id;
	private String blurb, key, lore, name, partype, title;
	
	public List<String> getAllytips() {
		return allytips;
	}
	public List<String> getEnemytips() {
		return enemytips;
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
	public List<String> getTags() {
		return tags;
	}
	public Image getImage() {
		return image;
	}
	public Info getInfo() {
		return info;
	}
	public Passive getPassive() {
		return passive;
	}
	public Stats getStats() {
		return stats;
	}
	public int getId() {
		return id;
	}
	public String getBlurb() {
		return blurb;
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
	public String getTitle() {
		return title;
	}
	
}
