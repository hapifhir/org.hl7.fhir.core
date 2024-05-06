package org.hl7.fhir.r5.utils;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.Base;

import java.util.List;

/**
 @deprecated This interface only exists to provide backward compatibility for the following two projects:
 <a href="https://github.com/cqframework/clinical-reasoning">clinical-reasoning</a>
 <a href="https://github.com/cqframework/clinical_quality_language/">clinical_quality-language</a>

 Due to a circular dependency, they cannot be updated without a release of HAPI, which requires backwards
 compatibility with core version 6.1.2.2
 **/
public class FHIRPathEngine  extends  org.hl7.fhir.r5.fhirpath.FHIRPathEngine {

  public interface IEvaluationContext extends org.hl7.fhir.r5.fhirpath.FHIRPathEngine.IEvaluationContext{ }
  public FHIRPathEngine(IWorkerContext worker) {
    super(worker);
  }

  public org.hl7.fhir.r5.model.ExpressionNode parse(String string) {
    return new org.hl7.fhir.r5.model.ExpressionNode(super.parse(string));
  }

  public List<Base> evaluate(Base base, org.hl7.fhir.r5.model.ExpressionNode expressionNode) {
    return super.evaluate(base, expressionNode);
  }
}