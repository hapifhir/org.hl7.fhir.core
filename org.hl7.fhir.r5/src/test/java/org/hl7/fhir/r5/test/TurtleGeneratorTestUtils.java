package org.hl7.fhir.r5.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.fhir.ucum.UcumException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.JsonParser;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.elementmodel.ResourceParser;
import org.hl7.fhir.r5.elementmodel.TurtleParser;
import org.hl7.fhir.r5.elementmodel.ValidatedFragment;
import org.hl7.fhir.r5.elementmodel.XmlParser;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.turtle.Turtle;
import org.hl7.fhir.utilities.validation.ValidationMessage;

public final class TurtleGeneratorTestUtils {
  
  private TurtleGeneratorTestUtils() {
    // Utility class
  }
  
  public static final class ParserContext {
    private final IWorkerContext workerContext;
    private final ResourceParser resourceParser;
    private final XmlParser xmlParser;
    private final JsonParser jsonParser;
    private final TurtleParser turtleParser;

    private ParserContext(IWorkerContext workerContext) {
      this.workerContext = workerContext;
      this.resourceParser = new ResourceParser(workerContext);
      this.xmlParser = (XmlParser) Manager.makeParser(workerContext, FhirFormat.XML);
      this.jsonParser = (JsonParser) Manager.makeParser(workerContext, FhirFormat.JSON);
      this.turtleParser = (TurtleParser) Manager.makeParser(workerContext, FhirFormat.TURTLE);
    }

    public static ParserContext fromWorkerContext(IWorkerContext workerContext) {
      return new ParserContext(workerContext);
    }

    public IWorkerContext getWorkerContext() {
      return workerContext;
    }

    
    // ---------------------------------------------------------------------------
    // TTL parsers
    // ---------------------------------------------------------------------------
    public String parseGeneratedTurtle(String turtleFilePath) throws IOException {
      try (InputStream stream = ManagedFileAccess.inStream(turtleFilePath)) {
        String turtle = new String(stream.readAllBytes(), StandardCharsets.UTF_8);
        new Turtle().parse(turtle);
        return normalizeTurtle(turtle);
      }
    }
    
    private static String normalizeTurtle(String turtle) {
      return turtle.replaceAll("\\r\\n?", "\n").trim();
    }

    public Element parseGeneratedTurtleElement(String turtleFilePath) throws IOException {
      try (InputStream stream = ManagedFileAccess.inStream(turtleFilePath)) {
        List<ValidatedFragment> fragments = turtleParser.parse(stream);
        if (fragments.size() != 1) {
          throw new IOException("Expected a single Turtle fragment for " + turtleFilePath + " but found " + fragments.size());
        }
        Element element = fragments.get(0).getElement();
        if (element == null) {
          throw new IOException("Turtle parser returned no element for " + turtleFilePath);
        }
        return element;
      }
    }

    // ---------------------------------------------------------------------------
    // TTL generators
    // ---------------------------------------------------------------------------
    public String generateTurtleFromXmlResourcePath(Path xmlResourcePath, Path outputDirectory) throws IOException, UcumException {
      var fileName = xmlResourcePath.getFileName().toString();
      var baseName = fileName.endsWith(".xml") ? fileName.substring(0, fileName.length() - 4) : fileName;
      var turtleFilePath = outputDirectory.resolve(baseName + ".ttl").toString();
      try (
        InputStream inputXmlStream = ManagedFileAccess.inStream(xmlResourcePath.toString());
        OutputStream outputTurtleStream = ManagedFileAccess.outStream(turtleFilePath)
      ) {
        System.out.println("Generating " + turtleFilePath);
        generateTurtleFromXmlStream(inputXmlStream, outputTurtleStream);
        return turtleFilePath;
      }
    }

    public void generateTurtleFromXmlStream(InputStream xmlStream, OutputStream turtleStream) throws IOException, UcumException {
      var errorList = new ArrayList<ValidationMessage>();
      Element resourceElement = xmlParser.parseSingle(xmlStream, errorList);
      turtleParser.compose(resourceElement, turtleStream, OutputStyle.PRETTY, null);
      for (ValidationMessage message : errorList) {
        System.out.println(message.getDisplay());
      }
    }

    public String generateTurtleFromJsonResourcePath(Path jsonResourcePath, Path outputDirectory) throws IOException, UcumException {
      var turtleFilePath = outputDirectory.resolve(jsonResourcePath.getFileName().toString().replace(".json", ".ttl")).toString();
      try (
        InputStream inputJsonStream = ManagedFileAccess.inStream(jsonResourcePath.toString());
        OutputStream outputTurtleStream = ManagedFileAccess.outStream(turtleFilePath)
      ) {
        generateTurtleFromJsonStream(inputJsonStream, outputTurtleStream);
        return turtleFilePath;
      }
    }

