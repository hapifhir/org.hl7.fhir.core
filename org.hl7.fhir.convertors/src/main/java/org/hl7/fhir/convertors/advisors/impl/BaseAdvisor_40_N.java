package org.hl7.fhir.convertors.advisors.impl;

import org.hl7.fhir.convertors.advisors.interfaces.BaseAdvisorN;

public class BaseAdvisor_40_N extends BaseAdvisorN<org.hl7.fhir.r4.model.Extension> {

  private boolean produceIllegalParameters = false;

  public BaseAdvisor_40_N() {

  }

  public BaseAdvisor_40_N(Boolean failFast) {
    this.failFast = failFast;
  }

  public BaseAdvisor_40_N(Boolean failFast, Boolean produceIllegalParameters) {
    this.failFast = failFast;
    this.produceIllegalParameters = produceIllegalParameters;
  }

  public boolean produceIllegalParameters() {
    return produceIllegalParameters;
  }
}
