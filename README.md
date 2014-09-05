# RIOT-API-JAVA

## Please note - Version 3.0 is still in the process of being updated. The fully updated library should be available by 09/05/14. - Rithms
-----------------------------

[![Build Status](https://travis-ci.org/rithms/riot-api-java.svg?branch=master)](https://travis-ci.org/rithms/riot-api-java)

A simple to use, Riot Games API (Beta) wrapper for Java.
This library makes it easy to gather and use League of Legends data in your Java code. :)

## Disclaimer
This product is not endorsed, certified or otherwise approved in any way by Riot Games, Inc. or any of its affiliates.

## Download
[Download (Version 3.0.0)]()

## Requirements

**riot-api-java** requires the following libraries:
- [Apache Commons IO 2.4](http://commons.apache.org/proper/commons-io/download_io.cgi)
- [Google Gson](https://code.google.com/p/google-gson/)

## Setup

[Download]() the .jar file, and add it as an external library to your project.

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
		
		Map<String, Summoner> summoners = riotAPI.getSummonersByName("na", "rithms, tryndamere");
		Summoner summoner = summoners.get("rithms");
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
		
		Map<String, Summoner> summoners = riotAPI.getSummonersByName("rithms, tryndamere");
		Summoner summoner = summoners.get("rithms");
		long id = summoner.getId();
	}
}

```


It is important to be aware of your personal rate limit. Any method call from the RiotAPI is a request that counts towards your rate limit, with exceptions to the accessors and mutators of region, key, and season. The below code makes 2 requests; one request for a summoner, and another for ranked stats of a summoner.



```java
import java.util.Map;
import com.google.gson*;
import org.apache.commons.io.IOUtils;

import dto.*;
import main.java.riotapi.RiotAPI;


public class Example {

	public static void main(String[] args) {
		
		RiotAPI riotAPI = new RiotAPI("YOUR KEY GOES HERE", "na");
		riotAPI.setSeason("SEASON3");
		
		RankedStats rankedStats = riotAPI.getRankedStats(riotAPI.getSummonersByName("rithms, tryndamere").get("rithms").getId());
	}
}

```

## Reference

### Strict API Methods


|Category|Method                                                                |Return Type              |
|--------|----------------------------------------------------------------------|-------------------------|
|Champion|`getChampions(String region, boolean freeToPlay)`                     |ChampionList             |
|Game    |`getRecentGames(String region, long summonerId)`                      |RecentGames              |
|League  |`getLeagues(String region, long summonerId)`                          |List<League>             |
|Stats   |`getPlayerStatsSummary(String region, long summonerId, String season)`|PlayerStatsSummaryList   |
|Stats   |`getRankedStats(String region, long summonerId, String season)`       |RankedStats              |
|Summoner|`getMasteryPages(String region, long summonerId)`                     |Map<String, MasteryPages>|
|Summoner|`getRunePages(String region, long summonerId)`                        |Map<String, RunePages>   |
|Summoner|`getSummonersByName(String region, String names)`                     |Map<String, Summoner>    |
|Summoner|`getSummonersById(String region, String summonerIds)`                 |Map<String, Summoner>    |
|Summoner|`getSummonerNames(String region, String summonerIds)`             	|Map<String, String>      |
|Team    |`getTeams(String region, long summonerId)`                            |List<Team>               |

Full documentation can be found [HERE](http://taycaldwell.github.io/riot-api-java/doc).

## API Versions
The current version of this library supports the following Riot Games API versions:
- **champion-v1.1 [EUNE, EUW, NA]**
- **game-v1.3 [EUNE, EUW, NA]**
- **league-v2.3 [BR, EUNE, EUW, NA, TR]**
- **stats-v1.2 [EUNE, EUW, NA]**
- **summoner-v1.3 [EUNE, EUW, NA]**
- **team-v2.2 [BR, EUNE, EUW, NA, TR]**

## Contributing
If you would like to contribute to this repo, please send a pull request.

##Discussion
Have a suggestion, complaint, or question? Head over to the [discussion board](), or send me an email (tcaldwel@nmsu.edu) for a quick response.
