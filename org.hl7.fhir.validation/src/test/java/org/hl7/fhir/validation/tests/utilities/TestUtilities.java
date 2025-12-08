package org.hl7.fhir.validation.tests.utilities;

import java.nio.file.Paths;
import java.util.Locale;

import org.hl7.fhir.r5.Constants;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyCache;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.validation.constants.ReferenceValidationPolicy;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.tests.TestConfig;
import org.hl7.fhir.utilities.tests.TestConstants;
import org.hl7.fhir.validation.IgLoader;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.instance.advisor.BasePolicyAdvisorForFullValidation;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;

public class TestUtilities {

  public static boolean silent = false;

  public static ValidationEngine getValidationEngine(java.lang.String src, java.lang.String txServer, String txLog, FhirPublication version, 
      boolean canRunWithoutTerminologyServer, String vString, boolean usesEcosystem, String thoVersion, String extensionsVersion) throws Exception {
    TestingUtilities.injectCorePackageLoader();

   final ValidationEngine validationEngine = new ValidationEngine.ValidationEngineBuilder()
      .withCanRunWithoutTerminologyServer(canRunWithoutTerminologyServer)
      .withVersion(vString)
      .withUserAgent(TestConstants.USER_AGENT)
      .withTerminologyCachePath(getTerminologyCacheDirectory(vString))
      .withTxServer(txServer, txLog, version, usesEcosystem)
      .withThoVersion(thoVersion)
      .withExtensionsVersion(extensionsVersion)
      .fromSource(src);

    TerminologyCache.setCacheErrors(true);
    validationEngine.setLanguage("en-US");
    validationEngine.setLocale(Locale.US);

    // #TODO: David, where should these go?
    SimpleWorkerContext ctxt = validationEngine.getContext();
    ctxt.setPackageManager(new FilesystemPackageCacheManager.Builder().build());
    ctxt.setLoaderFactory(validationEngine.getIgLoader());

    return validationEngine;
  }

  public static String getTerminologyCacheDirectory(String ... testSetPath) {
    return Paths.get(TestConfig.getInstance().getTxCacheDirectory("org.hl7.fhir.validation"), testSetPath).toString();
  }


  public static ValidationEngine getValidationEngineNoTxServer(java.lang.String src, java.lang.String vString) throws Exception {

   final ValidationEngine validationEngine = new ValidationEngine.ValidationEngineBuilder()
      .withCanRunWithoutTerminologyServer(true)
      .withVersion(vString)
      .withUserAgent(TestConstants.USER_AGENT)
      .fromSource(src);
    validationEngine.setLanguage("en-US");
    validationEngine.setLocale(Locale.US);
    return validationEngine;
  }

  public static ValidationEngine getValidationEngine(java.lang.String src, java.lang.String txServer, FhirPublication version, java.lang.String vString) throws Exception {
      return getValidationEngine(src, txServer, version, vString, new InstanceValidatorParameters());
    }

    public static ValidationEngine getValidationEngine(java.lang.String src, java.lang.String txServer, FhirPublication version, java.lang.String vString, InstanceValidatorParameters instanceValidatorParameters) throws Exception {
    TestingUtilities.injectCorePackageLoader();
    ValidationEngine validationEngine = null;
    if ("n/a".equals(txServer)) {
      validationEngine = new ValidationEngine.ValidationEngineBuilder()
          .withDefaultInstanceValidatorParameters(instanceValidatorParameters)
          .withVersion(vString)
          .withUserAgent(TestConstants.USER_AGENT)
          .withNoTerminologyServer()
          .withThoVersion(Constants.THO_WORKING_VERSION)
          .withExtensionsVersion(Constants.EXTENSIONS_WORKING_VERSION)
          .fromSource(src);      
    } else {
      validationEngine = new ValidationEngine.ValidationEngineBuilder()
        .withDefaultInstanceValidatorParameters(instanceValidatorParameters)
        .withVersion(vString)
        .withUserAgent(TestConstants.USER_AGENT)
        .withTerminologyCachePath(getTerminologyCacheDirectory(vString))
        .withTxServer(txServer, TestConstants.TX_CACHE_LOG, version, false)
        .withThoVersion(Constants.THO_WORKING_VERSION)
        .withExtensionsVersion(Constants.EXTENSIONS_WORKING_VERSION)
        .fromSource(src);
      TerminologyCache.setCacheErrors(true);
    }
    validationEngine.setLanguage("en-US");
    validationEngine.setLocale(Locale.US);
    validationEngine.setPolicyAdvisor(new BasePolicyAdvisorForFullValidation(ReferenceValidationPolicy.IGNORE, null));
    return validationEngine;
  }

  public static boolean runningAsSurefire() {
    return "true".equals(System.getProperty("runningAsSurefire") != null ? System.getProperty("runningAsSurefire").toLowerCase(Locale.ENGLISH) : "");
  }
}