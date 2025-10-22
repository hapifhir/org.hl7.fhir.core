package org.hl7.fhir.validation.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class RePackageParameters {

  @JsonProperty("packages")
  @SerializedName("packages")
  private
  List<String> packages = new ArrayList<>();

  @JsonProperty("modeParams")
  @SerializedName("modeParams")
  private
  Set<String> modeParams = new HashSet<String>();

  @JsonProperty("format")
  @SerializedName("format")
  private
  FhirFormat format;

  @SerializedName("packages")
  @JsonProperty("packages")
  public List<String> getPackages() {
    return packages;
  }

  @SerializedName("packages")
  @JsonProperty("packages")
  public RePackageParameters setPackages(List<String> packages) {
    this.packages = packages;
    return this;
  }

  public RePackageParameters addPackage(String ig) {
    if (this.packages == null) {
      this.packages = new ArrayList<>();
    }
    this.packages.add(ig);
    return this;
  }

  @SerializedName("modeParams")
  @JsonProperty("modeParams")
  public Set<String> getModeParams() {
    return modeParams;
  }

  @SerializedName("modeParams")
  @JsonProperty("modeParams")
  public RePackageParameters setModeParams(Set<String> modeParams) {
    this.modeParams = modeParams;
    return this;
  }

  public RePackageParameters addModeParam(String modeParam) {
    modeParams.add(modeParam);
    return this;
  }

  @SerializedName("format")
  @JsonProperty("format")
  public FhirFormat getFormat() {
    return format;
  }

  @SerializedName("format")
  @JsonProperty("format")
  public RePackageParameters setFormat(FhirFormat format) {
    this.format = format;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    RePackageParameters that = (RePackageParameters) o;
    return Objects.equals(packages, that.packages)
      && Objects.equals(modeParams, that.modeParams)
      && Objects.equals(format, that.format);
  }

  @Override
  public int hashCode() {
    return Objects.hash(packages, modeParams, format);
  }

  @Override
  public String toString() {
    return "RePackageParameters{" +
      "packages=" + packages +
      ", modeParams=" + modeParams +
      ", format=" + format +
      '}';
  }
}
