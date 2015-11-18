package main.java.riotapi;

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
import dto.Champion.Champion;
import dto.CurrentGame.CurrentGameInfo;
import dto.FeaturedGames.FeaturedGames;
import dto.Game.RecentGames;
import dto.League.League;
import dto.Match.MatchDetail;
import dto.MatchList.MatchList;
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
import dto.Team.Team;

/**
 * Riot Games API Java Library - riot-api-java
 * 
 * @author Taylor 'rithms' Caldwell - http://rithms.net
 * @version 3.7.0
 */
public class RiotApi {

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
	 * Retrieve all champions.
	 *
	 * @return A list of all the champions for the set region
	 * @see dto.Champion.ChampionList
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public dto.Champion.ChampionList getChampions() throws RiotApiException {

		return ChampionApi.getChampions(getRegion(), getKey());
	}

	/**
	 * Retrieve all champions.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @return A list of champions for the given region
	 * @see dto.Champion.ChampionList
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public dto.Champion.ChampionList getChampions(Region region) throws RiotApiException {

		return ChampionApi.getChampions(region, getKey());
	}

	/**
	 * Retrieve all champions.
	 *
	 * @param freeToPlay
	 *            Optional filter param to retrieve only free to play champions.
	 * @return A list of champions for the set region
	 * @see dto.Champion.ChampionList
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public dto.Champion.ChampionList getChampions(boolean freeToPlay) throws RiotApiException {

		return ChampionApi.getChampions(getRegion(), getKey(), freeToPlay);
	}

	/**
	 * Retrieve all champions.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param freeToPlay
	 *            Optional filter param to retrieve only free to play champions.
	 * @return A list of champions for the given region
	 * @see dto.Champion.ChampionList
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public dto.Champion.ChampionList getChampions(Region region, boolean freeToPlay) throws RiotApiException {

		return ChampionApi.getChampions(region, getKey(), freeToPlay);
	}

	/**
	 * Retrieve all champions that are free-to-play.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @return A list of all the free to play champions for the given region
	 * @see dto.Champion.ChampionList
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public dto.Champion.ChampionList getFreeToPlayChampions(Region region) throws RiotApiException {

		return ChampionApi.getChampions(region, getKey(), true);
	}

	/**
	 * Retrieve all champions that are free-to-play.
	 *
	 * @return A list of all the free to play champions for the set region
	 * @see dto.Champion.ChampionList
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public dto.Champion.ChampionList getFreeToPlayChampions() throws RiotApiException {

		return ChampionApi.getChampions(getRegion(), getKey(), true);
	}

	/**
	 * Retrieve champion by ID.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param champId
	 *            The ID of the desired champion
	 * @return The champion of the given ID
	 * @see Champion
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Champion getChampionById(Region region, int champId) throws RiotApiException {

		return ChampionApi.getChampionById(region, getKey(), champId);
	}

	/**
	 * Retrieve champion by ID.
	 *
	 * @param champId
	 *            The ID of the desired champion
	 * @return The champion of the given ID
	 * @see Champion
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Champion getChampionById(int champId) throws RiotApiException {

		return ChampionApi.getChampionById(getRegion(), getKey(), champId);
	}

	/**
	 * Get leagues for a given summoner ID.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerId
	 *            ID of the summoner for which to retrieve recent games.
	 * @return Recent games of the given summoner
	 * @see RecentGames
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public RecentGames getRecentGames(Region region, long summonerId) throws RiotApiException {

		return GameApi.getRecentGames(region, getKey(), summonerId);
	}

	/**
	 * Get leagues for a given summoner ID.
	 *
	 * @param summonerId
	 *            ID of the summoner for which to retrieve recent games.
	 * @return Recent games of the given summoner
	 * @see RecentGames
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public RecentGames getRecentGames(long summonerId) throws RiotApiException {

		return GameApi.getRecentGames(getRegion(), getKey(), summonerId);
	}

	/**
	 * Get leagues for a given summoner ID.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerId
	 *            ID of the summoner for which to retrieve recent games.
	 * @return Recent games of the given summoner
	 * @see RecentGames
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public RecentGames getRecentGames(Region region, String summonerId) throws RiotApiException {

		return GameApi.getRecentGames(region, getKey(), summonerId);
	}

	/**
	 * Get leagues for a given summoner ID.
	 *
	 * @param summonerId
	 *            ID of the summoner for which to retrieve recent games.
	 * @return Recent games of the given summoner
	 * @see RecentGames
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public RecentGames getRecentGames(String summonerId) throws RiotApiException {

		return GameApi.getRecentGames(getRegion(), getKey(), summonerId);
	}

	/**
	 * Get a list of leagues for a summoner
	 * 
	 * @param region
	 *            The region of the leagues.
	 * @param summonerId
	 *            Summoner ID
	 * @return A list of leagues
	 * @see League
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public List<League> getLeagueBySummoner(Region region, long summonerId) throws RiotApiException {

		return LeagueApi.getLeagueBySummoners(region, getKey(), summonerId).get(Long.toString(summonerId));
	}

	/**
	 * Get leagues for a given summoner ID.
	 * 
	 * @param summonerId
	 *            Summoner ID
	 * @return A list of leagues
	 * @see League
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public List<League> getLeagueBySummoner(long summonerId) throws RiotApiException {

		return LeagueApi.getLeagueBySummoners(getRegion(), getKey(), summonerId).get(Long.toString(summonerId));
	}

	/**
	 * Get a list of leagues for a summoner
	 * 
	 * @param region
	 *            The region of the leagues.
	 * @param summonerId
	 *            Summoner ID
	 * @return A list of leagues
	 * @see League
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public List<League> getLeagueBySummoner(Region region, String summonerId) throws RiotApiException {

		return LeagueApi.getLeagueBySummoners(region, getKey(), summonerId).get(summonerId);
	}

	/**
	 * Get a list of leagues for a summoner
	 * 
	 * @param summonerId
	 *            Summoner ID
	 * @return A list of leagues
	 * @see League
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public List<League> getLeagueBySummoner(String summonerId) throws RiotApiException {
		return LeagueApi.getLeagueBySummoners(getRegion(), getKey(), summonerId).get(summonerId);
	}

	/**
	 * Get leagues mapped by summoner ID for a given list of summoner IDs.
	 * 
	 * @param region
	 *            The region of the leagues.
	 * @param summonerIds
	 *            List of summoner IDs. Maximum allowed at once is 10.
	 * @return A map, mapping each summoner ID to a list of leagues
	 * @see League
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, List<League>> getLeagueBySummoners(Region region, long... summonerIds) throws RiotApiException {

		return LeagueApi.getLeagueBySummoners(region, getKey(), summonerIds);
	}

	/**
	 * Get leagues mapped by summoner ID for a given list of summoner IDs.
	 * 
	 * @param summonerIds
	 *            List of summoner IDs. Maximum allowed at once is 10.
	 * @return A map, mapping each summoner ID to a list of leagues
	 * @see League
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, List<League>> getLeagueBySummoners(long... summonerIds) throws RiotApiException {

		return LeagueApi.getLeagueBySummoners(getRegion(), getKey(), summonerIds);
	}

	/**
	 * Get a list of leagues for multiple summoners
	 * 
	 * @param region
	 *            The region of the leagues.
	 * @param summonerIds
	 *            List of summoner IDs. Maximum allowed at once is 10.
	 * @return A map, mapping each summoner ID to a list of leagues
	 * @see League
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, List<League>> getLeagueBySummoners(Region region, String summonerIds) throws RiotApiException {

		return LeagueApi.getLeagueBySummoners(region, getKey(), summonerIds);
	}

	/**
	 * Get league entries mapped by summoner ID for a given list of summoner IDs.
	 * 
	 * @param summonerIds
	 *            List of summoner IDs. Maximum allowed at once is 10.
	 * @return A map, mapping each summoner ID to a list of leagues
	 * @see League
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, List<League>> getLeagueBySummoners(String summonerIds) throws RiotApiException {
		return LeagueApi.getLeagueBySummoners(getRegion(), getKey(), summonerIds);
	}

	/**
	 * Get league entries for a given summoner ID.
	 * 
	 * @param region
	 *            The region of the leagues.
	 * @param summonerId
	 *            Summoner ID
	 * @return A list of leagues
	 * @see League
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public List<League> getLeagueEntryBySummoner(Region region, long summonerId) throws RiotApiException {

		return LeagueApi.getLeagueEntryBySummoners(region, getKey(), summonerId).get(Long.toString(summonerId));
	}

	/**
	 * Get league entries for a given summoner ID.
	 * 
	 * @param summonerId
	 *            Summoner ID
	 * @return A list of leagues
	 * @see League
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public List<League> getLeagueEntryBySummoner(long summonerId) throws RiotApiException {

		return LeagueApi.getLeagueEntryBySummoners(getRegion(), getKey(), summonerId).get(Long.toString(summonerId));
	}

	/**
	 * Get league entries for a given summoner ID.
	 * 
	 * @param region
	 *            The region of the leagues.
	 * @param summonerId
	 *            Summoner ID
	 * @return A list of leagues
	 * @see League
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public List<League> getLeagueEntryBySummoner(Region region, String summonerId) throws RiotApiException {

		return LeagueApi.getLeagueEntryBySummoners(region, getKey(), summonerId).get(summonerId);
	}

	/**
	 * Get league entries for a given summoner ID.
	 * 
	 * @param summonerId
	 *            Summoner ID
	 * @return A list of leagues
	 * @see League
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public List<League> getLeagueEntryBySummoner(String summonerId) throws RiotApiException {

		return LeagueApi.getLeagueEntryBySummoners(getRegion(), getKey(), summonerId).get(summonerId);
	}

	/**
	 * Get league entries mapped by summoner ID for a given list of summoner IDs.
	 * 
	 * @param region
	 *            The region of the leagues.
	 * @param summonerIds
	 *            List of summoner IDs. Maximum allowed at once is 10.
	 * @return A map, mapping each summoner ID to a list of leagues
	 * @see League
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, List<League>> getLeagueEntryBySummoners(Region region, long... summonerIds) throws RiotApiException {

		return LeagueApi.getLeagueEntryBySummoners(region, getKey(), summonerIds);
	}

	/**
	 * Get league entries mapped by summoner ID for a given list of summoner IDs.
	 * 
	 * @param summonerIds
	 *            List of summoner IDs. Maximum allowed at once is 10.
	 * @return A map, mapping each summoner ID to a list of leagues
	 * @see League
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, List<League>> getLeagueEntryBySummoners(long... summonerIds) throws RiotApiException {

		return LeagueApi.getLeagueEntryBySummoners(getRegion(), getKey(), summonerIds);
	}

	/**
	 * Get league entries mapped by summoner ID for a given list of summoner IDs.
	 * 
	 * @param region
	 *            The region of the leagues.
	 * @param summonerIds
	 *            List of summoner IDs. Maximum allowed at once is 10.
	 * @return A map, mapping each summoner ID to a list of leagues
	 * @see League
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, List<League>> getLeagueEntryBySummoners(Region region, String summonerIds) throws RiotApiException {

		return LeagueApi.getLeagueEntryBySummoners(region, getKey(), summonerIds);
	}

	/**
	 * Get league entries mapped by summoner ID for a given list of summoner IDs.
	 * 
	 * @param summonerIds
	 *            List of summoner IDs. Maximum allowed at once is 10.
	 * @return A map, mapping each summoner ID to a list of leagues
	 * @see League
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, List<League>> getLeagueEntryBySummoners(String summonerIds) throws RiotApiException {

		return LeagueApi.getLeagueEntryBySummoners(getRegion(), getKey(), summonerIds);
	}

	/**
	 * Get leagues for a given team ID.
	 * 
	 * @param region
	 *            The region of the leagues.
	 * @param teamId
	 *            Team ID
	 * @return A list of leagues
	 * @see League
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public List<League> getLeagueByTeam(Region region, String teamId) throws RiotApiException {

		return LeagueApi.getLeagueByTeams(region, getKey(), teamId).get(teamId);
	}

	/**
	 * Get leagues for a given team ID.
	 * 
	 * @param teamId
	 *            Team ID
	 * @return A list of leagues
	 * @see League
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public List<League> getLeagueByTeam(String teamId) throws RiotApiException {

		return LeagueApi.getLeagueByTeams(getRegion(), getKey(), teamId).get(teamId);
	}

	/**
	 * Get leagues mapped by team ID for a given list of team IDs.
	 * 
	 * @param region
	 *            The region of the leagues.
	 * @param teamIds
	 *            List of team IDs. Maximum allowed at once is 10.
	 * @return A map, mapping each team ID to a list of leagues
	 * @see League
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, List<League>> getLeagueByTeams(Region region, String teamIds) throws RiotApiException {

		return LeagueApi.getLeagueByTeams(region, getKey(), teamIds);
	}

	/**
	 * Get leagues mapped by team ID for a given list of team IDs.
	 * 
	 * @param teamIds
	 *            List of team IDs. Maximum allowed at once is 10.
	 * @return A map, mapping each team ID to a list of leagues
	 * @see League
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, List<League>> getLeagueByTeams(String teamIds) throws RiotApiException {

		return LeagueApi.getLeagueByTeams(getRegion(), getKey(), teamIds);
	}

	/**
	 * Get league entries for a given team ID.
	 * 
	 * @param region
	 *            The region of the leagues.
	 * @param teamId
	 *            Team ID
	 * @return A list of leagues
	 * @see League
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public List<League> getLeagueEntryByTeam(Region region, String teamId) throws RiotApiException {

		return LeagueApi.getLeagueEntryByTeams(region, getKey(), teamId).get(teamId);
	}

	/**
	 * Get league entries for a given team ID.
	 * 
	 * @param teamIds
	 *            List of team IDs. Maximum allowed at once is 10.
	 * @return A list of leagues
	 * @see League
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public List<League> getLeagueEntryByTeam(String teamId) throws RiotApiException {

		return LeagueApi.getLeagueEntryByTeams(getRegion(), getKey(), teamId).get(teamId);
	}

	/**
	 * Get league entries mapped by team ID for a given list of team IDs.
	 * 
	 * @param region
	 *            The region of the leagues.
	 * @param teamIds
	 *            List of team IDs. Maximum allowed at once is 10.
	 * @return A map, mapping each team ID to a list of leagues
	 * @see League
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, List<League>> getLeagueEntryByTeams(Region region, String teamIds) throws RiotApiException {

		return LeagueApi.getLeagueEntryByTeams(region, getKey(), teamIds);
	}

	/**
	 * Get league entries mapped by team ID for a given list of team IDs.
	 * 
	 * @param teamIds
	 *            List of team IDs. Maximum allowed at once is 10.
	 * @return A map, mapping each team ID to a list of leagues
	 * @see League
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, List<League>> getLeagueEntryByTeams(String teamIds) throws RiotApiException {

		return LeagueApi.getLeagueEntryByTeams(getRegion(), getKey(), teamIds);
	}

	/**
	 * Get challenger tier leagues.
	 * 
	 * @param region
	 *            The region of the leagues.
	 * @return A single league
	 * @see League
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public League getChallengerLeague(Region region) throws RiotApiException {

		return LeagueApi.getChallengerLeague(region, getKey());
	}

	/**
	 * Get challenger tier leagues.
	 * 
	 * @return A single league
	 * @see League
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public League getChallengerLeague() throws RiotApiException {

		return LeagueApi.getChallengerLeague(getRegion(), getKey());
	}

	/**
	 * Get challenger tier leagues.
	 * 
	 * @param region
	 *            The region of the leagues.
	 * @param queueType
	 *            Game queue type.
	 * @return A single league
	 * @see League
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public League getChallengerLeague(Region region, QueueType queueType) throws RiotApiException {

		return LeagueApi.getChallengerLeague(region, getKey(), queueType);
	}

	/**
	 * Get challenger tier leagues.
	 * 
	 * @param queueType
	 *            Game queue type.
	 * @return A single league
	 * @see League
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public League getChallengerLeague(QueueType queueType) throws RiotApiException {

		return LeagueApi.getChallengerLeague(getRegion(), getKey(), queueType);
	}

	/**
	 * Get master tier leagues.
	 * 
	 * @param region
	 *            The region of the leagues.
	 * @return A single league
	 * @see League
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public League getMasterLeague(Region region) throws RiotApiException {

		return LeagueApi.getMasterLeague(region, getKey());
	}

	/**
	 * Get master tier leagues.
	 * 
	 * @return A single league
	 * @see League
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public League getMasterLeague() throws RiotApiException {

		return LeagueApi.getMasterLeague(getRegion(), getKey());
	}

	/**
	 * Get master tier leagues.
	 * 
	 * @param region
	 *            The region of the leagues.
	 * @param queueType
	 *            Game queue type.
	 * @return A single league
	 * @see League
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public League getMasterLeague(Region region, QueueType queueType) throws RiotApiException {

		return LeagueApi.getMasterLeague(region, getKey(), queueType);
	}

	/**
	 * Get master tier leagues.
	 * 
	 * @param queueType
	 *            Game queue type.
	 * @return A single league
	 * @see League
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public League getMasterLeague(QueueType queueType) throws RiotApiException {

		return LeagueApi.getMasterLeague(getRegion(), getKey(), queueType);
	}

	/**
	 * Get player stats summaries by summoner ID.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerId
	 *            ID of the summoner for which to retrieve player stats.
	 * @param season
	 *            If specified, stats for the given season are returned. Otherwise, stats for the current season are returned.
	 * @return A summary of player statistics for the given summoner
	 * @see PlayerStatsSummaryList
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public PlayerStatsSummaryList getPlayerStatsSummary(Region region, Season season, long summonerId) throws RiotApiException {

		return StatsApi.getPlayerStatsSummary(region, season, getKey(), summonerId);
	}

	/**
	 * Get player stats summaries by summoner ID.
	 *
	 * @param summonerId
	 *            ID of the summoner for which to retrieve player stats.
	 * @param season
	 *            If specified, stats for the given season are returned. Otherwise, stats for the current season are returned.
	 * @return A summary of player statistics for the given summoner
	 * @see PlayerStatsSummaryList
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public PlayerStatsSummaryList getPlayerStatsSummary(Season season, long summonerId) throws RiotApiException {

		return StatsApi.getPlayerStatsSummary(getRegion(), season, getKey(), summonerId);
	}

	/**
	 * Get player stats summaries by summoner ID.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerId
	 *            ID of the summoner for which to retrieve player stats.
	 * @return A summary of player statistics for the given summoner
	 * @see PlayerStatsSummaryList
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public PlayerStatsSummaryList getPlayerStatsSummary(Region region, long summonerId) throws RiotApiException {

		return StatsApi.getPlayerStatsSummary(region, getSeason(), getKey(), summonerId);
	}

	/**
	 * Get player stats summaries by summoner ID.
	 *
	 * @param summonerId
	 *            ID of the summoner for which to retrieve player stats.
	 * @return A summary of player statistics for the given summoner
	 * @see PlayerStatsSummaryList
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public PlayerStatsSummaryList getPlayerStatsSummary(long summonerId) throws RiotApiException {

		return StatsApi.getPlayerStatsSummary(getRegion(), getSeason(), getKey(), summonerId);
	}

	/**
	 * Get ranked stats by summoner ID.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerId
	 *            ID of the summoner for which to retrieve ranked stats.
	 * @param season
	 *            If specified, stats for the given season are returned. Otherwise, stats for the current season are returned.
	 * @return Ranked statistics of the given summoner
	 * @see RankedStats
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public RankedStats getRankedStats(Region region, Season season, long summonerId) throws RiotApiException {

		return StatsApi.getRankedStats(region, season, getKey(), summonerId);
	}

	/**
	 * Get ranked stats by summoner ID.
	 *
	 * @param summonerId
	 *            ID of the summoner for which to retrieve ranked stats.
	 * @param season
	 *            If specified, stats for the given season are returned. Otherwise, stats for the current season are returned.
	 * @return Ranked statistics of the given summoner
	 * @see RankedStats
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public RankedStats getRankedStats(Season season, long summonerId) throws RiotApiException {

		return StatsApi.getRankedStats(getRegion(), season, getKey(), summonerId);
	}

	/**
	 * Get ranked stats by summoner ID.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerId
	 *            ID of the summoner for which to retrieve ranked stats.
	 * @return Ranked statistics of the given summoner
	 * @see RankedStats
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public RankedStats getRankedStats(Region region, long summonerId) throws RiotApiException {

		return StatsApi.getRankedStats(region, getSeason(), getKey(), summonerId);
	}

	/**
	 * Get ranked stats by summoner ID.
	 *
	 * @param summonerId
	 *            ID of the summoner for which to retrieve ranked stats.
	 * @return Ranked statistics of the given summoner
	 * @see RankedStats
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public RankedStats getRankedStats(long summonerId) throws RiotApiException {

		return StatsApi.getRankedStats(getRegion(), getSeason(), getKey(), summonerId);
	}

	/**
	 * Get mastery pages for a given summoner ID.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerId
	 *            Summoner ID associated with masteries to retrieve.
	 * @return A map of mastery pages of the given summoner
	 * @see MasteryPages
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public MasteryPages getMasteryPages(Region region, long summonerId) throws RiotApiException {

		return SummonerApi.getMasteryPages(region, getKey(), summonerId).get(Long.toString(summonerId));
	}

	/**
	 * Get mastery pages for a given summoner ID.
	 *
	 * @param summonerId
	 *            Summoner ID associated with masteries to retrieve.
	 * @return A map of mastery pages of the given summoner
	 * @see MasteryPages
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public MasteryPages getMasteryPages(long summonerId) throws RiotApiException {

		return SummonerApi.getMasteryPages(getRegion(), getKey(), summonerId).get(Long.toString(summonerId));
	}

	/**
	 * Get mastery pages mapped by summoner ID for a given list of summoner IDs.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerIds
	 *            Comma-separated list of summoner IDs associated with masteries to retrieve. Maximum allowed at once is 40.
	 * @return A map of mastery pages of the given summoners
	 * @see MasteryPages
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, MasteryPages> getMasteryPages(Region region, String summonerIds) throws RiotApiException {

		return SummonerApi.getMasteryPages(region, getKey(), summonerIds);
	}

	/**
	 * Get mastery pages mapped by summoner ID for a given list of summoner IDs.
	 *
	 * @param summonerIds
	 *            Comma-separated list of summoner IDs associated with masteries to retrieve. Maximum allowed at once is 40.
	 * @return A map of mastery pages of the given summoners
	 * @see MasteryPages
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, MasteryPages> getMasteryPages(String summonerIds) throws RiotApiException {

		return SummonerApi.getMasteryPages(getRegion(), getKey(), summonerIds);
	}

	/**
	 * Get mastery pages mapped by summoner ID for a given list of summoner IDs.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerIds
	 *            List of summoner IDs associated with masteries to retrieve. Maximum allowed at once is 40.
	 * @return A map of mastery pages of the given summoners
	 * @see MasteryPages
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, MasteryPages> getMasteryPages(Region region, long... summonerIds) throws RiotApiException {

		return SummonerApi.getMasteryPages(region, getKey(), summonerIds);
	}

	/**
	 * Get mastery pages mapped by summoner ID for a given list of summoner IDs.
	 *
	 * @param summonerIds
	 *            List of summoner IDs associated with masteries to retrieve. Maximum allowed at once is 40.
	 * @return A map of mastery pages of the given summoners
	 * @see MasteryPages
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, MasteryPages> getMasteryPages(long... summonerIds) throws RiotApiException {

		return SummonerApi.getMasteryPages(getRegion(), getKey(), summonerIds);
	}

	/**
	 * Get rune pages for a given summoner ID.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerId
	 *            Summoner ID associated with runes to retrieve.
	 * @return A map of rune pages of the given summoner
	 * @see RunePages
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public RunePages getRunePages(Region region, long summonerId) throws RiotApiException {

		return SummonerApi.getRunePages(region, getKey(), summonerId).get(Long.toString(summonerId));
	}

	/**
	 * Get rune pages for a given summoner ID.
	 *
	 * @param summonerId
	 *            Summoner ID associated with runes to retrieve.
	 * @return A map of rune pages of the given summoner
	 * @see RunePages
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public RunePages getRunePages(long summonerId) throws RiotApiException {

		return SummonerApi.getRunePages(getRegion(), getKey(), summonerId).get(Long.toString(summonerId));
	}

	/**
	 * Get rune pages mapped by summoner ID for a given list of summoner IDs.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerIds
	 *            Comma-separated list of summoner IDs associated with runes to retrieve. Maximum allowed at once is 40.
	 * @return A map of rune pages of the given summoners
	 * @see RunePages
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, RunePages> getRunePages(Region region, String summonerIds) throws RiotApiException {

		return SummonerApi.getRunePages(region, getKey(), summonerIds);
	}

	/**
	 * Get rune pages mapped by summoner ID for a given list of summoner IDs.
	 *
	 * @param summonerIds
	 *            Comma-separated list of summoner IDs associated with runes to retrieve. Maximum allowed at once is 40.
	 * @return A map of rune pages of the given summoners
	 * @see RunePages
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, RunePages> getRunePages(String summonerIds) throws RiotApiException {

		return SummonerApi.getRunePages(getRegion(), getKey(), summonerIds);
	}

	/**
	 * Get rune pages mapped by summoner ID for a given list of summoner IDs.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerIds
	 *            List of summoner IDs associated with runes to retrieve. Maximum allowed at once is 40.
	 * @return A map of rune pages of the given summoners
	 * @see RunePages
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, RunePages> getRunePages(Region region, long... summonerIds) throws RiotApiException {

		return SummonerApi.getRunePages(region, getKey(), summonerIds);
	}

	/**
	 * Get rune pages mapped by summoner ID for a given list of summoner IDs.
	 *
	 * @param summonerIds
	 *            List of summoner IDs associated with runes to retrieve. Maximum allowed at once is 40.
	 * @return A map of rune pages of the given summoners
	 * @see RunePages
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, RunePages> getRunePages(long... summonerIds) throws RiotApiException {

		return SummonerApi.getRunePages(getRegion(), getKey(), summonerIds);
	}

	/**
	 * Get a single summoner object for a given summoner name.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerName
	 *            Summoner name or standardized summoner name associated with summoner to retrieve.
	 * @return The desired summoner
	 * @see Summoner
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Summoner getSummonerByName(Region region, String summonerName) throws RiotApiException {

		Map<String, Summoner> summoners = SummonerApi.getSummonersByName(region, getKey(), summonerName);
		String key = summonerName.toLowerCase().replaceAll("\\s+", "");
		if (!summoners.containsKey(key)) {
			throw new RiotApiException(RiotApiException.DATA_NOT_FOUND);
		}
		return summoners.get(key);
	}

	/**
	 * Get a single summoner object for a given summoner name.
	 *
	 * @param summonerName
	 *            Summoner name or standardized summoner name associated with summoner to retrieve.
	 * @return The desired summoner
	 * @see Summoner
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Summoner getSummonerByName(String summonerName) throws RiotApiException {

		Map<String, Summoner> summoners = SummonerApi.getSummonersByName(getRegion(), getKey(), summonerName);
		String key = summonerName.toLowerCase().replaceAll("\\s+", "");
		if (!summoners.containsKey(key)) {
			throw new RiotApiException(RiotApiException.DATA_NOT_FOUND);
		}
		return summoners.get(key);
	}

	/**
	 * Get summoner objects mapped by standardized summoner name for a given list of summoner names.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerNames
	 *            Comma-separated list of summoner names or standardized summoner names associated with summoners to retrieve. Maximum
	 *            allowed at once is 40.
	 * @return A map of desired summoners
	 * @see Summoner
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, Summoner> getSummonersByName(Region region, String summonerNames) throws RiotApiException {

		return SummonerApi.getSummonersByName(region, getKey(), summonerNames);
	}

	/**
	 * Get summoner objects mapped by standardized summoner name for a given list of summoner names.
	 *
	 * @param summonerNames
	 *            Comma-separated list of summoner names or standardized summoner names associated with summoners to retrieve. Maximum
	 *            allowed at once is 40.
	 * @return A map of desired summoners
	 * @see Summoner
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, Summoner> getSummonersByName(String summonerNames) throws RiotApiException {

		return SummonerApi.getSummonersByName(getRegion(), getKey(), summonerNames);
	}

	/**
	 * Get a summoner objects for a given summoner ID.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerId
	 *            Summoner IDs associated with summoner to retrieve.
	 * @return The desired summoner
	 * @see Summoner
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Summoner getSummonerById(Region region, long summonerId) throws RiotApiException {

		Map<String, Summoner> summoners = SummonerApi.getSummonersById(region, getKey(), summonerId);
		if (!summoners.containsKey(String.valueOf(summonerId))) {
			throw new RiotApiException(RiotApiException.DATA_NOT_FOUND);
		}
		return summoners.get(String.valueOf(summonerId));
	}

	/**
	 * Get a summoner objects for a given summoner ID.
	 *
	 * @param summonerId
	 *            Summoner IDs associated with summoner to retrieve.
	 * @return The desired summoner
	 * @see Summoner
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Summoner getSummonerById(long summonerId) throws RiotApiException {

		Map<String, Summoner> summoners = SummonerApi.getSummonersById(getRegion(), getKey(), summonerId);
		if (!summoners.containsKey(String.valueOf(summonerId))) {
			throw new RiotApiException(RiotApiException.DATA_NOT_FOUND);
		}
		return summoners.get(String.valueOf(summonerId));
	}

	/**
	 * Get a summoner objects for a given summoner ID.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerId
	 *            Summoner IDs associated with summoner to retrieve.
	 * @return The desired summoner
	 * @see Summoner
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Summoner getSummonerById(Region region, String summonerId) throws RiotApiException {

		Map<String, Summoner> summoners = SummonerApi.getSummonersById(region, getKey(), summonerId);
		if (!summoners.containsKey(summonerId)) {
			throw new RiotApiException(RiotApiException.DATA_NOT_FOUND);
		}
		return summoners.get(summonerId);
	}

	/**
	 * Get a summoner objects for a given summoner ID.
	 *
	 * @param summonerId
	 *            Summoner IDs associated with summoner to retrieve.
	 * @return The desired summoner
	 * @see Summoner
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Summoner getSummonerById(String summonerId) throws RiotApiException {

		Map<String, Summoner> summoners = SummonerApi.getSummonersById(getRegion(), getKey(), summonerId);
		if (!summoners.containsKey(summonerId)) {
			throw new RiotApiException(RiotApiException.DATA_NOT_FOUND);
		}
		return summoners.get(summonerId);
	}

	/**
	 * Get summoner objects mapped by summoner ID for a given list of summoner IDs.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerIds
	 *            List of summoner IDs associated with summoners to retrieve. Maximum allowed at once is 40.
	 * @return A map of desired summoners
	 * @see Summoner
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, Summoner> getSummonersById(Region region, long... summonerIds) throws RiotApiException {

		return SummonerApi.getSummonersById(region, getKey(), summonerIds);
	}

	/**
	 * Get summoner objects mapped by summoner ID for a given list of summoner IDs.
	 *
	 * @param summonerIds
	 *            List of summoner IDs associated with summoners to retrieve. Maximum allowed at once is 40.
	 * @return A map of desired summoners
	 * @see Summoner
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, Summoner> getSummonersById(long... summonerIds) throws RiotApiException {

		return SummonerApi.getSummonersById(getRegion(), getKey(), summonerIds);
	}

	/**
	 * Get summoner objects mapped by summoner ID for a given list of summoner IDs.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerIds
	 *            Comma-separated list of summoner IDs associated with summoners to retrieve. Maximum allowed at once is 40.
	 * @return A map of desired summoners
	 * @see Summoner
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, Summoner> getSummonersById(Region region, String summonerIds) throws RiotApiException {

		return SummonerApi.getSummonersById(region, getKey(), summonerIds);
	}

	/**
	 * Get summoner objects mapped by summoner ID for a given list of summoner IDs.
	 *
	 * @param summonerIds
	 *            Comma-separated list of summoner IDs associated with summoners to retrieve. Maximum allowed at once is 40.
	 * @return A map of desired summoners
	 * @see Summoner
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, Summoner> getSummonersById(String summonerIds) throws RiotApiException {

		return SummonerApi.getSummonersById(getRegion(), getKey(), summonerIds);
	}

	/**
	 * Get summoner name for a given summoner ID.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerId
	 *            Summoner ID associated with summoner name to retrieve.
	 * @return The desired summoner name
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public String getSummonerName(Region region, long summonerId) throws RiotApiException {

		Map<String, String> summoners = SummonerApi.getSummonerNames(region, getKey(), summonerId);
		if (!summoners.containsKey(String.valueOf(summonerId))) {
			throw new RiotApiException(RiotApiException.DATA_NOT_FOUND);
		}
		return summoners.get(String.valueOf(summonerId));
	}

	/**
	 * Get summoner name for a given summoner ID.
	 *
	 * @param summonerId
	 *            Summoner ID associated with summoner name to retrieve.
	 * @return The desired summoner name
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public String getSummonerName(long summonerId) throws RiotApiException {

		Map<String, String> summoners = SummonerApi.getSummonerNames(getRegion(), getKey(), summonerId);
		if (!summoners.containsKey(String.valueOf(summonerId))) {
			throw new RiotApiException(RiotApiException.DATA_NOT_FOUND);
		}
		return summoners.get(String.valueOf(summonerId));
	}

	/**
	 * Get summoner name for a given summoner ID.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerId
	 *            Summoner ID associated with summoner name to retrieve.
	 * @return The desired summoner name
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public String getSummonerName(Region region, String summonerId) throws RiotApiException {

		Map<String, String> summoners = SummonerApi.getSummonerNames(region, getKey(), summonerId);
		if (!summoners.containsKey(summonerId)) {
			throw new RiotApiException(RiotApiException.DATA_NOT_FOUND);
		}
		return summoners.get(summonerId);
	}

	/**
	 * Get summoner name for a given summoner ID.
	 *
	 * @param summonerId
	 *            Summoner ID associated with summoner name to retrieve.
	 * @return A map of desired summoner names
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public String getSummonerName(String summonerId) throws RiotApiException {

		Map<String, String> summoners = SummonerApi.getSummonerNames(getRegion(), getKey(), summonerId);
		if (!summoners.containsKey(summonerId)) {
			throw new RiotApiException(RiotApiException.DATA_NOT_FOUND);
		}
		return summoners.get(summonerId);
	}

	/**
	 * Get summoner names mapped by summoner ID for a given list of summoner IDs.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerIds
	 *            List of summoner IDs associated with summoner names to retrieve. Maximum allowed at once is 40.
	 * @return A map of desired summoner names
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, String> getSummonerNames(Region region, long... summonerIds) throws RiotApiException {

		return SummonerApi.getSummonerNames(region, getKey(), summonerIds);
	}

	/**
	 * Get summoner names mapped by summoner ID for a given list of summoner IDs.
	 *
	 * @param summonerIds
	 *            List of summoner IDs associated with summoner names to retrieve. Maximum allowed at once is 40.
	 * @return A map of desired summoner names
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, String> getSummonerNames(long... summonerIds) throws RiotApiException {

		return SummonerApi.getSummonerNames(getRegion(), getKey(), summonerIds);
	}

	/**
	 * Get summoner names mapped by summoner ID for a given list of summoner IDs.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerIds
	 *            Comma-separated list of summoner IDs associated with summoner names to retrieve. Maximum allowed at once is 40.
	 * @return A map of desired summoner names
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, String> getSummonerNames(Region region, String summonerIds) throws RiotApiException {

		return SummonerApi.getSummonerNames(region, getKey(), summonerIds);
	}

	/**
	 * Get summoner names mapped by summoner ID for a given list of summoner IDs.
	 *
	 * @param summonerIds
	 *            Comma-separated list of summoner IDs associated with summoner names to retrieve. Maximum allowed at once is 40.
	 * @return A map of desired summoner names
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, String> getSummonerNames(String summonerIds) throws RiotApiException {

		return SummonerApi.getSummonerNames(getRegion(), getKey(), summonerIds);
	}

	/**
	 * Get teams for a given summoner ID.
	 *
	 * @param region
	 *            The region of the summoner.
	 * @param summonerId
	 *            Summoner ID
	 * @return A list of the summoner's teams
	 * @see Team
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public List<Team> getTeamsBySummonerId(Region region, long summonerId) throws RiotApiException {

		return TeamApi.getTeamsBySummonerIds(region, getKey(), summonerId).get(Long.toString(summonerId));
	}

	/**
	 * Get teams for a given summoner ID.
	 *
	 * @param summonerId
	 *            A summoner ID
	 * @return A list of the summoner's teams
	 * @see Team
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public List<Team> getTeamsBySummonerId(long summonerId) throws RiotApiException {

		return TeamApi.getTeamsBySummonerIds(getRegion(), getKey(), summonerId).get(Long.toString(summonerId));
	}

	/**
	 * Get teams for a given summoner ID.
	 *
	 * @param region
	 *            The region of the summoner.
	 * @param summonerId
	 *            Summoner ID
	 * @return A list of the summoner's teams
	 * @see Team
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public List<Team> getTeamsBySummonerId(Region region, String summonerId) throws RiotApiException {

		return TeamApi.getTeamsBySummonerIds(region, getKey(), summonerId).get(summonerId);
	}

	/**
	 * Get teams for a given summoner ID.
	 *
	 * @param summonerId
	 *            A summoner ID
	 * @return A list of the summoner's teams
	 * @see Team
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public List<Team> getTeamsBySummonerId(String summonerId) throws RiotApiException {

		return TeamApi.getTeamsBySummonerIds(getRegion(), getKey(), summonerId).get(summonerId);
	}

	/**
	 * Get teams mapped by summoner ID for a given list of summoner IDs.
	 *
	 * @param region
	 *            The region of the summoner.
	 * @param summonerIds
	 *            A list of summoner IDs. Maximum allowed at once is 10.
	 * @return A map of the summoners' teams
	 * @see Team
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, List<Team>> getTeamsBySummonerIds(Region region, long... summonerIds) throws RiotApiException {

		return TeamApi.getTeamsBySummonerIds(region, getKey(), summonerIds);
	}

	/**
	 * Get teams mapped by summoner ID for a given list of summoner IDs.
	 *
	 * @param summonerIds
	 *            A list of summoner IDs. Maximum allowed at once is 10.
	 * @return A map of the summoners' teams
	 * @see Team
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, List<Team>> getTeamsBySummonerIds(long... summonerIds) throws RiotApiException {

		return TeamApi.getTeamsBySummonerIds(getRegion(), getKey(), summonerIds);
	}

	/**
	 * Get teams mapped by summoner ID for a given list of summoner IDs.
	 *
	 * @param region
	 *            The region of the summoner.
	 * @param summonerIds
	 *            Comma-separated list of summoner IDs. Maximum allowed at once is 10.
	 * @return A map of the summoners' teams
	 * @see Team
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, List<Team>> getTeamsBySummonerIds(Region region, String summonerIds) throws RiotApiException {

		return TeamApi.getTeamsBySummonerIds(region, getKey(), summonerIds);
	}

	/**
	 * Get teams mapped by summoner ID for a given list of summoner IDs.
	 *
	 * @param summonerIds
	 *            Comma-separated list of summoner IDs
	 * @return A map of the summoners' teams
	 * @see Team
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, List<Team>> getTeamsBySummonerIds(String summonerIds) throws RiotApiException {

		return TeamApi.getTeamsBySummonerIds(getRegion(), getKey(), summonerIds);
	}

	/**
	 * Get team for a given team ID.
	 *
	 * @param region
	 *            The region of the summoner.
	 * @param teamId
	 *            Team ID
	 * @return A team
	 * @see Team
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Team getTeamByTeamId(Region region, String teamId) throws RiotApiException {

		Map<String, Team> teams = TeamApi.getTeamsByTeamIds(region, getKey(), teamId);
		if (!teams.containsKey(teamId)) {
			throw new RiotApiException(RiotApiException.DATA_NOT_FOUND);
		}
		return teams.get(teamId);
	}

	/**
	 * Get team for a given team ID.
	 *
	 * @param teamId
	 *            Comma-separated list of team IDs. Maximum allowed at once is 10.
	 * @return A team
	 * @see Team
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Team getTeamByTeamId(String teamId) throws RiotApiException {

		Map<String, Team> teams = TeamApi.getTeamsByTeamIds(getRegion(), getKey(), teamId);
		if (!teams.containsKey(teamId)) {
			throw new RiotApiException(RiotApiException.DATA_NOT_FOUND);
		}
		return teams.get(teamId);
	}

	/**
	 * Get teams mapped by team ID for a given list of team IDs.
	 *
	 * @param region
	 *            The region of the summoner.
	 * @param teamIds
	 *            Comma-separated list of team IDs. Maximum allowed at once is 10.
	 * @return A map of teams
	 * @see Team
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, Team> getTeamsByTeamIds(Region region, String teamIds) throws RiotApiException {

		return TeamApi.getTeamsByTeamIds(region, getKey(), teamIds);
	}

	/**
	 * Get teams mapped by team ID for a given list of team IDs.
	 *
	 * @param teamIds
	 *            Comma-separated list of team IDs. Maximum allowed at once is 10.
	 * @return A map of teams
	 * @see Team
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Map<String, Team> getTeamsByTeamIds(String teamIds) throws RiotApiException {

		return TeamApi.getTeamsByTeamIds(getRegion(), getKey(), teamIds);
	}

	/**
	 * Retrieve match by match ID.
	 *
	 * @param region
	 *            The region of the summoner.
	 * @param matchId
	 *            The ID of the match.
	 * @return A map with match details
	 * @see MatchDetail
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public MatchDetail getMatch(Region region, long matchId) throws RiotApiException {

		return MatchApi.getMatch(region, getKey(), matchId);
	}

	/**
	 * Retrieve match by match ID.
	 *
	 * @param matchId
	 *            The ID of the match
	 * @return A map with match details
	 * @see MatchDetail
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public MatchDetail getMatch(long matchId) throws RiotApiException {

		return MatchApi.getMatch(getRegion(), getKey(), matchId);
	}

	/**
	 * Retrieve match by match ID.
	 *
	 * @param region
	 *            The region of the summoner.
	 * @param matchId
	 *            The ID of the match.
	 * @param includeTimeline
	 *            Flag indicating whether or not to include match timeline data
	 * @return A map with match details
	 * @see MatchDetail
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public MatchDetail getMatch(Region region, long matchId, boolean includeTimeline) throws RiotApiException {

		return MatchApi.getMatch(region, getKey(), matchId, includeTimeline);
	}

	/**
	 * Retrieve match by match ID.
	 *
	 * @param matchId
	 *            The ID of the match.
	 * @param includeTimeline
	 *            Flag indicating whether or not to include match timeline data
	 * @return A map with match details
	 * @see MatchDetail
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public MatchDetail getMatch(long matchId, boolean includeTimeline) throws RiotApiException {

		return MatchApi.getMatch(getRegion(), getKey(), matchId, includeTimeline);
	}

	/**
	 * Retrieve match list by summoner ID.
	 *
	 * @param region
	 *            The region of the summoner.
	 * @param summonerId
	 *            The ID of the summoner.
	 * @param championIds
	 *            Comma-separated list of champion IDs to use for fetching games.
	 * @param rankedQueues
	 *            Comma-separated list of ranked queue types to use for fetching games. Non-ranked queue types will be ignored.
	 * @param seasons
	 *            Comma-separated list of seasons to use for fetching games.
	 * @param beginTime
	 *            The begin time to use for fetching games specified as epoch milliseconds.
	 * @param endTime
	 *            The end time to use for fetching games specified as epoch milliseconds.
	 * @param beginIndex
	 *            The begin index to use for fetching games.
	 * @param endIndex
	 *            The end index to use for fetching games.
	 * @return A list with matches
	 * @see MatchList
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public MatchList getMatchList(Region region, long summonerId, String championIds, String rankedQueues, String seasons, long beginTime, long endTime,
			int beginIndex, int endIndex) throws RiotApiException {

		return MatchListApi.getMatchList(region, getKey(), summonerId, championIds, rankedQueues, seasons, beginTime, endTime, beginIndex, endIndex);
	}

	/**
	 * Retrieve match list by summoner ID.
	 *
	 * @param The
	 *            region of the summoner.
	 * @param summonerId
	 *            The ID of the summoner.
	 * @return A list with matches
	 * @see MatchList
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public MatchList getMatchList(Region region, long summonerId) throws RiotApiException {

		return MatchListApi.getMatchList(region, getKey(), summonerId, null, null, null, -1, -1, -1, -1);
	}

	/**
	 * Retrieve match list by summoner ID.
	 *
	 * @param summonerId
	 *            The ID of the summoner.
	 * @param championIds
	 *            Comma-separated list of champion IDs to use for fetching games.
	 * @param rankedQueues
	 *            Comma-separated list of ranked queue types to use for fetching games. Non-ranked queue types will be ignored.
	 * @param seasons
	 *            Comma-separated list of seasons to use for fetching games.
	 * @param beginTime
	 *            The begin time to use for fetching games specified as epoch milliseconds.
	 * @param endTime
	 *            The end time to use for fetching games specified as epoch milliseconds.
	 * @param beginIndex
	 *            The begin index to use for fetching games.
	 * @param endIndex
	 *            The end index to use for fetching games.
	 * @return A list with matches
	 * @see MatchList
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public MatchList getMatchList(long summonerId, String championIds, String rankedQueues, String seasons, long beginTime, long endTime, int beginIndex,
			int endIndex) throws RiotApiException {

		return MatchListApi.getMatchList(getRegion(), getKey(), summonerId, championIds, rankedQueues, seasons, beginTime, endTime, beginIndex, endIndex);
	}

	/**
	 * Retrieve match list by summoner ID.
	 *
	 * @param summonerId
	 *            The ID of the summoner.
	 * @return A list with matches
	 * @see MatchList
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public MatchList getMatchList(long summonerId) throws RiotApiException {

		return MatchListApi.getMatchList(getRegion(), getKey(), summonerId, null, null, null, -1, -1, -1, -1);
	}

	/**
	 * Get current game information for the given summoner ID.
	 * 
	 * @param platformId
	 *            The platform ID for which to fetch data.
	 * @param summonerId
	 *            The ID of the summoner.
	 * @return Current game info
	 * @see CurrentGameInfo
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public CurrentGameInfo getCurrentGameInfo(PlatformId platformId, long summonerId) throws RiotApiException {

		return CurrentGameApi.getCurrentGameInfo(platformId, getKey(), summonerId);
	}

	/**
	 * Get current game information for the given summoner ID.
	 * 
	 * @param platformId
	 *            The platform ID for which to fetch data.
	 * @param summonerId
	 *            The ID of the summoner.
	 * @return Current game info
	 * @see CurrentGameInfo
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public CurrentGameInfo getCurrentGameInfo(PlatformId platformId, String summonerId) throws RiotApiException {

		return CurrentGameApi.getCurrentGameInfo(platformId, getKey(), summonerId);
	}

	/**
	 * Get list of featured games.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return Featured games
	 * @see FeaturedGames
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public FeaturedGames getFeaturedGames(Region region) throws RiotApiException {

		return FeaturedGamesApi.getFeaturedGames(region, getKey());
	}

	/**
	 * Get list of featured games.
	 * 
	 * @return Featured games
	 * @see FeaturedGames
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public FeaturedGames getFeaturedGames() throws RiotApiException {

		return FeaturedGamesApi.getFeaturedGames(getRegion(), getKey());
	}

	/**
	 * Retrieves champion list.
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
	 *             if the API returns an error or unparsable result
	 */
	public ChampionList getDataChampionList(Region region, String locale, String version, boolean dataById, ChampData... champData) throws RiotApiException {

		return StaticDataApi.getDataChampionList(region, getKey(), locale, version, dataById, champData);
	}

