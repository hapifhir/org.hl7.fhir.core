package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpExchange;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.utils.validation.constants.BestPracticeWarningLevel;
import org.hl7.fhir.r5.utils.validation.constants.CheckDisplayOption;
import org.hl7.fhir.r5.utils.validation.constants.IdStatus;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class BaseHTTPHandler {

  protected List<String> parseListParameter(String param) {
    if (param == null || param.trim().isEmpty()) {
      return new ArrayList<>();
    }
    return Arrays.asList(param.split(","));
  }

  protected Map<String, String> parseQueryParams(String query) {
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

  protected  byte[] readRequestBody(HttpExchange exchange) throws IOException {
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

  protected  Manager.FhirFormat determineFormat(String contentType) {
    if (contentType == null) {
      return Manager.FhirFormat.JSON; // Default
    }
    contentType = contentType.toLowerCase();
    if (contentType.contains("xml")) {
      return Manager.FhirFormat.XML;
    } else if (contentType.contains("json")) {
      return Manager.FhirFormat.JSON;
    } else {
      return Manager.FhirFormat.JSON; // Default
    }
  }

  protected String getAcceptHeader(HttpExchange exchange) {
    String accept = exchange.getRequestHeaders().getFirst("Accept");
    if (accept != null && accept.toLowerCase().contains("xml")) {
      return "xml";
    }
    return "json"; // Default
  }

  protected  IdStatus parseIdStatus(String param) {
    if (param == null) return IdStatus.OPTIONAL;
    return IdStatus.valueOf(param.toUpperCase());
  }

  protected  boolean parseBooleanParameter(String param, boolean defaultValue) {
    if (param == null) return defaultValue;
    return "true".equalsIgnoreCase(param);
  }

  protected  BestPracticeWarningLevel parseBestPracticeWarningLevel(String param) {
    if (param == null) return BestPracticeWarningLevel.Ignore;
    return BestPracticeWarningLevel.valueOf(param);
  }

  protected  CheckDisplayOption parseCheckDisplayOption(String param) {
    if (param == null) return CheckDisplayOption.Ignore;
    return CheckDisplayOption.valueOf(param);
  }

  protected  OperationOutcome createSuccessOperationOutcome(String message) {
    OperationOutcome outcome = new OperationOutcome();
    OperationOutcome.OperationOutcomeIssueComponent issue = outcome.addIssue();
    issue.setSeverity(OperationOutcome.IssueSeverity.INFORMATION);
    issue.setCode(OperationOutcome.IssueType.INFORMATIONAL);
    issue.setDiagnostics(message);
    return outcome;
  }

  protected  OperationOutcome createErrorOperationOutcome(String message) {
    OperationOutcome outcome = new OperationOutcome();
    OperationOutcome.OperationOutcomeIssueComponent issue = outcome.addIssue();
    issue.setSeverity(OperationOutcome.IssueSeverity.ERROR);
    issue.setCode(OperationOutcome.IssueType.EXCEPTION);
    issue.setDiagnostics(message);
    return outcome;
  }

  protected void sendOperationOutcome(HttpExchange exchange, int statusCode, OperationOutcome outcome, String format) throws IOException {
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

  protected void sendResponse(HttpExchange exchange, int statusCode, String response, String contentType) throws IOException {
    byte[] responseBytes = response.getBytes(StandardCharsets.UTF_8);
    exchange.getResponseHeaders().set("Content-Type", contentType);
    exchange.sendResponseHeaders(statusCode, responseBytes.length);
    try (OutputStream os = exchange.getResponseBody()) {
      os.write(responseBytes);
    }
  }


}
