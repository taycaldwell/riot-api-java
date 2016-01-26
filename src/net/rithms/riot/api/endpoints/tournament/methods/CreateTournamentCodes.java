package net.rithms.riot.api.endpoints.tournament.methods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.ApiMethod;
import net.rithms.riot.api.endpoints.UrlParameter;
import net.rithms.riot.api.request.RequestMethod;
import net.rithms.riot.constant.PickType;
import net.rithms.riot.constant.SpectatorType;
import net.rithms.riot.constant.TournamentMap;

public class CreateTournamentCodes extends ApiMethod {

	public CreateTournamentCodes(ApiConfig config, int tournamentId, int count, int teamSize, TournamentMap mapType, PickType pickType,
			SpectatorType spectatorType, String metaData, long... allowedSummonerIds) {
		super(config);
		setMethod(RequestMethod.POST);
		setDtoType(new TypeToken<List<String>>() {
		}.getType());
		setUrlBase("https://global.api.pvp.net/tournament/public/v1/code");
		add(new UrlParameter("tournamentId", tournamentId));
		add(new UrlParameter("count", count));
		addTournamentApiKeyParameter();
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("teamSize", teamSize);
		body.put("mapType", mapType);
		body.put("pickType", pickType);
		body.put("spectatorType", spectatorType);
		if (metaData != null) {
			body.put("metaData", metaData);
		}
		if (allowedSummonerIds != null && allowedSummonerIds.length > 0) {
			HashMap<String, Object> allowedSummonerIdsMap = new HashMap<String, Object>();
			allowedSummonerIdsMap.put("participants", allowedSummonerIds);
			body.put("allowedSummonerIds", allowedSummonerIdsMap);
		}
		buildJsonBody(body);
	}
}