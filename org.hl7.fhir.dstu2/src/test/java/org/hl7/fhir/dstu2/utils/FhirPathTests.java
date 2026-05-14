package org.hl7.fhir.dstu2.utils;

import org.hl7.fhir.dstu2.model.Patient;
import org.hl7.fhir.dstu2.model.Questionnaire;
import org.hl7.fhir.exceptions.FHIRException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FhirPathTests {

  @Mock
  IWorkerContext iWorkerContext;

  @ParameterizedTest
  @CsvSource({
    "1, true",
    "2, true",
    "3, false",
    "4, false"})
  void testExecutionLimitExceededThrowsException(int maxCalls, boolean shouldThrow) {
    FHIRPathEngine engine = new FHIRPathEngine(iWorkerContext);
    Patient input = new Patient();
    input.addName().addGiven("John");
    engine.setExecutionMaxCalls(maxCalls);
    try {
      if (shouldThrow) {
        Assertions.assertThrows(FHIRException.class, () -> engine.evaluate(input, "Patient.name.given"));
      } else {
        Assertions.assertDoesNotThrow(() -> engine.evaluate(input, "Patient.name.given"));
      }
    } finally {
      engine.setExecutionMaxCalls(FHIRPathEngine.DEFAULT_EXECUTION_MAX_CALLS);
    }
  }

  @ParameterizedTest
  @CsvSource({
    "1, true",
    "2, true",
    "3, false",
    "4, false"})
  void testRepeatMaxIterationsExceededThrowsException(int maxIterations, boolean shouldThrow) {
    FHIRPathEngine engine = new FHIRPathEngine(iWorkerContext);
    Questionnaire input = new Questionnaire();
    Questionnaire.GroupComponent mainGroup = input.getGroup();
    mainGroup.setLinkId("main");
    mainGroup.addGroup().setLinkId("subgroup1");
    mainGroup.addGroup().setLinkId("subgroup2");
    engine.setRepeatMaxIterations(maxIterations);
    try {
      if (shouldThrow) {
        Assertions.assertThrows(FHIRException.class, () -> engine.evaluate(input, "Questionnaire.repeat(group)"));
      } else {
        Assertions.assertDoesNotThrow(() -> engine.evaluate(input, "Questionnaire.repeat(group)"));
      }
    } finally {
      engine.setRepeatMaxIterations(FHIRPathEngine.DEFAULT_REPEAT_MAX_ITERATIONS);
    }
  }
}
