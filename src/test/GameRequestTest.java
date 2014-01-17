package test;

import main.java.riotapi.RiotAPI;
import dto.*;
import org.junit.*;

public class GameRequestTest
{
	
	private RiotAPI api;

	@Before 
	public void setup()
	{
	   System.out.println("\nTest starting...");
	   api = new RiotAPI("YOUR-API-KEY");
	}

	@After 
	public void teardown()
	{
	   System.out.println("\nTest finished.");
	}

	@Test 
	public void testGetRecentGamesValidSetRegionValidId()
	{    
		api.setRegion("na");
		RecentGames games = api.getRecentGames(26120541);
	    Assert.assertNotNull(games);
	}
	
	@Test 
	public void testGetRecentGamesValidSetRegionInvalidId()
	{    
		api.setRegion("na");
		RecentGames games = api.getRecentGames(36849083);
	    Assert.assertNull(games);
	}
	
	@Test 
	public void testGetRecentGamesInvalidSetRegionValidId()
	{    
		api.setRegion("tr");
		RecentGames games = api.getRecentGames(26120541);
	    Assert.assertNull(games);
	}
	
	@Test 
	public void testGetRecentGamesInvalidSetRegionInvalidId()
	{    
		api.setRegion("tr");
		RecentGames games = api.getRecentGames(36849083);
	    Assert.assertNull(games);
	}
	
	@Test 
	public void testGetRecentGamesValidRegionValidId()
	{    
		RecentGames games = api.getRecentGames("na", 26120541);
	    Assert.assertNotNull(games);
	}
	
	@Test 
	public void testGetRecentGamesValidRegionInvalidId()
	{    
		RecentGames games = api.getRecentGames("na", 36849083);
	    Assert.assertNull(games);
	}
	
	@Test 
	public void testGetRecentGamesInvalidRegionValidId()
	{    
		RecentGames games = api.getRecentGames("tr", 26120541);
	    Assert.assertNull(games);
	}
	
	@Test 
	public void testGetRecentGamesInvalidRegionInvalidId()
	{    
		RecentGames games = api.getRecentGames("tr", 36849083);
	    Assert.assertNull(games);
	}
}



