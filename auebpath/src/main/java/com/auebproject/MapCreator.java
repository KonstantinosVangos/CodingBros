package com.auebproject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MapCreator {

    public static Map<String, Node> parseNodesFromGeoJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        // Load resource as InputStream
        try (InputStream resourceStream = MapCreator.class.getResourceAsStream("/data/athens_transport_data.geojson")) {
            if (resourceStream == null) {
                throw new IOException("Resource not found: /data/athens_transport_data.geojson");
            }
            JsonNode root = mapper.readTree(resourceStream);
            var cords = new CodeToName();
            JsonNode elements = root.get("features");
            Map<String, Node> nodes = new HashMap<>();

            for (JsonNode element : elements) {
                if (element.has("properties") && element.get("properties").has("ref")) {
                    String id = "-1";
                    String ref = element.get("properties").get("ref").asText();
                    double lat = element.get("geometry").get("coordinates").get(1).asDouble();
                    double lon = element.get("geometry").get("coordinates").get(0).asDouble();

                    if (ref.matches("\\d{6}")) {
                        nodes.put(ref, new Node(ref, lat, lon));
                    }
                }
            }
            return nodes;
        }
    }

    public static List<Edge> parseEdgesFromGeoJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        // Load resource as InputStream
        try (InputStream resourceStream = MapCreator.class.getResourceAsStream("/data/athens_transport_data3.geojson")) {
            if (resourceStream == null) {
                throw new IOException("Resource not found: /data/athens_transport_data3.geojson");
            }
            JsonNode root = mapper.readTree(resourceStream);
            JsonNode elements = root.get("features");
            List<Edge> edges = new ArrayList<>();
            Map<String, Node> nodeMap = new HashMap<>();
            AtomicInteger idCounter = new AtomicInteger(1);

            for (JsonNode element : elements) {
                String geometryType = element.get("geometry").get("type").asText();

                if ("LineString".equals(geometryType)) {
                    JsonNode coordinates = element.get("geometry").get("coordinates");
                    edges.addAll(processCoordinates(coordinates, nodeMap, idCounter));
                } else if ("Polygon".equals(geometryType)) {
                    JsonNode coordinates = element.get("geometry").get("coordinates");
                    if (coordinates.isArray() && coordinates.size() > 0) {
                        JsonNode exteriorRing = coordinates.get(0);
                        edges.addAll(processCoordinates(exteriorRing, nodeMap, idCounter));
                    }
                }
            }
            return edges;
        }
    }

    private static List<Edge> processCoordinates(JsonNode coordinates, Map<String, Node> nodeMap, AtomicInteger idCounter) {
        List<Edge> edges = new ArrayList<>();
        Node prevNode = null;

        for (JsonNode coordinate : coordinates) {
            double lon = coordinate.get(0).asDouble();
            double lat = coordinate.get(1).asDouble();

            String key = String.format("%.6f,%.6f", lat, lon);

            Node currentNode = nodeMap.computeIfAbsent(key, k -> new Node("L" + idCounter.getAndIncrement(), lat, lon));

            if (prevNode != null && !prevNode.id.equals(currentNode.id)) {
                double distance = NodeHandling.calculateDistance(prevNode, currentNode);
                edges.add(new Edge(prevNode, currentNode, distance));
            }

            prevNode = currentNode;
        }
        return edges;
    }
}
