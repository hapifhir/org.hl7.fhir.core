package org.hl7.fhir.utilities.validation;

import java.util.HashSet;
import java.util.Set;

import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.AcceptLanguageHeader;

import com.google.gson.JsonElement;

public class ValidationOptions {
  public enum ValueSetMode {
    ALL_CHECKS, CHECK_MEMERSHIP_ONLY, NO_MEMBERSHIP_CHECK
  }
  
  private AcceptLanguageHeader langs = null;
  private boolean useServer = true;
  private boolean useClient = true;
  private boolean guessSystem = false;
  private ValueSetMode valueSetMode = ValueSetMode.ALL_CHECKS;
  private boolean displayWarningMode = false;
  private boolean vsAsUrl;
  private boolean versionFlexible = true;
  private boolean useValueSetDisplays;
  private boolean englishOk = true;
  private FhirPublication fhirVersion;

  public ValidationOptions() {
    this(FhirPublication.R5);
  }

  public ValidationOptions(FhirPublication fhirVersion) {
    super();
    this.fhirVersion = fhirVersion;
  }

  public ValidationOptions(FhirPublication fhirVersion, String language) {
    super();
    if (!Utilities.noString(language)) {
      langs = new AcceptLanguageHeader(language, false);
    }
  }

  public static ValidationOptions defaults() {
    return new ValidationOptions(FhirPublication.R5, "en, en-US");
  }
  
  /**
   * The language that the validation is in (for display name checking etc
   * 
   * See also englishOK
   * 
   * @return
   */
  public AcceptLanguageHeader getLanguages() {
    return langs;
  }

  public boolean hasLanguages() {
    return langs != null && !Utilities.noString(langs.getSource());
  }


  /**
   * true (which is default) means that the validator will use the server if it needs to for this request
   * 
   * (there's a few corner cases where you want to turn this off?)
   * @return
   */
  public boolean isUseServer() {
    return useServer;
  }

  /**
   * True means that the validator will try to resolve the terminology request locally with the resources at hand 
   * 
   * There have been a few corner case code systems where the local code system from THO is wrong
   * 
   * @return
   */
  public boolean isUseClient() {
    return useClient;
  }

  /**
   * True if this is called from a code context where there's no known code system (inferred from the value set)
   * 
   * @return
   */
  public boolean isGuessSystem() {
    return guessSystem;
  }

  /**
   * See {link}
   * @return
   */
  public ValueSetMode getValueSetMode() {
    return valueSetMode;
  }
  
  /**
   * Don't know what this does
   * 
   * @return
   */
  public boolean getVsAsUrl() {
    return vsAsUrl;
  }

  /**
   * Don't know exactly what this does
   * 
   * @return
   */
  public boolean isVersionFlexible() {
    return versionFlexible;
  }

  /**
   * see {link}
   *  
   * @return
   */
  public boolean isUseValueSetDisplays() {
    return useValueSetDisplays;
  }

  /**
   * if the language is other than english, should the validator accept english as well?
   * 
   * @return
   */
  public boolean isEnglishOk() {
    return englishOk;
  }


  public ValidationOptions withLanguage(String language) {
    if (language == null) {
      return this;
    }
    ValidationOptions n = this.copy();
    n.addLanguage(language);
    return n;
  }

  public ValidationOptions withNoServer() {
    ValidationOptions n = this.copy();
    n.useServer = false;
    return n;
  }
  
  public ValidationOptions withNoClient() {
    ValidationOptions n = this.copy();
    n.useClient = false;
    return n;
  }

  public ValidationOptions withGuessSystem() {
    ValidationOptions n = this.copy();
    n.guessSystem = true;
    return n;
  }
  
  public ValidationOptions withCheckValueSetOnly() {
    ValidationOptions n = this.copy();
    n.valueSetMode = ValueSetMode.CHECK_MEMERSHIP_ONLY;
    return n;
  }

