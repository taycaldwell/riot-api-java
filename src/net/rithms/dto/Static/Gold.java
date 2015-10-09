package net.rithms.dto.Static;

import java.io.Serializable;

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

public class Gold implements Serializable {
	
	private static final long serialVersionUID = -2996361282729522012L;
	private boolean purchasable;
	private int base, sell, total;
	
	public boolean isPurchasable() {
		return purchasable;
	}
	public int getBase() {
		return base;
	}
	public int getSell() {
		return sell;
	}
	public int getTotal() {
		return total;
	}
	
}
