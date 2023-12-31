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

    // This is a directory of XML resources built using the FHIR specification
    inputXmlDirectory = getInputXmlDirectory();

    // This is a temporary directory for files that should be discarded after testing
    outputTurtleDirectory = FileSystems.getDefault().getPath(System.getProperty("java.io.tmpdir"));
  }

  @Test
  public void testInstanceGeneration() throws IOException, UcumException {
    var resourceName = "codesystem-contact-point-use";
    // Generate Turtle
    var generatedTurtleFilePath = generateTurtleInstanceFromResourceName(resourceName, inputXmlDirectory, outputTurtleDirectory);
    // Try parsing again ("round-trip test") -- this only tests for valid RDF
    try (
      InputStream turtleStream = new FileInputStream(generatedTurtleFilePath);
    ) {
      var generatedTurtleString = new String(turtleStream.readAllBytes());
      Turtle ttl = new Turtle();
      ttl.parse(generatedTurtleString);
    }
    // TODO add more tests here
  }

  @Test
  public void testClassGeneration() throws IOException, UcumException {
    var profileName = "Patient";
    var generatedTurtleFilePath = generateTurtleClassFromProfileName(profileName);
    // Try parsing again ("round-trip test") -- this only tests for valid RDF
    try (
      InputStream turtleStream = new FileInputStream(generatedTurtleFilePath);
    ) {
      var generatedTurtleString = new String(turtleStream.readAllBytes());
      Turtle ttl = new Turtle();
      ttl.parse(generatedTurtleString);
    }
    // TODO add more tests here
  }

  
  /**
   * This could be the "publish" directory of XML resources built using the FHIR specification publishing library
   */
  private static Path getInputXmlDirectory() throws IOException {
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
  
  /**
   * Generate a Turtle version of a resource, given its name, input directory of its XML source, and output directory of the Turtle file
   * @return the path of the generated Turtle file
   */
  private String generateTurtleInstanceFromResourceName(String resourceName, Path inputXmlDirectory, Path outputTurtleDirectory) throws IOException, UcumException {
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
}
