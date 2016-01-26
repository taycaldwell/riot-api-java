package net.rithms.riot.api.endpoints.tournament.methods;

import java.util.HashMap;
import java.util.Map;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.ApiMethod;
import net.rithms.riot.api.request.RequestMethod;
import net.rithms.riot.constant.Region;

public class CreateProvider extends ApiMethod {

	public CreateProvider(ApiConfig config, Region region, String callbackUrl) {
		super(config);
		setMethod(RequestMethod.POST);
		setDtoType(Integer.class);
		setUrlBase("https://global.api.pvp.net/tournament/public/v1/provider");
		addTournamentApiKeyParameter();
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("region", region.getName().toUpperCase());
		body.put("url", callbackUrl);
		buildJsonBody(body);
	}
}