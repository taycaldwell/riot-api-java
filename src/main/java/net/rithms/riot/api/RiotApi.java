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
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

import net.rithms.riot.api.endpoints.champion.dto.Champion;
import net.rithms.riot.api.endpoints.champion.dto.ChampionList;
import net.rithms.riot.api.endpoints.champion.methods.GetChampion;
import net.rithms.riot.api.endpoints.champion.methods.GetChampions;
import net.rithms.riot.api.endpoints.champion_mastery.dto.ChampionMastery;
import net.rithms.riot.api.endpoints.champion_mastery.methods.GetChampionMasteriesBySummoner;
import net.rithms.riot.api.endpoints.champion_mastery.methods.GetChampionMasteriesBySummonerByChampion;
import net.rithms.riot.api.endpoints.champion_mastery.methods.GetChampionMasteryScoresBySummoner;
import net.rithms.riot.api.endpoints.game.dto.RecentGames;
import net.rithms.riot.api.endpoints.game.methods.GetRecentGames;
import net.rithms.riot.api.endpoints.league.dto.League;
import net.rithms.riot.api.endpoints.league.methods.GetChallengerLeague;
import net.rithms.riot.api.endpoints.league.methods.GetLeagueBySummoners;
import net.rithms.riot.api.endpoints.league.methods.GetLeagueEntryBySummoners;
import net.rithms.riot.api.endpoints.league.methods.GetMasterLeague;
import net.rithms.riot.api.endpoints.lol_status.dto.ShardStatus;
import net.rithms.riot.api.endpoints.lol_status.methods.GetShardData;
import net.rithms.riot.api.endpoints.masteries.dto.MasteryPages;
import net.rithms.riot.api.endpoints.masteries.methods.GetMasteriesBySummoner;
import net.rithms.riot.api.endpoints.match.dto.MatchDetail;
import net.rithms.riot.api.endpoints.match.methods.GetMatch;
import net.rithms.riot.api.endpoints.match.methods.GetMatchForTournament;
import net.rithms.riot.api.endpoints.match.methods.GetMatchesByTournament;
import net.rithms.riot.api.endpoints.matchlist.dto.MatchList;
import net.rithms.riot.api.endpoints.matchlist.methods.GetMatchList;
import net.rithms.riot.api.endpoints.runes.dto.RunePages;
import net.rithms.riot.api.endpoints.runes.methods.GetRunesBySummoner;
import net.rithms.riot.api.endpoints.spectator.dto.CurrentGameInfo;
import net.rithms.riot.api.endpoints.spectator.dto.FeaturedGames;
import net.rithms.riot.api.endpoints.spectator.methods.GetActiveGameBySummoner;
import net.rithms.riot.api.endpoints.spectator.methods.GetFeaturedGames;
import net.rithms.riot.api.endpoints.static_data.constant.ChampData;
import net.rithms.riot.api.endpoints.static_data.constant.ItemData;
import net.rithms.riot.api.endpoints.static_data.constant.ItemListData;
import net.rithms.riot.api.endpoints.static_data.constant.Locale;
import net.rithms.riot.api.endpoints.static_data.constant.MasteryData;
import net.rithms.riot.api.endpoints.static_data.constant.MasteryListData;
import net.rithms.riot.api.endpoints.static_data.constant.RuneData;
import net.rithms.riot.api.endpoints.static_data.constant.RuneListData;
import net.rithms.riot.api.endpoints.static_data.constant.SpellData;
import net.rithms.riot.api.endpoints.static_data.dto.Item;
import net.rithms.riot.api.endpoints.static_data.dto.ItemList;
import net.rithms.riot.api.endpoints.static_data.dto.LanguageStrings;
import net.rithms.riot.api.endpoints.static_data.dto.MapData;
import net.rithms.riot.api.endpoints.static_data.dto.Mastery;
import net.rithms.riot.api.endpoints.static_data.dto.MasteryList;
import net.rithms.riot.api.endpoints.static_data.dto.Realm;
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
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;
import net.rithms.riot.api.endpoints.summoner.methods.GetSummoner;
import net.rithms.riot.api.endpoints.summoner.methods.GetSummonerByAccount;
import net.rithms.riot.api.endpoints.summoner.methods.GetSummonerByName;
import net.rithms.riot.api.endpoints.tournament_stub.dto.LobbyEventWrapper;
import net.rithms.riot.api.endpoints.tournament_stub.methods.CreateTournament;
import net.rithms.riot.api.endpoints.tournament_stub.methods.CreateTournamentCodes;
import net.rithms.riot.api.endpoints.tournament_stub.methods.CreateTournamentProvider;
import net.rithms.riot.api.endpoints.tournament_stub.methods.GetLobbyEventsByCode;
import net.rithms.riot.constant.PickType;
import net.rithms.riot.constant.Platform;
import net.rithms.riot.constant.QueueType;
import net.rithms.riot.constant.Region;
import net.rithms.riot.constant.Season;
import net.rithms.riot.constant.SpectatorType;
import net.rithms.riot.constant.TournamentMap;
import net.rithms.util.Convert;

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
 * Summoner summoner = api.getSummonerByName(Region.NA, "Tryndamere"); // Gets a Summoner object for the summoner Tryndamere on NA
 * </pre>
 * </p>
 * 
 * <p>
 * To fire asynchronous api calls, you need an instance of {@link RiotApiAsync}, which you can get by calling {@link RiotApi#getAsyncApi()}.
 * </p>
 *
 * @version 4.0.0 alpha
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
	 * @return A tournament ID
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
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
	 * @return A tournament Id
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
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
	 * @version 3
	 */
	public List<String> createTournamentCodes(int tournamentId, int count, int teamSize, TournamentMap mapType, PickType pickType, SpectatorType spectatorType,
			String metaData, long... allowedSummonerIds) throws RiotApiException {
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
	 * @version 3
	 */
	public List<String> createTournamentCodes(int tournamentId, int count, int teamSize, TournamentMap mapType, PickType pickType, SpectatorType spectatorType,
			long... allowedSummonerIds) throws RiotApiException {
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
	 * @version 3
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
	 *            The platform for which to fetch data.
	 * @param summonerId
	 *            The ID of the summoner.
	 * @return Current game info
	 * @throws NullPointerException
	 *             If {@code platform} or {@code summonerId} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see CurrentGameInfo
	 */
	public CurrentGameInfo getActiveGameBySummoner(Platform platform, long summonerId) throws RiotApiException {
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
		ApiMethod method = new GetChallengerLeague(getConfig(), region, queueType);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Retrieve champion by {@code id}.
	 *
	 * @param platform
	 *            Platform where to retrieve the data.
	 * @param id
	 *            The ID of the desired champion
	 * @return The champion of the given ID
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see Champion
	 */
	public Champion getChampion(Platform platform, int id) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetChampion(getConfig(), platform, id);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Get all champion mastery entries sorted by number of champion points descending
	 *
	 * @param platform
	 *            Platform where to retrieve the data.
	 * @param summonerId
	 *            Summoner ID associated with the player
	 * @return A list of champion masteries for a given summoner.
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see ChampionMastery
	 */
	public List<ChampionMastery> getChampionMasteriesBySummoner(Platform platform, long summonerId) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetChampionMasteriesBySummoner(getConfig(), platform, summonerId);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Get a champion mastery by {@code summonerId} and {@code championId}.
	 *
	 * @param platform
	 *            Platform where to retrieve the data.
	 * @param summonerId
	 *            Summoner ID associated with the player
	 * @param championId
	 *            Champion ID to retrieve Champion Mastery for
	 * @return Champion mastery for a given summoner and championId, or {@code null} if given player has no mastery for given champion.
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see ChampionMastery
	 */
	public ChampionMastery getChampionMasteriesBySummonerByChampion(Platform platform, long summonerId, int championId) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetChampionMasteriesBySummonerByChampion(getConfig(), platform, summonerId, championId);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Get a player's total champion mastery score, which is sum of individual champion mastery levels
	 *
	 * @param platform
	 *            Platform where to retrieve the data.
	 * @param summonerId
	 *            Summoner ID associated with the player
	 * @return The total champion mastery score of a given summoner.
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 */
	public int getChampionMasteryScoresBySummoner(Platform platform, long summonerId) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetChampionMasteryScoresBySummoner(getConfig(), platform, summonerId);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Retrieve all champions.
	 *
	 * @param platform
	 *            Platform where to retrieve the data.
	 * @param freeToPlay
	 *            Optional filter param to retrieve only free to play champions.
	 * @return This object contains a collection of champion information.
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see ChampionList
	 */
	public ChampionList getChampions(Platform platform, boolean freeToPlay) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetChampions(getConfig(), platform, freeToPlay);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Retrieve all champions.
	 *
	 * @param platform
	 *            Platform where to retrieve the data.
	 * @return This object contains a collection of champion information.
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see ChampionList
	 */
	public ChampionList getChampions(Platform platform) throws RiotApiException {
		return getChampions(platform, false);
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
	 * Retrieves a champion by its {@code id}.
	 * 
	 * @param platform
	 *            Platform from which to retrieve data.
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
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see net.rithms.riot.api.endpoints.static_data.dto.Champion
	 */
	public net.rithms.riot.api.endpoints.static_data.dto.Champion getDataChampion(Platform platform, int id, Locale locale, String version,
			ChampData... champData) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetDataChampion(getConfig(), platform, id, locale, version, champData);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Retrieves a champion by its {@code id}.
	 * 
	 * @param platform
	 *            Platform from which to retrieve data.
	 * @param id
	 *            Champion ID
	 * @return A single champion
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see net.rithms.riot.api.endpoints.static_data.dto.Champion
	 */
	public net.rithms.riot.api.endpoints.static_data.dto.Champion getDataChampion(Platform platform, int id) throws RiotApiException {
		return getDataChampion(platform, id, null, null, (ChampData) null);
	}

	/**
	 * Retrieves champion list.
	 * 
	 * @param platform
	 *            Platform from which to retrieve data.
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
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see net.rithms.riot.api.endpoints.static_data.dto.ChampionList
	 */
	public net.rithms.riot.api.endpoints.static_data.dto.ChampionList getDataChampionList(Platform platform, Locale locale, String version, boolean dataById,
			ChampData... champData) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetDataChampionList(getConfig(), platform, locale, version, dataById, champData);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Retrieves champion list.
	 * 
	 * @param platform
	 *            Platform from which to retrieve data.
	 * @return A list with champions
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see net.rithms.riot.api.endpoints.static_data.dto.ChampionList
	 */
	public net.rithms.riot.api.endpoints.static_data.dto.ChampionList getDataChampionList(Platform platform) throws RiotApiException {
		return getDataChampionList(platform, null, null, false, (ChampData) null);
	}

	/**
	 * Retrieves item by its unique {@code id}.
	 * 
	 * @param platform
	 *            Platform from which to retrieve data.
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
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see Item
	 */
	public Item getDataItem(Platform platform, int id, Locale locale, String version, ItemData... itemData) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetDataItem(getConfig(), platform, id, locale, version, itemData);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Retrieves item by its unique {@code id}.
	 * 
	 * @param platform
	 *            Platform from which to retrieve data.
	 * @param id
	 *            Item ID
	 * @return A single item
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see Item
	 */
	public Item getDataItem(Platform platform, int id) throws RiotApiException {
		return getDataItem(platform, id, null, null, (ItemData) null);
	}

	/**
	 * Retrieves item list.
	 * 
	 * @param platform
	 *            Platform from which to retrieve data.
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
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see ItemList
	 */
	public ItemList getDataItemList(Platform platform, Locale locale, String version, ItemListData... itemListData) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetDataItemList(getConfig(), platform, locale, version, itemListData);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Retrieves item list.
	 * 
	 * @param platform
	 *            Platform from which to retrieve data.
	 * @return A list of items
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see ItemList
	 */
	public ItemList getDataItemList(Platform platform) throws RiotApiException {
		return getDataItemList(platform, null, null, (ItemListData) null);
	}

	/**
	 * Retrieve supported languages data.
	 * 
	 * @param platform
	 *            Platform from which to retrieve data.
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
	 *            Platform from which to retrieve data.
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
	 *            Platform from which to retrieve data.
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
	 *            Platform from which to retrieve data.
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
	 *            Platform from which to retrieve data.
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
	 * Retrieves mastery item by its unique {@code id}.
	 * 
	 * @param platform
	 *            Platform from which to retrieve data.
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
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see Mastery
	 */
	public Mastery getDataMastery(Platform platform, int id, Locale locale, String version, MasteryData... masteryData) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetDataMastery(getConfig(), platform, id, locale, version, masteryData);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Retrieves mastery item by its unique {@code id}.
	 * 
	 * @param platform
	 *            Platform from which to retrieve data.
	 * @param id
	 *            Mastery ID
	 * @return A single mastery
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see Mastery
	 */
	public Mastery getDataMastery(Platform platform, int id) throws RiotApiException {
		return getDataMastery(platform, id, null, null, (MasteryData) null);
	}

	/**
	 * Retrieves mastery list.
	 * 
	 * @param platform
	 *            Platform from which to retrieve data.
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
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see MasteryList
	 */
	public MasteryList getDataMasteryList(Platform platform, Locale locale, String version, MasteryListData... masteryListData) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetDataMasteryList(getConfig(), platform, locale, version, masteryListData);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Retrieves mastery list.
	 * 
	 * @param platform
	 *            Platform from which to retrieve data.
	 * @return A list with masteries
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see MasteryList
	 */
	public MasteryList getDataMasteryList(Platform platform) throws RiotApiException {
		return getDataMasteryList(platform, null, null, (MasteryListData) null);
	}

	/**
	 * Retrieve realm data.
	 * 
	 * @param platform
	 *            Platform from which to retrieve data.
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
	 * Retrieves rune by its unique {@code id}.
	 * 
	 * @param platform
	 *            Platform from which to retrieve data.
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
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see Rune
	 */
	public Rune getDataRune(Platform platform, int id, Locale locale, String version, RuneData... runeData) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetDataRune(getConfig(), platform, id, locale, version, runeData);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Retrieves rune by its unique {@code id}.
	 * 
	 * @param platform
	 *            Platform from which to retrieve data.
	 * @param id
	 *            Rune ID
	 * @return A single rune
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see Rune
	 */
	public Rune getDataRune(Platform platform, int id) throws RiotApiException {
		return getDataRune(platform, id, null, null, (RuneData) null);
	}

	/**
	 * Retrieves rune list.
	 * 
	 * @param platform
	 *            Platform from which to retrieve data.
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
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see RuneList
	 */
	public RuneList getDataRuneList(Platform platform, Locale locale, String version, RuneListData... runeListData) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetDataRuneList(getConfig(), platform, locale, version, runeListData);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Retrieves rune list.
	 * 
	 * @param platform
	 *            Platform from which to retrieve data.
	 * @return A list with runes
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see RuneList
	 */
	public RuneList getDataRuneList(Platform platform) throws RiotApiException {
		return getDataRuneList(platform, null, null, (RuneListData) null);
	}

	/**
	 * Retrieves summoner spell by its unique {@code id}.
	 * 
	 * @param platform
	 *            Platform from which to retrieve data.
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
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see SummonerSpell
	 */
	public SummonerSpell getDataSummonerSpell(Platform platform, int id, Locale locale, String version, SpellData... spellData) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetDataSummonerSpell(getConfig(), platform, id, locale, version, spellData);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Retrieves summoner spell by its unique {@code id}.
	 * 
	 * @param platform
	 *            Platform from which to retrieve data.
	 * @param id
	 *            Summoner spell ID
	 * @return A single summoner spell
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see SummonerSpell
	 */
	public SummonerSpell getDataSummonerSpell(Platform platform, int id) throws RiotApiException {
		return getDataSummonerSpell(platform, id, null, null, (SpellData) null);
	}

	/**
	 * Retrieves summoner spell list.
	 * 
	 * @param platform
	 *            Platform from which to retrieve data.
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
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see SummonerSpellList
	 */
	public SummonerSpellList getDataSummonerSpellList(Platform platform, Locale locale, String version, boolean dataById, SpellData... spellData)
			throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetDataSummonerSpellList(getConfig(), platform, locale, version, dataById, spellData);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Retrieves summoner spell list.
	 * 
	 * @param platform
	 *            Platform from which to retrieve data.
	 * @return A list with summoner spells
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see SummonerSpellList
	 */
	public SummonerSpellList getDataSummonerSpellList(Platform platform) throws RiotApiException {
		return getDataSummonerSpellList(platform, null, null, false, (SpellData) null);
	}

	/**
	 * Retrieve version data.
	 * 
	 * @param platform
	 *            Platform from which to retrieve data.
	 * @return A list with versions
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 */
	public List<String> getDataVersions(Platform platform) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetDataVersions(getConfig(), platform);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Get list of featured games.
	 * 
	 * @param platform
	 *            Platform from which to retrieve data.
	 * @return Featured games
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see FeaturedGames
	 */
	public FeaturedGames getFeaturedGames(Platform platform) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetFeaturedGames(getConfig(), platform);
		return endpointManager.callMethodAndReturnDto(method);
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
		ApiMethod method = new GetLeagueBySummoners(getConfig(), region, Convert.joinString(",", summonerIds));
		return endpointManager.callMethodAndReturnDto(method);
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
		ApiMethod method = new GetLeagueEntryBySummoners(getConfig(), region, Convert.joinString(",", summonerIds));
		return endpointManager.callMethodAndReturnDto(method);
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
	 * Gets a list of lobby events by {@code tournamentCode}
	 * 
	 * @param tournamentCode
	 *            Tournament code used to enter the lobby.
	 * @return Lobby event data
	 * @throws NullPointerException
	 *             If {@code tournamentCode} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see LobbyEventWrapper
	 */
	public LobbyEventWrapper getLobbyEventsByTournament(String tournamentCode) throws RiotApiException {
		Objects.requireNonNull(tournamentCode);
		ApiMethod method = new GetLobbyEventsByCode(getConfig(), tournamentCode);
		return endpointManager.callMethodAndReturnDto(method);
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
		ApiMethod method = new GetMasterLeague(getConfig(), region, queueType);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Get mastery pages for a given {@code summonerId}.
	 *
	 * @param platform
	 *            Platform where to retrieve the data.
	 * @param summonerIds
	 *            Summoner ID associated with masteries to retrieve.
	 * @return Mastery pages of the given summoners
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see MasteryPages
	 */
	public MasteryPages getMasteriesBySummoner(Platform platform, long summonerId) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetMasteriesBySummoner(getConfig(), platform, summonerId);
		return endpointManager.callMethodAndReturnDto(method);
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
		ApiMethod method = new GetMatch(getConfig(), region, matchId, includeTimeline);
		return endpointManager.callMethodAndReturnDto(method);
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
		ApiMethod method = new GetMatchesByTournament(getConfig(), region, tournamentCode);
		return endpointManager.callMethodAndReturnDto(method);
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
		ApiMethod method = new GetMatchForTournament(getConfig(), region, matchId, tournamentCode, includeTimeline);
		return endpointManager.callMethodAndReturnDto(method);
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
		ApiMethod method = new GetMatchList(getConfig(), region, summonerId, championIds, rankedQueues, seasons, beginTime, endTime, beginIndex, endIndex);
		return endpointManager.callMethodAndReturnDto(method);
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
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see MatchList
	 */
	public MatchList getMatchList(Region region, long summonerId, String championIds, String rankedQueues, String seasons) throws RiotApiException {
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
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see MatchList
	 */
	public MatchList getMatchList(Region region, long summonerId) throws RiotApiException {
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
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see PlayerStatsSummaryList
	 */
	@Deprecated
	public PlayerStatsSummaryList getPlayerStatsSummary(Region region, Season season, long summonerId) throws RiotApiException {
		Objects.requireNonNull(region);
		ApiMethod method = new GetPlayerStatsSummary(getConfig(), region, season, summonerId);
		return endpointManager.callMethodAndReturnDto(method);
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
	@Deprecated
	public PlayerStatsSummaryList getPlayerStatsSummary(Region region, long summonerId) throws RiotApiException {
		Objects.requireNonNull(region);
		return getPlayerStatsSummary(region, null, summonerId);
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
	@Deprecated
	public RankedStats getRankedStats(Region region, Season season, long summonerId) throws RiotApiException {
		Objects.requireNonNull(region);
		ApiMethod method = new GetRankedStats(getConfig(), region, season, summonerId);
		return endpointManager.callMethodAndReturnDto(method);
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
	@Deprecated
	public RankedStats getRankedStats(Region region, long summonerId) throws RiotApiException {
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
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @see RecentGames
	 */
	public RecentGames getRecentGames(Region region, long summonerId) throws RiotApiException {
		Objects.requireNonNull(region);
		Objects.requireNonNull(summonerId);
		ApiMethod method = new GetRecentGames(getConfig(), region, summonerId);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Get rune pages for a given {@code summonerId}.
	 *
	 * @param platform
	 *            Platform where to retrieve the data.
	 * @param summonerIds
	 *            Summoner ID associated with runes to retrieve.
	 * @return Rune pages of the given summoners
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see RunePages
	 */
	public RunePages getRunesBySummoner(Platform platform, long summonerId) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetRunesBySummoner(getConfig(), platform, summonerId);
		return endpointManager.callMethodAndReturnDto(method);
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
	 *            Platform where to retrieve the data.
	 * @param accountId
	 *            Account ID associated with summoner to retrieve.
	 * @return The desired summoner
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see Summoner
	 */
	public Summoner getSummonerByAccount(Platform platform, long accountId) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetSummonerByAccount(getConfig(), platform, accountId);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Get a summoner object for a given {@code summonerId}.
	 *
	 * @param platform
	 *            Platform where to retrieve the data.
	 * @param summonerId
	 *            Summoner ID associated with summoner to retrieve.
	 * @return The desired summoner
	 * @throws NullPointerException
	 *             If {@code platform} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see Summoner
	 */
	public Summoner getSummoner(Platform platform, long summonerId) throws RiotApiException {
		Objects.requireNonNull(platform);
		ApiMethod method = new GetSummoner(getConfig(), platform, summonerId);
		return endpointManager.callMethodAndReturnDto(method);
	}

	/**
	 * Get a single summoner object for a given {@code summonerName}.
	 *
	 * @param platform
	 *            Platform where to retrieve the data.
	 * @param summonerName
	 *            Summoner name associated with summoner to retrieve.
	 * @return Desired summoner
	 * @throws NullPointerException
	 *             If {@code platform} or {@code summonerName} is {@code null}
	 * @throws RiotApiException
	 *             If the API returns an error or unparsable result
	 * @version 3
	 * @see Summoner
	 */
	public Summoner getSummonerByName(Platform platform, String summonerName) throws RiotApiException {
		Objects.requireNonNull(platform);
		Objects.requireNonNull(summonerName);
		ApiMethod method = new GetSummonerByName(getConfig(), platform, summonerName);
		return endpointManager.callMethodAndReturnDto(method);
	}
}
