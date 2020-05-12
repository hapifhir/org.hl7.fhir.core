package org.hl7.fhir.r5.terminologies;

import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.Coding;

public abstract class SpecialCodeSystem {

  public abstract ConceptDefinitionComponent findConcept(Coding code);

}