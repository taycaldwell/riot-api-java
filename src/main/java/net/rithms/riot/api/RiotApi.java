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

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Logger;

import net.rithms.riot.api.endpoints.champion.dto.ChampionInfo;
import net.rithms.riot.api.endpoints.champion.methods.GetChampionRotations;
import net.rithms.riot.api.endpoints.champion_mastery.dto.ChampionMastery;
import net.rithms.riot.api.endpoints.champion_mastery.methods.GetChampionMasteriesBySummoner;
import net.rithms.riot.api.endpoints.champion_mastery.methods.GetChampionMasteriesBySummonerByChampion;
import net.rithms.riot.api.endpoints.champion_mastery.methods.GetChampionMasteryScoresBySummoner;
import net.rithms.riot.api.endpoints.league.constant.LeagueQueue;
import net.rithms.riot.api.endpoints.league.dto.LeagueEntry;
import net.rithms.riot.api.endpoints.league.dto.LeagueList;
import net.rithms.riot.api.endpoints.league.methods.GetChallengerLeagueByQueue;
import net.rithms.riot.api.endpoints.league.methods.GetGrandmasterLeagueByQueue;
import net.rithms.riot.api.endpoints.league.methods.GetLeagueById;
import net.rithms.riot.api.endpoints.league.methods.GetLeagueEntries;
import net.rithms.riot.api.endpoints.league.methods.GetLeagueEntriesBySummonerId;
import net.rithms.riot.api.endpoints.league.methods.GetMasterLeagueByQueue;
import net.rithms.riot.api.endpoints.lol_status.dto.ShardStatus;
import net.rithms.riot.api.endpoints.lol_status.methods.GetShardData;
import net.rithms.riot.api.endpoints.match.dto.Match;
import net.rithms.riot.api.endpoints.match.dto.MatchList;
import net.rithms.riot.api.endpoints.match.dto.MatchTimeline;
import net.rithms.riot.api.endpoints.match.methods.GetMatch;
import net.rithms.riot.api.endpoints.match.methods.GetMatchByMatchIdAndTournamentCode;
import net.rithms.riot.api.endpoints.match.methods.GetMatchIdsByTournamentCode;
import net.rithms.riot.api.endpoints.match.methods.GetMatchListByAccountId;
import net.rithms.riot.api.endpoints.match.methods.GetTimelineByMatchId;
import net.rithms.riot.api.endpoints.spectator.dto.CurrentGameInfo;
import net.rithms.riot.api.endpoints.spectator.dto.FeaturedGames;
import net.rithms.riot.api.endpoints.spectator.methods.GetActiveGameBySummoner;
import net.rithms.riot.api.endpoints.spectator.methods.GetFeaturedGames;
import net.rithms.riot.api.endpoints.static_data.constant.ChampionListTags;
import net.rithms.riot.api.endpoints.static_data.constant.ChampionTags;
import net.rithms.riot.api.endpoints.static_data.constant.ItemListTags;
import net.rithms.riot.api.endpoints.static_data.constant.ItemTags;
import net.rithms.riot.api.endpoints.static_data.constant.Locale;
import net.rithms.riot.api.endpoints.static_data.constant.MasteryListTags;
import net.rithms.riot.api.endpoints.static_data.constant.MasteryTags;
import net.rithms.riot.api.endpoints.static_data.constant.RuneListTags;
import net.rithms.riot.api.endpoints.static_data.constant.RuneTags;
import net.rithms.riot.api.endpoints.static_data.constant.SpellListTags;
import net.rithms.riot.api.endpoints.static_data.constant.SpellTags;
import net.rithms.riot.api.endpoints.static_data.dto.Item;
import net.rithms.riot.api.endpoints.static_data.dto.ItemList;
import net.rithms.riot.api.endpoints.static_data.dto.LanguageStrings;
import net.rithms.riot.api.endpoints.static_data.dto.MapData;
import net.rithms.riot.api.endpoints.static_data.dto.Mastery;
import net.rithms.riot.api.endpoints.static_data.dto.MasteryList;
import net.rithms.riot.api.endpoints.static_data.dto.ProfileIconData;
import net.rithms.riot.api.endpoints.static_data.dto.Realm;
import net.rithms.riot.api.endpoints.static_data.dto.ReforgedRune;
import net.rithms.riot.api.endpoints.static_data.dto.ReforgedRunePath;
import net.rithms.riot.api.endpoints.static_data.dto.Rune;
import net.rithms.riot.api.endpoints.static_data.dto.RuneList;
import net.rithms.riot.api.endpoints.static_data.dto.SummonerSpell;
import net.rithms.riot.api.endpoints.static_data.dto.SummonerSpellList;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataChampion;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataChampionList;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataItem;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataItemList;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataLanguageStrings;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataLanguages;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataMaps;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataMastery;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataMasteryList;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataProfileIcons;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataRealm;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataReforgedRune;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataReforgedRuneList;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataReforgedRunePath;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataReforgedRunePathList;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataRune;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataRuneList;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataSummonerSpell;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataSummonerSpellList;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataTarballLinks;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataVersions;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;
import net.rithms.riot.api.endpoints.summoner.methods.GetSummoner;
import net.rithms.riot.api.endpoints.summoner.methods.GetSummonerByAccount;
import net.rithms.riot.api.endpoints.summoner.methods.GetSummonerByName;
import net.rithms.riot.api.endpoints.summoner.methods.GetSummonerByPuuid;
import net.rithms.riot.api.endpoints.third_party_code.methods.GetThirdPartyCodeBySummoner;
import net.rithms.riot.api.endpoints.tournament.constant.PickType;
import net.rithms.riot.api.endpoints.tournament.constant.SpectatorType;
import net.rithms.riot.api.endpoints.tournament.constant.TournamentMap;
import net.rithms.riot.api.endpoints.tournament.dto.LobbyEventWrapper;
import net.rithms.riot.api.endpoints.tournament.dto.TournamentCode;
import net.rithms.riot.api.endpoints.tournament.methods.CreateTournament;
import net.rithms.riot.api.endpoints.tournament.methods.CreateTournamentCodes;
import net.rithms.riot.api.endpoints.tournament.methods.CreateTournamentProvider;
import net.rithms.riot.api.endpoints.tournament.methods.GetLobbyEventsByCode;
import net.rithms.riot.api.endpoints.tournament.methods.GetTournamentCode;
import net.rithms.riot.api.endpoints.tournament.methods.UpdateTournamentCode;
import net.rithms.riot.constant.Platform;
import net.rithms.util.RiotApiUtil;

