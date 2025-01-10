package com.auebproject;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        var j = new Location();
        List<Edge> edges = MapCreator.parseEdgesFromGeoJson();
        var asoee = new Node("asoee", 37.994124, 23.731996);
        var t1 = new Node("t1", 37.877708, 23.761687);
        System.out.println(ShortestPath.findShortestPath(asoee, t1, edges));
        String outputFilePath = "auebpath\\src\\main\\java\\com\\auebproject\\exported_data.geojson";
        GeoJsonExporter.exportShortestPathToGeoJson(ShortestPath.findShortestPath(asoee, t1, edges), outputFilePath);
        //j.location();
    }
}

