package org.hl7.fhir.validation.service.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ValidationContextUtilitiesTests {

  @Test
  void testOnlyDirectIgDependenciesRoundTrip() {
    ValidationEngineParameters validationEngineParameters = new ValidationEngineParameters()
      .setRecursive(true)
      .setOnlyDirectIgDependencies(true)
      .addIg("hl7.fhir.us.core");

    ValidationContext validationContext = new ValidationContext();
    ValidationContextUtilities.addValidationEngineParameters(validationContext, validationEngineParameters);

    assertTrue(validationContext.isOnlyDirectIgDependencies());
    assertTrue(ValidationContextUtilities.getValidationEngineParameters(validationContext).isOnlyDirectIgDependencies());
  }
}
