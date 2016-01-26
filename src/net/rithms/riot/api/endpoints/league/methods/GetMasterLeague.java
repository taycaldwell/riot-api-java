package net.rithms.riot.api.endpoints.league.methods;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.ApiMethod;
import net.rithms.riot.api.endpoints.UrlParameter;
import net.rithms.riot.api.endpoints.league.dto.League;
import net.rithms.riot.constant.QueueType;
import net.rithms.riot.constant.Region;

public class GetMasterLeague extends ApiMethod {

	public GetMasterLeague(ApiConfig config, Region region, QueueType queueType) {
		super(config);
		setDtoClass(League.class);
		setUrlBase(region.getEndpoint() + "/v2.5/league/master");
		add(new UrlParameter("type", queueType.name()));
		addApiKeyParameter();
	}
}