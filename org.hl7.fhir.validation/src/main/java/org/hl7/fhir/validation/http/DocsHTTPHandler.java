package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * Serves the API documentation page using Swagger UI (CDN-hosted).
 * Available at /docs (Swagger UI) and /redoc (Redoc).
 */
class DocsHTTPHandler implements HttpHandler {

  private final String html;

  DocsHTTPHandler(String html) {
    this.html = html;
  }

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    byte[] responseBytes = html.getBytes(StandardCharsets.UTF_8);
    exchange.getResponseHeaders().set("Content-Type", "text/html; charset=utf-8");
    exchange.sendResponseHeaders(200, responseBytes.length);
    try (OutputStream os = exchange.getResponseBody()) {
      os.write(responseBytes);
    }
  }

  static final String SWAGGER_HTML = "<!DOCTYPE html>\n" +
    "<html>\n" +
    "<head>\n" +
    "  <title>FHIR Validator HTTP Service - API Documentation</title>\n" +
    "  <meta charset=\"utf-8\"/>\n" +
    "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
    "  <link rel=\"stylesheet\" type=\"text/css\" href=\"https://unpkg.com/swagger-ui-dist@5/swagger-ui.css\">\n" +
    "  <style>\n" +
    "    html { box-sizing: border-box; overflow-y: scroll; }\n" +
    "    *, *:before, *:after { box-sizing: inherit; }\n" +
    "    body { margin: 0; background: #fafafa; }\n" +
    "  </style>\n" +
    "</head>\n" +
    "<body>\n" +
    "  <div id=\"swagger-ui\"></div>\n" +
    "  <script src=\"https://unpkg.com/swagger-ui-dist@5/swagger-ui-bundle.js\"></script>\n" +
    "  <script src=\"https://unpkg.com/swagger-ui-dist@5/swagger-ui-standalone-preset.js\"></script>\n" +
    "  <script>\n" +
    "    window.onload = function() {\n" +
    "      SwaggerUIBundle({\n" +
    "        url: '/openapi.json',\n" +
    "        dom_id: '#swagger-ui',\n" +
    "        deepLinking: true,\n" +
    "        presets: [SwaggerUIBundle.presets.apis, SwaggerUIStandalonePreset],\n" +
    "        plugins: [SwaggerUIBundle.plugins.DownloadUrl],\n" +
    "        layout: 'StandaloneLayout'\n" +
    "      });\n" +
    "    };\n" +
    "  </script>\n" +
    "</body>\n" +
    "</html>\n";

  static final String REDOC_HTML = "<!DOCTYPE html>\n" +
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
