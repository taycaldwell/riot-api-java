package net.rithms.riot.api.endpoints.tournament.methods;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.ApiMethod;
import net.rithms.riot.api.endpoints.tournament.dto.TournamentCode;

public class GetTournamentCode extends ApiMethod {

	public GetTournamentCode(ApiConfig config, String tournamentCode) {
		super(config);
		setDtoType(TournamentCode.class);
		setUrlBase("https://global.api.pvp.net/tournament/public/v1/code/" + tournamentCode);
		addTournamentApiKeyParameter();
	}
}