package com.auebproject;

import java.awt.Desktop;
import java.net.URI;

public class OpenHtmlInBrowser {
    public static void openHtml() {
        try {
            URI uri = HtmlViewerAppSwing.class.getResource("/web/MapViewer.html").toURI();
            Desktop.getDesktop().browse(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
