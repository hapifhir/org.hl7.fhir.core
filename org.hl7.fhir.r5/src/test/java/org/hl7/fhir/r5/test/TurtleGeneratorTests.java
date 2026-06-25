package org.hl7.fhir.r5.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.fhir.ucum.UcumException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.ParserBase;
import org.hl7.fhir.r5.elementmodel.ParserBase.IdRenderingPolicy;
import org.hl7.fhir.r5.elementmodel.ParserBase.ValidationPolicy;
import org.hl7.fhir.r5.elementmodel.TurtleParser;
import org.hl7.fhir.r5.elementmodel.TurtleParserR6;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.turtle.Turtle;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;

/**
 * TurtleGeneratorTests
 * Generates TTL (Terse Triples Language, aka "Turtle") files from specified resources, including example "instances"
 * Unit tests for the generated turtle files
 * For generic RDF parsing tests, see `TurtleTests.java`
 * For ShEx validation tests, see `ShExGeneratorTests.java`
 * Author: Tim Prudhomme <tmprdh@gmail.com>
 */
public class TurtleGeneratorTests {
  private static TurtleGeneratorTestUtils.ParserContext parsers;
  private static TurtleGeneratorTestUtils.ParserContext r5Parsers;
  private static TurtleGeneratorTestUtils.ParserContext r4Parsers;
  private static TurtleGeneratorTestUtils.ParserContext r6Parsers;
  private static final String R4_VERSION = "4.0.1";
  private static final String R6_VERSION = "6.0.0";

  private static final Path ROOT_TEST_PATH = Paths.get("testUtilities");
  private static final Path DEFAULT_EXPECTED_XML_DIR = ROOT_TEST_PATH.resolve("xml/examples/expected");
  private static final Path DEFAULT_EXPECTED_JSON_DIR = ROOT_TEST_PATH.resolve("json/examples/expected");
  private static final Path DEFAULT_EXPECTED_TTL_DIR = ROOT_TEST_PATH.resolve("ttl/examples/expected");
    // These can be overwritten with a local.properties file (org.hl7.fhir.r5/src/test/resources/local.properties)
  private static Path inputXmlDirectory;
  private static Path inputJsonDirectory;
  private static Path outputTurtleDirectory;
  private static Path expectedTurtleDirectory;

  private static Path DEFAULT_OUTPUT_TURTLE_DIR;

  @BeforeAll
  public static void setup() throws IOException {
    DEFAULT_OUTPUT_TURTLE_DIR = Path.of(Utilities.path("[tmp]", "ttl"));

    // Override configured directories in org.hl7.fhir.r5/src/test/resources/local.properties
    var props = TurtleGeneratorTestUtils.loadLocalProperties();
    inputXmlDirectory = TurtleGeneratorTestUtils.getConfiguredDirectory(props, "inputXmlDirectory", TurtleGeneratorTestUtils.getResourcePath(DEFAULT_EXPECTED_XML_DIR));
    inputJsonDirectory = TurtleGeneratorTestUtils.getConfiguredDirectory(props, "inputJsonDirectory", TurtleGeneratorTestUtils.getResourcePath(DEFAULT_EXPECTED_JSON_DIR));
    outputTurtleDirectory = TurtleGeneratorTestUtils.getConfiguredDirectory(props, "outputTtlDirectory", DEFAULT_OUTPUT_TURTLE_DIR);
    Files.createDirectories(outputTurtleDirectory);
    expectedTurtleDirectory = TurtleGeneratorTestUtils.getConfiguredDirectory(props, "expectedTtlDirectory", TurtleGeneratorTestUtils.getResourcePath(DEFAULT_EXPECTED_TTL_DIR));

    // Use R5 by default
    r5Parsers = TurtleGeneratorTestUtils.ParserContext.fromWorkerContext(TestingUtilities.getSharedWorkerContext());
    useR5Parsers();
  }

  @BeforeEach
  void resetParsers() {
    // Reset to R5 by default
    useR5Parsers();
  }

  @AfterAll
  public static void tearDown() {
    parsers = null;
    r5Parsers = null;
    r4Parsers = null;
    r6Parsers = null;
    inputXmlDirectory = null;
    inputJsonDirectory = null;
    outputTurtleDirectory = null;
    expectedTurtleDirectory = null;
  }

  private static void useR5Parsers() {
    parsers = r5Parsers;
  }

  /**
   * Get cached versioned contexts
   */
  private static void useVersionOverrideParsers(String version) {
    parsers = getVersionOverrideParsers(version);
  }

