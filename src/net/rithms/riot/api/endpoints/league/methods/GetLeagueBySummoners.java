package net.rithms.riot.api.endpoints.league.methods;

import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.ApiMethod;
import net.rithms.riot.api.endpoints.league.dto.League;
import net.rithms.riot.constant.Region;

public class GetLeagueBySummoners extends ApiMethod {
	
	public GetLeagueBySummoners(ApiConfig config, Region region, String summonerIds) {
		super(config);
		setDtoType(new TypeToken<Map<String, List<League>>>() {
		}.getType());
		setUrlBase(region.getEndpoint() + "/v2.5/league/by-summoner/" + summonerIds);
		addApiKeyParameter();
	}	
}
