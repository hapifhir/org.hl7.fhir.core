package org.hl7.fhir.r5.test;

import org.fhir.ucum.UcumException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.ProfileUtilities;
import org.hl7.fhir.r5.conformance.LDContextGenerator;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.TextFile;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class LDContextGeneratorTests {

//  String basePath = FileSystems.getDefault().getPath(System.getProperty("java.io.tmpdir")).toString() + "/";
  String basePath = "/Users/m091864/TEMP/";

  private void doTest(String name) throws IOException, FHIRException {
    StructureDefinition sd = TestingUtilities.context().
      fetchResource(StructureDefinition.class, ProfileUtilities.sdNs(name, null));

    if(sd == null) {
      throw new FHIRException("StructuredDefinition for " + name + " was null");
    }
    //String outPath = basePath + name.toLowerCase() + ".context.jsonld";

    LDContextGenerator ldContextGenerator = new LDContextGenerator();


    ConcurrentHashMap<String, String> renderedJson = ldContextGenerator.generate(sd);

    // write each json string to a file
    // may be multiples if there were BackboneElements processed.
    for (String jsonName : renderedJson.keySet()){
      TextFile.stringToFile(renderedJson.get(jsonName),basePath + jsonName.toLowerCase() + ".context.jsonld");
    }

   // TextFile.stringToFile(ldContextGenerator.generate(sd), outPath);
  }

  /**
   * Go through all StructureDefinitions and generate context jsonld.
   * @throws IOException
   * @throws FHIRException
   */
  private void doTestAll() throws IOException, FHIRException {
    List<StructureDefinition> sds = TestingUtilities.context().allStructures();
    ConcurrentHashMap<String, String> renderedJson;

    for(StructureDefinition sd : sds) {
      if (sd == null ) {
        throw new FHIRException("StructuredDefinition was null");
      }

      synchronized(this) {
        LDContextGenerator ldContextGenerator = new LDContextGenerator();
        
        renderedJson = ldContextGenerator.generate(sd);

        // write each json string to a file
        // may be multiples if there were BackboneElements processed.
        for (String jsonName : renderedJson.keySet()) {
          TextFile.stringToFile(renderedJson.get(jsonName), basePath + jsonName.toLowerCase() + ".context.jsonld");
        }

      }
    }
  }
//
  @Test
  public void testAll() throws FHIRException, IOException, UcumException {
    doTestAll();
  }

//  @Test
//  public void testIdentifier() throws FHIRException, IOException, UcumException {
//    doTest("Identifier");
//  }

//  @Test
//  public void testExpression() throws FHIRException, IOException, UcumException {
//    doTest("Expression");
//  }

//  @Test
//  public void testDevice() throws FHIRException, IOException, UcumException {
//    doTest("Device");
//  }

//  @Test
//  public void testObservation() throws FHIRException, IOException, UcumException {
//    doTest("Observation");  // *** doesn't have backbone element, but is on fhir website ***
//  }

//  @Test
//  public void testDataRequirement() throws FHIRException, IOException, UcumException {
//    doTest("DataRequirement");  // *** doesn't have backbone element ***
//  }

//  @Test
//  public void testAuditEvent() throws FHIRException, IOException, UcumException {
//    doTest("AuditEvent");
//  }

//  @Test
//  public void testAllergyIntolerance() throws FHIRException, IOException, UcumException {
//    doTest("AllergyIntolerance");
//  }
//
//  @Test
//  public void testAccount() throws FHIRException, IOException, UcumException {
//    doTest("Account");
//  }
//
//  @Test
//  public void testPatient() throws FHIRException, IOException, UcumException {
//    doTest("Patient");
//  }
//
//  @Test
//  public void testActivityDefinition() throws FHIRException, IOException, UcumException {
//    doTest("ActivityDefinition");
//  }
//
//  @Test
//  public void testMedicationRequest() throws FHIRException, IOException, UcumException {
//    doTest("MedicationRequest");
//  }
//
//  @Test
//  public void testDateTime() throws FHIRException, IOException, UcumException {
//    doTest("dateTime");
//  }
//
//  @Test
//  public void testAddress() throws FHIRException, IOException, UcumException {
//    doTest("Address");
//  }
//  @Test
//  public void testReference() throws FHIRException, IOException, UcumException {
//    doTest("Reference");
//  }
//    @Test
//    public void testString() throws FHIRException, IOException, UcumException {
//      doTest("string");
//  }
}
