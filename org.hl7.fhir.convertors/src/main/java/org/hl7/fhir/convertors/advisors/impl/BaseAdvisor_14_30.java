package org.hl7.fhir.convertors.advisors.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Nonnull;

import org.hl7.fhir.convertors.advisors.interfaces.BaseAdvisor30;

public class BaseAdvisor_14_30 extends BaseAdvisor30<org.hl7.fhir.dstu2016may.model.Extension> {

  private final List<String> ignoredUrls = new ArrayList<>(Collections.singletonList("http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.acceptUnknown"));

  public BaseAdvisor_14_30() {
  }

  public BaseAdvisor_14_30(Boolean failFast) {
    this.failFast = failFast;
  }

  @Override
  public boolean ignoreExtension(@Nonnull String path,
                                 @Nonnull String url) {
    return this.ignoredUrls.contains(url);
  }
}
