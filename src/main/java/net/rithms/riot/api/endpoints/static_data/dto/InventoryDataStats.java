/*
 * Copyright 2017 Taylor Caldwell
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

import com.google.gson.annotations.SerializedName;

import net.rithms.riot.api.Dto;

public class InventoryDataStats extends Dto implements Serializable {

	private static final long serialVersionUID = 6417194857864439349L;

	@SerializedName(value = "FlatArmorMod")
	private double flatArmorMod;
	@SerializedName(value = "FlatAttackSpeedMod")
	private double flatAttackSpeedMod;
	@SerializedName(value = "FlatBlockMod")
	private double flatBlockMod;
	@SerializedName(value = "FlatCritChanceMod")
	private double flatCritChanceMod;
	@SerializedName(value = "FlatCritDamageMod")
	private double flatCritDamageMod;
	@SerializedName(value = "FlatEXPBonus")
	private double flatEXPBonus;
	@SerializedName(value = "FlatEnergyPoolMod")
	private double flatEnergyPoolMod;
	@SerializedName(value = "FlatEnergyRegenMod")
	private double flatEnergyRegenMod;
	@SerializedName(value = "FlatHPPoolMod")
	private double flatHPPoolMod;
	@SerializedName(value = "FlatHPRegenMod")
	private double flatHPRegenMod;
	@SerializedName(value = "FlatMPPoolMod")
	private double flatMPPoolMod;
	@SerializedName(value = "FlatMPRegenMod")
	private double flatMPRegenMod;
	@SerializedName(value = "FlatMagicDamageMod")
	private double flatMagicDamageMod;
	@SerializedName(value = "FlatMovementSpeedMod")
	private double flatMovementSpeedMod;
	@SerializedName(value = "FlatPhysicalDamageMod")
	private double flatPhysicalDamageMod;
	@SerializedName(value = "FlatSpellBlockMod")
	private double flatSpellBlockMod;
	@SerializedName(value = "PercentArmorMod")
	private double percentArmorMod;
	@SerializedName(value = "PercentAttackSpeedMod")
	private double percentAttackSpeedMod;
	@SerializedName(value = "PercentBlockMod")
	private double percentBlockMod;
	@SerializedName(value = "PercentCritChanceMod")
	private double percentCritChanceMod;
	@SerializedName(value = "PercentCritDamageMod")
	private double percentCritDamageMod;
	@SerializedName(value = "PercentDodgeMod")
	private double percentDodgeMod;
	@SerializedName(value = "PercentEXPBonus")
	private double percentEXPBonus;
	@SerializedName(value = "PercentHPPoolMod")
	private double percentHPPoolMod;
	@SerializedName(value = "PercentHPRegenMod")
	private double percentHPRegenMod;
	@SerializedName(value = "PercentLifeStealMod")
	private double percentLifeStealMod;
	@SerializedName(value = "PercentMPPoolMod")
	private double percentMPPoolMod;
	@SerializedName(value = "PercentMPRegenMod")
	private double percentMPRegenMod;
	@SerializedName(value = "PercentMagicDamageMod")
	private double percentMagicDamageMod;
	@SerializedName(value = "PercentMovementSpeedMod")
	private double percentMovementSpeedMod;
	@SerializedName(value = "PercentPhysicalDamageMod")
	private double percentPhysicalDamageMod;
	@SerializedName(value = "PercentSpellBlockMod")
	private double percentSpellBlockMod;
	@SerializedName(value = "PercentSpellVampMod")
	private double percentSpellVampMod;

	public double getFlatArmorMod() {
		return flatArmorMod;
	}

	public double getFlatAttackSpeedMod() {
		return flatAttackSpeedMod;
	}

	public double getFlatBlockMod() {
		return flatBlockMod;
	}

	public double getFlatCritChanceMod() {
		return flatCritChanceMod;
	}

	public double getFlatCritDamageMod() {
		return flatCritDamageMod;
	}

	public double getFlatEXPBonus() {
		return flatEXPBonus;
	}

	public double getFlatEnergyPoolMod() {
		return flatEnergyPoolMod;
	}

	public double getFlatEnergyRegenMod() {
		return flatEnergyRegenMod;
	}

	public double getFlatHPPoolMod() {
		return flatHPPoolMod;
	}

	public double getFlatHPRegenMod() {
		return flatHPRegenMod;
	}

	public double getFlatMPPoolMod() {
		return flatMPPoolMod;
	}

	public double getFlatMPRegenMod() {
		return flatMPRegenMod;
	}

	public double getFlatMagicDamageMod() {
		return flatMagicDamageMod;
	}

	public double getFlatMovementSpeedMod() {
		return flatMovementSpeedMod;
	}

	public double getFlatPhysicalDamageMod() {
		return flatPhysicalDamageMod;
	}

	public double getFlatSpellBlockMod() {
		return flatSpellBlockMod;
	}

	public double getPercentArmorMod() {
		return percentArmorMod;
	}

	public double getPercentAttackSpeedMod() {
		return percentAttackSpeedMod;
	}

	public double getPercentBlockMod() {
		return percentBlockMod;
	}

	public double getPercentCritChanceMod() {
		return percentCritChanceMod;
	}

	public double getPercentCritDamageMod() {
		return percentCritDamageMod;
	}

	public double getPercentDodgeMod() {
		return percentDodgeMod;
	}

	public double getPercentEXPBonus() {
		return percentEXPBonus;
	}

	public double getPercentHPPoolMod() {
		return percentHPPoolMod;
	}

	public double getPercentHPRegenMod() {
		return percentHPRegenMod;
	}

	public double getPercentLifeStealMod() {
		return percentLifeStealMod;
	}

	public double getPercentMPPoolMod() {
		return percentMPPoolMod;
	}

	public double getPercentMPRegenMod() {
		return percentMPRegenMod;
	}

	public double getPercentMagicDamageMod() {
		return percentMagicDamageMod;
	}

	public double getPercentMovementSpeedMod() {
		return percentMovementSpeedMod;
	}

	public double getPercentPhysicalDamageMod() {
		return percentPhysicalDamageMod;
	}

	public double getPercentSpellBlockMod() {
		return percentSpellBlockMod;
	}

	public double getPercentSpellVampMod() {
		return percentSpellVampMod;
	}
}