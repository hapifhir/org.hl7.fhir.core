package org.hl7.fhir.r5.terminologies.expansion;

import java.util.List;

import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;

public class AllConceptsFilter extends ConceptFilter {

  public AllConceptsFilter(List<String> allErrors) {
    super(allErrors);
  }

  @Override
  public boolean includeConcept(CodeSystem cs, ConceptDefinitionComponent def) {
    return true;
  }
}