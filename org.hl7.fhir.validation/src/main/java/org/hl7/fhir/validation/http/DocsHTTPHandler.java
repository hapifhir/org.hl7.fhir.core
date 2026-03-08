package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * Serves the API documentation page using Redoc (CDN-hosted).
 * Available at /docs.
 */
class DocsHTTPHandler implements HttpHandler {

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    byte[] responseBytes = DOCS_HTML.getBytes(StandardCharsets.UTF_8);
    exchange.getResponseHeaders().set("Content-Type", "text/html; charset=utf-8");
    exchange.sendResponseHeaders(200, responseBytes.length);
    try (OutputStream os = exchange.getResponseBody()) {
      os.write(responseBytes);
    }
  }

  private static final String DOCS_HTML = "<!DOCTYPE html>\n" +
    "<html>\n" +
    "<head>\n" +
    "  <title>FHIR Validator HTTP Service - API Documentation</title>\n" +
    "  <meta charset=\"utf-8\"/>\n" +
    "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
    "  <link href=\"https://fonts.googleapis.com/css?family=Montserrat:300,400,700|Roboto:300,400,700\" rel=\"stylesheet\">\n" +
    "  <style>\n" +
    "    body { margin: 0; padding: 0; }\n" +
    "  </style>\n" +
    "</head>\n" +
    "<body>\n" +
    "  <redoc spec-url='/openapi.json'></redoc>\n" +
    "  <script src=\"https://cdn.redoc.ly/redoc/latest/bundles/redoc.standalone.js\"></script>\n" +
    "</body>\n" +
    "</html>\n";
}