  /**
   * Efficiently cache each context for when running multiple tests
   */
  private static TurtleGeneratorTestUtils.ParserContext getVersionOverrideParsers(String version) {
    if (R4_VERSION.equals(version)) {
      if (r4Parsers == null) {
        r4Parsers = createVersionOverrideParsers(version);
      }
      return r4Parsers;
    } else if (R6_VERSION.equals(version)) {
      if (r6Parsers == null) {
        r6Parsers = createVersionOverrideParsers(version);
      }
      return r6Parsers;
    } else {
      throw new IllegalArgumentException("Unsupported FHIR version for Turtle tests: " + version);
    }
  }

  private static TurtleGeneratorTestUtils.ParserContext createVersionOverrideParsers(String version) {
    IWorkerContext context = TurtleGeneratorTestUtils.getVersionOverrideWorkerContext(version);
    System.out.println("FHIR version for testing: " + context.getVersion());
    return TurtleGeneratorTestUtils.ParserContext.fromWorkerContext(context);
  }

  // ---------------------------------------------------------------------------
  // Tests
  // ---------------------------------------------------------------------------
  // XML conversion
  @Test
  public void testXmlExamplesR5() throws IOException, UcumException {
    testExpectedXmlExamples(expectedTurtleDirectory.resolve("R5"), outputTurtleDirectory);
  }

  @Test
  public void testXmlExamplesR4() throws IOException, UcumException {
    useVersionOverrideParsers(R4_VERSION);
    testExpectedXmlExamples(expectedTurtleDirectory.resolve("R4"), outputTurtleDirectory);
  }

  @Test
  public void testXmlExamplesR6() throws IOException, UcumException {
    useVersionOverrideParsers(R6_VERSION);
    testExpectedXmlExamples(expectedTurtleDirectory.resolve("R6"), outputTurtleDirectory);
  }

  
  // JSON conversion
  @Test
  public void testJsonExampleR5() throws IOException, UcumException {
    testExpectedJsonExamples(inputJsonDirectory.resolve("R5"), outputTurtleDirectory);
  }
  @Test
  public void testJsonExampleR4() throws IOException, UcumException {
    useVersionOverrideParsers(R4_VERSION);
    testExpectedJsonExamples(inputJsonDirectory.resolve("R4"), outputTurtleDirectory);
  }

  // TODO add R6 JSON example from somewhere


  @Test
  public void testR6ClassNameHandlesEmptyInput() {
    assertThat(TurtleParserR6.getClassName(null)).isNull();
    assertThat(TurtleParserR6.getClassName("")).isEmpty();
  }

  // Not all of these are critical and can be consolidated if we want to reduce tests
  @Test
  public void testAsHtmlGeneratesProperFormattingR4() throws Exception {
    testAsHtmlGeneratesProperFormatting("R4", getVersionOverrideParsers(R4_VERSION));
  }

  @Test
  public void testAsHtmlGeneratesProperFormattingR5() throws Exception {
    testAsHtmlGeneratesProperFormatting("R5", r5Parsers);
  }

  @Test
  public void testAsHtmlGeneratesProperFormattingR6() throws Exception {
    testAsHtmlGeneratesProperFormatting("R6", getVersionOverrideParsers(R6_VERSION));
  }

  @Test
  public void asHtmlRendersLinkedPredicatesAsAnchors() throws Exception {
    Turtle ttl = new Turtle();
    ttl.prefix("fhir", "http://hl7.org/fhir/");
    Turtle.Section section = ttl.section("test");
    Turtle.Subject subject = section.subject("fhir:Example");
    subject.linkedPredicate("fhir:name", "value", "http://example.org/name", null);

    String html = ttl.asHtml(false);
    assertThat(html).contains("<a href=\"http://example.org/name\">fhir:name</a>");
  }

  /** Verifies the sync wiring actually runs; the drift detector below verifies the field set. */
  @Test
  public void syncR6ParserStatePropagatesSettingsToDelegate() throws Exception {
    TurtleParser parser = new TurtleParser(TestingUtilities.getSharedWorkerContext());
    parser.setupValidation(ValidationPolicy.EVERYTHING);
    parser.setIdPolicy(IdRenderingPolicy.None);
    parser.setShowDecorations(true);

    Method r6ParserMethod = TurtleParser.class.getDeclaredMethod("r6Parser");
    r6ParserMethod.setAccessible(true);
    TurtleParserR6 delegate = (TurtleParserR6) r6ParserMethod.invoke(parser);

    assertThat(delegate.getPolicy()).isEqualTo(ValidationPolicy.EVERYTHING);
    assertThat(delegate.getIdPolicy()).isEqualTo(IdRenderingPolicy.None);
    assertThat(delegate.isShowDecorations()).isTrue();
  }

