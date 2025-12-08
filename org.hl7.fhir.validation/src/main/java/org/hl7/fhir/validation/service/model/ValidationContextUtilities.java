package org.hl7.fhir.validation.service.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class is intended to provide backward compatibility for the deprecated ValidationContext class.
 * <p/>
 * Its usage is strongly discouraged.
 */
@Deprecated(since="2025-10-08")
public class ValidationContextUtilities {
  public static void addValidationEngineParameters(ValidationContext validationContext, ValidationEngineParameters validationEngineParameters) {
    validationContext.setInferFhirVersion(validationEngineParameters.isInferFhirVersion());
    validationContext.setDoNative(validationEngineParameters.isDoNative());
    validationContext.setRecursive(validationEngineParameters.isRecursive());
    validationContext.setSnomedCT(validationEngineParameters.getSnomedCT());
    validationContext.setSv(validationEngineParameters.getSv());
    for (String ig : validationEngineParameters.getIgs()) {
      validationContext.addIg(ig);
    }
    validationContext.setBaseEngine(validationEngineParameters.getBaseEngine());
    validationContext.setResolutionContext(validationEngineParameters.getResolutionContext());
    validationContext.setAIService(validationEngineParameters.getAIService());
    for (String certSource : validationEngineParameters.getCertSources()) {
      validationContext.addCertSource(certSource);
    }
    validationContext.setTxServer(validationEngineParameters.getTxServer());
    validationContext.setNoEcosystem(validationEngineParameters.getNoEcosystem());
    validationContext.setTxLog(validationEngineParameters.getTxLog());
    validationContext.setTxCache(validationEngineParameters.getTxCache());
    validationContext.setClearTxCache(validationEngineParameters.isClearTxCache());
    validationContext.setAdvisorFile(validationEngineParameters.getAdvisorFile());
    validationContext.setLocale(validationEngineParameters.getLanguageCode());
    validationContext.setLang(validationEngineParameters.getLang());
    validationContext.setCheckReferences(validationEngineParameters.isCheckReferences());
    validationContext.getCheckReferencesTo().addAll(validationEngineParameters.getCheckReferencesTo());
    validationContext.setNoInternalCaching(validationEngineParameters.isNoInternalCaching());
    validationContext.setDisableDefaultResourceFetcher(validationEngineParameters.isDisableDefaultResourceFetcher());
    validationContext.setMapLog(validationEngineParameters.getMapLog());
    validationContext.setDisplayWarnings(validationEngineParameters.isDisplayWarnings());
    validationContext.setNoExtensibleBindingMessages(validationEngineParameters.isNoExtensibleBindingMessages());
    validationContext.setShowTimes(validationEngineParameters.isShowTimes());
    validationContext.setMatchetypes(new ArrayList<>(validationEngineParameters.getMatchetypes()));
    validationContext.setLocations(new HashMap<>(validationEngineParameters.getLocations()));
  }

  public static void addWatchParameters(ValidationContext validationContext, WatchParameters watchParameters) {
    validationContext.setWatchMode(watchParameters.getWatchMode());
    validationContext.setWatchScanDelay(watchParameters.getWatchScanDelay());
    validationContext.setWatchSettleTime(watchParameters.getWatchSettleTime());
  }

  public static void addUnprocessedParameters(ValidationContext validationContext, List<String> unprocessedParameters) {
    for (String unprocessedParam : unprocessedParameters) {
      validationContext.addSource(unprocessedParam);
    }
  }

  public static void addTransformLangParameters(ValidationContext validationContext, TransformLangParameters transformLangParameters) {
    validationContext.setSrcLang(transformLangParameters.getSrcLang());
    validationContext.setTgtLang(transformLangParameters.getTgtLang());
    validationContext.setLangTransform(transformLangParameters.getLangTransform());
    for (String input : transformLangParameters.getInputs()) {
      validationContext.addInput(input);
    }
  }

  public static void addTransformVersionParameters(ValidationContext validationContext, TransformVersionParameters transformVersionParameters) {
    validationContext.setTargetVer(transformVersionParameters.getTargetVer());
    validationContext.setCanDoNative(transformVersionParameters.getCanDoNative());
  }

