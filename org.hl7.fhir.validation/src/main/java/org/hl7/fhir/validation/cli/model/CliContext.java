package org.hl7.fhir.validation.cli.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;
import org.hl7.fhir.r5.terminologies.JurisdictionUtilities;
import org.hl7.fhir.r5.utils.validation.BundleValidationRule;
import org.hl7.fhir.r5.utils.validation.constants.BestPracticeWarningLevel;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.settings.FhirSettings;
import org.hl7.fhir.validation.cli.services.ValidatorWatchMode;
import org.hl7.fhir.validation.cli.utils.EngineMode;
import org.hl7.fhir.validation.cli.utils.QuestionnaireMode;
import org.hl7.fhir.validation.cli.utils.ValidationLevel;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A POJO for storing the flags/values for the CLI validator.
 */
public class CliContext {

  @JsonProperty("baseEngine")
  @SerializedName("baseEngine")
  private
  String baseEngine = null;
  @JsonProperty("doNative")
  @SerializedName("doNative")
  private
  boolean doNative = false;
  @JsonProperty("hintAboutNonMustSupport")
  @SerializedName("hintAboutNonMustSupport")
  private
  boolean hintAboutNonMustSupport = false;
  @JsonProperty("recursive")
  @SerializedName("recursive")
  private
  boolean recursive = false;
  @JsonProperty("showMessagesFromReferences")
  @SerializedName("showMessagesFromReferences")
  private
  boolean showMessagesFromReferences = false;
  @JsonProperty("doDebug")
  @SerializedName("doDebug")
  private
  boolean doDebug = false;
  @JsonProperty("assumeValidRestReferences")
  @SerializedName("assumeValidRestReferences")
  private
  boolean assumeValidRestReferences = false;
  @JsonProperty("canDoNative")
  @SerializedName("canDoNative")
  private
  boolean canDoNative = false;
  @JsonProperty("noInternalCaching")
  @SerializedName("noInternalCaching")
  private
  boolean noInternalCaching = false; // internal, for when debugging terminology validation
  @JsonProperty("noExtensibleBindingMessages")
  @SerializedName("noExtensibleBindingMessages")
  private
  boolean noExtensibleBindingMessages = false;
  @JsonProperty("noUnicodeBiDiControlChars")
  @SerializedName("noUnicodeBiDiControlChars")
  private
  boolean noUnicodeBiDiControlChars = false;
  @JsonProperty("noInvariants")
  @SerializedName("noInvariants")
  private
  boolean noInvariants = false;
  @JsonProperty("displayWarnings")
  @SerializedName("displayWarnings")
  private
  boolean displayWarnings = false;
  @JsonProperty("wantInvariantsInMessages")
  @SerializedName("wantInvariantsInMessages")
  private
  boolean wantInvariantsInMessages = false;
  @JsonProperty("doImplicitFHIRPathStringConversion")
  @SerializedName("doImplicitFHIRPathStringConversion")
  private
  boolean doImplicitFHIRPathStringConversion = false;
  @JsonProperty("htmlInMarkdownCheck")
  @SerializedName("htmlInMarkdownCheck")
  private
  HtmlInMarkdownCheck htmlInMarkdownCheck = HtmlInMarkdownCheck.WARNING;
  @JsonProperty("allowDoubleQuotesInFHIRPath")
  @SerializedName("allowDoubleQuotesInFHIRPath")
  private
  boolean allowDoubleQuotesInFHIRPath = false;
  @JsonProperty("disableDefaultResourceFetcher")
  @SerializedName("disableDefaultResourceFetcher")
  private
  boolean disableDefaultResourceFetcher = false;
  @JsonProperty("checkIPSCodes")
  @SerializedName("checkIPSCodes")
  private
  boolean checkIPSCodes;
  @JsonProperty("langTransform")
  @SerializedName("langTransform")
  private
  String langTransform = null;
  @JsonProperty("map")
  @SerializedName("map")
  private
  String map = null;
  @JsonProperty("output")
  @SerializedName("output")
  private
  String output = null;
  @JsonProperty("outputSuffix")
  @SerializedName("outputSuffix")
  private
  String outputSuffix;
  @JsonProperty("htmlOutput")
  @SerializedName("htmlOutput")
  private
  String htmlOutput = null;
  @JsonProperty("txServer")
  @SerializedName("txServer")
  private
  String txServer = FhirSettings.getTxFhirProduction();
  @JsonProperty("sv")
  @SerializedName("sv")
  private
  String sv = null;
  @JsonProperty("txLog")
  @SerializedName("txLog")
  private
  String txLog = null;
  @JsonProperty("txCache")
  @SerializedName("txCache")
  private
  String txCache = null;
  @JsonProperty("mapLog")
  @SerializedName("mapLog")
  private
  String mapLog = null;
  @JsonProperty("lang")
  @SerializedName("lang")
  private
  String lang = null;
  @JsonProperty("fhirpath")
  @SerializedName("fhirpath")
  private
  String fhirpath = null;
  @JsonProperty("snomedCT")
  @SerializedName("snomedCT")
  private
  String snomedCT = "900000000000207008";
  @JsonProperty("targetVer")
  @SerializedName("targetVer")
  private
  String targetVer = null;
  @JsonProperty("packageName")
  @SerializedName("packageName")
  private
  String packageName = null;
  @JsonProperty("noEcosystem")
  @SerializedName("noEcosystem")
  private
  boolean noEcosystem = false;

