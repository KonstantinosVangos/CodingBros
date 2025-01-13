package com.auebproject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class GeocodingService {

    // Method to get latitude and longitude from an address
    public double[] getLatLon(String address) throws Exception {
        // Format the address for the URL
        String formattedAddress = address.replace(" ", "+");
        String urlString = "https://maps.googleapis.com/maps/api/geocode/json?address="
                            + formattedAddress + "&key=" + "AIzaSyD57XGKSL3GwOvmWwfYkdpy2Wt4x6cI3HU";

        // Make the API request
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        // Read the response
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Parse the JSON response
        JSONObject jsonResponse = new JSONObject(response.toString());
        if (jsonResponse.getString("status").equals("OK")) {
            JSONArray results = jsonResponse.getJSONArray("results");
            JSONObject location = results.getJSONObject(0)
                                         .getJSONObject("geometry")
                                         .getJSONObject("location");
            double lat = location.getDouble("lat");
            double lng = location.getDouble("lng");
            return new double[] {lat, lng};
        } else {
            throw new Exception("Error: " + jsonResponse.getString("status"));
        }
    }
}
