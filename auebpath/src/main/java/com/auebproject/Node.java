package com.auebproject;

class Node {
    public String id;
    public double lat;
    public double lon;

    public Node(String id, double lat, double lon) {
        this.id = id;
        this.lat = lat;
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "Node{id=" + id + ", lat=" + lat + ", lon=" + lon + "}";
    }
}
