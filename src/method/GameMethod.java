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
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import dto.Game.RecentGames;
import main.java.riotapi.Request;
import main.java.riotapi.RiotApiException;

public final class GameMethod {

    public static RecentGames getRecentGames(String endpoint, String region, String key, long summonerId) throws RiotApiException {

        String url = endpoint + "/api/lol/" + region + "/v1.3/game/by-summoner/" + summonerId + "/recent?api_key=" + key;
        try {
            RecentGames recentGames = new Gson().fromJson(Request.execute(url), RecentGames.class);
            return recentGames;
        } catch (JsonSyntaxException e) {
            throw new RiotApiException(RiotApiException.PARSE_FAILURE);
        }
    }
}
