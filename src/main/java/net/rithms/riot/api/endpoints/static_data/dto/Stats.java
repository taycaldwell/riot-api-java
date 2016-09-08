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

package net.rithms.riot.api.endpoints.static_data.dto;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import net.rithms.riot.api.Dto;

public class Stats extends Dto implements Serializable {

	private static final long serialVersionUID = 7631639894093703038L;

	private double armor;
	@SerializedName(value = "armorperlevel")
	private double armorPerLevel;
	@SerializedName(value = "attackdamage")
	private double attackDamage;
	@SerializedName(value = "attackdamageperlevel")
	private double attackDamagePerLevel;
	@SerializedName(value = "attackrange")
	private double attackRange;
	private double attackSpeedOffset;
	@SerializedName(value = "attackspeedperlevel")
	private double attackSpeedPerLevel;
	@SerializedName(value = "baseattackspeed")
	private double baseAttackSpeed;
	private double crit;
	@SerializedName(value = "critperlevel")
	private double critPerLevel;
	private double hp;
	@SerializedName(value = "hpperlevel")
	private double hpPerLevel;
	@SerializedName(value = "hpregen")
	private double hpRegen;
	@SerializedName(value = "hpregenperlevel")
	private double hpRegenPerLevel;
	@SerializedName(value = "movespeed")
	private double moveSpeed;
	private double mp;
	@SerializedName(value = "mpperlevel")
	private double mpPerLevel;
	@SerializedName(value = "mpregen")
	private double mpregen;
	@SerializedName(value = "mpregenperlevel")
	private double mpRegenPerLevel;
	@SerializedName(value = "spellblock")
	private double spellBlock;
	@SerializedName(value = "spellblockperlevel")
	private double spellBlockPerLevel;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public double getArmor() {
		return armor;
	}

	public double getArmorPerLevel() {
		return armorPerLevel;
	}

	public double getAttackDamage() {
		return attackDamage;
	}

	public double getAttackDamagePerLevel() {
		return attackDamagePerLevel;
	}

	public double getAttackRange() {
		return attackRange;
	}

	public double getAttackSpeedOffset() {
		return attackSpeedOffset;
	}

	public double getAttackSpeedPerLevel() {
		return attackSpeedPerLevel;
	}

	public double getBaseAttackSpeed() {
		return (0.625 / (1.0 + attackSpeedOffset));
	}
	
	public double getCrit() {
		return crit;
	}

	public double getCritPerLevel() {
		return critPerLevel;
	}

	public double getHp() {
		return hp;
	}

	public double getHpPerLevel() {
		return hpPerLevel;
	}

	public double getHpRegen() {
		return hpRegen;
	}

	public double getHpRegenPerLevel() {
		return hpRegenPerLevel;
	}

	public double getMoveSpeed() {
		return moveSpeed;
	}

	public double getMp() {
		return mp;
	}

	public double getMpPerLevel() {
		return mpPerLevel;
	}

	public double getMpregen() {
		return mpregen;
	}

	public double getMpRegenPerLevel() {
		return mpRegenPerLevel;
	}

	public double getSpellBlock() {
		return spellBlock;
	}

	public double getSpellBlockPerLevel() {
		return spellBlockPerLevel;
	}

	public void setArmor(double armor) {
		this.armor = armor;
	}

	public void setArmorPerLevel(double armorPerLevel) {
		this.armorPerLevel = armorPerLevel;
	}

	public void setAttackDamage(double attackDamage) {
		this.attackDamage = attackDamage;
	}

	public void setAttackDamagePerLevel(double attackDamagePerLevel) {
		this.attackDamagePerLevel = attackDamagePerLevel;
	}

	public void setAttackRange(double attackRange) {
		this.attackRange = attackRange;
	}

	public void setAttackSpeedOffset(double attackSpeedOffset) {
		this.attackSpeedOffset = attackSpeedOffset;
	}

	public void setAttackSpeedPerLevel(double attackSpeedPerLevel) {
		this.attackSpeedPerLevel = attackSpeedPerLevel;
	}

	public void setBaseAttackSpeed(double baseAttackSpeed) {
		this.baseAttackSpeed = baseAttackSpeed;
	}

	public void setCrit(double crit) {
		this.crit = crit;
	}

	public void setCritPerLevel(double critPerLevel) {
		this.critPerLevel = critPerLevel;
	}

	public void setHp(double hp) {
		this.hp = hp;
	}

	public void setHpPerLevel(double hpPerLevel) {
		this.hpPerLevel = hpPerLevel;
	}

	public void setHpRegen(double hpRegen) {
		this.hpRegen = hpRegen;
	}

	public void setHpRegenPerLevel(double hpRegenPerLevel) {
		this.hpRegenPerLevel = hpRegenPerLevel;
	}

	public void setMoveSpeed(double moveSpeed) {
		this.moveSpeed = moveSpeed;
	}

	public void setMp(double mp) {
		this.mp = mp;
	}

	public void setMpPerLevel(double mpPerLevel) {
		this.mpPerLevel = mpPerLevel;
	}

	public void setMpregen(double mpregen) {
		this.mpregen = mpregen;
	}

	public void setMpRegenPerLevel(double mpRegenPerLevel) {
		this.mpRegenPerLevel = mpRegenPerLevel;
	}

	public void setSpellBlock(double spellBlock) {
		this.spellBlock = spellBlock;
	}

	public void setSpellBlockPerLevel(double spellBlockPerLevel) {
		this.spellBlockPerLevel = spellBlockPerLevel;
	}
}