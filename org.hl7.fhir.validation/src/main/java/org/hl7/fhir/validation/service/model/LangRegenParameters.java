package org.hl7.fhir.validation.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Deprecated(since="2025-11-07")
public class LangRegenParameters {

  @JsonProperty("langRegenParam")
  @SerializedName("langRegenParam")
  private List<String> langRegenParam = new ArrayList<>();

  @SerializedName("langRegenParam")
  @JsonProperty("langRegenParam")
  public List<String> getLangRegenParam() {
    return langRegenParam;
  }

  @SerializedName("langRegenParam")
  @JsonProperty("langRegenParam")
  public LangRegenParameters setLangRegenParam(List<String> langRegenParam) {
    this.langRegenParam = langRegenParam;
    return this;
  }

  public LangRegenParameters addLangRegenParam(String value) {
    langRegenParam.add(value);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LangRegenParameters that = (LangRegenParameters) o;
    return Objects.equals(langRegenParam, that.langRegenParam);
  }

  @Override
  public int hashCode() {
    return Objects.hash(langRegenParam);
  }

  @Override
  public String toString() {
    return "LangRegenParameters{" +
      "langRegenParam=" + langRegenParam +
      '}';
  }
}
