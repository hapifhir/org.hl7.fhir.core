package org.hl7.fhir.r5.utils.validation;

import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.utils.validation.constants.ContainedReferenceValidationPolicy;
import org.hl7.fhir.r5.utils.validation.constants.ReferenceValidationPolicy;

public interface IValidationPolicyAdvisor {

  /**
   *
   * @param validator
   * @param appContext What was originally provided from the app for it's context
   * @param path Path that led us to this resource.
   * @param url Url of the profile the container resource is being validated against.
   * @return {@link ReferenceValidationPolicy}
   */
  ReferenceValidationPolicy policyForReference(IResourceValidator validator,
                                               Object appContext,
                                               String path,
                                               String url);

  /**
   * //TODO pass through the actual containing Element as opposed to the type, id
   * @param validator
   * @param appContext What was originally provided from the app for it's context
   * @param containerType Type of the resources that contains the resource being validated
   * @param containerId Id of the resources that contains the resource being validated
   * @param containingResourceType Type of the resource that will be validated (BUNDLE_ENTRY, BUNDLE_OUTCOME, CONTAINED_RESOURCE, PARAMETER)
   * @param path Path that led us to this resource.
   * @param url Url of the profile the container resource is being validated against.
   * @return {@link ReferenceValidationPolicy}
   */
  ContainedReferenceValidationPolicy policyForContained(IResourceValidator validator,
                                                        Object appContext,
                                                        String containerType,
                                                        String containerId,
                                                        Element.SpecialElement containingResourceType,
                                                        String path,
                                                        String url);

}