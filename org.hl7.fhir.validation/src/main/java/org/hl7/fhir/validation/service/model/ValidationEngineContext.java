package org.hl7.fhir.validation.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.terminologies.JurisdictionUtilities;
import org.hl7.fhir.r5.utils.validation.BundleValidationRule;
import org.hl7.fhir.r5.utils.validation.constants.BestPracticeWarningLevel;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.settings.FhirSettings;
import org.hl7.fhir.utilities.validation.ValidationOptions.R5BundleRelativeReferencePolicy;
import org.hl7.fhir.validation.service.ValidatorWatchMode;
import org.hl7.fhir.validation.service.utils.EngineMode;
import org.hl7.fhir.validation.service.utils.QuestionnaireMode;
import org.hl7.fhir.validation.service.utils.ValidationLevel;

import java.util.*;

/**
 * A POJO for storing the flags/values for the CLI validator.
 */
public class ValidationEngineContext {


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
  public ValidationEngineContext setBaseEngine(String baseEngine) {
    this.baseEngine = baseEngine;
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
  public ValidationEngineContext setDoNative(boolean doNative) {
    this.doNative = doNative;
    return this;
  }

  @JsonProperty("hintAboutNonMustSupport")
  @SerializedName("hintAboutNonMustSupport")
  private
  boolean hintAboutNonMustSupport = false;

  @SerializedName("hintAboutNonMustSupport")
  @JsonProperty("hintAboutNonMustSupport")
  public boolean isHintAboutNonMustSupport() {
    return hintAboutNonMustSupport;
  }

  @SerializedName("hintAboutNonMustSupport")
  @JsonProperty("hintAboutNonMustSupport")
  public ValidationEngineContext setHintAboutNonMustSupport(boolean hintAboutNonMustSupport) {
    this.hintAboutNonMustSupport = hintAboutNonMustSupport;
    return this;
  }


}