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
import java.util.List;

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
  public void testJavaSystemPropertyFhirSettingsPath() throws IOException {
    final String dummyPath = "dummy-path";
    System.setProperty(FhirSettings.FHIR_SETTINGS_PATH, dummyPath);
    String actualPath = FhirSettings.getSettingsFilePath(null);
    assertEquals(dummyPath, actualPath);
  }

  @Test
  public void testExplicitSettingsPathSelected() throws IOException {
    final String wrongDummyPath = "wrong-dummy-path";
    final String dummyPath = "dummy-path";
    System.setProperty(FhirSettings.FHIR_SETTINGS_PATH, wrongDummyPath);
    String actualPath = FhirSettings.getSettingsFilePath(dummyPath);
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

    FhirSettingsPOJO fhirSettings = FhirSettings.getFhirSettingsPOJO(path.toString());

   assertEquals("dummy-npm-path", fhirSettings.getNpmPath());
   assertEquals("dummy-ruby-path", fhirSettings.getRubyPath());
    assertEquals("dummy-api-key-value", fhirSettings.getApiKeys().get("dummy-api-key"));
    assertEquals("dummy-fhir-test-cases-path", fhirSettings.getFhirTestCasesPath());
    assertEquals("dummy-diff-tool-path", fhirSettings.getDiffToolPath());
    assertEquals("dummy-temp-path", fhirSettings.getTempPath());
    assertEquals("dummy-test-igs-path", fhirSettings.getTestIgsPath());

    List<PackageServerPOJO> packageServers = fhirSettings.getPackageServers();

    assertEquals(2, packageServers.size());

    assertEquals("http://dummy.org", packageServers.get(0).url);
    assertEquals("joe", packageServers.get(0).username);
    assertEquals("swordfish", packageServers.get(0).password);
    assertEquals("BASIC", packageServers.get(0).authenticationType);

    assertEquals("http://dummy2.com", packageServers.get(1).url);

  }
}