  public static void addInstanceValidatorParameters(ValidationContext validationContext, InstanceValidatorParameters instanceValidatorParameters) {
    validationContext.setAssumeValidRestReferences(instanceValidatorParameters.isAssumeValidRestReferences());
    validationContext.setHintAboutNonMustSupport(instanceValidatorParameters.isHintAboutNonMustSupport());
    validationContext.setHtmlOutput(instanceValidatorParameters.getHtmlOutput());
    validationContext.setOutputStyle(instanceValidatorParameters.getOutputStyle());
    validationContext.setR5BundleRelativeReferencePolicy(instanceValidatorParameters.getR5BundleRelativeReferencePolicy());
    validationContext.setExtensions(instanceValidatorParameters.getExtensions());
    validationContext.setWantInvariantsInMessages(instanceValidatorParameters.isWantInvariantsInMessages());
    validationContext.setNoInvariants(instanceValidatorParameters.isNoInvariants());
    validationContext.setQuestionnaireMode(instanceValidatorParameters.getQuestionnaireMode());
    validationContext.setUnknownCodeSystemsCauseErrors(instanceValidatorParameters.isUnknownCodeSystemsCauseErrors());
    validationContext.setLevel(instanceValidatorParameters.getLevel());
    validationContext.setBestPracticeLevel(instanceValidatorParameters.getBestPracticeLevel());
    validationContext.setForPublication(instanceValidatorParameters.isForPublication());
    validationContext.setHtmlInMarkdownCheck(instanceValidatorParameters.getHtmlInMarkdownCheck());
    validationContext.setNoUnicodeBiDiControlChars(instanceValidatorParameters.isNoUnicodeBiDiControlChars());
    validationContext.setCrumbTrails(instanceValidatorParameters.isCrumbTrails());
    validationContext.setShowMessageIds(instanceValidatorParameters.isShowMessageIds());
    validationContext.setAllowExampleUrls(instanceValidatorParameters.isAllowExampleUrls());
    validationContext.setShowMessagesFromReferences(instanceValidatorParameters.isShowMessagesFromReferences());
    validationContext.setSecurityChecks(instanceValidatorParameters.isSecurityChecks());
    validationContext.setNoExperimentalContent(instanceValidatorParameters.isNoExperimentalContent());
    validationContext.setShowTerminologyRouting(instanceValidatorParameters.isShowTerminologyRouting());
    validationContext.setExpansionParameters(instanceValidatorParameters.getExpansionParameters());
    validationContext.setProfiles(instanceValidatorParameters.getProfiles());
    validationContext.setDoImplicitFHIRPathStringConversion(instanceValidatorParameters.isDoImplicitFHIRPathStringConversion());
    validationContext.setAllowDoubleQuotesInFHIRPath(instanceValidatorParameters.isAllowDoubleQuotesInFHIRPath());
    validationContext.setCheckIPSCodes(instanceValidatorParameters.isCheckIPSCodes());
    validationContext.setBundleValidationRules(new ArrayList<>(instanceValidatorParameters.getBundleValidationRules()));
    validationContext.setJurisdiction(instanceValidatorParameters.getJurisdiction());
  }

  public static void addOutputParameters(ValidationContext validationContext, OutputParameters outputParameters) {
    validationContext.setOutput(outputParameters.getOutput());
    validationContext.setOutputSuffix(outputParameters.getOutputSuffix());
  }

  public static void addFHIRPathParameters(ValidationContext validationContext, FHIRPathParameters fhirPathParameters) {
    validationContext.setFhirpath(fhirPathParameters.getFhirpath());
  }

  public static void addMapParameters(ValidationContext validationContext, MapParameters mapParameters) {
    validationContext.setMap(mapParameters.getMap());
  }

  public static void addCodeGenParameters(ValidationContext validationContext, CodeGenParameters codeGenParameters) {
    for (String option : codeGenParameters.getOptions()) {
      validationContext.addOption(option);
    }
  }

  public static void addRePackageParameters(ValidationContext validationContext, RePackageParameters rePackageParameters) {
    for (String ig : rePackageParameters.getPackages()) {
      validationContext.addIg(ig);
    }
    for (String modeParam : rePackageParameters.getModeParams()) {
      validationContext.addModeParam(modeParam);
    }
    validationContext.setFormat(rePackageParameters.getFormat());
  }

  public static void addLangRegenParameters(ValidationContext validationContext, LangRegenParameters langRegenParameters) {
    for (String param : langRegenParameters.getLangRegenParam()) {
      validationContext.addLangRegenParam(param);
    }
  }

  public static void addPackageNameParameters(ValidationContext validationContext, PackageNameParameters packageNameParameters) {
    validationContext.setPackageName(packageNameParameters.getPackageName());
  }

  public static void addInstanceFactoryParameters(ValidationContext validationContext, InstanceFactoryParameters instanceFactoryParameters) {
    validationContext.setSource(instanceFactoryParameters.getSource());
  }

