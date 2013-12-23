riot-api-java
=============

A simple to use, Riot Games API (Beta) wrapper for Java.

## Setup

[Download](https://www.dropbox.com/s/te7kxqqrhzsp60e/riot-api-java.jar) the .jar file, and add it as an external library to your project.

If you are using Eclipse, this can be done by right clicking your project, and selecting:

Build Path -> Configure Build Path -> Libraries -> Add External Jars

and selecting the jar under the Order and Export tab.

## Examples

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
Below is an example of how to set your region. Because the region was set before a method was called, there is no need to pass in the region parameter. This is great for the lazy programmer that knows they will only be working in one region when making multiple requests. The same can be done for the season.


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


## Downloads
[Download (Version 1.0)](https://www.dropbox.com/s/te7kxqqrhzsp60e/riot-api-java.jar)

## Contributing
If you would like to contribute to this repo, please send a pull request.

## Disclaimer
This product is not endorsed, certified or otherwise approved in any way by Riot Games, Inc. or any of its affiliates.
