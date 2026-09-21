package org.hl7.fhir.validation.tests;

import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.validation.ValidationEngine;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.validation.instance.MatchetypeValidator;
import org.hl7.fhir.validation.instance.MatchetypeMarkers;
import org.hl7.fhir.validation.special.TxTesterNormalizer;
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

  private ValidationEngine engine;

  @BeforeEach
  void setUp() throws IOException {
    engine = mock(ValidationEngine.class);
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
  @ValueSource(strings = {"fhir", "matchetype", "fhirPathAssertion", "fhirPath", "testdata", "validationResults", "igManager", "transform", "questionnaire", "package", "loadResource"})
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
  void transformProcessReturns400WhenContentInputIsEmpty() throws Exception {
    JsonObject body = processRequestBody("transform",
      anyContent("content", ""),
      anyContent("map", "http://example.org/StructureMap/x"));
    HttpResponse<String> response = post("/itb/transform/process", JsonParser.compose(body));
    assertEquals(400, response.statusCode());
    assertThat(JsonParser.parseObject(response.body()).asString("error")).contains("present but empty");
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
  void loadResourceModuleHasLoadResourceOperationWithRequiredContent() throws Exception {
    JsonObject body = JsonParser.parseObject(get("/itb/loadResource/getModuleDefinition").body());
    JsonObject module = body.getJsonObject("module");
    assertEquals("ResourceLoader", module.asString("id"));
    assertOperations(module, "loadResource");

    JsonArray ops = module.getJsonArray("operation");
    JsonObject load = null;
    for (JsonElement el : ops) {
      JsonObject o = el.asJsonObject();
      if ("loadResource".equals(o.asString("name"))) { load = o; break; }
    }
    assertTrue(load != null, "loadResource operation must be present in module definition");
    JsonArray inputs = load.getJsonObject("inputs").getJsonArray("param");
    java.util.Set<String> required = new java.util.HashSet<>();
    java.util.Set<String> optional = new java.util.HashSet<>();
    for (JsonElement el : inputs) {
      JsonObject p = el.asJsonObject();
      ("R".equals(p.asString("use")) ? required : optional).add(p.asString("name"));
    }
    assertTrue(required.contains("content"), "loadResource.content must be required");
    assertTrue(optional.contains("format"),  "loadResource.format must be optional");
  }

  @Test
  void loadResourceProcessReturns400WhenContentInputIsMissing() throws Exception {
    JsonObject body = processRequestBody("loadResource"); // no input — content is required
    HttpResponse<String> response = post("/itb/loadResource/process", JsonParser.compose(body));
    assertEquals(400, response.statusCode());
    assertThat(JsonParser.parseObject(response.body()).asString("error")).contains("Missing required input");
  }

  @Test
  void loadResourceProcessReturns400ForUnknownOperation() throws Exception {
    JsonObject body = processRequestBody("flubber",
      anyContent("content", "{\"resourceType\":\"Patient\"}"));
    HttpResponse<String> response = post("/itb/loadResource/process", JsonParser.compose(body));
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
  // POST /itb/matchetype/validate with normalize=tx
  //
  // Without the input the comparison is positional and a response that differs only in
  // array order fails; with normalize=tx the actual is scrubbed and sorted first, the way
  // the terminology test runner does it. The mocked engine is given a real context and the
  // comparison the real engine performs, so the handler's own work is what is tested.
  // ------------------------------------------------------------------

  /** A $lookup response as a server might return it. */
  private static final String LOOKUP = "{\"resourceType\":\"Parameters\",\"parameter\":["
    + "{\"name\":\"name\",\"valueString\":\"LOINC\"},"
    + "{\"name\":\"display\",\"valueString\":\"Body weight\"},"
    + "{\"name\":\"designation\",\"part\":[{\"name\":\"language\",\"valueCode\":\"en\"},"
    + "{\"name\":\"use\",\"valueCoding\":{\"system\":\"http://snomed.info/sct\",\"code\":\"900000000000013009\"}},"
    + "{\"name\":\"value\",\"valueString\":\"Weight\"}]},"
    + "{\"name\":\"property\",\"part\":[{\"name\":\"code\",\"valueCode\":\"CLASS\"},{\"name\":\"value\",\"valueString\":\"BDYWGT.ATOM\"}]},"
    + "{\"name\":\"result\",\"valueBoolean\":true}"
    + "]}";

  private SimpleWorkerContext txContext() throws Exception {
    // the engine's context type; the shared test context is one
    return (SimpleWorkerContext) TestingUtilities.getSharedWorkerContext();
  }

  /** Stub the mocked engine with a real context and the comparison the real engine performs. */
  private void stubEngineForComparison() throws Exception {
    SimpleWorkerContext ctx = txContext();
    when(engine.getContext()).thenReturn(ctx);
    when(engine.compareMatchetype(any(), any(), any(), any(), anyBoolean(), any(), any())).thenAnswer(inv -> {
      byte[] actual = inv.getArgument(0);
      byte[] expected = inv.getArgument(2);
      boolean patternMode = inv.getArgument(4);
      java.util.Set<String> modes = inv.getArgument(5);
      java.util.Map<String, String> variables = inv.getArgument(6);
      Element act = Manager.parseSingle(ctx, new ByteArrayInputStream(actual), FhirFormat.JSON);
      Element exp = Manager.parseSingle(ctx, new ByteArrayInputStream(MatchetypeMarkers.toExtensions(expected)), FhirFormat.JSON);
      List<ValidationMessage> messages = new ArrayList<>();
      new MatchetypeValidator(new FHIRPathEngine(ctx), modes, null, variables).setPatternMode(patternMode).compare(messages, act.fhirType(), exp, act);
      OperationOutcome oo = new OperationOutcome();
      if (messages.isEmpty()) {
        oo.addIssue().setSeverity(OperationOutcome.IssueSeverity.INFORMATION).setCode(OperationOutcome.IssueType.INFORMATIONAL).setDiagnostics("Resource matches the matchetype");
      } else {
        for (ValidationMessage m : messages) {
          oo.addIssue().setSeverity(OperationOutcome.IssueSeverity.ERROR).setCode(OperationOutcome.IssueType.INVALID).setDiagnostics(m.getMessage());
        }
      }
      return oo;
    });
  }

  /** The expected file's form: the runner's scrub and sort applied to the fixture. */
  private String lookupAsExpectedFile() throws Exception {
    return new String(TxTesterNormalizer.normalizeJson(LOOKUP.getBytes(StandardCharsets.UTF_8), false), StandardCharsets.UTF_8);
  }

  /** The same content with the parameter array and every part array reversed. */
  private String lookupReversed() throws Exception {
    org.hl7.fhir.r5.formats.JsonParser jp = new org.hl7.fhir.r5.formats.JsonParser();
    Parameters p = (Parameters) jp.parse(LOOKUP.getBytes(StandardCharsets.UTF_8));
    Collections.reverse(p.getParameter());
    for (ParametersParameterComponent pp : p.getParameter()) {
      Collections.reverse(pp.getPart());
    }
    return new String(jp.composeBytes(p), StandardCharsets.UTF_8);
  }

  private JsonObject postMatchetype(JsonObject... inputs) throws Exception {
    HttpResponse<String> response = post("/itb/matchetype/validate", JsonParser.compose(validateRequestBody(inputs)));
    assertEquals(200, response.statusCode(), response.body());
    return JsonParser.parseObject(response.body());
  }

  @Test
  void matchetypeWithoutNormalizeStillFailsOnArrayOrder() throws Exception {
    stubEngineForComparison();
    JsonObject report = postMatchetype(
      anyContent("contentToValidate", lookupReversed()),
      anyContent("matchetype", lookupAsExpectedFile())).getJsonObject("report");
    assertEquals("FAILURE", report.asString("result"));
    assertTrue(report.getJsonObject("counters").asInteger("nrOfErrors") > 0);
  }

  @Test
  void matchetypeWithNormalizeTxAcceptsReorderedResponse() throws Exception {
    stubEngineForComparison();
    JsonObject report = postMatchetype(
      anyContent("contentToValidate", lookupReversed()),
      anyContent("matchetype", lookupAsExpectedFile()),
      anyContent("normalize", "tx")).getJsonObject("report");
    assertEquals("SUCCESS", report.asString("result"));
    assertEquals(0, report.getJsonObject("counters").asInteger("nrOfErrors"));
  }

  @Test
  void matchetypeNormalizeTouchesOnlyTheActual() throws Exception {
    // The matchetype is used as given: a reversed matchetype against a sorted actual fails
    // even with normalize=tx, because normalisation is never applied to the pattern.
    stubEngineForComparison();
    JsonObject report = postMatchetype(
      anyContent("contentToValidate", lookupAsExpectedFile()),
      anyContent("matchetype", lookupReversed()),
      anyContent("normalize", "tx")).getJsonObject("report");
    assertEquals("FAILURE", report.asString("result"));
  }

  @Test
  void matchetypeRejectsUnknownNormalizeValue() throws Exception {
    HttpResponse<String> response = post("/itb/matchetype/validate", JsonParser.compose(validateRequestBody(
      anyContent("contentToValidate", LOOKUP),
      anyContent("matchetype", LOOKUP),
      anyContent("normalize", "json"))));
    assertEquals(400, response.statusCode());
    assertThat(JsonParser.parseObject(response.body()).asString("error")).contains("normalize");
  }

  /** A capability statement as a server returns it, and the subset an expected file lists. */
  private static final String CAPSTMT_FULL = "{\"resourceType\":\"CapabilityStatement\",\"id\":\"srv\",\"status\":\"active\",\"date\":\"2026-01-01\",\"kind\":\"instance\",\"fhirVersion\":\"4.0.1\",\"format\":[\"application/fhir+xml\",\"application/fhir+json\"],\"rest\":[{\"mode\":\"server\",\"security\":{\"cors\":true},\"operation\":[{\"name\":\"expand\",\"definition\":\"http://hl7.org/fhir/OperationDefinition/ValueSet-expand\"},{\"name\":\"versions\",\"definition\":\"http://hl7.org/fhir/OperationDefinition/fhir-versions\"}]}]}";
  private static final String CAPSTMT_SUBSET = "{\"resourceType\":\"CapabilityStatement\",\"status\":\"active\",\"kind\":\"instance\",\"fhirVersion\":\"4.0.1\",\"format\":[\"application/fhir+json\"],\"rest\":[{\"mode\":\"server\",\"operation\":[{\"name\":\"versions\",\"definition\":\"http://hl7.org/fhir/OperationDefinition/fhir-versions\"}]}]}";

  @Test
  void matchetypeCompleteModeRejectsExtraContent() throws Exception {
    // The default: the resource must match the matchetype exactly, so a server's fuller
    // capability statement fails against the subset an expected file lists.
    stubEngineForComparison();
    JsonObject report = postMatchetype(
      anyContent("contentToValidate", CAPSTMT_FULL),
      anyContent("matchetype", CAPSTMT_SUBSET),
      anyContent("normalize", "tx")).getJsonObject("report");
    assertEquals("FAILURE", report.asString("result"));
  }

  @Test
  void matchetypePartialModeAcceptsASubsetMatchetype() throws Exception {
    // mode=partial: the matchetype is a subset the resource must contain, which is how the
    // terminology test runner compares the metadata tests.
    stubEngineForComparison();
    JsonObject report = postMatchetype(
      anyContent("contentToValidate", CAPSTMT_FULL),
      anyContent("matchetype", CAPSTMT_SUBSET),
      anyContent("normalize", "tx"),
      anyContent("mode", "partial")).getJsonObject("report");
    assertEquals("SUCCESS", report.asString("result"));
    assertEquals(0, report.getJsonObject("counters").asInteger("nrOfErrors"));
  }

  @Test
  void matchetypeRejectsUnknownMode() throws Exception {
    HttpResponse<String> response = post("/itb/matchetype/validate", JsonParser.compose(validateRequestBody(
      anyContent("contentToValidate", LOOKUP),
      anyContent("matchetype", LOOKUP),
      anyContent("mode", "lenient"))));
    assertEquals(400, response.statusCode());
    assertThat(JsonParser.parseObject(response.body()).asString("error")).contains("mode");
  }

  /** Repro A: an expansion parameter the expected file marks $optional$, and a server that omits it. */
  private static final String EXPAND_EXPECTED = "{\"resourceType\":\"ValueSet\",\"status\":\"active\",\"expansion\":{\"identifier\":\"$uuid$\",\"timestamp\":\"$instant$\",\"parameter\":[{\"name\":\"excludeNested\",\"valueBoolean\":true},{\"$optional$\":true,\"name\":\"version\",\"valueUri\":\"http://hl7.org/fhir/test/CodeSystem/simple|0.1.0\"}],\"contains\":[{\"system\":\"http://hl7.org/fhir/test/CodeSystem/simple\",\"code\":\"code1\",\"display\":\"Display 1\"}]}}";
  private static final String EXPAND_WITHOUT_OPTIONAL = "{\"resourceType\":\"ValueSet\",\"status\":\"active\",\"expansion\":{\"identifier\":\"urn:uuid:c0ffee00-0000-4000-8000-000000000001\",\"timestamp\":\"2026-01-01T00:00:00Z\",\"parameter\":[{\"name\":\"excludeNested\",\"valueBoolean\":true}],\"contains\":[{\"system\":\"http://hl7.org/fhir/test/CodeSystem/simple\",\"code\":\"code1\",\"display\":\"Display 1\"}]}}";
  /** Repro B: a designation use coding whose display is in $optional-properties$, and a server that omits it. */
  private static final String LOOKUP_EXPECTED = "{\"resourceType\":\"Parameters\",\"parameter\":[{\"name\":\"designation\",\"part\":[{\"name\":\"language\",\"valueCode\":\"en\"},{\"name\":\"use\",\"valueCoding\":{\"$optional-properties$\":[\"display\"],\"system\":\"http://snomed.info/sct\",\"code\":\"900000000000003001\",\"display\":\"Fully specified name\"}},{\"name\":\"value\",\"valueString\":\"Display 1\"}]},{\"name\":\"display\",\"valueString\":\"Display 1\"},{\"name\":\"name\",\"valueString\":\"Simple\"}]}";
  private static final String LOOKUP_WITHOUT_DISPLAY = "{\"resourceType\":\"Parameters\",\"parameter\":[{\"name\":\"designation\",\"part\":[{\"name\":\"language\",\"valueCode\":\"en\"},{\"name\":\"use\",\"valueCoding\":{\"system\":\"http://snomed.info/sct\",\"code\":\"900000000000003001\"}},{\"name\":\"value\",\"valueString\":\"Display 1\"}]},{\"name\":\"display\",\"valueString\":\"Display 1\"},{\"name\":\"name\",\"valueString\":\"Simple\"}]}";

  @Test
  void matchetypeOptionalArrayItemMayBeAbsent() throws Exception {
    // What the expected file marks $optional$ is allowed to be absent: the item count and
    // the positional comparison both skip it.
    stubEngineForComparison();
    JsonObject report = postMatchetype(
      anyContent("contentToValidate", EXPAND_WITHOUT_OPTIONAL),
      anyContent("matchetype", EXPAND_EXPECTED),
      anyContent("normalize", "tx")).getJsonObject("report");
    assertEquals("SUCCESS", report.asString("result"), JsonParser.compose(report));
  }

  @Test
  void matchetypeOptionalPropertyMayBeAbsent() throws Exception {
    // A property listed in $optional-properties$ is allowed to be absent.
    stubEngineForComparison();
    JsonObject report = postMatchetype(
      anyContent("contentToValidate", LOOKUP_WITHOUT_DISPLAY),
      anyContent("matchetype", LOOKUP_EXPECTED),
      anyContent("normalize", "tx")).getJsonObject("report");
    assertEquals("SUCCESS", report.asString("result"), JsonParser.compose(report));
  }

  @Test
  void matchetypeOptionalPropertyMayBePresentWhenTheMatchetypeLacksIt() throws Exception {
    // $optional-properties$ relaxes the property either way, as in the runner: a server that
    // sends a display the expected file lists as optional but does not itself carry passes.
    stubEngineForComparison();
    JsonObject report = postMatchetype(
      anyContent("contentToValidate", LOOKUP_EXPECTED.replace("\"$optional-properties$\":[\"display\"],", "")),
      anyContent("matchetype", LOOKUP_EXPECTED.replace(",\"display\":\"Fully specified name\"", "")),
      anyContent("normalize", "tx")).getJsonObject("report");
    assertEquals("SUCCESS", report.asString("result"), JsonParser.compose(report));
  }

  @Test
  void matchetypeStillRequiresWhatIsNotMarkedOptional() throws Exception {
    // The markers relax only what they name: the same response against the expected file
    // with the marker removed fails on the count, as before.
    stubEngineForComparison();
    JsonObject report = postMatchetype(
      anyContent("contentToValidate", EXPAND_WITHOUT_OPTIONAL),
      anyContent("matchetype", EXPAND_EXPECTED.replace("\"$optional$\":true,", "")),
      anyContent("normalize", "tx")).getJsonObject("report");
    assertEquals("FAILURE", report.asString("result"));
  }

  /** A parameter that is optional in the tx.fhir.org mode only, and one that exists in FHIR 4 only. */
  private static final String EXPAND_MODE_FILTER = "{\"resourceType\":\"ValueSet\",\"status\":\"active\",\"expansion\":{\"identifier\":\"urn:uuid:c0ffee00-0000-4000-8000-000000000001\",\"timestamp\":\"2026-01-01T00:00:00Z\",\"parameter\":[{\"name\":\"excludeNested\",\"valueBoolean\":true},{\"$optional$\":\"tx.fhir.org\",\"name\":\"warning-draft\",\"valueString\":\"draft\"}],\"contains\":[{\"system\":\"http://hl7.org/fhir/test/CodeSystem/simple\",\"code\":\"code1\",\"display\":\"Display 1\"}]}}";
  private static final String EXPAND_VERSION_FILTER = "{\"resourceType\":\"ValueSet\",\"status\":\"active\",\"expansion\":{\"identifier\":\"urn:uuid:c0ffee00-0000-4000-8000-000000000001\",\"timestamp\":\"2026-01-01T00:00:00Z\",\"parameter\":[{\"name\":\"excludeNested\",\"valueBoolean\":true},{\"$only$\":\"version:4\",\"name\":\"used-codesystem\",\"valueUri\":\"http://hl7.org/fhir/test/CodeSystem/simple|0.1.0\"}],\"contains\":[{\"system\":\"http://hl7.org/fhir/test/CodeSystem/simple\",\"code\":\"code1\",\"display\":\"Display 1\"}]}}";
  private static final String EXPAND_TWO_PARAMETERS = "{\"resourceType\":\"ValueSet\",\"status\":\"active\",\"expansion\":{\"identifier\":\"urn:uuid:c0ffee00-0000-4000-8000-000000000001\",\"timestamp\":\"2026-01-01T00:00:00Z\",\"parameter\":[{\"name\":\"excludeNested\",\"valueBoolean\":true},{\"name\":\"used-codesystem\",\"valueUri\":\"http://hl7.org/fhir/test/CodeSystem/simple|0.1.0\"}],\"contains\":[{\"system\":\"http://hl7.org/fhir/test/CodeSystem/simple\",\"code\":\"code1\",\"display\":\"Display 1\"}]}}";

  @Test
  void matchetypeModesInputDecidesModeFilters() throws Exception {
    // $optional$: "tx.fhir.org" - the item may be absent only when that mode is given.
    stubEngineForComparison();
    JsonObject without = postMatchetype(
      anyContent("contentToValidate", EXPAND_WITHOUT_OPTIONAL),
      anyContent("matchetype", EXPAND_MODE_FILTER),
      anyContent("normalize", "tx")).getJsonObject("report");
    assertEquals("FAILURE", without.asString("result"), JsonParser.compose(without));
    JsonObject with = postMatchetype(
      anyContent("contentToValidate", EXPAND_WITHOUT_OPTIONAL),
      anyContent("matchetype", EXPAND_MODE_FILTER),
      anyContent("normalize", "tx"),
      anyContent("modes", "general, tx.fhir.org")).getJsonObject("report");
    assertEquals("SUCCESS", with.asString("result"), JsonParser.compose(with));
  }

  @Test
  void matchetypeVersionInputDecidesVersionFilters() throws Exception {
    // $only$: "version:4" - required from a FHIR 4 server, not to be sent by a FHIR 5 one.
    stubEngineForComparison();
    JsonObject r4 = postMatchetype(
      anyContent("contentToValidate", EXPAND_TWO_PARAMETERS),
      anyContent("matchetype", EXPAND_VERSION_FILTER),
      anyContent("normalize", "tx"),
      anyContent("version", "4.0.1")).getJsonObject("report");
    assertEquals("SUCCESS", r4.asString("result"), JsonParser.compose(r4));
    JsonObject r5 = postMatchetype(
      anyContent("contentToValidate", EXPAND_TWO_PARAMETERS),
      anyContent("matchetype", EXPAND_VERSION_FILTER),
      anyContent("normalize", "tx"),
      anyContent("version", "5.0.0")).getJsonObject("report");
    assertEquals("FAILURE", r5.asString("result"), JsonParser.compose(r5));
    assertThat(JsonParser.compose(r5)).contains("not expected in this version or mode");
  }

  @Test
  void matchetypeRejectsUnknownVersion() throws Exception {
    HttpResponse<String> response = post("/itb/matchetype/validate", JsonParser.compose(validateRequestBody(
      anyContent("contentToValidate", LOOKUP),
      anyContent("matchetype", LOOKUP),
      anyContent("version", "2.0"))));
    assertEquals(400, response.statusCode());
    assertThat(JsonParser.parseObject(response.body()).asString("error")).contains("version");
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
