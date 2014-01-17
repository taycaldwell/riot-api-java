package test;

import main.java.riotapi.RiotAPI;
import dto.*;
import org.junit.*;


public class ChampionRequestTest
{
	private RiotAPI api;
   
	@Before public void setup()
	{
	   System.out.println("\nTest starting...");
	   api = new RiotAPI("YOUR-API-KEY");
	}

	@After public void teardown()
	{
	   System.out.println("\nTest finished.");
	}

	@Test public void testGetChampionsValidSetRegion()
	{    
		api.setRegion("na");
		ChampionList champions = api.getChampions();
	    Assert.assertNotNull(champions);
	}
	
	@Test public void testGetChampionsInvalidSetRegion()
	{    
		api.setRegion("br");
		ChampionList champions = api.getChampions();
		Assert.assertNull(champions);
	}
	
	@Test public void testGetChampionsValidRegion()
	{    
		ChampionList champions = api.getChampions("na");
	    Assert.assertNotNull(champions);
	}
	
	
	@Test public void testGetChampionsInvalidRegion()
	{    
		ChampionList champions = api.getChampions("br");
		Assert.assertNull(champions);
	}
	
	
	@Test public void testGetChampionsValidSetRegionFreeToPlayTrue()
	{    
		api.setRegion("na");
		ChampionList champions = api.getChampions(true);
		Assert.assertNotNull(champions);
	}
	
	@Test public void testGetChampionsInvalidSetRegionFreeToPlayTrue()
	{    
		api.setRegion("tr");
		ChampionList champions = api.getChampions(true);
		Assert.assertNull(champions);
	}
	
	@Test public void testGetChampionsValidSetRegionFreeToPlayFalse()
	{    
		api.setRegion("na");
		ChampionList champions = api.getChampions(false);
		Assert.assertNotNull(champions);
	}
	
	@Test public void testGetChampionsInvalidSetRegionFreeToPlayFalse()
	{    
		api.setRegion("tr");
		ChampionList champions = api.getChampions(false);
		Assert.assertNull(champions);
	}
	
	@Test public void testGetChampionsValidRegionFreeToPlayTrue()
	{    
		ChampionList champions = api.getChampions("na", true);
		Assert.assertNotNull(champions);
	}
	
	@Test public void testGetChampionsInvalidRegionFreeToPlayTrue()
	{    
		ChampionList champions = api.getChampions("tr", true);
		Assert.assertNull(champions);
	}
	
	@Test public void testGetChampionsValidRegionFreeToPlayFalse()
	{    
		ChampionList champions = api.getChampions("na", false);
		Assert.assertNotNull(champions);
	}
	
	@Test public void testGetChampionsInvalidRegionFreeToPlayFalse()
	{    
		ChampionList champions = api.getChampions("tr", false);
		Assert.assertNull(champions);
	}
	
	@Test public void testGetFreeToPlayChampionsValidSetRegion()
	{    
		api.setRegion("na");
		ChampionList champions = api.getFreeToPlayChampions();
		Assert.assertNotNull(champions);
	}
	
	@Test public void testGetFreeToPlayChampionsInvalidSetRegion()
	{    
		api.setRegion("br");
		ChampionList champions = api.getFreeToPlayChampions();
		Assert.assertNull(champions);
	}
	
	@Test public void testGetFreeToPlayChampionsValidRegion()
	{    
		ChampionList champions = api.getFreeToPlayChampions("na");
		Assert.assertNotNull(champions);
	}
	
	@Test public void testGetFreeToPlayChampionsInvalidRegion()
	{    
		ChampionList champions = api.getFreeToPlayChampions("br");
		Assert.assertNull(champions);
	}
}



