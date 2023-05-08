package org.hl7.fhir.r5.terminologies.expansion;

import java.util.List;

import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;

public class RegexFilter extends ConceptFilter {

  private String regex;
  
  protected RegexFilter(List<String> allErrors, String regex) {
    super(allErrors);
    this.regex = regex;
  }

  @Override
  public boolean includeConcept(CodeSystem cs, ConceptDefinitionComponent def) {
    return def.getCode().matches(regex);
  }
}