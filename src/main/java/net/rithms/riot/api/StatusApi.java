package net.rithms.riot.api;

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
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Status.Shard;
import net.rithms.riot.dto.Status.ShardStatus;

final class StatusApi {

	private static final String VERSION = "/v1.0/";

	public static List<Shard> getShards() throws RiotApiException {
		String url = "http://status.leagueoflegends.com/shards";

		List<Shard> shards = null;
		try {
			shards = new Gson().fromJson(Request.sendGet(url), new TypeToken<List<Shard>>() {
			}.getType());
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (shards == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return shards;
	}

	public static ShardStatus getShardStatus(Region region) throws RiotApiException {
		String url = "http://status.leagueoflegends.com/shards/" + region;
		if (region.equals(Region.PBE.getName())) {
			url = "http://status.pbe.leagueoflegends.com/shards/pbe";
		}

		ShardStatus status = null;
		try {
			status = new Gson().fromJson(Request.sendGet(url), ShardStatus.class);
		} catch (JsonSyntaxException e) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}
		if (status == null) {
			throw new RiotApiException(RiotApiException.PARSE_FAILURE);
		}

		return status;
	}
}