  public ValidationOptions withNoCheckValueSetMembership() {
    ValidationOptions n = this.copy();
    n.valueSetMode = ValueSetMode.NO_MEMBERSHIP_CHECK;
    return n;
  }

  public ValidationOptions withVsAsUrl() {
    ValidationOptions n = this.copy();
    n.vsAsUrl = true;
    return n;
  }

  public ValidationOptions withVersionFlexible(boolean value) {
    ValidationOptions n = this.copy();
    n.versionFlexible = value;
    return n;
  }

  public ValidationOptions withUseValueSetDisplays(boolean useValueSetDisplays) {
    ValidationOptions n = this.copy();
    n.useValueSetDisplays = useValueSetDisplays;
    return n;
  }
  
  public ValidationOptions withEnglishOk(boolean englishOk) {
    ValidationOptions n = this.copy();
    n.englishOk = englishOk;
    return n;
  }

  public ValidationOptions addLanguage(String language) {
    if (this.langs == null) {
      langs = new AcceptLanguageHeader(language, false);
    } else {
      langs.add(language);
    }
    return this;
  }

  public ValidationOptions setLanguages(String language) {
    langs = new AcceptLanguageHeader(language, false);
    return this;
  }

  public ValidationOptions setNoServer(boolean useServer) {
    this.useServer = useServer;
    return this;
  }
  
  public ValidationOptions setNoClient(boolean useClient) {
    this.useClient = useClient;
    return this;
  }

  public ValidationOptions setGuessSystem(boolean guessSystem) {
    this.guessSystem = guessSystem;
    return this;
  }
  
  public ValidationOptions setCheckValueSetOnly() {
    this.valueSetMode = ValueSetMode.CHECK_MEMERSHIP_ONLY;
    return this;
  }

  public ValidationOptions setNoCheckValueSetMembership() {
    this.valueSetMode = ValueSetMode.NO_MEMBERSHIP_CHECK;
    return this;
  }

  public ValidationOptions setVsAsUrl(boolean value) {
    this.vsAsUrl = value;
    return this;
  }

  public ValidationOptions setVersionFlexible(boolean value) {
    this.versionFlexible = value;
    return this;
  }

  public ValidationOptions setUseValueSetDisplays(boolean useValueSetDisplays) {
    this.useValueSetDisplays = useValueSetDisplays;
    return this;
  }

  public ValidationOptions setEnglishOk(boolean englishOk) {
    this.englishOk = englishOk;
    return this;
  }

  public boolean isDisplayWarningMode() {
    return displayWarningMode;
  }

  public ValidationOptions setDisplayWarningMode(boolean displayWarningMode) {
    this.displayWarningMode = displayWarningMode;
    return this;
  }

  public ValidationOptions copy() {
    ValidationOptions n = new ValidationOptions(fhirVersion);
    n.langs = langs == null ? null : langs.copy();
    n.useServer = useServer;
    n.useClient = useClient;
    n.guessSystem = guessSystem; 
    n.vsAsUrl = vsAsUrl;
    n.versionFlexible = versionFlexible;
    n.valueSetMode = valueSetMode;
    n.useValueSetDisplays = useValueSetDisplays;   
    n.displayWarningMode = displayWarningMode;
    return n;
  }
  

  public String toJson() {
    return "\"langs\":\""+( langs == null ? "" : langs.toString())+"\", \"useServer\":\""+Boolean.toString(useServer)+"\", \"useClient\":\""+Boolean.toString(useClient)+"\", "+
       "\"guessSystem\":\""+Boolean.toString(guessSystem)+"\", \"valueSetMode\":\""+valueSetMode.toString()+"\", \"displayWarningMode\":\""+Boolean.toString(displayWarningMode)+"\", \"versionFlexible\":\""+Boolean.toString(versionFlexible)+"\"";
  }

  public String langSummary() {
    if (langs == null) {
      return "--";
    } else {
      String s = langs.toString();
      if (Utilities.noString(s)) {
        s = "--";
      }
      return s;
    }
  }

  public FhirPublication getFhirVersion() {
    return fhirVersion;
  }
  
}