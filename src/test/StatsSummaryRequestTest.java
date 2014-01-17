package test;

import main.java.riotapi.RiotAPI;
import dto.*;

import org.junit.*;

public class StatsSummaryRequestTest
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
	public void testGetPlayerStatsSummaryValidRegionValidIdValidSeason()
	{    
		PlayerStatsSummaryList stats = api.getPlayerStatsSummary("euw", 32581723, "SEASON4");
	    Assert.assertNotNull(stats);
	}
	
	@Test 
	public void testGetPlayerStatsSummaryInvalidRegionValidIdValidSeason()
	{    
		PlayerStatsSummaryList stats = api.getPlayerStatsSummary("tr", 32581723, "SEASON4");
	    Assert.assertNull(stats);
	}
	
	@Test 
	public void testGetPlayerStatsSummaryValidRegionInvalidIdValidSeason()
	{    
		PlayerStatsSummaryList stats = api.getPlayerStatsSummary("euw", 99999999, "SEASON4");
	    Assert.assertNull(stats);
	}
	
	@Test 
	public void testGetPlayerStatsSummaryValidRegionValidIdInvalidSeason()
	{    
		PlayerStatsSummaryList stats = api.getPlayerStatsSummary("euw", 32581723, "SEASON99");
	    Assert.assertNull(stats);
	}
	
	//
	@Test 
	public void testGetPlayerStatsSummarySetValidRegionValidIdValidSeason()
	{   
		api.setRegion("euw");
		PlayerStatsSummaryList stats = api.getPlayerStatsSummary(32581723, "SEASON4");
	    Assert.assertNotNull(stats);
	}
	
	@Test 
	public void testGetPlayerStatsSummarySetInvalidRegionValidIdValidSeason()
	{    
		api.setRegion("tr");
		PlayerStatsSummaryList stats = api.getPlayerStatsSummary(32581723, "SEASON4");
	    Assert.assertNull(stats);
	}
	
	//
	@Test 
	public void testGetPlayerStatsSummaryValidRegionValidIdSetValidSeason()
	{    
		api.setSeason("SEASON4");
		PlayerStatsSummaryList stats = api.getPlayerStatsSummary("euw", 32581723);
	    Assert.assertNotNull(stats);
	}
	
	
	@Test 
	public void testGetPlayerStatsSummaryValidRegionValidIdSetInvalidSeason()
	{    
		api.setSeason("SEASON99");
		PlayerStatsSummaryList stats = api.getPlayerStatsSummary("euw", 32581723);
	    Assert.assertNull(stats);
	}
	
	//
	@Test 
	public void testGetPlayerStatsSummarySetValidRegionValidIdSetValidSeason()
	{    
		api.setSeason("SEASON4");
		api.setRegion("euw");
		PlayerStatsSummaryList stats = api.getPlayerStatsSummary(32581723);
	    Assert.assertNotNull(stats);
	}
}