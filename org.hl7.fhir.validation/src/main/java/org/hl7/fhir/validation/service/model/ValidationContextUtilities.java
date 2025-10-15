package org.hl7.fhir.validation.service.model;

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
  }

  public static void addWatchParameters(ValidationContext validationContext, WatchParameters watchParameters) {
    validationContext.setWatchMode(watchParameters.getWatchMode());
    validationContext.setWatchScanDelay(watchParameters.getWatchScanDelay());
    validationContext.setWatchSettleTime(watchParameters.getWatchSettleTime());
  }

  public static void addTransformLangParameters(ValidationContext validationContext, TransformLangParameters transformLangParameters) {
    validationContext.setSrcLang(transformLangParameters.getSrcLang());
    validationContext.setTgtLang(transformLangParameters.getTgtLang());
  }

  public static void addTransformVersionParameters(ValidationContext validationContext, TransformVersionParameters transformVersionParameters) {
    validationContext.setTargetVer(transformVersionParameters.getTargetVer());
  }

  public static void addInstanceValidatorParameters(ValidationContext validationContext, InstanceValidatorParameters instanceValidatorParameters) {
    validationContext.setAssumeValidRestReferences(instanceValidatorParameters.isAssumeValidRestReferences());
    validationContext.setNoExtensibleBindingMessages(instanceValidatorParameters.isNoExtensibleBindingMessages());
    validationContext.setShowTimes(instanceValidatorParameters.isShowTimes());
    validationContext.setHintAboutNonMustSupport(instanceValidatorParameters.isHintAboutNonMustSupport());
  }

  public static void addOutputParameters(ValidationContext validationContext, OutputParameters outputParameters) {
    validationContext.setOutput(outputParameters.getOutput());
    validationContext.setOutputSuffix(outputParameters.getOutputSuffix());
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
    return transformLangParameters;
  }

  public static TransformVersionParameters getTransformVersionParameters(ValidationContext validationContext) {
    TransformVersionParameters transformVersionParameters = new TransformVersionParameters();
    transformVersionParameters.setTargetVer(validationContext.getTargetVer());
    return transformVersionParameters;
  }

  public static InstanceValidatorParameters getInstanceValidatorParameters(ValidationContext validationContext) {
    InstanceValidatorParameters instanceValidatorParameters = new InstanceValidatorParameters();
    instanceValidatorParameters.setAssumeValidRestReferences(validationContext.isAssumeValidRestReferences());
    instanceValidatorParameters.setNoExtensibleBindingMessages(validationContext.isNoExtensibleBindingMessages());
    instanceValidatorParameters.setShowTimes(validationContext.isShowTimes());
    instanceValidatorParameters.setHintAboutNonMustSupport(validationContext.isHintAboutNonMustSupport());
    return instanceValidatorParameters;
  }

  public static OutputParameters getOutputParameters(ValidationContext validationContext) {
    OutputParameters outputParameters = new OutputParameters();
    outputParameters.setOutput(validationContext.getOutput());
    outputParameters.setOutputSuffix(validationContext.getOutputSuffix());
    return outputParameters;
  }
}
