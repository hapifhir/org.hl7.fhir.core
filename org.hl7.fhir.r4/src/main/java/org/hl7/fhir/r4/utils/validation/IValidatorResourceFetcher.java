package org.hl7.fhir.r4.utils.validation;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.elementmodel.Element;

import java.io.IOException;

public interface IValidatorResourceFetcher {
  Element fetch(Object appContext, String url) throws FHIRException, IOException;

  // Add the line here getValidationPolicyForContainedResource
  // Move this above method out with the new one and call it the policyAdvisor interface
  // For a given reference, how much do you want to validate it?
  // IANTORNO
  /*
public enum ContainingResourceType { CONTAINED, BUNDLE_ENTRY, BUNDLE_OUTCOME, PARAMETER }

public interface IValidationPolicyAdvisor {
  ReferenceValidationPolicy policyForReference(IResourceValidator validator, Object appContext, String path, String url);
  ReferenceValidationPolicy policyForContained(IResourceValidator validator, Object appContext, String containerType, String containerId, ContainingResourceType containerType, String path, String url);
}
   */
  // For a given reference how much do we validate it?

  boolean resolveURL(Object appContext, String path, String url) throws IOException, FHIRException;
}
