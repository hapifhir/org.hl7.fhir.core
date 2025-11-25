package org.hl7.fhir.validation.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

@Deprecated(since="2025-11-07")
public class OutputParameters {

  @JsonProperty("output")
  @SerializedName("output")
  private
  String output = null;

  @JsonProperty("outputSuffix")
  @SerializedName("outputSuffix")
  private
  String outputSuffix;

  @SerializedName("output")
  @JsonProperty("output")
  public String getOutput() {
    return output;
  }

  @SerializedName("output")
  @JsonProperty("output")
  public OutputParameters setOutput(String output) {
    this.output = output;
    return this;
  }

  @SerializedName("outputSuffix")
  @JsonProperty("outputSuffix")
  public String getOutputSuffix() {
    return outputSuffix;
  }

  @SerializedName("outputSuffix")
  @JsonProperty("outputSuffix")
  public OutputParameters setOutputSuffix(String outputSuffix) {
    this.outputSuffix = outputSuffix;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OutputParameters that = (OutputParameters) o;
    return Objects.equals(output, that.output) &&
      Objects.equals(outputSuffix, that.outputSuffix);
  }

  @Override
  public int hashCode() {
    return Objects.hash(output, outputSuffix);
  }

  @Override
  public String toString() {
    return "OutputParameters{" +
      "output='" + output + '\'' +
      ", outputSuffix='" + outputSuffix + '\'' +
      '}';
  }
}