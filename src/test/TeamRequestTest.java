package test;

import java.util.List;

import main.java.riotapi.RiotAPI;
import dto.*;

import org.junit.*;

public class TeamRequestTest
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
	public void testGetTeamsValidRegionValidID()
	{    
		List<Team> teams = api.getTeams("na", 20714655);
	    Assert.assertNotNull(teams);
	}
	
	@Test 
	public void testGetTeamsValidRegionInvalidID()
	{    
		List<Team> teams = api.getTeams("na", 9999999);
	    Assert.assertNull(teams);
	}
	
	@Test 
	public void testGetTeamsInvalidRegionValidID()
	{    
		List<Team> teams = api.getTeams("oc", 20714655);
	    Assert.assertNull(teams);
	}
	
	@Test 
	public void testGetTeamValidSetRegionValidID()
	{    
		api.setRegion("na");
		List<Team> teams = api.getTeams(20714655);
	    Assert.assertNotNull(teams);
	}
	
	@Test 
	public void testGetTeamInvalidSetRegionValidID()
	{    
		api.setRegion("oc");
		List<Team> teams = api.getTeams(20714655);
	    Assert.assertNull(teams);
	}
	
	@Test 
	public void testGetTeamValidSetRegionInvalidID()
	{    
		api.setRegion("na");
		List<Team> teams = api.getTeams(99999999);
	    Assert.assertNull(teams);
	}
}



