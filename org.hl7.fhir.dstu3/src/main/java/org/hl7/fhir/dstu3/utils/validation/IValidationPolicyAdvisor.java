package org.hl7.fhir.dstu3.utils.validation;

import org.hl7.fhir.dstu3.elementmodel.Element;
import org.hl7.fhir.dstu3.utils.validation.constants.ReferenceValidationPolicy;

public interface IValidationPolicyAdvisor {

  ReferenceValidationPolicy policyForReference(IResourceValidator validator,
                                               Object appContext,
                                               String path,
                                               String url);

  ReferenceValidationPolicy policyForContained(IResourceValidator validator,
                                               Object appContext,
                                               String containerType,
                                               String containerId,
                                               Element.SpecialElement containingResourceType,
                                               String path,
                                               String url);

}