package org.hl7.fhir.utilities.settings;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Slf4j
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
  private final FhirSettingsPOJO fhirSettingsPOJO;

  public static String getFilePath() {
    getInstance();
    return instance.filePath;
  }

  final String filePath;
  private FhirSettings(FhirSettingsPOJO fhirSettingsPOJO, String filePath) {

    this.fhirSettingsPOJO = fhirSettingsPOJO;
    this.filePath = filePath;
  }

  public static String getApiKey(String key) {
    getInstance();
    return instance.fhirSettingsPOJO.getApiKeys() != null
      ? instance.fhirSettingsPOJO.getApiKeys().get(key)
      : null;
  }

  public static boolean hasApiKey(String key) {
    getInstance();
    return instance.fhirSettingsPOJO.getApiKeys() != null && instance.fhirSettingsPOJO.getApiKeys().get(key) != null;
  }

  public static String getNpmPath() {
    getInstance();
    return instance.fhirSettingsPOJO.getNpmPath();
  }

  public static boolean hasNpmPath() {
    getInstance();
    return instance.fhirSettingsPOJO.getNpmPath() != null;
  }
  public static boolean hasRubyPath() {
    getInstance();
    return instance.fhirSettingsPOJO.getRubyPath() != null;
  }

  public static String getRubyPath() {
    getInstance();
    return instance.fhirSettingsPOJO.getRubyPath();
  }

  public static String getGemPath() {
    getInstance();
    return instance.fhirSettingsPOJO.getGemPath();
  }

  public static boolean hasFhirTestCasesPath() {
    getInstance();
    return instance.fhirSettingsPOJO.getFhirTestCasesPath() != null;
  }

  public static String getFhirTestCasesPath() {
    getInstance();
    return instance.fhirSettingsPOJO.getFhirTestCasesPath();
  }

  public static boolean hasDiffToolPath() {
    getInstance();
    return instance.fhirSettingsPOJO.getDiffToolPath() != null;
  }

  public static String getDiffToolPath() {
    getInstance();
    return instance.fhirSettingsPOJO.getDiffToolPath();
  }

  public static boolean hasTempPath() {
    getInstance();
    return instance.fhirSettingsPOJO.getTempPath() != null;
  }

  public static String getTempPath() {
    getInstance();
    return instance.fhirSettingsPOJO.getTempPath();
  }

  public static boolean hasTestIGsPath() {
    getInstance();
    return instance.fhirSettingsPOJO.getTestIgsPath() != null;
  }

  public static String getTestIgsPath() {
    getInstance();
    return instance.fhirSettingsPOJO.getTestIgsPath();
  }

  public static boolean hasProhibitNetworkAccess() {
    if (prohibitNetworkAccess != null) {
      return true;
    }
    getInstance();
    return instance.fhirSettingsPOJO.getProhibitNetworkAccess() != null;
  }

  public static boolean isProhibitNetworkAccess() {
    if (prohibitNetworkAccess != null) {
      return prohibitNetworkAccess;
    }
    getInstance();
    return instance.fhirSettingsPOJO.getProhibitNetworkAccess() != null && instance.fhirSettingsPOJO.getProhibitNetworkAccess();
  }


  /**
   * See ManagedWebAccess and use that to control network access
   * @deprecated 
   * @param value
   */
  @Deprecated(since="2025-06-20", forRemoval = true)
  public static void setProhibitNetworkAccess(boolean value) {
    prohibitNetworkAccess = value;
  }

  public static String getTxFhirProduction() {
    getInstance();
    return instance.fhirSettingsPOJO.getTxFhirProduction() == null
      ? FhirSettingsPOJO.TX_SERVER_PROD
      : instance.fhirSettingsPOJO.getTxFhirProduction();
  }

  public static String getTxFhirDevelopment() {
    getInstance();
    return instance.fhirSettingsPOJO.getTxFhirDevelopment() == null
      ? FhirSettingsPOJO.TX_SERVER_DEV
      : instance.fhirSettingsPOJO.getTxFhirDevelopment();
  }

  public static String getTxFhirLocal() {
    getInstance();
    return instance.fhirSettingsPOJO.getTxFhirLocal() == null
      ? FhirSettingsPOJO.TX_SERVER_LOCAL
      : instance.fhirSettingsPOJO.getTxFhirLocal();
  }
  
  private static FhirSettings instance = null;

  private static FhirSettings getInstance()  {
    if (instance == null) {
      try {
        instance = getInstanceFromPath(explicitFilePath);
      } catch (IOException e) {
        log.error("Unable to load FHIR settings from path:" + explicitFilePath + ". Loading default settings instead.", e);
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
    final File file = ManagedFileAccess.file(filePath);

    if (!file.exists()) {
      return new FhirSettingsPOJO();
    }

    final ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    final InputStream inputStream = ManagedFileAccess.inStream(file);
    return objectMapper.readValue(inputStream, FhirSettingsPOJO.class);
  }

  protected static String getDefaultSettingsPath() throws IOException {
    return Utilities.path(System.getProperty("user.home"), ".fhir", "fhir-settings.json");
  }

  public static boolean isIgnoreDefaultPackageServers() {
    getInstance();
    if (instance.fhirSettingsPOJO.getIgnoreDefaultPackageServers() == null) {
      return false;
    }
    return instance.fhirSettingsPOJO.getIgnoreDefaultPackageServers();
  }

  public static List<ServerDetailsPOJO> getServers() {
    getInstance();
    if (instance.fhirSettingsPOJO.getServers() == null) {
      return Collections.emptyList();
    }
    return Arrays.asList(instance.fhirSettingsPOJO.getServers().toArray(new ServerDetailsPOJO[]{}));
  }

  public static List<String> getCertificateSources() {
    getInstance();
    if (instance.fhirSettingsPOJO.getCertificateSources() == null) {
      return Collections.emptyList();
    }
    return instance.fhirSettingsPOJO.getCertificateSources();
  }
}