	/**
	 * Retrieves champion list.
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
	 *             if the API returns an error or unparsable result
	 */
	public ChampionList getDataChampionList(String locale, String version, boolean dataById, ChampData... champData) throws RiotApiException {

		return StaticDataApi.getDataChampionList(getRegion(), getKey(), locale, version, dataById, champData);
	}

	/**
	 * Retrieves champion list.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return A list with champions
	 * @see ChampionList
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public ChampionList getDataChampionList(Region region) throws RiotApiException {

		return StaticDataApi.getDataChampionList(region, getKey(), null, null, false, (ChampData) null);
	}

	/**
	 * Retrieves champion list.
	 * 
	 * @return A list with champions
	 * @see ChampionList
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public ChampionList getDataChampionList() throws RiotApiException {

		return StaticDataApi.getDataChampionList(getRegion(), getKey(), null, null, false, (ChampData) null);
	}

	/**
	 * Retrieves a champion by its ID.
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
	 *             if the API returns an error or unparsable result
	 */
	public dto.Static.Champion getDataChampion(Region region, int id, String locale, String version, ChampData... champData) throws RiotApiException {

		return StaticDataApi.getDataChampion(region, getKey(), id, locale, version, champData);
	}

	/**
	 * Retrieves a champion by its ID.
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
	 *             if the API returns an error or unparsable result
	 */
	public dto.Static.Champion getDataChampion(int id, String locale, String version, ChampData... champData) throws RiotApiException {

		return StaticDataApi.getDataChampion(getRegion(), getKey(), id, locale, version, champData);
	}