  @JsonProperty("extensions")
  @SerializedName("extensions")
  private
  List<String> extensions = new ArrayList<String>();
  @JsonProperty("igs")
  @SerializedName("igs")
  private
  List<String> igs = new ArrayList<String>();
  @JsonProperty("questionnaire")
  @SerializedName("questionnaire")
  private
  QuestionnaireMode questionnaireMode = QuestionnaireMode.CHECK;
  @JsonProperty("level")
  @SerializedName("level")
  private
  ValidationLevel level = ValidationLevel.HINTS;
  @JsonProperty("options")
  @SerializedName("options")
  private
  List<String> options = new ArrayList<String>();

  @JsonProperty("profiles")
  @SerializedName("profiles")
  private
  List<String> profiles = new ArrayList<String>();
  @JsonProperty("sources")
  @SerializedName("sources")
  private
  List<String> sources = new ArrayList<String>();
  @JsonProperty("inputs")
  @SerializedName("inputs")
  private
  List<String> inputs = new ArrayList<String>();
  @JsonProperty("modeParams")
  @SerializedName("modeParams")
  private
  List<String> modeParams = new ArrayList<String>();

  @JsonProperty("mode")
  @SerializedName("mode")
  private
  EngineMode mode = EngineMode.VALIDATION;

  @JsonProperty("securityChecks")
  @SerializedName("securityChecks")
  private
  boolean securityChecks = false;

  @JsonProperty("crumbTrails")
  @SerializedName("crumbTrails")
  private
  boolean crumbTrails = false;

  @JsonProperty("showMessageIds")
  @SerializedName("showMessageIds")
  private
  boolean showMessageIds = false;

  @JsonProperty("forPublication")
  @SerializedName("forPublication")
  private
  boolean forPublication = false;

  @JsonProperty("allowExampleUrls")
  @SerializedName("allowExampleUrls")
  private
  boolean allowExampleUrls = false;

  @JsonProperty("showTimes")
  @SerializedName("showTimes")
  private
  boolean showTimes = false;

  @JsonProperty("showTerminologyRouting")
  @SerializedName("showTerminologyRouting")
  private
  boolean showTerminologyRouting = false;

  @JsonProperty("clearTxCache")
  @SerializedName("clearTxCache")
  private
  boolean clearTxCache = false;

  @JsonProperty("locale")
  @SerializedName("locale")
  private
  String locale = Locale.ENGLISH.toLanguageTag();

  @JsonProperty("locations")
  @SerializedName("locations")
  private
  Map<String, String> locations = new HashMap<String, String>();

  @JsonProperty("outputStyle")
  @SerializedName("outputStyle")
  private
  String outputStyle = null;

  @JsonProperty("bundleValidationRules")
  @SerializedName("bundleValidationRules")
  private
  List<BundleValidationRule> bundleValidationRules = new ArrayList<>();

  @JsonProperty("jurisdiction")
  @SerializedName("jurisdiction")
  private
  String jurisdiction = JurisdictionUtilities.getJurisdictionFromLocale(Locale.getDefault().getCountry());
  @JsonProperty("srcLang")
  @SerializedName("srcLang")
  private
  String srcLang = null;
  @JsonProperty("tgtLang")
  @SerializedName("tgtLang")
  private
  String tgtLang = null;

  @JsonProperty("fhirSettingsFile")
  @SerializedName("fhirSettingsFile")
  private
  String fhirSettingsFile;

  @JsonProperty("watchMode")
  @SerializedName("watchMode")
  private
  ValidatorWatchMode watchMode = ValidatorWatchMode.NONE;

  @JsonProperty("watchScanDelay")
  @SerializedName("watchScanDelay")
  private
  int watchScanDelay = 1000;

  @JsonProperty("watchSettleTime")
  @SerializedName("watchSettleTime")
  private
  int watchSettleTime = 100;

  @JsonProperty("bestPracticeLevel")
  @SerializedName("bestPracticeLevel")
  private
  BestPracticeWarningLevel bestPracticeLevel = BestPracticeWarningLevel.Warning;

  @JsonProperty("unknownCodeSystemsCauseErrors")
  @SerializedName("unknownCodeSystemsCauseErrors")
  private
  boolean unknownCodeSystemsCauseErrors;

  @JsonProperty("noExperimentalContent")
  @SerializedName("noExperimentalContent")
  private
  boolean noExperimentalContent;

  @JsonProperty("advisorFile")
  @SerializedName("advisorFile")
  private
  String advisorFile;

  @SerializedName("baseEngine")
  @JsonProperty("baseEngine")
  public String getBaseEngine() {
    return baseEngine;
  }

  @SerializedName("baseEngine")
  @JsonProperty("baseEngine")
  public CliContext setBaseEngine(String baseEngine) {
    this.baseEngine = baseEngine;
    return this;
  }

  @SerializedName("map")
  @JsonProperty("map")
  public String getMap() {
    return map;
  }

