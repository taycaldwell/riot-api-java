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
import dto.MatchList.MatchList;
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

    public RiotApi(Region region) {
        this.setRegion(region);
    }

    public RiotApi(String key, Region region) {
        this.setKey(key);
        this.setRegion(region);
    }

    /**
     * Get all the champions for a set region
     *
     * @return A list of all the champions for the set region
     * @see dto.Champion.ChampionList
     * @throws RiotApiException
     */
    public dto.Champion.ChampionList getChampions() throws RiotApiException {

        return ChampionApi.getChampions(getEndpoint(), getRegion(), getKey());
    }

    /**
     * Get all the champions for a given region
     *
     * @param region Region where to retrieve the data.
     * @return A list of champions for the given region
     * @see dto.Champion.ChampionList
     * @throws RiotApiException
     */
    public dto.Champion.ChampionList getChampions(Region region) throws RiotApiException {

        return ChampionApi.getChampions(region.getEndpoint(), region.getName(), getKey());
    }

    /**
     * Get all the champions for a set region
     *
     * @param freeToPlay Optional filter param to retrieve only free to play champions.
     * @return A list of champions for the set region
     * @see dto.Champion.ChampionList
     * @throws RiotApiException
     */
    public dto.Champion.ChampionList getChampions(boolean freeToPlay) throws RiotApiException {

        return ChampionApi.getChampions(getEndpoint(), getRegion(), getKey(), freeToPlay);
    }

    /**
     * Get all champions for a given region
     *
     * @param region Region where to retrieve the data.
     * @param freeToPlay Optional filter param to retrieve only free to play champions.
     * @return A list of champions for the given region
     * @see dto.Champion.ChampionList
     * @throws RiotApiException
     */
    public dto.Champion.ChampionList getChampions(Region region, boolean freeToPlay) throws RiotApiException {

        return ChampionApi.getChampions(region.getEndpoint(), region.getName(), getKey(), freeToPlay);
    }

    /**
     * Get all free to play champions for a given region
     *
     * @param region Region where to retrieve the data.
     * @return A list of all the free to play champions for the given region
     * @see dto.Champion.ChampionList
     * @throws RiotApiException
     */
    public dto.Champion.ChampionList getFreeToPlayChampions(Region region) throws RiotApiException {

        return ChampionApi.getChampions(region.getEndpoint(), region.getName(), getKey(), true);
    }

    /**
     * Get all free to play champions for a set region
     *
     * @return A list of all the free to play champions for the set region
     * @see dto.Champion.ChampionList
     * @throws RiotApiException
     */
    public dto.Champion.ChampionList getFreeToPlayChampions() throws RiotApiException {

        return ChampionApi.getChampions(getEndpoint(), getRegion(), getKey(), true);
    }

    /**
     * Get a champion by id for a given region
     *
     * @param region Region where to retrieve the data.
     * @param champId The ID of the desired champion
     * @return The champion of the given ID
     * @see Champion
     * @throws RiotApiException
     */
    public Champion getChampionById(Region region, int champId) throws RiotApiException {

        return ChampionApi.getChampionById(region.getEndpoint(), region.getName(), getKey(), champId);
    }

    /**
     * Get a champion by id for a set region
     *
     * @param champId The ID of the desired champion
     * @return The champion of the given ID
     * @see Champion
     * @throws RiotApiException
     */
    public Champion getChampionById(int champId) throws RiotApiException {

        return ChampionApi.getChampionById(getEndpoint(), getRegion(), getKey(), champId);
    }

    /**
     * Get recent games for a given summoner
     *
     * @param region Region where to retrieve the data.
     * @param summonerId ID of the summoner for which to retrieve recent games.
     * @return Recent games of the given summoner
     * @see RecentGames
     * @throws RiotApiException
     */
    public RecentGames getRecentGames(Region region, long summonerId) throws RiotApiException {

        return GameApi.getRecentGames(region.getEndpoint(), region.getName(), getKey(), summonerId);
    }

    /**
     * Get recent games for a given summoner
     *
     * @param summonerId ID of the summoner for which to retrieve recent games.
     * @return Recent games of the given summoner
     * @see RecentGames
     * @throws RiotApiException
     */
    public RecentGames getRecentGames(long summonerId) throws RiotApiException {

        return GameApi.getRecentGames(getEndpoint(), getRegion(), getKey(), summonerId);
    }
    
    /**
     * Get a list of leagues for a summoner
     * 
     * @param region The region of the leagues.
     * @param summonerId Summoner ID
     * @return A list of leagues
     * @see League
     * @throws RiotApiException
     */
    public List<League> getLeagueBySummoner(Region region, long summonerId) throws RiotApiException {

        return LeagueApi.getLeagueBySummoners(region.getEndpoint(), region.getName(), getKey(), summonerId).get(Long.toString(summonerId));
    }
    
    /**
     * Get a list of leagues for multiple summoners
     * 
     * @param region The region of the leagues.
     * @param summonerIds List of summoner IDs. Maximum allowed at once is 10.
     * @return A map, mapping each summoner ID to a list of leagues
     * @see League
     * @throws RiotApiException
     */
    public Map<String, List<League>> getLeagueBySummoners(Region region, long... summonerIds) throws RiotApiException {

        return LeagueApi.getLeagueBySummoners(region.getEndpoint(), region.getName(), getKey(), summonerIds);
    }
    
    /**
     * Get a list of leagues for a summoner
     * 
     * @param summonerId Summoner ID
     * @return A list of leagues
     * @see League
     * @throws RiotApiException
     */
    public List<League> getLeagueBySummoner(long summonerId) throws RiotApiException {

        return LeagueApi.getLeagueBySummoners(getEndpoint(), getRegion(), getKey(), summonerId).get(Long.toString(summonerId));
    }
    
    /**
     * Get a list of leagues for multiple summoners
     * 
     * @param summonerIds List of summoner IDs. Maximum allowed at once is 10.
     * @return A map, mapping each summoner ID to a list of leagues
     * @see League
     * @throws RiotApiException
     */
    public Map<String, List<League>> getLeagueBySummoners(long... summonerIds) throws RiotApiException {

        return LeagueApi.getLeagueBySummoners(getEndpoint(), getRegion(), getKey(), summonerIds);
    }
    
    /**
     * Get a list of leagues for a summoner
     * 
     * @param region The region of the leagues.
     * @param summonerId Summoner ID
     * @return A list of leagues
     * @see League
     * @throws RiotApiException
     */
    public List<League> getLeagueEntryBySummoner(Region region, long summonerId) throws RiotApiException {

        return LeagueApi.getLeagueEntryBySummoners(region.getEndpoint(), region.getName(), getKey(), summonerId).get(Long.toString(summonerId));
    }
    
    /**
     * Get a list of leagues for multiple summoners
     * 
     * @param region The region of the leagues.
     * @param summonerIds List of summoner IDs. Maximum allowed at once is 10.
     * @return A map, mapping each summoner ID to a list of leagues
     * @see League
     * @throws RiotApiException
     */
    public Map<String, List<League>> getLeagueEntryBySummoners(Region region, long... summonerIds) throws RiotApiException {

        return LeagueApi.getLeagueEntryBySummoners(region.getEndpoint(), region.getName(), getKey(), summonerIds);
    }
    
    /**
     * Get a list of leagues for a summoner
     * 
     * @param summonerId Summoner ID
     * @return A list of leagues
     * @see League
     * @throws RiotApiException
     */
    public List<League> getLeagueEntryBySummoner(long summonerId) throws RiotApiException {

        return LeagueApi.getLeagueEntryBySummoners(getEndpoint(), getRegion(), getKey(), summonerId).get(Long.toString(summonerId));
    }
    
    /**
     * Get a list of leagues for multiple summoners
     * 
     * @param summonerIds List of summoner IDs. Maximum allowed at once is 10.
     * @return A map, mapping each summoner ID to a list of leagues
     * @see League
     * @throws RiotApiException
     */
    public Map<String, List<League>> getLeagueEntryBySummoners(long... summonerIds) throws RiotApiException {

        return LeagueApi.getLeagueEntryBySummoners(getEndpoint(), getRegion(), getKey(), summonerIds);
    }
    
    /**
     * Get a list of leagues for a summoner
     * 
     * @param region The region of the leagues.
     * @param summonerId Summoner ID
     * @return A list of leagues
     * @see League
     * @throws RiotApiException
     */
    public List<League> getLeagueBySummoner(Region region, String summonerId) throws RiotApiException {

        return LeagueApi.getLeagueBySummoners(region.getEndpoint(), region.getName(), getKey(), summonerId).get(summonerId);
    }
    
    /**
     * Get a list of leagues for multiple summoners
     * 
     * @param region The region of the leagues.
     * @param summonerIds List of summoner IDs. Maximum allowed at once is 10.
     * @return A map, mapping each summoner ID to a list of leagues
     * @see League
     * @throws RiotApiException
     */
    public Map<String, List<League>> getLeagueBySummoners(Region region, String summonerIds) throws RiotApiException {

        return LeagueApi.getLeagueBySummoners(region.getEndpoint(), region.getName(), getKey(), summonerIds);
    }
    
    /**
     * Get a list of leagues for a summoner
     * 
     * @param summonerId Summoner ID
     * @return A list of leagues
     * @see League
     * @throws RiotApiException
     */
    public List<League> getLeagueBySummoner(String summonerId) throws RiotApiException {
        return LeagueApi.getLeagueBySummoners(getEndpoint(), getRegion(), getKey(), summonerId).get(summonerId);
    }
    
    /**
     * Get a list of leagues for multiple summoners
     * 
     * @param summonerIds List of summoner IDs. Maximum allowed at once is 10.
     * @return A map, mapping each summoner ID to a list of leagues
     * @see League
     * @throws RiotApiException
     */
    public Map<String, List<League>> getLeagueBySummoners(String summonerIds) throws RiotApiException {
        return LeagueApi.getLeagueBySummoners(getEndpoint(), getRegion(), getKey(), summonerIds);
    }
    
    /**
     * Get a list of league entries for a summoner
     * 
     * @param region The region of the leagues.
     * @param summonerId Summoner ID
     * @return A list of leagues
     * @see League
     * @throws RiotApiException
     */
    public List<League> getLeagueEntryBySummoner(Region region, String summonerId) throws RiotApiException {

        return LeagueApi.getLeagueEntryBySummoners(region.getEndpoint(), region.getName(), getKey(), summonerId).get(summonerId);
    }
    
    /**
     * Get a list of league entries for multiple summoners
     * 
     * @param region The region of the leagues.
     * @param summonerIds List of summoner IDs. Maximum allowed at once is 10.
     * @return A map, mapping each summoner ID to a list of leagues
     * @see League
     * @throws RiotApiException
     */
    public Map<String, List<League>> getLeagueEntryBySummoners(Region region, String summonerIds) throws RiotApiException {

        return LeagueApi.getLeagueEntryBySummoners(region.getEndpoint(), region.getName(), getKey(), summonerIds);
    }
    
    /**
     * Get a list of league entries for a summoner
     * 
     * @param summonerId Summoner ID
     * @return A list of leagues
     * @see League
     * @throws RiotApiException
     */
    public List<League> getLeagueEntryBySummoner(String summonerId) throws RiotApiException {

        return LeagueApi.getLeagueEntryBySummoners(getEndpoint(), getRegion(), getKey(), summonerId).get(summonerId);
    }
    
    /**
     * Get a list of league entries for multiple summoners
     * 
     * @param summonerIds List of summoner IDs. Maximum allowed at once is 10.
     * @return A map, mapping each summoner ID to a list of leagues
     * @see League
     * @throws RiotApiException
     */
    public Map<String, List<League>> getLeagueEntryBySummoners(String summonerIds) throws RiotApiException {

        return LeagueApi.getLeagueEntryBySummoners(getEndpoint(), getRegion(), getKey(), summonerIds);
    }
    
    /**
     * Get a list of leagues for a team
     * 
     * @param region The region of the leagues.
     * @param teamId Team ID
     * @return A list of leagues
     * @see League
     * @throws RiotApiException
     */
    public List<League> getLeagueByTeam(Region region, String teamId) throws RiotApiException {

        return LeagueApi.getLeagueByTeams(region.getEndpoint(), region.getName(), getKey(), teamId).get(teamId);
    }
    
    /**
     * Get a list of leagues for multiple teams
     * 
     * @param region The region of the leagues.
     * @param teamIds List of team IDs. Maximum allowed at once is 10.
     * @return A map, mapping each team ID to a list of leagues
     * @see League
     * @throws RiotApiException
     */
    public Map<String, List<League>> getLeagueByTeams(Region region, String teamIds) throws RiotApiException {

        return LeagueApi.getLeagueByTeams(region.getEndpoint(), region.getName(), getKey(), teamIds);
    }
    
    /**
     * Get a list of leagues for a team
     * 
     * @param teamId Team ID
     * @return A list of leagues
     * @see League
     * @throws RiotApiException
     */
    public List<League> getLeagueByTeam(String teamId) throws RiotApiException {

        return LeagueApi.getLeagueByTeams(getEndpoint(), getRegion(), getKey(), teamId).get(teamId);
    }
    
    /**
     * Get a list of leagues for multiple teams
     * 
     * @param teamIds List of team IDs. Maximum allowed at once is 10.
     * @return A map, mapping each team ID to a list of leagues
     * @see League
     * @throws RiotApiException
     */
    public Map<String, List<League>> getLeagueByTeams(String teamIds) throws RiotApiException {

        return LeagueApi.getLeagueByTeams(getEndpoint(), getRegion(), getKey(), teamIds);
    }

    /**
     * Get a list of league entries for a team
     * 
     * @param region The region of the leagues.
     * @param teamId Team ID
     * @return A list of leagues
     * @see League
     * @throws RiotApiException
     */
    public List<League> getLeagueEntryByTeam(Region region, String teamId) throws RiotApiException {

        return LeagueApi.getLeagueEntryByTeams(region.getEndpoint(), region.getName(), getKey(), teamId).get(teamId);
    }
    
    /**
     * Get a list of league entries for multiple teams
     * 
     * @param region The region of the leagues.
     * @param teamIds List of team IDs. Maximum allowed at once is 10.
     * @return A map, mapping each team ID to a list of leagues
     * @see League
     * @throws RiotApiException
     */
    public Map<String, List<League>> getLeagueEntryByTeams(Region region, String teamIds) throws RiotApiException {

        return LeagueApi.getLeagueEntryByTeams(region.getEndpoint(), region.getName(), getKey(), teamIds);
    }
    
    /**
     * Get a list of league entries for a team
     * 
     * @param teamIds List of team IDs. Maximum allowed at once is 10.
     * @return A list of leagues
     * @see League
     * @throws RiotApiException
     */
    public List<League> getLeagueEntryByTeam(String teamId) throws RiotApiException {

        return LeagueApi.getLeagueEntryByTeams(getEndpoint(), getRegion(), getKey(), teamId).get(teamId);
    }
    
    /**
     * Get a list of league entries for multiple teams
     * 
     * @param teamIds List of team IDs. Maximum allowed at once is 10.
     * @return A map, mapping each team ID to a list of leagues
     * @see League
     * @throws RiotApiException
     */
    public Map<String, List<League>> getLeagueEntryByTeams(String teamIds) throws RiotApiException {

        return LeagueApi.getLeagueEntryByTeams(getEndpoint(), getRegion(), getKey(), teamIds);
    }

    /**
     * Get challenger league
     * 
     * @param region The region of the leagues.
     * @return A single league
     * @see League
     * @throws RiotApiException
     */
    public League getChallengerLeague(Region region) throws RiotApiException {

        return LeagueApi.getChallengerLeague(region.getEndpoint(), region.getName(), getKey());
    }

    /**
     * Get challenger league
     * 
     * @return A single league
     * @see League
     * @throws RiotApiException
     */
    public League getChallengerLeague() throws RiotApiException {

        return LeagueApi.getChallengerLeague(getEndpoint(), getRegion(), getKey());
    }

    /**
     * Get challenger league
     * 
     * @param region The region of the leagues.
     * @param queueType Game queue type.
     * @return A single league
     * @see League
     * @throws RiotApiException
     */
    public League getChallengerLeague(Region region, QueueType queueType) throws RiotApiException {

        return LeagueApi.getChallengerLeague(region.getEndpoint(), region.getName(), getKey(), queueType);
    }

    /**
     * Get challenger league
     * 
     * @param queueType Game queue type.
     * @return A single league
     * @see League
     * @throws RiotApiException
     */
    public League getChallengerLeague(QueueType queueType) throws RiotApiException {

        return LeagueApi.getChallengerLeague(getEndpoint(), getRegion(), getKey(), queueType);
    }
    
    /**
     * Get master league
     * 
     * @param region The region of the leagues.
     * @return A single league
     * @see League
     * @throws RiotApiException
     */
    public League getMasterLeague(Region region) throws RiotApiException {

        return LeagueApi.getMasterLeague(region.getEndpoint(), region.getName(), getKey());
    }

    /**
     * Get master league
     * 
     * @return A single league
     * @see League
     * @throws RiotApiException
     */
    public League getMasterLeague() throws RiotApiException {

        return LeagueApi.getMasterLeague(getEndpoint(), getRegion(), getKey());
    }

    /**
     * Get master league
     * 
     * @param region The region of the leagues.
     * @param queueType Game queue type.
     * @return A single league
     * @see League
     * @throws RiotApiException
     */
    public League getMasterLeague(Region region, QueueType queueType) throws RiotApiException {

        return LeagueApi.getMasterLeague(region.getEndpoint(), region.getName(), getKey(), queueType);
    }

    /**
     * Get master league
     * 
     * @param queueType Game queue type.
     * @return A single league
     * @see League
     * @throws RiotApiException
     */
    public League getMasterLeague(QueueType queueType) throws RiotApiException {

        return LeagueApi.getMasterLeague(getEndpoint(), getRegion(), getKey(), queueType);
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

        return StatsApi.getPlayerStatsSummary(region.getEndpoint(), region.getName(), season.getName(), getKey(), summonerId);
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

        return StatsApi.getPlayerStatsSummary(getEndpoint(), getRegion(), season.getName(), getKey(), summonerId);
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

        return StatsApi.getPlayerStatsSummary(region.getEndpoint(), region.getName(), getSeason(), getKey(), summonerId);
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

        return StatsApi.getPlayerStatsSummary(getEndpoint(), getRegion(), getSeason(), getKey(), summonerId);
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

        return StatsApi.getRankedStats(region.getEndpoint(), region.getName(), season.getName(), getKey(), summonerId);
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

        return StatsApi.getRankedStats(getEndpoint(), getRegion(), season.getName(), getKey(), summonerId);
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

        return StatsApi.getRankedStats(region.getEndpoint(), region.getName(), getSeason(), getKey(), summonerId);
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

        return StatsApi.getRankedStats(getEndpoint(), getRegion(), getSeason(), getKey(), summonerId);
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

        return SummonerApi.getMasteryPages(region.getEndpoint(), region.getName(), getKey(), summonerIds);
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

        return SummonerApi.getMasteryPages(getEndpoint(), getRegion(), getKey(), summonerIds);
    }

    /**
     * Get the mastery pages of given summoners
     *
     * @param region The desired region
     * @param summonerIds The IDs of the desired summoners
     * @return A map of mastery pages of the given summoners
     * @see MasteryPages
     * @throws RiotApiException
     */
    public Map<String, MasteryPages> getMasteryPages(Region region, long... summonerIds) throws RiotApiException {

        return SummonerApi.getMasteryPages(region.getEndpoint(), region.getName(), getKey(), summonerIds);
    }
    
    /**
     * Get the mastery pages of a given summoner
     *
     * @param region The desired region
     * @param summonerId The ID of the desired summoner
     * @return A map of mastery pages of the given summoner
     * @see MasteryPages
     * @throws RiotApiException
     */
    public MasteryPages getMasteryPages(Region region, long summonerId) throws RiotApiException {

        return SummonerApi.getMasteryPages(region.getEndpoint(), region.getName(), getKey(), summonerId).get(Long.toString(summonerId));
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

        return SummonerApi.getMasteryPages(getEndpoint(), getRegion(), getKey(), summonerIds);
    }
    
    /**
     * Get the mastery pages of a given summoner
     *
     * @param summonerId The IDs of the desired summoner
     * @return A map of mastery pages of the given summoner
     * @see MasteryPages
     * @throws RiotApiException
     */
    public MasteryPages getMasteryPages(long summonerId) throws RiotApiException {

        return SummonerApi.getMasteryPages(getEndpoint(), getRegion(), getKey(), summonerId).get(Long.toString(summonerId));
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

        return SummonerApi.getRunePages(region.getEndpoint(), region.getName(), getKey(), summonerIds);
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

        return SummonerApi.getRunePages(getEndpoint(), getRegion(), getKey(), summonerIds);
    }

    /**
     * Get the rune pages of a given summoners
     *
     * @param region The desired region
     * @param summonerIds The IDs of the desired summoners
     * @return A map of rune pages of the given summoners
     * @see RunePages
     * @throws RiotApiException
     */
    public Map<String, RunePages> getRunePages(Region region, long... summonerIds) throws RiotApiException {

        return SummonerApi.getRunePages(region.getEndpoint(), region.getName(), getKey(), summonerIds);
    }
    
    /**
     * Get the rune pages of a given summoner
     *
     * @param region The desired region
     * @param summonerId The IDs of the desired summoner
     * @return A map of rune pages of the given summoner
     * @see RunePages
     * @throws RiotApiException
     */
    public RunePages getRunePages(Region region, long summonerId) throws RiotApiException {

        return SummonerApi.getRunePages(region.getEndpoint(), region.getName(), getKey(), summonerId).get(Long.toString(summonerId));
    }

    /**
     * Get the rune pages of a given summoners
     *
     * @param summonerIds The IDs of the desired summoners
     * @return A map of rune pages of the given summoners
     * @see RunePages
     * @throws RiotApiException
     */
    public Map<String, RunePages> getRunePages(long... summonerIds) throws RiotApiException {

        return SummonerApi.getRunePages(getEndpoint(), getRegion(), getKey(), summonerIds);
    }
    
    /**
     * Get the rune pages of a given summoner
     *
     * @param summonerId The IDs of the desired summoner
     * @return A map of rune pages of the given summoner
     * @see RunePages
     * @throws RiotApiException
     */
    public RunePages getRunePages(long summonerId) throws RiotApiException {

        return SummonerApi.getRunePages(getEndpoint(), getRegion(), getKey(), summonerId).get(Long.toString(summonerId));
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

        return SummonerApi.getSummonersByName(region.getEndpoint(), region.getName(), getKey(), summonerNames);
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
    	
        return SummonerApi.getSummonersByName(getEndpoint(), getRegion(), getKey(), summonerNames);
    }

    /**
     * Get summoner by name
     *
     * @param region The desired region
     * @param summonerName The name of the desired summoner
     * @return The desired summoner
     * @see Summoner
     * @throws RiotApiException
     */
    public Summoner getSummonerByName(Region region, String summonerName) throws RiotApiException {

        Map<String, Summoner> summoners = SummonerApi.getSummonersByName(region.getEndpoint(), region.getName(), getKey(), summonerName);
        Summoner summoner = summoners.entrySet().iterator().next().getValue();
        return summoner;
        
    }

    /**
     * Get summoner by name
     *
     * @param summonerName The name of the desired summoner
     * @return The desired summoner
     * @see Summoner
     * @throws RiotApiException
     */
    public Summoner getSummonerByName(String summonerName) throws RiotApiException {
    	
    	Map<String, Summoner> summoners = SummonerApi.getSummonersByName(getEndpoint(), getRegion(), getKey(), summonerName);
        Summoner summoner = summoners.entrySet().iterator().next().getValue();
        return summoner;
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

        return SummonerApi.getSummonersById(region.getEndpoint(), region.getName(), getKey(), summonerIds);
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

        return SummonerApi.getSummonersById(getEndpoint(), getRegion(), getKey(), summonerIds);
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

        return SummonerApi.getSummonersById(region.getEndpoint(), region.getName(), getKey(), summonerIds);
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

        return SummonerApi.getSummonersById(getEndpoint(), getRegion(), getKey(), summonerIds);
    }

    /**
     * Get summoners by names
     *
     * @param region The desired region
     * @param summonerId The ID of the desired summoner
     * @return The desired summoner
     * @see Summoner
     * @throws RiotApiException
     */
    public Summoner getSummonerById(Region region, long summonerId) throws RiotApiException {

    	Map<String, Summoner> summoners = SummonerApi.getSummonersById(region.getEndpoint(), region.getName(), getKey(), summonerId);
    	Summoner summoner = summoners.entrySet().iterator().next().getValue();
        return summoner;
    }

    /**
     * Get summoners by names
     *
     * @param summonerId The IDs of the desired summoners
     * @return The desired summoner
     * @see Summoner
     * @throws RiotApiException
     */
    public Summoner getSummonerById(long summonerId) throws RiotApiException {

        Map<String, Summoner> summoners = SummonerApi.getSummonersById(getEndpoint(), getRegion(), getKey(), summonerId);
        Summoner summoner = summoners.entrySet().iterator().next().getValue();
        return summoner;
    }

    /**
     * Get summoners by names
     *
     * @param region The desired region
     * @param summonerId The IDs of the desired summoners
     * @return The desired summoner
     * @see Summoner
     * @throws RiotApiException
     */
    public Summoner getSummonerById(Region region, String summonerId) throws RiotApiException {

        Map<String, Summoner> summoners = SummonerApi.getSummonersById(region.getEndpoint(), region.getName(), getKey(), summonerId);
        Summoner summoner = summoners.entrySet().iterator().next().getValue();
        return summoner;
    }

    /**
     * Get summoners by names
     *
     * @param region The desired region
     * @param summonerId The IDs of the desired summoners
     * @return The desired summoner
     * @see Summoner
     * @throws RiotApiException
     */
    public Summoner getSummonerById(String summonerId) throws RiotApiException {

    	Map<String, Summoner> summoners = SummonerApi.getSummonersById(getEndpoint(), getRegion(), getKey(), summonerId);
    	Summoner summoner = summoners.entrySet().iterator().next().getValue();
        return summoner;
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

        return SummonerApi.getSummonerNames(region.getEndpoint(), region.getName(), getKey(), summonerIds);
    }

    /**
     * Get summoner names by IDs
     *
     * @param summonerIds The IDs of the desired summoners
     * @return A map of desired summoner names
     * @throws RiotApiException
     */
    public Map<String, String> getSummonerNames(long... summonerIds) throws RiotApiException {

        return SummonerApi.getSummonerNames(getEndpoint(), getRegion(), getKey(), summonerIds);
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

        return SummonerApi.getSummonerNames(region.getEndpoint(), region.getName(), getKey(), summonerIds);
    }

    /**
     * Get summoner names by IDs
     *
     * @param summonerIds A comma separated list of IDs of the desired summoners
     * @return A map of desired summoner names
     * @throws RiotApiException
     */
    public Map<String, String> getSummonerNames(String summonerIds) throws RiotApiException {

        return SummonerApi.getSummonerNames(getEndpoint(), getRegion(), getKey(), summonerIds);
    }

    /**
     * Get summoner names by IDs
     *
     * @param region The desired region
     * @param summonerId The IDs of the desired summoner
     * @return The desired summoner name
     * @throws RiotApiException
     */
    public String getSummonerName(Region region, long summonerId) throws RiotApiException {

    	Map<String, String> summoners = SummonerApi.getSummonerNames(region.getEndpoint(), region.getName(), getKey(), summonerId);
    	String name = summoners.entrySet().iterator().next().getValue();
        return name;
    }

    /**
     * Get summoner names by IDs
     *
     * @param region The desired region
     * @param summonerId The IDs of the desired summoner
     * @return The desired summoner name
     * @throws RiotApiException
     */
    public String getSummonerName(long summonerId) throws RiotApiException {

    	Map<String, String> summoners = SummonerApi.getSummonerNames(getEndpoint(), getRegion(), getKey(), summonerId);
        String name = summoners.entrySet().iterator().next().getValue();
        return name;
    }

    /**
     * Get summoner names by IDs
     *
     * @param region The desired region
     * @param summonerId The IDs of the desired summoner
     * @return The desired summoner name
     * @throws RiotApiException
     */
    public String getSummonerName(Region region, String summonerId) throws RiotApiException {

        Map<String, String> summoners = SummonerApi.getSummonerNames(region.getEndpoint(), region.getName(), getKey(), summonerId);
        String name = summoners.entrySet().iterator().next().getValue();
        return name;
    }

    /**
     * Get summoner names by IDs
     *
     * @param summonerId The ID of the desired summoner
     * @return A map of desired summoner names
     * @throws RiotApiException
     */
    public String getSummonerName(String summonerId) throws RiotApiException {

    	Map<String, String> summoners = SummonerApi.getSummonerNames(getEndpoint(), getRegion(), getKey(), summonerId);
    	String name = summoners.entrySet().iterator().next().getValue();
        return name;
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

        return TeamApi.getTeamsBySummonerIds(region.getEndpoint(), region.getName(), getKey(), summonerIds);
    }
    
    /**
     * Get teams by summonerID
     *
     * @param region The desired region
     * @param summonerId A summoner ID
     * @return A list of the summoners' teams
     * @see Team
     * @throws RiotApiException
     */
    public List<Team> getTeamsBySummonerId(Region region, long summonerId) throws RiotApiException {

        return TeamApi.getTeamsBySummonerIds(region.getEndpoint(), region.getName(), getKey(), summonerId).get(Long.toString(summonerId));
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

        return TeamApi.getTeamsBySummonerIds(getEndpoint(), getRegion(), getKey(), summonerIds);
    }
    
    /**
     * Get teams by summonerID
     *
     * @param summonerId A summoner ID
     * @return A list of the summoners' teams
     * @see Team
     * @throws RiotApiException
     */
    public List<Team> getTeamsBySummonerId(long summonerId) throws RiotApiException {

        return TeamApi.getTeamsBySummonerIds(getEndpoint(), getRegion(), getKey(), summonerId).get(Long.toString(summonerId));
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

        return TeamApi.getTeamsBySummonerIds(region.getEndpoint(), region.getName(), getKey(), summonerIds);
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

        return TeamApi.getTeamsBySummonerIds(getEndpoint(), getRegion(), getKey(), summonerIds);
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

        return MatchApi.getMatch(region.getEndpoint(), region.getName(), getKey(), matchId);
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

        return MatchApi.getMatch(getEndpoint(), getRegion(), getKey(), matchId);
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

        return MatchApi.getMatch(region.getEndpoint(), region.getName(), getKey(), matchId, includeTimeline);
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

        return MatchApi.getMatch(getEndpoint(), getRegion(), getKey(), matchId, includeTimeline);
    }

    /**
     * Get match list by summonerID
     *
     * @param region The desired region
     * @param summonerId The ID of the desired summoner
     * @param championIds Comma-separated list of champion IDs to use for fetching games.
     * @param rankedQueues Comma-separated list of ranked queue types to use for fetching games
     * @param seasons Comma-separated list of seasons to use for fetching games.
     * @param beginTime The begin time to use for fetching games specified as epoch milliseconds.
     * @param endTime The end time to use for fetching games specified as epoch milliseconds.
     * @param beginIndex The begin index to use for fetching games
     * @param endIndex The end index to use for fetching games
     * @return A list with matches
     * @see MatchList
     * @throws RiotApiException
     */
    public MatchList getMatchList(Region region, long summonerId, String championIds, String rankedQueues, String seasons, long beginTime, long endTime, int beginIndex, int endIndex) throws RiotApiException {

        return MatchListApi.getMatchList(region.getEndpoint(), region.getName(), getKey(), summonerId, championIds, rankedQueues, seasons, beginTime, endTime, beginIndex, endIndex);
    }
    
    /**
     * Get match list by summonerID
     *
     * @param region The desired region
     * @param summonerId The ID of the desired summoner
     * @return A list with matches
     * @see MatchList
     * @throws RiotApiException
     */
    public MatchList getMatchList(Region region, long summonerId) throws RiotApiException {

        return MatchListApi.getMatchList(region.getEndpoint(), region.getName(), getKey(), summonerId, null, null, null, -1, -1, -1, -1);
    }
    
    /**
     * Get match list by summonerID
     *
     * @param summonerId The ID of the desired summoner
     * @param championIds Comma-separated list of champion IDs to use for fetching games.
     * @param rankedQueues Comma-separated list of ranked queue types to use for fetching games
     * @param seasons Comma-separated list of seasons to use for fetching games.
     * @param beginTime The begin time to use for fetching games specified as epoch milliseconds.
     * @param endTime The end time to use for fetching games specified as epoch milliseconds.
     * @param beginIndex The begin index to use for fetching games
     * @param endIndex The end index to use for fetching games
     * @return A list with matches
     * @see MatchList
     * @throws RiotApiException
     */
    public MatchList getMatchList(long summonerId, String championIds, String rankedQueues, String seasons, long beginTime, long endTime, int beginIndex, int endIndex) throws RiotApiException {

        return MatchListApi.getMatchList(getEndpoint(), getRegion(), getKey(), summonerId, championIds, rankedQueues, seasons, beginTime, endTime, beginIndex, endIndex);
    }
    
    /**
     * Get match list by summonerID
     *
     * @param summonerId The ID of the desired summoner
     * @return A list with matches
     * @see MatchList
     * @throws RiotApiException
     */
    public MatchList getMatchList(long summonerId) throws RiotApiException {

        return MatchListApi.getMatchList(getEndpoint(), getRegion(), getKey(), summonerId, null, null, null, -1, -1, -1, -1);
    }
    
	/**
	 * Get current game info
	 * 
	 * @param platformId
	 *            The platform ID for which to fetch data.
	 * @param summonerId
	 *            The ID of the summoner.
	 * @return Current game info
	 * @see CurrentGameInfo
	 * @throws RiotApiException
	 */
	public CurrentGameInfo getCurrentGameInfo(PlatformId platformId, long summonerId) throws RiotApiException {

		return CurrentGameApi.getCurrentGameInfo(platformId, getKey(), summonerId);
	}

	/**
	 * Get featured games
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return Featured games
	 * @see FeaturedGames
	 * @throws RiotApiException
	 */
	public FeaturedGames getFeaturedGames(Region region) throws RiotApiException {

		return FeaturedGamesApi.getFeaturedGames(region.getName(), getKey());
	}

	/**
	 * Get featured games
	 * 
	 * @return Featured games
	 * @see FeaturedGames
	 * @throws RiotApiException
	 */
	public FeaturedGames getFeaturedGames() throws RiotApiException {

		return FeaturedGamesApi.getFeaturedGames(getRegion(), getKey());
	}

	/**
	 * Get static data: champion list
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param locale
	 *            Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the getDataVersions() method.
	 * @param dataById
	 *            If specified as true, the returned data map will use the champions' IDs as the keys. If specified as false, the returned
	 *            data map will use the champions' keys instead.
	 * @param champData
	 *            Tags to return additional data. Only id, key, name, and title are returned by default if this parameter isn't specified.
	 *            To return all additional data, use ChampData.ALL.
	 * @return A list with champions
	 * @see ChampionList
	 * @throws RiotApiException
	 */
	public ChampionList getDataChampionList(Region region, String locale, String version, boolean dataById, ChampData... champData) throws RiotApiException {

		return StaticDataApi.getDataChampionList(region.getName(), getKey(), locale, version, dataById, champData);
	}

	/**
	 * Get static data: champion list
	 * 
	 * @param locale
	 *            Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the getDataVersions() method.
	 * @param dataById
	 *            If specified as true, the returned data map will use the champions' IDs as the keys. If specified as false, the returned
	 *            data map will use the champions' keys instead.
	 * @param champData
	 *            Tags to return additional data. Only id, key, name, and title are returned by default if this parameter isn't specified.
	 *            To return all additional data, use ChampData.ALL.
	 * @return A list with champions
	 * @see ChampionList
	 * @throws RiotApiException
	 */
	public ChampionList getDataChampionList(String locale, String version, boolean dataById, ChampData... champData) throws RiotApiException {

		return StaticDataApi.getDataChampionList(getRegion(), getKey(), locale, version, dataById, champData);
	}

	/**
	 * Get static data: champion list
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return A list with champions
	 * @see ChampionList
	 * @throws RiotApiException
	 */
	public ChampionList getDataChampionList(Region region) throws RiotApiException {

		return StaticDataApi.getDataChampionList(region.getName(), getKey(), null, null, false, (ChampData) null);
	}

	/**
	 * Get static data: champion list
	 * 
	 * @return A list with champions
	 * @see ChampionList
	 * @throws RiotApiException
	 */
	public ChampionList getDataChampionList() throws RiotApiException {

		return StaticDataApi.getDataChampionList(getRegion(), getKey(), null, null, false, (ChampData) null);
	}

	/**
	 * Get static data: champion
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param id
	 *            Champion ID
	 * @param locale
	 *            Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the getDataVersions() method.
	 * @param champData
	 *            Tags to return additional data. Only id, key, name, and title are returned by default if this parameter isn't specified.
	 *            To return all additional data, use ChampData.ALL.
	 * @return A single champion
	 * @see Champion
	 * @throws RiotApiException
	 */
	public dto.Static.Champion getDataChampion(Region region, int id, String locale, String version, ChampData... champData) throws RiotApiException {

		return StaticDataApi.getDataChampion(region.getName(), getKey(), id, locale, version, champData);
	}

	/**
	 * Get static data: champion
	 * 
	 * @param id
	 *            Champion ID
	 * @param locale
	 *            Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the getDataVersions() method.
	 * @param champData
	 *            Tags to return additional data. Only id, key, name, and title are returned by default if this parameter isn't specified.
	 *            To return all additional data, use ChampData.ALL.
	 * @return A single champion
	 * @see Champion
	 * @throws RiotApiException
	 */
	public dto.Static.Champion getDataChampion(int id, String locale, String version, ChampData... champData) throws RiotApiException {

		return StaticDataApi.getDataChampion(getRegion(), getKey(), id, locale, version, champData);
	}

	/**
	 * Get static data: champion
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param id
	 *            Champion ID
	 * @return A single champion
	 * @see Champion
	 * @throws RiotApiException
	 */
	public dto.Static.Champion getDataChampion(Region region, int id) throws RiotApiException {

		return StaticDataApi.getDataChampion(region.getName(), getKey(), id, null, null, (ChampData) null);
	}

	/**
	 * Get static data: champion
	 * 
	 * @param id
	 *            Champion ID
	 * @return A single champion
	 * @see Champion
	 * @throws RiotApiException
	 */
	public dto.Static.Champion getDataChampion(int id) throws RiotApiException {

		return StaticDataApi.getDataChampion(getRegion(), getKey(), id, null, null, (ChampData) null);
	}

	/**
	 * Get static data: game map list
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param locale
	 *            Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the getDataVersions() method.
	 * @return A list of game maps
	 * @see GameMapList
	 * @throws RiotApiException
	 */
	public GameMapList getDataGameMapList(Region region, String locale, String version) throws RiotApiException {

		return StaticDataApi.getDataGameMapList(region.getName(), getKey(), locale, version);
	}

	/**
	 * Get static data: game map list
	 * 
	 * @param locale
	 *            Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the getDataVersions() method.
	 * @return A list of game maps
	 * @see GameMapList
	 * @throws RiotApiException
	 */
	public GameMapList getDataGameMapList(String locale, String version) throws RiotApiException {

		return StaticDataApi.getDataGameMapList(getRegion(), getKey(), locale, version);
	}

	/**
	 * Get static data: game map list
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return A list of game maps
	 * @see GameMapList
	 * @throws RiotApiException
	 */
	public GameMapList getDataGameMapList(Region region) throws RiotApiException {

		return StaticDataApi.getDataGameMapList(region.getName(), getKey(), null, null);
	}

	/**
	 * Get static data: game map list
	 * 
	 * @return A list of game maps
	 * @see GameMapList
	 * @throws RiotApiException
	 */
	public GameMapList getDataGameMapList() throws RiotApiException {

		return StaticDataApi.getDataGameMapList(getRegion(), getKey(), null, null);
	}

	/**
	 * Get static data: item list
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param locale
	 *            Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the getDataVersions() method.
	 * @param itemListData
	 *            Tags to return additional data. Only type, version, basic, data, id, name, plaintext, group, and description are returned
	 *            by default if this parameter isn't specified. To return all additional data, use ItemListData.ALL.
	 * @return A list of items
	 * @see ItemList
	 * @throws RiotApiException
	 */
	public ItemList getDataItemList(Region region, String locale, String version, ItemListData... itemListData) throws RiotApiException {

		return StaticDataApi.getDataItemList(region.getName(), getKey(), locale, version, itemListData);
	}

	/**
	 * Get static data: item list
	 * 
	 * @param locale
	 *            Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the getDataVersions() method.
	 * @param itemListData
	 *            Tags to return additional data. Only type, version, basic, data, id, name, plaintext, group, and description are returned
	 *            by default if this parameter isn't specified. To return all additional data, use ItemListData.ALL.
	 * @return A list of items
	 * @see ItemList
	 * @throws RiotApiException
	 */
	public ItemList getDataItemList(String locale, String version, ItemListData... itemListData) throws RiotApiException {

		return StaticDataApi.getDataItemList(getRegion(), getKey(), locale, version, itemListData);
	}

	/**
	 * Get static data: item list
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return A list of items
	 * @see ItemList
	 * @throws RiotApiException
	 */
	public ItemList getDataItemList(Region region) throws RiotApiException {

		return StaticDataApi.getDataItemList(region.getName(), getKey(), null, null, (ItemListData) null);
	}

	/**
	 * Get static data: item list
	 * 
	 * @return A list of items
	 * @see ItemList
	 * @throws RiotApiException
	 */
	public ItemList getDataItemList() throws RiotApiException {

		return StaticDataApi.getDataItemList(getRegion(), getKey(), null, null, (ItemListData) null);
	}

	/**
	 * Get static data: item
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param id
	 *            Item ID
	 * @param locale
	 *            Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the getDataVersions() method.
	 * @param itemData
	 *            Tags to return additional data. Only type, version, basic, data, id, name, plaintext, group, and description are returned
	 *            by default if this parameter isn't specified. To return all additional data, use ItemData.ALL.
	 * @return A single item
	 * @see Item
	 * @throws RiotApiException
	 */
	public Item getDataItem(Region region, int id, String locale, String version, ItemData... itemData) throws RiotApiException {

		return StaticDataApi.getDataItem(region.getName(), getKey(), id, locale, version, itemData);
	}

	/**
	 * Get static data: item
	 * 
	 * @param id
	 *            Item ID
	 * @param locale
	 *            Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the getDataVersions() method.
	 * @param itemData
	 *            Tags to return additional data. Only type, version, basic, data, id, name, plaintext, group, and description are returned
	 *            by default if this parameter isn't specified. To return all additional data, use ItemData.ALL.
	 * @return A single item
	 * @see Item
	 * @throws RiotApiException
	 */
	public Item getDataItem(int id, String locale, String version, ItemData... itemData) throws RiotApiException {

		return StaticDataApi.getDataItem(getRegion(), getKey(), id, locale, version, itemData);
	}

	/**
	 * Get static data: item
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param id
	 *            Item ID
	 * @return A single item
	 * @see Item
	 * @throws RiotApiException
	 */
	public Item getDataItem(Region region, int id) throws RiotApiException {

		return StaticDataApi.getDataItem(region.getName(), getKey(), id, null, null, (ItemData) null);
	}

	/**
	 * Get static data: item
	 * 
	 * @param id
	 *            Item ID
	 * @return A single item
	 * @see Item
	 * @throws RiotApiException
	 */
	public Item getDataItem(int id) throws RiotApiException {

		return StaticDataApi.getDataItem(getRegion(), getKey(), id, null, null, (ItemData) null);
	}

	/**
	 * Get static data: languages
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return A list with languages
	 * @throws RiotApiException
	 */
	public List<String> getDataLanguages(Region region) throws RiotApiException {

		return StaticDataApi.getDataLanguages(region.getName(), getKey());
	}

	/**
	 * Get static data: languages
	 * 
	 * @return A list with languages
	 * @throws RiotApiException
	 */
	public List<String> getDataLanguages() throws RiotApiException {

		return StaticDataApi.getDataLanguages(getRegion(), getKey());
	}

	/**
	 * Get static data: language strings
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param locale
	 *            Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the getDataVersions() method.
	 * @return Language strings
	 * @see LanguageStrings
	 * @throws RiotApiException
	 */
	public LanguageStrings getDataLanguageStrings(Region region, String locale, String version) throws RiotApiException {

		return StaticDataApi.getDataLanguageStrings(region.getName(), getKey(), locale, version);
	}

	/**
	 * Get static data: language strings
	 * 
	 * @param locale
	 *            Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the getDataVersions() method.
	 * @return Language strings
	 * @see LanguageStrings
	 * @throws RiotApiException
	 */
	public LanguageStrings getDataLanguageStrings(String locale, String version) throws RiotApiException {

		return StaticDataApi.getDataLanguageStrings(getRegion(), getKey(), locale, version);
	}

	/**
	 * Get static data: language strings
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return Language strings
	 * @see LanguageStrings
	 * @throws RiotApiException
	 */
	public LanguageStrings getDataLanguageStrings(Region region) throws RiotApiException {

		return StaticDataApi.getDataLanguageStrings(region.getName(), getKey(), null, null);
	}

	/**
	 * Get static data: language strings
	 * 
	 * @return Language strings
	 * @see LanguageStrings
	 * @throws RiotApiException
	 */
	public LanguageStrings getDataLanguageStrings() throws RiotApiException {

		return StaticDataApi.getDataLanguageStrings(getRegion(), getKey(), null, null);
	}

	/**
	 * Get static data: mastery list
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param locale
	 *            Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the getDataVersions() method.
	 * @param masteryListData
	 *            Tags to return additional data. Only type, version, data, id, name, and description are returned by default if this
	 *            parameter isn't specified. To return all additional data, use MasteryListData.ALL.
	 * @return A list with masteries
	 * @see MasteryList
	 * @throws RiotApiException
	 */
	public MasteryList getDataMasteryList(Region region, String locale, String version, MasteryListData... masteryListData) throws RiotApiException {

		return StaticDataApi.getDataMasteryList(region.getName(), getKey(), locale, version, masteryListData);
	}

	/**
	 * Get static data: mastery list
	 * 
	 * @param locale
	 *            Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the getDataVersions() method.
	 * @param masteryListData
	 *            Tags to return additional data. Only type, version, data, id, name, and description are returned by default if this
	 *            parameter isn't specified. To return all additional data, use MasteryListData.ALL.
	 * @return A list with masteries
	 * @see MasteryList
	 * @throws RiotApiException
	 */
	public MasteryList getDataMasteryList(String locale, String version, MasteryListData... masteryListData) throws RiotApiException {

		return StaticDataApi.getDataMasteryList(getRegion(), getKey(), locale, version, masteryListData);
	}

	/**
	 * Get static data: mastery list
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return A list with masteries
	 * @see MasteryList
	 * @throws RiotApiException
	 */
	public MasteryList getDataMasteryList(Region region) throws RiotApiException {

		return StaticDataApi.getDataMasteryList(region.getName(), getKey(), null, null, (MasteryListData) null);
	}

	/**
	 * Get static data: mastery list
	 * 
	 * @return A list with masteries
	 * @see MasteryList
	 * @throws RiotApiException
	 */
	public MasteryList getDataMasteryList() throws RiotApiException {

		return StaticDataApi.getDataMasteryList(getRegion(), getKey(), null, null, (MasteryListData) null);
	}

	/**
	 * Get static data: mastery
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param id
	 *            Mastery ID
	 * @param locale
	 *            Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the getDataVersions() method.
	 * @param masteryData
	 *            Tags to return additional data. Only id, name, and description are returned by default if this parameter isn't specified.
	 *            To return all additional data, use MasteryData.ALL.
	 * @return A single mastery
	 * @see Mastery
	 * @throws RiotApiException
	 */
	public Mastery getDataMastery(Region region, int id, String locale, String version, MasteryData... masteryData) throws RiotApiException {

		return StaticDataApi.getDataMastery(region.getName(), getKey(), id, locale, version, masteryData);
	}

	/**
	 * Get static data: mastery
	 * 
	 * @param id
	 *            Mastery ID
	 * @param locale
	 *            Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the getDataVersions() method.
	 * @param masteryData
	 *            Tags to return additional data. Only id, name, and description are returned by default if this parameter isn't specified.
	 *            To return all additional data, use MasteryData.ALL.
	 * @return A single mastery
	 * @see Mastery
	 * @throws RiotApiException
	 */
	public Mastery getDataMastery(int id, String locale, String version, MasteryData... masteryData) throws RiotApiException {

		return StaticDataApi.getDataMastery(getRegion(), getKey(), id, locale, version, masteryData);
	}

	/**
	 * Get static data: mastery
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param id
	 *            Mastery ID
	 * @return A single mastery
	 * @see Mastery
	 * @throws RiotApiException
	 */
	public Mastery getDataMastery(Region region, int id) throws RiotApiException {

		return StaticDataApi.getDataMastery(region.getName(), getKey(), id, null, null, (MasteryData) null);
	}

	/**
	 * Get static data: mastery
	 * 
	 * @param id
	 *            Mastery ID
	 * @return A single mastery
	 * @see Mastery
	 * @throws RiotApiException
	 */
	public Mastery getDataMastery(int id) throws RiotApiException {

		return StaticDataApi.getDataMastery(getRegion(), getKey(), id, null, null, (MasteryData) null);
	}

	/**
	 * Get static data: realm
	 * 
	 * @param region
	 *            Region corresponding to data to retrieve.
	 * @return A single realm
	 * @see Realm
	 * @throws RiotApiException
	 */
	public Realm getDataRealm(Region region) throws RiotApiException {

		return StaticDataApi.getDataRealm(region.getName(), getKey());
	}

	/**
	 * Get static data: realm
	 * 
	 * @return A single realm
	 * @see Realm
	 * @throws RiotApiException
	 */
	public Realm getDataRealm() throws RiotApiException {

		return StaticDataApi.getDataRealm(getRegion(), getKey());
	}

	/**
	 * Get static data: rune list
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param locale
	 *            Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the getDataVersions() method.
	 * @param runeListData
	 *            Tags to return additional data. Only type, version, data, id, name, rune, and description are returned by default if this
	 *            parameter isn't specified. To return all additional data, use RuneListData.ALL.
	 * @return A list with runes
	 * @see RuneList
	 * @throws RiotApiException
	 */
	public RuneList getDataRuneList(Region region, String locale, String version, RuneListData... runeListData) throws RiotApiException {

		return StaticDataApi.getDataRuneList(region.getName(), getKey(), locale, version, runeListData);
	}

	/**
	 * Get static data: rune list
	 * 
	 * @param locale
	 *            Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the getDataVersions() method.
	 * @param runeListData
	 *            Tags to return additional data. Only type, version, data, id, name, rune, and description are returned by default if this
	 *            parameter isn't specified. To return all additional data, use RuneListData.ALL.
	 * @return A list with runes
	 * @see RuneList
	 * @throws RiotApiException
	 */
	public RuneList getDataRuneList(String locale, String version, RuneListData... runeListData) throws RiotApiException {

		return StaticDataApi.getDataRuneList(getRegion(), getKey(), locale, version, runeListData);
	}

	/**
	 * Get static data: rune list
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return A list with runes
	 * @see RuneList
	 * @throws RiotApiException
	 */
	public RuneList getDataRuneList(Region region) throws RiotApiException {

		return StaticDataApi.getDataRuneList(region.getName(), getKey(), null, null, (RuneListData) null);
	}

	/**
	 * Get static data: rune list
	 * 
	 * @return A list with runes
	 * @see RuneList
	 * @throws RiotApiException
	 */
	public RuneList getDataRuneList() throws RiotApiException {

		return StaticDataApi.getDataRuneList(getRegion(), getKey(), null, null, (RuneListData) null);
	}

	/**
	 * Get static data: rune
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param id
	 *            Rune ID
	 * @param locale
	 *            Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the getDataVersions() method.
	 * @param runeData
	 *            Tags to return additional data. Only id, name, rune, and description are returned by default if this parameter isn't
	 *            specified. To return all additional data, use RuneData.ALL.
	 * @return A single rune
	 * @see Rune
	 * @throws RiotApiException
	 */
	public Rune getDataRune(Region region, int id, String locale, String version, RuneData... runeData) throws RiotApiException {

		return StaticDataApi.getDataRune(region.getName(), getKey(), id, locale, version, runeData);
	}

	/**
	 * Get static data: rune
	 * 
	 * @param id
	 *            Rune ID
	 * @param locale
	 *            Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the getDataVersions() method.
	 * @param runeData
	 *            Tags to return additional data. Only id, name, rune, and description are returned by default if this parameter isn't
	 *            specified. To return all additional data, use RuneData.ALL.
	 * @return A single rune
	 * @see Rune
	 * @throws RiotApiException
	 */
	public Rune getDataRune(int id, String locale, String version, RuneData... runeData) throws RiotApiException {

		return StaticDataApi.getDataRune(getRegion(), getKey(), id, locale, version, runeData);
	}

	/**
	 * Get static data: rune
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param id
	 *            Rune ID
	 * @return A single rune
	 * @see Rune
	 * @throws RiotApiException
	 */
	public Rune getDataRune(Region region, int id) throws RiotApiException {

		return StaticDataApi.getDataRune(region.getName(), getKey(), id, null, null, (RuneData) null);
	}

	/**
	 * Get static data: rune
	 * 
	 * @param id
	 *            Rune ID
	 * @return A single rune
	 * @see Rune
	 * @throws RiotApiException
	 */
	public Rune getDataRune(int id) throws RiotApiException {

		return StaticDataApi.getDataRune(getRegion(), getKey(), id, null, null, (RuneData) null);
	}

	/**
	 * Get static data: summoner spell list
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param locale
	 *            Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the getDataVersions() method.
	 * @param dataById
	 *            If specified as true, the returned data map will use the spells' IDs as the keys. If specified as false, the returned data
	 *            map will use the spells' keys instead
	 * @param spellData
	 *            Tags to return additional data. Only type, version, data, id, key, name, description, and summonerLevel are returned by
	 *            default if this parameter isn't specified. To return all additional data, use SpellData.ALL.
	 * @return A list with summoner spells
	 * @see SummonerSpellList
	 * @throws RiotApiException
	 */
	public SummonerSpellList getDataSummonerSpellList(Region region, String locale, String version, boolean dataById, SpellData... spellData)
			throws RiotApiException {

		return StaticDataApi.getDataSummonerSpellList(region.getName(), getKey(), locale, version, dataById, spellData);
	}

	/**
	 * Get static data: summoner spell list
	 * 
	 * @param locale
	 *            Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the getDataVersions() method.
	 * @param dataById
	 *            If specified as true, the returned data map will use the spells' IDs as the keys. If specified as false, the returned data
	 *            map will use the spells' keys instead
	 * @param spellData
	 *            Tags to return additional data. Only type, version, data, id, key, name, description, and summonerLevel are returned by
	 *            default if this parameter isn't specified. To return all additional data, use SpellData.ALL.
	 * @return A list with summoner spells
	 * @see SummonerSpellList
	 * @throws RiotApiException
	 */
	public SummonerSpellList getDataSummonerSpellList(String locale, String version, boolean dataById, SpellData... spellData) throws RiotApiException {

		return StaticDataApi.getDataSummonerSpellList(getRegion(), getKey(), locale, version, dataById, spellData);
	}

	/**
	 * Get static data: summoner spell list
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return A list with summoner spells
	 * @see SummonerSpellList
	 * @throws RiotApiException
	 */
	public SummonerSpellList getDataSummonerSpellList(Region region) throws RiotApiException {

		return StaticDataApi.getDataSummonerSpellList(region.getName(), getKey(), null, null, false, (SpellData) null);
	}

	/**
	 * Get static data: summoner spell list
	 * 
	 * @return A list with summoner spells
	 * @see SummonerSpellList
	 * @throws RiotApiException
	 */
	public SummonerSpellList getDataSummonerSpellList() throws RiotApiException {

		return StaticDataApi.getDataSummonerSpellList(getRegion(), getKey(), null, null, false, (SpellData) null);
	}

	/**
	 * Get static data: summoner spell
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param id
	 *            Summoner spell ID
	 * @param locale
	 *            Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the getDataVersions() method.
	 * @param spellData
	 *            Tags to return additional data. Only id, key, name, description, and summonerLevel are returned by default if this
	 *            parameter isn't specified. To return all additional data, use SpellData.ALL.
	 * @return A single summoner spell
	 * @see SummonerSpell
	 * @throws RiotApiException
	 */
	public SummonerSpell getDataSummonerSpell(Region region, int id, String locale, String version, SpellData... spellData) throws RiotApiException {

		return StaticDataApi.getDataSummonerSpell(region.getName(), getKey(), id, locale, version, spellData);
	}

	/**
	 * Get static data: summoner spell
	 * 
	 * @param id
	 *            Summoner spell ID
	 * @param locale
	 *            Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the getDataVersions() method.
	 * @param spellData
	 *            Tags to return additional data. Only id, key, name, description, and summonerLevel are returned by default if this
	 *            parameter isn't specified. To return all additional data, use SpellData.ALL.
	 * @return A single summoner spell
	 * @see SummonerSpell
	 * @throws RiotApiException
	 */
	public SummonerSpell getDataSummonerSpell(int id, String locale, String version, SpellData... spellData) throws RiotApiException {

		return StaticDataApi.getDataSummonerSpell(getRegion(), getKey(), id, locale, version, spellData);
	}

	/**
	 * Get static data: summoner spell
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param id
	 *            Summoner spell ID
	 * @return A single summoner spell
	 * @see SummonerSpell
	 * @throws RiotApiException
	 */
	public SummonerSpell getDataSummonerSpell(Region region, int id) throws RiotApiException {

		return StaticDataApi.getDataSummonerSpell(region.getName(), getKey(), id, null, null, (SpellData) null);
	}

	/**
	 * Get static data: summoner spell
	 * 
	 * @param id
	 *            Summoner spell ID
	 * @return A single summoner spell
	 * @see SummonerSpell
	 * @throws RiotApiException
	 */
	public SummonerSpell getDataSummonerSpell(int id) throws RiotApiException {

		return StaticDataApi.getDataSummonerSpell(getRegion(), getKey(), id, null, null, (SpellData) null);
	}

	/**
	 * Get static data: versions
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return A list with versions
	 * @throws RiotApiException
	 */
	public List<String> getDataVersions(Region region) throws RiotApiException {

		return StaticDataApi.getDataVersions(region.getName(), getKey());
	}

	/**
	 * Get static data: versions
	 * 
	 * @return A list with versions
	 * @throws RiotApiException
	 */
	public List<String> getDataVersions() throws RiotApiException {

		return StaticDataApi.getDataVersions(getRegion(), getKey());
	}

	/**
	 * Get status data: shard list
	 * 
	 * @return Status for a list of shards
	 * @see Shard
	 * @throws RiotApiException
	 */
	public List<Shard> getShards() throws RiotApiException {

		return StatusApi.getShards();
	}

	/**
	 * Get status data: shard
	 * 
	 * @param region
	 *            The region for which to fetch data.
	 * @return Status for a single shard
	 * @see ShardStatus
	 * @throws RiotApiException
	 */
	public ShardStatus getShardStatus(Region region) throws RiotApiException {

		return StatusApi.getShardStatus(region.getName());
	}

	/**
	 * Get status data: shard
	 * 
	 * @return Status for a single shard
	 * @see ShardStatus
	 * @throws RiotApiException
	 */
	public ShardStatus getShardStatus() throws RiotApiException {

		return StatusApi.getShardStatus(getRegion());
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
    
    @Override
    public RiotApi clone() {
    	return new RiotApi(this.key, this.region);
    }
}