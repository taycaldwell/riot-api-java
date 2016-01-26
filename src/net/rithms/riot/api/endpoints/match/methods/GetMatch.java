package net.rithms.riot.api.endpoints.match.methods;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.ApiMethod;
import net.rithms.riot.api.endpoints.UrlParameter;
import net.rithms.riot.api.endpoints.match.dto.MatchDetail;
import net.rithms.riot.constant.Region;

public class GetMatch extends ApiMethod {

	public GetMatch(ApiConfig config, Region region, long matchId, boolean includeTimeline) {
		super(config);
		setDtoType(MatchDetail.class);
		setUrlBase(region.getEndpoint() + "/v2.2/match/" + matchId);
		if (includeTimeline) {
			add(new UrlParameter("includeTimeline", includeTimeline));
		}
		addApiKeyParameter();
	}
}