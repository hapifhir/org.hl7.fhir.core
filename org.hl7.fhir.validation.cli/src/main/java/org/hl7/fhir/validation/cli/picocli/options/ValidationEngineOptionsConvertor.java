package org.hl7.fhir.validation.cli.picocli.options;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.utilities.Utilities;
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
    if (options.fhirVersion != null) {
      validationEngineParameters.setSv(VersionUtilities.getCurrentPackageVersion(options.fhirVersion));
    }
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
    } else {
      validationEngineParameters.setTxServer("");
    }

    if (options.txLog != null) {
      validationEngineParameters.setTxLog(options.txLog);
    }
    if (options.txCache != null) {
      validationEngineParameters.setTxCache(options.txCache);
    }
    if (options.advisorFile != null) {
      checkFileAccess(options.advisorFile, true, "-advisor-file");
      if (!Utilities.existsInList(Utilities.getFileExtension(options.advisorFile), "json", "txt")) {
        throw new IllegalArgumentException("Advisor file " + options.advisorFile + " must be a .json or a .txt file");
      }
      validationEngineParameters.setAdvisorFile(options.advisorFile);
    }
    if (options.lang != null) {
      validationEngineParameters.setLang(options.lang);
    }
    if (options.mapLog != null) {
      checkFileAccess(options.mapLog, false, "-log");
      validationEngineParameters.setMapLog(options.mapLog);
    }

    // List fields - use addX() methods
    if (options.igs != null) {
      for (String ig : options.igs) {
        String fhirVersionForCorePackage = corePackageVersion(ig);
        if (fhirVersionForCorePackage == null) {
          validationEngineParameters.addIg(ig);
        } else {
         if (options.fhirVersion != null && !VersionUtilities.getCurrentPackageVersion(options.fhirVersion).equals(fhirVersionForCorePackage)) {
           throw new IllegalArgumentException("Parameters are inconsistent: version specified by -version is '"+options.fhirVersion+"' but -ig parameter '"+ig+"' implies '"+fhirVersionForCorePackage+"'");
         }
         if (validationEngineParameters.getSv() != null && !fhirVersionForCorePackage.equals(validationEngineParameters.getSv())) {
           throw new IllegalArgumentException("Parameters are inconsistent: another IG has set the version to '"+ validationEngineParameters.getSv()+"' but -ig parameter '"+ig+"' implies '"+fhirVersionForCorePackage+"'");
         }
         validationEngineParameters.setSv(fhirVersionForCorePackage);
        }

      }
    }
    if (options.certSources != null) {
      for (String certSource : options.certSources) {
        checkFileAccess(certSource, true, "-cert");
        validationEngineParameters.addCertSource(certSource);
      }
    }
    if (options.matchetypes != null) {
      for (String matchetype : options.matchetypes) {
        checkFileAccess(matchetype, true, "-matchetype");
        validationEngineParameters.addMatchetype(matchetype);
      }
    }

    return validationEngineParameters;
  }

  private static void checkFileAccess(String filePath, boolean checkExists, String optionName) {
    try {
      File file = ManagedFileAccess.file(filePath);
      if (!checkExists)
        return;
      if (file.exists()) {
        return;
      }
      throw new IllegalArgumentException("File does not exist at path '" + filePath + "' specified by option " + optionName);
    } catch (IOException e) {
      throw new IllegalArgumentException("Exception accessing file at path '" + filePath + "' specified by option " + optionName, e);
    }
  }

  /**
   * If this is a core package, return the appropriate FHIR version, otherwise return null
   *
   * @param igFileName the IG file name
   * @return FHIR version, or null if not a core IG
   */
  public static String corePackageVersion(String igFileName) {
    if (igFileName.equals("hl7.fhir.core")) {
      return "5.0";
    } else if (igFileName.startsWith("hl7.fhir.core#")) {
      return VersionUtilities.getCurrentPackageVersion(igFileName.substring(14));
    } else if (igFileName.startsWith("hl7.fhir.r2.core#") || igFileName.equals("hl7.fhir.r2.core")) {
      return "1.0";
    } else if (igFileName.startsWith("hl7.fhir.r2b.core#") || igFileName.equals("hl7.fhir.r2b.core")) {
      return "1.4";
    } else if (igFileName.startsWith("hl7.fhir.r3.core#") || igFileName.equals("hl7.fhir.r3.core")) {
      return "3.0";
    } else if (igFileName.startsWith("hl7.fhir.r4.core#") || igFileName.equals("hl7.fhir.r4.core")) {
      return "4.0";
    } else if (igFileName.startsWith("hl7.fhir.r5.core#") || igFileName.equals("hl7.fhir.r5.core")) {
      return "5.0";
    } else if (igFileName.startsWith("hl7.fhir.r6.core#") || igFileName.equals("hl7.fhir.r6.core")) {
      return "6.0";
    }
    return null;
  }
}
