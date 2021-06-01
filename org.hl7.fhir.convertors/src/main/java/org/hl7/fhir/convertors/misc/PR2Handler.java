package org.hl7.fhir.convertors.misc;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_10_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.CodeSystem;
import org.hl7.fhir.r4.model.ValueSet;
import org.hl7.fhir.r5.model.FhirPublication;
import org.jetbrains.annotations.NotNull;

class PR2Handler extends BaseAdvisor_10_40 {

  @Override
  public boolean ignoreEntry(Bundle.BundleEntryComponent src, FhirPublication publication) {
    return false;
  }

  @Override
  public void handleCodeSystem(@NotNull CodeSystem tgtcs, @NotNull ValueSet source) throws FHIRException {
    throw new Error("Not done yet");
  }

  @Override
  public CodeSystem getCodeSystem(@NotNull ValueSet src) throws FHIRException {
    throw new Error("Not done yet");
  }

}
