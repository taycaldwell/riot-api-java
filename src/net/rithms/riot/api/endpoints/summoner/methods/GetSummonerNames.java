package net.rithms.riot.api.endpoints.summoner.methods;

import java.util.Map;

import com.google.gson.reflect.TypeToken;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.ApiMethod;
import net.rithms.riot.constant.Region;

public class GetSummonerNames extends ApiMethod {

	public GetSummonerNames(ApiConfig config, Region region, String summonerIds) {
		super(config);
		setDtoType(new TypeToken<Map<String, String>>() {
		}.getType());
		setUrlBase(region.getEndpoint() + "/v1.4/summoner/" + summonerIds + "/name");
		addApiKeyParameter();
	}
}