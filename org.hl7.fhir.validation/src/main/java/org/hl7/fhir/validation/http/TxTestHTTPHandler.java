package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.hl7.fhir.model.IModelContext;
import org.hl7.fhir.model.core.OperationOutcome;
import org.hl7.fhir.model.utilities.OperationOutcomeUtilities;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.validation.special.TxTester;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * Runs the terminology ecosystem tests (hl7.fhir.uv.tx-ecosystem) against a terminology server,
 * one test at a time, so that a caller's own test framework can report a result per test.
 *
 * <ul>
 *   <li>{@code POST /txTest/setup} starts a run: the things that can't change during it - the
 *   server, the version of the test cases, the externals (message wording), the output folder
 *   and the tester name. The server is connected to then, which decides the FHIR version the
 *   tests are run in. Returns a session id.</li>
 *   <li>{@code GET /txTest?session=...&suite=...&test=...} runs one test: an OperationOutcome
 *   with no errors means it passed. A test that doesn't run (disabled, or gated on a mode,
 *   feature or FHIR version) is an error to ask for, but is not counted in the run's results.</li>
 *   <li>{@code POST /txTest/teardown?session=...} ends the run, and returns the two reports the
 *   command line writes - test-results.json and report.json (a TestReport) - which are also
 *   written to the run's output folder.</li>
 * </ul>
 *
 * A {@code GET /txTest} with {@code server} and no {@code session} still works as it used to: it
 * makes an implicit run for that server on first use, with the current test cases. That run can
 * be ended with {@code /txTest/teardown?server=...}.
 */
class TxTestHTTPHandler extends BaseHTTPHandler implements HttpHandler {

  /** The modes used when a test call doesn't say: everything except the server specific tx.fhir.org tests. */
  static final List<String> DEFAULT_MODES = Collections.unmodifiableList(Arrays.asList("general", "snomed", "omop", "mimetypes", "icd-11", "icf"));

  /** A version of the test cases: a version, or a package label such as 'current' - never a path. */
  private static final Pattern TEST_VERSION = Pattern.compile("^[A-Za-z0-9][A-Za-z0-9._-]{0,63}$");

  /** The parameters fixed by setup, which a test call in a session may not pass. */
  private static final Set<String> SETUP_ONLY = new LinkedHashSet<>(Arrays.asList("server", "test-version", "version", "externals", "folder"));

  private static final String LEGACY_PREFIX = "server:";

  private final IModelContext context;
  private final FhirValidatorHttpService fhirValidatorHttpService;

  public TxTestHTTPHandler(IModelContext context, FhirValidatorHttpService fhirValidatorHttpService) {
    super(context);
    this.context = context;
    this.fhirValidatorHttpService = fhirValidatorHttpService;
  }

  /** A request the caller got wrong: reported as a 400, or a 404 for something that isn't there. */
  private static class RequestException extends Exception {
    private final int status;

    RequestException(int status, String message) {
      super(message);
      this.status = status;
    }
  }

  /** One run of the tests against one server: the tester, and the test cases it runs. */
  public class ServerTxTester extends TxTester {
    private final TxTester.ITxTesterLoader loader;
    private final JsonObject testCases;

    public ServerTxTester(TxTester.ITxTesterLoader loader, String server, JsonObject testCases, JsonObject externals) {
      super(loader, server, true, externals, null);
      this.testCases = testCases;
      this.loader = loader;
    }

    public JsonObject getSuite(String suiteName) throws RequestException {
      for (JsonObject t : testCases.getJsonObjects("suites")) {
        if (suiteName.equals(t.asString("name"))) {
          return t;
        }
      }
      throw new RequestException(404, "Test Suite " + suiteName + " not found");
    }

