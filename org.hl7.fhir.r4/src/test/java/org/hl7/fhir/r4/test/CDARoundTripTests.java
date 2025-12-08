package org.hl7.fhir.r4.test;

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
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@Disabled
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CDARoundTripTests {

  private SimpleWorkerContext context;

  @BeforeAll
  public void setUp() throws Exception {
    context = new SimpleWorkerContext();
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
    context.loadFromPackage(pcm.loadPackage("hl7.fhir.core", "current"), null, "StructureDefinition");
    context.loadFromPackage(pcm.loadPackage("hl7.fhir.cda", "current"), null, "StructureDefinition");
  }

  @Test
  void testDCI() throws FHIRException {
    assertDoesNotThrow(() -> {
        Element e = Manager.parse(context,
            ManagedFileAccess.inStream("C:\\work\\org.hl7.fhir.us\\ccda-to-fhir-maps\\cda\\IAT2-Discharge_Summary-DCI.xml"),
            FhirFormat.XML);
        Manager.compose(context, e, ManagedFileAccess.outStream(Utilities.path("[tmp]", "ccda.xml")), FhirFormat.XML,
            OutputStyle.PRETTY, null);
//    Manager.compose(context, e, ManagedFileAccess.outStream("C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-Discharge_Summary-DCI.out.json"), FhirFormat.JSON, OutputStyle.PRETTY, null);
//    Manager.compose(context, e, ManagedFileAccess.outStream("C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-Discharge_Summary-DCI.out.ttl"), FhirFormat.TURTLE, OutputStyle.PRETTY, null);
    });
  }

  @Test
  void testEpic() throws FHIRException {
    assertDoesNotThrow(() -> {
      Element e = Manager.parse(context,
          ManagedFileAccess.inStream(
              "C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-Discharge-Homework-Epic.xml"),
          FhirFormat.XML);
      Manager.compose(context, e,
          ManagedFileAccess.outStream(
              "C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-Discharge-Homework-Epic.out.xml"),
          FhirFormat.XML, OutputStyle.PRETTY, null);
      Manager.compose(context, e,
          ManagedFileAccess.outStream(
              "C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-Discharge-Homework-Epic.out.json"),
          FhirFormat.JSON, OutputStyle.PRETTY, null);
      Manager.compose(context, e,
          ManagedFileAccess.outStream(
              "C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-Discharge-Homework-Epic.out.ttl"),
          FhirFormat.TURTLE, OutputStyle.PRETTY, null);
    });
  }

  @Test
  void testDHIT() throws FHIRException {
    assertDoesNotThrow(() -> {
      Element e = Manager.parse(context,
          ManagedFileAccess.inStream("C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-DS-Homework-DHIT.xml"),
          FhirFormat.XML);
      Manager.compose(context, e,
          ManagedFileAccess.outStream(
              "C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-DS-Homework-DHIT.out.xml"),
          FhirFormat.XML, OutputStyle.PRETTY, null);
      Manager.compose(context, e,
          ManagedFileAccess.outStream(
              "C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-DS-Homework-DHIT.out.json"),
          FhirFormat.JSON, OutputStyle.PRETTY, null);
      Manager.compose(context, e,
          ManagedFileAccess.outStream(
              "C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-DS-Homework-DHIT.out.ttl"),
          FhirFormat.TURTLE, OutputStyle.PRETTY, null);
    });
  }

}