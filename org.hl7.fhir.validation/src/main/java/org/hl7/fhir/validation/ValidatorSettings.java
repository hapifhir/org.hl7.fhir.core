package org.hl7.fhir.validation;

import java.util.*;

import lombok.Getter;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.UsageContext;
import org.hl7.fhir.r5.utils.validation.constants.BestPracticeWarningLevel;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.validation.instance.utils.DigitalSignatureSupport;
import org.hl7.fhir.validation.service.utils.ValidationLevel;

public class ValidatorSettings extends ValidationOptions {

  private Source source; // @configuration
  private ValidationLevel level = ValidationLevel.HINTS; // @configuration
  private Coding jurisdiction; // @configuration
  private boolean allowExamples; // @configuration
  private boolean forPublication; // @configuration
  private boolean debug; // @configuration
  private boolean warnOnDraftOrExperimental; // @configuration 
  private BestPracticeWarningLevel bpWarnings = BestPracticeWarningLevel.Warning; // @configuration
  private List<UsageContext> usageContexts = new ArrayList<UsageContext>(); // @configuration
  private boolean assumeValidRestReferences;
  private Map<String, byte[]> certificates = new HashMap<>();
  private List<String> certificateFolders = new ArrayList<>();
  private String minVersion;
  private String maxVersion;
  private boolean useNewXVersionPackages;

  @Getter private Set<String> jwtHeaderList = buildJadesHeaders();


  public Source getSource() {
    return source;
  }
  public void setSource(Source source) {
    this.source = source;
  }
  public ValidationLevel getLevel() {
    return level;
  }
  public void setLevel(ValidationLevel level) {
    this.level = level;
  }
  public Coding getJurisdiction() {
    return jurisdiction;
  }
  public void setJurisdiction(Coding jurisdiction) {
    this.jurisdiction = jurisdiction;
  }
  public boolean isAllowExamples() {
    return allowExamples;
  }
  public void setAllowExamples(boolean allowExamples) {
    this.allowExamples = allowExamples;
  }
  public boolean isAssumeValidRestReferences() {
    return assumeValidRestReferences;
  }
  public void setAssumeValidRestReferences(boolean assumeValidRestReferences) {
    this.assumeValidRestReferences = assumeValidRestReferences;
  }
  public boolean isForPublication() {
    return forPublication;
  }
  public void setForPublication(boolean forPublication) {
    this.forPublication = forPublication;
    if (forPublication) {
      warnOnDraftOrExperimental = true;
    }
  }
  public boolean isDebug() {
    return debug;
  }
  public void setDebug(boolean debug) {
    this.debug = debug;
  }
  public boolean isWarnOnDraftOrExperimental() {
    return warnOnDraftOrExperimental;
  }
  public void setWarnOnDraftOrExperimental(boolean warnOnDraftOrExperimental) {
    this.warnOnDraftOrExperimental = warnOnDraftOrExperimental;
  }
  public BestPracticeWarningLevel getBpWarnings() {
    return bpWarnings;
  }
  public void setBpWarnings(BestPracticeWarningLevel value) {
    if (value == null) {
      bpWarnings = BestPracticeWarningLevel.Warning;   
    } else {
      bpWarnings = value;
    }
  }

  public List<UsageContext> getUsageContexts() {
    return usageContexts;
  }
  public Map<String, byte[]> getCertificates() {
    return certificates;
  }
  public void setCertificates(Map<String, byte[]> certificates) {
    this.certificates = certificates;
  }
  public List<String> getCertificateFolders() {
    return certificateFolders;
  }
  public void setCertificateFolders(List<String> certificateFolders) {
    this.certificateFolders = certificateFolders;
  }

  public String getMinVersion() {
    return minVersion;
  }

  public String getMaxVersion() {
    return maxVersion;
  }

  public void setMinVersion(String minVersion) {
    this.minVersion =  minVersion;
  }

  public void setMaxVersion(String maxVersion) {
    this.maxVersion =  maxVersion;
  }

  public boolean isUseNewXVersionPackages() {
    return useNewXVersionPackages;
  }

  public void setUseNewXVersionPackages(boolean useNewXVersionPackages) {
    this.useNewXVersionPackages = useNewXVersionPackages;
  }

  private static Set<String> buildJadesHeaders() {
    Set<String> stringSet = new HashSet<>();
    // see https://github.com/hapifhir/org.hl7.fhir.core/issues/2209
    stringSet.add(DigitalSignatureSupport.JWT_HEADER_SRCMS);
    stringSet.add(DigitalSignatureSupport.JWT_HEADER_IAT);
    stringSet.add(DigitalSignatureSupport.JWT_HEADER_ALG);
    stringSet.add(DigitalSignatureSupport.JWT_HEADER_TYP);
    stringSet.add(DigitalSignatureSupport.JWT_HEADER_X5C);
    stringSet.add(DigitalSignatureSupport.JWT_HEADER_SIGD);
    stringSet.add(DigitalSignatureSupport.JWT_HEADER_VER); // custom for Eeva Turkka
    return stringSet;
  }

}
