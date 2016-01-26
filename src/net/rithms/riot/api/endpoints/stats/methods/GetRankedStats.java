package net.rithms.riot.api.endpoints.stats.methods;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.ApiMethod;
import net.rithms.riot.api.endpoints.UrlParameter;
import net.rithms.riot.api.endpoints.stats.dto.RankedStats;
import net.rithms.riot.constant.Region;
import net.rithms.riot.constant.Season;

public class GetRankedStats extends ApiMethod {

	public GetRankedStats(ApiConfig config, Region region, Season season, long summonerId) {
		super(config);
		setDtoClass(RankedStats.class);
		setUrlBase(region.getEndpoint() + "/v1.3/stats/by-summoner/" + summonerId + "/ranked");
		if (season != null) {
			add(new UrlParameter("season", season));
		}
		addApiKeyParameter();
	}
}