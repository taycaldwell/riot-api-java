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

/**
 * This object contains stats for runes.
 */
public class RuneStats extends Dto implements Serializable {

	private static final long serialVersionUID = 8756197541522296210L;

	@SerializedName(value = "FlatArmorMod")
	private double flatArmorMod;
	@SerializedName(value = "FlatArmorModPerLevel")
	private double flatArmorModPerLevel;
	@SerializedName(value = "FlatArmorPenetrationMod")
	private double flatArmorPenetrationMod;
	@SerializedName(value = "FlatArmorPenetrationModPerLevel")
	private double flatArmorPenetrationModPerLevel;
	@SerializedName(value = "FlatAttackSpeedMod")
	private double flatAttackSpeedMod;
	@SerializedName(value = "FlatBlockMod")
	private double flatBlockMod;
	@SerializedName(value = "FlatCritChanceMod")
	private double flatCritChanceMod;
	@SerializedName(value = "FlatCritChanceModPerLevel")
	private double flatCritChanceModPerLevel;
	@SerializedName(value = "FlatCritDamageMod")
	private double flatCritDamageMod;
	@SerializedName(value = "FlatCritDamageModPerLevel")
	private double flatCritDamageModPerLevel;
	@SerializedName(value = "FlatDodgeMod")
	private double flatDodgeMod;
	@SerializedName(value = "FlatDodgeModPerLevel")
	private double flatDodgeModPerLevel;
	@SerializedName(value = "FlatEnergyModPerLevel")
	private double flatEnergyModPerLevel;
	@SerializedName(value = "FlatEnergyRegenModPerLevel")
	private double flatEnergyRegenModPerLevel;
	@SerializedName(value = "FlatEXPBonus")
	private double flatEXPBonus;
	@SerializedName(value = "FlatEnergyPoolMod")
	private double flatEnergyPoolMod;
	@SerializedName(value = "FlatEnergyRegenMod")
	private double flatEnergyRegenMod;
	@SerializedName(value = "FlatGoldPer10Mod")
	private double flatGoldPer10Mod;
	@SerializedName(value = "FlatHPModPerLevel")
	private double flatHPModPerLevel;
	@SerializedName(value = "FlatHPPoolMod")
	private double flatHPPoolMod;
	@SerializedName(value = "FlatHPRegenMod")
	private double flatHPRegenMod;
	@SerializedName(value = "FlatHPRegenModPerLevel")
	private double flatHPRegenModPerLevel;
	@SerializedName(value = "FlatMPModPerLevel")
	private double flatMPModPerLevel;
	@SerializedName(value = "FlatMPPoolMod")
	private double flatMPPoolMod;
	@SerializedName(value = "FlatMPRegenMod")
	private double flatMPRegenMod;
	@SerializedName(value = "FlatMPRegenModPerLevel")
	private double flatMPRegenModPerLevel;
	@SerializedName(value = "FlatMagicDamageMod")
	private double flatMagicDamageMod;
	@SerializedName(value = "FlatMagicDamageModPerLevel")
	private double flatMagicDamageModPerLevel;
	@SerializedName(value = "FlatMagicPenetrationMod")
	private double flatMagicPenetrationMod;
	@SerializedName(value = "FlatMagicPenetrationModPerLevel")
	private double flatMagicPenetrationModPerLevel;
	@SerializedName(value = "FlatMovementSpeedMod")
	private double flatMovementSpeedMod;
	@SerializedName(value = "FlatMovementSpeedModPerLevel")
	private double flatMovementSpeedModPerLevel;
	@SerializedName(value = "FlatPhysicalDamageMod")
	private double flatPhysicalDamageMod;
	@SerializedName(value = "FlatPhysicalDamageModPerLevel")
	private double flatPhysicalDamageModPerLevel;
	@SerializedName(value = "FlatSpellBlockMod")
	private double flatSpellBlockMod;
	@SerializedName(value = "FlatSpellBlockModPerLevel")
	private double flatSpellBlockModPerLevel;
	@SerializedName(value = "FlatTimeDeadMod")
	private double flatTimeDeadMod;
	@SerializedName(value = "FlatTimeDeadModPerLevel")
	private double flatTimeDeadModPerLevel;
	@SerializedName(value = "PercentArmorMod")
	private double percentArmorMod;
	@SerializedName(value = "PercentArmorPenetrationMod")
	private double percentArmorPenetrationMod;
	@SerializedName(value = "PercentArmorPenetrationModPerLevel")
	private double percentArmorPenetrationModPerLevel;
	@SerializedName(value = "PercentAttackSpeedMod")
	private double percentAttackSpeedMod;
	@SerializedName(value = "PercentAttackSpeedModPerLevel")
	private double percentAttackSpeedModPerLevel;
	@SerializedName(value = "PercentBlockMod")
	private double percentBlockMod;
	@SerializedName(value = "PercentCooldownMod")
	private double percentCooldownMod;
	@SerializedName(value = "PercentCooldownModPerLevel")
	private double percentCooldownModPerLevel;
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
	@SerializedName(value = "PercentMagicPenetrationMod")
	private double percentMagicPenetrationMod;
	@SerializedName(value = "PercentMagicPenetrationModPerLevel")
	private double percentMagicPenetrationModPerLevel;
	@SerializedName(value = "PercentMovementSpeedModPerLevel")
	private double percentMovementSpeedModPerLevel;
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
	@SerializedName(value = "PercentTimeDeadMod")
	private double percentTimeDeadMod;
	@SerializedName(value = "PercentTimeDeadModPerLevel")
	private double percentTimeDeadModPerLevel;

