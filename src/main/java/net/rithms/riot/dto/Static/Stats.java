package net.rithms.riot.dto.Static;

import java.io.Serializable;

/*
 * Copyright 2015 Taylor Caldwell
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

public class Stats implements Serializable {

	private static final long serialVersionUID = 7631639894093703038L;
	private double armor, armorperlevel, attackdamage, attackdamageperlevel, attackrange, attackspeedoffset, attackspeedperlevel, crit, critperlevel, hp,
			hpperlevel, hpregen, hpregenperlevel, movespeed, mp, mpperlevel, mpregen, mpregenperlevel, spellblock, spellblockperlevel;

	public double getBaseAttackSpeed() {
		return (0.625 / (1.0 + attackspeedoffset));
	}

	public double getArmor() {
		return armor;
	}

	public double getArmorPerLevel() {
		return armorperlevel;
	}

	public double getAttackDamage() {
		return attackdamage;
	}

	public double getAttackDamagePerLevel() {
		return attackdamageperlevel;
	}

	public double getAttackRange() {
		return attackrange;
	}

	public double getAttackSpeedOffset() {
		return attackspeedoffset;
	}

	public double getAttackSpeedPerLevel() {
		return attackspeedperlevel;
	}

	public double getCrit() {
		return crit;
	}

	public double getCritPerLevel() {
		return critperlevel;
	}

	public double getHp() {
		return hp;
	}

	public double getHpPerLevel() {
		return hpperlevel;
	}

	public double getHpRegen() {
		return hpregen;
	}

	public double getHpRegenPerLevel() {
		return hpregenperlevel;
	}

	public double getMoveSpeed() {
		return movespeed;
	}

	public double getMp() {
		return mp;
	}

	public double getMpPerLevel() {
		return mpperlevel;
	}

	public double getMpRegen() {
		return mpregen;
	}

	public double getMpRegenPerLevel() {
		return mpregenperlevel;
	}

	public double getSpellBlock() {
		return spellblock;
	}

	public double getSpellBlockPerLevel() {
		return spellblockperlevel;
	}
}