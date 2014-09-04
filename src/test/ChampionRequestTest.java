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
import dto.Champion.ChampionList;

import org.junit.*;

import constant.Region;


public class ChampionRequestTest
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
	public void testGetChampionsValidSetRegion()
	{    
		api.setRegion(Region.NA);
		ChampionList champions = api.getChampions();
	    Assert.assertNotNull(champions);
	}
	
	@Test 
	public void testGetChampionsInvalidSetRegion()
	{    
		api.setRegion(Region.BR);
		ChampionList champions = api.getChampions();
		Assert.assertNull(champions);
	}
	
	@Test 
	public void testGetChampionsValidRegion()
	{    
		ChampionList champions = api.getChampions(Region.NA);
	    Assert.assertNotNull(champions);
	}
	
	
	@Test 
	public void testGetChampionsInvalidRegion()
	{    
		ChampionList champions = api.getChampions(Region.BR);
		Assert.assertNull(champions);
	}
	
	
	@Test 
	public void testGetChampionsValidSetRegionFreeToPlayTrue()
	{    
		api.setRegion(Region.NA);
		ChampionList champions = api.getChampions(true);
		Assert.assertNotNull(champions);
	}
	
	@Test 
	public void testGetChampionsInvalidSetRegionFreeToPlayTrue()
	{    
		api.setRegion(Region.TR);
		ChampionList champions = api.getChampions(true);
		Assert.assertNull(champions);
	}
	
	@Test 
	public void testGetChampionsValidSetRegionFreeToPlayFalse()
	{    
		api.setRegion(Region.NA);
		ChampionList champions = api.getChampions(false);
		Assert.assertNotNull(champions);
	}
	
	@Test 
	public void testGetChampionsInvalidSetRegionFreeToPlayFalse()
	{    
		api.setRegion(Region.TR);
		ChampionList champions = api.getChampions(false);
		Assert.assertNull(champions);
	}
	
	@Test 
	public void testGetChampionsValidRegionFreeToPlayTrue()
	{    
		ChampionList champions = api.getChampions(Region.NA, true);
		Assert.assertNotNull(champions);
	}
	
	@Test 
	public void testGetChampionsInvalidRegionFreeToPlayTrue()
	{    
		ChampionList champions = api.getChampions(Region.TR, true);
		Assert.assertNull(champions);
	}
	
	@Test 
	public void testGetChampionsValidRegionFreeToPlayFalse()
	{    
		ChampionList champions = api.getChampions(Region.NA, false);
		Assert.assertNotNull(champions);
	}
	
	@Test 
	public void testGetChampionsInvalidRegionFreeToPlayFalse()
	{    
		ChampionList champions = api.getChampions(Region.TR, false);
		Assert.assertNull(champions);
	}
	
	@Test 
	public void testGetFreeToPlayChampionsValidSetRegion()
	{    
		api.setRegion(Region.NA);
		ChampionList champions = api.getFreeToPlayChampions();
		Assert.assertNotNull(champions);
	}
	
	@Test 
	public void testGetFreeToPlayChampionsInvalidSetRegion()
	{    
		api.setRegion(Region.BR);
		ChampionList champions = api.getFreeToPlayChampions();
		Assert.assertNull(champions);
	}
	
	@Test 
	public void testGetFreeToPlayChampionsValidRegion()
	{    
		ChampionList champions = api.getFreeToPlayChampions(Region.NA);
		Assert.assertNotNull(champions);
	}
	
	@Test 
	public void testGetFreeToPlayChampionsInvalidRegion()
	{    
		ChampionList champions = api.getFreeToPlayChampions(Region.BR);
		Assert.assertNull(champions);
	}
}



