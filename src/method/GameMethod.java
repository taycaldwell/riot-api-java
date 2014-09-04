package method;

import java.io.IOException;
import java.net.URL;
import org.apache.commons.io.IOUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import dto.Game.RecentGames;

public final class GameMethod {
	
	public static RecentGames getRecentGames(String endpoint, String region, String key, long summonerId) {
		
		String url = endpoint + "/api/lol/" + region + "/v1.3/game/by-summoner/" + summonerId + "/recent?api_key=" + key;
	    RecentGames recentGames = null;

			try {
				recentGames = new Gson().fromJson(IOUtils.toString(new URL(url)), RecentGames.class);
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}

	    return recentGames;
	}
	
}
