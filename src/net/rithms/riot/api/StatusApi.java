/*
 * Copyright 2014 Taylor Caldwell
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.rithms.riot.api;

import java.util.List;

import com.google.gson.reflect.TypeToken;

import net.rithms.riot.api.request.Request;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Status.Shard;
import net.rithms.riot.dto.Status.ShardStatus;

/**
 * @version 1.0
 */
final class StatusApi {

	public static List<Shard> getShards(ApiConfig config) throws RiotApiException {
		Request request = new Request(config);
		request.setUrlBase("http://status.leagueoflegends.com/shards");
		request.execute();
		List<Shard> dto = request.getDto(new TypeToken<List<Shard>>() {
		}.getType());
		return dto;
	}

	public static ShardStatus getShardStatus(ApiConfig config, Region region) throws RiotApiException {
		Request request = new Request(config);
		if (region == Region.PBE) {
			request.setUrlBase("http://status.pbe.leagueoflegends.com/shards/pbe");
		} else {
			request.setUrlBase("http://status.leagueoflegends.com/shards/", region);
		}
		request.execute();
		ShardStatus dto = request.getDto(ShardStatus.class);
		return dto;
	}
}