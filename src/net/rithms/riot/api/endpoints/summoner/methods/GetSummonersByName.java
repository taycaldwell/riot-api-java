package net.rithms.riot.api.endpoints.summoner.methods;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.ApiMethod;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;
import net.rithms.riot.constant.Region;
import net.rithms.util.Convert;

public class GetSummonersByName extends ApiMethod {

	public GetSummonersByName(ApiConfig config, Region region, String summonerNames) {
		super(config);
		summonerNames = Convert.normalizeSummonerName(summonerNames);
		setDtoType(new TypeToken<Map<String, Summoner>>() {
		}.getType());
		try {
			setUrlBase(region.getEndpoint() + "/v1.4/summoner/by-name/" + URLEncoder.encode(summonerNames, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// This should never happen
			e.printStackTrace();
		}
		addApiKeyParameter();
	}
}