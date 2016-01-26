package net.rithms.riot.api.endpoints.champion.methods;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.ApiMethod;
import net.rithms.riot.api.endpoints.UrlParameter;
import net.rithms.riot.api.endpoints.champion.dto.ChampionList;
import net.rithms.riot.constant.Region;

public class GetChampions extends ApiMethod {

	public GetChampions(ApiConfig config, Region region, boolean freeToPlay) {
		super(config);
		setDtoType(ChampionList.class);
		setUrlBase(region.getEndpoint() + "/v1.2/champion");
		if (freeToPlay) {
			add(new UrlParameter("freeToPlay", freeToPlay));
		}
		addApiKeyParameter();
	}
}