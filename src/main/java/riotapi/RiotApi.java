package main.java.riotapi;

/**
 * Riot Games API Java Library
 * riot-api-java
 * by Taylor Caldwell - @rithms
 * http://rithms.im 
 */

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
import java.util.Map;

import constant.PlatformId;
import constant.QueueType;
import constant.Region;
import constant.Season;
import constant.staticdata.ChampData;
import constant.staticdata.ItemData;
import constant.staticdata.ItemListData;
import constant.staticdata.MasteryData;
import constant.staticdata.MasteryListData;
import constant.staticdata.RuneData;
import constant.staticdata.RuneListData;
import constant.staticdata.SpellData;
import dto.Champion.*;
import dto.CurrentGame.CurrentGameInfo;
import dto.FeaturedGames.FeaturedGames;
import dto.Game.RecentGames;
import dto.League.League;
import dto.Match.MatchDetail;
import dto.MatchHistory.PlayerHistory;
import dto.Team.Team;
import dto.Static.ChampionList;
import dto.Static.GameMapList;
import dto.Static.Item;
import dto.Static.ItemList;
import dto.Static.LanguageStrings;
import dto.Static.Mastery;
import dto.Static.MasteryList;
import dto.Static.Realm;
import dto.Static.Rune;
import dto.Static.RuneList;
import dto.Static.SummonerSpell;
import dto.Static.SummonerSpellList;
import dto.Stats.PlayerStatsSummaryList;
import dto.Stats.RankedStats;
import dto.Status.Shard;
import dto.Status.ShardStatus;
import dto.Summoner.MasteryPages;
import dto.Summoner.RunePages;
import dto.Summoner.Summoner;
import method.*;

public class RiotApi {

    /**
     * The base URL for all API requests
     */
    private String endpoint = Region.GLOBAL.getEndpoint();

    private Region region = Region.NA; // North American region default
    private Season season = null;
    private String key;

    public RiotApi() {
    }

    public RiotApi(String key) {
        this.setKey(key);
    }

    public RiotApi(String key, Region region) {
        this.setKey(key);
        this.setRegion(region);
    }

    /**
     * Get all the champions for a set region
     *
     * @return A list of all the champions for the set region
     * @see ChampionList
     * @throws RiotApiException
     */
    public dto.Champion.ChampionList getChampions() throws RiotApiException {

        return ChampionMethod.getChampions(getEndpoint(), getRegion(), getKey());
    }

    /**
     * Get all the champions for a given region
     *
     * @param region The desired region
     * @return A list of all the champions for the set region
     * @see ChampionList
     * @throws RiotApiException
     */
    public dto.Champion.ChampionList getChampions(Region region) throws RiotApiException {

        return ChampionMethod.getChampions(region.getEndpoint(), region.getName(), getKey());
    }

    /**
     * Get all the champions for a set region
     *
     * @param freeToPlay Only free to play
     * @return A list of all the free to play champions for the set region when
     * freeToPlay is true A list of all the champions for the set region when
     * freeToPlay is false
     * @see ChampionList
     * @throws RiotApiException
     */
    public dto.Champion.ChampionList getChampions(boolean freeToPlay) throws RiotApiException {

        return ChampionMethod.getChampions(getEndpoint(), getRegion(), getKey(), freeToPlay);
    }

    /**
     * Get all champions for a given region
     *
     * @param region The desired region
     * @param freeToPlay Only free to play
     * @return A list of all the free to play champions for the given region
     * when freeToPlay is true A list of all the champions for the given region
     * when freeToPlay is false
     * @see ChampionList
     * @throws RiotApiException
     */
    public dto.Champion.ChampionList getChampions(Region region, boolean freeToPlay) throws RiotApiException {

        return ChampionMethod.getChampions(region.getEndpoint(), region.getName(), getKey(), freeToPlay);
    }

    /**
     * Get all free to play champions for a given region
     *
     * @param region The desired region
     * @return A list of all the free to play champions for the given region
     * @see ChampionList
     * @throws RiotApiException
     */
    public dto.Champion.ChampionList getFreeToPlayChampions(Region region) throws RiotApiException {

        return ChampionMethod.getChampions(region.getEndpoint(), region.getName(), getKey(), true);
    }

    /**
     * Get all free to play champions for a set region
     *
     * @return A list of all the free to play champions for the set region
     * @see ChampionList
     * @throws RiotApiException
     */
    public dto.Champion.ChampionList getFreeToPlayChampions() throws RiotApiException {

        return ChampionMethod.getChampions(getEndpoint(), getRegion(), getKey(), true);
    }

    /**
     * Get a champion by id for a given region
     *
     * @param region The desired region
     * @param champId The ID of the desired champion
     * @return The champion of the given ID
     * @see ChampionList
     * @throws RiotApiException
     */
    public Champion getChampionById(Region region, int champId) throws RiotApiException {

        return ChampionMethod.getChampionById(region.getEndpoint(), region.getName(), getKey(), champId);
    }

    /**
     * Get a champion by id for a set region
     *
     * @param champId The ID of the desired champion
     * @return The champion of the given ID
     * @see ChampionList
     * @throws RiotApiException
     */
    public Champion getChampionById(int champId) throws RiotApiException {

        return ChampionMethod.getChampionById(getEndpoint(), getRegion(), getKey(), champId);
    }

    /**
     * Get recent games for a given summoner
     *
     * @param region The desired region
     * @param summonerId The ID of the desired summoner
     * @return Recent games of the given summoner
     * @see RecentGames
     * @throws RiotApiException
     */
    public RecentGames getRecentGames(Region region, long summonerId) throws RiotApiException {

        return GameMethod.getRecentGames(region.getEndpoint(), region.getName(), getKey(), summonerId);
    }

    /**
     * Get recent games for a given summoner
     *
     * @param summonerId The ID of the desired summoner
     * @return Recent games of the given summoner
     * @see RecentGames
     * @throws RiotApiException
     */
    public RecentGames getRecentGames(long summonerId) throws RiotApiException {

        return GameMethod.getRecentGames(getEndpoint(), getRegion(), getKey(), summonerId);
    }

    /**
     * 
     * @param region
     * @param summonerIds
     * @throws RiotApiException
     */
    public Map<String, List<League>> getLeagueBySummoners(Region region, long... summonerIds) throws RiotApiException {

        return LeagueMethod.getLeagueBySummoners(region.getEndpoint(), region.getName(), getKey(), summonerIds);
    }

    /**
     * 
     * @param summonerIds
     * @throws RiotApiException
     */
    public Map<String, List<League>> getLeagueBySummoners(long... summonerIds) throws RiotApiException {

        return LeagueMethod.getLeagueBySummoners(getEndpoint(), getRegion(), getKey(), summonerIds);
    }

    /**
     * 
     * @param region
     * @param summonerIds
     * @throws RiotApiException
     */
    public Map<String, List<League>> getLeagueEntryBySummoners(Region region, long... summonerIds) throws RiotApiException {

        return LeagueMethod.getLeagueEntryBySummoners(region.getEndpoint(), region.getName(), getKey(), summonerIds);
    }

