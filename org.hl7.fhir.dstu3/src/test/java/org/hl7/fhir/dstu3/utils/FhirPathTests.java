package org.hl7.fhir.dstu3.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

import java.util.List;

import org.hl7.fhir.dstu3.context.IWorkerContext;
import org.hl7.fhir.dstu3.fhirpath.ExpressionNode;
import org.hl7.fhir.dstu3.fhirpath.FHIRPathEngine;
import org.hl7.fhir.dstu3.model.Base;
import org.hl7.fhir.dstu3.model.Patient;
import org.hl7.fhir.dstu3.model.Questionnaire;
import org.hl7.fhir.dstu3.model.StringType;
import org.hl7.fhir.exceptions.FHIRException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FhirPathTests {

  @Mock
  IWorkerContext iWorkerContext;

  @Mock
  Object appContext;

  @Mock
  Base resource;

  @Mock
  Base base;

  @Test
  void testFuncReplaceParamSize() {
    FHIRPathEngine engine = Mockito.spy(new FHIRPathEngine(iWorkerContext));

    ExpressionNode expressionNode = new ExpressionNode(0);
    expressionNode.setKind(ExpressionNode.Kind.Function);
    expressionNode.setFunction(ExpressionNode.Function.Replace);

    ExpressionNode expressionNodeB = new ExpressionNode(1);
    expressionNodeB.setKind(ExpressionNode.Kind.Function);
    expressionNodeB.setFunction(ExpressionNode.Function.Empty);

    ExpressionNode expressionNodeC = new ExpressionNode(2);
    expressionNodeC.setKind(ExpressionNode.Kind.Function);
    expressionNodeC.setFunction(ExpressionNode.Function.Empty);

    expressionNode.getParameters().add(expressionNodeB);
    expressionNode.getParameters().add(expressionNodeC);
    List<Base> result = engine.evaluate(appContext, resource, base, expressionNode);

    assertEquals(1, result.size());
    Base onlyResult = result.get(0);
    assertTrue(onlyResult instanceof StringType);
    assertEquals("base", ((StringType)result.get(0)).asStringValue());
    Mockito.verify(engine, times(2)).convertToString(any());
  }

  @ParameterizedTest
  @CsvSource({
    "1, true",
    "2, true",
    "3, false",
    "4, false"})
  void testExecutionLimitExceededThrowsException(int maxCalls, boolean shouldThrow) {
    FHIRPathEngine engine = new FHIRPathEngine(iWorkerContext);
    Patient input = new Patient();
    input.addName().setFamily("Smith").addGiven("John");
    engine.setExecutionMaxCalls(maxCalls);
    try {
      if (shouldThrow) {
        Assertions.assertThrows(FHIRException.class, () -> engine.evaluate(input, "Patient.name.family"));
      } else {
        Assertions.assertDoesNotThrow(() -> engine.evaluate(input, "Patient.name.family"));
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
    input.addItem().setLinkId("item1").addItem().setLinkId("subitem1");
    input.addItem().setLinkId("item2").addItem().setLinkId("subitem2");
    engine.setRepeatMaxIterations(maxIterations);
    try {
      if (shouldThrow) {
        Assertions.assertThrows(FHIRException.class, () -> engine.evaluate(input, "Questionnaire.repeat(item)"));
      } else {
        Assertions.assertDoesNotThrow(() -> engine.evaluate(input, "Questionnaire.repeat(item)"));
      }
    } finally {
      engine.setRepeatMaxIterations(FHIRPathEngine.DEFAULT_REPEAT_MAX_ITERATIONS);
    }
  }
}