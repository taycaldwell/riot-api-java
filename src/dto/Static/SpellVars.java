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

public class SpellVars {

	private List<Double> coeff;
	private String dyn, key, link, ranksWith;
	
	public List<Double> getCoeff() {
		return coeff;
	}
	public String getDyn() {
		return dyn;
	}
	public String getKey() {
		return key;
	}
	public String getLink() {
		return link;
	}
	public String getRanksWith() {
		return ranksWith;
	}

}
