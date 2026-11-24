package org.hl7.fhir.validation.instance.type;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.model.utilities.formats.FhirFormat;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.instance.InstanceValidator;
import org.hl7.fhir.validation.tests.utilities.TestUtilities;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ParametersValidatorTests {

  private static ValidationEngine engine;
  private static InstanceValidator validator;

  @BeforeAll
  static void setUpAll() throws Exception {
    engine = TestUtilities.getValidationEngineNoTxServer("hl7.fhir.r5.core#5.0.0", "5.0.0");
    validator = engine.getValidator(FhirFormat.JSON);
  }

  @AfterAll
  static void tearDownAll() {
    // Release the per-class engine so it does not stay resident for the rest of the module's test
    // JVM.
    validator = null;
    engine = null;
    System.gc();
  }

  // Parameters.parameter.name is 1..1. A parameter without a name used to make the validator throw a
  // NullPointerException (null key in an immutable Map lookup) instead of reporting the missing element.
  @Test
  void parameterWithoutNameReportsCardinalityInsteadOfThrowing() {
    String json = "{ \"resourceType\": \"Parameters\", \"parameter\": [ { \"valueString\": \"x\" } ] }";
    List<ValidationMessage> messages = new ArrayList<>();
    assertDoesNotThrow(() -> validator.validate(null, messages,
        new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8)), FhirFormat.JSON));
    assertTrue(messages.stream().anyMatch(m -> m.getLevel() == IssueSeverity.ERROR
        && I18nConstants.VALIDATION_VAL_PROFILE_MINIMUM.equals(m.getMessageId())
        && m.getLocation().startsWith("Parameters.parameter[0]")
        && m.getMessage().contains("Parameters.parameter.name")),
        "expected a cardinality error on Parameters.parameter.name but got: " + messages);
  }
}
