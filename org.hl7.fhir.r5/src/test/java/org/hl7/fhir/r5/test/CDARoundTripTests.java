package org.hl7.fhir.r5.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.FHIRPathEngine;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager.FilesystemPackageCacheMode;
import org.hl7.fhir.utilities.npm.ToolsVersion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CDARoundTripTests {

	private static SimpleWorkerContext context;
	private static FHIRPathEngine fp;

	@BeforeAll
	public static void setUp() throws Exception {
	  FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager(org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager.FilesystemPackageCacheMode.USER);
	  context = TestingUtilities.getWorkerContext(pcm.loadPackage("hl7.fhir.r4.core", "4.0.1"));
	  fp = new FHIRPathEngine(context);

	  context.loadFromFile(TestingUtilities.loadTestResourceStream("validator", "cda", "any.xml"), "any.xml", null);
	  context.loadFromFile(TestingUtilities.loadTestResourceStream("validator", "cda", "ii.xml"), "ii.xml", null);
	  context.loadFromFile(TestingUtilities.loadTestResourceStream("validator", "cda", "cd.xml"), "cd.xml", null);
	  context.loadFromFile(TestingUtilities.loadTestResourceStream("validator", "cda", "ce.xml"), "ce.xml", null);
	  context.loadFromFile(TestingUtilities.loadTestResourceStream("validator", "cda", "ed.xml"), "ed.xml", null);
	  context.loadFromFile(TestingUtilities.loadTestResourceStream("validator", "cda", "st.xml"), "st.xml", null);
	  context.loadFromFile(TestingUtilities.loadTestResourceStream("validator", "cda", "cda.xml"), "cda.xml", null);
	  for (StructureDefinition sd : context.fetchResourcesByType(StructureDefinition.class)) {
	    if (!sd.hasSnapshot()) {
	      //				System.out.println("generate snapshot for " + sd.getUrl());
	      new ContextUtilities(context).generateSnapshot(sd, true);
	    }
	  }
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
//      // <img src="MM1" alt=\"img\"/></div>
//      String text = fp.evaluateToString(e, "component.structuredBody.component.section.component.section.where(code.code='8709-8' and code.codeSystem='2.16.840.1.113883.6.1').text");
//      assertTrue(text.contains("<img src=\"MM1\" alt=\"img\"/>"));
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
//      Manager.compose(context, e, new FileOutputStream(Utilities.path("[tmp]", "ccda.xml"), FhirFormat.XML, OutputStyle.PRETTY, null);
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

	public void assertsExample(Element cdaExample) {
	    Assertions.assertEquals("2.16.840.1.113883.3.27.1776", fp.evaluateToString(null, cdaExample, cdaExample, cdaExample, fp.parse("ClinicalDocument.templateId.root")));
        Assertions.assertEquals("SoEN", fp.evaluateToString(null, cdaExample, cdaExample, cdaExample, fp.parse("ClinicalDocument.code.displayName")));
        Assertions.assertEquals("SoEN2", fp.evaluateToString(null, cdaExample, cdaExample, cdaExample, fp.parse("ClinicalDocument.code.sdtcDisplayName")));
        Assertions.assertEquals("c266", fp.evaluateToString(null, cdaExample, cdaExample, cdaExample, fp.parse("ClinicalDocument.id.extension")));
	    Assertions.assertEquals("2.16.840.1.113883.19.4", fp.evaluateToString(null, cdaExample, cdaExample, cdaExample, fp.parse("ClinicalDocument.id.root")));
	    Assertions.assertEquals("X-34133-9", fp.evaluateToString(null, cdaExample, cdaExample, cdaExample, fp.parse("ClinicalDocument.code.code")));
	    Assertions.assertEquals("2.16.840.1.113883.6.1", fp.evaluateToString(null, cdaExample, cdaExample, cdaExample, fp.parse("ClinicalDocument.code.codeSystem")));
	    Assertions.assertEquals("LOINC", fp.evaluateToString(null, cdaExample, cdaExample, cdaExample, fp.parse("ClinicalDocument.code.codeSystemName")));
	    Assertions.assertEquals("Episode Note", fp.evaluateToString(null, cdaExample, cdaExample, cdaExample, fp.parse("ClinicalDocument.title.dataString")));	  
  }

	@Test
	/**
	 * Deserializes a simplified CDA example into the logical model and checks that
	 * xml deserialization/serialization
	 * 
	 * @throws IOException
	 */
	public void testClinicalDocumentXmlParser() throws IOException {
		Element cda = Manager.parseSingle(context, TestingUtilities.loadTestResourceStream("validator", "cda", "example.xml"),
				FhirFormat.XML);

		assertsExample(cda);

		ByteArrayOutputStream baosXml = new ByteArrayOutputStream();
		Manager.compose(context, cda, baosXml, FhirFormat.XML, OutputStyle.PRETTY, null);
		Element cdaXmlRoundtrip = Manager.parseSingle(context, new ByteArrayInputStream(baosXml.toString().getBytes()), FhirFormat.XML);
		assertsExample(cdaXmlRoundtrip);
	}

	@Test
	/**
	 * Deserializes a simplified CDA example into the logical model and checks that
	 * json deserialization/serialization works
	 * 
	 * @throws IOException
	 */
	public void testClinicalDocumentJsonParser() throws IOException {
		Element cda = Manager.parseSingle(context, TestingUtilities.loadTestResourceStream("validator", "cda", "example.xml"),
				FhirFormat.XML);

		assertsExample(cda);

		ByteArrayOutputStream baosJson = new ByteArrayOutputStream();
		Manager.compose(context, cda, baosJson, FhirFormat.JSON, OutputStyle.PRETTY, null);
		Element cdaJsonRoundtrip = Manager.parseSingle(context, new ByteArrayInputStream(baosJson.toString().getBytes()),
				FhirFormat.JSON);
		
		assertsExample(cdaJsonRoundtrip);

	}
	
	@Test
	/**
	 * verify that umlaut like äö etc are not encoded in UTF-8 in attributes
	 */
	public void testSerializeUmlaut() throws IOException {
	  Element xml = Manager.parseSingle(context,
		  TestingUtilities.loadTestResourceStream("validator", "cda", "example.xml"), FhirFormat.XML);
	  
	  List<Element> title = xml.getChildrenByName("title");
    Assertions.assertTrue(title != null && title.size() == 1);
	  
	  
	  Element value = title.get(0).getChildren().get(0);
	  Assertions.assertEquals("Episode Note", value.getValue());
	  value.setValue("öé");
	  
	  ByteArrayOutputStream baosXml = new ByteArrayOutputStream();
	  Manager.compose(TestingUtilities.getSharedWorkerContext(), xml, baosXml, FhirFormat.XML, OutputStyle.PRETTY, null);
	  String cdaSerialised = baosXml.toString("UTF-8");
    Assertions.assertTrue(cdaSerialised.indexOf("öé") > 0);
	}

}