package org.hl7.fhir.utilities.settings;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.hl7.fhir.utilities.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;



public class FhirSettings {

  public static final String FHIR_SETTINGS_PATH = "fhir.settings.path";
  private static String explicitFilePath = null;

  public static void setExplicitFilePath(String explicitFilePath) {
    if (instance != null) {
      throw new IllegalStateException("Attempted to set explicitFilePath after FhirSettings has already been initialized with path: " + instance.filePath);
    }
    if (FhirSettings.explicitFilePath != null) {
      throw new IllegalStateException("Attempted to set explicitFilePath to " + explicitFilePath + " when already set to " + FhirSettings.explicitFilePath);
    }
    FhirSettings.explicitFilePath = explicitFilePath;
  }
  private final FhirSettingsPOJO fhirSettings;

  @Getter
  final String filePath;
  private FhirSettings(FhirSettingsPOJO fhirSettings, String filePath) {

    this.fhirSettings = fhirSettings;
    this.filePath = filePath;
  }

  public String getApiKey(String key) {
    return fhirSettings.getApiKeys() != null
      ? fhirSettings.getApiKeys().get(key)
      : null;
  }

  public boolean hasApiKey(String key) {
    return fhirSettings.getApiKeys() != null
      ? fhirSettings.getApiKeys().get(key) != null
      : null;
  }

  public String getNpmPath() {
    return fhirSettings.getNpmPath();
  }

  public boolean hasNpmPath() {
    return fhirSettings.getNpmPath() != null;
  }
  public boolean hasRubyPath() {
    return fhirSettings.getRubyPath() != null;
  }

  public String getRubyPath() {
    return fhirSettings.getRubyPath();
  }

  public boolean hasFhirTestCasesPath() {
    return fhirSettings.getFhirTestCasesPath() != null;
  }

  public String getFhirTestCasesPath() {
    return fhirSettings.getFhirTestCasesPath();
  }

  public boolean hasDiffToolPath() {
    return fhirSettings.getDiffToolPath() != null;
  }

  public String getDiffToolPath() {
    return fhirSettings.getDiffToolPath();
  }

  public boolean hasTempPath() {
    return fhirSettings.getTempPath() != null;
  }

  public String getTempPath() {
    return fhirSettings.getTempPath();
  }

  public boolean hasTestIGsPath() {
    return fhirSettings.getTestIgsPath() != null;
  }

  public String getTestIgsPath() {
    return fhirSettings.getTestIgsPath();
  }

  private static FhirSettings instance = null;

  public static FhirSettings getInstance()  {
    if (instance == null) {
      try {
        instance = getInstanceFromPath(explicitFilePath);
      } catch (IOException e) {
        e.printStackTrace();
        instance = new FhirSettings(new FhirSettingsPOJO(), null);
      }
    }
    return instance;
  }

  protected static FhirSettings getInstanceFromPath(String explicitFilePath) throws IOException {
    final String filePath;
    filePath = getSettingsFilePath(explicitFilePath);
    return new FhirSettings(getFhirSettingsPOJO(filePath), filePath);
  }

  protected static String getSettingsFilePath(String explicitFilePath) {
    final String filePath;
    String pathFromSystemProperties;
    try {
      pathFromSystemProperties = getDefaultSettingsPath();
    } catch (IOException e) {
      pathFromSystemProperties = null;
    }
    filePath = explicitFilePath != null ? explicitFilePath :
      System.getProperty(FHIR_SETTINGS_PATH, pathFromSystemProperties);
    return filePath;
  }

  private static FhirSettingsPOJO getFhirSettingsPOJO(String filePath) throws IOException {
    final File file = new File(filePath);

    if (!file.exists()) {
      return new FhirSettingsPOJO();
    }

    final ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    final InputStream inputStream = new FileInputStream(file);
    final FhirSettingsPOJO output = objectMapper.readValue(inputStream, FhirSettingsPOJO.class);

    return output;
  }

  protected static String getDefaultSettingsPath() throws IOException {
    return Utilities.path(System.getProperty("user.home"), ".fhir", "fhir-settings.json");
  }
}
