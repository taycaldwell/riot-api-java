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

import net.rithms.riot.api.Dto;

public class Info extends Dto implements Serializable {

	private static final long serialVersionUID = -671408952920494867L;

	private int attack;
	private int defense;
	private int difficulty;
	private int magic;

	public int getAttack() {
		return attack;
	}

	public int getDefense() {
		return defense;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public int getMagic() {
		return magic;
	}
	
	public void setAttack(int attack) {
		this.attack = attack;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public void setMagic(int magic) {
		this.magic = magic;
	}

	@Override
	public String toString() {
		return "[" + getAttack() + "," + getMagic() + "," + getDefense() + "," + getDifficulty() + "]";
	}
}