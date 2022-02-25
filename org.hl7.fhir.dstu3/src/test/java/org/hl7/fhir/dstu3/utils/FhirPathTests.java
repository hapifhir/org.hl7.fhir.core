package org.hl7.fhir.dstu3.utils;


import org.hl7.fhir.dstu3.context.IWorkerContext;
import org.hl7.fhir.dstu3.model.Base;
import org.hl7.fhir.dstu3.model.ExpressionNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

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
    engine.evaluate(appContext, resource, base, expressionNode);

  }
}