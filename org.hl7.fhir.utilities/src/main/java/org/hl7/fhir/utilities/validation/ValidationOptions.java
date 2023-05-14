package org.hl7.fhir.utilities.validation;

import java.util.Set;

import org.hl7.fhir.utilities.Utilities;

import java.util.HashSet;

public class ValidationOptions {
  public enum ValueSetMode {
    ALL_CHECKS, CHECK_MEMERSHIP_ONLY, NO_MEMBERSHIP_CHECK
  }

  private Set<String> languages = new HashSet<>();
  private boolean useServer = true;
  private boolean useClient = true;
  private boolean guessSystem = false;
  private ValueSetMode valueSetMode = ValueSetMode.ALL_CHECKS;
  private boolean displayWarningMode = false;
  private boolean vsAsUrl;
  private boolean versionFlexible = true;
  private boolean useValueSetDisplays;
  private boolean englishOk = true;

  public ValidationOptions(String... languages) {
    super();
    for(String s : languages) {
      this.languages.add(s);
    }
  }

  public static ValidationOptions defaults() {
    return new ValidationOptions("en", "en-US");
  }
  
  /**
   * The language that the validation is in (for display name checking etc
   * 
   * See also englishOK
   * 
   * @return
   */
  public Set<String> getLanguages() {
    return languages;
  }

  public boolean hasLanguages() {
    return languages.size() > 0;
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
    n.languages.add(language);
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
    this.languages.add(language);
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
    ValidationOptions n = new ValidationOptions();
    n.languages.addAll(languages);
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
    return "\"langs\":\""+languages.toString()+"\", \"useServer\":\""+Boolean.toString(useServer)+"\", \"useClient\":\""+Boolean.toString(useClient)+"\", "+
       "\"guessSystem\":\""+Boolean.toString(guessSystem)+"\", \"valueSetMode\":\""+valueSetMode.toString()+"\", \"displayWarningMode\":\""+Boolean.toString(displayWarningMode)+"\", \"versionFlexible\":\""+Boolean.toString(versionFlexible)+"\"";
  }

  public String langSummary() {
    if (languages.size() == 0) {
      return "--";
    } else {
      return String.join("|", Utilities.sorted(languages));
    }
  }



  
}