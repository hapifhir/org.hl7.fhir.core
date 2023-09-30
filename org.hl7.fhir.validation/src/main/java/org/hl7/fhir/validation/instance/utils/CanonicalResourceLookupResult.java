package org.hl7.fhir.validation.instance.utils;

import org.hl7.fhir.r5.model.CanonicalResource;

public class CanonicalResourceLookupResult {

  CanonicalResource resource;
  String error;

  public CanonicalResourceLookupResult(CanonicalResource resource) {
    this.resource = resource;
  }

  public CanonicalResourceLookupResult(String error) {
    this.error = error;
  }

  public CanonicalResource getResource() {
    return resource;
  }

  public String getError() {
    return error;
  }
  
  
}