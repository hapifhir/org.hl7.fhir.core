package org.hl7.fhir.validation.tests;

import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.Servers;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.validation.NativeHostServices;
import org.junit.jupiter.api.Test;

import static org.hl7.fhir.validation.tests.utilities.TestUtilities.getTerminologyCacheDirectory;

public class NativeHostServiceTester {

  private static final boolean DEBUG = false;

  @Test
  public void test() throws Exception {

    msg("starting...");
    
    NativeHostServices svc = new NativeHostServices();
    svc.init("hl7.fhir.r4.core#4.0.1");
    svc.connectToTxSvc(Utilities.path(Servers.TX_SERVER_DEV, "r4"), null, getTerminologyCacheDirectory("nativeHost").toString());
    msg("base: "+svc.status());

    svc.seeResource(TestingUtilities.loadTestResourceBytes("validator", "misc", "ValueSet-dicm-2-AnatomicModifier.json"), FhirFormat.JSON);
    msg("added: "+svc.status());
    
    svc.dropResource("ValueSet", "dicm-2-AnatomicModifier");
    msg("removed: "+svc.status());

    msg("validate:");
    byte[] res = svc.validateResource("my-loc", TestingUtilities.loadTestResourceBytes("validator", "patient-example.xml"), "XML", "any-extensions id-optional");
    msg(new String(res));
    
    msg("convert:");
    byte[] r4 = svc.convertResource(TestingUtilities.loadTestResourceBytes("validator", "patient-example.xml"), "xml", "4.0");
    msg(new String(r4));    
    
    msg("unconvert:");
    byte[] r2 = svc.convertResource(TestingUtilities.loadTestResourceBytes("validator", "patient-example.xml"), "xml", "1.0");
    msg(new String(r2));    
    
    
    msg("done");
  }

  private void msg(String m) {
    if (DEBUG) {
      System.out.println(m);
    }
    
  }

}