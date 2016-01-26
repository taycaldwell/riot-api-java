package net.rithms.riot.api.endpoints.championmastery.methods;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.ApiMethod;
import net.rithms.riot.constant.PlatformId;

public class GetChampionMasteryScore extends ApiMethod {

	public GetChampionMasteryScore(ApiConfig config, PlatformId platformId, long summonerId) {
		super(config);
		setDtoClass(Integer.class);
		setUrlBase("https://" + platformId.getName() + ".api.pvp.net/championmastery/location/" + platformId.getId() + "/player/" + summonerId + "/score");
		addApiKeyParameter();
	}
}