  public static ValidationEngineParameters getValidationEngineParameters(ValidationContext validationContext) {
    ValidationEngineParameters validationEngineParameters = new ValidationEngineParameters();
    validationEngineParameters.setInferFhirVersion(validationContext.isInferFhirVersion());
    validationEngineParameters.setDoNative(validationContext.isDoNative());
    validationEngineParameters.setRecursive(validationContext.isRecursive());
    validationEngineParameters.setSnomedCT(validationContext.getSnomedCT());
    validationEngineParameters.setSv(validationContext.getSv());
    for (String ig : validationContext.getIgs()) {
      validationEngineParameters.addIg(ig);
    }
    validationEngineParameters.setBaseEngine(validationContext.getBaseEngine());
    validationEngineParameters.setResolutionContext(validationContext.getResolutionContext());
    validationEngineParameters.setAIService(validationContext.getAIService());
    for (String certSource : validationContext.getCertSources()) {
      validationEngineParameters.addCertSource(certSource);
    }
    validationEngineParameters.setTxServer(validationContext.getTxServer());
    validationEngineParameters.setNoEcosystem(validationContext.getNoEcosystem());
    validationEngineParameters.setTxLog(validationContext.getTxLog());
    validationEngineParameters.setTxCache(validationContext.getTxCache());
    validationEngineParameters.setClearTxCache(validationContext.isClearTxCache());
    validationEngineParameters.setAdvisorFile(validationContext.getAdvisorFile());
    validationEngineParameters.setLocale(validationContext.getLanguageCode());
    validationEngineParameters.setLang(validationContext.getLang());
    validationEngineParameters.setCheckReferences(validationContext.isCheckReferences());
    validationEngineParameters.getCheckReferencesTo().addAll(validationContext.getCheckReferencesTo());
    validationEngineParameters.setNoInternalCaching(validationContext.isNoInternalCaching());
    validationEngineParameters.setDisableDefaultResourceFetcher(validationContext.isDisableDefaultResourceFetcher());
    validationEngineParameters.setMapLog(validationContext.getMapLog());
    validationEngineParameters.setDisplayWarnings(validationContext.isDisplayWarnings());
    validationEngineParameters.setNoExtensibleBindingMessages(validationContext.isNoExtensibleBindingMessages());
    validationEngineParameters.setShowTimes(validationContext.isShowTimes());
    validationEngineParameters.setMatchetypes(new ArrayList<>(validationContext.getMatchetypes()));
    validationEngineParameters.setLocations(new HashMap<>(validationContext.getLocations()));
    return validationEngineParameters;
  }

  public static WatchParameters getWatchParameters(ValidationContext validationContext) {
    WatchParameters watchParameters = new WatchParameters();
    watchParameters.setWatchMode(validationContext.getWatchMode());
    watchParameters.setWatchScanDelay(validationContext.getWatchScanDelay());
    watchParameters.setWatchSettleTime(validationContext.getWatchSettleTime());
    return watchParameters;
  }

  public static TransformLangParameters getTransformLangParameters(ValidationContext validationContext) {
    TransformLangParameters transformLangParameters = new TransformLangParameters();
    transformLangParameters.setSrcLang(validationContext.getSrcLang());
    transformLangParameters.setTgtLang(validationContext.getTgtLang());
    transformLangParameters.setLangTransform(validationContext.getLangTransform());
    transformLangParameters.setInputs(new ArrayList<>(validationContext.getInputs()));
    return transformLangParameters;
  }

  public static TransformVersionParameters getTransformVersionParameters(ValidationContext validationContext) {
    TransformVersionParameters transformVersionParameters = new TransformVersionParameters();
    transformVersionParameters.setTargetVer(validationContext.getTargetVer());
    transformVersionParameters.setCanDoNative(validationContext.getCanDoNative());
    return transformVersionParameters;
  }

