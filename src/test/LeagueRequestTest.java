package test;

import java.util.List;
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
		List<League> leagues = api.getLeagues(32581723);
	    Assert.assertNotNull(leagues);
	}
	
	@Test 
	public void testGetLeaguesValidSetRegionInvalidId()
	{    
		api.setRegion("na");
		List<League> leagues = api.getLeagues(36849083);
	    Assert.assertNull(leagues);
	}
	
	@Test 
	public void testGetLeaguesInvalidSetRegionValidId()
	{    
		api.setRegion("oc");
		List<League> leagues = api.getLeagues(32581723);
	    Assert.assertNull(leagues);
	}
	
	@Test 
	public void testGetLeaguesInvalidSetRegionInvalidId()
	{    
		api.setRegion("oc");
		List<League> leagues = api.getLeagues(36849083);
	    Assert.assertNull(leagues);
	}
	
	@Test 
	public void testGetLeaguesValidRegionValidId()
	{    
		List<League> leagues = api.getLeagues("euw", 32581723);
	    Assert.assertNotNull(leagues);
	}
	
	@Test 
	public void testGetLeaguesValidRegionInvalidId()
	{    
		List<League> leagues = api.getLeagues("na", 36849083);
	    Assert.assertNull(leagues);
	}
	
	@Test 
	public void testGetLeaguesInvalidRegionValidId()
	{    
		List<League> leagues = api.getLeagues("oc", 32581723);
	    Assert.assertNull(leagues);
	}
	
	@Test 
	public void testGetLeaguesInvalidRegionInvalidId()
	{    
		List<League> leagues = api.getLeagues("oc", 36849083);
	    Assert.assertNull(leagues);
	}
	
}



