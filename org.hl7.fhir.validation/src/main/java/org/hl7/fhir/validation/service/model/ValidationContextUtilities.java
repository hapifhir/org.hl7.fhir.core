package org.hl7.fhir.validation.service.model;

import java.util.ArrayList;

/**
 * This class is intended to provide backward compatibility for the ValidationContext class.
 */
@Deprecated(since="2025-10-08")
public class ValidationContextUtilities {
  public static void addValidationEngineParameters(ValidationContext validationContext, ValidationEngineParameters validationEngineParameters) {
    validationContext.setInferFhirVersion(validationEngineParameters.isInferFhirVersion());
    validationContext.setDoNative(validationEngineParameters.isDoNative());
    validationContext.setSnomedCT(validationEngineParameters.getSnomedCT());
    validationContext.setSv(validationEngineParameters.getSv());
    for (String ig : validationEngineParameters.getIgs()) {
      validationContext.addIg(ig);
    }
    validationContext.setBaseEngine(validationEngineParameters.getBaseEngine());
    validationContext.setResolutionContext(validationEngineParameters.getResolutionContext());
    validationContext.setJurisdiction(validationEngineParameters.getJurisdiction());
    validationContext.setAIService(validationEngineParameters.getAIService());
    for (String certSource : validationEngineParameters.getCertSources()) {
      validationContext.addCertSource(certSource);
    }
    validationContext.setTxServer(validationEngineParameters.getTxServer());
    validationContext.setNoEcosystem(validationEngineParameters.getNoEcosystem());
    validationContext.setTxLog(validationEngineParameters.getTxLog());
    validationContext.setTxCache(validationEngineParameters.getTxCache());
    validationContext.setClearTxCache(validationEngineParameters.isClearTxCache());
    validationContext.setCheckIPSCodes(validationEngineParameters.isCheckIPSCodes());
    validationContext.setDoImplicitFHIRPathStringConversion(validationEngineParameters.isDoImplicitFHIRPathStringConversion());
    validationContext.setAllowDoubleQuotesInFHIRPath(validationEngineParameters.isAllowDoubleQuotesInFHIRPath());
    validationContext.setAdvisorFile(validationEngineParameters.getAdvisorFile());
    validationContext.setBundleValidationRules(validationEngineParameters.getBundleValidationRules());
    validationContext.setLocale(validationEngineParameters.getLanguageCode());
    validationContext.setLang(validationEngineParameters.getLang());
    validationContext.setCheckReferences(validationEngineParameters.isCheckReferences());
  }

  public static void addWatchParameters(ValidationContext validationContext, WatchParameters watchParameters) {
    validationContext.setWatchMode(watchParameters.getWatchMode());
    validationContext.setWatchScanDelay(watchParameters.getWatchScanDelay());
    validationContext.setWatchSettleTime(watchParameters.getWatchSettleTime());
  }

