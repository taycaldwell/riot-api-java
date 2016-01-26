package net.rithms.riot.api.endpoints.stats.methods;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.ApiMethod;
import net.rithms.riot.api.endpoints.UrlParameter;
import net.rithms.riot.api.endpoints.stats.dto.PlayerStatsSummaryList;
import net.rithms.riot.constant.Region;
import net.rithms.riot.constant.Season;

public class GetPlayerStatsSummary extends ApiMethod {

	public GetPlayerStatsSummary(ApiConfig config, Region region, Season season, long summonerId) {
		super(config);
		setDtoClass(PlayerStatsSummaryList.class);
		setUrlBase(region.getEndpoint() + "/v1.3/stats/by-summoner/" + summonerId + "/summary");
		if (season != null) {
			add(new UrlParameter("season", season));
		}
		addApiKeyParameter();
	}
}