package net.rithms.riot.api.endpoints.status.methods;

import java.util.List;

import com.google.gson.reflect.TypeToken;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.endpoints.ApiMethod;
import net.rithms.riot.api.endpoints.status.dto.Shard;

public class GetShards extends ApiMethod {

	public GetShards(ApiConfig config) {
		super(config);
		setDtoType(new TypeToken<List<Shard>>() {
		}.getType());
		setUrlBase("http://status.leagueoflegends.com/shards");
	}
}