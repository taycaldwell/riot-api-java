/*********************************
riot-api-java
----------------------------------
Riot Games API Java Library
by Taylor Caldwell - @rithms
----------------------------------
taycaldwell.com
********************************/

package main.java.riotapi;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import constant.QueueType;
import constant.Region;
import constant.Season;
import dto.Champion.*;
import dto.Game.RecentGames;
import dto.League.League;
import dto.Team.Team;
import dto.Stats.PlayerStatsSummaryList;
import dto.Stats.RankedStats;
import dto.Summoner.MasteryPages;
import dto.Summoner.RunePages;
import dto.Summoner.Summoner;

import org.apache.commons.io.IOUtils;

import method.*;

public class RiotApi {
	
	/**The base URL for all API requests*/
	private String endpoint = Region.GLOBAL.getEndpoint();

	private Region region; 
	private Season season;
	private String key;
	
	public RiotApi() {}

	public RiotApi(String key) {
		this.setKey(key);
	}
	
	public RiotApi(String key, Region region) {
		this.setKey(key);
		this.setRegion(region);
	}
	
	/**
	 * Get all the champions for a set region
	 * @return A list of all the champions for the set region
	 * @see ChampionList
	 */
	public ChampionList getChampions() {
		
		return ChampionMethod.getChampions(getEndpoint(), getRegion(), getKey());
	}
	
	/**
	 * Get all the champions for a given region
	 * @param region The desired region
	 * @return A list of all the champions for the set region
	 * @see ChampionList
	 */
	public ChampionList getChampions(Region region) {
	
		return ChampionMethod.getChampions(getEndpoint(), region.getName(), getKey());
	}
    
	/**
	 * Get all the champions for a set region
	 * @param freeToPlay Only free to play
	 * @return 
	 * A list of all the free to play champions for the set region when freeToPlay is true
	 * A list of all the champions for the set region when freeToPlay is false
	 * @see ChampionList
	 * 
	 */
	public ChampionList getChampions(boolean freeToPlay) {

		return ChampionMethod.getChampions(getEndpoint(), getRegion(), getKey(), freeToPlay);
	}
	
	/**
	 * Get all champions for a given region
	 * @param region The desired region
	 * @param freeToPlay Only free to play
	 * @return
	 * A list of all the free to play champions for the given region when freeToPlay is true
	 * A list of all the champions for the given region when freeToPlay is false
	 * @see ChampionList
	 */
	public ChampionList getChampions(Region region, boolean freeToPlay) {
		
		return ChampionMethod.getChampions(getEndpoint(), region.getName(), getKey(), freeToPlay);
	}
	
	/**
	 * Get all free to play champions for a given region
	 * @param region The desired region
	 * @return A list of all the free to play champions for the given region
	 * @see ChampionList
	 */
	public ChampionList getFreeToPlayChampions(Region region) {

		return ChampionMethod.getChampions(getEndpoint(), region.getName(), getKey(), true);
	}
	
	/**
	 * Get all free to play champions for a set region
	 * @return A list of all the free to play champions for the set region
	 * @see ChampionList
	 */
	public ChampionList getFreeToPlayChampions() {

		return ChampionMethod.getChampions(getEndpoint(), getRegion(), getKey(), true);
	}
	
	/**
	 * Get a champion by id for a given region
	 * @param region The desired region
	 * @param id The ID of the desired champion
	 * @return
	 * The champion of the given ID
	 * @see ChampionList
	 */
	public Champion getChampionById(Region region, int champId) {
		
		return ChampionMethod.getChampionById(getEndpoint(), region.getName(), getKey(), champId);
	}
	
	/**
	 * Get a champion by id for a set region
	 * @param id The ID of the desired champion
	 * @return
	 * The champion of the given ID
	 * @see ChampionList
	 */
	public Champion getChampionById(int champId) {
		
		return ChampionMethod.getChampionById(getEndpoint(), getRegion(), getKey(), champId);
	}
	
	/**
	* Get recent games for a given summoner
	* @param region The desired region
	* @param summonerId The ID of the desired summoner
	* @return Recent games of the given summoner
	* @see RecentGames
	*/
	public RecentGames getRecentGames(Region region, long summonerId) {
			
		return GameMethod.getRecentGames(getEndpoint(), region.getName(), getKey(), summonerId);
	}
		
