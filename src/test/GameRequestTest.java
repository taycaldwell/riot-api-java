package test;

import main.java.riotapi.RiotApi;
import dto.Game.RecentGames;

import org.junit.*;

import constant.Region;

public class GameRequestTest
{
	
	private RiotApi api;

	@Before 
	public void setup()
	{
	   System.out.println("\nTest starting...");
	   api = new RiotApi("YOUR-API-KEY");
	}

	@After 
	public void teardown()
	{
	   System.out.println("\nTest finished.");
	}

	@Test 
	public void testGetRecentGamesValidSetRegionValidId()
	{    
		api.setRegion(Region.NA);
		RecentGames games = api.getRecentGames(26120541);
	    Assert.assertNotNull(games);
	}
	
	@Test 
	public void testGetRecentGamesValidSetRegionInvalidId()
	{    
		api.setRegion(Region.NA);
		RecentGames games = api.getRecentGames(36849083);
	    Assert.assertNull(games);
	}
	
	@Test 
	public void testGetRecentGamesInvalidSetRegionValidId()
	{    
		api.setRegion(Region.TR);
		RecentGames games = api.getRecentGames(26120541);
	    Assert.assertNull(games);
	}
	
	@Test 
	public void testGetRecentGamesInvalidSetRegionInvalidId()
	{    
		api.setRegion(Region.TR);
		RecentGames games = api.getRecentGames(36849083);
	    Assert.assertNull(games);
	}
	
	@Test 
	public void testGetRecentGamesValidRegionValidId()
	{    
		RecentGames games = api.getRecentGames(Region.NA, 26120541);
	    Assert.assertNotNull(games);
	}
	
	@Test 
	public void testGetRecentGamesValidRegionInvalidId()
	{    
		RecentGames games = api.getRecentGames(Region.NA, 36849083);
	    Assert.assertNull(games);
	}
	
	@Test 
	public void testGetRecentGamesInvalidRegionValidId()
	{    
		RecentGames games = api.getRecentGames(Region.TR, 26120541);
	    Assert.assertNull(games);
	}
	
	@Test 
	public void testGetRecentGamesInvalidRegionInvalidId()
	{    
		RecentGames games = api.getRecentGames(Region.TR, 36849083);
	    Assert.assertNull(games);
	}
}



