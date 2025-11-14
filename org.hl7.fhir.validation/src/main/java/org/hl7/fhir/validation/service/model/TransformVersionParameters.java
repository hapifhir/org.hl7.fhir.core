package org.hl7.fhir.validation.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

@Deprecated(since="2025-11-07")
public class TransformVersionParameters {
  @JsonProperty("targetVer")
  @SerializedName("targetVer")
  private String targetVer = null;

  @SerializedName("targetVer")
  @JsonProperty("targetVer")
  public String getTargetVer() {
    return targetVer;
  }

  @SerializedName("targetVer")
  @JsonProperty("targetVer")
  public TransformVersionParameters setTargetVer(String targetVer) {
    this.targetVer = targetVer;
    return this;
  }

  @JsonProperty("canDoNative")
  @SerializedName("canDoNative")
  private
  boolean canDoNative = false;

  @SerializedName("canDoNative")
  @JsonProperty("canDoNative")
  public boolean getCanDoNative() {
    return canDoNative;
  }

  @SerializedName("canDoNative")
  @JsonProperty("canDoNative")
  public TransformVersionParameters setCanDoNative(boolean canDoNative) {
    this.canDoNative = canDoNative;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TransformVersionParameters that = (TransformVersionParameters) o;
    return canDoNative == that.canDoNative
      && Objects.equals(targetVer, that.targetVer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(canDoNative, targetVer);
  }

  @Override
  public String toString() {
    return "TransformVersionParameters{" +
      "canDoNative=" + canDoNative +
      ", targetVer='" + targetVer + '\'' +
      '}';
  }
}
