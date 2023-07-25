package org.hl7.fhir.convertors.advisors.impl;

import javax.annotation.Nonnull;

import org.hl7.fhir.convertors.advisors.interfaces.BaseAdvisor30;

public class BaseAdvisor_14_30 extends BaseAdvisor30<org.hl7.fhir.dstu2016may.model.Extension> {

  public BaseAdvisor_14_30() {
  }

  public BaseAdvisor_14_30(Boolean failFast) {
    this.failFast = failFast;
  }

  @Override
  public boolean ignoreExtension(@Nonnull String path,
                                 @Nonnull String url) {
    // no globally ignored extensions here.
    return false;
  }
}
