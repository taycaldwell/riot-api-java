/*
 * Copyright 2016 Taylor Caldwell
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

package net.rithms.riot.api.endpoints.static_data.methods;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.UrlParameter;
import net.rithms.riot.api.endpoints.static_data.StaticDataApiMethod;
import net.rithms.riot.api.endpoints.static_data.constant.RuneData;
import net.rithms.riot.api.endpoints.static_data.dto.Rune;
import net.rithms.riot.constant.Region;
import net.rithms.util.Convert;

public class GetDataRune extends StaticDataApiMethod {

	public GetDataRune(ApiConfig config, Region region, int id, String locale, String version, RuneData... runeData) {
		super(config);
		setRegion(region);
		setReturnType(Rune.class);
		setUrlBase("https://global.api.pvp.net/api/lol/static-data/" + region + "/v1.2/rune/" + id);
		if (locale != null) {
			add(new UrlParameter("locale", locale));
		}
		if (version != null) {
			add(new UrlParameter("version", version));
		}
		if (runeData[0] != null) {
			add(new UrlParameter("runeData", Convert.joinString(",", (Object[]) runeData)));
		}
		addApiKeyParameter();
	}
}