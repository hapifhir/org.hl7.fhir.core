package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.utils.OperationOutcomeUtilities;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Handler for ad-hoc registration of FHIR resources in the validator's context.
 * {@code POST /loadResource?format=json|xml} with the resource (or a {@code collection}/
 * {@code batch}/{@code transaction} Bundle) in the request body.
 *
 * <p>Used to inject artifacts — typically StructureMaps parsed via {@code /fml} —
 * into the running validator without rebuilding an NPM package.</p>
 */
@Slf4j
class LoadResourceHTTPHandler extends BaseHTTPHandler implements HttpHandler {
  private final FhirValidatorHttpService service;

  LoadResourceHTTPHandler(FhirValidatorHttpService service) {
    this.service = service;
  }

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    if (!"POST".equals(exchange.getRequestMethod())) {
      sendResponse(exchange, 405, "Method not allowed", "text/plain");
      return;
    }
    try {
      byte[] body = readRequestBody(exchange);
      if (body == null || body.length == 0) {
        sendOperationOutcome(exchange, 400,
          OperationOutcomeUtilities.createError("Missing request body: the FHIR resource (or Bundle) to load"),
          getAcceptHeader(exchange));
        return;
      }
      java.util.Map<String, String> q = parseQueryParams(exchange.getRequestURI().getQuery());
      String format = q.get("format");
      boolean replace = "true".equalsIgnoreCase(q.get("replace"));
      FhirFormat inputFormat = detectFormat(format, exchange.getRequestHeaders().getFirst("Content-Type"), body);

      List<String> loaded = service.getValidationEngine().loadResourceFromBytes(body, inputFormat, replace);

      JsonObject out = new JsonObject();
      out.add("loaded", loaded.size());
      JsonArray arr = new JsonArray();
      for (String s : loaded) arr.add(s);
      out.add("resources", arr);
      String json;
      try {
        json = JsonParser.compose(out, true);
      } catch (JsonException e) {
        throw new IOException(e);
      }
      byte[] bytes = json.getBytes(StandardCharsets.UTF_8);
      exchange.getResponseHeaders().set("Content-Type", "application/json");
      exchange.sendResponseHeaders(200, bytes.length);
      try (OutputStream os = exchange.getResponseBody()) {
        os.write(bytes);
      }
    } catch (Throwable e) {
      log.warn("/loadResource failed", e);
      sendOperationOutcome(exchange, 500,
        OperationOutcomeUtilities.createError("Load failed: " + e.getMessage()),
        getAcceptHeader(exchange));
    }
  }

  private static FhirFormat detectFormat(String formatParam, String contentType, byte[] body) {
    if (formatParam != null) {
      return "xml".equalsIgnoreCase(formatParam) ? FhirFormat.XML : FhirFormat.JSON;
    }
    if (contentType != null && contentType.toLowerCase().contains("xml")) {
      return FhirFormat.XML;
    }
    if (contentType != null && contentType.toLowerCase().contains("json")) {
      return FhirFormat.JSON;
    }
    // sniff: XML starts with '<', JSON with '{' or '['
    for (byte b : body) {
      if (b == '<') return FhirFormat.XML;
      if (b == '{' || b == '[') return FhirFormat.JSON;
      if (!Character.isWhitespace(b)) break;
    }
    return FhirFormat.JSON;
  }
}
