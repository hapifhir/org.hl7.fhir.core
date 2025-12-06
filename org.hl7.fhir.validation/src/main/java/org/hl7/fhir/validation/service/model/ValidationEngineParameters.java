package org.hl7.fhir.validation.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.hl7.fhir.r5.terminologies.JurisdictionUtilities;
import org.hl7.fhir.r5.terminologies.utilities.SnomedUtilities;
import org.hl7.fhir.r5.utils.validation.BundleValidationRule;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.settings.FhirSettings;

import java.util.*;

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

  @JsonProperty("recursive")
  @SerializedName("recursive")
  private
  boolean recursive = false;

  @SerializedName("recursive")
  @JsonProperty("recursive")
  public boolean isRecursive() {
    return recursive;
  }

  @SerializedName("recursive")
  @JsonProperty("recursive")
  public ValidationEngineParameters setRecursive(boolean recursive) {
    this.recursive = recursive;
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

  @JsonProperty("txLog")
  @SerializedName("txLog")
  private
  String txLog = null;

  @SerializedName("txLog")
  @JsonProperty("txLog")
  public String getTxLog() {
    return txLog;
  }

  @SerializedName("txLog")
  @JsonProperty("txLog")
  public ValidationEngineParameters setTxLog(String txLog) {
    this.txLog = txLog;
    return this;
  }

  @JsonProperty("txCache")
  @SerializedName("txCache")
  private
  String txCache = null;

  @SerializedName("txCache")
  @JsonProperty("txCache")
  public String getTxCache() {
    return txCache;
  }

  @SerializedName("txCache")
  @JsonProperty("txCache")
  public ValidationEngineParameters setTxCache(String txCache) {
    this.txCache = txCache;
    return this;
  }

  @JsonProperty("clearTxCache")
  @SerializedName("clearTxCache")
  private
  boolean clearTxCache = false;

  @SerializedName("clearTxCache")
  @JsonProperty("clearTxCache")
  public boolean isClearTxCache() {
    return clearTxCache;
  }

  @SerializedName("clearTxCache")
  @JsonProperty("clearTxCache")
  public ValidationEngineParameters setClearTxCache(boolean clearTxCache) {
    this.clearTxCache = clearTxCache;
    return this;
  }

  @JsonProperty("advisorFile")
  @SerializedName("advisorFile")
  private
  String advisorFile;

  @SerializedName("advisorFile")
  @JsonProperty("advisorFile")
  public String getAdvisorFile() {
    return advisorFile;
  }

  @SerializedName("advisorFile")
  @JsonProperty("advisorFile")
  public ValidationEngineParameters setAdvisorFile(String advisorFile) {
    this.advisorFile = advisorFile;
    return this;
  }

  @JsonProperty("locale")
  @SerializedName("locale")
  private
  String locale = Locale.ENGLISH.toLanguageTag();

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
  public ValidationEngineParameters setLocale(String languageString) {
    this.locale = languageString;
    return this;
  }

  public ValidationEngineParameters setLocale(Locale locale) {
    this.locale = locale.getLanguage();
    return this;
  }

  @JsonProperty("lang")
  @SerializedName("lang")
  private
  String lang = null;

  @SerializedName("lang")
  @JsonProperty("lang")
  public String getLang() {
    return lang;
  }

  @SerializedName("lang")
  @JsonProperty("lang")
  public ValidationEngineParameters setLang(String lang) {
    this.lang = lang;
    return this;
  }

  @JsonProperty("checkReferences")
  @SerializedName("checkReferences")
  private
  boolean checkReferences = false;

  @JsonProperty("checkReferencesTo")
  @SerializedName("checkReferencesTo")
  private
  Set<String> checkReferencesTo = new HashSet<>();

  @SerializedName("checkReferences")
  @JsonProperty("checkReferences")
  public boolean isCheckReferences() {
    return checkReferences;
  }

  @SerializedName("checkReferences")
  @JsonProperty("checkReferences")
  public ValidationEngineParameters setCheckReferences(boolean checkReferences) {
    this.checkReferences = checkReferences;
    return this;
  }

  @SerializedName("checkReferences")
  @JsonProperty("checkReferences")
  public Set<String> getCheckReferencesTo() {
    return checkReferencesTo;
  }


  @JsonProperty("noInternalCaching")
  @SerializedName("noInternalCaching")
  private
  boolean noInternalCaching = false;

  @SerializedName("noInternalCaching")
  @JsonProperty("noInternalCaching")
  public boolean isNoInternalCaching() {
    return noInternalCaching;
  }

  @SerializedName("noInternalCaching")
  @JsonProperty("noInternalCaching")
  public ValidationEngineParameters setNoInternalCaching(boolean noInternalCaching) {
    this.noInternalCaching = noInternalCaching;
    return this;
  }

  @JsonProperty("disableDefaultResourceFetcher")
  @SerializedName("disableDefaultResourceFetcher")
  private
  boolean disableDefaultResourceFetcher = false;

  @SerializedName("disableDefaultResourceFetcher")
  @JsonProperty("disableDefaultResourceFetcher")
  public boolean isDisableDefaultResourceFetcher() {
    return disableDefaultResourceFetcher;
  }

  @SerializedName("disableDefaultResourceFetcher")
  @JsonProperty("disableDefaultResourceFetcher")
  public ValidationEngineParameters setDisableDefaultResourceFetcher(boolean disableDefaultResourceFetcher) {
    this.disableDefaultResourceFetcher = disableDefaultResourceFetcher;
    return this;
  }

  @JsonProperty("mapLog")
  @SerializedName("mapLog")
  private
  String mapLog = null;

  @SerializedName("mapLog")
  @JsonProperty("mapLog")
  public String getMapLog() {
    return mapLog;
  }

  @SerializedName("mapLog")
  @JsonProperty("mapLog")
  public ValidationEngineParameters setMapLog(String mapLog) {
    this.mapLog = mapLog;
    return this;
  }

  @JsonProperty("displayWarnings")
  @SerializedName("displayWarnings")
  private boolean displayWarnings = false;

  @SerializedName("displayWarnings")
  @JsonProperty("displayWarnings")
  public boolean isDisplayWarnings() {
    return displayWarnings;
  }

  @SerializedName("displayWarnings")
  @JsonProperty("displayWarnings")
  public ValidationEngineParameters setDisplayWarnings(boolean displayWarnings) {
    this.displayWarnings = displayWarnings;
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
  public ValidationEngineParameters setNoExtensibleBindingMessages(boolean noExtensibleBindingMessages) {
    this.noExtensibleBindingMessages = noExtensibleBindingMessages;
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

  @JsonProperty("doDebug")
  @SerializedName("doDebug")
  private
  boolean doDebug = false;

  @SerializedName("doDebug")
  @JsonProperty("doDebug")
  public boolean isDoDebug() {
    return doDebug;
  }

  @SerializedName("doDebug")
  @JsonProperty("doDebug")
  public ValidationEngineParameters setDoDebug(boolean doDebug) {
    this.doDebug = doDebug;
    return this;
  }

  @JsonProperty("showTimes")
  @SerializedName("showTimes")
  private
  boolean showTimes = false;

  @SerializedName("showTimes")
  @JsonProperty("showTimes")
  public boolean isShowTimes() {
    return showTimes;
  }

  @SerializedName("showTimes")
  @JsonProperty("showTimes")
  public ValidationEngineParameters setShowTimes(boolean showTimes) {
    this.showTimes = showTimes;
    return this;
  }

  @JsonProperty("matchetypes")
  @SerializedName("matchetypes")
  private List<String> matchetypes = new ArrayList<String>();

  @SerializedName("matchetypes")
  @JsonProperty("matchetypes")
  public List<String> getMatchetypes() {
    return matchetypes;
  }

  @SerializedName("matchetypes")
  @JsonProperty("matchetypes")
  public ValidationEngineParameters setMatchetypes(List<String> matchetypes) {
    this.matchetypes = matchetypes;
    return this;
  }

  public ValidationEngineParameters addMatchetype(String matchetype) {
    this.matchetypes.add(matchetype);
    return this;
  }

  @JsonProperty("locations")
  @SerializedName("locations")
  private
  Map<String, String> locations = new HashMap<String, String>();

  @SerializedName("locations")
  @JsonProperty("locations")
  public Map<String, String> getLocations() {
    return locations;
  }

  @SerializedName("locations")
  @JsonProperty("locations")
  public ValidationEngineParameters setLocations(Map<String, String> locations) {
    this.locations = locations;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ValidationEngineParameters that = (ValidationEngineParameters) o;
    return Objects.equals(baseEngine, that.baseEngine)
      && doNative == that.doNative
      && recursive == that.recursive
      && snomedCT.equals(that.snomedCT)
      && sv.equals(that.sv)
      && isInferFhirVersion() == that.isInferFhirVersion()
      && noEcosystem == that.noEcosystem
      && clearTxCache == that.clearTxCache
      && checkReferences == that.checkReferences
      && noInternalCaching == that.noInternalCaching
      && disableDefaultResourceFetcher == that.disableDefaultResourceFetcher
      && displayWarnings == that.displayWarnings
      && noExtensibleBindingMessages == that.noExtensibleBindingMessages
      && doDebug == that.doDebug
      && showTimes == that.showTimes
      && Objects.equals(resolutionContext, that.resolutionContext)
      && Objects.equals(aiService, that.aiService)
      && Objects.equals(certSources, that.certSources)
      && Objects.equals(txServer, that.txServer)
      && Objects.equals(txLog, that.txLog)
      && Objects.equals(txCache, that.txCache)
      && Objects.equals(advisorFile, that.advisorFile)
      && Objects.equals(locale, that.locale)
      && Objects.equals(lang, that.lang)
      && Objects.equals(mapLog, that.mapLog)
      && Objects.equals(matchetypes, that.matchetypes)
      && Objects.equals(locations, that.locations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      baseEngine,
      doNative,
      recursive,
      snomedCT,
      sv,
      inferFhirVersion,
      resolutionContext,
      aiService,
      certSources,
      txServer,
      noEcosystem,
      txLog,
      txCache,
      clearTxCache,
      advisorFile,
      locale,
      lang,
      checkReferences,
      noInternalCaching,
      disableDefaultResourceFetcher,
      mapLog,
      displayWarnings,
      noExtensibleBindingMessages,
      doDebug,
      showTimes,
      matchetypes,
      locations);
  }

  @Override
  public String toString() {
    return "ValidationEngineParameters{" +
      "baseEngine=" + baseEngine +
      ", doNative=" + doNative +
      ", recursive=" + recursive +
      ", snomedCT=" + snomedCT +
      ", sv=" + sv +
      ", inferFhirVersion=" + inferFhirVersion +
      ", resolutionContext='" + resolutionContext + '\'' +
      ", aiService='" + aiService + '\'' +
      ", certSources=" + certSources +
      ", txServer='" + txServer + '\'' +
      ", noEcosystem=" + noEcosystem +
      ", txLog='" + txLog + '\'' +
      ", txCache='" + txCache + '\'' +
      ", clearTxCache=" + clearTxCache +
      ", advisorFile='" + advisorFile + '\'' +
      ", locale='" + locale + '\'' +
      ", lang='" + lang + '\'' +
      ", checkReferences=" + checkReferences +
      ", noInternalCaching=" + noInternalCaching +
      ", disableDefaultResourceFetcher=" + disableDefaultResourceFetcher +
      ", mapLog='" + mapLog + '\'' +
      ", displayWarnings=" + displayWarnings +
      ", noExtensibleBindingMessages=" + noExtensibleBindingMessages +
      ", doDebug=" + doDebug +
      ", showTimes=" + showTimes +
      ", matchetypes=" + matchetypes +
      ", locations=" + locations +
      "}";
  }
}
