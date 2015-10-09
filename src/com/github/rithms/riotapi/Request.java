package com.github.rithms.riotapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.rithms.util.PropertiesLoader;

public class Request {

	private static final Logger logger = Logger.getLogger(Request.class.getName());

	public static String execute(String URL) throws RiotApiException {

		HttpURLConnection connection = null;

		try {
			String requestURL = URL;
			logger.log(Level.INFO, "Executing request: GET: " + requestURL);
			URL url = new URL(requestURL);
			Proxy proxy = PropertiesLoader.getProxy();
			if (proxy == null) {
				connection = (HttpURLConnection) url.openConnection();
			} else {
				connection = (HttpURLConnection) url.openConnection(proxy);
			}
			connection.setRequestMethod("GET");
			connection.setInstanceFollowRedirects(false);

			int responseCode = connection.getResponseCode();
			if (responseCode != 200) {
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