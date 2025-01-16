package com.auebproject;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;

public class OpenHtmlFile {
    public static void openHtml() {
        try {
            // Get the file path from GeoJsonToHtmlGenerator
            Path tempFilePath = GeoJsonToHtmlGenerator.getLastMapViewerFilePath();

            if (tempFilePath == null) {
                System.err.println("HTML file path not found!");
                return;
            }

            // Convert Path to URI
            URI uri = tempFilePath.toUri();

            // Open in default browser
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(uri);
            } else {
                System.err.println("Desktop operations are not supported!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
