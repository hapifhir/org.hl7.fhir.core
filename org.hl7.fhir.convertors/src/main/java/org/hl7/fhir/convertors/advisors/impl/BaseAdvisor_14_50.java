package org.hl7.fhir.convertors.advisors.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.Nonnull;

import org.hl7.fhir.convertors.advisors.interfaces.BaseAdvisor50;
import org.hl7.fhir.exceptions.FHIRException;

public class BaseAdvisor_14_50 extends BaseAdvisor50<org.hl7.fhir.dstu2016may.model.Extension> {

  final List<String> capabilityStatementIgnoredUrls = Collections.singletonList("http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.acceptUnknown");

  public BaseAdvisor_14_50() {
  }

  public BaseAdvisor_14_50(Boolean failFast) {
    this.failFast = failFast;
  }

  @Override
  public boolean ignoreExtension(@Nonnull String path,
                                 @Nonnull String url) throws FHIRException {
    List<String> paths = Arrays.asList(path.split(","));
    return (paths.get(paths.size() - 1).equals("CapabilityStatement")) && (capabilityStatementIgnoredUrls.contains(url));
  }
}
