riot-api-java
=============

#riot-api-java (Version 1.0)

A simple to use, Riot Games API (Beta) wrapper for Java.

Version 1.0 of this library is available.

Tests, documentation, and a completed ReadMe will be available soon.
## Example

This library can be used strictly according to the [Riot API Documentation](https://developer.riotgames.com/api/methods) like so:


This library also provides the feature to be more laid back with requests. If you know you want your application to only cater to the North American region, you can set this region, and not have to pass it through every single request. Like so:

```java

	import dto.*;
	import main.java.riotapi.RiotAPI;
	

	public class Example {

		public static void main(String[] args) {
			
		RiotAPI riotAPI = new RiotAPI("na", "YOUR KEY GOES HERE");
		
			Summoner summoner = riotAPI.getSummoner("Taystee");
			long summonerId = summoner.getId();
		}

	}

```


```java

        import dto.*;
        import main.java.riotapi.RiotAPI;


        public class Example {

        	public static void main(String[] args) {
		
	        	RiotAPI riotAPI = new RiotAPI();
			riotAPI.setKey("YOUR KEY GOES HERE");
			riotAPI.setRegion("na");
		
			Summoner taystee = riotAPI.getSummoner("Taystee");
			Summoner skrumptious = riotAPI.getSummoner("Skrumptious");
			long summonerId = taystee.getId();
			long summonerId = skrumptious.getId();
		
		}

	}

```

## Downloads
[Download (Version 1.0)](https://www.dropbox.com/s/te7kxqqrhzsp60e/riot-api-java.jar)

Please note this library makes use of [gson](http://code.google.com/p/google-gson/)

Enjoy.

This product is not endorsed, certified or otherwise approved in any way by Riot Games, Inc. or any of its affiliates.