	/**
	 * Get recent games for a given summoner
	 * @param summonerId The ID of the desired summoner
	 * @return Recent games of the given summoner
	 * @see RecentGames
	 */
	public RecentGames getRecentGames(long summonerId) {
			
		return GameMethod.getRecentGames(getEndpoint(), getRegion(), getKey(), summonerId);
	}
	
	/**
	 *
	 */
	public Map<String, List<League>> getLeagueBySummoners(Region region, long... summonerIds) {
			
		return LeagueMethod.getLeagueBySummoners(getEndpoint(), region.getName(), getKey(), summonerIds);
	}
	
	/**
	 *
	 */
	public Map<String, List<League>> getLeagueBySummoners(long... summonerIds) {
			
		return LeagueMethod.getLeagueBySummoners(getEndpoint(), getRegion(), getKey(), summonerIds);
	}
	
	/**
	 *
	 */
	public Map<String, List<League>> getLeagueEntryBySummoners(Region region, long... summonerIds) {
		
		return LeagueMethod.getLeagueEntryBySummoners(getEndpoint(), region.getName(), getKey(), summonerIds);
	}
	
	/**
	 *
	 */
	public Map<String, List<League>> getLeagueEntryBySummoners(long... summonerIds) {
		
		return LeagueMethod.getLeagueEntryBySummoners(getEndpoint(), getRegion(), getKey(), summonerIds);
	}
	
	/**
	 *
	 */
	public Map<String, List<League>> getLeagueBySummoners(Region region, String summonerIds) {
		
		return LeagueMethod.getLeagueBySummoners(getEndpoint(), region.getName(), getKey(), summonerIds);	
	}
	
	/**
	 *
	 */
	public Map<String, List<League>> getLeagueBySummoners(String summonerIds) {
		
		return LeagueMethod.getLeagueBySummoners(getEndpoint(), getRegion(), getKey(), summonerIds);	
	}
	
	/**
	 *
	 */
	public Map<String, List<League>> getLeagueEntryBySummoners(Region region, String summonerIds) {
		
		return LeagueMethod.getLeagueEntryBySummoners(getEndpoint(), region.getName(), getKey(), summonerIds);	
	}
	
	/**
	 *
	 */
	public Map<String, List<League>> getLeagueEntryBySummoners(String summonerIds) {
		
		return LeagueMethod.getLeagueEntryBySummoners(getEndpoint(), getRegion(), getKey(), summonerIds);	
	}
	
	/**
	 *
	 */
	public Map<String, List<League>> getLeagueByTeams(Region region, long... teamIds) {
		
		return LeagueMethod.getLeagueByTeams(getEndpoint(), region.getName(), getKey(), teamIds);	
	}
	
	/**
	 *
	 */
	public Map<String, List<League>> getLeagueByTeams(long... teamIds) {
		
		return LeagueMethod.getLeagueByTeams(getEndpoint(), getRegion(), getKey(), teamIds);	
	}
	
	/**
	 *
	 */
	public Map<String, List<League>> getLeagueEntryByTeams(Region region, long... teamIds) {
		
		return LeagueMethod.getLeagueEntryByTeams(getEndpoint(), region.getName(), getKey(), teamIds);	
	}
	
	/**
	 *
	 */
	public Map<String, List<League>> getLeagueEntryByTeams(long... teamIds) {
		
		return LeagueMethod.getLeagueEntryByTeams(getEndpoint(), getRegion(), getKey(), teamIds);	
	}
	
	/**
	 *
	 */
	public Map<String, List<League>> getLeagueByTeams(Region region, String teamIds) {
		
		return LeagueMethod.getLeagueByTeams(getEndpoint(), region.getName(), getKey(), teamIds);	
	}
	
	/**
	 *
	 */
	public Map<String, List<League>> getLeagueByTeams(String teamIds) {
		
		return LeagueMethod.getLeagueByTeams(getEndpoint(), getRegion(), getKey(), teamIds);	
	}
	
	/**
	 *
	 */
	public Map<String, List<League>> getLeagueEntryByTeams(Region region, String teamIds) {
		
		return LeagueMethod.getLeagueEntryByTeams(getEndpoint(), region.getName(), getKey(), teamIds);	
	}
	
	/**
	 *
	 */
	public Map<String, List<League>> getLeagueEntryByTeams(String teamIds) {
		
		return LeagueMethod.getLeagueEntryByTeams(getEndpoint(), getRegion(), getKey(), teamIds);	
	}
	
