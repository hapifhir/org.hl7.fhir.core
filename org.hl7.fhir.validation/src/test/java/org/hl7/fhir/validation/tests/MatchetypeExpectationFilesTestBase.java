package org.hl7.fhir.validation.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.model.JsonProperty;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.http.FhirValidatorHttpService;
import org.hl7.fhir.validation.special.TxTestData;
import org.hl7.fhir.validation.tests.utilities.TestUtilities;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * The HL7 terminology test set's expected files, each compared with itself through
 * {@code POST /itb/matchetype/validate}, on a validator of the FHIR version the subclass names.
 * <p>
 * For every response file {@code test-cases.json} names, the actual is the file with its
 * placeholders filled and the elements its own markers make optional removed - what a server
 * that returns exactly the expected minimum would send. Compared with {@code normalize=tx},
 * {@code version} set to the validator's own version, and {@code mode=partial} for the tests
 * the terminology test runner compares in pattern mode, the result must be SUCCESS. That
 * guards two invariants at once:
 * <ul>
 * <li>what a file marks optional ({@code $optional$}, {@code $optional-properties$}) or
 * version-specific ({@code $only$}) is allowed to be absent;</li>
 * <li>normalising a document already in the stored form is a no-op - the files are maintained
 * from the runner's output, so the service's normalisation must sort the way the runner does.</li>
 * </ul>
 * The files are R5-shaped. A validator of an earlier version does not define some of their
 * content ({@code ValueSet.expansion.contains.property}, say); the service must then say so
 * rather than compare with that content silently dropped, which is what let a response that
 * omitted it pass. So on such a validator the only other acceptable outcome is a FAILURE whose
 * every item reports the matchetype's undefined content, and
 * {@link #responseWithoutTheContentTheFileRequiresFails()} pins that the omission is never
 * accepted.
 */
@TestInstance(Lifecycle.PER_CLASS)
abstract class MatchetypeExpectationFilesTestBase {

  private static final String PACKAGE = "hl7.fhir.uv.tx-ecosystem#current";
  /** Three files in the version suite spell the marker {@code $optional} - not a marker either runner knows. */
  private static final String STRAY_MARKER = "\"$optional\"";

  private TxTestData txtests;
  /** The real tx.fhir.org messages the files' $external:n$ placeholders stand for, by file name and n. */
  private JsonObject externals;
  private ValidationEngine engine;
  private FhirValidatorHttpService service;
  private HttpClient client;

  /** The core package to load, e.g. {@code hl7.fhir.r4.core#4.0.1}. */
  protected abstract String corePackage();

  /** The validator's FHIR version, e.g. {@code 4.0.1}. */
  protected abstract String fhirVersion();

  /** The port the service listens on for this class. */
  protected abstract int port();

  /** Whether this validator's version defines everything an R5-shaped file can carry. */
  protected abstract boolean definesR5Content();

  Stream<Arguments> expectationFiles() throws IOException {
    if (txtests == null) {
      txtests = TxTestData.loadTestDataFromPackage(PACKAGE);
      externals = JsonParser.parseObject(txtests.load("messages-tx.fhir.org.json"));
    }
    JsonObject cases = JsonParser.parseObject(txtests.load("test-cases.json"));
    List<Arguments> res = new ArrayList<>();
    Set<String> seen = new HashSet<>();
    for (JsonObject suite : cases.getJsonObjects("suites")) {
      for (JsonObject test : suite.getJsonObjects("tests")) {
        String file = test.asString("response");
        if (file != null && seen.add(file)) {
          // the runner compares these two in pattern mode: the file is a subset of the response
          String op = test.asString("operation");
          boolean partial = "metadata".equals(op) || "term-caps".equals(op);
          res.add(Arguments.of(file, suite.asString("name") + "/" + test.asString("name"), partial));
        }
      }
    }
    return res.stream();
  }

  @BeforeAll
  void startService() throws Exception {
    engine = TestUtilities.getValidationEngineNoTxServer(corePackage(), fhirVersion());
    service = new FhirValidatorHttpService(engine, true, port());
    service.startServer();
    client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build();
  }

  @AfterAll
  void stopService() {
    if (service != null) {
      service.stop();
    }
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("expectationFiles")
  void expectedFileMatchesItself(String file, String test, boolean partial) throws Exception {
    String expected = txtests.load(file);
    JsonObject actual = JsonParser.parseObject(expected);
    asMinimalResponse(actual, externals.has(file) ? externals.getJsonObject(file) : new JsonObject());

    JsonObject report = compare(JsonParser.compose(actual), expected, partial);
    String result = report.asString("result");
    boolean strayMarker = expected.contains(STRAY_MARKER);
    if (definesR5Content() && !strayMarker) {
      assertEquals("SUCCESS", result, () -> test + " (" + file + "): " + failures(report));
    } else {
      // the pattern carries content this validator cannot represent: that is reported, and
      // nothing else is
      assertTrue("SUCCESS".equals(result) || onlyPatternErrors(report), () -> test + " (" + file + "): " + failures(report));
      if (strayMarker) {
        assertTrue(onlyPatternErrors(report), () -> test + " (" + file + "): the stray marker must be reported: " + failures(report));
      }
    }
  }

  /**
   * The case that used to pass silently on an R4 validator: an R5-shaped expected file with
   * {@code contains.property}, and a response without it. The response must fail whatever the
   * validator's version - as a missing element where the version defines it, as content the
   * matchetype cannot carry where it does not.
   */
  @Test
  void responseWithoutTheContentTheFileRequiresFails() throws Exception {
    String pattern = "{\"resourceType\":\"ValueSet\",\"status\":\"active\",\"expansion\":{\"identifier\":\"$uuid$\",\"timestamp\":\"$instant$\","
      + "\"contains\":[{\"system\":\"http://hl7.org/fhir/test/CodeSystem/simple\",\"code\":\"code2\",\"display\":\"Display 2\","
      + "\"property\":[{\"code\":\"status\",\"valueCode\":\"retired\"}]}]}}";
    String response = "{\"resourceType\":\"ValueSet\",\"status\":\"active\",\"expansion\":{\"identifier\":\"urn:uuid:c0ffee00-0000-4000-8000-000000000001\","
      + "\"timestamp\":\"2026-01-01T00:00:00Z\",\"contains\":[{\"system\":\"http://hl7.org/fhir/test/CodeSystem/simple\",\"code\":\"code2\",\"display\":\"Display 2\"}]}}";
    JsonObject report = compare(response, pattern, false);
    assertEquals("FAILURE", report.asString("result"), failures(report));
    assertTrue(JsonParser.compose(report).contains("property"), failures(report));
    assertEquals(definesR5Content(), !onlyPatternErrors(report), failures(report));
  }

  // ------------------------------------------------------------------
  // The service call
  // ------------------------------------------------------------------

  protected JsonObject compare(String actual, String matchetype, boolean partial, JsonObject... more) throws Exception {
    JsonArray inputs = new JsonArray();
    inputs.add(anyContent("contentToValidate", actual));
    inputs.add(anyContent("matchetype", matchetype));
    inputs.add(anyContent("normalize", "tx"));
    if (partial) {
      inputs.add(anyContent("mode", "partial"));
    }
    boolean hasVersion = false;
    for (JsonObject m : more) {
      hasVersion = hasVersion || "version".equals(m.asString("name"));
      inputs.add(m);
    }
    if (!hasVersion) {
      inputs.add(anyContent("version", fhirVersion()));
    }
    JsonObject body = new JsonObject();
    body.add("input", inputs);

    HttpResponse<String> response = client.send(
      HttpRequest.newBuilder()
        .uri(URI.create("http://localhost:" + port() + "/itb/matchetype/validate"))
        .header("Content-Type", "application/json")
        .POST(HttpRequest.BodyPublishers.ofString(JsonParser.compose(body)))
        .build(),
      HttpResponse.BodyHandlers.ofString());
    assertEquals(200, response.statusCode(), response.body());
    return JsonParser.parseObject(response.body()).getJsonObject("report");
  }

  protected static JsonObject anyContent(String name, String value) {
    JsonObject ac = new JsonObject();
    ac.add("name", name);
    ac.add("value", value);
    ac.add("embeddingMethod", "STRING");
    return ac;
  }

  /** True when the report is a failure whose every item reports content the matchetype cannot carry. */
  protected static boolean onlyPatternErrors(JsonObject report) {
    if (!"FAILURE".equals(report.asString("result")) || !report.has("items")) {
      return false;
    }
    for (JsonObject item : report.getJsonObjects("items")) {
      if (!item.asString("description").startsWith("matchetype: ")) {
        return false;
      }
    }
    return true;
  }

  protected static String failures(JsonObject report) {
    String s = JsonParser.compose(report);
    return s.length() > 2000 ? s.substring(0, 2000) + "..." : s;
  }

  // ------------------------------------------------------------------
  // The file as the minimal response a conforming server would send
  // ------------------------------------------------------------------

  /**
   * Fill the placeholders and take out what the markers say need not be there.
   *
   * @param ext the file's real tx.fhir.org messages, by placeholder number
   * @return false when the object itself is one the server need not - or must not - send
   */
  private boolean asMinimalResponse(JsonObject obj, JsonObject ext) {
    if (obj.has("$optional$")) {
      JsonElement v = obj.get("$optional$");
      obj.remove("$optional$");
      if ((v.isJsonBoolean() && v.asJsonBoolean().asBoolean()) || (v.isJsonString() && passes(v.asString()))) {
        return false;
      }
    }
    if (obj.has("$only$")) {
      String filter = obj.asString("$only$");
      obj.remove("$only$");
      if (!passes(filter)) {
        return false;
      }
    }
    if (obj.has("$optional-properties$")) {
      for (String n : obj.getStrings("$optional-properties$")) {
        obj.remove(n);
      }
      obj.remove("$optional-properties$");
    }
    obj.remove("$count-arrays$");
    obj.remove("$optional");

    for (JsonProperty p : new ArrayList<>(obj.getProperties())) {
      JsonElement v = p.getValue();
      if (v.isJsonObject()) {
        if (!asMinimalResponse(v.asJsonObject(), ext)) {
          obj.remove(p.getName());
        }
      } else if (v.isJsonArray()) {
        JsonArray arr = v.asJsonArray();
        for (JsonElement e : new ArrayList<>(arr.getItems())) {
          if (e.isJsonObject() && !asMinimalResponse(e.asJsonObject(), ext)) {
            arr.remove(e);
          }
        }
      } else if (v.isJsonString() && isPlaceholder(v.asString())) {
        obj.set(p.getName(), fill(p.getName(), v.asString(), ext));
      }
    }
    return true;
  }

  /** The comparer's filter rule with no modes and this validator's version, which is what the test sends. */
  private boolean passes(String filter) {
    if (filter.startsWith("version:")) {
      return fhirVersion().startsWith(filter.substring(8));
    }
    return filter.startsWith("!") || filter.startsWith("warning:");
  }

  private static boolean isPlaceholder(String s) {
    return s.length() >= 2 && s.startsWith("$") && s.endsWith("$");
  }

  /**
   * A value the placeholder accepts, and that the element's type accepts too. A message stands
   * in for a real server message: the real one where the package records it, since the sorted
   * order the files are stored in depends on the real text; otherwise the fragments the
   * placeholder asks for, behind a word so that the value is not itself a "; " list the
   * normaliser would reorder.
   */
  private String fill(String name, String placeholder, JsonObject ext) {
    if (placeholder.startsWith("$choice:")) {
      return placeholder.substring(8, placeholder.length() - 1).split("\\|")[0];
    }
    if (placeholder.startsWith("$fragments:")) {
      return "Message " + placeholder.substring(11, placeholder.length() - 1).replace('|', ' ');
    }
    if (placeholder.startsWith("$external:")) {
      // $external:n$ is the message the package's externals file records under n;
      // $external:n:a|b$ must contain a and b when no externals are given, as in the service
      String[] cmd = placeholder.substring(1, placeholder.length() - 1).split(":", 3);
      if (ext.has(cmd[1])) {
        return ext.asString(cmd[1]);
      }
      return cmd.length > 2 ? "Message " + cmd[2].replace('|', ' ') : "Message";
    }
    switch (placeholder) {
    case "$instant$": return "2026-01-01T00:00:00Z";
    case "$date$": return "2026-01-01";
    case "$uuid$": return "urn:uuid:c0ffee00-0000-4000-8000-000000000001";
    case "$id$": return "a1";
    case "$url$": return "http://example.org/fhir/x";
    case "$semver$": return "1.0.0";
    case "$version$": return fhirVersion();
    case "$token$": return "status".equals(name) ? "active" : "a1";
    default: return "x"; // $$, $string$
    }
  }
}
