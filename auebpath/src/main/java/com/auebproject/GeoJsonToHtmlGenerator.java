package com.auebproject;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GeoJsonToHtmlGenerator {

    private static Path lastMapViewerFilePath;

    public static Path getLastMapViewerFilePath() {
        return lastMapViewerFilePath;
    }

    // File paths for the GeoJSON and output HTML
    public static Path getGeoJsonFilePath() throws URISyntaxException {
        return GeoJsonExporter.getLastExportedFilePath();
    }
    /* 
    public static Path getOutputHtmlFilePath() throws URISyntaxException {
        return Paths.get(GeoJsonToHtmlGenerator.class.getResource("/web/MapViewer.html").toURI());
    }*/

    public static void generateHtml() {
        String htmlTemplate = """
                <!DOCTYPE html>
                <html>
                <head>
                    <title>Google Maps with GeoJSON</title>
                    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD57XGKSL3GwOvmWwfYkdpy2Wt4x6cI3HU"></script>
                    <script>
                        function initMap() {
                            const map = new google.maps.Map(document.getElementById("map"), {
                                center: { lat: 37.9838, lng: 23.7275 },
                                zoom: 12,
                            });
    
                            // GeoJSON data
                            const geoJsonData = %%GEOJSON_DATA%%;
    
                            // Add GeoJSON to the map
                            map.data.addGeoJson(geoJsonData);
                        }
                    </script>
                </head>
                <body onload="initMap()">
                    <div id="map" style="height: 500px; width: 100%;"></div>
                </body>
                </html>
                """;
    
        try {
            Path geoJsonPath = getGeoJsonFilePath();
            String geoJsonData = Files.readString(geoJsonPath);
    
            // Escape GeoJSON data
            //String escapedGeoJsonData = geoJsonData.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n");
            String finalHtml = htmlTemplate.replace("%%GEOJSON_DATA%%", geoJsonData);
    
            lastMapViewerFilePath = Files.createTempFile("exported_graph", ".html");
            try (FileWriter writer = new FileWriter(lastMapViewerFilePath.toFile())) {
                writer.write(finalHtml);
            }
    
            System.out.println("HTML file created: " + lastMapViewerFilePath);
        } catch (IOException | URISyntaxException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }    
}
