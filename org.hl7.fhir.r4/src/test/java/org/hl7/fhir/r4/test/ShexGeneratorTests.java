package org.hl7.fhir.r4.test;

import org.fhir.ucum.UcumException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.conformance.ProfileUtilities;
import org.hl7.fhir.r4.conformance.ShExGenerator;
import org.hl7.fhir.r4.conformance.ShExGenerator.HTMLLinkPolicy;
import org.hl7.fhir.r4.model.StructureDefinition;
import org.hl7.fhir.r4.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.TextFile;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

@Disabled
public class ShexGeneratorTests {

  private void doTest(String name) throws FileNotFoundException, IOException, FHIRException, UcumException {
    String workingDirectory = "C:\\work\\org.hl7.fhir\\build\\publish"; // FileSystems.getDefault().getPath(System.getProperty("user.dir"), "data").toString();
    // String workingDirectory = FileSystems.getDefault().getPath(System.getProperty("user.dir"), "..", "..", "..", "publish").toString();
    StructureDefinition sd = TestingUtilities.context().fetchResource(StructureDefinition.class, ProfileUtilities.sdNs(name, null));
    if (sd == null) {
      throw new FHIRException("StructuredDefinition for " + name + "was null");
    }
    Path outPath = FileSystems.getDefault().getPath(workingDirectory, name.toLowerCase() + ".shex");
    TextFile.stringToFile(new ShExGenerator(TestingUtilities.context()).generate(HTMLLinkPolicy.NONE, sd), outPath.toString());
  }

  @Test
  public void testId() throws FHIRException, IOException, UcumException {
    doTest("id");
  }

  @Test
  public void testUri() throws FHIRException, IOException, UcumException {
    doTest("uri");
  }


  @Test
  public void testObservation() throws FHIRException, IOException, UcumException {
    doTest("Observation");
  }

  @Test
  public void testRef() throws FHIRException, IOException, UcumException {
    doTest("Reference");
  }

  @Test
  public void testAccount() throws FHIRException, IOException, UcumException {
    doTest("Account");
  }

  @Test
  public void testMedicationRequest() throws FHIRException, IOException, UcumException {
    doTest("MedicationRequest");
  }

  @Test
  public void testAllergyIntolerance() throws FHIRException, IOException, UcumException {
    doTest("AllergyIntolerance");
  }

  @Test
  public void testCoding() throws FHIRException, IOException, UcumException {
    doTest("Coding");
  }

  @Test
  public void testTiming() throws FHIRException, IOException, UcumException {
    doTest("Timing");
  }

  @Test
  public void testSignature() throws FHIRException, IOException, UcumException {
    doTest("Signature");
  }
}