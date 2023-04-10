package org.hl7.fhir.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FhirSettings {


  final FhirSettingsPOJO fhirSettings;

  private FhirSettings(FhirSettingsPOJO fhirSettings) {
    this.fhirSettings = fhirSettings;
  }

  public String getApiKey() {
    return fhirSettings.getApiKey();
  }

  public boolean hasApiKey() {
    return fhirSettings.getApiKey() != null;
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

  public boolean hasDiffPath() {
    return fhirSettings.getDiffToolPath() != null;
  }

  public String getDiffPath() {
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
        instance = getInstanceFromPath(null);
      } catch (IOException e) {
        e.printStackTrace();
        instance = new FhirSettings(new FhirSettingsPOJO());
      }
    }
    return instance;
  }

  public static FhirSettings getInstance(String explicitFilePath) throws IOException {
    if (explicitFilePath == null) {
      return getInstance();
    }
    return getInstanceFromPath(explicitFilePath);
  }

  private static FhirSettings getInstanceFromPath(String explicitFilePath) throws IOException {
      String pathFromSystemProperties;
      try {
        pathFromSystemProperties = getDefaultSettingsPath();
      } catch (IOException e) {
        pathFromSystemProperties = null;
      }
      final String filePath = explicitFilePath != null ? explicitFilePath :
        System.getProperty("fhir.settings.path", pathFromSystemProperties);
    return new FhirSettings(getFhirSettingsPOJO(filePath));
  }

  private static FhirSettingsPOJO getFhirSettingsPOJO(String filePath) throws IOException {
    final File file = new File(filePath);

    if (!file.exists()) {
      return new FhirSettingsPOJO();
    }

    final ObjectMapper objectMapper = new ObjectMapper();
    final InputStream inputStream = new FileInputStream(file);
    final FhirSettingsPOJO output = objectMapper.readValue(inputStream, FhirSettingsPOJO.class);

    return output;
  }

  private static String getDefaultSettingsPath() throws IOException {
    return Utilities.path(System.getProperty("user.home"), "fhir-settings.json");
  }
}
