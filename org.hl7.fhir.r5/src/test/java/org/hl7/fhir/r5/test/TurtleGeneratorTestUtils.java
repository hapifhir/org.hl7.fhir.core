package org.hl7.fhir.r5.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.google.gson.JsonElement;
import org.fhir.ucum.UcumException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.JsonParser;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.elementmodel.ParserBase;
import org.hl7.fhir.r5.elementmodel.ResourceParser;
import org.hl7.fhir.r5.elementmodel.TurtleParser;
import org.hl7.fhir.r5.elementmodel.TurtleParserBase;
import org.hl7.fhir.r5.elementmodel.XmlParser;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.turtle.Turtle;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.junit.jupiter.api.Assertions;

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

    public void setDeriveConceptIriFromNamingSystem(boolean deriveConceptIriFromNamingSystem) {
      turtleParser.setDeriveConceptIriFromNamingSystem(deriveConceptIriFromNamingSystem);
    }

    public void setCanonicalizeXhtml(boolean canonicalizeXhtml) {
      turtleParser.setCanonicalizeXhtml(canonicalizeXhtml);
    }

    public void setConceptIriHandling(TurtleParserBase.ConceptIriHandling conceptIriHandling) {
      turtleParser.setConceptIriHandling(conceptIriHandling);
    }
    
    public String getFhirVersion() {
      return workerContext.getVersion();
    }

    public Element parseResource(InputStream stream, FhirFormat format) throws IOException {
      return parseResource(parserFor(format), stream, format);
    }

    public Element parseStrictResource(InputStream stream, FhirFormat format) throws IOException {
      ParserBase parser = Manager.makeParser(workerContext, format);
      parser.setupValidation(ParserBase.ValidationPolicy.EVERYTHING);
      if (parser instanceof TurtleParser) {
        ((TurtleParser) parser).setConceptIriHandling(turtleParser.getConceptIriHandling());
      }
      return parseResource(parser, stream, format);
    }

    private Element parseResource(ParserBase parser, InputStream stream, FhirFormat format) throws IOException {
      var errors = new ArrayList<ValidationMessage>();
      Element resource = parser.parseSingle(stream, errors);
      if (resource == null || errors.stream().anyMatch(message -> message.getLevel() == ValidationMessage.IssueSeverity.ERROR
          || message.getLevel() == ValidationMessage.IssueSeverity.FATAL)) {
        throw new IOException("Unable to parse " + format + ": " + errors);
      }
      return resource;
    }

    public void composeResource(Element resource, OutputStream stream, FhirFormat format) throws IOException {
      parserFor(format).compose(resource, stream, OutputStyle.PRETTY, null);
    }

    /** Parses with {@link #parseStrictResource}. */
    public Element parse(String source, FhirFormat format) throws IOException {
      return parseStrictResource(new ByteArrayInputStream(source.getBytes(StandardCharsets.UTF_8)), format);
    }

    public String compose(Element resource, FhirFormat format) throws IOException {
      ByteArrayOutputStream output = new ByteArrayOutputStream();
      composeResource(resource, output, format);
      return output.toString(StandardCharsets.UTF_8);
    }

    private ParserBase parserFor(FhirFormat format) {
      switch (format) {
      case JSON: return jsonParser;
      case XML: return xmlParser;
      case TURTLE: return turtleParser;
      default: throw new IllegalArgumentException("Unsupported Turtle test format: " + format);
      }
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
        generateTurtleFromXmlStream(inputXmlStream, outputTurtleStream);
        return turtleFilePath;
      }
    }

    public void generateTurtleFromXmlStream(InputStream xmlStream, OutputStream turtleStream) throws IOException, UcumException {
      Element resourceElement;
      try {
        resourceElement = parseXmlResource(xmlStream);
      } catch (Exception ex) {
        System.out.println("Unable to parse XML -- not relevant for Turtle generation");
        return;
      }
      composeResource(resourceElement, turtleStream, FhirFormat.TURTLE);
    }

    public Turtle composeTurtleFromXmlResourcePath(Path xmlResourcePath) throws IOException, UcumException {
      try (InputStream inputXmlStream = ManagedFileAccess.inStream(xmlResourcePath.toString())) {
        Element resourceElement = parseXmlResource(inputXmlStream);
        Turtle ttl = new Turtle();
        turtleParser.compose(resourceElement, ttl, "");
        return ttl;
      }
    }

    private Element parseXmlResource(InputStream xmlStream) throws IOException, FHIRException {
      var errorList = new ArrayList<ValidationMessage>();
      Element resourceElement = xmlParser.parseSingle(xmlStream, errorList);
      printValidationMessages(errorList);
      return resourceElement;
    }

    private void printValidationMessages(List<ValidationMessage> errorList) {
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
        System.out.println("Generating " + turtleFilePath);
        generateTurtleFromJsonStream(inputJsonStream, outputTurtleStream);
        return turtleFilePath;
      }
    }

    public void generateTurtleFromJsonStream(InputStream jsonStream, OutputStream turtleStream) throws IOException, UcumException {
      var errorList = new ArrayList<ValidationMessage>();
      Element resourceElement = jsonParser.parseSingle(jsonStream, errorList);
      composeResource(resourceElement, turtleStream, FhirFormat.TURTLE);
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
        composeResource(resourceElement, outputStream, FhirFormat.TURTLE);
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

  public static Path getResourcePath(Path resourcePath) throws IOException {
    String resourceName = resourcePath.toString().replace('\\', '/');
    URL resourceUrl = TurtleGeneratorTestUtils.class.getClassLoader().getResource(resourceName);
    if (resourceUrl == null) {
      throw new IOException("Missing test resource path: " + resourceName);
    }
    try {
      return Path.of(resourceUrl.toURI());
    } catch (URISyntaxException e) {
      throw new IOException("Invalid test resource URI for " + resourceName, e);
    }
  }
  
  /**
  * Loads local.properties from src/test/resources/. Add overrides there (already in .gitignore).
  * Returns empty properties if the file does not exist.
  */
  public static Properties loadLocalProperties() {
    Properties properties = new Properties();
      try (InputStream input = TurtleGeneratorTestUtils.class.getClassLoader().getResourceAsStream("local.properties")) {
        if (input == null) {
          return properties;
        }
        properties.load(input);
      } catch (IOException e) {
        // local.properties is optional; use defaults if not present
      }
      return properties;
  }
    
  /**
  * Compares JSON ignoring object key order, but not array order, primitive kinds or numeric value.
  */
  public static void assertJsonEquals(JsonElement expected, JsonElement actual) {
    assertJsonEquals(expected, actual, "$");
  }

  private static void assertJsonEquals(JsonElement expected, JsonElement actual, String path) {
    if (expected.isJsonObject()) {
      Assertions.assertTrue(actual.isJsonObject(), path);
      Assertions.assertEquals(expected.getAsJsonObject().keySet(), actual.getAsJsonObject().keySet(), path);
      for (String key : expected.getAsJsonObject().keySet()) {
        assertJsonEquals(expected.getAsJsonObject().get(key), actual.getAsJsonObject().get(key), path + "." + key);
      }
    } else if (expected.isJsonArray()) {
      Assertions.assertTrue(actual.isJsonArray(), path);
      Assertions.assertEquals(expected.getAsJsonArray().size(), actual.getAsJsonArray().size(), path);
      for (int index = 0; index < expected.getAsJsonArray().size(); index++) {
        assertJsonEquals(expected.getAsJsonArray().get(index), actual.getAsJsonArray().get(index), path + "[" + index + "]");
      }
    } else if (expected.isJsonPrimitive()) {
      Assertions.assertTrue(actual.isJsonPrimitive(), path);
      var expectedValue = expected.getAsJsonPrimitive();
      var actualValue = actual.getAsJsonPrimitive();
      Assertions.assertEquals(expectedValue.isNumber(), actualValue.isNumber(), path);
      Assertions.assertEquals(expectedValue.isBoolean(), actualValue.isBoolean(), path);
      Assertions.assertEquals(expectedValue.isString(), actualValue.isString(), path);
      if (expectedValue.isNumber()) {
        Assertions.assertEquals(0, expectedValue.getAsBigDecimal().compareTo(actualValue.getAsBigDecimal()), path);
      } else {
        Assertions.assertEquals(expectedValue, actualValue, path);
      }
    } else {
      Assertions.assertEquals(expected, actual, path);
    }
  }

  /**
  * Clones the default shared test context and overrides only its reported FHIR version.
  */
  public static IWorkerContext getVersionOverrideWorkerContext(String version) {
    try {
      String sourceVersion = TestingUtilities.DEFAULT_CONTEXT_VERSION;
      // Use a fresh base context so finishLoading() can't pin versions onto the singleton shared test resources used by later tests.
      return new VersionOverrideWorkerContext(TestingUtilities.getWorkerContext(sourceVersion)).overrideVersion(version);
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