package net.rithms.riot.api.endpoints.championmastery.methods;

import java.util.List;

import com.google.gson.reflect.TypeToken;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.ApiMethod;
import net.rithms.riot.api.endpoints.championmastery.dto.ChampionMastery;
import net.rithms.riot.constant.PlatformId;

public class GetChampionMasteries extends ApiMethod {

	public GetChampionMasteries(ApiConfig config, PlatformId platformId, long summonerId) {
		super(config);
		setDtoType(new TypeToken<List<ChampionMastery>>() {
		}.getType());
		setUrlBase("https://" + platformId.getName() + ".api.pvp.net/championmastery/location/" + platformId.getId() + "/player/" + summonerId + "/champions");
		addApiKeyParameter();
	}
}