  @SerializedName("map")
  @JsonProperty("map")
  public CliContext setMap(String map) {
    this.map = map;
    return this;
  }


  @SerializedName("langTransform")
  @JsonProperty("langTransform")
  public String getLangTransform() {
    return langTransform;
  }

  @SerializedName("langTransform")
  @JsonProperty("langTransform")
  public CliContext setLangTransform(String langTransform) {
    this.langTransform = langTransform;
    return this;
  }

  @SerializedName("igs")
  @JsonProperty("igs")
  public List<String> getIgs() {
    return igs;
  }

  @SerializedName("igs")
  @JsonProperty("igs")
  public CliContext setIgs(List<String> igs) {
    this.igs = igs;
    return this;
  }

  @SerializedName("bundleValidationRules")
  @JsonProperty("bundleValidationRules")
  public List<BundleValidationRule> getBundleValidationRules() {
    return bundleValidationRules;
  }

  @SerializedName("bundleValidationRules")
  @JsonProperty("bundleValidationRules")
  public CliContext setBundleValidationRules(List<BundleValidationRule> bundleValidationRules) {
    this.bundleValidationRules = bundleValidationRules;
    return this;
  }

  public CliContext addIg(String ig) {
    if (this.igs == null) {
      this.igs = new ArrayList<>();
    }
    this.igs.add(ig);
    return this;
  }

  @SerializedName("questionnaire")
  @JsonProperty("questionnaire")
  public QuestionnaireMode getQuestionnaireMode() {
    return questionnaireMode;
  }

  @SerializedName("questionnaire")
  @JsonProperty("questionnaire")
  public CliContext setQuestionnaireMode(QuestionnaireMode questionnaireMode) {
    this.questionnaireMode = questionnaireMode;
    return this;
  }

  @SerializedName("level")
  @JsonProperty("level")
  public ValidationLevel getLevel() {
    return level;
  }

  @SerializedName("level")
  @JsonProperty("level")
  public CliContext setLevel(ValidationLevel level) {
    this.level = level;
    return this;
  }

  @SerializedName("txServer")
  @JsonProperty("txServer")
  public String getTxServer() {
    return txServer;
  }

  @SerializedName("txServer")
  @JsonProperty("txServer")
  public CliContext setTxServer(String txServer) {
    this.txServer = txServer;
    return this;
  }

  @SerializedName("noEcosystem")
  @JsonProperty("noEcosystem")
  public boolean getNoEcosystem() {
    return noEcosystem;
  }

  @SerializedName("noEcosystem")
  @JsonProperty("noEcosystem")
  public CliContext setNoEcosystem(boolean noEcosystem) {
    this.noEcosystem = noEcosystem;
    return this;
  }

  @SerializedName("doNative")
  @JsonProperty("doNative")
  public boolean isDoNative() {
    return doNative;
  }

  @SerializedName("doNative")
  @JsonProperty("doNative")
  public CliContext setDoNative(boolean doNative) {
    this.doNative = doNative;
    return this;
  }

  @SerializedName("extensions")
  @JsonProperty("extensions")
  public List<String> getExtensions() {
    return extensions;
  }

  @SerializedName("extensions")
  @JsonProperty("extensions")
  public CliContext setExtensions(List<String> extensions) {
    this.extensions = extensions;
    return this;
  }

  @SerializedName("hintAboutNonMustSupport")
  @JsonProperty("hintAboutNonMustSupport")
  public boolean isHintAboutNonMustSupport() {
    return hintAboutNonMustSupport;
  }

  @SerializedName("hintAboutNonMustSupport")
  @JsonProperty("hintAboutNonMustSupport")
  public CliContext setHintAboutNonMustSupport(boolean hintAboutNonMustSupport) {
    this.hintAboutNonMustSupport = hintAboutNonMustSupport;
    return this;
  }

  @SerializedName("recursive")
  @JsonProperty("recursive")
  public boolean isRecursive() {
    return recursive;
  }

  @SerializedName("recursive")
  @JsonProperty("recursive")
  public CliContext setRecursive(boolean recursive) {
    this.recursive = recursive;
    return this;
  }

  @SerializedName("showMessagesFromReferences")
  @JsonProperty("showMessagesFromReferences")
  public boolean isShowMessagesFromReferences() {
    return showMessagesFromReferences;
  }

  @SerializedName("showMessagesFromReferences")
  @JsonProperty("showMessagesFromReferences")
  public CliContext setShowMessagesFromReferences(boolean showMessagesFromReferences) {
    this.showMessagesFromReferences = showMessagesFromReferences;
    return this;
  }

  @SerializedName("doImplicitFHIRPathStringConversion")
  @JsonProperty("doImplicitFHIRPathStringConversion")
  public boolean isDoImplicitFHIRPathStringConversion() {
    return doImplicitFHIRPathStringConversion;
  }

  @SerializedName("doImplicitFHIRPathStringConversion")
  @JsonProperty("doImplicitFHIRPathStringConversion")
  public void setDoImplicitFHIRPathStringConversion(boolean doImplicitFHIRPathStringConversion) {
    this.doImplicitFHIRPathStringConversion = doImplicitFHIRPathStringConversion;
  }

