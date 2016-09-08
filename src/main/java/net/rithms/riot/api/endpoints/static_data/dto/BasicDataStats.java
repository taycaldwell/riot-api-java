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
import com.google.gson.annotations.SerializedName;
import net.rithms.riot.api.Dto;

public class BasicDataStats extends Dto implements Serializable {

	private static final long serialVersionUID = -6907555892482131577L;
	
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

	public void setFlatArmorMod(double flatArmorMod) {
		this.flatArmorMod = flatArmorMod;
	}

	public void setFlatAttackSpeedMod(double flatAttackSpeedMod) {
		this.flatAttackSpeedMod = flatAttackSpeedMod;
	}

	public void setFlatBlockMod(double flatBlockMod) {
		this.flatBlockMod = flatBlockMod;
	}

	public void setFlatCritChanceMod(double flatCritChanceMod) {
		this.flatCritChanceMod = flatCritChanceMod;
	}

	public void setFlatCritDamageMod(double flatCritDamageMod) {
		this.flatCritDamageMod = flatCritDamageMod;
	}

	public void setFlatEXPBonus(double flatEXPBonus) {
		this.flatEXPBonus = flatEXPBonus;
	}

	public void setFlatEnergyPoolMod(double flatEnergyPoolMod) {
		this.flatEnergyPoolMod = flatEnergyPoolMod;
	}

	public void setFlatEnergyRegenMod(double flatEnergyRegenMod) {
		this.flatEnergyRegenMod = flatEnergyRegenMod;
	}

	public void setFlatHPPoolMod(double flatHPPoolMod) {
		this.flatHPPoolMod = flatHPPoolMod;
	}

	public void setFlatHPRegenMod(double flatHPRegenMod) {
		this.flatHPRegenMod = flatHPRegenMod;
	}

	public void setFlatMPPoolMod(double flatMPPoolMod) {
		this.flatMPPoolMod = flatMPPoolMod;
	}

	public void setFlatMPRegenMod(double flatMPRegenMod) {
		this.flatMPRegenMod = flatMPRegenMod;
	}

	public void setFlatMagicDamageMod(double flatMagicDamageMod) {
		this.flatMagicDamageMod = flatMagicDamageMod;
	}

	public void setFlatMovementSpeedMod(double flatMovementSpeedMod) {
		this.flatMovementSpeedMod = flatMovementSpeedMod;
	}

	public void setFlatPhysicalDamageMod(double flatPhysicalDamageMod) {
		this.flatPhysicalDamageMod = flatPhysicalDamageMod;
	}

	public void setFlatSpellBlockMod(double flatSpellBlockMod) {
		this.flatSpellBlockMod = flatSpellBlockMod;
	}

	public void setPercentArmorMod(double percentArmorMod) {
		this.percentArmorMod = percentArmorMod;
	}

	public void setPercentAttackSpeedMod(double percentAttackSpeedMod) {
		this.percentAttackSpeedMod = percentAttackSpeedMod;
	}

	public void setPercentBlockMod(double percentBlockMod) {
		this.percentBlockMod = percentBlockMod;
	}

	public void setPercentCritChanceMod(double percentCritChanceMod) {
		this.percentCritChanceMod = percentCritChanceMod;
	}

	public void setPercentCritDamageMod(double percentCritDamageMod) {
		this.percentCritDamageMod = percentCritDamageMod;
	}

	public void setPercentDodgeMod(double percentDodgeMod) {
		this.percentDodgeMod = percentDodgeMod;
	}

	public void setPercentEXPBonus(double percentEXPBonus) {
		this.percentEXPBonus = percentEXPBonus;
	}

	public void setPercentHPPoolMod(double percentHPPoolMod) {
		this.percentHPPoolMod = percentHPPoolMod;
	}

	public void setPercentHPRegenMod(double percentHPRegenMod) {
		this.percentHPRegenMod = percentHPRegenMod;
	}

	public void setPercentLifeStealMod(double percentLifeStealMod) {
		this.percentLifeStealMod = percentLifeStealMod;
	}

	public void setPercentMPPoolMod(double percentMPPoolMod) {
		this.percentMPPoolMod = percentMPPoolMod;
	}

	public void setPercentMPRegenMod(double percentMPRegenMod) {
		this.percentMPRegenMod = percentMPRegenMod;
	}

	public void setPercentMagicDamageMod(double percentMagicDamageMod) {
		this.percentMagicDamageMod = percentMagicDamageMod;
	}

	public void setPercentMovementSpeedMod(double percentMovementSpeedMod) {
		this.percentMovementSpeedMod = percentMovementSpeedMod;
	}

	public void setPercentPhysicalDamageMod(double percentPhysicalDamageMod) {
		this.percentPhysicalDamageMod = percentPhysicalDamageMod;
	}

	public void setPercentSpellBlockMod(double percentSpellBlockMod) {
		this.percentSpellBlockMod = percentSpellBlockMod;
	}

	public void setPercentSpellVampMod(double percentSpellVampMod) {
		this.percentSpellVampMod = percentSpellVampMod;
	}

	public void setrFlatArmorModPerLevel(double rFlatArmorModPerLevel) {
		this.rFlatArmorModPerLevel = rFlatArmorModPerLevel;
	}

	public void setrFlatArmorPenetrationMod(double rFlatArmorPenetrationMod) {
		this.rFlatArmorPenetrationMod = rFlatArmorPenetrationMod;
	}

	public void setrFlatArmorPenetrationModPerLevel(double rFlatArmorPenetrationModPerLevel) {
		this.rFlatArmorPenetrationModPerLevel = rFlatArmorPenetrationModPerLevel;
	}

