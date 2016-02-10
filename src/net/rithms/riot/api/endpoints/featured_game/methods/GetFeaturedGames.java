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

package net.rithms.riot.api.endpoints.featured_game.methods;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.featured_game.FeaturedGameApiMethod;
import net.rithms.riot.api.endpoints.featured_game.dto.FeaturedGames;
import net.rithms.riot.constant.Region;

public class GetFeaturedGames extends FeaturedGameApiMethod {

	public GetFeaturedGames(ApiConfig config, Region region) {
		super(config);
		setRegion(region);
		setReturnType(FeaturedGames.class);
		setUrlBase("https://" + region + ".api.pvp.net/observer-mode/rest/featured");
		addApiKeyParameter();
	}
}