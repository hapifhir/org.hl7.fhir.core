package org.hl7.fhir.validation.ai;

import java.io.IOException;
import java.util.List;

public abstract class AIAPI {
  
  public abstract List<CodeAndTextValidationResult> validateCodings(List<CodeAndTextValidationRequest> requests) throws IOException;
  

  protected String getSystemName(String system) {
    switch (system) {
    case "http://snomed.info/sct": return "SNOMED CT";
    case "http://loinc.org": return "LOINC";
    case "http://www.nlm.nih.gov/research/umls/rxnorm": return "RxNorm";
    default : return system;
    }
  }
  
}
