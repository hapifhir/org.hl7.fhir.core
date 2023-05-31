package org.hl7.fhir.utilities.settings;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.npm.PackageServer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;


public class FhirSettings {

  
  public static final String FHIR_SETTINGS_PATH = "fhir.settings.path";
  private static String explicitFilePath = null;
  private static Boolean prohibitNetworkAccess;

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

  public static String getFilePath() {
    getInstance();
    return instance.filePath;
  }

  final String filePath;
  private FhirSettings(FhirSettingsPOJO fhirSettings, String filePath) {

    this.fhirSettings = fhirSettings;
    this.filePath = filePath;
  }

  public static String getApiKey(String key) {
    getInstance();
    return instance.fhirSettings.getApiKeys() != null
      ? instance.fhirSettings.getApiKeys().get(key)
      : null;
  }

  public static boolean hasApiKey(String key) {
    getInstance();
    return instance.fhirSettings.getApiKeys() != null
      ? instance.fhirSettings.getApiKeys().get(key) != null
      : false;
  }

  public static String getNpmPath() {
    getInstance();
    return instance.fhirSettings.getNpmPath();
  }

  public static boolean hasNpmPath() {
    getInstance();
    return instance.fhirSettings.getNpmPath() != null;
  }
  public static boolean hasRubyPath() {
    getInstance();
    return instance.fhirSettings.getRubyPath() != null;
  }

  public static String getRubyPath() {
    getInstance();
    return instance.fhirSettings.getRubyPath();
  }

  public static boolean hasFhirTestCasesPath() {
    getInstance();
    return instance.fhirSettings.getFhirTestCasesPath() != null;
  }

  public static String getFhirTestCasesPath() {
    getInstance();
    return instance.fhirSettings.getFhirTestCasesPath();
  }

  public static boolean hasDiffToolPath() {
    getInstance();
    return instance.fhirSettings.getDiffToolPath() != null;
  }

  public static String getDiffToolPath() {
    getInstance();
    return instance.fhirSettings.getDiffToolPath();
  }

  public static boolean hasTempPath() {
    getInstance();
    return instance.fhirSettings.getTempPath() != null;
  }

  public static String getTempPath() {
    getInstance();
    return instance.fhirSettings.getTempPath();
  }

  public static boolean hasTestIGsPath() {
    getInstance();
    return instance.fhirSettings.getTestIgsPath() != null;
  }

  public static String getTestIgsPath() {
    getInstance();
    return instance.fhirSettings.getTestIgsPath();
  }

  public static boolean hasProhibitNetworkAccess() {
    if (prohibitNetworkAccess != null) {
      return true;
    }
    getInstance();
    return instance.fhirSettings.getProhibitNetworkAccess() != null; 
  }

  public static boolean isProhibitNetworkAccess() {
    if (prohibitNetworkAccess != null) {
      return prohibitNetworkAccess;
    }
    getInstance();
    return instance.fhirSettings.getProhibitNetworkAccess() == null
      ? false
      : instance.fhirSettings.getProhibitNetworkAccess(); 
  }
  
  public static void setProhibitNetworkAccess(boolean value) {
    prohibitNetworkAccess = value;
  }


  public static String getTxFhirProduction() {
    getInstance();
    return instance.fhirSettings.getTxFhirProduction() == null
      ? FhirSettingsPOJO.TX_SERVER_PROD
      : instance.fhirSettings.getTxFhirProduction(); 
  }

  public static String getTxFhirDevelopment() {
    getInstance();
    return instance.fhirSettings.getTxFhirDevelopment() == null
      ? FhirSettingsPOJO.TX_SERVER_DEV
      : instance.fhirSettings.getTxFhirDevelopment();
  }

  public static String getTxFhirLocal() {
    getInstance();
    return instance.fhirSettings.getTxFhirLocal() == null
      ? FhirSettingsPOJO.TX_SERVER_LOCAL
      : instance.fhirSettings.getTxFhirLocal();
  }
  
  private static FhirSettings instance = null;

  private static FhirSettings getInstance()  {
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

  static FhirSettingsPOJO getFhirSettingsPOJO(String filePath) throws IOException {
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

  public static List<PackageServerPOJO> getPackageServers() {
    getInstance();
    return List.of(instance.fhirSettings.getPackageServers().toArray(new PackageServerPOJO[]{}));
  }
}
