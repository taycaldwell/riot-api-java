package net.rithms.riot.api.endpoints.current_game.methods;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.ApiMethod;
import net.rithms.riot.api.endpoints.current_game.dto.CurrentGameInfo;
import net.rithms.riot.constant.PlatformId;

public class GetCurrentGameInfo extends ApiMethod {

	public GetCurrentGameInfo(ApiConfig config, PlatformId platformId, long summonerId) {
		super(config);
		setDtoClass(CurrentGameInfo.class);
		setUrlBase(
				"https://" + platformId.getName() + ".api.pvp.net/observer-mode/rest/consumer/getSpectatorGameInfo/" + platformId.getId() + '/' + summonerId);
		addApiKeyParameter();
	}
}