	/**
	 *
	 */
	public League getChallengerLeagues(Region region) {
		
		return LeagueMethod.getChallengerLeagues(getEndpoint(), region.getName(), getKey());	
	}
	
	/**
	 *
	 */
	public League getChallengerLeagues() {
		
		return LeagueMethod.getChallengerLeagues(getEndpoint(), getRegion(), getKey());	
	}
	
	/**
	 *
	 */
	public League getChallengerLeagues(Region region, QueueType queueType) {
		
		return LeagueMethod.getChallengerLeagues(getEndpoint(), region.getName(), getKey(), queueType);	
	}
	
	/**
	 *
	 */
	public League getChallengerLeagues(QueueType queueType) {
		
		return LeagueMethod.getChallengerLeagues(getEndpoint(), getRegion(), getKey(), queueType);	
	}
	
	/**
	 * Get a summary of player statistics for a given summoner
	 * @param region The desired region
	 * @param summonerId The ID of the desired summoner
	 * @param season The desired season
	 * @return A summary of player statistics for the given summoner
	 * @see PlayerStatsSummaryList
	 */
	public PlayerStatsSummaryList getPlayerStatsSummary(Region region, long summonerId, Season season) {
		
		return StatsMethod.getPlayerStatsSummary(getEndpoint(), region.getName(), season.getName(), getKey(), summonerId);
	}
	
	/**
	 * Get a summary of player statistics for a given summoner
	 * @param summonerId The ID of the desired summoner
	 * @param season The desired season
	 * @return A summary of player statistics for the given summoner
	 * @see PlayerStatsSummaryList
	 */
	public PlayerStatsSummaryList getPlayerStatsSummary(long summonerId, Season season) {
		
		return StatsMethod.getPlayerStatsSummary(getEndpoint(), getRegion(), season.getName(), getKey(), summonerId);
	}
	
	/**
	 * Get a summary of player statistics for a given summoner
	 * @param region The desired region
	 * @param summonerId The ID of the desired summoner
	 * @return A summary of player statistics for the given summoner
	 * @see PlayerStatsSummaryList
	 */
	public PlayerStatsSummaryList getPlayerStatsSummary(Region region, long summonerId) {
		
		return StatsMethod.getPlayerStatsSummary(getEndpoint(), region.getName(), getSeason(), getKey(), summonerId);
	}
	
	/**
	 * Get a summary of player statistics for a given summoner
	 * @param summonerId The ID of the desired summoner
	 * @return A summary of player statistics for the given summoner
	 * @see PlayerStatsSummaryList
	 */
	public PlayerStatsSummaryList getPlayerStatsSummary(long summonerId) {
		
		return StatsMethod.getPlayerStatsSummary(getEndpoint(), getRegion(), getSeason(), getKey(), summonerId);
	}
	
	/**
	 * Get the ranked statistics of a given summoner
	 * @param region The desired region
	 * @param summonerId The ID of the desired summoner
	 * @param season The desired season
	 * @return Ranked statistics of the given summoner
	 * @see RankedStats
	 */
	public RankedStats getRankedStats(Region region, long summonerId, Season season) {
		
		return StatsMethod.getRankedStats(getEndpoint(), region.getName(), season.getName(), getKey(), summonerId);
	}
	
	/**
	 * Get the ranked statistics of a given summoner
	 * @param summonerId The ID of the desired summoner
	 * @param season The desired season
	 * @return Ranked statistics of the given summoner
	 * @see RankedStats
	 */
	public RankedStats getRankedStats(long summonerId, Season season) {
		
		return StatsMethod.getRankedStats(getEndpoint(), getRegion(), season.getName(), getKey(), summonerId);
	}
	
	/**
	 * Get the ranked statistics of a given summoner
	 * @param region The desired region
	 * @param summonerId The ID of the desired summoner
	 * @return Ranked statistics of the given summoner
	 * @see RankedStats
	 */
	public RankedStats getRankedStats(Region region, long summonerId) {
		
		return StatsMethod.getRankedStats(getEndpoint(), region.getName(), getSeason(), getKey(), summonerId);
	}
	
