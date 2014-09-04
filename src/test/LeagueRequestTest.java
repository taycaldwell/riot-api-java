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



