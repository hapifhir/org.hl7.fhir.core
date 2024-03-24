package org.hl7.fhir.r5.test;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Properties;

import org.fhir.ucum.UcumException;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.elementmodel.ResourceParser;
import org.hl7.fhir.r5.elementmodel.TurtleParser;
import org.hl7.fhir.r5.elementmodel.XmlParser;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.validation.ValidationMessage;

import org.hl7.fhir.utilities.turtle.Turtle;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * TurtleGeneratorTests
 * Generates turtle files from specified resources, including example "instances"
 * Unit tests for the generated turtle files
 * For generic RDF parsing tests, see `TurtleTests.java`
 * For ShEx validation tests, see `ShExGeneratorTests.java`
 * Author: Tim Prudhomme <tmprdh@gmail.com>
 */
public class TurtleGeneratorTests {

  private static IWorkerContext workerContext;
  private static ResourceParser resourceParser;
  private static XmlParser xmlParser;
  private static TurtleParser turtleParser;

  private static Path inputXmlDirectory;
  private static Path outputTurtleDirectory;

  @BeforeAll
  public static void setup() throws IOException {
    workerContext = TestingUtilities.getSharedWorkerContext();
    resourceParser = new org.hl7.fhir.r5.elementmodel.ResourceParser(workerContext);
    xmlParser = (XmlParser) Manager.makeParser(workerContext, FhirFormat.XML);
    turtleParser = (TurtleParser) Manager.makeParser(workerContext, FhirFormat.TURTLE);

    // Temporary directory of files that should be discarded after testing
    outputTurtleDirectory = FileSystems.getDefault().getPath(System.getProperty("java.io.tmpdir"));

    // Directory of XML files used for generating Turtle files
    String currentDirectory = System.getProperty("user.dir");
    inputXmlDirectory = FileSystems.getDefault().getPath(currentDirectory, "src", "test", "resources", "testUtilities", "xml", "examples");
  }

  @Test
  public void testExamples() throws IOException, UcumException {
    var exampleInstanceName = "codesystem-contact-point-use";
    testInstanceGeneration(exampleInstanceName);
  }

  @Disabled("TODO this doesn't pass due to existing issues in R5 RDF")
  @Test
  public void testProfiles() throws IOException, UcumException {
    var profileName = "Encounter";
    testClassGeneration(profileName);
  }

  @Disabled("Run manually for testing with XML resources generated from FHIR specification publishing library")
  @Test
  public void testPublishedExamples() throws IOException, UcumException {
    inputXmlDirectory = getPublishedXmlDirectory();
    var exampleInstanceName = "codesystem-contact-point-use";
    testInstanceGeneration(exampleInstanceName);
  }

  /*
   * Generate a Turtle file from the name of an XML resource, then parse it
  */
  private void testInstanceGeneration(String resourceName) throws IOException, UcumException {
    // Generate Turtle
    var generatedTurtleFilePath = generateTurtleFromResourceName(resourceName, inputXmlDirectory, outputTurtleDirectory);
    // Try parsing again ("round-trip test") -- this only tests for valid RDF
    parseGeneratedTurtle(generatedTurtleFilePath);
  }

  /*
  * Generate a Turtle file from the name of a profile, then parse it
  */
  private void testClassGeneration(String profileName) throws IOException, UcumException {
    var generatedTurtleFilePath = generateTurtleClassFromProfileName(profileName);
    // Try parsing again ("round-trip test") -- this only tests for valid RDF
    parseGeneratedTurtle(generatedTurtleFilePath);
  }

  private void parseGeneratedTurtle(String generatedTurtleFilePath) throws IOException {
    try (
      InputStream turtleStream = new FileInputStream(generatedTurtleFilePath);
    ) {
      var generatedTurtleString = new String(turtleStream.readAllBytes());
      Turtle ttl = new Turtle();
      ttl.parse(generatedTurtleString);
    }
  }
  
