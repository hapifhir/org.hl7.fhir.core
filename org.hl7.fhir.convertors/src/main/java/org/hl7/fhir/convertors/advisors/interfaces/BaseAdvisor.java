package org.hl7.fhir.convertors.advisors.interfaces;

public abstract class BaseAdvisor {

  public boolean failFast = true;

  public boolean failFastOnNullOrUnknownEntry() {
    return this.failFast;
  }
}
