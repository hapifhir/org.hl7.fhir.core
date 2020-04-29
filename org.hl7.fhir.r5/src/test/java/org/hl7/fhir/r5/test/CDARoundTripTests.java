package org.hl7.fhir.r5.test;

import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.FHIRPathEngine;
import org.hl7.fhir.utilities.cache.PackageCacheManager;
import org.hl7.fhir.utilities.cache.ToolsVersion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CDARoundTripTests {

//  private SimpleWorkerContext context;
// old-test  private FHIRPathEngine fp;

  @BeforeAll
  public void setUp() throws Exception {
// old-test     context = new SimpleWorkerContext();
// old-test     PackageCacheManager pcm = new PackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
// old-test     context.loadFromPackage(pcm.loadPackage("hl7.fhir.core", "dev"), null, "StructureDefinition");
// old-test     context.loadFromPackage(pcm.loadPackage("hl7.fhir.cda", "dev"), null, "StructureDefinition");
// old-test     fp = new FHIRPathEngine(context);
  }

// old-test    
//  @Test
//  public void testCDA() throws FHIRFormatError, DefinitionException, FileNotFoundException, IOException, FHIRException {
//    try {
//
//      InputStream fileSource = TestingUtilities.loadTestResourceStream("cda", "cda-original.xml");
//      String roundTrip = TestingUtilities.tempFile("cda", "cda-roundtrip.xml");
//      String jsonRoundTrip = TestingUtilities.tempFile("cda", "cda-roundtrip.json");
//
//      Element e = Manager.parse(context, fileSource, FhirFormat.XML);
//
//      Manager.compose(context, e, new FileOutputStream(roundTrip), FhirFormat.XML, OutputStyle.PRETTY, null);
//      Manager.compose(context, e, new FileOutputStream(jsonRoundTrip), FhirFormat.JSON, OutputStyle.PRETTY, null);
//
////    <typeId root="2.16.840.1.113883.1.3" extension="POCD_HD000040"/>
////      assertEquals("POCD_HD000040", fp.evaluateToString(e, "typeId.extension"));
////      assertEquals("2.16.840.1.113883.1.3", fp.evaluateToString(e, "typeId.root"));
////    <templateId root="2.16.840.1.113883.3.27.1776"/>
////      assertEquals("2.16.840.1.113883.3.27.1776", fp.evaluateToString(e, "templateId.root"));
////    <id extension="c266" root="2.16.840.1.113883.19.4"/>
//      assertEquals("2.16.840.1.113883.19.4", fp.evaluateToString(e, "id.root"));
//      assertEquals("c266", fp.evaluateToString(e, "id.extension"));
//
////    <title>Good Health Clinic Consultation Note</title>
//      assertEquals("Good Health Clinic Consultation Note", fp.evaluateToString(e, "title.dataString"));
////    <effectiveTime value="20000407"/>
//      assertEquals("2000-04-07", fp.evaluateToString(e, "effectiveTime.value"));
////    <confidentialityCode code="N" codeSystem="2.16.840.1.113883.5.25"/>
//      assertEquals("N", fp.evaluateToString(e, "confidentialityCode.code"));
//      assertEquals("2.16.840.1.113883.5.25", fp.evaluateToString(e, "confidentialityCode.codeSystem"));
////    <languageCode code="en-US"/>
//      assertEquals("en-US", fp.evaluateToString(e, "languageCode.code"));
////    <setId extension="BB35" root="2.16.840.1.113883.19.7"/>
//      assertEquals("BB35", fp.evaluateToString(e, "setId.extension"));
//      assertEquals("2.16.840.1.113883.19.7", fp.evaluateToString(e, "setId.root"));
////    <versionNumber value="2"/>
//      assertEquals("2", fp.evaluateToString(e, "versionNumber.value"));
////    <recordTarget>
////      <patientRole>
////        <id extension="12345" root="2.16.840.1.113883.19.5"/>
//      assertEquals("12345", fp.evaluateToString(e, "recordTarget.patientRole.id.extension"));
//      assertEquals("2.16.840.1.113883.19.5", fp.evaluateToString(e, "recordTarget.patientRole.id.root"));
////        <patient>
////          <name>
////            <family>Levin</family>
//      assertEquals("Levin", fp.evaluateToString(e, "recordTarget.patientRole.patient.name.family.dataString"));
////    <given>Henry</given>
//      assertEquals("Henry", fp.evaluateToString(e, "recordTarget.patientRole.patient.name.given.dataString"));
////            <suffix>the 7th</suffix>
////          </name>
////          <administrativeGenderCode code="M" codeSystem="2.16.840.1.113883.5.1"/>
////          <birthTime value="19320924"/>
////        </patient>
////        <providerOrganization>
////          <id root="2.16.840.1.113883.19.5"/>
////        </providerOrganization>
////      </patientRole>
////    </recordTarget>
//      
////      <component>
////      <structuredBody>
////    <component>
////    <section>
//      
////      <component>
////      <section>
////        <code code="8709-8" codeSystem="2.16.840.1.113883.6.1" codeSystemName="LOINC"/>
////        <title>Skin Exam</title>
////        <text>Erythematous rash, palmar surface, left index finger.
////           <renderMultiMedia referencedObject="MM1"/>
////        </text>
//
//      assertEquals("Skin Exam", fp.evaluateToString(e, "component.structuredBody.component.section.component.section.where(code.code='8709-8' and code.codeSystem='2.16.840.1.113883.6.1').title.dataString"));
//      // <div>Erythematous rash, palmar surface, left index finger.
//      // <img src="MM1"/></div>
//      String text = fp.evaluateToString(e, "component.structuredBody.component.section.component.section.where(code.code='8709-8' and code.codeSystem='2.16.840.1.113883.6.1').text");
//      assertTrue(text.contains("<img src=\"MM1\"/>"));
//    } catch (Exception e) {
//      System.out.println(e.getMessage());
//      e.printStackTrace();
//      throw e;
//    }
//  }
//
//  @Ignore
//  public void testDCI() throws FHIRFormatError, DefinitionException, FileNotFoundException, IOException, FHIRException {
//    try {
//      Element e = Manager.parse(context,
//          new FileInputStream("C:\\work\\org.hl7.fhir.us\\ccda-to-fhir-maps\\cda\\IAT2-Discharge_Summary-DCI.xml"),
//          FhirFormat.XML);
//
//      Manager.compose(context, e, new FileOutputStream("C:\\temp\\ccda.xml"), FhirFormat.XML, OutputStyle.PRETTY, null);
////    Manager.compose(context, e, new FileOutputStream("C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-Discharge_Summary-DCI.out.json"), FhirFormat.JSON, OutputStyle.PRETTY, null);
////    Manager.compose(context, e, new FileOutputStream("C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-Discharge_Summary-DCI.out.ttl"), FhirFormat.TURTLE, OutputStyle.PRETTY, null);
//    } catch (Exception e) {
//      System.out.println(e.getMessage());
//      e.printStackTrace();
//      throw e;
//    }
//  }
//
//  @Ignore
//  public void testEpic()
//      throws FHIRFormatError, DefinitionException, FileNotFoundException, IOException, FHIRException {
//    Element e = Manager.parse(context,
//        new FileInputStream(
//            "C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-Discharge-Homework-Epic.xml"),
//        FhirFormat.XML);
//    Manager.compose(context, e,
//        new FileOutputStream(
//            "C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-Discharge-Homework-Epic.out.xml"),
//        FhirFormat.XML, OutputStyle.PRETTY, null);
//    Manager.compose(context, e,
//        new FileOutputStream(
//            "C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-Discharge-Homework-Epic.out.json"),
//        FhirFormat.JSON, OutputStyle.PRETTY, null);
//    Manager.compose(context, e,
//        new FileOutputStream(
//            "C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-Discharge-Homework-Epic.out.ttl"),
//        FhirFormat.TURTLE, OutputStyle.PRETTY, null);
//  }
//
//  @Ignore
//  public void testDHIT()
//      throws FHIRFormatError, DefinitionException, FileNotFoundException, IOException, FHIRException {
//    Element e = Manager.parse(context,
//        new FileInputStream("C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-DS-Homework-DHIT.xml"),
//        FhirFormat.XML);
//    Manager.compose(context, e,
//        new FileOutputStream(
//            "C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-DS-Homework-DHIT.out.xml"),
//        FhirFormat.XML, OutputStyle.PRETTY, null);
//    Manager.compose(context, e,
//        new FileOutputStream(
//            "C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-DS-Homework-DHIT.out.json"),
//        FhirFormat.JSON, OutputStyle.PRETTY, null);
//    Manager.compose(context, e,
//        new FileOutputStream(
//            "C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-DS-Homework-DHIT.out.ttl"),
//        FhirFormat.TURTLE, OutputStyle.PRETTY, null);
//  }


  @Test
  @Disabled
  public void testSimple() throws IOException {
    PackageCacheManager pcm = new PackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
    SimpleWorkerContext context = SimpleWorkerContext.fromPackage(pcm.loadPackage("hl7.fhir.r4.core", "4.0.1"));
    context.loadFromFile(TestingUtilities.loadTestResourceStream("r5", "cda", "any.xml"), "any.xml", null);
    context.loadFromFile(TestingUtilities.loadTestResourceStream("r5", "cda", "ii.xml"), "ii.xml", null);
    context.loadFromFile(TestingUtilities.loadTestResourceStream("r5", "cda", "cd.xml"), "cd.xml", null);
    context.loadFromFile(TestingUtilities.loadTestResourceStream("r5", "cda", "ce.xml"), "ce.xml", null);
    context.loadFromFile(TestingUtilities.loadTestResourceStream("r5", "cda", "cda.xml"), "cda.xml", null);
    for (StructureDefinition sd : context.getStructures()) {
      if (!sd.hasSnapshot()) {
        System.out.println("generate snapshot for " + sd.getUrl());
        context.generateSnapshot(sd, true);
      }
    }
    Element cda = Manager.parse(context, TestingUtilities.loadTestResourceStream("r5", "cda", "example.xml"), FhirFormat.XML);
    FHIRPathEngine fp = new FHIRPathEngine(context);
    Assertions.assertEquals("2.16.840.1.113883.3.27.1776", fp.evaluateToString(null, cda, cda, cda, fp.parse("ClinicalDocument.templateId.root")));
  }

}