  /**
   * Generate a Turtle version of a resource, given its name, input directory of its XML source, and output directory of the Turtle file
   * @return the path of the generated Turtle file
   */
  private String generateTurtleFromResourceName(String resourceName, Path inputXmlDirectory, Path outputTurtleDirectory) throws IOException, UcumException {
    // Specify source xml path and destination turtle path
    var xmlFilePath = inputXmlDirectory.resolve(resourceName + ".xml").toString();
    var turtleFilePath = outputTurtleDirectory.resolve(resourceName + ".ttl").toString();
    try (
        InputStream inputXmlStream = new FileInputStream(xmlFilePath);
        OutputStream outputTurtleStream = new FileOutputStream(turtleFilePath);
    ) {
      // print out file names using string interpolation
      System.out.println("Generating " + turtleFilePath);
      generateTurtleFromXmlStream(inputXmlStream, outputTurtleStream);
      return turtleFilePath;
    }
  }

  /**
   * Generate a Turtle file from an XML resource
   */
  private void generateTurtleFromXmlStream(InputStream xmlStream, OutputStream turtleStream) throws IOException, UcumException {
    var errorList = new ArrayList<ValidationMessage>();
    Element resourceElement = xmlParser.parseSingle(xmlStream, errorList);
    turtleParser.compose(resourceElement, turtleStream, OutputStyle.PRETTY, null);
    // Check errors
    for (ValidationMessage m : errorList) {
      System.out.println(m.getDisplay());
    }
  }

  /**
   * Generate a Turtle file from an org.hl7.fhir.r5.model.Resource profile
   * @return the path of the generated Turtle file
   */
  private String generateTurtleClassFromProfileName(String profileName) throws IOException, UcumException {
    String resourceUri = ProfileUtilities.sdNs(profileName, null);
    Resource resource = workerContext.fetchResource(Resource.class, resourceUri);
    Element resourceElement = resourceParser.parse(resource);
    var turtleFilePath = outputTurtleDirectory.resolve(profileName + ".ttl").toString();
    try (OutputStream outputStream = new FileOutputStream(turtleFilePath)) {
      turtleParser.compose(resourceElement, outputStream, OutputStyle.PRETTY, null);
      return turtleFilePath;
    }
  }

  /**
   * Generate a Turtle file from a "test case" resource -- those only available on https://github.com/FHIR/fhir-test-cases/
   * @return the path of the generated Turtle file
   */
  private String generateTurtleFromTestCaseResource(String resourceName) throws IOException, UcumException {
    var turtleFilePath = outputTurtleDirectory.resolve(resourceName + ".ttl").toString();
    try (
      // Follows pattern in `TestingUtilities.java`
      InputStream inputXmlStream = TestingUtilities.loadTestResourceStream("r5", resourceName + ".xml");
      OutputStream outputTurtleStream = new FileOutputStream(turtleFilePath);
    ) {
      generateTurtleFromXmlStream(inputXmlStream, outputTurtleStream);
      return turtleFilePath;
    }
  }


  /**
   * This could be the "publish" directory of XML resources built using the FHIR specification publishing library.
   * Use this for testing with other generated XML resources
   */
  private static Path getPublishedXmlDirectory() throws IOException {
    Properties properties = new Properties();
    String currentDirectory = System.getProperty("user.dir");
    // Add your directory path to "org.hl7.fhir.r5/src/test/resources/local.properties"
    String localPropertiesPath = FileSystems.getDefault().getPath(currentDirectory, "src", "test", "resources", "local.properties").toString();
    try (FileInputStream input = new FileInputStream(localPropertiesPath)) {
        properties.load(input);
    } catch (IOException e) {
        // You should create this local.properties file if it doesn't exist. It should already be listed in .gitignore.
        e.printStackTrace();
        throw e;
    }
    var filePath = properties.getProperty("xmlResourceDirectory");
    return FileSystems.getDefault().getPath(filePath);
  }
}
