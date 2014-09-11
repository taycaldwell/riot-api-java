package method;

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

import java.io.IOException;
import java.net.URL;
import org.apache.commons.io.IOUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import dto.MatchHistory.PlayerHistory;

public final class MatchHistoryMethod {
	
	public static PlayerHistory getMatchHistory(String endpoint, String region, String key, long summonerId, String championIds, String rankedQueues, int beginIndex, int endIndex){
		
		String url = endpoint + "/api/lol/" + region + "/v2.2/matchhistory/" + summonerId + "?";
		
		if(championIds != null)
			url += "championIds=" + championIds + "&";
		if(rankedQueues != null)
			url += "rankedQueues=" + rankedQueues + "&";
		if(beginIndex != -1)
			url += "beginIndex=" + beginIndex + "&";
		if(endIndex != -1)
			url += "endIndex=" + endIndex + "&";
		url += "api_key=" + key;
		
		PlayerHistory matchHistory = null;

			try {
				matchHistory = new Gson().fromJson(IOUtils.toString(new URL(url)), PlayerHistory.class);
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
	
	    return matchHistory;
	}

}