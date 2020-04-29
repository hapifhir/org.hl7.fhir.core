package org.hl7.fhir.validation.tests;

import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.validation.NativeHostServices;
import org.junit.jupiter.api.Test;

public class NativeHostServiceTester {

  @Test
  public void test() throws Exception {
    System.out.println("starting...");
    
    NativeHostServices svc = new NativeHostServices();
    svc.init("hl7.fhir.r4.core#4.0.1");
    svc.connectToTxSvc("http://tx.fhir.org/r4", null);
    System.out.println("base: "+svc.status());

    svc.seeResource(TestingUtilities.loadTestResourceBytes("validator", "misc", "ValueSet-dicm-2-AnatomicModifier.json"), FhirFormat.JSON);
    System.out.println("added: "+svc.status());
    
    svc.dropResource("ValueSet", "dicm-2-AnatomicModifier");
    System.out.println("removed: "+svc.status());

    System.out.println("validate:");
    byte[] res = svc.validateResource("my-loc", TestingUtilities.loadTestResourceBytes("validator", "patient-example.xml"), "XML", "any-extensions id-optional");
    System.out.println(new String(res));
    
    System.out.println("convert:");
    byte[] r4 = svc.convertResource(TestingUtilities.loadTestResourceBytes("validator", "patient-example.xml"), "xml", "4.0");
    System.out.println(new String(r4));    
    
    System.out.println("unconvert:");
    byte[] r2 = svc.convertResource(TestingUtilities.loadTestResourceBytes("validator", "patient-example.xml"), "xml", "1.0");
    System.out.println(new String(r2));    
    
    
    System.out.println("done");
  }

}
