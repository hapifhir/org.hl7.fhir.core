package org.hl7.fhir.validation.cli.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class ValidationIssue {
  @JsonProperty("severity")
  @SerializedName("severity")
  private
  String severity;
  @JsonProperty("details")
  @SerializedName("details")
  private
  String details;

  public ValidationIssue() {
  }

  public ValidationIssue(String severity, String details) {
    this.severity = severity;
    this.details = details;
  }

  @SerializedName("severity")
  @JsonProperty("severity")
  public String getSeverity() {
    return severity;
  }

  @SerializedName("severity")
  @JsonProperty("severity")
  public ValidationIssue setSeverity(String severity) {
    this.severity = severity;
    return this;
  }

  @SerializedName("details")
  @JsonProperty("details")
  public String getDetails() {
    return details;
  }

  @SerializedName("details")
  @JsonProperty("details")
  public ValidationIssue setDetails(String details) {
    this.details = details;
    return this;
  }
}