  public static InstanceValidatorParameters getInstanceValidatorParameters(ValidationContext validationContext) {
    InstanceValidatorParameters instanceValidatorParameters = new InstanceValidatorParameters();
    instanceValidatorParameters.setAssumeValidRestReferences(validationContext.isAssumeValidRestReferences());
    instanceValidatorParameters.setHintAboutNonMustSupport(validationContext.isHintAboutNonMustSupport());
    instanceValidatorParameters.setHtmlOutput(validationContext.getHtmlOutput());
    instanceValidatorParameters.setOutputStyle(validationContext.getOutputStyle());
    instanceValidatorParameters.setR5BundleRelativeReferencePolicy(validationContext.getR5BundleRelativeReferencePolicy());
    instanceValidatorParameters.setExtensions(validationContext.getExtensions());
    instanceValidatorParameters.setWantInvariantsInMessages(validationContext.isWantInvariantsInMessages());
    instanceValidatorParameters.setNoInvariants(validationContext.isNoInvariants());
    instanceValidatorParameters.setQuestionnaireMode(validationContext.getQuestionnaireMode());
    instanceValidatorParameters.setUnknownCodeSystemsCauseErrors(validationContext.isUnknownCodeSystemsCauseErrors());
    instanceValidatorParameters.setLevel(validationContext.getLevel());
    instanceValidatorParameters.setBestPracticeLevel(validationContext.getBestPracticeLevel());
    instanceValidatorParameters.setForPublication(validationContext.isForPublication());
    instanceValidatorParameters.setHtmlInMarkdownCheck(validationContext.getHtmlInMarkdownCheck());
    instanceValidatorParameters.setNoUnicodeBiDiControlChars(validationContext.isNoUnicodeBiDiControlChars());
    instanceValidatorParameters.setCrumbTrails(validationContext.isCrumbTrails());
    instanceValidatorParameters.setShowMessageIds(validationContext.isShowMessageIds());
    instanceValidatorParameters.setAllowExampleUrls(validationContext.isAllowExampleUrls());
    instanceValidatorParameters.setShowMessagesFromReferences(validationContext.isShowMessagesFromReferences());
    instanceValidatorParameters.setSecurityChecks(validationContext.isSecurityChecks());
    instanceValidatorParameters.setNoExperimentalContent(validationContext.isNoExperimentalContent());
    instanceValidatorParameters.setShowTerminologyRouting(validationContext.isShowTerminologyRouting());
    instanceValidatorParameters.setExpansionParameters(validationContext.getExpansionParameters());
    instanceValidatorParameters.setProfiles(validationContext.getProfiles());
    instanceValidatorParameters.setDoImplicitFHIRPathStringConversion(validationContext.isDoImplicitFHIRPathStringConversion());
    instanceValidatorParameters.setAllowDoubleQuotesInFHIRPath(validationContext.isAllowDoubleQuotesInFHIRPath());
    instanceValidatorParameters.setCheckIPSCodes(validationContext.isCheckIPSCodes());
    instanceValidatorParameters.setBundleValidationRules(new ArrayList<>(validationContext.getBundleValidationRules()));
    instanceValidatorParameters.setJurisdiction(validationContext.getJurisdiction());
    return instanceValidatorParameters;
  }

  public static OutputParameters getOutputParameters(ValidationContext validationContext) {
    OutputParameters outputParameters = new OutputParameters();
    outputParameters.setOutput(validationContext.getOutput());
    outputParameters.setOutputSuffix(validationContext.getOutputSuffix());
    return outputParameters;
  }

  public static FHIRPathParameters getFHIRPathParameters(ValidationContext validationContext) {
    FHIRPathParameters fhirPathParameters = new FHIRPathParameters();
    fhirPathParameters.setFhirpath(validationContext.getFhirpath());
    return fhirPathParameters;
  }

  public static MapParameters getMapParameters(ValidationContext validationContext) {
    MapParameters mapParameters = new MapParameters();
    mapParameters.setMap(validationContext.getMap());
    return mapParameters;
  }

  public static CodeGenParameters getCodeGenParameters(ValidationContext validationContext) {
    CodeGenParameters codeGenParameters = new CodeGenParameters();
    codeGenParameters.setOptions(new ArrayList<>(validationContext.getOptions()));
    return codeGenParameters;
  }

  public static RePackageParameters getRePackageParameters(ValidationContext validationContext) {
    RePackageParameters rePackageParameters = new RePackageParameters();
    rePackageParameters.setPackages(new ArrayList<>(validationContext.getIgs()));
    rePackageParameters.setModeParams(validationContext.getModeParams());
    rePackageParameters.setFormat(validationContext.getFormat());
    return rePackageParameters;
  }

  public static LangRegenParameters getLangRegenParameters(ValidationContext validationContext) {
    LangRegenParameters langRegenParameters = new LangRegenParameters();
    langRegenParameters.setLangRegenParam(new ArrayList<>(validationContext.getLangRegenParam()));
    return langRegenParameters;
  }

  public static PackageNameParameters getPackageNameParameters(ValidationContext validationContext) {
    PackageNameParameters packageNameParameters = new PackageNameParameters();
    packageNameParameters.setPackageName(validationContext.getPackageName());
    return packageNameParameters;
  }

  public static InstanceFactoryParameters getInstanceFactoryParameters(ValidationContext validationContext) {
    InstanceFactoryParameters instanceFactoryParameters = new InstanceFactoryParameters();
    instanceFactoryParameters.setSource(validationContext.getSource());
    return instanceFactoryParameters;
  }
}