	/**
	 * Get the ranked statistics of a given summoner
	 * @param summonerId The ID of the desired summoner
	 * @return Ranked statistics of the given summoner
	 * @see RankedStats
	 */
	public RankedStats getRankedStats(long summonerId) {
		
		return StatsMethod.getRankedStats(getEndpoint(), getRegion(), getSeason(), getKey(), summonerId);
	}
	
	/**
	 * Get the mastery pages of a given summoner
	 * @param region The desired region
	 * @param summonerIds The IDs of the desired summoners
	 * @return A map of mastery pages of the given summoners
	 * @see MasteryPages
	 */
	public Map<String, MasteryPages> getMasteryPages(Region region, String summonerIds) {
		
		return SummonerMethod.getMasteryPages(getEndpoint(), region.getName(), getKey(), summonerIds);
	}
	
	
	/**
	 * Get the mastery pages of a given summoner
	 * @param summonerIds The IDs of the desired summoners
	 * @return A map of mastery pages of the given summoners
	 * @see MasteryPages
	 */
	public Map<String, MasteryPages> getMasteryPages(String summonerIds) {
		
		return SummonerMethod.getMasteryPages(getEndpoint(), getRegion(), getKey(), summonerIds);
	}
	
	/**
	 * Get the mastery pages of a given summoner
	 * @param region The desired region
	 * @param summonerIds The IDs of the desired summoners
	 * @return A map of mastery pages of the given summoners
	 * @see MasteryPages
	 */
	public Map<String, MasteryPages> getMasteryPages(Region region, long... summonerIds) {
		
		return SummonerMethod.getMasteryPages(getEndpoint(), region.getName(), getKey(), summonerIds);
	}
	
	/**
	 * Get the mastery pages of a given summoner
	 * @param summonerIds The IDs of the desired summoners
	 * @return A map of mastery pages of the given summoners
	 * @see MasteryPages
	 */
	public Map<String, MasteryPages> getMasteryPages(long... summonerIds) {
		
		return SummonerMethod.getMasteryPages(getEndpoint(), getRegion(), getKey(), summonerIds);
	}
	
	
	/**
	 * Get the rune pages of a given summoner
	 * @param region The desired region
	 * @param summonerIds The IDs of the desired summoners
	 * @return A map of rune pages of the given summoners
	 * @see RunePages
	 */
	public Map<String, RunePages> getRunePages(Region region, String summonerIds) {
		
		return SummonerMethod.getRunePages(getEndpoint(), region.getName(), getKey(), summonerIds);
	}
	
	/**
	 * Get the rune pages of a given summoner
	 * @param summonerIds The IDs of the desired summoners
	 * @return A map of rune pages of the given summoners
	 * @see RunePages
	 */
	public Map<String, RunePages> getRunePages(String summonerIds) {
		
		return SummonerMethod.getRunePages(getEndpoint(), getRegion(), getKey(), summonerIds);
	}
	
	/**
	 * Get the rune pages of a given summoner
	 * @param region The desired region
	 * @param summonerIds The IDs of the desired summoners
	 * @return A map of rune pages of the given summoners
	 * @see RunePages
	 */
	public Map<String, RunePages> getRunePages(Region region, long... summonerIds) {
		
		return SummonerMethod.getRunePages(getEndpoint(), region.getName(), getKey(), summonerIds);
	}
	
	/**
	 * Get the rune pages of a given summoner
	 * @param summonerIds The IDs of the desired summoners
	 * @return A map of rune pages of the given summoners
	 * @see RunePages
	 */
	public Map<String, RunePages> getRunePages(long... summonerIds) {
		
		return SummonerMethod.getRunePages(getEndpoint(), getRegion(), getKey(), summonerIds);
	}
	
	/**
	 * Get summoners by names
	 * @param region The desired region
	 * @param summonerNames The names of the desired summoners
	 * @return A map of desired summoners
	 * @see Summoner
	 */
	public Map<String, Summoner> getSummonersByName(Region region, String summonerNames) {
		
		return SummonerMethod.getSummonerByName(getEndpoint(), region.getName(), getKey(), summonerNames);
	}
	
	/**
	 * Get summoners by names
	 * @param summonerNames The names of the desired summoners
	 * @return A map of desired summoners
	 * @see Summoner
	 */
	public Map<String, Summoner> getSummonersByName(String summonerNames) {
		
		return SummonerMethod.getSummonerByName(getEndpoint(), getRegion(), getKey(), summonerNames);
	}
	
