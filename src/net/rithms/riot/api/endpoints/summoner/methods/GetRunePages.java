package net.rithms.riot.api.endpoints.summoner.methods;

import java.util.Map;

import com.google.gson.reflect.TypeToken;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.ApiMethod;
import net.rithms.riot.api.endpoints.summoner.dto.RunePages;
import net.rithms.riot.constant.Region;

public class GetRunePages extends ApiMethod {

	public GetRunePages(ApiConfig config, Region region, String summonerIds) {
		super(config);
		setDtoType(new TypeToken<Map<String, RunePages>>() {
		}.getType());
		setUrlBase(region.getEndpoint() + "/v1.4/summoner/" + summonerIds + "/runes");
		addApiKeyParameter();
	}
}