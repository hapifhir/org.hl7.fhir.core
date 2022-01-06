package org.hl7.fhir.validation.tests.utilities;

import org.hl7.fhir.r5.model.FhirPublication;
import org.hl7.fhir.validation.ValidationEngine;

import java.nio.file.Paths;

public class TestUtilities {

  public static boolean silent = false;
  
//  public static String resourceNameToFile(String name) throws IOException {
//    return org.hl7.fhir.utilities.Utilities.path(System.getProperty("user.dir"), "src", "test", "resources", name);
//  }
  public static final ValidationEngine getValidationEngine(java.lang.String src, java.lang.String txsrvr, java.lang.String txLog, FhirPublication version, boolean canRunWithoutTerminologyServer, java.lang.String vString, java.lang.String userAgent) throws Exception {
    txLog = TestConstants.TX_CACHE_LOG;
    final ValidationEngine validationEngine = new ValidationEngine(src, txsrvr, txLog, version, canRunWithoutTerminologyServer, vString, userAgent);
    validationEngine.getContext().initTS(Paths.get(TestConstants.TX_CACHE, vString).toString());
    validationEngine.getContext().setUserAgent("fhir/test-cases");
    return validationEngine;
  }

  public static ValidationEngine getValidationEngine(java.lang.String src, java.lang.String txsrvr, java.lang.String txLog, FhirPublication version, java.lang.String vString, java.lang.String userAgent) throws Exception {
    txLog = TestConstants.TX_CACHE_LOG;
    final ValidationEngine validationEngine = new ValidationEngine(src, txsrvr, txLog, version, vString, userAgent);
    validationEngine.getContext().initTS(Paths.get(TestConstants.TX_CACHE, vString).toString());
    validationEngine.getContext().setUserAgent("fhir/test-cases");
    return validationEngine;
  }
}