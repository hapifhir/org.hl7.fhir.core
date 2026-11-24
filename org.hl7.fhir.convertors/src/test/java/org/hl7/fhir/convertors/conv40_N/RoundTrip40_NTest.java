package org.hl7.fhir.convertors.conv40_N;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.ModelContext;
import org.hl7.fhir.model.utilities.formats.OutputStyle;
import org.hl7.fhir.utilities.settings.FhirSettings;
import org.hl7.fhir.utilities.tests.TestConfig;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Round trip tests for R4 <-> R6 conversion, driven by the examples from the two specifications.
 * <p>
 * Layout, under conversion/roundtrip40_N in fhir-test-cases:
 * <pre>
 *   r4/resource/X.json   - an R4 example (the source)
 *   r4/converted/X.json  - what it converts to in R6
 *   r4/returned/X.json   - what that converts back to in R4
 *   r6/resource/X.json   - an R6 example (the source)
 *   r6/converted/X.json  - what it converts to in R4
 *   r6/returned/X.json   - what that converts back to in R6
 * </pre>
 * The three folders on each side use the same file names, so a folder diff of resource vs returned shows
 * what the round trip loses or changes, and resource vs converted shows the conversion itself.
 * <p>
 * The converted and returned files are not hand written. Where one is missing, the test writes what the
 * convertors currently produce and passes; where one is present, the test fails if the output differs. So
 * to accept a change in the convertors, delete the affected converted/returned files and re-run the tests.
 * <p>
 * The source files are put in place by {@link RoundTrip40_NSeeder}, which only takes resources the
 * convertors support.
 */
class RoundTrip40_NTest {

  static final String ROOT_NAME = "roundtrip40_N";

  /**
   * The local fhir-test-cases checkout if there is one (and then missing outputs can be written),
   * otherwise the copy in the fhir-test-cases jar (read only)
   */
  static Path root() throws IOException {
    String dir = TestConfig.getInstance().getFhirTestCasesDirectory();
    if (dir == null && FhirSettings.hasFhirTestCasesPath()) {
      dir = FhirSettings.getFhirTestCasesPath();
    }
    if (dir != null && Files.isDirectory(Paths.get(dir))) {
      return Paths.get(dir, "conversion", ROOT_NAME);
    }
    URL url = RoundTrip40_NTest.class.getResource("/org/hl7/fhir/testcases/conversion/" + ROOT_NAME);
    if (url == null) {
      throw new IOException("Unable to find the fhir-test-cases folder conversion/" + ROOT_NAME);
    }
    try {
      URI uri = url.toURI();
      if ("jar".equals(uri.getScheme())) {
        try {
          FileSystems.getFileSystem(uri);
        } catch (FileSystemNotFoundException e) {
          FileSystems.newFileSystem(uri, Collections.emptyMap());
        }
      }
      return Paths.get(uri);
    } catch (URISyntaxException e) {
      throw new IOException(e);
    }
  }

  private static Stream<Arguments> cases(String version) throws IOException {
    Path folder = root().resolve(version).resolve("resource");
    if (!Files.isDirectory(folder)) {
      throw new IOException("The round trip test cases were not found at " + folder.toUri() + " (the fhir-test-cases location comes from the "
        + TestConfig.FHIR_TEST_CASES + " environment variable, or fhirTestCasesPath in fhir-settings.json, or else the fhir-test-cases jar)");
    }
    List<String> names;
    try (Stream<Path> files = Files.list(folder)) {
      names = files.map(f -> f.getFileName().toString()).filter(n -> n.endsWith(".json")).sorted().collect(Collectors.toList());
    }
    if (names.isEmpty()) {
      throw new IOException("No round trip test cases found in " + folder.toUri());
    }
    return names.stream().map(Arguments::of);
  }

  static Stream<Arguments> r4Cases() throws IOException {
    return cases("r4");
  }

  static Stream<Arguments> r6Cases() throws IOException {
    return cases("r6");
  }

