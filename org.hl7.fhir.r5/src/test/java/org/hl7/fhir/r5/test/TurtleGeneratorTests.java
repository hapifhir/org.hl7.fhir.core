package org.hl7.fhir.r5.test;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;

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

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * TurtleGeneratorTests
 * Generates turtle files from specified resources, including example "instances"
 * Unit tests for the generated turtle files
 * 
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
  public static void setup() {
    workerContext = TestingUtilities.getSharedWorkerContext();
    resourceParser = new org.hl7.fhir.r5.elementmodel.ResourceParser(workerContext);
    xmlParser = (XmlParser) Manager.makeParser(workerContext, FhirFormat.XML);
    turtleParser = (TurtleParser) Manager.makeParser(workerContext, FhirFormat.TURTLE);

    // This could be the "publish" directory of XML resources built using the FHIR specification publishing library
    inputXmlDirectory = Path.of("TODO");

    // This is a temporary directory for files that should be discarded after testing
    outputTurtleDirectory = FileSystems.getDefault().getPath(System.getProperty("java.io.tmpdir"));
  }

  @Test
  public void testInstance() throws IOException, UcumException {
    var resourceName = "codesystem-contact-point-use";
    generateTurtleFromResourceName(resourceName, inputXmlDirectory, outputTurtleDirectory);
  }

  @Test
  public void testClass() throws IOException, UcumException {
    var ttlFilePath = outputTurtleDirectory.resolve("Patient.ttl").toString();
    generateTurtleFromResource("Patient", ttlFilePath);
  }

  
  /**
   * Generate a turtle version of a resource, given its name, input directory of its xml source, and output directory of the turtle file
   */
  private void generateTurtleFromResourceName(String resourceName, Path inputXmlDirectory, Path outputTurtleDirectory) throws IOException, UcumException {
    // Specify source xml path and destination turtle path
    var xmlFilePath = inputXmlDirectory.resolve(resourceName + ".xml").toString();
    var turtleFilePath = outputTurtleDirectory.resolve(resourceName + ".ttl").toString();

    try (
        InputStream inputXmlStream = new FileInputStream(xmlFilePath);
        OutputStream outputTurtleStream = new FileOutputStream(turtleFilePath);
    ) {
      generateTurtleFromXmlStream(inputXmlStream, outputTurtleStream);
      // Analyze output stream now
    }
  }


  /**
   * Generate a turtle file from a "test case" resource -- those only available on https://github.com/FHIR/fhir-test-cases/
   */
  private void generateTurtleFromTestCaseResource(String resourceName) throws IOException, UcumException {
    var turtleFilePath = outputTurtleDirectory.resolve(resourceName + ".ttl").toString();
    try (
      InputStream inputXmlStream = TestingUtilities.loadTestResourceStream("r5", resourceName + ".xml");
      OutputStream outputTurtleStream = new FileOutputStream(turtleFilePath);
    ) {
      generateTurtleFromXmlStream(inputXmlStream, outputTurtleStream);
    }
  }


  /**
   * Generate a turtle file from an xml resource
   */
  private OutputStream generateTurtleFromXmlStream(InputStream xmlStream, OutputStream turtleStream) throws IOException, UcumException {
    var errorList = new ArrayList<ValidationMessage>();
    Element resourceElement = xmlParser.parseSingle(xmlStream, errorList);
    turtleParser.compose(resourceElement, turtleStream, OutputStyle.PRETTY, null);
    // Check errors
    for (ValidationMessage m : errorList) {
      System.out.println(m.getDisplay());
    }
    // Return stream to analyze
    return turtleStream;
  }


  private void generateTurtleFromResource(String resourceName, String ttlFilePath) throws IOException, UcumException {
    String resourceUri = ProfileUtilities.sdNs(resourceName, null);
    Resource resource = workerContext.fetchResource(Resource.class, resourceUri);
    Element resourceElement = resourceParser.parse(resource);
    turtleParser.compose(resourceElement, new FileOutputStream(ttlFilePath), OutputStyle.PRETTY, null);
  }
}
