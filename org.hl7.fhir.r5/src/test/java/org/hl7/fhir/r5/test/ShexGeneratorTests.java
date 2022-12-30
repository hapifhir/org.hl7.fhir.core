package org.hl7.fhir.r5.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.fhir.ucum.UcumException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.ProfileUtilities;
import org.hl7.fhir.r5.conformance.ShExGenerator;
import org.hl7.fhir.r5.conformance.ShExGenerator.HTMLLinkPolicy;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.TextFile;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ShexGeneratorTests {

  public static List<String> skipSDs = new ArrayList<String>();
  public ShExGenerator shexGenerator;
  @BeforeAll
  public static void setup() {
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/ActivityDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/AdministrableProductDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/ChargeItemDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/ClinicalUseDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/CodeSystem");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/ConceptMap");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/CompartmentDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/CompartmentDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/DeviceDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/ElementDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/EventDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/GraphDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/GuidanceResponse");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/Library");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/ManufacturedItemDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/Measure");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/MeasureReport");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/MedicinalProductDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/MessageDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/NamingSystem");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/ObservationDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/OperationDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/PackagedProductDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/ParameterDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/PlanDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/SearchParameter");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/SpecimenDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/StructureDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/SubstanceDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/Task");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/TerminologyCapabilities");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/TriggerDefinition");
    skipSDs.add("http://hl7.org/fhir/StructureDefinition/ValueSet");
  }


  private void doTest(String name) throws FileNotFoundException, IOException, FHIRException, UcumException {
    this.doTestThis(name.toLowerCase(), name);
  }

  private void doTestThis(String shortName, String name){
    StructureDefinition sd = TestingUtilities.getSharedWorkerContext().fetchResource(StructureDefinition.class, ProfileUtilities.sdNs(name, null));
    if (sd == null) {
      throw new FHIRException("StructuredDefinition for " + name + " was null");
    }
    Path outPath = FileSystems.getDefault().getPath(System.getProperty("user.home") + "/runtime_environments/ShExSchemas", shortName + ".shex");
    try {
      this.shexGenerator = new ShExGenerator(TestingUtilities.getSharedWorkerContext());
      this.shexGenerator.setExcludedStructureDefinitionUrls(skipSDs);
      this.shexGenerator.debugMode = true;
      TextFile.stringToFile(this.shexGenerator.generate(HTMLLinkPolicy.NONE, sd), outPath.toString());
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
      String name = item;
//      if (skipSDs.contains(name)) {
//        System.out.println("SKIPPING Generating ShEx for '" + name + "' ...");
//        return;
//      }

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
    System.out.println("Skipped SDS: " + skipSDs.size());
    System.out.println("Net SDS Translated: " + (sdNames.size() - skipSDs.size()));
    System.out.println("\n\nSkipped SDs are \n" + StringUtils.join(skipSDs, "\n"));
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