package test;

import java.util.List;

import main.java.riotapi.RiotApi;
import dto.League.League;

import org.junit.*;

import constant.Region;

public class LeagueRequestTest
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
	public void testGetLeaguesValidSetRegionValidId()
	{    
		api.setRegion(Region.EUW);
		List<League> leagues = api.getLeagues(32581723);
	    Assert.assertNotNull(leagues);
	}
	
	@Test 
	public void testGetLeaguesValidSetRegionInvalidId()
	{    
		api.setRegion(Region.NA);
		List<League> leagues = api.getLeagues(36849083);
	    Assert.assertNull(leagues);
	}
	
	@Test 
	public void testGetLeaguesInvalidSetRegionValidId()
	{    
		api.setRegion(Region.OCE);
		List<League> leagues = api.getLeagues(32581723);
	    Assert.assertNull(leagues);
	}
	
	@Test 
	public void testGetLeaguesInvalidSetRegionInvalidId()
	{    
		api.setRegion(Region.OCE);
		List<League> leagues = api.getLeagues(36849083);
	    Assert.assertNull(leagues);
	}
	
	@Test 
	public void testGetLeaguesValidRegionValidId()
	{    
		List<League> leagues = api.getLeagues(Region.EUW, 32581723);
	    Assert.assertNotNull(leagues);
	}
	
	@Test 
	public void testGetLeaguesValidRegionInvalidId()
	{    
		List<League> leagues = api.getLeagues(Region.NA, 36849083);
	    Assert.assertNull(leagues);
	}
	
	@Test 
	public void testGetLeaguesInvalidRegionValidId()
	{    
		List<League> leagues = api.getLeagues(Region.OCE, 32581723);
	    Assert.assertNull(leagues);
	}
	
	@Test 
	public void testGetLeaguesInvalidRegionInvalidId()
	{    
		List<League> leagues = api.getLeagues(Region.OCE, 36849083);
	    Assert.assertNull(leagues);
	}
	
}



