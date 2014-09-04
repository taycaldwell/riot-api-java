package test;

import main.java.riotapi.RiotApi;
import dto.Stats.PlayerStatsSummaryList;

import org.junit.*;

import constant.Region;
import constant.Season;

public class StatsSummaryRequestTest
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
	public void testGetPlayerStatsSummaryValidRegionValidIdValidSeason()
	{    
		PlayerStatsSummaryList stats = api.getPlayerStatsSummary(Region.EUW, 32581723, Season.FOUR);
	    Assert.assertNotNull(stats);
	}
	
	@Test 
	public void testGetPlayerStatsSummaryInvalidRegionValidIdValidSeason()
	{    
		PlayerStatsSummaryList stats = api.getPlayerStatsSummary(Region.TR, 32581723, Season.FOUR);
	    Assert.assertNull(stats);
	}
	
	@Test 
	public void testGetPlayerStatsSummaryValidRegionInvalidIdValidSeason()
	{    
		PlayerStatsSummaryList stats = api.getPlayerStatsSummary(Region.EUW, 99999999, Season.FOUR);
	    Assert.assertNull(stats);
	}
	
	//
	@Test 
	public void testGetPlayerStatsSummarySetValidRegionValidIdValidSeason()
	{   
		api.setRegion(Region.EUW);
		PlayerStatsSummaryList stats = api.getPlayerStatsSummary(32581723, Season.FOUR);
	    Assert.assertNotNull(stats);
	}
	
	@Test 
	public void testGetPlayerStatsSummarySetInvalidRegionValidIdValidSeason()
	{    
		api.setRegion(Region.TR);
		PlayerStatsSummaryList stats = api.getPlayerStatsSummary(32581723, Season.FOUR);
	    Assert.assertNull(stats);
	}
	
	//
	@Test 
	public void testGetPlayerStatsSummaryValidRegionValidIdSetValidSeason()
	{    
		api.setSeason(Season.FOUR);
		PlayerStatsSummaryList stats = api.getPlayerStatsSummary(Region.EUW, 32581723);
	    Assert.assertNotNull(stats);
	}
	
	//
	@Test 
	public void testGetPlayerStatsSummarySetValidRegionValidIdSetValidSeason()
	{    
		api.setSeason(Season.FOUR);
		api.setRegion(Region.EUW);
		PlayerStatsSummaryList stats = api.getPlayerStatsSummary(32581723);
	    Assert.assertNotNull(stats);
	}
}