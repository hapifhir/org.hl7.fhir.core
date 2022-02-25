package org.hl7.fhir.dstu3.utils;

import org.hl7.fhir.dstu3.context.IWorkerContext;
import org.hl7.fhir.dstu3.model.Base;
import org.hl7.fhir.dstu3.model.ExpressionNode;
import org.hl7.fhir.dstu3.model.StringType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class FhirPathTests {

  @Mock
  IWorkerContext iWorkerContext;

  @Mock
  Object appContext;

  @Mock
  Base resource;

  @Mock
  Base base;

  @Test
  public void testFuncReplaceParamSize() {
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
}