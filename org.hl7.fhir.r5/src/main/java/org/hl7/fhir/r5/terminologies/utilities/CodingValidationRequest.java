package org.hl7.fhir.r5.terminologies.utilities;

import lombok.Getter;
import lombok.Setter;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyCache.CacheToken;


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