	public void setrFlatCritChanceModPerLevel(double rFlatCritChanceModPerLevel) {
		this.rFlatCritChanceModPerLevel = rFlatCritChanceModPerLevel;
	}

	public void setrFlatCritDamageModPerLevel(double rFlatCritDamageModPerLevel) {
		this.rFlatCritDamageModPerLevel = rFlatCritDamageModPerLevel;
	}

	public void setrFlatDodgeMod(double rFlatDodgeMod) {
		this.rFlatDodgeMod = rFlatDodgeMod;
	}

	public void setrFlatDodgeModPerLevel(double rFlatDodgeModPerLevel) {
		this.rFlatDodgeModPerLevel = rFlatDodgeModPerLevel;
	}

	public void setrFlatEnergyModPerLevel(double rFlatEnergyModPerLevel) {
		this.rFlatEnergyModPerLevel = rFlatEnergyModPerLevel;
	}

	public void setrFlatEnergyRegenModPerLevel(double rFlatEnergyRegenModPerLevel) {
		this.rFlatEnergyRegenModPerLevel = rFlatEnergyRegenModPerLevel;
	}

	public void setrFlatGoldPer10Mod(double rFlatGoldPer10Mod) {
		this.rFlatGoldPer10Mod = rFlatGoldPer10Mod;
	}

	public void setrFlatHPModPerLevel(double rFlatHPModPerLevel) {
		this.rFlatHPModPerLevel = rFlatHPModPerLevel;
	}

	public void setrFlatHPRegenModPerLevel(double rFlatHPRegenModPerLevel) {
		this.rFlatHPRegenModPerLevel = rFlatHPRegenModPerLevel;
	}

	public void setrFlatMPModPerLevel(double rFlatMPModPerLevel) {
		this.rFlatMPModPerLevel = rFlatMPModPerLevel;
	}

	public void setrFlatMPRegenModPerLevel(double rFlatMPRegenModPerLevel) {
		this.rFlatMPRegenModPerLevel = rFlatMPRegenModPerLevel;
	}

	public void setrFlatMagicDamageModPerLevel(double rFlatMagicDamageModPerLevel) {
		this.rFlatMagicDamageModPerLevel = rFlatMagicDamageModPerLevel;
	}

	public void setrFlatMagicPenetrationMod(double rFlatMagicPenetrationMod) {
		this.rFlatMagicPenetrationMod = rFlatMagicPenetrationMod;
	}

	public void setrFlatMagicPenetrationModPerLevel(double rFlatMagicPenetrationModPerLevel) {
		this.rFlatMagicPenetrationModPerLevel = rFlatMagicPenetrationModPerLevel;
	}

	public void setrFlatMovementSpeedModPerLevel(double rFlatMovementSpeedModPerLevel) {
		this.rFlatMovementSpeedModPerLevel = rFlatMovementSpeedModPerLevel;
	}

	public void setrFlatPhysicalDamageModPerLevel(double rFlatPhysicalDamageModPerLevel) {
		this.rFlatPhysicalDamageModPerLevel = rFlatPhysicalDamageModPerLevel;
	}

	public void setrFlatSpellBlockModPerLevel(double rFlatSpellBlockModPerLevel) {
		this.rFlatSpellBlockModPerLevel = rFlatSpellBlockModPerLevel;
	}

	public void setrFlatTimeDeadMod(double rFlatTimeDeadMod) {
		this.rFlatTimeDeadMod = rFlatTimeDeadMod;
	}

	public void setrFlatTimeDeadModPerLevel(double rFlatTimeDeadModPerLevel) {
		this.rFlatTimeDeadModPerLevel = rFlatTimeDeadModPerLevel;
	}

	public void setrPercentArmorPenetrationMod(double rPercentArmorPenetrationMod) {
		this.rPercentArmorPenetrationMod = rPercentArmorPenetrationMod;
	}

	public void setrPercentArmorPenetrationModPerLevel(double rPercentArmorPenetrationModPerLevel) {
		this.rPercentArmorPenetrationModPerLevel = rPercentArmorPenetrationModPerLevel;
	}

	public void setrPercentAttackSpeedModPerLevel(double rPercentAttackSpeedModPerLevel) {
		this.rPercentAttackSpeedModPerLevel = rPercentAttackSpeedModPerLevel;
	}

	public void setrPercentCooldownMod(double rPercentCooldownMod) {
		this.rPercentCooldownMod = rPercentCooldownMod;
	}

	public void setrPercentCooldownModPerLevel(double rPercentCooldownModPerLevel) {
		this.rPercentCooldownModPerLevel = rPercentCooldownModPerLevel;
	}

	public void setrPercentMagicPenetrationMod(double rPercentMagicPenetrationMod) {
		this.rPercentMagicPenetrationMod = rPercentMagicPenetrationMod;
	}

	public void setrPercentMagicPenetrationModPerLevel(double rPercentMagicPenetrationModPerLevel) {
		this.rPercentMagicPenetrationModPerLevel = rPercentMagicPenetrationModPerLevel;
	}

	public void setrPercentMovementSpeedModPerLevel(double rPercentMovementSpeedModPerLevel) {
		this.rPercentMovementSpeedModPerLevel = rPercentMovementSpeedModPerLevel;
	}

	public void setrPercentTimeDeadMod(double rPercentTimeDeadMod) {
		this.rPercentTimeDeadMod = rPercentTimeDeadMod;
	}

	public void setrPercentTimeDeadModPerLevel(double rPercentTimeDeadModPerLevel) {
		this.rPercentTimeDeadModPerLevel = rPercentTimeDeadModPerLevel;
	}
	
	
}