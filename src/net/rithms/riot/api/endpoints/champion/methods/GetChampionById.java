package net.rithms.riot.api.endpoints.champion.methods;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.ApiMethod;
import net.rithms.riot.api.endpoints.champion.dto.Champion;
import net.rithms.riot.constant.Region;

public class GetChampionById extends ApiMethod {

	public GetChampionById(ApiConfig config, Region region, int id) {
		super(config);
		setDtoType(Champion.class);
		setUrlBase(region.getEndpoint() + "/v1.2/champion/" + id);
		addApiKeyParameter();
	}
}