	public double getFlatArmorMod() {
		return flatArmorMod;
	}

	public double getFlatArmorModPerLevel() {
		return flatArmorModPerLevel;
	}

	public double getFlatArmorPenetrationMod() {
		return flatArmorPenetrationMod;
	}

	public double getFlatArmorPenetrationModPerLevel() {
		return flatArmorPenetrationModPerLevel;
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

	public double getFlatCritChanceModPerLevel() {
		return flatCritChanceModPerLevel;
	}

	public double getFlatCritDamageMod() {
		return flatCritDamageMod;
	}

	public double getFlatCritDamageModPerLevel() {
		return flatCritDamageModPerLevel;
	}

	public double getFlatDodgeMod() {
		return flatDodgeMod;
	}

	public double getFlatDodgeModPerLevel() {
		return flatDodgeModPerLevel;
	}

	public double getFlatEXPBonus() {
		return flatEXPBonus;
	}

	public double getFlatEnergyModPerLevel() {
		return flatEnergyModPerLevel;
	}

	public double getFlatEnergyPoolMod() {
		return flatEnergyPoolMod;
	}

	public double getFlatEnergyRegenMod() {
		return flatEnergyRegenMod;
	}

	public double getFlatEnergyRegenModPerLevel() {
		return flatEnergyRegenModPerLevel;
	}

	public double getFlatGoldPer10Mod() {
		return flatGoldPer10Mod;
	}

	public double getFlatHPModPerLevel() {
		return flatHPModPerLevel;
	}

	public double getFlatHPPoolMod() {
		return flatHPPoolMod;
	}

	public double getFlatHPRegenMod() {
		return flatHPRegenMod;
	}

	public double getFlatHPRegenModPerLevel() {
		return flatHPRegenModPerLevel;
	}

	public double getFlatMagicDamageMod() {
		return flatMagicDamageMod;
	}

	public double getFlatMagicDamageModPerLevel() {
		return flatMagicDamageModPerLevel;
	}

	public double getFlatMagicPenetrationMod() {
		return flatMagicPenetrationMod;
	}

	public double getFlatMagicPenetrationModPerLevel() {
		return flatMagicPenetrationModPerLevel;
	}

	public double getFlatMovementSpeedMod() {
		return flatMovementSpeedMod;
	}

	public double getFlatMovementSpeedModPerLevel() {
		return flatMovementSpeedModPerLevel;
	}

	public double getFlatMPModPerLevel() {
		return flatMPModPerLevel;
	}

	public double getFlatMPPoolMod() {
		return flatMPPoolMod;
	}

	public double getFlatMPRegenMod() {
		return flatMPRegenMod;
	}

	public double getFlatMPRegenModPerLevel() {
		return flatMPRegenModPerLevel;
	}

	public double getFlatPhysicalDamageMod() {
		return flatPhysicalDamageMod;
	}

	public double getFlatPhysicalDamageModPerLevel() {
		return flatPhysicalDamageModPerLevel;
	}

	public double getFlatSpellBlockMod() {
		return flatSpellBlockMod;
	}

	public double getFlatSpellBlockModPerLevel() {
		return flatSpellBlockModPerLevel;
	}

	public double getFlatTimeDeadMod() {
		return flatTimeDeadMod;
	}

	public double getFlatTimeDeadModPerLevel() {
		return flatTimeDeadModPerLevel;
	}

	public double getPercentArmorMod() {
		return percentArmorMod;
	}

	public double getPercentArmorPenetrationMod() {
		return percentArmorPenetrationMod;
	}

	public double getPercentArmorPenetrationModPerLevel() {
		return percentArmorPenetrationModPerLevel;
	}

	public double getPercentAttackSpeedMod() {
		return percentAttackSpeedMod;
	}

	public double getPercentAttackSpeedModPerLevel() {
		return percentAttackSpeedModPerLevel;
	}

	public double getPercentBlockMod() {
		return percentBlockMod;
	}

	public double getPercentCooldownMod() {
		return percentCooldownMod;
	}

	public double getPercentCooldownModPerLevel() {
		return percentCooldownModPerLevel;
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

	public double getPercentMagicPenetrationMod() {
		return percentMagicPenetrationMod;
	}

	public double getPercentMagicPenetrationModPerLevel() {
		return percentMagicPenetrationModPerLevel;
	}

	public double getPercentMovementSpeedMod() {
		return percentMovementSpeedMod;
	}

	public double getPercentMovementSpeedModPerLevel() {
		return percentMovementSpeedModPerLevel;
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

	public double getPercentTimeDeadMod() {
		return percentTimeDeadMod;
	}

	public double getPercentTimeDeadModPerLevel() {
		return percentTimeDeadModPerLevel;
	}
}