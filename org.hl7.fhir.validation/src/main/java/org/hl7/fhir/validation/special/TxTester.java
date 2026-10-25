package org.hl7.fhir.validation.special;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.convertors.txClient.TerminologyClientFactory;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.model.Base;
import org.hl7.fhir.model.IModelContext;
import org.hl7.fhir.model.ModelContext;
import org.hl7.fhir.services.client.ClientHeaders;
import org.hl7.fhir.services.client.EFhirClientException;
import org.hl7.fhir.services.client.ITerminologyClientN;
import org.hl7.fhir.services.client.ResourceFormat;
import org.hl7.fhir.model.core.Bundle;
import org.hl7.fhir.model.core.Bundle.BundleEntryComponent;
import org.hl7.fhir.model.core.CapabilityStatement;
import org.hl7.fhir.model.core.DateTimeType;
import org.hl7.fhir.model.core.Period;
import org.hl7.fhir.model.core.ConceptMap;
import org.hl7.fhir.model.core.OperationOutcome;
import org.hl7.fhir.model.core.Parameters;
import org.hl7.fhir.model.core.Resource;
import org.hl7.fhir.model.core.StringType;
import org.hl7.fhir.model.core.TerminologyCapabilities;
import org.hl7.fhir.model.testing.TestReport;
import org.hl7.fhir.model.testing.TestReport.TestReportActionResultValueSet;
import org.hl7.fhir.model.testing.TestReport.TestReportParticipantTypeValueSet;
import org.hl7.fhir.model.testing.TestReport.TestReportResultValueSet;
import org.hl7.fhir.model.testing.TestReport.TestReportStatusValueSet;
import org.hl7.fhir.model.testing.TestReport.TestReportTestComponent;
import ca.uhn.fhir.model.api.TemporalPrecisionEnum;
import org.hl7.fhir.model.core.ValueSet;
import org.hl7.fhir.model.utilities.formats.OutputStyle;

import org.hl7.fhir.services.testing.CompareUtilities;
import org.hl7.fhir.standalone.terminology.client.TerminologyClientContext;
import org.hl7.fhir.utilities.*;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.http.HTTPHeader;
import org.hl7.fhir.utilities.http.HTTPResult;
import org.hl7.fhir.utilities.http.ManagedWebAccess;
import org.hl7.fhir.utilities.http.URLUtil;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;

@Slf4j
public class TxTester implements ITerminologyRequestIdProvider {


  @Override
  public String getRequestId() {
    String result = nextRequestId.get();
    nextRequestId.remove();
    return result;
  }

  public static class ResultInformation {
    private boolean result;
    private String message;

    public ResultInformation(boolean result) {
      this.result = result;
    }

    public ResultInformation(String message) {
      this.message = message;
      this.result = false;
    }
  }

  public interface ITxTesterLoader {
    public String describe();
    public Resource loadResource(String filename) throws IOException, FHIRFormatError, FileNotFoundException, FHIRException, DefinitionException;
    public byte[] loadContent(String filename) throws FileNotFoundException, IOException;
    public boolean hasContent(String filename) throws IOException;
    public String code();
    public String version() throws JsonException, IOException;
    public String testFileName();
  }

  private class TxTesterConversionLogger implements ITerminologyClientN.ITerminologyConversionLogger {

    // Per-thread so concurrent tests don't write each other's conversion
    // artefacts into the wrong suite/test directory.
    public final ThreadLocal<String> suiteName = new ThreadLocal<>();
    public final ThreadLocal<String> testName = new ThreadLocal<>();

    @Override
    public void log(String name, String mode, String resourceType, String version, byte[] cnt) {
      String base;
      try {
        base = Utilities.path(outputDir, "conversions");
        if (ManagedFileAccess.file(base).exists()) {
          String dir = Utilities.path(base, version, suiteName.get());
          FileUtilities.createDirectory(dir);
          String filename = Utilities.path(dir, testName.get()+"."+mode+".json");
          FileUtilities.bytesToFile(cnt, filename);
        }
      } catch (IOException e) {
        // TODO Auto-generated catch block
        log.error(e.getMessage(), e);
      }
    }
  }

  private final String version;
  // Per-thread so concurrent executeTest calls don't step on each other's
  // request-correlation IDs. Consumed (remove()) by the HTTP client's single
  // getRequestId() call on the same thread that set it.
  private final ThreadLocal<String> nextRequestId = new ThreadLocal<>();
  private String server;
  private List<ITxTesterLoader> loaders = new ArrayList<>();
  private String outputDir;
  private String folderName;
  // Per-thread ITerminologyClient. Every operation mutates client state
  // (setAcceptLanguage, setClientHeaders) before dispatch; giving each worker
  // its own client makes those mutations private to that worker and removes
  // the need for cross-thread synchronisation around the dispatch itself.
  // Lazily created on first use per thread via client(); the one-time
  // capability-statement fetch runs against the main-thread bootstrap client
  // inside initialise().
  private final ThreadLocal<ITerminologyClientN> terminologyClient = new ThreadLocal<>();
  // Modes passed to the first initialise() call, cached so worker threads can
  // lazily construct their own clients with the same connection config.
  private volatile Set<String> clientModes;
  private boolean tight;
  private JsonObject externals;
  private String software;
  // CopyOnWriteArrayList: concurrent-safe writes, snapshot iteration. Writes
  // are infrequent (once per failed test / once per operation), so the O(n)
  // copy cost on each add is negligible.
  private final List<String> fails = new CopyOnWriteArrayList<>();

  @Getter
  // Warnings are recorded from CompareUtilities ($optional$ items marked
  // "warning:..." that were absent from the response) but they do NOT make a test
  // fail, and no longer cause the expected/actual pair to be written out either -
  // a passing test should leave no diff output behind.
  private final List<String> warnings = new CopyOnWriteArrayList<>();
  private CapabilityStatement capabilityStatement;
  private TerminologyCapabilities terminologyCapabilities;
  private IModelContext context = ModelContext.fullCoreContext();

  /**
   * The FHIR version the server under test reports, discovered in connectToServer(). This is
   * what the suites' and tests' version gates are evaluated against - see passesVersion(). It
   * is set once, on the calling thread, before initialise() returns and therefore before any
   * gate is evaluated or any worker thread starts.
   */
  private volatile String serverVersion;
  // Server-side caching state, per thread (clients are per-thread). Maps a suite
  // name to the server-issued cache-id this thread holds for it. The first test a
  // thread runs from a suite starts a cache and front-loads that suite's setup
  // resources into it; later tests from the same suite on the same thread carry
  // the cache-id as the X-Cache-Id header instead of re-sending the setup. Tests
  // from one suite can be scheduled across many threads, so each thread caches the
  // suites it happens to run - that's fine, the caches are independent.
  private final ThreadLocal<Map<String, String>> suiteCaches = ThreadLocal.withInitial(HashMap::new);
  // Every closure test names the same closure table, so two runs against one server at
  // the same time would add to, and reset, each other's table and fail on the versions.
  // Each run uses its own table instead: a fresh UUID, because servers may require closure
  // table names to be UUIDs. The expected responses don't check the name.
  private final String closureTableName = UUID.randomUUID().toString();
  private TxTesterConversionLogger conversionLogger;
  private TestReport testReport;
  // who ran the tests: the start of TestReport.tester, which goes on to list the modes
  private String testerName = "HL7 Ecosystem Test Runner";
  private static final String TEST_CASES_URL = "https://github.com/HL7/fhir-tx-ecosystem-ig/blob/main/tests/test-cases.json";
  private static final String TEST_ENGINE_URL = "https://github.com/hapifhir/org.hl7.fhir.core";

  public TxTester(ITxTesterLoader loader, String server, boolean tight, JsonObject externals, String version) {
    super();
    this.server = server;
    this.loaders.add(loader);
    this.tight = tight;
    this.externals = externals;
    this.version = version;
    conversionLogger = new TxTesterConversionLogger();
    testReport = new TestReport();
  }

  public static void main(String[] args) throws Exception {
    new TxTester(new InternalTxLoader(ModelContext.fullCoreContext(), args[0]), args[1], "true".equals(args[2]), args.length == 5 ? JsonParser.parseObjectFromFile(args[4]) : null, null).execute(new HashSet<>(), args[3]);
  }

  public void addLoader(ITxTesterLoader loader) {
    this.loaders.add(loader);
  }

  public boolean execute(Set<String> modes, String filter) throws IOException, URISyntaxException {
    return execute(modes, filter, null);
  }

