package org.hl7.fhir.r5.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.fhir.ucum.UcumException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.ProfileUtilities;
import org.hl7.fhir.r5.conformance.ShExGenerator;
import org.hl7.fhir.r5.conformance.ShExGenerator.HTMLLinkPolicy;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.ZipGenerator;
import org.junit.Test;
//import org.junit.jupiter.api.Test;

public class ShexGeneratorTests {

  private void doTest(String name) throws FileNotFoundException, IOException, FHIRException, UcumException {
    StructureDefinition sd = TestingUtilities.context().fetchResource(StructureDefinition.class, ProfileUtilities.sdNs(name, null));
    if(sd == null) {
      throw new FHIRException("StructuredDefinition for " + name + "was null");
    }
    String outPath = "E:/workspace/temp/TEMP_SHEX/" + name.toLowerCase()+".shex";
//    Path outPath = FileSystems.getDefault().getPath(System.getProperty("java.io.tmpdir"), name.toLowerCase() + ".shex");
    TextFile.stringToFile(new ShExGenerator(TestingUtilities.context()).generate(HTMLLinkPolicy.NONE, sd), outPath.toString());
  }


  /**
   * Go through all StructureDefinitions and generate context jsonld.
   * @throws IOException
   * @throws FHIRException
   */
  private void doTestAll() throws IOException, FHIRException {
    List<StructureDefinition> sds = TestingUtilities.context().allStructures();
    String outPath;

    for(StructureDefinition sd : sds) {
      if (sd == null ) {
        throw new FHIRException("StructuredDefinition was null");
      }

      outPath = "/Users/m091864/TEMP_SHEX/" + sd.getId().toLowerCase()+".shex";
      TextFile.stringToFile(new ShExGenerator(TestingUtilities.context()).generate(HTMLLinkPolicy.NONE, sd), outPath.toString());
    }
  }

  /**
   * Test zipping up a set of SHeX files
   * @throws IOException
   * @throws FHIRException
   */
  private void doTestZip() throws IOException, FHIRException {

    List<StructureDefinition> list = new ArrayList<StructureDefinition>();
    List<StructureDefinition> sds = TestingUtilities.context().allStructures();
    String outPath;
    String basePath = "/Users/m091864/TEMP_SHEX/";

    ZipGenerator zip = new ZipGenerator(basePath+ "fhir.shex.zip");

    for(StructureDefinition sd : sds) {
      if (sd == null ) {
        throw new FHIRException("StructuredDefinition was null");
      }

//      if (sd.getId().toLowerCase().contains("capability")) {
       // System.out.println("Adding SD to list: " + sd.getId());

        outPath = basePath + sd.getId().toLowerCase() + ".shex";
        TextFile.stringToFile(new ShExGenerator(TestingUtilities.context()).generate(HTMLLinkPolicy.NONE, sd), outPath);

        zip.addFileName(sd.getId().toLowerCase() + ".shex", outPath, false);

//      }
//      // add a few different StructureDefinitions to a list.
//      if (sd.getId().toLowerCase().contains("capability")){
//        list.add(sd);
//        System.out.println("Adding SD to list: " + sd.getId());
//      }
    }
//    zip.addFiles(basePath, basePath, "shex", "");

    zip.close();
  }

  @Test
  public void testAllergyIntolerance() throws FHIRException, IOException, UcumException {
    doTest("AllergyIntolerance");
  }

  @Test
  public void testCoding() throws FHIRException, IOException, UcumException {
    doTest("Coding");
  }

//  @Test
//  public void testAll() throws FHIRException, IOException {
//    doTestAll();
//  }

  @Test
  public void testZip() throws FHIRException, IOException {
    doTestZip();
  }

//  @Test
//  public void testPatient() throws FHIRException, IOException, UcumException {
//    doTest("Patient");
//  }

//  @Test
//  public void testId() throws FHIRException, IOException, UcumException {
//    doTest("id");
//  }
//
//  @Test
//  public void testUri() throws FHIRException, IOException, UcumException {
//    doTest("uri");
//  }
//
//
//  @Test
//  public void testObservation() throws FHIRException, IOException, UcumException {
//    doTest("Observation");
//  }
//
//  @Test
//  public void testRef() throws FHIRException, IOException, UcumException {
//    doTest("Reference");
//  }
//
//  @Test
//  public void testAccount() throws FHIRException, IOException, UcumException {
//    doTest("Account");
//  }
//
//  @Test
//  public void testMedicationRequest() throws FHIRException, IOException, UcumException {
//    doTest("MedicationRequest");
//  }
//
//  @Test
//  public void testAllergyIntolerance() throws FHIRException, IOException, UcumException {
//    doTest("AllergyIntolerance");
//  }
//
//  @Test
//  public void testCoding() throws FHIRException, IOException, UcumException {
//    doTest("Coding");
//  }
//
//  @Test
//  public void testTiming() throws FHIRException, IOException, UcumException {
//    doTest("Timing");
//  }
//
//  @Test
//  public void testSignature() throws FHIRException, IOException, UcumException {
//    doTest("Signature");
//  }

//  @Test
//  public void testString() throws FHIRException, IOException, UcumException {
//    doTest("string");
//  }
}