  public static void addTransformLangParameters(ValidationContext validationContext, TransformLangParameters transformLangParameters) {
    validationContext.setSrcLang(transformLangParameters.getSrcLang());
    validationContext.setTgtLang(transformLangParameters.getTgtLang());
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
    validationContext.setNoExtensibleBindingMessages(instanceValidatorParameters.isNoExtensibleBindingMessages());
    validationContext.setShowTimes(instanceValidatorParameters.isShowTimes());
    validationContext.setHintAboutNonMustSupport(instanceValidatorParameters.isHintAboutNonMustSupport());
    validationContext.setHtmlOutput(instanceValidatorParameters.getHtmlOutput());
    validationContext.setOutputStyle(instanceValidatorParameters.getOutputStyle());
    validationContext.setR5BundleRelativeReferencePolicy(instanceValidatorParameters.getR5BundleRelativeReferencePolicy());
    validationContext.setExtensions(instanceValidatorParameters.getExtensions());
    validationContext.setWantInvariantsInMessages(instanceValidatorParameters.isWantInvariantsInMessages());
    validationContext.setNoInvariants(instanceValidatorParameters.isNoInvariants());
    validationContext.setQuestionnaireMode(instanceValidatorParameters.getQuestionnaireMode());
    validationContext.setDisplayWarnings(instanceValidatorParameters.isDisplayWarnings());
    validationContext.setUnknownCodeSystemsCauseErrors(instanceValidatorParameters.isUnknownCodeSystemsCauseErrors());
    validationContext.setLevel(instanceValidatorParameters.getLevel());
    validationContext.setBestPracticeLevel(instanceValidatorParameters.getBestPracticeLevel());
    validationContext.setForPublication(instanceValidatorParameters.isForPublication());
    validationContext.setHtmlInMarkdownCheck(instanceValidatorParameters.getHtmlInMarkdownCheck());
    validationContext.setNoUnicodeBiDiControlChars(instanceValidatorParameters.isNoUnicodeBiDiControlChars());
    validationContext.setCrumbTrails(instanceValidatorParameters.isCrumbTrails());
    validationContext.setShowMessageIds(instanceValidatorParameters.isShowMessageIds());
    validationContext.setAllowExampleUrls(instanceValidatorParameters.isAllowExampleUrls());
    validationContext.setMatchetypes(new ArrayList<>(instanceValidatorParameters.getMatchetypes()));
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

  public static ValidationEngineParameters getValidationEngineParameters(ValidationContext validationContext) {
    ValidationEngineParameters validationEngineParameters = new ValidationEngineParameters();
    validationEngineParameters.setInferFhirVersion(validationContext.isInferFhirVersion());
    validationEngineParameters.setDoNative(validationContext.isDoNative());
    validationEngineParameters.setSnomedCT(validationContext.getSnomedCT());
    validationEngineParameters.setSv(validationContext.getSv());
    for (String ig : validationContext.getIgs()) {
      validationEngineParameters.addIg(ig);
    }
    validationEngineParameters.setBaseEngine(validationContext.getBaseEngine());
    validationEngineParameters.setResolutionContext(validationContext.getResolutionContext());
    validationEngineParameters.setJurisdiction(validationContext.getJurisdiction());
    validationEngineParameters.setAIService(validationContext.getAIService());
    for (String certSource : validationContext.getCertSources()) {
      validationEngineParameters.addCertSource(certSource);
    }
    validationEngineParameters.setTxServer(validationContext.getTxServer());
    validationEngineParameters.setNoEcosystem(validationContext.getNoEcosystem());
    validationEngineParameters.setTxLog(validationContext.getTxLog());
    validationEngineParameters.setTxCache(validationContext.getTxCache());
    validationEngineParameters.setClearTxCache(validationContext.isClearTxCache());
    validationEngineParameters.setCheckIPSCodes(validationContext.isCheckIPSCodes());
    validationEngineParameters.setDoImplicitFHIRPathStringConversion(validationContext.isDoImplicitFHIRPathStringConversion());
    validationEngineParameters.setAllowDoubleQuotesInFHIRPath(validationContext.isAllowDoubleQuotesInFHIRPath());
    validationEngineParameters.setAdvisorFile(validationContext.getAdvisorFile());
    validationEngineParameters.setBundleValidationRules(validationContext.getBundleValidationRules());
    validationEngineParameters.setLocale(validationContext.getLanguageCode());
    validationEngineParameters.setLang(validationContext.getLang());
    validationEngineParameters.setCheckReferences(validationContext.isCheckReferences());
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
    instanceValidatorParameters.setNoExtensibleBindingMessages(validationContext.isNoExtensibleBindingMessages());
    instanceValidatorParameters.setShowTimes(validationContext.isShowTimes());
    instanceValidatorParameters.setHintAboutNonMustSupport(validationContext.isHintAboutNonMustSupport());
    instanceValidatorParameters.setHtmlOutput(validationContext.getHtmlOutput());
    instanceValidatorParameters.setOutputStyle(validationContext.getOutputStyle());
    instanceValidatorParameters.setR5BundleRelativeReferencePolicy(validationContext.getR5BundleRelativeReferencePolicy());
    instanceValidatorParameters.setExtensions(validationContext.getExtensions());
    instanceValidatorParameters.setWantInvariantsInMessages(validationContext.isWantInvariantsInMessages());
    instanceValidatorParameters.setNoInvariants(validationContext.isNoInvariants());
    instanceValidatorParameters.setQuestionnaireMode(validationContext.getQuestionnaireMode());
    instanceValidatorParameters.setDisplayWarnings(validationContext.isDisplayWarnings());
    instanceValidatorParameters.setUnknownCodeSystemsCauseErrors(validationContext.isUnknownCodeSystemsCauseErrors());
    instanceValidatorParameters.setLevel(validationContext.getLevel());
    instanceValidatorParameters.setBestPracticeLevel(validationContext.getBestPracticeLevel());
    instanceValidatorParameters.setForPublication(validationContext.isForPublication());
    instanceValidatorParameters.setHtmlInMarkdownCheck(validationContext.getHtmlInMarkdownCheck());
    instanceValidatorParameters.setNoUnicodeBiDiControlChars(validationContext.isNoUnicodeBiDiControlChars());
    instanceValidatorParameters.setCrumbTrails(validationContext.isCrumbTrails());
    instanceValidatorParameters.setShowMessageIds(validationContext.isShowMessageIds());
    instanceValidatorParameters.setAllowExampleUrls(validationContext.isAllowExampleUrls());
    instanceValidatorParameters.setMatchetypes(new ArrayList<>(validationContext.getMatchetypes()));
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
}
