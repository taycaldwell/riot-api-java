package net.rithms.riot.api.endpoints.championmastery.methods;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.ApiMethod;
import net.rithms.riot.api.endpoints.championmastery.dto.ChampionMastery;
import net.rithms.riot.constant.PlatformId;

public class GetChampionMastery extends ApiMethod {

	public GetChampionMastery(ApiConfig config, PlatformId platformId, long summonerId, long championId) {
		super(config);
		setDtoClass(ChampionMastery.class);
		setUrlBase("https://" + platformId.getName() + ".api.pvp.net/championmastery/location/" + platformId.getId() + "/player/" + summonerId + "/champion/"
				+ championId);
		addApiKeyParameter();
	}
}