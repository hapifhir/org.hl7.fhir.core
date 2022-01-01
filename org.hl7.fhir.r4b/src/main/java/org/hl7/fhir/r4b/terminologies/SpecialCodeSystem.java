package org.hl7.fhir.r4b.terminologies;

import org.hl7.fhir.r4b.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r4b.model.Coding;

public abstract class SpecialCodeSystem {

  public abstract ConceptDefinitionComponent findConcept(Coding code);

}