  static org.hl7.fhir.r4.formats.JsonParser r4Parser() {
    return (org.hl7.fhir.r4.formats.JsonParser) new org.hl7.fhir.r4.formats.JsonParser().setOutputStyle(org.hl7.fhir.r4.formats.IParser.OutputStyle.PRETTY);
  }

  static org.hl7.fhir.model.core.formats.JsonParser r6Parser() {
    org.hl7.fhir.model.core.formats.JsonParser p = new org.hl7.fhir.model.core.formats.JsonParser(ModelContext.fullCoreContext());
    p.setOutputStyle(OutputStyle.PRETTY);
    return p;
  }

  /**
   * True if the exception is the convertors saying they don't handle this resource type (directly, or
   * because it's in a Bundle or contained) - those cases are skipped, not failed
   */
  static boolean isUnsupported(Exception e) {
    // "The type X cannot be converted" is a bug in a convertor that is supported, not an unsupported resource
    return e instanceof FHIRException && e.getMessage() != null && e.getMessage().startsWith("The resource ") && e.getMessage().contains(" cannot be converted");
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("r4Cases")
  void testR4RoundTrip(String name) throws IOException {
    Path folder = root().resolve("r4");
    org.hl7.fhir.r4.model.Resource src = r4Parser().parse(Files.readAllBytes(folder.resolve("resource").resolve(name)));

    org.hl7.fhir.model.core.Resource converted;
    try {
      converted = VersionConvertorFactory_40_N.convertResource(src);
    } catch (Exception e) {
      Assumptions.assumeFalse(isUnsupported(e), e.getMessage());
      throw e;
    }
    String convertedJson = r6Parser().composeString(converted);

    // convert back from the serialised form, so that the converted output has to be valid R6
    org.hl7.fhir.r4.model.Resource returned = VersionConvertorFactory_40_N.convertResource(r6Parser().parse(convertedJson));
    String returnedJson = r4Parser().composeString(returned);

    assertAll(check(folder, "converted", name, convertedJson), check(folder, "returned", name, returnedJson));
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("r6Cases")
  void testR6RoundTrip(String name) throws IOException {
    Path folder = root().resolve("r6");
    org.hl7.fhir.model.core.Resource src = r6Parser().parse(Files.readAllBytes(folder.resolve("resource").resolve(name)));

    org.hl7.fhir.r4.model.Resource converted;
    try {
      converted = VersionConvertorFactory_40_N.convertResource(src);
    } catch (Exception e) {
      Assumptions.assumeFalse(isUnsupported(e), e.getMessage());
      throw e;
    }
    String convertedJson = r4Parser().composeString(converted);

    // convert back from the serialised form, so that the converted output has to be valid R4
    org.hl7.fhir.model.core.Resource returned = VersionConvertorFactory_40_N.convertResource(r4Parser().parse(convertedJson));
    String returnedJson = r6Parser().composeString(returned);

    assertAll(check(folder, "converted", name, convertedJson), check(folder, "returned", name, returnedJson));
  }

  /**
   * if there's no file yet, write what we have and accept it. Otherwise, it must not have changed
   */
  private static Executable check(Path folder, String kind, String name, String actual) throws IOException {
    Path file = folder.resolve(kind).resolve(name);
    if (!Files.exists(file)) {
      if (file.getFileSystem() != FileSystems.getDefault()) {
        return () -> fail(kind + "/" + name + " is missing, and can't be created in the fhir-test-cases jar - run the test against a local fhir-test-cases checkout");
      }
      Files.createDirectories(file.getParent());
      Files.write(file, actual.getBytes(StandardCharsets.UTF_8));
      return () -> { };
    }
    String expected = new String(Files.readAllBytes(file), StandardCharsets.UTF_8);
    return () -> assertEquals(normalise(expected), normalise(actual),
      kind + "/" + name + " has changed (delete " + file + " to accept the new output)");
  }

  private static String normalise(String s) {
    return s.replace("\r\n", "\n").trim();
  }
}
