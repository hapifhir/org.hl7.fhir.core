package org.hl7.fhir.terminology.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.io.IOUtils;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_14_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Constants;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.utilities.VersionUtil;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.settings.FhirSettings;
import org.hl7.fhir.validation.special.TxTestData;
import org.hl7.fhir.validation.special.TxTester;
import org.hl7.fhir.validation.special.TxTester.ITxTesterLoader;
import org.hl7.fhir.validation.tests.utilities.TestUtilities;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.model.RunnerScheduler;

import com.google.common.base.Charsets;

@RunWith(ExternalTerminologyServiceTests.ParallelParameterized.class)
public class ExternalTerminologyServiceTests implements ITxTesterLoader {

  private static final int THREAD_COUNT = 16;

  /**
   * Runs the parameterized children concurrently across a fixed-size thread pool
   * so the external run, which is almost entirely network latency, completes in
   * wall-clock time proportional to the slowest batch rather than the sum of all
   * requests. @BeforeClass / @AfterClass still fire serially on the main thread,
   * so the eager TxTester initialisation remains single-threaded.
   */
  public static class ParallelParameterized extends Parameterized {
    public ParallelParameterized(Class<?> klass) throws Throwable {
      super(klass);
      setScheduler(new RunnerScheduler() {
        private final ExecutorService pool = Executors.newFixedThreadPool(THREAD_COUNT, r -> {
          Thread t = new Thread(r, "tx-tester-worker");
          t.setDaemon(true);
          return t;
        });

        @Override
        public void schedule(Runnable child) {
          pool.submit(child);
        }

        @Override
        public void finished() {
          pool.shutdown();
          try {
            pool.awaitTermination(1, TimeUnit.MINUTES);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }
        }
      });
    }
  }

  public static class JsonObjectPair {
    public JsonObjectPair(JsonObject suite, JsonObject test) {
      this.suite = suite;
      this.test = test;
    }
    private JsonObject suite;
    private JsonObject test;
  }

  private static final String SERVER = FhirSettings.getTxFhirDevelopment() + "/r5";


  @Parameters(name = "{index}: id {0}")
  public static Iterable<Object[]> data() throws IOException {

    txtests = TxTestData.loadTestDataFromPackage("hl7.fhir.uv.tx-ecosystem#dev");

    String contents = txtests.load("test-cases.json");
    externals = org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(txtests.load("messages-tx.fhir.org.json"));

    Map<String, JsonObjectPair> examples = new HashMap<String, JsonObjectPair>();
    manifest = org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(contents);
    for (org.hl7.fhir.utilities.json.model.JsonObject suite : manifest.getJsonObjects("suites")) {
      if (!suite.has("version") || suite.asString("version").startsWith("5.0")) {
        String sn = suite.asString("name");
        for (org.hl7.fhir.utilities.json.model.JsonObject test : suite.getJsonObjects("tests")) {
          if (!test.has("version") || test.asString("version").startsWith("5.0")) {
            String tn = test.asString("name");
            examples.put(sn + "." + tn, new JsonObjectPair(suite, test));
          }
        }
      }
    }

    List<String> names = new ArrayList<String>(examples.size());
    names.addAll(examples.keySet());
    Collections.sort(names);

    List<Object[]> objects = new ArrayList<Object[]>(examples.size());
    for (String id : names) {
      objects.add(new Object[]{id, examples.get(id)});
    }
    // The previous "final" sentinel that piggy-backed on the Parameterized run
    // to print the summary has been removed — with parallel execution there is
    // no meaningful "last test", so the summary is emitted from @AfterClass.
    return objects;
  }

  private static org.hl7.fhir.utilities.json.model.JsonObject manifest;
  private static org.hl7.fhir.utilities.json.model.JsonObject externals;
  private JsonObjectPair setup;
  private String version = "5.0.0";
  private static TxTester tester;
  private Set<String> modes = new HashSet<>();
  private static final AtomicInteger error = new AtomicInteger();
  private static final AtomicInteger skipped = new AtomicInteger();
  private static final AtomicInteger count = new AtomicInteger();
  private static TxTestData txtests;

  /**
   * Eagerly constructs the shared TxTester and forces its one-shot network
   * initialisation (connect, capability statement, terminology capabilities)
   * on the main thread before any parameterized test is scheduled. After this
   * returns, TxTester's remaining per-test state is thread-safe for concurrent
   * executeTest calls.
   */
  @BeforeClass
  public static void setUpTester() throws Exception {
    if (SERVER == null) {
      return;
    }
    Set<String> initModes = new HashSet<>();
    initModes.add("tx.fhir.org");
    initModes.add("omop");
    initModes.add("general");
    initModes.add("snomed");
    // Loader only uses the static txtests field, so a throwaway instance is fine.
    tester = new TxTester(new ExternalTerminologyServiceTests("init", null), SERVER, true, externals, "5.0.0");
    tester.initialise(initModes);
  }

  /**
   * Emits the run summary once all parameterized children have finished. Runs
   * on the main thread after the parallel scheduler's pool has drained.
   */
  @AfterClass
  public static void reportSummary() throws Exception {
    int err = error.get();
    int ran = count.get() - skipped.get();
    if (err == 0) {
      System.out.println("tx.fhir.org passed all " + ran
        + " HL7 terminology service tests (mode 'tx.fhir.org', tests v" + txtests.loadVersion()
        + ", runner v" + VersionUtil.getBaseVersion() + ")");
    } else {
      System.out.println("tx.fhir.org failed " + err + " of " + ran
        + " HL7 terminology service tests (mode 'tx.fhir.org', tests v" + txtests.loadVersion()
        + ", runner v" + VersionUtil.getBaseVersion() + ")");
    }
//    Assertions.assertTrue(err == 0);
  }

  public ExternalTerminologyServiceTests(String name, JsonObjectPair setup) {
    this.setup = setup;
    modes.add("tx.fhir.org");
    modes.add("omop");
    modes.add("general");
    modes.add("snomed");
  }

  private void logTestSkip(String reason) {
    if (setup != null) {
      System.out.println("Skipping test: " + setup.suite.asString("name") + " " + setup.test.asString("name") + " reason: " + reason);
    }
  }

  @SuppressWarnings("deprecation")
  @Test
  public void test() throws Exception {
    if (false && TestUtilities.runningAsSurefire()) {
      logTestSkip("Running in surefire.");
      return;
    }

    count.incrementAndGet();
    if (SERVER == null) {
      Assertions.assertTrue(true);
      return;
    }

    if (setup.suite.asBoolean("disabled") || setup.test.asBoolean("disabled")) {
      return;
    }
    String err = tester.executeTest(this, setup.suite, setup.test, modes);
    if (err != null) {
      if ("n/a".equals(err)) {
        skipped.incrementAndGet();
        err = null;
      } else {
        error.incrementAndGet();
      }
    }
    Assertions.assertTrue(err == null, err);
  }

  public Resource loadResource(String filename) throws IOException, FHIRFormatError, FileNotFoundException, FHIRException, DefinitionException {
    String contents = txtests.load(filename);
    try (InputStream inputStream = IOUtils.toInputStream(contents, Charsets.UTF_8)) {
      if (filename.contains(".json")) {
        return new JsonParser().parse(inputStream);
      } else {
        return new XmlParser().parse(inputStream);
      }
    }
  }

  @Override
  public String describe() {
    return "Test cases";
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
    return "external";
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