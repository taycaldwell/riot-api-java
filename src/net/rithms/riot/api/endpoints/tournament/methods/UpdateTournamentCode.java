package net.rithms.riot.api.endpoints.tournament.methods;

import java.util.HashMap;
import java.util.Map;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.ApiMethod;
import net.rithms.riot.api.request.RequestMethod;
import net.rithms.riot.constant.PickType;
import net.rithms.riot.constant.SpectatorType;
import net.rithms.riot.constant.TournamentMap;

public class UpdateTournamentCode extends ApiMethod {

	public UpdateTournamentCode(ApiConfig config, String tournamentCode, TournamentMap mapType, PickType pickType, SpectatorType spectatorType,
			long... allowedSummonerIds) {
		super(config);
		setMethod(RequestMethod.PUT);
		setDtoType(Void.class);
		setUrlBase("https://global.api.pvp.net/tournament/public/v1/code/" + tournamentCode);
		addTournamentApiKeyParameter();
		Map<String, Object> body = new HashMap<String, Object>();
		if (mapType != null) {
			body.put("mapType", mapType);
		}
		if (pickType != null) {
			body.put("pickType", pickType);
		}
		if (spectatorType != null) {
			body.put("spectatorType", spectatorType);
		}
		if (allowedSummonerIds != null && allowedSummonerIds.length > 0) {
			body.put("allowedParticipants", allowedSummonerIds);
		}
		buildJsonBody(body);
	}
}