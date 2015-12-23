package net.rithms.riot.dto.Static;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

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

public class Rune implements Serializable {

	private static final long serialVersionUID = -4823668922402235509L;
	private List<String> from;
	private List<String> into;
	private Map<String, Boolean> maps;
	private List<String> tags;
	private Gold gold;
	private Image image;
	private MetaData rune;
	private BasicDataStats stats;
	private RuneStat stat;
	private boolean consumeOnFull, consumed, hideFromAll, inStore;
	private int depth, id, specialRecipe, stacks;
	private String colloq, description, group, name, plaintext, requiredChampion, sanitizedDescription;

	public List<String> getFrom() {
		return from;
	}

	public List<String> getInto() {
		return into;
	}

	public Map<String, Boolean> getMaps() {
		return maps;
	}

	public List<String> getTags() {
		return tags;
	}

	public Gold getGold() {
		return gold;
	}

	public Image getImage() {
		return image;
	}

	public MetaData getRune() {
		return rune;
	}

	public BasicDataStats getStats() {
		return stats;
	}

	public String getColloq() {
		return colloq;
	}

	public String getDescription() {
		return description;
	}

	public String getGroup() {
		return group;
	}

	public String getName() {
		return name;
	}

	public String getPlaintext() {
		return plaintext;
	}

	public String getRequiredChampion() {
		return requiredChampion;
	}

	public String getSanitizedDescription() {
		return sanitizedDescription;
	}

	public boolean isConsumeOnFull() {
		return consumeOnFull;
	}

	public boolean isConsumed() {
		return consumed;
	}

	public boolean isHideFromAll() {
		return hideFromAll;
	}

	public boolean isInStore() {
		return inStore;
	}

	public int getDepth() {
		return depth;
	}

	public int getId() {
		return id;
	}

	public int getSpecialRecipe() {
		return specialRecipe;
	}

	public int getStacks() {
		return stacks;
	}

