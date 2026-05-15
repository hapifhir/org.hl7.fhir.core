package org.hl7.fhir.validation.tests;

import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.http.FhirValidatorHttpService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

/**
 * Integration tests for the GITB-faithful handlers exposed under {@code /itb/...}.
 * Each handler is one of:
 *   Validation Service: GET /<svc>/getModuleDefinition + POST /<svc>/validate
 *   Processing Service: GET /<svc>/getModuleDefinition + POST /<svc>/process + POST /<svc>/beginTransaction + POST /<svc>/endTransaction
 * <p>
 * Engine-free paths (definitions, ValidationResultsProcessor, error handling)
 * use a mocked ValidationEngine; engine-bound paths are covered by the broader
 * suite in {@code FhirValidatorHttpServiceTest}.
 */
class GitbHttpHandlersTest {

  private static final int TEST_PORT = 18091;
  private static final String BASE_URL = "http://localhost:" + TEST_PORT;

  private FhirValidatorHttpService service;
  private HttpClient client;

  @BeforeEach
  void setUp() throws IOException {
    ValidationEngine engine = mock(ValidationEngine.class);
    service = new FhirValidatorHttpService(engine, true, TEST_PORT);
    service.startServer();
    client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build();
  }

  @AfterEach
  void tearDown() {
    if (service != null) service.stop();
  }

  // ------------------------------------------------------------------
  // GET /itb/<svc>/getModuleDefinition for every service
  // ------------------------------------------------------------------

  @ParameterizedTest
  @ValueSource(strings = {"fhir", "matchetype", "fhirPathAssertion", "fhirPath", "testdata", "validationResults", "igManager", "transform", "questionnaire", "package"})
  void getModuleDefinitionReturnsModule(String svc) throws Exception {
    HttpResponse<String> response = get("/itb/" + svc + "/getModuleDefinition");
    assertEquals(200, response.statusCode(), "for /itb/" + svc + "/getModuleDefinition");
    JsonObject body = JsonParser.parseObject(response.body());
    assertTrue(body.has("module"), "response must wrap the module: " + body);
    JsonObject module = body.getJsonObject("module");
    assertTrue(module.has("id"), "module must include id");
    assertTrue(module.has("metadata"), "module must include metadata");
  }

  @Test
  void fhirModuleIsValidationServiceWithSingleValidateOperation() throws Exception {
    JsonObject body = JsonParser.parseObject(get("/itb/fhir/getModuleDefinition").body());
    JsonObject module = body.getJsonObject("module");
    assertEquals("FHIRValidator", module.asString("id"));
    assertEquals("validate", module.asString("operation"));
  }

  @Test
  void fhirPathModuleIsProcessingServiceWithEvaluateOperation() throws Exception {
    JsonObject body = JsonParser.parseObject(get("/itb/fhirPath/getModuleDefinition").body());
    JsonObject module = body.getJsonObject("module");
    assertEquals("FHIRPathProcessor", module.asString("id"));
    JsonArray ops = module.getJsonArray("operation");
    assertEquals(1, ops.size());
    assertEquals("evaluate", ops.get(0).asJsonObject().asString("name"));
  }

  @Test
  void igManagerModuleHasLoadIgOperation() throws Exception {
    JsonObject body = JsonParser.parseObject(get("/itb/igManager/getModuleDefinition").body());
    JsonObject module = body.getJsonObject("module");
    assertEquals("IGManager", module.asString("id"));
    JsonArray ops = module.getJsonArray("operation");
    assertEquals(1, ops.size());
    assertEquals("loadIG", ops.get(0).asJsonObject().asString("name"));
  }

  @Test
  void validationResultsModuleListsAllThreeOperations() throws Exception {
    JsonObject body = JsonParser.parseObject(get("/itb/validationResults/getModuleDefinition").body());
    JsonObject module = body.getJsonObject("module");
    assertEquals("ValidationResultsProcessor", module.asString("id"));
    assertOperations(module, "summarize", "filterBySeverity", "filterByText");
  }

