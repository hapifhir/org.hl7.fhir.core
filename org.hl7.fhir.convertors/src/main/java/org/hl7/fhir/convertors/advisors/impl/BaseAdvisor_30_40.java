package org.hl7.fhir.convertors.advisors.impl;

import javax.annotation.Nonnull;

import org.hl7.fhir.convertors.advisors.interfaces.BaseAdvisor40;
import org.hl7.fhir.exceptions.FHIRException;

public class BaseAdvisor_30_40 extends BaseAdvisor40<org.hl7.fhir.dstu3.model.Extension> {
  public BaseAdvisor_30_40() {
  }

  public BaseAdvisor_30_40(Boolean failFast) {
    this.failFast = failFast;
  }

  @Override
  public boolean ignoreExtension(@Nonnull String path,
                                 @Nonnull String url) throws FHIRException {
    // no globally ignored extensions here.
    return false;
  }
}
