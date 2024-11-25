package com.auebproject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Url {
    
    private static final String BASE_URL = "http://telematics.oasa.gr/api/";

    protected static String urlCreator(String endpoint) {
        try {
            // Construct the complete URL
            URL url = new URL(BASE_URL + endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HTTP GET Request Failed with Error code : " + conn.getResponseCode());
            }

            // Read the response
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                output.append(line);
            }
            conn.disconnect();

            // Return the raw response as a String
            return output.toString();  // This is the raw response

        } catch (Exception e) {
            /*e.printStackTrace();
            return null;  // Return null in case of error
            */
            return "error";
        }
    }
}