  @Test
  void transformModuleHasTransformAndParseOperations() throws Exception {
    JsonObject body = JsonParser.parseObject(get("/itb/transform/getModuleDefinition").body());
    JsonObject module = body.getJsonObject("module");
    assertEquals("FHIRTransformer", module.asString("id"));
    assertOperations(module, "transform", "parse");

    JsonArray ops = module.getJsonArray("operation");
    JsonObject transform = null;
    JsonObject parse = null;
    for (JsonElement el : ops) {
      JsonObject o = el.asJsonObject();
      if ("transform".equals(o.asString("name"))) transform = o;
      if ("parse".equals(o.asString("name")))     parse = o;
    }
    assertTrue(transform != null, "transform operation must be present in module definition");
    assertTrue(parse != null,     "parse operation must be present in module definition");

    java.util.Set<String> tReq = new java.util.HashSet<>();
    java.util.Set<String> tOpt = new java.util.HashSet<>();
    for (JsonElement el : transform.getJsonObject("inputs").getJsonArray("param")) {
      JsonObject p = el.asJsonObject();
      ("R".equals(p.asString("use")) ? tReq : tOpt).add(p.asString("name"));
    }
    assertTrue(tReq.contains("content"),     "transform.content must be required");
    assertTrue(tReq.contains("map"),         "transform.map must be required");
    assertTrue(tOpt.contains("contentType"), "transform.contentType must be optional");
    assertTrue(tOpt.contains("targetFormat"),"transform.targetFormat must be optional");

    java.util.Set<String> pReq = new java.util.HashSet<>();
    java.util.Set<String> pOpt = new java.util.HashSet<>();
    for (JsonElement el : parse.getJsonObject("inputs").getJsonArray("param")) {
      JsonObject p = el.asJsonObject();
      ("R".equals(p.asString("use")) ? pReq : pOpt).add(p.asString("name"));
    }
    assertTrue(pReq.contains("content"),      "parse.content must be required");
    assertTrue(pOpt.contains("name"),         "parse.name must be optional");
    assertTrue(pOpt.contains("targetFormat"), "parse.targetFormat must be optional");
  }

  @Test
  void transformProcessReturns400WhenMapInputIsMissing() throws Exception {
    JsonObject body = processRequestBody("transform",
      anyContent("content", "{\"resourceType\":\"Patient\"}"));
    HttpResponse<String> response = post("/itb/transform/process", JsonParser.compose(body));
    assertEquals(400, response.statusCode());
    assertThat(JsonParser.parseObject(response.body()).asString("error")).contains("Missing required input");
  }

  @Test
  void transformParseReturns400WhenContentInputIsMissing() throws Exception {
    JsonObject body = processRequestBody("parse"); // no input — content is required
    HttpResponse<String> response = post("/itb/transform/process", JsonParser.compose(body));
    assertEquals(400, response.statusCode());
    assertThat(JsonParser.parseObject(response.body()).asString("error")).contains("Missing required input");
  }

  @Test
  void transformProcessReturns400ForUnknownOperation() throws Exception {
    JsonObject body = processRequestBody("flubber",
      anyContent("content", "{}"),
      anyContent("map", "http://example.org/StructureMap/x"));
    HttpResponse<String> response = post("/itb/transform/process", JsonParser.compose(body));
    assertEquals(400, response.statusCode());
    assertThat(JsonParser.parseObject(response.body()).asString("error")).contains("Unknown operation");
  }

  @Test
  void questionnaireModuleHasGenerateOperationWithRequiredProfile() throws Exception {
    JsonObject body = JsonParser.parseObject(get("/itb/questionnaire/getModuleDefinition").body());
    JsonObject module = body.getJsonObject("module");
    assertEquals("QuestionnaireGenerator", module.asString("id"));
    assertOperations(module, "generate");

    JsonArray ops = module.getJsonArray("operation");
    JsonObject generate = null;
    for (JsonElement el : ops) {
      JsonObject o = el.asJsonObject();
      if ("generate".equals(o.asString("name"))) { generate = o; break; }
    }
    assertTrue(generate != null, "generate operation must be present in module definition");
    JsonArray inputs = generate.getJsonObject("inputs").getJsonArray("param");
    java.util.Set<String> required = new java.util.HashSet<>();
    java.util.Set<String> optional = new java.util.HashSet<>();
    for (JsonElement el : inputs) {
      JsonObject p = el.asJsonObject();
      ("R".equals(p.asString("use")) ? required : optional).add(p.asString("name"));
    }
    assertTrue(required.contains("profile"),      "questionnaire.profile must be required");
    assertTrue(optional.contains("targetFormat"), "questionnaire.targetFormat must be optional");
    assertTrue(optional.contains("select"),       "questionnaire.select must be optional");
  }

