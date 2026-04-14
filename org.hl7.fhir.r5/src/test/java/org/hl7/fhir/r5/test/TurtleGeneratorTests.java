package org.hl7.fhir.r5.test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.DirectoryStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.fhir.ucum.UcumException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.junit.jupiter.api.BeforeAll;
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

  // These should be overwritten with a local.properties file (org.hl7.fhir.r5/src/test/resources/local.properties)
  private static Path inputXmlDirectory = FileSystems.getDefault().getPath(System.getProperty("user.dir"), "src", "test", "resources", "testUtilities", "json", "examples");
  private static Path inputJsonDirectory = FileSystems.getDefault().getPath(System.getProperty("user.dir"), "src", "test", "resources", "testUtilities", "xml", "examples");
  private static Path outputTurtleDirectory = FileSystems.getDefault().getPath(System.getProperty("java.io.tmpdir"));
  private static Path expectedTurtleDirectory = FileSystems.getDefault().getPath(System.getProperty("user.dir"), "src", "test", "resources", "testUtilities", "ttl", "expected");

  @BeforeAll
  public static void setup() throws IOException {
    var props = TurtleGeneratorTestUtils.loadLocalProperties();
    inputXmlDirectory = TurtleGeneratorTestUtils.getConfiguredDirectory(props, "inputXmlDirectory", inputXmlDirectory);
    inputJsonDirectory = TurtleGeneratorTestUtils.getConfiguredDirectory(props, "inputJsonDirectory", inputJsonDirectory);
    outputTurtleDirectory = TurtleGeneratorTestUtils.getConfiguredDirectory(props, "outputTtlDirectory", outputTurtleDirectory);
    Files.createDirectories(outputTurtleDirectory);
    expectedTurtleDirectory = TurtleGeneratorTestUtils.getConfiguredDirectory(props, "expectedTtlDirectory", expectedTurtleDirectory);

    initializeParsers(TestingUtilities.getSharedWorkerContext());
  }

  private static void initializeParsers(IWorkerContext context) {
    parsers = TurtleGeneratorTestUtils.ParserContext.fromWorkerContext(context);
    System.out.println("FHIR version for testing: " + context.getVersion());
  }

  // ---------------------------------------------------------------------------
  // Tests
  // ---------------------------------------------------------------------------
  @Test
  public void testExamples() throws IOException, UcumException {
    // As used in R5 serialization
    testExpectedExamples(expectedTurtleDirectory.resolve("R5"));
  }

  @Test
  public void testExamplesR6() throws IOException, UcumException {
    // Re-initialize context of current FHIR build
    var r6context = TurtleGeneratorTestUtils.getVersionOverrideWorkerContext("6.0.0");
    initializeParsers(r6context);
    testExpectedExamples(expectedTurtleDirectory.resolve("R6"));
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
  private void testExpectedExamples(Path expectedDirectory) throws IOException, UcumException {
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
      Assertions.assertTrue(Files.exists(xmlResourcePath), "Missing XML example for " + expectedTurtlePath.getFileName());
      Assertions.assertEquals(
          parsers.parseGeneratedTurtle(expectedTurtlePath.toString()),
          parsers.parseGeneratedTurtle(parsers.generateTurtleFromXmlResourcePath(xmlResourcePath, outputTurtleDirectory)),
          "Generated Turtle did not match expected output for " + expectedTurtlePath.getFileName());
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
    return inputXmlDirectory.resolve(baseName + ".xml");
  }
}
