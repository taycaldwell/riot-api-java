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
import java.util.Map;
import java.util.Objects;

import net.rithms.riot.constant.PickType;
import net.rithms.riot.constant.PlatformId;
import net.rithms.riot.constant.QueueType;
import net.rithms.riot.constant.Region;
import net.rithms.riot.constant.Season;
import net.rithms.riot.constant.SpectatorType;
import net.rithms.riot.constant.TournamentMap;
import net.rithms.riot.constant.staticdata.ChampData;
import net.rithms.riot.constant.staticdata.ItemData;
import net.rithms.riot.constant.staticdata.ItemListData;
import net.rithms.riot.constant.staticdata.MasteryData;
import net.rithms.riot.constant.staticdata.MasteryListData;
import net.rithms.riot.constant.staticdata.RuneData;
import net.rithms.riot.constant.staticdata.RuneListData;
import net.rithms.riot.constant.staticdata.SpellData;
import net.rithms.riot.dto.Champion.Champion;
import net.rithms.riot.dto.Champion.ChampionList;
import net.rithms.riot.dto.ChampionMastery.ChampionMastery;
import net.rithms.riot.dto.CurrentGame.CurrentGameInfo;
import net.rithms.riot.dto.FeaturedGames.FeaturedGames;
import net.rithms.riot.dto.Game.RecentGames;
import net.rithms.riot.dto.League.League;
import net.rithms.riot.dto.Match.MatchDetail;
import net.rithms.riot.dto.MatchList.MatchList;
import net.rithms.riot.dto.Static.GameMapList;
import net.rithms.riot.dto.Static.Item;
import net.rithms.riot.dto.Static.ItemList;
import net.rithms.riot.dto.Static.LanguageStrings;
import net.rithms.riot.dto.Static.Mastery;
import net.rithms.riot.dto.Static.MasteryList;
import net.rithms.riot.dto.Static.Realm;
import net.rithms.riot.dto.Static.Rune;
import net.rithms.riot.dto.Static.RuneList;
import net.rithms.riot.dto.Static.SummonerSpell;
import net.rithms.riot.dto.Static.SummonerSpellList;
import net.rithms.riot.dto.Stats.PlayerStatsSummaryList;
import net.rithms.riot.dto.Stats.RankedStats;
import net.rithms.riot.dto.Status.Shard;
import net.rithms.riot.dto.Status.ShardStatus;
import net.rithms.riot.dto.Summoner.MasteryPages;
import net.rithms.riot.dto.Summoner.RunePages;
import net.rithms.riot.dto.Summoner.Summoner;
import net.rithms.riot.dto.Team.Team;
import net.rithms.riot.dto.Tournament.LobbyEventList;
import net.rithms.riot.dto.Tournament.TournamentCode;
import net.rithms.util.Convert;

/**
 * Riot Games API Java Library - riot-api-java
 * 
 * @author Taylor 'rithms' Caldwell
 * @author Daniel 'Linnun' Figge
 * @version 3.8.2
 */
public class RiotApi {

	private Region region = Region.NA; // North American region default
	private Season season = null;
	private String key;
	private String tournamentKey;

	public RiotApi() {
	}

	public RiotApi(String key) {
		setKey(key);
	}

	public RiotApi(String key, String tournamentKey) {
		setKey(key);
		setTournamentKey(tournamentKey);
	}

	public RiotApi(Region region) {
		setRegion(region);
	}

	public RiotApi(String key, Region region) {
		setKey(key);
		setRegion(region);
	}

	public RiotApi(String key, String tournamentKey, Region region) {
		setKey(key);
		setTournamentKey(tournamentKey);
		setRegion(region);
	}

	@Override
	public RiotApi clone() {
		RiotApi api = new RiotApi(getKey(), getTournamentKey(), getRegion());
		api.setSeason(getSeason());
		return api;
	}

	/**
	 * Retrieve all champions.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param freeToPlay
	 *            Optional filter param to retrieve only free to play champions.
	 * @return A list of champions for the given region
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see ChampionList
	 */
	public ChampionList getChampions(Region region, boolean freeToPlay) throws RiotApiException {
		Objects.requireNonNull(region);
		return ChampionApi.getChampions(region, getKey(), freeToPlay);
	}

	/**
	 * Retrieve all champions.
	 *
	 * @param freeToPlay
	 *            Optional filter param to retrieve only free to play champions.
	 * @return A list of champions for the set region
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see ChampionList
	 */
	public ChampionList getChampions(boolean freeToPlay) throws RiotApiException {
		return getChampions(getRegion(), freeToPlay);
	}

	/**
	 * Retrieve all champions.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @return A list of champions for the given region
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see ChampionList
	 */
	public ChampionList getChampions(Region region) throws RiotApiException {
		Objects.requireNonNull(region);
		return getChampions(region, false);
	}

	/**
	 * Retrieve all champions.
	 *
	 * @return A list of all the champions for the set region
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see ChampionList
	 */
	public ChampionList getChampions() throws RiotApiException {
		return getChampions(getRegion());
	}

	/**
	 * Retrieve all champions that are free-to-play.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @return A list of all the free to play champions for the given region
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see ChampionList
	 */
	public ChampionList getFreeToPlayChampions(Region region) throws RiotApiException {
		Objects.requireNonNull(region);
		return getChampions(region, true);
	}

	/**
	 * Retrieve all champions that are free-to-play.
	 *
	 * @return A list of all the free to play champions for the set region
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see ChampionList
	 */
	public ChampionList getFreeToPlayChampions() throws RiotApiException {
		return getFreeToPlayChampions(getRegion());
	}

	/**
	 * Retrieve champion by {@code id}.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param id
	 *            The ID of the desired champion
	 * @return The champion of the given ID
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Champion
	 */
	public Champion getChampionById(Region region, int id) throws RiotApiException {
		Objects.requireNonNull(region);
		return ChampionApi.getChampionById(region, getKey(), id);
	}

	/**
	 * Retrieve champion by {@code id}.
	 *
	 * @param id
	 *            The ID of the desired champion
	 * @return The champion of the given ID
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Champion
	 */
	public Champion getChampionById(int id) throws RiotApiException {
		return getChampionById(getRegion(), id);
	}

