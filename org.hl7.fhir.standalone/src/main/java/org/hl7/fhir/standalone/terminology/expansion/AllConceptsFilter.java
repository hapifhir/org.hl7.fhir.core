package org.hl7.fhir.standalone.terminology.expansion;

import org.hl7.fhir.model.core.CodeSystem;
import org.hl7.fhir.model.core.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.standalone.terminology.expansion.ConceptFilter;

import java.util.List;


public class AllConceptsFilter extends ConceptFilter {

  public AllConceptsFilter(List<String> allErrors) {
    super(allErrors);
  }

  @Override
  public boolean includeConcept(CodeSystem cs, ConceptDefinitionComponent def) {
    return true;
  }
}