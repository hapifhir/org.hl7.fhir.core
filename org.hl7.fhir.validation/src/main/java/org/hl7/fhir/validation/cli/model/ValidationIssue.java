package org.hl7.fhir.validation.cli.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValidationIssue {
  @JsonProperty("severity")
  private String severity;
  @JsonProperty("details")
  private String details;

  @JsonProperty("severity")
  public String getSeverity() {
    return severity;
  }

  @JsonProperty("severity")
  public ValidationIssue setSeverity(String severity) {
    this.severity = severity;
    return this;
  }

  @JsonProperty("details")
  public String getDetails() {
    return details;
  }

  @JsonProperty("details")
  public ValidationIssue setDetails(String details) {
    this.details = details;
    return this;
  }
}