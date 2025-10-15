package org.hl7.fhir.validation.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.hl7.fhir.r5.terminologies.JurisdictionUtilities;
import org.hl7.fhir.r5.terminologies.utilities.SnomedUtilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.settings.FhirSettings;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class ValidationEngineParameters {
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
  public ValidationEngineParameters setBaseEngine(String baseEngine) {
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
  public ValidationEngineParameters setSv(String sv) {
    if (sv != null && (sv.startsWith("R") || sv.startsWith("r"))) {
      this.sv = VersionUtilities.versionFromCode(sv.toLowerCase());
    } else {
      this.sv = sv;
    }
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
  public ValidationEngineParameters setDoNative(boolean doNative) {
    this.doNative = doNative;
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

  public String getSnomedCT() {
    return snomedCT;
    }

  @SerializedName("snomedCT")
  @JsonProperty("snomedCT")
  public ValidationEngineParameters setSnomedCT(String snomedCT) {
    this.snomedCT = snomedCT;
    return this;
  }

  @JsonProperty("igs")
  @SerializedName("igs")
  private
  List<String> igs = new ArrayList<>();

  @SerializedName("igs")
  @JsonProperty("igs")
  public List<String> getIgs() {
    return igs;
  }

  @SerializedName("igs")
  @JsonProperty("igs")
  public ValidationEngineParameters setIgs(List<String> igs) {
    this.igs = igs;
    return this;
  }

  public ValidationEngineParameters addIg(String ig) {
    if (this.igs == null) {
      this.igs = new ArrayList<>();
    }
    this.igs.add(ig);
    return this;
  }

  @JsonProperty("resolutionContext")
  @SerializedName("resolutionContext")
  private
  String resolutionContext = null;

  @SerializedName("resolutionContext")
  @JsonProperty("resolutionContext")
  public String getResolutionContext() {
    return resolutionContext;
  }

  @SerializedName("resolutionContext")
  @JsonProperty("resolutionContext")
  public ValidationEngineParameters setResolutionContext(String resolutionContext) {
    this.resolutionContext = resolutionContext;
    return this;
  }

  @JsonProperty("jurisdiction")
  @SerializedName("jurisdiction")
  private
  String jurisdiction = JurisdictionUtilities.getJurisdictionFromLocale(Locale.getDefault().getCountry());

  @SerializedName("jurisdiction")
  @JsonProperty("jurisdiction")
  public String getJurisdiction() {
    return jurisdiction;
  }

  @SerializedName("jurisdiction")
  @JsonProperty("jurisdiction")
  public ValidationEngineParameters setJurisdiction(String jurisdiction) {
    this.jurisdiction = jurisdiction;
    return this;
  }

  @JsonProperty("aiService")
  @SerializedName("aiService")
  private
  String aiService;

  @SerializedName("aiService")
  @JsonProperty("aiService")
  public String getAIService() {
    return aiService;
  }

  @SerializedName("aiService")
  @JsonProperty("aiService")
  public ValidationEngineParameters setAIService(String aiService) {
    this.aiService = aiService;
    return this;
  }

  @JsonProperty("certSources")
  @SerializedName("certSources")
  private
  List<String> certSources = new ArrayList<String>();

  @SerializedName("certSources")
  @JsonProperty("certSources")
  public List<String> getCertSources() {
    return certSources;
  }

  @SerializedName("certSources")
  @JsonProperty("certSources")
  public ValidationEngineParameters setCertSources(List<String> certSources) {
    this.certSources = certSources;
    return this;
  }

  public ValidationEngineParameters addCertSource(String certSource) {
    certSources.add(certSource);
    return this;
  }

  @JsonProperty("txServer")
  @SerializedName("txServer")
  private
  String txServer = FhirSettings.getTxFhirProduction();

  @SerializedName("txServer")
  @JsonProperty("txServer")
  public String getTxServer() {
    return txServer;
  }

  @SerializedName("txServer")
  @JsonProperty("txServer")
  public ValidationEngineParameters setTxServer(String txServer) {
    this.txServer = txServer;
    return this;
  }

  @JsonProperty("noEcosystem")
  @SerializedName("noEcosystem")
  private
  boolean noEcosystem = false;

  @SerializedName("noEcosystem")
  @JsonProperty("noEcosystem")
  public boolean getNoEcosystem() {
    return noEcosystem;
  }

  @SerializedName("noEcosystem")
  @JsonProperty("noEcosystem")
  public ValidationEngineParameters setNoEcosystem(boolean noEcosystem) {
    this.noEcosystem = noEcosystem;
    return this;
  }

  private Boolean inferFhirVersion = true;

  public Boolean isInferFhirVersion() {
    return inferFhirVersion;
  }

  public ValidationEngineParameters setInferFhirVersion(Boolean inferFhirVersion) {
    this.inferFhirVersion = inferFhirVersion;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ValidationEngineParameters that = (ValidationEngineParameters) o;
    return Objects.equals(baseEngine, that.baseEngine)
      && doNative == that.doNative
      && snomedCT.equals(that.snomedCT)
      && sv.equals(that.sv)
      && isInferFhirVersion() == that.isInferFhirVersion()
      && noEcosystem == that.noEcosystem
      && Objects.equals(resolutionContext, that.resolutionContext)
      && Objects.equals(jurisdiction, that.jurisdiction)
      && Objects.equals(aiService, that.aiService)
      && Objects.equals(certSources, that.certSources)
      && Objects.equals(txServer, that.txServer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      baseEngine,
      doNative,
      snomedCT,
      sv,
      inferFhirVersion,
      resolutionContext,
      jurisdiction,
      aiService,
      certSources,
      txServer,
      noEcosystem);
  }

  @Override
  public String toString() {
    return "ValidationEngineParameters{" +
      "baseEngine=" + baseEngine +
      ", doNative=" + doNative +
      ", snomedCT=" + snomedCT +
      ", sv=" + sv +
      ", inferFhirVersion=" + inferFhirVersion +
      ", resolutionContext='" + resolutionContext + '\'' +
      ", jurisdiction='" + jurisdiction + '\'' +
      ", aiService='" + aiService + '\'' +
      ", certSources=" + certSources +
      ", txServer='" + txServer + '\'' +
      ", noEcosystem=" + noEcosystem +
      "}";
  }
}
