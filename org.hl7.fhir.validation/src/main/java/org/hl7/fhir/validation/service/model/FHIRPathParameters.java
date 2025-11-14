package org.hl7.fhir.validation.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

@Deprecated(since="2025-11-07")
public class FHIRPathParameters {
  @JsonProperty("fhirpath")
  @SerializedName("fhirpath")
  private String fhirpath = null;

  @SerializedName("fhirpath")
  @JsonProperty("fhirpath")
  public String getFhirpath() {
    return fhirpath;
  }

  @SerializedName("fhirpath")
  @JsonProperty("fhirpath")
  public FHIRPathParameters setFhirpath(String fhirpath) {
    this.fhirpath = fhirpath;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    FHIRPathParameters that = (FHIRPathParameters) o;
    return Objects.equals(fhirpath, that.fhirpath);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fhirpath);
  }

  @Override
  public String toString() {
    return "FHIRPathParameters{" +
      "fhirpath='" + fhirpath + '\'' +
      '}';
  }
}