	/**
	 * Get recent games for a given {@code summonerId}.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerId
	 *            ID of the summoner for which to retrieve recent games.
	 * @return Recent games of the given summoner
	 * @throws NullPointerException
	 *             If {@code region} or {@code summonerId} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see RecentGames
	 */
	public RecentGames getRecentGames(Region region, String summonerId) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerId);
		return GameApi.getRecentGames(region, getKey(), summonerId);
	}

	/**
	 * Get recent games for a given {@code summonerId}.
	 *
	 * @param summonerId
	 *            ID of the summoner for which to retrieve recent games.
	 * @return Recent games of the given summoner
	 * @throws NullPointerException
	 *             If {@code summonerId} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see RecentGames
	 */
	public RecentGames getRecentGames(String summonerId) throws RiotApiException {
		Objects.requireNonNull(summonerId);
		return getRecentGames(getRegion(), summonerId);
	}

	/**
	 * Get recent games for a given {@code summonerId}.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerId
	 *            ID of the summoner for which to retrieve recent games.
	 * @return Recent games of the given summoner
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see RecentGames
	 */
	public RecentGames getRecentGames(Region region, long summonerId) throws RiotApiException {
		Objects.requireNonNull(region);
		return getRecentGames(region, String.valueOf(summonerId));
	}

	/**
	 * Get recent games for a given {@code summonerId}.
	 *
	 * @param summonerId
	 *            ID of the summoner for which to retrieve recent games.
	 * @return Recent games of the given summoner
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see RecentGames
	 */
	public RecentGames getRecentGames(long summonerId) throws RiotApiException {
		return getRecentGames(getRegion(), summonerId);
	}

	/**
	 * Get a list of leagues mapped by summoner ID for a given list of {@code summonerIds}.
	 * 
	 * @param region
	 *            The region of the leagues.
	 * @param summonerIds
	 *            List of summoner IDs. Maximum allowed at once is 10.
	 * @return A map, mapping each summoner ID to a list of leagues
	 * @throws NullPointerException
	 *             If {@code region} or {@code summonerIds} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see League
	 */
	public Map<String, List<League>> getLeagueBySummoners(Region region, String... summonerIds) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerIds);
		return LeagueApi.getLeagueBySummoners(region, getKey(), Convert.joinString(",", summonerIds));
	}

	/**
	 * Get a list of leagues mapped by summoner ID for a given list of {@code summonerIds}.
	 * 
	 * @param summonerIds
	 *            List of summoner IDs. Maximum allowed at once is 10.
	 * @return A map, mapping each summoner ID to a list of leagues
	 * @throws NullPointerException
	 *             If {@code summonerIds} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see League
	 */
	public Map<String, List<League>> getLeagueBySummoners(String... summonerIds) throws RiotApiException {
		Objects.requireNonNull(summonerIds);
		return getLeagueBySummoners(getRegion(), summonerIds);
	}

	/**
	 * Get a list of leagues mapped by summoner ID for a given list of {@code summonerIds}.
	 * 
	 * @param region
	 *            The region of the leagues.
	 * @param summonerIds
	 *            List of summoner IDs. Maximum allowed at once is 10.
	 * @return A map, mapping each summoner ID to a list of leagues
	 * @throws NullPointerException
	 *             If {@code region} or {@code summonerIds} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see League
	 */
	public Map<String, List<League>> getLeagueBySummoners(Region region, long... summonerIds) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerIds);
		return getLeagueBySummoners(region, Convert.longToString(summonerIds));
	}

	/**
	 * Get a list of leagues mapped by summoner ID for a given list of {@code summonerIds}.
	 * 
	 * @param summonerIds
	 *            List of summoner IDs. Maximum allowed at once is 10.
	 * @return A map, mapping each summoner ID to a list of leagues
	 * @throws NullPointerException
	 *             If {@code summonerIds} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see League
	 */
	public Map<String, List<League>> getLeagueBySummoners(long... summonerIds) throws RiotApiException {
		Objects.requireNonNull(summonerIds);
		return getLeagueBySummoners(getRegion(), summonerIds);
	}

	/**
	 * Get a list of leagues for a given {@code summonerId}
	 * 
	 * @param region
	 *            The region of the leagues.
	 * @param summonerId
	 *            Summoner ID
	 * @return A list of leagues
	 * @throws NullPointerException
	 *             If {@code region} or {@code summonerId} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see League
	 */
	public List<League> getLeagueBySummoner(Region region, String summonerId) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerId);
		Map<String, List<League>> leagues = getLeagueBySummoners(region, summonerId);
		if (!leagues.containsKey(String.valueOf(summonerId))) {
			throw new RiotApiException(RiotApiException.DATA_NOT_FOUND);
		}
		return leagues.get(summonerId);
	}

	/**
	 * Get a list of leagues for a given {@code summonerId}
	 * 
	 * @param summonerId
	 *            Summoner ID
	 * @return A list of leagues
	 * @throws NullPointerException
	 *             If {@code summonerId} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see League
	 */
	public List<League> getLeagueBySummoner(String summonerId) throws RiotApiException {
		Objects.requireNonNull(summonerId);
		return getLeagueBySummoner(getRegion(), summonerId);
	}

	/**
	 * Get a list of leagues for a given {@code summonerId}
	 * 
	 * @param region
	 *            The region of the leagues.
	 * @param summonerId
	 *            Summoner ID
	 * @return A list of leagues
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see League
	 */
	public List<League> getLeagueBySummoner(Region region, long summonerId) throws RiotApiException {
		Objects.requireNonNull(region);
		return getLeagueBySummoner(region, String.valueOf(summonerId));
	}

	/**
	 * Get a list of leagues for a given {@code summonerId}
	 * 
	 * @param summonerId
	 *            Summoner ID
	 * @return A list of leagues
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see League
	 */
	public List<League> getLeagueBySummoner(long summonerId) throws RiotApiException {
		return getLeagueBySummoner(getRegion(), summonerId);
	}

	/**
	 * Get a list of league entries mapped by summoner ID for a given list of {@code summonerIds}.
	 * 
	 * @param region
	 *            The region of the leagues.
	 * @param summonerIds
	 *            List of summoner IDs. Maximum allowed at once is 10.
	 * @return A map, mapping each summoner ID to a list of leagues
	 * @throws NullPointerException
	 *             If {@code region} or {@code summonerIds} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see League
	 */
	public Map<String, List<League>> getLeagueEntryBySummoners(Region region, String... summonerIds) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerIds);
		return LeagueApi.getLeagueEntryBySummoners(region, getKey(), Convert.joinString(",", summonerIds));
	}

	/**
	 * Get a list of league entries mapped by summoner ID for a given list of {@code summonerIds}.
	 * 
	 * @param summonerIds
	 *            List of summoner IDs. Maximum allowed at once is 10.
	 * @return A map, mapping each summoner ID to a list of leagues
	 * @throws NullPointerException
	 *             If {@code summonerIds} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see League
	 */
	public Map<String, List<League>> getLeagueEntryBySummoners(String... summonerIds) throws RiotApiException {
		Objects.requireNonNull(summonerIds);
		return getLeagueEntryBySummoners(getRegion(), summonerIds);
	}

	/**
	 * Get a list of league entries mapped by summoner ID for a given list of {@code summonerIds}.
	 * 
	 * @param region
	 *            The region of the leagues.
	 * @param summonerIds
	 *            List of summoner IDs. Maximum allowed at once is 10.
	 * @return A map, mapping each summoner ID to a list of leagues
	 * @throws NullPointerException
	 *             If {@code region} or {@code summonerIds} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see League
	 */
	public Map<String, List<League>> getLeagueEntryBySummoners(Region region, long... summonerIds) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerIds);
		return getLeagueEntryBySummoners(region, Convert.longToString(summonerIds));
	}

	/**
	 * Get a list of league entries mapped by summoner ID for a given list of {@code summonerIds}.
	 * 
	 * @param summonerIds
	 *            List of summoner IDs. Maximum allowed at once is 10.
	 * @return A map, mapping each summoner ID to a list of leagues
	 * @throws NullPointerException
	 *             If {@code summonerIds} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see League
	 */
	public Map<String, List<League>> getLeagueEntryBySummoners(long... summonerIds) throws RiotApiException {
		Objects.requireNonNull(summonerIds);
		return getLeagueEntryBySummoners(getRegion(), summonerIds);
	}

	/**
	 * Get a list of league entries for a given {@code summonerId}.
	 * 
	 * @param region
	 *            The region of the leagues.
	 * @param summonerId
	 *            Summoner ID
	 * @return A list of leagues
	 * @throws NullPointerException
	 *             If {@code region} or {@code summonerId} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see League
	 */
	public List<League> getLeagueEntryBySummoner(Region region, String summonerId) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerId);
		Map<String, List<League>> leagues = getLeagueEntryBySummoners(region, summonerId);
		if (!leagues.containsKey(String.valueOf(summonerId))) {
			throw new RiotApiException(RiotApiException.DATA_NOT_FOUND);
		}
		return leagues.get(summonerId);
	}

	/**
	 * Get a list of league entries for a given {@code summonerId}.
	 * 
	 * @param summonerId
	 *            Summoner ID
	 * @return A list of leagues
	 * @throws NullPointerException
	 *             If {@code summonerId} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see League
	 */
	public List<League> getLeagueEntryBySummoner(String summonerId) throws RiotApiException {
		Objects.requireNonNull(summonerId);
		return getLeagueEntryBySummoner(getRegion(), summonerId);
	}

	/**
	 * Get a list of league entries for a given {@code summonerId}.
	 * 
	 * @param region
	 *            The region of the leagues.
	 * @param summonerId
	 *            Summoner ID
	 * @return A list of leagues
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see League
	 */
	public List<League> getLeagueEntryBySummoner(Region region, long summonerId) throws RiotApiException {
		Objects.requireNonNull(region);
		return getLeagueEntryBySummoner(region, String.valueOf(summonerId));
	}

	/**
	 * Get a list of league entries for a given {@code summonerId}.
	 * 
	 * @param summonerId
	 *            Summoner ID
	 * @return A list of leagues
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see League
	 */
	public List<League> getLeagueEntryBySummoner(long summonerId) throws RiotApiException {
		return getLeagueEntryBySummoner(getRegion(), summonerId);
	}

	/**
	 * Get a list of leagues mapped by team ID for a given list of {@code teamIds}.
	 * 
	 * @param region
	 *            The region of the leagues.
	 * @param teamIds
	 *            List of team IDs. Maximum allowed at once is 10.
	 * @return A map, mapping each team ID to a list of leagues
	 * @throws NullPointerException
	 *             If {@code region} or {@code teamIds} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see League
	 */
	public Map<String, List<League>> getLeagueByTeams(Region region, String... teamIds) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(teamIds);
		return LeagueApi.getLeagueByTeams(region, getKey(), Convert.joinString(",", teamIds));
	}

	/**
	 * Get a list of leagues mapped by team ID for a given list of {@code teamIds}.
	 * 
	 * @param teamIds
	 *            List of team IDs. Maximum allowed at once is 10.
	 * @return A map, mapping each team ID to a list of leagues
	 * @throws NullPointerException
	 *             If {@code teamIds} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see League
	 */
	public Map<String, List<League>> getLeagueByTeams(String... teamIds) throws RiotApiException {
		Objects.requireNonNull(teamIds);
		return getLeagueByTeams(getRegion(), teamIds);
	}

	/**
	 * Get a list of leagues for a given {@code teamId}.
	 * 
	 * @param region
	 *            The region of the leagues.
	 * @param teamId
	 *            Team ID
	 * @return A list of leagues
	 * @throws NullPointerException
	 *             If {@code region} or {@code teamId} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see League
	 */
	public List<League> getLeagueByTeam(Region region, String teamId) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(teamId);
		Map<String, List<League>> leagues = getLeagueByTeams(region, getKey(), teamId);
		if (!leagues.containsKey(String.valueOf(teamId))) {
			throw new RiotApiException(RiotApiException.DATA_NOT_FOUND);
		}
		return leagues.get(teamId);
	}

	/**
	 * Get a list of leagues for a given {@code teamId}.
	 * 
	 * @param teamId
	 *            Team ID
	 * @return A list of leagues
	 * @throws NullPointerException
	 *             If {@code teamId} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see League
	 */
	public List<League> getLeagueByTeam(String teamId) throws RiotApiException {
		Objects.requireNonNull(teamId);
		return getLeagueByTeam(getRegion(), teamId);
	}

	/**
	 * Get a list of league entries mapped by team ID for a given list of {@code teamIds}.
	 * 
	 * @param region
	 *            The region of the leagues.
	 * @param teamIds
	 *            List of team IDs. Maximum allowed at once is 10.
	 * @return A map, mapping each team ID to a list of leagues
	 * @throws NullPointerException
	 *             If {@code region} or {@code teamIds} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see League
	 */
	public Map<String, List<League>> getLeagueEntryByTeams(Region region, String... teamIds) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(teamIds);
		return LeagueApi.getLeagueEntryByTeams(region, getKey(), Convert.joinString(",", teamIds));
	}

	/**
	 * Get a list of league entries mapped by team ID for a given list of {@code teamIds}.
	 * 
	 * @param teamIds
	 *            List of team IDs. Maximum allowed at once is 10.
	 * @return A map, mapping each team ID to a list of leagues
	 * @throws NullPointerException
	 *             If {@code teamIds} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see League
	 */
	public Map<String, List<League>> getLeagueEntryByTeams(String... teamIds) throws RiotApiException {
		Objects.requireNonNull(teamIds);
		return getLeagueEntryByTeams(getRegion(), teamIds);
	}

	/**
	 * Get a list of league entries for a given {@code teamId}.
	 * 
	 * @param region
	 *            The region of the leagues.
	 * @param teamId
	 *            Team ID
	 * @return A list of leagues
	 * @throws NullPointerException
	 *             If {@code region} or {@code teamId} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see League
	 */
	public List<League> getLeagueEntryByTeam(Region region, String teamId) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(teamId);
		Map<String, List<League>> leagues = getLeagueEntryByTeams(region, teamId);
		if (!leagues.containsKey(String.valueOf(teamId))) {
			throw new RiotApiException(RiotApiException.DATA_NOT_FOUND);
		}
		return leagues.get(teamId);
	}

	/**
	 * Get a list of league entries for a given {@code teamId}.
	 * 
	 * @param teamId
	 *            Team ID
	 * @return A list of leagues
	 * @throws NullPointerException
	 *             If {@code teamId} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see League
	 */
	public List<League> getLeagueEntryByTeam(String teamId) throws RiotApiException {
		Objects.requireNonNull(teamId);
		return getLeagueEntryByTeam(getRegion(), teamId);
	}

	/**
	 * Get challenger tier league for the given {@code queueType}.
	 * 
	 * @param region
	 *            The region of the leagues.
	 * @param queueType
	 *            Game queue type.
	 * @return A single league
	 * @throws NullPointerException
	 *             If {@code region} or {@code queueType} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see League
	 */
	public League getChallengerLeague(Region region, QueueType queueType) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(queueType);
		return LeagueApi.getChallengerLeague(region, getKey(), queueType);
	}

	/**
	 * Get challenger tier league for the given {@code queueType}.
	 * 
	 * @param queueType
	 *            Game queue type.
	 * @return A single league
	 * @throws NullPointerException
	 *             If {@code queueType} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see League
	 */
	public League getChallengerLeague(QueueType queueType) throws RiotApiException {
		Objects.requireNonNull(queueType);
		return getChallengerLeague(getRegion(), queueType);
	}

	/**
	 * Get master tier league for the given {@code queueType}.
	 * 
	 * @param region
	 *            The region of the leagues.
	 * @param queueType
	 *            Game queue type.
	 * @return A single league
	 * @throws NullPointerException
	 *             If {@code region} or {@code queueType} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see League
	 */
	public League getMasterLeague(Region region, QueueType queueType) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(queueType);
		return LeagueApi.getMasterLeague(region, getKey(), queueType);
	}

	/**
	 * Get master tier league for the given {@code queueType}.
	 * 
	 * @param queueType
	 *            Game queue type.
	 * @return A single league
	 * @throws NullPointerException
	 *             If {@code queueType} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see League
	 */
	public League getMasterLeague(QueueType queueType) throws RiotApiException {
		Objects.requireNonNull(queueType);
		return getMasterLeague(getRegion(), queueType);
	}

	/**
	 * Get player stats summaries by {@code summonerId}.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerId
	 *            ID of the summoner for which to retrieve player stats.
	 * @param season
	 *            If specified, stats for the given season are returned. Otherwise, stats for the current season are returned.
	 * @return A summary of player statistics for the given summoner
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see PlayerStatsSummaryList
	 */
	public PlayerStatsSummaryList getPlayerStatsSummary(Region region, Season season, long summonerId) throws RiotApiException {
		Objects.requireNonNull(region);
		return StatsApi.getPlayerStatsSummary(region, season, getKey(), summonerId);
	}

	/**
	 * Get player stats summaries by {@code summonerId}.
	 *
	 * @param summonerId
	 *            ID of the summoner for which to retrieve player stats.
	 * @param season
	 *            If specified, stats for the given season are returned. Otherwise, stats for the current season are returned.
	 * @return A summary of player statistics for the given summoner
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see PlayerStatsSummaryList
	 */
	public PlayerStatsSummaryList getPlayerStatsSummary(Season season, long summonerId) throws RiotApiException {
		return getPlayerStatsSummary(getRegion(), season, summonerId);
	}

	/**
	 * Get player stats summaries by {@code summonerId}.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerId
	 *            ID of the summoner for which to retrieve player stats.
	 * @return A summary of player statistics for the given summoner
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see PlayerStatsSummaryList
	 */
	public PlayerStatsSummaryList getPlayerStatsSummary(Region region, long summonerId) throws RiotApiException {
		Objects.requireNonNull(region);
		return getPlayerStatsSummary(region, getSeason(), summonerId);
	}

	/**
	 * Get player stats summaries by {@code summonerId}.
	 *
	 * @param summonerId
	 *            ID of the summoner for which to retrieve player stats.
	 * @return A summary of player statistics for the given summoner
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see PlayerStatsSummaryList
	 */
	public PlayerStatsSummaryList getPlayerStatsSummary(long summonerId) throws RiotApiException {
		return getPlayerStatsSummary(getRegion(), summonerId);
	}

	/**
	 * Get ranked stats by {@code summonerId}.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerId
	 *            ID of the summoner for which to retrieve ranked stats.
	 * @param season
	 *            If specified, stats for the given season are returned. Otherwise, stats for the current season are returned.
	 * @return Ranked statistics of the given summoner
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see RankedStats
	 */
	public RankedStats getRankedStats(Region region, Season season, long summonerId) throws RiotApiException {
		Objects.requireNonNull(region);
		return StatsApi.getRankedStats(region, season, getKey(), summonerId);
	}

	/**
	 * Get ranked stats by {@code summonerId}.
	 *
	 * @param summonerId
	 *            ID of the summoner for which to retrieve ranked stats.
	 * @param season
	 *            If specified, stats for the given season are returned. Otherwise, stats for the current season are returned.
	 * @return Ranked statistics of the given summoner
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see RankedStats
	 */
	public RankedStats getRankedStats(Season season, long summonerId) throws RiotApiException {
		return getRankedStats(getRegion(), season, summonerId);
	}

	/**
	 * Get ranked stats by {@code summonerId}.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerId
	 *            ID of the summoner for which to retrieve ranked stats.
	 * @return Ranked statistics of the given summoner
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see RankedStats
	 */
	public RankedStats getRankedStats(Region region, long summonerId) throws RiotApiException {
		Objects.requireNonNull(region);
		return getRankedStats(region, getSeason(), summonerId);
	}

	/**
	 * Get ranked stats by {@code summonerId}.
	 *
	 * @param summonerId
	 *            ID of the summoner for which to retrieve ranked stats.
	 * @return Ranked statistics of the given summoner
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see RankedStats
	 */
	public RankedStats getRankedStats(long summonerId) throws RiotApiException {
		return getRankedStats(getRegion(), summonerId);
	}

	/**
	 * Get mastery pages mapped by summoner ID for a given list of {@code summonerIds}.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerIds
	 *            Comma-separated list of summoner IDs associated with masteries to retrieve. Maximum allowed at once is 40.
	 * @return A map of mastery pages of the given summoners
	 * @throws NullPointerException
	 *             If {@code region} or {@code summonerIds} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see MasteryPages
	 */
	public Map<String, MasteryPages> getMasteryPages(Region region, String... summonerIds) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerIds);
		return SummonerApi.getMasteryPages(region, getKey(), Convert.joinString(",", summonerIds));
	}

	/**
	 * Get mastery pages mapped by summoner ID for a given list of {@code summonerIds}.
	 *
	 * @param summonerIds
	 *            Comma-separated list of summoner IDs associated with masteries to retrieve. Maximum allowed at once is 40.
	 * @return A map of mastery pages of the given summoners
	 * @throws NullPointerException
	 *             If {@code summonerIds} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see MasteryPages
	 */
	public Map<String, MasteryPages> getMasteryPages(String... summonerIds) throws RiotApiException {
		Objects.requireNonNull(summonerIds);
		return getMasteryPages(getRegion(), summonerIds);
	}

	/**
	 * Get mastery pages mapped by summoner ID for a given list of {@code summonerIds}.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerIds
	 *            List of summoner IDs associated with masteries to retrieve. Maximum allowed at once is 40.
	 * @return A map of mastery pages of the given summoners
	 * @throws NullPointerException
	 *             If {@code region} or {@code summonerIds} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see MasteryPages
	 */
	public Map<String, MasteryPages> getMasteryPages(Region region, long... summonerIds) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerIds);
		return getMasteryPages(region, Convert.longToString(summonerIds));
	}

	/**
	 * Get mastery pages mapped by summoner ID for a given list of {@code summonerIds}.
	 *
	 * @param summonerIds
	 *            List of summoner IDs associated with masteries to retrieve. Maximum allowed at once is 40.
	 * @return A map of mastery pages of the given summoners
	 * @throws NullPointerException
	 *             If {@code summonerIds} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see MasteryPages
	 */
	public Map<String, MasteryPages> getMasteryPages(long... summonerIds) throws RiotApiException {
		Objects.requireNonNull(summonerIds);
		return getMasteryPages(getRegion(), summonerIds);
	}

	/**
	 * Get mastery pages for a given {@code summonerId}.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerId
	 *            Summoner ID associated with masteries to retrieve.
	 * @return A map of mastery pages of the given summoner
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see MasteryPages
	 */
	public MasteryPages getMasteryPages(Region region, long summonerId) throws RiotApiException {
		Objects.requireNonNull(region);
		String summonerIdString = String.valueOf(summonerId);
		Map<String, MasteryPages> masteryPages = getMasteryPages(region, summonerIdString);
		if (!masteryPages.containsKey(summonerIdString)) {
			throw new RiotApiException(RiotApiException.DATA_NOT_FOUND);
		}
		return masteryPages.get(summonerIdString);
	}

	/**
	 * Get mastery pages for a given {@code summonerId}.
	 *
	 * @param summonerId
	 *            Summoner ID associated with masteries to retrieve.
	 * @return A map of mastery pages of the given summoner
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see MasteryPages
	 */
	public MasteryPages getMasteryPages(long summonerId) throws RiotApiException {
		return getMasteryPages(getRegion(), summonerId);
	}

	/**
	 * Get rune pages mapped by summoner ID for a given list of {@code summonerIds}.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerIds
	 *            Comma-separated list of summoner IDs associated with runes to retrieve. Maximum allowed at once is 40.
	 * @return A map of rune pages of the given summoners
	 * @throws NullPointerException
	 *             If {@code region} or {@code summonerIds} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see RunePages
	 */
	public Map<String, RunePages> getRunePages(Region region, String... summonerIds) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerIds);
		return SummonerApi.getRunePages(region, getKey(), Convert.joinString(",", summonerIds));
	}

	/**
	 * Get rune pages mapped by summoner ID for a given list of {@code summonerIds}.
	 *
	 * @param summonerIds
	 *            Comma-separated list of summoner IDs associated with runes to retrieve. Maximum allowed at once is 40.
	 * @return A map of rune pages of the given summoners
	 * @throws NullPointerException
	 *             If {@code summonerIds} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see RunePages
	 */
	public Map<String, RunePages> getRunePages(String... summonerIds) throws RiotApiException {
		Objects.requireNonNull(summonerIds);
		return getRunePages(getRegion(), summonerIds);
	}

	/**
	 * Get rune pages mapped by summoner ID for a given list of {@code summonerIds}.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerIds
	 *            List of summoner IDs associated with runes to retrieve. Maximum allowed at once is 40.
	 * @return A map of rune pages of the given summoners
	 * @throws NullPointerException
	 *             If {@code region} or {@code summonerIds} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see RunePages
	 */
	public Map<String, RunePages> getRunePages(Region region, long... summonerIds) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerIds);
		return getRunePages(region, Convert.longToString(summonerIds));
	}

	/**
	 * Get rune pages mapped by summoner ID for a given list of {@code summonerIds}.
	 *
	 * @param summonerIds
	 *            List of summoner IDs associated with runes to retrieve. Maximum allowed at once is 40.
	 * @return A map of rune pages of the given summoners
	 * @throws NullPointerException
	 *             If {@code summonerIds} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see RunePages
	 */
	public Map<String, RunePages> getRunePages(long... summonerIds) throws RiotApiException {
		Objects.requireNonNull(summonerIds);
		return getRunePages(getRegion(), summonerIds);
	}

	/**
	 * Get rune pages for a given {@code summonerId}.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerId
	 *            Summoner ID associated with runes to retrieve.
	 * @return A map of rune pages of the given summoner
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see RunePages
	 */
	public RunePages getRunePages(Region region, long summonerId) throws RiotApiException {
		Objects.requireNonNull(region);
		String summonerIdString = String.valueOf(summonerId);
		Map<String, RunePages> runePages = getRunePages(region, summonerIdString);
		if (!runePages.containsKey(summonerIdString)) {
			throw new RiotApiException(RiotApiException.DATA_NOT_FOUND);
		}
		return runePages.get(summonerIdString);
	}

	/**
	 * Get rune pages for a given {@code summonerId}.
	 *
	 * @param summonerId
	 *            Summoner ID associated with runes to retrieve.
	 * @return A map of rune pages of the given summoner
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see RunePages
	 */
	public RunePages getRunePages(long summonerId) throws RiotApiException {
		return getRunePages(getRegion(), summonerId);
	}

	/**
	 * Get summoner objects mapped by standardized summoner name for a given list of {@code summonerNames}.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerNames
	 *            Comma-separated list of summoner names or standardized summoner names associated with summoners to retrieve. Maximum
	 *            allowed at once is 40.
	 * @return A map of desired summoners
	 * @throws NullPointerException
	 *             If {@code region} or {@code summonerNames} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Summoner
	 */
	public Map<String, Summoner> getSummonersByName(Region region, String... summonerNames) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerNames);
		return SummonerApi.getSummonersByName(region, getKey(), Convert.joinString(",", summonerNames));
	}

	/**
	 * Get summoner objects mapped by standardized summoner name for a given list of {@code summonerNames}.
	 *
	 * @param summonerNames
	 *            Comma-separated list of summoner names or standardized summoner names associated with summoners to retrieve. Maximum
	 *            allowed at once is 40.
	 * @return A map of desired summoners
	 * @throws NullPointerException
	 *             If {@code summonerNames} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Summoner
	 */
	public Map<String, Summoner> getSummonersByName(String... summonerNames) throws RiotApiException {
		Objects.requireNonNull(summonerNames);
		return getSummonersByName(getRegion(), summonerNames);
	}

	/**
	 * Get a single summoner object for a given {@code summonerName}.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerName
	 *            Summoner name or standardized summoner name associated with summoner to retrieve.
	 * @return The desired summoner
	 * @throws NullPointerException
	 *             If {@code region} or {@code summonerName} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Summoner
	 */
	public Summoner getSummonerByName(Region region, String summonerName) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerName);
		Map<String, Summoner> summoners = getSummonersByName(region, summonerName);
		String key = Convert.normalizeSummonerName(summonerName);
		if (!summoners.containsKey(key)) {
			throw new RiotApiException(RiotApiException.DATA_NOT_FOUND);
		}
		return summoners.get(key);
	}

	/**
	 * Get a single summoner object for a given {@code summonerName}.
	 *
	 * @param summonerName
	 *            Summoner name or standardized summoner name associated with summoner to retrieve.
	 * @return The desired summoner
	 * @throws NullPointerException
	 *             If {@code summonerName} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Summoner
	 */
	public Summoner getSummonerByName(String summonerName) throws RiotApiException {
		Objects.requireNonNull(summonerName);
		return getSummonerByName(getRegion(), summonerName);
	}

	/**
	 * Get summoner objects mapped by summoner ID for a given list of {@code summonerIds}.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerIds
	 *            Comma-separated list of summoner IDs associated with summoners to retrieve. Maximum allowed at once is 40.
	 * @return A map of desired summoners
	 * @throws NullPointerException
	 *             If {@code region} or {@code summonerIds} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Summoner
	 */
	public Map<String, Summoner> getSummonersById(Region region, String... summonerIds) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerIds);
		return SummonerApi.getSummonersById(region, getKey(), Convert.joinString(",", summonerIds));
	}

	/**
	 * Get summoner objects mapped by summoner ID for a given list of {@code summonerIds}.
	 *
	 * @param summonerIds
	 *            Comma-separated list of summoner IDs associated with summoners to retrieve. Maximum allowed at once is 40.
	 * @return A map of desired summoners
	 * @throws NullPointerException
	 *             If {@code summonerIds} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Summoner
	 */
	public Map<String, Summoner> getSummonersById(String... summonerIds) throws RiotApiException {
		Objects.requireNonNull(summonerIds);
		return getSummonersById(getRegion(), summonerIds);
	}

	/**
	 * Get summoner objects mapped by summoner ID for a given list of {@code summonerIds}.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerIds
	 *            List of summoner IDs associated with summoners to retrieve. Maximum allowed at once is 40.
	 * @return A map of desired summoners
	 * @throws NullPointerException
	 *             If {@code region} or {@code summonerIds} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Summoner
	 */
	public Map<String, Summoner> getSummonersById(Region region, long... summonerIds) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerIds);
		return getSummonersById(region, Convert.longToString(summonerIds));
	}

	/**
	 * Get summoner objects mapped by summoner ID for a given list of {@code summonerIds}.
	 *
	 * @param summonerIds
	 *            List of summoner IDs associated with summoners to retrieve. Maximum allowed at once is 40.
	 * @return A map of desired summoners
	 * @throws NullPointerException
	 *             If {@code summonerIds} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Summoner
	 */
	public Map<String, Summoner> getSummonersById(long... summonerIds) throws RiotApiException {
		Objects.requireNonNull(summonerIds);
		return getSummonersById(getRegion(), summonerIds);
	}

	/**
	 * Get a summoner objects for a given {@code summonerId}.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerId
	 *            Summoner IDs associated with summoner to retrieve.
	 * @return The desired summoner
	 * @throws NullPointerException
	 *             If {@code region} or {@code summonerId} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Summoner
	 */
	public Summoner getSummonerById(Region region, String summonerId) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerId);
		Map<String, Summoner> summoners = getSummonersById(region, summonerId);
		if (!summoners.containsKey(summonerId)) {
			throw new RiotApiException(RiotApiException.DATA_NOT_FOUND);
		}
		return summoners.get(summonerId);
	}

	/**
	 * Get a summoner objects for a given {@code summonerId}.
	 *
	 * @param summonerId
	 *            Summoner IDs associated with summoner to retrieve.
	 * @return The desired summoner
	 * @throws NullPointerException
	 *             If {@code summonerId} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Summoner
	 */
	public Summoner getSummonerById(String summonerId) throws RiotApiException {
		Objects.requireNonNull(summonerId);
		return getSummonerById(getRegion(), summonerId);
	}

	/**
	 * Get a summoner objects for a given {@code summonerId}.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerId
	 *            Summoner IDs associated with summoner to retrieve.
	 * @return The desired summoner
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Summoner
	 */
	public Summoner getSummonerById(Region region, long summonerId) throws RiotApiException {
		Objects.requireNonNull(region);
		return getSummonerById(region, String.valueOf(summonerId));
	}

	/**
	 * Get a summoner objects for a given {@code summonerId}.
	 *
	 * @param summonerId
	 *            Summoner IDs associated with summoner to retrieve.
	 * @return The desired summoner
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Summoner
	 */
	public Summoner getSummonerById(long summonerId) throws RiotApiException {
		return getSummonerById(getRegion(), summonerId);
	}

	/**
	 * Get summoner names mapped by summoner ID for a given list of {@code summonerIds}.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerIds
	 *            Comma-separated list of summoner IDs associated with summoner names to retrieve. Maximum allowed at once is 40.
	 * @return A map of desired summoner names
	 * @throws NullPointerException
	 *             If {@code region} or {@code summonerIds} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public Map<String, String> getSummonerNames(Region region, String... summonerIds) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerIds);
		return SummonerApi.getSummonerNames(region, getKey(), Convert.joinString(",", summonerIds));
	}

	/**
	 * Get summoner names mapped by summoner ID for a given list of {@code summonerIds}.
	 *
	 * @param summonerIds
	 *            Comma-separated list of summoner IDs associated with summoner names to retrieve. Maximum allowed at once is 40.
	 * @return A map of desired summoner names
	 * @throws NullPointerException
	 *             If {@code summonerIds} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public Map<String, String> getSummonerNames(String... summonerIds) throws RiotApiException {
		Objects.requireNonNull(summonerIds);
		return getSummonerNames(getRegion(), summonerIds);
	}

	/**
	 * Get summoner names mapped by summoner ID for a given list of {@code summonerIds}.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerIds
	 *            List of summoner IDs associated with summoner names to retrieve. Maximum allowed at once is 40.
	 * @return A map of desired summoner names
	 * @throws NullPointerException
	 *             If {@code region} or {@code summonerIds} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public Map<String, String> getSummonerNames(Region region, long... summonerIds) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerIds);
		return getSummonerNames(region, Convert.longToString(summonerIds));
	}

	/**
	 * Get summoner names mapped by summoner ID for a given list of {@code summonerIds}.
	 *
	 * @param summonerIds
	 *            List of summoner IDs associated with summoner names to retrieve. Maximum allowed at once is 40.
	 * @return A map of desired summoner names
	 * @throws NullPointerException
	 *             If {@code summonerIds} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public Map<String, String> getSummonerNames(long... summonerIds) throws RiotApiException {
		Objects.requireNonNull(summonerIds);
		return getSummonerNames(getRegion(), summonerIds);
	}

	/**
	 * Get summoner name for a given {@code summonerId}.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerId
	 *            Summoner ID associated with summoner name to retrieve.
	 * @return The desired summoner name
	 * @throws NullPointerException
	 *             If {@code region} or {@code summonerId} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public String getSummonerName(Region region, String summonerId) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerId);
		Map<String, String> summoners = getSummonerNames(region, summonerId);
		if (!summoners.containsKey(summonerId)) {
			throw new RiotApiException(RiotApiException.DATA_NOT_FOUND);
		}
		return summoners.get(summonerId);
	}

	/**
	 * Get summoner name for a given {@code summonerId}.
	 *
	 * @param summonerId
	 *            Summoner ID associated with summoner name to retrieve.
	 * @return A map of desired summoner names
	 * @throws NullPointerException
	 *             If {@code summonerId} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public String getSummonerName(String summonerId) throws RiotApiException {
		Objects.requireNonNull(summonerId);
		return getSummonerName(getRegion(), summonerId);
	}

	/**
	 * Get summoner name for a given {@code summonerId}.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @param summonerId
	 *            Summoner ID associated with summoner name to retrieve.
	 * @return The desired summoner name
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public String getSummonerName(Region region, long summonerId) throws RiotApiException {
		Objects.requireNonNull(region);
		return getSummonerName(region, String.valueOf(summonerId));
	}

	/**
	 * Get summoner name for a given {@code summonerId}.
	 *
	 * @param summonerId
	 *            Summoner ID associated with summoner name to retrieve.
	 * @return The desired summoner name
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public String getSummonerName(long summonerId) throws RiotApiException {
		return getSummonerName(getRegion(), summonerId);
	}

	/**
	 * Get teams mapped by summoner ID for a given list of {@code summonerIds}.
	 *
	 * @param region
	 *            The region of the summoner.
	 * @param summonerIds
	 *            Comma-separated list of summoner IDs. Maximum allowed at once is 10.
	 * @return A map of the summoners' teams
	 * @throws NullPointerException
	 *             If {@code region} or {@code summonerIds} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Team
	 */
	public Map<String, List<Team>> getTeamsBySummonerIds(Region region, String... summonerIds) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerIds);
		return TeamApi.getTeamsBySummonerIds(region, getKey(), Convert.joinString(",", summonerIds));
	}

	/**
	 * Get teams mapped by summoner ID for a given list of {@code summonerIds}.
	 *
	 * @param summonerIds
	 *            Comma-separated list of summoner IDs
	 * @return A map of the summoners' teams
	 * @throws NullPointerException
	 *             If {@code summonerIds} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Team
	 */
	public Map<String, List<Team>> getTeamsBySummonerIds(String... summonerIds) throws RiotApiException {
		Objects.requireNonNull(summonerIds);
		return getTeamsBySummonerIds(getRegion(), summonerIds);
	}

	/**
	 * Get teams mapped by summoner ID for a given list of {@code summonerIds}.
	 *
	 * @param region
	 *            The region of the summoner.
	 * @param summonerIds
	 *            A list of summoner IDs. Maximum allowed at once is 10.
	 * @return A map of the summoners' teams
	 * @throws NullPointerException
	 *             If {@code region} or {@code summonerIds} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Team
	 */
	public Map<String, List<Team>> getTeamsBySummonerIds(Region region, long... summonerIds) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerIds);
		return getTeamsBySummonerIds(region, Convert.longToString(summonerIds));
	}

	/**
	 * Get teams mapped by summoner ID for a given list of {@code summonerIds}.
	 *
	 * @param summonerIds
	 *            A list of summoner IDs. Maximum allowed at once is 10.
	 * @return A map of the summoners' teams
	 * @throws NullPointerException
	 *             If {@code summonerIds} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Team
	 */
	public Map<String, List<Team>> getTeamsBySummonerIds(long... summonerIds) throws RiotApiException {
		Objects.requireNonNull(summonerIds);
		return getTeamsBySummonerIds(getRegion(), summonerIds);
	}

	/**
	 * Get teams for a given {@code summonerId}.
	 *
	 * @param region
	 *            The region of the summoner.
	 * @param summonerId
	 *            Summoner ID
	 * @return A list of the summoner's teams
	 * @throws NullPointerException
	 *             If {@code region} or {@code summonerId} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Team
	 */
	public List<Team> getTeamsBySummonerId(Region region, String summonerId) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerId);
		Map<String, List<Team>> teams = getTeamsBySummonerIds(region, summonerId);
		if (!teams.containsKey(summonerId)) {
			throw new RiotApiException(RiotApiException.DATA_NOT_FOUND);
		}
		return teams.get(summonerId);
	}

	/**
	 * Get teams for a given {@code summonerId}.
	 *
	 * @param summonerId
	 *            A summoner ID
	 * @return A list of the summoner's teams
	 * @throws NullPointerException
	 *             If {@code summonerId} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Team
	 */
	public List<Team> getTeamsBySummonerId(String summonerId) throws RiotApiException {
		Objects.requireNonNull(summonerId);
		return getTeamsBySummonerId(getRegion(), summonerId);
	}

	/**
	 * Get teams for a given {@code summonerId}.
	 *
	 * @param region
	 *            The region of the summoner.
	 * @param summonerId
	 *            Summoner ID
	 * @return A list of the summoner's teams
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Team
	 */
	public List<Team> getTeamsBySummonerId(Region region, long summonerId) throws RiotApiException {
		Objects.requireNonNull(region);
		return getTeamsBySummonerId(region, Convert.longToString(summonerId));
	}

	/**
	 * Get teams for a given {@code summonerId}.
	 *
	 * @param summonerId
	 *            A summoner ID
	 * @return A list of the summoner's teams
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Team
	 */
	public List<Team> getTeamsBySummonerId(long summonerId) throws RiotApiException {
		return getTeamsBySummonerId(getRegion(), summonerId);
	}

	/**
	 * Get teams mapped by team ID for a given list of {@code teamIds}.
	 *
	 * @param region
	 *            The region of the summoner.
	 * @param teamIds
	 *            Comma-separated list of team IDs. Maximum allowed at once is 10.
	 * @return A map of teams
	 * @throws NullPointerException
	 *             If {@code region} or {@code teamIds} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Team
	 */
	public Map<String, Team> getTeamsByTeamIds(Region region, String... teamIds) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(teamIds);
		return TeamApi.getTeamsByTeamIds(region, getKey(), Convert.joinString(",", teamIds));
	}

	/**
	 * Get teams mapped by team ID for a given list of {@code teamIds}.
	 *
	 * @param teamIds
	 *            Comma-separated list of team IDs. Maximum allowed at once is 10.
	 * @return A map of teams
	 * @throws NullPointerException
	 *             If {@code teamIds} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Team
	 */
	public Map<String, Team> getTeamsByTeamIds(String... teamIds) throws RiotApiException {
		Objects.requireNonNull(teamIds);
		return getTeamsByTeamIds(getRegion(), teamIds);
	}

	/**
	 * Get team for a given {@code teamId}.
	 *
	 * @param region
	 *            The region of the summoner.
	 * @param teamId
	 *            Team ID
	 * @return A team
	 * @throws NullPointerException
	 *             If {@code region} or {@code teamId} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Team
	 */
	public Team getTeamByTeamId(Region region, String teamId) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(teamId);
		Map<String, Team> teams = getTeamsByTeamIds(region, teamId);
		if (!teams.containsKey(teamId)) {
			throw new RiotApiException(RiotApiException.DATA_NOT_FOUND);
		}
		return teams.get(teamId);
	}

	/**
	 * Get team for a given {@code teamId}.
	 *
	 * @param teamId
	 *            Comma-separated list of team IDs. Maximum allowed at once is 10.
	 * @return A team
	 * @throws NullPointerException
	 *             If {@code teamId} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Team
	 */
	public Team getTeamByTeamId(String teamId) throws RiotApiException {
		Objects.requireNonNull(teamId);
		return getTeamByTeamId(getRegion(), teamId);
	}

	/**
	 * Retrieve match by {@code matchId}.
	 *
	 * @param region
	 *            The region of the summoner.
	 * @param matchId
	 *            The ID of the match.
	 * @param includeTimeline
	 *            Flag indicating whether or not to include match timeline data
	 * @return A map with match details
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see MatchDetail
	 */
	public MatchDetail getMatch(Region region, long matchId, boolean includeTimeline) throws RiotApiException {
		Objects.requireNonNull(region);
		return MatchApi.getMatch(region, getKey(), matchId, includeTimeline);
	}

	/**
	 * Retrieve match by {@code matchId}.
	 *
	 * @param matchId
	 *            The ID of the match.
	 * @param includeTimeline
	 *            Flag indicating whether or not to include match timeline data
	 * @return A map with match details
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see MatchDetail
	 */
	public MatchDetail getMatch(long matchId, boolean includeTimeline) throws RiotApiException {
		return getMatch(getRegion(), matchId, includeTimeline);
	}

	/**
	 * Retrieve match by {@code matchId}.
	 *
	 * @param region
	 *            The region of the summoner.
	 * @param matchId
	 *            The ID of the match.
	 * @return A map with match details
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see MatchDetail
	 */
	public MatchDetail getMatch(Region region, long matchId) throws RiotApiException {
		Objects.requireNonNull(region);
		return getMatch(region, matchId, false);
	}

	/**
	 * Retrieve match by {@code matchId}.
	 *
	 * @param matchId
	 *            The ID of the match
	 * @return A map with match details
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see MatchDetail
	 */
	public MatchDetail getMatch(long matchId) throws RiotApiException {
		return getMatch(getRegion(), matchId);
	}

	/**
	 * Retrieve match list by {@code summonerId}.
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
	 *            The begin time to use for fetching games specified as epoch milliseconds. Use {@code -1} to not use this parameter.
	 * @param endTime
	 *            The end time to use for fetching games specified as epoch milliseconds. Use {@code -1} to not use this parameter.
	 * @param beginIndex
	 *            The begin index to use for fetching games. Use {@code -1} to not use this parameter.
	 * @param endIndex
	 *            The end index to use for fetching games. Use {@code -1} to not use this parameter.
	 * @return A list with matches
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see MatchList
	 */
	public MatchList getMatchList(Region region, long summonerId, String championIds, String rankedQueues, String seasons, long beginTime, long endTime,
			int beginIndex, int endIndex) throws RiotApiException {
		Objects.requireNonNull(region);
		return MatchListApi.getMatchList(region, getKey(), summonerId, championIds, rankedQueues, seasons, beginTime, endTime, beginIndex, endIndex);
	}

	/**
	 * Retrieve match list by {@code summonerId}.
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
	 *            The begin time to use for fetching games specified as epoch milliseconds. Use {@code -1} to not use this parameter.
	 * @param endTime
	 *            The end time to use for fetching games specified as epoch milliseconds. Use {@code -1} to not use this parameter.
	 * @param beginIndex
	 *            The begin index to use for fetching games. Use {@code -1} to not use this parameter.
	 * @param endIndex
	 *            The end index to use for fetching games. Use {@code -1} to not use this parameter.
	 * @return A list with matches
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see MatchList
	 */
	public MatchList getMatchList(long summonerId, String championIds, String rankedQueues, String seasons, long beginTime, long endTime, int beginIndex,
			int endIndex) throws RiotApiException {
		return getMatchList(getRegion(), summonerId, championIds, rankedQueues, seasons, beginTime, endTime, beginIndex, endIndex);
	}

	/**
	 * Retrieve match list by {@code summonerId}.
	 *
	 * @param region
	 *            The region of the summoner.
	 * @param summonerId
	 *            The ID of the summoner.
	 * @return A list with matches
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see MatchList
	 */
	public MatchList getMatchList(Region region, long summonerId) throws RiotApiException {
		Objects.requireNonNull(region);
		return getMatchList(region, summonerId, null, null, null, -1, -1, -1, -1);
	}

	/**
	 * Retrieve match list by {@code summonerId}.
	 *
	 * @param summonerId
	 *            The ID of the summoner.
	 * @return A list with matches
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see MatchList
	 */
	public MatchList getMatchList(long summonerId) throws RiotApiException {
		return getMatchList(getRegion(), summonerId);
	}

	/**
	 * Get current game information for the given summoner ID.
	 * 
	 * @param platformId
	 *            The platform ID for which to fetch data.
	 * @param summonerId
	 *            The ID of the summoner.
	 * @return Current game info
	 * @throws NullPointerException
	 *             If {@code platformId} or {@code summonerId} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see CurrentGameInfo
	 */
	public CurrentGameInfo getCurrentGameInfo(PlatformId platformId, String summonerId) throws RiotApiException {
		Objects.requireNonNull(platformId);
		Objects.requireNonNull(summonerId);
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
	 * @throws NullPointerException
	 *             If {@code platformId} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see CurrentGameInfo
	 */
	public CurrentGameInfo getCurrentGameInfo(PlatformId platformId, long summonerId) throws RiotApiException {
		Objects.requireNonNull(platformId);
		return getCurrentGameInfo(platformId, String.valueOf(summonerId));
	}

	/**
	 * Get list of featured games.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return Featured games
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see FeaturedGames
	 */
	public FeaturedGames getFeaturedGames(Region region) throws RiotApiException {
		Objects.requireNonNull(region);
		return FeaturedGamesApi.getFeaturedGames(region, getKey());
	}

	/**
	 * Get list of featured games.
	 * 
	 * @return Featured games
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see FeaturedGames
	 */
	public FeaturedGames getFeaturedGames() throws RiotApiException {
		return getFeaturedGames(getRegion());
	}

	/**
	 * Retrieves champion list.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @param dataById
	 *            If specified as true, the returned data map will use the champions' IDs as the keys. If specified as false, the returned
	 *            data map will use the champions' keys instead.
	 * @param champData
	 *            Tags to return additional data. Only {@code id}, {@code key}, {@code name}, and {@code title} are returned by default if
	 *            this parameter isn't specified. To return all additional data, use {@code ChampData.ALL}.
	 * @return A list with champions
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see net.rithms.riot.dto.Static.ChampionList
	 */
	public net.rithms.riot.dto.Static.ChampionList getDataChampionList(Region region, String locale, String version, boolean dataById, ChampData... champData)
			throws RiotApiException {
		Objects.requireNonNull(region);
		return StaticDataApi.getDataChampionList(region, getKey(), locale, version, dataById, champData);
	}

	/**
	 * Retrieves champion list.
	 * 
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @param dataById
	 *            If specified as true, the returned data map will use the champions' IDs as the keys. If specified as false, the returned
	 *            data map will use the champions' keys instead.
	 * @param champData
	 *            Tags to return additional data. Only {@code id}, {@code key}, {@code name}, and {@code title} are returned by default if
	 *            this parameter isn't specified. To return all additional data, use {@code ChampData.ALL}.
	 * @return A list with champions
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see net.rithms.riot.dto.Static.ChampionList
	 */
	public net.rithms.riot.dto.Static.ChampionList getDataChampionList(String locale, String version, boolean dataById, ChampData... champData)
			throws RiotApiException {
		return getDataChampionList(getRegion(), locale, version, dataById, champData);
	}

	/**
	 * Retrieves champion list.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return A list with champions
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see net.rithms.riot.dto.Static.ChampionList
	 */
	public net.rithms.riot.dto.Static.ChampionList getDataChampionList(Region region) throws RiotApiException {
		Objects.requireNonNull(region);
		return getDataChampionList(region, null, null, false, (ChampData) null);
	}

	/**
	 * Retrieves champion list.
	 * 
	 * @return A list with champions
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see net.rithms.riot.dto.Static.ChampionList
	 */
	public net.rithms.riot.dto.Static.ChampionList getDataChampionList() throws RiotApiException {
		return getDataChampionList(getRegion());
	}

	/**
	 * Retrieves a champion by its {@code id}.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param id
	 *            Champion ID
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @param champData
	 *            Tags to return additional data. Only {@code id}, {@code key}, {@code name}, and {@code title} are returned by default if
	 *            this parameter isn't specified. To return all additional data, use {@code ChampData.ALL}.
	 * @return A single champion
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see net.rithms.riot.dto.Static.Champion
	 */
	public net.rithms.riot.dto.Static.Champion getDataChampion(Region region, int id, String locale, String version, ChampData... champData)
			throws RiotApiException {
		Objects.requireNonNull(region);
		return StaticDataApi.getDataChampion(region, getKey(), id, locale, version, champData);
	}

	/**
	 * Retrieves a champion by its {@code id}.
	 * 
	 * @param id
	 *            Champion ID
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @param champData
	 *            Tags to return additional data. Only {@code id}, {@code key}, {@code name}, and {@code title} are returned by default if
	 *            this parameter isn't specified. To return all additional data, use {@code ChampData.ALL}.
	 * @return A single champion
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see net.rithms.riot.dto.Static.Champion
	 */
	public net.rithms.riot.dto.Static.Champion getDataChampion(int id, String locale, String version, ChampData... champData) throws RiotApiException {
		return getDataChampion(getRegion(), id, locale, version, champData);
	}

	/**
	 * Retrieves a champion by its {@code id}.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param id
	 *            Champion ID
	 * @return A single champion
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see net.rithms.riot.dto.Static.Champion
	 */
	public net.rithms.riot.dto.Static.Champion getDataChampion(Region region, int id) throws RiotApiException {
		Objects.requireNonNull(region);
		return getDataChampion(region, id, null, null, (ChampData) null);
	}

	/**
	 * Retrieves a champion by its {@code id}.
	 * 
	 * @param id
	 *            Champion ID
	 * @return A single champion
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see net.rithms.riot.dto.Static.Champion
	 */
	public net.rithms.riot.dto.Static.Champion getDataChampion(int id) throws RiotApiException {
		return getDataChampion(getRegion(), id);
	}

	/**
	 * Retrieves map data.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @return A list of game maps
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see GameMapList
	 */
	public GameMapList getDataGameMapList(Region region, String locale, String version) throws RiotApiException {
		Objects.requireNonNull(region);
		return StaticDataApi.getDataGameMapList(region, getKey(), locale, version);
	}

	/**
	 * Retrieves map data.
	 * 
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @return A list of game maps
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see GameMapList
	 */
	public GameMapList getDataGameMapList(String locale, String version) throws RiotApiException {
		return getDataGameMapList(getRegion(), locale, version);
	}

	/**
	 * Retrieves map data.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return A list of game maps
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see GameMapList
	 */
	public GameMapList getDataGameMapList(Region region) throws RiotApiException {
		Objects.requireNonNull(region);
		return getDataGameMapList(region, null, null);
	}

	/**
	 * Retrieves map data.
	 * 
	 * @return A list of game maps
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see GameMapList
	 */
	public GameMapList getDataGameMapList() throws RiotApiException {
		return getDataGameMapList(getRegion());
	}

	/**
	 * Retrieves item list.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @param itemListData
	 *            Tags to return additional data. Only {@code type}, {@code version}, {@code basic}, {@code data}, {@code id}, {@code name},
	 *            {@code plaintext}, {@code group}, and {@code description} are returned by default if this parameter isn't specified. To
	 *            return all additional data, use {@code ItemListData.ALL}.
	 * @return A list of items
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see ItemList
	 */
	public ItemList getDataItemList(Region region, String locale, String version, ItemListData... itemListData) throws RiotApiException {
		Objects.requireNonNull(region);
		return StaticDataApi.getDataItemList(region, getKey(), locale, version, itemListData);
	}

	/**
	 * Retrieves item list.
	 * 
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @param itemListData
	 *            Tags to return additional data. Only {@code type}, {@code version}, {@code basic}, {@code data}, {@code id}, {@code name},
	 *            {@code plaintext}, {@code group}, and {@code description} are returned by default if this parameter isn't specified. To
	 *            return all additional data, use {@code ItemListData.ALL}.
	 * @return A list of items
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see ItemList
	 */
	public ItemList getDataItemList(String locale, String version, ItemListData... itemListData) throws RiotApiException {
		return getDataItemList(getRegion(), locale, version, itemListData);
	}

	/**
	 * Retrieves item list.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return A list of items
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see ItemList
	 */
	public ItemList getDataItemList(Region region) throws RiotApiException {
		Objects.requireNonNull(region);
		return getDataItemList(region, null, null, (ItemListData) null);
	}

	/**
	 * Retrieves item list.
	 * 
	 * @return A list of items
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see ItemList
	 */
	public ItemList getDataItemList() throws RiotApiException {
		return getDataItemList(getRegion());
	}

	/**
	 * Retrieves item by its unique {@code id}.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param id
	 *            Item ID
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @param itemData
	 *            Tags to return additional data. Only {@code type}, {@code version}, {@code basic}, {@code data}, {@code id}, {@code name},
	 *            {@code plaintext}, {@code group}, and {@code description} are returned by default if this parameter isn't specified. To
	 *            return all additional data, use {@code ItemData.ALL}.
	 * @return A single item
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Item
	 */
	public Item getDataItem(Region region, int id, String locale, String version, ItemData... itemData) throws RiotApiException {
		Objects.requireNonNull(region);
		return StaticDataApi.getDataItem(region, getKey(), id, locale, version, itemData);
	}

	/**
	 * Retrieves item by its unique {@code id}.
	 * 
	 * @param id
	 *            Item ID
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @param itemData
	 *            Tags to return additional data. Only {@code type}, {@code version}, {@code basic}, {@code data}, {@code id}, {@code name},
	 *            {@code plaintext}, {@code group}, and {@code description} are returned by default if this parameter isn't specified. To
	 *            return all additional data, use {@code ItemData.ALL}.
	 * @return A single item
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Item
	 */
	public Item getDataItem(int id, String locale, String version, ItemData... itemData) throws RiotApiException {
		return getDataItem(getRegion(), id, locale, version, itemData);
	}

	/**
	 * Retrieves item by its unique {@code id}.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param id
	 *            Item ID
	 * @return A single item
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Item
	 */
	public Item getDataItem(Region region, int id) throws RiotApiException {
		Objects.requireNonNull(region);
		return getDataItem(region, id, null, null, (ItemData) null);
	}

	/**
	 * Retrieves item by its unique {@code id}.
	 * 
	 * @param id
	 *            Item ID
	 * @return A single item
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Item
	 */
	public Item getDataItem(int id) throws RiotApiException {
		return getDataItem(getRegion(), id);
	}

	/**
	 * Retrieve supported languages data.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return A list with languages
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public List<String> getDataLanguages(Region region) throws RiotApiException {
		Objects.requireNonNull(region);
		return StaticDataApi.getDataLanguages(region, getKey());
	}

	/**
	 * Retrieve supported languages data.
	 * 
	 * @return A list with languages
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public List<String> getDataLanguages() throws RiotApiException {
		return getDataLanguages(getRegion());
	}

	/**
	 * Retrieve language strings data.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @return Language strings
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see LanguageStrings
	 */
	public LanguageStrings getDataLanguageStrings(Region region, String locale, String version) throws RiotApiException {
		Objects.requireNonNull(region);
		return StaticDataApi.getDataLanguageStrings(region, getKey(), locale, version);
	}

	/**
	 * Retrieve language strings data.
	 * 
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @return Language strings
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see LanguageStrings
	 */
	public LanguageStrings getDataLanguageStrings(String locale, String version) throws RiotApiException {
		return getDataLanguageStrings(getRegion(), locale, version);
	}

	/**
	 * Retrieve language strings data.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return Language strings
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see LanguageStrings
	 */
	public LanguageStrings getDataLanguageStrings(Region region) throws RiotApiException {
		Objects.requireNonNull(region);
		return getDataLanguageStrings(region, null, null);
	}

	/**
	 * Retrieve language strings data.
	 * 
	 * @return Language strings
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see LanguageStrings
	 */
	public LanguageStrings getDataLanguageStrings() throws RiotApiException {
		return getDataLanguageStrings(getRegion());
	}

	/**
	 * Retrieves mastery list.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @param masteryListData
	 *            Tags to return additional data. Only {@code type}, {@code version}, {@code data}, {@code id}, {@code name}, and
	 *            {@code description} are returned by default if this parameter isn't specified. To return all additional data, use
	 *            {@code MasteryListData.ALL}.
	 * @return A list with masteries
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see MasteryList
	 */
	public MasteryList getDataMasteryList(Region region, String locale, String version, MasteryListData... masteryListData) throws RiotApiException {
		Objects.requireNonNull(region);
		return StaticDataApi.getDataMasteryList(region, getKey(), locale, version, masteryListData);
	}

	/**
	 * Retrieves mastery list.
	 * 
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @param masteryListData
	 *            Tags to return additional data. Only {@code type}, {@code version}, {@code data}, {@code id}, {@code name}, and
	 *            {@code description} are returned by default if this parameter isn't specified. To return all additional data, use
	 *            {@code MasteryListData.ALL}.
	 * @return A list with masteries
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see MasteryList
	 */
	public MasteryList getDataMasteryList(String locale, String version, MasteryListData... masteryListData) throws RiotApiException {
		return getDataMasteryList(getRegion(), locale, version, masteryListData);
	}

	/**
	 * Retrieves mastery list.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return A list with masteries
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see MasteryList
	 */
	public MasteryList getDataMasteryList(Region region) throws RiotApiException {
		Objects.requireNonNull(region);
		return getDataMasteryList(region, null, null, (MasteryListData) null);
	}

	/**
	 * Retrieves mastery list.
	 * 
	 * @return A list with masteries
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see MasteryList
	 */
	public MasteryList getDataMasteryList() throws RiotApiException {
		return getDataMasteryList(getRegion());
	}

	/**
	 * Retrieves mastery item by its unique {@code id}.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param id
	 *            Mastery ID
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @param masteryData
	 *            Tags to return additional data. Only {@code id}, {@code name}, and {@code description} are returned by default if this
	 *            parameter isn't specified. To return all additional data, use {@code MasteryData.ALL}.
	 * @return A single mastery
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Mastery
	 */
	public Mastery getDataMastery(Region region, int id, String locale, String version, MasteryData... masteryData) throws RiotApiException {
		Objects.requireNonNull(region);
		return StaticDataApi.getDataMastery(region, getKey(), id, locale, version, masteryData);
	}

	/**
	 * Retrieves mastery item by its unique {@code id}.
	 * 
	 * @param id
	 *            Mastery ID
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @param masteryData
	 *            Tags to return additional data. Only {@code id}, {@code name}, and {@code description} are returned by default if this
	 *            parameter isn't specified. To return all additional data, use {@code MasteryData.ALL}.
	 * @return A single mastery
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Mastery
	 */
	public Mastery getDataMastery(int id, String locale, String version, MasteryData... masteryData) throws RiotApiException {
		return getDataMastery(getRegion(), id, locale, version, masteryData);
	}

	/**
	 * Retrieves mastery item by its unique {@code id}.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param id
	 *            Mastery ID
	 * @return A single mastery
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Mastery
	 */
	public Mastery getDataMastery(Region region, int id) throws RiotApiException {
		Objects.requireNonNull(region);
		return getDataMastery(region, id, null, null, (MasteryData) null);
	}

	/**
	 * Retrieves mastery item by its unique {@code id}.
	 * 
	 * @param id
	 *            Mastery ID
	 * @return A single mastery
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Mastery
	 */
	public Mastery getDataMastery(int id) throws RiotApiException {
		return getDataMastery(getRegion(), id);
	}

	/**
	 * Retrieve realm data.
	 * 
	 * @param region
	 *            Region corresponding to data to retrieve.
	 * @return A single realm
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Realm
	 */
	public Realm getDataRealm(Region region) throws RiotApiException {
		Objects.requireNonNull(region);
		return StaticDataApi.getDataRealm(region, getKey());
	}

	/**
	 * Retrieve realm data.
	 * 
	 * @return A single realm
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Realm
	 */
	public Realm getDataRealm() throws RiotApiException {
		return getDataRealm(getRegion());
	}

	/**
	 * Retrieves rune list.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @param runeListData
	 *            Tags to return additional data. Only {@code type}, {@code version}, {@code data}, {@code id}, {@code name}, {@code rune},
	 *            and {@code description} are returned by default if this parameter isn't specified. To return all additional data, use
	 *            {@code RuneListData.ALL}.
	 * @return A list with runes
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see RuneList
	 */
	public RuneList getDataRuneList(Region region, String locale, String version, RuneListData... runeListData) throws RiotApiException {
		Objects.requireNonNull(region);
		return StaticDataApi.getDataRuneList(region, getKey(), locale, version, runeListData);
	}

	/**
	 * Retrieves rune list.
	 * 
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @param runeListData
	 *            Tags to return additional data. Only {@code type}, {@code version}, {@code data}, {@code id}, {@code name}, {@code rune},
	 *            and {@code description} are returned by default if this parameter isn't specified. To return all additional data, use
	 *            {@code RuneListData.ALL}.
	 * @return A list with runes
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see RuneList
	 */
	public RuneList getDataRuneList(String locale, String version, RuneListData... runeListData) throws RiotApiException {
		return getDataRuneList(getRegion(), locale, version, runeListData);
	}

	/**
	 * Retrieves rune list.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return A list with runes
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see RuneList
	 */
	public RuneList getDataRuneList(Region region) throws RiotApiException {
		Objects.requireNonNull(region);
		return getDataRuneList(region, null, null, (RuneListData) null);
	}

	/**
	 * Retrieves rune list.
	 * 
	 * @return A list with runes
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see RuneList
	 */
	public RuneList getDataRuneList() throws RiotApiException {
		return getDataRuneList(getRegion());
	}

	/**
	 * Retrieves rune by its unique {@code id}.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param id
	 *            Rune ID
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @param runeData
	 *            Tags to return additional data. Only {@code id}, {@code name}, {@code rune}, and {@code description} are returned by
	 *            default if this parameter isn't specified. To return all additional data, use {@code RuneData.ALL}.
	 * @return A single rune
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Rune
	 */
	public Rune getDataRune(Region region, int id, String locale, String version, RuneData... runeData) throws RiotApiException {
		Objects.requireNonNull(region);
		return StaticDataApi.getDataRune(region, getKey(), id, locale, version, runeData);
	}

	/**
	 * Retrieves rune by its unique {@code id}.
	 * 
	 * @param id
	 *            Rune ID
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @param runeData
	 *            Tags to return additional data. Only {@code id}, {@code name}, {@code rune}, and {@code description} are returned by
	 *            default if this parameter isn't specified. To return all additional data, use {@code RuneData.ALL}.
	 * @return A single rune
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Rune
	 */
	public Rune getDataRune(int id, String locale, String version, RuneData... runeData) throws RiotApiException {
		return getDataRune(getRegion(), id, locale, version, runeData);
	}

	/**
	 * Retrieves rune by its unique {@code id}.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param id
	 *            Rune ID
	 * @return A single rune
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Rune
	 */
	public Rune getDataRune(Region region, int id) throws RiotApiException {
		Objects.requireNonNull(region);
		return getDataRune(region, id, null, null, (RuneData) null);
	}

	/**
	 * Retrieves rune by its unique {@code id}.
	 * 
	 * @param id
	 *            Rune ID
	 * @return A single rune
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Rune
	 */
	public Rune getDataRune(int id) throws RiotApiException {
		return getDataRune(getRegion(), id);
	}

	/**
	 * Retrieves summoner spell list.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @param dataById
	 *            If specified as true, the returned data map will use the spells' IDs as the keys. If specified as false, the returned data
	 *            map will use the spells' keys instead
	 * @param spellData
	 *            Tags to return additional data. Only {@code type}, {@code version}, {@code data}, {@code id}, {@code key}, {@code name},
	 *            {@code description}, and {@code summonerLevel} are returned by default if this parameter isn't specified. To return all
	 *            additional data, use {@code SpellData.ALL}.
	 * @return A list with summoner spells
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see SummonerSpellList
	 */
	public SummonerSpellList getDataSummonerSpellList(Region region, String locale, String version, boolean dataById, SpellData... spellData)
			throws RiotApiException {
		Objects.requireNonNull(region);
		return StaticDataApi.getDataSummonerSpellList(region, getKey(), locale, version, dataById, spellData);
	}

	/**
	 * Retrieves summoner spell list.
	 * 
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @param dataById
	 *            If specified as true, the returned data map will use the spells' IDs as the keys. If specified as false, the returned data
	 *            map will use the spells' keys instead
	 * @param spellData
	 *            Tags to return additional data. Only {@code type}, {@code version}, {@code data}, {@code id}, {@code key}, {@code name},
	 *            {@code description}, and {@code summonerLevel} are returned by default if this parameter isn't specified. To return all
	 *            additional data, use {@code SpellData.ALL}.
	 * @return A list with summoner spells
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see SummonerSpellList
	 */
	public SummonerSpellList getDataSummonerSpellList(String locale, String version, boolean dataById, SpellData... spellData) throws RiotApiException {
		return getDataSummonerSpellList(getRegion(), locale, version, dataById, spellData);
	}

	/**
	 * Retrieves summoner spell list.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return A list with summoner spells
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see SummonerSpellList
	 */
	public SummonerSpellList getDataSummonerSpellList(Region region) throws RiotApiException {
		Objects.requireNonNull(region);
		return getDataSummonerSpellList(region, null, null, false, (SpellData) null);
	}

	/**
	 * Retrieves summoner spell list.
	 * 
	 * @return A list with summoner spells
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see SummonerSpellList
	 */
	public SummonerSpellList getDataSummonerSpellList() throws RiotApiException {
		return getDataSummonerSpellList(getRegion());
	}

	/**
	 * Retrieves summoner spell by its unique {@code id}.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param id
	 *            Summoner spell ID
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @param spellData
	 *            Tags to return additional data. Only {@code id}, {@code key}, {@code name}, {@code description}, and {@code summonerLevel}
	 *            are returned by default if this parameter isn't specified. To return all additional data, use {@code SpellData.ALL}.
	 * @return A single summoner spell
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see SummonerSpell
	 */
	public SummonerSpell getDataSummonerSpell(Region region, int id, String locale, String version, SpellData... spellData) throws RiotApiException {
		Objects.requireNonNull(region);
		return StaticDataApi.getDataSummonerSpell(region, getKey(), id, locale, version, spellData);
	}

	/**
	 * Retrieves summoner spell by its unique {@code id}.
	 * 
	 * @param id
	 *            Summoner spell ID
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @param spellData
	 *            Tags to return additional data. Only {@code id}, {@code key}, {@code name}, {@code description}, and {@code summonerLevel}
	 *            are returned by default if this parameter isn't specified. To return all additional data, use {@code SpellData.ALL}.
	 * @return A single summoner spell
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see SummonerSpell
	 */
	public SummonerSpell getDataSummonerSpell(int id, String locale, String version, SpellData... spellData) throws RiotApiException {
		return getDataSummonerSpell(getRegion(), id, locale, version, spellData);
	}

	/**
	 * Retrieves summoner spell by its unique {@code id}.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @param id
	 *            Summoner spell ID
	 * @return A single summoner spell
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see SummonerSpell
	 */
	public SummonerSpell getDataSummonerSpell(Region region, int id) throws RiotApiException {
		Objects.requireNonNull(region);
		return getDataSummonerSpell(region, id, null, null, (SpellData) null);
	}

	/**
	 * Retrieves summoner spell by its unique {@code id}.
	 * 
	 * @param id
	 *            Summoner spell ID
	 * @return A single summoner spell
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see SummonerSpell
	 */
	public SummonerSpell getDataSummonerSpell(int id) throws RiotApiException {
		return getDataSummonerSpell(getRegion(), id);
	}

	/**
	 * Retrieve version data.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return A list with versions
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public List<String> getDataVersions(Region region) throws RiotApiException {
		return StaticDataApi.getDataVersions(region, getKey());
	}

	/**
	 * Retrieve version data.
	 * 
	 * @return A list with versions
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public List<String> getDataVersions() throws RiotApiException {
		return getDataVersions(getRegion());
	}

	/**
	 * Get shard list.
	 * 
	 * @return Status for a list of shards
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see Shard
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
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see ShardStatus
	 */
	public ShardStatus getShardStatus(Region region) throws RiotApiException {
		Objects.requireNonNull(region);
		return StatusApi.getShardStatus(region);
	}

	/**
	 * Get shard status. Returns the data available on the status.leagueoflegends.com website for the given region.
	 * 
	 * @return Status for a single shard
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see ShardStatus
	 */
	public ShardStatus getShardStatus() throws RiotApiException {
		return getShardStatus(getRegion());
	}

	/**
	 * Returns the tournament code DTO associated with a {@code tournamentCode} string.
	 * 
	 * @param tournamentCode
	 *            Tournament code corresponding to data to retrieve.
	 * @return Data associated with a tournament code
	 * @throws NullPointerException
	 *             If {@code tournamentCode} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see TournamentCode
	 */
	public TournamentCode getTournamentCode(String tournamentCode) throws RiotApiException {
		Objects.requireNonNull(tournamentCode);
		return TournamentApi.getTournamentCode(getTournamentKey(), tournamentCode);
	}

	/**
	 * Gets a list of lobby events by {@code tournamentCode}
	 * 
	 * @param tournamentCode
	 *            Tournament code used to enter the lobby.
	 * @return Lobby event data
	 * @throws NullPointerException
	 *             If {@code tournamentCode} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see LobbyEventList
	 */
	public LobbyEventList getLobbyEventsByTournament(String tournamentCode) throws RiotApiException {
		Objects.requireNonNull(tournamentCode);
		return TournamentApi.getLobbyEventsByTournament(getTournamentKey(), tournamentCode);
	}

	/**
	 * Retrieve match by {@code matchId} and {@code tournamentCode}.
	 *
	 * @param region
	 *            The region of the match.
	 * @param matchId
	 *            The ID of the match.
	 * @param tournamentCode
	 *            The code of the tournament.
	 * @param includeTimeline
	 *            Flag indicating whether or not to include match timeline data
	 * @return A map with match details
	 * @throws NullPointerException
	 *             If {@code region} or {@code tournamentCode} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see MatchDetail
	 */
	public MatchDetail getMatchForTournament(Region region, long matchId, String tournamentCode, boolean includeTimeline) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(tournamentCode);
		return MatchApi.getMatchForTournament(region, getTournamentKey(), matchId, tournamentCode, includeTimeline);
	}

	/**
	 * Retrieve match by {@code matchId} and {@code tournamentCode}.
	 *
	 * @param matchId
	 *            The ID of the match.
	 * @param tournamentCode
	 *            The code of the tournament.
	 * @param includeTimeline
	 *            Flag indicating whether or not to include match timeline data
	 * @return A map with match details
	 * @throws NullPointerException
	 *             If {@code tournamentCode} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see MatchDetail
	 */
	public MatchDetail getMatchForTournament(long matchId, String tournamentCode, boolean includeTimeline) throws RiotApiException {
		Objects.requireNonNull(tournamentCode);
		return getMatchForTournament(getRegion(), matchId, tournamentCode, includeTimeline);
	}

	/**
	 * Retrieve match by {@code matchId} and {@code tournamentCode}.
	 *
	 * @param region
	 *            The region of the match.
	 * @param matchId
	 *            The ID of the match.
	 * @param tournamentCode
	 *            The code of the tournament.
	 * @return A map with match details
	 * @throws NullPointerException
	 *             If {@code region} or {@code tournamentCode} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see MatchDetail
	 */
	public MatchDetail getMatchForTournament(Region region, long matchId, String tournamentCode) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(tournamentCode);
		return getMatchForTournament(region, matchId, tournamentCode, false);
	}

	/**
	 * Retrieve match by {@code matchId} and {@code tournamentCode}.
	 *
	 * @param matchId
	 *            The ID of the match.
	 * @param tournamentCode
	 *            The code of the tournament.
	 * @return A map with match details
	 * @throws NullPointerException
	 *             If {@code tournamentCode} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see MatchDetail
	 */
	public MatchDetail getMatchForTournament(long matchId, String tournamentCode) throws RiotApiException {
		Objects.requireNonNull(tournamentCode);
		return getMatchForTournament(getRegion(), matchId, tournamentCode);
	}

	/**
	 * Retrieve match IDs by {@code tournamentCode}.
	 *
	 * @param region
	 *            The region of the matches/tournament.
	 * @param tournamentCode
	 *            The code of the tournament.
	 * @return A list of match IDs
	 * @throws NullPointerException
	 *             If {@code region} or {@code tournamentCode} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public List<Long> getMatchesByTournament(Region region, String tournamentCode) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(tournamentCode);
		return MatchApi.getMatchesByTournament(region, getTournamentKey(), tournamentCode);
	}

	/**
	 * Retrieve match IDs by {@code tournamentCode}.
	 *
	 * @param tournamentCode
	 *            The code of the tournament.
	 * @return A list of match IDs
	 * @throws NullPointerException
	 *             If {@code tournamentCode} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public List<Long> getMatchesByTournament(String tournamentCode) throws RiotApiException {
		Objects.requireNonNull(tournamentCode);
		return getMatchesByTournament(getRegion(), tournamentCode);
	}

	/**
	 * Creates a tournament provider and returns its ID.
	 *
	 * @param region
	 *            The region in which the provider will be running tournaments.
	 * @param callbackUrl
	 *            The provider's callback URL to which tournament game results in this region should be posted. (http URLs must use port 80,
	 *            https URLs must use port 443).
	 * @return A provider ID
	 * @throws NullPointerException
	 *             If {@code region} or {@code callbackUrl} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public int createProvider(Region region, String callbackUrl) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(callbackUrl);
		return TournamentApi.createProvider(getTournamentKey(), region, callbackUrl);
	}

	/**
	 * Creates a tournament provider and returns its ID.
	 *
	 * @param callbackUrl
	 *            The provider's callback URL to which tournament game results in this region should be posted. (http URLs must use port 80,
	 *            https URLs must use port 443).
	 * @return A provider ID
	 * @throws NullPointerException
	 *             If {@code callbackUrl} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public int createProvider(String callbackUrl) throws RiotApiException {
		Objects.requireNonNull(callbackUrl);
		return createProvider(getRegion(), callbackUrl);
	}

	/**
	 * Creates a tournament and returns its ID.
	 *
	 * @param tournamentName
	 *            The optional name of the tournament.
	 * @param providerId
	 *            The provider ID to specify the regional registered provider data to associate this tournament.
	 * @return A tournament ID
	 * @throws NullPointerException
	 *             If {@code tournamentName} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public int createTournament(String tournamentName, int providerId) throws RiotApiException {
		Objects.requireNonNull(tournamentName);
		return TournamentApi.createTournament(getTournamentKey(), tournamentName, providerId);
	}

	/**
	 * Creates a tournament and returns its ID.
	 *
	 * @param providerId
	 *            The provider ID to specify the regional registered provider data to associate this tournament.
	 * @return A tournament Id
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public int createTournament(int providerId) throws RiotApiException {
		return createTournament(null, providerId);
	}

	/**
	 * Create tournament codes for the given tournament.
	 *
	 * @param tournamentId
	 *            The tournament ID
	 * @param count
	 *            The number of codes to create (max 1000)
	 * @param teamSize
	 *            The team size of the game. Valid values are 1-5.
	 * @param mapType
	 *            The map type of the game.
	 * @param pickType
	 *            The pick type of the game.
	 * @param spectatorType
	 *            The spectator type of the game.
	 * @param metaData
	 *            Optional string that may contain any data in any format, if specified at all. Used to denote any custom information about
	 *            the game.
	 * @param allowedSummonerIds
	 *            Optional list of participants in order to validate the players eligible to join the lobby.
	 * @return A list of tournament codes
	 * @throws NullPointerException
	 *             If {@code mapType} or {@code pickType} or {@code spectatorType} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public List<String> createTournamentCodes(int tournamentId, int count, int teamSize, TournamentMap mapType, PickType pickType, SpectatorType spectatorType,
			String metaData, long... allowedSummonerIds) throws RiotApiException {
		Objects.requireNonNull(mapType);
		Objects.requireNonNull(pickType);
		Objects.requireNonNull(spectatorType);
		return TournamentApi.createTournamentCodes(getTournamentKey(), tournamentId, count, teamSize, mapType, pickType, spectatorType, metaData,
				allowedSummonerIds);
	}

	/**
	 * Create tournament codes for the given tournament.
	 *
	 * @param tournamentId
	 *            The tournament ID
	 * @param count
	 *            The number of codes to create (max 1000)
	 * @param teamSize
	 *            The team size of the game. Valid values are 1-5.
	 * @param mapType
	 *            The map type of the game.
	 * @param pickType
	 *            The pick type of the game.
	 * @param spectatorType
	 *            The spectator type of the game.
	 * @param allowedSummonerIds
	 *            Optional list of participants in order to validate the players eligible to join the lobby.
	 * @return A list of tournament codes
	 * @throws NullPointerException
	 *             If {@code mapType} or {@code pickType} or {@code spectatorType} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public List<String> createTournamentCodes(int tournamentId, int count, int teamSize, TournamentMap mapType, PickType pickType, SpectatorType spectatorType,
			long... allowedSummonerIds) throws RiotApiException {
		Objects.requireNonNull(mapType);
		Objects.requireNonNull(pickType);
		Objects.requireNonNull(spectatorType);
		return createTournamentCodes(tournamentId, count, teamSize, mapType, pickType, spectatorType, null, allowedSummonerIds);
	}

	/**
	 * Create a tournament code for the given tournament.
	 *
	 * @param tournamentId
	 *            The tournament ID
	 * @param teamSize
	 *            The team size of the game. Valid values are 1-5.
	 * @param mapType
	 *            The map type of the game.
	 * @param pickType
	 *            The pick type of the game.
	 * @param spectatorType
	 *            The spectator type of the game.
	 * @param metaData
	 *            Optional string that may contain any data in any format, if specified at all. Used to denote any custom information about
	 *            the game.
	 * @param allowedSummonerIds
	 *            Optional list of participants in order to validate the players eligible to join the lobby.
	 * @return A tournament code
	 * @throws NullPointerException
	 *             If {@code mapType} or {@code pickType} or {@code spectatorType} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public String createTournamentCode(int tournamentId, int teamSize, TournamentMap mapType, PickType pickType, SpectatorType spectatorType, String metaData,
			long... allowedSummonerIds) throws RiotApiException {
		Objects.requireNonNull(mapType);
		Objects.requireNonNull(pickType);
		Objects.requireNonNull(spectatorType);
		List<String> tournamentCodeList = createTournamentCodes(tournamentId, 1, teamSize, mapType, pickType, spectatorType, metaData, allowedSummonerIds);
		if (tournamentCodeList.size() < 1) {
			throw new RiotApiException(RiotApiException.DATA_NOT_FOUND);
		}
		return tournamentCodeList.get(0);
	}

	/**
	 * Create a tournament code for the given tournament.
	 *
	 * @param tournamentId
	 *            The tournament ID
	 * @param teamSize
	 *            The team size of the game. Valid values are 1-5.
	 * @param mapType
	 *            The map type of the game.
	 * @param pickType
	 *            The pick type of the game.
	 * @param spectatorType
	 *            The spectator type of the game.
	 * @param allowedSummonerIds
	 *            Optional list of participants in order to validate the players eligible to join the lobby.
	 * @return A tournament code
	 * @throws NullPointerException
	 *             If {@code mapType} or {@code pickType} or {@code spectatorType} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public String createTournamentCode(int tournamentId, int teamSize, TournamentMap mapType, PickType pickType, SpectatorType spectatorType,
			long... allowedSummonerIds) throws RiotApiException {
		Objects.requireNonNull(mapType);
		Objects.requireNonNull(pickType);
		Objects.requireNonNull(spectatorType);
		return createTournamentCode(tournamentId, teamSize, mapType, pickType, spectatorType, null, allowedSummonerIds);
	}

	/**
	 * Update the pick type, map, spectator type, or allowed summoners for a {@code tournamentCode}
	 *
	 * @param tournamentCode
	 *            The tournament code to update.
	 * @param mapType
	 *            The map type of the game.
	 * @param pickType
	 *            The pick type of the game.
	 * @param spectatorType
	 *            The spectator type of the game.
	 * @param allowedSummonerIds
	 *            Optional list of participants in order to validate the players eligible to join the lobby.
	 * @throws NullPointerException
	 *             If {@code tournamentCode} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public void updateTournamentCode(String tournamentCode, TournamentMap mapType, PickType pickType, SpectatorType spectatorType, long... allowedSummonerIds)
			throws RiotApiException {
		Objects.requireNonNull(tournamentCode);
		TournamentApi.updateTournamentCode(getTournamentKey(), tournamentCode, mapType, pickType, spectatorType, allowedSummonerIds);
	}

	/**
	 * Update the pick type, map, spectator type, or allowed summoners for a {@code tournamentCode}
	 *
	 * @param tournamentCode
	 *            The tournament code to update.
	 * @param pickType
	 *            The pick type of the game.
	 * @param spectatorType
	 *            The spectator type of the game.
	 * @param allowedSummonerIds
	 *            Optional list of participants in order to validate the players eligible to join the lobby.
	 * @throws NullPointerException
	 *             If {@code tournamentCode} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public void updateTournamentCode(String tournamentCode, PickType pickType, SpectatorType spectatorType, long... allowedSummonerIds)
			throws RiotApiException {
		Objects.requireNonNull(tournamentCode);
		updateTournamentCode(tournamentCode, null, pickType, spectatorType, allowedSummonerIds);
	}

	/**
	 * Update the pick type, map, spectator type, or allowed summoners for a {@code tournamentCode}
	 *
	 * @param tournamentCode
	 *            The tournament code to update.
	 * @param mapType
	 *            The map type of the game.
	 * @param spectatorType
	 *            The spectator type of the game.
	 * @param allowedSummonerIds
	 *            Optional list of participants in order to validate the players eligible to join the lobby.
	 * @throws NullPointerException
	 *             If {@code tournamentCode} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public void updateTournamentCode(String tournamentCode, TournamentMap mapType, SpectatorType spectatorType, long... allowedSummonerIds)
			throws RiotApiException {
		Objects.requireNonNull(tournamentCode);
		updateTournamentCode(tournamentCode, mapType, null, spectatorType, allowedSummonerIds);
	}

	/**
	 * Update the pick type, map, spectator type, or allowed summoners for a {@code tournamentCode}
	 *
	 * @param tournamentCode
	 *            The tournament code to update.
	 * @param mapType
	 *            The map type of the game.
	 * @param pickType
	 *            The pick type of the game.
	 * @param allowedSummonerIds
	 *            Optional list of participants in order to validate the players eligible to join the lobby.
	 * @throws NullPointerException
	 *             If {@code tournamentCode} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public void updateTournamentCode(String tournamentCode, TournamentMap mapType, PickType pickType, long... allowedSummonerIds) throws RiotApiException {
		Objects.requireNonNull(tournamentCode);
		updateTournamentCode(tournamentCode, mapType, pickType, null, allowedSummonerIds);
	}

	/**
	 * Update the pick type, map, spectator type, or allowed summoners for a {@code tournamentCode}
	 *
	 * @param tournamentCode
	 *            The tournament code to update.
	 * @param mapType
	 *            The map type of the game.
	 * @param allowedSummonerIds
	 *            Optional list of participants in order to validate the players eligible to join the lobby.
	 * @throws NullPointerException
	 *             If {@code tournamentCode} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public void updateTournamentCode(String tournamentCode, TournamentMap mapType, long... allowedSummonerIds) throws RiotApiException {
		Objects.requireNonNull(tournamentCode);
		updateTournamentCode(tournamentCode, mapType, null, null, allowedSummonerIds);
	}

	/**
	 * Update the pick type, map, spectator type, or allowed summoners for a {@code tournamentCode}
	 *
	 * @param tournamentCode
	 *            The tournament code to update.
	 * @param pickType
	 *            The pick type of the game.
	 * @param allowedSummonerIds
	 *            Optional list of participants in order to validate the players eligible to join the lobby.
	 * @throws NullPointerException
	 *             If {@code tournamentCode} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public void updateTournamentCode(String tournamentCode, PickType pickType, long... allowedSummonerIds) throws RiotApiException {
		Objects.requireNonNull(tournamentCode);
		updateTournamentCode(tournamentCode, null, pickType, null, allowedSummonerIds);
	}

	/**
	 * Update the pick type, map, spectator type, or allowed summoners for a {@code tournamentCode}
	 *
	 * @param tournamentCode
	 *            The tournament code to update.
	 * @param spectatorType
	 *            The spectator type of the game.
	 * @param allowedSummonerIds
	 *            Optional list of participants in order to validate the players eligible to join the lobby.
	 * @throws NullPointerException
	 *             If {@code tournamentCode} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public void updateTournamentCode(String tournamentCode, SpectatorType spectatorType, long... allowedSummonerIds) throws RiotApiException {
		Objects.requireNonNull(tournamentCode);
		updateTournamentCode(tournamentCode, null, null, spectatorType, allowedSummonerIds);
	}
	
	/**
	 * Retrieve champion mastery by {@code summonerId} and {@code championId}.
	 *
	 * @param platformId
	 *            The platform ID for which to fetch data.
	 * @param summonerId
	 *            The ID of the summoner.
	 * @param championId
	 *            The ID of the champion.
	 * @throws NullPointerException
	 *             If {@code platformId} or {@code summonerId} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public ChampionMastery getChampionMastery(PlatformId platformId, String summonerId, long championId) throws RiotApiException {
		Objects.requireNonNull(platformId);
		Objects.requireNonNull(summonerId);
		return ChampionMasteryApi.getChampionMastery(platformId, getKey(), summonerId, championId);
	}
	
	/**
	 * Retrieve champion mastery by {@code summonerId} and {@code championId}.
	 *
	 * @param platformId
	 *            The platform ID for which to fetch data.
	 * @param summonerId
	 *            The ID of the summoner.
	 * @param championId
	 *            The ID of the champion.
	 * @throws NullPointerException
	 *             If {@code platformId} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public ChampionMastery getChampionMastery(PlatformId platformId, long summonerId, long championId) throws RiotApiException {
		return getChampionMastery(platformId, String.valueOf(summonerId), championId);
	}
	
	/**
	 * Retrieve all champion masteries by {@code summonerId}.
	 *
	 * @param platformId
	 *            The platform ID for which to fetch data.
	 * @param summonerId
	 *            The ID of the summoner.
	 * @throws NullPointerException
	 *             If {@code platformId} or {@code summonerId} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public List<ChampionMastery> getChampionMasteries(PlatformId platformId, String summonerId) throws RiotApiException {
		Objects.requireNonNull(platformId);
		Objects.requireNonNull(summonerId);
		return ChampionMasteryApi.getChampionMasteries(platformId, getKey(), summonerId);
	}
	
	/**
	 * Retrieve all champion masteries by {@code summonerId}.
	 *
	 * @param platformId
	 *            The platform ID for which to fetch data.
	 * @param summonerId
	 *            The ID of the summoner.
	 * @throws NullPointerException
	 *             If {@code platformId} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public List<ChampionMastery> getChampionMasteries(PlatformId platformId, long summonerId) throws RiotApiException {
		return getChampionMasteries(platformId, String.valueOf(summonerId));
	}
	
	/**
	 * Retrieve total champion mastery score by {@code summonerId}.
	 *
	 * @param platformId
	 *            The platform ID for which to fetch data.
	 * @param summonerId
	 *            The ID of the summoner.
	 * @throws NullPointerException
	 *             If {@code platformId} or {@code summonerId} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public int getChampionMasteryScore(PlatformId platformId, String summonerId) throws RiotApiException {
		Objects.requireNonNull(platformId);
		Objects.requireNonNull(summonerId);
		return ChampionMasteryApi.getChampionMasteryScore(platformId, getKey(), summonerId);
	}
	
	/**
	 * Retrieve total champion mastery score by {@code summonerId}.
	 *
	 * @param platformId
	 *            The platform ID for which to fetch data.
	 * @param summonerId
	 *            The ID of the summoner.
	 * @throws NullPointerException
	 *             If {@code platformId} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public int getChampionMasteryScore(PlatformId platformId, long summonerId) throws RiotApiException {
		return getChampionMasteryScore(platformId, String.valueOf(summonerId));
	}
	
	/**
	 * Retrieve specified number of top champion masteries by {@code summonerId}.
	 *
	 * @param platformId
	 *            The platform ID for which to fetch data.
	 * @param summonerId
	 *            The ID of the summoner.
	 * @param count
	 *            Number of entries to retrieve.
	 * @throws NullPointerException
	 *             If {@code platformId} or {@code summonerId} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public List<ChampionMastery> getTopChampionMasteries(PlatformId platformId, String summonerId, int count) throws RiotApiException {
		Objects.requireNonNull(platformId);
		Objects.requireNonNull(summonerId);
		return ChampionMasteryApi.getTopChampionMasteries(platformId, getKey(), summonerId, count);
	}
	
	/**
	 * Retrieve specified number of top champion masteries by {@code summonerId}.
	 *
	 * @param platformId
	 *            The platform ID for which to fetch data.
	 * @param summonerId
	 *            The ID of the summoner.
	 * @param count
	 *            Number of entries to retrieve.
	 * @throws NullPointerException
	 *             If {@code platformId} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public List<ChampionMastery> getTopChampionMasteries(PlatformId platformId, long summonerId, int count) throws RiotApiException {
		return getTopChampionMasteries(platformId, String.valueOf(summonerId), count);
	}
	
	/**
	 * Retrieve top 3 champion masteries by {@code summonerId}.
	 *
	 * @param platformId
	 *            The platform ID for which to fetch data.
	 * @param summonerId
	 *            The ID of the summoner.
	 * @throws NullPointerException
	 *             If {@code platformId} or {@code summonerId} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public List<ChampionMastery> getTopChampionMasteries(PlatformId platformId, String summonerId) throws RiotApiException {
		return getTopChampionMasteries(platformId, summonerId, -1);
	}
	
	/**
	 * Retrieve top 3 champion masteries by {@code summonerId}.
	 *
	 * @param platformId
	 *            The platform ID for which to fetch data.
	 * @param summonerId
	 *            The ID of the summoner.
	 * @throws NullPointerException
	 *             If {@code platformId} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public List<ChampionMastery> getTopChampionMasteries(PlatformId platformId, long summonerId) throws RiotApiException {
		return getTopChampionMasteries(platformId, String.valueOf(summonerId));
	}
	
	/**
	 * Get the base URL for API requests
	 *
	 * @return The base URL for API requests
	 */
	public String getEndpoint() {
		return region.getEndpoint();
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
	 * Get the currently set tournament API key
	 *
	 * @return The currently set tournament API key
	 */
	public String getTournamentKey() {
		return tournamentKey;
	}

	/**
	 * Get the currently set region
	 *
	 * @return The currently set region
	 * @see Region
	 */
	public Region getRegion() {
		return region;
	}

	/**
	 * Get the currently set season
	 *
	 * @return The currently set season
	 * @see Season
	 */
	public Season getSeason() {
		return season;
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
	 * Set the tournament key
	 *
	 * @param tournamentKey
	 *            The tournament API key to set
	 */
	public void setTournamentKey(String tournamentKey) {
		this.tournamentKey = tournamentKey;
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
	 * Set the season
	 *
	 * @param season
	 *            The season to set
	 */
	public void setSeason(Season season) {
		this.season = season;
	}
}