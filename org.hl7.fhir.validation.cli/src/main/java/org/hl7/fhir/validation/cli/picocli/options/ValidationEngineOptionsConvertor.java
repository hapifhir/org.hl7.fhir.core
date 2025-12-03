package org.hl7.fhir.validation.cli.picocli.options;

import org.hl7.fhir.validation.service.model.ValidationEngineParameters;

public class ValidationEngineOptionsConvertor {
  public ValidationEngineParameters convert(ValidationEngineOptions options) {
    ValidationEngineParameters validationEngineParameters = new ValidationEngineParameters();

    // FHIR Version
    validationEngineParameters.setSv(options.fhirVersion);

    // Boolean flags
    validationEngineParameters.setDoNative(options.doNative);
    validationEngineParameters.setRecursive(options.recursive);
    validationEngineParameters.setClearTxCache(options.clearTxCache);
    validationEngineParameters.setCheckReferences(options.checkReferences);
    validationEngineParameters.setNoInternalCaching(options.noInternalCaching);
    validationEngineParameters.setDisableDefaultResourceFetcher(options.disableDefaultResourceFetcher);
    validationEngineParameters.setDisplayWarnings(options.displayWarnings);
    validationEngineParameters.setNoExtensibleBindingMessages(options.noExtensibleBindingMessages);
    validationEngineParameters.setShowTimes(options.showTimes);
    validationEngineParameters.setDoDebug(options.doDebug);

    // String fields
    if (options.snomedCT != null) {
      validationEngineParameters.setSnomedCT(options.snomedCT);
    }
    if (options.resolutionContext != null) {
      validationEngineParameters.setResolutionContext(options.resolutionContext);
    }
    if (options.aiService != null) {
      validationEngineParameters.setAIService(options.aiService);
    }
    // txServer has a default, so always set it
    validationEngineParameters.setTxServer(options.txServer);
    // noEcosystem is set when txServer differs from default, but we handle this explicitly
    validationEngineParameters.setNoEcosystem(options.noEcosystem);
    if (options.txLog != null) {
      validationEngineParameters.setTxLog(options.txLog);
    }
    if (options.txCache != null) {
      validationEngineParameters.setTxCache(options.txCache);
    }
    if (options.advisorFile != null) {
      validationEngineParameters.setAdvisorFile(options.advisorFile);
    }
    if (options.lang != null) {
      validationEngineParameters.setLang(options.lang);
    }
    if (options.mapLog != null) {
      validationEngineParameters.setMapLog(options.mapLog);
    }

    // List fields - use addX() methods
    if (options.igs != null) {
      for (String ig : options.igs) {
        validationEngineParameters.addIg(ig);
      }
    }
    if (options.certSources != null) {
      for (String cert : options.certSources) {
        validationEngineParameters.addCertSource(cert);
      }
    }
    if (options.matchetypes != null) {
      for (String matchetype : options.matchetypes) {
        validationEngineParameters.addMatchetype(matchetype);
      }
    }

    return validationEngineParameters;
  }
}
