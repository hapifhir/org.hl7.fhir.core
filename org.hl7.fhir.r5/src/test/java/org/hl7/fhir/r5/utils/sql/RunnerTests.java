package org.hl7.fhir.r5.utils.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.json.model.JsonNull;
import org.hl7.fhir.utilities.json.model.JsonNumber;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link Runner} behaviour that the official SQL on FHIR suite does not exercise:
 * the trickle-mode resource type check, integer64 values beyond the int range, and the exception
 * type raised for FHIRPath features the runner does not support.
 *
 * @author John Grimes
 */
class RunnerTests {

  private static IWorkerContext context;

  @BeforeAll
  static void setUpAll() {
    context = TestingUtilities.getSharedWorkerContext();
  }

  private static Resource parseResource(String json) throws Exception {
    return new org.hl7.fhir.r5.formats.JsonParser()
        .parse(new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8)));
  }

  private static Runner newRunner(TestProvider provider, TestStorage storage) {
    Runner runner = new Runner();
    runner.setContext(context);
    runner.setProvider(provider);
    runner.setStorage(storage);
    return runner;
  }

  private static final String PATIENT_VIEW = "{\"resourceType\":\"ViewDefinition\",\"name\":\"t\",\"status\":\"active\","
      + "\"resource\":\"Patient\",\"select\":[{\"column\":[{\"name\":\"id\",\"path\":\"id\"},{\"name\":\"g\",\"path\":\"gender\"}]}]}";

  // Spec, Process a Resource step 1: a resource whose type differs from ViewDefinition.resource
  // produces no rows. Batch mode fetches by type, so only the trickle entry point can see one.
  @Test
  void trickleModeIgnoresResourcesOfAnotherType() throws Exception {
    TestStorage storage = new TestStorage();
    Runner runner = newRunner(new TestProvider(), storage);
    Runner.WorkContext wc = runner.prepare("VD", JsonParser.parseObject(PATIENT_VIEW));

    runner.processResource(wc, parseResource(
        "{\"resourceType\":\"Observation\",\"id\":\"o1\",\"status\":\"final\",\"code\":{\"text\":\"x\"}}"));
    runner.processResource(wc, parseResource("{\"resourceType\":\"Patient\",\"id\":\"p1\",\"gender\":\"male\"}"));
    runner.finish(wc);

    assertEquals(1, storage.getResults().size(), "only the Patient may produce a row");
    assertEquals("p1", ((JsonObject) storage.getResults().get(0)).asString("id"));
  }

  // integer64 is a 64-bit type; a constant above Integer.MAX_VALUE must flow through to the output
  // as a number rather than fail in the runner.
  @Test
  void integer64ValueBeyondIntRangeIsEmitted() throws Exception {
    TestStorage storage = new TestStorage();
    TestProvider provider = new TestProvider();
    provider.addResource(parseResource("{\"resourceType\":\"Patient\",\"id\":\"p1\"}"));
    Runner runner = newRunner(provider, storage);

    runner.execute(JsonParser.parseObject("{\"resourceType\":\"ViewDefinition\",\"name\":\"t\",\"status\":\"active\","
        + "\"resource\":\"Patient\",\"constant\":[{\"name\":\"big\",\"valueInteger64\":9999999999}],"
        + "\"select\":[{\"column\":[{\"name\":\"big\",\"path\":\"%big\",\"type\":\"integer64\"}]}]}"));

    JsonObject row = (JsonObject) storage.getResults().get(0);
    assertEquals("9999999999", ((JsonNumber) row.get("big")).getValue());
  }

  private static final String OBSERVATION = "{\"resourceType\":\"Observation\",\"id\":\"o1\",\"status\":\"final\","
      + "\"code\":{\"text\":\"x\"},\"subject\":{\"reference\":\"Patient/p1\"}}";

  private static JsonObject observationView(String path) throws Exception {
    return JsonParser.parseObject("{\"resourceType\":\"ViewDefinition\",\"name\":\"t\",\"status\":\"active\","
        + "\"resource\":\"Observation\",\"select\":[{\"column\":[{\"name\":\"s\",\"path\":\"" + path + "\"}]}]}");
  }

  // A view that uses a FHIRPath feature the runner does not provide (memberOf() needs a
  // terminology service) fails with a FHIRException the caller can handle, not a java.lang.Error.
  @Test
  void unsupportedFhirPathFunctionFailsWithFhirException() throws Exception {
    TestStorage storage = new TestStorage();
    TestProvider provider = new TestProvider();
    provider.addResource(parseResource(OBSERVATION));
    Runner runner = newRunner(provider, storage);
    JsonObject view = observationView("status.memberOf('http://example.org/vs')");

    FHIRException e = assertThrows(FHIRException.class, () -> runner.execute(view));
    assertTrue(e.getMessage().contains("memberOf()"), e.getMessage());
  }

  // The engine treats a resolver failure as "cannot resolve", which FHIRPath defines as empty. A
  // resolve() column therefore comes out null rather than taking the run down.
  @Test
  void resolveYieldsEmptyRatherThanFailing() throws Exception {
    TestStorage storage = new TestStorage();
    TestProvider provider = new TestProvider();
    provider.addResource(parseResource(OBSERVATION));
    Runner runner = newRunner(provider, storage);

    runner.execute(observationView("subject.resolve().id"));

    assertEquals(1, storage.getResults().size());
    assertTrue(((JsonObject) storage.getResults().get(0)).get("s") instanceof JsonNull);
  }
}
