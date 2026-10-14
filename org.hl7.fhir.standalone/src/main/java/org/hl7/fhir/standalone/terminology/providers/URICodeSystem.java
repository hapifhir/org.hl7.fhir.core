package org.hl7.fhir.standalone.terminology.providers;

import org.hl7.fhir.model.core.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.model.core.Coding;

import org.hl7.fhir.standalone.terminology.providers.SpecialCodeSystem;
import org.hl7.fhir.utilities.Utilities;


public class URICodeSystem extends SpecialCodeSystem {

  @Override
  public ConceptDefinitionComponent findConcept(Coding code) {
    if (Utilities.isAbsoluteUrl(code.getCode())) {
      return new ConceptDefinitionComponent(code.getModelContext(), code.getCode()).setDisplay(code.hasDisplay() ? code.getDisplay() : code.getCode());
    } else {
      return null;
    }
  }

  @Override
  public boolean inactive(String code) {
    return false;
  }

}