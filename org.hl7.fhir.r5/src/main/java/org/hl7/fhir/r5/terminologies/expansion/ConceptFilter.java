package org.hl7.fhir.r5.terminologies.expansion;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;

public abstract class ConceptFilter {

  private List<String> allErrors;
  

  protected FHIRException fail(String msg) {
    allErrors.add(msg);
    return new FHIRException(msg);
  }
  
  public ConceptFilter(List<String> allErrors) {
    super();
    this.allErrors = allErrors;
  }


  public abstract boolean includeConcept(CodeSystem cs, ConceptDefinitionComponent def);

}