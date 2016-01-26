package net.rithms.riot.api.endpoints.tournament.methods;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.ApiMethod;
import net.rithms.riot.api.endpoints.tournament.dto.LobbyEventList;

public class GetLobbyEventsByTournament extends ApiMethod {

	public GetLobbyEventsByTournament(ApiConfig config, String tournamentCode) {
		super(config);
		setDtoType(LobbyEventList.class);
		setUrlBase("https://global.api.pvp.net/tournament/public/v1/lobby/events/by-code/" + tournamentCode);
		addTournamentApiKeyParameter();
	}
}