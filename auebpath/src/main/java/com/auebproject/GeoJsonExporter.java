package com.auebproject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class GeoJsonExporter {

    // Temporary file path
    private static Path lastExportedFilePath;

    public static void exportShortestPathToGeoJson(List<Node> pathNodes) throws IOException {
        if (pathNodes == null || pathNodes.isEmpty()) {
            throw new IllegalArgumentException("Path nodes cannot be null or empty.");
        }

        StringBuilder geoJson = new StringBuilder("{ \"type\": \"FeatureCollection\", \"features\": [");

        // Add Nodes
        for (Node node : pathNodes) {
            if (node == null) {
                throw new IllegalArgumentException("Path nodes list contains a null node.");
            }
            geoJson.append("{")
                .append("\"type\": \"Feature\",")
                .append("\"geometry\": {")
                .append("\"type\": \"Point\",")
                .append("\"coordinates\": [")
                .append(node.lon).append(",").append(node.lat)
                .append("]},")
                .append("\"properties\": { \"id\": \"").append(node.id).append("\" }")
                .append("},");
        }

        // Add Edges (connect consecutive nodes)
        for (int i = 0; i < pathNodes.size() - 1; i++) {
            Node from = pathNodes.get(i);
            Node to = pathNodes.get(i + 1);

            geoJson.append("{")
                .append("\"type\": \"Feature\",")
                .append("\"geometry\": {")
                .append("\"type\": \"LineString\",")
                .append("\"coordinates\": [")
                .append("[").append(from.lon).append(",").append(from.lat).append("],")
                .append("[").append(to.lon).append(",").append(to.lat).append("]")
                .append("]},")
                .append("\"properties\": {}")
                .append("},");
        }

        // Remove trailing comma and close the JSON
        if (geoJson.charAt(geoJson.length() - 1) == ',') {
            geoJson.setLength(geoJson.length() - 1);
        }
        geoJson.append("]}");

        // Create a temporary file
        lastExportedFilePath = Files.createTempFile("exported_shortest_path", ".geojson");
        lastExportedFilePath.toFile().deleteOnExit();

        // Write to the temporary file
        try (FileWriter writer = new FileWriter(lastExportedFilePath.toFile())) {
            writer.write(geoJson.toString());
        }
    }

    public static void exportToGeoJson(Map<String, Node> nodes, List<Edge> edges) throws IOException {
        if (nodes == null || nodes.isEmpty()) {
            throw new IllegalArgumentException("Nodes map cannot be null or empty.");
        }
        if (edges == null || edges.isEmpty()) {
            throw new IllegalArgumentException("Edges list cannot be null or empty.");
        }

        StringBuilder geoJson = new StringBuilder("{ \"type\": \"FeatureCollection\", \"features\": [");

        // Add Nodes
        for (Node node : nodes.values()) {
            if (node == null) {
                throw new IllegalArgumentException("Nodes map contains a null node.");
            }
            geoJson.append("{")
                .append("\"type\": \"Feature\",")
                .append("\"geometry\": {")
                .append("\"type\": \"Point\",")
                .append("\"coordinates\": [")
                .append(node.lon).append(",").append(node.lat)
                .append("]},")
                .append("\"properties\": { \"id\": \"").append(node.id).append("\" }")
                .append("},");
        }

        // Add Edges
        for (Edge edge : edges) {
            if (edge == null || edge.getFrom() == null || edge.getTo() == null) {
                throw new IllegalArgumentException("Edges list contains a null edge or nodes.");
            }
            geoJson.append("{")
                .append("\"type\": \"Feature\",")
                .append("\"geometry\": {")
                .append("\"type\": \"LineString\",")
                .append("\"coordinates\": [")
                .append("[").append(edge.from.lon).append(",").append(edge.from.lat).append("],")
                .append("[").append(edge.to.lon).append(",").append(edge.to.lat).append("]")
                .append("]},")
                .append("\"properties\": { \"distance\": ").append(edge.distance).append(" }")
                .append("},");
        }

        // Remove trailing comma and close the JSON
        if (geoJson.charAt(geoJson.length() - 1) == ',') {
            geoJson.setLength(geoJson.length() - 1);
        }
        geoJson.append("]}");

        // Create a temporary file
        lastExportedFilePath = Files.createTempFile("exported_graph", ".geojson");
        lastExportedFilePath.toFile().deleteOnExit();

        // Write to the temporary file
        try (FileWriter writer = new FileWriter(lastExportedFilePath.toFile())) {
            writer.write(geoJson.toString());
        }
    }

    public static Path getLastExportedFilePath() {
        return lastExportedFilePath;
    }
}
