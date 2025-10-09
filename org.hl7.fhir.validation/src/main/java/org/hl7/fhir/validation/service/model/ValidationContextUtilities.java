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
    validationContext.setTargetVer(validationEngineParameters.getTargetVer());
    for (String ig : validationEngineParameters.getIgs()) {
      validationContext.addIg(ig);
    }
    validationContext.setBaseEngine(validationEngineParameters.getBaseEngine());
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
    validationEngineParameters.setTargetVer(validationContext.getTargetVer());
    for (String ig : validationContext.getIgs()) {
      validationEngineParameters.addIg(ig);
    }
    validationEngineParameters.setBaseEngine(validationContext.getBaseEngine());
    return validationEngineParameters;
  }
}
