package org.hl7.fhir.validation.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.hl7.fhir.r5.utils.validation.constants.BestPracticeWarningLevel;
import org.hl7.fhir.utilities.validation.ValidationOptions.R5BundleRelativeReferencePolicy;
import org.hl7.fhir.validation.instance.ValidatorMaxMessages;
import org.hl7.fhir.validation.service.utils.QuestionnaireMode;
import org.hl7.fhir.validation.service.utils.ValidationLevel;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InstanceValidatorParameters {

  public InstanceValidatorParameters() {}

  public InstanceValidatorParameters(@Nonnull InstanceValidatorParameters instanceValidatorParameters) {
    this.assumeValidRestReferences = instanceValidatorParameters.assumeValidRestReferences;
    this.hintAboutNonMustSupport = instanceValidatorParameters.hintAboutNonMustSupport;
    this.htmlOutput = instanceValidatorParameters.htmlOutput;
    this.outputStyle = instanceValidatorParameters.outputStyle;
    this.r5BundleRelativeReferencePolicy = instanceValidatorParameters.r5BundleRelativeReferencePolicy;
    this.extensions = new ArrayList<>(instanceValidatorParameters.extensions);
    this.wantInvariantsInMessages = instanceValidatorParameters.wantInvariantsInMessages;
    this.noInvariants = instanceValidatorParameters.noInvariants;
    this.questionnaireMode = instanceValidatorParameters.questionnaireMode;
    this.unknownCodeSystemsCauseErrors = instanceValidatorParameters.unknownCodeSystemsCauseErrors;
    this.level = instanceValidatorParameters.level;
    this.bestPracticeLevel = instanceValidatorParameters.bestPracticeLevel;
    this.forPublication = instanceValidatorParameters.forPublication;
    this.htmlInMarkdownCheck = instanceValidatorParameters.htmlInMarkdownCheck;
    this.noUnicodeBiDiControlChars = instanceValidatorParameters.noUnicodeBiDiControlChars;
    this.crumbTrails = instanceValidatorParameters.crumbTrails;
    this.showMessageIds = instanceValidatorParameters.showMessageIds;
    this.allowExampleUrls = instanceValidatorParameters.allowExampleUrls;
    this.showMessagesFromReferences = instanceValidatorParameters.showMessagesFromReferences;
    this.securityChecks = instanceValidatorParameters.securityChecks;
    this.noExperimentalContent = instanceValidatorParameters.noExperimentalContent;
    this.showTerminologyRouting = instanceValidatorParameters.showTerminologyRouting;
    this.expansionParameters = instanceValidatorParameters.expansionParameters;
    this.profiles = new ArrayList<>(instanceValidatorParameters.profiles);
    this.doImplicitFHIRPathStringConversion = instanceValidatorParameters.doImplicitFHIRPathStringConversion;
    this.allowDoubleQuotesInFHIRPath = instanceValidatorParameters.allowDoubleQuotesInFHIRPath;
    this.checkIPSCodes = instanceValidatorParameters.checkIPSCodes;
    this.bundleValidationRules = new ArrayList<>(instanceValidatorParameters.bundleValidationRules);
    this.jurisdiction = instanceValidatorParameters.jurisdiction;
    this.maxValidationMessages = instanceValidatorParameters.getMaxValidationMessages();
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
  public InstanceValidatorParameters setAssumeValidRestReferences(boolean assumeValidRestReferences) {
    this.assumeValidRestReferences = assumeValidRestReferences;
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

  @JsonProperty("unknownCodeSystemsCauseErrors")
  @SerializedName("unknownCodeSystemsCauseErrors")
  private boolean unknownCodeSystemsCauseErrors;

  @JsonProperty("level")
  @SerializedName("level")
  private ValidationLevel level = ValidationLevel.HINTS;

  @JsonProperty("bestPracticeLevel")
  @SerializedName("bestPracticeLevel")
  private BestPracticeWarningLevel bestPracticeLevel = BestPracticeWarningLevel.Warning;

  @JsonProperty("forPublication")
  @SerializedName("forPublication")
  private boolean forPublication = false;

  @JsonProperty("htmlInMarkdownCheck")
  @SerializedName("htmlInMarkdownCheck")
  private HtmlInMarkdownCheck htmlInMarkdownCheck = HtmlInMarkdownCheck.WARNING;

  @JsonProperty("noUnicodeBiDiControlChars")
  @SerializedName("noUnicodeBiDiControlChars")
  private boolean noUnicodeBiDiControlChars = false;

  @JsonProperty("crumbTrails")
  @SerializedName("crumbTrails")
  private boolean crumbTrails = false;

  @JsonProperty("showMessageIds")
  @SerializedName("showMessageIds")
  private boolean showMessageIds = false;

  @JsonProperty("allowExampleUrls")
  @SerializedName("allowExampleUrls")
  private boolean allowExampleUrls = false;

  @JsonProperty("showMessagesFromReferences")
  @SerializedName("showMessagesFromReferences")
  private boolean showMessagesFromReferences = false;

  @JsonProperty("securityChecks")
  @SerializedName("securityChecks")
  private boolean securityChecks = false;

  @JsonProperty("noExperimentalContent")
  @SerializedName("noExperimentalContent")
  private boolean noExperimentalContent;

  @JsonProperty("showTerminologyRouting")
  @SerializedName("showTerminologyRouting")
  private boolean showTerminologyRouting = false;

  @JsonProperty("expansionParameters")
  @SerializedName("expansionParameters")
  private String expansionParameters;

  @JsonProperty("profiles")
  @SerializedName("profiles")
  private List<String> profiles = new ArrayList<String>();

  @SerializedName("unknownCodeSystemsCauseErrors")
  @JsonProperty("unknownCodeSystemsCauseErrors")
  public boolean isUnknownCodeSystemsCauseErrors() {
    return unknownCodeSystemsCauseErrors;
  }

  @SerializedName("unknownCodeSystemsCauseErrors")
  @JsonProperty("unknownCodeSystemsCauseErrors")
  public InstanceValidatorParameters setUnknownCodeSystemsCauseErrors(boolean unknownCodeSystemsCauseErrors) {
    this.unknownCodeSystemsCauseErrors = unknownCodeSystemsCauseErrors;
    return this;
  }

  @SerializedName("level")
  @JsonProperty("level")
  public ValidationLevel getLevel() {
    return level;
  }

  @SerializedName("level")
  @JsonProperty("level")
  public InstanceValidatorParameters setLevel(ValidationLevel level) {
    this.level = level;
    return this;
  }

  @SerializedName("bestPracticeLevel")
  @JsonProperty("bestPracticeLevel")
  public BestPracticeWarningLevel getBestPracticeLevel() {
    return bestPracticeLevel;
  }

  @SerializedName("bestPracticeLevel")
  @JsonProperty("bestPracticeLevel")
  public InstanceValidatorParameters setBestPracticeLevel(BestPracticeWarningLevel bestPracticeLevel) {
    this.bestPracticeLevel = bestPracticeLevel;
    return this;
  }

  public boolean isForPublication() {
    return forPublication;
  }

  public InstanceValidatorParameters setForPublication(boolean forPublication) {
    this.forPublication = forPublication;
    return this;
  }

  @SerializedName("htmlInMarkdownCheck")
  @JsonProperty("htmlInMarkdownCheck")
  public HtmlInMarkdownCheck getHtmlInMarkdownCheck() {
    return htmlInMarkdownCheck;
  }

  @SerializedName("htmlInMarkdownCheck")
  @JsonProperty("htmlInMarkdownCheck")
  public InstanceValidatorParameters setHtmlInMarkdownCheck(HtmlInMarkdownCheck htmlInMarkdownCheck) {
    this.htmlInMarkdownCheck = htmlInMarkdownCheck;
    return this;
  }

  @SerializedName("noUnicodeBiDiControlChars")
  @JsonProperty("noUnicodeBiDiControlChars")
  public boolean isNoUnicodeBiDiControlChars() {
    return noUnicodeBiDiControlChars;
  }

  @SerializedName("noUnicodeBiDiControlChars")
  @JsonProperty("noUnicodeBiDiControlChars")
  public InstanceValidatorParameters setNoUnicodeBiDiControlChars(boolean noUnicodeBiDiControlChars) {
    this.noUnicodeBiDiControlChars = noUnicodeBiDiControlChars;
    return this;
  }

  public boolean isCrumbTrails() {
    return crumbTrails;
  }

  public InstanceValidatorParameters setCrumbTrails(boolean crumbTrails) {
    this.crumbTrails = crumbTrails;
    return this;
  }

  public boolean isShowMessageIds() {
    return showMessageIds;
  }

  public InstanceValidatorParameters setShowMessageIds(boolean showMessageIds) {
    this.showMessageIds = showMessageIds;
    return this;
  }

  public boolean isAllowExampleUrls() {
    return allowExampleUrls;
  }

  public InstanceValidatorParameters setAllowExampleUrls(boolean allowExampleUrls) {
    this.allowExampleUrls = allowExampleUrls;
    return this;
  }

  @SerializedName("showMessagesFromReferences")
  @JsonProperty("showMessagesFromReferences")
  public boolean isShowMessagesFromReferences() {
    return showMessagesFromReferences;
  }

  @SerializedName("showMessagesFromReferences")
  @JsonProperty("showMessagesFromReferences")
  public InstanceValidatorParameters setShowMessagesFromReferences(boolean showMessagesFromReferences) {
    this.showMessagesFromReferences = showMessagesFromReferences;
    return this;
  }

  @SerializedName("securityChecks")
  @JsonProperty("securityChecks")
  public boolean isSecurityChecks() {
    return securityChecks;
  }

  @SerializedName("securityChecks")
  @JsonProperty("securityChecks")
  public InstanceValidatorParameters setSecurityChecks(boolean securityChecks) {
    this.securityChecks = securityChecks;
    return this;
  }

  @SerializedName("noExperimentalContent")
  @JsonProperty("noExperimentalContent")
  public boolean isNoExperimentalContent() {
    return noExperimentalContent;
  }

  @SerializedName("noExperimentalContent")
  @JsonProperty("noExperimentalContent")
  public InstanceValidatorParameters setNoExperimentalContent(boolean noExperimentalContent) {
    this.noExperimentalContent = noExperimentalContent;
    return this;
  }

  public boolean isShowTerminologyRouting() {
    return showTerminologyRouting;
  }

  public InstanceValidatorParameters setShowTerminologyRouting(boolean showTerminologyRouting) {
    this.showTerminologyRouting = showTerminologyRouting;
    return this;
  }

  @SerializedName("expansionParameters")
  @JsonProperty("expansionParameters")
  public String getExpansionParameters() {
    return expansionParameters;
  }

  @SerializedName("expansionParameters")
  @JsonProperty("expansionParameters")
  public InstanceValidatorParameters setExpansionParameters(String expansionParameters) {
    this.expansionParameters = expansionParameters;
    return this;
  }

  @SerializedName("profiles")
  @JsonProperty("profiles")
  public List<String> getProfiles() {
    return profiles;
  }

  @SerializedName("profiles")
  @JsonProperty("profiles")
  public InstanceValidatorParameters setProfiles(List<String> profiles) {
    this.profiles = profiles;
    return this;
  }

  public InstanceValidatorParameters addProfile(String profile) {
    if (this.profiles == null) {
      this.profiles = new ArrayList<>();
    }
    this.profiles.add(profile);
    return this;
  }

  @JsonProperty("doImplicitFHIRPathStringConversion")
  @SerializedName("doImplicitFHIRPathStringConversion")
  private
  boolean doImplicitFHIRPathStringConversion = false;

  @SerializedName("doImplicitFHIRPathStringConversion")
  @JsonProperty("doImplicitFHIRPathStringConversion")
  public boolean isDoImplicitFHIRPathStringConversion() {
    return doImplicitFHIRPathStringConversion;
  }

  @SerializedName("doImplicitFHIRPathStringConversion")
  @JsonProperty("doImplicitFHIRPathStringConversion")
  public InstanceValidatorParameters setDoImplicitFHIRPathStringConversion(boolean doImplicitFHIRPathStringConversion) {
    this.doImplicitFHIRPathStringConversion = doImplicitFHIRPathStringConversion;
    return this;
  }

  @JsonProperty("allowDoubleQuotesInFHIRPath")
  @SerializedName("allowDoubleQuotesInFHIRPath")
  private
  boolean allowDoubleQuotesInFHIRPath = false;

  @SerializedName("allowDoubleQuotesInFHIRPath")
  @JsonProperty("allowDoubleQuotesInFHIRPath")
  public boolean isAllowDoubleQuotesInFHIRPath() {
    return allowDoubleQuotesInFHIRPath;
  }

  @SerializedName("allowDoubleQuotesInFHIRPath")
  @JsonProperty("allowDoubleQuotesInFHIRPath")
  public InstanceValidatorParameters setAllowDoubleQuotesInFHIRPath(boolean allowDoubleQuotesInFHIRPath) {
    this.allowDoubleQuotesInFHIRPath = allowDoubleQuotesInFHIRPath;
    return this;
  }

  @JsonProperty("checkIPSCodes")
  @SerializedName("checkIPSCodes")
  private
  boolean checkIPSCodes;

  @SerializedName("checkIPSCodes")
  @JsonProperty("checkIPSCodes")
  public boolean isCheckIPSCodes() {
    return checkIPSCodes;
  }

  @SerializedName("checkIPSCodes")
  @JsonProperty("checkIPSCodes")
  public InstanceValidatorParameters setCheckIPSCodes(boolean checkIPSCodes) {
    this.checkIPSCodes = checkIPSCodes;
    return this;
  }

  @JsonProperty("bundleValidationRules")
  @SerializedName("bundleValidationRules")
  private
  List<org.hl7.fhir.r5.utils.validation.BundleValidationRule> bundleValidationRules = new ArrayList<>();

  @SerializedName("bundleValidationRules")
  @JsonProperty("bundleValidationRules")
  public List<org.hl7.fhir.r5.utils.validation.BundleValidationRule> getBundleValidationRules() {
    return bundleValidationRules;
  }

  @SerializedName("bundleValidationRules")
  @JsonProperty("bundleValidationRules")
  public InstanceValidatorParameters setBundleValidationRules(List<org.hl7.fhir.r5.utils.validation.BundleValidationRule> bundleValidationRules) {
    this.bundleValidationRules = bundleValidationRules;
    return this;
  }

  public InstanceValidatorParameters addBundleValidationRule(org.hl7.fhir.r5.utils.validation.BundleValidationRule bundleValidationRule) {
    this.bundleValidationRules.add(bundleValidationRule);
    return this;
  }

  @JsonProperty("jurisdiction")
  @SerializedName("jurisdiction")
  private
  String jurisdiction = org.hl7.fhir.r5.terminologies.JurisdictionUtilities.getJurisdictionFromLocale(java.util.Locale.getDefault().getCountry());

  @SerializedName("jurisdiction")
  @JsonProperty("jurisdiction")
  public String getJurisdiction() {
    return jurisdiction;
  }

  @SerializedName("jurisdiction")
  @JsonProperty("jurisdiction")
  public InstanceValidatorParameters setJurisdiction(String jurisdiction) {
    this.jurisdiction = jurisdiction;
    return this;
  }

  @JsonProperty("maxValidationMessages")
  @SerializedName("maxValidationMessages")
  private
  ValidatorMaxMessages maxValidationMessages = null;

  @SerializedName("maxValidationMessages")
  @JsonProperty("maxValidationMessages")
  public ValidatorMaxMessages getMaxValidationMessages() {
    return maxValidationMessages;
  }

  @SerializedName("maxValidationMessages")
  @JsonProperty("maxValidationMessages")
  public InstanceValidatorParameters setMaxValidationMessages(ValidatorMaxMessages maxValidationMessages) {
    this.maxValidationMessages = maxValidationMessages;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    InstanceValidatorParameters that = (InstanceValidatorParameters) o;
    return assumeValidRestReferences == that.assumeValidRestReferences
      && hintAboutNonMustSupport == that.hintAboutNonMustSupport
      && wantInvariantsInMessages == that.wantInvariantsInMessages
      && noInvariants == that.noInvariants
      && unknownCodeSystemsCauseErrors == that.unknownCodeSystemsCauseErrors
      && forPublication == that.forPublication
      && noUnicodeBiDiControlChars == that.noUnicodeBiDiControlChars
      && crumbTrails == that.crumbTrails
      && showMessageIds == that.showMessageIds
      && allowExampleUrls == that.allowExampleUrls
      && showMessagesFromReferences == that.showMessagesFromReferences
      && securityChecks == that.securityChecks
      && noExperimentalContent == that.noExperimentalContent
      && showTerminologyRouting == that.showTerminologyRouting
      && doImplicitFHIRPathStringConversion == that.doImplicitFHIRPathStringConversion
      && allowDoubleQuotesInFHIRPath == that.allowDoubleQuotesInFHIRPath
      && checkIPSCodes == that.checkIPSCodes
      && Objects.equals(htmlOutput, that.htmlOutput)
      && Objects.equals(outputStyle, that.outputStyle)
      && Objects.equals(r5BundleRelativeReferencePolicy, that.r5BundleRelativeReferencePolicy)
      && Objects.equals(extensions, that.extensions)
      && Objects.equals(questionnaireMode, that.questionnaireMode)
      && Objects.equals(level, that.level)
      && Objects.equals(bestPracticeLevel, that.bestPracticeLevel)
      && Objects.equals(htmlInMarkdownCheck, that.htmlInMarkdownCheck)
      && Objects.equals(expansionParameters, that.expansionParameters)
      && Objects.equals(profiles, that.profiles)
      && Objects.equals(bundleValidationRules, that.bundleValidationRules)
      && Objects.equals(jurisdiction, that.jurisdiction)
      && Objects.equals(maxValidationMessages, that.maxValidationMessages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(assumeValidRestReferences, hintAboutNonMustSupport, htmlOutput, outputStyle, r5BundleRelativeReferencePolicy, extensions, wantInvariantsInMessages, noInvariants, questionnaireMode, unknownCodeSystemsCauseErrors, level, bestPracticeLevel, forPublication, htmlInMarkdownCheck, noUnicodeBiDiControlChars, crumbTrails, showMessageIds, allowExampleUrls, showMessagesFromReferences, securityChecks, noExperimentalContent, showTerminologyRouting, expansionParameters, profiles, doImplicitFHIRPathStringConversion, allowDoubleQuotesInFHIRPath, checkIPSCodes, bundleValidationRules, jurisdiction, maxValidationMessages);
  }

  @Override
  public String toString() {
    return "InstanceValidatorParameters{" +
      "assumeValidRestReferences=" + assumeValidRestReferences +
      ", hintAboutNonMustSupport=" + hintAboutNonMustSupport +
      ", htmlOutput='" + htmlOutput + '\'' +
      ", outputStyle='" + outputStyle + '\'' +
      ", r5BundleRelativeReferencePolicy=" + r5BundleRelativeReferencePolicy +
      ", extensions=" + extensions +
      ", wantInvariantsInMessages=" + wantInvariantsInMessages +
      ", noInvariants=" + noInvariants +
      ", questionnaireMode=" + questionnaireMode +
      ", unknownCodeSystemsCauseErrors=" + unknownCodeSystemsCauseErrors +
      ", level=" + level +
      ", bestPracticeLevel=" + bestPracticeLevel +
      ", forPublication=" + forPublication +
      ", htmlInMarkdownCheck=" + htmlInMarkdownCheck +
      ", noUnicodeBiDiControlChars=" + noUnicodeBiDiControlChars +
      ", crumbTrails=" + crumbTrails +
      ", showMessageIds=" + showMessageIds +
      ", allowExampleUrls=" + allowExampleUrls +
      ", showMessagesFromReferences=" + showMessagesFromReferences +
      ", securityChecks=" + securityChecks +
      ", noExperimentalContent=" + noExperimentalContent +
      ", showTerminologyRouting=" + showTerminologyRouting +
      ", expansionParameters='" + expansionParameters + '\'' +
      ", profiles=" + profiles +
      ", doImplicitFHIRPathStringConversion=" + doImplicitFHIRPathStringConversion +
      ", allowDoubleQuotesInFHIRPath=" + allowDoubleQuotesInFHIRPath +
      ", checkIPSCodes=" + checkIPSCodes +
      ", bundleValidationRules=" + bundleValidationRules +
      ", jurisdiction='" + jurisdiction + '\'' +
      ", maxValidationMessages=" + maxValidationMessages +
      '}';
  }
}
