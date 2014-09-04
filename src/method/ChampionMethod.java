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
import dto.Champion.Champion;
import dto.Champion.ChampionList;

public final class ChampionMethod {
	
	public static ChampionList getChampions(String endpoint, String region, String key) {
		
		String url = endpoint + "/api/lol/" + region + "/v1.2/champion?api_key=" + key;
	    ChampionList championList = null;
		
			try {
				championList = new Gson().fromJson(IOUtils.toString(new URL(url)), ChampionList.class);
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
		 
	    return championList;
	}
    
	public static ChampionList getChampions(String endpoint, String region, String key, boolean freeToPlay) {

		String url = endpoint + "/api/lol/" + region + "/v1.2/champion?freeToPlay=" + freeToPlay + "&api_key=" + key;
	    ChampionList championList = null;

			try {
				championList = new Gson().fromJson(IOUtils.toString(new URL(url)), ChampionList.class);
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}

	    return championList;
	}
	
	public static Champion getChampionById(String endpoint, String region, String key, int champId) {
		
		String url = endpoint + "/api/lol/" + region + "/v1.2/champion/" + champId + "?api_key=" + key;
	    Champion champion = null;
		
			try {
				champion = new Gson().fromJson(IOUtils.toString(new URL(url)), Champion.class);
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
		 
	    return champion;
	}
	
}