    /**
     * 
     * @param summonerIds
     * @throws RiotApiException
     */
    public Map<String, List<League>> getLeagueEntryBySummoners(long... summonerIds) throws RiotApiException {

        return LeagueMethod.getLeagueEntryBySummoners(getEndpoint(), getRegion(), getKey(), summonerIds);
    }

    /**
     * 
     * @param region
     * @param summonerIds
     * @throws RiotApiException
     */
    public Map<String, List<League>> getLeagueBySummoners(Region region, String summonerIds) throws RiotApiException {

        return LeagueMethod.getLeagueBySummoners(region.getEndpoint(), region.getName(), getKey(), summonerIds);
    }

    /**
     * 
     * @param summonerIds
     * @throws RiotApiException
     */
    public Map<String, List<League>> getLeagueBySummoners(String summonerIds) throws RiotApiException {
        return LeagueMethod.getLeagueBySummoners(getEndpoint(), getRegion(), getKey(), summonerIds);
    }

    /**
     * 
     * @param region
     * @param summonerIds
     * @throws RiotApiException
     */
    public Map<String, List<League>> getLeagueEntryBySummoners(Region region, String summonerIds) throws RiotApiException {

        return LeagueMethod.getLeagueEntryBySummoners(region.getEndpoint(), region.getName(), getKey(), summonerIds);
    }

    /**
     * 
     * @param summonerIds
     * @throws RiotApiException
     */
    public Map<String, List<League>> getLeagueEntryBySummoners(String summonerIds) throws RiotApiException {

        return LeagueMethod.getLeagueEntryBySummoners(getEndpoint(), getRegion(), getKey(), summonerIds);
    }

    /**
     * @param region
     * @param teamIds
     * @throws RiotApiException
     */
    public Map<String, List<League>> getLeagueByTeams(Region region, long... teamIds) throws RiotApiException {

        return LeagueMethod.getLeagueByTeams(region.getEndpoint(), region.getName(), getKey(), teamIds);
    }

    /**
     * 
     * @param teamIds
     * @throws RiotApiException
     */
    public Map<String, List<League>> getLeagueByTeams(long... teamIds) throws RiotApiException {

        return LeagueMethod.getLeagueByTeams(getEndpoint(), getRegion(), getKey(), teamIds);
    }

    /**
     * 
     * @param region
     * @param teamIds
     * @throws RiotApiException
     */
    public Map<String, List<League>> getLeagueEntryByTeams(Region region, long... teamIds) throws RiotApiException {

        return LeagueMethod.getLeagueEntryByTeams(region.getEndpoint(), region.getName(), getKey(), teamIds);
    }

    /**
     * 
     * @param teamIds
     * @throws RiotApiException
     */
    public Map<String, List<League>> getLeagueEntryByTeams(long... teamIds) throws RiotApiException {

        return LeagueMethod.getLeagueEntryByTeams(getEndpoint(), getRegion(), getKey(), teamIds);
    }

    /**
     * 
     * @param region
     * @param teamIds
     * @throws RiotApiException
     */
    public Map<String, List<League>> getLeagueByTeams(Region region, String teamIds) throws RiotApiException {

        return LeagueMethod.getLeagueByTeams(region.getEndpoint(), region.getName(), getKey(), teamIds);
    }

    /**
     * 
     * @param teamIds
     * @throws RiotApiException
     */
    public Map<String, List<League>> getLeagueByTeams(String teamIds) throws RiotApiException {

        return LeagueMethod.getLeagueByTeams(getEndpoint(), getRegion(), getKey(), teamIds);
    }

    /**
     * 
     * @param region
     * @param teamIds
     * @throws RiotApiException
     */
    public Map<String, List<League>> getLeagueEntryByTeams(Region region, String teamIds) throws RiotApiException {

        return LeagueMethod.getLeagueEntryByTeams(region.getEndpoint(), region.getName(), getKey(), teamIds);
    }

    /**
     * 
     * @param teamIds
     * @throws RiotApiException
     */
    public Map<String, List<League>> getLeagueEntryByTeams(String teamIds) throws RiotApiException {

        return LeagueMethod.getLeagueEntryByTeams(getEndpoint(), getRegion(), getKey(), teamIds);
    }

    /**
     * 
     * @param region
     * @throws RiotApiException
     */
    public League getChallengerLeagues(Region region) throws RiotApiException {

        return LeagueMethod.getChallengerLeagues(region.getEndpoint(), region.getName(), getKey());
    }

    /**
     * 
     * @throws RiotApiException
     */
    public League getChallengerLeagues() throws RiotApiException {

        return LeagueMethod.getChallengerLeagues(getEndpoint(), getRegion(), getKey());
    }

    /**
     * 
     * @param region
     * @param queueType
     * @throws RiotApiException
     */
    public League getChallengerLeagues(Region region, QueueType queueType) throws RiotApiException {

        return LeagueMethod.getChallengerLeagues(region.getEndpoint(), region.getName(), getKey(), queueType);
    }

    /**
     * 
     * @param queueType
     * @throws RiotApiException
     * @return League
     */
    public League getChallengerLeagues(QueueType queueType) throws RiotApiException {

        return LeagueMethod.getChallengerLeagues(getEndpoint(), getRegion(), getKey(), queueType);
    }

    /**
     * Get a summary of player statistics for a given summoner
     *
     * @param region The desired region
     * @param summonerId The ID of the desired summoner
     * @param season The desired season
     * @return A summary of player statistics for the given summoner
     * @see PlayerStatsSummaryList
     * @throws RiotApiException
     */
    public PlayerStatsSummaryList getPlayerStatsSummary(Region region, Season season, long summonerId) throws RiotApiException {

        return StatsMethod.getPlayerStatsSummary(region.getEndpoint(), region.getName(), season.getName(), getKey(), summonerId);
    }

    /**
     * Get a summary of player statistics for a given summoner
     *
     * @param summonerId The ID of the desired summoner
     * @param season The desired season
     * @return A summary of player statistics for the given summoner
     * @see PlayerStatsSummaryList
     * @throws RiotApiException
     */
    public PlayerStatsSummaryList getPlayerStatsSummary(Season season, long summonerId) throws RiotApiException {

        return StatsMethod.getPlayerStatsSummary(getEndpoint(), getRegion(), season.getName(), getKey(), summonerId);
    }

    /**
     * Get a summary of player statistics for a given summoner
     *
     * @param region The desired region
     * @param summonerId The ID of the desired summoner
     * @return A summary of player statistics for the given summoner
     * @see PlayerStatsSummaryList
     * @throws RiotApiException
     */
    public PlayerStatsSummaryList getPlayerStatsSummary(Region region, long summonerId) throws RiotApiException {

        return StatsMethod.getPlayerStatsSummary(region.getEndpoint(), region.getName(), getSeason(), getKey(), summonerId);
    }