	/**
	 * Get summoner by name
	 * @param region The desired region
	 * @param summonerName The name of the desired summoner
	 * @return A map of desired summoners
	 * @see Summoner
	 */
	public Map<String, Summoner> getSummonerByName(Region region, String summonerName) {
		
		return SummonerMethod.getSummonerByName(getEndpoint(), region.getName(), getKey(), summonerName);
	}
	
	/**
	 * Get summoner by name
	 * @param summonerName The name of the desired summoner
	 * @return A map of desired summoners
	 * @see Summoner
	 */
	public Map<String, Summoner> getSummonerByName(String summonerName) {
		
		return SummonerMethod.getSummonerByName(getEndpoint(), getRegion(), getKey(), summonerName);
	}
	
	/**
	 * Get summoners by names
	 * @param region The desired region
	 * @param summonerIds The IDs of the desired summoners
	 * @return A map of desired summoners
	 * @see Summoner
	 */
	public Map<String, Summoner> getSummonersById(Region region, long... summonerIds) {
			
		return SummonerMethod.getSummonersById(getEndpoint(), region.getName(), getKey(), summonerIds);
	}
	
	/**
	 * Get summoners by names
	 * @param summonerIds The IDs of the desired summoners
	 * @return A map of desired summoners
	 * @see Summoner
	 */
	public Map<String, Summoner> getSummonersById(long... summonerIds) {
		
		return SummonerMethod.getSummonersById(getEndpoint(), getRegion(), getKey(), summonerIds);
	}
	
	/**
	 * Get summoners by names
	 * @param region The desired region
	 * @param summonerIds The IDs of the desired summoners
	 * @return A map of desired summoners
	 * @see Summoner
	 */
	public Map<String, Summoner> getSummonersById(Region region, String summonerIds) {
		
		return SummonerMethod.getSummonerById(getEndpoint(), region.getName(), getKey(), summonerIds);
	}
	
	/**
	 * Get summoners by names
	 * @param summonerIds The IDs of the desired summoners
	 * @return A map of desired summoners
	 * @see Summoner
	 */
	public Map<String, Summoner> getSummonersById(String summonerIds) {
		
		return SummonerMethod.getSummonerById(getEndpoint(), getRegion(), getKey(), summonerIds);
	}
	
	/**
	 * Get summoners by names
	 * @param region The desired region
	 * @param summonerId The ID of the desired summoner
	 * @return A map of desired summoners
	 * @see Summoner
	 */
	public Map<String, Summoner> getSummonerById(Region region, long summonerId) {
			
		return SummonerMethod.getSummonerById(getEndpoint(), region.getName(), getKey(), summonerId);
	}
	
	/**
	 * Get summoners by names
	 * @param summonerId The IDs of the desired summoners
	 * @return A map of desired summoners
	 * @see Summoner
	 */
	public Map<String, Summoner> getSummonerById(long summonerId) {
		
		return SummonerMethod.getSummonerById(getEndpoint(), getRegion(), getKey(), summonerId);
	}
	
	/**
	 * Get summoners by names
	 * @param region The desired region
	 * @param summonerIds The IDs of the desired summoners
	 * @return A map of desired summoners
	 * @see Summoner
	 */
	public Map<String, Summoner> getSummonerById(Region region, String summonerId) {
		
		return SummonerMethod.getSummonerById(getEndpoint(), region.getName(), getKey(), summonerId);
	}
	
	/**
	 * Get summoners by names
	 * @param summonerId The IDs of the desired summoners
	 * @return A map of desired summoners
	 * @see Summoner
	 */
	public Map<String, Summoner> getSummonerById(String summonerId) {
		
		return SummonerMethod.getSummonerById(getEndpoint(), getRegion(), getKey(), summonerId);
	}
	
	/**
	 * Get summoner names by IDs
	 * @param region The desired region
	 * @param summonerIds The IDs of the desired summoners
	 * @return A map of desired summoner names
	 */
	public Map<String, String> getSummonerNames(Region region, long... summonerIds){
	
		return SummonerMethod.getSummonerNames(getEndpoint(), region.getName(), getKey(), summonerIds);
	}
	
	/**
	 * Get summoner names by IDs
	 * @param summonerIds The IDs of the desired summoners
	 * @return A map of desired summoner names
	 */
	public Map<String, String> getSummonerNames(long... summonerIds){
	
		return SummonerMethod.getSummonerNames(getEndpoint(), getRegion(), getKey(), summonerIds);
	}
	