  @SerializedName("htmlInMarkdownCheck")
  @JsonProperty("htmlInMarkdownCheck")
  public HtmlInMarkdownCheck getHtmlInMarkdownCheck() {
    return htmlInMarkdownCheck;
  }

  @SerializedName("htmlInMarkdownCheck")
  @JsonProperty("htmlInMarkdownCheck")
  public void setHtmlInMarkdownCheck(HtmlInMarkdownCheck htmlInMarkdownCheck) {
    this.htmlInMarkdownCheck = htmlInMarkdownCheck;
  }

  @SerializedName("allowDoubleQuotesInFHIRPath")
  @JsonProperty("allowDoubleQuotesInFHIRPath")
  public boolean isAllowDoubleQuotesInFHIRPath() {
    return allowDoubleQuotesInFHIRPath;
  }

  @SerializedName("allowDoubleQuotesInFHIRPath")
  @JsonProperty("allowDoubleQuotesInFHIRPath")
  public void setAllowDoubleQuotesInFHIRPath(boolean allowDoubleQuotesInFHIRPath) {
    this.allowDoubleQuotesInFHIRPath = allowDoubleQuotesInFHIRPath;
  }

  @SerializedName("disableDefaultResourceFetcher")
  @JsonProperty("disableDefaultResourceFetcher")
  public boolean isDisableDefaultResourceFetcher() {
    return disableDefaultResourceFetcher;
  }

  @SerializedName("disableDefaultResourceFetcher")
  @JsonProperty("disableDefaultResourceFetcher")
  public CliContext setDisableDefaultResourceFetcher(boolean disableDefaultResourceFetcher) {
    this.disableDefaultResourceFetcher = disableDefaultResourceFetcher;
    return this;
  }

  @SerializedName("checkIPSCodes")
  @JsonProperty("checkIPSCodes")
  public boolean isCheckIPSCodes() {
    return checkIPSCodes;
  }

  @SerializedName("checkIPSCodes")
  @JsonProperty("checkIPSCodes")
  public CliContext setCheckIPSCodes(boolean checkIPSCodes) {
    this.checkIPSCodes = checkIPSCodes;
    return this;
  }


  @SerializedName("locale")
  @JsonProperty("locale")
  public String getLanguageCode() {
    return locale;
  }

  public Locale getLocale() {
    return Locale.forLanguageTag(this.locale);
  }

  @SerializedName("locale")
  @JsonProperty("locale")
  public CliContext setLocale(String languageString) {
    this.locale = languageString;
    return this;
  }

  public CliContext setLocale(Locale locale) {
    this.locale = locale.getLanguage();
    return this;
  }

  @SerializedName("profiles")
  @JsonProperty("profiles")
  public List<String> getProfiles() {
    return profiles;
  }

  @SerializedName("profiles")
  @JsonProperty("profiles")
  public CliContext setProfiles(List<String> profiles) {
    this.profiles = profiles;
    return this;
  }

  public CliContext addProfile(String profile) {
    if (this.profiles == null) {
      this.profiles = new ArrayList<>();
    }
    this.profiles.add(profile);
    return this;
  }

  @SerializedName("options")
  @JsonProperty("options")
  public List<String> getOptions() {
    return options;
  }

  @SerializedName("options")
  @JsonProperty("options")
  public CliContext setOptions(List<String> options) {
    this.options = options;
    return this;
  }

  public CliContext addOption(String option) {
    if (this.options == null) {
      this.options = new ArrayList<>();
    }
    this.options.add(option);
    return this;
  }

  @SerializedName("mode")
  @JsonProperty("mode")
  public EngineMode getMode() {
    return mode;
  }

  @SerializedName("mode")
  @JsonProperty("mode")
  public CliContext setMode(EngineMode mode) {
    this.mode = mode;
    return this;
  }

  @SerializedName("output")
  @JsonProperty("output")
  public String getOutput() {
    return output;
  }

  @SerializedName("output")
  @JsonProperty("output")
  public CliContext setOutput(String output) {
    this.output = output;
    return this;
  }

  @SerializedName("outputSuffix")
  @JsonProperty("outputSuffix")
  public String getOutputSuffix() {
    return outputSuffix;
  }

  @SerializedName("outputSuffix")
  @JsonProperty("outputSuffix")
  public CliContext setOutputSuffix(String outputSuffix) {
    this.outputSuffix = outputSuffix;
    return this;
  }

  @SerializedName("htmlOutput")
  @JsonProperty("htmlOutput")
  public String getHtmlOutput() {
    return htmlOutput;
  }

  @SerializedName("htmlOutput")
  @JsonProperty("htmlOutput")
  public CliContext setHtmlOutput(String htmlOutput) {
    this.htmlOutput = htmlOutput;
    return this;
  }

  @SerializedName("canDoNative")
  @JsonProperty("canDoNative")
  public boolean getCanDoNative() {
    return canDoNative;
  }

  @SerializedName("canDoNative")
  @JsonProperty("canDoNative")
  public CliContext setCanDoNative(boolean canDoNative) {
    this.canDoNative = canDoNative;
    return this;
  }

  @SerializedName("sources")
  @JsonProperty("sources")
  public List<String> getSources() {
    return sources;
  }

