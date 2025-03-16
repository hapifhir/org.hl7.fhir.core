package org.hl7.fhir.r5.model;

import org.hl7.fhir.utilities.FhirPublication;

public abstract class LogicalBase extends Base {

  private static final long serialVersionUID = 1L;

  @Override
  public String getIdBase() {
    return null;
  }

  @Override
  public void setIdBase(String value) {
    // nothing    
  }

  @Override
  public FhirPublication getFHIRPublicationVersion() {
    return FhirPublication.R5;
  }

}