	/**
	 * Get summoner names by IDs
	 * @param region The desired region
	 * @param summonerIds A comma separated list of IDs of the desired summoners
	 * @return A map of desired summoner names
	 */
	public Map<String, String> getSummonerNames(Region region, String summonerIds){
		
		return SummonerMethod.getSummonerName(getEndpoint(), region.getName(), getKey(), summonerIds);
	}
	
	/**
	 * Get summoner names by IDs
	 * @param summonerIds A comma separated list of IDs of the desired summoners
	 * @return A map of desired summoner names
	 */
	public Map<String, String> getSummonerNames(String summonerIds){
		
		return SummonerMethod.getSummonerName(getEndpoint(), getRegion(), getKey(), summonerIds);
	}
	
	/**
	 * Get summoner names by IDs
	 * @param region The desired region
	 * @param summonerId The IDs of the desired summoner
	 * @return A map of desired summoner names
	 */
	public Map<String, String> getSummonerName(Region region, long summonerId){
	
		return SummonerMethod.getSummonerName(getEndpoint(), region.getName(), getKey(), summonerId);
	}
	
	/**
	 * Get summoner names by IDs
	 * @param summonerId The IDs of the desired summoner
	 * @return A map of desired summoner names
	 */
	public Map<String, String> getSummonerName(long summonerId){
	
		return SummonerMethod.getSummonerName(getEndpoint(), getRegion(), getKey(), summonerId);
	}
	
	/**
	 * Get summoner names by IDs
	 * @param region The desired region
	 * @param summonerId The ID of the desired summoner
	 * @return A map of desired summoner names
	 */
	public Map<String, String> getSummonerName(Region region, String summonerId){
		
		return SummonerMethod.getSummonerName(getEndpoint(), region.getName(), getKey(), summonerId);
	}
	
	/**
	 * Get summoner names by IDs
	 * @param summonerIds The ID of the desired summoner
	 * @return A map of desired summoner names
	 */
	public Map<String, String> getSummonerName(String summonerId){
		
		return SummonerMethod.getSummonerName(getEndpoint(), getRegion(), getKey(), summonerId);
	}
	
	/**
	 * Get teams of a given summoner
	 * @param region The desired region
	 * @param summonerId The ID of the desired summoner
	 * @return The teams the given summoner is a member of
	 * @see Team
	 */
	public List<Team> getTeams(Region region, long summonerId){
		
		String url = getEndpoint() + region.getName() + "/v2.2/team/by-summoner/" + summonerId + "?api_key=" + getKey();
		List<Team> teamList = null;

			try {
				teamList = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<List<Team>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
	
	    return teamList;
	}
	
	/**
	 * Get teams of a given summoner
	 * @param summonerId The desired summoner
	 * @return The teams the given summoner is a member of
	 * @see Team
	 */
	public List<Team> getTeams(long summonerId){
		
		String url = getEndpoint() + getRegion() + "/v2.2/team/by-summoner/" + summonerId + "?api_key=" + getKey();
		List<Team> teamList = null;

			try {
				teamList = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<List<Team>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
	
	    return teamList;
	}
	
	/**
	 * Get the currently set season
	 * @return The currently set season
	 * @throws Exception 
	 */
	public String getSeason() {
		return season.getName();
	}
	
	/**
	 * Get the currently set API key
	 * @return The currently set API key
	 * @throws Exception 
	 */
	public String getKey() {
		return key;
	}
	
	/**
	 * Get the currently set region
	 * @return The currently set region
	 * @throws Exception 
	 */
	public String getRegion() {
		return region.getName();
	}
	
	/**
	 * Set the season
	 * @param season The season to set
	 */
	public void setSeason(Season season) {
		this.season = season;
	}
	
	/**
	 * Set the API key
	 * @param key The API key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
	
	/**
	 * Set the region
	 * @param region The region to set
	 */
	public void setRegion(Region region) {
		this.region = region;
		setEndpoint();
	}
	
	/**
	 * Get the base URL for all API requests
	 * @return The base URL for all API requests
	 */
	public String getEndpoint() {
		return endpoint;
	}
	
	private void setEndpoint() {
		this.endpoint = region.getEndpoint();
	}

}
