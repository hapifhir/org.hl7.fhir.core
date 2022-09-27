package org.hl7.fhir.r5.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.fhir.ucum.UcumException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.ProfileUtilities;
import org.hl7.fhir.r5.conformance.ShExGenerator;
import org.hl7.fhir.r5.conformance.ShExGenerator.HTMLLinkPolicy;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.TextFile;
import org.junit.jupiter.api.Test;

public class ShexGeneratorTests {

  private void doTest(String name) throws FileNotFoundException, IOException, FHIRException, UcumException {
    StructureDefinition sd = TestingUtilities.getSharedWorkerContext().fetchResource(StructureDefinition.class, ProfileUtilities.sdNs(name, null));
    if (sd == null) {
      throw new FHIRException("StructuredDefinition for " + name + "was null");
    }
    //Path outPath = FileSystems.getDefault().getPath(System.getProperty("java.io.tmpdir"), name.toLowerCase() + ".shex");
    Path outPath = FileSystems.getDefault().getPath(System.getProperty("user.home")+"/runtime_environments/ShExSchemas", name.toLowerCase() + ".shex");
    TextFile.stringToFile(new ShExGenerator(TestingUtilities.getSharedWorkerContext()).generate(HTMLLinkPolicy.NONE, sd), outPath.toString());
  }

  private void doTestThis(String name){
    StructureDefinition sd = TestingUtilities.getSharedWorkerContext().fetchResource(StructureDefinition.class, ProfileUtilities.sdNs(name, null));
    if (sd == null) {
      throw new FHIRException("StructuredDefinition for " + name + "was null");
    }
    Path outPath = FileSystems.getDefault().getPath(System.getProperty("user.home") + "/runtime_environments/ShExSchemas", name + ".shex");
    try {
      TextFile.stringToFile(new ShExGenerator(TestingUtilities.getSharedWorkerContext()).generate(HTMLLinkPolicy.NONE, sd), outPath.toString());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private void printList(String title, List<String> items){
    Collections.sort(items);
    System.out.println("************************************************************************");
    System.out.println("Printing " + title);
    System.out.println("************************************************************************");
    items.forEach((String item) -> {
      System.out.println(item);
    });
  }

  private void processList(String title, List<String> items){
    Collections.sort(items);
    System.out.println("************************************************************************");
    System.out.println("Processing " + title);
    System.out.println("************************************************************************");
    items.forEach((String item) -> {
      System.out.println("******************** " + item + " *********************");
      doTestThis(item);
    });
  }

  @Test
  public void doTestAll() throws FileNotFoundException, IOException, FHIRException, UcumException {
    List<StructureDefinition> sds = TestingUtilities.getSharedWorkerContext().allStructures();
    if ((sds == null)||(sds.isEmpty())) {
      throw new FHIRException("No StructuredDefinition found");
    }

    List<String> sdNames = new ArrayList<String>();
    List<String> extNames = new ArrayList<String>();
    List<String> logicalNames = new ArrayList<String>();
    List<String> otherNames = new ArrayList<String>();
    List<String> sdNamesPrint = new ArrayList<String>();
    List<String> extNamesPrint = new ArrayList<String>();
    List<String> logicalNamesPrint = new ArrayList<String>();
    List<String> otherNamesPrint = new ArrayList<String>();
    sds.forEach((StructureDefinition sd ) ->{
      if (sd.getBaseDefinition() == null){
        logicalNames.add(sd.getName());
        logicalNamesPrint.add(sd.getKind().name() + "\t" + sd.getName() + "\t" + sd.getType() + "\t" + sd.getUrl() + "\t" + sd.getBaseDefinition());
      }
      else if (sd.getType().trim().equals(sd.getName().trim())) {
        sdNames.add(sd.getName());
        sdNamesPrint.add(sd.getKind().name() + "\t" + sd.getName() + "\t" + sd.getType() + "\t" + sd.getUrl() + "\t" + sd.getBaseDefinition());
      }
      else if ("Extension".equals(sd.getType())) {
        extNames.add(sd.getName());
        extNamesPrint.add(sd.getKind().name() + "\t" + sd.getName() + "\t" + sd.getType() + "\t" + sd.getUrl() + "\t" + sd.getBaseDefinition());
      }
      else {
        otherNames.add(sd.getName());
        otherNamesPrint.add(sd.getKind().name() + "\t" + sd.getName() + "\t" + sd.getType() + "\t" + sd.getUrl() + "\t" + sd.getBaseDefinition());
      }
    });

    //printList("StructureDefinitions", sdNamesPrint);
    //printList("Extensions", extNamesPrint);
    //printList("Logical", logicalNamesPrint);
    //printList("Profiles", otherNamesPrint);

    processList("StructureDefinitions", sdNames);
    //processList("Extensions", extNames);
    //processList("Logical", logicalNames);
    //processList("Profiles", otherNames);

    System.out.println("************************************************************************");
    System.out.println("Total Items: " + sds.size());
    System.out.println("Total SDS: " + sdNames.size());
    System.out.println("Total Extensions: " + extNames.size());
    System.out.println("Total Logical: " + logicalNames.size());
    System.out.println("Total Other: " + otherNames.size());
    System.out.println("************************************************************************");
  }

  @Test
  public void testActivityDefinition() throws FHIRException, IOException, UcumException {
    doTest("ActivityDefinition");
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