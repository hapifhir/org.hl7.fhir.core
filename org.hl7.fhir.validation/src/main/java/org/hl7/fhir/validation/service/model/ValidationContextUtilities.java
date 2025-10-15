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
    validationContext.setHintAboutNonMustSupport(validationEngineParameters.isHintAboutNonMustSupport());
    validationContext.setAssumeValidRestReferences(validationEngineParameters.isAssumeValidRestReferences());
    validationContext.setNoExtensibleBindingMessages(validationEngineParameters.isNoExtensibleBindingMessages());
    validationContext.setSv(validationEngineParameters.getSv());
    for (String ig : validationEngineParameters.getIgs()) {
      validationContext.addIg(ig);
    }
    validationContext.setBaseEngine(validationEngineParameters.getBaseEngine());
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

  public static ValidationEngineParameters getValidationEngineParameters(ValidationContext validationContext) {
    ValidationEngineParameters validationEngineParameters = new ValidationEngineParameters();
    validationEngineParameters.setInferFhirVersion(validationContext.isInferFhirVersion());
    validationEngineParameters.setDoNative(validationContext.isDoNative());
    validationEngineParameters.setSnomedCT(validationContext.getSnomedCT());
    validationEngineParameters.setHintAboutNonMustSupport(validationContext.isHintAboutNonMustSupport());
    validationEngineParameters.setAssumeValidRestReferences(validationContext.isAssumeValidRestReferences());
    validationEngineParameters.setNoExtensibleBindingMessages(validationContext.isNoExtensibleBindingMessages());
    validationEngineParameters.setSv(validationContext.getSv());
    for (String ig : validationContext.getIgs()) {
      validationEngineParameters.addIg(ig);
    }
    validationEngineParameters.setBaseEngine(validationContext.getBaseEngine());
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
}
