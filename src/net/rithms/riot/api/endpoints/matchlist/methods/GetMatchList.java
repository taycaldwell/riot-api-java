package net.rithms.riot.api.endpoints.matchlist.methods;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.ApiMethod;
import net.rithms.riot.api.endpoints.UrlParameter;
import net.rithms.riot.api.endpoints.matchlist.dto.MatchList;
import net.rithms.riot.constant.Region;

public class GetMatchList extends ApiMethod {

	public GetMatchList(ApiConfig config, Region region, long summonerId, String championIds, String rankedQueues, String seasons, long beginTime, long endTime,
			int beginIndex, int endIndex) {
		super(config);
		setDtoType(MatchList.class);
		setUrlBase(region.getEndpoint() + "/v2.2/matchlist/by-summoner/" + summonerId);
		if (championIds != null) {
			add(new UrlParameter("championIds", championIds));
		}
		if (rankedQueues != null) {
			add(new UrlParameter("rankedQueues", rankedQueues));
		}
		if (seasons != null) {
			add(new UrlParameter("seasons", seasons));
		}
		if (beginTime != -1) {
			add(new UrlParameter("beginTime", beginTime));
		}
		if (endTime != -1) {
			add(new UrlParameter("endTime", endTime));
		}
		if (beginIndex != -1) {
			add(new UrlParameter("beginIndex", beginIndex));
		}
		if (endIndex != -1) {
			add(new UrlParameter("endIndex", endIndex));
		}
		addApiKeyParameter();
	}
}