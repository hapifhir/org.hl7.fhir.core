package org.hl7.fhir.validation.cli.picocli.options;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.http.ManagedWebAccess;
import org.hl7.fhir.utilities.settings.FhirSettings;
import picocli.CommandLine;

import java.io.IOException;

@Slf4j
public class FHIRSettingsOptions implements GlobalOptions {
  private static final String FHIR_SETTINGS = "-fhir-settings";
  @CommandLine.Option(names = (FHIR_SETTINGS))
  public String fhirSettingsFile;

  @Override
  public int apply(CommandLine.ParseResult parseResult) {
    final String fhirSettingsFilePath = parseResult.matchedOptionValue(FHIR_SETTINGS, null);

    if (fhirSettingsFilePath != null) {
      try {
        if (!ManagedFileAccess.file(fhirSettingsFilePath).exists()) {
          log.error("Cannot find fhir-settings file: " + fhirSettingsFilePath);
          return 1;
        }
      } catch (IOException e) {
        log.error("Error reading fhir-settings file: " + fhirSettingsFilePath);
        return 1;
      }
      FhirSettings.setExplicitFilePath(fhirSettingsFilePath);
    }
    ManagedWebAccess.loadFromFHIRSettings();
    return 0;
  }
}
