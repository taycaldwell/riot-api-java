#RIOT-API-JAVA
--------------

A simple to use, Riot Games API (Beta) wrapper for Java.

##Requirements

riot-api-java requires the following libraries:
[Commons IO 2.4](http://commons.apache.org/proper/commons-io/download_io.cgi)
[Gson](https://code.google.com/p/google-gson/)

## Setup

[Download](https://dl.dropboxusercontent.com/s/te7kxqqrhzsp60e/riot-api-java.jar?dl=1&token_hash=AAHiCwTK9cGe-G-z5_4fmobXiEP5knAoJmhCTzUN96x7bw) the .jar file, and add it as an external library to your project.

If you are using Eclipse, this can be done by right clicking your project, and selecting:

Build Path -> Configure Build Path -> Libraries -> Add External Jars

and selecting the jar under the Order and Export tab.

## Usage

This library can be used strictly according to the [Riot API Documentation](https://developer.riotgames.com/api/methods) like so:

```java
import java.util.Map;
import com.google.gson*;
import org.apache.commons.io.IOUtils;

import main.java.riotapi.RiotAPI;
import dto.*;	

public class Example {

	public static void main(String[] args) {
			
		RiotAPI riotAPI = new RiotAPI("YOUR KEY GOES HERE");
		
		Map<String, Summoner> summoners = riotAPI.getSummonersByName("na", "taystee, frenchtoastkitty");
		Summoner summoner = summoners.get("taystee");
		long id = summoner.getId();
	}
}

```


Available accessors allow you to accomplish similar tasks in a different way.
Below is an example of how to set your region. Because the region was set before a method was called, there is no need to pass in the region parameter. This is great for people that know they will only be working in one region when making multiple requests. The same can be done for the season.


```java
import java.util.Map;
import com.google.gson*;
import org.apache.commons.io.IOUtils;

import dto.*;
import main.java.riotapi.RiotAPI;


public class Example {

	public static void main(String[] args) {
		
		RiotAPI riotAPI = new RiotAPI("YOUR KEY GOES HERE");
		riotAPI.setRegion("na");
		
		Map<String, Summoner> summoners = riotAPI.getSummonersByName("taystee, frenchtoastkitty");
		Summoner summoner = summoners.get("taystee");
		long id = summoner.getId();
	}
}

```


It is important to be aware of your personal rate limit. Any method call from the RiotAPI is a request that counts towards your rate limit, with exceptions to the accessors and mutators of region, key, and season. The below code makes 2 requests; one request for a summoner, and another for ranked stats of a summoner.



```java

import dto.*;
import main.java.riotapi.RiotAPI;


public class Example {

	public static void main(String[] args) {
		
		RiotAPI riotAPI = new RiotAPI("YOUR KEY GOES HERE", "na");
		riotAPI.setSeason("SEASON3");
		
		RankedStats rankedStats = riotAPI.getRankedStats(riotAPI.getSummonersByName("taystee, frenchtoastkitty").get("taystee").getId());
	}
}

```

## Reference

### Strict API Methods


|Category|Method                                                                |Return Type              |
|--------|----------------------------------------------------------------------|-------------------------|
|Champion|`getChampions(String region, boolean freeToPlay)`                     |ChampionList             |
|Game    |`getRecentGames(String region, long summonerId)`                      |RecentGames              |
|League  |`getLeagues(String region, long summonerId)`                          |Map<String, League>      |
|Stats   |`getPlayerStatsSummary(String region, long summonerId, String season)`|PlayerStatsSummaryList   |
|Stats   |`getRankedStats(String region, long summonerId, String season)`       |RankedStats              |
|Summoner|`getMasteryPages(String region, long summonerId)`                     |Map<String, MasteryPages>|
|Summoner|`getRunePages(String region, long summonerId)`                        |Map<String, RunePages>   |
|Summoner|`getSummonersByName(String region, String names)`                     |Map<String, Summoner>    |
|Summoner|`getSummonersById(String region, String summonerIds)`                 |Map<String, Summoner>    |
|Summoner|`getSummonerNames(String region, String summonerIds)`             	|Map<String, String>      |
|Team    |`getTeams(String region, long summonerId)`                            |List<Team>               |

Full documentation can be found [HERE](http://taycaldwell.github.io/riot-api-java/doc).

## Download
[Download (Version 2.2)](https://dl.dropboxusercontent.com/s/te7kxqqrhzsp60e/riot-api-java.jar?dl=1&token_hash=AAHiCwTK9cGe-G-z5_4fmobXiEP5knAoJmhCTzUN96x7bw)

## Contributing
If you would like to contribute to this repo, please send a pull request.

##Discussion
Have a suggestion, complaint, or question? Head over to the [discussion board](http://developer.riotgames.com/discussion/riot-games-api/show/aiuG9pfx), or send me an email (tcaldwel@nmsu.edu) for a quick response.

## Disclaimer
This product is not endorsed, certified or otherwise approved in any way by Riot Games, Inc. or any of its affiliates.
