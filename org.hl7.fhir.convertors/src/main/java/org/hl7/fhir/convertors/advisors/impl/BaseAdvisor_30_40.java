package org.hl7.fhir.convertors.advisors.impl;

import org.hl7.fhir.convertors.advisors.interfaces.BaseAdvisor40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.CodeSystem;
import org.hl7.fhir.r4.model.Expression;
import org.hl7.fhir.r4.model.Type;
import org.hl7.fhir.r4.model.ValueSet;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BaseAdvisor_30_40 extends BaseAdvisor40<org.hl7.fhir.dstu3.model.Extension> {

  final List<String> capabilityStatementIgnoredUrls = Collections.singletonList("http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.acceptUnknown");

  private final List<CodeSystem> cslist = new ArrayList<>();

  public BaseAdvisor_30_40() {}

  public BaseAdvisor_30_40(Boolean failFast) {
    this.failFast = failFast;
  }

  public final List<CodeSystem> getCslist() {
    return this.cslist;
  }

  @Override
  public boolean ignoreExtension(@NotNull String path, @NotNull String url) throws FHIRException {
    List<String> paths = Arrays.asList(path.split(","));
    if ((paths.get(paths.size() - 1).equals("CapabilityStatement")) && (capabilityStatementIgnoredUrls.contains(url))){
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
