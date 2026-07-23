package org.hl7.fhir.validation.cli.picocli.options;

import lombok.AllArgsConstructor;
import lombok.With;
import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.settings.FhirSettings;
import picocli.CommandLine;

import java.io.IOException;

import static org.hl7.fhir.validation.cli.picocli.options.OptionConstants.FHIR_SETTINGS_DOCS_WEB_ADDRESS;

@Slf4j
@AllArgsConstructor
public class FHIRSettingsOptions {

  @CommandLine.Option(names = ("-fhir-settings"),
    scope = CommandLine.ScopeType.INHERIT,
  description = "the location of the fhir-settings.json file. This contains global settings used throughout the validator. Documentation on fhir-settings.json is available at: " + FHIR_SETTINGS_DOCS_WEB_ADDRESS)
  @With
  public String fhirSettingsFilePath = null;

  public void applyOptions() {
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
  }

  public FHIRSettingsOptions() {
    // All public fields should be set in their declaration for Picocli purposes, so we do nothing here.
  }
}