/**
 * This is the main class for using this riot api wrapper. This api is typically used by first constructing a RiotApi instance, and then
 * invoking methods on it to fire synchronous api calls.
 *
 * <p>
 * Here is an example of how RiotApi is used:
 *
 * <pre>
 * ApiConfig config = new ApiConfig().setKey("YOUR-API-KEY-HERE");
 * RiotApi api = new RiotApi(config);
 * Summoner summoner = api.getSummonerByName(Platform.NA, "Tryndamere"); // Gets a Summoner object for the summoner Tryndamere on NA
 * </pre>
 * </p>
 * 
 * <p>
 * To fire asynchronous api calls, you need an instance of {@link RiotApiAsync}, which you can get by calling {@link #getAsyncApi()}.
 * </p>
 *
 * @version 4.3.0
 * @author Taylor Caldwell
 * @author Daniel 'Linnun' Figge
 * @see ApiConfig
 * @see RiotApiAsync
 */
public class RiotApi implements Cloneable {

	public static final Logger log = Logger.getLogger(RiotApi.class.getName());

	private final ApiConfig config;
	private final EndpointManager endpointManager;

	private final Object asyncApiLock = new Object();
	private volatile RiotApiAsync asyncApi;

	/**
	 * Constructs a RiotApi object with default configuration. Please note that the default configuration does not contain an api key, and
	 * thus cannot be used for most endpoints.
	 */
	public RiotApi() {
		this(new ApiConfig());
	}

	/**
	 * Constructs a RiotApi object with the given configuration.
	 * 
	 * @param config
	 *            Configuration to use for this RiotApi object
	 * @see ApiConfig
	 */
	public RiotApi(ApiConfig config) {
		this.config = config;
		log.setUseParentHandlers(false);
		log.addHandler(new LogHandler(config.getDebugToFile()));
		log.setLevel(config.getDebugLevel());
		endpointManager = new EndpointManager(config);
	}

	/**
	 * Call a custom {@code ApiMethod}
	 *
	 * @param method
	 *            Custom {@code ApiMethod} object
	 * @return Result Dto (if any)
	 * @throws NullPointerException
	 *             If {@code method} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 */
	public Object callCustomApiMethod(ApiMethod method) throws RiotApiException {
		Objects.requireNonNull(method);
		return endpointManager.callMethodAndReturnDto(method);
	}

	@Override
	public RiotApi clone() {
		return new RiotApi(config.clone());
	}

