/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import org.json.*;

/**
 *
 * @author Kevin
 */
public class query {

    private static void fetchData() throws MalformedURLException, IOException, JSONException {
        String baseUrl = "http://query.yahooapis.com/v1/public/yql?q=";
        String query = "select * from upcoming.events where location='San Francisco' and search_text='dance'";
        String fullUrlStr = baseUrl + URLEncoder.encode(query, "UTF-8") + "&format=json";

        URL fullUrl = new URL(fullUrlStr);
        InputStream is = fullUrl.openStream();

        JSONTokener tok = new JSONTokener(is);
        JSONObject result = new JSONObject(tok);

        is.close();
    }
    public static void main(String[] args) throws IOException, MalformedURLException, JSONException, Exception {
        sendGet("SELECT * FROM yahoo.finance.quotes WHERE symbol='KMB'");
    }
        public static String sendGet(String s) throws Exception {
        String url = "http://query.yahooapis.com/v1/public/yql?q=" + URLEncoder.encode(s, "UTF-8") + "&format=xml";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        StringBuffer response;
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
        }

        return response.toString();

    }
}
