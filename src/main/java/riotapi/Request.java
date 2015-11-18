package main.java.riotapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Request {

	public static String execute(String URL) throws RiotApiException {

		HttpURLConnection connection = null;

		try {
			String requestURL = URL;
			URL url = new URL(requestURL);

			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setInstanceFollowRedirects(false);

			int responseCode = connection.getResponseCode();
			
			if (responseCode == 429) {
				String retryAfterString = connection.getHeaderField("Retry-After");
				String rateLimitType = connection.getHeaderField("X-Rate-Limit-Type");
				if(retryAfterString != null) {
					int retryAfter = Integer.parseInt(retryAfterString);
					throw new RiotApiException(responseCode, retryAfter, rateLimitType);
				} else {
					throw new RiotApiException(responseCode, 0, rateLimitType);
				}	
			}
			
			else if (responseCode != 200) {
				throw new RiotApiException(responseCode);
			}

			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, "utf-8"));
			StringBuilder response = new StringBuilder();

			String line;
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}

			connection.disconnect();
			return response.toString();
		} catch (IOException ex) {
			Logger.getLogger(Request.class.getName()).log(Level.SEVERE, null, ex);
			throw new RiotApiException(RiotApiException.IOEXCEPTION);
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}
}