  @Test
  void questionnaireProcessReturns400WhenProfileInputIsMissing() throws Exception {
    JsonObject body = processRequestBody("generate"); // no input array — profile is required
    HttpResponse<String> response = post("/itb/questionnaire/process", JsonParser.compose(body));
    assertEquals(400, response.statusCode());
    assertThat(JsonParser.parseObject(response.body()).asString("error")).contains("Missing required input");
  }

  @Test
  void questionnaireProcessReturns400ForUnknownOperation() throws Exception {
    JsonObject body = processRequestBody("flubber",
      anyContent("profile", "http://hl7.org/fhir/StructureDefinition/Patient"));
    HttpResponse<String> response = post("/itb/questionnaire/process", JsonParser.compose(body));
    assertEquals(400, response.statusCode());
    assertThat(JsonParser.parseObject(response.body()).asString("error")).contains("Unknown operation");
  }

  @Test
  void packageModuleHasPackageOperationWithRequiredResource() throws Exception {
    JsonObject body = JsonParser.parseObject(get("/itb/package/getModuleDefinition").body());
    JsonObject module = body.getJsonObject("module");
    assertEquals("PackageGenerator", module.asString("id"));
    assertOperations(module, "package");

    JsonArray ops = module.getJsonArray("operation");
    JsonObject pkg = null;
    for (JsonElement el : ops) {
      JsonObject o = el.asJsonObject();
      if ("package".equals(o.asString("name"))) { pkg = o; break; }
    }
    assertTrue(pkg != null, "package operation must be present in module definition");
    JsonArray inputs = pkg.getJsonObject("inputs").getJsonArray("param");
    java.util.Set<String> required = new java.util.HashSet<>();
    java.util.Set<String> optional = new java.util.HashSet<>();
    for (JsonElement el : inputs) {
      JsonObject p = el.asJsonObject();
      ("R".equals(p.asString("use")) ? required : optional).add(p.asString("name"));
    }
    assertTrue(required.contains("resource"),        "package.resource must be required");
    assertTrue(optional.contains("expandValueSets"), "package.expandValueSets must be optional");
    assertTrue(optional.contains("targetFormat"),    "package.targetFormat must be optional");
  }

  @Test
  void packageProcessReturns400WhenResourceInputIsMissing() throws Exception {
    JsonObject body = processRequestBody("package"); // no input — resource is required
    HttpResponse<String> response = post("/itb/package/process", JsonParser.compose(body));
    assertEquals(400, response.statusCode());
    assertThat(JsonParser.parseObject(response.body()).asString("error")).contains("Missing required input");
  }

  @Test
  void packageProcessReturns400ForUnknownOperation() throws Exception {
    JsonObject body = processRequestBody("flubber",
      anyContent("resource", "http://example.org/ImplementationGuide/x"));
    HttpResponse<String> response = post("/itb/package/process", JsonParser.compose(body));
    assertEquals(400, response.statusCode());
    assertThat(JsonParser.parseObject(response.body()).asString("error")).contains("Unknown operation");
  }

