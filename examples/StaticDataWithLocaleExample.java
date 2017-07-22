import java.util.Map;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.static_data.constant.ChampionListTags;
import net.rithms.riot.api.endpoints.static_data.constant.Locale;
import net.rithms.riot.api.endpoints.static_data.dto.Champion;
import net.rithms.riot.api.endpoints.static_data.dto.ChampionList;
import net.rithms.riot.constant.Platform;

/**
 * This example demonstrates using the RiotApi to request some static data using a Locale. Specifically, here we will list all champions
 * with their German name and title
 */
public class StaticDataWithLocaleExample {

	public static void main(String[] args) throws RiotApiException {
		ApiConfig config = new ApiConfig().setKey("YOUR-API-KEY-HERE");
		RiotApi api = new RiotApi(config);

		// Get all champions and print them with their German title
		ChampionList championList = api.getDataChampionList(Platform.EUW, Locale.DE_DE, null, false, ChampionListTags.ALL);
		Map<String, Champion> map = championList.getData();
		for (Champion champion : map.values()) {
			System.out.println(champion.getName() + ": " + champion.getTitle());
		}
	}
}