    /**
     * Get a summary of player statistics for a given summoner
     *
     * @param summonerId The ID of the desired summoner
     * @return A summary of player statistics for the given summoner
     * @see PlayerStatsSummaryList
     * @throws RiotApiException
     */
    public PlayerStatsSummaryList getPlayerStatsSummary(long summonerId) throws RiotApiException {

        return StatsMethod.getPlayerStatsSummary(getEndpoint(), getRegion(), getSeason(), getKey(), summonerId);
    }

    /**
     * Get the ranked statistics of a given summoner
     *
     * @param region The desired region
     * @param summonerId The ID of the desired summoner
     * @param season The desired season
     * @return Ranked statistics of the given summoner
     * @see RankedStats
     * @throws RiotApiException
     */
    public RankedStats getRankedStats(Region region, Season season, long summonerId) throws RiotApiException {

        return StatsMethod.getRankedStats(region.getEndpoint(), region.getName(), season.getName(), getKey(), summonerId);
    }

    /**
     * Get the ranked statistics of a given summoner
     *
     * @param summonerId The ID of the desired summoner
     * @param season The desired season
     * @return Ranked statistics of the given summoner
     * @see RankedStats
     * @throws RiotApiException
     */
    public RankedStats getRankedStats(Season season, long summonerId) throws RiotApiException {

        return StatsMethod.getRankedStats(getEndpoint(), getRegion(), season.getName(), getKey(), summonerId);
    }

    /**
     * Get the ranked statistics of a given summoner
     *
     * @param region The desired region
     * @param summonerId The ID of the desired summoner
     * @return Ranked statistics of the given summoner
     * @see RankedStats
     * @throws RiotApiException
     */
    public RankedStats getRankedStats(Region region, long summonerId) throws RiotApiException {

        return StatsMethod.getRankedStats(region.getEndpoint(), region.getName(), getSeason(), getKey(), summonerId);
    }

    /**
     * Get the ranked statistics of a given summoner
     *
     * @param summonerId The ID of the desired summoner
     * @return Ranked statistics of the given summoner
     * @see RankedStats
     * @throws RiotApiException
     */
    public RankedStats getRankedStats(long summonerId) throws RiotApiException {

        return StatsMethod.getRankedStats(getEndpoint(), getRegion(), getSeason(), getKey(), summonerId);
    }

    /**
     * Get the mastery pages of a given summoner
     *
     * @param region The desired region
     * @param summonerIds The IDs of the desired summoners
     * @return A map of mastery pages of the given summoners
     * @see MasteryPages
     * @throws RiotApiException
     */
    public Map<String, MasteryPages> getMasteryPages(Region region, String summonerIds) throws RiotApiException {

        return SummonerMethod.getMasteryPages(region.getEndpoint(), region.getName(), getKey(), summonerIds);
    }

    /**
     * Get the mastery pages of a given summoner
     *
     * @param summonerIds The IDs of the desired summoners
     * @return A map of mastery pages of the given summoners
     * @see MasteryPages
     * @throws RiotApiException
     */
    public Map<String, MasteryPages> getMasteryPages(String summonerIds) throws RiotApiException {

        return SummonerMethod.getMasteryPages(getEndpoint(), getRegion(), getKey(), summonerIds);
    }

    /**
     * Get the mastery pages of a given summoner
     *
     * @param region The desired region
     * @param summonerIds The IDs of the desired summoners
     * @return A map of mastery pages of the given summoners
     * @see MasteryPages
     * @throws RiotApiException
     */
    public Map<String, MasteryPages> getMasteryPages(Region region, long... summonerIds) throws RiotApiException {

        return SummonerMethod.getMasteryPages(region.getEndpoint(), region.getName(), getKey(), summonerIds);
    }

    /**
     * Get the mastery pages of a given summoner
     *
     * @param summonerIds The IDs of the desired summoners
     * @return A map of mastery pages of the given summoners
     * @see MasteryPages
     * @throws RiotApiException
     */
    public Map<String, MasteryPages> getMasteryPages(long... summonerIds) throws RiotApiException {

        return SummonerMethod.getMasteryPages(getEndpoint(), getRegion(), getKey(), summonerIds);
    }

    /**
     * Get the rune pages of a given summoner
     *
     * @param region The desired region
     * @param summonerIds The IDs of the desired summoners
     * @return A map of rune pages of the given summoners
     * @see RunePages
     * @throws RiotApiException
     */
    public Map<String, RunePages> getRunePages(Region region, String summonerIds) throws RiotApiException {

        return SummonerMethod.getRunePages(region.getEndpoint(), region.getName(), getKey(), summonerIds);
    }

    /**
     * Get the rune pages of a given summoner
     *
     * @param summonerIds The IDs of the desired summoners
     * @return A map of rune pages of the given summoners
     * @see RunePages
     * @throws RiotApiException
     */
    public Map<String, RunePages> getRunePages(String summonerIds) throws RiotApiException {

        return SummonerMethod.getRunePages(getEndpoint(), getRegion(), getKey(), summonerIds);
    }

    /**
     * Get the rune pages of a given summoner
     *
     * @param region The desired region
     * @param summonerIds The IDs of the desired summoners
     * @return A map of rune pages of the given summoners
     * @see RunePages
     * @throws RiotApiException
     */
    public Map<String, RunePages> getRunePages(Region region, long... summonerIds) throws RiotApiException {

        return SummonerMethod.getRunePages(region.getEndpoint(), region.getName(), getKey(), summonerIds);
    }

    /**
     * Get the rune pages of a given summoner
     *
     * @param summonerIds The IDs of the desired summoners
     * @return A map of rune pages of the given summoners
     * @see RunePages
     * @throws RiotApiException
     */
    public Map<String, RunePages> getRunePages(long... summonerIds) throws RiotApiException {

        return SummonerMethod.getRunePages(getEndpoint(), getRegion(), getKey(), summonerIds);
    }

    /**
     * Get summoners by names
     *
     * @param region The desired region
     * @param summonerNames The names of the desired summoners
     * @return A map of desired summoners
     * @see Summoner
     * @throws RiotApiException
     */
    public Map<String, Summoner> getSummonersByName(Region region, String summonerNames) throws RiotApiException {

        return SummonerMethod.getSummonersByName(region.getEndpoint(), region.getName(), getKey(), summonerNames);
    }

    /**
     * Get summoners by names
     *
     * @param summonerNames The names of the desired summoners
     * @return A map of desired summoners
     * @see Summoner
     * @throws RiotApiException
     */
    public Map<String, Summoner> getSummonersByName(String summonerNames) throws RiotApiException {

        return SummonerMethod.getSummonersByName(getEndpoint(), getRegion(), getKey(), summonerNames);
    }

    /**
     * Get summoner by name
     *
     * @param region The desired region
     * @param summonerName The name of the desired summoner
     * @return A map of desired summoners
     * @see Summoner
     * @throws RiotApiException
     */
    public Map<String, Summoner> getSummonerByName(Region region, String summonerName) throws RiotApiException {

        return SummonerMethod.getSummonersByName(region.getEndpoint(), region.getName(), getKey(), summonerName);
    }

