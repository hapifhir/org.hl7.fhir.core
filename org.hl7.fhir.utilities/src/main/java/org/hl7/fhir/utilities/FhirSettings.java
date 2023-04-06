package org.hl7.fhir.utilities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FhirSettings {

  @JsonProperty("doNative")
  private boolean doNative = false;
}
