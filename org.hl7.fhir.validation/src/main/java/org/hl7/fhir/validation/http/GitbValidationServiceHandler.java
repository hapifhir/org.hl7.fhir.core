package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpExchange;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;

import java.io.IOException;

/**
 * GITB Validation Service base handler. Implements the dispatch contract from
 * {@code gitb_vs.wsdl} / {@code gitb_vs.xsd}:
 * <ul>
 *   <li>{@code GET  /<svc>/getModuleDefinition} → {@code GetModuleDefinitionResponse} = {@code {module: ValidationModule}}</li>
 *   <li>{@code POST /<svc>/validate}            → {@code ValidationResponse}          = {@code {report: TAR}}</li>
 * </ul>
 * Subclasses implement {@link #buildValidationModule()} (description of the service)
 * and {@link #doValidate(JsonArray, JsonArray, String)} (the actual validation,
 * returning a TAR JsonObject).
 */
abstract class GitbValidationServiceHandler extends GitbServiceHandler {

  protected GitbValidationServiceHandler(FhirValidatorHttpService service, String pathPrefix) {
    super(service, pathPrefix);
  }

  @Override
  protected final void dispatch(HttpExchange exchange, String method, String suffix) throws IOException {
    if ("GET".equalsIgnoreCase(method) && "/getModuleDefinition".equals(suffix)) {
      sendJson(exchange, 200, getModuleDefinitionResponse(buildValidationModule()));
      return;
    }
    if ("POST".equalsIgnoreCase(method) && "/validate".equals(suffix)) {
      handleValidate(exchange);
      return;
    }
    notFound(exchange);
  }

  private void handleValidate(HttpExchange exchange) throws IOException {
    JsonObject req = readJsonBody(exchange);
    if (req == null) return; // readJsonBody already sent the 400
    JsonArray input = inputArray(req);
    JsonArray config = req.has("config") && req.get("config").isJsonArray()
      ? req.getJsonArray("config")
      : new JsonArray();
    String sessionId = req.has("sessionId") ? req.asString("sessionId") : null;
    try {
      JsonObject report = doValidate(input, config, sessionId);
      sendJson(exchange, 200, validationResponse(report));
    } catch (MissingInputException | InvalidInputException e) {
      sendErrorJson(exchange, 400, e.getMessage());
    } catch (Throwable t) {
      sendErrorJson(exchange, 500, t.getClass().getSimpleName() + ": " + t.getMessage());
    }
  }

  /** Build the {@code ValidationModule} for this service. */
  protected abstract JsonObject buildValidationModule();

  /**
   * Run the validation. Returns a TAR JSON ({@code {id, date, result, counters,
   * overview, items[], context[]}}) which the base wraps as {@code {report: ...}}.
   */
  protected abstract JsonObject doValidate(JsonArray input, JsonArray config, String sessionId) throws Exception;
}
