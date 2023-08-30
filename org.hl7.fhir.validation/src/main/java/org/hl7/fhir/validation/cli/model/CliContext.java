package org.hl7.fhir.validation.cli.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import org.hl7.fhir.r5.terminologies.JurisdictionUtilities;
import org.hl7.fhir.r5.utils.validation.BundleValidationRule;

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

  @JsonProperty("doNative")
  private boolean doNative = false;
  @JsonProperty("hintAboutNonMustSupport")
  private boolean hintAboutNonMustSupport = false;
  @JsonProperty("recursive")
  private boolean recursive = false;
  @JsonProperty("showMessagesFromReferences")
  private boolean showMessagesFromReferences = false;
  @JsonProperty("doDebug")
  private boolean doDebug = false;
  @JsonProperty("assumeValidRestReferences")
  private boolean assumeValidRestReferences = false;
  @JsonProperty("canDoNative")
  private boolean canDoNative = false;
  @JsonProperty("noInternalCaching")
  private boolean noInternalCaching = false; // internal, for when debugging terminology validation
  @JsonProperty("noExtensibleBindingMessages")
  private boolean noExtensibleBindingMessages = false;
  @JsonProperty("noUnicodeBiDiControlChars")
  private boolean noUnicodeBiDiControlChars = false;
  @JsonProperty("noInvariants")
  private boolean noInvariants = false;
  @JsonProperty("displayWarnings")
  private boolean displayWarnings = false;
  @JsonProperty("wantInvariantsInMessages")
  private boolean wantInvariantsInMessages = false;
  @JsonProperty("doImplicitFHIRPathStringConversion")
  private boolean doImplicitFHIRPathStringConversion = false;
  @JsonProperty("htmlInMarkdownCheck")
  private HtmlInMarkdownCheck htmlInMarkdownCheck = HtmlInMarkdownCheck.WARNING;
  @JsonProperty("allowDoubleQuotesInFHIRPath")  
  private boolean allowDoubleQuotesInFHIRPath = false;
  @JsonProperty("langTransform")
  private String langTransform = null;
  @JsonProperty("map")
  private String map = null;
  @JsonProperty("output")
  private String output = null;
  @JsonProperty("outputSuffix")
  private String outputSuffix;
  @JsonProperty("htmlOutput")
  private String htmlOutput = null;
  @JsonProperty("txServer")
  private String txServer = FhirSettings.getTxFhirProduction();
  @JsonProperty("sv")
  private String sv = null;
  @JsonProperty("txLog")
  private String txLog = null;
  @JsonProperty("txCache")
  private String txCache = null;
  @JsonProperty("mapLog")
  private String mapLog = null;
  @JsonProperty("lang")
  private String lang = null;
  @JsonProperty("fhirpath")
  private String fhirpath = null;
  @JsonProperty("snomedCT")
  private String snomedCT = "900000000000207008";
  @JsonProperty("targetVer")
  private String targetVer = null;

  @JsonProperty("extensions")
  private List<String> extensions = new ArrayList<String>();
  @JsonProperty("igs")
  private List<String> igs = new ArrayList<String>();
  @JsonProperty("questionnaire")
  private QuestionnaireMode questionnaireMode = QuestionnaireMode.CHECK;
  @JsonProperty("level")
  private ValidationLevel level = ValidationLevel.HINTS;
  
  @JsonProperty("profiles")
  private List<String> profiles = new ArrayList<String>();
  @JsonProperty("sources")
  private List<String> sources = new ArrayList<String>();
  @JsonProperty("inputs")
  private List<String> inputs = new ArrayList<String>();

  @JsonProperty("mode")
  private EngineMode mode = EngineMode.VALIDATION;

  @JsonProperty("securityChecks")
  private boolean securityChecks = false;
  
  @JsonProperty("crumbTrails")
  private boolean crumbTrails = false;
  
  @JsonProperty("forPublication")
  private boolean forPublication = false;
  
  @JsonProperty("allowExampleUrls")
  private boolean allowExampleUrls = false;
  
  @JsonProperty("showTimes")
  private boolean showTimes = false;
  
  @JsonProperty("locale")
  private String locale = Locale.ENGLISH.getDisplayLanguage();

  @JsonProperty("locations")
  private Map<String, String> locations = new HashMap<String, String>();

  @JsonProperty("outputStyle")
  private String outputStyle = null;
  
  // TODO: Mark what goes here?
  private List<BundleValidationRule> bundleValidationRules = new ArrayList<>();

  @JsonProperty("jurisdiction")
  private String jurisdiction = JurisdictionUtilities.getJurisdictionFromLocale(Locale.getDefault().getCountry());
  @JsonProperty("srcLang")
  private String srcLang = null;
  @JsonProperty("tgtLang")
  private String tgtLang = null;

  @JsonProperty("fhirSettingsFile")
  private String fhirSettingsFile;

  @JsonProperty("watchMode")
  private ValidatorWatchMode watchMode = ValidatorWatchMode.NONE;
  
  @JsonProperty("watchScanDelay")
  private int watchScanDelay = 1000;
  
  @JsonProperty("watchSettleTime")
  private int watchSettleTime = 100;
  

  @JsonProperty("map")
  public String getMap() {
    return map;
  }

  @JsonProperty("map")
  public CliContext setMap(String map) {
    this.map = map;
    return this;
  }


  @JsonProperty("langTransform")
  public String getLangTransform() {
    return langTransform;
  }

  @JsonProperty("langTransform")
  public CliContext setLangTransform(String langTransform) {
    this.langTransform = langTransform;
    return this;
  }
  @JsonProperty("igs")
  public List<String> getIgs() {
    return igs;
  }

  @JsonProperty("igs")
  public CliContext setIgs(List<String> igs) {
    this.igs = igs;
    return this;
  }

  // TODO: Mark what goes here?
  public List<BundleValidationRule> getBundleValidationRules() {
   return bundleValidationRules;
  }

  public CliContext addIg(String ig) {
    if (this.igs == null) {
      this.igs = new ArrayList<>();
    }
    this.igs.add(ig);
    return this;
  }

  @JsonProperty("questionnaire")
  public QuestionnaireMode getQuestionnaireMode() {
    return questionnaireMode;
  }

  @JsonProperty("questionnaire")
  public CliContext setQuestionnaireMode(QuestionnaireMode questionnaireMode) {
    this.questionnaireMode = questionnaireMode;
    return this;
  }

  @JsonProperty("level")
  public ValidationLevel getLevel() {
    return level;
  }

  @JsonProperty("level")
  public CliContext setLevel(ValidationLevel level) {
    this.level = level;
    return this;
  }

  @JsonProperty("txServer")
  public String getTxServer() {
    return txServer;
  }

  @JsonProperty("txServer")
  public CliContext setTxServer(String txServer) {
    this.txServer = txServer;
    return this;
  }

  @JsonProperty("doNative")
  public boolean isDoNative() {
    return doNative;
  }

  @JsonProperty("doNative")
  public CliContext setDoNative(boolean doNative) {
    this.doNative = doNative;
    return this;
  }

  @JsonProperty("extensions")
  public List<String> getExtensions() {
    return extensions;
  }

  @JsonProperty("extensions")
  public CliContext setExtensions(List<String> extensions) {
    this.extensions = extensions;
    return this;
  }

  @JsonProperty("hintAboutNonMustSupport")
  public boolean isHintAboutNonMustSupport() {
    return hintAboutNonMustSupport;
  }

  @JsonProperty("hintAboutNonMustSupport")
  public CliContext setHintAboutNonMustSupport(boolean hintAboutNonMustSupport) {
    this.hintAboutNonMustSupport = hintAboutNonMustSupport;
    return this;
  }

  @JsonProperty("recursive")
  public boolean isRecursive() {
    return recursive;
  }

  @JsonProperty("recursive")
  public CliContext setRecursive(boolean recursive) {
    this.recursive = recursive;
    return this;
  }

  @JsonProperty("showMessagesFromReferences")
  public boolean isShowMessagesFromReferences() {
    return showMessagesFromReferences;
  }

  @JsonProperty("showMessagesFromReferences")
  public CliContext setShowMessagesFromReferences(boolean showMessagesFromReferences) {
    this.showMessagesFromReferences = showMessagesFromReferences;
    return this;
  }

  @JsonProperty("doImplicitFHIRPathStringConversion")
  public boolean isDoImplicitFHIRPathStringConversion() {
    return doImplicitFHIRPathStringConversion;
  }

  @JsonProperty("doImplicitFHIRPathStringConversion")
  public void setDoImplicitFHIRPathStringConversion(boolean doImplicitFHIRPathStringConversion) {
    this.doImplicitFHIRPathStringConversion = doImplicitFHIRPathStringConversion;
  }

  @JsonProperty("htmlInMarkdownCheck")
  public HtmlInMarkdownCheck getHtmlInMarkdownCheck() {
    return htmlInMarkdownCheck;
  }

  @JsonProperty("htmlInMarkdownCheck")
  public void setHtmlInMarkdownCheck(HtmlInMarkdownCheck htmlInMarkdownCheck) {
    this.htmlInMarkdownCheck = htmlInMarkdownCheck;
  }

  @JsonProperty("allowDoubleQuotesInFHIRPath")  
  public boolean isAllowDoubleQuotesInFHIRPath() {
    return allowDoubleQuotesInFHIRPath;
  }

  @JsonProperty("allowDoubleQuotesInFHIRPath")  
  public void setAllowDoubleQuotesInFHIRPath(boolean allowDoubleQuotesInFHIRPath) {
    this.allowDoubleQuotesInFHIRPath = allowDoubleQuotesInFHIRPath;
  }

  @JsonProperty("locale")
  public String getLanguageCode() {
    return locale;
  }

  public Locale getLocale() {
    return Locale.forLanguageTag(this.locale);
  }

  @JsonProperty("locale")
  public CliContext setLocale(String languageString) {
    this.locale = languageString;
    return this;
  }

  public CliContext setLocale(Locale locale) {
    this.locale = locale.getLanguage();
    return this;
  }

  @JsonProperty("profiles")
  public List<String> getProfiles() {
    return profiles;
  }

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

  @JsonProperty("mode")
  public EngineMode getMode() {
    return mode;
  }

  @JsonProperty("mode")
  public CliContext setMode(EngineMode mode) {
    this.mode = mode;
    return this;
  }

  @JsonProperty("output")
  public String getOutput() {
    return output;
  }

  @JsonProperty("output")
  public CliContext setOutput(String output) {
    this.output = output;
    return this;
  }

  @JsonProperty("outputSuffix")
  public String getOutputSuffix() {
    return outputSuffix;
  }

  @JsonProperty("outputSuffix")
  public CliContext setOutputSuffix(String outputSuffix) {
    this.outputSuffix = outputSuffix;
    return this;
  }

  @JsonProperty("htmlOutput")
  public String getHtmlOutput() {
    return htmlOutput;
  }

  @JsonProperty("htmlOutput")
  public CliContext setHtmlOutput(String htmlOutput) {
    this.htmlOutput = htmlOutput;
    return this;
  }

  @JsonProperty("canDoNative")
  public boolean getCanDoNative() {
    return canDoNative;
  }

  @JsonProperty("canDoNative")
  public CliContext setCanDoNative(boolean canDoNative) {
    this.canDoNative = canDoNative;
    return this;
  }

  @JsonProperty("sources")
  public List<String> getSources() {
    return sources;
  }

  @JsonProperty("inputs")
  public List<String> getInputs() {
    return inputs;
  }

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

  @JsonProperty("locations")
  public Map<String, String> getLocations() {
    return locations;
  }

  @JsonProperty("locations")
  public CliContext setLocations(Map<String, String> locations) {
    this.locations = locations;
    return this;
  }

  public CliContext addLocation(String profile, String location) {
    this.locations.put(profile, location);
    return this;
  }

  @JsonProperty("sv")
  public String getSv() {
    return sv;
  }

  @JsonProperty("sv")
  public CliContext setSv(String sv) {
    if (sv != null && (sv.startsWith("R") || sv.startsWith("r"))) {
      this.sv = VersionUtilities.versionFromCode(sv.toLowerCase());
    } else {
      this.sv = sv;
    }
    return this;
  }

  @JsonProperty("txLog")
  public String getTxLog() {
    return txLog;
  }

  @JsonProperty("txLog")
  public CliContext setTxLog(String txLog) {
    this.txLog = txLog;
    return this;
  }

  @JsonProperty("txCache")
  public String getTxCache() {
    return txCache;
  }

  @JsonProperty("txCache")
  public CliContext setTxCache(String txCache) {
    this.txCache = txCache;
    return this;
  }

  @JsonProperty("mapLog")
  public String getMapLog() {
    return mapLog;
  }

  @JsonProperty("mapLog")
  public CliContext setMapLog(String mapLog) {
    this.mapLog = mapLog;
    return this;
  }

  @JsonProperty("lang")
  public String getLang() {
    return lang;
  }

  @JsonProperty("lang")
  public CliContext setLang(String lang) {
    this.lang = lang;
    return this;
  }

  @JsonProperty("fhirpath")
  public String getFhirpath() {
    return fhirpath;
  }

  @JsonProperty("fhirpath")
  public CliContext setFhirpath(String fhirpath) {
    this.fhirpath = fhirpath;
    return this;
  }


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

  @JsonProperty("snomedCT")
  public CliContext setSnomedCT(String snomedCT) {
    this.snomedCT = snomedCT;
    return this;
  }

  @JsonProperty("targetVer")
  public String getTargetVer() {
    return targetVer;
  }

  @JsonProperty("targetVer")
  public CliContext setTargetVer(String targetVer) {
    this.targetVer = targetVer;
    return this;
  }

  @JsonProperty("doDebug")
  public boolean isDoDebug() {
    return doDebug;
  }

  @JsonProperty("doDebug")
  public CliContext setDoDebug(boolean doDebug) {
    this.doDebug = doDebug;
    return this;
  }

  @JsonProperty("assumeValidRestReferences")
  public boolean isAssumeValidRestReferences() {
    return assumeValidRestReferences;
  }

  @JsonProperty("assumeValidRestReferences")
  public CliContext setAssumeValidRestReferences(boolean assumeValidRestReferences) {
    this.assumeValidRestReferences = assumeValidRestReferences;
    return this;
  }

  @JsonProperty("noInternalCaching")
  public boolean isNoInternalCaching() {
    return noInternalCaching;
  }

  @JsonProperty("noInternalCaching")
  public CliContext setNoInternalCaching(boolean noInternalCaching) {
    this.noInternalCaching = noInternalCaching;
    return this;
  }

  @JsonProperty("noExtensibleBindingMessages")
  public boolean isNoExtensibleBindingMessages() {
    return noExtensibleBindingMessages;
  }

  @JsonProperty("noExtensibleBindingMessages")
  public CliContext setNoExtensibleBindingMessages(boolean noExtensibleBindingMessages) {
    this.noExtensibleBindingMessages = noExtensibleBindingMessages;
    return this;
  }
  
  @JsonProperty("noInvariants")
  public boolean isNoInvariants() {
    return noInvariants;
  }

  @JsonProperty("noInvariants")
  public void setNoInvariants(boolean noInvariants) {
    this.noInvariants = noInvariants;
  }

  @JsonProperty("displayWarnings")
  public boolean isDisplayWarnings() {
    return displayWarnings;
  }

  @JsonProperty("displayWarnings")
  public void setDisplayWarnings(boolean displayWarnings) {
    this.displayWarnings = displayWarnings;
  }

  @JsonProperty("wantInvariantsInMessages")
  public boolean isWantInvariantsInMessages() {
    return wantInvariantsInMessages;
  }

  @JsonProperty("wantInvariantsInMessages")
  public void setWantInvariantsInMessages(boolean wantInvariantsInMessages) {
    this.wantInvariantsInMessages = wantInvariantsInMessages;
  }

  @JsonProperty("securityChecks")  
  public boolean isSecurityChecks() {
    return securityChecks;
  }

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
    return doNative == that.doNative &&
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
      Objects.equals(igs, that.igs) &&
      Objects.equals(questionnaireMode, that.questionnaireMode) &&
      Objects.equals(level, that.level) &&
      Objects.equals(profiles, that.profiles) &&
      Objects.equals(sources, that.sources) &&
      Objects.equals(crumbTrails, that.crumbTrails) &&
      Objects.equals(forPublication, that.forPublication)&&
      Objects.equals(allowExampleUrls, that.allowExampleUrls) &&
      Objects.equals(showTimes, that.showTimes) &&
      mode == that.mode &&
      Objects.equals(locale, that.locale) &&
      Objects.equals(outputStyle, that.outputStyle) &&
      Objects.equals(jurisdiction, that.jurisdiction) &&
      Objects.equals(locations, that.locations) &&
      Objects.equals(watchMode, that.watchMode) &&
      Objects.equals(watchScanDelay, that.watchScanDelay) &&
      Objects.equals(watchSettleTime, that.watchSettleTime) ;
  }

  @Override
  public int hashCode() {
    return Objects.hash(doNative, extensions, hintAboutNonMustSupport, recursive, doDebug, assumeValidRestReferences, canDoNative, noInternalCaching, 
            noExtensibleBindingMessages, noInvariants, displayWarnings, wantInvariantsInMessages, map, output, outputSuffix, htmlOutput, txServer, sv, txLog, txCache, mapLog, lang, srcLang, tgtLang, fhirpath, snomedCT,
            targetVer, igs, questionnaireMode, level, profiles, sources, inputs, mode, locale, locations, crumbTrails, forPublication, showTimes, allowExampleUrls, outputStyle, jurisdiction, noUnicodeBiDiControlChars, watchMode, watchScanDelay, watchSettleTime,
            htmlInMarkdownCheck, allowDoubleQuotesInFHIRPath);
  }

  @Override
  public String toString() {
    return "CliContext{" +
      "doNative=" + doNative +
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
      ", igs=" + igs +
      ", questionnaireMode=" + questionnaireMode +
      ", level=" + level +
      ", profiles=" + profiles +
      ", sources=" + sources +
      ", inputs=" + inputs +
      ", mode=" + mode +
      ", securityChecks=" + securityChecks +
      ", crumbTrails=" + crumbTrails +
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
      ", watchMode=" + watchMode +
      ", watchSettleTime=" + watchSettleTime +
      ", watchScanDelay=" + watchScanDelay +
      '}';
  }

  @JsonProperty("fhirSettingsFile")
  public CliContext setFhirSettingsFile(String fhirSettingsFile) {
    this.fhirSettingsFile = fhirSettingsFile;
    return this;
  }

  @JsonProperty("fhirSettingsFile")
  public String getFhirSettingsFile() {
    return fhirSettingsFile;
  }

  @JsonProperty("watchMode")
  public ValidatorWatchMode getWatchMode() {
    return watchMode;
  }

  @JsonProperty("watchMode")
  public CliContext setWatchMode(ValidatorWatchMode watchMode) {
    this.watchMode = watchMode;
    return this;
  }

  @JsonProperty("watchScanDelay")
  public int getWatchScanDelay() {
    return watchScanDelay;
  }

  @JsonProperty("watchScanDelay")
  public void setWatchScanDelay(int watchScanDelay) {
    this.watchScanDelay = watchScanDelay;
  }

  @JsonProperty("watchSettleTime")
  public int getWatchSettleTime() {
    return watchSettleTime;
  }

  @JsonProperty("watchSettleTime")
  public void setWatchSettleTime(int watchSettleTime) {
    this.watchSettleTime = watchSettleTime;
  }
  
  
}