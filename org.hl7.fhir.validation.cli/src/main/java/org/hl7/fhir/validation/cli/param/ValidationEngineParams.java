package org.hl7.fhir.validation.cli.param;

import org.hl7.fhir.validation.service.model.ValidationEngineSettings;

public class ValidationEngineParams {

  public static ValidationEngineSettings getValidationEngineSettingsFromArgs(String[] args) {
    ValidationEngineSettings validationEngineSettings = new ValidationEngineSettings();

    for (int i = 0; i < args.length; i++) {
      if (args[i].equals(Params.NATIVE)) {
        validationEngineSettings.setDoNative(true);
      }
    }

    return validationEngineSettings;
  }
}
