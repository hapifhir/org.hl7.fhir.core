package org.hl7.fhir.validation.cli.picocli.options;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.validation.service.model.ValidationEngineParameters;

import java.io.File;
import java.io.IOException;

@Slf4j
public class ValidationEngineOptionsConvertor {
  public ValidationEngineParameters convert(ValidationEngineOptions options) {
    ValidationEngineParameters validationEngineParameters = new ValidationEngineParameters();

    // FHIR Version
    validationEngineParameters.setSv(VersionUtilities.getCurrentPackageVersion(options.fhirVersion));

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

    if (options.txServer != null) {
      validationEngineParameters.setTxServer("n/a".equals(options.txServer) ? null : options.txServer);
      validationEngineParameters.setNoEcosystem(true);
    }

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
        final String optionName = "matchetype";
        checkIfFileIsAccessibleAndWarnIfNot(matchetype, optionName);
        validationEngineParameters.addMatchetype(matchetype);
      }
    }

    return validationEngineParameters;
  }

  private static void checkIfFileIsAccessibleAndWarnIfNot(String matchetype, String optionName) {
    try {
      File file = ManagedFileAccess.file(matchetype);
      if (file.exists()) {
        return;
      }
      throw new Error("File does not exist at path '" + matchetype + "' specified by option " + optionName);
    } catch (IOException e) {
      throw new Error("Exception accessing file at path '" + matchetype + "' specified by option " + optionName, e);
    }
  }
}
