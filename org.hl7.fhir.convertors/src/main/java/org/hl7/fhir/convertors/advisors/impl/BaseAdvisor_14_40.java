package org.hl7.fhir.convertors.advisors.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Nonnull;

import org.hl7.fhir.convertors.advisors.interfaces.BaseAdvisor40;
import org.hl7.fhir.r4.model.Expression;
import org.hl7.fhir.r4.model.Type;

public class BaseAdvisor_14_40 extends BaseAdvisor40<org.hl7.fhir.dstu2016may.model.Extension> {

  private final List<Class<?>> ignoredExtensionTypes = new ArrayList<>(Collections.singletonList(Expression.class));

  public BaseAdvisor_14_40() {
  }

  public BaseAdvisor_14_40(Boolean failFast) {
    this.failFast = failFast;
  }


  public boolean ignoreExtension(@Nonnull String path,
                                 @Nonnull String url) {
    // no globally ignored extensions here.
    return false;
  }

  public boolean ignoreType(@Nonnull String path, @Nonnull Type type) {
    return ignoredExtensionTypes.contains(type.getClass());
  }
}
