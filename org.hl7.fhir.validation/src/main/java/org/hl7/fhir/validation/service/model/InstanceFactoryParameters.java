package org.hl7.fhir.validation.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

@Deprecated(since="2025-11-07")
public class InstanceFactoryParameters {

  @JsonProperty("source")
  @SerializedName("source")
  private String source = null;

  @SerializedName("source")
  @JsonProperty("source")
  public String getSource() {
    return source;
  }

  @SerializedName("source")
  @JsonProperty("source")
  public InstanceFactoryParameters setSource(String source) {
    this.source = source;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    InstanceFactoryParameters that = (InstanceFactoryParameters) o;
    return Objects.equals(source, that.source);
  }

  @Override
  public int hashCode() {
    return Objects.hash(source);
  }

  @Override
  public String toString() {
    return "InstanceFactoryParameters{" +
      "source='" + source + '\'' +
      '}';
  }
}
