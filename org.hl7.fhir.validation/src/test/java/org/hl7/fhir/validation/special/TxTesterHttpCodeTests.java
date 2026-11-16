package org.hl7.fhir.validation.special;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
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
 * A test's http-code can give the server a choice - "200|4xx" - with an expected response for each
 * (response:200, response:4xx). The code the server returns picks the response its answer is
 * compared with.
 */
class TxTesterHttpCodeTests {

  private static final String CAPABILITY_STATEMENT = "{\"resourceType\":\"CapabilityStatement\",\"status\":\"active\",\"date\":\"2026-01-01\","
    + "\"kind\":\"instance\",\"fhirVersion\":\"5.0.0\",\"format\":[\"json\"],\"software\":{\"name\":\"Fake\",\"version\":\"1.0\"}}";
  private static final String TERMINOLOGY_CAPABILITIES = "{\"resourceType\":\"TerminologyCapabilities\",\"status\":\"active\",\"date\":\"2026-01-01\",\"kind\":\"instance\"}";

  private static final String VALUE_SET = "{\"resourceType\":\"ValueSet\",\"status\":\"active\",\"expansion\":{\"timestamp\":\"2026-01-01T00:00:00Z\","
    + "\"contains\":[{\"system\":\"http://example.org/cs\",\"code\":\"a\"}]}}";
  private static final String OTHER_VALUE_SET = "{\"resourceType\":\"ValueSet\",\"status\":\"active\",\"expansion\":{\"timestamp\":\"2026-01-01T00:00:00Z\","
    + "\"contains\":[{\"system\":\"http://example.org/cs\",\"code\":\"b\"}]}}";
  private static final String OUTCOME = "{\"resourceType\":\"OperationOutcome\",\"issue\":[{\"severity\":\"error\",\"code\":\"not-found\"}]}";
  private static final String OTHER_OUTCOME = "{\"resourceType\":\"OperationOutcome\",\"issue\":[{\"severity\":\"error\",\"code\":\"invalid\"}]}";

  private static final String TEST_CASES = "{\"suites\":[{\"name\":\"s1\",\"tests\":["
    + "{\"name\":\"either\",\"operation\":\"expand\",\"http-code\":\"200|4xx\",\"request\":\"request.json\","
    + "\"response:200\":\"vs-response.json\",\"response:4xx\":\"oo-response.json\"},"
    + "{\"name\":\"exact\",\"operation\":\"expand\",\"http-code\":\"422\",\"request\":\"request.json\",\"response\":\"oo-response.json\"},"
    + "{\"name\":\"plain-4xx\",\"operation\":\"expand\",\"http-code\":\"4xx\",\"request\":\"request.json\",\"response\":\"oo-response.json\"},"
    + "{\"name\":\"default\",\"operation\":\"expand\",\"request\":\"request.json\",\"response\":\"vs-response.json\"},"
    + "{\"name\":\"missing-response\",\"operation\":\"expand\",\"http-code\":\"200|4xx\",\"request\":\"request.json\",\"response:200\":\"vs-response.json\"},"
    + "{\"name\":\"bad-code\",\"operation\":\"expand\",\"http-code\":\"200|oops\",\"request\":\"request.json\",\"response\":\"vs-response.json\"}"
    + "]}]}";

  private HttpServer server;
  // what the fake server answers $expand with
  private volatile int expandStatus;
  private volatile String expandBody;

  @TempDir
  Path output;

