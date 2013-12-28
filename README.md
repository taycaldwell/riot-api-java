riot-api-java
=============

A simple to use, Riot Games API (Beta) wrapper for Java.

## Setup

[Download](https://dl.dropboxusercontent.com/s/te7kxqqrhzsp60e/riot-api-java.jar?dl=1&token_hash=AAHiCwTK9cGe-G-z5_4fmobXiEP5knAoJmhCTzUN96x7bw) the .jar file, and add it as an external library to your project.

If you are using Eclipse, this can be done by right clicking your project, and selecting:

Build Path -> Configure Build Path -> Libraries -> Add External Jars

and selecting the jar under the Order and Export tab.

## Usage

This library can be used strictly according to the [Riot API Documentation](https://developer.riotgames.com/api/methods) like so:

```java

import dto.*;
import main.java.riotapi.RiotAPI;
	

public class Example {

	public static void main(String[] args) {
			
		RiotAPI riotAPI = new RiotAPI("YOUR KEY GOES HERE");
		
		Summoner summoner = riotAPI.getSummoner("na", "Taystee");
		long summonerId = summoner.getId();
	}
}

```


Available accessors allow you to accomplish similar tasks in a different way.
Below is an example of how to set your region. Because the region was set before a method was called, there is no need to pass in the region parameter. This is great for people that know they will only be working in one region when making multiple requests. The same can be done for the season.


```java

import dto.*;
import main.java.riotapi.RiotAPI;


public class Example {

	public static void main(String[] args) {
		
		RiotAPI riotAPI = new RiotAPI("YOUR KEY GOES HERE");
		riotAPI.setRegion("na");
		
		Summoner summoner = riotAPI.getSummoner("Taystee");
		long summonerId = summoner.getId();
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
		
		RankedStats rankedStats = riotAPI.getRankedStats(riotAPI.getSummoner("Taystee").getId());
	}
}

```

## Reference

### Strict API Methods


|Category|Method                                                                |Return Type           |
|--------|----------------------------------------------------------------------|----------------------|
|Champion|`getChampions(String region, boolean freeToPlay)`                     |ChampionList          |
|Game    |`getRecentGames(String region, long summonerId)`                      |RecentGames           |
|League  |`getLeagues(String region, long summonerId)`                          |Map<String, League>   |
|Stats   |`getPlayerStatsSummary(String region, long summonerId, String season)`|PlayerStatsSummaryList|
|Stats   |`getRankedStats(String region, long summonerId, String season)`       |RankedStats           |
|Summoner|`getMasteryPages(String region, long summonerId)`                     |MasteryPages          |
|Summoner|`getRunePages(String region, long summonerId)`                        |RunePages             |
|Summoner|`getSummoner(String region, String name)`                             |Summoner              |
|Summoner|`getSummoner(String region, long summonerId)`                         |Summoner              |
|Summoner|`getSummonerNames(String region, long... summonerIds)`             |SummonerNameList      |
|Team    |`getTeams(String region, long summonerId)`                            |List<Team>            |

Full documentation can be found [HERE](http://taycaldwell.github.io/riot-api-java/doc).

## Downloads
[Download (Version 2.0)](https://dl.dropboxusercontent.com/s/te7kxqqrhzsp60e/riot-api-java.jar?dl=1&token_hash=AAHiCwTK9cGe-G-z5_4fmobXiEP5knAoJmhCTzUN96x7bw)

## Contributing
If you would like to contribute to this repo, please send a pull request.

## Disclaimer
This product is not endorsed, certified or otherwise approved in any way by Riot Games, Inc. or any of its affiliates.
