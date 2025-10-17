package org.hl7.fhir.utilities.validation;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.AcceptLanguageHeader;

public class ValidationOptions {
  
  public enum R5BundleRelativeReferencePolicy {
    DEFAULT,
    NEVER,
    ALWAYS;

    public String toCode() {
      switch (this) {
      case ALWAYS: return "always";
      case DEFAULT: return "default";
      case NEVER: return "never";
      }
      return null;
    }

    public static R5BundleRelativeReferencePolicy fromCode(String code) {
      switch (code) {
      case "always": return ALWAYS;
      case "default": return DEFAULT;
      case "never": return NEVER;
      }
      throw new FHIRException("bad code "+code);
    }
  }

  private AcceptLanguageHeader langs = null;
  private boolean useServer = true;
  private boolean useClient = true;
  private boolean guessSystem = false;
  private boolean membershipOnly = false;
  private boolean displayWarningMode = false;
  private boolean vsAsUrl;
  private boolean versionFlexible = true;
  private boolean useValueSetDisplays;
  private boolean englishOk = true;
  private boolean activeOnly = false;
  private boolean exampleOK = false;
  private FhirPublication fhirVersion;
  private R5BundleRelativeReferencePolicy r5BundleRelativeReferencePolicy = R5BundleRelativeReferencePolicy.DEFAULT;
  private boolean isDefaultLang = false;
  
  public ValidationOptions() { this(FhirPublication.R5); }

  public ValidationOptions(FhirPublication fhirVersion) {
    super();
    this.fhirVersion = fhirVersion;
  }

  public ValidationOptions(FhirPublication fhirVersion, String language) {
    super();
    if (!Utilities.noString(language)) {
      langs = new AcceptLanguageHeader(language, false);
      isDefaultLang = false;
    }
  }

  public static ValidationOptions defaults() {
    ValidationOptions vo = new ValidationOptions(FhirPublication.R5, "en, en-US");
    vo.isDefaultLang  = true;
    return vo;
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
  
  public boolean isActiveOnly() {
    return activeOnly;
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

  public boolean isMembershipOnly() {
    return membershipOnly;
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

  public ValidationOptions withUseClient(boolean value) {
    ValidationOptions n = this.copy();
    n.useClient = value;
    return n;
  }

  public ValidationOptions withGuessSystem() {
    ValidationOptions n = this.copy();
    n.guessSystem = true;
    return n;
  }


  public ValidationOptions withGuessSystem(boolean value) {
    ValidationOptions n = this.copy();
    n.guessSystem = value;
    return n;
  }
  
  public ValidationOptions withActiveOnly() {
    ValidationOptions n = this.copy();
    n.activeOnly = true;
    return n;
  }
  
  /** Only for additional bindings **/
  public ValidationOptions withCheckValueSetOnly() {
    ValidationOptions n = this.copy();
    n.membershipOnly = true;
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
    if (this.langs == null || isDefaultLang) {
      langs = new AcceptLanguageHeader(language, false);
    } else {
      langs.add(language);
      isDefaultLang = false;
    }
    return this;
  }

  public ValidationOptions setLanguages(String language) {
    langs = new AcceptLanguageHeader(language, false);
    isDefaultLang = false;
    return this;
  }

  public ValidationOptions setUseServer(boolean useServer) {
    this.useServer = useServer;
    return this;
  }
  
  public ValidationOptions setUseClient(boolean useClient) {
    this.useClient = useClient;
    return this;
  }

  public ValidationOptions setGuessSystem(boolean guessSystem) {
    this.guessSystem = guessSystem;
    return this;
  }
  
  public ValidationOptions setActiveOnly(boolean activeOnly) {
    this.activeOnly = activeOnly;
    return this;
  }
  
  public ValidationOptions setCheckValueSetOnly() {
    this.membershipOnly = true;
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

  public boolean isExampleOK() {
    return exampleOK;
  }

  public ValidationOptions setExampleOK(boolean exampleOK) {
    this.exampleOK = exampleOK;
    return this;
  }
  
  public ValidationOptions withExampleOK() {
    return setExampleOK(true);
  }

  
  public R5BundleRelativeReferencePolicy getR5BundleRelativeReferencePolicy() {
    return r5BundleRelativeReferencePolicy;
  }

  public void setR5BundleRelativeReferencePolicy(R5BundleRelativeReferencePolicy r5BundleRelativeReferencePolicy) {
    if (r5BundleRelativeReferencePolicy == null) {
      r5BundleRelativeReferencePolicy = R5BundleRelativeReferencePolicy.DEFAULT;
    } 
    this.r5BundleRelativeReferencePolicy = r5BundleRelativeReferencePolicy;
  }

  public ValidationOptions withR5BundleRelativeReferencePolicy(R5BundleRelativeReferencePolicy r5BundleRelativeReferencePolicy) {
    setR5BundleRelativeReferencePolicy(r5BundleRelativeReferencePolicy);
    return this;
  }

  public ValidationOptions copy() {
    ValidationOptions n = new ValidationOptions(fhirVersion);
    n.langs = langs == null ? null : langs.copy();
    n.isDefaultLang = isDefaultLang;
    n.useServer = useServer;
    n.useClient = useClient;
    n.guessSystem = guessSystem; 
    n.activeOnly = activeOnly; 
    n.vsAsUrl = vsAsUrl;
    n.versionFlexible = versionFlexible;
    n.membershipOnly = membershipOnly;
    n.useValueSetDisplays = useValueSetDisplays;   
    n.displayWarningMode = displayWarningMode;
    n.exampleOK = exampleOK;
    n.r5BundleRelativeReferencePolicy = r5BundleRelativeReferencePolicy;
    return n;
  }
  

  public String toJson() {
    return "\"langs\":\""+( langs == null ? "" : langs.toString())+"\", \"useServer\":\""+Boolean.toString(useServer)+"\", \"useClient\":\""+Boolean.toString(useClient)+"\", "+
       "\"guessSystem\":\""+Boolean.toString(guessSystem)+"\", \"activeOnly\":\""+Boolean.toString(activeOnly)+(exampleOK ? "\", \"exampleOK\":\""+Boolean.toString(exampleOK) : "")+
       "\", \"membershipOnly\":\""+Boolean.toString(membershipOnly)+"\", \"displayWarningMode\":\""+Boolean.toString(displayWarningMode)+
       "\", \"versionFlexible\":\""+Boolean.toString(versionFlexible)+"\""+
       (r5BundleRelativeReferencePolicy != R5BundleRelativeReferencePolicy.DEFAULT ? ", \"r5BundleRelativeReferencePolicy\":\""+r5BundleRelativeReferencePolicy.toCode()+"\"" : "");
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