package org.hl7.fhir.validation.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.validation.special.PackageReGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Deprecated(since="2025-11-07")
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

  @SerializedName("ignoreList")
  @JsonProperty("ignoreList")
  private List<String> ignoreList;
  
  @SerializedName("ignoreList")
  @JsonProperty("ignoreList")
  public List<String> getIgnoreList() {
    return ignoreList;
  }

  @SerializedName("ignoreList")
  @JsonProperty("ignoreList")
  public RePackageParameters setIgnoreList(List<String>ignoreList) {
    this.ignoreList = ignoreList;
    return this;
  }


  @SerializedName("includeList")
  @JsonProperty("includeList")
  private List<String> includeList;

  @SerializedName("includeList")
  @JsonProperty("includeList")
  public List<String> getIncludeList() {
    return includeList;
  }

  @SerializedName("includeList")
  @JsonProperty("includeList")
  public RePackageParameters setIncludeList(List<String> includeList) {
    this.includeList = includeList;
    return this;
  }

  @SerializedName("includeConformsTo")
  @JsonProperty("includeConformsTo")
  public boolean isIncludeConformsTo() {
    return includeConformsTo;
  }

  @SerializedName("includeConformsTo")
  @JsonProperty("includeConformsTo")
  public RePackageParameters setIncludeConformsTo(boolean includeConformsTo) {
    this.includeConformsTo = includeConformsTo;
    return this;
  }

  @SerializedName("includeConformsTo")
  @JsonProperty("includeConformsTo")
  private boolean includeConformsTo = false;

  @SerializedName("scope")
  @JsonProperty("scope")
  private PackageReGenerator.ExpansionPackageGeneratorScope scope = null;

  @SerializedName("scope")
  @JsonProperty("scope")
  public PackageReGenerator.ExpansionPackageGeneratorScope getScope() {
    return scope;
  }

  @SerializedName("scope")
  @JsonProperty("scope")
  public RePackageParameters setScope(PackageReGenerator.ExpansionPackageGeneratorScope scope) {
    this.scope = scope;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    RePackageParameters that = (RePackageParameters) o;
    return Objects.equals(packages, that.packages)
      && Objects.equals(modeParams, that.modeParams)
      && Objects.equals(format, that.format)
      && Objects.equals(ignoreList, that.ignoreList)
      && Objects.equals(includeList, that.includeList)
      && Objects.equals(includeConformsTo, that.includeConformsTo)
      && Objects.equals(scope, that.scope);
  }

  @Override
  public int hashCode() {
    return Objects.hash(packages, modeParams, format, ignoreList, includeList, includeConformsTo, scope);
  }

  @Override
  public String toString() {
    return "RePackageParameters{" +
      "packages=" + packages +
      ", modeParams=" + modeParams +
      ", format=" + format +
      ", ignoreList=" + ignoreList +
      ", includeList=" + includeList +
      ", includeConformsTo=" + includeConformsTo +
      ", scope=" + scope +
      '}';
  }
}
