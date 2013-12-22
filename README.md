riot-api-java
=============

A simple to use, Riot Games API (Beta) wrapper for Java.

Version 1.0 of this library is available.

Tests, documentation, and a completed ReadMe will be available soon.

## Setup

Download the .jar file, and add it as an external library to your project.

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


Available getter and setter methods also allow you to accomplish similar tasks in a different way.
Below is an example of how to set your region. Because the region was set before a method was called, there is no need to pass in the region parameter.


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


Object Oriented principles are also supported, but be aware of your personal rate limit. Any method call from the RiotAPI is a request that counts towards your rate limit.



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
