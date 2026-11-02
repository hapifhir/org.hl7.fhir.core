package org.hl7.fhir.validation.special;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.model.ModelContext;
import org.hl7.fhir.model.core.Resource;
import org.hl7.fhir.model.testing.TestReport;
import org.hl7.fhir.model.testing.TestReport.TestReportResultValueSet;
import org.hl7.fhir.utilities.http.ManagedWebAccess;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

/**
 * A run made one test at a time (the validator's server mode): startRun(), executeTest() for each
 * test, and finishRun(), which has to produce the same reports as a whole run - not counting the
 * tests that didn't run, and counting a test run twice once.
 */
class TxTesterRunTests {

  private static final String CAPABILITY_STATEMENT = "{\"resourceType\":\"CapabilityStatement\",\"status\":\"active\",\"date\":\"2026-01-01\","
    + "\"kind\":\"instance\",\"fhirVersion\":\"5.0.0\",\"format\":[\"json\"],\"software\":{\"name\":\"Fake\",\"version\":\"1.0\"}}";
  private static final String TERMINOLOGY_CAPABILITIES = "{\"resourceType\":\"TerminologyCapabilities\",\"status\":\"active\",\"date\":\"2026-01-01\",\"kind\":\"instance\"}";

  private static final String TEST_CASES = "{\"suites\":[{\"name\":\"s1\",\"tests\":["
    + "{\"name\":\"good\",\"operation\":\"metadata\",\"response\":\"good-response.json\"},"
    + "{\"name\":\"bad\",\"operation\":\"metadata\",\"response\":\"bad-response.json\"},"
    + "{\"name\":\"off\",\"operation\":\"metadata\",\"response\":\"good-response.json\",\"disabled\":true},"
    + "{\"name\":\"gated\",\"operation\":\"metadata\",\"response\":\"good-response.json\",\"mode\":\"special\"},"
    + "{\"name\":\"r4only\",\"operation\":\"metadata\",\"response\":\"good-response.json\",\"version\":\"4.0\"},"
    + "{\"name\":\"needs-closure\",\"operation\":\"metadata\",\"response\":\"good-response.json\",\"feature\":\"closure\"}"
    + "]}]}";

  private HttpServer server;

  @TempDir
  Path output;

  /** A terminology server that knows only who it is. */
  @BeforeEach
  void startServer() throws IOException {
    // the fake server is http on localhost, which the SSRF protection refuses
    ManagedWebAccess.setSsrfProtectionEnabled(false);
    server = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
    server.createContext("/fhir", exchange -> {
      String path = exchange.getRequestURI().getPath();
      String query = exchange.getRequestURI().getQuery();
      if (path.endsWith("/$versions")) {
        respond(exchange, 200, "{\"resourceType\":\"Parameters\",\"parameter\":[{\"name\":\"default\",\"valueCode\":\"5.0.0\"}]}");
      } else if (path.endsWith("/metadata") && query != null && query.contains("mode=terminology")) {
        respond(exchange, 200, TERMINOLOGY_CAPABILITIES);
      } else if (path.endsWith("/metadata")) {
        respond(exchange, 200, CAPABILITY_STATEMENT);
      } else {
        respond(exchange, 404, "{\"resourceType\":\"OperationOutcome\",\"issue\":[{\"severity\":\"error\",\"code\":\"not-found\"}]}");
      }
    });
    server.start();
  }

  @AfterEach
  void stopServer() {
    server.stop(0);
    ManagedWebAccess.setSsrfProtectionEnabled(true);
  }

  private static void respond(HttpExchange exchange, int status, String body) throws IOException {
    byte[] b = body.getBytes(StandardCharsets.UTF_8);
    exchange.getResponseHeaders().set("Content-Type", "application/fhir+json");
    exchange.sendResponseHeaders(status, b.length);
    try (OutputStream os = exchange.getResponseBody()) {
      os.write(b);
    }
  }

  /** The test cases, from memory. */
  private static class Loader implements TxTester.ITxTesterLoader {
    private final Map<String, String> files = new HashMap<>();

