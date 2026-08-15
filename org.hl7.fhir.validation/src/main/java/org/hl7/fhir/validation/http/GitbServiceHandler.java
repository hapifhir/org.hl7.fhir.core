package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Base for the GITB-faithful REST handlers exposed under {@code /itb/<service>/...}.
 * <p>
 * Sub-paths and request/response shapes follow the GITB processing-service
 * ({@code gitb_ps.xsd}) and validation-service ({@code gitb_vs.xsd}) contracts:
 * <ul>
 *   <li>{@code GET  /<svc>/getModuleDefinition}    — every service</li>
 *   <li>{@code POST /<svc>/validate}               — validation services</li>
 *   <li>{@code POST /<svc>/beginTransaction}       — processing services</li>
 *   <li>{@code POST /<svc>/process}                — processing services</li>
 *   <li>{@code POST /<svc>/endTransaction}         — processing services</li>
 * </ul>
 * Inputs are always an {@code input[]} array of {@code AnyContent} items
 * ({@code {name, value, embeddingMethod, mimeType?, type?, encoding?, item?[]}}).
 * Outputs are an {@code output[]} array of AnyContent (processing) or absent
 * (validation — only {@code report: TAR} is returned).
 * <p>
 * Concrete handlers extend this class and implement {@link #dispatch(HttpExchange, String, String)}
 * to route the suffix (the path bit after the service prefix). Helpers in this
 * class cover the common AnyContent / JSON / HTTP plumbing.
 */
abstract class GitbServiceHandler extends BaseHTTPHandler implements HttpHandler {

  protected final FhirValidatorHttpService service;
  private final String pathPrefix;

  protected GitbServiceHandler(FhirValidatorHttpService service, String pathPrefix) {
    this.service = service;
    this.pathPrefix = pathPrefix;
  }

  @Override
  public final void handle(HttpExchange exchange) throws IOException {
    String path = exchange.getRequestURI().getPath();
    String suffix = path.startsWith(pathPrefix) ? path.substring(pathPrefix.length()) : path;
    if (suffix.endsWith("/")) suffix = suffix.substring(0, suffix.length() - 1);
    String method = exchange.getRequestMethod();
    try {
      dispatch(exchange, method, suffix);
    } catch (Throwable t) {
      sendResponse(exchange, 500, "Internal error: " + t.getMessage(), "text/plain");
    }
  }

  /**
   * Subclass dispatch. Subclasses match {@code method} + {@code suffix} (the latter
   * is the path tail starting with {@code /}, e.g. {@code /getModuleDefinition},
   * {@code /validate}, {@code /process}). Should call {@link #notFound(HttpExchange)}
   * when nothing matches.
   */
  protected abstract void dispatch(HttpExchange exchange, String method, String suffix) throws IOException;

  // ------------------------------------------------------------------
  // HTTP transport
  // ------------------------------------------------------------------

  protected void sendJson(HttpExchange exchange, int statusCode, JsonObject body) throws IOException {
    String text = JsonParser.compose(body, true);
    sendResponse(exchange, statusCode, text, "application/json");
  }

  protected void sendNoContent(HttpExchange exchange) throws IOException {
    exchange.sendResponseHeaders(204, -1);
    exchange.close();
  }

  protected void notFound(HttpExchange exchange) throws IOException {
    sendResponse(exchange, 404, "Not found", "text/plain");
  }

  protected void sendErrorJson(HttpExchange exchange, int statusCode, String message) throws IOException {
    JsonObject o = new JsonObject();
    o.add("error", message);
    sendJson(exchange, statusCode, o);
  }

  // ------------------------------------------------------------------
  // AnyContent helpers — request input[] and response output[]
  // ------------------------------------------------------------------

  /**
   * Parses the {@code input} array out of an incoming GITB request body.
   * Returns an empty array if absent. Throws on malformed JSON.
   */
  protected static JsonArray inputArray(JsonObject request) {
    if (request == null) return new JsonArray();
    if (!request.has("input")) return new JsonArray();
    JsonElement el = request.get("input");
    if (el.isJsonArray()) return el.asJsonArray();
    // Some clients send a single AnyContent object; wrap it to be lenient.
    if (el.isJsonObject()) {
      JsonArray arr = new JsonArray();
      arr.add(el);
      return arr;
    }
    return new JsonArray();
  }

  /** Find the first AnyContent in {@code input[]} with the given {@code name}, or null. */
  protected static JsonObject findInput(JsonArray inputs, String name) {
    for (JsonElement el : inputs) {
      if (!el.isJsonObject()) continue;
      JsonObject ac = el.asJsonObject();
      if (name.equals(ac.asString("name"))) return ac;
    }
    return null;
  }

  /**
   * Resolve the value of an AnyContent according to its {@code embeddingMethod}.
   * For {@code STRING} (the default), returns the raw string. For {@code BASE_64},
   * decodes to a UTF-8 string. {@code URI} is not yet implemented (would require
   * the SSRF-hardened fetch policy from §2.4 of documentation/itb-rest-spec.md); throws.
   */
  protected static String resolveValue(JsonObject anyContent) {
    String value = anyContent.asString("value");
    if (value == null) return "";
    String embedding = anyContent.has("embeddingMethod")
      ? anyContent.asString("embeddingMethod")
      : "STRING";
    if (embedding == null || embedding.isEmpty()) embedding = "STRING";
    switch (embedding.toUpperCase()) {
      case "STRING":
        return value;
      case "BASE_64":
      case "BASE64":
        try {
          return new String(Base64.getDecoder().decode(value), StandardCharsets.UTF_8);
        } catch (IllegalArgumentException e) {
          throw new InvalidInputException("Invalid base64 value for input '" + anyContent.asString("name") + "'");
        }
      case "URI":
        throw new InvalidInputException("embeddingMethod URI is not yet supported");
      default:
        throw new InvalidInputException("Unknown embeddingMethod '" + embedding + "' on input '" + anyContent.asString("name") + "'");
    }
  }

  /** Convenience: find by name AND resolve to a string in one call. Returns null when missing. */
  protected static String resolveInput(JsonArray inputs, String name) {
    JsonObject ac = findInput(inputs, name);
    return ac == null ? null : resolveValue(ac);
  }

  /** Like {@link #resolveInput} but throws {@link MissingInputException} when missing/empty. */
  protected static String requireInput(JsonArray inputs, String name) {
    String v = resolveInput(inputs, name);
    if (v == null || v.isEmpty()) {
      throw new MissingInputException("Missing required input: " + name);
    }
    return v;
  }

  /** Like {@link #resolveInput} but with a default fallback. */
  protected static String optionalInput(JsonArray inputs, String name, String defaultValue) {
    String v = resolveInput(inputs, name);
    return (v == null || v.isEmpty()) ? defaultValue : v;
  }

  protected static boolean optionalBooleanInput(JsonArray inputs, String name, boolean defaultValue) {
    String v = resolveInput(inputs, name);
    if (v == null || v.isEmpty()) return defaultValue;
    return Boolean.parseBoolean(v);
  }

  // ------------------------------------------------------------------
  // AnyContent helpers — response side
  // ------------------------------------------------------------------

  /** Build a single AnyContent JSON object suitable for {@code output[]} or TAR {@code context[]}. */
  protected static JsonObject anyContent(String name, String value, String mimeType) {
    JsonObject a = new JsonObject();
    a.add("name", name);
    a.add("value", value == null ? "" : value);
    a.add("embeddingMethod", "STRING");
    a.add("type", "string");
    if (mimeType != null) a.add("mimeType", mimeType);
    a.add("encoding", "UTF-8");
    a.add("forContext", true);
    a.add("forReport", true);
    return a;
  }

  /** ProcessResponse {@code = {report: TAR, output: [AnyContent]}}. */
  protected static JsonObject processResponse(JsonObject report, JsonArray output) {
    JsonObject r = new JsonObject();
    if (report != null) r.add("report", report);
    if (output != null && output.size() > 0) r.add("output", output);
    return r;
  }

  /** ValidationResponse {@code = {report: TAR}}. */
  protected static JsonObject validationResponse(JsonObject report) {
    JsonObject r = new JsonObject();
    r.add("report", report);
    return r;
  }

  // ------------------------------------------------------------------
  // Module-definition helpers
  // ------------------------------------------------------------------

  /** Build the {@code GetModuleDefinitionResponse} envelope around a module definition. */
  protected static JsonObject getModuleDefinitionResponse(JsonObject module) {
    JsonObject r = new JsonObject();
    r.add("module", module);
    return r;
  }

  /** Common metadata block for both ValidationModule and ProcessingModule. */
  protected static JsonObject metadata(String name, String version, String description) {
    JsonObject m = new JsonObject();
    m.add("name", name);
    m.add("version", version);
    if (description != null) m.add("description", description);
    return m;
  }

  /** Build a TypedParameters list ({@code {param: [{name, type, use, kind?, ...}]}}). */
  protected static JsonObject typedParameters(TypedParam... params) {
    JsonObject tp = new JsonObject();
    JsonArray paramArr = new JsonArray();
    for (TypedParam p : params) {
      JsonObject pj = new JsonObject();
      pj.add("name", p.name);
      pj.add("type", p.type);
      pj.add("use", p.required ? "R" : "O");
      if (p.description != null) pj.add("description", p.description);
      paramArr.add(pj);
    }
    tp.add("param", paramArr);
    return tp;
  }

  /** Build a ValidationModule JSON: {@code {metadata, configs?, inputs?, outputs?, @id, @operation}}. */
  protected static JsonObject validationModule(String id, String operation, JsonObject metadata, JsonObject inputs) {
    JsonObject m = new JsonObject();
    m.add("id", id);
    if (operation != null) m.add("operation", operation);
    m.add("metadata", metadata);
    if (inputs != null) m.add("inputs", inputs);
    return m;
  }

  /** Build a ProcessingModule JSON: {@code {metadata, configs?, operation: [ProcessingOperation], @id}}. */
  protected static JsonObject processingModule(String id, JsonObject metadata, ProcessingOperation... operations) {
    JsonObject m = new JsonObject();
    m.add("id", id);
    m.add("metadata", metadata);
    JsonArray ops = new JsonArray();
    for (ProcessingOperation op : operations) ops.add(op.toJson());
    m.add("operation", ops);
    return m;
  }

  // ------------------------------------------------------------------
  // Request body parsing
  // ------------------------------------------------------------------

  /**
   * Reads a JSON request body. Returns an empty object on empty body. Sends a
   * 400 with {@code error} when the body is non-empty and not parseable, then
   * returns null.
   */
  protected JsonObject readJsonBody(HttpExchange exchange) throws IOException {
    byte[] body = readRequestBody(exchange);
    if (body == null || body.length == 0) return new JsonObject();
    try {
      return JsonParser.parseObject(body);
    } catch (Exception e) {
      sendErrorJson(exchange, 400, "Malformed JSON: " + e.getMessage());
      return null;
    }
  }

  // ------------------------------------------------------------------
  // Descriptors and exceptions
  // ------------------------------------------------------------------

  /** Validation-/Processing-module input or output declaration. */
  protected static final class TypedParam {
    final String name;
    final String type;
    final boolean required;
    final String description;
    TypedParam(String name, String type, boolean required) {
      this(name, type, required, null);
    }
    TypedParam(String name, String type, boolean required, String description) {
      this.name = name;
      this.type = type;
      this.required = required;
      this.description = description;
    }
  }

  /** ProcessingOperation entry of a ProcessingModule. */
  protected static final class ProcessingOperation {
    final String name;
    final JsonObject inputs;
    final JsonObject outputs;
    ProcessingOperation(String name, JsonObject inputs, JsonObject outputs) {
      this.name = name;
      this.inputs = inputs;
      this.outputs = outputs;
    }
    JsonObject toJson() {
      JsonObject o = new JsonObject();
      o.add("name", name);
      if (inputs != null) o.add("inputs", inputs);
      if (outputs != null) o.add("outputs", outputs);
      return o;
    }
  }

  /** Thrown from {@link #requireInput} when a required input is missing or empty. → HTTP 400. */
  protected static final class MissingInputException extends RuntimeException {
    MissingInputException(String message) { super(message); }
  }

  /** Thrown when {@code embeddingMethod} or AnyContent value is unusable. → HTTP 400. */
  protected static final class InvalidInputException extends RuntimeException {
    InvalidInputException(String message) { super(message); }
  }

  /** Thrown when the {@code operation} field of a {@code process} request is unknown to the service. → HTTP 400. */
  protected static final class UnknownOperationException extends RuntimeException {
    UnknownOperationException(String operation, String supported) {
      super("Unknown operation: " + operation + ". Supported: " + supported);
    }
  }
}
