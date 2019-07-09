package org.hl7.fhir.r4.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r4.context.SimpleWorkerContext;
import org.hl7.fhir.r4.elementmodel.Element;
import org.hl7.fhir.r4.elementmodel.Manager;
import org.hl7.fhir.r4.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r4.formats.IParser.OutputStyle;
import org.hl7.fhir.r4.test.utils.TestingUtilities;
import org.hl7.fhir.r4.utils.FHIRPathEngine;
import org.hl7.fhir.utilities.cache.PackageCacheManager;
import org.hl7.fhir.utilities.cache.ToolsVersion;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CDARoundTripTests {

  private SimpleWorkerContext context;
  private FHIRPathEngine fp;

  @Before
  public void setUp() throws Exception {
    context = new SimpleWorkerContext();
    PackageCacheManager pcm = new PackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
    context.loadFromPackage(pcm.loadPackage("hl7.fhir.core", "4.0.0"), null, "StructureDefinition");
    context.loadFromPackage(pcm.loadPackage("hl7.fhir.cda", "dev"), null, "StructureDefinition");
    fp = new FHIRPathEngine(context);
  }

  @Test
  public void testCDA() throws FHIRFormatError, DefinitionException, FileNotFoundException, IOException, FHIRException {
    try {

      String fileSource = TestingUtilities.resourceNameToFile("cda", "cda.xml");
      String roundTrip = TestingUtilities.resourceNameToFile("cda", "cda-roundtrip.xml");

      Element e = Manager.parse(context, new FileInputStream(fileSource), FhirFormat.XML);

      Manager.compose(context, e, new FileOutputStream(roundTrip), FhirFormat.XML, OutputStyle.PRETTY, null);

//		<typeId root="2.16.840.1.113883.1.3" extension="POCD_HD000040"/>
      assertEquals("POCD_HD000040", fp.evaluateToString(e, "typeId.extension"));
      assertEquals("2.16.840.1.113883.1.3", fp.evaluateToString(e, "typeId.root"));
//    <templateId root="2.16.840.1.113883.3.27.1776"/>
      assertEquals("2.16.840.1.113883.3.27.1776", fp.evaluateToString(e, "templateId.root"));
//    <id extension="c266" root="2.16.840.1.113883.19.4"/>
      assertEquals("2.16.840.1.113883.19.4", fp.evaluateToString(e, "id.root"));
      assertEquals("c266", fp.evaluateToString(e, "id.extension"));

//		<title>Good Health Clinic Consultation Note</title>
      assertEquals("Good Health Clinic Consultation Note", fp.evaluateToString(e, "title.dataString"));
//		<effectiveTime value="20000407"/>
      assertEquals("2000-04-07", fp.evaluateToString(e, "effectiveTime.value"));
//		<confidentialityCode code="N" codeSystem="2.16.840.1.113883.5.25"/>
      assertEquals("N", fp.evaluateToString(e, "confidentialityCode.code"));
      assertEquals("2.16.840.1.113883.5.25", fp.evaluateToString(e, "confidentialityCode.codeSystem"));
//		<languageCode code="en-US"/>
      assertEquals("en-US", fp.evaluateToString(e, "languageCode.code"));
//		<setId extension="BB35" root="2.16.840.1.113883.19.7"/>
      assertEquals("BB35", fp.evaluateToString(e, "setId.extension"));
      assertEquals("2.16.840.1.113883.19.7", fp.evaluateToString(e, "setId.root"));
//		<versionNumber value="2"/>
      assertEquals("2", fp.evaluateToString(e, "versionNumber.value"));
//		<recordTarget>
//			<patientRole>
//				<id extension="12345" root="2.16.840.1.113883.19.5"/>
      assertEquals("12345", fp.evaluateToString(e, "recordTarget.patientRole.id.extension"));
      assertEquals("2.16.840.1.113883.19.5", fp.evaluateToString(e, "recordTarget.patientRole.id.root"));
//				<patient>
//					<name>
//						<given>Henry</given>
      assertEquals("Henry", fp.evaluateToString(e, "recordTarget.patientRole.patient.name.given.dataString"));
//						<family>Levin</family>
      assertEquals("Levin", fp.evaluateToString(e, "recordTarget.patientRole.patient.name.family.dataString"));
//						<suffix>the 7th</suffix>
//					</name>
//					<administrativeGenderCode code="M" codeSystem="2.16.840.1.113883.5.1"/>
//					<birthTime value="19320924"/>
//				</patient>
//				<providerOrganization>
//					<id root="2.16.840.1.113883.19.5"/>
//				</providerOrganization>
//			</patientRole>
//		</recordTarget>
      
//      <component>
//      <structuredBody>
//    <component>
//    <section>
      
//      <component>
//      <section>
//        <code code="8709-8" codeSystem="2.16.840.1.113883.6.1" codeSystemName="LOINC"/>
//        <title>Skin Exam</title>
//        <text>Erythematous rash, palmar surface, left index finger.
//           <renderMultiMedia referencedObject="MM1"/>
//        </text>

      assertEquals("Skin Exam", fp.evaluateToString(e, "component.structuredBody.component.section.component.section.where(code.code='8709-8' and code.codeSystem='2.16.840.1.113883.6.1').title.dataString"));
      
      // <div>Erythematous rash, palmar surface, left index finger.
      // <img src="MM1"/></div>
      String text = fp.evaluateToString(e, "component.structuredBody.component.section.component.section.where(code.code='8709-8' and code.codeSystem='2.16.840.1.113883.6.1').text");
      assertTrue(text.contains("<img src=\"MM1\"/>"));
      

    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
      throw e;
    }
  }

  @Ignore
  public void testDCI() throws FHIRFormatError, DefinitionException, FileNotFoundException, IOException, FHIRException {
    try {
      Element e = Manager.parse(context,
          new FileInputStream("C:\\work\\org.hl7.fhir.us\\ccda-to-fhir-maps\\cda\\IAT2-Discharge_Summary-DCI.xml"),
          FhirFormat.XML);

      Manager.compose(context, e, new FileOutputStream("C:\\temp\\ccda.xml"), FhirFormat.XML, OutputStyle.PRETTY, null);
//    Manager.compose(context, e, new FileOutputStream("C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-Discharge_Summary-DCI.out.json"), FhirFormat.JSON, OutputStyle.PRETTY, null);
//    Manager.compose(context, e, new FileOutputStream("C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-Discharge_Summary-DCI.out.ttl"), FhirFormat.TURTLE, OutputStyle.PRETTY, null);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
      throw e;
    }
  }

  @Ignore
  public void testEpic()
      throws FHIRFormatError, DefinitionException, FileNotFoundException, IOException, FHIRException {
    Element e = Manager.parse(context,
        new FileInputStream(
            "C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-Discharge-Homework-Epic.xml"),
        FhirFormat.XML);
    Manager.compose(context, e,
        new FileOutputStream(
            "C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-Discharge-Homework-Epic.out.xml"),
        FhirFormat.XML, OutputStyle.PRETTY, null);
    Manager.compose(context, e,
        new FileOutputStream(
            "C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-Discharge-Homework-Epic.out.json"),
        FhirFormat.JSON, OutputStyle.PRETTY, null);
    Manager.compose(context, e,
        new FileOutputStream(
            "C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-Discharge-Homework-Epic.out.ttl"),
        FhirFormat.TURTLE, OutputStyle.PRETTY, null);
  }

  @Ignore
  public void testDHIT()
      throws FHIRFormatError, DefinitionException, FileNotFoundException, IOException, FHIRException {
    Element e = Manager.parse(context,
        new FileInputStream("C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-DS-Homework-DHIT.xml"),
        FhirFormat.XML);
    Manager.compose(context, e,
        new FileOutputStream(
            "C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-DS-Homework-DHIT.out.xml"),
        FhirFormat.XML, OutputStyle.PRETTY, null);
    Manager.compose(context, e,
        new FileOutputStream(
            "C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-DS-Homework-DHIT.out.json"),
        FhirFormat.JSON, OutputStyle.PRETTY, null);
    Manager.compose(context, e,
        new FileOutputStream(
            "C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-DS-Homework-DHIT.out.ttl"),
        FhirFormat.TURTLE, OutputStyle.PRETTY, null);
  }

}