	/**
	 * Retrieves a champion by its ID.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param id
	 *            Champion ID
	 * @return A single champion
	 * @see Champion
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public dto.Static.Champion getDataChampion(Region region, int id) throws RiotApiException {

		return StaticDataApi.getDataChampion(region, getKey(), id, null, null, (ChampData) null);
	}

	/**
	 * Retrieves a champion by its ID.
	 * 
	 * @param id
	 *            Champion ID
	 * @return A single champion
	 * @see Champion
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public dto.Static.Champion getDataChampion(int id) throws RiotApiException {

		return StaticDataApi.getDataChampion(getRegion(), getKey(), id, null, null, (ChampData) null);
	}

	/**
	 * Retrieves map data.
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
	 *             if the API returns an error or unparsable result
	 */
	public GameMapList getDataGameMapList(Region region, String locale, String version) throws RiotApiException {

		return StaticDataApi.getDataGameMapList(region, getKey(), locale, version);
	}

	/**
	 * Retrieves map data.
	 * 
	 * @param locale
	 *            Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the getDataVersions() method.
	 * @return A list of game maps
	 * @see GameMapList
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public GameMapList getDataGameMapList(String locale, String version) throws RiotApiException {

		return StaticDataApi.getDataGameMapList(getRegion(), getKey(), locale, version);
	}

	/**
	 * Retrieves map data.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return A list of game maps
	 * @see GameMapList
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public GameMapList getDataGameMapList(Region region) throws RiotApiException {

		return StaticDataApi.getDataGameMapList(region, getKey(), null, null);
	}

	/**
	 * Retrieves map data.
	 * 
	 * @return A list of game maps
	 * @see GameMapList
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public GameMapList getDataGameMapList() throws RiotApiException {

		return StaticDataApi.getDataGameMapList(getRegion(), getKey(), null, null);
	}

	/**
	 * Retrieves item list.
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
	 *             if the API returns an error or unparsable result
	 */
	public ItemList getDataItemList(Region region, String locale, String version, ItemListData... itemListData) throws RiotApiException {

		return StaticDataApi.getDataItemList(region, getKey(), locale, version, itemListData);
	}

