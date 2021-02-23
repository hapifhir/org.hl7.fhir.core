package org.hl7.fhir.validation.cli.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValidationResponse {

  @JsonProperty("outcomes")
  public List<ValidationOutcome> outcomes = new ArrayList<>();

  @JsonProperty("sessionToken")
  public String sessionToken;

  public ValidationResponse() {}

  public ValidationResponse(List<ValidationOutcome> outcomes) {
    this(outcomes, null);
  }

  public ValidationResponse(List<ValidationOutcome> outcomes, String sessionToken) {
    this.outcomes = outcomes;
    this.sessionToken = sessionToken;
  }

  @JsonProperty("outcomes")
  public List<ValidationOutcome> getOutcomes() {
    return outcomes;
  }

  @JsonProperty("outcomes")
  public ValidationResponse setOutcomes(List<ValidationOutcome> outcomes) {
    this.outcomes = outcomes;
    return this;
  }

  @JsonProperty("sessionToken")
  public String getSessionToken() {
    return sessionToken;
  }

  @JsonProperty("sessionToken")
  public ValidationResponse setSessionToken(String sessionToken) {
    this.sessionToken = sessionToken;
    return this;
  }

  public ValidationResponse addOutcome(ValidationOutcome outcome) {
    if (outcomes == null) {
      outcomes = new ArrayList<>();
    }
    outcomes.add(outcome);
    return this;
  }

}