    /**
     * Get summoner by name
     *
     * @param summonerName The name of the desired summoner
     * @return A map of desired summoners
     * @see Summoner
     * @throws RiotApiException
     */
    public Map<String, Summoner> getSummonerByName(String summonerName) throws RiotApiException {

        return SummonerMethod.getSummonersByName(getEndpoint(), getRegion(), getKey(), summonerName);
    }

    /**
     * Get summoners by names
     *
     * @param region The desired region
     * @param summonerIds The IDs of the desired summoners
     * @return A map of desired summoners
     * @see Summoner
     * @throws RiotApiException
     */
    public Map<String, Summoner> getSummonersById(Region region, long... summonerIds) throws RiotApiException {

        return SummonerMethod.getSummonersById(region.getEndpoint(), region.getName(), getKey(), summonerIds);
    }

    /**
     * Get summoners by names
     *
     * @param summonerIds The IDs of the desired summoners
     * @return A map of desired summoners
     * @see Summoner
     * @throws RiotApiException
     */
    public Map<String, Summoner> getSummonersById(long... summonerIds) throws RiotApiException {

        return SummonerMethod.getSummonersById(getEndpoint(), getRegion(), getKey(), summonerIds);
    }

    /**
     * Get summoners by names
     *
     * @param region The desired region
     * @param summonerIds The IDs of the desired summoners
     * @return A map of desired summoners
     * @see Summoner
     * @throws RiotApiException
     */
    public Map<String, Summoner> getSummonersById(Region region, String summonerIds) throws RiotApiException {

        return SummonerMethod.getSummonersById(region.getEndpoint(), region.getName(), getKey(), summonerIds);
    }

    /**
     * Get summoners by names
     *
     * @param summonerIds The IDs of the desired summoners
     * @return A map of desired summoners
     * @see Summoner
     * @throws RiotApiException
     */
    public Map<String, Summoner> getSummonersById(String summonerIds) throws RiotApiException {

        return SummonerMethod.getSummonersById(getEndpoint(), getRegion(), getKey(), summonerIds);
    }

    /**
     * Get summoners by names
     *
     * @param region The desired region
     * @param summonerId The ID of the desired summoner
     * @return A map of desired summoners
     * @see Summoner
     * @throws RiotApiException
     */
    public Map<String, Summoner> getSummonerById(Region region, long summonerId) throws RiotApiException {

        return SummonerMethod.getSummonersById(region.getEndpoint(), region.getName(), getKey(), summonerId);
    }

    /**
     * Get summoners by names
     *
     * @param summonerId The IDs of the desired summoners
     * @return A map of desired summoners
     * @see Summoner
     * @throws RiotApiException
     */
    public Map<String, Summoner> getSummonerById(long summonerId) throws RiotApiException {

        return SummonerMethod.getSummonersById(getEndpoint(), getRegion(), getKey(), summonerId);
    }

    /**
     * Get summoners by names
     *
     * @param region The desired region
     * @param summonerId The IDs of the desired summoners
     * @return A map of desired summoners
     * @see Summoner
     * @throws RiotApiException
     */
    public Map<String, Summoner> getSummonerById(Region region, String summonerId) throws RiotApiException {

        return SummonerMethod.getSummonersById(region.getEndpoint(), region.getName(), getKey(), summonerId);
    }

    /**
     * Get summoners by names
     *
     * @param summonerId The IDs of the desired summoners
     * @return A map of desired summoners
     * @see Summoner
     * @throws RiotApiException
     */
    public Map<String, Summoner> getSummonerById(String summonerId) throws RiotApiException {

        return SummonerMethod.getSummonersById(getEndpoint(), getRegion(), getKey(), summonerId);
    }

    /**
     * Get summoner names by IDs
     *
     * @param region The desired region
     * @param summonerIds The IDs of the desired summoners
     * @return A map of desired summoner names
     * @throws RiotApiException
     */
    public Map<String, String> getSummonerNames(Region region, long... summonerIds) throws RiotApiException {

        return SummonerMethod.getSummonerNames(region.getEndpoint(), region.getName(), getKey(), summonerIds);
    }

    /**
     * Get summoner names by IDs
     *
     * @param summonerIds The IDs of the desired summoners
     * @return A map of desired summoner names
     * @throws RiotApiException
     */
    public Map<String, String> getSummonerNames(long... summonerIds) throws RiotApiException {

        return SummonerMethod.getSummonerNames(getEndpoint(), getRegion(), getKey(), summonerIds);
    }

    /**
     * Get summoner names by IDs
     *
     * @param region The desired region
     * @param summonerIds A comma separated list of IDs of the desired summoners
     * @return A map of desired summoner names
     * @throws RiotApiException
     */
    public Map<String, String> getSummonerNames(Region region, String summonerIds) throws RiotApiException {

        return SummonerMethod.getSummonerNames(region.getEndpoint(), region.getName(), getKey(), summonerIds);
    }

    /**
     * Get summoner names by IDs
     *
     * @param summonerIds A comma separated list of IDs of the desired summoners
     * @return A map of desired summoner names
     * @throws RiotApiException
     */
    public Map<String, String> getSummonerNames(String summonerIds) throws RiotApiException {

        return SummonerMethod.getSummonerNames(getEndpoint(), getRegion(), getKey(), summonerIds);
    }

    /**
     * Get summoner names by IDs
     *
     * @param region The desired region
     * @param summonerId The IDs of the desired summoner
     * @return A map of desired summoner names
     * @throws RiotApiException
     */
    public Map<String, String> getSummonerName(Region region, long summonerId) throws RiotApiException {

        return SummonerMethod.getSummonerNames(region.getEndpoint(), region.getName(), getKey(), summonerId);
    }

    /**
     * Get summoner names by IDs
     *
     * @param summonerId The IDs of the desired summoner
     * @return A map of desired summoner names
     * @throws RiotApiException
     */
    public Map<String, String> getSummonerName(long summonerId) throws RiotApiException {

        return SummonerMethod.getSummonerNames(getEndpoint(), getRegion(), getKey(), summonerId);
    }

    /**
     * Get summoner names by IDs
     *
     * @param region The desired region
     * @param summonerId The ID of the desired summoner
     * @return A map of desired summoner names
     * @throws RiotApiException
     */
    public Map<String, String> getSummonerName(Region region, String summonerId) throws RiotApiException {

        return SummonerMethod.getSummonerNames(region.getEndpoint(), region.getName(), getKey(), summonerId);
    }

    /**
     * Get summoner names by IDs
     *
     * @param summonerId The ID of the desired summoner
     * @return A map of desired summoner names
     * @throws RiotApiException
     */
    public Map<String, String> getSummonerName(String summonerId) throws RiotApiException {

        return SummonerMethod.getSummonerNames(getEndpoint(), getRegion(), getKey(), summonerId);
    }

