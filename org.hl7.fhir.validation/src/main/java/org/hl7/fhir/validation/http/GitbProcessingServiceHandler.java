package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpExchange;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;

import java.io.IOException;
import java.util.UUID;

/**
 * GITB Processing Service base handler. Implements the dispatch contract from
 * {@code gitb_ps.wsdl} / {@code gitb_ps.xsd}:
 * <ul>
 *   <li>{@code GET  /<svc>/getModuleDefinition} → {@code GetModuleDefinitionResponse} = {@code {module: ProcessingModule}}</li>
 *   <li>{@code POST /<svc>/beginTransaction}    → {@code BeginTransactionResponse}    = {@code {sessionId}}</li>
 *   <li>{@code POST /<svc>/process}             → {@code ProcessResponse}             = {@code {report: TAR, output: [AnyContent]}}</li>
 *   <li>{@code POST /<svc>/endTransaction}      → {@code 204 No Content}</li>
 * </ul>
 * The validator's processing services are stateless beyond loaded IGs, so
 * {@code beginTransaction} just returns a fresh UUID and {@code endTransaction}
 * is a no-op.
 */
abstract class GitbProcessingServiceHandler extends GitbServiceHandler {

  protected GitbProcessingServiceHandler(FhirValidatorHttpService service, String pathPrefix) {
    super(service, pathPrefix);
  }

  @Override
  protected final void dispatch(HttpExchange exchange, String method, String suffix) throws IOException {
    if ("GET".equalsIgnoreCase(method) && "/getModuleDefinition".equals(suffix)) {
      sendJson(exchange, 200, getModuleDefinitionResponse(buildProcessingModule()));
      return;
    }
    if ("POST".equalsIgnoreCase(method)) {
      switch (suffix) {
        case "/beginTransaction":
          handleBeginTransaction(exchange);
          return;
        case "/endTransaction":
          handleEndTransaction(exchange);
          return;
        case "/process":
          handleProcess(exchange);
          return;
        default:
          notFound(exchange);
          return;
      }
    }
    notFound(exchange);
  }

  private void handleBeginTransaction(HttpExchange exchange) throws IOException {
    JsonObject resp = new JsonObject();
    resp.add("sessionId", UUID.randomUUID().toString());
    sendJson(exchange, 200, resp);
  }

  private void handleEndTransaction(HttpExchange exchange) throws IOException {
    sendNoContent(exchange);
  }

  private void handleProcess(HttpExchange exchange) throws IOException {
    JsonObject req = readJsonBody(exchange);
    if (req == null) return;
    JsonArray input = inputArray(req);
    String operation = req.has("operation") ? req.asString("operation") : null;
    String sessionId = req.has("sessionId") ? req.asString("sessionId") : null;
    try {
      ProcessResult result = doProcess(operation, input, sessionId);
      sendJson(exchange, 200, processResponse(result.report, result.output));
    } catch (UnknownOperationException | MissingInputException | InvalidInputException e) {
      sendErrorJson(exchange, 400, e.getMessage());
    } catch (Throwable t) {
      sendErrorJson(exchange, 500, t.getClass().getSimpleName() + ": " + t.getMessage());
    }
  }

  /** Build the {@code ProcessingModule} for this service. */
  protected abstract JsonObject buildProcessingModule();

  /**
   * Execute one operation. {@code operation} may be {@code null} when the service
   * has only one operation; the implementation can ignore it in that case.
   */
  protected abstract ProcessResult doProcess(String operation, JsonArray input, String sessionId) throws Exception;

  /** Carrier for {@link #doProcess} return values. {@code output} may be empty. */
  protected static final class ProcessResult {
    final JsonObject report;
    final JsonArray output;
    ProcessResult(JsonObject report, JsonArray output) {
      this.report = report;
      this.output = output == null ? new JsonArray() : output;
    }
    static ProcessResult ofOutput(JsonArray output) {
      return new ProcessResult(null, output);
    }
    static ProcessResult ofReport(JsonObject report) {
      return new ProcessResult(report, null);
    }
  }
}
