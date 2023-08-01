package org.hl7.fhir.convertors.advisors.impl;

import javax.annotation.Nonnull;

import org.hl7.fhir.convertors.advisors.interfaces.BaseAdvisor50;
import org.hl7.fhir.exceptions.FHIRException;

public class BaseAdvisor_30_50 extends BaseAdvisor50<org.hl7.fhir.dstu3.model.Extension> {

  public BaseAdvisor_30_50() {
  }

  public BaseAdvisor_30_50(Boolean failFast) {
    this.failFast = failFast;
  }

  @Override
  public boolean ignoreExtension(@Nonnull String path,
                                 @Nonnull String url) throws FHIRException {
      // no globally ignored extensions here.
      return false;
  }

}
