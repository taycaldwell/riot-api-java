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

public class BasicDataStats implements Serializable {

	private static final long serialVersionUID = -6907555892482131577L;

	private double FlatArmorMod;
	private double FlatAttackSpeedMod;
	private double FlatBlockMod;
	private double FlatCritChanceMod;
	private double FlatCritDamageMod;
	private double FlatEXPBonus;
	private double FlatEnergyPoolMod;
	private double FlatEnergyRegenMod;
	private double FlatHPPoolMod;
	private double FlatHPRegenMod;
	private double FlatMPPoolMod;
	private double FlatMPRegenMod;
	private double FlatMagicDamageMod;
	private double FlatMovementSpeedMod;
	private double FlatPhysicalDamageMod;
	private double FlatSpellBlockMod;
	private double PercentArmorMod;
	private double PercentAttackSpeedMod;
	private double PercentBlockMod;
	private double PercentCritChanceMod;
	private double PercentCritDamageMod;
	private double PercentDodgeMod;
	private double PercentEXPBonus;
	private double PercentHPPoolMod;
	private double PercentHPRegenMod;
	private double PercentLifeStealMod;
	private double PercentMPPoolMod;
	private double PercentMPRegenMod;
	private double PercentMagicDamageMod;
	private double PercentMovementSpeedMod;
	private double PercentPhysicalDamageMod;
	private double PercentSpellBlockMod;
	private double PercentSpellVampMod;
	private double rFlatArmorModPerLevel;
	private double rFlatArmorPenetrationMod;
	private double rFlatArmorPenetrationModPerLevel;
	private double rFlatCritChanceModPerLevel;
	private double rFlatCritDamageModPerLevel;
	private double rFlatDodgeMod;
	private double rFlatDodgeModPerLevel;
	private double rFlatEnergyModPerLevel;
	private double rFlatEnergyRegenModPerLevel;
	private double rFlatGoldPer10Mod;
	private double rFlatHPModPerLevel;
	private double rFlatHPRegenModPerLevel;
	private double rFlatMPModPerLevel;
	private double rFlatMPRegenModPerLevel;
	private double rFlatMagicDamageModPerLevel;
	private double rFlatMagicPenetrationMod;
	private double rFlatMagicPenetrationModPerLevel;
	private double rFlatMovementSpeedModPerLevel;
	private double rFlatPhysicalDamageModPerLevel;
	private double rFlatSpellBlockModPerLevel;
	private double rFlatTimeDeadMod;
	private double rFlatTimeDeadModPerLevel;
	private double rPercentArmorPenetrationMod;
	private double rPercentArmorPenetrationModPerLevel;
	private double rPercentAttackSpeedModPerLevel;
	private double rPercentCooldownMod;
	private double rPercentCooldownModPerLevel;
	private double rPercentMagicPenetrationMod;
	private double rPercentMagicPenetrationModPerLevel;
	private double rPercentMovementSpeedModPerLevel;
	private double rPercentTimeDeadMod;
	private double rPercentTimeDeadModPerLevel;

	public double getFlatArmorMod() {
		return FlatArmorMod;
	}

	public double getFlatAttackSpeedMod() {
		return FlatAttackSpeedMod;
	}

	public double getFlatBlockMod() {
		return FlatBlockMod;
	}

	public double getFlatCritChanceMod() {
		return FlatCritChanceMod;
	}

	public double getFlatCritDamageMod() {
		return FlatCritDamageMod;
	}

	public double getFlatEXPBonus() {
		return FlatEXPBonus;
	}

	public double getFlatEnergyPoolMod() {
		return FlatEnergyPoolMod;
	}

	public double getFlatEnergyRegenMod() {
		return FlatEnergyRegenMod;
	}

	public double getFlatHPPoolMod() {
		return FlatHPPoolMod;
	}

	public double getFlatHPRegenMod() {
		return FlatHPRegenMod;
	}

	public double getFlatMPPoolMod() {
		return FlatMPPoolMod;
	}

	public double getFlatMPRegenMod() {
		return FlatMPRegenMod;
	}

	public double getFlatMagicDamageMod() {
		return FlatMagicDamageMod;
	}

	public double getFlatMovementSpeedMod() {
		return FlatMovementSpeedMod;
	}

	public double getFlatPhysicalDamageMod() {
		return FlatPhysicalDamageMod;
	}

	public double getFlatSpellBlockMod() {
		return FlatSpellBlockMod;
	}

	public double getPercentArmorMod() {
		return PercentArmorMod;
	}

	public double getPercentAttackSpeedMod() {
		return PercentAttackSpeedMod;
	}

	public double getPercentBlockMod() {
		return PercentBlockMod;
	}

