package com.auebproject;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;


public class overpassAPI  {
    public static void fetchOverpassAPIData() {
    try {
    
        //URL with the Overpass API query
        URL url = new URL("""
                      https://overpass-api.de/api/interpreter?data=[out:json][timeout:25];area["name"="Athens"]["boundary"="administrative"]->.searchArea;(node(area.searchArea);way(area.searchArea););out body;>;out skel qt;\r
                      """ //
        );
    
        //Establishing connection with the URL and getting the response
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
    
        //Reading the response String
        InputStreamReader inputReader = new InputStreamReader(con.getInputStream());
        StringBuilder response = new StringBuilder();
        int t;
        while((t = inputReader.read()) != -1 ) {
        response.append((char)t);
        }

        //Converting the response to json
        JSONObject responseToJSON =  new JSONObject(response.toString());
        JSONArray graphElements = responseToJSON.getJSONArray("elements");
        
        //Go through the elements
        for (int i = 0; i < graphElements.length(); i ++) {
        JSONObject graphElement = graphElements.getJSONObject(i);
        int id = graphElement.getInt("id");
        double lat = graphElement.getDouble("lat");
        double lon = graphElement.getDouble("lon");
        System.out.println("node" + id + lon);
        }
    } catch (Exception e) {
        System.err.print("error");
    }

}

}
