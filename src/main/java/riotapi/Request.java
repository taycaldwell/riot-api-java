package main.java.riotapi;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Request {

	protected enum RequestMethod {
		DELETE, GET, POST, PUT
	};

	protected static String execute(RequestMethod method, String requestURL, String key, String body) throws RiotApiException {
		HttpURLConnection connection = null;
		try {
			URL url = new URL(requestURL);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(method.name());
			connection.setInstanceFollowRedirects(false);
			if (key != null) {
				connection.setRequestProperty("X-Riot-Token", key);
			}

			if (method == RequestMethod.POST || method == RequestMethod.PUT) {
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
				if (retryAfterString != null) {
					int retryAfter = Integer.parseInt(retryAfterString);
					throw new RiotApiException(responseCode, retryAfter, rateLimitType);
				} else {
					throw new RiotApiException(responseCode, 0, rateLimitType);
				}
			} else if (responseCode != 200 && responseCode != 204) {
				System.out.println(requestURL);
				throw new RiotApiException(responseCode);
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
			StringBuilder response = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				response.append(line);
				response.append(System.lineSeparator());
			}
			br.close();
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
		return execute(RequestMethod.GET, URL, key, null);
	}

	// HTTP POST request
	protected static String sendPost(String URL, String key, String body) throws RiotApiException {
		return execute(RequestMethod.POST, URL, key, body);
	}

	// HTTP PUT request
	protected static String sendPut(String URL, String key, String body) throws RiotApiException {
		return execute(RequestMethod.PUT, URL, key, body);
	}
}