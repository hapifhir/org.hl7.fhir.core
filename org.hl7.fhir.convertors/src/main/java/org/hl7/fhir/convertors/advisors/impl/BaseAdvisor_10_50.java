package org.hl7.fhir.convertors.advisors.impl;

import org.hl7.fhir.convertors.advisors.interfaces.BaseAdvisor50;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.Expression;
import org.hl7.fhir.r5.model.ValueSet;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BaseAdvisor_10_50 extends BaseAdvisor50<org.hl7.fhir.dstu2.model.Extension> {
  final List<String> conformanceIgnoredUrls = Collections.singletonList("http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.acceptUnknown");
  // TODO Collapse down all the advisor classes. There is code here that can be in the BaseAdvisor50
  private final List<CodeSystem> cslist = new ArrayList<>();
  private final List<Class<?>> ignoredExtensionTypes = new ArrayList<>(Collections.singletonList(Expression.class));

  public BaseAdvisor_10_50() {
  }

  public BaseAdvisor_10_50(Boolean failFast) {
    this.failFast = failFast;
  }

  public final List<CodeSystem> getCslist() {
    return this.cslist;
  }

  public boolean ignoreExtension(@NotNull String path, @NotNull String url) {
    List<String> paths = Arrays.asList(path.split(","));
    return (paths.get(paths.size() - 1).equals("Conformance")) && (conformanceIgnoredUrls.contains(url));
  }

  public boolean ignoreType(@NotNull String path, @NotNull DataType type) {
    return ignoredExtensionTypes.contains(type.getClass());
  }

  public void handleCodeSystem(@NotNull CodeSystem tgtcs, @NotNull ValueSet source) {
    tgtcs.setId(source.getId());
    tgtcs.setValueSet(source.getUrl());
    this.cslist.add(tgtcs);
  }
}
