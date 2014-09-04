package test;

import java.util.List;

import main.java.riotapi.RiotApi;
import dto.Team.Team;

import org.junit.*;

import constant.Region;

public class TeamRequestTest
{
	
	private RiotApi api;

	@Before 
	public void setup()
	{
	   System.out.println("\nTest starting...");
	   api = new RiotApi("9fe7219e-190c-4fb1-b1d1-bdc501e9ecfa");
	}

	@After 
	public void teardown()
	{
	   System.out.println("\nTest finished.");
	}

	@Test 
	public void testGetTeamsValidRegionValidID()
	{    
		List<Team> teams = api.getTeams(Region.NA, 20714655);
	    Assert.assertNotNull(teams);
	}
	
	@Test 
	public void testGetTeamsValidRegionInvalidID()
	{    
		List<Team> teams = api.getTeams(Region.NA, 9999999);
	    Assert.assertNull(teams);
	}
	
	@Test 
	public void testGetTeamsInvalidRegionValidID()
	{    
		List<Team> teams = api.getTeams(Region.OCE, 20714655);
	    Assert.assertNull(teams);
	}
	
	@Test 
	public void testGetTeamValidSetRegionValidID()
	{    
		api.setRegion(Region.NA);
		List<Team> teams = api.getTeams(20714655);
	    Assert.assertNotNull(teams);
	}
	
	@Test 
	public void testGetTeamInvalidSetRegionValidID()
	{    
		api.setRegion(Region.OCE);
		List<Team> teams = api.getTeams(20714655);
	    Assert.assertNull(teams);
	}
	
	@Test 
	public void testGetTeamValidSetRegionInvalidID()
	{    
		api.setRegion(Region.NA);
		List<Team> teams = api.getTeams(99999999);
	    Assert.assertNull(teams);
	}
}



