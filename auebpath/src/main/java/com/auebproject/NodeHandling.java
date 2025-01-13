package com.auebproject;

import java.util.List;
import java.util.Map;

public class NodeHandling {

    public static Node findClosestNode(Map<String, Node> nodes, double targetLat, double targetLon) {
        if (nodes == null || nodes.isEmpty()) {
            throw new IllegalArgumentException("Nodes map cannot be null or empty.");
        }
        if (!isValidCoordinate(targetLat, targetLon)) {
            throw new IllegalArgumentException("Invalid target coordinates: Latitude and Longitude must be within valid ranges.");
        }

        Node closestNode = null;
        double minDistance = Double.MAX_VALUE;

        for (Node node : nodes.values()) {
            if (node == null) {
                throw new IllegalArgumentException("Nodes map contains a null node.");
            }

            double distance = calculateDistance(node, targetLat, targetLon);
            if (distance < minDistance) {
                minDistance = distance;
                closestNode = node;
            }
        }

        if (closestNode == null) {
            throw new NoNodeFoundException("No closest node found in the given nodes map.");
        }

        return closestNode;
    }

    public static Node findClosestNode(List<Edge> edges, double targetLat, double targetLon) {
        if (edges == null || edges.isEmpty()) {
            throw new IllegalArgumentException("Edges list cannot be null or empty.");
        }
        if (!isValidCoordinate(targetLat, targetLon)) {
            throw new IllegalArgumentException("Invalid target coordinates: Latitude and Longitude must be within valid ranges.");
        }

        Node closestNode = null;
        double minDistance = Double.MAX_VALUE;

        for (Edge edge : edges) {
            if (edge == null || edge.getFrom() == null || edge.getTo() == null) {
                throw new IllegalArgumentException("Edges list contains a null edge or nodes.");
            }

            Node[] nodes = {edge.getFrom(), edge.getTo()};
            for (Node node : nodes) {
                double distance = calculateDistance(node, targetLat, targetLon);
                if (distance < minDistance) {
                    minDistance = distance;
                    closestNode = node;
                }
            }
        }

        if (closestNode == null) {
            throw new NoNodeFoundException("No closest node found in the given edges list.");
        }

        return closestNode;
    }

    public static double calculateDistance(Node from, Node to) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Nodes for distance calculation cannot be null.");
        }
        return Math.sqrt(Math.pow(from.getLat() - to.getLat(), 2) + Math.pow(from.getLon() - to.getLon(), 2));
    }

    public static double calculateDistance(Node from, double lat, double lon) {
        if (from == null) {
            throw new IllegalArgumentException("From node cannot be null.");
        }
        if (!isValidCoordinate(lat, lon)) {
            throw new IllegalArgumentException("Invalid coordinates for distance calculation: Latitude and Longitude must be within valid ranges.");
        }

        final int EARTH_RADIUS = 6371; // Radius in kilometers
        double latDiff = Math.toRadians(lat - from.getLat());
        double lonDiff = Math.toRadians(lon - from.getLon());
        double a = Math.sin(latDiff / 2) * Math.sin(latDiff / 2) +
                   Math.cos(Math.toRadians(from.getLat())) * Math.cos(Math.toRadians(lat)) *
                   Math.sin(lonDiff / 2) * Math.sin(lonDiff / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS * c;
    }

    private static boolean isValidCoordinate(double lat, double lon) {
        return lat >= -90 && lat <= 90 && lon >= -180 && lon <= 180;
    }

    // Custom exception for no node found
    public static class NoNodeFoundException extends RuntimeException {
        public NoNodeFoundException(String message) {
            super(message);
        }
    }
}
