package net.rithms.riot.api.endpoints.match.methods;

import java.util.List;

import com.google.gson.reflect.TypeToken;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.ApiMethod;
import net.rithms.riot.constant.Region;

public class GetMatchesByTournament extends ApiMethod {

	public GetMatchesByTournament(ApiConfig config, Region region, String tournamentCode) {
		super(config);
		setDtoType(new TypeToken<List<Long>>() {
		}.getType());
		setUrlBase(region.getEndpoint() + "/v2.2/match/by-tournament/" + tournamentCode + "/ids");
		addApiKeyParameter();
	}
}