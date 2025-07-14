package org.hl7.fhir.r5.terminologies.providers;

import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.r5.model.Coding;

@MarkedToMoveToAdjunctPackage
public abstract class SpecialCodeSystem {

  public abstract ConceptDefinitionComponent findConcept(Coding code);

  public abstract boolean inactive(String code);

}