	/**
	 * Retrieves item list.
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
	 *             if the API returns an error or unparsable result
	 */
	public ItemList getDataItemList(String locale, String version, ItemListData... itemListData) throws RiotApiException {

		return StaticDataApi.getDataItemList(getRegion(), getKey(), locale, version, itemListData);
	}

	/**
	 * Retrieves item list.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return A list of items
	 * @see ItemList
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public ItemList getDataItemList(Region region) throws RiotApiException {

		return StaticDataApi.getDataItemList(region, getKey(), null, null, (ItemListData) null);
	}

	/**
	 * Retrieves item list.
	 * 
	 * @return A list of items
	 * @see ItemList
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public ItemList getDataItemList() throws RiotApiException {

		return StaticDataApi.getDataItemList(getRegion(), getKey(), null, null, (ItemListData) null);
	}

	/**
	 * Retrieves item by its unique ID.
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
	 *             if the API returns an error or unparsable result
	 */
	public Item getDataItem(Region region, int id, String locale, String version, ItemData... itemData) throws RiotApiException {

		return StaticDataApi.getDataItem(region, getKey(), id, locale, version, itemData);
	}

	/**
	 * Retrieves item by its unique ID.
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
	 *             if the API returns an error or unparsable result
	 */
	public Item getDataItem(int id, String locale, String version, ItemData... itemData) throws RiotApiException {

		return StaticDataApi.getDataItem(getRegion(), getKey(), id, locale, version, itemData);
	}

