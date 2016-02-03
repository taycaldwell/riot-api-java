/*
 * Copyright 2016 Taylor Caldwell
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

package net.rithms.riot.api;

import java.util.Objects;

import net.rithms.riot.api.endpoints.champion.dto.Champion;
import net.rithms.riot.api.endpoints.champion.dto.ChampionList;
import net.rithms.riot.api.endpoints.champion.methods.GetChampionById;
import net.rithms.riot.api.endpoints.champion.methods.GetChampions;
import net.rithms.riot.api.endpoints.championmastery.dto.ChampionMastery;
import net.rithms.riot.api.endpoints.championmastery.methods.GetChampionMasteries;
import net.rithms.riot.api.endpoints.championmastery.methods.GetChampionMastery;
import net.rithms.riot.api.endpoints.championmastery.methods.GetChampionMasteryScore;
import net.rithms.riot.api.endpoints.championmastery.methods.GetTopChampionMasteries;
import net.rithms.riot.api.endpoints.current_game.dto.CurrentGameInfo;
import net.rithms.riot.api.endpoints.current_game.methods.GetCurrentGameInfo;
import net.rithms.riot.api.endpoints.featured_game.dto.FeaturedGames;
import net.rithms.riot.api.endpoints.featured_game.methods.GetFeaturedGames;
import net.rithms.riot.api.endpoints.game.dto.RecentGames;
import net.rithms.riot.api.endpoints.game.methods.GetRecentGames;
import net.rithms.riot.api.endpoints.league.dto.League;
import net.rithms.riot.api.endpoints.league.methods.GetChallengerLeague;
import net.rithms.riot.api.endpoints.league.methods.GetLeagueBySummoners;
import net.rithms.riot.api.endpoints.league.methods.GetLeagueByTeams;
import net.rithms.riot.api.endpoints.league.methods.GetLeagueEntryBySummoners;
import net.rithms.riot.api.endpoints.league.methods.GetLeagueEntryByTeams;
import net.rithms.riot.api.endpoints.league.methods.GetMasterLeague;
import net.rithms.riot.api.endpoints.match.dto.MatchDetail;
import net.rithms.riot.api.endpoints.match.methods.GetMatch;
import net.rithms.riot.api.endpoints.match.methods.GetMatchForTournament;
import net.rithms.riot.api.endpoints.match.methods.GetMatchesByTournament;
import net.rithms.riot.api.endpoints.matchlist.dto.MatchList;
import net.rithms.riot.api.endpoints.matchlist.methods.GetMatchList;
import net.rithms.riot.api.endpoints.static_data.constant.ChampData;
import net.rithms.riot.api.endpoints.static_data.constant.ItemData;
import net.rithms.riot.api.endpoints.static_data.constant.ItemListData;
import net.rithms.riot.api.endpoints.static_data.constant.MasteryData;
import net.rithms.riot.api.endpoints.static_data.constant.MasteryListData;
import net.rithms.riot.api.endpoints.static_data.constant.RuneData;
import net.rithms.riot.api.endpoints.static_data.constant.RuneListData;
import net.rithms.riot.api.endpoints.static_data.constant.SpellData;
import net.rithms.riot.api.endpoints.static_data.dto.GameMapList;
import net.rithms.riot.api.endpoints.static_data.dto.Item;
import net.rithms.riot.api.endpoints.static_data.dto.ItemList;
import net.rithms.riot.api.endpoints.static_data.dto.LanguageStrings;
import net.rithms.riot.api.endpoints.static_data.dto.Mastery;
import net.rithms.riot.api.endpoints.static_data.dto.MasteryList;
import net.rithms.riot.api.endpoints.static_data.dto.Realm;
import net.rithms.riot.api.endpoints.static_data.dto.Rune;
import net.rithms.riot.api.endpoints.static_data.dto.RuneList;
import net.rithms.riot.api.endpoints.static_data.dto.SummonerSpell;
import net.rithms.riot.api.endpoints.static_data.dto.SummonerSpellList;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataChampion;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataChampionList;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataGameMapList;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataItem;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataItemList;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataLanguageStrings;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataLanguages;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataMastery;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataMasteryList;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataRealm;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataRune;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataRuneList;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataSummonerSpell;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataSummonerSpellList;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataVersions;
import net.rithms.riot.api.endpoints.stats.dto.PlayerStatsSummaryList;
import net.rithms.riot.api.endpoints.stats.dto.RankedStats;
import net.rithms.riot.api.endpoints.stats.methods.GetPlayerStatsSummary;
import net.rithms.riot.api.endpoints.stats.methods.GetRankedStats;
import net.rithms.riot.api.endpoints.status.dto.Shard;
import net.rithms.riot.api.endpoints.status.dto.ShardStatus;
import net.rithms.riot.api.endpoints.status.methods.GetShardStatus;
import net.rithms.riot.api.endpoints.status.methods.GetShards;
import net.rithms.riot.api.endpoints.summoner.dto.MasteryPages;
import net.rithms.riot.api.endpoints.summoner.dto.RunePages;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;
import net.rithms.riot.api.endpoints.summoner.methods.GetMasteryPages;
import net.rithms.riot.api.endpoints.summoner.methods.GetRunePages;
import net.rithms.riot.api.endpoints.summoner.methods.GetSummonerNames;
import net.rithms.riot.api.endpoints.summoner.methods.GetSummonersById;
import net.rithms.riot.api.endpoints.summoner.methods.GetSummonersByName;
import net.rithms.riot.api.endpoints.team.dto.Team;
import net.rithms.riot.api.endpoints.team.methods.GetTeamsBySummonerIds;
import net.rithms.riot.api.endpoints.team.methods.GetTeamsByTeamIds;
import net.rithms.riot.api.endpoints.tournament.dto.LobbyEventList;
import net.rithms.riot.api.endpoints.tournament.dto.TournamentCode;
import net.rithms.riot.api.endpoints.tournament.methods.CreateProvider;
import net.rithms.riot.api.endpoints.tournament.methods.CreateTournament;
import net.rithms.riot.api.endpoints.tournament.methods.GetLobbyEventsByTournament;
import net.rithms.riot.api.endpoints.tournament.methods.GetTournamentCode;
import net.rithms.riot.api.endpoints.tournament.methods.UpdateTournamentCode;
import net.rithms.riot.api.request.AsyncRequest;
import net.rithms.riot.api.request.RequestListener;
import net.rithms.riot.constant.PickType;
import net.rithms.riot.constant.PlatformId;
import net.rithms.riot.constant.QueueType;
import net.rithms.riot.constant.Region;
import net.rithms.riot.constant.Season;
import net.rithms.riot.constant.SpectatorType;
import net.rithms.riot.constant.TournamentMap;
import net.rithms.util.Convert;

/**
 * This class is used to fire asynchronous requests. You can get an instance of this object by calling {@link RiotApi#getAsyncApi()} on your
 * {@code RiotApi} object.
 * 
 * <p>
 * Due to the nature of asynchronous calls, methods in this class always return an {@link AsyncRequest} instead of the actual return type.
 * To get the actual return value, call {@link AsyncRequest#getDto()}. For further information on handling asynchronous requests, see
 * {@link AsyncRequest}.
 * </p>
 *
 * @see ApiConfig
 * @see AsyncRequest
 * @see RiotApi
 */
