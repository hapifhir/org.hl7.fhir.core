package org.hl7.fhir.context;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Coding;
import org.hl7.fhir.services.terminology.CodingValidationRequest;
import org.hl7.fhir.model.core.ValueSet;
import org.hl7.fhir.services.terminology.ValidationResult;
import org.hl7.fhir.standalone.context.SimpleWorkerContext;
import org.hl7.fhir.standalone.terminology.validation.ValueSetValidator;
import org.hl7.fhir.standalone.terminology.validation.VSCheckerException;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.hl7.fhir.services.terminology.ValidationContextCarrier;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * R6 counterpart of the org.hl7.fhir.r5 test of the same name.
 * A code in a batch whose local check fails gets the answer validateCode() gives it. If that fails too, the code
 * still gets an answer (an error), and so do the rest of the codes in the batch
 */
class ValidateCodeBatchFallbackTests {

  @ParameterizedTest
  @ValueSource(booleans = {true, false})
  void everyCodeGetsAnAnswerWhenTheFallbackFails(boolean checkerException) throws Exception {
    SimpleWorkerContext ctxt = new SimpleWorkerContext(TestingUtilities.getSharedWorkerContext()) {
      @Override
      public ValueSetValidator constructValueSetCheckerSimple(ValidationOptions options, ValueSet vs) {
        throw checkerException ? new VSCheckerException("local check failed", null) : new FHIRException("local check failed");
      }

      @Override
      public ValidationResult validateCode(ValidationOptions options, String path, Coding code, ValueSet vs, ValidationContextCarrier ctxt) {
        throw new FHIRException("fallback failed for " + code.getCode());
      }
    };
    List<CodingValidationRequest> batch = List.of(
      new CodingValidationRequest(new Coding("http://example.org/cs", "a", null)),
      new CodingValidationRequest(new Coding("http://example.org/cs", "b", null)));

    // no server, so the local answer is the answer
    ctxt.validateCodeBatch(ValidationOptions.defaults().withNoServer(), batch, null, false);

    for (CodingValidationRequest t : batch) {
      ValidationResult res = t.getResult();
      assertNotNull(res, t.getCoding().getCode());
      assertEquals(IssueSeverity.ERROR, res.getSeverity());
      assertEquals("fallback failed for " + t.getCoding().getCode(), res.getMessage());
      assertTrue(res.getDiagnostics().contains("local check failed"), res.getDiagnostics());
    }
  }
}
