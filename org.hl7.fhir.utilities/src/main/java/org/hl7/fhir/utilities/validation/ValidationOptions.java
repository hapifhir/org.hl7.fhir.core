package org.hl7.fhir.utilities.validation;

import lombok.Getter;
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
  /**
   *  true (default) means that the validator will try to resolve the terminology using a server if it needs to for this
   *  request. (There are a few use cases, both in the code and externally where this is needed)
   */
  @Getter
  private boolean useServer = true;

  /**
   *  true (default) means that the validator will try to resolve the terminology request locally with the resources at
   *  hand (There are a few use cases, both in the code and externally where this is needed)
   */
  @Getter
  private boolean useClient = true;
  /**
   *  True if this is called from a code context where there's no known code system (inferred from the value set)*
   */
  @Getter
  private boolean guessSystem = false;
  @Getter
  private boolean membershipOnly = false;
  @Getter
  private boolean displayWarningMode = false;
  private boolean vsAsUrl;
  /**
   *  If the version requested has to match the version actually found, or not. It's used for e.g. display, where you
   *  pass a version in, because you have one, but you don't mind getting a display from a different version instead
   */
  @Getter
  private boolean versionFlexible = true;
  @Getter
  private boolean useValueSetDisplays;
  /**
   *  If true and the language is other than english, the validator will accept english as well
   */
  @Getter
  private boolean englishOk = true;
  @Getter
  private boolean activeOnly = false;
  @Getter
  private boolean exampleOK = false;
  @Getter
  private final FhirPublication fhirVersion;
  @Getter
  private R5BundleRelativeReferencePolicy r5BundleRelativeReferencePolicy = R5BundleRelativeReferencePolicy.DEFAULT;
  private boolean isDefaultLang = false;
  @Getter
  private boolean noAbstract = false;

  @Getter private Object externalSource;
  
  public ValidationOptions() { this(FhirPublication.R5); }

  public ValidationOptions(FhirPublication fhirVersion) {
    super();
    this.fhirVersion = fhirVersion;
  }

  public ValidationOptions(FhirPublication fhirVersion, String language) {
    this(fhirVersion);
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
   * @return the AcceptLanguageHeader for the language that the validation is in (for display name checking etc.)
   * @see ValidationOptions#englishOk
   */
  public AcceptLanguageHeader getLanguages() {
    return langs;
  }

  public boolean hasLanguages() {
    return langs != null && !Utilities.noString(langs.getSource());
  }


  /**
   * If true tells the engine to pass the ValueSet to the server as a URL rather than the whole VS.
   * (But I don't remember why this exists now -Grieve)
   */
  public boolean getVsAsUrl() {
    return vsAsUrl;
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

  public ValidationOptions withNoAbstract() {
    ValidationOptions n = this.copy();
    n.noAbstract = true;
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
  public ValidationOptions setNoAbstract(boolean noAbstract) {
    this.noAbstract = noAbstract;
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

  public ValidationOptions setDisplayWarningMode(boolean displayWarningMode) {
    this.displayWarningMode = displayWarningMode;
    return this;
  }

  public ValidationOptions setExampleOK(boolean exampleOK) {
    this.exampleOK = exampleOK;
    return this;
  }

  public ValidationOptions setExternalSource(Object externalSource) {
    this.externalSource = externalSource;
    return this;
  }

  public ValidationOptions withExampleOK() {
    ValidationOptions n = this.copy();
    return n.setExampleOK(true);
  }


  public ValidationOptions setR5BundleRelativeReferencePolicy(R5BundleRelativeReferencePolicy r5BundleRelativeReferencePolicy) {
    if (r5BundleRelativeReferencePolicy == null) {
      r5BundleRelativeReferencePolicy = R5BundleRelativeReferencePolicy.DEFAULT;
    } 
    this.r5BundleRelativeReferencePolicy = r5BundleRelativeReferencePolicy;
    return this;
  }

  public ValidationOptions withR5BundleRelativeReferencePolicy(R5BundleRelativeReferencePolicy r5BundleRelativeReferencePolicy) {
    ValidationOptions n = this.copy();
    n.setR5BundleRelativeReferencePolicy(r5BundleRelativeReferencePolicy);
    return n;
  }

  public ValidationOptions copy() {
    ValidationOptions n = new ValidationOptions(fhirVersion);
    n.langs = langs == null ? null : langs.copy();
    n.isDefaultLang = isDefaultLang;
    n.useServer = useServer;
    n.useClient = useClient;
    n.guessSystem = guessSystem;
    n.activeOnly = activeOnly;
    n.noAbstract = noAbstract;
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
      "\"guessSystem\":\""+Boolean.toString(guessSystem)+"\", \"noAbstract\":\""+Boolean.toString(noAbstract)+"\", \"activeOnly\":\""+Boolean.toString(activeOnly)+(exampleOK ? "\", \"exampleOK\":\""+Boolean.toString(exampleOK) : "")+
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

  public ValidationOptions withExternalSource(Object res) {
    ValidationOptions n = this.copy();
    n.externalSource = res;
    return n;
  }


}