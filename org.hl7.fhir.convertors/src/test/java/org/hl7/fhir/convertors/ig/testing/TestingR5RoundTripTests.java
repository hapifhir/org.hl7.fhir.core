package org.hl7.fhir.convertors.ig.testing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.hl7.fhir.convertors.igs.testing.TestingR5Convertor;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.igs.testing.TestingJsonParser;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.Assumptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Round trip tests for the R5 &lt;-&gt; testing-IG (R6-shaped) converters. Each TestScript and
 * TestReport example in the Testing IG is parsed into the IG (org.hl7.fhir.r5.igs.testing) model,
 * converted to R5 and back again, and the result is required to be deeply equal to the original.
 * <p/>
 * This is the R5 counterpart of {@link TestingR4RoundTripTests}. Unlike the R4 converter, the R5
 * converter shares the R5 datatypes with the IG model, so it copies (rather than converts) elements
 * and needs no {@code ConversionContext40_50}; the calls are plain static invocations.
 * <p/>
 * When a round trip is not deeply equal, the (pretty printed) original and round-tripped resources
 * are written to [tmp]/conversions/expected/&lt;file&gt; and [tmp]/conversions/actual/&lt;file&gt;
 * so the difference can be inspected.
 */
public class TestingR5RoundTripTests {

  private static final String[] PACKAGES = {"hl7.fhir.uv.testing#current"};
  private static final String[] RESOURCE_TYPES = {"TestScript", "TestReport", "TestPlan"};

  // examples that use features with no agreed cross-version mapping are suppressed (reported as
  // skipped, not failed) rather than removed, so the case and the reason stay visible
  private static final Map<String, String> SUPPRESSED = Map.of(
      "TestScript-testscript-example-readcommon.json",
      "uses TestScript.common, introduced in the Testing IG - no agreed migration to/from R5");

  // loading a package - especially a '#current' one, which re-resolves against the ci-build server -
  // is expensive, so each package is loaded once and reused across all the tests
  private static final Map<String, NpmPackage> PACKAGE_CACHE = new HashMap<>();

  private static synchronized NpmPackage getPackage(String pid) throws IOException {
    NpmPackage npm = PACKAGE_CACHE.get(pid);
    if (npm == null) {
      npm = new FilesystemPackageCacheManager.Builder().build().loadPackage(pid);
      PACKAGE_CACHE.put(pid, npm);
    }
    return npm;
  }

  public static Stream<Arguments> data() throws IOException {
    List<Arguments> objects = new ArrayList<>();
    for (String pid : PACKAGES) {
      NpmPackage npm = getPackage(pid);
      for (String fn : npm.list("example")) {
        if (fn.endsWith(".json") && fn.contains("-")) {
          String rt = fn.substring(0, fn.indexOf("-"));
          if (Utilities.existsInList(rt, RESOURCE_TYPES)) {
            objects.add(Arguments.of(pid + "/" + fn, pid, fn));
          }
        }
      }
    }
    return objects.stream();
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("data")
  public void testRoundTrip(String name, String pid, String filename) throws IOException {
    Assumptions.assumeFalse(SUPPRESSED.containsKey(filename), () -> "suppressed: " + SUPPRESSED.get(filename));
    byte[] source = FileUtilities.streamToBytes(getPackage(pid).load("example", filename));

    Resource r1 = new TestingJsonParser(true, true).parse(source);
    Resource r2 = convertToR5AndBack(r1);

    boolean ok = r1.equalsDeep(r2);
    if (!ok) {
      writeDiff(r1, "expected", filename);
      writeDiff(r2, "actual", filename);
    }
    assertTrue(ok, "not deeply equal after IG -> R5 -> IG round trip for " + name
        + " - compare [tmp]/conversions/expected/" + filename + " and [tmp]/conversions/actual/" + filename);
  }

  private Resource convertToR5AndBack(Resource r1) {
    if (r1 instanceof org.hl7.fhir.r5.igs.testing.TestScript) {
      org.hl7.fhir.r5.model.TestScript r5 = TestingR5Convertor.convertTestScript((org.hl7.fhir.r5.igs.testing.TestScript) r1);
      return TestingR5Convertor.convertTestScript(r5);
    } else if (r1 instanceof org.hl7.fhir.r5.igs.testing.TestReport) {
      org.hl7.fhir.r5.model.TestReport r5 = TestingR5Convertor.convertTestReport((org.hl7.fhir.r5.igs.testing.TestReport) r1);
      return TestingR5Convertor.convertTestReport(r5);
    } else if (r1 instanceof org.hl7.fhir.r5.igs.testing.TestPlan) {
      org.hl7.fhir.r5.model.Basic r5 = TestingR5Convertor.convertTestPlan((org.hl7.fhir.r5.igs.testing.TestPlan) r1);
      return TestingR5Convertor.convertTestPlan(r5);
    } else {
      throw new IllegalStateException("Unexpected resource type: " + r1.fhirType());
    }
  }

  private void writeDiff(Resource r, String kind, String filename) throws IOException {
    String dir = Utilities.path("[tmp]", "conversions", kind);
    FileUtilities.createDirectory(dir);
    TestingJsonParser json = new TestingJsonParser(true, true);
    json.setOutputStyle(OutputStyle.PRETTY);
    FileUtilities.stringToFile(json.composeString(r), Utilities.path(dir, filename));
  }
}
