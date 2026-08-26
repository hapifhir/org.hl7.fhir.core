package org.hl7.fhir.standalone.terminology.providers;

import org.hl7.fhir.model.core.CodeSystem.ConceptDefinitionComponent;

import org.hl7.fhir.model.core.Coding;


public abstract class SpecialCodeSystem {

  public abstract ConceptDefinitionComponent findConcept(Coding code);

  public abstract boolean inactive(String code);

}