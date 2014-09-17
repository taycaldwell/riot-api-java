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
import dto.Match.MatchDetail;
import main.java.riotapi.Request;
import main.java.riotapi.RiotApiException;

public final class MatchMethod {

    public static MatchDetail getMatch(String endpoint, String region, String key, long matchId, boolean includeTimeline) throws RiotApiException {

        String url = endpoint + "/api/lol/" + region + "/v2.2/match/" + matchId + "?includeTimeline=" + includeTimeline + "&api_key=" + key;
        MatchDetail matchDetail = null;

        try {
            matchDetail = new Gson().fromJson(Request.execute(url), MatchDetail.class);
        } catch (JsonSyntaxException e) {
            throw new RiotApiException(RiotApiException.PARSE_FAILURE);
        }

        return matchDetail;
    }

    public static MatchDetail getMatch(String endpoint, String region, String key, long matchId) throws RiotApiException {

        String url = endpoint + "/api/lol/" + region + "/v2.2/match/" + matchId + "?api_key=" + key;
        MatchDetail matchDetail = null;

        try {
            matchDetail = new Gson().fromJson(Request.execute(url), MatchDetail.class);
        } catch (JsonSyntaxException e) {
            throw new RiotApiException(RiotApiException.PARSE_FAILURE);
        }

        return matchDetail;
    }

}
