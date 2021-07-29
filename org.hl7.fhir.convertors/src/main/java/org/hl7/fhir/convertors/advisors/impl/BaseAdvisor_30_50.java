package org.hl7.fhir.convertors.advisors.impl;

import org.hl7.fhir.convertors.advisors.interfaces.BaseAdvisor50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.ValueSet;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BaseAdvisor_30_50 extends BaseAdvisor50<org.hl7.fhir.dstu3.model.Extension> {

  final List<String> valueSetIgnoredUrls = Collections.singletonList("http://hl7.org/fhir/StructureDefinition/valueset-extensible");
  final List<String> capabilityStatementIgnoredUrls = Arrays.asList("http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.acceptUnknown",
    "http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.profile");

  private final List<CodeSystem> cslist = new ArrayList<>();

  public BaseAdvisor_30_50() {}

  public BaseAdvisor_30_50(Boolean failFast) {
    this.failFast = failFast;
  }

  public final List<CodeSystem> getCslist() {
    return this.cslist;
  }

  @Override
  public boolean ignoreExtension(@NotNull String path, @NotNull String url) throws FHIRException {
    List<String> paths = Arrays.asList(path.split(","));
    if ((paths.get(paths.size() - 1).equals("ValueSet")) && (valueSetIgnoredUrls.contains(url))) {
      return true;
    } else if ((paths.get(paths.size() - 1).equals("CapabilityStatement")) && (capabilityStatementIgnoredUrls.contains(url))){
      return true;
    } else {
      return false;
    }
  }

  public void handleCodeSystem(@NotNull CodeSystem tgtcs, @NotNull ValueSet source) {
    tgtcs.setId(source.getId());
    tgtcs.setValueSet(source.getUrl());
    this.cslist.add(tgtcs);
  }
}
