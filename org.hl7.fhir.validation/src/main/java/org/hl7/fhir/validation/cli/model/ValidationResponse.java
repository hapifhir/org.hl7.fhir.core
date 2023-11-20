package org.hl7.fhir.validation.cli.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValidationResponse {

  @JsonProperty("outcomes")
  public List<ValidationOutcome> outcomes = new ArrayList<>();

  @JsonProperty("sessionId")
  public String sessionId;

  @JsonProperty("validationTime")
  public ValidationTime validationTime;

  public ValidationResponse() {}

  public ValidationResponse(List<ValidationOutcome> outcomes) {
    this(outcomes, null);
  }

  public ValidationResponse(List<ValidationOutcome> outcomes, String sessionId) {
    this.outcomes = outcomes;
    this.sessionId = sessionId;
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

  @JsonProperty("sessionId")
  public String getSessionId() {
    return sessionId;
  }

  @JsonProperty("sessionId")
  public ValidationResponse setSessionId(String sessionId) {
    this.sessionId = sessionId;
    return this;
  }

  public ValidationResponse addOutcome(ValidationOutcome outcome) {
    if (outcomes == null) {
      outcomes = new ArrayList<>();
    }
    outcomes.add(outcome);
    return this;
  }

  @JsonProperty("validationTime")
  public ValidationTime getValidationTime() {
    return validationTime;
  }

  @JsonProperty("validationTime")
  public ValidationResponse setValidationTime(ValidationTime validationTime) {
    this.validationTime = validationTime;
    return this;
  }

}