  public boolean execute(Set<String> modes, String filter, String suite) throws IOException, URISyntaxException {
    if (outputDir == null) {
      outputDir = Utilities.path("[tmp]", outputFolder());
    }

    log.info("Run terminology service Tests");
    log.info("  Source for tests: "+loaders.get(0).describe());
    for (ITxTesterLoader loader : loaders) {
      if (loader != loaders.get(0)) {
        log.info("  Additional Tests: "+loader.describe());
      }
    }
    log.info("  Output Directory: "+outputDir);
    if (!ManagedFileAccess.file(outputDir).exists()) {
      FileUtilities.createDirectory(outputDir);
    }
    if (!ManagedFileAccess.file(outputDir).exists()) {
      throw new IOException("Unable to create output directory "+outputDir);
    }
    FileUtilities.createDirectory(Utilities.path(outputDir, "actual"));
    FileUtilities.createDirectory(Utilities.path(outputDir, "expected"));
    log.info("  Term Service Url: "+server);
    // the server's name and version are filled in from its CapabilityStatement (checkClient)
    testReport.addParticipant().setType(TestReportParticipantTypeValueSet.SERVER).setUri(server);
    log.info("  External Strings: "+(externals != null));
    log.info("  Test  Exec Modes: "+modes.toString());
    describeRunner(modes);

    if (filter != null) {
      log.info("  Filter Parameter: "+filter);
    }
    if (suite != null) {
      log.info("  Suite Parameter: "+suite);
    }

    AtomicInteger counter = new AtomicInteger();
    AtomicInteger errCount = new AtomicInteger();
    JsonObject json = new JsonObject();
    List<StringPair> versions = new ArrayList<StringPair>();
    json.add("date", new SimpleDateFormat("EEE, MMM d, yyyy HH:mmZ", new Locale("en", "US")).format(Calendar.getInstance().getTime()) + timezone());
    try {
      // execute() is the legacy standalone entry point. Use initialise() so
      // both the client and the per-thread ThreadLocal entry get populated
      // on this (main) thread.
      initialise(modes);
      boolean ok = true;
      for (ITxTesterLoader loader : loaders) {
        JsonObject tests = loadTests(loader);
        readTests(tests, loader.version());
        versions.add(new StringPair(loader.code(), loader.version()));
        for (JsonObject suiteObj : tests.getJsonObjects("suites")) {
          if ((!suiteObj.has("mode") || modes.contains(suiteObj.asString("mode"))) && passesVersion(suiteObj) && passesFeatures(suiteObj)) {
            if (suiteObj.asBoolean("disabled")) {
              // ok = true;
            } else if (suite == null || suite.equals(suiteObj.asString("name"))) {
              ok = runSuite(loader, suiteObj, modes, filter, json.forceArray("suites"), counter, errCount) && ok;
            }
          }
        }
      }
      FileUtilities.stringToFile(JsonParser.compose(json, true), Utilities.path(outputDir, "test-results.json"));

      completeReport(counter.intValue(), errCount.intValue());

      if (filter == null && suite == null) {
        String m = modes.isEmpty() ? "[none]" : CommaSeparatedStringBuilder.join("+", modes);
        if (ok) {
          log.info(software+" passed all "+counter.intValue()+" HL7 terminology service tests ("+Utilities.pluralize("mode", modes.size())+" "+m+", tests v"+vString(versions)+", runner v"+VersionUtil.getBaseVersion()+")");
          return true;
        } else {
          log.info(software+" failed "+errCount.intValue()+" of "+counter.intValue()+" HL7 terminology service tests ("+Utilities.pluralize("mode", modes.size())+" "+m+", tests v"+vString(versions)+", runner v"+VersionUtil.getBaseVersion()+")");
          log.info("Failed Tests: "+ CommaSeparatedStringBuilder.join(",", fails ));
          return false;
        }
      } else if (suite != null) {
        String m = modes.isEmpty() ? "[none]" : CommaSeparatedStringBuilder.join("+", modes);
        int passed = counter.intValue() - errCount.intValue();
        if (ok) {
          log.info(software+" passed all "+counter.intValue()+" tests for suite '"+suite+"' ("+passed+" passed, 0 failed, "+Utilities.pluralize("mode", modes.size())+" "+m+", tests v"+vString(versions)+", runner v"+VersionUtil.getBaseVersion()+")");
        } else {
          log.info(software+" did not pass tests for suite '"+suite+"' ("+passed+" passed, "+errCount.intValue()+" failed of "+counter.intValue()+", "+Utilities.pluralize("mode", modes.size())+" "+m+", tests v"+vString(versions)+", runner v"+VersionUtil.getBaseVersion()+")");
          log.info("Failed Tests: "+ CommaSeparatedStringBuilder.join(",", fails));
        }
        return ok;
      } else {
        log.info(software+" "+(ok ? "Passed the tests" : "did not pass the tests")+" '"+filter+"'");
        return ok;
      }
    } catch (Exception e) {
      log.error("Exception running Terminology Service Tests: "+e.getMessage(), e);
      return false;
    } finally {
      TxTesterLogFile.stop();
    }
  }

//
//  private TestCasesSuiteComponent getSuite(JsonObject suite) {
//    for (TestCasesSuiteComponent t : testCases.getSuite()) {
//      if (t.getName().equals(suite.asString("name"))) {
//        return t;
//      }
//    }
//    TestCasesSuiteComponent t = testCases.addSuite();
//    t.setName(suite.asString("name"));
//    t.setDescription(suite.asString("description"));
//    if (suite.has("notes")) {
//      t.setDescription(t.getDescription()+". "+suite.asString("notes"));
//    }
//    for (String s : suite.getStrings("setup")) {
//      t.addSetup().setFile(s);
//    }
//    return t;
//  }
//
//  private TestCasesSuiteTestComponent getSuiteTest(TestCasesSuiteComponent tcs, JsonObject test) {
//    for (TestCasesSuiteTestComponent t : tcs.getTest()) {
//      if (t.getName().equals(test.asString("name"))) {
//        return t;
//      }
//    }
//    TestCasesSuiteTestComponent t = tcs.addTest();
//    t.setName(test.asString("name"));
//    if (test.has("explanation")) {
//      t.setDescription(test.asString("explanation"));
//    } else {
//      t.setDescription(test.asString("description"));
//    }
//    t.setOperation(test.asString("operation"));
//    if (test.has("mode")) {
//      t.setMode(test.asString("mode"));
//    }
//    if (test.has("request")) {
//      t.addInput().setName("request").setFile(test.asString("request"));
//    }
//    if (test.has("response")) {
//      t.addOutput().setName("response").setFile(test.asString("response"));
//    }
//    for (JsonProperty p : test.getProperties()) {
//      if (p.getName().startsWith("request:")) {
//        t.addInput().setName("request").setMode(p.getName().substring(8)).setFile(p.getValue().asString());
//      }
//      if (p.getName().startsWith("response:")) {
//        t.addInput().setName("response").setMode(p.getName().substring(9)).setFile(p.getValue().asString());
//      }
//    }
//    if (test.has("Accept-Language")) {
//      t.addParameter().setName("Accept-Language").setValue(new StringType(test.asString("Accept-Language")));
//    }
//    if (test.has("http-code")) {
//      t.addParameter().setName("http-code").setValue(new StringType(test.asString("http-code")));
//    }
//    if (test.has("profile")) {
//      t.addParameter().setName("profile").setValue(new StringType(test.asString("profile")));
//    }
//    if (test.has("header")) {
//      JsonObject hdr = test.getJsonObject("header");
//      t.addParameter().setMode(hdr.asString("mode")).setName("header").setValue(new StringType(hdr.asString("name")+": "+hdr.asString("value")));
//    }
//    return t;
//  }

  private void readTests(JsonObject tests, String version) {
//    testCases.setIdBase("tx-ecosystem-test-cases");
//    testCases.setUrl("http://hl7.org/fhir/uv/tx-ecosystem/TestCases/tx-ecosystem-test-cases");
//    testCases.setVersion(version);
//    testCases.setName("TxEcosystemTests");
//    testCases.setDescription(tests.asString("introduction"));
    testReport.setName("TxEcosystemTests");
    testReport.setTestScript(TEST_CASES_URL+"|"+version);
    testReport.setStatus(TestReportStatusValueSet.COMPLETED);
  }

  /**
   * Who ran the tests, for TestReport.tester (default "HL7 Ecosystem Test Runner"). The
   * modes are added after it, e.g. "FHIRsmith build (modes general, snomed)".
   */
  public TxTester setTesterName(String testerName) {
    this.testerName = testerName;
    return this;
  }

  /** Who ran the tests, and with which modes: TestReport.tester and the test engine participant. */
  private void describeRunner(Set<String> modes) {
    List<String> modeList = Utilities.sorted(modes);
    testReport.setTester(testerName+" (modes "+String.join(", ", modeList)+")");
    testReport.addParticipant().setType(TestReportParticipantTypeValueSet.TESTENGINE).setUri(TEST_ENGINE_URL)
      .setVersion(VersionUtil.getBaseVersion()).setDisplay("HL7 Ecosystem Test Runner (modes "+String.join("+", modeList)+")");
  }

  /**
   * The overall outcome on the TestReport, once every test has run. TestReport.score is the
   * percentage of tests passed (0..100), not a fraction. Kept to two decimal places, so a single
   * failure in a large run doesn't round away to 100
   */
  private void completeReport(int total, int errors) {
    double score = total == 0 ? 0 : Math.round((total - errors) * 10000.0 / total) / 100.0;
    testReport.setScore(score);
    testReport.setResult(errors == 0 ? TestReportResultValueSet.PASS : TestReportResultValueSet.FAIL);
    testReport.setIssuedElement(instant(System.currentTimeMillis()));
  }

  /** A dateTime to the millisecond, in UTC - the default precision is only seconds. */
  private static DateTimeType instant(long ms) {
    return new DateTimeType(new Date(ms), TemporalPrecisionEnum.MILLI, TimeZone.getTimeZone("UTC"));
  }

  /** Record a test's outcome on its TestReport.test: its result, as the test's and its action's, and how long it took. */
  private static void recordResult(TestReportTestComponent tr, TestReportActionResultValueSet result, String message, long start) {
    tr.setResult(result);
    tr.getActionFirstRep().getOperation().setResult(result).setMessage(message);
    tr.setPeriod(new Period().setStartElement(instant(start)).setEndElement(instant(System.currentTimeMillis())));
  }

  private TestReportTestComponent getTestReportTest(JsonObject suite, JsonObject test) {
    // Synchronise the mutation on the top-level TestReport resource. Each
    // returned TestReportTestComponent is only touched by its owning thread
    // after this point, so no further locking is required.
    final TestReportTestComponent t;
    synchronized (testReport) {
      t = testReport.addTest();
    }
    t.setName(suite.asString("name")+"/"+test.asString("name"));
    t.getActionFirstRep().getOperation().setResult(TestReportActionResultValueSet.SKIP);
    return t;
  }

  private String vString(List<StringPair> versions) {
    StringBuilder b = new StringBuilder();
    b.append(versions.get(0).getValue());
    if (versions.size() > 1) {
      b.append("[");
      for (int i = 1; i < versions.size(); i++) {
        if (i > 1) {
          b.append(",");
        }
        b.append(versions.get(i).getName());
        b.append(":");
        b.append(versions.get(i).getValue());
      }
      b.append("]");
    }
    return b.toString();
  }

  private String timezone() {
    TimeZone tz = TimeZone.getDefault();
    Calendar cal = GregorianCalendar.getInstance(tz);
    int offsetInMillis = tz.getOffset(cal.getTimeInMillis());

    String offset = String.format("%02d:%02d", Math.abs(offsetInMillis / 3600000), Math.abs((offsetInMillis / 60000) % 60));
    offset = (offsetInMillis >= 0 ? "+" : "-") + offset;

    return offset;
  }

  private boolean checkClient() throws URISyntaxException, IOException {
    conversionLogger.suiteName.set("connect");
    conversionLogger.testName.set("checkClient");
    capabilityStatement = client().getCapabilitiesStatement();
    if (capabilityStatement.hasSoftware()) {
      software = capabilityStatement.getSoftware().getName()+" v"+ capabilityStatement.getSoftware().getVersion();
      testReport.getParticipantFirstRep().setDisplay(capabilityStatement.getSoftware().getName());
      if (capabilityStatement.getSoftware().hasVersion()) {
        testReport.getParticipantFirstRep().setVersion(capabilityStatement.getSoftware().getVersion());
      }
    }
    terminologyCapabilities = client().getTerminologyCapabilities();
    features = featuresFor(capabilityStatement);
    log.info("  Server Features: "+(features.isEmpty() ? "(none)" : String.join(", ", features)));
    for (String f : features) {
      testReport.addParameter().setName(f);
    }
    return true;
  }

  // ---- features ------------------------------------------------------------------------------
  //
  // A suite or test can say "feature" : "a,b": it only runs when the server declares all of
  // them. Unlike modes, which the person running the tests chooses, features come from what the
  // server says about itself in its CapabilityStatement (see featuresFor).

  public static final String FEATURE_EXTENSION = "http://hl7.org/fhir/uv/application-feature/StructureDefinition/feature";
  public static final String CODESYSTEM_AS_PARAMETER = "http://hl7.org/fhir/uv/tx-ecosystem/FeatureDefinition/CodeSystemAsParameter";

  // operation name -> the feature declaring it gives
  private static final String[][] OPERATION_FEATURES = {
    { "expand", "expand" },
    { "validate-code", "validate" },
    { "lookup", "lookup" },
    { "subsumes", "subsumes" },
    { "translate", "translate" },
    { "closure", "closure" },
    { "related", "related" }
  };

  /** The features a suite or test can name. */
  public static final Set<String> KNOWN_FEATURES = Collections.unmodifiableSet(new TreeSet<>(Arrays.asList(
    "expand", "validate", "lookup", "subsumes", "translate", "closure", "related", "tx-resource")));