	/**
	 * Creates a tournament and returns its ID.
	 *
	 * @param tournamentName
	 *            The optional name of the tournament.
	 * @param providerId
	 *            The provider ID to specify the regional registered provider data to associate this tournament.
	 * @return Tournament ID
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 4
	 */
	public int createTournament(String tournamentName, int providerId) throws RiotApiException {
		ApiMethod method = new CreateTournament(getConfig(), tournamentName, providerId);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Creates a tournament and returns its ID.
	 *
	 * @param providerId
	 *            The provider ID to specify the regional registered provider data to associate this tournament.
	 * @return Tournament ID
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 4
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
	 * @version 4
	 */
	public List<String> createTournamentCodes(int tournamentId, int count, int teamSize, TournamentMap mapType, PickType pickType, SpectatorType spectatorType,
			String metaData, String... allowedSummonerIds) throws RiotApiException {
		Objects.requireNonNull(mapType);
		Objects.requireNonNull(pickType);
		Objects.requireNonNull(spectatorType);
		ApiMethod method = new CreateTournamentCodes(getConfig(), tournamentId, count, teamSize, mapType, pickType, spectatorType, metaData,
				allowedSummonerIds);
		return endpointManager.callMethodAndReturnDto(method);
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
	 * @version 4
	 */
	public List<String> createTournamentCodes(int tournamentId, int count, int teamSize, TournamentMap mapType, PickType pickType, SpectatorType spectatorType,
			String... allowedSummonerIds) throws RiotApiException {
		return createTournamentCodes(tournamentId, count, teamSize, mapType, pickType, spectatorType, null, allowedSummonerIds);
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
	 * @version 4
	 */
	public int createTournamentProvider(String region, String callbackUrl) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(callbackUrl);
		ApiMethod method = new CreateTournamentProvider(getConfig(), region, callbackUrl);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Get current game information for the given summoner ID.
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param summonerId
	 *            The ID of the summoner.
	 * @return Current game info
	 * @throws NullPointerException
	 *             If {@code platform} or {@code summonerId} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 4
	 * @see CurrentGameInfo
	 */
	public CurrentGameInfo getActiveGameBySummoner(Platform platform, String summonerId) throws RiotApiException {
		Objects.requireNonNull(platform);
		Objects.requireNonNull(summonerId);
		ApiMethod method = new GetActiveGameBySummoner(getConfig(), platform, summonerId);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Provides a RiotApiAsync object to use for asynchronous api calls.
	 * 
	 * @return RotApiAsync object
	 * @see RiotApiAsync
	 */
	public RiotApiAsync getAsyncApi() {
		RiotApiAsync asyncInstance = asyncApi;
		if (asyncInstance == null) {
			synchronized (asyncApiLock) {
				asyncInstance = asyncApi;
				if (asyncInstance == null) {
					asyncApi = asyncInstance = new RiotApiAsync(config, endpointManager);
				}
			}
		}
		return asyncInstance;
	}

	/**
	 * Get the challenger league for a given {@code queue}.
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param queue
	 *            Game queue type.
	 * @return A league list
	 * @throws NullPointerException
	 *             If {@code platform} or {@code queue} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 4
	 * @see LeagueList
	 */
	public LeagueList getChallengerLeagueByQueue(Platform platform, String queue) throws RiotApiException {
		Objects.requireNonNull(platform);
		Objects.requireNonNull(queue);
		ApiMethod method = new GetChallengerLeagueByQueue(getConfig(), platform, queue);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Get the challenger league for a given {@code queue}.
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param queue
	 *            Game queue type.
	 * @return A league list
	 * @throws NullPointerException
	 *             If {@code queue} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 4
	 * @see LeagueList
	 */
	public LeagueList getChallengerLeagueByQueue(Platform platform, LeagueQueue queue) throws RiotApiException {
		Objects.requireNonNull(queue);
		return getChallengerLeagueByQueue(platform, queue.toString());
	}

	/**
	 * Get all champion mastery entries sorted by number of champion points descending
	 *
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param summonerId
	 *            Summoner ID associated with the player
	 * @return A list of champion masteries for a given summoner.
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 4
	 * @see ChampionMastery
	 */
	public List<ChampionMastery> getChampionMasteriesBySummoner(Platform platform, String summonerId) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetChampionMasteriesBySummoner(getConfig(), platform, summonerId);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Get a champion mastery by {@code summonerId} and {@code championId}.
	 *
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param summonerId
	 *            Summoner ID associated with the player
	 * @param championId
	 *            Champion ID to retrieve Champion Mastery for
	 * @return Champion mastery for a given summoner and championId, or {@code null} if given player has no mastery for given champion.
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 4
	 * @see ChampionMastery
	 */
	public ChampionMastery getChampionMasteriesBySummonerByChampion(Platform platform, String summonerId, int championId) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetChampionMasteriesBySummonerByChampion(getConfig(), platform, summonerId, championId);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Get a player's total champion mastery score, which is sum of individual champion mastery levels
	 *
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param summonerId
	 *            Summoner ID associated with the player
	 * @return The total champion mastery score of a given summoner.
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 4
	 */
	public int getChampionMasteryScoresBySummoner(Platform platform, String summonerId) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetChampionMasteryScoresBySummoner(getConfig(), platform, summonerId);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Returns champion rotations, including free-to-play and low-level free-to-play rotations.
	 *
	 * @param platform
	 *            Platform to execute the method call against.
	 * @return This object contains information about champion rotations.
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see ChampionInfo
	 */
	public ChampionInfo getChampionRotations(Platform platform) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetChampionRotations(getConfig(), platform);
		return endpointManager.callMethodAndReturnDto(method);
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
	 * Retrieves a champion by {@code id}.
	 * <p>
	 * <i>Not all data is returned by default. See the tags parameter for more information.</i>
	 * </p>
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param id
	 *            Champion ID
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @param tags
	 *            Tags to return additional data. Only {@code id}, {@code key}, {@code name}, and {@code title} are returned by default if
	 *            this parameter isn't specified. To return all additional data, use {@code ChampionTags.ALL}.
	 * @return A single champion
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see net.rithms.riot.api.endpoints.static_data.dto.Champion
	 */
	public net.rithms.riot.api.endpoints.static_data.dto.Champion getDataChampion(Platform platform, int id, Locale locale, String version,
			ChampionTags... tags) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetDataChampion(getConfig(), platform, id, locale, version, tags);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Retrieves a champion by {@code id}.
	 * <p>
	 * <i>Not all data is returned by default. See the tags parameter for more information.</i>
	 * </p>
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param id
	 *            Champion ID
	 * @return A single champion
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see net.rithms.riot.api.endpoints.static_data.dto.Champion
	 */
	public net.rithms.riot.api.endpoints.static_data.dto.Champion getDataChampion(Platform platform, int id) throws RiotApiException {
		return getDataChampion(platform, id, null, null);
	}

	/**
	 * Retrieves champion list.
	 * <p>
	 * <i>Not all data is returned by default. See the tags parameter for more information.</i>
	 * </p>
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @param dataById
	 *            If specified as true, the returned data map will use the champions' IDs as the keys. If specified as false, the returned
	 *            data map will use the champions' keys instead.
	 * @param tags
	 *            Tags to return additional data. Only {@code id}, {@code key}, {@code name}, and {@code title} are returned by default if
	 *            this parameter isn't specified. To return all additional data, use {@code ChampionListTags.ALL}.
	 * @return A list with champions
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see net.rithms.riot.api.endpoints.static_data.dto.ChampionList
	 */
	public net.rithms.riot.api.endpoints.static_data.dto.ChampionList getDataChampionList(Platform platform, Locale locale, String version, boolean dataById,
			ChampionListTags... tags) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetDataChampionList(getConfig(), platform, locale, version, dataById, tags);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Retrieves champion list.
	 * <p>
	 * <i>Not all data is returned by default. See the tags parameter for more information.</i>
	 * </p>
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @return A list with champions
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see net.rithms.riot.api.endpoints.static_data.dto.ChampionList
	 */
	public net.rithms.riot.api.endpoints.static_data.dto.ChampionList getDataChampionList(Platform platform) throws RiotApiException {
		return getDataChampionList(platform, null, null, false);
	}

	/**
	 * Retrieves item by {@code id}.
	 * <p>
	 * <i>Not all data is returned by default. See the tags parameter for more information.</i>
	 * </p>
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param id
	 *            Item ID
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @param tags
	 *            Tags to return additional data. Only {@code type}, {@code version}, {@code basic}, {@code data}, {@code id}, {@code name},
	 *            {@code plaintext}, {@code group}, and {@code description} are returned by default if this parameter isn't specified. To
	 *            return all additional data, use {@code ItemTags.ALL}.
	 * @return A single item
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see Item
	 */
	public Item getDataItem(Platform platform, int id, Locale locale, String version, ItemTags... tags) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetDataItem(getConfig(), platform, id, locale, version, tags);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Retrieves item by {@code id}.
	 * <p>
	 * <i>Not all data is returned by default. See the tags parameter for more information.</i>
	 * </p>
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param id
	 *            Item ID
	 * @return A single item
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see Item
	 */
	public Item getDataItem(Platform platform, int id) throws RiotApiException {
		return getDataItem(platform, id, null, null);
	}

	/**
	 * Retrieves item list.
	 * <p>
	 * <i>Not all data is returned by default. See the tags parameter for more information.</i>
	 * </p>
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @param tags
	 *            Tags to return additional data. Only {@code type}, {@code version}, {@code basic}, {@code data}, {@code id}, {@code name},
	 *            {@code plaintext}, {@code group}, and {@code description} are returned by default if this parameter isn't specified. To
	 *            return all additional data, use {@code ItemListTags.ALL}.
	 * @return A list of items
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see ItemList
	 */
	public ItemList getDataItemList(Platform platform, Locale locale, String version, ItemListTags... tags) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetDataItemList(getConfig(), platform, locale, version, tags);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Retrieves item list.
	 * <p>
	 * <i>Not all data is returned by default. See the tags parameter for more information.</i>
	 * </p>
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @return A list of items
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see ItemList
	 */
	public ItemList getDataItemList(Platform platform) throws RiotApiException {
		return getDataItemList(platform, null, null);
	}

	/**
	 * Retrieve supported languages data.
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @return A list with languages
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 */
	public List<String> getDataLanguages(Platform platform) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetDataLanguages(getConfig(), platform);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Retrieve language strings data.
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @return Language strings
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see LanguageStrings
	 */
	public LanguageStrings getDataLanguageStrings(Platform platform, Locale locale, String version) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetDataLanguageStrings(getConfig(), platform, locale, version);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Retrieve language strings data.
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @return Language strings
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see LanguageStrings
	 */
	public LanguageStrings getDataLanguageStrings(Platform platform) throws RiotApiException {
		return getDataLanguageStrings(platform, null, null);
	}

	/**
	 * Retrieves map data.
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @return A list of game maps
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see MapData
	 */
	public MapData getDataMaps(Platform platform, Locale locale, String version) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetDataMaps(getConfig(), platform, locale, version);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Retrieves map data.
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @return A list of game maps
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see MapData
	 */
	public MapData getDataMaps(Platform platform) throws RiotApiException {
		return getDataMaps(platform, null, null);
	}

	/**
	 * Retrieves mastery item by {@code id}.
	 * <p>
	 * <i>Not all data is returned by default. See the tags parameter for more information.</i>
	 * </p>
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param id
	 *            Mastery ID
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @param tags
	 *            Tags to return additional data. Only {@code id}, {@code name}, and {@code description} are returned by default if this
	 *            parameter isn't specified. To return all additional data, use {@code MasteryTags.ALL}.
	 * @return A single mastery
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see Mastery
	 */
	public Mastery getDataMastery(Platform platform, int id, Locale locale, String version, MasteryTags... tags) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetDataMastery(getConfig(), platform, id, locale, version, tags);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Retrieves mastery item by {@code id}.
	 * <p>
	 * <i>Not all data is returned by default. See the tags parameter for more information.</i>
	 * </p>
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param id
	 *            Mastery ID
	 * @return A single mastery
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see Mastery
	 */
	public Mastery getDataMastery(Platform platform, int id) throws RiotApiException {
		return getDataMastery(platform, id, null, null);
	}

	/**
	 * Retrieves mastery list.
	 * <p>
	 * <i>Not all data is returned by default. See the tags parameter for more information.</i>
	 * </p>
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @param tags
	 *            Tags to return additional data. Only {@code type}, {@code version}, {@code data}, {@code id}, {@code name}, and
	 *            {@code description} are returned by default if this parameter isn't specified. To return all additional data, use
	 *            {@code MasteryListTags.ALL}.
	 * @return A list with masteries
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see MasteryList
	 */
	public MasteryList getDataMasteryList(Platform platform, Locale locale, String version, MasteryListTags... tags) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetDataMasteryList(getConfig(), platform, locale, version, tags);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Retrieves mastery list.
	 * <p>
	 * <i>Not all data is returned by default. See the tags parameter for more information.</i>
	 * </p>
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @return A list with masteries
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see MasteryList
	 */
	public MasteryList getDataMasteryList(Platform platform) throws RiotApiException {
		return getDataMasteryList(platform, null, null);
	}

	/**
	 * Retrieve profile icons.
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @return Profile icons
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see ProfileIconData
	 */
	public ProfileIconData getDataProfileIcons(Platform platform, Locale locale, String version) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetDataProfileIcons(getConfig(), platform, locale, version);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Retrieve profile icons.
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @return Profile icons
	 * @version 3
	 * @see ProfileIconData
	 */
	public ProfileIconData getDataProfileIcons(Platform platform) throws RiotApiException {
		return getDataProfileIcons(platform, null, null);
	}

	/**
	 * Retrieve realm data.
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @return A single realm
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see Realm
	 */
	public Realm getDataRealm(Platform platform) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetDataRealm(getConfig(), platform);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Retrieves reforged rune by {@code id}.
	 *
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param id
	 *            Reforged rune ID
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @return A single reforged rune
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see ReforgedRune
	 */
	public ReforgedRune getDataReforgedRune(Platform platform, int id, Locale locale, String version) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetDataReforgedRune(getConfig(), platform, id, locale, version);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Retrieves reforged rune by {@code id}.
	 *
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param id
	 *            Reforged rune ID
	 * @return A single reforged rune
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see ReforgedRune
	 */
	public ReforgedRune getDataReforgedRune(Platform platform, int id) throws RiotApiException {
		return getDataReforgedRune(platform, id, null, null);
	}

	/**
	 * Retrieves reforged rune array.
	 *
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @return An array of reforged runes
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see ReforgedRune
	 */
	public ReforgedRune[] getDataReforgedRuneList(Platform platform, Locale locale, String version) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetDataReforgedRuneList(getConfig(), platform, locale, version);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Retrieves reforged rune array.
	 *
	 * @param platform
	 *            Platform to execute the method call against.
	 * @return An array of reforged runes
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see ReforgedRune
	 */
	public ReforgedRune[] getDataReforgedRuneList(Platform platform) throws RiotApiException {
		return getDataReforgedRuneList(platform, null, null);
	}

	/**
	 * Retrieves reforged rune path by {@code id}.
	 *
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param id
	 *            Reforged rune path ID
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @return A single reforged rune path
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see ReforgedRunePath
	 */
	public ReforgedRunePath getDataReforgedRunePath(Platform platform, int id, Locale locale, String version) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetDataReforgedRunePath(getConfig(), platform, id, locale, version);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Retrieves reforged rune path by {@code id}.
	 *
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param id
	 *            Reforged rune path ID
	 * @return A single reforged rune path
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see ReforgedRunePath
	 */
	public ReforgedRunePath getDataReforgedRunePath(Platform platform, int id) throws RiotApiException {
		return getDataReforgedRunePath(platform, id, null, null);
	}

	/**
	 * Retrieves reforged rune path array.
	 *
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @return An array of reforged runes path
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see ReforgedRunePath
	 */
	public ReforgedRunePath[] getDataReforgedRunePathList(Platform platform, Locale locale, String version) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetDataReforgedRunePathList(getConfig(), platform, locale, version);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Retrieves reforged rune path array.
	 *
	 * @param platform
	 *            Platform to execute the method call against.
	 * @return An array of reforged runes path
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see ReforgedRunePath
	 */
	public ReforgedRunePath[] getDataReforgedRunePathList(Platform platform) throws RiotApiException {
		return getDataReforgedRunePathList(platform, null, null);
	}

	/**
	 * Retrieves rune by {@code id}.
	 * <p>
	 * <i>Not all data is returned by default. See the tags parameter for more information.</i>
	 * </p>
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param id
	 *            Rune ID
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @param tags
	 *            Tags to return additional data. Only {@code id}, {@code name}, {@code rune}, and {@code description} are returned by
	 *            default if this parameter isn't specified. To return all additional data, use {@code RuneTags.ALL}.
	 * @return A single rune
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see Rune
	 */
	public Rune getDataRune(Platform platform, int id, Locale locale, String version, RuneTags... tags) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetDataRune(getConfig(), platform, id, locale, version, tags);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Retrieves rune by {@code id}.
	 * <p>
	 * <i>Not all data is returned by default. See the tags parameter for more information.</i>
	 * </p>
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param id
	 *            Rune ID
	 * @return A single rune
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see Rune
	 */
	public Rune getDataRune(Platform platform, int id) throws RiotApiException {
		return getDataRune(platform, id, null, null);
	}

	/**
	 * Retrieves rune list.
	 * <p>
	 * <i>Not all data is returned by default. See the tags parameter for more information.</i>
	 * </p>
	 *
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @param tags
	 *            Tags to return additional data. Only {@code type}, {@code version}, {@code data}, {@code id}, {@code name}, {@code rune},
	 *            and {@code description} are returned by default if this parameter isn't specified. To return all additional data, use
	 *            {@code RuneListTags.ALL}.
	 * @return A list with runes
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see RuneList
	 */
	public RuneList getDataRuneList(Platform platform, Locale locale, String version, RuneListTags... tags) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetDataRuneList(getConfig(), platform, locale, version, tags);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Retrieves rune list.
	 * <p>
	 * <i>Not all data is returned by default. See the tags parameter for more information.</i>
	 * </p>
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @return A list with runes
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see RuneList
	 */
	public RuneList getDataRuneList(Platform platform) throws RiotApiException {
		return getDataRuneList(platform, null, null);
	}

	/**
	 * Retrieves summoner spell by {@code id}.
	 * <p>
	 * <i>Not all data is returned by default. See the tags parameter for more information.</i>
	 * </p>
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param id
	 *            Summoner spell ID
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @param tags
	 *            Tags to return additional data. Only {@code id}, {@code key}, {@code name}, {@code description}, and {@code summonerLevel}
	 *            are returned by default if this parameter isn't specified. To return all additional data, use {@code SpellTags.ALL}.
	 * @return A single summoner spell
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see SummonerSpell
	 */
	public SummonerSpell getDataSummonerSpell(Platform platform, int id, Locale locale, String version, SpellTags... tags) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetDataSummonerSpell(getConfig(), platform, id, locale, version, tags);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Retrieves summoner spell by {@code id}.
	 * <p>
	 * <i>Not all data is returned by default. See the tags parameter for more information.</i>
	 * </p>
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param id
	 *            Summoner spell ID
	 * @return A single summoner spell
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see SummonerSpell
	 */
	public SummonerSpell getDataSummonerSpell(Platform platform, int id) throws RiotApiException {
		return getDataSummonerSpell(platform, id, null, null);
	}

	/**
	 * Retrieves summoner spell list.
	 * <p>
	 * <i>Not all data is returned by default. See the tags parameter for more information.</i>
	 * </p>
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param locale
	 *            Locale code for returned data (e.g., {@code en_US}, {@code es_ES}). If not specified, the default locale for the region is
	 *            used.
	 * @param version
	 *            Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions
	 *            can be obtained from the {@link #getDataVersions()} method.
	 * @param dataById
	 *            If specified as true, the returned data map will use the spells' IDs as the keys. If specified as false, the returned data
	 *            map will use the spells' keys instead
	 * @param tags
	 *            Tags to return additional data. Only {@code type}, {@code version}, {@code data}, {@code id}, {@code key}, {@code name},
	 *            {@code description}, and {@code summonerLevel} are returned by default if this parameter isn't specified. To return all
	 *            additional data, use {@code SpellListTags.ALL}.
	 * @return A list with summoner spells
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see SummonerSpellList
	 */
	public SummonerSpellList getDataSummonerSpellList(Platform platform, Locale locale, String version, boolean dataById, SpellListTags... tags)
			throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetDataSummonerSpellList(getConfig(), platform, locale, version, dataById, tags);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Retrieves summoner spell list.
	 * <p>
	 * <i>Not all data is returned by default. See the tags parameter for more information.</i>
	 * </p>
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @return A list with summoner spells
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see SummonerSpellList
	 */
	public SummonerSpellList getDataSummonerSpellList(Platform platform) throws RiotApiException {
		return getDataSummonerSpellList(platform, null, null, false);
	}

	/**
	 * Retrieves full tarball link.
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param version
	 *            Patch version for returned data. If not specified, the latest version is used. List of valid versions can be obtained from
	 *            {@link #getDataVersions()}.
	 * @return Tarball link
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 */
	public String getDataTarballLinks(Platform platform, String version) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetDataTarballLinks(getConfig(), platform, version);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Retrieves full tarball link.
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @return Tarball link
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 */
	public String getDataTarballLinks(Platform platform) throws RiotApiException {
		Objects.requireNonNull(platform);
		return getDataTarballLinks(platform, null);
	}

	/**
	 * Retrieve version data.
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @return A list with versions
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 */
	public List<String> getDataVersions(Platform platform) throws RiotApiException {
		ApiMethod method = new GetDataVersions(getConfig(), platform);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Get list of featured games.
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @return Featured games
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 4
	 * @see FeaturedGames
	 */
	public FeaturedGames getFeaturedGames(Platform platform) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetFeaturedGames(getConfig(), platform);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Get the grandmaster league for a given {@code queue}.
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param queue
	 *            Game queue type.
	 * @return A league list
	 * @throws NullPointerException
	 *             If {@code platform} or {@code queue} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 4
	 * @see LeagueList
	 */
	public LeagueList getGrandmasterLeagueByQueue(Platform platform, String queue) throws RiotApiException {
		Objects.requireNonNull(platform);
		Objects.requireNonNull(queue);
		ApiMethod method = new GetGrandmasterLeagueByQueue(getConfig(), platform, queue);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Get the grandmaster league for a given {@code queue}.
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param queue
	 *            Game queue type.
	 * @return A league list
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @throws NullPointerException
	 *             If {@code queue} is {@code null}
	 * @version 4
	 * @see LeagueList
	 */
	public LeagueList getGrandmasterLeagueByQueue(Platform platform, LeagueQueue queue) throws RiotApiException {
		Objects.requireNonNull(queue);
		return getGrandmasterLeagueByQueue(platform, queue.toString());
	}

	/**
	 * Get league with given ID, including inactive entries.
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param leagueId
	 *            League ID
	 * @return League list
	 * @throws NullPointerException
	 *             If {@code platform} or {@code leagueId} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 4
	 * @see LeagueList
	 */
	public LeagueList getLeagueById(Platform platform, String leagueId) throws RiotApiException {
		Objects.requireNonNull(platform);
		Objects.requireNonNull(leagueId);
		ApiMethod method = new GetLeagueById(getConfig(), platform, leagueId);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Get league entries in all queues for a given {@code queue}, {@code tier}, and {@code division}.
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param queue
	 *            Ranked Queue
	 * @param tier
	 *            Tier
	 * @param division
	 *            Division
	 * @return List of league entries
	 * @throws NullPointerException
	 *             If {@code platform}, {@code queue}, {@code tier}, or {@code division} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 4
	 * @see LeagueEntry
	 */
	public Set<LeagueEntry> getLeagueEntries(Platform platform, String queue, String tier, String division) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetLeagueEntries(getConfig(), platform, queue, tier, division);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Get league entries in all queues for a given {@code summonerId}.
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param summonerId
	 *            Summoner ID
	 * @return List of league entries
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 4
	 * @see LeagueEntry
	 */
	public Set<LeagueEntry> getLeagueEntriesBySummonerId(Platform platform, String summonerId) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetLeagueEntriesBySummonerId(getConfig(), platform, summonerId);
		return endpointManager.callMethodAndReturnDto(method);
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
	 * @version 4
	 * @see LobbyEventWrapper
	 */
	public LobbyEventWrapper getLobbyEventsByTournament(String tournamentCode) throws RiotApiException {
		Objects.requireNonNull(tournamentCode);
		ApiMethod method = new GetLobbyEventsByCode(getConfig(), tournamentCode);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Get the master league for a given {@code queue}.
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param queue
	 *            Game queue type.
	 * @return A league list
	 * @throws NullPointerException
	 *             If {@code platform} or {@code queue} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 4
	 * @see LeagueList
	 */
	public LeagueList getMasterLeagueByQueue(Platform platform, String queue) throws RiotApiException {
		Objects.requireNonNull(platform);
		Objects.requireNonNull(queue);
		ApiMethod method = new GetMasterLeagueByQueue(getConfig(), platform, queue);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Get the master league for a given {@code queue}.
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param queue
	 *            Game queue type.
	 * @return A league list
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @throws NullPointerException
	 *             If {@code queue} is {@code null}
	 * @version 4
	 * @see LeagueList
	 */
	public LeagueList getMasterLeagueByQueue(Platform platform, LeagueQueue queue) throws RiotApiException {
		Objects.requireNonNull(queue);
		return getMasterLeagueByQueue(platform, queue.toString());
	}

	/**
	 * Get match by {@code matchId}.
	 *
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param matchId
	 *            The ID of the match.
	 * @param forAccountId
	 *            If provided, used to identify the participant to be unobfuscated.
	 * @return A map with match details
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 4
	 * @see Match
	 */
	public Match getMatch(Platform platform, long matchId, String forAccountId) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetMatch(getConfig(), platform, matchId, forAccountId);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Get match by {@code matchId}.
	 *
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param matchId
	 *            The ID of the match.
	 * @return A map with match details
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 4
	 * @see Match
	 */
	public Match getMatch(Platform platform, long matchId) throws RiotApiException {
		return getMatch(platform, matchId, null);
	}

	/**
	 * Retrieve match by {@code matchId} and {@code tournamentCode}.
	 *
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param matchId
	 *            The ID of the match.
	 * @param tournamentCode
	 *            The code of the tournament.
	 * @return A map with match details
	 * @throws NullPointerException
	 *             If {@code platform} or {@code tournamentCode} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 4
	 * @see Match
	 */
	public Match getMatchByMatchIdAndTournamentCode(Platform platform, long matchId, String tournamentCode) throws RiotApiException {
		Objects.requireNonNull(platform);
		Objects.requireNonNull(tournamentCode);
		ApiMethod method = new GetMatchByMatchIdAndTournamentCode(getConfig(), platform, matchId, tournamentCode);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Retrieve match IDs by {@code tournamentCode}.
	 *
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param tournamentCode
	 *            The code of the tournament.
	 * @return A list of match IDs
	 * @throws NullPointerException
	 *             If {@code platform} or {@code tournamentCode} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 4
	 */
	public List<Long> getMatchIdsByTournamentCode(Platform platform, String tournamentCode) throws RiotApiException {
		Objects.requireNonNull(platform);
		Objects.requireNonNull(tournamentCode);
		ApiMethod method = new GetMatchIdsByTournamentCode(getConfig(), platform, tournamentCode);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Get matchlist for given account ID and platform ID.
	 *
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param accountId
	 *            The account ID of the summoner.
	 * @param champion
	 *            Set of champion IDs for which to filtering matchlist.
	 * @param queue
	 *            Set of queue IDs for which to filtering matchlist.
	 * @param season
	 *            Set of season IDs for which to filtering matchlist.
	 * @param beginTime
	 *            The begin time to use for filtering matchlist specified as epoch milliseconds. Use {@code -1} to not use this parameter.
	 * @param endTime
	 *            The end time to use for filtering matchlist specified as epoch milliseconds. Use {@code -1} to not use this parameter.
	 * @param beginIndex
	 *            The begin index to use for filtering matchlist. Use {@code -1} to not use this parameter.
	 * @param endIndex
	 *            The end index to use for filtering matchlist. Use {@code -1} to not use this parameter.
	 * @return A list with matches
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 4
	 * @see MatchList
	 */
	public MatchList getMatchListByAccountId(Platform platform, String accountId, Set<Integer> champion, Set<Integer> queue, Set<Integer> season,
			long beginTime, long endTime, int beginIndex, int endIndex) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetMatchListByAccountId(getConfig(), platform, accountId, champion, queue, season, beginTime, endTime, beginIndex, endIndex);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Get matchlist for given account ID and platform ID.
	 *
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param accountId
	 *            The account ID of the summoner.
	 * @param champion
	 *            Set of champion IDs for which to filtering matchlist.
	 * @param queue
	 *            Set of queue IDs for which to filtering matchlist.
	 * @param season
	 *            Set of season IDs for which to filtering matchlist.
	 * @return A list with matches
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 4
	 * @see MatchList
	 */
	public MatchList getMatchListByAccountId(Platform platform, String accountId, Set<Integer> champion, Set<Integer> queue, Set<Integer> season)
			throws RiotApiException {
		return getMatchListByAccountId(platform, accountId, champion, queue, season, -1, -1, -1, -1);
	}

	/**
	 * Get matchlist for given account ID and platform ID.
	 *
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param accountId
	 *            The account ID of the summoner.
	 * @return A list with matches
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 4
	 * @see MatchList
	 */
	public MatchList getMatchListByAccountId(Platform platform, String accountId) throws RiotApiException {
		return getMatchListByAccountId(platform, accountId, null, null, null);
	}

	/**
	 * Get shard status. Returns the data available on the status.leagueoflegends.com website for the given region.
	 * 
	 * @param platform
	 *            Platform to execute the method call against.
	 * @return Status for a single shard
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see ShardStatus
	 */
	public ShardStatus getShardData(Platform platform) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetShardData(getConfig(), platform);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Get a summoner object for a given {@code accountId}.
	 *
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param accountId
	 *            Account ID associated with summoner to retrieve.
	 * @return The desired summoner
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 4
	 * @see Summoner
	 */
	public Summoner getSummonerByAccount(Platform platform, String accountId) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetSummonerByAccount(getConfig(), platform, accountId);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Get a summoner object for a given {@code summonerId}.
	 *
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param summonerId
	 *            Summoner ID associated with summoner to retrieve.
	 * @return The desired summoner
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 4
	 * @see Summoner
	 */
	public Summoner getSummoner(Platform platform, String summonerId) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetSummoner(getConfig(), platform, summonerId);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Get a single summoner object for a given {@code summonerName}.
	 *
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param summonerName
	 *            Summoner name associated with summoner to retrieve.
	 * @return Desired summoner
	 * @throws IllegalArgumentException
	 *             If {@code summonerName} is not a valid summoner name
	 * @throws NullPointerException
	 *             If {@code platform} or {@code summonerName} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 4
	 * @see Summoner
	 */
	public Summoner getSummonerByName(Platform platform, String summonerName) throws RiotApiException {
		Objects.requireNonNull(platform);
		Objects.requireNonNull(summonerName);
		RiotApiUtil.requireValidSummonerName(summonerName);
		ApiMethod method = new GetSummonerByName(getConfig(), platform, summonerName);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Get a summoner object for a given {@code puuid}.
	 *
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param puuid
	 *            PUUID associated with summoner to retrieve.
	 * @return The desired summoner
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 4
	 * @see Summoner
	 */
	public Summoner getSummonerByPuuid(Platform platform, String puuid) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetSummonerByPuuid(getConfig(), platform, puuid);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Get the third party code for a given {@code summonerId}.
	 *
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param summonerId
	 *            Summoner ID associated with summoner to retrieve third party code for.
	 * @return Third party code of the desired summoner
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 4
	 */
	public String getThirdPartyCodeBySummoner(Platform platform, String summonerId) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetThirdPartyCodeBySummoner(getConfig(), platform, summonerId);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Get match timeline by {@code matchId}.
	 *
	 * @param platform
	 *            Platform to execute the method call against.
	 * @param matchId
	 *            The ID of the match.
	 * @return A map with match timeline details
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 4
	 * @see MatchTimeline
	 */
	public MatchTimeline getTimelineByMatchId(Platform platform, long matchId) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetTimelineByMatchId(getConfig(), platform, matchId);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Returns the tournament code DTO associated with a {@code tournamentCode}.
	 *
	 * @param tournamentCode
	 *            The tournament code
	 * @return Tournament code DTO
	 * @throws NullPointerException
	 *             If {@code tournamentCode} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 4
	 * @see TournamentCode
	 */
	public TournamentCode getTournamentCode(String tournamentCode) throws RiotApiException {
		Objects.requireNonNull(tournamentCode);
		ApiMethod method = new GetTournamentCode(getConfig(), tournamentCode);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Update the pick type, map, spectator type, or allowed summoners for a code.
	 *
	 * @param tournamentCode
	 *            The tournament code
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
	 * @version 4
	 */
	public void updateTournamentCode(String tournamentCode, TournamentMap mapType, PickType pickType, SpectatorType spectatorType, String... allowedSummonerIds)
			throws RiotApiException {
		Objects.requireNonNull(tournamentCode);
		ApiMethod method = new UpdateTournamentCode(getConfig(), tournamentCode, mapType, pickType, spectatorType, allowedSummonerIds);
		endpointManager.callMethod(method);
	}
}