package net.rithms.riot.api.endpoints.match.methods;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.ApiMethod;
import net.rithms.riot.api.endpoints.UrlParameter;
import net.rithms.riot.api.endpoints.match.dto.MatchDetail;
import net.rithms.riot.constant.Region;

public class GetMatchForTournament extends ApiMethod {

	public GetMatchForTournament(ApiConfig config, Region region, long matchId, String tournamentCode, boolean includeTimeline) {
		super(config);
		setDtoType(MatchDetail.class);
		setUrlBase(region.getEndpoint() + "/v2.2/match/for-tournament/" + matchId);
		add(new UrlParameter("tournamentCode", tournamentCode));
		if (includeTimeline) {
			add(new UrlParameter("includeTimeline", includeTimeline));
		}
		addApiKeyParameter();
	}
}