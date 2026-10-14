package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * Serves the OpenAPI 3.0 specification as JSON at /openapi.json.
 * <p/>
 * The specification itself is maintained as the classpath resource {@link #SPEC_RESOURCE} rather
 * than inline in this class. A YAML rendering of the same document, and prose documentation of
 * the server, are kept in documentation/validator-server.openapi.yaml and
 * documentation/validator-server.md - all three need to be updated together when an endpoint or
 * a parameter changes.
 */
@Slf4j
class OpenApiHTTPHandler implements HttpHandler {

  static final String SPEC_RESOURCE = "validator-http-openapi.json";

  private static volatile String spec;

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    byte[] responseBytes;
    try {
      responseBytes = getSpec().getBytes(StandardCharsets.UTF_8);
    } catch (IOException e) {
      log.error("Unable to load the OpenAPI specification", e);
      // deliberately a fixed message: the exception text is not echoed into the response
      byte[] errorBytes = "The OpenAPI specification is not available in this build".getBytes(StandardCharsets.UTF_8);
      exchange.getResponseHeaders().set("Content-Type", "text/plain; charset=utf-8");
      exchange.sendResponseHeaders(500, errorBytes.length);
      try (OutputStream os = exchange.getResponseBody()) {
        os.write(errorBytes);
      }
      return;
    }
    exchange.getResponseHeaders().set("Content-Type", "application/json");
    exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
    exchange.sendResponseHeaders(200, responseBytes.length);
    try (OutputStream os = exchange.getResponseBody()) {
      os.write(responseBytes);
    }
  }

  private static String getSpec() throws IOException {
    String result = spec;
    if (result == null) {
      synchronized (OpenApiHTTPHandler.class) {
        result = spec;
        if (result == null) {
          try (InputStream in = OpenApiHTTPHandler.class.getClassLoader().getResourceAsStream(SPEC_RESOURCE)) {
            if (in == null) {
              throw new IOException("Unable to find " + SPEC_RESOURCE + " on the classpath");
            }
            result = IOUtils.toString(in, StandardCharsets.UTF_8);
          }
          spec = result;
        }
      }
    }
    return result;
  }
}