  @SerializedName("inputs")
  @JsonProperty("inputs")
  public List<String> getInputs() {
    return inputs;
  }


  @SerializedName("modeParams")
  @JsonProperty("modeParams")
  public List<String> getModeParams() {
    return modeParams;
  }

  @SerializedName("sources")
  @JsonProperty("sources")
  public CliContext setSources(List<String> sources) {
    this.sources = sources;
    return this;
  }

  public CliContext addSource(String source) {
    if (this.sources == null) {
      this.sources = new ArrayList<>();
    }
    this.sources.add(source);
    return this;
  }

  @SerializedName("locations")
  @JsonProperty("locations")
  public Map<String, String> getLocations() {
    return locations;
  }

  @SerializedName("locations")
  @JsonProperty("locations")
  public CliContext setLocations(Map<String, String> locations) {
    this.locations = locations;
    return this;
  }

  public CliContext addLocation(String profile, String location) {
    this.locations.put(profile, location);
    return this;
  }

  @SerializedName("sv")
  @JsonProperty("sv")
  public String getSv() {
    return sv;
  }

  @SerializedName("sv")
  @JsonProperty("sv")
  public CliContext setSv(String sv) {
    if (sv != null && (sv.startsWith("R") || sv.startsWith("r"))) {
      this.sv = VersionUtilities.versionFromCode(sv.toLowerCase());
    } else {
      this.sv = sv;
    }
    return this;
  }

  @SerializedName("txLog")
  @JsonProperty("txLog")
  public String getTxLog() {
    return txLog;
  }

  @SerializedName("txLog")
  @JsonProperty("txLog")
  public CliContext setTxLog(String txLog) {
    this.txLog = txLog;
    return this;
  }

  @SerializedName("txCache")
  @JsonProperty("txCache")
  public String getTxCache() {
    return txCache;
  }

  @SerializedName("txCache")
  @JsonProperty("txCache")
  public CliContext setTxCache(String txCache) {
    this.txCache = txCache;
    return this;
  }

  @SerializedName("mapLog")
  @JsonProperty("mapLog")
  public String getMapLog() {
    return mapLog;
  }

  @SerializedName("mapLog")
  @JsonProperty("mapLog")
  public CliContext setMapLog(String mapLog) {
    this.mapLog = mapLog;
    return this;
  }

  @SerializedName("lang")
  @JsonProperty("lang")
  public String getLang() {
    return lang;
  }

  @SerializedName("lang")
  @JsonProperty("lang")
  public CliContext setLang(String lang) {
    this.lang = lang;
    return this;
  }

  @SerializedName("fhirpath")
  @JsonProperty("fhirpath")
  public String getFhirpath() {
    return fhirpath;
  }

  @SerializedName("fhirpath")
  @JsonProperty("fhirpath")
  public CliContext setFhirpath(String fhirpath) {
    this.fhirpath = fhirpath;
    return this;
  }


  @SerializedName("snomedCT")
  @JsonProperty("snomedCT")
  public String getSnomedCTCode() {
    if ("intl".equals(snomedCT)) return "900000000000207008";
    if ("us".equals(snomedCT)) return "731000124108";
    if ("uk".equals(snomedCT)) return "999000041000000102";
    if ("au".equals(snomedCT)) return "32506021000036107";
    if ("ca".equals(snomedCT)) return "20611000087101";
    if ("nl".equals(snomedCT)) return "11000146104";
    if ("se".equals(snomedCT)) return "45991000052106";
    if ("es".equals(snomedCT)) return "449081005";
    if ("dk".equals(snomedCT)) return "554471000005108";
    return snomedCT;
  }

  @SerializedName("snomedCT")
  @JsonProperty("snomedCT")
  public CliContext setSnomedCT(String snomedCT) {
    this.snomedCT = snomedCT;
    return this;
  }

  @SerializedName("targetVer")
  @JsonProperty("targetVer")
  public String getTargetVer() {
    return targetVer;
  }

  @SerializedName("targetVer")
  @JsonProperty("targetVer")
  public CliContext setTargetVer(String targetVer) {
    this.targetVer = targetVer;
    return this;
  }

  @SerializedName("packageName")
  @JsonProperty("packageName")
  public String getPackageName() {
    return packageName;
  }

  @SerializedName("packageName")
  @JsonProperty("packageName")
  public CliContext setPackageName(String packageName) {
    this.packageName = packageName;
    return this;
  }

  @SerializedName("doDebug")
  @JsonProperty("doDebug")
  public boolean isDoDebug() {
    return doDebug;
  }

  @SerializedName("doDebug")
  @JsonProperty("doDebug")
  public CliContext setDoDebug(boolean doDebug) {
    this.doDebug = doDebug;
    return this;
  }

  @SerializedName("assumeValidRestReferences")
  @JsonProperty("assumeValidRestReferences")
  public boolean isAssumeValidRestReferences() {
    return assumeValidRestReferences;
  }

  @SerializedName("assumeValidRestReferences")
  @JsonProperty("assumeValidRestReferences")
  public CliContext setAssumeValidRestReferences(boolean assumeValidRestReferences) {
    this.assumeValidRestReferences = assumeValidRestReferences;
    return this;
  }

