package com.auebproject;

public class Node {
    private int x, y; // Συντεταγμένες κόμβου στον χάρτη
    private String name;

    public Node(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return name;
    }
}