  @BeforeEach
  void startServer() throws IOException {
    // the fake server is http on localhost, which the SSRF protection refuses
    ManagedWebAccess.setSsrfProtectionEnabled(false);
    server = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
    server.createContext("/fhir", exchange -> {
      String path = exchange.getRequestURI().getPath();
      String query = exchange.getRequestURI().getQuery();
      exchange.getRequestBody().readAllBytes();
      if (path.endsWith("/$versions")) {
        respond(exchange, 200, "{\"resourceType\":\"Parameters\",\"parameter\":[{\"name\":\"default\",\"valueCode\":\"5.0.0\"}]}");
      } else if (path.endsWith("/metadata") && query != null && query.contains("mode=terminology")) {
        respond(exchange, 200, TERMINOLOGY_CAPABILITIES);
      } else if (path.endsWith("/metadata")) {
        respond(exchange, 200, CAPABILITY_STATEMENT);
      } else if (path.endsWith("/$expand")) {
        respond(exchange, expandStatus, expandBody);
      } else {
        respond(exchange, 404, OUTCOME);
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

  private static class Loader implements TxTester.ITxTesterLoader {
    private final Map<String, String> files = new HashMap<>();

    Loader() {
      files.put("test-cases.json", TEST_CASES);
      files.put("parameters-default.json", "{\"resourceType\":\"Parameters\"}");
      files.put("request.json", "{\"resourceType\":\"Parameters\",\"parameter\":[{\"name\":\"url\",\"valueUri\":\"http://example.org/vs\"}]}");
      files.put("vs-response.json", VALUE_SET);
      files.put("oo-response.json", OUTCOME);
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

  private Loader loader;
  private JsonObject suite;
  private TxTester tester;

  private String run(String name, int status, String body) throws Exception {
    if (tester == null) {
      loader = new Loader();
      suite = JsonParser.parseObject(TEST_CASES).getJsonObjects("suites").get(0);
      tester = new TxTester(loader, "http://localhost:" + server.getAddress().getPort() + "/fhir", true, null, null);
      tester.setOutput(output.toString());
      tester.startRun();
    }
    expandStatus = status;
    expandBody = body;
    for (JsonObject t : suite.getJsonObjects("tests")) {
      if (name.equals(t.asString("name"))) {
        return tester.executeTest(loader, suite, t, Set.of("general"));
      }
    }
    throw new IllegalArgumentException(name);
  }

  private static void assertCodeFail(String msg) {
    assertNotNull(msg);
    assertTrue(msg.contains("Response Code fail"), msg);
  }

  private static void assertContentFail(String msg) {
    assertNotNull(msg);
    assertFalse(msg.contains("Response Code fail"), msg);
  }

  @Test
  void choiceServerReturnsResource() throws Exception {
    assertNull(run("either", 200, VALUE_SET));
  }

  @Test
  void choiceServerReturnsError() throws Exception {
    assertNull(run("either", 422, OUTCOME));
    assertNull(run("either", 400, OUTCOME));
  }

  @Test
  void choiceComparesWithTheResponseForTheCodeReturned() throws Exception {
    // a 200 is compared with response:200, not response:4xx, and v.v.
    assertContentFail(run("either", 200, OTHER_VALUE_SET));
    assertContentFail(run("either", 422, OTHER_OUTCOME));
  }

  @Test
  void choiceCodeMatchesNeither() throws Exception {
    assertCodeFail(run("either", 500, OUTCOME));
  }

  @Test
  void exactCode() throws Exception {
    assertNull(run("exact", 422, OUTCOME));
    assertCodeFail(run("exact", 400, OUTCOME));
  }

  @Test
  void singleCodeClassUsesResponse() throws Exception {
    assertNull(run("plain-4xx", 404, OUTCOME));
    assertCodeFail(run("plain-4xx", 200, VALUE_SET));
  }

  @Test
  void defaultIs2xx() throws Exception {
    assertNull(run("default", 200, VALUE_SET));
    assertCodeFail(run("default", 400, OUTCOME));
  }

  @Test
  void choiceWithoutAResponseIsAnError() throws Exception {
    String msg = run("missing-response", 200, VALUE_SET);
    assertNotNull(msg);
    assertTrue(msg.contains("4xx"), msg);
  }

  @Test
  void badCodeIsAnError() throws Exception {
    String msg = run("bad-code", 200, VALUE_SET);
    assertNotNull(msg);
    assertTrue(msg.contains("http-code"), msg);
  }
}