  @Test
  void testdataModuleListsGenerateGenerateBundleAndModify() throws Exception {
    JsonObject body = JsonParser.parseObject(get("/itb/testdata/getModuleDefinition").body());
    JsonObject module = body.getJsonObject("module");
    assertEquals("TestDataGenerator", module.asString("id"));
    assertOperations(module, "generate", "generateBundle", "modify");

    // The 'modify' operation must declare its required inputs (resource + operations).
    JsonArray ops = module.getJsonArray("operation");
    JsonObject modify = null;
    for (JsonElement el : ops) {
      JsonObject o = el.asJsonObject();
      if ("modify".equals(o.asString("name"))) { modify = o; break; }
    }
    assertTrue(modify != null, "modify operation must be present in module definition");
    JsonArray inputs = modify.getJsonObject("inputs").getJsonArray("param");
    java.util.Set<String> required = new java.util.HashSet<>();
    java.util.Set<String> optional = new java.util.HashSet<>();
    for (JsonElement el : inputs) {
      JsonObject p = el.asJsonObject();
      ("R".equals(p.asString("use")) ? required : optional).add(p.asString("name"));
    }
    assertTrue(required.contains("resource"),   "modify.resource must be required");
    assertTrue(required.contains("operations"), "modify.operations must be required");
    assertTrue(optional.contains("profile"),    "modify.profile must be optional");
    assertTrue(optional.contains("enforce"),    "modify.enforce must be optional");
  }

  // ------------------------------------------------------------------
  // ValidationResultsProcessor — pure JSON, no engine needed
  // ------------------------------------------------------------------

  @Test
  void validationResultsSummarizeCountsBySeverity() throws Exception {
    String outcome = "{\"resourceType\":\"OperationOutcome\",\"issue\":["
      + "{\"severity\":\"error\",\"code\":\"invalid\"},"
      + "{\"severity\":\"error\",\"code\":\"required\"},"
      + "{\"severity\":\"warning\",\"code\":\"informational\"},"
      + "{\"severity\":\"information\",\"code\":\"informational\"}"
      + "]}";
    JsonObject response = postProcess("/itb/validationResults/process", "summarize",
      anyContent("outcome", outcome));
    JsonArray output = response.getJsonArray("output");
    assertEquals("2", outputValue(output, "errors"));
    assertEquals("1", outputValue(output, "warnings"));
    assertEquals("1", outputValue(output, "information"));
  }

  @Test
  void validationResultsFilterBySeverityCountsAndReturnsFilteredOutcome() throws Exception {
    String outcome = "{\"resourceType\":\"OperationOutcome\",\"issue\":["
      + "{\"severity\":\"error\",\"code\":\"invalid\",\"details\":{\"text\":\"a\"}},"
      + "{\"severity\":\"warning\",\"code\":\"informational\",\"details\":{\"text\":\"b\"}}"
      + "]}";
    JsonObject response = postProcess("/itb/validationResults/process", "filterBySeverity",
      anyContent("outcome", outcome),
      anyContent("severity", "error"));
    JsonArray output = response.getJsonArray("output");
    assertEquals("1", outputValue(output, "count"));
    JsonObject filtered = JsonParser.parseObject(outputValue(output, "outcome"));
    assertEquals(1, filtered.getJsonArray("issue").size());
  }

  @Test
  void validationResultsFilterByTextMatchesSubstring() throws Exception {
    String outcome = "{\"resourceType\":\"OperationOutcome\",\"issue\":["
      + "{\"severity\":\"error\",\"details\":{\"text\":\"identifier system missing\"}},"
      + "{\"severity\":\"error\",\"details\":{\"text\":\"name required\"}}"
      + "]}";
    JsonObject response = postProcess("/itb/validationResults/process", "filterByText",
      anyContent("outcome", outcome),
      anyContent("text", "identifier"));
    assertEquals("1", outputValue(response.getJsonArray("output"), "count"));
  }

  // ------------------------------------------------------------------
  // Processing service lifecycle
  // ------------------------------------------------------------------

  @Test
  void beginTransactionReturnsSessionId() throws Exception {
    HttpResponse<String> response = post("/itb/validationResults/beginTransaction", "{}");
    assertEquals(200, response.statusCode());
    JsonObject body = JsonParser.parseObject(response.body());
    assertTrue(body.has("sessionId"), "must include sessionId");
    assertThat(body.asString("sessionId")).isNotBlank();
  }

  @Test
  void endTransactionReturnsNoContent() throws Exception {
    HttpResponse<String> response = post("/itb/validationResults/endTransaction", "{}");
    assertEquals(204, response.statusCode());
  }

  // ------------------------------------------------------------------
  // Error handling
  // ------------------------------------------------------------------

