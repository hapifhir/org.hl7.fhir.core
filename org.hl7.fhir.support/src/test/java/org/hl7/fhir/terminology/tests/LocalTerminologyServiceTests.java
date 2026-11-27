package org.hl7.fhir.terminology.tests;

import com.google.common.base.Charsets;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.model.ModelContext;
import org.hl7.fhir.model.core.Resource;
import org.hl7.fhir.model.core.formats.JsonParser;
import org.hl7.fhir.model.core.formats.XmlParser;
import org.hl7.fhir.utilities.VersionUtil;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.http.ManagedWebAccess;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.validation.special.TxTestData;
import org.hl7.fhir.validation.special.TxTester;
import org.hl7.fhir.validation.special.TxTester.ITxTesterLoader;
import org.hl7.fhir.support.tests.utilities.TestUtilities;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@RunWith(Parameterized.class)
@Slf4j
public class LocalTerminologyServiceTests implements ITxTesterLoader { 

  /** every test is registered once for each of these FHIR versions - all the R4 tests, then all the R5 tests */
  private static final String[] VERSIONS = {"4.0.1", "5.0.0"};

  public static class JsonObjectPair {
    public JsonObjectPair(JsonObject suite, JsonObject test) {
      this.suite = suite;
      this.test = test;
    }
    private JsonObject suite;
    private JsonObject test;
  }

//  private static final String SERVER = FhirSettings.getTxFhirLocal();
  private static final String SERVER_BASE = "http://localhost:3001/";

  private static boolean isR5(String version) {
    return version.startsWith("5");
  }

  private static String serverFor(String version) {
    return SERVER_BASE + (isR5(version) ? "r5" : "r4");
  }

  /**
   * The state of the run against one FHIR version - its own tester, and its own counts for the
   * summary at the end of that version's tests
   */
  private static class VersionRun {
    private TxTester tester;
    private int error = 0;
    private int skipped = 0;
    private int count = 0;
    private List<String> failedNames = new ArrayList<>();
  }

  private static final Map<String, VersionRun> runs = new HashMap<>();

  private static VersionRun runFor(String version) {
    return runs.computeIfAbsent(version, v -> new VersionRun());
  }

  private static boolean localTxRunning() throws IOException {
    return ManagedFileAccess.file("/Users/grahame/work/FHIRsmith/data").exists();
  }

  @BeforeClass
  public static void disableSsrfProtection() {
    // these tests run against a local terminology server over http, which the
    // SSRF protection would otherwise refuse to connect to
    ManagedWebAccess.setSsrfProtectionEnabled(false);
  }

  @AfterClass
  public static void enableSsrfProtection() {
    ManagedWebAccess.setSsrfProtectionEnabled(true);
  }

  @Parameters(name = "{index}: id {0}")
  public static Iterable<Object[]> data() throws IOException {
    try {
      txtests = TxTestData.loadTestDataFromFolder(new File("/Users/grahame/igs/tx-ecosystem-ig/tests"), "test-cases.json");
      // txtests = TxTestData.loadTestDataFromPackage("hl7.fhir.uv.tx-ecosystem#dev");

      String contents = txtests.load("test-cases.json");
      externals = org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(txtests.load("messages-tx.fhir.org.json"));
      manifest = org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(contents);
    } catch (Exception e) {
      manifest = null;
    }

    List<Object[]> objects = new ArrayList<Object[]>();
    for (String version : VERSIONS) {
      String prefix = isR5(version) ? "r5" : "r4";
      Map<String, JsonObjectPair> examples = new HashMap<String, JsonObjectPair>();
      // tests from "sequential" suites (e.g. closure, where each test builds on the last) keep
      // manifest order and run after everything else for that version
      List<String> sequentialNames = new ArrayList<>();
      if (manifest != null) {
        for (org.hl7.fhir.utilities.json.model.JsonObject suite : manifest.getJsonObjects("suites")) {
          if (passesVersion(suite, version)) {
            String sn = suite.asString("name");
            for (org.hl7.fhir.utilities.json.model.JsonObject test : suite.getJsonObjects("tests")) {
              if (passesVersion(test, version)) {
                String tn = test.asString("name");
                examples.put(sn + "." + tn, new JsonObjectPair(suite, test));
                if (suite.asBoolean("sequential")) {
                  sequentialNames.add(sn + "." + tn);
                }
              }
            }
          }
        }
      }
      List<String> names = new ArrayList<String>(examples.size());
      names.addAll(examples.keySet());
      names.removeAll(sequentialNames);
      Collections.sort(names);
      names.addAll(sequentialNames);

      for (String id : names) {
        objects.add(new Object[]{prefix + "/" + id, version, examples.get(id)});
      }
      objects.add(new Object[]{prefix + "/final", version, null});
    }
    return objects;
  }

