package com.auebproject;

import java.util.List;

public class Input {
    public static void inputForGUI(String address) {
        try {
            var geocodingService = new GeocodingService();
            double[] latLon = geocodingService.getLatLon(address);
            List<Edge> edges = MapCreator.parseEdgesFromGeoJson();
            var asoee = new Node("asoee", 37.994124, 23.731996);
            var input = new Node("t1", latLon[0], latLon[1]);
            GeoJsonExporter.exportShortestPathToGeoJson(ShortestPath.findShortestPath(asoee, input, edges));
            GeoJsonToHtmlGenerator.generateHtml();
            Thread.sleep(1000);
            OpenHtmlFile.openHtml();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
