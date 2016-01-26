package net.rithms.riot.api.endpoints.championmastery.methods;

import java.util.List;

import com.google.gson.reflect.TypeToken;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.ApiMethod;
import net.rithms.riot.api.endpoints.UrlParameter;
import net.rithms.riot.api.endpoints.championmastery.dto.ChampionMastery;
import net.rithms.riot.constant.PlatformId;

public class GetTopChampionMasteries extends ApiMethod {

	public GetTopChampionMasteries(ApiConfig config, PlatformId platformId, long summonerId, int count) {
		super(config);
		setDtoType(new TypeToken<List<ChampionMastery>>() {
		}.getType());
		setUrlBase(
				"https://" + platformId.getName() + ".api.pvp.net/championmastery/location/" + platformId.getId() + "/player/" + summonerId + "/topchampions");
		if (count != -1) {
			add(new UrlParameter("count", count));
		}
		addApiKeyParameter();
	}
}