  private static boolean passesVersion(JsonObject test, String version) {
    if (test.has("version")) {
      return TxTester.versionGateMatches(test.asString("version"), version);
    } else {
      return true;
    }
  }

  private static org.hl7.fhir.utilities.json.model.JsonObject manifest;
  private static org.hl7.fhir.utilities.json.model.JsonObject externals;
  private JsonObjectPair setup;
  private String version;
  private Set<String> modes = new HashSet<>();
  private static TxTestData txtests;

  public LocalTerminologyServiceTests(String name, String version, JsonObjectPair setup) {
    this.setup = setup;
    this.version = version;
    modes.add("tx.fhir.org");
    modes.add("omop");
    modes.add("general");
    modes.add("snomed");
    modes.add("mimetypes");
    modes.add("icd-11");
    modes.add("icf");
    modes.add("closure");
    modes.add("loinc");
  }

  @SuppressWarnings("deprecation")
  @Test
  public void test() throws Exception {
    if (false && TestUtilities.runningAsSurefire()) {
      logTestSkip("Running in surefire.");
      return;
    }
    if (!localTxRunning()) {
      logTestSkip("No local terminology server available.");
      return;
    }
    VersionRun run = runFor(version);
    String server = serverFor(version);
    if (setup == null) {
      // logged rather than printed, so the summary and - the useful part - the list of which
      // tests failed end up in the run's test.log alongside the diffs, not only on a console
      // that has since scrolled
      if (run.error == 0) {
        log.info(server+" passed all "+(run.count-run.skipped)+" HL7 terminology service tests (tests v"+loadVersion()+", runner v"+VersionUtil.getBaseVersion()+")");
      } else {
        log.info(server+" failed "+run.error+" of "+(run.count-run.skipped)+" HL7 terminology service tests (tests v"+loadVersion()+", runner v"+VersionUtil.getBaseVersion()+")");
        for (String s : run.failedNames) {
          log.info("   "+s);
        }
      }
      if (run.tester != null && run.tester.getWarnings().size() > 0) {
        int c = countWarnings(run.tester, "version");
        if (c > 0) {
          log.warn("Warning: "+c+" times the server did not return a version from $validate-code when it should have");
        }
      }
      Assertions.assertTrue(run.error == 0);
    } else {
      run.count++;
      if (server != null) {
        if (run.tester == null) {
          run.tester = new TxTester(this, server, true, externals, version);
          // both servers are on localhost, so each version gets its own output folder. R5 keeps
          // the folder the tests have always used
          run.tester.setFolderName(isR5(version) ? "localhost" : "localhost-r4");
        }
        if (setup.suite.asString("name").contains("omop") || true) {
          String err = run.tester.executeTest(this, setup.suite, setup.test, modes);
          if (err != null) {
            if (TxTester.isNotRun(err)) {
              run.skipped++;
              err = null;
            } else {
              run.error++;
              run.failedNames.add(setup.suite.asString("name")+"/"+setup.test.asString("name"));
            }
          }
          Assertions.assertTrue(err == null, err);
        } else {
          Assertions.assertTrue(true);
        }
      } else {
        Assertions.assertTrue(true);
      }
    }
  }

  private int countWarnings(TxTester tester, String version) {
    int i = 0;
    for (String w : tester.getWarnings()) {
      if (w.equals("version")) {
        i++;
      }
    }
    return i;
  }

  private String loadVersion() throws JsonException, IOException {
    return txtests.loadVersion();
  }

  private void logTestSkip(String reason) {
    if (setup != null) {
      log.info("Skipping test: " + setup.suite.asString("name") + " " + setup.test.asString("name") + " reason: " + reason);
    }
  }

  public Resource loadResource(String filename) throws IOException, FHIRFormatError, FileNotFoundException, FHIRException, DefinitionException {
    String contents = txtests.load(filename);
    Resource res = null;
    try (InputStream inputStream = IOUtils.toInputStream(contents, Charsets.UTF_8)) {
      if (filename.contains(".json")) {
        res = new JsonParser(ModelContext.fullCoreContext()).parse(inputStream);
      } else {
        res = new XmlParser(ModelContext.fullCoreContext()).parse(inputStream);
      }
    }
    return res;
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
    return "local";
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