	public RuneStat getStat() {
		if (stat != null) {
			return stat;
		}

		stat = new RuneStat();
		double value;
		if ((value = stats.getFlatArmorMod()) != 0) {
			stat.setType("FlatArmorMod");
			stat.setValue(value);
		} else if ((value = stats.getFlatAttackSpeedMod()) != 0) {
			stat.setType("FlatAttackSpeedMod");
			stat.setValue(value);
		} else if ((value = stats.getFlatBlockMod()) != 0) {
			stat.setType("FlatBlockMod");
			stat.setValue(value);
		} else if ((value = stats.getFlatCritChanceMod()) != 0) {
			stat.setType("FlatCritChanceMod");
			stat.setValue(value);
		} else if ((value = stats.getFlatCritDamageMod()) != 0) {
			stat.setType("FlatCritDamageMod");
			stat.setValue(value);
		} else if ((value = stats.getFlatEnergyPoolMod()) != 0) {
			stat.setType("FlatEnergyPoolMod");
			stat.setValue(value);
		} else if ((value = stats.getFlatEnergyRegenMod()) != 0) {
			stat.setType("FlatEnergyRegenMod");
			stat.setValue(value);
		} else if ((value = stats.getFlatEXPBonus()) != 0) {
			stat.setType("FlatEXPBonus");
			stat.setValue(value);
		} else if ((value = stats.getFlatHPPoolMod()) != 0) {
			stat.setType("FlatHPPoolMod");
			stat.setValue(value);
		} else if ((value = stats.getFlatHPRegenMod()) != 0) {
			stat.setType("FlatHPRegenMod");
			stat.setValue(value);
		} else if ((value = stats.getFlatMagicDamageMod()) != 0) {
			stat.setType("FlatMagicDamageMod");
			stat.setValue(value);
		} else if ((value = stats.getFlatMovementSpeedMod()) != 0) {
			stat.setType("FlatMovementSpeedMod");
			stat.setValue(value);
		} else if ((value = stats.getFlatMPPoolMod()) != 0) {
			stat.setType("FlatMPPoolMod");
			stat.setValue(value);
		} else if ((value = stats.getFlatMPRegenMod()) != 0) {
			stat.setType("FlatMPRegenMod");
			stat.setValue(value);
		} else if ((value = stats.getFlatPhysicalDamageMod()) != 0) {
			stat.setType("FlatPhysicalDamageMod");
			stat.setValue(value);
		} else if ((value = stats.getFlatSpellBlockMod()) != 0) {
			stat.setType("FlatSpellBlockMod");
			stat.setValue(value);
		} else if ((value = stats.getPercentArmorMod()) != 0) {
			stat.setType("PercentArmorMod");
			stat.setValue(value);
		} else if ((value = stats.getPercentAttackSpeedMod()) != 0) {
			stat.setType("PercentAttackSpeedMod");
			stat.setValue(value);
		} else if ((value = stats.getPercentBlockMod()) != 0) {
			stat.setType("PercentBlockMod");
			stat.setValue(value);
		} else if ((value = stats.getPercentCritChanceMod()) != 0) {
			stat.setType("PercentCritChanceMod");
			stat.setValue(value);
		} else if ((value = stats.getPercentCritDamageMod()) != 0) {
			stat.setType("PercentCritDamageMod");
			stat.setValue(value);
		} else if ((value = stats.getPercentDodgeMod()) != 0) {
			stat.setType("PercentDodgeMod");
			stat.setValue(value);
		} else if ((value = stats.getPercentEXPBonus()) != 0) {
			stat.setType("PercentEXPBonus");
			stat.setValue(value);
		} else if ((value = stats.getPercentHPPoolMod()) != 0) {
			stat.setType("PercentHPPoolMod");
			stat.setValue(value);
		} else if ((value = stats.getPercentHPRegenMod()) != 0) {
			stat.setType("PercentHPRegenMod");
			stat.setValue(value);
		} else if ((value = stats.getPercentLifeStealMod()) != 0) {
			stat.setType("PercentLifeStealMod");
			stat.setValue(value);
		} else if ((value = stats.getPercentMagicDamageMod()) != 0) {
			stat.setType("PercentMagicDamageMod");
			stat.setValue(value);
		} else if ((value = stats.getPercentMovementSpeedMod()) != 0) {
			stat.setType("PercentMovementSpeedMod");
			stat.setValue(value);
		} else if ((value = stats.getPercentMPPoolMod()) != 0) {
			stat.setType("PercentMPPoolMod");
			stat.setValue(value);
		} else if ((value = stats.getPercentMPRegenMod()) != 0) {
			stat.setType("PercentMPRegenMod");
			stat.setValue(value);
		} else if ((value = stats.getPercentPhysicalDamageMod()) != 0) {
			stat.setType("PercentPhysicalDamageMod");
			stat.setValue(value);
		} else if ((value = stats.getPercentSpellBlockMod()) != 0) {
			stat.setType("PercentSpellBlockMod");
			stat.setValue(value);
		} else if ((value = stats.getPercentSpellVampMod()) != 0) {
			stat.setType("PercentSpellVampMod");
			stat.setValue(value);
		} else if ((value = stats.getrFlatArmorModPerLevel()) != 0) {
			stat.setType("rFlatArmorModPerLevel");
			stat.setValue(value);
		} else if ((value = stats.getrFlatArmorPenetrationMod()) != 0) {
			stat.setType("rFlatArmorPenetrationMod");
			stat.setValue(value);
		} else if ((value = stats.getrFlatArmorPenetrationModPerLevel()) != 0) {
			stat.setType("rFlatArmorPenetrationModPerLevel");
			stat.setValue(value);
		} else if ((value = stats.getrFlatCritChanceModPerLevel()) != 0) {
			stat.setType("rFlatCritChanceModPerLevel");
			stat.setValue(value);
		} else if ((value = stats.getrFlatCritDamageModPerLevel()) != 0) {
			stat.setType("rFlatCritDamageModPerLevel");
			stat.setValue(value);
		} else if ((value = stats.getrFlatDodgeMod()) != 0) {
			stat.setType("rFlatDodgeMod");
			stat.setValue(value);
		} else if ((value = stats.getrFlatDodgeModPerLevel()) != 0) {
			stat.setType("rFlatDodgeModPerLevel");
			stat.setValue(value);
		} else if ((value = stats.getrFlatEnergyModPerLevel()) != 0) {
			stat.setType("rFlatEnergyModPerLevel");
			stat.setValue(value);
		} else if ((value = stats.getrFlatEnergyRegenModPerLevel()) != 0) {
			stat.setType("rFlatEnergyRegenModPerLevel");
			stat.setValue(value);
		} else if ((value = stats.getrFlatGoldPer10Mod()) != 0) {
			stat.setType("rFlatGoldPer10Mod");
			stat.setValue(value);
		} else if ((value = stats.getrFlatHPModPerLevel()) != 0) {
			stat.setType("rFlatHPModPerLevel");
			stat.setValue(value);
		} else if ((value = stats.getrFlatHPRegenModPerLevel()) != 0) {
			stat.setType("rFlatHPRegenModPerLevel");
			stat.setValue(value);
		} else if ((value = stats.getrFlatMagicDamageModPerLevel()) != 0) {
			stat.setType("rFlatMagicDamageModPerLevel");
			stat.setValue(value);
		} else if ((value = stats.getrFlatMagicPenetrationMod()) != 0) {
			stat.setType("rFlatMagicPenetrationMod");
			stat.setValue(value);
		} else if ((value = stats.getrFlatMagicPenetrationModPerLevel()) != 0) {
			stat.setType("rFlatMagicPenetrationModPerLevel");
			stat.setValue(value);
		} else if ((value = stats.getrFlatMovementSpeedModPerLevel()) != 0) {
			stat.setType("rFlatMovementSpeedModPerLevel");
			stat.setValue(value);
		} else if ((value = stats.getrFlatMPModPerLevel()) != 0) {
			stat.setType("rFlatMPModPerLevel");
			stat.setValue(value);
		} else if ((value = stats.getrFlatMPRegenModPerLevel()) != 0) {
			stat.setType("rFlatMPRegenModPerLevel");
			stat.setValue(value);
		} else if ((value = stats.getrFlatPhysicalDamageModPerLevel()) != 0) {
			stat.setType("rFlatPhysicalDamageModPerLevel");
			stat.setValue(value);
		} else if ((value = stats.getrFlatSpellBlockModPerLevel()) != 0) {
			stat.setType("rFlatSpellBlockModPerLevel");
			stat.setValue(value);
		} else if ((value = stats.getrFlatTimeDeadMod()) != 0) {
			stat.setType("rFlatTimeDeadMod");
			stat.setValue(value);
		} else if ((value = stats.getrFlatTimeDeadModPerLevel()) != 0) {
			stat.setType("rFlatTimeDeadModPerLevel");
			stat.setValue(value);
		} else if ((value = stats.getrPercentArmorPenetrationMod()) != 0) {
			stat.setType("rPercentArmorPenetrationMod");
			stat.setValue(value);
		} else if ((value = stats.getrPercentArmorPenetrationModPerLevel()) != 0) {
			stat.setType("rPercentArmorPenetrationModPerLevel");
			stat.setValue(value);
		} else if ((value = stats.getrPercentAttackSpeedModPerLevel()) != 0) {
			stat.setType("rPercentAttackSpeedModPerLevel");
			stat.setValue(value);
		} else if ((value = stats.getrPercentCooldownMod()) != 0) {
			stat.setType("rPercentCooldownMod");
			stat.setValue(value);
		} else if ((value = stats.getrPercentCooldownModPerLevel()) != 0) {
			stat.setType("rPercentCooldownModPerLevel");
			stat.setValue(value);
		} else if ((value = stats.getrPercentMagicPenetrationMod()) != 0) {
			stat.setType("rPercentMagicPenetrationMod");
			stat.setValue(value);
		} else if ((value = stats.getrPercentMagicPenetrationModPerLevel()) != 0) {
			stat.setType("rPercentMagicPenetrationModPerLevel");
			stat.setValue(value);
		} else if ((value = stats.getrPercentMovementSpeedModPerLevel()) != 0) {
			stat.setType("rPercentMovementSpeedModPerLevel");
			stat.setValue(value);
		} else if ((value = stats.getrPercentTimeDeadMod()) != 0) {
			stat.setType("rPercentTimeDeadMod");
			stat.setValue(value);
		} else if ((value = stats.getrPercentTimeDeadModPerLevel()) != 0) {
			stat.setType("rPercentTimeDeadModPerLevel");
			stat.setValue(value);
		}
		return stat;
	}
}