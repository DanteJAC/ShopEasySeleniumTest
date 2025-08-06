
package com.shopeasy;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class HtmlReportGenerator {

    public static void generateReport(String className, List<String> logs) {
        String timestamp = LocalDateTime.now().toString();
        StringBuilder html = new StringBuilder();

        html.append("<!DOCTYPE html><html><head><meta charset='UTF-8'>");
        html.append("<title>Informe de Pruebas - ").append(className).append("</title>");
        html.append("<style>body{font-family:Arial;margin:40px;} .log{margin-bottom:10px;}</style>");
        html.append("</head><body>");
        html.append("<h1>Informe de Pruebas Automatizadas</h1>");
        html.append("<p>Clase: ").append(className).append("</p>");
        html.append("<p>Generado: ").append(timestamp).append("</p>");
        html.append("<div>");

        for (String log : logs) {
            html.append("<div class='log'>").append(log).append("</div>");
        }

        html.append("</div></body></html>");

        try (FileWriter writer = new FileWriter("informe_" + className + ".html")) {
            writer.write(html.toString());
            System.out.println("✅ Informe HTML generado: informe_" + className + ".html");
        } catch (IOException e) {
            System.out.println("❌ Error al generar el informe: " + e.getMessage());
        }
    }
}
