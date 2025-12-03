package org.hl7.fhir.validation.cli.picocli.options;

import org.hl7.fhir.validation.service.model.ValidationEngineParameters;

public class ValidationEngineOptionsConvertor {
  public ValidationEngineParameters convert(ValidationEngineOptions options) {
    ValidationEngineParameters validationEngineParameters = new ValidationEngineParameters();
    validationEngineParameters.setSv(options.fhirVersion);
    return validationEngineParameters;
  }
}
