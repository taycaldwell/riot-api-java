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
import java.util.Map;

import util.Convert;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import dto.Summoner.MasteryPages;
import dto.Summoner.RunePages;
import dto.Summoner.Summoner;
import main.java.riotapi.Request;
import main.java.riotapi.RiotApiException;

public final class SummonerMethod {

    public static Map<String, MasteryPages> getMasteryPages(String endpoint, String region, String key, String summonerIds) throws RiotApiException {

        String url = endpoint + "/api/lol/" + region + "/v1.4/summoner/" + summonerIds + "/masteries?api_key=" + key;
        Map<String, MasteryPages> masteryPages = null;

        try {
            masteryPages = new Gson().fromJson(Request.execute(url), new TypeToken<Map<String, MasteryPages>>() {
            }.getType());
        } catch (JsonSyntaxException e) {
            throw new RiotApiException(RiotApiException.PARSE_FAILURE);
        }
        return masteryPages;
    }

    public static Map<String, MasteryPages> getMasteryPages(String endpoint, String region, String key, long... summonerIds) throws RiotApiException {
        return getMasteryPages(endpoint, region, key, Convert.longToString(summonerIds));
    }

    public static Map<String, RunePages> getRunePages(String endpoint, String region, String key, String summonerIds) throws RiotApiException {

        String url = endpoint + "/api/lol/" + region + "/v1.4/summoner/" + summonerIds + "/runes?api_key=" + key;
        Map<String, RunePages> runePages = null;

        try {
            runePages = new Gson().fromJson(Request.execute(url), new TypeToken<Map<String, RunePages>>() {
            }.getType());
        } catch (JsonSyntaxException e) {
            throw new RiotApiException(RiotApiException.PARSE_FAILURE);
        }

        return runePages;
    }

    public static Map<String, RunePages> getRunePages(String endpoint, String region, String key, long... summonerIds) throws RiotApiException {
        return getRunePages(endpoint, region, key, Convert.longToString(summonerIds));
    }

    public static Map<String, Summoner> getSummonersByName(String endpoint, String region, String key, String summonerNames) throws RiotApiException {

        summonerNames = summonerNames.replaceAll("\\s+", "");
        String url = endpoint + "/api/lol/" + region + "/v1.4/summoner/by-name/" + summonerNames + "?api_key=" + key;
        Map<String, Summoner> summoners = null;

        try {
            summoners = new Gson().fromJson(Request.execute(url), new TypeToken<Map<String, Summoner>>() {
            }.getType());
        } catch (JsonSyntaxException e) {
            throw new RiotApiException(RiotApiException.PARSE_FAILURE);
        }

        return summoners;
    }

    public static Map<String, Summoner> getSummonersById(String endpoint, String region, String key, long... summonerIds) throws RiotApiException {
        return getSummonersByName(endpoint, region, key, Convert.longToString(summonerIds));
    }

    public static Map<String, Summoner> getSummonersById(String endpoint, String region, String key, String summonerIds) throws RiotApiException {

        String url = endpoint + "/api/lol/" + region + "/v1.4/summoner/" + summonerIds + "?api_key=" + key;
        Map<String, Summoner> summoners = null;

        try {
            summoners = new Gson().fromJson(Request.execute(url), new TypeToken<Map<String, Summoner>>() {
            }.getType());
        } catch (JsonSyntaxException e) {
            throw new RiotApiException(RiotApiException.PARSE_FAILURE);
        }

        return summoners;
    }

    public static Map<String, String> getSummonerNames(String endpoint, String region, String key, long... summonerIds) throws RiotApiException {
        return getSummonerNames(endpoint, region, key, Convert.longToString(summonerIds));
    }

    public static Map<String, String> getSummonerNames(String endpoint, String region, String key, String summonerIds) throws RiotApiException {

        String url = endpoint + "/api/lol/" + region + "/v1.4/summoner/" + summonerIds + "/name?api_key=" + key;
        Map<String, String> summonerNames = null;

        try {
            summonerNames = new Gson().fromJson(Request.execute(url), new TypeToken<Map<String, String>>() {
            }.getType());
        } catch (JsonSyntaxException e) {
            throw new RiotApiException(RiotApiException.PARSE_FAILURE);
        }

        return summonerNames;
    }

}
