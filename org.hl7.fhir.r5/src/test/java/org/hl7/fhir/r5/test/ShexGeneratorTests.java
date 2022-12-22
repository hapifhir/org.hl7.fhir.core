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
      throw new FHIRException("StructuredDefinition for " + name + " was null");
    }
    //Path outPath = FileSystems.getDefault().getPath(System.getProperty("java.io.tmpdir"), name.toLowerCase() + ".shex");
    Path outPath = FileSystems.getDefault().getPath(System.getProperty("user.home")+"/runtime_environments/ShExSchemas", name.toLowerCase() + ".shex");
    TextFile.stringToFile(new ShExGenerator(TestingUtilities.getSharedWorkerContext()).generate(HTMLLinkPolicy.NONE, sd), outPath.toString());
  }

  private void doTestThis(String shortName, String name){
    StructureDefinition sd = TestingUtilities.getSharedWorkerContext().fetchResource(StructureDefinition.class, ProfileUtilities.sdNs(name, null));
    if (sd == null) {
      //throw new FHIRException("ERROR! ERROR! ERROR! StructuredDefinition for " + name + "was null");
      System.out.println("ERROR! ERROR! ERROR! StructuredDefinition for " + name + " was null");
      return;
    }
    Path outPath = FileSystems.getDefault().getPath(System.getProperty("user.home") + "/runtime_environments/ShExSchemas", shortName + ".shex");
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
    List<String> skipSDs = new ArrayList<String>();
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/StructureDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/TerminologyCapabilities");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/SearchParameter");

    items.forEach((String item) -> {
      String name = item;
      if (skipSDs.contains(name)) {
        System.out.println("SKIPPING Generating ShEx for '" + name + "' ...");
        return;
      }

      if (item.indexOf("/") != -1) {
        String els[] = item.split("/");
        name = els[els.length - 1];
      }
      System.out.println("******************** " + item + " *********************");
      doTestThis(name, item);
    });
  }

  @Test
  public void doTestAll() throws FileNotFoundException, IOException, FHIRException, UcumException {
    List<StructureDefinition> sds = TestingUtilities.getSharedWorkerContext().fetchResourcesByType(StructureDefinition.class);
    if ((sds == null)||(sds.isEmpty())) {
      throw new FHIRException("No StructuredDefinition found");
    }

    List<String> sdNames = new ArrayList<String>();
    List<String> extNames = new ArrayList<String>();
    List<String> logicalNames = new ArrayList<String>();
    List<String> otherNames = new ArrayList<String>();
    List<String> sdURLs = new ArrayList<String>();
    List<String> extURLs = new ArrayList<String>();
    List<String> logicalURLs = new ArrayList<String>();
    List<String> otherURLs = new ArrayList<String>();
    List<String> sdNamesPrint = new ArrayList<String>();
    List<String> extNamesPrint = new ArrayList<String>();
    List<String> logicalNamesPrint = new ArrayList<String>();
    List<String> otherNamesPrint = new ArrayList<String>();
    sds.forEach((StructureDefinition sd ) ->{
      if (sd.getBaseDefinition() == null){
        logicalNames.add(sd.getName());
        logicalURLs.add(sd.getUrl());
        logicalNamesPrint.add(getSDInfo(sd));
      }
      else if (sd.getType().trim().equals(sd.getName().trim())) {
        sdNames.add(sd.getName());
        sdURLs.add(sd.getUrl());
        sdNamesPrint.add(getSDInfo(sd));
      }
      else if ("Extension".equals(sd.getType())) {
        extNames.add(sd.getName());
        extURLs.add(sd.getUrl());
        extNamesPrint.add(getSDInfo(sd));
      }
      else {
        otherNames.add(sd.getName());
        otherURLs.add(sd.getUrl());
        otherNamesPrint.add(getSDInfo(sd));
      }
    });

    System.out.println("************************************************************************");
    System.out.println("************************   FHIR SDs LIST  ******************************");
    System.out.println("************************************************************************");

    printList("StructureDefinitions", sdNamesPrint);
    printList("Extensions", extNamesPrint);
    printList("Logical", logicalNamesPrint);
    printList("Profiles", otherNamesPrint);

    //processList("StructureDefinitions", sdNames);
    //processList("Extensions", extNames);
    //processList("Logical", logicalNames);
    //processList("Profiles", otherNames);

    System.out.println("************************************************************************");
    System.out.println("************************ BEGIN PROCESSING ******************************");
    System.out.println("************************************************************************");

    processList("StructureDefinitions", sdURLs);
    processList("Extensions", extURLs);
    processList("Logical", logicalURLs);
    processList("Profiles", otherURLs);

    System.out.println("************************ END PROCESSING ******************************");

    System.out.println("************************************************************************");
    System.out.println("Total Items: " + sds.size());
    System.out.println("Total SDS: " + sdNames.size());
    System.out.println("Total Extensions: " + extNames.size());
    System.out.println("Total Logical: " + logicalNames.size());
    System.out.println("Total Other: " + otherNames.size());
    System.out.println("************************************************************************");
  }

  private String getSDInfo(StructureDefinition sd){

    if (sd != null) {
      String kind = " "; try { kind = sd.getKind().name(); } catch(Exception e) {System.out.println("Kind is null");}
      String name = " "; try { name = sd.getName(); } catch(Exception e) {System.out.println("Name is null");}
      String type = " "; try { type = sd.getType(); } catch(Exception e) {System.out.println("Type is null");}
      String derv = " "; try { derv = sd.getDerivation().name(); } catch(Exception e) {System.out.println("Derivation is null");}
      String url = " "; try { url = sd.getUrl(); } catch(Exception e) {System.out.println("URL is null");}
      String base = " "; try { base = sd.getBaseDefinition(); } catch(Exception e) {System.out.println("Base is null");}
      return kind + "\t" + name + "\t" + type + "\t" + derv + "\t" + url + "\t" + base;
    }

    return "";
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
  public void testAge() throws FHIRException, IOException, UcumException {
    doTest("Age");
  }

  @Test
  public void testUri() throws FHIRException, IOException, UcumException {
    doTest("uri");
  }

  @Test
  public void testRatio() throws FHIRException, IOException, UcumException {
    doTest("Ratio");
  }
  @Test
  public void testObservation() throws FHIRException, IOException, UcumException {
    doTest("Observation");
  }

  @Test
  public void testCapabilityStatement() throws FHIRException, IOException, UcumException {
    doTest("CapabilityStatement");
  }

  @Test
  public void testCapabilities() throws FHIRException, IOException, UcumException {
    doTest("http://fhir-registry.smarthealthit.org/StructureDefinition/capabilities");
  }

  @Test
  public void testMoneyQuantityprofile() throws FHIRException, IOException, UcumException {
    doTest("MoneyQuantity");
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