	public double getPercentCritChanceMod() {
		return PercentCritChanceMod;
	}

	public double getPercentCritDamageMod() {
		return PercentCritDamageMod;
	}

	public double getPercentDodgeMod() {
		return PercentDodgeMod;
	}

	public double getPercentEXPBonus() {
		return PercentEXPBonus;
	}

	public double getPercentHPPoolMod() {
		return PercentHPPoolMod;
	}

	public double getPercentHPRegenMod() {
		return PercentHPRegenMod;
	}

	public double getPercentLifeStealMod() {
		return PercentLifeStealMod;
	}

	public double getPercentMPPoolMod() {
		return PercentMPPoolMod;
	}

	public double getPercentMPRegenMod() {
		return PercentMPRegenMod;
	}

	public double getPercentMagicDamageMod() {
		return PercentMagicDamageMod;
	}

	public double getPercentMovementSpeedMod() {
		return PercentMovementSpeedMod;
	}

	public double getPercentPhysicalDamageMod() {
		return PercentPhysicalDamageMod;
	}

	public double getPercentSpellBlockMod() {
		return PercentSpellBlockMod;
	}

	public double getPercentSpellVampMod() {
		return PercentSpellVampMod;
	}

	public double getrFlatArmorModPerLevel() {
		return rFlatArmorModPerLevel;
	}

	public double getrFlatArmorPenetrationMod() {
		return rFlatArmorPenetrationMod;
	}

	public double getrFlatArmorPenetrationModPerLevel() {
		return rFlatArmorPenetrationModPerLevel;
	}

	public double getrFlatCritChanceModPerLevel() {
		return rFlatCritChanceModPerLevel;
	}

	public double getrFlatCritDamageModPerLevel() {
		return rFlatCritDamageModPerLevel;
	}

	public double getrFlatDodgeMod() {
		return rFlatDodgeMod;
	}

	public double getrFlatDodgeModPerLevel() {
		return rFlatDodgeModPerLevel;
	}

	public double getrFlatEnergyModPerLevel() {
		return rFlatEnergyModPerLevel;
	}

	public double getrFlatEnergyRegenModPerLevel() {
		return rFlatEnergyRegenModPerLevel;
	}

	public double getrFlatGoldPer10Mod() {
		return rFlatGoldPer10Mod;
	}

	public double getrFlatHPModPerLevel() {
		return rFlatHPModPerLevel;
	}

	public double getrFlatHPRegenModPerLevel() {
		return rFlatHPRegenModPerLevel;
	}

	public double getrFlatMPModPerLevel() {
		return rFlatMPModPerLevel;
	}

	public double getrFlatMPRegenModPerLevel() {
		return rFlatMPRegenModPerLevel;
	}

	public double getrFlatMagicDamageModPerLevel() {
		return rFlatMagicDamageModPerLevel;
	}

	public double getrFlatMagicPenetrationMod() {
		return rFlatMagicPenetrationMod;
	}

	public double getrFlatMagicPenetrationModPerLevel() {
		return rFlatMagicPenetrationModPerLevel;
	}

	public double getrFlatMovementSpeedModPerLevel() {
		return rFlatMovementSpeedModPerLevel;
	}

	public double getrFlatPhysicalDamageModPerLevel() {
		return rFlatPhysicalDamageModPerLevel;
	}

	public double getrFlatSpellBlockModPerLevel() {
		return rFlatSpellBlockModPerLevel;
	}

	public double getrFlatTimeDeadMod() {
		return rFlatTimeDeadMod;
	}

	public double getrFlatTimeDeadModPerLevel() {
		return rFlatTimeDeadModPerLevel;
	}

	public double getrPercentArmorPenetrationMod() {
		return rPercentArmorPenetrationMod;
	}

	public double getrPercentArmorPenetrationModPerLevel() {
		return rPercentArmorPenetrationModPerLevel;
	}

	public double getrPercentAttackSpeedModPerLevel() {
		return rPercentAttackSpeedModPerLevel;
	}

	public double getrPercentCooldownMod() {
		return rPercentCooldownMod;
	}

	public double getrPercentCooldownModPerLevel() {
		return rPercentCooldownModPerLevel;
	}

	public double getrPercentMagicPenetrationMod() {
		return rPercentMagicPenetrationMod;
	}

	public double getrPercentMagicPenetrationModPerLevel() {
		return rPercentMagicPenetrationModPerLevel;
	}

	public double getrPercentMovementSpeedModPerLevel() {
		return rPercentMovementSpeedModPerLevel;
	}

	public double getrPercentTimeDeadMod() {
		return rPercentTimeDeadMod;
	}

	public double getrPercentTimeDeadModPerLevel() {
		return rPercentTimeDeadModPerLevel;
	}
}