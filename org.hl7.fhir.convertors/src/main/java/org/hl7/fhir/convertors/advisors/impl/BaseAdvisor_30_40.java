package org.hl7.fhir.convertors.advisors.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.Nonnull;

import org.hl7.fhir.convertors.advisors.interfaces.BaseAdvisor40;
import org.hl7.fhir.exceptions.FHIRException;

public class BaseAdvisor_30_40 extends BaseAdvisor40<org.hl7.fhir.dstu3.model.Extension> {

  final List<String> capabilityStatementIgnoredUrls = Collections.singletonList("http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.acceptUnknown");

  final List<String> immunizationIgnoredUrls = Collections.singletonList("http://hl7.org/fhir/3.0/StructureDefinition/extension-Immunization.notGiven");

  public BaseAdvisor_30_40() {
  }

  public BaseAdvisor_30_40(Boolean failFast) {
    this.failFast = failFast;
  }

  @Override
  public boolean ignoreExtension(@Nonnull String path,
                                 @Nonnull String url) throws FHIRException {
    // no globally ignored extensions here.
    return false;
  }
}
