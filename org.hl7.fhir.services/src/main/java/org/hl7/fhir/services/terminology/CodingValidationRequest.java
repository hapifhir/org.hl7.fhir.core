package org.hl7.fhir.services.terminology;

import lombok.Getter;
import lombok.Setter;
import org.hl7.fhir.model.core.Coding;


@Getter

public class CodingValidationRequest {
  private final Coding coding;
  @Setter
  private ValidationResult result;

  @Setter
  private CacheToken cacheToken;

  public CodingValidationRequest(Coding coding) {
    super();
    this.coding = coding;
  }

  public boolean hasResult() {
    return result != null;
  }


}