  private Set<String> features = new TreeSet<>();
  private final Set<String> warnedFeatures = Collections.synchronizedSet(new HashSet<>());

  public Set<String> getFeatures() {
    return features;
  }

  /**
   * The features a server declares in its CapabilityStatement:
   * - an operation (expand, validate, lookup, subsumes, translate, closure, related) when it
   *   declares that operation anywhere - at system level, or on any resource - by name, or by an
   *   OperationDefinition whose id ends with it (ValueSet-expand, CodeSystem-validate-code...)
   * - tx-resource when it declares the CodeSystemAsParameter feature, with the value true
   */
  public static Set<String> featuresFor(CapabilityStatement cs) {
    Set<String> res = new TreeSet<>();
    if (cs == null) {
      return res;
    }
    List<org.hl7.fhir.model.core.Extension> exts = new ArrayList<>();
    exts.addAll(cs.getExtensionsByUrl(FEATURE_EXTENSION));
    for (CapabilityStatement.CapabilityStatementRestComponent rest : cs.getRestList()) {
      exts.addAll(rest.getExtensionsByUrl(FEATURE_EXTENSION));
      for (CapabilityStatement.CapabilityStatementRestResourceOperationComponent op : rest.getOperationList()) {
        exts.addAll(op.getExtensionsByUrl(FEATURE_EXTENSION));
        addOperationFeature(res, op.getName(), op.getDefinition());
      }
      for (CapabilityStatement.CapabilityStatementRestResourceComponent r : rest.getResourceList()) {
        exts.addAll(r.getExtensionsByUrl(FEATURE_EXTENSION));
        for (CapabilityStatement.CapabilityStatementRestResourceOperationComponent op : r.getOperationList()) {
          exts.addAll(op.getExtensionsByUrl(FEATURE_EXTENSION));
          addOperationFeature(res, op.getName(), op.getDefinition());
        }
      }
    }
    for (org.hl7.fhir.model.core.Extension ext : exts) {
      String d = null;
      org.hl7.fhir.model.core.DataType value = null;
      for (org.hl7.fhir.model.core.Extension sub : ext.getExtension()) {
        if ("definition".equals(sub.getUrl()) && sub.getValue() != null) {
          d = sub.getValue().primitiveValue();
        } else if ("value".equals(sub.getUrl())) {
          value = sub.getValue();
        }
      }
      if (d != null && d.contains("|")) {
        d = d.substring(0, d.indexOf("|"));
      }
      if (CODESYSTEM_AS_PARAMETER.equals(d) && value instanceof org.hl7.fhir.model.core.BooleanType
          && ((org.hl7.fhir.model.core.BooleanType) value).getValue() != null
          && ((org.hl7.fhir.model.core.BooleanType) value).booleanValue()) {
        res.add("tx-resource");
      }
    }
    return res;
  }

  private static void addOperationFeature(Set<String> res, String name, String definition) {
    String tail = null;
    if (definition != null) {
      tail = definition.contains("|") ? definition.substring(0, definition.indexOf("|")) : definition;
      tail = tail.substring(tail.lastIndexOf("/") + 1);
    }
    for (String[] of : OPERATION_FEATURES) {
      if (of[0].equals(name) || (tail != null && (tail.equals(of[0]) || tail.endsWith("-" + of[0])))) {
        res.add(of[1]);
      }
    }
  }

  /** The features a suite or test needs: its "feature", a comma separated list. */
  static List<String> neededFeatures(JsonObject obj) {
    List<String> res = new ArrayList<>();
    if (obj != null && obj.has("feature")) {
      // a plain comma scan - no regex
      String src = obj.asString("feature");
      int start = 0;
      while (start <= src.length()) {
        int end = src.indexOf(',', start);
        if (end < 0) {
          end = src.length();
        }
        String f = src.substring(start, end).trim();
        if (!f.isEmpty()) {
          res.add(f);
        }
        start = end + 1;
      }
    }
    return res;
  }

