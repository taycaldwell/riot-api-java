import java.util.Map;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;
import net.rithms.riot.constant.Region;

/**
 * This is a simple example using the RiotApi to synchronously request summoner information
 */
public class SimpleExample {

	public static void main(String[] args) throws RiotApiException {
		ApiConfig config = new ApiConfig().setKey("YOUR-API-KEY-HERE");
		RiotApi api = new RiotApi(config);

		Map<String, Summoner> summoners = api.getSummonersByName(Region.NA, "tryndamere", "ryze");
		for (String key : summoners.keySet()) {
			Summoner summoner = summoners.get(key);
			System.out.println("Name: " + summoner.getName() + ", ID: " + summoner.getId());
		}
	}
}