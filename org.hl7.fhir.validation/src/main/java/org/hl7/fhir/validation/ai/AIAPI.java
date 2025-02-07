package org.hl7.fhir.validation.ai;

import java.io.IOException;
import java.util.List;

import org.hl7.fhir.utilities.json.model.JsonObject;

public abstract class AIAPI {
  

  protected JsonObject config;
  
  public AIAPI(JsonObject config) {
    super();
    this.config = config;
  }

  
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
