package org.hl7.fhir.validation.cli.picocli.options;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.http.ManagedWebAccess;
import org.hl7.fhir.utilities.settings.FhirSettings;
import picocli.CommandLine;

import java.io.IOException;

@Slf4j
public class FHIRSettingsOptions {
  private static final String FHIR_SETTINGS = "-fhir-settings";



  @CommandLine.Option(names = (FHIR_SETTINGS) , scope = CommandLine.ScopeType.INHERIT)
  public void setFhirSettingsFile(String fhirSettingsFilePath) {
    if (fhirSettingsFilePath != null) {
      try {
        if (!ManagedFileAccess.file(fhirSettingsFilePath).exists()) {
          throw new IllegalArgumentException("Cannot find fhir-settings file: " + fhirSettingsFilePath);
        }
      } catch (IOException e) {
        throw new IllegalArgumentException("Error reading fhir-settings file: " + fhirSettingsFilePath);
      }
      FhirSettings.setExplicitFilePath(fhirSettingsFilePath);
    }
    ManagedWebAccess.loadFromFHIRSettings();
  }
}
