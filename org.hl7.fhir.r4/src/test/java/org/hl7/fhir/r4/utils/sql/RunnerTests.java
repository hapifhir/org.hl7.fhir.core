package org.hl7.fhir.r4.utils.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.context.IWorkerContext;
import org.hl7.fhir.r4.model.Resource;
import org.hl7.fhir.r4.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.json.model.JsonNull;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link Runner} behaviour that the official SQL on FHIR suite does not exercise:
 * the trickle-mode resource type check and the exception
 * type raised for FHIRPath features the runner does not support.
 *
 * @author John Grimes
 */
class RunnerTests {

  private static IWorkerContext context;

  @BeforeAll
  static void setUpAll() {
    context = TestingUtilities.context();
  }

  private static Resource parseResource(String json) throws Exception {
    return new org.hl7.fhir.r4.formats.JsonParser()
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

  // A cyclical repeat expression such as ["$this"] would otherwise recurse until the stack
  // overflows; StackOverflowError is an Error, so it escapes the publisher's catch (Exception)
  // and kills the whole build. The runner must stop with a FHIRException instead.
  @Test
  void cyclicalRepeatFailsWithFhirException() throws Exception {
    TestStorage storage = new TestStorage();
    TestProvider provider = new TestProvider();
    provider.addResource(parseResource("{\"resourceType\":\"Patient\",\"id\":\"p1\",\"gender\":\"male\"}"));
    Runner runner = newRunner(provider, storage);
    JsonObject view = JsonParser.parseObject("{\"resourceType\":\"ViewDefinition\",\"name\":\"t\",\"status\":\"active\","
        + "\"resource\":\"Patient\",\"select\":[{\"repeat\":[\"$this\"],"
        + "\"column\":[{\"name\":\"id\",\"path\":\"id\"}]}]}");

    FHIRException e = assertThrows(FHIRException.class, () -> runner.execute(view));
    assertTrue(e.getMessage().contains("repeat"), e.getMessage());
  }

  // The number of nodes a repeat collects must be capped, so that an expression
  // such as ["descendants()"], whose output grows exponentially with nesting depth,
  // cannot consume unbounded time and memory. The limit is configurable so callers
  // can tune it; the default is far above what legitimate views produce.
  @Test
  void repeatBeyondNodeLimitFailsWithFhirException() throws Exception {
    TestStorage storage = new TestStorage();
    TestProvider provider = new TestProvider();
    provider.addResource(parseResource(
        "{\"resourceType\":\"Patient\",\"id\":\"p1\",\"name\":[{\"family\":\"a\"},{\"family\":\"b\"},"
            + "{\"family\":\"c\"},{\"family\":\"d\"},{\"family\":\"e\"},{\"family\":\"f\"}]}"));
    Runner runner = newRunner(provider, storage);
    runner.setMaxRepeatNodes(3);
    JsonObject view = JsonParser.parseObject("{\"resourceType\":\"ViewDefinition\",\"name\":\"t\",\"status\":\"active\","
        + "\"resource\":\"Patient\",\"select\":[{\"repeat\":[\"name\"],"
        + "\"column\":[{\"name\":\"f\",\"path\":\"family\"}]}]}");

    FHIRException e = assertThrows(FHIRException.class, () -> runner.execute(view));
    assertTrue(e.getMessage().contains("repeat"), e.getMessage());
  }

  // Legitimate nesting far deeper than any real FHIR resource must still be traversed
  // in full; the depth limit must not reject reasonable views.
  @Test
  void repeatTraversesDeeplyNestedItems() throws Exception {
    int depth = 50;
    StringBuilder resource = new StringBuilder(
        "{\"resourceType\":\"QuestionnaireResponse\",\"id\":\"q1\",\"status\":\"completed\"");
    for (int i = 0; i < depth; i++) {
      resource.append(",\"item\":[{\"linkId\":\"i").append(i).append("\"");
    }
    for (int i = 0; i < depth; i++) {
      resource.append("}]");
    }
    resource.append("}");
    TestStorage storage = new TestStorage();
    TestProvider provider = new TestProvider();
    provider.addResource(parseResource(resource.toString()));
    Runner runner = newRunner(provider, storage);
    JsonObject view = JsonParser.parseObject(
        "{\"resourceType\":\"ViewDefinition\",\"name\":\"t\",\"status\":\"active\",\"resource\":\"QuestionnaireResponse\","
            + "\"select\":[{\"repeat\":[\"item\"],\"column\":[{\"name\":\"linkId\",\"path\":\"linkId\"}]}]}");

    runner.execute(view);

    assertEquals(depth, storage.getResults().size(), "one row per nested item");
  }

  // getReferenceKey() on a contained reference: the provider can only find the target inside the
  // resource being processed, so the runner must pass that resource through. It used to pass null,
  // and a contained target never had a key
  @Test
  void referenceKeyResolvesContainedReference() throws Exception {
    TestStorage storage = new TestStorage();
    TestProvider provider = new TestProvider();
    provider.addResource(parseResource("{\"resourceType\":\"Observation\",\"id\":\"o1\",\"status\":\"final\","
        + "\"contained\":[{\"resourceType\":\"Patient\",\"id\":\"p1\"}],"
        + "\"code\":{\"text\":\"x\"},\"subject\":{\"reference\":\"#p1\"}}"));
    Runner runner = newRunner(provider, storage);

    runner.execute(JsonParser.parseObject("{\"resourceType\":\"ViewDefinition\",\"name\":\"t\",\"status\":\"active\","
        + "\"resource\":\"Observation\",\"select\":[{\"column\":["
        + "{\"name\":\"any\",\"path\":\"subject.getReferenceKey()\"},"
        + "{\"name\":\"pat\",\"path\":\"subject.getReferenceKey(Patient)\"},"
        + "{\"name\":\"grp\",\"path\":\"subject.getReferenceKey(Group)\"}]}]}"));

    assertEquals(1, storage.getResults().size());
    JsonObject row = (JsonObject) storage.getResults().get(0);
    assertEquals("Patient/p1", row.asString("any"));
    assertEquals("Patient/p1", row.asString("pat"));
    assertTrue(row.get("grp") instanceof JsonNull, "a contained Patient is not a Group");
  }

  // six names, each with six given names
  private static final String SIX_NAMES = "{\"resourceType\":\"Patient\",\"id\":\"p1\",\"name\":["
      + "{\"family\":\"a\",\"given\":[\"1\",\"2\",\"3\",\"4\",\"5\",\"6\"]},{\"family\":\"b\",\"given\":[\"1\",\"2\",\"3\",\"4\",\"5\",\"6\"]},{\"family\":\"c\",\"given\":[\"1\",\"2\",\"3\",\"4\",\"5\",\"6\"]},{\"family\":\"d\",\"given\":[\"1\",\"2\",\"3\",\"4\",\"5\",\"6\"]},{\"family\":\"e\",\"given\":[\"1\",\"2\",\"3\",\"4\",\"5\",\"6\"]},{\"family\":\"f\",\"given\":[\"1\",\"2\",\"3\",\"4\",\"5\",\"6\"]}"
      + "]}";

  // each forEach multiplies the rows by the items it iterates (here, 6 names x 6 given names): nested ones can make
  // millions of rows from one resource, so the rows one resource can make are capped (configurably)
  private static final String NAMES_BY_NAMES = "{\"resourceType\":\"ViewDefinition\",\"name\":\"t\",\"status\":\"active\","
      + "\"resource\":\"Patient\",\"select\":[{\"forEach\":\"name\",\"column\":[{\"name\":\"f1\",\"path\":\"family\"}],"
      + "\"select\":[{\"forEach\":\"given\",\"column\":[{\"name\":\"g\",\"path\":\"$this\"}]}]}]}";

  @Test
  void rowsBeyondTheLimitFail() throws Exception {
    TestStorage storage = new TestStorage();
    TestProvider provider = new TestProvider();
    provider.addResource(parseResource(SIX_NAMES));
    Runner runner = newRunner(provider, storage);
    runner.setMaxRows(20);
    FHIRException e = assertThrows(FHIRException.class, () -> runner.execute(JsonParser.parseObject(NAMES_BY_NAMES)));
    assertTrue(e.getMessage().contains("more than 20 rows"), e.getMessage());
  }

  @Test
  void rowsUpToTheLimitAreFine() throws Exception {
    TestStorage storage = new TestStorage();
    TestProvider provider = new TestProvider();
    provider.addResource(parseResource(SIX_NAMES));
    Runner runner = newRunner(provider, storage);
    runner.setMaxRows(36);
    runner.execute(JsonParser.parseObject(NAMES_BY_NAMES));
    assertEquals(36, storage.getResults().size());
  }

  // the time limit is for each resource, and the FHIRPath the view runs spends it
  @Test
  void aResourceThatTakesTooLongFails() throws Exception {
    TestStorage storage = new TestStorage();
    TestProvider provider = new TestProvider();
    provider.addResource(parseResource(SIX_NAMES));
    Runner runner = newRunner(provider, storage);
    runner.setMaxExecutionMillis(200);
    String slow = "(1).repeat(iif($this < 1000, $this + 1, {})).select((1).repeat(iif($this < 1000, $this + 1, {})).count()).count()";
    JsonObject view = JsonParser.parseObject("{\"resourceType\":\"ViewDefinition\",\"name\":\"t\",\"status\":\"active\","
        + "\"resource\":\"Patient\",\"select\":[{\"column\":[{\"name\":\"n\",\"path\":\"" + slow + "\"}]}]}");
    long start = System.currentTimeMillis();
    FHIRException e = assertThrows(FHIRException.class, () -> runner.execute(view));
    assertTrue(e.getMessage().contains("didn't finish"), e.getMessage());
    assertTrue(System.currentTimeMillis() - start < 30000);
  }
  /** a collection column's values go in every row: rows times values is limited */
  @Test
  void aCollectionColumnInManyRowsFails() throws Exception {
    TestStorage storage = new TestStorage();
    TestProvider provider = new TestProvider();
    provider.addResource(parseResource(SIX_NAMES));
    Runner runner = newRunner(provider, storage);
    runner.setMaxRows(5000);
    // 1000 rows, each getting a column of 11,000 values: 11,000,000 cells, over the limit (ExecutionLimits.DEFAULT_MAX_ITEMS).
    // The values are cheap to make (one repeat, not one per value: thousand.select(thousand) took more than 30s on CI)
    String thousand = "(1).repeat(iif($this < 1000, $this + 1, {}))";
    String eleven = "(1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11)";
    JsonObject view = JsonParser.parseObject("{\"resourceType\":\"ViewDefinition\",\"name\":\"t\",\"status\":\"active\","
        + "\"resource\":\"Patient\",\"select\":[{\"forEach\":\"" + thousand + "\",\"column\":[{\"name\":\"n\",\"path\":\"$this\"}]},"
        + "{\"column\":[{\"name\":\"m\",\"collection\":true,\"path\":\"" + thousand + ".select(" + eleven + ")\"}]}]}");
    long start = System.currentTimeMillis();
    FHIRException e = assertThrows(FHIRException.class, () -> runner.execute(view));
    assertTrue(e.getMessage().contains("values in a column"), e.getMessage());
    assertTrue(System.currentTimeMillis() - start < 30000);
  }
}