    /**
     * Get teams by summonerIDs
     *
     * @param region The desired region
     * @param summonerIds A list of summoner IDs
     * @return A map of the summoners' teams
     * @see Team
     * @throws RiotApiException
     */
    public Map<String, List<Team>> getTeamsBySummonerIds(Region region, long... summonerIds) throws RiotApiException {

        return TeamMethod.getTeamsBySummonerIds(region.getEndpoint(), region.getName(), getKey(), summonerIds);
    }

    /**
     * Get teams by summonerIDs
     *
     * @param summonerIds A list of summoner IDs
     * @return A map of the summoners' teams
     * @see Team
     * @throws RiotApiException
     */
    public Map<String, List<Team>> getTeamsBySummonerIds(long... summonerIds) throws RiotApiException {

        return TeamMethod.getTeamsBySummonerIds(getEndpoint(), getRegion(), getKey(), summonerIds);
    }

    /**
     * Get teams by summonerIDs
     *
     * @param region The desired region
     * @param summonerIds Comma-separated list of summoner IDs
     * @return A map of the summoners' teams
     * @see Team
     * @throws RiotApiException
     */
    public Map<String, List<Team>> getTeamsBySummonerIds(Region region, String summonerIds) throws RiotApiException {

        return TeamMethod.getTeamsBySummonerIds(region.getEndpoint(), region.getName(), getKey(), summonerIds);
    }

    /**
     * Get teams by summonerIDs
     *
     * @param summonerIds Comma-separated list of summoner IDs
     * @return A map of the summoners' teams
     * @see Team
     * @throws RiotApiException
     */
    public Map<String, List<Team>> getTeamsBySummonerIds(String summonerIds) throws RiotApiException {

        return TeamMethod.getTeamsBySummonerIds(getEndpoint(), getRegion(), getKey(), summonerIds);
    }

    /**
     * Get match by ID
     *
     * @param region The desired region
     * @param matchId The ID of the match
     * @return A map with match details
     * @see MatchDetail
     * @throws RiotApiException
     */
    public MatchDetail getMatch(Region region, long matchId) throws RiotApiException {

        return MatchMethod.getMatch(region.getEndpoint(), region.getName(), getKey(), matchId);
    }

    /**
     * Get match by ID
     *
     * @param matchId The ID of the match
     * @return A map with match details
     * @see MatchDetail
     * @throws RiotApiException
     */
    public MatchDetail getMatch(long matchId) throws RiotApiException {

        return MatchMethod.getMatch(getEndpoint(), getRegion(), getKey(), matchId);
    }

    /**
     * Get match by ID
     *
     * @param region The desired region
     * @param matchId The ID of the match
     * @param includeTimeline Flag indicating whether or not to include match timeline data
     * @return A map with match details
     * @see MatchDetail
     * @throws RiotApiException
     */
    public MatchDetail getMatch(Region region, long matchId, boolean includeTimeline) throws RiotApiException {

        return MatchMethod.getMatch(region.getEndpoint(), region.getName(), getKey(), matchId, includeTimeline);
    }

    /**
     * Get match by ID
     *
     * @param matchId The ID of the match
     * @param includeTimeline Flag indicating whether or not to include match timeline data
     * @return A map with match details
     * @see MatchDetail
     * @throws RiotApiException
     */
    public MatchDetail getMatch(long matchId, boolean includeTimeline) throws RiotApiException {

        return MatchMethod.getMatch(getEndpoint(), getRegion(), getKey(), matchId, includeTimeline);
    }

    /**
     * Get match history by summonerID
     *
     * @param region The desired region
     * @param summonerId The ID of the desired summoner
     * @param championIds Comma-separated list of champion IDs to use for fetching games.
     * @param rankedQueues Comma-separated list of ranked queue types to use for fetching games
     * @param beginIndex The begin index to use for fetching games
     * @param endIndex The end index to use for fetching games
     * @return A list with matches
     * @see PlayerHistory
     * @throws RiotApiException
     */
    public PlayerHistory getMatchHistory(Region region, long summonerId, String championIds, String rankedQueues, int beginIndex, int endIndex) throws RiotApiException {

        return MatchHistoryMethod.getMatchHistory(region.getEndpoint(), region.getName(), getKey(), summonerId, championIds, rankedQueues, beginIndex, endIndex);
    }

    /**
     * Get match history by summonerID
     *
     * @param region The desired region
     * @param summonerId The ID of the desired summoner
     * @param championIds Comma-separated list of champion IDs to use for fetching games.
     * @param rankedQueues Comma-separated list of ranked queue types to use for fetching games
     * @param beginIndex The begin index to use for fetching games
     * @return A list with matches
     * @see PlayerHistory
     * @throws RiotApiException
     */
    public PlayerHistory getMatchHistory(Region region, long summonerId, String championIds, String rankedQueues, int beginIndex) throws RiotApiException {

        return MatchHistoryMethod.getMatchHistory(region.getEndpoint(), region.getName(), getKey(), summonerId, championIds, rankedQueues, beginIndex, -1);
    }

    /**
     * Get match history by summonerID
     *
     * @param region The desired region
     * @param summonerId The ID of the desired summoner
     * @param championIds Comma-separated list of champion IDs to use for fetching games.
     * @param rankedQueues Comma-separated list of ranked queue types to use for fetching games
     * @return A list with matches
     * @see PlayerHistory
     * @throws RiotApiException
     */
    public PlayerHistory getMatchHistory(Region region, long summonerId, String championIds, String rankedQueues) throws RiotApiException {

        return MatchHistoryMethod.getMatchHistory(region.getEndpoint(), region.getName(), getKey(), summonerId, championIds, rankedQueues, -1, -1);
    }
    
    /**
     * Get match history by summonerID
     *
     * @param region The desired region
     * @param summonerId The ID of the desired summoner
     * @param rankedQueues Comma-separated list of ranked queue types to use for fetching games
     * @param beginIndex The begin index to use for fetching games
     * @param endIndex The end index to use for fetching games
     * @return A list with matches
     * @see PlayerHistory
     * @throws RiotApiException
     */
   public PlayerHistory getMatchHistory(Region region, long summonerId, String rankedQueues, int beginIndex, int endIndex) throws RiotApiException {

       return MatchHistoryMethod.getMatchHistory(region.getEndpoint(), region.getName(), getKey(), summonerId, null, rankedQueues, beginIndex, endIndex);
   }
   
   /**
    * Get match history by summonerID
    *
    * @param region The desired region
    * @param summonerId The ID of the desired summoner
    * @param rankedQueues Comma-separated list of ranked queue types to use for fetching games
    * @param beginIndex The begin index to use for fetching games
    * @return A list with matches
    * @see PlayerHistory
    * @throws RiotApiException
    */
  public PlayerHistory getMatchHistory(Region region, long summonerId, String rankedQueues, int beginIndex) throws RiotApiException {

      return MatchHistoryMethod.getMatchHistory(region.getEndpoint(), region.getName(), getKey(), summonerId, null, rankedQueues, beginIndex, -1);
  }

