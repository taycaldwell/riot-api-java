package test;

import java.util.Map;

import main.java.riotapi.RiotAPI;
import dto.*;

import org.junit.*;

public class LeagueRequestTest
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
	public void testGetLeaguesValidSetRegionValidId()
	{    
		api.setRegion("euw");
		Map<String, League> leagues = api.getLeagues(32581723);
	    Assert.assertNotNull(leagues);
	}
	
	@Test 
	public void testGetLeaguesValidSetRegionInvalidId()
	{    
		api.setRegion("na");
		Map<String, League> leagues = api.getLeagues(36849083);
	    Assert.assertNull(leagues);
	}
	
	@Test 
	public void testGetLeaguesInvalidSetRegionValidId()
	{    
		api.setRegion("oc");
		Map<String, League> leagues = api.getLeagues(32581723);
	    Assert.assertNull(leagues);
	}
	
	@Test 
	public void testGetLeaguesInvalidSetRegionInvalidId()
	{    
		api.setRegion("oc");
		Map<String, League> leagues = api.getLeagues(36849083);
	    Assert.assertNull(leagues);
	}
	
	@Test 
	public void testGetLeaguesValidRegionValidId()
	{    
		Map<String, League> leagues = api.getLeagues("euw", 32581723);
	    Assert.assertNotNull(leagues);
	}
	
	@Test 
	public void testGetLeaguesValidRegionInvalidId()
	{    
		Map<String, League> leagues = api.getLeagues("na", 36849083);
	    Assert.assertNull(leagues);
	}
	
	@Test 
	public void testGetLeaguesInvalidRegionValidId()
	{    
		Map<String, League> leagues = api.getLeagues("oc", 32581723);
	    Assert.assertNull(leagues);
	}
	
	@Test 
	public void testGetLeaguesInvalidRegionInvalidId()
	{    
		Map<String, League> leagues = api.getLeagues("oc", 36849083);
	    Assert.assertNull(leagues);
	}
	
}