    Loader() {
      files.put("test-cases.json", TEST_CASES);
      files.put("parameters-default.json", "{\"resourceType\":\"Parameters\"}");
      files.put("good-response.json", "{\"resourceType\":\"CapabilityStatement\",\"fhirVersion\":\"5.0.0\"}");
      files.put("bad-response.json", "{\"resourceType\":\"CapabilityStatement\",\"fhirVersion\":\"4.0.1\"}");
    }

    public String describe() {
      return "in memory";
    }

    public Resource loadResource(String filename) throws IOException {
      return new org.hl7.fhir.model.core.formats.JsonParser(ModelContext.fullCoreContext()).parse(new ByteArrayInputStream(loadContent(filename)));
    }

    public byte[] loadContent(String filename) throws FileNotFoundException {
      if (!files.containsKey(filename)) {
        throw new FileNotFoundException(filename);
      }
      return files.get(filename).getBytes(StandardCharsets.UTF_8);
    }

    public boolean hasContent(String filename) {
      return files.containsKey(filename);
    }

    public String code() {
      return "test";
    }

    public String version() {
      return "0.0.1";
    }

    public String testFileName() {
      return "test-cases.json";
    }
  }

  private JsonObject test(JsonObject testCases, String name) {
    for (JsonObject t : testCases.getJsonObjects("suites").get(0).getJsonObjects("tests")) {
      if (name.equals(t.asString("name"))) {
        return t;
      }
    }
    throw new IllegalArgumentException(name);
  }

  @Test
  void runOneTestAtATime() throws Exception {
    Loader loader = new Loader();
    JsonObject testCases = JsonParser.parseObject(TEST_CASES);
    JsonObject suite = testCases.getJsonObjects("suites").get(0);
    TxTester tester = new TxTester(loader, "http://localhost:" + server.getAddress().getPort() + "/fhir", true, null, null);
    tester.setOutput(output.toString());
    tester.startRun();
    assertEquals("5.0.0", tester.getServerVersion());

    Set<String> modes = Set.of("general");
    assertNull(tester.executeTest(loader, suite, test(testCases, "good"), modes));
    String fail = tester.executeTest(loader, suite, test(testCases, "bad"), modes);
    assertNotNull(fail);
    assertFalse(TxTester.isNotRun(fail));
    // run again: it still counts once
    assertNull(tester.executeTest(loader, suite, test(testCases, "good"), modes));

    assertEquals(TxTester.NOT_RUN_DISABLED, tester.executeTest(loader, suite, test(testCases, "off"), modes));
    assertEquals("n/a", tester.executeTest(loader, suite, test(testCases, "gated"), modes));
    assertEquals(TxTester.NOT_RUN_VERSION, tester.executeTest(loader, suite, test(testCases, "r4only"), modes));
    assertEquals(TxTester.NOT_RUN_FEATURES, tester.executeTest(loader, suite, test(testCases, "needs-closure"), modes));
    assertTrue(TxTester.isNotRun(TxTester.NOT_RUN_DISABLED));
    assertTrue(tester.describeVersionGate(suite, test(testCases, "r4only")).contains("4.0"));

    JsonObject results = tester.finishRun();
    // only the tests that ran are in test-results.json
    assertEquals(1, results.getJsonObjects("suites").size());
    assertEquals(2, results.getJsonObjects("suites").get(0).getJsonObjects("tests").size());
    assertEquals("pass", results.getJsonObjects("suites").get(0).getJsonObjects("tests").get(0).asString("status"));
    assertEquals("fail", results.getJsonObjects("suites").get(0).getJsonObjects("tests").get(1).asString("status"));

    TestReport report = tester.getTestReport();
    assertEquals(50.0, report.getScore().doubleValue());
    assertEquals(TestReportResultValueSet.FAIL, report.getResult());
    // one entry per test, whether or not it ran
    assertEquals(6, report.getTestList().size());
    assertTrue(report.getTester().contains("general"));

    assertTrue(new File(output.toFile(), "test-results.json").exists());
    assertTrue(new File(output.toFile(), "report.json").exists());
  }
}
