package org.hl7.fhir.r4.utils.validation;

import org.hl7.fhir.r4.elementmodel.Element;
import org.hl7.fhir.r4.utils.validation.constants.ReferenceValidationPolicy;

public interface IValidationPolicyAdvisor {

  ReferenceValidationPolicy policyForReference(IResourceValidator validator, Object appContext, String path,
      String url);

  ReferenceValidationPolicy policyForContained(IResourceValidator validator, Object appContext, String containerType,
      String containerId, Element.SpecialElement containingResourceType, String path, String url);

}