  @SerializedName("noInternalCaching")
  @JsonProperty("noInternalCaching")
  public boolean isNoInternalCaching() {
    return noInternalCaching;
  }

  @SerializedName("noInternalCaching")
  @JsonProperty("noInternalCaching")
  public CliContext setNoInternalCaching(boolean noInternalCaching) {
    this.noInternalCaching = noInternalCaching;
    return this;
  }

  @SerializedName("noExtensibleBindingMessages")
  @JsonProperty("noExtensibleBindingMessages")
  public boolean isNoExtensibleBindingMessages() {
    return noExtensibleBindingMessages;
  }

  @SerializedName("noExtensibleBindingMessages")
  @JsonProperty("noExtensibleBindingMessages")
  public CliContext setNoExtensibleBindingMessages(boolean noExtensibleBindingMessages) {
    this.noExtensibleBindingMessages = noExtensibleBindingMessages;
    return this;
  }

  @SerializedName("noInvariants")
  @JsonProperty("noInvariants")
  public boolean isNoInvariants() {
    return noInvariants;
  }

  @SerializedName("noInvariants")
  @JsonProperty("noInvariants")
  public void setNoInvariants(boolean noInvariants) {
    this.noInvariants = noInvariants;
  }

  @SerializedName("displayWarnings")
  @JsonProperty("displayWarnings")
  public boolean isDisplayWarnings() {
    return displayWarnings;
  }

  @SerializedName("displayWarnings")
  @JsonProperty("displayWarnings")
  public void setDisplayWarnings(boolean displayWarnings) {
    this.displayWarnings = displayWarnings;
  }

  @SerializedName("wantInvariantsInMessages")
  @JsonProperty("wantInvariantsInMessages")
  public boolean isWantInvariantsInMessages() {
    return wantInvariantsInMessages;
  }

  @SerializedName("wantInvariantsInMessages")
  @JsonProperty("wantInvariantsInMessages")
  public void setWantInvariantsInMessages(boolean wantInvariantsInMessages) {
    this.wantInvariantsInMessages = wantInvariantsInMessages;
  }

  @SerializedName("securityChecks")
  @JsonProperty("securityChecks")
  public boolean isSecurityChecks() {
    return securityChecks;
  }

  @SerializedName("securityChecks")
  @JsonProperty("securityChecks")
  public CliContext setSecurityChecks(boolean securityChecks) {
    this.securityChecks = securityChecks;
    return this;
  }

  public boolean isCrumbTrails() {
    return crumbTrails;
  }

  public void setCrumbTrails(boolean crumbTrails) {
    this.crumbTrails = crumbTrails;
  }

  public boolean isShowMessageIds() {
    return showMessageIds;
  }

  public void setShowMessageIds(boolean showMessageIds) {
    this.showMessageIds = showMessageIds;
  }

  public boolean isForPublication() {
    return forPublication;
  }

  public void setForPublication(boolean forPublication) {
    this.forPublication = forPublication;
  }

  public boolean isAllowExampleUrls() {
    return allowExampleUrls;
  }

  public void setAllowExampleUrls(boolean allowExampleUrls) {
    this.allowExampleUrls = allowExampleUrls;
  }

  public boolean isShowTimes() {
    return showTimes;
  }

  public void setShowTimes(boolean showTimes) {
    this.showTimes = showTimes;
  }

  public boolean isShowTerminologyRouting() {
    return showTerminologyRouting;
  }

  public void setShowTerminologyRouting(boolean showTerminologyRouting) {
    this.showTerminologyRouting = showTerminologyRouting;
  }

  public boolean isClearTxCache() {
    return clearTxCache;
  }

  public void setClearTxCache(boolean clearTxCache) {
    this.clearTxCache = clearTxCache;
  }

  public String getOutputStyle() {
    return outputStyle;
  }

  public void setOutputStyle(String outputStyle) {
    this.outputStyle = outputStyle;
  }

  public boolean isNoUnicodeBiDiControlChars() {
    return noUnicodeBiDiControlChars;
  }

  public void setNoUnicodeBiDiControlChars(boolean noUnicodeBiDiControlChars) {
    this.noUnicodeBiDiControlChars = noUnicodeBiDiControlChars;
  }

  public String getJurisdiction() {
    return jurisdiction;
  }

  public void setJurisdiction(String jurisdiction) {
    this.jurisdiction = jurisdiction;
  }


  public String getSrcLang() {
    return srcLang;
  }

  public void setSrcLang(String srcLang) {
    this.srcLang = srcLang;
  }

  public String getTgtLang() {
    return tgtLang;
  }

