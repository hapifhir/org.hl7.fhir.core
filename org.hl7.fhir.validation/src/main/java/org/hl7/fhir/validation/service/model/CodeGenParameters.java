package org.hl7.fhir.validation.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Deprecated(since="2025-11-07")
public class CodeGenParameters {
  @JsonProperty("options")
  @SerializedName("options")
  private List<String> options = new ArrayList<String>();

  @SerializedName("options")
  @JsonProperty("options")
  public List<String> getOptions() {
    return options;
  }

  @SerializedName("options")
  @JsonProperty("options")
  public CodeGenParameters setOptions(List<String> options) {
    this.options = options;
    return this;
  }

  public CodeGenParameters addOption(String option) {
    if (this.options == null) {
      this.options = new ArrayList<>();
    }
    this.options.add(option);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CodeGenParameters that = (CodeGenParameters) o;
    return Objects.equals(options, that.options);
  }

  @Override
  public int hashCode() {
    return Objects.hash(options);
  }

  @Override
  public String toString() {
    return "CodeGenParameters{" +
      "options=" + options +
      '}';
  }
}