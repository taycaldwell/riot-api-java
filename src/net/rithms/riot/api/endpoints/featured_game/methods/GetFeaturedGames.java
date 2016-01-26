package net.rithms.riot.api.endpoints.featured_game.methods;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.ApiMethod;
import net.rithms.riot.api.endpoints.featured_game.dto.FeaturedGames;
import net.rithms.riot.constant.Region;

public class GetFeaturedGames extends ApiMethod {

	public GetFeaturedGames(ApiConfig config, Region region) {
		super(config);
		setDtoClass(FeaturedGames.class);
		setUrlBase(
				"https://" + region + ".api.pvp.net/observer-mode/rest/featured");
		addApiKeyParameter();
	}
}