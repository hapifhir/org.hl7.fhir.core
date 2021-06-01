package org.hl7.fhir.convertors.advisors.impl;

import org.hl7.fhir.convertors.advisors.interfaces.BaseAdvisor30;
import org.hl7.fhir.dstu2016may.model.Extension;
import org.hl7.fhir.dstu3.model.CodeSystem;
import org.hl7.fhir.dstu3.model.ValueSet;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseAdvisor_14_30 extends BaseAdvisor30<org.hl7.fhir.dstu2016may.model.Extension> {

  private final List<CodeSystem> cslist = new ArrayList<>();
  private final List<String> ignoredUrls = new ArrayList<>(Collections.singletonList("http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.acceptUnknown"));

  public BaseAdvisor_14_30() {}

  public BaseAdvisor_14_30(Boolean failFast) {
    this.failFast = failFast;
  }

  public final List<CodeSystem> getCslist() {
    return this.cslist;
  }

  public boolean ignoreExtension(@NotNull String path, @NotNull String url) {
    return this.ignoredUrls.contains(url);
  }

  public void handleCodeSystem(@NotNull CodeSystem tgtcs, @NotNull ValueSet source) {
    tgtcs.setId(source.getId());
    tgtcs.setValueSet(source.getUrl());
    this.cslist.add(tgtcs);
  }
}