  /**
   * Drift detector for {@code TurtleParser.syncR6ParserState()}: if a new mutable field is
   * added to {@link ParserBase}, this test fails so the new field is either propagated to the
   * R6 delegate or explicitly added to the ignored set below.
   */
  @Test
  public void syncR6ParserStateCoversAllParserBaseSettings() {
    Set<String> covered = Set.of(
        "policy", "linkResolver", "showDecorations", "idPolicy",
        "logical", "signatureServices", "canonicalFilter");
    // Internal plumbing established at construction time; not part of user-configurable state.
    Set<String> ignored = Set.of("context", "profileUtilities", "contextUtilities");

    Set<String> declared = Arrays.stream(ParserBase.class.getDeclaredFields())
        .filter(f -> !Modifier.isStatic(f.getModifiers()))
        .filter(f -> !Modifier.isFinal(f.getModifiers()))
        .map(Field::getName)
        .collect(Collectors.toSet());

    Set<String> unaccounted = new HashSet<>(declared);
    unaccounted.removeAll(covered);
    unaccounted.removeAll(ignored);

    assertThat(unaccounted)
        .as("New ParserBase field(s) not propagated by TurtleParser.syncR6ParserState — add to covered or ignored set")
        .isEmpty();
  }


  @Disabled("TODO this doesn't pass due to some FHIR URLs containing vertical bars |, which are allowed in XSD 1.1 but not XSD 1.0")
  @Test
  public void testProfiles() throws IOException, UcumException {
    testStructureDefinitionGeneration("Encounter");
  }


