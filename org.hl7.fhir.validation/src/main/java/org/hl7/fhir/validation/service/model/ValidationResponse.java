package org.hl7.fhir.validation.service.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class ValidationResponse {

  @JsonProperty("outcomes")
  @SerializedName("outcomes")
  public
  List<ValidationOutcome> outcomes = new ArrayList<>();

  @JsonProperty("sessionId")
  @SerializedName("sessionId")
  public
  String sessionId;

  @JsonProperty("validationTimes")
  @SerializedName("validationTimes")
  public
  Map<String, ValidationTime> validationTimes;

  public ValidationResponse() {
  }

  public ValidationResponse(List<ValidationOutcome> outcomes) {
    this(outcomes, null, new HashMap<>());
  }

  public ValidationResponse(List<ValidationOutcome> outcomes, String sessionId, Map<String, ValidationTime> validationTimes) {
    this.outcomes = outcomes;
    this.sessionId = sessionId;
    this.validationTimes = validationTimes;
  }


  @SerializedName("outcomes")
  @JsonProperty("outcomes")
  public List<ValidationOutcome> getOutcomes() {
    return outcomes;
  }

  @SerializedName("outcomes")
  @JsonProperty("outcomes")
  public ValidationResponse setOutcomes(List<ValidationOutcome> outcomes) {
    this.outcomes = outcomes;
    return this;
  }

  @SerializedName("sessionId")
  @JsonProperty("sessionId")
  public String getSessionId() {
    return sessionId;
  }

  @SerializedName("sessionId")
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

  @SerializedName("validationTimes")
  @JsonProperty("validationTimes")
  public Map<String, ValidationTime> getValidationTimes() {
    return validationTimes;
  }

  @SerializedName("validationTimes")
  @JsonProperty("validationTimes")
  public ValidationResponse setValidationTimes(Map<String, ValidationTime> validationTimes) {
    this.validationTimes = validationTimes;
    return this;
  }

}