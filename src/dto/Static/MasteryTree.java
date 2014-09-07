package dto.Static;

import java.util.List;

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

public class MasteryTree {
	
	private List<MasteryTreeList> Defense;
	private List<MasteryTreeList> Offense;
	private List<MasteryTreeList> Utility;
	
	public List<MasteryTreeList> getDefense() {
		return Defense;
	}
	public List<MasteryTreeList> getOffense() {
		return Offense;
	}
	public List<MasteryTreeList> getUtility() {
		return Utility;
	}
	
}
