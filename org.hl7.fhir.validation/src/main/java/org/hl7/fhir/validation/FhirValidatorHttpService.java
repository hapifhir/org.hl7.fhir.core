package org.hl7.fhir.validation;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.utils.validation.constants.BestPracticeWarningLevel;
import org.hl7.fhir.r5.utils.validation.constants.CheckDisplayOption;
import org.hl7.fhir.r5.utils.validation.constants.IdStatus;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.validation.instance.ResourcePercentageLogger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * HTTP service wrapper for the FHIR validator using ValidationEngine and IGLoader directly
 */
@Slf4j
public class FhirValidatorHttpService {

  private final ValidationEngine validationEngine;
  private HttpServer server;
  private final int port;

  public FhirValidatorHttpService(ValidationEngine validationEngine, int port) {
    this.validationEngine = validationEngine;
    this.port = port;
    ResourcePercentageLogger.setLoggingSuppressed(true);
  }

  public void startServer() throws IOException {
    // Create HTTP server
    server = HttpServer.create(new InetSocketAddress(port), 0);

    server.createContext("/validateResource", new ValidateResourceHandler());

    // Start the server
    server.setExecutor(null); // Use default executor
    server.start();

    log.info("FHIR Validator HTTP Service started on port " + port);
  }

  /**
   * Stop the HTTP server
   */
  public void stop() {
    if (server != null) {
      server.stop(0);
      log.info("FHIR Validator HTTP Service stopped");
    }
  }

  /**
   * Handler for validating resources
   */
  private class ValidateResourceHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
      if (!"POST".equals(exchange.getRequestMethod())) {
        sendResponse(exchange, 405, "Method not allowed", "text/plain");
        return;
      }

      List<String> profiles = null;
      IdStatus resourceIdRule = null;
      boolean anyExtensionsAllowed = false;
      BestPracticeWarningLevel bpWarnings = null;
      CheckDisplayOption displayOption = null;
      byte[] resourceBytes = null;
      FhirFormat format = null;

