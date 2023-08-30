package org.hl7.fhir.convertors.advisors.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Nonnull;

import org.hl7.fhir.convertors.advisors.interfaces.BaseAdvisor30;

public class BaseAdvisor_10_30 extends BaseAdvisor30<org.hl7.fhir.dstu2.model.Extension> {

  public BaseAdvisor_10_30() {
  }

  public BaseAdvisor_10_30(Boolean failFast) {
    this.failFast = failFast;
  }

  public boolean ignoreExtension(@Nonnull String path,
                                 @Nonnull String url) {
    // no globally ignored extensions here.
    return false;
  }
}
