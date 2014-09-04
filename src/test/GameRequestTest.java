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

import main.java.riotapi.RiotApi;
import dto.Game.RecentGames;

import org.junit.*;

import constant.Region;

public class GameRequestTest
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
	public void testGetRecentGamesValidSetRegionValidId()
	{    
		api.setRegion(Region.NA);
		RecentGames games = api.getRecentGames(26120541);
	    Assert.assertNotNull(games);
	}
	
	@Test 
	public void testGetRecentGamesValidSetRegionInvalidId()
	{    
		api.setRegion(Region.NA);
		RecentGames games = api.getRecentGames(36849083);
	    Assert.assertNull(games);
	}
	
	@Test 
	public void testGetRecentGamesInvalidSetRegionValidId()
	{    
		api.setRegion(Region.TR);
		RecentGames games = api.getRecentGames(26120541);
	    Assert.assertNull(games);
	}
	
	@Test 
	public void testGetRecentGamesInvalidSetRegionInvalidId()
	{    
		api.setRegion(Region.TR);
		RecentGames games = api.getRecentGames(36849083);
	    Assert.assertNull(games);
	}
	
	@Test 
	public void testGetRecentGamesValidRegionValidId()
	{    
		RecentGames games = api.getRecentGames(Region.NA, 26120541);
	    Assert.assertNotNull(games);
	}
	
	@Test 
	public void testGetRecentGamesValidRegionInvalidId()
	{    
		RecentGames games = api.getRecentGames(Region.NA, 36849083);
	    Assert.assertNull(games);
	}
	
	@Test 
	public void testGetRecentGamesInvalidRegionValidId()
	{    
		RecentGames games = api.getRecentGames(Region.TR, 26120541);
	    Assert.assertNull(games);
	}
	
	@Test 
	public void testGetRecentGamesInvalidRegionInvalidId()
	{    
		RecentGames games = api.getRecentGames(Region.TR, 36849083);
	    Assert.assertNull(games);
	}
}



