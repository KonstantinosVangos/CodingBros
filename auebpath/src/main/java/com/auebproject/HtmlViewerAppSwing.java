package com.auebproject;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class HtmlViewerAppSwing {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Map Viewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            // Use JEditorPane for basic HTML rendering
            JEditorPane editorPane = new JEditorPane();
            editorPane.setEditable(false);

            try {
                // Load the local HTML file
                String htmlFilePath = HtmlViewerAppSwing.class.getResource("/web/MapViewer1.html").toExternalForm();
                editorPane.setPage(htmlFilePath);
            } catch (IOException e) {
                e.printStackTrace();
                editorPane.setContentType("text/html");
                editorPane.setText("<html><body><h1>Error loading HTML</h1></body></html>");
            }

            JScrollPane scrollPane = new JScrollPane(editorPane);
            frame.add(scrollPane, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }
}