	/**
	 * Retrieves item by its unique ID.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param id
	 *            Item ID
	 * @return A single item
	 * @see Item
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Item getDataItem(Region region, int id) throws RiotApiException {

		return StaticDataApi.getDataItem(region, getKey(), id, null, null, (ItemData) null);
	}

	/**
	 * Retrieves item by its unique ID.
	 * 
	 * @param id
	 *            Item ID
	 * @return A single item
	 * @see Item
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Item getDataItem(int id) throws RiotApiException {

		return StaticDataApi.getDataItem(getRegion(), getKey(), id, null, null, (ItemData) null);
	}

	/**
	 * Retrieve supported languages data.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return A list with languages
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public List<String> getDataLanguages(Region region) throws RiotApiException {

		return StaticDataApi.getDataLanguages(region, getKey());
	}

	/**
	 * Retrieve supported languages data.
	 * 
	 * @return A list with languages
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public List<String> getDataLanguages() throws RiotApiException {

		return StaticDataApi.getDataLanguages(getRegion(), getKey());
	}

	/**
	 * Retrieve language strings data.
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
	 *             if the API returns an error or unparsable result
	 */
	public LanguageStrings getDataLanguageStrings(Region region, String locale, String version) throws RiotApiException {

		return StaticDataApi.getDataLanguageStrings(region, getKey(), locale, version);
	}

