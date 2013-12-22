riot-api-java
=============

A simple to use, Riot Games API (Beta) wrapper for Java.

Version 1.0 of this library is available.

Tests, documentation, and a completed ReadMe will be available soon.
## Example

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
		
			Summoner taystee = riotAPI.getSummoner("Taystee");
			long summonerId = taystee.getId();
			
		
		}

	}

```

## Downloads
[Download (Version 1.0)](https://www.dropbox.com/s/te7kxqqrhzsp60e/riot-api-java.jar)

Please note this library makes use of [gson](http://code.google.com/p/google-gson/)

Enjoy.

This product is not endorsed, certified or otherwise approved in any way by Riot Games, Inc. or any of its affiliates.
