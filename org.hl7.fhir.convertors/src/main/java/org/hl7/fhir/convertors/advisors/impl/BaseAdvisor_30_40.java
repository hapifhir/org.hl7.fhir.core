package org.hl7.fhir.convertors.advisors.impl;

import org.hl7.fhir.convertors.advisors.interfaces.BaseAdvisor40;
import org.hl7.fhir.exceptions.FHIRException;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BaseAdvisor_30_40 extends BaseAdvisor40<org.hl7.fhir.dstu3.model.Extension> {

  final List<String> capabilityStatementIgnoredUrls = Collections.singletonList("http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.acceptUnknown");

  public BaseAdvisor_30_40() {
  }

  public BaseAdvisor_30_40(Boolean failFast) {
    this.failFast = failFast;
  }

  @Override
  public boolean ignoreExtension(@Nonnull String path,
                                 @Nonnull String url) throws FHIRException {
    List<String> paths = Arrays.asList(path.split(","));
    return (paths.get(paths.size() - 1).equals("CapabilityStatement")) && (capabilityStatementIgnoredUrls.contains(url));
  }
}
