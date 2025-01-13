package com.auebproject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GeoJsonToHtmlGenerator {

    public static void generateHtml(String geoJsonFilePath, String outputHtmlFilePath) {
        // HTML template with a placeholder for the GeoJSON data
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
            // Read the GeoJSON file content
            String geoJsonData = Files.readString(Paths.get(geoJsonFilePath));

            // Remove escape characters and ensure JSON is embedded as a raw object
            String rawGeoJson = geoJsonData;

            // Replace the placeholder in the HTML template with the raw GeoJSON
            String finalHtml = htmlTemplate.replace("%%GEOJSON_DATA%%", rawGeoJson);

            // Write the final HTML to the output file
            Files.writeString(Path.of(outputHtmlFilePath), finalHtml);

            System.out.println("HTML file created: " + outputHtmlFilePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to generate HTML file.");
        }
    }
}