    public JsonObject getTest(JsonObject suite, String testName) throws RequestException {
      for (JsonObject t : suite.getJsonObjects("tests")) {
        if (testName.equals(t.asString("name"))) {
          return t;
        }
      }
      throw new RequestException(404, "Test " + testName + " not found in suite " + suite.asString("name"));
    }
  }

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    String path = exchange.getRequestURI().getPath();
    String method = exchange.getRequestMethod();
    try {
      if (path.endsWith("/setup")) {
        requireMethod(method, "POST");
        setup(exchange);
      } else if (path.endsWith("/teardown")) {
        requireMethod(method, "POST");
        teardown(exchange);
      } else if (path.equals("/txTest") || path.equals("/txTest/")) {
        requireMethod(method, "GET");
        runTest(exchange);
      } else {
        throw new RequestException(404, "Unknown path " + path + ": use /txTest/setup, /txTest, or /txTest/teardown");
      }
    } catch (RequestException e) {
      if (e.status == 405) {
        sendResponse(exchange, 405, "Method not allowed", "text/plain");
      } else {
        sendOperationOutcome(exchange, e.status, OperationOutcomeUtilities.createError(e.getMessage()), getAcceptHeader(exchange));
      }
    } catch (Exception e) {
      OperationOutcome outcome = OperationOutcomeUtilities.createError("Testing failed: " + e.getMessage());
      sendOperationOutcome(exchange, 500, outcome, getAcceptHeader(exchange));
    }
  }

  private void requireMethod(String method, String expected) throws RequestException {
    if (!expected.equals(method)) {
      throw new RequestException(405, "Method not allowed");
    }
  }

  // ---- setup --------------------------------------------------------------------------------

  /**
   * The body is a JSON object: {@code server} (required), {@code test-version} (default
   * 'current'), {@code externals} (the content of an externals file, as a JSON object - not a
   * file name), {@code folder} and {@code tester}.
   */
  private void setup(HttpExchange exchange) throws Exception {
    byte[] body = readRequestBody(exchange);
    if (body.length == 0) {
      throw new RequestException(400, "setup needs a JSON object in the body, with at least 'server'");
    }
    JsonObject json;
    try {
      json = JsonParser.parseObject(body);
    } catch (Exception e) {
      throw new RequestException(400, "The body of setup is not a JSON object: " + e.getMessage());
    }
    for (String n : json.getNames()) {
      if (!Arrays.asList("server", "test-version", "externals", "folder", "tester").contains(n)) {
        throw new RequestException(400, "Unknown setup parameter '" + n + "' (known: server, test-version, externals, folder, tester)");
      }
    }
    String server = json.asString("server");
    if (server == null || server.isEmpty()) {
      throw new RequestException(400, "Missing required parameter 'server'");
    }
    JsonObject externals = null;
    if (json.has("externals")) {
      JsonElement e = json.get("externals");
      if (e.isJsonObject()) {
        externals = e.asJsonObject();
      } else if (e.isJsonString()) {
        try {
          externals = JsonParser.parseObject(e.asString());
        } catch (Exception ex) {
          throw new RequestException(400, "'externals' is not a JSON object: " + ex.getMessage());
        }
      } else {
        throw new RequestException(400, "'externals' must be the content of an externals file: a JSON object");
      }
    }

    String id = UUID.randomUUID().toString();
    ServerTxTester tester = createTester(server, json.asString("test-version"), externals, "(supplied in setup)",
      json.asString("folder"), json.asString("tester"));
    fhirValidatorHttpService.getTxTesters().put(id, tester);

    JsonObject res = describe(id, tester);
    sendResponse(exchange, 200, JsonParser.compose(res, true), "application/json");
  }

  private ServerTxTester createTester(String server, String testVersion, JsonObject externals, String externalsName, String folder, String testerName) throws Exception {
    if (testVersion == null) {
      testVersion = "current";
    }
    if (!TEST_VERSION.matcher(testVersion).matches()) {
      throw new RequestException(400, "Invalid 'test-version' '" + testVersion + "': it is a version of the test cases (e.g. 1.9.6, or current), not a path");
    }
    if (folder != null) {
      String err = TxTester.checkFolderName(folder);
      if (err != null) {
        throw new RequestException(400, "Invalid 'folder' parameter: " + err);
      }
    }
    TxTester.InternalTxLoader loader = new TxTester.InternalTxLoader(context, testVersion);
    JsonObject testCases = JsonParser.parseObject(loader.loadContent(loader.testFileName()));
    ServerTxTester tester = new ServerTxTester(loader, server, testCases, externals);
    tester.setExternalsName(externalsName);
    if (testerName != null) {
      tester.setTesterName(testerName);
    }
    if (folder != null) {
      tester.setFolderName(folder);
    }
    // connecting decides the FHIR version the tests run in
    tester.startRun();
    return tester;
  }

  private JsonObject describe(String id, ServerTxTester tester) throws IOException {
    JsonObject res = new JsonObject();
    if (id != null) {
      res.add("session", id);
    }
    res.add("server", tester.getServer());
    res.add("test-version", tester.loader.version());
    res.add("fhirVersion", tester.getServerVersion());
    res.add("software", tester.getSoftware());
    JsonArray features = res.forceArray("features");
    for (String f : tester.getFeatures()) {
      features.add(f);
    }
    res.add("output", tester.getOutput());
    return res;
  }

  // ---- one test -----------------------------------------------------------------------------

  private void runTest(HttpExchange exchange) throws Exception {
    Map<String, String> params = parseQueryParams(exchange.getRequestURI().getQuery());
    String suiteName = params.get("suite");
    String testName = params.get("test");
    String session = params.get("session");
    String label = params.get("label");
    if (suiteName == null) {
      throw new RequestException(400, "Missing required parameter 'suite'");
    }
    if (testName == null) {
      throw new RequestException(400, "Missing required parameter 'test'");
    }

    ServerTxTester tester;
    if (session != null) {
      for (String n : SETUP_ONLY) {
        if (params.containsKey(n)) {
          throw new RequestException(400, "The parameter '" + n + "' is fixed for the session by setup, and can't be passed with a test"
            + ("version".equals(n) ? " (the FHIR version is the server's)" : ""));
        }
      }
      tester = findSession(session);
    } else {
      tester = legacyTester(params);
    }

    Set<String> modes = new TreeSet<>();
    if (params.containsKey("modes")) {
      modes.addAll(parseListParameter(params.get("modes")));
    } else {
      modes.addAll(DEFAULT_MODES);
    }
    if (label != null) {
      String err = TxTester.checkFolderName(label);
      if (err != null) {
        throw new RequestException(400, "Invalid 'label' parameter: " + err);
      }
    }

    JsonObject suite = tester.getSuite(suiteName);
    JsonObject test = tester.getTest(suite, testName);
    OperationOutcome outcome;
    String err = tester.executeTest(tester.loader, suite, test, modes, label);
    if (err == null) {
      outcome = OperationOutcomeUtilities.createSuccess("Test passed");
    } else if (TxTester.isNotRun(err)) {
      // The test never ran. Asking for it is an error, but it is neither a pass nor a failure
      // of the server, and the run's results don't count it. Say why it didn't run.
      outcome = OperationOutcomeUtilities.createError("Test '" + suiteName + "/" + testName + "' did not run: "
        + describeNotRun(tester, err, suite, test, modes));
    } else {
      outcome = OperationOutcomeUtilities.createError(err);
    }
    sendOperationOutcome(exchange, 200, outcome, getAcceptHeader(exchange));
  }

  private String describeNotRun(ServerTxTester tester, String err, JsonObject suite, JsonObject test, Set<String> modes) {
    if (TxTester.NOT_RUN_DISABLED.equals(err)) {
      return "it is disabled";
    } else if (TxTester.NOT_RUN_FEATURES.equals(err)) {
      return tester.describeFeatureGate(suite, test);
    } else if (TxTester.NOT_RUN_VERSION.equals(err)) {
      return tester.describeVersionGate(suite, test);
    } else {
      return "it is gated on mode " + describeModeGate(suite, test)
        + ", and the modes requested were [" + String.join(", ", new TreeSet<>(modes))
        + "]. Pass it in the 'modes' parameter to run this test.";
    }
  }

  /** The tester for a call made the old way, with a server and no session: one per server, made on first use. */
  private ServerTxTester legacyTester(Map<String, String> params) throws Exception {
    String server = params.get("server");
    if (server == null) {
      throw new RequestException(400, "Missing required parameter 'session' (from /txTest/setup)");
    }
    ServerTxTester tester = fhirValidatorHttpService.getTxTesters().get(LEGACY_PREFIX + server);
    if (tester == null) {
      String externalFile = params.get("externals");
      if (externalFile == null) {
        externalFile = "messages-tx.fhir.org.json";
      }
      if (!externalFile.endsWith(".json")) {
        externalFile = externalFile + ".json";
      }
      // the old form names an externals file in the test package
      TxTester.InternalTxLoader probe = new TxTester.InternalTxLoader(context, "current");
      if (!probe.hasContent(externalFile)) {
        throw new RequestException(400, "The externals file '" + externalFile + "' is not in the test package");
      }
      JsonObject externals = JsonParser.parseObject(probe.loadContent(externalFile));
      tester = createTester(server, "current", externals, externalFile, params.get("folder"), null);
      fhirValidatorHttpService.getTxTesters().put(LEGACY_PREFIX + server, tester);
    }
    return tester;
  }

  private ServerTxTester findSession(String session) throws RequestException {
    ServerTxTester tester = fhirValidatorHttpService.getTxTesters().get(session);
    if (tester == null || session.startsWith(LEGACY_PREFIX)) {
      throw new RequestException(404, "Unknown session '" + session + "': start one with POST /txTest/setup (sessions end at teardown)");
    }
    return tester;
  }

  /**
   * The modes a test is gated on, for the message when it does not run. A test that names no
   * mode always runs, so this only ever has to describe one that does - but both the suite and
   * the test can carry a gate, and either can be the one that stopped it.
   */
  private String describeModeGate(JsonObject suite, JsonObject test) {
    Set<String> required = new LinkedHashSet<>();
    for (JsonObject o : new JsonObject[] { suite, test }) {
      if (o.has("modes")) {
        required.addAll(o.getStrings("modes"));
      }
      if (o.has("mode")) {
        required.add(o.asString("mode"));
      }
    }
    return required.isEmpty() ? "(no mode)" : "[" + String.join(", ", required) + "]";
  }

  // ---- teardown -----------------------------------------------------------------------------

  /**
   * Ends the session, and returns {"session", "test-results", "report"}: test-results.json and
   * report.json, as the command line writes them (they are written to the output folder too).
   */
  private void teardown(HttpExchange exchange) throws Exception {
    Map<String, String> params = parseQueryParams(exchange.getRequestURI().getQuery());
    String session = params.get("session");
    String key;
    if (session != null) {
      findSession(session);
      key = session;
    } else if (params.get("server") != null) {
      key = LEGACY_PREFIX + params.get("server");
      if (!fhirValidatorHttpService.getTxTesters().containsKey(key)) {
        throw new RequestException(404, "No tests have been run for the server '" + params.get("server") + "'");
      }
    } else {
      throw new RequestException(400, "Missing required parameter 'session'");
    }
    ServerTxTester tester = fhirValidatorHttpService.getTxTesters().remove(key);
    JsonObject results = tester.finishRun();
    String report = new org.hl7.fhir.model.core.formats.JsonParser(context).composeString(tester.getTestReport());

    JsonObject res = new JsonObject();
    if (session != null) {
      res.add("session", session);
    }
    res.add("output", tester.getOutput());
    res.add("test-results", results);
    res.add("report", JsonParser.parseObject(report.getBytes(StandardCharsets.UTF_8)));
    sendResponse(exchange, 200, JsonParser.compose(res, true), "application/json");
  }
}
