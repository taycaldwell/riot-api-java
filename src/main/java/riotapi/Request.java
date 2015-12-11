package main.java.riotapi;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Request {

	private static String execute(String method, String URL, String key, String body) throws RiotApiException {

		HttpURLConnection connection = null;

		try {
			String requestURL = URL;
			URL url = new URL(requestURL);

			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(method);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestProperty("X-Riot-Token", key);
			
			if(method.equals("PUT") || method.equals("POST")) {
				connection.setRequestProperty("Content-Type", "application/json");
				connection.setDoOutput(true);
				DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
				wr.writeBytes(body);
				wr.flush();
				wr.close();
			}

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
			
			else if (responseCode != 200 && responseCode != 204) {
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
			rd.close();

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
	
	// HTTP GET request
	protected static String sendGet(String URL, String key) throws RiotApiException {
		return execute("GET", URL, key, null);
	}
	
	// HTTP POST request
	protected static String sendPost(String URL, String key, String body) throws RiotApiException {
		return execute("POST", URL, key, body);
	}
	
	// HTTP PUT request
	protected static String sendPut(String URL, String key, String body) throws RiotApiException {
		return execute("PUT", URL, key, body);
	}
}