   /**
    * Get match history by summonerID
    *
    * @param region The desired region
    * @param summonerId The ID of the desired summoner
    * @param beginIndex The begin index to use for fetching games
    * @param endIndex The end index to use for fetching games
    * @return A list with matches
    * @see PlayerHistory
    * @throws RiotApiException
    */
   public PlayerHistory getMatchHistory(Region region, long summonerId, int beginIndex, int endIndex) throws RiotApiException {

       return MatchHistoryMethod.getMatchHistory(region.getEndpoint(), region.getName(), getKey(), summonerId, null, null, beginIndex, endIndex);
   }

   /**
    * Get match history by summonerID
    *
    * @param region The desired region
    * @param summonerId The ID of the desired summoner
    * @param beginIndex The begin index to use for fetching games
    * @return A list with matches
    * @see PlayerHistory
    * @throws RiotApiException
    */
   public PlayerHistory getMatchHistory(Region region, long summonerId, int beginIndex) throws RiotApiException {

       return MatchHistoryMethod.getMatchHistory(region.getEndpoint(), region.getName(), getKey(), summonerId, null, null, beginIndex, -1);
   }

   /**
    * Get match history by summonerID
    *
    * @param region The desired region
    * @param summonerId The ID of the desired summoner
    * @return A list with matches
    * @see PlayerHistory
    * @throws RiotApiException
    */
    public PlayerHistory getMatchHistory(Region region, long summonerId) throws RiotApiException {

        return MatchHistoryMethod.getMatchHistory(region.getEndpoint(), region.getName(), getKey(), summonerId, null, null, -1, -1);
    }

    /**
     * Get match history by summonerID
     *
     * @param summonerId The ID of the desired summoner
     * @param championIds Comma-separated list of champion IDs to use for fetching games.
     * @param rankedQueues Comma-separated list of ranked queue types to use for fetching games
     * @param beginIndex The begin index to use for fetching games
     * @param endIndex The end index to use for fetching games
     * @return A list with matches
     * @see PlayerHistory
     * @throws RiotApiException
     */
    public PlayerHistory getMatchHistory(long summonerId, String championIds, String rankedQueues, int beginIndex, int endIndex) throws RiotApiException {

        return MatchHistoryMethod.getMatchHistory(getEndpoint(), getRegion(), getKey(), summonerId, championIds, rankedQueues, beginIndex, endIndex);
    }

    /**
     * Get match history by summonerID
     *
     * @param summonerId The ID of the desired summoner
     * @param championIds Comma-separated list of champion IDs to use for fetching games.
     * @param rankedQueues Comma-separated list of ranked queue types to use for fetching games
     * @param beginIndex The begin index to use for fetching games
     * @return A list with matches
     * @see PlayerHistory
     * @throws RiotApiException
     */
    public PlayerHistory getMatchHistory(long summonerId, String championIds, String rankedQueues, int beginIndex) throws RiotApiException {

        return MatchHistoryMethod.getMatchHistory(getEndpoint(), getRegion(), getKey(), summonerId, championIds, rankedQueues, beginIndex, -1);
    }

    /**
     * Get match history by summonerID
     *
     * @param summonerId The ID of the desired summoner
     * @param championIds Comma-separated list of champion IDs to use for fetching games.
     * @param rankedQueues Comma-separated list of ranked queue types to use for fetching games
     * @return A list with matches
     * @see PlayerHistory
     * @throws RiotApiException
     */
    public PlayerHistory getMatchHistory(long summonerId, String championIds, String rankedQueues) throws RiotApiException {

        return MatchHistoryMethod.getMatchHistory(getEndpoint(), getRegion(), getKey(), summonerId, championIds, rankedQueues, -1, -1);
    }

    /**
     * Get match history by summonerID
     *
     * @param summonerId The ID of the desired summoner
     * @param rankedQueues Comma-separated list of ranked queue types to use for fetching games
     * @param beginIndex The begin index to use for fetching games
     * @param endIndex The end index to use for fetching games
     * @return A list with matches
     * @see PlayerHistory
     * @throws RiotApiException
     */
    public PlayerHistory getMatchHistory(long summonerId, String rankedQueues, int beginIndex, int endIndex) throws RiotApiException {

        return MatchHistoryMethod.getMatchHistory(getEndpoint(), getRegion(), getKey(), summonerId, null, rankedQueues, beginIndex, endIndex);
    }

    /**
     * Get match history by summonerID
     *
     * @param summonerId The ID of the desired summoner
     * @param rankedQueues Comma-separated list of ranked queue types to use for fetching games
     * @param beginIndex The begin index to use for fetching games
     * @return A list with matches
     * @see PlayerHistory
     * @throws RiotApiException
     */
    public PlayerHistory getMatchHistory(long summonerId, String rankedQueues, int beginIndex) throws RiotApiException {

        return MatchHistoryMethod.getMatchHistory(getEndpoint(), getRegion(), getKey(), summonerId, null, rankedQueues, beginIndex, -1);
    }

    /**
     * Get match history by summonerID
     *
     * @param summonerId The ID of the desired summoner
     * @param beginIndex The begin index to use for fetching games
     * @param endIndex The end index to use for fetching games
     * @return A list with matches
     * @see PlayerHistory
     * @throws RiotApiException
     */
    public PlayerHistory getMatchHistory(long summonerId, int beginIndex, int endIndex) throws RiotApiException {

        return MatchHistoryMethod.getMatchHistory(getEndpoint(), getRegion(), getKey(), summonerId, null, null, beginIndex, endIndex);
    }

    /**
     * Get match history by summonerID
     *
     * @param summonerId The ID of the desired summoner
     * @param beginIndex The begin index to use for fetching games
     * @return A list with matches
     * @see PlayerHistory
     * @throws RiotApiException
     */
    public PlayerHistory getMatchHistory(long summonerId, int beginIndex) throws RiotApiException {

        return MatchHistoryMethod.getMatchHistory(getEndpoint(), getRegion(), getKey(), summonerId, null, null, beginIndex, -1);
    }

    /**
     * Get match history by summonerID
     *
     * @param summonerId The ID of the desired summoner
     * @return A list with matches
     * @see PlayerHistory
     * @throws RiotApiException
     */
    public PlayerHistory getMatchHistory(long summonerId) throws RiotApiException {

        return MatchHistoryMethod.getMatchHistory(getEndpoint(), getRegion(), getKey(), summonerId, null, null, -1, -1);
    }

    /**
     *
     */
    public ChampionList getDataChampionList(Region region, String locale, String version, boolean dataById, ChampData... champData) throws RiotApiException {

        return StaticDataMethod.getDataChampionList(region.getName(), getKey(), locale, version, dataById, champData);
    }

    /**
     *
     */
    public ChampionList getDataChampionList(String locale, String version, boolean dataById, ChampData... champData) throws RiotApiException {

        return StaticDataMethod.getDataChampionList(getRegion(), getKey(), locale, version, dataById, champData);
    }

    /**
     *
     */
    public ChampionList getDataChampionList(Region region) throws RiotApiException {

        return StaticDataMethod.getDataChampionList(region.getName(), getKey(), null, null, false, (ChampData) null);
    }

