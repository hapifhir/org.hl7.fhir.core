package org.hl7.fhir.validation.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

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
    private
    boolean hintAboutNonMustSupport = false;

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

}
