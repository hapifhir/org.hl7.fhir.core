package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * Base class for GITB-compatible REST processing service endpoints.
 * <p>
 * Each service exposes:
 * <ul>
 *   <li>GET /api/{service}/definition — service metadata</li>
 *   <li>POST /api/{service}/process — execute an operation</li>
 * </ul>
 */
abstract class GitbServiceHandler extends BaseHTTPHandler implements HttpHandler {

  protected final FhirValidatorHttpService fhirValidatorHttpService;

  GitbServiceHandler(FhirValidatorHttpService fhirValidatorHttpService) {
    this.fhirValidatorHttpService = fhirValidatorHttpService;
  }

  /** Return the service definition as a JsonObject. */
  protected abstract JsonObject buildDefinition();

  /** Execute the operation. Return a JsonObject with "result", "output", and optionally "error". */
  protected abstract JsonObject doProcess(String operation, JsonObject inputs) throws Exception;

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    addCorsHeaders(exchange);
    if (handleCorsPreFlight(exchange)) return;

    String path = exchange.getRequestURI().getPath();

    try {
      if (path.endsWith("/definition") && "GET".equals(exchange.getRequestMethod())) {
        sendJson(exchange, 200, buildDefinition());
      } else if (path.endsWith("/process") && "POST".equals(exchange.getRequestMethod())) {
        byte[] body = readRequestBody(exchange);
        JsonObject request = JsonParser.parseObject(body);
        String operation = request.asString("operation");
        JsonObject inputs = request.hasObject("inputs") ? request.getJsonObject("inputs") : new JsonObject();
        JsonObject response = doProcess(operation, inputs);
        sendJson(exchange, 200, response);
      } else {
        sendJson(exchange, 404, failure("Not found. Use /definition (GET) or /process (POST)."));
      }
    } catch (Exception e) {
      sendJson(exchange, 500, failure(e.getMessage()));
    }
  }

  protected void sendJson(HttpExchange exchange, int statusCode, JsonObject json) throws IOException {
    byte[] bytes = JsonParser.composeBytes(json);
    exchange.getResponseHeaders().set("Content-Type", "application/json");
    exchange.sendResponseHeaders(statusCode, bytes.length);
    try (OutputStream os = exchange.getResponseBody()) {
      os.write(bytes);
    }
  }

  protected static JsonObject success(JsonObject output) {
    JsonObject resp = new JsonObject();
    resp.add("result", "SUCCESS");
    resp.add("output", output);
    return resp;
  }

  protected static JsonObject failure(String error) {
    JsonObject resp = new JsonObject();
    resp.add("result", "FAILURE");
    resp.add("error", error != null ? error : "Unknown error");
    return resp;
  }

  protected static JsonObject definition(String id, String[] operations, InputDef[] inputs, String[] outputs) {
    JsonObject def = new JsonObject();
    def.add("id", id);
    JsonArray ops = new JsonArray();
    for (String op : operations) ops.add(op);
    def.add("operations", ops);
    JsonArray ins = new JsonArray();
    for (InputDef input : inputs) {
      JsonObject in = new JsonObject();
      in.add("name", input.name);
      in.add("type", input.type);
      in.add("required", input.required);
      ins.add(in);
    }
    def.add("inputs", ins);
    JsonArray outs = new JsonArray();
    for (String out : outputs) {
      JsonObject o = new JsonObject();
      o.add("name", out);
      o.add("type", "string");
      outs.add(o);
    }
    def.add("outputs", outs);
    return def;
  }

  protected static String requireInput(JsonObject inputs, String name) throws Exception {
    String val = inputs.asString(name);
    if (val == null || val.trim().isEmpty()) {
      throw new Exception("Missing required input: " + name);
    }
    return val;
  }

  protected static String optionalInput(JsonObject inputs, String name, String defaultValue) {
    String val = inputs.asString(name);
    return (val == null || val.trim().isEmpty()) ? defaultValue : val;
  }

  static class InputDef {
    final String name;
    final String type;
    final boolean required;
    InputDef(String name, String type, boolean required) {
      this.name = name;
      this.type = type;
      this.required = required;
    }
  }
}
