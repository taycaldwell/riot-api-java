# [RIOT-API-JAVA](http://taycaldwell.com/riot-api-java/)
----------
[![JitPack](https://img.shields.io/github/tag/rithms/riot-api-java.svg?label=maven)](https://jitpack.io/#rithms/riot-api-java/v3.9.0)
----------

A simple to use, Riot Games API wrapper for Java.
This library makes it easy to gather and use League of Legends data in your apps.

## Disclaimer
This product is not endorsed, certified or otherwise approved in any way by Riot Games, Inc. or any of its affiliates.

## Requirements

**riot-api-java** requires Java 7 and the following libraries:
- [Google Gson](https://code.google.com/p/google-gson/)

## Setup

[Download](https://github.com/taycaldwell/riot-api-java/releases) the .jar file, and add it as an external library to your project.

If you are using Eclipse, this can be done by right clicking your project, and selecting:

Build Path -> Configure Build Path -> Libraries -> Add External Jars

and selecting the jar under the Order and Export tab.


This project is also available on [Jitpack](https://jitpack.io/#rithms/riot-api-java/v3.9.0)

## Usage

This library can be used strictly according to the [Riot API Documentation](https://developer.riotgames.com/api/methods) like so:

```java
import java.util.Map;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Summoner.Summoner;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import com.google.gson*;

public class Example {

	public static void main(String[] args) throws RiotApiException {
		
		RiotApi api = new RiotApi("YOUR-API-KEY-HERE");

		Map<String, Summoner> summoners = api.getSummonersByName(Region.NA, "rithms, tryndamere");
		Summoner summoner = summoners.get("rithms");
		long id = summoner.getId();
		System.out.println(id);
	}

}

```


Available accessors allow you to accomplish similar tasks in a different way.
Below is an example of how to set your region. Because the region was set before a method was called, there is no need to pass in the region parameter. This is great for people that know they will only be working in one region when making multiple requests. The same can be done for the season.


```java
import java.util.Map;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Summoner.Summoner;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import com.google.gson*;

public class Example {

	public static void main(String[] args) throws RiotApiException {
		
		RiotApi api = new RiotApi("YOUR-API-KEY-HERE");
		
		api.setRegion(Region.NA);
		Map<String, Summoner> summoners = api.getSummonersByName("rithms, tryndamere");
		Summoner summoner = summoners.get("rithms");
		long id = summoner.getId();
		System.out.println(id);
	}

}

```


It is important to be aware of your personal rate limit. Any method call from the RiotAPI is a request that counts towards your rate limit, except any requests regarding static data. The below code makes 2 requests; one request for a summoner, and another for ranked stats of a summoner.



```java
import net.rithms.riot.constant.Region;
import net.rithms.riot.constant.Season;
import net.rithms.riot.dto.Stats.RankedStats;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import com.google.gson*;

public class Example {

	public static void main(String[] args) throws RiotApiException {
		
		RiotApi api = new RiotApi("YOUR-API-KEY-HERE", Region.NA);
		api.setSeason(Season.CURRENT);
		
		RankedStats rankedStats = api.getRankedStats(api.getSummonerByName("rithms").getId());
	}

}

```

## Documentation
The documentation for this library can be found [here.](http://taycaldwell.com/riot-api-java/doc/)

## API Versions
The current version of this library supports the following Riot Games API versions:
- **CHAMPION-MASTERY-V3**
- **CHAMPION-V3**
- **LEAGUE-V3**
- **LOL-STATUS-V3**
- **MASTERIES-V3**
- **MATCH-V3**
- **RUNES-V3**
- **SPECTATOR-V3**
- **STATIC-DATA-V3**
- **SUMMONER-V3**
- **TOURNAMENT-V3**
- **TOURNAMENT-STUB-V3**

## Contributing
All contributions are appreciated.
If you would like to contribute to this project, please send a pull request.

## Contact
Have a suggestion, complaint, or question? Open an [issue](https://github.com/taycaldwell/riot-api-java/issues).
