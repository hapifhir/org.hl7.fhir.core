package org.hl7.fhir.validation.tests;

import org.hl7.fhir.r5.validation.NativeHostServices;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.validation.tests.utilities.TestUtilities;

public class NativeHostServiceTester {

  public static void main(String[] args) throws Exception {
    System.out.println("starting...");
    
    NativeHostServices svc = new NativeHostServices();
    svc.init("hl7.fhir.core#4.0.0");
    svc.connectToTxSvc("http://tx.fhir.org/r4", null);
    System.out.println("base: "+svc.status());

    svc.seeResource(TextFile.fileToBytes(TestUtilities.resourceNameToFile("ValueSet-dicm-2-AnatomicModifier.json")));
    System.out.println("added: "+svc.status());
    
    svc.dropResource("ValueSet", "dicm-2-AnatomicModifier");
    System.out.println("removed: "+svc.status());

    System.out.println("validate:");
    byte[] res = svc.validateResource("my-loc", TextFile.fileToBytes(TestUtilities.resourceNameToFile("validation-examples", "patient-example.xml")), "XML", "any-extensions id-optional");
    System.out.println(new String(res));
    
    System.out.println("convert:");
    byte[] r4 = svc.convertResource(TextFile.fileToBytes(TestUtilities.resourceNameToFile("validation-examples", "patient-example.xml")), "xml", "r2");
    System.out.println(new String(r4));    
    
    System.out.println("unconvert:");
    byte[] r2 = svc.convertResource(TextFile.fileToBytes(TestUtilities.resourceNameToFile("validation-examples", "patient-example.xml")), "xml", "r2");
    System.out.println(new String(r2));    
    
    
    System.out.println("done");
  }

}
