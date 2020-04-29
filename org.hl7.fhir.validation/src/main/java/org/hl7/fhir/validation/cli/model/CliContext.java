package org.hl7.fhir.validation.cli.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hl7.fhir.validation.Validator;
import org.hl7.fhir.validation.cli.utils.SnomedVersion;

import java.util.*;

/**
 * A POJO for storing the flags/values for the CLI validator.
 */
public class CliContext {

  @JsonProperty("doNative")
  private boolean doNative = false;
  @JsonProperty("anyExtensionsAllowed")
  private boolean anyExtensionsAllowed = true;
  @JsonProperty("hintAboutNonMustSupport")
  private boolean hintAboutNonMustSupport = false;
  @JsonProperty("recursive")
  private boolean recursive = false;
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

  @JsonProperty("map")
  private String map = null;
  @JsonProperty("output")
  private String output = null;
  @JsonProperty("txServer")
  private String txServer = "http://tx.fhir.org";
  @JsonProperty("sv")
  private String sv = "current";
  @JsonProperty("txLog")
  private String txLog = null;
  @JsonProperty("mapLog")
  private String mapLog = null;
  @JsonProperty("lang")
  private String lang = null;
  @JsonProperty("fhirpath")
  private String fhirpath = null;
  @JsonProperty("snomedCT")
  private String snomedCT = SnomedVersion.INTL.getCode();
  @JsonProperty("targetVer")
  private String targetVer = null;

  @JsonProperty("igs")
  private List<String> igs = new ArrayList<String>();
  @JsonProperty("questionnaires")
  private List<String> questionnaires = new ArrayList<String>();
  @JsonProperty("profiles")
  private List<String> profiles = new ArrayList<String>();
  @JsonProperty("sources")
  private List<String> sources = new ArrayList<String>();

  @JsonProperty("mode")
  private Validator.EngineMode mode = Validator.EngineMode.VALIDATION;

  @JsonProperty("locale")
  private String locale = Locale.ENGLISH.getDisplayLanguage();

  @JsonProperty("locations")
  private Map<String, String> locations = new HashMap<String, String>();


  @JsonProperty("map")
  public String getMap() {
    return map;
  }

  @JsonProperty("map")
  public CliContext setMap(String map) {
    this.map = map;
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

  public CliContext addIg(String ig) {
    if (this.igs == null) {
      this.igs = new ArrayList<>();
    }
    this.igs.add(ig);
    return this;
  }

  @JsonProperty("questionnaires")
  public List<String> getQuestionnaires() {
    return questionnaires;
  }

  @JsonProperty("questionnaires")
  public CliContext setQuestionnaires(List<String> questionnaires) {
    this.questionnaires = questionnaires;
    return this;
  }

  public CliContext addQuestionnaire(String questionnaire) {
    if (this.questionnaires == null) {
      this.questionnaires = new ArrayList<>();
    }
    this.questionnaires.add(questionnaire);
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

  @JsonProperty("anyExtensionsAllowed")
  public boolean isAnyExtensionsAllowed() {
    return anyExtensionsAllowed;
  }

  @JsonProperty("anyExtensionsAllowed")
  public CliContext setAnyExtensionsAllowed(boolean anyExtensionsAllowed) {
    this.anyExtensionsAllowed = anyExtensionsAllowed;
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
    this.locale = locale.getDisplayLanguage();
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
  public Validator.EngineMode getMode() {
    return mode;
  }

  @JsonProperty("mode")
  public CliContext setMode(Validator.EngineMode mode) {
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
    this.sv = sv;
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

  public SnomedVersion getSnomedCT() {
    return SnomedVersion.getFromCode(snomedCT);
  }

  @JsonProperty("snomedCT")
  public String getSnomedCTCode() {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CliContext that = (CliContext) o;
    return doNative == that.doNative &&
      anyExtensionsAllowed == that.anyExtensionsAllowed &&
      hintAboutNonMustSupport == that.hintAboutNonMustSupport &&
      recursive == that.recursive &&
      doDebug == that.doDebug &&
      assumeValidRestReferences == that.assumeValidRestReferences &&
      canDoNative == that.canDoNative &&
      noInternalCaching == that.noInternalCaching &&
      noExtensibleBindingMessages == that.noExtensibleBindingMessages &&
      Objects.equals(map, that.map) &&
      Objects.equals(output, that.output) &&
      Objects.equals(txServer, that.txServer) &&
      Objects.equals(sv, that.sv) &&
      Objects.equals(txLog, that.txLog) &&
      Objects.equals(mapLog, that.mapLog) &&
      Objects.equals(lang, that.lang) &&
      Objects.equals(fhirpath, that.fhirpath) &&
      Objects.equals(snomedCT, that.snomedCT) &&
      Objects.equals(targetVer, that.targetVer) &&
      Objects.equals(igs, that.igs) &&
      Objects.equals(questionnaires, that.questionnaires) &&
      Objects.equals(profiles, that.profiles) &&
      Objects.equals(sources, that.sources) &&
      mode == that.mode &&
      Objects.equals(locale, that.locale) &&
      Objects.equals(locations, that.locations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(doNative, anyExtensionsAllowed, hintAboutNonMustSupport, recursive, doDebug, assumeValidRestReferences, canDoNative, noInternalCaching, noExtensibleBindingMessages, map, output, txServer, sv, txLog, mapLog, lang, fhirpath, snomedCT, targetVer, igs, questionnaires, profiles, sources, mode, locale, locations);
  }
}
