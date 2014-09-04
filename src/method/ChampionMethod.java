package method;

import java.io.IOException;
import java.net.URL;
import org.apache.commons.io.IOUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import dto.Champion.Champion;
import dto.Champion.ChampionList;

public final class ChampionMethod {
	
	public static ChampionList getChampions(String endpoint, String region, String key) {
		
		String url = endpoint + "/api/lol/" + region + "/v1.2/champion?api_key=" + key;
	    ChampionList championList = null;
		
			try {
				championList = new Gson().fromJson(IOUtils.toString(new URL(url)), ChampionList.class);
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
		 
	    return championList;
	}
    
	public static ChampionList getChampions(String endpoint, String region, String key, boolean freeToPlay) {

		String url = endpoint + "/api/lol/" + region + "/v1.2/champion?freeToPlay=" + freeToPlay + "&api_key=" + key;
	    ChampionList championList = null;

			try {
				championList = new Gson().fromJson(IOUtils.toString(new URL(url)), ChampionList.class);
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}

	    return championList;
	}
	
	public static Champion getChampionById(String endpoint, String region, String key, int champId) {
		
		String url = endpoint + "/api/lol/" + region + "/v1.2/champion/" + champId + "?api_key=" + key;
	    Champion champion = null;
		
			try {
				champion = new Gson().fromJson(IOUtils.toString(new URL(url)), Champion.class);
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
		 
	    return champion;
	}
	
}
