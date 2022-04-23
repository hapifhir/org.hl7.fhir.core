package org.hl7.fhir.validation.tests.utilities;

import org.hl7.fhir.r5.context.TerminologyCache;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.validation.ValidationEngine;

import java.nio.file.Paths;

public class TestUtilities {

  public static boolean silent = false;

  public static ValidationEngine getValidationEngine(java.lang.String src, java.lang.String txServer, String txLog, FhirPublication version, boolean canRunWithoutTerminologyServer, java.lang.String vString) throws Exception {

   final ValidationEngine validationEngine = new ValidationEngine.ValidationEngineBuilder()
      .withCanRunWithoutTerminologyServer(canRunWithoutTerminologyServer)
      .withVersion(vString)
      .withUserAgent(TestConstants.USER_AGENT)
      .withTerminologyCachePath(Paths.get(TestConstants.TX_CACHE, vString).toString())
      .withTxServer(txServer, txLog, version)
      .fromSource(src);

    TerminologyCache.setCacheErrors(true);
    return validationEngine;
  }

  public static ValidationEngine getValidationEngine(java.lang.String src, java.lang.String txServer, FhirPublication version, java.lang.String vString) throws Exception {
    final ValidationEngine validationEngine = new ValidationEngine.ValidationEngineBuilder()
      .withVersion(vString)
      .withUserAgent(TestConstants.USER_AGENT)
      .withTerminologyCachePath(Paths.get(TestConstants.TX_CACHE, vString).toString())
      .withTxServer(txServer, TestConstants.TX_CACHE_LOG, version)
      .fromSource(src);
    TerminologyCache.setCacheErrors(true);

    return validationEngine;
  }
}