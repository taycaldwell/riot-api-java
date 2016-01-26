package net.rithms.riot.api.endpoints.game.methods;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.ApiMethod;
import net.rithms.riot.api.endpoints.game.dto.RecentGames;
import net.rithms.riot.constant.Region;

public class GetRecentGames extends ApiMethod {

	public GetRecentGames(ApiConfig config, Region region, long summonerId) {
		super(config);
		setDtoClass(RecentGames.class);
		setUrlBase(region.getEndpoint() + "/v1.3/game/by-summoner/" + summonerId + "/recent");
		addApiKeyParameter();
	}
}