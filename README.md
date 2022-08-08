# [RIOT-API-JAVA](https://taycaldwell.github.io/riot-api-java/)
----------
[![JitPack](https://img.shields.io/github/tag/rithms/riot-api-java.svg?label=maven)](https://jitpack.io/#taycaldwell/riot-api-java/4.3.0)
----------

A simple to use Riot Games API wrapper for Java.
This library makes it easy to gather and use League of Legends data in your apps.

**⚠️ Warning: This project has been archived and is no longer being maintained.**

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

This project is also available on [Jitpack](https://jitpack.io/#rithms/riot-api-java/4.3.0)

### Gradle

Add Jitpack to your root build.gradle at the end of repositories:

```java
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

Add the project as a dependency:

```java
dependencies {
	compile 'com.github.taycaldwell:riot-api-java:4.3.0'
}
```

### Maven

Add Jitpack as a repository:

```xml
<repositories>
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
</repositories>
```

Add the project as a dependency:

```xml
<dependency>
    <groupId>com.github.taycaldwell</groupId>
    <artifactId>riot-api-java</artifactId>
    <version>4.2.0</version>
</dependency>
```

## Usage

This library can be used strictly according to the [Riot API Documentation](https://developer.riotgames.com/api/methods) like so:

```java
import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;
import net.rithms.riot.constant.Platform;

/**
 * This example demonstrates using the RiotApi to request summoner information for a given summoner name
 */
public class SummonerExample {

	public static void main(String[] args) throws RiotApiException {
		ApiConfig config = new ApiConfig().setKey("YOUR-API-KEY-HERE");
		RiotApi api = new RiotApi(config);

		Summoner summoner = api.getSummonerByName(Platform.NA, "tryndamere");
		System.out.println("Name: " + summoner.getName());
		System.out.println("Summoner ID: " + summoner.getId());
		System.out.println("Account ID: " + summoner.getAccountId());
		System.out.println("PUUID: " + summoner.getPuuid());
		System.out.println("Summoner Level: " + summoner.getSummonerLevel());
		System.out.println("Profile Icon ID: " + summoner.getProfileIconId());
	}
}
```

It is important to be aware of your personal rate limit. Any method call from the Riot API is a request that counts towards your rate limit, except requests regarding static data which count toward a method rate limit but not toward your app rate limit. The below code makes 2 requests; one request for a summoner, and another for the match list of a summoner.

```java
import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.match.dto.MatchList;
import net.rithms.riot.api.endpoints.match.dto.MatchReference;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;
import net.rithms.riot.constant.Platform;

/**
 * This example demonstrates using the RiotApi to request the match list for a given summoner name and iterating over the match list
 */
public class MatchListExample {

	public static void main(String[] args) throws RiotApiException {
		ApiConfig config = new ApiConfig().setKey("YOUR-API-KEY-HERE");
		RiotApi api = new RiotApi(config);

		// First we need to request the summoner because we will need it's account ID
		Summoner summoner = api.getSummonerByName(Platform.NA, "tryndamere");

		// Then we can use the account ID to request the summoner's match list
		MatchList matchList = api.getMatchListByAccountId(Platform.NA, summoner.getAccountId());

		System.out.println("Total Games in requested match list: " + matchList.getTotalGames());

		// We can now iterate over the match list to access the data
		if (matchList.getMatches() != null) {
			for (MatchReference match : matchList.getMatches()) {
				System.out.println("GameID: " + match.getGameId());
			}
		}
	}
}
```

You can find these and more examples in the repository's directory "examples".

## Documentation
The documentation for this library can be found [here.](https://taycaldwell.github.io/riot-api-java/doc/)

## API Versions
The current version of this library supports the following Riot Games API versions:
- **CHAMPION-MASTERY-V4**
- **CHAMPION-V3**
- **LEAGUE-V4**
- **LOL-STATUS-V3**
- **MATCH-V4**
- **SPECTATOR-V4**
- **STATIC-DATA-V3** (deprecated)
- **SUMMONER-V4**
- **THIRD-PARTY-CODE-V4**
- **TOURNAMENT-V3**
- **TOURNAMENT-STUB-V4**

## Contributing
All contributions are appreciated.
If you would like to contribute to this project, please send a pull request.

## Contact
Have a suggestion, complaint, or question? Open an [issue](https://github.com/taycaldwell/riot-api-java/issues).
