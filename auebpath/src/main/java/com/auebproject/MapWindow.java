package com.auebproject;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MapWindow extends JPanel {
    private Graph graph;

    public MapWindow(Graph graph) {
        this.graph = graph;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Ζωγράφισε τις ακμές (μαύρες γραμμές)
        g.setColor(Color.BLACK);
        for (Edge edge : graph.getEdges()) {
            Node from = edge.getFrom();
            Node to = edge.getTo();
            g.drawLine(from.getX(), from.getY(), to.getX(), to.getY());
        }
    }
}