  public void setTgtLang(String tgtLang) {
    this.tgtLang = tgtLang;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CliContext that = (CliContext) o;
    return Objects.equals(baseEngine, that.baseEngine) &&
      doNative == that.doNative &&
      hintAboutNonMustSupport == that.hintAboutNonMustSupport &&
      recursive == that.recursive &&
      doDebug == that.doDebug &&
      assumeValidRestReferences == that.assumeValidRestReferences &&
      canDoNative == that.canDoNative &&
      noInternalCaching == that.noInternalCaching &&
      noExtensibleBindingMessages == that.noExtensibleBindingMessages &&
      noUnicodeBiDiControlChars == that.noUnicodeBiDiControlChars &&
      noInvariants == that.noInvariants &&
      displayWarnings == that.displayWarnings &&
      wantInvariantsInMessages == that.wantInvariantsInMessages &&
      allowDoubleQuotesInFHIRPath == that.allowDoubleQuotesInFHIRPath &&
      checkIPSCodes == that.checkIPSCodes &&
      Objects.equals(extensions, that.extensions) &&
      Objects.equals(map, that.map) &&
      Objects.equals(htmlInMarkdownCheck, that.htmlInMarkdownCheck) &&
      Objects.equals(output, that.output) &&
      Objects.equals(outputSuffix, that.outputSuffix) &&
      Objects.equals(htmlOutput, that.htmlOutput) &&
      Objects.equals(txServer, that.txServer) &&
      Objects.equals(sv, that.sv) &&
      Objects.equals(txLog, that.txLog) &&
      Objects.equals(txCache, that.txCache) &&
      Objects.equals(mapLog, that.mapLog) &&
      Objects.equals(lang, that.lang) &&
      Objects.equals(srcLang, that.srcLang) &&
      Objects.equals(tgtLang, that.tgtLang) &&
      Objects.equals(fhirpath, that.fhirpath) &&
      Objects.equals(snomedCT, that.snomedCT) &&
      Objects.equals(targetVer, that.targetVer) &&
      Objects.equals(packageName, that.packageName) &&
      Objects.equals(igs, that.igs) &&
      Objects.equals(questionnaireMode, that.questionnaireMode) &&
      Objects.equals(level, that.level) &&
      Objects.equals(profiles, that.profiles) &&
      Objects.equals(options, that.options) &&
      Objects.equals(sources, that.sources) &&
      Objects.equals(crumbTrails, that.crumbTrails) &&
      Objects.equals(showMessageIds, that.showMessageIds) &&
      Objects.equals(forPublication, that.forPublication) &&
      Objects.equals(allowExampleUrls, that.allowExampleUrls) &&
      Objects.equals(showTimes, that.showTimes) &&
      mode == that.mode &&
      Objects.equals(locale, that.locale) &&
      Objects.equals(outputStyle, that.outputStyle) &&
      Objects.equals(jurisdiction, that.jurisdiction) &&
      Objects.equals(locations, that.locations) &&
      Objects.equals(watchMode, that.watchMode) &&
      Objects.equals(bestPracticeLevel, that.bestPracticeLevel) &&
      Objects.equals(watchScanDelay, that.watchScanDelay) &&
      Objects.equals(unknownCodeSystemsCauseErrors, that.unknownCodeSystemsCauseErrors) &&
      Objects.equals(noExperimentalContent, that.noExperimentalContent) &&
      Objects.equals(advisorFile, that.advisorFile) &&
      Objects.equals(watchSettleTime, that.watchSettleTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseEngine, doNative, extensions, hintAboutNonMustSupport, recursive, doDebug, assumeValidRestReferences, canDoNative, noInternalCaching,
      noExtensibleBindingMessages, noInvariants, displayWarnings, wantInvariantsInMessages, map, output, outputSuffix, htmlOutput, txServer, sv, txLog, txCache, mapLog, lang, srcLang, tgtLang, fhirpath, snomedCT,
      targetVer, packageName, igs, questionnaireMode, level, profiles, options, sources, inputs, mode, locale, locations, crumbTrails, showMessageIds, forPublication, showTimes, allowExampleUrls, outputStyle, jurisdiction, noUnicodeBiDiControlChars,
      watchMode, watchScanDelay, watchSettleTime, bestPracticeLevel, unknownCodeSystemsCauseErrors, noExperimentalContent, advisorFile, htmlInMarkdownCheck, allowDoubleQuotesInFHIRPath, checkIPSCodes);
  }

