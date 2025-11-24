package org.hl7.fhir.validation.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

@Deprecated(since="2025-11-07")
public class PackageNameParameters {

  @JsonProperty("packageName")
  @SerializedName("packageName")
  private String packageName = null;

  @SerializedName("packageName")
  @JsonProperty("packageName")
  public String getPackageName() {
    return packageName;
  }

  @SerializedName("packageName")
  @JsonProperty("packageName")
  public PackageNameParameters setPackageName(String packageName) {
    this.packageName = packageName;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PackageNameParameters that = (PackageNameParameters) o;
    return Objects.equals(packageName, that.packageName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(packageName);
  }

  @Override
  public String toString() {
    return "PackageNameParameters{" +
      "packageName='" + packageName + '\'' +
      '}';
  }
}