	/**
	 * Retrieve language strings data.
	 * 
	 * @param locale
	 *            Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the getDataVersions() method.
	 * @return Language strings
	 * @see LanguageStrings
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public LanguageStrings getDataLanguageStrings(String locale, String version) throws RiotApiException {

		return StaticDataApi.getDataLanguageStrings(getRegion(), getKey(), locale, version);
	}

	/**
	 * Retrieve language strings data.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return Language strings
	 * @see LanguageStrings
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public LanguageStrings getDataLanguageStrings(Region region) throws RiotApiException {

		return StaticDataApi.getDataLanguageStrings(region, getKey(), null, null);
	}

	/**
	 * Retrieve language strings data.
	 * 
	 * @return Language strings
	 * @see LanguageStrings
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public LanguageStrings getDataLanguageStrings() throws RiotApiException {

		return StaticDataApi.getDataLanguageStrings(getRegion(), getKey(), null, null);
	}

	/**
	 * Retrieves mastery list.
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
	 *             if the API returns an error or unparsable result
	 */
	public MasteryList getDataMasteryList(Region region, String locale, String version, MasteryListData... masteryListData) throws RiotApiException {

		return StaticDataApi.getDataMasteryList(region, getKey(), locale, version, masteryListData);
	}

	/**
	 * Retrieves mastery list.
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
	 *             if the API returns an error or unparsable result
	 */
	public MasteryList getDataMasteryList(String locale, String version, MasteryListData... masteryListData) throws RiotApiException {

		return StaticDataApi.getDataMasteryList(getRegion(), getKey(), locale, version, masteryListData);
	}

