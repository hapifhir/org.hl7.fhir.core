package org.hl7.fhir.r4b.terminologies;

import org.hl7.fhir.r4b.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.r4b.model.Coding;

@MarkedToMoveToAdjunctPackage
public abstract class SpecialCodeSystem {

  public abstract ConceptDefinitionComponent findConcept(Coding code);

}