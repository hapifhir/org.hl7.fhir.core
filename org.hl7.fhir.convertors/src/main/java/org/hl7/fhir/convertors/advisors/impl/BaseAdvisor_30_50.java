package org.hl7.fhir.convertors.advisors.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.Nonnull;

import org.hl7.fhir.convertors.advisors.interfaces.BaseAdvisor50;
import org.hl7.fhir.exceptions.FHIRException;

public class BaseAdvisor_30_50 extends BaseAdvisor50<org.hl7.fhir.dstu3.model.Extension> {

  final List<String> valueSetIgnoredUrls = Collections.singletonList("http://hl7.org/fhir/StructureDefinition/valueset-extensible");
  final List<String> capabilityStatementIgnoredUrls = Arrays.asList("http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.acceptUnknown",
    "http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.profile");

  public BaseAdvisor_30_50() {
  }

  public BaseAdvisor_30_50(Boolean failFast) {
    this.failFast = failFast;
  }

  @Override
  public boolean ignoreExtension(@Nonnull String path,
                                 @Nonnull String url) throws FHIRException {
    final List<String> paths = Arrays.asList(path.split(","));
    final String lastPath = paths.get(paths.size() - 1);
    if ((lastPath.equals("ValueSet")) && (valueSetIgnoredUrls.contains(url))) {
      return true;
    }
    else
      return (lastPath.equals("CapabilityStatement")) && (capabilityStatementIgnoredUrls.contains(url));

  }

}