	/**
	 * Retrieves mastery list.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return A list with masteries
	 * @see MasteryList
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public MasteryList getDataMasteryList(Region region) throws RiotApiException {

		return StaticDataApi.getDataMasteryList(region, getKey(), null, null, (MasteryListData) null);
	}

	/**
	 * Retrieves mastery list.
	 * 
	 * @return A list with masteries
	 * @see MasteryList
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public MasteryList getDataMasteryList() throws RiotApiException {

		return StaticDataApi.getDataMasteryList(getRegion(), getKey(), null, null, (MasteryListData) null);
	}

	/**
	 * Retrieves mastery item by its unique ID.
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
	 *             if the API returns an error or unparsable result
	 */
	public Mastery getDataMastery(Region region, int id, String locale, String version, MasteryData... masteryData) throws RiotApiException {

		return StaticDataApi.getDataMastery(region, getKey(), id, locale, version, masteryData);
	}

	/**
	 * Retrieves mastery item by its unique ID.
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
	 *             if the API returns an error or unparsable result
	 */
	public Mastery getDataMastery(int id, String locale, String version, MasteryData... masteryData) throws RiotApiException {

		return StaticDataApi.getDataMastery(getRegion(), getKey(), id, locale, version, masteryData);
	}

	/**
	 * Retrieves mastery item by its unique ID.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param id
	 *            Mastery ID
	 * @return A single mastery
	 * @see Mastery
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Mastery getDataMastery(Region region, int id) throws RiotApiException {

		return StaticDataApi.getDataMastery(region, getKey(), id, null, null, (MasteryData) null);
	}

	/**
	 * Retrieves mastery item by its unique ID.
	 * 
	 * @param id
	 *            Mastery ID
	 * @return A single mastery
	 * @see Mastery
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Mastery getDataMastery(int id) throws RiotApiException {

		return StaticDataApi.getDataMastery(getRegion(), getKey(), id, null, null, (MasteryData) null);
	}

	/**
	 * Retrieve realm data.
	 * 
	 * @param region
	 *            Region corresponding to data to retrieve.
	 * @return A single realm
	 * @see Realm
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Realm getDataRealm(Region region) throws RiotApiException {

		return StaticDataApi.getDataRealm(region, getKey());
	}

	/**
	 * Retrieve realm data.
	 * 
	 * @return A single realm
	 * @see Realm
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Realm getDataRealm() throws RiotApiException {

		return StaticDataApi.getDataRealm(getRegion(), getKey());
	}

	/**
	 * Retrieves rune list.
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
	 *             if the API returns an error or unparsable result
	 */
	public RuneList getDataRuneList(Region region, String locale, String version, RuneListData... runeListData) throws RiotApiException {

		return StaticDataApi.getDataRuneList(region, getKey(), locale, version, runeListData);
	}

