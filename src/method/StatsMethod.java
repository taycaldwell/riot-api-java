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

import dto.Stats.PlayerStatsSummaryList;
import dto.Stats.RankedStats;
import main.java.riotapi.Request;
import main.java.riotapi.RiotApiException;

public final class StatsMethod {

    /**
     * Get a summary of player statistics for a given summoner
     *
     * @param region The desired region
     * @param summonerId The ID of the desired summoner
     * @param season The desired season
     * @return A summary of player statistics for the given summoner
     * @see PlayerStatsSummaryList
     */
    public static PlayerStatsSummaryList getPlayerStatsSummary(String endpoint, String region, String season, String key, long summonerId) throws RiotApiException {

        String url = endpoint + "/api/lol/" + region + "/v1.3/stats/by-summoner/" + summonerId + "/summary?season=" + season + "&api_key=" + key;
        PlayerStatsSummaryList summaryList = null;

        try {
            summaryList = new Gson().fromJson(Request.execute(url), PlayerStatsSummaryList.class);
        } catch (JsonSyntaxException e) {
            throw new RiotApiException(RiotApiException.PARSE_FAILURE);
        }

        return summaryList;
    }

    /**
     * Get the ranked statistics of a given summoner
     *
     * @param region The desired region
     * @param summonerId The ID of the desired summoner
     * @param season The desired season
     * @return Ranked statistics of the given summoner
     * @see RankedStats
     */
    public static RankedStats getRankedStats(String endpoint, String region, String season, String key, long summonerId) throws RiotApiException {

        String url = endpoint + "/api/lol/" + region + "/v1.3/stats/by-summoner/" + summonerId + "/ranked?season=" + season + "&api_key=" + key;
        RankedStats rankedStats = null;

        try {
            rankedStats = new Gson().fromJson(Request.execute(url), RankedStats.class);
        } catch (JsonSyntaxException e) {
            throw new RiotApiException(RiotApiException.PARSE_FAILURE);
        }

        return rankedStats;
    }

}
