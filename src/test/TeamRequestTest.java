package test;

/*
 * Copyright 2014 Taylor Caldwell
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
	   api = new RiotApi("YOUR-API-KEY");
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



