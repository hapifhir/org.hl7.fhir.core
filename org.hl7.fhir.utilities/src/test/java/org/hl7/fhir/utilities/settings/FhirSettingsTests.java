package org.hl7.fhir.utilities.settings;

import org.hl7.fhir.utilities.tests.ResourceLoaderTests;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Isolated;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Isolated
public class FhirSettingsTests implements ResourceLoaderTests {

  private static String existingFhirSettingsPath;

  @BeforeAll
  public static void beforeAll() {
    existingFhirSettingsPath = System.getProperty(FhirSettings.FHIR_SETTINGS_PATH);
    System.clearProperty(FhirSettings.FHIR_SETTINGS_PATH);
  }

  @AfterEach
  public void afterEach() {
    System.clearProperty(FhirSettings.FHIR_SETTINGS_PATH);
  }

  @AfterAll
  public static void afterAll() {
    if (existingFhirSettingsPath == null) {
      System.clearProperty(FhirSettings.FHIR_SETTINGS_PATH);
    } else {
      System.setProperty(FhirSettings.FHIR_SETTINGS_PATH, existingFhirSettingsPath);
    }
  }

  @Test
  public void testDefaultFhirSettingsPath() throws IOException {
    String actualPath = FhirSettings.getSettingsFilePath(null);
    assertEquals(FhirSettings.getDefaultSettingsPath(), actualPath);
  }

  @Test
  public void testJavaSystemParameterFhirSettingsPath() throws IOException {
    final String dummyPath = "dummy-path";
    System.setProperty(FhirSettings.FHIR_SETTINGS_PATH, dummyPath);
    String actualPath = FhirSettings.getSettingsFilePath(null);
    assertEquals(dummyPath, actualPath);
  }

  @Test
  public void testExplicitFhirSettingsPath() throws IOException {
    final String dummyPath = "dummy-path";
    String actualPath = FhirSettings.getSettingsFilePath(dummyPath);
    assertEquals(dummyPath, actualPath);
  }

  @Test
  public void testParseFhirSettings() throws IOException {
    Path path = Files.createTempFile("fhir-settings", "json").toAbsolutePath();
    copyResourceToFile(path, "settings", "settings-example.json");

    FhirSettings fhirSettings = FhirSettings.getInstanceFromPath(path.toString());

   assertEquals(path.toString(), fhirSettings.filePath);

   assertTrue(fhirSettings.hasNpmPath());
   assertEquals("dummy-npm-path", fhirSettings.getNpmPath());
   assertTrue(fhirSettings.hasRubyPath());
   assertEquals("dummy-ruby-path", fhirSettings.getRubyPath());
    assertTrue(fhirSettings.hasApiKey("dummy-api-key"));
    assertEquals("dummy-api-key-value", fhirSettings.getApiKey("dummy-api-key"));
    assertTrue(fhirSettings.hasFhirTestCasesPath());
    assertEquals("dummy-fhir-test-cases-path", fhirSettings.getFhirTestCasesPath());
    assertTrue(fhirSettings.hasDiffToolPath());
    assertEquals("dummy-diff-tool-path", fhirSettings.getDiffToolPath());
    assertTrue(fhirSettings.hasTempPath());
    assertEquals("dummy-temp-path", fhirSettings.getTempPath());
    assertTrue(fhirSettings.hasTestIGsPath());
    assertEquals("dummy-test-igs-path", fhirSettings.getTestIgsPath());
  }
}
