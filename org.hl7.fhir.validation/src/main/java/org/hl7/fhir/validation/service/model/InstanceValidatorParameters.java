package org.hl7.fhir.validation.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class InstanceValidatorParameters {
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
  public InstanceValidatorParameters setAssumeValidRestReferences(boolean assumeValidRestReferences) {
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
  public InstanceValidatorParameters setNoExtensibleBindingMessages(boolean noExtensibleBindingMessages) {
    this.noExtensibleBindingMessages = noExtensibleBindingMessages;
    return this;
  }

  @JsonProperty("showTimes")
  @SerializedName("showTimes")
  private boolean showTimes = false;

  @SerializedName("showTimes")
  @JsonProperty("showTimes")
  public boolean isShowTimes() {
    return showTimes;
  }

  @SerializedName("showTimes")
  @JsonProperty("showTimes")
  public InstanceValidatorParameters setShowTimes(boolean showTimes) {
    this.showTimes = showTimes;
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
  public InstanceValidatorParameters setHintAboutNonMustSupport(boolean hintAboutNonMustSupport) {
    this.hintAboutNonMustSupport = hintAboutNonMustSupport;
    return this;
  }

  @JsonProperty("htmlOutput")
  @SerializedName("htmlOutput")
  private
  String htmlOutput = null;

  @SerializedName("htmlOutput")
  @JsonProperty("htmlOutput")
  public String getHtmlOutput() {
    return htmlOutput;
  }

  @SerializedName("htmlOutput")
  @JsonProperty("htmlOutput")
  public InstanceValidatorParameters setHtmlOutput(String htmlOutput) {
    this.htmlOutput = htmlOutput;
    return this;
  }

  @JsonProperty("outputStyle")
  @SerializedName("outputStyle")
  private
  String outputStyle = null;

  @SerializedName("outputStyle")
  @JsonProperty("outputStyle")
  public String getOutputStyle() {
    return outputStyle;
  }

  @SerializedName("outputStyle")
  @JsonProperty("outputStyle")
  public InstanceValidatorParameters setOutputStyle(String outputStyle) {
    this.outputStyle = outputStyle;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    InstanceValidatorParameters that = (InstanceValidatorParameters) o;
    return assumeValidRestReferences == that.assumeValidRestReferences
      && noExtensibleBindingMessages == that.noExtensibleBindingMessages
      && showTimes == that.showTimes
      && hintAboutNonMustSupport == that.hintAboutNonMustSupport
      && Objects.equals(htmlOutput, that.htmlOutput)
      && Objects.equals(outputStyle, that.outputStyle);
  }

  @Override
  public int hashCode() {
    return Objects.hash(assumeValidRestReferences, noExtensibleBindingMessages, showTimes, hintAboutNonMustSupport, htmlOutput, outputStyle);
  }

  @Override
  public String toString() {
    return "InstanceValidatorParameters{" +
      "assumeValidRestReferences=" + assumeValidRestReferences +
      ", noExtensibleBindingMessages=" + noExtensibleBindingMessages +
      ", showTimes=" + showTimes +
      ", hintAboutNonMustSupport=" + hintAboutNonMustSupport +
      ", htmlOutput='" + htmlOutput + '\'' +
      ", outputStyle='" + outputStyle + '\'' +
      '}';
  }
}