  /**
   * Whether the server declares every feature the suite or test needs. A feature that isn't one
   * of KNOWN_FEATURES (a typo in the test cases, say) is never declared, so the test doesn't run -
   * and that is logged, once per feature, so that it doesn't just quietly disappear.
   */
  private boolean passesFeatures(JsonObject obj) {
    for (String f : neededFeatures(obj)) {
      if (!KNOWN_FEATURES.contains(f) && warnedFeatures.add(f)) {
        log.warn("Unknown feature '"+f+"' in the test cases (known features: "+String.join(", ", KNOWN_FEATURES)+") - tests that need it will not run");
      }
      if (!features.contains(f)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Why a test doesn't run because of its features: what it needs, and what the server declares.
   * Null if it isn't stopped by features.
   */
  public String describeFeatureGate(JsonObject suite, JsonObject test) {
    List<String> missing = new ArrayList<>();
    List<String> needed = new ArrayList<>(neededFeatures(suite));
    needed.addAll(neededFeatures(test));
    for (String f : needed) {
      if (!features.contains(f) && !missing.contains(f)) {
        missing.add(f);
      }
    }
    if (missing.isEmpty()) {
      return null;
    }
    return "it needs the feature(s) [" + String.join(", ", missing) + "], and the server only declares ["
      + String.join(", ", features) + "]";
  }

  private JsonObject loadTests(ITxTesterLoader loader) throws JsonException, IOException {
    log.info("Load Tests from "+loader.describe());
    return JsonParser.parseObject(loader.loadContent(loader.testFileName()));
  }

  private byte[] fetch(String url) throws IOException {
    String urlWithNoCacheParam = URLUtil.getUrlWithNoCacheParam(url);
    HTTPResult res = ManagedWebAccess.get(Arrays.asList("web"), urlWithNoCacheParam, "application/json, application/fhir+json");
    return res.getContent();
  }

  private ITerminologyClientN connectToServer(Set<String> modes) throws URISyntaxException, IOException {
    log.info("Connect to "+server);
    software = server;

    if (outputDir == null) {
      outputDir = Utilities.path("[tmp]", outputFolder());
    }
    // from here on, everything logged to the console is also written to test.log in the
    // output directory. This is the one point both entry points pass through - execute()
    // for a whole run, executeTest() one test at a time from the JUnit runners - and the
    // first at which the output directory is known.
    String logFile = TxTesterLogFile.start(outputDir);
    if (logFile != null) {
      log.info("  Log File: "+logFile);
    }

    String fhirVersion = determineFhirVersion();

    if (serverVersion == null) {
      serverVersion = fhirVersion;
    }

    ITerminologyClientN client = null;

    if (VersionUtilities.isR5Plus(fhirVersion)) {
      client = new TerminologyClientFactory(FhirPublication.R5).makeClientN(context,"Test-Server", server, "Tools/Java", null);
    } else if (VersionUtilities.isR4Plus(fhirVersion)) {
      FileUtilities.createDirectory(Utilities.path(outputDir, "conversions", "r4"));
      FileUtilities.createDirectory(Utilities.path(outputDir, "conversions", "r5"));
      client = new TerminologyClientFactory(FhirPublication.R4).makeClientN(context,"Test-Server", server, "Tools/Java", null);
      client.setConversionLogger(conversionLogger);
    } else {
      throw new FHIRException("unsupported FHIR Version for terminology tests: "+fhirVersion);
    }
    client.setFormat(ResourceFormat.RESOURCE_JSON);
    client.setRequestIdProvider(this);
    return client;
  }

  /**
   * Work out which FHIR version the server under test speaks.
   *
   * This is not optional information: it decides which terminology client is used, and it is what
   * the suites' and tests' version gates are evaluated against (see passesVersion()). Guessing it
   * produces a run that looks fine and means nothing - the wrong client, and version gated tests
   * silently included or excluded - so if we cannot determine it, we stop.
   *
   * Two probes, in order:
   *  - $versions, the terminology ecosystem's own version discovery;
   *  - /metadata, which per the specification returns a CapabilityStatement, and so carries
   *    fhirVersion. (TerminologyCapabilities is the response to /metadata?mode=terminology, which
   *    is fetched separately in checkClient(); a server that returns one from unqualified /metadata
   *    is not conformant, and the error says so rather than leaving the user to guess.)
   */
  private String determineFhirVersion() throws IOException {
    List<String> issues = new ArrayList<>();
    String fhirVersion = null;

    try {
      String actFn = Utilities.path(outputRoot(), "actual", "$versions.json");
      byte[] vr = fetch(Utilities.pathURL(server, "$versions", "?_format=json"));
      if (vr == null) {
        issues.add("$versions returned no content");
      } else {
        // create the directory first: execute() makes it for a whole run, but executeTest()
        // (server mode, and the JUnit runners) comes straight here, so without this the write
        // failed and $versions was recorded as unsupported for every server-mode run - which
        // it then silently was, because the fallback to /metadata works
        FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(actFn));
        FileUtilities.bytesToFile(vr, actFn);
        fhirVersion = versionFromVersions(JsonParser.parseObject(vr), issues);
      }
    } catch (Exception e) {
      issues.add("$versions failed: "+e.getMessage());
      log.warn("Server does not support $versions: "+e.getMessage(), e);
    }
    if (fhirVersion != null) {
      log.info("Server version " + fhirVersion + " from $versions");
      return fhirVersion;
    }

    try {
      fhirVersion = versionFromMetadata(JsonParser.parseObjectFromUrl(Utilities.pathURL(server, "metadata", "?_format=json")), issues);
    } catch (Exception e) {
      issues.add("/metadata failed: "+e.getMessage());
      log.warn("Error checking server version: "+e.getMessage(), e);
    }
    if (fhirVersion != null) {
      log.info("Server version "+fhirVersion+" from /metadata");
      return fhirVersion;
    }

    throw new FHIRException("Unable to determine the FHIR version of the terminology server at "+server+", so the tests cannot be run. "+
        "The server must either support $versions, or return a CapabilityStatement with a fhirVersion from /metadata. Details: "+String.join("; ", issues));
  }

  /**
   * The FHIR version from a $versions response: a Parameters with a 'default' parameter, or the
   * bare JSON object with a 'default' property that the operation's simpler form returns. Returns
   * null and appends to issues if neither shape yields a version.
   *
   * The parameter is read as valueCode or valueString: there is no OperationDefinition for
   * $versions to settle which it should be, and the reference implementation sends valueCode, so
   * accepting only one of them means never reading the answer at all.
   */
  static String versionFromVersions(JsonObject vl, List<String> issues) {
    if ("Parameters".equals(vl.asString("resourceType"))) {
      for (JsonObject v : vl.forceArray("parameter").asJsonObjects()) {
        if ("default".equals(v.asString("name"))) {
          String value = v.asString("valueCode") != null ? v.asString("valueCode") : v.asString("valueString");
          if (value != null) {
            return value;
          }
        }
      }
      issues.add("$versions returned a Parameters with no usable 'default' parameter");
      return null;
    } else if (vl.has("default")) {
      return vl.asString("default");
    } else {
      issues.add("Unable to interpret the response from $versions: " + vl.toString());
      return null;
    }
  }

  /**
   * The FHIR version from a /metadata response, which is a CapabilityStatement. Returns null and
   * appends to issues otherwise - naming the resource type that did come back, since the usual
   * cause is a server answering TerminologyCapabilities where CapabilityStatement is specified.
   */
  static String versionFromMetadata(JsonObject cs, List<String> issues) {
    String fhirVersion = cs.asString("fhirVersion");
    if (fhirVersion != null) {
      return fhirVersion;
    }
    String rt = cs.asString("resourceType");
    if (rt != null && !"CapabilityStatement".equals(rt)) {
      issues.add("/metadata returned a "+rt+", not a CapabilityStatement (TerminologyCapabilities is the response to /metadata?mode=terminology, not to /metadata)");
    } else {
      issues.add("/metadata returned a CapabilityStatement with no fhirVersion");
    }
    return null;
  }

  /**
   * Eagerly perform the one-shot, not-thread-safe setup: connect to the server
   * from the calling thread, fetch the CapabilityStatement and
   * TerminologyCapabilities, and stash the modes so worker threads can
   * lazily construct their own clients on first dispatch. Call this once on
   * the main thread before issuing any concurrent executeTest calls.
   * Idempotent — subsequent calls only refresh the stored modes.
   */
  public void initialise(Set<String> modes) throws URISyntaxException, IOException {
    this.clientModes = modes;
    if (capabilityStatement == null) {
      // Bootstrap client on the calling thread — also becomes this thread's
      // ThreadLocal entry, so checkClient() and any later executeTest on the
      // main thread reuse it.
      terminologyClient.set(connectToServer(modes));
      checkClient();
    }
  }

  /**
   * Return the calling thread's ITerminologyClient, constructing it on first
   * access. Each worker gets its own client, so setAcceptLanguage /
   * setClientHeaders mutations never cross thread boundaries.
   */
  private ITerminologyClientN client() throws URISyntaxException, IOException {
    ITerminologyClientN c = terminologyClient.get();
    if (c == null) {
      Set<String> modes = clientModes;
      if (modes == null) {
        throw new IllegalStateException("TxTester not initialised — call initialise(modes) before executeTest()");
      }
      c = connectToServer(modes);
      terminologyClient.set(c);
    }
    return c;
  }

  /** What executeTest returns for a test that didn't run because the server lacks a feature it needs. */
  public static final String NOT_RUN_FEATURES = "n/a:features";

  public String executeTest(ITxTesterLoader loader, JsonObject suite, JsonObject test, Set<String> modes) throws URISyntaxException, FHIRFormatError, FileNotFoundException, IOException {
    return executeTest(loader, suite, test, modes, null);
  }

  /**
   * @param label a subfolder of the run folder for this test's output, or null for the root of
   *   it. A caller that runs the same test more than one way - R4 and R5, cached and not - has
   *   every run writing the same two filenames, so without a label only the last one survives,
   *   and it is not marked as being from the last one.
   */
  public String executeTest(ITxTesterLoader loader, JsonObject suite, JsonObject test, Set<String> modes, String label) throws URISyntaxException, FHIRFormatError, FileNotFoundException, IOException {
    if (label != null) {
      String err = checkFolderName(label);
      if (err != null) {
        throw new FHIRException("Invalid test label: " + err);
      }
    }
    if (suite.asBoolean("disabled") || test.asBoolean("disabled")) {
      recordNotRun(suite, test, modes);
      return NOT_RUN_DISABLED;
    }
    if (!passesModes(suite, modes) || !passesModes(test, modes)) {
      recordNotRun(suite, test, modes);
      return "n/a";
    }

    // Idempotent: populates clientModes and (on the main thread, first call)
    // fetches the capability statement. Worker threads construct their own
    // client lazily via client() inside the operation helpers.
    initialise(modes);
    // features come from the server's CapabilityStatement, and the server's FHIR version from
    // connecting to it, so these can only be checked once initialise has run
    if (!passesFeatures(suite) || !passesFeatures(test)) {
      recordNotRun(suite, test, modes);
      return NOT_RUN_FEATURES;
    }
    if (!passesVersion(suite) || !passesVersion(test)) {
      recordNotRun(suite, test, modes);
      return NOT_RUN_VERSION;
    }
    List<Resource> setup = loadSetupResources(loader, suite);
    TestReportTestComponent tr = run != null ? run.reportTest(suite, test) : getTestReportTest(suite, test);

    ResultInformation ri = runTest(loader, suite, test, setup, modes, "*", null, new AtomicInteger(), tr, label);
    if (run != null) {
      run.record(suite, test, modes, ri.message);
    }
    return ri.message;
  }

  /** What executeTest returns for a test that didn't run because it, or its suite, is disabled. */
  public static final String NOT_RUN_DISABLED = "n/a:disabled";

  /** What executeTest returns for a test that didn't run because the server's FHIR version is excluded by a version gate. */
  public static final String NOT_RUN_VERSION = "n/a:version";

  /**
   * Whether a result from executeTest means that the test did not run at all - it is gated on a
   * mode that wasn't asked for, a feature the server doesn't declare, or a FHIR version the server
   * isn't, or it is disabled - as opposed to having passed (null) or failed (the failure message).
   */
  public static boolean isNotRun(String result) {
    return result != null && (result.equals("n/a") || result.startsWith("n/a:"));
  }

  /** Why a test doesn't run because of its version gate. Null if it isn't stopped by one. */
  public String describeVersionGate(JsonObject suite, JsonObject test) {
    for (JsonObject o : new JsonObject[] { suite, test }) {
      if (!passesVersion(o)) {
        return "it is gated on FHIR version '" + o.asString("version") + "', and the server is FHIR version " + serverVersion;
      }
    }
    return null;
  }

  // ---- runs made one test at a time ----------------------------------------------------------
  //
  // execute() runs everything and writes test-results.json and report.json at the end. A caller
  // that runs the tests one at a time through executeTest() - the validator's server mode - gets
  // the same two reports by bracketing its calls with startRun() and finishRun(). Tests that did
  // not run (disabled, or stopped by a mode, feature or version gate) are not counted as passes
  // or failures, just as a whole run doesn't count them; a test run more than once counts once,
  // with its last result.

  private TestRun run;

  private class TestRun {
    private final String date = new SimpleDateFormat("EEE, MMM d, yyyy HH:mmZ", new Locale("en", "US")).format(Calendar.getInstance().getTime()) + timezone();
    private final Set<String> modes = new TreeSet<>();
    // suite name -> test name -> failure message (null: passed), in the order first run
    private final Map<String, Map<String, String>> results = new LinkedHashMap<>();
    private final Map<String, TestReportTestComponent> reportTests = new HashMap<>();
    private final Set<String> notRun = new TreeSet<>();

    private String key(JsonObject suite, JsonObject test) {
      return suite.asString("name") + "/" + test.asString("name");
    }

    private synchronized TestReportTestComponent reportTest(JsonObject suite, JsonObject test) {
      TestReportTestComponent t = reportTests.get(key(suite, test));
      if (t == null) {
        t = getTestReportTest(suite, test);
        reportTests.put(key(suite, test), t);
      }
      return t;
    }

    private synchronized void record(JsonObject suite, JsonObject test, Set<String> testModes, String message) {
      modes.addAll(testModes);
      notRun.remove(key(suite, test));
      results.computeIfAbsent(suite.asString("name"), k -> new LinkedHashMap<>()).put(test.asString("name"), message);
    }

    private synchronized void recordNotRun(JsonObject suite, JsonObject test, Set<String> testModes) {
      modes.addAll(testModes);
      if (!results.containsKey(suite.asString("name")) || !results.get(suite.asString("name")).containsKey(test.asString("name"))) {
        notRun.add(key(suite, test));
        // getTestReportTest leaves a new entry as a skip
        reportTest(suite, test);
      }
    }
  }

  private void recordNotRun(JsonObject suite, JsonObject test, Set<String> modes) {
    if (run != null) {
      run.recordNotRun(suite, test, modes);
    }
  }

  public boolean isRunStarted() {
    return run != null;
  }

  /**
   * Start a run that will be made one test at a time with executeTest(): connect to the server
   * (which decides the FHIR version the tests are run in) and read the test cases, so that
   * finishRun() can produce the same reports that execute() does.
   */
  public void startRun() throws URISyntaxException, IOException {
    if (run != null) {
      throw new FHIRException("A run has already been started");
    }
    run = new TestRun();
    log.info("Run terminology service Tests, one test at a time");
    log.info("  Source for tests: "+loaders.get(0).describe());
    log.info("  Term Service Url: "+server);
    log.info("  External Strings: "+(externals != null));
    testReport.addParticipant().setType(TestReportParticipantTypeValueSet.SERVER).setUri(server);
    for (ITxTesterLoader loader : loaders) {
      readTests(loadTests(loader), loader.version());
    }
    initialise(new HashSet<>());
    log.info("  Output Directory: "+outputRoot());
    log.info("  FHIR Version    : "+serverVersion);
  }

  /**
   * Finish a run started with startRun(): write test-results.json and report.json to the output
   * directory, exactly as execute() does, and return test-results.json. The TestReport is
   * getTestReport().
   */
  public JsonObject finishRun() throws IOException, URISyntaxException {
    if (run == null) {
      throw new FHIRException("No run has been started");
    }
    try {
      JsonObject json = new JsonObject();
      int total = 0;
      List<String> failed = new ArrayList<>();
      synchronized (run) {
        json.add("date", run.date);
        for (Map.Entry<String, Map<String, String>> se : run.results.entrySet()) {
          JsonObject so = new JsonObject();
          json.forceArray("suites").add(so);
          so.add("name", se.getKey());
          for (Map.Entry<String, String> te : se.getValue().entrySet()) {
            JsonObject to = new JsonObject();
            so.forceArray("tests").add(to);
            to.add("name", te.getKey());
            to.add("status", te.getValue() == null ? "pass" : "fail");
            if (te.getValue() != null) {
              to.add("message", te.getValue());
              failed.add(se.getKey() + "/" + te.getKey());
            }
            total++;
          }
        }
      }
      describeRunner(run.modes);
      completeReport(total, failed.size());

      String outputDir = outputRoot();
      FileUtilities.createDirectory(outputDir);
      FileUtilities.stringToFile(JsonParser.compose(json, true), Utilities.path(outputDir, "test-results.json"));
      FileUtilities.stringToFile(new org.hl7.fhir.model.core.formats.JsonParser(context).setOutputStyle(OutputStyle.PRETTY).composeString(testReport),
        Utilities.path(outputDir, "report.json"));

      List<String> versions = new ArrayList<>();
      for (ITxTesterLoader loader : loaders) {
        versions.add(loader == loaders.get(0) ? loader.version() : loader.code()+":"+loader.version());
      }
      String m = run.modes.isEmpty() ? "[none]" : String.join("+", run.modes);
      String nr = run.notRun.isEmpty() ? "" : "; "+run.notRun.size()+" did not run";
      String detail = Utilities.pluralize("mode", run.modes.size())+" "+m+", tests v"+String.join(",", versions)+", runner v"+VersionUtil.getBaseVersion();
      if (failed.isEmpty()) {
        log.info(software+" passed all "+total+" HL7 terminology service tests run ("+detail+nr+")");
      } else {
        log.info(software+" failed "+failed.size()+" of "+total+" HL7 terminology service tests run ("+detail+nr+")");
        log.info("Failed Tests: "+String.join(",", failed));
      }
      return json;
    } finally {
      TxTesterLogFile.stop();
    }
  }

  /** The URL of the server under test. */
  public String getServer() {
    return server;
  }

  /** The FHIR version of the server under test, once connected. */
  public String getServerVersion() {
    return serverVersion;
  }

  /** The server's software name and version from its CapabilityStatement, once connected (the server's URL if it doesn't say). */
  public String getSoftware() {
    return software;
  }

  private boolean passesModes(JsonObject obj, Set<String> modes) {
    if (obj.has("modes")) {
      for (String mode : obj.getStrings("modes")) {
        if (modes.contains(mode)) {
          return true;
        }
      }
    }
    if (obj.has("mode")) {
      return modes.contains(obj.asString("mode"));
    }
    return true;
  }

  private boolean runSuite(ITxTesterLoader loader, JsonObject suite, Set<String> modes, String filter, JsonArray output, AtomicInteger counter, AtomicInteger errCount) throws FHIRFormatError, FileNotFoundException, IOException {
    log.info("Group "+suite.asString("name"));
    JsonObject outputS = new JsonObject();
    if (output != null) {
      output.add(outputS);
    }
    outputS.add("name", suite.asString("name"));
    List<Resource> setup = loadSetupResources(loader, suite);
    boolean ok = true;
    try {
      // runTest decides per-test whether to use a server cache for the suite's
      // setup (lazily started on first use per thread); we just pass the setup.
      for (JsonObject test : suite.getJsonObjects("tests")) {
        TestReportTestComponent tr = getTestReportTest(suite, test);
        if ((!test.has("mode") || modes.contains(test.asString("mode"))) && passesVersion(test) && passesFeatures(test)) {
          if (test.asBoolean("disabled")) {
            ok = true;
          } else {
            ResultInformation tok = runTest(loader, suite, test, setup, modes, filter, outputS.forceArray("tests"), counter, tr, null);
            if (!tok.result) {
              errCount.getAndAdd(1);
            }
            ok = tok.result && ok;
          }
        }
      }
    } finally {
      // Sequential path: the suite is finished on this thread, so release its
      // cache promptly. (The concurrent per-test path has no suite-end signal and
      // relies on the server's idle timeout instead.)
      endSuiteCache(suite.asString("name"));
    }
    return ok;
  }

  /**
   * The version gate is a FHIR version, so it is evaluated against the FHIR version the server
   * under test reports - not against anything the caller names. The constructor's version is
   * only a fallback for a tester that has not connected to a server.
   */
  private boolean passesVersion(JsonObject item) {
    String ver = serverVersion != null ? serverVersion : version;
    if (item.has("version") && ver != null) {
      return versionGateMatches(item.asString("version"), ver);
    } else {
      return true;
    }
  }

  /**
   * Does a suite's or test's "version" gate let it run against this FHIR version?
   *
   * The gate is a major.minor prefix - "4.0" runs only on R4 - optionally negated with
   * a leading "!", so "!4.0" runs on everything except R4. Negation is handled here
   * rather than in VersionUtilities, which has no notion of it.
   *
   * This is a deliberate prefix test rather than VersionUtilities.versionMatches: the
   * gate is written as major.minor, but the version it is matched against may be either
   * major.minor ("4.0") or a full version ("4.0.1"), and versionMatches counts the
   * missing patch part as a mismatch in both directions.
   */
  public static boolean versionGateMatches(String gate, String ver) {
    if (gate == null || ver == null) {
      return true;
    }
    if (gate.startsWith("!")) {
      return !versionGateMatches(gate.substring(1), ver);
    }
    return ver.equals(gate) || ver.startsWith(gate + ".");
  }

  private ResultInformation runTest(ITxTesterLoader loader, JsonObject suite, JsonObject test, List<Resource> setup, Set<String> modes, String filter,
                                    JsonArray output, AtomicInteger counter, TestReportTestComponent tr, String label) throws FHIRFormatError, DefinitionException, FileNotFoundException, FHIRException, IOException {
    JsonObject outputT = new JsonObject();
    if (output != null) {
      output.add(outputT);
    }
    long start = System.currentTimeMillis();
    Parameters profile = loadProfile(loader, test);
    String testName = test.asString("name");
    outputT.add("name", testName);
    if (Utilities.noString(filter) || filter.equals("*") || testName.contains(filter)) {
      log.info("  Testing "+ testName +": ");
      HTTPHeader header = null;
      if (test.has("header")) {
        JsonObject hdr = test.getJsonObject("header");
        if (!hdr.has("mode") || modes.contains(hdr.asString("mode"))) {
          header = new HTTPHeader(hdr.asString("name"), hdr.asString("value"));
        }
      }
      try {
        counter.getAndAdd( 1);
        // If the server caches, get this thread's cache-id for the suite (starting
        // the cache + front-loading setup on first use). When cached, the setup is
        // sent via the cache, not on each request.
        String cid = suiteCacheId(suite.asString("name"), setup);
        List<Resource> effectiveSetup = cid != null ? Collections.emptyList() : setup;
        // Set this thread's client headers for the request: the suite cache-id (if
        // caching this suite) and/or the test's own header. We always set (even to
        // empty), because the thread is reused across tests from the pool - leaving
        // a previous test's cache-id or header in place would leak it to the next
        // request. setClientHeaders replaces the whole set. (Per-thread - no race.)
        List<HTTPHeader> hdrs = new ArrayList<>();
        if (cid != null) {
          hdrs.add(new HTTPHeader(TerminologyClientContext.CACHE_ID_HEADER, cid));
        }
        if (header != null) {
          hdrs.add(header);
        }
        client().setClientHeaders(new ClientHeaders(hdrs));
        conversionLogger.suiteName.set(suite.asString("name"));
        conversionLogger.testName.set(testName);
        String reqFile = chooseParam(test, "request", modes);
        Resource req = reqFile == null ? null : loader.loadResource(reqFile);
        // A test can ask for a particular display validation mode rather than
        // carrying the parameter in its request file, so the same request can be
        // run both ways (see snomed-inactive-display-lenient / -notlenient).
        // The parameter only means anything to the two $validate-code operations.
        if (test.has("lenient-display") && req instanceof Parameters
            && Utilities.existsInList(test.asString("operation"), "validate-code", "cs-validate-code")) {
          ((Parameters) req).addParameter("lenient-display-validation", test.asBoolean("lenient-display"));
        }

        String fn = chooseParam(test, "response", modes);
        String resp = FileUtilities.bytesToString(loader.loadContent(fn));
        String base = label == null ? outputRoot() : Utilities.path(outputRoot(), label);
        String expFn = Utilities.path(base, "expected", fn);
        String actFn = Utilities.path(base, "actual", fn);
        File fo = ManagedFileAccess.file(expFn);
        if (fo.exists()) {
          fo.delete();
        }
        fo = ManagedFileAccess.file(actFn);
        if (fo.exists()) {
          fo.delete();
        }
        fo = ManagedFileAccess.file(Utilities.path(base, "comparison", fn));
        if (fo.exists()) {
          fo.delete();
        }
        currentOutput.set(new String[] { base, fn });

        JsonObject ext = externals == null ? null : externals.getJsonObject(fn);

        nextRequestId.set("txTests:"+suite.asString("name")+"/"+test.asString("name"));
        String lang = test.asString("Accept-Language");
        String msg = null;
        if (test.asString("operation").equals("metadata")) {
          msg = metadata(test.str("name"), effectiveSetup, resp, expFn, actFn, lang, profile, ext, modes);
        } else if (test.asString("operation").equals("term-caps")) {
          msg = termcaps(test.str("name"), effectiveSetup, resp, expFn, actFn, lang, profile, ext, modes);
        } else if (test.asString("operation").equals("expand")) {
          msg = expand(test.str("name"), effectiveSetup, (Parameters) req, resp, expFn, actFn, lang, profile, ext, getResponseCode(test), modes);
        } else if (test.asString("operation").equals("validate-code")) {
          msg = validate(test.str("name"), effectiveSetup, (Parameters) req, resp, expFn, actFn, lang, profile, ext, getResponseCode(test), modes);
        } else if (test.asString("operation").equals("cs-validate-code")) {
          msg = validateCS(test.str("name"), effectiveSetup, (Parameters) req, resp, expFn, actFn, lang, profile, ext, getResponseCode(test), modes);
        } else if (test.asString("operation").equals("lookup")) {
          msg = lookup(test.str("name"), effectiveSetup, (Parameters) req, resp, expFn, actFn, lang, profile, ext, getResponseCode(test), modes);
        } else if (test.asString("operation").equals("translate")) {
          msg = translate(test.str("name"), effectiveSetup, (Parameters) req, resp, expFn, actFn, lang, profile, ext, getResponseCode(test), modes);
        } else if (test.asString("operation").equals("batch")) {
          msg = batch(test.str("name"), effectiveSetup, (Bundle) req, resp, expFn, actFn, lang, profile, ext, getResponseCode(test), modes);
        } else if (test.asString("operation").equals("batch-validate")) {
          msg = batchValidate(test.str("name"), effectiveSetup, (Parameters) req, resp, expFn, actFn, lang, profile, ext, getResponseCode(test), modes);
        } else if (test.asString("operation").equals("compare")) {
          msg = compare(test.str("name"), effectiveSetup, (Parameters) req, resp, expFn, actFn, lang, profile, ext, getResponseCode(test), modes);
        } else if (test.asString("operation").equals("subsumes")) {
          msg = subsumes(test.str("name"), effectiveSetup, (Parameters) req, resp, expFn, actFn, lang, profile, ext, getResponseCode(test), modes);
        } else if (test.asString("operation").equals("closure")) {
          msg = closure(test.str("name"), effectiveSetup, (Parameters) req, resp, expFn, actFn, lang, profile, ext, getResponseCode(test), modes);
        } else {
          throw new Exception("Unknown Operation "+test.asString("operation"));
        }

        log.info("   -- "+ testName +": " + (msg == null ? "Pass" : "Fail") + " ("+Utilities.describeDuration(System.currentTimeMillis() - start)+")");
        if (msg != null) {
          log.error("    "+msg);
          fails.add(suite.asString("name")+"/"+ testName);
        }
        outputT.add("status", msg == null ? "pass" : "fail");
        if (msg != null) {
          outputT.add("message", msg);
        }
        recordResult(tr, msg == null ? TestReportActionResultValueSet.PASS : TestReportActionResultValueSet.FAIL, msg, start);
        return msg == null ? new ResultInformation(true) : new ResultInformation(msg);
      } catch (Exception e) {
        log.error("  Tested "+ testName +": "+ "  ... Exception: "+e.getMessage());

        fails.add(suite.asString("name")+"/"+ testName);
        log.error(e.getMessage(), e);
        recordResult(tr, TestReportActionResultValueSet.ERROR, e.getMessage(), start);
        return new ResultInformation(e.getMessage());
      } finally {
        currentOutput.remove();
        // Reset headers on this thread's client so the next test run on the
        // same worker starts with a clean slate. This only matters if this
        // test set any; a plain client has no headers to clear.
        if (header != null) {
          try {
            client().setClientHeaders(new ClientHeaders());
          } catch (Exception ignored) {
            // Nothing useful we can do if a header-reset fails at this point.
          }
        }
      }
    } else {
      outputT.add("status", "ignored");
      tr.setResult(TestReportActionResultValueSet.SKIP);
      tr.getActionFirstRep().getOperation().setResult(TestReportActionResultValueSet.SKIP);
      return new ResultInformation(true);
    }
  }

  private String metadata(String id, List<Resource> setup, String resp, String expFn, String actFn, String lang, Parameters profile, JsonObject ext, Set<String> modes) throws IOException, URISyntaxException {
    CapabilityStatement cs = capabilityStatement.copy(Base.COPY_NOTHING);
    TxTesterScrubbers.scrubCapStmt(cs, tight);
    TxTesterSorters.sortCapStmt(cs);
    String csj = new org.hl7.fhir.model.core.formats.JsonParser(context).setOutputStyle(OutputStyle.PRETTY).composeString(cs);

    CompareUtilities c = new CompareUtilities(modes, ext, vars()).setCollectAll(true);
    String diff = c.setPatternMode(true).checkJsonSrcIsSame(id, resp, csj, false);
    warnings.addAll(c.getWarnings());
    writeTestOutput(expFn, resp, actFn, csj, modes, diff != null);
    return diff;
  }

  private String termcaps(String id, List<Resource> setup, String resp, String expFn, String actFn, String lang, Parameters profile, JsonObject ext, Set<String> modes) throws IOException, URISyntaxException {
    TerminologyCapabilities cs = terminologyCapabilities.copy(Base.COPY_NOTHING);
    TxTesterScrubbers.scrubTermCaps(cs, tight);
    TxTesterSorters.sortTermCaps(cs);
    String csj = new org.hl7.fhir.model.core.formats.JsonParser(context).setOutputStyle(OutputStyle.PRETTY).composeString(cs);
    CompareUtilities c = new CompareUtilities(modes, ext, vars()).setCollectAll(true);
    String diff = c.setPatternMode(true).checkJsonSrcIsSame(id, resp, csj, false);
    warnings.addAll(c.getWarnings());
    writeTestOutput(expFn, resp, actFn, csj, modes, diff != null);
    return diff;
  }

  private String getResponseCode(JsonObject test) {
    if (test.has("http-code")) {
      return test.asString("http-code");
    } else {
      return "2xx";
    }
  }

  private String chooseParam(JsonObject test, String name, Set<String> modes) {
    for (String mode : modes) {
      if (test.has(name+":"+mode)) {
        return test.asString(name+":"+mode);
      }
    }
    return test.asString(name);
  }

  private Parameters loadProfile(ITxTesterLoader loader, JsonObject test) throws FHIRFormatError, DefinitionException, FileNotFoundException, FHIRException, IOException {
    if (test.has("profile")) {
      return (Parameters) loader.loadResource(test.asString("profile"));
    } else {
      return (Parameters) loader.loadResource("parameters-default.json");
    }
  }

  private String serverId() throws URISyntaxException {
    return new URI(server).getHost();
  }

  @SuppressWarnings("checkstyle:patternUsage")
  //a fixed literal reviewed here; never user input
  private static final Pattern FOLDER_NAME = Pattern.compile("[A-Za-z0-9][A-Za-z0-9._-]*");

  /**
   * Check a folder name given by the caller - the run folder, or a test's label. It has to be
   * usable on every operating system the tests run on, and it must not be able to walk out of
   * the directory it is meant to be in, so it is a name and never a path: letters, digits, '.',
   * '-' and '_', starting with a letter or a digit. That also rules out "..", a leading '.',
   * and any separator. Windows adds two rules of its own - no trailing '.', and none of the
   * names it reserves for devices, even with an extension on the end.
   *
   * @return what is wrong with the name, or null if it is fine
   */
  @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
  //False positive: Matcher.matches() on pattern which has been independently reviewed
  public static String checkFolderName(String name) {
    if (Utilities.noString(name)) {
      return "No name provided";
    }
    if (name.length() > 64) {
      return "The name '" + name + "' is longer than 64 characters";
    }
    if (!FOLDER_NAME.matcher(name).matches()) {
      return "The name '" + name + "' is not a simple name: it may contain only letters, digits, "
          + "'.', '-' and '_', and must start with a letter or a digit. It is a folder name, not a path";
    }
    if (name.endsWith(".")) {
      return "The name '" + name + "' ends with '.', which Windows does not allow in a folder name";
    }
    String base = name.contains(".") ? name.substring(0, name.indexOf('.')) : name;
    return null;
  }

  /**
   * Name the folder this run writes into, under the temp directory, instead of taking the name
   * from the server. One server run several ways - R4 and R5, cached and not - is still one
   * server, so a folder named after it has every variant writing over the last one, and the
   * diffs you go looking for are from whichever variant happened to finish last.
   */
  public void setFolderName(String folderName) {
    String err = checkFolderName(folderName);
    if (err != null) {
      throw new FHIRException("Invalid output folder name: " + err);
    }
    this.folderName = folderName;
  }

  public String getFolderName() {
    return folderName;
  }

  /** The folder this run writes into: the caller's name for it, or the server's host. */
  private String outputFolder() throws URISyntaxException {
    return folderName == null ? serverId() : folderName;
  }

  /** Where this run's output goes: an explicit output directory, else the temp folder. */
  private String outputRoot() throws URISyntaxException, IOException {
    return outputDir == null ? Utilities.path("[tmp]", outputFolder()) : outputDir;
  }

  private String lookup(String id, List<Resource> setup, Parameters p, String resp, String expFn, String actFn, String lang, Parameters profile, JsonObject ext, String tcode, Set<String> modes) throws IOException, URISyntaxException {
    for (Resource r : setup) {
      p.addParameter().setName("tx-resource").setResource(r);
    }
    client().setAcceptLanguage(lang);
    p.getParameterList().addAll(profile.getParameterList());
    int code = 0;
    String pj;
    try {
      Parameters po = client().lookupCode(p);
      TxTesterScrubbers.scrubParameters(po, tight);
      TxTesterSorters.sortParameters(po);
      pj = new org.hl7.fhir.model.core.formats.JsonParser(context).setOutputStyle(OutputStyle.PRETTY).composeString(po);
      code = 200;
    } catch (EFhirClientException e) {
      code = e.getCode();
      OperationOutcome oo = e.getServerErrors().get(0);
      TxTesterScrubbers.scrubOperationOutcome(oo, tight);
      pj = new org.hl7.fhir.model.core.formats.JsonParser(context).setOutputStyle(OutputStyle.PRETTY).composeString(oo);
    }
    CompareUtilities c = new CompareUtilities(modes, ext, vars()).setCollectAll(true);
    String diff = c.checkJsonSrcIsSame(id, resp, pj, false);
    warnings.addAll(c.getWarnings());
    writeTestOutput(expFn, resp, actFn, pj, modes, diff != null);
    if (tcode != null && !httpCodeOk(tcode, code)) {
      return "Response Code fail: should be '"+tcode+"' but is '"+code+"'";
    }
    return diff;
  }

  private String subsumes(String id, List<Resource> setup, Parameters p, String resp, String expFn, String actFn, String lang, Parameters profile, JsonObject ext, String tcode, Set<String> modes) throws IOException, URISyntaxException {
    for (Resource r : setup) {
      p.addParameter().setName("tx-resource").setResource(r);
    }
    client().setAcceptLanguage(lang);
    p.getParameterList().addAll(profile.getParameterList());
    int code = 0;
    String pj;
    try {
      Parameters po = client().subsumes(p);
      TxTesterScrubbers.scrubParameters(po, tight);
      TxTesterSorters.sortParameters(po);
      pj = new org.hl7.fhir.model.core.formats.JsonParser(context).setOutputStyle(OutputStyle.PRETTY).composeString(po);
      code = 200;
    } catch (EFhirClientException e) {
      code = e.getCode();
      OperationOutcome oo = e.getServerErrors().get(0);
      TxTesterScrubbers.scrubOperationOutcome(oo, tight);
      pj = new org.hl7.fhir.model.core.formats.JsonParser(context).setOutputStyle(OutputStyle.PRETTY).composeString(oo);
    }
    CompareUtilities c = new CompareUtilities(modes, ext, vars()).setCollectAll(true);
    String diff = c.checkJsonSrcIsSame(id, resp, pj, false);
    warnings.addAll(c.getWarnings());
    writeTestOutput(expFn, resp, actFn, pj, modes, diff != null);
    if (tcode != null && !httpCodeOk(tcode, code)) {
      return "Response Code fail: should be '"+tcode+"' but is '"+code+"'";
    }
    return diff;
  }

  /**
   * $closure. The response is a ConceptMap rather than a Parameters. Closure tests are
   * stateful - each builds on the table the previous one left - so their suite is marked
   * "sequential" and the runners run it in order on one thread, after everything else.
   */
  /** The closure table this run uses. */
  String closureTableName() {
    return closureTableName;
  }

  /**
   * Point a $closure request at this run's own closure table: replace the table name it carries
   * with the run's name. See closureTableName.
   */
  static void useRunClosureTable(Parameters p, String tableName) {
    for (Parameters.ParametersParameterComponent pp : p.getParameterList()) {
      if ("name".equals(pp.getName()) && pp.hasValue()) {
        pp.setValue(new StringType(tableName));
      }
    }
  }

  private String closure(String id, List<Resource> setup, Parameters p, String resp, String expFn, String actFn, String lang, Parameters profile, JsonObject ext, String tcode, Set<String> modes) throws IOException, URISyntaxException {
    useRunClosureTable(p, closureTableName);
    for (Resource r : setup) {
      p.addParameter().setName("tx-resource").setResource(r);
    }
    client().setAcceptLanguage(lang);
    p.getParameterList().addAll(profile.getParameterList());
    int code = 0;
    String pj;
    try {
      ConceptMap cm = client().closure(p);
      cm.setText(null);
      TxTesterSorters.sortConceptMap(cm);
      pj = new org.hl7.fhir.model.core.formats.JsonParser(context).setOutputStyle(OutputStyle.PRETTY).composeString(cm);
      code = 200;
    } catch (EFhirClientException e) {
      code = e.getCode();
      OperationOutcome oo = e.getServerErrors().get(0);
      if (oo == null) {
        throw e;
      }
      TxTesterScrubbers.scrubOperationOutcome(oo, tight);
      oo.setText(null);
      pj = new org.hl7.fhir.model.core.formats.JsonParser(context).setOutputStyle(OutputStyle.PRETTY).composeString(oo);
    }
    CompareUtilities c = new CompareUtilities(modes, ext, vars()).setCollectAll(true);
    String diff = c.checkJsonSrcIsSame(id, resp, pj, false);
    warnings.addAll(c.getWarnings());
    writeTestOutput(expFn, resp, actFn, pj, modes, diff != null);
    if (tcode != null && !httpCodeOk(tcode, code)) {
      return "Response Code fail: should be '"+tcode+"' but is '"+code+"'";
    }
    return diff;
  }

  private String translate(String id, List<Resource> setup, Parameters p, String resp, String expFn, String actFn, String lang, Parameters profile, JsonObject ext, String tcode, Set<String> modes) throws IOException, URISyntaxException {
    for (Resource r : setup) {
      p.addParameter().setName("tx-resource").setResource(r);
    }
    client().setAcceptLanguage(lang);
    p.getParameterList().addAll(profile.getParameterList());
    int code = 0;
    String pj;
    try {
      Parameters po = client().translate(p);
      TxTesterScrubbers.scrubParameters(po, tight);
      TxTesterSorters.sortParameters(po);
      pj = new org.hl7.fhir.model.core.formats.JsonParser(context).setOutputStyle(OutputStyle.PRETTY).composeString(po);
      code = 200;
    } catch (EFhirClientException e) {
      code = e.getCode();
      OperationOutcome oo = e.getServerErrors().get(0);
      TxTesterScrubbers.scrubOperationOutcome(oo, tight);
      pj = new org.hl7.fhir.model.core.formats.JsonParser(context).setOutputStyle(OutputStyle.PRETTY).composeString(oo);
    }
    CompareUtilities c = new CompareUtilities(modes, ext, vars()).setCollectAll(true);
    String diff = c.checkJsonSrcIsSame(id, resp, pj, false);
    warnings.addAll(c.getWarnings());
    writeTestOutput(expFn, resp, actFn, pj, modes, diff != null);
    if (tcode != null && !httpCodeOk(tcode, code)) {
      return "Response Code fail: should be '"+tcode+"' but is '"+code+"'";
    }
    return diff;
  }

  private String expand(String id, List<Resource> setup, Parameters p, String resp, String expFn, String actFn, String lang, Parameters profile, JsonObject ext, String tcode, Set<String> modes) throws IOException, URISyntaxException {
    for (Resource r : setup) {
      p.addParameter().setName("tx-resource").setResource(r);
    }
    for (var pp : p.getParameterList()) {
      if (pp.getName().equals("url") && !pp.hasValueUriType()) {
        throw new Error("Wrong param type");
      }
    }
    client().setAcceptLanguage(lang);
    p.getParameterList().addAll(profile.getParameterList());
    int code = 0;
    String vsj;
    try {
      ValueSet vs = client().expandValueset(null, p);
      TxTesterScrubbers.scrubValueSet(vs, tight);
      TxTesterSorters.sortValueSet(vs);
      vsj = new org.hl7.fhir.model.core.formats.JsonParser(context).setOutputStyle(OutputStyle.PRETTY).composeString(vs);
      code = 200;
    } catch (EFhirClientException e) {
      code = e.getCode();
      OperationOutcome oo = e.getServerErrors().get(0);
      if (oo != null) {
        TxTesterScrubbers.scrubOperationOutcome(oo, tight);
        vsj = new org.hl7.fhir.model.core.formats.JsonParser(context).setOutputStyle(OutputStyle.PRETTY).composeString(oo);
      } else {
        throw e;
      }
    }
    CompareUtilities c = new CompareUtilities(modes, ext, vars()).setCollectAll(true);
    String diff = c.checkJsonSrcIsSame(id, resp, vsj, false);
    warnings.addAll(c.getWarnings());
    writeTestOutput(expFn, resp, actFn, vsj, modes, diff != null);
    if (tcode != null && !httpCodeOk(tcode, code)) {
      return "Response Code fail: should be '"+tcode+"' but is '"+code+"'";
    }
    return diff;
  }

  private boolean httpCodeOk(String tcode, int code) {
    switch (tcode) {
      case "2xx" : return code >= 200 && code < 300;
      case "3xx" : return code >= 300 && code < 400;
      case "4xx" : return code >= 400 && code < 500;
      case "5xx" : return code >= 500 && code < 600;
      default:
        throw new Error("unknown code string "+tcode);
    }
  }

  private String batchValidate(String id, List<Resource> setup, Parameters p, String resp, String expFn, String actFn, String lang, Parameters profile, JsonObject ext, String tcode, Set<String> modes) throws IOException, URISyntaxException {
    for (Resource r : setup) {
      p.addParameter().setName("tx-resource").setResource(r);
    }
    p.getParameterList().addAll(profile.getParameterList());
    client().setAcceptLanguage(lang);
    int code = 0;
    String pj;
    try {
      Parameters po = client().batchValidateVS(p);
      TxTesterScrubbers.scrubParameters(po, tight);
      TxTesterSorters.sortParameters(po);
      pj = new org.hl7.fhir.model.core.formats.JsonParser(context).setOutputStyle(OutputStyle.PRETTY).composeString(po);
      code = 200;
    } catch (EFhirClientException e) {
      code = e.getCode();
      OperationOutcome oo = e.getServerErrors().get(0);
      TxTesterScrubbers.scrubOperationOutcome(oo, tight);
      oo.setText(null);
      pj = new org.hl7.fhir.model.core.formats.JsonParser(context).setOutputStyle(OutputStyle.PRETTY).composeString(oo);
    }
    CompareUtilities c = new CompareUtilities(modes, ext, vars()).setCollectAll(true);
    String diff = c.checkJsonSrcIsSame(id, resp, pj, false);
    warnings.addAll(c.getWarnings());
    writeTestOutput(expFn, resp, actFn, pj, modes, diff != null);
    if (tcode != null && !httpCodeOk(tcode, code)) {
      return "Response Code fail: should be '"+tcode+"' but is '"+code+"'";
    }
    return diff;
  }

  private String validate(String id, List<Resource> setup, Parameters p, String resp, String expFn, String actFn, String lang, Parameters profile, JsonObject ext, String tcode, Set<String> modes) throws IOException, URISyntaxException {
    for (Resource r : setup) {
      p.addParameter().setName("tx-resource").setResource(r);
    }
    p.getParameterList().addAll(profile.getParameterList());
    client().setAcceptLanguage(lang);
    int code = 0;
    String pj;
    try {
      Parameters po = client().validateVS(p);
      TxTesterScrubbers.scrubParameters(po, tight);
      TxTesterSorters.sortParameters(po);
      pj = new org.hl7.fhir.model.core.formats.JsonParser(context).setOutputStyle(OutputStyle.PRETTY).composeString(po);
      code = 200;
    } catch (EFhirClientException e) {
      code = e.getCode();
      OperationOutcome oo = e.getServerErrors().get(0);
      if (oo != null) {
        TxTesterScrubbers.scrubOperationOutcome(oo, tight);
        oo.setText(null);
        pj = new org.hl7.fhir.model.core.formats.JsonParser(context).setOutputStyle(OutputStyle.PRETTY).composeString(oo);
      } else {
        throw e;
      }
    }
    CompareUtilities c = new CompareUtilities(modes, ext, vars()).setCollectAll(true);
    String diff = c.checkJsonSrcIsSame(id, resp, pj, false);
    warnings.addAll(c.getWarnings());
    writeTestOutput(expFn, resp, actFn, pj, modes, diff != null);
    if (tcode != null && !httpCodeOk(tcode, code)) {
      return "Response Code fail: should be '"+tcode+"' but is '"+code+"'";
    }
    if (pj != null) {
      try {
        Parameters pp = (Parameters) new org.hl7.fhir.model.core.formats.JsonParser(context).parse(pj);
        boolean hasVersion = false;
        boolean hasSystem = false;
        for (Parameters.ParametersParameterComponent ppp : pp.getParameterList()) {
          hasVersion = hasVersion || "version".equals(ppp.getName());
          hasSystem = hasSystem || "system".equals(ppp.getName());
        }
        if (hasVersion != hasSystem) {
          throw new FHIRException("Error in response: has a system != has a version");
        }
      } catch (Exception e) {
        // nothing
      }
    }
    return diff;
  }

  private String validateCS(String id, List<Resource> setup, Parameters p, String resp, String expFn, String actFn, String lang, Parameters profile, JsonObject ext, String tcode, Set<String> modes) throws IOException, URISyntaxException {
    for (Resource r : setup) {
      p.addParameter().setName("tx-resource").setResource(r);
    }
    p.getParameterList().addAll(profile.getParameterList());
    client().setAcceptLanguage(lang);
    int code = 0;
    String pj;
    try {
      Parameters po = client().validateCS(p);
      TxTesterScrubbers.scrubParameters(po, tight);
      TxTesterSorters.sortParameters(po);
      pj = new org.hl7.fhir.model.core.formats.JsonParser(context).setOutputStyle(OutputStyle.PRETTY).composeString(po);
      code = 200;
    } catch (EFhirClientException e) {
      code = e.getCode();
      OperationOutcome oo = e.getServerErrors().get(0);
      oo.setText(null);
      pj = new org.hl7.fhir.model.core.formats.JsonParser(context).setOutputStyle(OutputStyle.PRETTY).composeString(oo);
    }
    CompareUtilities c = new CompareUtilities(modes, ext, vars()).setCollectAll(true);
    String diff = c.checkJsonSrcIsSame(id, resp, pj, false);
    warnings.addAll(c.getWarnings());
    writeTestOutput(expFn, resp, actFn, pj, modes, diff != null);
    if (tcode != null && !httpCodeOk(tcode, code)) {
      return "Response Code fail: should be '"+tcode+"' but is '"+code+"'";
    }
    return diff;
  }

  private String compare(String id, List<Resource> setup, Parameters p, String resp, String expFn, String actFn, String lang, Parameters profile, JsonObject ext, String tcode, Set<String> modes) throws IOException, URISyntaxException {
    for (Resource r : setup) {
      p.addParameter().setName("tx-resource").setResource(r);
    }
    p.getParameterList().addAll(profile.getParameterList());
    client().setAcceptLanguage(lang);
    int code = 0;
    String pj;
    try {
      Parameters po = client().doCompare(p);
      TxTesterScrubbers.scrubParameters(po, tight);
      TxTesterSorters.sortParameters(po);
      pj = new org.hl7.fhir.model.core.formats.JsonParser(context).setOutputStyle(OutputStyle.PRETTY).composeString(po);
      code = 200;
    } catch (EFhirClientException e) {
      code = e.getCode();
      OperationOutcome oo = e.getServerErrors().get(0);
      if (oo != null) {
        TxTesterScrubbers.scrubOperationOutcome(oo, tight);
        oo.setText(null);
        pj = new org.hl7.fhir.model.core.formats.JsonParser(context).setOutputStyle(OutputStyle.PRETTY).composeString(oo);
      } else {
        throw e;
      }
    }
    CompareUtilities c = new CompareUtilities(modes, ext, vars()).setCollectAll(true);
    String diff = c.checkJsonSrcIsSame(id, resp, pj, false);
    warnings.addAll(c.getWarnings());
    writeTestOutput(expFn, resp, actFn, pj, modes, diff != null);
    if (tcode != null && !httpCodeOk(tcode, code)) {
      return "Response Code fail: should be '"+tcode+"' but is '"+code+"'";
    }
    return diff;
  }

  private String batch(String id, List<Resource> setup, Bundle bnd, String resp, String expFn, String actFn, String lang, Parameters profile, JsonObject ext, String tcode, Set<String> modes) throws IOException, URISyntaxException {
    for (Resource r : setup) {
      Parameters p = (Parameters) bnd.getEntryFirstRep().getResource();
      p.addParameter().setName("tx-resource").setResource(r);
    }
    client().setAcceptLanguage(lang);
    for (BundleEntryComponent be : bnd.getEntryList()) {
      ((Parameters) be.getResource()).getParameterList().addAll(profile.getParameterList());
    }
    int code = 0;
    String bj;
    try {
      Bundle bo = client().batch(bnd);
      for (BundleEntryComponent be : bo.getEntryList()) {
        if (be.getResource() instanceof Parameters) {
          Parameters po = ((Parameters) be.getResource());
          TxTesterScrubbers.scrubParameters(po, tight);
          TxTesterSorters.sortParameters(po);
        }
        if (be.getResource() instanceof OperationOutcome) {
          OperationOutcome oo = ((OperationOutcome) be.getResource());
          TxTesterScrubbers.scrubOperationOutcome(oo, tight);
        }
      }
      bj = new org.hl7.fhir.model.core.formats.JsonParser(context).setOutputStyle(OutputStyle.PRETTY).composeString(bo);
      code = 200;
    } catch (EFhirClientException e) {
      code = e.getCode();
      OperationOutcome oo = e.getServerErrors().get(0);
      TxTesterScrubbers.scrubOperationOutcome(oo, tight);
      bj = new org.hl7.fhir.model.core.formats.JsonParser(context).setOutputStyle(OutputStyle.PRETTY).composeString(oo);
    }
    CompareUtilities c = new CompareUtilities(modes, ext, vars()).setCollectAll(true);
    String diff = c.checkJsonSrcIsSame(id, resp, bj, false);
    warnings.addAll(c.getWarnings());
    writeTestOutput(expFn, resp, actFn, bj, modes, diff != null);
    if (tcode != null && !httpCodeOk(tcode, code)) {
      return "Response Code fail: should be '"+tcode+"' but is '"+code+"'";
    }
    return diff;
  }


  // where the test running on this thread writes its output: { base folder, response file name }
  private final ThreadLocal<String[]> currentOutput = new ThreadLocal<>();
  // the comparison copy of the externals file, by base folder
  private final Map<String, JsonObject> comparisonMessages = new HashMap<>();
  // the name of the externals file, which its comparison copy is given so that it can be compared
  // with the original; the tx-ecosystem default when the caller doesn't say
  private String externalsName = "messages-tx.fhir.org.json";

  public TxTester setExternalsName(String name) {
    if (name != null) {
      String n = name.replace('\\', '/');
      this.externalsName = n.substring(n.lastIndexOf('/') + 1);
    }
    return this;
  }

  // TEMPORARY: write the comparison for every test, passed or not. Set to false to only write it
  // for failed tests, alongside the expected and actual files
  private static final boolean COMPARISON_FOR_ALL_TESTS = true;

  /**
   * When a test fails, write the expected and actual responses, and the comparison form of the
   * actual response - the actual response with what the expected response only matches by
   * pattern ($external$, $uuid$, $instant$...) put back as those patterns, so that a diff of
   * expected against comparison only shows what matters. The server's wording of the $external$
   * messages goes into comparison/{externals file name}, a copy of the externals file (if there is
   * one) with this test's messages set to what the server said.
   */
  private void writeTestOutput(String expFn, String expected, String actFn, String actual, Set<String> modes, boolean failed) throws IOException {
    if (failed) {
      FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(expFn));
      FileUtilities.stringToFile(expected, expFn);
      FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(actFn));
      FileUtilities.stringToFile(actual, actFn);
    } else if (!COMPARISON_FOR_ALL_TESTS) {
      return;
    }

    String[] output = currentOutput.get();
    if (output == null) {
      return;
    }
    try {
      TxTesterComparison comparison = new TxTesterComparison(modes, vars());
      org.hl7.fhir.utilities.json.model.JsonElement normalised = comparison.normalise(JsonParser.parse(expected), JsonParser.parse(actual));
      String cmpFn = Utilities.path(output[0], "comparison", output[1]);
      FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(cmpFn));
      FileUtilities.stringToFile(JsonParser.compose(normalised, true), cmpFn);
      if (!comparison.getMessages().isEmpty()) {
        recordComparisonMessages(output[0], output[1], comparison.getMessages());
      }
    } catch (Exception e) {
      // the comparison is only a convenience; the expected and actual files are written
      log.warn("Unable to write the comparison for " + output[1] + ": " + e.getMessage());
    }
  }

  private synchronized void recordComparisonMessages(String base, String fn, Map<String, String> messages) throws IOException {
    JsonObject all = comparisonMessages.computeIfAbsent(base, b -> externals == null ? new JsonObject() : externals.deepCopy());
    JsonObject entry = all.forceObject(fn);
    for (Map.Entry<String, String> m : messages.entrySet()) {
      entry.set(m.getKey(), m.getValue());
    }
    String fn2 = Utilities.path(base, "comparison", externalsName);
    FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(fn2));
    FileUtilities.stringToFile(JsonParser.compose(all, true), fn2);
  }

  private Map<String, String> vars() throws URISyntaxException, IOException {
    Map<String, String> vars = new HashMap<String, String>();
    vars.put("version", client().getActualVersion().toCode());
    return vars;

  }

  private List<Resource> loadSetupResources(ITxTesterLoader loader, JsonObject suite) throws FHIRFormatError, FileNotFoundException, IOException {
    List<Resource> res = new ArrayList<>();
    for (String s : suite.getStrings("setup")) {
      res.add(loader.loadResource(s));
    }
    return res;
  }

  /**
   * @return true if the server's CapabilityStatement advertises the system-level
   * $cache-control operation.
   */
  private boolean serverSupportsCacheControl() {
    if (capabilityStatement == null) {
      return false;
    }
    for (CapabilityStatement.CapabilityStatementRestComponent rest : capabilityStatement.getRestList()) {
      for (CapabilityStatement.CapabilityStatementRestResourceOperationComponent op : rest.getOperationList()) {
        if ("cache-control".equals(op.getName())) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Return the cache-id this thread holds for the given suite, lazily starting a
   * cache and front-loading the suite's setup into it on first use. Returns null
   * if caching isn't available (server doesn't support it, no setup, or start
   * failed) - the caller then inlines the setup as before. The per-thread map is
   * keyed by suite name; tests of a suite may be spread across threads, so each
   * thread independently caches the suites it runs.
   */
  private String suiteCacheId(String suiteName, List<Resource> setup) {
    if (setup.isEmpty() || !serverSupportsCacheControl()) {
      return null;
    }
    Map<String, String> caches = suiteCaches.get();
    if (caches.containsKey(suiteName)) {
      // present even when the value is null: a prior start failed, so don't retry
      // (and re-warn) on every subsequent test for this suite on this thread.
      return caches.get(suiteName);
    }
    String cacheId = startSuiteCache(setup);
    caches.put(suiteName, cacheId);
    return cacheId;
  }

  /**
   * Start a server cache and front-load the setup resources into it, so requests
   * can refer to them by the cache-id (carried as the X-Cache-Id header) rather
   * than re-sending them. Returns the server-issued cache-id, or null on failure.
   */
  private String startSuiteCache(List<Resource> setup) {
    try {
      Parameters p = new Parameters();
      for (Resource r : setup) {
        p.addParameter().setName("tx-resource").setResource(r);
      }
      Parameters resp = client().cacheControl(ITerminologyClientN.CacheControlMode.START_CACHE, p);
      if (resp != null && resp.hasParameter("cache-id")) {
        return resp.getParameterValue("cache-id").primitiveValue();
      }
      log.warn("Server advertised $cache-control but returned no cache-id; not caching this suite");
      return null;
    } catch (Exception e) {
      log.warn("Unable to start a terminology cache (" + e.getMessage() + "); not caching this suite");
      return null;
    }
  }

  /**
   * Release this thread's cache for the named suite, if any (best-effort; the
   * server times caches out anyway). Used by the sequential path which has a
   * suite-end signal; the concurrent per-test path relies on the timeout.
   */
  private void endSuiteCache(String suiteName) {
    String cacheId = suiteCaches.get().remove(suiteName);
    if (cacheId == null) {
      return;
    }
    try {
      client().setClientHeaders(new ClientHeaders(List.of(new HTTPHeader(TerminologyClientContext.CACHE_ID_HEADER, cacheId))));
      client().cacheControl(ITerminologyClientN.CacheControlMode.END_CACHE, null);
      client().setClientHeaders(new ClientHeaders());
    } catch (Exception e) {
      // best effort
    }
  }

  public String getOutput() {
    return outputDir;
  }

  public TxTester setOutput(String output) {
    this.outputDir = output;
    return this;
  }

  public static class InternalTxLoader implements ITxTesterLoader {

    private TxTestData txtests;
    private boolean additional;
    private IModelContext context;

    public InternalTxLoader(IModelContext context, String version) throws IOException {
      this.context = context;
      File f = ManagedFileAccess.file(version);
      if (f.exists() && f.isDirectory()) {
        txtests = TxTestData.loadTestDataFromFolder(f, "test-cases.json");
      } else {
        load(version);
      }
    }

    private InternalTxLoader(IModelContext context) {
      this.context = context;
    }

    /**
     * Load the test cases from the hl7.fhir.uv.tx-ecosystem package, and only from the package:
     * unlike the constructor, a version that happens to be the name of a local folder is not
     * read from that folder. For callers that take the version from someone else - the
     * validator's server mode - who must not be able to point it at the server's file system.
     */
    public static InternalTxLoader fromPackage(IModelContext context, String version) throws IOException {
      InternalTxLoader loader = new InternalTxLoader(context);
      loader.load(version);
      return loader;
    }

    public InternalTxLoader(String source, boolean additional) throws IOException {
      this.additional = additional;
      File f = ManagedFileAccess.file(source);
      if (f.exists() && f.isDirectory()) {
        txtests = TxTestData.loadTestDataFromFolder(f, "test-cases.json");
      } else if (f.exists()) {
        txtests = TxTestData.loadTestDataFromFolder(ManagedFileAccess.file(FileUtilities.getDirectoryForFile(source)), f.getName());
      } else {
        load(source);
      }
    }

    private void load(String version) throws IOException {
      txtests = TxTestData.loadTestDataFromPackage("hl7.fhir.uv.tx-ecosystem#"+version);
    }

    @Override
    public String describe() {
      return txtests.describe();
    }

    @Override
    public Resource loadResource(String filename) throws IOException, FHIRFormatError, FileNotFoundException, FHIRException, DefinitionException {
      Resource res = new org.hl7.fhir.model.core.formats.JsonParser(context).parse(txtests.load(filename));
//        org.hl7.fhir.r4.model.Resource r4 = VersionConvertorFactory_40_50.convertResource(res);
//        String p = Utilities.path(folder, "r4", filename);
//        Utilities.createDirectory(Utilities.getDirectoryForFile(p));
//        new org.hl7.fhir.r4.formats.JsonParser(context).setOutputStyle(org.hl7.fhir.r4.formats.IParser.OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(p), r4);
//      } catch (Exception e) {
//        // nothing...
//      }
      return res;
    }

    @Override
    public byte[] loadContent(String filename) throws FileNotFoundException, IOException {
      return txtests.loadBytes(filename);
    }

    @Override
    public boolean hasContent(String filename) throws IOException {
      return txtests.hasFile(filename);
    }

    @Override
    public String code() {
      return txtests.code();
    }

    @Override
    public String version() throws JsonException, IOException {
      return txtests.loadVersion();
    }

    @Override
    public String testFileName() {
      return txtests.testFileName();
    }
  }

  public TestReport getTestReport() {
    return testReport;
  }


}