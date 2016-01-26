package net.rithms.riot.api.endpoints.status.methods;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.ApiMethod;
import net.rithms.riot.api.endpoints.status.dto.ShardStatus;
import net.rithms.riot.constant.Region;

public class GetShardStatus extends ApiMethod {

	public GetShardStatus(ApiConfig config, Region region) {
		super(config);
		setDtoClass(ShardStatus.class);
		if (region == Region.PBE) {
			setUrlBase("http://status.pbe.leagueoflegends.com/shards/pbe");
		} else {
			setUrlBase("http://status.leagueoflegends.com/shards/" + region);
		}
	}
}