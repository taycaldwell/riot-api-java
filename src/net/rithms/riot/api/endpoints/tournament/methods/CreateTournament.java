package net.rithms.riot.api.endpoints.tournament.methods;

import java.util.HashMap;
import java.util.Map;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.ApiMethod;
import net.rithms.riot.api.request.RequestMethod;

public class CreateTournament extends ApiMethod {

	public CreateTournament(ApiConfig config, String tournamentName, int providerId) {
		super(config);
		setMethod(RequestMethod.POST);
		setDtoType(Integer.class);
		setUrlBase("https://global.api.pvp.net/tournament/public/v1/tournament");
		addTournamentApiKeyParameter();
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("name", (tournamentName == null) ? "" : tournamentName);
		body.put("providerId", providerId);
		buildJsonBody(body);
	}
}