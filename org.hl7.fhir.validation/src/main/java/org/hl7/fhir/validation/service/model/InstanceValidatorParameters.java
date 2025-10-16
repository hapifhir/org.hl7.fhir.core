package org.hl7.fhir.validation.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.hl7.fhir.utilities.validation.ValidationOptions.R5BundleRelativeReferencePolicy;
import org.hl7.fhir.validation.service.utils.QuestionnaireMode;

import java.util.ArrayList;
import java.util.List;
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

  @JsonProperty("r5BundleRelativeReferencePolicy")
  @SerializedName("r5BundleRelativeReferencePolicy")
  private R5BundleRelativeReferencePolicy r5BundleRelativeReferencePolicy;

  public R5BundleRelativeReferencePolicy getR5BundleRelativeReferencePolicy() {
    return r5BundleRelativeReferencePolicy;
  }

  public InstanceValidatorParameters setR5BundleRelativeReferencePolicy(R5BundleRelativeReferencePolicy r5BundleRelativeReferencePolicy) {
    this.r5BundleRelativeReferencePolicy = r5BundleRelativeReferencePolicy;
    return this;
  }

  @JsonProperty("extensions")
  @SerializedName("extensions")
  private List<String> extensions = new ArrayList<String>();

  @SerializedName("extensions")
  @JsonProperty("extensions")
  public List<String> getExtensions() {
    return extensions;
  }

  @SerializedName("extensions")
  @JsonProperty("extensions")
  public InstanceValidatorParameters setExtensions(List<String> extensions) {
    this.extensions = extensions;
    return this;
  }

  public InstanceValidatorParameters addExtension(String extension) {
    this.extensions.add(extension);
    return this;
  }

  @JsonProperty("wantInvariantsInMessages")
  @SerializedName("wantInvariantsInMessages")
  private boolean wantInvariantsInMessages = false;

  @SerializedName("wantInvariantsInMessages")
  @JsonProperty("wantInvariantsInMessages")
  public boolean isWantInvariantsInMessages() {
    return wantInvariantsInMessages;
  }

  @SerializedName("wantInvariantsInMessages")
  @JsonProperty("wantInvariantsInMessages")
  public InstanceValidatorParameters setWantInvariantsInMessages(boolean wantInvariantsInMessages) {
    this.wantInvariantsInMessages = wantInvariantsInMessages;
    return this;
  }

  @JsonProperty("noInvariants")
  @SerializedName("noInvariants")
  private boolean noInvariants = false;

  @SerializedName("noInvariants")
  @JsonProperty("noInvariants")
  public boolean isNoInvariants() {
    return noInvariants;
  }

  @SerializedName("noInvariants")
  @JsonProperty("noInvariants")
  public InstanceValidatorParameters setNoInvariants(boolean noInvariants) {
    this.noInvariants = noInvariants;
    return this;
  }

  @JsonProperty("questionnaire")
  @SerializedName("questionnaire")
  private QuestionnaireMode questionnaireMode = QuestionnaireMode.CHECK;

  @SerializedName("questionnaire")
  @JsonProperty("questionnaire")
  public QuestionnaireMode getQuestionnaireMode() {
    return questionnaireMode;
  }

  @SerializedName("questionnaire")
  @JsonProperty("questionnaire")
  public InstanceValidatorParameters setQuestionnaireMode(QuestionnaireMode questionnaireMode) {
    this.questionnaireMode = questionnaireMode;
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
      && wantInvariantsInMessages == that.wantInvariantsInMessages
      && noInvariants == that.noInvariants
      && Objects.equals(htmlOutput, that.htmlOutput)
      && Objects.equals(outputStyle, that.outputStyle)
      && Objects.equals(r5BundleRelativeReferencePolicy, that.r5BundleRelativeReferencePolicy)
      && Objects.equals(extensions, that.extensions)
      && Objects.equals(questionnaireMode, that.questionnaireMode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(assumeValidRestReferences, noExtensibleBindingMessages, showTimes, hintAboutNonMustSupport, htmlOutput, outputStyle, r5BundleRelativeReferencePolicy, extensions, wantInvariantsInMessages, noInvariants, questionnaireMode);
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
      ", r5BundleRelativeReferencePolicy=" + r5BundleRelativeReferencePolicy +
      ", extensions=" + extensions +
      ", wantInvariantsInMessages=" + wantInvariantsInMessages +
      ", noInvariants=" + noInvariants +
      ", questionnaireMode=" + questionnaireMode +
      '}';
  }
}
