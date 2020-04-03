package org.hl7.fhir.validation.cliutils;

import org.hl7.fhir.validation.Validator;

import java.util.*;

/**
 * A POJO for storing the flags/values for the CLI validator.
 */
public class CliContext {

  private String map = null;
  private List<String> igs = new ArrayList<String>();
  private List<String> questionnaires = new ArrayList<String>();
  private String txServer = "http://tx.fhir.org";
  private boolean doNative = false;
  private boolean anyExtensionsAllowed = true;
  private boolean hintAboutNonMustSupport = false;
  private boolean recursive = false;
  private Locale locale = null;
  private List<String> profiles = new ArrayList<String>();
  private Validator.EngineMode mode = Validator.EngineMode.VALIDATION;
  private String output = null;
  private Boolean canDoNative = null;
  private List<String> sources = new ArrayList<String>();
  private Map<String, String> locations = new HashMap<String, String>();
  private String sv = "current";
  private String txLog = null;
  private String mapLog = null;
  private String lang = null;
  private String fhirpath = null;
  private String snomedCT = SnomedVersion.INTL.getCode();
  private String targetVer = null;
  private boolean doDebug = false;
  private boolean assumeValidRestReferences = false;

  public String getMap() {
    return map;
  }

  public CliContext setMap(String map) {
    this.map = map;
    return this;
  }

  public List<String> getIgs() {
    return igs;
  }

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

  public List<String> getQuestionnaires() {
    return questionnaires;
  }

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

  public String getTxServer() {
    return txServer;
  }

  public CliContext setTxServer(String txServer) {
    this.txServer = txServer;
    return this;
  }

  public boolean isDoNative() {
    return doNative;
  }

  public CliContext setDoNative(boolean doNative) {
    this.doNative = doNative;
    return this;
  }

  public boolean isAnyExtensionsAllowed() {
    return anyExtensionsAllowed;
  }

  public CliContext setAnyExtensionsAllowed(boolean anyExtensionsAllowed) {
    this.anyExtensionsAllowed = anyExtensionsAllowed;
    return this;
  }

  public boolean isHintAboutNonMustSupport() {
    return hintAboutNonMustSupport;
  }

  public CliContext setHintAboutNonMustSupport(boolean hintAboutNonMustSupport) {
    this.hintAboutNonMustSupport = hintAboutNonMustSupport;
    return this;
  }

  public boolean isRecursive() {
    return recursive;
  }

  public CliContext setRecursive(boolean recursive) {
    this.recursive = recursive;
    return this;
  }

  public Locale getLocale() {
    return locale;
  }

  public CliContext setLocale(Locale locale) {
    this.locale = locale;
    return this;
  }

  public List<String> getProfiles() {
    return profiles;
  }

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

  public Validator.EngineMode getMode() {
    return mode;
  }

  public CliContext setMode(Validator.EngineMode mode) {
    this.mode = mode;
    return this;
  }

  public String getOutput() {
    return output;
  }

  public CliContext setOutput(String output) {
    this.output = output;
    return this;
  }

  public Boolean getCanDoNative() {
    return canDoNative;
  }

  public CliContext setCanDoNative(Boolean canDoNative) {
    this.canDoNative = canDoNative;
    return this;
  }

  public List<String> getSources() {
    return sources;
  }

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

  public Map<String, String> getLocations() {
    return locations;
  }

  public CliContext setLocations(Map<String, String> locations) {
    this.locations = locations;
    return this;
  }

  public CliContext addLocation(String profile, String location) {
    this.locations.put(profile, location);
    return this;
  }

  public String getSv() {
    return sv;
  }

  public CliContext setSv(String sv) {
    this.sv = sv;
    return this;
  }

  public String getTxLog() {
    return txLog;
  }

  public CliContext setTxLog(String txLog) {
    this.txLog = txLog;
    return this;
  }

  public String getMapLog() {
    return mapLog;
  }

  public CliContext setMapLog(String mapLog) {
    this.mapLog = mapLog;
    return this;
  }

  public String getLang() {
    return lang;
  }

  public CliContext setLang(String lang) {
    this.lang = lang;
    return this;
  }

  public String getFhirpath() {
    return fhirpath;
  }

  public CliContext setFhirpath(String fhirpath) {
    this.fhirpath = fhirpath;
    return this;
  }

  public String getSnomedCT() {
    return snomedCT;
  }

  public CliContext setSnomedCT(String snomedCT) {
    this.snomedCT = SnomedVersion.resolveSnomedCTCode(snomedCT);
    return this;
  }

  public String getTargetVer() {
    return targetVer;
  }

  public CliContext setTargetVer(String targetVer) {
    this.targetVer = targetVer;
    return this;
  }

  public boolean isDoDebug() {
    return doDebug;
  }

  public CliContext setDoDebug(boolean doDebug) {
    this.doDebug = doDebug;
    return this;
  }

  public boolean isAssumeValidRestReferences() {
    return assumeValidRestReferences;
  }

  public CliContext setAssumeValidRestReferences(boolean assumeValidRestReferences) {
    this.assumeValidRestReferences = assumeValidRestReferences;
    return this;
  }
}
