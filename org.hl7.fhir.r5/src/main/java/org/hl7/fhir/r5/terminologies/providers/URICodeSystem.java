package org.hl7.fhir.r5.terminologies.providers;

import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.utilities.Utilities;

public class URICodeSystem extends SpecialCodeSystem {

  @Override
  public ConceptDefinitionComponent findConcept(Coding code) {
    if (Utilities.isAbsoluteUrl(code.getCode())) {
      return new ConceptDefinitionComponent(code.getCode()).setDisplay(code.hasDisplay() ? code.getDisplay() : code.getCode());
    } else {
      return null;
    }
  }

}