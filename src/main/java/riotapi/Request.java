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

        try {
            String requestURL = URL;

            URL url = new URL(requestURL);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setInstanceFollowRedirects(false);

            int responseCode = connection.getResponseCode();

            if (responseCode != 200) {
                switch (responseCode) {
                    case 400:
                        throw new RiotApiException(RiotApiException.Type.BAD_REQUEST);
                    case 401:
                        throw new RiotApiException(RiotApiException.Type.UNAUTHORIZED);
                    case 404:
                        throw new RiotApiException(RiotApiException.Type.DATA_NOT_FOUND);
                    case 429:
                        throw new RiotApiException(RiotApiException.Type.RATE_LIMITED);
                    case 500:
                        throw new RiotApiException(RiotApiException.Type.SERVER_ERROR);
                    case 503:
                        throw new RiotApiException(RiotApiException.Type.UNAVAILABLE);
                    default:
                        throw new RiotApiException(RiotApiException.Type.UNKNOWN);
                }
            }

            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, "utf-8"));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }

            connection.disconnect();
            return response.toString();

        } catch (IOException ex) {
            Logger.getLogger(Request.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

}