public class RiotApiAsync {

	private final ApiConfig config;
	private final EndpointManager endpointManager;

	/**
	 * Constructs a RiotApiAsync object. This cannot be done directly. To get an RiotApiAsync object, call {@link RiotApi#getAsyncApi()} on
	 * your {@link RiotApi} object.
	 *
	 * @param config
	 *            ApiConfig object
	 * @param endpointManager
	 *            EndpointManager object
	 */
	RiotApiAsync(ApiConfig config, EndpointManager endpointManager) {
		this.config = config;
		this.endpointManager = endpointManager;
	}

	/**
	 * Adds a request listener to get informed when asynchronous requests finish.
	 * 
	 * <p>
	 * Please note, that by adding a listener here, you will listen to ALL asynchronous requests made with this RiotApiAsync object. To only
	 * listen to a specific asynchronous request, you can set a listener directly in the {@link AsyncRequest} using
	 * {@link AsyncRequest#addListener(RequestListener)}.
	 * </p>
	 * 
	 * @param listener
	 *            An object that implements {@link RequestListener}
	 * @return {@code true} if the specified listener was not already listening
	 * @see RequestListener
	 */
	public boolean addListener(RequestListener listener) {
		return endpointManager.addListener(listener);
	}

	/**
	 * Waits indefinitely until all currently running and queued requests complete.
	 * <p>
	 * If the thread is interrupted while waiting for the requests to complete, this method will throw an {@code InterruptedException} and
	 * the thread's interrupt flag will be cleared.
	 * </p>
	 * <p>
	 * <i>Please note that this method is blocking and thus negates the advantage of the asynchronous nature of this class. Consider using a
	 * {@link RequestListener} instead.</i>
	 * </p>
	 * 
	 * @throws InterruptedException
	 *             If the method is interrupted by calling {@link Thread#interrupt()}. The interrupt flag will be cleared
	 */
	public void awaitAll() throws InterruptedException {
		endpointManager.awaitAll();
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
	 */
	public AsyncRequest createProvider(Region region, String callbackUrl) {
		Objects.requireNonNull(region);
		Objects.requireNonNull(callbackUrl);
		ApiMethod method = new CreateProvider(getConfig(), region, callbackUrl);
		return endpointManager.callMethodAsynchronously(method);
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
	 */
	public AsyncRequest createTournament(String tournamentName, int providerId) {
		Objects.requireNonNull(tournamentName);
		ApiMethod method = new CreateTournament(getConfig(), tournamentName, providerId);
		return endpointManager.callMethodAsynchronously(method);
	}

	/**
	 * Creates a tournament and returns its ID.
	 *
	 * @param providerId
	 *            The provider ID to specify the regional registered provider data to associate this tournament.
	 * @return A tournament Id
	 */
	public AsyncRequest createTournament(int providerId) {
		return createTournament(null, providerId);
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
	 * @see League
	 */
	public AsyncRequest getChallengerLeague(Region region, QueueType queueType) {
		Objects.requireNonNull(region);
		Objects.requireNonNull(queueType);
		ApiMethod method = new GetChallengerLeague(getConfig(), region, queueType);
		return endpointManager.callMethodAsynchronously(method);
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
	 * @see Champion
	 */
	public AsyncRequest getChampionById(Region region, int id) {
		Objects.requireNonNull(region);
		ApiMethod method = new GetChampionById(getConfig(), region, id);
		return endpointManager.callMethodAsynchronously(method);
	}

	/**
	 * Get all champion mastery entries sorted by number of champion points descending
	 *
	 * @param platformId
	 *            Region where to retrieve the data.
	 * @param summonerId
	 *            Summoner ID associated with the player
	 * @return A list of champion masteries for a given summoner.
	 * @throws NullPointerException
	 *             If {@code platformId} or {@code summonerId} is {@code null}
	 * @see ChampionMastery
	 */
	public AsyncRequest getChampionMasteries(PlatformId platformId, long summonerId) {
		Objects.requireNonNull(platformId);
		ApiMethod method = new GetChampionMasteries(getConfig(), platformId, summonerId);
		return endpointManager.callMethodAsynchronously(method);
	}

	/**
	 * Get a champion mastery by {@code summonerId} and {@code championId}.
	 *
	 * @param platformId
	 *            Region where to retrieve the data.
	 * @param summonerId
	 *            Summoner ID associated with the player
	 * @param championId
	 *            Champion ID to retrieve Champion Mastery for
	 * @return Champion mastery for a given summoner and championId, or {@code null} if given player has no mastery for given champion.
	 * @throws NullPointerException
	 *             If {@code platformId} or {@code summonerId} is {@code null}
	 * @see ChampionMastery
	 */
	public AsyncRequest getChampionMastery(PlatformId platformId, long summonerId, long championId) {
		Objects.requireNonNull(platformId);
		ApiMethod method = new GetChampionMastery(getConfig(), platformId, summonerId, championId);
		return endpointManager.callMethodAsynchronously(method);
	}

	/**
	 * Get a player's total champion mastery score, which is sum of individual champion mastery levels
	 *
	 * @param platformId
	 *            Region where to retrieve the data.
	 * @param summonerId
	 *            Summoner ID associated with the player
	 * @return The total champion mastery score of a given summoner.
	 * @throws NullPointerException
	 *             If {@code platformId} or {@code summonerId} is {@code null}
	 */
	public AsyncRequest getChampionMasteryScore(PlatformId platformId, long summonerId) {
		Objects.requireNonNull(platformId);
		ApiMethod method = new GetChampionMasteryScore(getConfig(), platformId, summonerId);
		return endpointManager.callMethodAsynchronously(method);
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
	 * @see ChampionList
	 */
	public AsyncRequest getChampions(Region region, boolean freeToPlay) {
		Objects.requireNonNull(region);
		ApiMethod method = new GetChampions(getConfig(), region, freeToPlay);
		return endpointManager.callMethodAsynchronously(method);
	}

	/**
	 * Retrieve all champions.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @return A list of champions for the given region
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @see ChampionList
	 */
	public AsyncRequest getChampions(Region region) {
		Objects.requireNonNull(region);
		return getChampions(region, false);
	}

	/**
	 * Get the configuration
	 * 
	 * @return {@link ApiConfig} object
	 * @see ApiConfig
	 */
	protected ApiConfig getConfig() {
		return config;
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
	 * @see CurrentGameInfo
	 */
	public AsyncRequest getCurrentGameInfo(PlatformId platformId, long summonerId) {
		Objects.requireNonNull(platformId);
		Objects.requireNonNull(summonerId);
		ApiMethod method = new GetCurrentGameInfo(getConfig(), platformId, summonerId);
		return endpointManager.callMethodAsynchronously(method);
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
	 * @see net.rithms.riot.api.endpoints.static_data.dto.Champion
	 */
	public AsyncRequest getDataChampion(Region region, int id, String locale, String version, ChampData... champData) {
		Objects.requireNonNull(region);
		ApiMethod method = new GetDataChampion(getConfig(), region, id, locale, version, champData);
		return endpointManager.callMethodAsynchronously(method);
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
	 * @see net.rithms.riot.api.endpoints.static_data.dto.Champion
	 */
	public AsyncRequest getDataChampion(Region region, int id) {
		Objects.requireNonNull(region);
		return getDataChampion(region, id, null, null, (ChampData) null);
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
	 * @see net.rithms.riot.api.endpoints.static_data.dto.ChampionList
	 */
	public AsyncRequest getDataChampionList(Region region, String locale, String version, boolean dataById, ChampData... champData) {
		Objects.requireNonNull(region);
		ApiMethod method = new GetDataChampionList(getConfig(), region, locale, version, dataById, champData);
		return endpointManager.callMethodAsynchronously(method);
	}

	/**
	 * Retrieves champion list.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return A list with champions
	 * @see net.rithms.riot.api.endpoints.static_data.dto.ChampionList
	 */
	public AsyncRequest getDataChampionList(Region region) {
		Objects.requireNonNull(region);
		return getDataChampionList(region, null, null, false, (ChampData) null);
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
	 * @see GameMapList
	 */
	public AsyncRequest getDataGameMapList(Region region, String locale, String version) {
		Objects.requireNonNull(region);
		ApiMethod method = new GetDataGameMapList(getConfig(), region, locale, version);
		return endpointManager.callMethodAsynchronously(method);
	}

	/**
	 * Retrieves map data.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return A list of game maps
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @see GameMapList
	 */
	public AsyncRequest getDataGameMapList(Region region) {
		Objects.requireNonNull(region);
		return getDataGameMapList(region, null, null);
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
	 * @see Item
	 */
	public AsyncRequest getDataItem(Region region, int id, String locale, String version, ItemData... itemData) {
		Objects.requireNonNull(region);
		ApiMethod method = new GetDataItem(getConfig(), region, id, locale, version, itemData);
		return endpointManager.callMethodAsynchronously(method);
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
	 * @see Item
	 */
	public AsyncRequest getDataItem(Region region, int id) {
		Objects.requireNonNull(region);
		return getDataItem(region, id, null, null, (ItemData) null);
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
	 * @see ItemList
	 */
	public AsyncRequest getDataItemList(Region region, String locale, String version, ItemListData... itemListData) {
		Objects.requireNonNull(region);
		ApiMethod method = new GetDataItemList(getConfig(), region, locale, version, itemListData);
		return endpointManager.callMethodAsynchronously(method);
	}

	/**
	 * Retrieves item list.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return A list of items
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @see ItemList
	 */
	public AsyncRequest getDataItemList(Region region) {
		Objects.requireNonNull(region);
		return getDataItemList(region, null, null, (ItemListData) null);
	}

	/**
	 * Retrieve supported languages data.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return A list with languages
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 */
	public AsyncRequest getDataLanguages(Region region) {
		Objects.requireNonNull(region);
		ApiMethod method = new GetDataLanguages(getConfig(), region);
		return endpointManager.callMethodAsynchronously(method);
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
	 * @see LanguageStrings
	 */
	public AsyncRequest getDataLanguageStrings(Region region, String locale, String version) {
		Objects.requireNonNull(region);
		ApiMethod method = new GetDataLanguageStrings(getConfig(), region, locale, version);
		return endpointManager.callMethodAsynchronously(method);
	}

	/**
	 * Retrieve language strings data.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return Language strings
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @see LanguageStrings
	 */
	public AsyncRequest getDataLanguageStrings(Region region) {
		Objects.requireNonNull(region);
		return getDataLanguageStrings(region, null, null);
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
	 * @see Mastery
	 */
	public AsyncRequest getDataMastery(Region region, int id, String locale, String version, MasteryData... masteryData) {
		Objects.requireNonNull(region);
		ApiMethod method = new GetDataMastery(getConfig(), region, id, locale, version, masteryData);
		return endpointManager.callMethodAsynchronously(method);
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
	 * @see Mastery
	 */
	public AsyncRequest getDataMastery(Region region, int id) {
		Objects.requireNonNull(region);
		return getDataMastery(region, id, null, null, (MasteryData) null);
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
	 * @see MasteryList
	 */
	public AsyncRequest getDataMasteryList(Region region, String locale, String version, MasteryListData... masteryListData) {
		Objects.requireNonNull(region);
		ApiMethod method = new GetDataMasteryList(getConfig(), region, locale, version, masteryListData);
		return endpointManager.callMethodAsynchronously(method);
	}

	/**
	 * Retrieves mastery list.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return A list with masteries
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @see MasteryList
	 */
	public AsyncRequest getDataMasteryList(Region region) {
		Objects.requireNonNull(region);
		return getDataMasteryList(region, null, null, (MasteryListData) null);
	}

	/**
	 * Retrieve realm data.
	 * 
	 * @param region
	 *            Region corresponding to data to retrieve.
	 * @return A single realm
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @see Realm
	 */
	public AsyncRequest getDataRealm(Region region) {
		Objects.requireNonNull(region);
		ApiMethod method = new GetDataRealm(getConfig(), region);
		return endpointManager.callMethodAsynchronously(method);
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
	 * @see Rune
	 */
	public AsyncRequest getDataRune(Region region, int id, String locale, String version, RuneData... runeData) {
		Objects.requireNonNull(region);
		ApiMethod method = new GetDataRune(getConfig(), region, id, locale, version, runeData);
		return endpointManager.callMethodAsynchronously(method);
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
	 * @see Rune
	 */
	public AsyncRequest getDataRune(Region region, int id) {
		Objects.requireNonNull(region);
		return getDataRune(region, id, null, null, (RuneData) null);
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
	 * @see RuneList
	 */
	public AsyncRequest getDataRuneList(Region region, String locale, String version, RuneListData... runeListData) {
		Objects.requireNonNull(region);
		ApiMethod method = new GetDataRuneList(getConfig(), region, locale, version, runeListData);
		return endpointManager.callMethodAsynchronously(method);
	}

	/**
	 * Retrieves rune list.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return A list with runes
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @see RuneList
	 */
	public AsyncRequest getDataRuneList(Region region) {
		Objects.requireNonNull(region);
		return getDataRuneList(region, null, null, (RuneListData) null);
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
	 * @see SummonerSpell
	 */
	public AsyncRequest getDataSummonerSpell(Region region, int id, String locale, String version, SpellData... spellData) {
		Objects.requireNonNull(region);
		ApiMethod method = new GetDataSummonerSpell(getConfig(), region, id, locale, version, spellData);
		return endpointManager.callMethodAsynchronously(method);
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
	 * @see SummonerSpell
	 */
	public AsyncRequest getDataSummonerSpell(Region region, int id) {
		Objects.requireNonNull(region);
		return getDataSummonerSpell(region, id, null, null, (SpellData) null);
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
	 * @see SummonerSpellList
	 */
	public AsyncRequest getDataSummonerSpellList(Region region, String locale, String version, boolean dataById, SpellData... spellData) {
		Objects.requireNonNull(region);
		ApiMethod method = new GetDataSummonerSpellList(getConfig(), region, locale, version, dataById, spellData);
		return endpointManager.callMethodAsynchronously(method);
	}

	/**
	 * Retrieves summoner spell list.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return A list with summoner spells
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @see SummonerSpellList
	 */
	public AsyncRequest getDataSummonerSpellList(Region region) {
		Objects.requireNonNull(region);
		return getDataSummonerSpellList(region, null, null, false, (SpellData) null);
	}

	/**
	 * Retrieve version data.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return A list with versions
	 */
	public AsyncRequest getDataVersions(Region region) {
		Objects.requireNonNull(region);
		ApiMethod method = new GetDataVersions(getConfig(), region);
		return endpointManager.callMethodAsynchronously(method);
	}

	/**
	 * Get list of featured games.
	 * 
	 * @param region
	 *            Region from which to retrieve data.
	 * @return Featured games
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @see FeaturedGames
	 */
	public AsyncRequest getFeaturedGames(Region region) {
		Objects.requireNonNull(region);
		ApiMethod method = new GetFeaturedGames(getConfig(), region);
		return endpointManager.callMethodAsynchronously(method);
	}

	/**
	 * Retrieve all champions that are free-to-play.
	 *
	 * @param region
	 *            Region where to retrieve the data.
	 * @return A list of all the free to play champions for the given region
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @see ChampionList
	 */
	public AsyncRequest getFreeToPlayChampions(Region region) {
		Objects.requireNonNull(region);
		return getChampions(region, true);
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
	 * @see League
	 */
	public AsyncRequest getLeagueBySummoners(Region region, String... summonerIds) {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerIds);
		ApiMethod method = new GetLeagueBySummoners(getConfig(), region, Convert.joinString(",", summonerIds));
		return endpointManager.callMethodAsynchronously(method);
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
	 * @see League
	 */
	public AsyncRequest getLeagueBySummoners(Region region, long... summonerIds) {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerIds);
		return getLeagueBySummoners(region, Convert.longToString(summonerIds));
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
	 * @see League
	 */
	public AsyncRequest getLeagueByTeams(Region region, String... teamIds) {
		Objects.requireNonNull(region);
		Objects.requireNonNull(teamIds);
		ApiMethod method = new GetLeagueByTeams(getConfig(), region, Convert.joinString(",", teamIds));
		return endpointManager.callMethodAsynchronously(method);
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
	 * @see League
	 */
	public AsyncRequest getLeagueEntryBySummoners(Region region, String... summonerIds) {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerIds);
		ApiMethod method = new GetLeagueEntryBySummoners(getConfig(), region, Convert.joinString(",", summonerIds));
		return endpointManager.callMethodAsynchronously(method);
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
	 * @see League
	 */
	public AsyncRequest getLeagueEntryBySummoners(Region region, long... summonerIds) {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerIds);
		return getLeagueEntryBySummoners(region, Convert.longToString(summonerIds));
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
	 * @see League
	 */
	public AsyncRequest getLeagueEntryByTeams(Region region, String... teamIds) {
		Objects.requireNonNull(region);
		Objects.requireNonNull(teamIds);
		ApiMethod method = new GetLeagueEntryByTeams(getConfig(), region, Convert.joinString(",", teamIds));
		return endpointManager.callMethodAsynchronously(method);
	}

	/**
	 * Gets a list of lobby events by {@code tournamentCode}
	 * 
	 * @param tournamentCode
	 *            Tournament code used to enter the lobby.
	 * @return Lobby event data
	 * @throws NullPointerException
	 *             If {@code tournamentCode} is {@code null}
	 * @see LobbyEventList
	 */
	public AsyncRequest getLobbyEventsByTournament(String tournamentCode) {
		Objects.requireNonNull(tournamentCode);
		ApiMethod method = new GetLobbyEventsByTournament(getConfig(), tournamentCode);
		return endpointManager.callMethodAsynchronously(method);
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
	 * @see League
	 */
	public AsyncRequest getMasterLeague(Region region, QueueType queueType) {
		Objects.requireNonNull(region);
		Objects.requireNonNull(queueType);
		ApiMethod method = new GetMasterLeague(getConfig(), region, queueType);
		return endpointManager.callMethodAsynchronously(method);
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
	 * @see MasteryPages
	 */
	public AsyncRequest getMasteryPages(Region region, String... summonerIds) {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerIds);
		ApiMethod method = new GetMasteryPages(getConfig(), region, Convert.joinString(",", summonerIds));
		return endpointManager.callMethodAsynchronously(method);
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
	 * @see MasteryPages
	 */
	public AsyncRequest getMasteryPages(Region region, long... summonerIds) {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerIds);
		return getMasteryPages(region, Convert.longToString(summonerIds));
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
	 * @see MatchDetail
	 */
	public AsyncRequest getMatch(Region region, long matchId, boolean includeTimeline) {
		Objects.requireNonNull(region);
		ApiMethod method = new GetMatch(getConfig(), region, matchId, includeTimeline);
		return endpointManager.callMethodAsynchronously(method);
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
	 * @see MatchDetail
	 */
	public AsyncRequest getMatch(Region region, long matchId) {
		Objects.requireNonNull(region);
		return getMatch(region, matchId, false);
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
	 */
	public AsyncRequest getMatchesByTournament(Region region, String tournamentCode) {
		Objects.requireNonNull(region);
		Objects.requireNonNull(tournamentCode);
		ApiMethod method = new GetMatchesByTournament(getConfig(), region, tournamentCode);
		return endpointManager.callMethodAsynchronously(method);
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
	 * @see MatchDetail
	 */
	public AsyncRequest getMatchForTournament(Region region, long matchId, String tournamentCode, boolean includeTimeline) {
		Objects.requireNonNull(region);
		Objects.requireNonNull(tournamentCode);
		ApiMethod method = new GetMatchForTournament(getConfig(), region, matchId, tournamentCode, includeTimeline);
		return endpointManager.callMethodAsynchronously(method);
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
	 * @see MatchDetail
	 */
	public AsyncRequest getMatchForTournament(Region region, long matchId, String tournamentCode) {
		Objects.requireNonNull(region);
		Objects.requireNonNull(tournamentCode);
		return getMatchForTournament(region, matchId, tournamentCode, false);
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
	 * @see MatchList
	 */
	public AsyncRequest getMatchList(Region region, long summonerId, String championIds, String rankedQueues, String seasons, long beginTime, long endTime,
			int beginIndex, int endIndex) {
		Objects.requireNonNull(region);
		ApiMethod method = new GetMatchList(getConfig(), region, summonerId, championIds, rankedQueues, seasons, beginTime, endTime, beginIndex, endIndex);
		return endpointManager.callMethodAsynchronously(method);
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
	 * @return A list with matches
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @see MatchList
	 */
	public AsyncRequest getMatchList(Region region, long summonerId, String championIds, String rankedQueues, String seasons) {
		Objects.requireNonNull(region);
		return getMatchList(region, summonerId, championIds, rankedQueues, seasons, -1, -1, -1, -1);
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
	 * @see MatchList
	 */
	public AsyncRequest getMatchList(Region region, long summonerId) {
		Objects.requireNonNull(region);
		return getMatchList(region, summonerId, null, null, null);
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
	 * @see PlayerStatsSummaryList
	 */
	public AsyncRequest getPlayerStatsSummary(Region region, Season season, long summonerId) {
		Objects.requireNonNull(region);
		ApiMethod method = new GetPlayerStatsSummary(getConfig(), region, season, summonerId);
		return endpointManager.callMethodAsynchronously(method);
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
	 * @see PlayerStatsSummaryList
	 */
	public AsyncRequest getPlayerStatsSummary(Region region, long summonerId) {
		Objects.requireNonNull(region);
		return getPlayerStatsSummary(region, null, summonerId);
	}

	/**
	 * Returns the number of elements in the asynchronous request pool.
	 *
	 * @return Number of elements in the asynchronous request pool
	 */
	public int getPoolSize() {
		return endpointManager.getPoolSize();
	}

	/**
	 * Returns the number of elements in the asynchronous request queue.
	 *
	 * @return Number of elements in the asynchronous request queue
	 */
	public int getQueueSize() {
		return endpointManager.getQueueSize();
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
	 * @see RankedStats
	 */
	public AsyncRequest getRankedStats(Region region, Season season, long summonerId) {
		Objects.requireNonNull(region);
		ApiMethod method = new GetRankedStats(getConfig(), region, season, summonerId);
		return endpointManager.callMethodAsynchronously(method);
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
	 * @see RankedStats
	 */
	public AsyncRequest getRankedStats(Region region, long summonerId) {
		Objects.requireNonNull(region);
		return getRankedStats(region, null, summonerId);
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
	 * @see RecentGames
	 */
	public AsyncRequest getRecentGames(Region region, long summonerId) {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerId);
		ApiMethod method = new GetRecentGames(getConfig(), region, summonerId);
		return endpointManager.callMethodAsynchronously(method);
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
	 * @see RunePages
	 */
	public AsyncRequest getRunePages(Region region, String... summonerIds) {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerIds);
		ApiMethod method = new GetRunePages(getConfig(), region, Convert.joinString(",", summonerIds));
		return endpointManager.callMethodAsynchronously(method);
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
	 * @see RunePages
	 */
	public AsyncRequest getRunePages(Region region, long... summonerIds) {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerIds);
		return getRunePages(region, Convert.longToString(summonerIds));
	}

	/**
	 * Get shard list.
	 * 
	 * @return Status for a list of shards
	 * @see Shard
	 */
	public AsyncRequest getShards() {
		ApiMethod method = new GetShards(getConfig());
		return endpointManager.callMethodAsynchronously(method);
	}

	/**
	 * Get shard status. Returns the data available on the status.leagueoflegends.com website for the given region.
	 * 
	 * @param region
	 *            The region for which to fetch data.
	 * @return Status for a single shard
	 * @throws NullPointerException
	 *             If {@code region} is {@code null}
	 * @see ShardStatus
	 */
	public AsyncRequest getShardStatus(Region region) {
		ApiMethod method = new GetShardStatus(getConfig(), region);
		return endpointManager.callMethodAsynchronously(method);
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
	 */
	public AsyncRequest getSummonerNames(Region region, String... summonerIds) {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerIds);
		ApiMethod method = new GetSummonerNames(getConfig(), region, Convert.joinString(",", summonerIds));
		return endpointManager.callMethodAsynchronously(method);
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
	 */
	public AsyncRequest getSummonerNames(Region region, long... summonerIds) {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerIds);
		return getSummonerNames(region, Convert.longToString(summonerIds));
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
	 * @see Summoner
	 */
	public AsyncRequest getSummonersById(Region region, String... summonerIds) {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerIds);
		ApiMethod method = new GetSummonersById(getConfig(), region, Convert.joinString(",", summonerIds));
		return endpointManager.callMethodAsynchronously(method);
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
	 * @see Summoner
	 */
	public AsyncRequest getSummonersById(Region region, long... summonerIds) {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerIds);
		return getSummonersById(region, Convert.longToString(summonerIds));
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
	 * @see Summoner
	 */
	public AsyncRequest getSummonersByName(Region region, String... summonerNames) {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerNames);
		ApiMethod method = new GetSummonersByName(getConfig(), region, Convert.joinString(",", summonerNames));
		return endpointManager.callMethodAsynchronously(method);
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
	 * @see Team
	 */
	public AsyncRequest getTeamsBySummonerIds(Region region, String... summonerIds) {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerIds);
		ApiMethod method = new GetTeamsBySummonerIds(getConfig(), region, Convert.joinString(",", summonerIds));
		return endpointManager.callMethodAsynchronously(method);
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
	 * @see Team
	 */
	public AsyncRequest getTeamsBySummonerIds(Region region, long... summonerIds) {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerIds);
		return getTeamsBySummonerIds(region, Convert.longToString(summonerIds));
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
	 * @see Team
	 */
	public AsyncRequest getTeamsByTeamIds(Region region, String... teamIds) {
		Objects.requireNonNull(region);
		Objects.requireNonNull(teamIds);
		ApiMethod method = new GetTeamsByTeamIds(getConfig(), region, Convert.joinString(",", teamIds));
		return endpointManager.callMethodAsynchronously(method);
	}

	/**
	 * Get specified number of top champion mastery entries sorted by number of champion points descending
	 *
	 * @param platformId
	 *            Region where to retrieve the data.
	 * @param summonerId
	 *            Summoner ID associated with the player
	 * @param count
	 *            Number of entries to retrieve.
	 * @return A list of the top champion masteries of a given summoner.
	 * @throws NullPointerException
	 *             If {@code platformId} or {@code summonerId} is {@code null}
	 * @see ChampionMastery
	 */
	public AsyncRequest getTopChampionMasteries(PlatformId platformId, long summonerId, int count) {
		Objects.requireNonNull(platformId);
		ApiMethod method = new GetTopChampionMasteries(getConfig(), platformId, summonerId, count);
		return endpointManager.callMethodAsynchronously(method);
	}

	/**
	 * Retrieve top 3 champion masteries by {@code summonerId}.
	 *
	 * @param platformId
	 *            Region where to retrieve the data.
	 * @param summonerId
	 *            Summoner ID associated with the player
	 * @return A list of the top champion masteries of a given summoner.
	 * @throws NullPointerException
	 *             If {@code platformId} or {@code summonerId} is {@code null}
	 * @see ChampionMastery
	 */
	public AsyncRequest getTopChampionMasteries(PlatformId platformId, long summonerId) {
		Objects.requireNonNull(platformId);
		Objects.requireNonNull(summonerId);
		return getTopChampionMasteries(platformId, summonerId, -1);
	}

	/**
	 * Returns the tournament code DTO associated with a {@code tournamentCode} string.
	 * 
	 * @param tournamentCode
	 *            Tournament code corresponding to data to retrieve.
	 * @return Data associated with a tournament code
	 * @throws NullPointerException
	 *             If {@code tournamentCode} is {@code null}
	 * @see TournamentCode
	 */
	public AsyncRequest getTournamentCode(String tournamentCode) {
		Objects.requireNonNull(tournamentCode);
		ApiMethod method = new GetTournamentCode(getConfig(), tournamentCode);
		return endpointManager.callMethodAsynchronously(method);
	}

	/**
	 * Removes a listener from getting informed when asynchronous requests finish.
	 * 
	 * @param listener
	 *            An object that implements {@link RequestListener}
	 * @return {@code true} if the specified listener was listening
	 * @see RequestListener
	 */
	public boolean removeListener(RequestListener listener) {
		return endpointManager.removeListener(listener);
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
	 */
	public void updateTournamentCode(String tournamentCode, TournamentMap mapType, PickType pickType, SpectatorType spectatorType, long... allowedSummonerIds) {
		Objects.requireNonNull(tournamentCode);
		ApiMethod method = new UpdateTournamentCode(getConfig(), tournamentCode, mapType, pickType, spectatorType, allowedSummonerIds);
		endpointManager.callMethodAsynchronously(method);
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
	 */
	public void updateTournamentCode(String tournamentCode, PickType pickType, SpectatorType spectatorType, long... allowedSummonerIds) {
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
	 */
	public void updateTournamentCode(String tournamentCode, TournamentMap mapType, SpectatorType spectatorType, long... allowedSummonerIds) {
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
	 */
	public void updateTournamentCode(String tournamentCode, TournamentMap mapType, PickType pickType, long... allowedSummonerIds) {
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
	 */
	public void updateTournamentCode(String tournamentCode, TournamentMap mapType, long... allowedSummonerIds) {
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
	 */
	public void updateTournamentCode(String tournamentCode, PickType pickType, long... allowedSummonerIds) {
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
	 */
	public void updateTournamentCode(String tournamentCode, SpectatorType spectatorType, long... allowedSummonerIds) {
		Objects.requireNonNull(tournamentCode);
		updateTournamentCode(tournamentCode, null, null, spectatorType, allowedSummonerIds);
	}
}