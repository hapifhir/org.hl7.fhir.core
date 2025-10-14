package org.hl7.fhir.validation.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TransformLangParameters that = (TransformLangParameters) o;
    return Objects.equals(srcLang, that.srcLang)
      && Objects.equals(tgtLang, that.tgtLang);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      srcLang,
      tgtLang);
  }

  @Override
  public String toString() {
    return "TransformLangParameters{" +
      "srcLang='" + srcLang + '\'' +
      ", tgtLang='" + tgtLang + '\'' +
      "}";
  }
}
