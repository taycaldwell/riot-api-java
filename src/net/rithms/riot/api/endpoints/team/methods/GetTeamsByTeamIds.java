package net.rithms.riot.api.endpoints.team.methods;

import java.util.Map;

import com.google.gson.reflect.TypeToken;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.ApiMethod;
import net.rithms.riot.api.endpoints.team.dto.Team;
import net.rithms.riot.constant.Region;

public class GetTeamsByTeamIds extends ApiMethod {

	public GetTeamsByTeamIds(ApiConfig config, Region region, String teamIds) {
		super(config);
		setDtoType(new TypeToken<Map<String, Team>>() {
		}.getType());
		setUrlBase(region.getEndpoint() + "/v2.4/team/" + teamIds);
		addApiKeyParameter();
	}
}