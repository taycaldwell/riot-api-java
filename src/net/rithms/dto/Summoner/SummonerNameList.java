package net.rithms.dto.Summoner;

/** DEPRECATED **/

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

import java.io.Serializable;
import java.util.List;

public class SummonerNameList implements Serializable {

	private static final long serialVersionUID = 1467065344377557207L;
	private List<SummonerName> summoners;

	public List<SummonerName> getSummoners() {
		return summoners;
	}
	
}
