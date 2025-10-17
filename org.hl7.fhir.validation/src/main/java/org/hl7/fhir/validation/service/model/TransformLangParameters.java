package org.hl7.fhir.validation.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TransformLangParameters {
  @JsonProperty("srcLang")
  @SerializedName("srcLang")
  private
  String srcLang = null;
  @JsonProperty("tgtLang")
  @SerializedName("tgtLang")
  private
  String tgtLang = null;

  @JsonProperty("inputs")
  @SerializedName("inputs")
  private List<String> inputs = new ArrayList<String>();

  public String getSrcLang() {
    return srcLang;
  }

  public TransformLangParameters setSrcLang(String srcLang) {
    this.srcLang = srcLang;
    return this;
  }

  public String getTgtLang() {
    return tgtLang;
  }

  public TransformLangParameters setTgtLang(String tgtLang) {
    this.tgtLang = tgtLang;
    return this;
  }

  @JsonProperty("inputs")
  @SerializedName("inputs")
  public List<String> getInputs() {
    return inputs;
  }

  @JsonProperty("inputs")
  @SerializedName("inputs")
  public TransformLangParameters setInputs(List<String> inputs) {
    this.inputs = inputs;
    return this;
  }

  public TransformLangParameters addInput(String input) {
    inputs.add(input);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TransformLangParameters that = (TransformLangParameters) o;
    return Objects.equals(srcLang, that.srcLang)
      && Objects.equals(tgtLang, that.tgtLang)
      && Objects.equals(inputs, that.inputs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      srcLang,
      tgtLang,
      inputs);
  }

  @Override
  public String toString() {
    return "TransformLangParameters{" +
      "srcLang='" + srcLang + '\'' +
      ", tgtLang='" + tgtLang + '\'' +
      ", inputs=" + inputs +
      "}";
  }
}
