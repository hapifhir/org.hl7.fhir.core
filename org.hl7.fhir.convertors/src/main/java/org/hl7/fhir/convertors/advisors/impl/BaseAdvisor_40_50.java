package org.hl7.fhir.convertors.advisors.impl;

import org.hl7.fhir.convertors.advisors.interfaces.BaseAdvisor50;

public class BaseAdvisor_40_50 extends BaseAdvisor50<org.hl7.fhir.r4.model.Extension> {

  private boolean produceIllegalParameters = false;

  public BaseAdvisor_40_50() {

  }

  public BaseAdvisor_40_50(Boolean failFast) {
    this.failFast = failFast;
  }

  public BaseAdvisor_40_50(Boolean failFast, Boolean produceIllegalParameters) {
    this.failFast = failFast;
    this.produceIllegalParameters = produceIllegalParameters;
  }

  public boolean produceIllegalParameters() {
    return produceIllegalParameters;
  }
}