  @Test
  void processReturns400WhenRequiredInputIsMissing() throws Exception {
    JsonObject body = processRequestBody("summarize"); // no input array — outcome is required
    HttpResponse<String> response = post("/itb/validationResults/process", JsonParser.compose(body));
    assertEquals(400, response.statusCode());
    JsonObject json = JsonParser.parseObject(response.body());
    assertThat(json.asString("error")).contains("Missing required input");
  }

  @Test
  void processReturns400ForUnknownOperation() throws Exception {
    JsonObject body = processRequestBody("totallyMadeUp",
      anyContent("outcome", "{\"resourceType\":\"OperationOutcome\"}"));
    HttpResponse<String> response = post("/itb/validationResults/process", JsonParser.compose(body));
    assertEquals(400, response.statusCode());
    assertThat(JsonParser.parseObject(response.body()).asString("error")).contains("Unknown operation");
  }

  @Test
  void processReturns400OnMalformedJson() throws Exception {
    HttpResponse<String> response = post("/itb/validationResults/process", "{not valid json");
    assertEquals(400, response.statusCode());
    assertThat(JsonParser.parseObject(response.body()).asString("error")).contains("Malformed JSON");
  }

  @Test
  void unknownPathUnderServicePrefixReturns404() throws Exception {
    HttpResponse<String> response = get("/itb/fhir/somethingElse");
    assertEquals(404, response.statusCode());
  }

  @Test
  void definitionRequestUsingOldPathReturns404() throws Exception {
    // Sanity: the old /<svc>/definition path is gone; only /<svc>/getModuleDefinition works.
    HttpResponse<String> response = get("/itb/fhir/definition");
    assertEquals(404, response.statusCode());
  }

  // ------------------------------------------------------------------
  // Helpers
  // ------------------------------------------------------------------

  private static JsonObject anyContent(String name, String value) {
    JsonObject ac = new JsonObject();
    ac.add("name", name);
    ac.add("value", value);
    ac.add("embeddingMethod", "STRING");
    return ac;
  }

  private static JsonObject processRequestBody(String operation, JsonObject... inputs) {
    JsonObject body = new JsonObject();
    if (operation != null) body.add("operation", operation);
    JsonArray arr = new JsonArray();
    for (JsonObject ac : inputs) arr.add(ac);
    body.add("input", arr);
    return body;
  }

  private static JsonObject validateRequestBody(JsonObject... inputs) {
    JsonObject body = new JsonObject();
    JsonArray arr = new JsonArray();
    for (JsonObject ac : inputs) arr.add(ac);
    body.add("input", arr);
    return body;
  }

  private static String outputValue(JsonArray output, String name) {
    for (JsonElement el : output) {
      if (!el.isJsonObject()) continue;
      JsonObject ac = el.asJsonObject();
      if (name.equals(ac.asString("name"))) return ac.asString("value");
    }
    return null;
  }

  private static void assertOperations(JsonObject module, String... expected) {
    JsonArray ops = module.getJsonArray("operation");
    java.util.Set<String> seen = new java.util.HashSet<>();
    for (JsonElement el : ops) {
      seen.add(el.asJsonObject().asString("name"));
    }
    for (String op : expected) {
      assertTrue(seen.contains(op), "missing operation: " + op + " (got " + seen + ")");
    }
  }

  private HttpResponse<String> get(String path) throws IOException, InterruptedException {
    return client.send(
      HttpRequest.newBuilder().uri(URI.create(BASE_URL + path)).GET().build(),
      HttpResponse.BodyHandlers.ofString());
  }

  private HttpResponse<String> post(String path, String body) throws IOException, InterruptedException {
    return client.send(
      HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + path))
        .header("Content-Type", "application/json")
        .POST(HttpRequest.BodyPublishers.ofString(body))
        .build(),
      HttpResponse.BodyHandlers.ofString());
  }

  private JsonObject postProcess(String path, String operation, JsonObject... inputs) throws IOException, InterruptedException {
    JsonObject body = processRequestBody(operation, inputs);
    HttpResponse<String> response = post(path, JsonParser.compose(body));
    assertEquals(200, response.statusCode(), "Expected 200 OK, got " + response.statusCode() + ": " + response.body());
    return JsonParser.parseObject(response.body());
  }
}
