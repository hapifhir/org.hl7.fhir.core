package org.hl7.fhir.convertors.misc;

import org.hl7.fhir.convertors.advisors.VersionConvertorAdvisor40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.CodeSystem;
import org.hl7.fhir.r4.model.ValueSet;

class PR2Handler implements VersionConvertorAdvisor40 {

  @Override
  public boolean ignoreEntry(Bundle.BundleEntryComponent src) {
    return false;
  }

  @Override
  public void handleCodeSystem(CodeSystem tgtcs, ValueSet source) throws FHIRException {
    throw new Error("Not done yet");
  }

  @Override
  public CodeSystem getCodeSystem(ValueSet src) throws FHIRException {
    throw new Error("Not done yet");
  }

}
