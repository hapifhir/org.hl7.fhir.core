package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpExchange;
import org.hl7.fhir.model.IModelContext;
import org.hl7.fhir.model.core.OperationOutcome;
import org.hl7.fhir.model.core.formats.JsonParser;
import org.hl7.fhir.model.core.formats.XmlParser;
import org.hl7.fhir.model.utilities.formats.FhirFormat;
import org.hl7.fhir.services.validation.constants.BestPracticeWarningLevel;
import org.hl7.fhir.services.validation.constants.CheckDisplayOption;
import org.hl7.fhir.services.validation.constants.IdStatus;
import org.hl7.fhir.model.utilities.OperationOutcomeUtilities;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class BaseHTTPHandler {

  private IModelContext context;

  public BaseHTTPHandler(IModelContext context) {
    this.context = context;
  }

  protected List<String> parseListParameter(String param) {
    if (param == null || param.trim().isEmpty()) {
      return new ArrayList<>();
    }
    @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
    //single literal character split
    String[] splitParam = param.split(",");
    return Arrays.asList(splitParam);
  }

  protected Map<String, String> parseQueryParams(String query) {
    Map<String, String> params = new HashMap<>();
    if (query != null) {
      @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
      //single literal character split
      String[] pairs = query.split("&");
      for (String pair : pairs) {
        @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
        //single literal character split
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

  /**
   * For a POST that carries a body, require the caller to declare a JSON or XML content type.
   * <p>
   * A browser can send a request to this server from any web page without a preflight only as a
   * CORS "simple" request, and a simple request cannot carry {@code application/json} or an XML
   * type - so insisting on one turns those requests away while affecting no real client, which
   * always declares what it is sending. An empty body is left alone so the handler's own
   * missing-body check still reports it.
   *
   * @return true to continue; false when a 415 has already been sent
   */
  protected boolean requireDeclaredBodyType(HttpExchange exchange, byte[] body) throws IOException {
    if (body == null || body.length == 0) {
      return true;
    }
    return requireDeclaredType(exchange);
  }

  /**
   * For a POST that takes no body but changes the server's state ({@code /stop},
   * {@code /txTest/setup} and {@code /txTest/teardown}), require a JSON or XML content type all
   * the same. An empty POST is a CORS simple request, so without this any web page could make
   * one; with it, a browser must send a preflight first, which this server does not answer.
   *
   * @return true to continue; false when a 415 has already been sent
   */
  protected boolean requireDeclaredType(HttpExchange exchange) throws IOException {
    if (isJsonOrXml(exchange.getRequestHeaders().getFirst("Content-Type"))) {
      return true;
    }
    sendOperationOutcome(exchange, 415, OperationOutcomeUtilities.createError(
      "A POST must declare a JSON or XML Content-Type"), getAcceptHeader(exchange));
    return false;
  }

  /**
   * Whether a content type is JSON or XML, judged on the media type before any parameters: a
   * browser decides whether a request is simple from that alone, so {@code text/plain;json} is
   * still text/plain.
   */
  static boolean isJsonOrXml(String contentType) {
    if (contentType == null) {
      return false;
    }
    String base = contentType.split(";")[0].trim().toLowerCase();
    return base.endsWith("/json") || base.endsWith("+json") || base.endsWith("/xml") || base.endsWith("+xml");
  }

  protected  FhirFormat determineFormat(String contentType) {
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

  protected String getAcceptHeader(HttpExchange exchange) {
    String accept = exchange.getRequestHeaders().getFirst("Accept");
    if (accept != null && accept.toLowerCase().contains("xml")) {
      return "xml";
    }
    return "json"; // Default
  }

  protected IdStatus parseIdStatus(String param) {
    if (param == null) return IdStatus.OPTIONAL;
    return IdStatus.valueOf(param.toUpperCase());
  }

  protected  boolean parseBooleanParameter(String param, boolean defaultValue) {
    if (param == null) return defaultValue;
    return "true".equalsIgnoreCase(param);
  }

  protected BestPracticeWarningLevel parseBestPracticeWarningLevel(String param) {
    if (param == null) return BestPracticeWarningLevel.Ignore;
    return BestPracticeWarningLevel.valueOf(param);
  }

  protected CheckDisplayOption parseCheckDisplayOption(String param) {
    if (param == null) return CheckDisplayOption.Ignore;
    return CheckDisplayOption.valueOf(param);
  }

  protected void sendOperationOutcome(HttpExchange exchange, int statusCode, OperationOutcome outcome, String format) throws IOException {
    try {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      if ("xml".equalsIgnoreCase(format)) {
        new XmlParser(context).compose(baos, outcome);
        sendResponse(exchange, statusCode, baos.toString(StandardCharsets.UTF_8.name()), "application/fhir+xml");
      } else {
        new JsonParser(context).compose(baos, outcome);
        sendResponse(exchange, statusCode, baos.toString(StandardCharsets.UTF_8.name()), "application/fhir+json");
      }
    } catch (Exception e) {
      sendResponse(exchange, 500, "Error serializing response: " + e.getMessage(), "text/plain");
    }
  }

  protected void sendResource(HttpExchange exchange, int statusCode, org.hl7.fhir.model.core.Resource resource, String format) throws IOException {
    try {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      if ("xml".equalsIgnoreCase(format)) {
        new XmlParser(context).compose(baos, resource);
        sendResponse(exchange, statusCode, baos.toString(StandardCharsets.UTF_8.name()), "application/fhir+xml");
      } else {
        new JsonParser(context).compose(baos, resource);
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
