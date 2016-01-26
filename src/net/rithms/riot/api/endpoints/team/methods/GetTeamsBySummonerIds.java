package net.rithms.riot.api.endpoints.team.methods;

import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.ApiMethod;
import net.rithms.riot.api.endpoints.team.dto.Team;
import net.rithms.riot.constant.Region;

public class GetTeamsBySummonerIds extends ApiMethod {

	public GetTeamsBySummonerIds(ApiConfig config, Region region, String summonerIds) {
		super(config);
		setDtoType(new TypeToken<Map<String, List<Team>>>() {
		}.getType());
		setUrlBase(region.getEndpoint() + "/v2.4/team/by-summoner/" + summonerIds);
		addApiKeyParameter();
	}
}