	/**
	 * Retrieves rune list.
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
	 *             if the API returns an error or unparsable result
	 */
	public RuneList getDataRuneList(String locale, String version, RuneListData... runeListData) throws RiotApiException {

		return StaticDataApi.getDataRuneList(getRegion(), getKey(), locale, version, runeListData);
	}

	/**
	 * Retrieves rune list.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return A list with runes
	 * @see RuneList
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public RuneList getDataRuneList(Region region) throws RiotApiException {

		return StaticDataApi.getDataRuneList(region, getKey(), null, null, (RuneListData) null);
	}

	/**
	 * Retrieves rune list.
	 * 
	 * @return A list with runes
	 * @see RuneList
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public RuneList getDataRuneList() throws RiotApiException {

		return StaticDataApi.getDataRuneList(getRegion(), getKey(), null, null, (RuneListData) null);
	}

	/**
	 * Retrieves rune by its unique ID.
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
	 *             if the API returns an error or unparsable result
	 */
	public Rune getDataRune(Region region, int id, String locale, String version, RuneData... runeData) throws RiotApiException {

		return StaticDataApi.getDataRune(region, getKey(), id, locale, version, runeData);
	}

	/**
	 * Retrieves rune by its unique ID.
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
	 *             if the API returns an error or unparsable result
	 */
	public Rune getDataRune(int id, String locale, String version, RuneData... runeData) throws RiotApiException {

		return StaticDataApi.getDataRune(getRegion(), getKey(), id, locale, version, runeData);
	}

	/**
	 * Retrieves rune by its unique ID.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param id
	 *            Rune ID
	 * @return A single rune
	 * @see Rune
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Rune getDataRune(Region region, int id) throws RiotApiException {

		return StaticDataApi.getDataRune(region, getKey(), id, null, null, (RuneData) null);
	}

	/**
	 * Retrieves rune by its unique ID.
	 * 
	 * @param id
	 *            Rune ID
	 * @return A single rune
	 * @see Rune
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public Rune getDataRune(int id) throws RiotApiException {

		return StaticDataApi.getDataRune(getRegion(), getKey(), id, null, null, (RuneData) null);
	}

	/**
	 * Retrieves summoner spell list.
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
	 *             if the API returns an error or unparsable result
	 */
	public SummonerSpellList getDataSummonerSpellList(Region region, String locale, String version, boolean dataById, SpellData... spellData)
			throws RiotApiException {

		return StaticDataApi.getDataSummonerSpellList(region, getKey(), locale, version, dataById, spellData);
	}

	/**
	 * Retrieves summoner spell list.
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
	 *             if the API returns an error or unparsable result
	 */
	public SummonerSpellList getDataSummonerSpellList(String locale, String version, boolean dataById, SpellData... spellData) throws RiotApiException {

		return StaticDataApi.getDataSummonerSpellList(getRegion(), getKey(), locale, version, dataById, spellData);
	}

	/**
	 * Retrieves summoner spell list.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return A list with summoner spells
	 * @see SummonerSpellList
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public SummonerSpellList getDataSummonerSpellList(Region region) throws RiotApiException {

		return StaticDataApi.getDataSummonerSpellList(region, getKey(), null, null, false, (SpellData) null);
	}

	/**
	 * Retrieves summoner spell list.
	 * 
	 * @return A list with summoner spells
	 * @see SummonerSpellList
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public SummonerSpellList getDataSummonerSpellList() throws RiotApiException {

		return StaticDataApi.getDataSummonerSpellList(getRegion(), getKey(), null, null, false, (SpellData) null);
	}

	/**
	 * Retrieves summoner spell by its unique ID.
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
	 *             if the API returns an error or unparsable result
	 */
	public SummonerSpell getDataSummonerSpell(Region region, int id, String locale, String version, SpellData... spellData) throws RiotApiException {

		return StaticDataApi.getDataSummonerSpell(region, getKey(), id, locale, version, spellData);
	}

	/**
	 * Retrieves summoner spell by its unique ID.
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
	 *             if the API returns an error or unparsable result
	 */
	public SummonerSpell getDataSummonerSpell(int id, String locale, String version, SpellData... spellData) throws RiotApiException {

		return StaticDataApi.getDataSummonerSpell(getRegion(), getKey(), id, locale, version, spellData);
	}

	/**
	 * Retrieves summoner spell by its unique ID.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param id
	 *            Summoner spell ID
	 * @return A single summoner spell
	 * @see SummonerSpell
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public SummonerSpell getDataSummonerSpell(Region region, int id) throws RiotApiException {

		return StaticDataApi.getDataSummonerSpell(region, getKey(), id, null, null, (SpellData) null);
	}

	/**
	 * Retrieves summoner spell by its unique ID.
	 * 
	 * @param id
	 *            Summoner spell ID
	 * @return A single summoner spell
	 * @see SummonerSpell
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public SummonerSpell getDataSummonerSpell(int id) throws RiotApiException {

		return StaticDataApi.getDataSummonerSpell(getRegion(), getKey(), id, null, null, (SpellData) null);
	}

	/**
	 * Retrieve version data.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return A list with versions
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public List<String> getDataVersions(Region region) throws RiotApiException {

		return StaticDataApi.getDataVersions(region, getKey());
	}

	/**
	 * Retrieve version data.
	 * 
	 * @return A list with versions
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public List<String> getDataVersions() throws RiotApiException {

		return StaticDataApi.getDataVersions(getRegion(), getKey());
	}

	/**
	 * Get shard list.
	 * 
	 * @return Status for a list of shards
	 * @see Shard
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public List<Shard> getShards() throws RiotApiException {

		return StatusApi.getShards();
	}

	/**
	 * Get shard status. Returns the data available on the status.leagueoflegends.com website for the given region.
	 * 
	 * @param region
	 *            The region for which to fetch data.
	 * @return Status for a single shard
	 * @see ShardStatus
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public ShardStatus getShardStatus(Region region) throws RiotApiException {

		return StatusApi.getShardStatus(region);
	}

	/**
	 * Get shard status. Returns the data available on the status.leagueoflegends.com website for the given region.
	 * 
	 * @return Status for a single shard
	 * @see ShardStatus
	 * @throws RiotApiException
	 *             if the API returns an error or unparsable result
	 */
	public ShardStatus getShardStatus() throws RiotApiException {

		return StatusApi.getShardStatus(getRegion());
	}

	/**
	 * Get the currently set season
	 *
	 * @return The currently set season
	 */
	public Season getSeason() {
		return season;
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
	 */
	public Region getRegion() {
		return region;
	}

	/**
	 * Set the season
	 *
	 * @param season
	 *            The season to set
	 */
	public void setSeason(Season season) {
		this.season = season;
	}

	/**
	 * Set the API key
	 *
	 * @param key
	 *            The API key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Set the region
	 *
	 * @param region
	 *            The region to set
	 */
	public void setRegion(Region region) {
		this.region = region;
	}

	/**
	 * Get the base URL for API requests
	 *
	 * @return The base URL for API requests
	 */
	public String getEndpoint() {
		return region.getEndpoint();
	}

	@Override
	public RiotApi clone() {
		return new RiotApi(this.key, this.region);
	}
}