    /**
     *
     */
    public ChampionList getDataChampionList() throws RiotApiException {

        return StaticDataMethod.getDataChampionList(getRegion(), getKey(), null, null, false, (ChampData) null);
    }

    /**
     *
     */
    public dto.Static.Champion getDataChampion(Region region, int id, String locale, String version, boolean dataById, ChampData... champData) throws RiotApiException {

        return StaticDataMethod.getDataChampion(region.getName(), getKey(), id, locale, version, dataById, champData);
    }

    /**
     *
     */
    public dto.Static.Champion getDataChampion(int id, String locale, String version, boolean dataById, ChampData... champData) throws RiotApiException {

        return StaticDataMethod.getDataChampion(getRegion(), getKey(), id, locale, version, dataById, champData);
    }

    /**
     *
     */
    public dto.Static.Champion getDataChampion(Region region, int id) throws RiotApiException {

        return StaticDataMethod.getDataChampion(region.getName(), getKey(), id, null, null, false, (ChampData) null);
    }

    /**
     *
     */
    public dto.Static.Champion getDataChampion(int id) throws RiotApiException {

        return StaticDataMethod.getDataChampion(getRegion(), getKey(), id, null, null, false, (ChampData) null);
    }

    /**
     *
     */
    public ItemList getDataItemList(Region region, String locale, String version, ItemListData... itemListData) throws RiotApiException {

        return StaticDataMethod.getDataItemList(region.getName(), getKey(), locale, version, itemListData);
    }

    /**
     *
     */
    public ItemList getDataItemList(String locale, String version, ItemListData... itemListData) throws RiotApiException {

        return StaticDataMethod.getDataItemList(getRegion(), getKey(), locale, version, itemListData);
    }

    /**
     *
     */
    public ItemList getDataItemList(Region region) throws RiotApiException {

        return StaticDataMethod.getDataItemList(region.getName(), getKey(), null, null, (ItemListData) null);
    }

    /**
     *
     */
    public ItemList getDataItemList() throws RiotApiException {

        return StaticDataMethod.getDataItemList(getRegion(), getKey(), null, null, (ItemListData) null);
    }

    /**
     *
     */
    public Item getDataItem(Region region, int id, String locale, String version, ItemData... itemData) throws RiotApiException {

        return StaticDataMethod.getDataItem(region.getName(), getKey(), id, locale, version, itemData);
    }

    /**
     *
     */
    public Item getDataItem(int id, String locale, String version, ItemData... itemData) throws RiotApiException {

        return StaticDataMethod.getDataItem(getRegion(), getKey(), id, locale, version, itemData);
    }

    /**
     *
     */
    public Item getDataItem(Region region, int id) throws RiotApiException {

        return StaticDataMethod.getDataItem(region.getName(), getKey(), id, null, null, (ItemData) null);
    }

    /**
     *
     */
    public Item getDataItem(int id) throws RiotApiException {

        return StaticDataMethod.getDataItem(getRegion(), getKey(), id, null, null, (ItemData) null);
    }

    /**
     *
     */
    public Realm getDataRealm(Region region) throws RiotApiException {

        return StaticDataMethod.getDataRealm(region.getName(), getKey());
    }

    /**
     *
     */
    public Realm getDataRealm() throws RiotApiException {

        return StaticDataMethod.getDataRealm(getRegion(), getKey());
    }

    /**
     *
     */
    public RuneList getDataRuneList(Region region, String locale, String version, RuneListData... runeListData) throws RiotApiException {

        return StaticDataMethod.getDataRuneList(region.getName(), getKey(), locale, version, runeListData);
    }

    /**
     *
     */
    public RuneList getDataRuneList(String locale, String version, RuneListData... runeListData) throws RiotApiException {

        return StaticDataMethod.getDataRuneList(getRegion(), getKey(), locale, version, runeListData);
    }

    /**
     *
     */
    public RuneList getDataRuneList(Region region) throws RiotApiException {

        return StaticDataMethod.getDataRuneList(region.getName(), getKey(), null, null, (RuneListData) null);
    }

    /**
     *
     */
    public RuneList getDataRuneList() throws RiotApiException {

        return StaticDataMethod.getDataRuneList(getRegion(), getKey(), null, null, (RuneListData) null);
    }

    /**
     *
     */
    public Rune getDataRune(Region region, int id, String locale, String version, RuneData... runeData) throws RiotApiException {

        return StaticDataMethod.getDataRune(region.getName(), getKey(), id, locale, version, runeData);
    }

    /**
     *
     */
    public Rune getDataRune(int id, String locale, String version, RuneData... runeData) throws RiotApiException {

        return StaticDataMethod.getDataRune(getRegion(), getKey(), id, locale, version, runeData);
    }

    /**
     *
     */
    public Rune getDataRune(Region region, int id) throws RiotApiException {

        return StaticDataMethod.getDataRune(region.getName(), getKey(), id, null, null, (RuneData) null);
    }

    /**
     *
     */
    public Rune getDataRune(int id) throws RiotApiException {

        return StaticDataMethod.getDataRune(getRegion(), getKey(), id, null, null, (RuneData) null);
    }

    /**
     *
     */
    public MasteryList getDataMasteryList(Region region, String locale, String version, MasteryListData... masteryListData) throws RiotApiException {

        return StaticDataMethod.getDataMasteryList(region.getName(), getKey(), locale, version, masteryListData);
    }

    /**
     *
     */
    public MasteryList getDataMasteryList(String locale, String version, MasteryListData... masteryListData) throws RiotApiException {

        return StaticDataMethod.getDataMasteryList(getRegion(), getKey(), locale, version, masteryListData);
    }

    /**
     *
     */
    public MasteryList getDataMasteryList(Region region) throws RiotApiException {

        return StaticDataMethod.getDataMasteryList(region.getName(), getKey(), null, null, (MasteryListData) null);
    }

    /**
     *
     */
    public MasteryList getDataMasteryList() throws RiotApiException {

        return StaticDataMethod.getDataMasteryList(getRegion(), getKey(), null, null, (MasteryListData) null);
    }

    /**
     *
     */
    public Mastery getDataMastery(Region region, int id, String locale, String version, MasteryData... masteryData) throws RiotApiException {

        return StaticDataMethod.getDataMastery(region.getName(), getKey(), id, locale, version, masteryData);
    }

    /**
     *
     */
    public Mastery getDataMastery(int id, String locale, String version, MasteryData... masteryData) throws RiotApiException {

        return StaticDataMethod.getDataMastery(getRegion(), getKey(), id, locale, version, masteryData);
    }

    /**
     *
     */
    public Mastery getDataMastery(Region region, int id) throws RiotApiException {

        return StaticDataMethod.getDataMastery(region.getName(), getKey(), id, null, null, (MasteryData) null);
    }

    /**
     *
     */
    public Mastery getDataMastery(int id) throws RiotApiException {

        return StaticDataMethod.getDataMastery(getRegion(), getKey(), id, null, null, (MasteryData) null);
    }

