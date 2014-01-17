package test;

import main.java.riotapi.RiotAPI;
import dto.*;

import org.junit.*;

public class RankedStatsRequestTest
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
	public void testGetRankedStatsValidRegionValidIdValidSeason()
	{    
		RankedStats stats = api.getRankedStats("euw", 32581723, "SEASON4");
	    Assert.assertNotNull(stats);
	}
	
	@Test 
	public void testGetRankedStatsInvalidRegionValidIdValidSeason()
	{    
		RankedStats stats = api.getRankedStats("tr", 32581723, "SEASON4");
	    Assert.assertNull(stats);
	}
	
	@Test 
	public void testGetRankedStatsValidRegionInvalidIdValidSeason()
	{    
		RankedStats stats = api.getRankedStats("euw", 99999999, "SEASON4");
	    Assert.assertNull(stats);
	}
	
	@Test 
	public void testGetRankedStatsValidRegionValidIdInvalidSeason()
	{    
		RankedStats stats = api.getRankedStats("euw", 32581723, "SEASON99");
	    Assert.assertNull(stats);
	}
	
	@Test 
	public void testGetRankedStatsSetValidRegionValidIdValidSeason()
	{   
		api.setRegion("euw");
		RankedStats stats = api.getRankedStats(32581723, "SEASON4");
	    Assert.assertNotNull(stats);
	}
	
	@Test 
	public void testGetRankedStatsSetInvalidRegionValidIdValidSeason()
	{    
		api.setRegion("tr");
		RankedStats stats = api.getRankedStats(32581723, "SEASON4");
	    Assert.assertNull(stats);
	}

	@Test 
	public void testGetRankedStatsValidRegionValidIdSetValidSeason()
	{    
		api.setSeason("SEASON4");
		RankedStats stats = api.getRankedStats("euw", 32581723);
	    Assert.assertNotNull(stats);
	}
	
	@Test 
	public void testGetRankedStatsValidRegionValidIdSetInvalidSeason()
	{    
		api.setSeason("SEASON99");
		RankedStats stats = api.getRankedStats("euw", 32581723);
	    Assert.assertNull(stats);
	}
	
	@Test 
	public void testGetRankedStatsSetValidRegionValidIdSetValidSeason()
	{    
		api.setSeason("SEASON4");
		api.setRegion("euw");
		RankedStats stats = api.getRankedStats(32581723);
	    Assert.assertNotNull(stats);
	}
	
}



