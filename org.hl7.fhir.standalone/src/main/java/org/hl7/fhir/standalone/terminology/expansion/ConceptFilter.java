package org.hl7.fhir.standalone.terminology.expansion;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.CodeSystem;
import org.hl7.fhir.model.core.CodeSystem.ConceptDefinitionComponent;

import java.util.List;


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