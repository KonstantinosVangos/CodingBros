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
            String outputFilePath = "auebpath\\src\\main\\resources\\data\\exported_data.geojson";
            String outputHtmlFilePath = "auebpath\\src\\main\\resources\\web\\MapViewer.html";
            GeoJsonExporter.exportShortestPathToGeoJson(ShortestPath.findShortestPath(asoee, input, edges), outputFilePath);
            GeoJsonToHtmlGenerator.generateHtml(outputFilePath, outputHtmlFilePath);
            Thread.sleep(1000);
            OpenHtmlInBrowser.openHtml();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