    /**
     *
     */
    public SummonerSpellList getDataSummonerSpellList(Region region, String locale, String version, boolean dataById, SpellData... spellData) throws RiotApiException {

        return StaticDataMethod.getDataSummonerSpellList(region.getName(), getKey(), locale, version, dataById, spellData);
    }

    /**
     *
     */
    public SummonerSpellList getDataSummonerSpellList(String locale, String version, boolean dataById, SpellData... spellData) throws RiotApiException {

        return StaticDataMethod.getDataSummonerSpellList(getRegion(), getKey(), locale, version, dataById, spellData);
    }

    /**
     *
     */
    public SummonerSpellList getDataSummonerSpellList(Region region) throws RiotApiException {

        return StaticDataMethod.getDataSummonerSpellList(region.getName(), getKey(), null, null, false, (SpellData) null);
    }

    /**
     *
     */
    public SummonerSpellList getDataSummonerSpellList() throws RiotApiException {

        return StaticDataMethod.getDataSummonerSpellList(getRegion(), getKey(), null, null, false, (SpellData) null);
    }

    /**
     *
     */
    public SummonerSpell getDataSummonerSpell(Region region, int id, String locale, String version, SpellData... spellData) throws RiotApiException {

        return StaticDataMethod.getDataSummonerSpell(region.getName(), getKey(), id, locale, version, spellData);
    }

    /**
     *
     */
    public SummonerSpell getDataSummonerSpell(int id, String locale, String version, SpellData... spellData) throws RiotApiException {

        return StaticDataMethod.getDataSummonerSpell(getRegion(), getKey(), id, locale, version, spellData);
    }

    /**
     *
     */
    public SummonerSpell getDataSummonerSpell(Region region, int id) throws RiotApiException {

        return StaticDataMethod.getDataSummonerSpell(region.getName(), getKey(), id, null, null, (SpellData) null);
    }

    /**
     *
     */
    public SummonerSpell getDataSummonerSpell(int id) throws RiotApiException {

        return StaticDataMethod.getDataSummonerSpell(getRegion(), getKey(), id, null, null, (SpellData) null);
    }

    /**
     *
     */
    public List<String> getDataVersions(Region region) throws RiotApiException {

        return StaticDataMethod.getDataVersions(region.getName(), getKey());
    }

    /**
     *
     */
    public List<String> getDataVersions() throws RiotApiException {

        return StaticDataMethod.getDataVersions(getRegion(), getKey());
    }
    
    /**
    *
    */
   public List<String> getDataLanguages(Region region) throws RiotApiException {

       return StaticDataMethod.getDataLanguages(region.getName(), getKey());
   }

   /**
    *
    */
   public List<String> getDataLanguages() throws RiotApiException {

       return StaticDataMethod.getDataLanguages(getRegion(), getKey());
   }
   
    /**
    *
    */
   public List<Shard> getShards() throws RiotApiException {

       return StatusMethod.getShards();
   }
   
   /**
   *
   */
  public ShardStatus getShardStatus(Region region) throws RiotApiException {

      return StatusMethod.getShardStatus(region.getName());
  }

   /**
   *
   */
  public ShardStatus getShardStatus() throws RiotApiException {

     return StatusMethod.getShardStatus(getRegion());
 }
  
	  /**
	  *
	  */
	 public GameMapList getDataGameMapList(Region region, String locale, String version) throws RiotApiException {
	
	     return StaticDataMethod.getDataGameMapList(region.getName(), getKey(), locale, version);
	 }
	
	 /**
	  *
	  */
	 public GameMapList getDataGameMapList(String locale, String version) throws RiotApiException {
	
	     return StaticDataMethod.getDataGameMapList(getRegion(), getKey(), locale, version);
	 }
	
	 /**
	  *
	  */
	 public GameMapList getDataGameMapList(Region region) throws RiotApiException {
	
	     return StaticDataMethod.getDataGameMapList(region.getName(), getKey(), null, null);
	 }
	
	 /**
	  *
	  */
	 public GameMapList getDataGameMapList() throws RiotApiException {
	
	     return StaticDataMethod.getDataGameMapList(getRegion(), getKey(), null, null);
	 }

	  /**
	  *
	  */
	 public LanguageStrings getDataLanguageStrings(Region region, String locale, String version) throws RiotApiException {
	
	     return StaticDataMethod.getDataLanguageStrings(region.getName(), getKey(), locale, version);
	 }
	
	 /**
	  *
	  */
	 public LanguageStrings getDataLanguageStrings(String locale, String version) throws RiotApiException {
	
	     return StaticDataMethod.getDataLanguageStrings(getRegion(), getKey(), locale, version);
	 }
	
	 /**
	  *
	  */
	 public LanguageStrings getDataLanguageStrings(Region region) throws RiotApiException {
	
	     return StaticDataMethod.getDataLanguageStrings(region.getName(), getKey(), null, null);
	 }
	
	 /**
	  *
	  */
	 public LanguageStrings getDataLanguageStrings() throws RiotApiException {
	
	     return StaticDataMethod.getDataLanguageStrings(getRegion(), getKey(), null, null);
	 }
	 
	 /**
	  *
	  */
	 public FeaturedGames getFeaturedGames(Region region) throws RiotApiException {
	
	     return FeaturedGamesMethod.getFeaturedGames(region.getName(), getKey());
	 }
	 
	 /**
	  *
	  */
	 public FeaturedGames getFeaturedGames() throws RiotApiException {
			
	     return FeaturedGamesMethod.getFeaturedGames(getRegion(), getKey());
	 }
	 
	 /**
	  *
	  */
	 public CurrentGameInfo getCurrentGameInfo(PlatformId platformId, long summonerId) throws RiotApiException {
	
	     return CurrentGameMethod.getCurrentGameInfo(platformId, getKey(), summonerId);
	 }
	 
    /**
     * Get the currently set season
     *
     * @return The currently set season
     */
    public String getSeason() {
    	if(season == null){
    		return null;
    	}
        return season.getName();
    }

    /**
     * Get the currently set API key
     *
     * @return The currently set API key
     */
    public String getKey() {
        return key;
    }

    /**
     * Get the currently set region
     *
     * @return The currently set region
     * @throws  
     */
    public String getRegion() {
        return region.getName();
    }

    /**
     * Set the season
     *
     * @param season The season to set
     */
    public void setSeason(Season season) {
        this.season = season;
    }

    /**
     * Set the API key
     *
     * @param key The API key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Set the region
     *
     * @param region The region to set
     */
    public void setRegion(Region region) {
        this.region = region;
        setEndpoint();
    }

    /**
     * Get the base URL for all API requests
     *
     * @return The base URL for all API requests
     */
    public String getEndpoint() {
        return endpoint;
    }

    private void setEndpoint() {
        this.endpoint = region.getEndpoint();
    }
    
    public RiotApi clone() {
    	return new RiotApi(this.key, this.region);
    }

}