      try {
        // Read resource bytes from request body
        resourceBytes = readRequestBody(exchange);

        // Get content type and determine format
        String contentType = exchange.getRequestHeaders().getFirst("Content-Type");
        format = determineFormat(contentType);

        // Parse validation parameters from query string
        Map<String, String> params = parseQueryParams(exchange.getRequestURI().getQuery());

        profiles = parseListParameter(params.get("profiles"));
        resourceIdRule = parseIdStatus(params.get("resourceIdRule"));
        anyExtensionsAllowed = parseBooleanParameter(params.get("anyExtensionsAllowed"), true);
        bpWarnings = parseBestPracticeWarningLevel(params.get("bpWarnings"));
        displayOption = parseCheckDisplayOption(params.get("displayOption"));
      } catch (Exception e) {
        OperationOutcome outcome = createErrorOperationOutcome("Operation failed: " + e.getMessage());
        sendOperationOutcome(exchange, 400, outcome, getAcceptHeader(exchange));
        return;
      }
      try {
        // Validate the resource using ValidationEngine
        OperationOutcome outcome = validationEngine.validate("http-request", resourceBytes, format, profiles,
          resourceIdRule, anyExtensionsAllowed, bpWarnings, displayOption);

        sendOperationOutcome(exchange, 200, outcome, getAcceptHeader(exchange));

      } catch (Throwable e) {
        OperationOutcome outcome = createErrorOperationOutcome("Validation failed: " + e.getMessage());
        sendOperationOutcome(exchange, 500, outcome, getAcceptHeader(exchange));
      }
    }
  }

  // Utility methods

  private Map<String, String> parseQueryParams(String query) {
    Map<String, String> params = new HashMap<>();
    if (query != null) {
      String[] pairs = query.split("&");
      for (String pair : pairs) {
        String[] keyValue = pair.split("=", 2);
        if (keyValue.length == 2) {
          try {
            String key = URLDecoder.decode(keyValue[0], StandardCharsets.UTF_8.name());
            String value = URLDecoder.decode(keyValue[1], StandardCharsets.UTF_8.name());
            params.put(key, value);
          } catch (Exception e) {
            // Skip malformed parameters
          }
        }
      }
    }
    return params;
  }

  private byte[] readRequestBody(HttpExchange exchange) throws IOException {
    try (InputStream is = exchange.getRequestBody()) {
      ByteArrayOutputStream buffer = new ByteArrayOutputStream();
      byte[] data = new byte[1024];
      int nRead;
      while ((nRead = is.read(data, 0, data.length)) != -1) {
        buffer.write(data, 0, nRead);
      }
      return buffer.toByteArray();
    }
  }

  private FhirFormat determineFormat(String contentType) {
    if (contentType == null) {
      return FhirFormat.JSON; // Default
    }
    contentType = contentType.toLowerCase();
    if (contentType.contains("xml")) {
      return FhirFormat.XML;
    } else if (contentType.contains("json")) {
      return FhirFormat.JSON;
    } else {
      return FhirFormat.JSON; // Default
    }
  }

  private String getAcceptHeader(HttpExchange exchange) {
    String accept = exchange.getRequestHeaders().getFirst("Accept");
    if (accept != null && accept.toLowerCase().contains("xml")) {
      return "xml";
    }
    return "json"; // Default
  }

  private List<String> parseListParameter(String param) {
    if (param == null || param.trim().isEmpty()) {
      return new ArrayList<>();
    }
    return Arrays.asList(param.split(","));
  }

  private IdStatus parseIdStatus(String param) {
    if (param == null) return IdStatus.OPTIONAL;
    return IdStatus.valueOf(param.toUpperCase());
  }

  private boolean parseBooleanParameter(String param, boolean defaultValue) {
    if (param == null) return defaultValue;
    return "true".equalsIgnoreCase(param);
  }

  private BestPracticeWarningLevel parseBestPracticeWarningLevel(String param) {
    if (param == null) return BestPracticeWarningLevel.Ignore;
    return BestPracticeWarningLevel.valueOf(param);
  }

  private CheckDisplayOption parseCheckDisplayOption(String param) {
    if (param == null) return CheckDisplayOption.Ignore;
    return CheckDisplayOption.valueOf(param);
  }

  private OperationOutcome createSuccessOperationOutcome(String message) {
    OperationOutcome outcome = new OperationOutcome();
    OperationOutcome.OperationOutcomeIssueComponent issue = outcome.addIssue();
    issue.setSeverity(OperationOutcome.IssueSeverity.INFORMATION);
    issue.setCode(OperationOutcome.IssueType.INFORMATIONAL);
    issue.setDiagnostics(message);
    return outcome;
  }

  private OperationOutcome createErrorOperationOutcome(String message) {
    OperationOutcome outcome = new OperationOutcome();
    OperationOutcome.OperationOutcomeIssueComponent issue = outcome.addIssue();
    issue.setSeverity(OperationOutcome.IssueSeverity.ERROR);
    issue.setCode(OperationOutcome.IssueType.EXCEPTION);
    issue.setDiagnostics(message);
    return outcome;
  }

  private void sendOperationOutcome(HttpExchange exchange, int statusCode, OperationOutcome outcome, String format) throws IOException {
    try {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      if ("xml".equalsIgnoreCase(format)) {
        new XmlParser().compose(baos, outcome);
        sendResponse(exchange, statusCode, baos.toString(StandardCharsets.UTF_8.name()), "application/fhir+xml");
      } else {
        new JsonParser().compose(baos, outcome);
        sendResponse(exchange, statusCode, baos.toString(StandardCharsets.UTF_8.name()), "application/fhir+json");
      }
    } catch (Exception e) {
      sendResponse(exchange, 500, "Error serializing response: " + e.getMessage(), "text/plain");
    }
  }

  private void sendResponse(HttpExchange exchange, int statusCode, String response, String contentType) throws IOException {
    byte[] responseBytes = response.getBytes(StandardCharsets.UTF_8);
    exchange.getResponseHeaders().set("Content-Type", contentType);
    exchange.sendResponseHeaders(statusCode, responseBytes.length);
    try (OutputStream os = exchange.getResponseBody()) {
      os.write(responseBytes);
    }
  }
}