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
import java.util.List;

public class LDContextGeneratorTests {

  String basePath = FileSystems.getDefault().getPath(System.getProperty("java.io.tmpdir")).toString() + "/";
  //String basePath = "/Users/m091864/TEMP/";

  private void doTest(String name) throws IOException, FHIRException {
    StructureDefinition sd = TestingUtilities.context().
      fetchResource(StructureDefinition.class, ProfileUtilities.sdNs(name, null));

    if(sd == null) {
      throw new FHIRException("StructuredDefinition for " + name + "was null");
    }
    String outPath = basePath + name.toLowerCase() + ".context.jsonld";

    LDContextGenerator ldContextGenerator = new LDContextGenerator(TestingUtilities.context());
    TextFile.stringToFile(ldContextGenerator.generate(sd), outPath);
  }

  /**
   * Go through all StructureDefinitions and generate context jsonld.
   * @throws IOException
   * @throws FHIRException
   */
  private void doTestAll() throws IOException, FHIRException {
    List<StructureDefinition> sds = TestingUtilities.context().allStructures();

    for(StructureDefinition sd : sds) {
      if (sd == null ) {
        throw new FHIRException("StructuredDefinition was null");
      }
      String name = sd.getName();
      String outPath = basePath + name.toLowerCase() + ".context.jsonld";

      LDContextGenerator ldContextGenerator = new LDContextGenerator(TestingUtilities.context());
      TextFile.stringToFile(ldContextGenerator.generate(sd), outPath);
      }
  }

//  @Test
//  public void testAll() throws FHIRException, IOException, UcumException {
//    doTestAll();
//  }

  @Test
  public void testAllergyIntolerance() throws FHIRException, IOException, UcumException {
    doTest("AllergyIntolerance");
  }

  @Test
  public void testAccount() throws FHIRException, IOException, UcumException {
    doTest("Account");
  }

  @Test
  public void testPatient() throws FHIRException, IOException, UcumException {
    doTest("Patient");
  }

  @Test
  public void testActivityDefinition() throws FHIRException, IOException, UcumException {
    doTest("ActivityDefinition");
  }

  @Test
  public void testMedicationRequest() throws FHIRException, IOException, UcumException {
    doTest("MedicationRequest");
  }

}
