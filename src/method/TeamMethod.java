package method;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import dto.Team.Team;

public final class TeamMethod {
	
	/**
	 * Get teams of a given summoner
	 * @param region The desired region
	 * @param summonerId The ID of the desired summoner
	 * @return The teams the given summoner is a member of
	 * @see Team
	 */
	public static List<Team> getTeams(String endpoint, String region, String key, long summonerId){
		
		String url = endpoint + "/api/lol/" + region + "/v2.4/team/by-summoner/" + summonerId + "?api_key=" + key;
		List<Team> teamList = null;

			try {
				teamList = new Gson().fromJson(IOUtils.toString(new URL(url)), new TypeToken<List<Team>>(){}.getType());
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
			}
	
	    return teamList;
	}

}
