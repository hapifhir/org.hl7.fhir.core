package org.hl7.fhir.utilities.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.hl7.fhir.utilities.tests.ResourceLoaderTests;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Isolated;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@Isolated
class FhirSettingsTests implements ResourceLoaderTests {

  private static String existingFhirSettingsPath;

  @BeforeAll
  static void beforeAll() {
    existingFhirSettingsPath = System.getProperty(FhirSettings.FHIR_SETTINGS_PATH);
    System.clearProperty(FhirSettings.FHIR_SETTINGS_PATH);
  }

  @AfterEach
  void afterEach() {
    System.clearProperty(FhirSettings.FHIR_SETTINGS_PATH);
  }

  @AfterAll
  static void afterAll() {
    if (existingFhirSettingsPath == null) {
      System.clearProperty(FhirSettings.FHIR_SETTINGS_PATH);
    } else {
      System.setProperty(FhirSettings.FHIR_SETTINGS_PATH, existingFhirSettingsPath);
    }
  }

  @Test
  void testDefaultFhirSettingsPath() throws IOException {
    String actualPath = FhirSettings.getSettingsFilePath(null);
    assertEquals(FhirSettings.getDefaultSettingsPath(), actualPath);
  }

  @Test
  void testJavaSystemPropertyFhirSettingsPath() {
    final String dummyPath = "dummy-path";
    System.setProperty(FhirSettings.FHIR_SETTINGS_PATH, dummyPath);
    String actualPath = FhirSettings.getSettingsFilePath(null);
    assertEquals(dummyPath, actualPath);
  }

  @Test
  void testExplicitSettingsPathSelected() {
    final String wrongDummyPath = "wrong-dummy-path";
    final String dummyPath = "dummy-path";
    System.setProperty(FhirSettings.FHIR_SETTINGS_PATH, wrongDummyPath);
    String actualPath = FhirSettings.getSettingsFilePath(dummyPath);
    assertEquals(dummyPath, actualPath);
  }

  @Test
  void testExplicitFhirSettingsPath() {
    final String dummyPath = "dummy-path";
    String actualPath = FhirSettings.getSettingsFilePath(dummyPath);
    assertEquals(dummyPath, actualPath);
  }

  @Test
  void testParseFhirSettings() throws IOException {
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

    assertTrue(fhirSettings.getIgnoreDefaultPackageServers());

    List<ServerDetailsPOJO> servers = fhirSettings.getServers();

    assertEquals(2, servers.size());

    assertEquals("http://dummy.org", servers.get(0).url);
    assertEquals("npm-package", servers.get(0).type);
    assertEquals("joe", servers.get(0).username);
    assertEquals("swordfish", servers.get(0).password);
    assertEquals("BASIC", servers.get(0).authenticationType);

    assertEquals("http://dummy2.com", servers.get(1).url);

  }

  @Test
  void testParseClientCredentialsSettings() throws IOException {
    Path path = Files.createTempFile("fhir-settings-cc", "json").toAbsolutePath();
    copyResourceToFile(path, "settings", "settings-client-credentials.json");

    FhirSettingsPOJO fhirSettings = FhirSettings.getFhirSettingsPOJO(path.toString());

    List<ServerDetailsPOJO> servers = fhirSettings.getServers();
    assertEquals(1, servers.size());

    ServerDetailsPOJO server = servers.get(0);
    assertEquals("https://tx.example.org/fhir", server.getUrl());
    assertEquals("fhir", server.getType());
    assertEquals("oauth_client_credentials", server.getAuthenticationType());
    assertEquals("my-client-id", server.getOauthClientCredentials().getClientId());
    assertEquals("my-client-secret", server.getOauthClientCredentials().getClientSecret());
    assertEquals("https://auth.example.org/token", server.getOauthClientCredentials().getTokenEndpoint());
    assertNull(FhirSettings.findClientCredentialsProblem(server));
    assertFalse(server.toString().contains("my-client-secret"), "the client secret must not appear in toString()");
  }

  @ParameterizedTest
  @CsvSource({
    "settings-client-credentials-missing-clientId.json, clientId",
    "settings-client-credentials-missing-clientSecret.json, clientSecret",
    "settings-client-credentials-missing-tokenEndpoint.json, tokenEndpoint",
    "settings-client-credentials-missing.json, clientSecret",
    "settings-client-credentials-missing-object.json, oauthClientCredentials",
    "settings-client-credentials-http-token-endpoint.json, https"
  })
  void testClientCredentialsProblemIsReportedButEntryKept(String resourceFile, String problem)
      throws IOException {
    Path path = Files.createTempFile("fhir-settings-cc-bad", "json").toAbsolutePath();
    copyResourceToFile(path, "settings", resourceFile);

    // An incomplete entry must not take the rest of the settings file down with it: throwing here
    // reaches FhirSettings.getInstance(), which substitutes empty settings for the whole JVM.
    FhirSettingsPOJO settings = FhirSettings.getFhirSettingsPOJO(path.toString());

    assertNotNull(settings, "settings should still load despite the invalid server entry");
    ServerDetailsPOJO server = settings.getServers().get(0);
    // Left as oauth_client_credentials so that it fails closed when used, rather than being
    // demoted to "none" and sent requests without credentials.
    assertEquals("oauth_client_credentials", server.getAuthenticationType());
    String reported = FhirSettings.findClientCredentialsProblem(server);
    assertNotNull(reported);
    assertTrue(reported.contains(problem), reported);
  }

  @Test
  void testInvalidClientCredentialsEntryDoesNotDiscardTheRestOfTheSettings() throws IOException {
    Path path = Files.createTempFile("fhir-settings-cc-mixed", "json").toAbsolutePath();
    copyResourceToFile(path, "settings", "settings-client-credentials-invalid-among-valid.json");

    FhirSettingsPOJO settings = FhirSettings.getFhirSettingsPOJO(path.toString());

    // Everything unrelated to the bad entry must survive
    assertEquals("/some/npm/path", settings.getNpmPath());
    assertEquals("an-api-key", settings.getApiKeys().get("example.org"));
    assertEquals(2, settings.getServers().size());

    // The incomplete entry is kept as configured, to fail closed when used
    assertEquals("oauth_client_credentials", settings.getServers().get(0).getAuthenticationType());
    assertEquals("token", settings.getServers().get(1).getAuthenticationType());
    assertEquals("a-valid-token", settings.getServers().get(1).getToken());
  }
}
