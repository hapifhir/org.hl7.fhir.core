package org.hl7.fhir.validation.http;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.hl7.fhir.services.validation.constants.IdStatus;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * checkDisplay on /validateResource never had any effect. It's deprecated: accepted and ignored, so that existing
 * clients don't start getting a 400
 */
class CheckDisplayParamTests {

  private final ValidateResourceHTTPHandler handler = new ValidateResourceHTTPHandler(null, null);

  @ParameterizedTest
  @ValueSource(strings = {"Ignore", "Check", "CheckCaseAndSpace", "INVALID", ""})
  void checkDisplayIsAcceptedAndIgnored(String value) {
    InstanceValidatorParameters params = handler.getInstanceValidatorParameters("resourceIdRule=required&checkDisplay=" + value);
    assertEquals(new InstanceValidatorParameters().setResourceIdRule(IdStatus.REQUIRED), params);
  }

  @Test
  void anUnknownParameterIsStillAnError() {
    assertThrows(IllegalArgumentException.class, () -> handler.getInstanceValidatorParameters("checkDisplayy=Check"));
  }
}
