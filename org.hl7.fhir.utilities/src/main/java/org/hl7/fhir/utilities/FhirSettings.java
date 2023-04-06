package org.hl7.fhir.utilities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FhirSettings {

  @JsonProperty
  private String apiKey;

  @JsonIgnore
  public String getApiKey() {
    return apiKey;
  }

  @JsonProperty("apiKey")
  public void setApiKey(String filePath) {
   this.apiKey = filePath;
  }
}