  @Disabled("Run manually for testing with XML resources generated from FHIR specification publishing library")
  @Test
  public void testPublishedXmlExamples() throws IOException, UcumException {
    System.out.println("Using input XML directory: " + inputXmlDirectory);
    System.out.println("Using output Turtle directory: " + outputTurtleDirectory);
    int success = 0;
    var failures = new ArrayList<String>();
    try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(inputXmlDirectory, "*.xml")) {
      for (Path xml : dirStream) {
        if (xml == null || Files.isDirectory(xml)) continue;
        try {
          testInstanceGeneration(xml);
          success++;
        } catch (Exception e) {
          System.out.println("Failed to generate Turtle for " + xml.getFileName() + ": " + e.getMessage());
          failures.add(xml.getFileName().toString());
        }
      }
    }
    System.out.println("Published examples summary: success=" + success + ", failed=" + failures.size());
    for (String f : failures) {
      System.out.println("  - " + f);
    }
  }

  @Disabled("Run manually for testing with mixed-format 'test-case' resources")
  @Test
  public void testGenerateFromTestCaseDirectory() throws IOException, UcumException {
    var inputDirectory = TurtleGeneratorTestUtils.getConfiguredDirectory(TurtleGeneratorTestUtils.loadLocalProperties(), "testCasesDirectory", null);
    if (inputDirectory == null) {
      throw new IllegalStateException("Missing testCasesDirectory configuration. Set it in src/test/resources/local.properties or pass -DtestCasesDirectory=/absolute/path.");
    }
    System.out.println("Using input directory: " + inputDirectory);
    System.out.println("Using output Turtle directory: " + outputTurtleDirectory);
    var generated = parsers.generateTurtleFromMixedResourceDirectory(inputDirectory, outputTurtleDirectory);
    System.out.println("Generated " + generated.size() + " Turtle files");
  }

  // ---------------------------------------------------------------------------
  // Test helpers
  // ---------------------------------------------------------------------------

  /**
   * Examples should (1) parse without errors and (2) match the corresponding expected TTL
   */
  private void testExpectedXmlExamples(Path expectedDirectory, Path outputDirectory) throws IOException, UcumException {
    List<Path> expectedTurtlePaths;
    try (var paths = Files.list(expectedDirectory)) {
      expectedTurtlePaths = paths
          .filter(Files::isRegularFile)
          .filter(path -> path.toString().endsWith(".ttl"))
          .sorted()
          .collect(Collectors.toList());
    }

    Assumptions.assumeFalse(expectedTurtlePaths.isEmpty(), "No expected Turtle fixtures found in " + expectedDirectory);

    for (Path expectedTurtlePath : expectedTurtlePaths) {
      Path xmlResourcePath = getXmlExamplePathForExpectedTurtle(expectedTurtlePath);
      Assertions.assertTrue(Files.exists(xmlResourcePath), "Missing XML example for " + expectedTurtlePath.getFileName() + " at path: " + xmlResourcePath);
      String expected = parsers.parseGeneratedTurtle(expectedTurtlePath.toString());
      String actual = parsers.parseGeneratedTurtle(parsers.generateTurtleFromXmlResourcePath(xmlResourcePath, outputDirectory));
      FileUtilities.stringToFile(actual, outputDirectory.resolve(xmlResourcePath.getFileName()).toString());
      Assertions.assertEquals(
        expected,
        actual,
          "Generated Turtle did not match expected output for " + expectedTurtlePath.getFileName());
    }
  }

  private void testExpectedJsonExamples(Path expectedDirectory, Path outputDirectory) throws IOException, UcumException {
    List<Path> expectedJsonPaths;
    try (var paths = Files.list(expectedDirectory)) {
      expectedJsonPaths = paths
          .filter(Files::isRegularFile)
          .filter(path -> path.toString().endsWith(".json"))
          .sorted()
          .collect(Collectors.toList());
    }

    Assumptions.assumeFalse(expectedJsonPaths.isEmpty(), "No expected JSON fixtures found in " + expectedDirectory);

    for (Path expectedJsonPath : expectedJsonPaths) {
      parsers.generateTurtleFromJsonResourcePath(expectedJsonPath, outputDirectory);
      // TODO finalize example JSON files and match to expected corresponding TTL
    }
  }

  private String testInstanceGeneration(Path resourcePath) throws IOException, UcumException {
    var generatedTurtlePath = parsers.generateTurtleFromXmlResourcePath(resourcePath, outputTurtleDirectory);
    parsers.parseGeneratedTurtle(generatedTurtlePath);
    return generatedTurtlePath;
  }

  private void testStructureDefinitionGeneration(String profileName) throws IOException, UcumException {
    parsers.parseGeneratedTurtle(parsers.generateTurtleStructureDefinitionFromProfileName(profileName, outputTurtleDirectory));
  }

  private Path getXmlExamplePathForExpectedTurtle(Path expectedTurtlePath) {
    String turtleFileName = expectedTurtlePath.getFileName().toString();
    String baseName = turtleFileName.endsWith(".ttl") ? turtleFileName.substring(0, turtleFileName.length() - 4) : turtleFileName;
    Path xmlFileName = Paths.get(baseName + ".xml");
    Path expectedParent = expectedTurtlePath.getParent();

    if (expectedParent != null) {
      Path relativeParent = expectedTurtleDirectory.relativize(expectedParent);
      Path versionedXmlPath = inputXmlDirectory.resolve(relativeParent).resolve(xmlFileName);
      if (Files.exists(versionedXmlPath)) {
        return versionedXmlPath;
      }
    }

    return inputXmlDirectory.resolve(xmlFileName);
  }

  private void testAsHtmlGeneratesProperFormatting(String versionDirectory, TurtleGeneratorTestUtils.ParserContext parserContext) throws Exception {
    Path xmlResourcePath = inputXmlDirectory.resolve(versionDirectory).resolve("patient-example-f201-roel.xml");
    Assumptions.assumeTrue(Files.exists(xmlResourcePath), "XML example missing: " + xmlResourcePath);

    Turtle rdf = parserContext.composeTurtleFromXmlResourcePath(xmlResourcePath);

    String prismHtml = rdf.asHtml(true);
    String plainHtml = rdf.asHtml(false);
    String preOpen = "<pre class=\"rdf\" data-fhir=\"generated\" style=\"white-space: pre; overflow: hidden\">";

    assertThat(prismHtml).startsWith(preOpen + "<code class=\"language-turtle\">\r\n").endsWith("</code></pre>\r\n\r\n");
    assertThat(plainHtml).startsWith(preOpen + "\r\n").endsWith("</pre>\r\n\r\n");

    // The HTML rendering path emits prefix declarations with XML-escaped angle brackets.
    assertThat(prismHtml).contains("@prefix fhir: &lt;http://hl7.org/fhir/&gt; .");
    assertThat(plainHtml).contains("@prefix fhir: &lt;http://hl7.org/fhir/&gt; .");

    // Write out for manual inspection
    String stem = xmlResourcePath.getFileName().toString().replaceFirst("\\.xml$", "");
    Path prismOut = outputTurtleDirectory.resolve(stem + "." + versionDirectory + ".prism.html");
    Path plainOut = outputTurtleDirectory.resolve(stem + "." + versionDirectory + ".plain.html");
    Files.writeString(prismOut, prismHtml);
    Files.writeString(plainOut, plainHtml);
  }
}