    public void generateTurtleFromJsonStream(InputStream jsonStream, OutputStream turtleStream) throws IOException, UcumException {
      var errorList = new ArrayList<ValidationMessage>();
      Element resourceElement = jsonParser.parseSingle(jsonStream, errorList);
      turtleParser.compose(resourceElement, turtleStream, OutputStyle.PRETTY, null);
      for (ValidationMessage message : errorList) {
        System.out.println(message.getDisplay());
      }
    }

    public String generateTurtleStructureDefinitionFromProfileName(String profileName, Path outputTurtleDirectory) throws IOException, UcumException {
      String resourceUri = ProfileUtilities.sdNs(profileName, null);
      Resource resource = workerContext.fetchResource(Resource.class, resourceUri);
      Element resourceElement = resourceParser.parse(resource);
      var turtleFilePath = outputTurtleDirectory.resolve(profileName + ".ttl").toString();
      try (OutputStream outputStream = ManagedFileAccess.outStream(turtleFilePath)) {
        turtleParser.compose(resourceElement, outputStream, OutputStyle.PRETTY, null);
        return turtleFilePath;
      }
    }

    public ArrayList<String> generateTurtleFromMixedResourceDirectory(Path inputDirectory, Path outputDirectory) throws IOException, UcumException {
      var generatedPaths = new ArrayList<String>();
      var failures = new ArrayList<String>();
      try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(inputDirectory)) {
        for (Path path : dirStream) {
          if (path == null || Files.isDirectory(path)) continue;
          var fileName = path.getFileName().toString();
          try {
            if (fileName.endsWith(".xml")) {
              generatedPaths.add(generateTurtleFromXmlResourcePath(path, outputDirectory));
            } else if (fileName.endsWith(".json")) {
              generatedPaths.add(generateTurtleFromJsonResourcePath(path, outputDirectory));
            }
          } catch (Exception e) {
            System.out.println("Failed to generate Turtle for " + fileName + ": " + e.getMessage());
            failures.add(fileName + " | " + e.getMessage());
          }
        }
      }
      System.out.println("Turtle generation summary: success=" + generatedPaths.size() + ", failed=" + failures.size());
      for (String failure : failures) {
        System.out.println("  - " + failure);
      }
      return generatedPaths;
    }

  }

  
  // ---------------------------------------------------------------------------
  // Configuration helpers
  // ---------------------------------------------------------------------------
  
  /**
  * Reads an optional configured directory from local.properties, with a fallback and JVM override.
  */
  public static Path getConfiguredDirectory(Properties properties, String propertyName, Path fallback) {
    String propertyValue = properties.getProperty(propertyName);
    Path configuredPath = (propertyValue == null || propertyValue.isEmpty()) ? fallback : FileSystems.getDefault().getPath(propertyValue);
    return getOverrideDirectory(propertyName, configuredPath);
  }
  
  /**
  * Reads a per-test override from a JVM system property, falling back to the configured default.
  */
  public static Path getOverrideDirectory(String propertyName, Path fallback) {
    String override = System.getProperty(propertyName);
    return (override != null && !override.isEmpty()) ? FileSystems.getDefault().getPath(override) : fallback;
  }
  
  /**
  * Loads local.properties from src/test/resources/. Add overrides there (already in .gitignore).
  * Returns empty properties if the file does not exist.
  */
  public static Properties loadLocalProperties() {
    Properties properties = new Properties();
    String localPropertiesPath = FileSystems.getDefault().getPath(
      System.getProperty("user.dir"), "src", "test", "resources", "local.properties").toString();
      try (FileInputStream input = ManagedFileAccess.inStream(localPropertiesPath)) {
        properties.load(input);
      } catch (IOException e) {
        // local.properties is optional; use defaults if not present
      }
      return properties;
  }
    
  /**
  * Clones the default shared test context and overrides only its reported FHIR version.
  */
  public static IWorkerContext getVersionOverrideWorkerContext(String version) {
    try {
      var sourceVersion = TestingUtilities.DEFAULT_CONTEXT_VERSION;
      return new VersionOverrideWorkerContext(TestingUtilities.getSharedWorkerContext(sourceVersion)).overrideVersion(version);
    } catch (Exception e) {
      e.printStackTrace();
      throw new Error(e);
    }
  }
  
  /**
  * Test-only worker context wrapper used to force a specific version for parser selection.
  */
  public static class VersionOverrideWorkerContext extends SimpleWorkerContext {
    VersionOverrideWorkerContext(SimpleWorkerContext other) throws IOException, FHIRException {
      super(other);
    }
    
    /**
    * Updates the reported FHIR version and refreshes version-aware cached state.
    */
    IWorkerContext overrideVersion(String version) {
      this.version = version;
      finishLoading(false);
      return this;
    }
  }

}