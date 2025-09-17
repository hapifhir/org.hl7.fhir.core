package org.hl7.fhir.validation.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.hl7.fhir.r5.terminologies.utilities.SnomedUtilities;
import org.hl7.fhir.utilities.VersionUtilities;

import java.util.Objects;

/**
 * A POJO for storing the flags/values for building a ValidationEngine.
 */
public class ValidationEngineSettings {

  //NOT A COMMAND LINE OPTION
  @JsonProperty("baseEngine")
  @SerializedName("baseEngine")
  private
  String baseEngine = null;

  @SerializedName("baseEngine")
  @JsonProperty("baseEngine")
  public String getBaseEngine() {
    return baseEngine;
  }

  @SerializedName("baseEngine")
  @JsonProperty("baseEngine")
  public ValidationEngineSettings setBaseEngine(String baseEngine) {
    this.baseEngine = baseEngine;
    return this;
  }

  @JsonProperty("sv")
  @SerializedName("sv")
  private
  String sv = null;

  @SerializedName("sv")
  @JsonProperty("sv")
  public String getSv() {
    return sv;
  }

  @SerializedName("sv")
  @JsonProperty("sv")
  public ValidationEngineSettings setSv(String sv) {
    if (sv != null && (sv.startsWith("R") || sv.startsWith("r"))) {
      this.sv = VersionUtilities.versionFromCode(sv.toLowerCase());
    } else {
      this.sv = sv;
    }
    return this;
  }

  @JsonProperty("targetVer")
  @SerializedName("targetVer")
  private
  String targetVer = null;

  @SerializedName("targetVer")
  @JsonProperty("targetVer")
  public String getTargetVer() {
    return targetVer;
  }

  @SerializedName("targetVer")
  @JsonProperty("targetVer")
  public ValidationEngineSettings setTargetVer(String targetVer) {
    this.targetVer = targetVer;
    return this;
  }

  @JsonProperty("doNative")
  @SerializedName("doNative")
  private
  boolean doNative = false;

  @SerializedName("doNative")
  @JsonProperty("doNative")
  public boolean isDoNative() {
    return doNative;
  }

  @SerializedName("doNative")
  @JsonProperty("doNative")
  public ValidationEngineSettings setDoNative(boolean doNative) {
    this.doNative = doNative;
    return this;
  }

  @JsonProperty("hintAboutNonMustSupport")
  @SerializedName("hintAboutNonMustSupport")
  private boolean hintAboutNonMustSupport = false;

  @SerializedName("hintAboutNonMustSupport")
  @JsonProperty("hintAboutNonMustSupport")
  public boolean isHintAboutNonMustSupport() {
    return hintAboutNonMustSupport;
  }

  @SerializedName("hintAboutNonMustSupport")
  @JsonProperty("hintAboutNonMustSupport")
  public ValidationEngineSettings setHintAboutNonMustSupport(boolean hintAboutNonMustSupport) {
    this.hintAboutNonMustSupport = hintAboutNonMustSupport;
    return this;
  }

  @JsonProperty("snomedCT")
  @SerializedName("snomedCT")
  private String snomedCT = "900000000000207008";

  @SerializedName("snomedCT")
  @JsonProperty("snomedCT")
  public String getSnomedCTCode() {
    String number = SnomedUtilities.getCodeFromAlias(snomedCT);
    if (number != null) return number;
    return snomedCT;
  }

  @SerializedName("snomedCT")
  @JsonProperty("snomedCT")
  public ValidationEngineSettings setSnomedCT(String snomedCT) {
    this.snomedCT = snomedCT;
    return this;
  }

  @JsonProperty("assumeValidRestReferences")
  @SerializedName("assumeValidRestReferences")
  private boolean assumeValidRestReferences = false;

  @SerializedName("assumeValidRestReferences")
  @JsonProperty("assumeValidRestReferences")
  public boolean isAssumeValidRestReferences() {
    return assumeValidRestReferences;
  }

  @SerializedName("assumeValidRestReferences")
  @JsonProperty("assumeValidRestReferences")
  public ValidationEngineSettings setAssumeValidRestReferences(boolean assumeValidRestReferences) {
    this.assumeValidRestReferences = assumeValidRestReferences;
    return this;
  }

  @JsonProperty("noExtensibleBindingMessages")
  @SerializedName("noExtensibleBindingMessages")
  private boolean noExtensibleBindingMessages = false;

  @SerializedName("noExtensibleBindingMessages")
  @JsonProperty("noExtensibleBindingMessages")
  public boolean isNoExtensibleBindingMessages() {
    return noExtensibleBindingMessages;
  }

  @SerializedName("noExtensibleBindingMessages")
  @JsonProperty("noExtensibleBindingMessages")
  public ValidationEngineSettings setNoExtensibleBindingMessages(boolean noExtensibleBindingMessages) {
    this.noExtensibleBindingMessages = noExtensibleBindingMessages;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ValidationEngineSettings that = (ValidationEngineSettings) o;
    return Objects.equals(baseEngine, that.baseEngine)
      && doNative == that.doNative
      && hintAboutNonMustSupport == that.hintAboutNonMustSupport
      && assumeValidRestReferences == that.assumeValidRestReferences
      && snomedCT.equals(that.snomedCT)
      && noExtensibleBindingMessages == that.noExtensibleBindingMessages
      && sv.equals(that.sv)
      && targetVer.equals(that.targetVer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      baseEngine,
      doNative,
      hintAboutNonMustSupport,
      assumeValidRestReferences,
      snomedCT,
      noExtensibleBindingMessages,
      sv,
      targetVer);
  }

  @Override
  public String toString() {
    return "ValidationContext{" +
      "baseEngine=" + baseEngine +
      ", doNative=" + doNative +
      ", hintAboutNonMustSupport=" + hintAboutNonMustSupport +
      ", assumeValidRestReferences=" + assumeValidRestReferences +
      ", snomedCT=" + snomedCT +
      ", noExtensibleBindingMessages=" + noExtensibleBindingMessages +
      ", sv=" + sv +
      ", targetVer=" + targetVer +
      "}";
  }
}