  @Override
  public String toString() {
    return "CliContext{" +
      "baseEngine=" + baseEngine +
      ", doNative=" + doNative +
      ", extensions=" + extensions +
      ", hintAboutNonMustSupport=" + hintAboutNonMustSupport +
      ", recursive=" + recursive +
      ", doDebug=" + doDebug +
      ", assumeValidRestReferences=" + assumeValidRestReferences +
      ", canDoNative=" + canDoNative +
      ", noInternalCaching=" + noInternalCaching +
      ", noExtensibleBindingMessages=" + noExtensibleBindingMessages +
      ", noUnicodeBiDiControlChars=" + noUnicodeBiDiControlChars +
      ", noInvariants=" + noInvariants +
      ", displayWarnings=" + displayWarnings +
      ", wantInvariantsInMessages=" + wantInvariantsInMessages +
      ", map='" + map + '\'' +
      ", output='" + output + '\'' +
      ", outputSuffix='" + output + '\'' +
      ", htmlOutput='" + htmlOutput + '\'' +
      ", txServer='" + txServer + '\'' +
      ", sv='" + sv + '\'' +
      ", txLog='" + txLog + '\'' +
      ", txCache='" + txCache + '\'' +
      ", mapLog='" + mapLog + '\'' +
      ", lang='" + lang + '\'' +
      ", srcLang='" + srcLang + '\'' +
      ", tgtLang='" + tgtLang + '\'' +
      ", fhirpath='" + fhirpath + '\'' +
      ", snomedCT='" + snomedCT + '\'' +
      ", targetVer='" + targetVer + '\'' +
      ", packageName='" + packageName + '\'' +
      ", igs=" + igs +
      ", questionnaireMode=" + questionnaireMode +
      ", level=" + level +
      ", profiles=" + profiles +
      ", options=" + options +
      ", sources=" + sources +
      ", inputs=" + inputs +
      ", mode=" + mode +
      ", securityChecks=" + securityChecks +
      ", crumbTrails=" + crumbTrails +
      ", showMessageIds=" + showMessageIds +
      ", forPublication=" + forPublication +
      ", outputStyle=" + outputStyle +
      ", jurisdiction=" + jurisdiction +
      ", allowExampleUrls=" + allowExampleUrls +
      ", showTimes=" + showTimes +
      ", locale='" + locale + '\'' +
      ", locations=" + locations +
      ", bundleValidationRules=" + bundleValidationRules +
      ", htmlInMarkdownCheck=" + htmlInMarkdownCheck +
      ", allowDoubleQuotesInFHIRPath=" + allowDoubleQuotesInFHIRPath +
      ", checkIPSCodes=" + checkIPSCodes +
      ", watchMode=" + watchMode +
      ", bestPracticeLevel=" + bestPracticeLevel +
      ", watchSettleTime=" + watchSettleTime +
      ", watchScanDelay=" + watchScanDelay +
      ", unknownCodeSystemsCauseErrors=" + unknownCodeSystemsCauseErrors +
      ", noExperimentalContent=" + noExperimentalContent +
      ", advisorFile=" + advisorFile +
      '}';
  }

  @SerializedName("fhirSettingsFile")
  @JsonProperty("fhirSettingsFile")
  public CliContext setFhirSettingsFile(String fhirSettingsFile) {
    this.fhirSettingsFile = fhirSettingsFile;
    return this;
  }

  @SerializedName("fhirSettingsFile")
  @JsonProperty("fhirSettingsFile")
  public String getFhirSettingsFile() {
    return fhirSettingsFile;
  }

  @SerializedName("watchMode")
  @JsonProperty("watchMode")
  public ValidatorWatchMode getWatchMode() {
    return watchMode;
  }

  @SerializedName("watchMode")
  @JsonProperty("watchMode")
  public CliContext setWatchMode(ValidatorWatchMode watchMode) {
    this.watchMode = watchMode;
    return this;
  }

  @SerializedName("watchScanDelay")
  @JsonProperty("watchScanDelay")
  public int getWatchScanDelay() {
    return watchScanDelay;
  }

  @SerializedName("watchScanDelay")
  @JsonProperty("watchScanDelay")
  public void setWatchScanDelay(int watchScanDelay) {
    this.watchScanDelay = watchScanDelay;
  }

  @SerializedName("watchSettleTime")
  @JsonProperty("watchSettleTime")
  public int getWatchSettleTime() {
    return watchSettleTime;
  }

  @SerializedName("watchSettleTime")
  @JsonProperty("watchSettleTime")
  public void setWatchSettleTime(int watchSettleTime) {
    this.watchSettleTime = watchSettleTime;
  }


  @SerializedName("bestPracticeLevel")
  @JsonProperty("bestPracticeLevel")
  public BestPracticeWarningLevel getBestPracticeLevel() {
    return bestPracticeLevel;
  }

  @SerializedName("bestPracticeLevel")
  @JsonProperty("bestPracticeLevel")
  public CliContext setBestPracticeLevel(BestPracticeWarningLevel bestPracticeLevel) {
    this.bestPracticeLevel = bestPracticeLevel;
    return this;
  }


  @SerializedName("unknownCodeSystemsCauseErrors")
  @JsonProperty("unknownCodeSystemsCauseErrors")
  public boolean isUnknownCodeSystemsCauseErrors() {
    return unknownCodeSystemsCauseErrors;
  }


  @SerializedName("unknownCodeSystemsCauseErrors")
  @JsonProperty("unknownCodeSystemsCauseErrors")
  public void setUnknownCodeSystemsCauseErrors(boolean unknownCodeSystemsCauseErrors) {
    this.unknownCodeSystemsCauseErrors = unknownCodeSystemsCauseErrors;
  }

  @SerializedName("noExperimentalContent")
  @JsonProperty("noExperimentalContent")
  public boolean isNoExperimentalContent() {
    return noExperimentalContent;
  }


  @SerializedName("noExperimentalContent")
  @JsonProperty("noExperimentalContent")
  public void setNoExperimentalContent(boolean noExperimentalContent) {
    this.noExperimentalContent = noExperimentalContent;
  }

  @SerializedName("advisorFile")
  @JsonProperty("advisorFile")
  public String getAdvisorFile() {
    return advisorFile;
  }

  @SerializedName("advisorFile")
  @JsonProperty("advisorFile")
  public void setAdvisorFile(String advisorFile) {
    this.advisorFile = advisorFile;
  }


}